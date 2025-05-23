package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountH5Manager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppService;

/* loaded from: classes32.dex */
public class PublicAccountH5ManagerImpl implements INetEngineListener, IPublicAccountH5Manager {
    public static final String C2B_FIRE_CAMERC_DIR = "c2bCAM/";
    public static final String C2B_FIRE_PIC_DIR = "c2bPIC/";
    private static final String JS_PEER_UIN = "255";
    public static final String TAG = "PAH5Manager";
    private QQAppInterface app;
    private IHttpEngineService netEngine;
    private String pUin;
    TroopMemberApiService troopMemberApiService;
    TransProcessorHandler mTransProcessorHandler = new a();
    HashMap<Long, Bundle> mapStart = new HashMap<>();
    HashMap<Long, Bundle> mapDone = new HashMap<>();
    HashMap<String, Bundle> mapDownload = new HashMap<>();
    private ArrayList<TransferRequest> uploadList = new ArrayList<>();
    private ArrayList<HttpNetReq> downloadList = new ArrayList<>();
    private ArrayList<TransferRequest> JSPttList = new ArrayList<>();

    /* loaded from: classes32.dex */
    class a extends TransProcessorHandler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg != null) {
                int i3 = fileMsg.fileType;
                if (i3 == 24 || i3 == 32) {
                    if (i3 != 24 || fileMsg.commandId == 10) {
                        int i16 = message.what;
                        if (i16 == 1001) {
                            Bundle remove = PublicAccountH5ManagerImpl.this.mapStart.remove(Long.valueOf(fileMsg.uniseq));
                            if (remove == null || remove.getInt(IPublicAccountH5AbilityPlugin.PICISSHOWPRO) != 1) {
                                return;
                            }
                            PublicAccountH5ManagerImpl.this.troopMemberApiService.X(23, remove);
                            if (QLog.isColorLevel()) {
                                QLog.d(PublicAccountH5ManagerImpl.TAG, 2, "start" + fileMsg.uniseq);
                                return;
                            }
                            return;
                        }
                        if (i16 == 1003) {
                            Bundle remove2 = PublicAccountH5ManagerImpl.this.mapDone.remove(Long.valueOf(fileMsg.uniseq));
                            PublicAccountH5ManagerImpl.this.removeUploadByKey(fileMsg.uniseq);
                            PublicAccountH5ManagerImpl.this.removeJSPttByKey(fileMsg.uniseq);
                            if (remove2 != null) {
                                if (fileMsg.fileType == 32) {
                                    new PublicAccountH5AbilityPttImpl();
                                    remove2.putLong("uniseq", fileMsg.uniseq);
                                    remove2.putString(IPublicAccountH5AbilityPlugin.PICSERVERID, PublicAccountH5AbilityPttImpl.getServerIdForPtt());
                                } else {
                                    remove2.putLong("uniseq", fileMsg.uniseq);
                                    remove2.putString(IPublicAccountH5AbilityPlugin.PICSERVERID, fileMsg.fileUrl);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(PublicAccountH5ManagerImpl.TAG, 2, IXWebBroadcastListener.STAGE_FINISHED + fileMsg.uniseq);
                                }
                                PublicAccountH5ManagerImpl.this.troopMemberApiService.X(24, remove2);
                                return;
                            }
                            return;
                        }
                        if (i16 == 1005) {
                            Bundle remove3 = PublicAccountH5ManagerImpl.this.mapDone.remove(Long.valueOf(fileMsg.uniseq));
                            PublicAccountH5ManagerImpl.this.removeUploadByKey(fileMsg.uniseq);
                            PublicAccountH5ManagerImpl.this.removeJSPttByKey(fileMsg.uniseq);
                            if (remove3 != null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(PublicAccountH5ManagerImpl.TAG, 2, "error" + fileMsg.uniseq);
                                }
                                remove3.putLong("uniseq", fileMsg.uniseq);
                                remove3.putString(IPublicAccountH5AbilityPlugin.PICSERVERID, "-1");
                                PublicAccountH5ManagerImpl.this.troopMemberApiService.X(24, remove3);
                                return;
                            }
                            return;
                        }
                        if (i16 == 2001) {
                            Bundle remove4 = PublicAccountH5ManagerImpl.this.mapStart.remove(Long.valueOf(fileMsg.uniseq));
                            if (remove4 == null || remove4.getInt(IPublicAccountH5AbilityPlugin.PICISSHOWPRO) != 1) {
                                return;
                            }
                            PublicAccountH5ManagerImpl.this.troopMemberApiService.X(25, remove4);
                            return;
                        }
                        if (i16 == 2003) {
                            PublicAccountH5ManagerImpl.this.removeJSPttByKey(fileMsg.uniseq);
                            Bundle remove5 = PublicAccountH5ManagerImpl.this.mapDone.remove(Long.valueOf(fileMsg.uniseq));
                            if (remove5 != null) {
                                if (fileMsg.fileType == 32) {
                                    remove5.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, new PublicAccountH5AbilityPttImpl().getLocalIdForPTTDownLoad(null));
                                }
                                PublicAccountH5ManagerImpl.this.troopMemberApiService.X(26, remove5);
                                return;
                            }
                            return;
                        }
                        if (i16 != 2005) {
                            return;
                        }
                        PublicAccountH5ManagerImpl.this.removeJSPttByKey(fileMsg.uniseq);
                        Bundle remove6 = PublicAccountH5ManagerImpl.this.mapDone.remove(Long.valueOf(fileMsg.uniseq));
                        if (remove6 != null) {
                            remove6.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, "-1");
                            PublicAccountH5ManagerImpl.this.troopMemberApiService.X(26, remove6);
                        }
                    }
                }
            }
        }
    }

    private boolean isJsPtt(IHttpCommunicatorListener iHttpCommunicatorListener) {
        if (!((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).checkIsJsPttClass(iHttpCommunicatorListener)) {
            return false;
        }
        BaseTransProcessor baseTransProcessor = (BaseTransProcessor) iHttpCommunicatorListener;
        return (baseTransProcessor.getFileStatus() == Constant.FROM_ID_START_ACTIVITY || baseTransProcessor.getLastFileStatus() == 2003) ? false : true;
    }

    private void removeDownloadloadByKey(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<HttpNetReq> it = this.downloadList.iterator();
        while (it.hasNext()) {
            HttpNetReq next = it.next();
            if (next.mReqUrl.equals(str)) {
                arrayList.add(next);
            }
        }
        this.downloadList.removeAll(arrayList);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountH5Manager
    public void cancleAllTask() {
        if (this.netEngine != null) {
            Iterator<HttpNetReq> it = this.downloadList.iterator();
            while (it.hasNext()) {
                this.netEngine.cancelReq(it.next());
            }
        }
        if (((ITransFileController) this.app.getRuntimeService(ITransFileController.class)) != null) {
            Iterator<TransferRequest> it5 = this.uploadList.iterator();
            while (it5.hasNext()) {
                TransferRequest next = it5.next();
                com.tencent.mobileqq.pic.aio.b.a(next.mPeerUin, next.mUniseq);
            }
            Iterator<TransferRequest> it6 = this.JSPttList.iterator();
            while (it6.hasNext()) {
                TransferRequest next2 = it6.next();
                cancelJsPttTask(next2.mPeerUin, next2.mUniseq);
            }
        }
        this.mapStart.clear();
        this.mapDone.clear();
        this.mapDownload.clear();
        this.uploadList.clear();
        this.downloadList.clear();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountH5Manager
    public void downloadPtt(Bundle bundle) {
        String string = bundle.getString(IPublicAccountH5AbilityPlugin.PICSERVERID);
        ITransFileController iTransFileController = (ITransFileController) this.app.getRuntimeService(ITransFileController.class);
        this.mTransProcessorHandler.addFilter(((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getJSPttDownloadProcessorClass());
        iTransFileController.addHandle(this.mTransProcessorHandler);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = this.app.getAccount();
        transferRequest.mPeerUin = JS_PEER_UIN;
        transferRequest.mUinType = 9999;
        transferRequest.mFileType = 32;
        transferRequest.mUniseq = (long) (Math.random() * 1000.0d);
        transferRequest.mIsUp = false;
        transferRequest.mServerPath = string;
        transferRequest.mOutFilePath = AppConstants.SDCARD_PATH + IPublicAccountH5Manager.C2B_FIRE_PTT_DIR + string + ".amr";
        if (new File(transferRequest.mOutFilePath).exists()) {
            bundle.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, new PublicAccountH5AbilityPttImpl().getLocalIdForPTTDownLoad(transferRequest.mOutFilePath));
            this.troopMemberApiService.X(26, bundle);
            return;
        }
        transferRequest.mIsSelfSend = true;
        transferRequest.mDbRecVersion = 5;
        ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        this.mapStart.put(Long.valueOf(transferRequest.mUniseq), bundle);
        this.mapDone.put(Long.valueOf(transferRequest.mUniseq), bundle);
        this.JSPttList.add(transferRequest);
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        if (netResp != null) {
            NetReq netReq = netResp.mReq;
            if (netReq instanceof HttpNetReq) {
                HttpNetReq httpNetReq = (HttpNetReq) netReq;
                int i3 = netResp.mResult;
                if (i3 == 0 || i3 == 1) {
                    Bundle remove = this.mapDownload.remove(httpNetReq.mReqUrl);
                    removeDownloadloadByKey(httpNetReq.mReqUrl);
                    if (remove != null) {
                        String str = httpNetReq.mReqUrl;
                        if (str != null && netResp.mResult == 0) {
                            String[] split = str.split("/");
                            if (split.length >= 2) {
                                remove.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, split[split.length - 2]);
                                String str2 = httpNetReq.mOutPath;
                                if (str2 != null && !"".equals(str2)) {
                                    File file = new File(str2);
                                    if (file.exists()) {
                                        remove.putString(IPublicAccountH5AbilityPlugin.PICLOCALPATH, str2);
                                        try {
                                            String estimateFileType = FileUtils.estimateFileType(str2);
                                            int lastIndexOf = str2.lastIndexOf(".");
                                            if (lastIndexOf != -1) {
                                                String substring = str2.substring(lastIndexOf + 1);
                                                if (estimateFileType != null && !estimateFileType.equals(substring)) {
                                                    String str3 = str2.substring(0, lastIndexOf) + "." + estimateFileType;
                                                    if (file.renameTo(new File(str3))) {
                                                        remove.putString(IPublicAccountH5AbilityPlugin.PICLOCALPATH, str3);
                                                    }
                                                }
                                            }
                                            this.troopMemberApiService.X(26, remove);
                                            return;
                                        } catch (Exception unused) {
                                            remove.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, "-1");
                                            this.troopMemberApiService.X(26, remove);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        remove.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, "-1");
                        this.troopMemberApiService.X(26, remove);
                    }
                }
            }
        }
    }

    void removeJSPttByKey(long j3) {
        ArrayList arrayList = new ArrayList();
        Iterator<TransferRequest> it = this.JSPttList.iterator();
        while (it.hasNext()) {
            TransferRequest next = it.next();
            if (next.mUniseq == j3) {
                arrayList.add(next);
            }
        }
        this.JSPttList.removeAll(arrayList);
    }

    void removeUploadByKey(long j3) {
        ArrayList arrayList = new ArrayList();
        Iterator<TransferRequest> it = this.uploadList.iterator();
        while (it.hasNext()) {
            TransferRequest next = it.next();
            if (next.mUniseq == j3) {
                arrayList.add(next);
            }
        }
        this.uploadList.removeAll(arrayList);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountH5Manager
    public void startDownloadPic(Bundle bundle) {
        int lastIndexOf;
        if (HttpUtil.getNetWorkType() == 0) {
            bundle.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, "-1");
            this.troopMemberApiService.X(26, bundle);
            return;
        }
        String string = bundle.getString(IPublicAccountH5AbilityPlugin.PICSERVERID);
        bundle.putInt("seq", bundle.getInt("seq", -1));
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = string;
        httpNetReq.mExcuteTimeLimit = 180000L;
        if (string != null) {
            String[] split = string.split("/");
            if (split.length >= 2) {
                String str = split[split.length - 2];
                StringBuilder sb5 = new StringBuilder();
                String str2 = AppConstants.SDCARD_PATH;
                sb5.append(str2);
                sb5.append(C2B_FIRE_PIC_DIR);
                sb5.append(str);
                sb5.append(".png");
                httpNetReq.mOutPath = sb5.toString();
                File file = new File(str2 + C2B_FIRE_PIC_DIR);
                ArrayList arrayList = new ArrayList();
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    boolean z16 = false;
                    for (int i3 = 0; i3 < listFiles.length; i3++) {
                        if (!listFiles[i3].isDirectory() && (lastIndexOf = listFiles[i3].getName().lastIndexOf(".")) != -1) {
                            arrayList.add(listFiles[i3].getName().substring(0, lastIndexOf));
                        }
                    }
                    int i16 = 0;
                    while (true) {
                        if (i16 >= arrayList.size()) {
                            break;
                        }
                        if (str.equalsIgnoreCase((String) arrayList.get(i16))) {
                            z16 = true;
                            break;
                        }
                        i16++;
                    }
                    if (z16) {
                        bundle.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, str);
                        this.troopMemberApiService.X(26, bundle);
                        return;
                    }
                }
                IHttpEngineService iHttpEngineService = this.netEngine;
                if (iHttpEngineService != null) {
                    iHttpEngineService.sendReq(httpNetReq);
                    this.mapDownload.put(string, bundle);
                    this.downloadList.add(httpNetReq);
                    if (bundle.getInt(IPublicAccountH5AbilityPlugin.PICISSHOWPRO) == 1) {
                        this.troopMemberApiService.X(25, bundle);
                        return;
                    }
                    return;
                }
            }
        }
        bundle.putString(IPublicAccountH5AbilityPlugin.PICLOCALID, "-1");
        this.troopMemberApiService.X(26, bundle);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountH5Manager
    public void startUploadPic(Bundle bundle) {
        if (HttpUtil.getNetWorkType() == 0) {
            bundle.putLong("uniseq", 0L);
            bundle.putString(IPublicAccountH5AbilityPlugin.PICSERVERID, "-1");
            this.troopMemberApiService.X(24, bundle);
            return;
        }
        String string = bundle.getString(IPublicAccountH5AbilityPlugin.PICLOCALPATH);
        this.pUin = bundle.getString(IPublicAccountH5AbilityPlugin.PICPUIN);
        ITransFileController iTransFileController = (ITransFileController) this.app.getRuntimeService(ITransFileController.class);
        this.mTransProcessorHandler.addFilter(BDHCommonUploadProcessor.class);
        iTransFileController.addHandle(this.mTransProcessorHandler);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mCommandId = 10;
        transferRequest.mLocalPath = string;
        transferRequest.mUniseq = (long) (Math.random() * 1000000.0d);
        transferRequest.mPeerUin = "0";
        transferRequest.mFileType = 24;
        transferRequest.mRichTag = StatisticCollector.PAJASDK_PIC_MSG_UPLOAD_STATISTIC_TAG;
        iTransFileController.transferAsync(transferRequest);
        this.mapStart.put(Long.valueOf(transferRequest.mUniseq), bundle);
        this.mapDone.put(Long.valueOf(transferRequest.mUniseq), bundle);
        this.uploadList.add(transferRequest);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountH5Manager
    public void uploadPtt(Bundle bundle) {
        String string = bundle.getString(IPublicAccountH5AbilityPlugin.PICLOCALPATH);
        ITransFileController iTransFileController = (ITransFileController) this.app.getRuntimeService(ITransFileController.class);
        this.mTransProcessorHandler.addFilter(((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getJSPttUpProcessorClass());
        iTransFileController.addHandle(this.mTransProcessorHandler);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = this.app.getAccount();
        transferRequest.mPeerUin = JS_PEER_UIN;
        transferRequest.mUinType = 9999;
        transferRequest.mFileType = 32;
        transferRequest.mUniseq = (long) (Math.random() * 1000000.0d);
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = string;
        transferRequest.mBusiType = 102;
        transferRequest.mPttCompressFinish = true;
        transferRequest.mPttUploadPanel = 2;
        ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        this.mapStart.put(Long.valueOf(transferRequest.mUniseq), bundle);
        this.mapDone.put(Long.valueOf(transferRequest.mUniseq), bundle);
        this.JSPttList.add(transferRequest);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountH5Manager
    public void init(AppService appService, AppInterface appInterface) {
        this.app = (QQAppInterface) appInterface;
        this.troopMemberApiService = (TroopMemberApiService) appService;
        this.netEngine = (IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all");
    }

    public void cancelJsPttTask(String str, long j3) {
        if (str == null || j3 == 0) {
            return;
        }
        Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).getProcessMap().entrySet().iterator();
        while (it.hasNext()) {
            IHttpCommunicatorListener value = it.next().getValue();
            if (isJsPtt(value)) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) value;
                if (str.equals(baseTransProcessor.mUiRequest.mPeerUin) && j3 == baseTransProcessor.mUiRequest.mUniseq) {
                    baseTransProcessor.cancel();
                    if (QLog.isColorLevel()) {
                        QLog.d("cancelpic", 2, "cancel JSPTT:" + baseTransProcessor.mUiRequest.mUniseq);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
    }
}
