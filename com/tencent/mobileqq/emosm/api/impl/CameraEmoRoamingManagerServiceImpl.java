package com.tencent.mobileqq.emosm.api.impl;

import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.CameraEmoRoamingObserver;
import com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CameraEmoRoamingManagerServiceImpl extends CustomEmotionRoamingManagerBase<CameraEmotionData> implements ICameraEmoRoamingManagerService {
    public static final String TAG = "CameraEmoRoamingManager";
    HashMap<CameraEmotionData, ICameraEmoRoamingManagerService.a> mAddCallBackMap = new HashMap<>();
    private volatile String listVersion = "";
    private volatile boolean hasReadVersion = false;
    volatile String isNeedShowGuide = null;
    private CameraEmoRoamingObserver emoRoamingObserver = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends CameraEmoRoamingObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.app.CameraEmoRoamingObserver
        protected void doOnAddEmoResult(int i3, CameraEmotionData cameraEmotionData) {
            CameraEmoRoamingManagerServiceImpl.this.onUploadCameraEmoCallBack(i3, cameraEmotionData);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CameraEmotionData f204146a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, CameraEmotionData cameraEmotionData) {
            super(looper);
            this.f204146a = cameraEmotionData;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileMsg fileMsg = (FileMsg) message.obj;
            if (((CustomEmotionRoamingManagerBase) CameraEmoRoamingManagerServiceImpl.this).mApp == null) {
                return;
            }
            if (fileMsg != null && fileMsg.commandId == CameraEmoRoamingManagerServiceImpl.this.getUploadProcessorID()) {
                Bdh_extinfo.CommFileExtRsp commFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
                byte[] bArr = fileMsg.bdhExtendInfo;
                String str = "";
                if (bArr != null) {
                    try {
                        commFileExtRsp.mergeFrom(bArr);
                        if (commFileExtRsp.bytes_download_url.has()) {
                            str = commFileExtRsp.bytes_download_url.get().toStringUtf8();
                        }
                    } catch (Exception unused) {
                        QLog.d(CameraEmoRoamingManagerServiceImpl.TAG, 2, "extRsp.mergeFrom(file.bdhExtendInfo) failed");
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                switch (message.what) {
                    case 1001:
                        if (QLog.isColorLevel()) {
                            QLog.d(CameraEmoRoamingManagerServiceImpl.TAG, 2, "start upload camera emo");
                            return;
                        }
                        return;
                    case 1002:
                    default:
                        return;
                    case 1003:
                        if (QLog.isColorLevel()) {
                            QLog.d(CameraEmoRoamingManagerServiceImpl.TAG, 2, "finish upload camera emo serverPath=" + str);
                        }
                        ((ITransFileController) ((CustomEmotionRoamingManagerBase) CameraEmoRoamingManagerServiceImpl.this).mApp.getRuntimeService(ITransFileController.class)).removeHandle(this);
                        ((CameraEmoRoamingHandler) ((CustomEmotionRoamingManagerBase) CameraEmoRoamingManagerServiceImpl.this).mApp.getBusinessHandler(CameraEmoRoamingHandler.f194459e)).G2(this.f204146a, true);
                        hashMap.put("sucFlag", "1");
                        hashMap.put("retCode", String.valueOf(message.what));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", true, 0L, 0L, hashMap, null);
                        return;
                    case 1004:
                        ((ITransFileController) ((CustomEmotionRoamingManagerBase) CameraEmoRoamingManagerServiceImpl.this).mApp.getRuntimeService(ITransFileController.class)).removeHandle(this);
                        QLog.i(CameraEmoRoamingManagerServiceImpl.TAG, 1, "upload camera emo cancel:" + str);
                        ((CameraEmoRoamingHandler) ((CustomEmotionRoamingManagerBase) CameraEmoRoamingManagerServiceImpl.this).mApp.getBusinessHandler(CameraEmoRoamingHandler.f194459e)).G2(this.f204146a, false);
                        hashMap.put("sucFlag", "0");
                        hashMap.put("retCode", String.valueOf(message.what));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", false, 0L, 0L, hashMap, null);
                        return;
                    case 1005:
                        ((ITransFileController) ((CustomEmotionRoamingManagerBase) CameraEmoRoamingManagerServiceImpl.this).mApp.getRuntimeService(ITransFileController.class)).removeHandle(this);
                        QLog.i(CameraEmoRoamingManagerServiceImpl.TAG, 1, "upload camera emo error:" + commFileExtRsp.int32_retcode.get());
                        ((CameraEmoRoamingHandler) ((CustomEmotionRoamingManagerBase) CameraEmoRoamingManagerServiceImpl.this).mApp.getBusinessHandler(CameraEmoRoamingHandler.f194459e)).G2(this.f204146a, false);
                        hashMap.put("sucFlag", "0");
                        hashMap.put("retCode", String.valueOf(commFileExtRsp.int32_retcode.get()));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", false, 0L, 0L, hashMap, null);
                        return;
                }
            }
            ((ITransFileController) ((CustomEmotionRoamingManagerBase) CameraEmoRoamingManagerServiceImpl.this).mApp.getRuntimeService(ITransFileController.class)).removeHandle(this);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public void asyncIncreaseEmotionClickNum(CameraEmotionData cameraEmotionData) {
        cameraEmotionData.increaseClickNum();
        getDBManager().updateCustomEmotion(cameraEmotionData);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase
    protected CustomEmotionRoamingDBManagerBase<CameraEmotionData> getDBManager() {
        return (CameraEmotionRoamingDBManagerServiceImpl) this.mApp.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public long getFileLength(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0L;
            }
            return file.length();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public i getImageSize(String str) {
        int i3;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        int i16 = 0;
        try {
            BitmapFactory.decodeFile(str, options);
            i3 = options.outHeight;
            try {
                i16 = options.outWidth;
            } catch (Exception e16) {
                e = e16;
                QLog.e(TAG, 1, "getImageSize has exception", e);
                return new i(i16, i3);
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
        return new i(i16, i3);
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public boolean getIsNeedShowGuide() {
        return false;
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public String getListVersion() {
        if (!this.hasReadVersion) {
            this.listVersion = cl.d(this.mApp.getApp().getApplicationContext(), this.mApp.getCurrentUin() + "camera_emo_list_version");
            this.hasReadVersion = true;
        }
        return this.listVersion;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase
    protected CustomEmoRoamingBaseHandler<CameraEmotionData> getRoamingHandler() {
        return (CameraEmoRoamingHandler) this.mApp.getBusinessHandler(CameraEmoRoamingHandler.f194459e);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase
    public int getUploadProcessorID() {
        return 70;
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public boolean isShowCameraEmoInApp() {
        return true;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase, mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        super.onCreate(appRuntime);
        this.mApp.addObserver(this.emoRoamingObserver);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase, mqq.app.api.IRuntimeService
    public void onDestroy() {
        BaseQQAppInterface baseQQAppInterface;
        super.onDestroy();
        CameraEmoRoamingObserver cameraEmoRoamingObserver = this.emoRoamingObserver;
        if (cameraEmoRoamingObserver != null && (baseQQAppInterface = this.mApp) != null) {
            baseQQAppInterface.removeObserver(cameraEmoRoamingObserver);
        }
        Iterator<Map.Entry<CameraEmotionData, ICameraEmoRoamingManagerService.a>> it = this.mAddCallBackMap.entrySet().iterator();
        while (it.hasNext()) {
            onUploadCameraEmoCallBack(15, it.next().getKey());
        }
        this.mAddCallBackMap.clear();
        this.mApp = null;
    }

    public void onUploadCameraEmoCallBack(int i3, CameraEmotionData cameraEmotionData) {
        ICameraEmoRoamingManagerService.a aVar = this.mAddCallBackMap.get(cameraEmotionData);
        if (aVar != null) {
            aVar.a(i3, cameraEmotionData);
            this.mAddCallBackMap.remove(cameraEmotionData);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public void realUploadCustomEmoticon(CameraEmotionData cameraEmotionData) {
        if (this.mApp == null) {
            QLog.d(TAG, 1, "realUploadCustomEmoticon start, app is null");
            onUploadCameraEmoCallBack(100, cameraEmotionData);
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.d(TAG, 1, "realUploadCustomEmoticon start, net not support");
            onUploadCameraEmoCallBack(12, cameraEmotionData);
            return;
        }
        QLog.d(TAG, 1, "realUploadCustomEmoticon start");
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 70;
        transferRequest.mRichTag = "camera_emo_upload";
        String str = this.uin;
        transferRequest.mSelfUin = str;
        transferRequest.mPeerUin = str;
        transferRequest.mIsUp = true;
        transferRequest.mUniseq = cameraEmotionData.emoId;
        transferRequest.mLocalPath = cameraEmotionData.emoPath;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFrom(cameraEmotionData.resid.getBytes()));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        b bVar = new b(ThreadManagerV2.getSubThreadLooper(), cameraEmotionData);
        bVar.addFilter(BDHCommonUploadProcessor.class);
        ((ITransFileController) this.mApp.getRuntimeService(ITransFileController.class)).addHandle(bVar);
        ((ITransFileController) this.mApp.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public void setIsNeedShowGuide(boolean z16) {
        String str;
        if (z16) {
            str = "";
        } else {
            str = "has_value";
        }
        this.isNeedShowGuide = str;
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public void syncIncreaseEmoticonExposeNum(CameraEmotionData cameraEmotionData) {
        cameraEmotionData.increaseExposeNum();
        getDBManager().updateCustomEmotion(cameraEmotionData);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase, com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public void syncLocalDel() {
        final CameraEmoRoamingHandler cameraEmoRoamingHandler;
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface == null || (cameraEmoRoamingHandler = (CameraEmoRoamingHandler) baseQQAppInterface.getBusinessHandler(CameraEmoRoamingHandler.f194459e)) == null) {
            return;
        }
        final ICameraEmotionRoamingDBManagerService iCameraEmotionRoamingDBManagerService = (ICameraEmotionRoamingDBManagerService) this.mApp.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.CameraEmoRoamingManagerServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                List<String> customEmoticonResIdsByType = iCameraEmotionRoamingDBManagerService.getCustomEmoticonResIdsByType("needDel");
                if (customEmoticonResIdsByType.size() > 0) {
                    cameraEmoRoamingHandler.delUserEmoRoamingReq(customEmoticonResIdsByType, true);
                } else if (customEmoticonResIdsByType.size() == 0) {
                    CameraEmoRoamingManagerServiceImpl.this.syncRoaming();
                }
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public void updateListVersion(String str) {
        if (str == null) {
            return;
        }
        cl.j(this.mApp.getApp().getApplicationContext(), this.mApp.getCurrentUin() + "camera_emo_list_version", str);
        this.listVersion = str;
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService
    public void uploadCameraEmo(CameraEmotionData cameraEmotionData, ICameraEmoRoamingManagerService.a aVar) {
        if (StringUtil.isEmpty(cameraEmotionData.emoPath)) {
            QLog.d(TAG, 1, "uploadCameraEmo error, path is null");
            aVar.a(10, cameraEmotionData);
            return;
        }
        if (this.mApp == null) {
            QLog.d(TAG, 1, "uploadCameraEmo, app is null");
            aVar.a(100, cameraEmotionData);
            return;
        }
        long fileLength = getFileLength(cameraEmotionData.emoPath);
        i imageSize = getImageSize(cameraEmotionData.emoPath);
        if (!StringUtil.isEmpty(cameraEmotionData.md5) && fileLength != 0 && imageSize.a() != 0 && imageSize.b() != 0) {
            QLog.d(TAG, 1, "uploadCameraEmo start");
            this.mAddCallBackMap.put(cameraEmotionData, aVar);
            ((CameraEmoRoamingHandler) this.mApp.getBusinessHandler(CameraEmoRoamingHandler.f194459e)).J2(cameraEmotionData, imageSize.b(), imageSize.a(), fileLength);
        } else {
            QLog.d(TAG, 1, "uploadCameraEmo params error, md5:", cameraEmotionData.md5, " size:", Long.valueOf(fileLength), " width:", Integer.valueOf(imageSize.b()), " height:", Integer.valueOf(imageSize.a()));
            aVar.a(14, cameraEmotionData);
        }
    }
}
