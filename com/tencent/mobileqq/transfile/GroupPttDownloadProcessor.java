package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.ptt.api.impl.PttInfoCollectorImpl;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class GroupPttDownloadProcessor extends BasePttDownloaderProcessor implements Runnable, NetFailedListener {
    static IPatchRedirector $redirector_ = null;
    public static final int DIRECT_DOWNLOAD_FAIL = 3;
    public static final int DIRECT_DOWNLOAD_NO_IP = 2;
    public static final int DIRECT_DOWNLOAD_NO_URL = 1;
    public static final int DIRECT_DOWNLOAD_OUTOFTIME = 4;
    String mDirectDownloadURL;
    TransferRequest.PttDownExtraInfo mExtraInfo;
    String mFullLocalPath;
    long mGroupFileID;
    String mGroupFileKeyStr;
    boolean mIsGroup;
    byte[] mMsgFileMd5;
    private long mMsgRecTime;
    private long mMsgTime;
    MessageForPtt mPtt;
    String mTempPath;
    private boolean useUrlIp;

    public GroupPttDownloadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mIsGroup = true;
        this.mDirectDownloadURL = null;
        this.useUrlIp = false;
    }

    private boolean isFailedByOverDue() {
        String str;
        ProcessorReport processorReport = this.mProcessorReport;
        if (processorReport.errCode == -9527 && (str = processorReport.errDesc) != null && (str.equals(PicDownloadExplicitError.GROUP_PIC_REQUEST_EXPIRED_DESC) || this.mProcessorReport.errDesc.equals("H_400_-5103017") || this.mProcessorReport.errDesc.equals("H_400_-5103039"))) {
            return true;
        }
        return false;
    }

    private void reportDirectDownload(int i3) {
        try {
            String str = "DiscussPTTDirectUrl";
            boolean z16 = true;
            if (this.mUiRequest.mUinType == 1) {
                str = "GroupPTTDirectUrl";
            }
            String str2 = str;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", String.valueOf(i3));
            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
            if (i3 != 0) {
                z16 = false;
            }
            statisticCollector.collectPerformance(null, str2, z16, 0L, 0L, hashMap, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:11:0x001c, B:12:0x002b, B:14:0x0031, B:15:0x0039, B:17:0x003f, B:19:0x004a, B:20:0x0057, B:21:0x0035, B:22:0x000f, B:25:0x005a), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:11:0x001c, B:12:0x002b, B:14:0x0031, B:15:0x0039, B:17:0x003f, B:19:0x004a, B:20:0x0057, B:21:0x0035, B:22:0x000f, B:25:0x005a), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:11:0x001c, B:12:0x002b, B:14:0x0031, B:15:0x0039, B:17:0x003f, B:19:0x004a, B:20:0x0057, B:21:0x0035, B:22:0x000f, B:25:0x005a), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:11:0x001c, B:12:0x002b, B:14:0x0031, B:15:0x0039, B:17:0x003f, B:19:0x004a, B:20:0x0057, B:21:0x0035, B:22:0x000f, B:25:0x005a), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:11:0x001c, B:12:0x002b, B:14:0x0031, B:15:0x0039, B:17:0x003f, B:19:0x004a, B:20:0x0057, B:21:0x0035, B:22:0x000f, B:25:0x005a), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035 A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:11:0x001c, B:12:0x002b, B:14:0x0031, B:15:0x0039, B:17:0x003f, B:19:0x004a, B:20:0x0057, B:21:0x0035, B:22:0x000f, B:25:0x005a), top: B:3:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void requestUrlWhileDirectFailed(boolean z16) {
        boolean z17;
        synchronized (BaseTransProcessor.TAG) {
            if (this.mDirectDownloadURL != null) {
                boolean isFailedByOverDue = isFailedByOverDue();
                if (!isFailedByOverDue && this.mProcessorReport.errCode != 9366) {
                    z17 = true;
                    if (z17) {
                        ((IPttTempApi) QRoute.api(IPttTempApi.class)).doOnPttSrvAddressError(this.useUrlIp, this.mDirectDownloadURL);
                    }
                    this.mDirectDownloadURL = null;
                    if (!z16) {
                        reportDirectDownload(4);
                    } else {
                        reportDirectDownload(3);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("SPD", 4, "directDownloadIfCan error");
                    }
                    if (!isFailedByOverDue) {
                        MessageForPtt messageForPtt = this.mPtt;
                        messageForPtt.fileSize = 2005L;
                        updateMessageDataBaseContent(messageForPtt);
                        onError();
                    } else {
                        sendGetUrlReq();
                    }
                }
                z17 = false;
                if (z17) {
                }
                this.mDirectDownloadURL = null;
                if (!z16) {
                }
                if (QLog.isDevelopLevel()) {
                }
                if (!isFailedByOverDue) {
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        String str = this.mUiRequest.mServerPath;
        if (str != null && !str.equals("") && !str.equals("null") && !FileUtils.isLocalPath(str) && !str.startsWith("http://")) {
            TransferRequest transferRequest = this.mUiRequest;
            MessageForPtt messageForPtt = (MessageForPtt) transferRequest.mRec;
            this.mPtt = messageForPtt;
            this.mExtraInfo = (TransferRequest.PttDownExtraInfo) transferRequest.mExtraObj;
            this.mMsgTime = messageForPtt.msgTime;
            this.mMsgRecTime = messageForPtt.msgRecTime;
            int i3 = messageForPtt.voiceType;
            if (transferRequest.mOutFilePath == null || !FileUtils.isLocalPath(transferRequest.mLocalPath)) {
                String str2 = this.mPtt.fullLocalPath;
                if (str2 != null && !str2.equals("")) {
                    this.mUiRequest.mOutFilePath = this.mPtt.fullLocalPath;
                } else {
                    this.mUiRequest.mOutFilePath = getPttStorePath(VipFunCallConstants.KEY_GROUP, str, i3);
                }
                this.mTempPath = this.mUiRequest.mOutFilePath + "~tmp";
            }
            TransferRequest transferRequest2 = this.mUiRequest;
            boolean z16 = true;
            if (1 != transferRequest2.mUinType) {
                z16 = false;
            }
            this.mIsGroup = z16;
            byte[] md5InBytesOfGroup = getMd5InBytesOfGroup(transferRequest2.mMd5, transferRequest2.mServerPath);
            this.mMsgFileMd5 = md5InBytesOfGroup;
            TransferRequest transferRequest3 = this.mUiRequest;
            this.mGroupFileID = transferRequest3.mGroupFileID;
            this.mGroupFileKeyStr = transferRequest3.mGroupFileKeyStr;
            if (md5InBytesOfGroup != null) {
                return 0;
            }
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("convert md5 error,md5:" + this.mUiRequest.mMd5 + "  uuid:" + this.mUiRequest.mServerPath)), null, null);
            onError();
            return -1;
        }
        this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("uuid illegal " + str)), null, null);
        onError();
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        int i3;
        String str;
        String str2;
        String str3;
        ServerAddr ipAndPortFromUrl;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (!z16 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (!processorReport.mIsOldDbRec) {
            if (!z16 || (processorReport.mReportedFlag & 2) <= 0) {
                int i16 = 1;
                if (z16 || (processorReport.mReportedFlag & 1) <= 0) {
                    int i17 = processorReport.mReportedFlag;
                    if (z16) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    processorReport.mReportedFlag = i17 | i3;
                    long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, this.mProcessorReport.mStepDirectDown.getReportInfo(1) + ";" + this.mProcessorReport.mStepUrl.getReportInfo(2) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(3) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(4));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_UUID, this.mUiRequest.mServerPath);
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    processorReport2.mReportInfo.put(ReportConstant.KEY_SENDBY_QUICK_HTTP, String.valueOf(processorReport2.mSendByQuickHttp));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PTT_OPT, String.valueOf(((IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class)).getOptString(((BasePttDownloaderProcessor) this).app, this.useUrlIp)));
                    HashMap<String, String> hashMap = this.mProcessorReport.mReportInfo;
                    if (this.mIsHttpsDownload) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    hashMap.put(ReportConstant.KEY_IS_HTTPS, str);
                    ProcessorReport processorReport3 = this.mProcessorReport;
                    processorReport3.mReportInfo.put(ReportConstant.KEY_TRANS_CONSUME, String.valueOf(processorReport3.mStepTrans.getTimeConsume()));
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("GroupPttDownload success: ");
                        sb5.append(z16);
                        sb5.append(", cost: ");
                        sb5.append(nanoTime);
                        sb5.append(" directDownloadIfCan: ");
                        if (this.mDirectDownloadURL != null) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        sb5.append(z17);
                        QLog.d("SPD", 4, sb5.toString());
                    }
                    if (z16) {
                        this.mProcessorReport.mReportInfo.put("param_isSuccess", "1");
                        reportForIpv6(true, nanoTime);
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, nanoTime, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
                    } else {
                        ProcessorReport processorReport4 = this.mProcessorReport;
                        if (processorReport4.errCode != -9527) {
                            processorReport4.mReportInfo.remove("param_rspHeader");
                        }
                        ProcessorReport processorReport5 = this.mProcessorReport;
                        processorReport5.mReportInfo.put("param_FailCode", String.valueOf(processorReport5.errCode));
                        ProcessorReport processorReport6 = this.mProcessorReport;
                        processorReport6.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport6.errDesc);
                        NetReq netReq = this.mNetReq;
                        if ((netReq instanceof HttpNetReq) && (ipAndPortFromUrl = TransFileUtil.getIpAndPortFromUrl(((HttpNetReq) netReq).mReqUrl)) != null) {
                            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_REQ_IP, ipAndPortFromUrl.mIp);
                        }
                        this.mProcessorReport.mReportInfo.put("param_isSuccess", "0");
                        reportForIpv6(false, nanoTime);
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, nanoTime, 0L, this.mProcessorReport.mReportInfo, "");
                        ProcessorReport processorReport7 = this.mProcessorReport;
                        if (processorReport7.errCode == -9527 && (str2 = processorReport7.errDesc) != null) {
                            if (!str2.equals(PicDownloadExplicitError.GROUP_PIC_REQUEST_EXPIRED_DESC)) {
                                if (this.mProcessorReport.errDesc.equals("H_400_-5103017")) {
                                    i16 = 16;
                                } else {
                                    i16 = 0;
                                }
                            }
                            if (i16 != 0) {
                                if (this.mMsgRecTime > this.mMsgTime) {
                                    if (this.mIsGroup) {
                                        str3 = "actGroupPTTOutOfTime";
                                    } else {
                                        str3 = "actDiscussionPTTOutOfTime";
                                    }
                                    String str4 = str3;
                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                                    long j3 = this.mMsgRecTime;
                                    long j16 = this.mMsgTime;
                                    hashMap2.put("MsgOff", String.valueOf((j3 - j16) / 86400));
                                    hashMap2.put("PttOff", String.valueOf((currentTimeMillis - j3) / 86400));
                                    hashMap2.put("OutOfTimeReason", String.valueOf(i16));
                                    hashMap2.put("param_FailCode", String.valueOf((currentTimeMillis - j16) / 86400));
                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str4, false, 0L, 0L, hashMap2, null);
                                }
                                Object obj = this.mUiRequest.mExtraObj;
                                if (obj != null) {
                                    TransferRequest.PttDownExtraInfo pttDownExtraInfo = (TransferRequest.PttDownExtraInfo) obj;
                                    ReportController.o(((BasePttDownloaderProcessor) this).app, "CliOper", "", "", "0X80059B3", "0X80059B3", PttInfoCollectorImpl.mergeDownloadPTTFromType(pttDownExtraInfo.mFromType, pttDownExtraInfo.mLayer), 0, "", "", "", AppSetting.f99551k);
                                }
                            }
                        }
                    }
                    setReportFlag();
                    if (this.mPtt != null) {
                        ((IPTTPreDownloader) ((BasePttDownloaderProcessor) this).app.getRuntimeService(IPTTPreDownloader.class, "all")).onDownloadFinish(z16, this.mProcessorReport.errCode, this.mExtraInfo, this.mPtt);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.mUiRequest.mUinType == 1) {
            return StatisticCollector.TROOP_PTT_DOWNLOAD_STATISTIC_TAG;
        }
        return StatisticCollector.DISCUSSION_PTT_DOWNLOAD_STATISTIC_TAG;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.GroupPttDownResp groupPttDownResp = (RichProto.RichProtoResp.GroupPttDownResp) richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", groupPttDownResp.toString());
                }
                this.mProcessorReport.mSendByQuickHttp = groupPttDownResp.isSendByQuickHttp;
                if (QLog.isColorLevel()) {
                    QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mProcessorReport.mSendByQuickHttp);
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, groupPttDownResp);
                if (groupPttDownResp.result == 0) {
                    this.mDownDomain = groupPttDownResp.domainV4V6;
                    this.mUrlPath = groupPttDownResp.urlPath;
                    this.mIpList = selectIpList(groupPttDownResp.mIpv6List, groupPttDownResp.mIpList);
                    if (this.mDownDomain != null) {
                        ServerAddr serverAddr = new ServerAddr();
                        serverAddr.isDomain = true;
                        serverAddr.mIp = this.mDownDomain;
                        this.mIpList.add(serverAddr);
                    }
                    recieveFile(groupPttDownResp.mIsHttps);
                } else {
                    onError();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        if (this.mUiRequest.mDownCallBack != null) {
            c.a aVar = new c.a();
            aVar.f258654a = -1;
            this.mUiRequest.mDownCallBack.h(aVar);
            return;
        }
        sendMessageToUpdate(2005);
    }

    @Override // com.tencent.mobileqq.transfile.NetFailedListener
    public void onFailed(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) netResp);
            return;
        }
        this.mRSMReporter.mFileSize = this.mRecvLen;
        reportForServerMonitor(netResp, false, RMServMonitorReport.REPORT_NAME_NM_PTTDOWN, this.mUiRequest.mServerPath);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        StepInfo stepInfo;
        FileMsg.StepTransInfo stepTransInfo;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) netResp);
            return;
        }
        if (this.mDirectDownloadURL != null) {
            stepInfo = this.mProcessorReport.mStepDirectDown;
            stepTransInfo = this.file.stepMsgDirecDown;
            ThreadManager.getSubThreadHandler().removeCallbacks(this);
        } else {
            stepInfo = this.mProcessorReport.mStepTrans;
            stepTransInfo = this.file.stepTrans;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        processorReport.copyStaticsInfoFromNetResp(stepInfo, netResp, z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" result:");
        if (netResp.mResult == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        logRichMediaEvent("onHttpResp", sb5.toString());
        long j3 = netResp.mTotalFileLen;
        this.mTotolLen = j3;
        NetReq netReq = this.mNetReq;
        if (netReq != null) {
            netReq.mCallback = null;
        }
        if (j3 <= 0) {
            this.mTotolLen = netResp.mTotalBlockLen + netResp.mReq.mStartDownOffset;
        }
        this.mRecvLen += netResp.mWrittenBlockLen;
        stepTransInfo.respHeader = netResp.mRespProperties.get("param_rspHeader");
        if (netResp.mResult == 0) {
            onSuccess();
            this.mRSMReporter.mFileSize = this.mRecvLen;
            reportForServerMonitor(netResp, true, RMServMonitorReport.REPORT_NAME_NM_PTTDOWN, this.mUiRequest.mServerPath);
            if (this.mDirectDownloadURL != null) {
                reportDirectDownload(0);
            }
        } else if (this.mDirectDownloadURL != null) {
            requestUrlWhileDirectFailed(false);
        } else {
            if (netResp.mErrCode == 9364 && this.mNetworkChgRetryCount < 3) {
                logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
                this.mNetReq = null;
                this.mNetworkChgRetryCount++;
                clearReprotInfo();
                sendGetUrlReq();
                return;
            }
            onError();
        }
        this.mNetReq = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        String str;
        MessageForPtt messageForPtt = this.mPtt;
        messageForPtt.url = MessageForPtt.getMsgFilePath(messageForPtt.voiceType, this.mUiRequest.mOutFilePath);
        MessageForPtt messageForPtt2 = this.mPtt;
        messageForPtt2.fileSize = this.mTotolLen;
        messageForPtt2.urlAtServer = this.mUiRequest.mServerPath;
        super.onSuccess();
        Message updateMessageDataBaseContent = updateMessageDataBaseContent(this.mPtt);
        if (updateMessageDataBaseContent != null && (str = updateMessageDataBaseContent.pttUrl) != null && str.equals(this.mUiRequest.mServerPath)) {
            updateMessageDataBaseContent.pttUrl = this.mUiRequest.mOutFilePath;
        }
        if (this.mUiRequest.mDownCallBack != null) {
            c.a aVar = new c.a();
            aVar.f258654a = 0;
            this.mUiRequest.mDownCallBack.h(aVar);
            return;
        }
        sendMessageToUpdate(2003);
    }

    void recieveFile(boolean z16) {
        String str;
        this.mProcessorReport.mStepTrans.logStartTime();
        this.mIsHttpsDownload = z16;
        this.mRSMReporter.mIsHttps = z16;
        String str2 = z16 ? "https://" : "http://";
        if (this.isDomainTest) {
            this.mDownDomain = BaseDownloadProcessor.PTT_VIDEO_DOWNLOAD_DOMAIN;
            ArrayList<ServerAddr> arrayList = this.mIpList;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
        ArrayList<ServerAddr> arrayList2 = this.mIpList;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ServerAddr serverAddr = this.mIpList.get(0);
            if (serverAddr.isIpv6 && !serverAddr.mIp.startsWith("[")) {
                str = "[" + serverAddr.mIp + "]";
            } else {
                str = serverAddr.mIp;
            }
            if (serverAddr.port != 80) {
                str = str + ":" + serverAddr.port;
            }
            this.mIpList.remove(0);
        } else {
            str = this.mDownDomain;
            if (str == null) {
                str = null;
            }
        }
        recieveFile((str2 + str) + this.mUrlPath, z16);
    }

    protected void reportPttPV(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportPTTPV(((BasePttDownloaderProcessor) this).app, i3, false, 2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.mNetReq != null) {
            if (QLog.isColorLevel()) {
                QLog.e("SPD", 2, "Direct download failed overtime = " + this.mDirectDownloadURL);
            }
            this.mNetEngine.cancelReq(this.mNetReq);
            this.mNetReq = null;
        }
        requestUrlWhileDirectFailed(true);
    }

    void sendGetUrlReq() {
        sendMessageToUpdate(2001);
        sendRequest_pb();
    }

    void sendRequest_pb() {
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.GroupPttDownReq groupPttDownReq = new RichProto.RichProtoReq.GroupPttDownReq();
        TransferRequest transferRequest = this.mUiRequest;
        groupPttDownReq.selfUin = transferRequest.mSelfUin;
        groupPttDownReq.peerUin = transferRequest.mPeerUin;
        groupPttDownReq.secondUin = transferRequest.mSecondId;
        groupPttDownReq.uinType = transferRequest.mUinType;
        groupPttDownReq.groupFileID = this.mGroupFileID;
        logRichMediaEvent("SendRequest", " SendRequest GrpFileKey:" + this.mGroupFileKeyStr);
        groupPttDownReq.groupFileKey = this.mGroupFileKeyStr;
        groupPttDownReq.md5 = this.mMsgFileMd5;
        groupPttDownReq.voiceType = this.mPtt.voiceType;
        groupPttDownReq.downType = this.mUiRequest.mDownMode;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.GRP_PTT_DW;
        richProtoReq.reqs.add(groupPttDownReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) ((BasePttDownloaderProcessor) this).app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
        } else {
            if (QLog.isColorLevel()) {
                logRichMediaEvent("requestStart", richProtoReq.toString());
            }
            if (!canDoNextStep()) {
                return;
            }
            this.mRichProtoReq = richProtoReq;
            RichProtoProc.procRichProtoReq(richProtoReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void setMtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        NetReq netReq = this.mNetReq;
        if (netReq != null && (netReq instanceof HttpNetReq)) {
            if (this.mIsGroup) {
                ((HttpNetReq) netReq).mReqUrl = MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_PTT_GD, ((HttpNetReq) netReq).mReqUrl);
            } else {
                ((HttpNetReq) netReq).mReqUrl = MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_PTT_DD, ((HttpNetReq) netReq).mReqUrl);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        MessageForPtt messageForPtt = this.mPtt;
        if (messageForPtt.extFlag == -1) {
            messageForPtt.extFlag = 0L;
        }
        if (this.mExtraInfo.mFromType == 6) {
            messageForPtt.extFlag |= 1;
        }
        super.start();
        sendMessageToUpdate(2001);
        if (this.mUiRequest.mUinType == 1) {
            i3 = 3;
        }
        reportPttPV(i3);
        if (!this.mUiRequest.mOutFilePath.equals(this.mPtt.fullLocalPath)) {
            MessageForPtt messageForPtt2 = this.mPtt;
            messageForPtt2.fullLocalPath = this.mUiRequest.mOutFilePath;
            updateMessageDataBaseContent(messageForPtt2);
        }
        sendGetUrlReq();
    }

    public Message updateMessageDataBaseContent(MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Message) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageForPtt);
        }
        messageForPtt.serial();
        IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
        AppInterface appInterface = ((BasePttDownloaderProcessor) this).app;
        TransferRequest transferRequest = this.mUiRequest;
        iPttTempApi.updateMsgContentByUniseq(appInterface, transferRequest.mPeerUin, transferRequest.mUinType, messageForPtt.uniseq, messageForPtt.msgData);
        IPttTempApi iPttTempApi2 = (IPttTempApi) QRoute.api(IPttTempApi.class);
        AppInterface appInterface2 = ((BasePttDownloaderProcessor) this).app;
        TransferRequest transferRequest2 = this.mUiRequest;
        return iPttTempApi2.getLastMessage(appInterface2, transferRequest2.mPeerUin, transferRequest2.mUinType);
    }

    void recieveFile(String str, boolean z16) {
        if (!str.contains("voice_codec=")) {
            str = str + "&voice_codec=" + this.mPtt.voiceType;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mFailedListener = this;
        httpNetReq.mReqUrl = str;
        httpNetReq.mIsHttps = z16;
        httpNetReq.mHostForHttpsVerify = this.mDownDomain;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mServerList = this.mIpList;
        TransferRequest transferRequest = this.mUiRequest;
        httpNetReq.mOutPath = transferRequest.mOutFilePath;
        httpNetReq.mSupportBreakResume = true;
        httpNetReq.mTempPath = this.mTempPath;
        httpNetReq.mMsgId = String.valueOf(transferRequest.mUniseq);
        TransferRequest transferRequest2 = this.mUiRequest;
        httpNetReq.mBusiProtoType = transferRequest2.mUinType;
        httpNetReq.mFileType = transferRequest2.mFileType;
        httpNetReq.mStartDownOffset = 0L;
        httpNetReq.mIsNetChgAsError = true;
        httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
        if (this.mDirectDownloadURL != null) {
            httpNetReq.mExcuteTimeLimit = 60000L;
            httpNetReq.mContinuErrorLimit = 0;
        }
        httpNetReq.mCanPrintUrl = true;
        httpNetReq.mUseCmwapConnectionTypeFromDpc = true;
        ArrayList<ServerAddr> arrayList = this.mIpList;
        logRichMediaEvent("httpDown", "directMsgUrlDown:" + this.mDirectMsgUrlDown + " ipList:" + ((arrayList == null || arrayList.isEmpty()) ? null : Arrays.toString(this.mIpList.toArray())) + " uuid:" + this.mUiRequest.mServerPath + " FileID:" + this.mUiRequest.mGroupFileID + " downOffset:" + httpNetReq.mStartDownOffset);
        if (canDoNextStep()) {
            this.mNetReq = httpNetReq;
            setMtype();
            this.mNetEngine.sendReq(httpNetReq);
        }
    }
}
