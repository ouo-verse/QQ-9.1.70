package com.tencent.mobileqq.zplan.avatar.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor;
import com.tencent.mobileqq.zplan.avatar.encoder.ApolloVideoEncoder;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import yg3.a;

/* loaded from: classes35.dex */
public class ZPlanAvatarVideoProcessorImpl implements IZPlanAvatarVideoProcessor {
    private static final String COMPRESS_VIDEO_SUFFIX = "_compress.mp4";
    private static final String PNG_SUFFIX = ".png";
    private static final int[] RESOLUTIONS_DEFAULT = {640, 200, 100};
    private static final int[] RESOLUTIONS_HIGH = {640, 200, 176};
    private static final String SUFFIX = ".mp4";
    private static final String TAG = "[zplan]ZPlanAvatarVideoProcessor";
    private static final int UPLOAD_DELAY = 0;
    private yg3.a apolloResDownloader;
    private int mActionId;
    private int mActionType;
    private WeakReference<AppInterface> mAppRef;
    private IZPlanAvatarVideoProcessor.a mFinishListener;
    private List<String> mPicList;
    private f mUploadHandler;
    private int mUploadKey;
    private String mVideoCoverCallbackPath;
    private String mVideoCoverPath;
    private String mVideoDirPath;
    private String mVideoPathBig;
    private String mVideoPathMedium;
    private String mVideoPathSmall;
    private int mCoverIndex = 0;
    private volatile boolean mIsUploading = false;
    private AvatarType mAvatarType = AvatarType.ZPLAN;
    ApolloVideoEncoder.a mOnEncodeListener = new c();
    private e mOnCompressFinishListener = new d();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public enum AvatarType {
        ZPLAN,
        ZPLAN_URL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements IZPlanAvatarFileManager.a {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager.a
        public void a(boolean z16, List<String> list, int i3) {
            ZPlanAvatarVideoProcessorImpl.this.onGetAllFramesComplete(z16, list, i3);
        }
    }

    /* loaded from: classes35.dex */
    class c implements ApolloVideoEncoder.a {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.encoder.ApolloVideoEncoder.a
        public void a(int i3, String str, int i16, int i17) {
            QLog.i(ZPlanAvatarVideoProcessorImpl.TAG, 1, "onEncodeFinish: " + i3 + ", " + str);
            if (i3 == 0) {
                if (str.endsWith(ZPlanAvatarVideoProcessorImpl.this.getResolution(0) + ".mp4")) {
                    ZPlanAvatarVideoProcessorImpl zPlanAvatarVideoProcessorImpl = ZPlanAvatarVideoProcessorImpl.this;
                    zPlanAvatarVideoProcessorImpl.onVideoFinished(zPlanAvatarVideoProcessorImpl.getResolution(0), str);
                    return;
                }
                if (str.endsWith(ZPlanAvatarVideoProcessorImpl.this.getResolution(1) + ".mp4")) {
                    ZPlanAvatarVideoProcessorImpl zPlanAvatarVideoProcessorImpl2 = ZPlanAvatarVideoProcessorImpl.this;
                    zPlanAvatarVideoProcessorImpl2.onVideoFinished(zPlanAvatarVideoProcessorImpl2.getResolution(1), str);
                    return;
                }
                if (str.endsWith(ZPlanAvatarVideoProcessorImpl.this.getResolution(2) + ".mp4")) {
                    ZPlanAvatarVideoProcessorImpl zPlanAvatarVideoProcessorImpl3 = ZPlanAvatarVideoProcessorImpl.this;
                    zPlanAvatarVideoProcessorImpl3.onVideoFinished(zPlanAvatarVideoProcessorImpl3.getResolution(2), str);
                    return;
                }
                return;
            }
            QLog.i(ZPlanAvatarVideoProcessorImpl.TAG, 1, "onEncodeFinish fail! errno = " + i3);
            if (i3 == 2) {
                AvatarType unused = ZPlanAvatarVideoProcessorImpl.this.mAvatarType;
                AvatarType avatarType = AvatarType.ZPLAN;
            }
            ZPlanAvatarVideoProcessorImpl.this.onProcessFinish(false);
        }
    }

    /* loaded from: classes35.dex */
    class d implements e {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarVideoProcessorImpl.e
        public void a(boolean z16, int i3, String str) {
            if (!z16) {
                if (i3 != ZPlanAvatarVideoProcessorImpl.this.getResolution(1)) {
                    if (i3 == ZPlanAvatarVideoProcessorImpl.this.getResolution(2)) {
                        QLog.i(ZPlanAvatarVideoProcessorImpl.TAG, 1, "onCompressFinish isSuccess: " + z16 + "encodeWithResolution resolution: " + i3);
                        ZPlanAvatarVideoProcessorImpl zPlanAvatarVideoProcessorImpl = ZPlanAvatarVideoProcessorImpl.this;
                        zPlanAvatarVideoProcessorImpl.encodeWithResolution(zPlanAvatarVideoProcessorImpl.getResolution(2));
                        return;
                    }
                    return;
                }
                QLog.i(ZPlanAvatarVideoProcessorImpl.TAG, 1, "onCompressFinish isSuccess: " + z16 + "encodeWithResolution resolution: " + i3);
                ZPlanAvatarVideoProcessorImpl zPlanAvatarVideoProcessorImpl2 = ZPlanAvatarVideoProcessorImpl.this;
                zPlanAvatarVideoProcessorImpl2.encodeWithResolution(zPlanAvatarVideoProcessorImpl2.getResolution(1));
                return;
            }
            QLog.i(ZPlanAvatarVideoProcessorImpl.TAG, 1, "onCompressFinish isSuccess: " + z16);
            ZPlanAvatarVideoProcessorImpl.this.onVideoFinished(i3, str);
        }
    }

    /* loaded from: classes35.dex */
    public interface e {
        void a(boolean z16, int i3, String str);
    }

    /* loaded from: classes35.dex */
    private class f extends TransProcessorHandler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (((AppInterface) ZPlanAvatarVideoProcessorImpl.this.mAppRef.get()) == null || !ZPlanAvatarVideoProcessorImpl.this.mIsUploading) {
                return;
            }
            FileMsg fileMsg = (FileMsg) message.obj;
            QLog.d(ZPlanAvatarVideoProcessorImpl.TAG, 4, "VideoUploadProcessorHandler.handleMessage fileType=" + fileMsg.fileType + ", errorCode=" + fileMsg.errorCode + "\uff0c what=" + message.what);
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
            QLog.e(ZPlanAvatarVideoProcessorImpl.TAG, 1, String.format("handleStatusSendError, errorCode=%s", Integer.valueOf(fileMsg.errorCode)));
            FaceUtil.setTempAvatarFilePath(null);
            ZPlanAvatarVideoProcessorImpl.this.onProcessFinish(false);
        }

