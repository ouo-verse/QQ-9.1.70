package com.tencent.mobileqq.avatar.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static byte a(byte b16) {
        if (QQTheme.isNowSimpleUI() && !o(b16)) {
            return (byte) 3;
        }
        return b16;
    }

    public static Bitmap b(byte b16, Bitmap bitmap, String str, int i3, int i16) {
        if (bitmap == null) {
            return bitmap;
        }
        switch (b16) {
            case 1:
                return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).genSquareFaceBmpByShape(bitmap);
            case 2:
            default:
                return l(bitmap);
            case 3:
            case 4:
                int f16 = f(i16);
                return e(bitmap, f16, f16);
            case 5:
            case 8:
                return bitmap;
            case 6:
                return a.b(bitmap, str, i3);
            case 7:
                return a.a(bitmap, str, i3);
        }
    }

    public static String c(String str) {
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(FaceConstant.MMKV_KEY_AVATAR_SELF_URL + str, "");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getUserAvatarUrl ");
        sb5.append(str);
        sb5.append(" is not empty:");
        sb5.append(!TextUtils.isEmpty(decodeString));
        QLog.d("AvatarUtil", 1, sb5.toString());
        return decodeString;
    }

    public static String d(String str) {
        StringBuilder sb5 = new StringBuilder(128);
        if (cu.e()) {
            sb5.append(AppConstants.PATH_HEAD_HD);
        } else {
            sb5.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
        }
        sb5.append(MD5.toMD5(MD5.toMD5(MD5.toMD5(str) + str) + str));
        sb5.append(".png");
        return sb5.toString();
    }

    public static Bitmap e(Bitmap bitmap, int i3, int i16) {
        return m(bitmap, -1, i3, i16);
    }

    public static int f(int i3) {
        Resources resources;
        if (!q() || i3 < 100 || (resources = MobileQQ.sMobileQQ.getResources()) == null) {
            return 50;
        }
        float f16 = resources.getDisplayMetrics().density;
        if (f16 <= 0.0f) {
            return 50;
        }
        float f17 = i3 / f16;
        if (f17 <= 50.0f) {
            return 50;
        }
        return Math.round(f17);
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("AvatarUtil", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
            return null;
        }
        int indexOf = str.indexOf("_");
        if (indexOf >= 0 && indexOf <= str.length()) {
            return str.substring(0, indexOf);
        }
        QLog.i("AvatarUtil", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | " + str);
        return null;
    }

    public static String h(int i3, String str, int i16, int i17) {
        String str2 = i3 + "_" + str;
        if (i3 == 32) {
            return "stranger_" + String.valueOf(i16) + "_" + str;
        }
        if (i3 == 16) {
            return "qcall_" + String.valueOf(i16) + "_" + str;
        }
        if (i3 == 116) {
            return "apollo_" + String.valueOf(i17) + "_" + str;
        }
        return str2;
    }

    public static String i(int i3, String str, int i16, int i17, FaceInfo faceInfo) {
        if (faceInfo != null && faceInfo.isEnableZplanOutbound()) {
            return faceInfo.headType + "_zs_out__" + i17 + "_" + faceInfo.uin + "_" + ((int) faceInfo.staticZplanFaceFlag) + "_" + ((int) faceInfo.dynamicZplanFaceFlag) + "_" + faceInfo.zplanFaceBgUrl;
        }
        return h(i3, str, i16, i17);
    }

    public static String j(int i3, String str, int i16) {
        if (i3 == 4) {
            return "troop_" + str;
        }
        if (i3 == 32) {
            return "stranger_" + String.valueOf(i16) + "_" + str;
        }
        if (i3 == 16) {
            return "qcall_" + String.valueOf(i16) + "_" + str;
        }
        if (i3 == 116) {
            return "apollo_" + String.valueOf(i16) + "_" + str;
        }
        return str;
    }

    public static String k(String str) {
        if (str != null && str.length() != 0) {
            return str + "_1001";
        }
        QLog.i("AvatarUtil", 1, "===getPstnDiscussionUin discussionUin is null ===");
        return null;
    }

    public static Bitmap l(Bitmap bitmap) {
        return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getRoundFaceBitmap(bitmap);
    }

    public static Bitmap m(Bitmap bitmap, int i3, int i16, int i17) {
        return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getShapeRoundFaceBitmap(bitmap, i3, i16, i17);
    }

    public static Setting n(String str) {
        Setting avatarInfoSetting = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getAvatarInfoSetting(1, str);
        if (avatarInfoSetting != null) {
            return avatarInfoSetting;
        }
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(FaceConstant.MMKV_KEY_USER_AVATAR_INFO + str, "");
        QLog.i("AvatarUtil", 2, "getUserAvatarSetting jsonStr[" + str + "]: " + decodeString);
        return com.tencent.mobileqq.proavatar.utils.e.a(decodeString);
    }

    private static boolean o(byte b16) {
        if (b16 != 4 && b16 != 5 && b16 != 8 && b16 != 7 && b16 != 6) {
            return false;
        }
        return true;
    }

    public static boolean p(String str) {
        if (str != null && str.length() != 0) {
            return str.contains("_1001");
        }
        QLog.i("AvatarUtil", 1, "===isPstnDiscussionUin discussionUin is null ===");
        return false;
    }

    public static boolean q() {
        AppRuntime peekAppRuntime;
        if (!((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        return ((IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).isSupportDecodeHeadSize();
    }

    public static void r(String str) {
        File externalFilesDir;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = AppConstants.PATH_CUSTOM_HEAD_ROOT;
        if (!str.startsWith(str2) || (externalFilesDir = MobileQQ.sMobileQQ.getExternalFilesDir(null)) == null) {
            return;
        }
        String replaceFirst = str.replaceFirst(str2, externalFilesDir.getAbsolutePath() + "/Tencent/MobileQQ/" + AppConstants.PATH_CUSTOM_HEAD);
        File file = new File(replaceFirst);
        if (file.exists() && file.length() > 0) {
            System.currentTimeMillis();
            try {
                if (new File(str).exists()) {
                    FileUtils.deleteFile(file);
                } else {
                    FileUtils.quickMove(replaceFirst, str);
                }
            } catch (Throwable th5) {
                QLog.e("AvatarUtil", 1, "migrateOldStorageFile ", th5);
            }
        }
    }

    public static void s(String str, String str2) {
        AppRuntime peekAppRuntime;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && str.equals(peekAppRuntime.getCurrentUin())) {
            u(str, str2 + "140&t=" + System.currentTimeMillis());
        }
    }

    public static void t(AppRuntime appRuntime, Setting setting) {
        String str;
        if (appRuntime == null || setting == null || (str = setting.uin) == null || str.isEmpty() || !str.equals(appRuntime.getCurrentUin())) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        String str2 = FaceConstant.MMKV_KEY_USER_AVATAR_INFO + str;
        JSONObject b16 = com.tencent.mobileqq.proavatar.utils.e.b(setting);
        QLog.i("AvatarUtil", 2, "saveUserAvatarSetting: " + b16);
        if (b16 != null) {
            from.encodeString(str2, b16.toString());
        }
    }

    public static void u(String str, String str2) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString(FaceConstant.MMKV_KEY_AVATAR_SELF_URL + str, str2);
    }
}
