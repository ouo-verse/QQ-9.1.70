package com.tencent.mobileqq.app.face.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.ProfileImgDownloader;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String IMG_CACHE = "cache";
    public static final String IMG_TEMP = "temp";
    public static final String PORTRAIT_BACKGROUND = "background";
    public static final String PORTRAIT_FHDAVATAR = "FHDAvatar";
    public static final String PORTRAIT_HDAVATAR = "HDAvatar";
    public static final String PORTRAIT_VOICE = "voice";
    private static final String SAVE_QQHEAD_TO_APP_STORAGE = "save_qqhead_to_app_storage";
    public static final String TAG = "FaceUtil";
    public static final String TOP_PORTRAIT_PATH;
    private static boolean isUploadingAvatar;
    private static boolean sIsUploadingZplanAvatar;
    private static String sLastUploadingAvatar;
    private static long sStartUploadZplanAvatarTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37752);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TOP_PORTRAIT_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "portrait/");
        sLastUploadingAvatar = null;
        isUploadingAvatar = false;
        sIsUploadingZplanAvatar = false;
        sStartUploadZplanAvatarTime = 0L;
    }

    public FaceUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean clearFHDAvatar(String str) {
        try {
            File file = new File(getFHDAvatarPath(str));
            if (!file.exists()) {
                return false;
            }
            return file.delete();
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(TAG, 2, "clearFHDAvatar " + e16.toString());
            return false;
        }
    }

    public static boolean clearHDAvatar(String str) {
        try {
            File file = new File(getHDAvatarPath(str));
            if (!file.exists()) {
                return false;
            }
            return file.delete();
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(TAG, 2, e16.toString());
            return false;
        }
    }

    public static String getAvatarCacheNewPath(String str) {
        StringBuilder sb5 = new StringBuilder();
        String md5 = MD5.toMD5(MD5.toMD5(MD5.toMD5(str)));
        sb5.append(TOP_PORTRAIT_PATH);
        sb5.append("cache");
        sb5.append("/");
        sb5.append(md5);
        sb5.append("_new");
        sb5.append(".jpg");
        return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
    }

    public static String getAvatarCacheOldPath(String str) {
        StringBuilder sb5 = new StringBuilder();
        String md5 = MD5.toMD5(MD5.toMD5(MD5.toMD5(str)));
        sb5.append(TOP_PORTRAIT_PATH);
        sb5.append("cache");
        sb5.append("/");
        sb5.append(md5);
        sb5.append("_old");
        sb5.append(".jpg");
        return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
    }

    public static int getAvatarLengthOfEdge(int i3, int i16) {
        return Math.min(1080, Math.min(i3, i16) - 10);
    }

    public static String getFHDAvatarPath(String str) {
        StringBuilder sb5 = new StringBuilder();
        String md5 = MD5.toMD5(MD5.toMD5(MD5.toMD5(str)));
        sb5.append(TOP_PORTRAIT_PATH);
        sb5.append(PORTRAIT_FHDAVATAR);
        sb5.append("/");
        sb5.append(md5);
        sb5.append(".jpg");
        return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
    }

    public static String getHDAvatarPath(String str) {
        StringBuilder sb5 = new StringBuilder();
        String md5 = MD5.toMD5(MD5.toMD5(MD5.toMD5(str)));
        sb5.append(TOP_PORTRAIT_PATH);
        sb5.append(PORTRAIT_HDAVATAR);
        sb5.append("/");
        sb5.append(md5);
        sb5.append(".jpg");
        return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
    }

    public static String getTempAvatarFilePath() {
        return sLastUploadingAvatar;
    }

    public static String getUploadAvatarTempPath() {
        return VFSAssistantUtils.getSDKPrivatePath(TOP_PORTRAIT_PATH + IMG_TEMP + "/" + System.currentTimeMillis() + "_portrait.tmp");
    }

    public static void initAvatarUploadState() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initAvatarUploadState");
        }
        isUploadingAvatar = false;
        sLastUploadingAvatar = null;
    }

    public static boolean isSavedQQHeadToStorage(Context context) {
        return context.getSharedPreferences("mobileQQ", 0).getBoolean(SAVE_QQHEAD_TO_APP_STORAGE, false);
    }

    public static boolean isUploadingAvatar() {
        return isUploadingAvatar;
    }

    public static boolean isUploadingZplanAvatar() {
        return sIsUploadingZplanAvatar;
    }

    public static void removeAvatarFromCache(AppRuntime appRuntime, String str) {
        try {
            ((IQQAvatarDataService) appRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(new URL(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_THUMB, (String) null, ((IQQAvatarDataService) appRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(false, str)).toString());
            ((IQQAvatarDataService) appRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(new URL(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_BIG, (String) null, getHDAvatarPath(str)).toString());
            ((IQQAvatarDataService) appRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(new URL(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_BIG_FHD, (String) null, getFHDAvatarPath(str)).toString());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "", e16);
            }
        }
    }

    public static void saveStoreQQHeadToApp(Context context, boolean z16) {
        context.getSharedPreferences("mobileQQ", 0).edit().putBoolean(SAVE_QQHEAD_TO_APP_STORAGE, z16).commit();
    }

    public static void setTempAvatarFilePath(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("setTempAvatarFilePath filePath=%s", str));
        }
        if (TextUtils.isEmpty(str)) {
            isUploadingAvatar = false;
        } else {
            sLastUploadingAvatar = str;
            isUploadingAvatar = true;
        }
    }

    public static void setUploadZplanFinish(boolean z16) {
        sIsUploadingZplanAvatar = false;
        QLog.d(TAG, 2, "setUploadZplanFinish success? " + z16);
        if (!z16) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.face.util.FaceUtil.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    QLog.d(FaceUtil.TAG, 2, "setUploadZplanFinish start job");
                    FaceInfo faceInfo = new FaceInfo(1, peekAppRuntime.getCurrentUin(), false, (byte) 0, 3, false, 200, 0, false);
                    faceInfo.faceFileType = (byte) 0;
                    faceInfo.setEnableZplanOutbound(true);
                    ((IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).removeFaceFileCache(faceInfo);
                    IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) peekAppRuntime.getRuntimeService(IQQAvatarHandlerService.class, "");
                    if (iQQAvatarHandlerService != null) {
                        iQQAvatarHandlerService.getCustomHead(faceInfo);
                    }
                }
            }
        }, 64, null, false);
    }

    public static void startUploadZplanAvatar() {
        sIsUploadingZplanAvatar = true;
        sStartUploadZplanAvatarTime = System.currentTimeMillis();
    }
}
