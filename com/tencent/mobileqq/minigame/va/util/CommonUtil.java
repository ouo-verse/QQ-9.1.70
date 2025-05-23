package com.tencent.mobileqq.minigame.va.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.util.AppSetting;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CommonUtil {
    private static final String FEN_SHEN_APP_DATA_PATH_PREFIX = "/user/999/";
    private static final String META_DREAM_DEBUG_DEEPLINK_TRUE = "letsgo://ymzx?isFromDeeplink=true";
    public static final String MINI_GAME_VA_PREFIX_TAG = "MiniGameVA";
    private static final String MMKV_KEY_DEBUG_DISABLE_VA_INTERCEPT = "debugDisableVaIntercept";
    private static final String TAG = "InterceptUtil";

    public static String appendDebugScheme(String str) {
        if (AppSetting.isPublicVersion()) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            str = META_DREAM_DEBUG_DEEPLINK_TRUE;
        }
        String decodeString = QMMKV.fromV2(BaseApplication.getContext(), QMMKVFile.FILE_MINI_GAME).decodeString(MiniGameVAMMKVKEY.VA_APPEND_DEEP_LINK, "");
        if (TextUtils.isEmpty(decodeString)) {
            return str;
        }
        return str + decodeString;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDeepLinkFromData(String str) {
        int i3;
        int i16;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return appendDebugScheme(null);
        }
        String str2 = "";
        try {
            jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("jumpType");
            try {
                i16 = jSONObject.optInt("jumpId");
            } catch (JSONException e16) {
                e = e16;
                i16 = 0;
            }
        } catch (JSONException e17) {
            e = e17;
            i3 = 0;
            i16 = 0;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("jumpParams");
            if (optJSONObject != null) {
                str2 = optJSONObject.toString();
            }
        } catch (JSONException e18) {
            e = e18;
            QLog.e(TAG, 1, e, new Object[0]);
            if (i3 != 0) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            return appendDebugScheme("letsgo://ymzx?isFromDeeplink=true&jumpType=" + i3 + "&jumpId=" + i16 + "&jumpParams=" + str2);
        }
        if (i3 != 0 && i16 == 0 && TextUtils.isEmpty(str2)) {
            return appendDebugScheme(null);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                str2 = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e19) {
                QLog.e(TAG, 1, e19, new Object[0]);
            }
        }
        return appendDebugScheme("letsgo://ymzx?isFromDeeplink=true&jumpType=" + i3 + "&jumpId=" + i16 + "&jumpParams=" + str2);
    }

    public static MiniGameVAInterceptConfig.VAInterceptConfig getVAAppConfig(String str) {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null) {
            return miniGameVAInterceptConfig.getInterceptConfigMap().get(str);
        }
        return null;
    }

    public static boolean isFenShenApp(Context context) {
        File filesDir = context.getApplicationContext().getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath().contains(FEN_SHEN_APP_DATA_PATH_PREFIX);
        }
        return false;
    }

    public static boolean isLocalInterceptDisable() {
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP).decodeBool(MMKV_KEY_DEBUG_DISABLE_VA_INTERCEPT, false);
        QLog.d(TAG, 1, "isInterceptDisable disable:", Boolean.valueOf(decodeBool));
        return decodeBool;
    }

    public static boolean isMountServiceHookFailed() {
        boolean isMountServiceHookFailed = ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isMountServiceHookFailed();
        if (isMountServiceHookFailed) {
            LogUtils.i(TAG, "isMountServiceHookFailed isFailed: true");
        }
        return isMountServiceHookFailed;
    }

    public static int parseIntSafety(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseIntSafety", e16);
            return 0;
        }
    }

    public static void setLocalInterceptDisable(boolean z16) {
        QLog.d(TAG, 1, "setInterceptDisable disable:", Boolean.valueOf(z16));
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP).encodeBool(MMKV_KEY_DEBUG_DISABLE_VA_INTERCEPT, z16);
    }
}
