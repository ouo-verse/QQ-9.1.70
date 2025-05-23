package com.tencent.mobileqq.zplan.avatar.api.impl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.profilecommon.processor.AvatarHistoryNumProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarApngProcessor;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes35.dex */
public class ZPlanAvatarApngProcessorImpl implements IZPlanAvatarApngProcessor {
    private static final String TAG = "[zplan]ZPlanAvatarApngProcessor";
    public static StringBuilder sTempBuilder;
    private int mActionType;
    private String mApngCoverPath;
    private String mApngDirPath;
    private WeakReference<AppInterface> mAppRef;
    private int mFileType;
    private IZPlanAvatarApngProcessor.a mFinishListener;
    private boolean mNeedUploadCover;
    private int mPortraitId;
    private b mUploadHandler;
    private int mResolutionsHigh = 640;
    private volatile boolean mIsUploading = false;
    private boolean mIsUploadingStatic = false;
    private boolean mIsUploadingApng = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements IZPlanAvatarFileManager.a {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager.a
        public void a(boolean z16, List<String> list, int i3) {
            ZPlanAvatarApngProcessorImpl.this.doStartUploadCover(z16, list);
        }
    }

    /* loaded from: classes35.dex */
    private class b extends TransProcessorHandler {
        public b(Looper looper) {
            super(looper);
        }

        private void b(FileMsg fileMsg) {
            if (QLog.isColorLevel()) {
                QLog.i(ZPlanAvatarApngProcessorImpl.TAG, 2, String.format("handleStatusSendFinished, fileType=%s", Integer.valueOf(fileMsg.fileType)));
            }
            if (!ZPlanAvatarApngProcessorImpl.this.mNeedUploadCover || !ZPlanAvatarApngProcessorImpl.this.mIsUploadingStatic || ZPlanAvatarApngProcessorImpl.this.mIsUploadingApng) {
                if (!ZPlanAvatarApngProcessorImpl.this.mIsUploadingStatic && ZPlanAvatarApngProcessorImpl.this.mIsUploadingApng) {
                    QLog.d(ZPlanAvatarApngProcessorImpl.TAG, 1, "dynamic avatar uploaded.");
                    ZPlanAvatarApngProcessorImpl.this.onFinalUploadProcess(fileMsg);
                    ZPlanAvatarApngProcessorImpl.this.mIsUploading = false;
                    return;
                } else {
                    QLog.e(ZPlanAvatarApngProcessorImpl.TAG, 1, "upload process error.");
                    ZPlanAvatarApngProcessorImpl.this.doOnProcessFinish(false);
                    ZPlanAvatarApngProcessorImpl.this.mIsUploading = false;
                    return;
                }
            }
            QLog.d(ZPlanAvatarApngProcessorImpl.TAG, 1, "static avatar uploaded.");
            ZPlanAvatarApngProcessorImpl.this.doUploadApng();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (((AppInterface) ZPlanAvatarApngProcessorImpl.this.mAppRef.get()) == null || !ZPlanAvatarApngProcessorImpl.this.mIsUploading) {
                return;
            }
            FileMsg fileMsg = (FileMsg) message.obj;
            QLog.d(ZPlanAvatarApngProcessorImpl.TAG, 4, "VideoUploadProcessorHandler.handleMessage fileType=" + fileMsg.fileType + ", errorCode=" + fileMsg.errorCode + "\uff0c what=" + message.what);
            int i3 = message.what;
            if (i3 == 1003) {
                b(fileMsg);
            } else {
                if (i3 != 1005) {
                    return;
                }
                a(fileMsg);
            }
        }

