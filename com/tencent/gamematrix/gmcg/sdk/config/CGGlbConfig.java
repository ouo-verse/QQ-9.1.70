package com.tencent.gamematrix.gmcg.sdk.config;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.base.helper.CGPersistHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGGlbConfig {
    private static final String KEY_PERSIST_GMCG_APP_APPLICATONID = ".key.persist.gmcg.app.applicationid";
    private static final String KEY_PERSIST_GMCG_APP_BIZNO = ".key.persist.gmcg.app.bizno";
    private static final String KEY_PERSIST_GMCG_APP_BOARD = ".key.persist.gmcg.app.board";
    private static final String KEY_PERSIST_GMCG_APP_BRAND = ".key.persist.gmcg.app.brand";
    private static final String KEY_PERSIST_GMCG_APP_CHANNEL = ".key.persist.gmcg.app.channel";
    private static final String KEY_PERSIST_GMCG_APP_HARDWARE = ".key.persist.gmcg.app.hardware";
    private static final String KEY_PERSIST_GMCG_APP_MODEL = ".key.persist.gmcg.app.model";
    private static final String KEY_PERSIST_GMCG_APP_SOC = ".key.persist.gmcg.app.soc";
    private static final String KEY_PERSIST_GMCG_CODECS_HW = ".key.persist.gmcg.codecs.hw";
    private static final String KEY_PERSIST_GMCG_TOKEN = ".key.persist.gmcg.token";
    private static final String KEY_PERSIST_SDK_LOGIN_INFO = ".key.persist.sdk.login.info";
    private static String sAndroidId;
    private static String sAppBizInfo;
    private static String sAppBizNo;
    private static String sAppChannel;
    private static Context sAppContext;
    private static String sBuildBoard;
    private static String sBuildBrand;
    private static String sBuildHardware;
    private static String sBuildManufacturer;
    private static String sBuildModel;
    private static String sGmCgToken;
    private static String sIMEI;
    private static String sOAID;
    private static String sPackageName;
    private static String sQIMEI;
    private static String sQIMEI36;
    private static Map<String, String> sServerMapping;
    private static String sSoc;
    public static CGUserDeviceInfo sUserDeviceInfo;
    private static String sXID;

    @NonNull
    private static CGSdkLoginInfo sSdkLoginInfo = new CGSdkLoginInfo();
    private static boolean sForceHwDec = false;
    public static boolean sDebugEnabled = false;
    public static boolean sUseDebugAlloc = false;
    public static boolean sIsForTV = false;
    public static boolean sEnableCgSSO = false;
    public static boolean sEnableSuperResolution = true;
    public static boolean sForceFsr = false;
    public static long THRESHOLD_IME_ANTI_FLASH = 200;
    public static boolean sEnableImeAntiFlash = true;

    private static void checkSdkLoginInfo() {
        if (!sSdkLoginInfo.isValid()) {
            String kVasString = CGPersistHelper.getKVasString(KEY_PERSIST_SDK_LOGIN_INFO, "");
            if (CGStringUtil.notEmpty(kVasString)) {
                sSdkLoginInfo = CGSdkLoginInfo.fromJsonString(kVasString);
            }
        }
    }

    public static void enableCgSSO(boolean z16) {
        sEnableCgSSO = z16;
    }

    public static void enableImeAntiFlash(boolean z16) {
        enableImeAntiFlash(z16, 100L);
    }

    public static void forceHwDec(boolean z16) {
        sForceHwDec = z16;
        CGPersistHelper.putKVasBoolean(KEY_PERSIST_GMCG_CODECS_HW, z16);
    }

    public static String geAppBizInfo() {
        if (CGStringUtil.isEmpty(sAppBizInfo)) {
            sAppBizInfo = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_APP_APPLICATONID, "");
        }
        return sAppBizInfo;
    }

    public static String getAndroidId() {
        return sAndroidId;
    }

    public static String getAppBizNo() {
        if (CGStringUtil.isEmpty(sAppBizNo)) {
            sAppBizNo = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_APP_BIZNO, "");
        }
        return sAppBizNo;
    }

    public static String getAppChannel() {
        if (CGStringUtil.isEmpty(sAppChannel)) {
            sAppChannel = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_APP_CHANNEL, "");
        }
        return sAppChannel;
    }

    public static Context getAppContext() {
        Context context = sAppContext;
        if (context == null) {
            return CGAppUtil.getApplicationByReflection();
        }
        return context;
    }

    public static String getBizId() {
        checkSdkLoginInfo();
        return sSdkLoginInfo.pBizId;
    }

    public static String getBuildBoard() {
        if (TextUtils.isEmpty(sBuildBoard)) {
            String kVasString = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_APP_BOARD, "");
            sBuildBoard = kVasString;
            if (TextUtils.isEmpty(kVasString)) {
                sBuildBoard = CGSystemUtil.getSysProperty(Build.BOARD, "");
            }
        }
        return sBuildBoard;
    }

    public static String getBuildBrand() {
        if (CGStringUtil.isEmpty(sBuildBrand)) {
            sBuildBrand = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_APP_BRAND, "");
        }
        return sBuildBrand;
    }

    public static String getBuildHardware() {
        if (CGStringUtil.isEmpty(sBuildHardware)) {
            sBuildHardware = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_APP_HARDWARE, "");
        }
        return sBuildHardware;
    }

    public static String getBuildManufacturer() {
        return sBuildManufacturer;
    }

    public static String getBuildModel() {
        if (CGStringUtil.isEmpty(sBuildModel)) {
            sBuildModel = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_APP_MODEL, "");
        }
        return sBuildModel;
    }

    public static String getGmCgToken() {
        if (CGStringUtil.isEmpty(sGmCgToken)) {
            sGmCgToken = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_TOKEN, "");
        }
        return sGmCgToken;
    }

    public static String getIMEI() {
        return sIMEI;
    }

    public static CGUserDeviceInfo getLocalUserDeviceInfo() {
        CGUserDeviceInfo cGUserDeviceInfo = sUserDeviceInfo;
        if (cGUserDeviceInfo == null || cGUserDeviceInfo.isValid()) {
            sUserDeviceInfo = CGUserDeviceInfo.create();
        }
        return sUserDeviceInfo;
    }

    public static String getOAID() {
        return sOAID;
    }

    public static String getPackageName() {
        try {
            if (sPackageName == null) {
                sPackageName = getAppContext().getPackageName();
            }
            return sPackageName;
        } catch (Exception e16) {
            CGLog.e("getPackageName failed: " + e16);
            return "";
        }
    }

    public static String getQIMEI() {
        return sQIMEI;
    }

    public static String getQIMEI36() {
        return sQIMEI36;
    }

    @NonNull
    public static Map<String, String> getServerMapping() {
        Map<String, String> map = sServerMapping;
        if (map != null) {
            return map;
        }
        return new HashMap();
    }

    public static int getServerType() {
        checkSdkLoginInfo();
        return sSdkLoginInfo.pServerEnvType;
    }

    public static String getSoc() {
        if (TextUtils.isEmpty(sSoc)) {
            String kVasString = CGPersistHelper.getKVasString(KEY_PERSIST_GMCG_APP_SOC, "");
            sSoc = kVasString;
            if (TextUtils.isEmpty(kVasString)) {
                String sysProperty = CGSystemUtil.getSysProperty("ro.board.platform", getBuildBoard());
                sSoc = sysProperty;
                CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_APP_SOC, sysProperty);
            }
        }
        return sSoc;
    }

    public static String getUserId() {
        checkSdkLoginInfo();
        return sSdkLoginInfo.pUserId;
    }

    public static String getUserKey() {
        checkSdkLoginInfo();
        return sSdkLoginInfo.pUserKey;
    }

    public static String getXID() {
        return sXID;
    }

    public static boolean hasServerMapping() {
        Map<String, String> map = sServerMapping;
        if (map != null && !map.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isCgSSOEnabled() {
        return sEnableCgSSO;
    }

    public static boolean isForTV() {
        return sIsForTV;
    }

    public static boolean isForceHwDec() {
        return CGPersistHelper.getKVasBoolean(KEY_PERSIST_GMCG_CODECS_HW, false);
    }

    public static void setAppBizInfo(@NonNull String str) {
        sAppBizInfo = str;
        CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_APP_APPLICATONID, str);
    }

    public static void setAppBizNo(@NonNull String str) {
        sAppBizNo = str;
        CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_APP_BIZNO, str);
    }

    public static void setAppChannel(@NonNull String str) {
        sAppChannel = str;
        CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_APP_CHANNEL, str);
    }

    public static void setAppContext(Context context) {
        sAppContext = context;
        if (context != null) {
            try {
                sPackageName = context.getPackageName();
            } catch (Exception e16) {
                CGLog.e("setAppContext getPackageName failed: " + e16);
            }
        }
    }

    public static void setForTV(boolean z16) {
        sIsForTV = z16;
    }

    public static void setGmCgToken(String str) {
        if (str != null) {
            sGmCgToken = str;
            CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_TOKEN, str);
        }
    }

    public static void setLoginInfo(String str, String str2, String str3, int i3) {
        CGSdkLoginInfo cGSdkLoginInfo = sSdkLoginInfo;
        cGSdkLoginInfo.pBizId = str;
        cGSdkLoginInfo.pUserId = str2;
        cGSdkLoginInfo.pUserKey = str3;
        cGSdkLoginInfo.pServerEnvType = i3;
        CGPersistHelper.putKVasString(KEY_PERSIST_SDK_LOGIN_INFO, cGSdkLoginInfo.toJsonString());
    }

    public static void setPrivacyDeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        sIMEI = str;
        sAndroidId = str2;
        sBuildModel = str7;
        sBuildBrand = str8;
        sBuildManufacturer = str9;
        sBuildHardware = str10;
        sBuildBoard = str11;
        sXID = str3;
        sOAID = str4;
        if (CGStringUtil.notEmpty(str7)) {
            CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_APP_MODEL, sBuildModel);
        }
        if (CGStringUtil.notEmpty(sBuildBrand)) {
            CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_APP_BRAND, sBuildBrand);
        }
        if (CGStringUtil.notEmpty(sBuildHardware)) {
            CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_APP_HARDWARE, sBuildHardware);
        }
        if (CGStringUtil.notEmpty(sBuildBoard)) {
            CGPersistHelper.putKVasString(KEY_PERSIST_GMCG_APP_BOARD, sBuildBoard);
        }
        sQIMEI = str5;
        sQIMEI36 = str6;
    }

    public static void setServerMapping(Map<String, String> map) {
        sServerMapping = map;
    }

    public static void enableImeAntiFlash(boolean z16, long j3) {
        sEnableImeAntiFlash = z16;
        THRESHOLD_IME_ANTI_FLASH = j3;
    }
}