        private void b(FileMsg fileMsg) {
            QLog.i(ZPlanAvatarVideoProcessorImpl.TAG, 1, String.format("handleStatusSendFinished, fileType=%s", Integer.valueOf(fileMsg.fileType)));
            int i3 = fileMsg.fileType;
            if (i3 == 36) {
                ZPlanAvatarVideoProcessorImpl.this.uploadVideoMedium();
            } else if (i3 == 37) {
                ZPlanAvatarVideoProcessorImpl.this.uploadVideoSmall();
            } else if (i3 == 38) {
                ZPlanAvatarVideoProcessorImpl.this.uploadVideoCover();
            } else if (i3 == 48) {
                ZPlanAvatarVideoProcessorImpl.this.onFinalUploadProcess(fileMsg);
            }
            FaceUtil.setTempAvatarFilePath(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void compressWithResolution(final String str, final int i3) {
        QLog.i(TAG, 1, "compressWithResolution inputVideoPath: " + str + ", resolution: " + i3);
        final AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            QLog.e(TAG, 1, "compressWithResolution exits due to app null");
        } else if (!TextUtils.isEmpty(this.mVideoDirPath)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarVideoProcessorImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = ZPlanAvatarVideoProcessorImpl.this.mVideoDirPath + File.separator + i3 + ZPlanAvatarVideoProcessorImpl.COMPRESS_VIDEO_SUFFIX;
                    ZPlanAvatarVideoProcessorImpl.this.mOnCompressFinishListener.a(com.tencent.mobileqq.zplan.avatar.encoder.a.a(appInterface.getApplicationContext(), str, str2, i3, true), i3, str2);
                }
            }, 16, null, true);
        } else {
            QLog.e(TAG, 1, "mVideoDirPath is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doProcess(String str, String str2) {
        reset();
        this.mActionId = -1;
        if (this.apolloResDownloader == null) {
            this.apolloResDownloader = com.tencent.mobileqq.zplan.download.a.b();
        }
        String str3 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/zplan/avatar/video/" + MD5Utils.toMD5(str) + ".mp4";
        String str4 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/zplan/avatar/video/" + MD5Utils.toMD5(str2) + ".png";
        HashMap hashMap = new HashMap();
        hashMap.put(str, str3);
        hashMap.put(str2, str4);
        File file = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/zplan/avatar/video/");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.apolloResDownloader.a(this.mAppRef.get(), hashMap, new a(str3, str4));
    }

    private boolean enableEncode() {
        List<String> list = this.mPicList;
        return (list == null || list.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encodeWithResolution(int i3) {
        if (enableEncode() && !TextUtils.isEmpty(this.mVideoDirPath)) {
            getVideoEncoder(this.mVideoDirPath + File.separator + i3 + ".mp4", i3).s();
            return;
        }
        QLog.e(TAG, 1, "mPicList is empty: " + enableEncode() + " mVideoDirPath is empty: " + TextUtils.isEmpty(this.mVideoDirPath));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getResolution(int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            return RESOLUTIONS_HIGH[i3];
        }
        return RESOLUTIONS_DEFAULT[i3];
    }

    private String getVideoDirPath(int i3) {
        String videoFilePath = this.mAvatarType == AvatarType.ZPLAN ? ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).getVideoFilePath(i3) : null;
        if (videoFilePath == null) {
            QLog.e(TAG, 1, "getVideoFilePath is null");
            return null;
        }
        File file = new File(videoFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private ApolloVideoEncoder getVideoEncoder(String str, int i3) {
        ApolloVideoEncoder apolloVideoEncoder;
        if (this.mAvatarType == AvatarType.ZPLAN) {
            apolloVideoEncoder = new com.tencent.mobileqq.zplan.avatar.encoder.b(this.mPicList, str, i3, i3);
            apolloVideoEncoder.q(25);
            apolloVideoEncoder.p((int) (i3 * i3 * getZPlanBitRateRatio()));
        } else {
            apolloVideoEncoder = new ApolloVideoEncoder(this.mPicList, str, i3, i3);
        }
        apolloVideoEncoder.r(this.mOnEncodeListener);
        return apolloVideoEncoder;
    }

    private float getZPlanBitRateRatio() {
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        String f26 = zPlanFeatureSwitch.f2();
        if (!TextUtils.isEmpty(f26) && f26.contains(Build.BRAND)) {
            return zPlanFeatureSwitch.Z1();
        }
        return zPlanFeatureSwitch.Y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinalUploadProcess(FileMsg fileMsg) {
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
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
        onProcessFinish(true);
        this.mIsUploading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetAllFramesComplete(boolean z16, List<String> list, int i3) {
        int i16;
        int i17;
        if (z16 && list != null && !list.isEmpty()) {
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
            if (this.mAvatarType != AvatarType.ZPLAN || (i17 = this.mCoverIndex) < 0) {
                i16 = 0;
            } else if (i17 >= list.size()) {
                i16 = list.size() - 1;
            } else {
                i16 = this.mCoverIndex;
            }
            String str = list.get(i16);
            this.mVideoCoverCallbackPath = str;
            String saveCoverFromPicList = saveCoverFromPicList(str);
            this.mVideoCoverPath = saveCoverFromPicList;
            if (TextUtils.isEmpty(saveCoverFromPicList)) {
                QLog.e(TAG, 1, "saveCoverFromPicList return null, error");
                onProcessFinish(false);
                return;
            }
            String videoDirPath = getVideoDirPath(i3);
            if (videoDirPath == null) {
                QLog.e(TAG, 1, "exits due to videoDirPath null");
                onProcessFinish(false);
                return;
            }
            ArrayList arrayList = new ArrayList();
            this.mPicList = arrayList;
            arrayList.addAll(list);
            this.mVideoDirPath = videoDirPath;
            QLog.i(TAG, 1, "videoPath = " + videoDirPath + ", cover path = " + this.mVideoCoverPath + ", pic list size = " + this.mPicList.size());
            encodeWithResolution(getResolution(0));
            return;
        }
        QLog.e(TAG, 1, "getFrameFilePath pic list is empty");
        onProcessFinish(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
    
        r4 = new java.io.File(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ae, code lost:
    
        if (r4.exists() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b4, code lost:
    
        if (com.tencent.mobileqq.utils.FileUtils.copyFile(r4, r0) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ba, code lost:
    
        return r0.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bb, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarVideoProcessorImpl.TAG, 1, "saveCoverFromPicList copy file fail");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c1, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008c, code lost:
    
        if (r5 != null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String saveCoverFromPicList(String str) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "saveCoverFromPicList error ", str);
            return null;
        }
        QLog.i(TAG, 1, "saveCoverFromPicList " + str);
        File file = new File(getVideoDirPath(this.mActionId), "cover.png");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                try {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, 480, 480, true);
                    if (bitmap2 != null) {
                        try {
                            BaseImageUtil.saveBitmapFileAsPNG(bitmap2, 100, file);
                            if (file.exists() && file.length() > 0) {
                                QLog.i(TAG, 1, "saveCoverFromPicList successfully");
                                String absolutePath = file.getAbsolutePath();
                                bitmap.recycle();
                                bitmap2.recycle();
                                return absolutePath;
                            }
                            bitmap2.recycle();
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                QLog.e(TAG, 1, "saveCoverFromPicList exception ", th);
                                System.gc();
                            } finally {
                                if (bitmap != null) {
                                    bitmap.recycle();
                                }
                                if (bitmap2 != null) {
                                    bitmap2.recycle();
                                }
                            }
                        }
                    }
                    bitmap.recycle();
                } catch (Throwable th6) {
                    th = th6;
                    bitmap2 = null;
                }
            } else {
                bitmap2 = null;
            }
            if (bitmap != null) {
                bitmap.recycle();
            }
        } catch (Throwable th7) {
            th = th7;
            bitmap = null;
            bitmap2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpload() {
        QLog.i(TAG, 1, QZoneJsConstants.METHOD_RECORDER_START_UPLOAD);
        this.mIsUploading = true;
        uploadVideoBig();
    }

    private void uploadVideoBig() {
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            return;
        }
        this.mUploadKey = (int) (System.currentTimeMillis() / 1000);
        if (TextUtils.isEmpty(this.mVideoPathBig)) {
            QLog.e(TAG, 1, "mVideoPathBig is empty: " + this.mVideoPathBig);
            onProcessFinish(false);
            return;
        }
        File file = new File(this.mVideoPathBig);
        if (file.exists() && file.length() > 0) {
            com.tencent.mobileqq.zplan.avatar.encoder.a.h(appInterface, this.mVideoPathBig, 36, this.mUploadKey, 640);
            FaceUtil.setTempAvatarFilePath(this.mVideoPathBig);
            QLog.i(TAG, 1, "uploadVideoBig " + file.length());
            return;
        }
        QLog.e(TAG, 1, "uploadVideoBig file empty: " + this.mVideoPathBig);
        onProcessFinish(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadVideoCover() {
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null || TextUtils.isEmpty(this.mVideoCoverPath)) {
            return;
        }
        File file = new File(this.mVideoCoverPath);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        com.tencent.mobileqq.zplan.avatar.encoder.a.i(appInterface, this.mVideoCoverPath);
        FaceUtil.setTempAvatarFilePath(this.mVideoCoverPath);
        QLog.i(TAG, 1, "uploadVideoCover " + file.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadVideoMedium() {
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mVideoPathMedium)) {
            QLog.e(TAG, 1, "mVideoPathMedium is empty: " + this.mVideoPathMedium);
            onProcessFinish(false);
            return;
        }
        File file = new File(this.mVideoPathMedium);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        com.tencent.mobileqq.zplan.avatar.encoder.a.h(appInterface, this.mVideoPathMedium, 37, this.mUploadKey, 200);
        FaceUtil.setTempAvatarFilePath(this.mVideoPathMedium);
        QLog.i(TAG, 1, "uploadVideoMedium " + file.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadVideoSmall() {
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mVideoPathSmall)) {
            QLog.e(TAG, 1, "mVideoPathSmall is empty: " + this.mVideoPathSmall);
            onProcessFinish(false);
            return;
        }
        File file = new File(this.mVideoPathSmall);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        com.tencent.mobileqq.zplan.avatar.encoder.a.h(appInterface, this.mVideoPathSmall, 38, this.mUploadKey, 100);
        FaceUtil.setTempAvatarFilePath(this.mVideoPathSmall);
        QLog.i(TAG, 1, "uploadVideoSmall " + file.length());
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor
    public void init(AppInterface appInterface) {
        this.mAppRef = new WeakReference<>(appInterface);
        f fVar = new f(ThreadManagerV2.getQQCommonThreadLooper());
        this.mUploadHandler = fVar;
        fVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
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

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor
    public void process(final kf3.a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarVideoProcessorImpl.1
            @Override // java.lang.Runnable
            public void run() {
                kf3.a aVar2 = aVar;
                if (aVar2 instanceof kf3.c) {
                    ZPlanAvatarVideoProcessorImpl.this.mAvatarType = AvatarType.ZPLAN;
                    ZPlanAvatarVideoProcessorImpl.this.doProcess((kf3.c) aVar2);
                    return;
                }
                if (aVar2 instanceof kf3.b) {
                    kf3.b bVar = (kf3.b) aVar2;
                    ZPlanAvatarVideoProcessorImpl.this.mAvatarType = AvatarType.ZPLAN_URL;
                    ZPlanAvatarVideoProcessorImpl.this.doProcess(bVar.f412296b, bVar.f412295a);
                    return;
                }
                new Throwable("use com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl instead");
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor
    public void setProcessFinishListener(IZPlanAvatarVideoProcessor.a aVar) {
        this.mFinishListener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements a.InterfaceC11614a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f331529a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f331530b;

        a(String str, String str2) {
            this.f331529a = str;
            this.f331530b = str2;
        }

        @Override // yg3.a.InterfaceC11614a
        public void a(boolean z16, Map<String, String> map, String str) {
            if (z16) {
                ZPlanAvatarVideoProcessorImpl.this.mVideoDirPath = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/zplan/avatar/video/";
                ZPlanAvatarVideoProcessorImpl.this.mVideoPathBig = this.f331529a;
                ZPlanAvatarVideoProcessorImpl.this.mVideoCoverPath = this.f331530b;
                ZPlanAvatarVideoProcessorImpl zPlanAvatarVideoProcessorImpl = ZPlanAvatarVideoProcessorImpl.this;
                zPlanAvatarVideoProcessorImpl.compressWithResolution(zPlanAvatarVideoProcessorImpl.mVideoPathBig, ZPlanAvatarVideoProcessorImpl.this.getResolution(1));
                return;
            }
            ZPlanAvatarVideoProcessorImpl.this.onProcessFinish(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessFinish(boolean z16) {
        if (z16) {
            QLog.i(TAG, 1, "isSuccess: true mActionId:" + this.mActionId);
        } else {
            QLog.e(TAG, 1, "isSuccess: false mActionId:" + this.mActionId);
        }
        IZPlanAvatarVideoProcessor.a aVar = this.mFinishListener;
        if (aVar != null) {
            aVar.a(z16, this.mActionId, this.mVideoCoverCallbackPath);
        }
        FileUtils.deleteFile(this.mVideoPathBig);
        FileUtils.deleteFile(this.mVideoCoverPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoFinished(int i3, String str) {
        if (i3 == getResolution(0)) {
            this.mVideoPathBig = str;
            if (ZPlanFeatureSwitch.f369852a.l0()) {
                compressWithResolution(this.mVideoPathBig, getResolution(1));
            } else {
                encodeWithResolution(getResolution(1));
            }
        } else if (i3 == getResolution(1)) {
            this.mVideoPathMedium = str;
            if (!ZPlanFeatureSwitch.f369852a.l0() && enableEncode()) {
                encodeWithResolution(getResolution(2));
            } else {
                compressWithResolution(this.mVideoPathBig, getResolution(2));
            }
        } else if (i3 == getResolution(2)) {
            this.mVideoPathSmall = str;
        }
        QLog.i(TAG, 1, "getVideoFinished paths = " + this.mVideoPathBig + ", " + this.mVideoPathMedium + ", " + this.mVideoPathSmall + ", " + this.mVideoCoverPath);
        if (TextUtils.isEmpty(this.mVideoPathBig) || TextUtils.isEmpty(this.mVideoPathMedium) || TextUtils.isEmpty(this.mVideoPathSmall)) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarVideoProcessorImpl.4
            @Override // java.lang.Runnable
            public void run() {
                ZPlanAvatarVideoProcessorImpl.this.startUpload();
            }
        }, 16, null, true, 0L);
    }

    private void reset() {
        this.mActionId = 0;
        this.mActionType = 0;
        this.mCoverIndex = 0;
        this.mUploadKey = 0;
        this.mVideoCoverPath = null;
        this.mVideoCoverCallbackPath = null;
        this.mVideoPathBig = null;
        this.mVideoPathMedium = null;
        this.mVideoPathSmall = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doProcess(kf3.c cVar) {
        reset();
        this.mActionId = cVar.f412297a;
        this.mCoverIndex = cVar.f412298b - 1;
        AppInterface appInterface = this.mAppRef.get();
        if (appInterface == null) {
            QLog.i(TAG, 1, "process exits due to app null");
            return;
        }
        QLog.i(TAG, 1, "process portraitId:" + this.mActionId);
        ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).getAllFrameFiles(this.mActionId, appInterface.getCurrentUin(), getResolution(0), getResolution(0), new b());
    }
}