        private void a(FileMsg fileMsg) {
            QLog.e(ZPlanAvatarApngProcessorImpl.TAG, 1, String.format("handleStatusSendError, errorCode=%s", Integer.valueOf(fileMsg.errorCode)));
            ZPlanAvatarApngProcessorImpl.this.doOnProcessFinish(false);
            ZPlanAvatarApngProcessorImpl.this.mIsUploading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ProfileCardUtil.a checkBeforeUpload(QQAppInterface qQAppInterface, String str, boolean z16) {
        ProfileCardUtil.a aVar = new ProfileCardUtil.a();
        if (TextUtils.isEmpty(str)) {
            aVar.f306430a = -10000;
            aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST;
            printErrorLog("onAvatarChanged", -10000, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
            return aVar;
        }
        File file = new File(str);
        long length = file.length();
        if (!file.exists()) {
            aVar.f306430a = -10000;
            aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST;
            printErrorLog("onAvatarChanged", -10000, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
            return aVar;
        }
        if (!NetworkUtil.isNetSupport(qQAppInterface.getApp())) {
            aVar.f306430a = -10001;
            aVar.f306431b = "network error";
            printErrorLog("onAvatarChanged", -10001, "network error");
            return aVar;
        }
        if (length <= 0) {
            printErrorLog("onAvatarChanged", 0, String.valueOf(length));
            aVar.f306430a = -10000;
            aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL;
            printErrorLog("onAvatarChanged", -10000, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL);
            return aVar;
        }
        if (z16) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth;
            if (i3 != options.outHeight || i3 <= 0 || i3 > 1080) {
                aVar.f306430a = -10000;
                aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL;
                printErrorLog("onAvatarChanged", -10000, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL);
                return aVar;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|start upload : size = " + length);
        }
        aVar.f306430a = 0;
        aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnProcessFinish(boolean z16) {
        IZPlanAvatarApngProcessor.a aVar = this.mFinishListener;
        if (aVar != null) {
            aVar.a(z16, this.mPortraitId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doProcess(int i3, boolean z16) {
        reset();
        this.mPortraitId = i3;
        this.mNeedUploadCover = z16;
        this.mFileType = 22;
        if (this.mAppRef.get() == null) {
            QLog.i(TAG, 1, "upload process exits due to app null");
            return;
        }
        QLog.i(TAG, 1, "process " + i3);
        if (z16) {
            doUploadStaticCover();
        } else {
            doUploadApng();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartUploadCover(final boolean z16, final List<String> list) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarApngProcessorImpl.4
            @Override // java.lang.Runnable
            public void run() {
                List list2;
                if (z16 && (list2 = list) != null && !list2.isEmpty()) {
                    String coverFramePath = ZPlanAvatarApngProcessorImpl.this.getCoverFramePath(list);
                    ZPlanAvatarApngProcessorImpl zPlanAvatarApngProcessorImpl = ZPlanAvatarApngProcessorImpl.this;
                    zPlanAvatarApngProcessorImpl.mApngCoverPath = zPlanAvatarApngProcessorImpl.saveCoverFromPicList(coverFramePath);
                    Intent intent = new Intent();
                    intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", ZPlanAvatarApngProcessorImpl.this.mApngCoverPath);
                    QLog.i(ZPlanAvatarApngProcessorImpl.TAG, 1, "cover path = " + ZPlanAvatarApngProcessorImpl.this.mApngCoverPath + ", pic list size = " + list.size());
                    AppInterface appInterface = (AppInterface) ZPlanAvatarApngProcessorImpl.this.mAppRef.get();
                    if (appInterface == null) {
                        QLog.e(ZPlanAvatarApngProcessorImpl.TAG, 1, "doStartUploadCover error, app null.");
                        return;
                    }
                    ZPlanAvatarApngProcessorImpl zPlanAvatarApngProcessorImpl2 = ZPlanAvatarApngProcessorImpl.this;
                    ProfileCardUtil.a checkBeforeUpload = zPlanAvatarApngProcessorImpl2.checkBeforeUpload((QQAppInterface) appInterface, zPlanAvatarApngProcessorImpl2.mApngCoverPath, false);
                    if (checkBeforeUpload.f306431b == FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS && checkBeforeUpload.f306430a == 0) {
                        ZPlanAvatarApngProcessorImpl.this.startUpload(intent);
                        return;
                    } else {
                        QLog.e(ZPlanAvatarApngProcessorImpl.TAG, 1, "check before upload apng cover error.");
                        ZPlanAvatarApngProcessorImpl.this.doOnProcessFinish(false);
                        return;
                    }
                }
                QLog.e(ZPlanAvatarApngProcessorImpl.TAG, 1, "getFrameFilePath picList empty.");
                ZPlanAvatarApngProcessorImpl.this.doOnProcessFinish(false);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getApngDirPath(int i3) {
        String apngFilePath = ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).getApngFilePath(i3);
        if (apngFilePath == null) {
            QLog.e(TAG, 1, "getApngFilePath is null");
            return null;
        }
        File file = new File(apngFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private void printErrorLog(String str, int i3, String str2) {
        StringBuilder sb5 = sTempBuilder;
        if (sb5 == null) {
            sTempBuilder = new StringBuilder(120);
        } else {
            sb5.setLength(0);
        }
        StringBuilder sb6 = sTempBuilder;
        sb6.append(str);
        sb6.append(", reason = [");
        sb6.append(str2);
        sb6.append("], code = [");
        sb6.append(i3);
        sb6.append("]");
        QLog.i("UPLOAD_AVATAR_FAIL", 1, sTempBuilder.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveCoverFromPicList(String str) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d(TAG, 1, "saveCoverFromCoverFramePath");
        File file = new File(getApngDirPath(this.mPortraitId), "cover.png");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                try {
                    bitmap2 = Bitmap.createScaledBitmap(decodeFile, 480, 480, true);
                    if (bitmap2 != null) {
                        BaseImageUtil.saveBitmapFileAsPNG(bitmap2, 100, file);
                        if (file.exists() && file.length() > 0) {
                            QLog.d(TAG, 1, "saveCoverFromPicList successfully");
                            String absolutePath = file.getAbsolutePath();
                            decodeFile.recycle();
                            bitmap2.recycle();
                            return absolutePath;
                        }
                        bitmap2.recycle();
                    }
                    decodeFile.recycle();
                } catch (Throwable th5) {
                    th = th5;
                    bitmap = null;
                    bitmap2 = decodeFile;
                    try {
                        QLog.e(TAG, 1, "saveCoverFromPicList error" + th);
                        System.gc();
                        return str;
                    } finally {
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                        }
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                    }
                }
            }
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
        } catch (Throwable th6) {
            th = th6;
            bitmap = null;
        }
        return str;
    }

    private void uploadByBDH(Intent intent) {
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            doOnProcessFinish(false);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("uploadApngCmshowAvatar", false);
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!booleanExtra) {
            stringExtra = com.tencent.mobileqq.zplan.avatar.upload.a.f331975a.c(stringExtra);
        }
        String str = stringExtra;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "upload error, localPath empty.");
            doOnProcessFinish(false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_UPLOAD_LOCAL_PHOTO, 2, ".uploadPhoto(), img_path = " + str);
        }
        com.tencent.mobileqq.zplan.avatar.upload.a.f331975a.e(appInterface, str, this.mFileType, false, booleanExtra, null);
        ReportController.o(appInterface, "dc00898", "", "", "0X8007C17", "0X8007C17", 3, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarApngProcessor
    public void init(AppInterface appInterface) {
        this.mAppRef = new WeakReference<>(appInterface);
        b bVar = new b(ThreadManagerV2.getQQCommonThreadLooper());
        this.mUploadHandler = bVar;
        bVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        ((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "all")).addHandle(this.mUploadHandler);
    }

    public void onDestroy() {
        AppInterface appInterface = this.mAppRef.get();
        if (this.mUploadHandler == null || appInterface == null) {
            return;
        }
        ((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "all")).removeHandle(this.mUploadHandler);
        FaceUtil.setTempAvatarFilePath(null);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarApngProcessor
    public void process(final int i3, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarApngProcessorImpl.1
            @Override // java.lang.Runnable
            public void run() {
                ZPlanAvatarApngProcessorImpl.this.doProcess(i3, z16);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarApngProcessor
    public void setProcessFinishListener(IZPlanAvatarApngProcessor.a aVar) {
        this.mFinishListener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUploadApng() {
        this.mIsUploadingApng = true;
        this.mIsUploadingStatic = false;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarApngProcessorImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AppInterface appInterface = (AppInterface) ZPlanAvatarApngProcessorImpl.this.mAppRef.get();
                if (appInterface == null) {
                    QLog.e(ZPlanAvatarApngProcessorImpl.TAG, 1, "doUploadApng error, app null.");
                    return;
                }
                ZPlanAvatarApngProcessorImpl zPlanAvatarApngProcessorImpl = ZPlanAvatarApngProcessorImpl.this;
                String apngDirPath = zPlanAvatarApngProcessorImpl.getApngDirPath(zPlanAvatarApngProcessorImpl.mPortraitId);
                if (apngDirPath != null) {
                    ZPlanAvatarApngProcessorImpl.this.mApngDirPath = apngDirPath;
                    FaceUtil.setTempAvatarFilePath(ZPlanAvatarApngProcessorImpl.this.mApngDirPath);
                    QLog.i(ZPlanAvatarApngProcessorImpl.TAG, 1, "apngPath = " + apngDirPath);
                    Intent intent = new Intent();
                    intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", ZPlanAvatarApngProcessorImpl.this.mApngDirPath);
                    intent.putExtra("uploadApngCmshowAvatar", true);
                    intent.putExtra(TagName.FILE_TYPE, 22);
                    ZPlanAvatarApngProcessorImpl zPlanAvatarApngProcessorImpl2 = ZPlanAvatarApngProcessorImpl.this;
                    ProfileCardUtil.a checkBeforeUpload = zPlanAvatarApngProcessorImpl2.checkBeforeUpload((QQAppInterface) appInterface, zPlanAvatarApngProcessorImpl2.mApngDirPath, false);
                    if (checkBeforeUpload.f306431b == FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS && checkBeforeUpload.f306430a == 0) {
                        ZPlanAvatarApngProcessorImpl.this.startUpload(intent);
                        return;
                    } else {
                        QLog.e(ZPlanAvatarApngProcessorImpl.TAG, 1, "check before upload apng error.");
                        ZPlanAvatarApngProcessorImpl.this.doOnProcessFinish(false);
                        return;
                    }
                }
                QLog.e(ZPlanAvatarApngProcessorImpl.TAG, 1, "exits due to apngDirPath null.");
                ZPlanAvatarApngProcessorImpl.this.doOnProcessFinish(false);
            }
        }, 16, null, true);
    }

    private void doUploadStaticCover() {
        this.mIsUploadingStatic = true;
        this.mIsUploadingApng = false;
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            QLog.e(TAG, 1, "doUploadStatic error, app null.");
            return;
        }
        IZPlanAvatarFileManager iZPlanAvatarFileManager = (IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class);
        int i3 = this.mPortraitId;
        String currentUin = appInterface.getCurrentUin();
        int i16 = this.mResolutionsHigh;
        iZPlanAvatarFileManager.getAllFrameFiles(i3, currentUin, i16, i16, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCoverFramePath(List<String> list) {
        if (list != null && !list.isEmpty()) {
            QLog.d(TAG, 1, "choose cover frame from picList.");
            return list.get(0);
        }
        QLog.e(TAG, 1, "choose cover frame error, picList empty.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinalUploadProcess(FileMsg fileMsg) {
        AvatarHistoryNumProcessor avatarHistoryNumProcessor;
        this.mIsUploadingStatic = false;
        this.mIsUploadingApng = false;
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            QLog.e(TAG, 1, "onFinalUploadProcess error, app null.");
            doOnProcessFinish(false);
            return;
        }
        QLog.i(TAG, 1, "onFinalUploadProcess. photoId = " + ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mPhotoUrl);
        CardHandler cardHandler = (CardHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null) {
            cardHandler.z5(true, appInterface.getCurrentAccountUin(), 0);
        }
        FaceUtil.setTempAvatarFilePath(null);
        if (((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(appInterface.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) (-1))).intValue() != 1) {
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(appInterface.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) 1);
        }
        if (ea.h0(appInterface.getApp(), appInterface.getCurrentAccountUin()) != 2 && (avatarHistoryNumProcessor = (AvatarHistoryNumProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(AvatarHistoryNumProcessor.class, appInterface)) != null) {
            avatarHistoryNumProcessor.a();
        }
        QLog.d(TAG, 1, "avatar upload succeed.");
        doOnProcessFinish(true);
    }

    private void reset() {
        QLog.d(TAG, 1, "start reset.");
        this.mPortraitId = 0;
        this.mActionType = 0;
        this.mApngCoverPath = null;
        this.mApngDirPath = null;
        this.mIsUploadingApng = false;
        this.mIsUploadingStatic = false;
        this.mIsUploading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpload(Intent intent) {
        if (intent == null) {
            return;
        }
        QLog.i(TAG, 1, QZoneJsConstants.METHOD_RECORDER_START_UPLOAD);
        this.mIsUploading = true;
        uploadByBDH(intent);
    }
}
