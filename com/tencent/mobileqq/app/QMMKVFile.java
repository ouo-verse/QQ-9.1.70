package com.tencent.mobileqq.app;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.tencent.mobileqq.app.bb;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVCacheReceiver;
import com.tencent.mobileqq.qmmkv.QMMKVHandler;
import com.tencent.mobileqq.qmmkv.v2.MMKVMemoryCache;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EstablishSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class QMMKVFile extends QMMKVHandler implements com.tencent.mmkv.c {
    static IPatchRedirector $redirector_ = null;
    public static final String FILE_ABTEST = "mmkv_abtest_controller_for_all";
    public static final String FILE_AD = "ad_mmkv_configurations";
    public static final String FILE_ADELIE = "qq_adelie";
    public static final String FILE_BUGLY = "BuglySdkInfos";
    public static final String FILE_CHAT_FIRST_CACHE = "q_chat_item_mmkv_file";
    public static final String FILE_COMMON = "common_mmkv_configurations";
    public static final String FILE_DOV = "dov_mmkv_configurations";
    public static final String FILE_GUILD = "guild_mmkv_configurations";
    public static final String FILE_HOMEWORK = "homework_mmkv_configurations";
    public static final String FILE_ICGAME = "icgame_mmkv_configurations";
    public static final String FILE_JSAPI = "jsapi_mmkv_file";
    public static final String FILE_KANDIAN = "kandian_mmkv_configurations";
    public static final String FILE_MINI_APP = "mini_app_mmkv_file";
    public static final String FILE_MINI_GAME = "mini_game_mmkv_file";
    public static final String FILE_MSF = "msf_mmkv_file";
    public static final String FILE_NEARBYPRO = "nearbypro_mmkv_configurations";
    public static final String FILE_PANDORA_CONFIG = "PandoraExConfig";
    public static final String FILE_PANDORA_PERMISSION = "PandoraPermission";
    public static final String FILE_QAV = "qav_mmkv_configurations";
    public static final String FILE_QCIRCLE = "qcircle_mmkv_configurations";
    public static final String FILE_QCIRCLE_COMMON = "QCIRCLE_MMKV_COMMON";
    public static final String FILE_QQLIVE = "qqlive_mmkv_configurations";
    public static final String FILE_QQVIP = "qqvip_mmkv_configurations";
    public static final String FILE_QQ_FILE = "qq_file";
    public static final String FILE_QSEC = "qsec_mmkv_configurations";
    public static final String FILE_QWALLET = "qwallet_mmkv_configurations";
    public static final String FILE_QZONE = "qzone_mmkv_configurations";
    public static final String FILE_QZONE_COMMON = "qzone_common_mmkv_configurations";
    public static final String FILE_SEARCH = "search_mmkv_configurations";
    public static final String FILE_SPRING_HB = "spring_hb_2024_mmkv_configurations";
    public static final String FILE_STUDYMODE = "qq_study";
    public static final String FILE_TIAN_SHU = "tianshu_mmkv_configurations";
    public static final String FILE_TROOP = "troop_mmkv_configurations";
    public static final String FILE_TUX = "tux_mmkv_configurations";
    public static final String FILE_UIN_UID_MAP = "qq_uin_uid_map";
    public static final String FILE_UNITED_CONFIG = "united_config_mmkv";

    @Deprecated
    public static final String FILE_VAS = "vas_mmkv_configurations";
    public static final String FILE_WEB = "web_mmkv_file";
    public static final String FILE_WTLOGIN = "wtlogin_mmkv_file";
    public static final String FILE_ZPLAN = "zplan_mmkv_configurations";
    public static final String FILE_ZPLAN_REPORT = "zplan_report";
    public static final String PREFIX_1 = "QCCTime";
    public static final String PREFIX_2 = "c_profile_sharepreference";
    public static final String PREFIX_3 = "sp_qqcirlce_";
    public static final String SUFFIX_1 = "config_manager_mmkv_configurations";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_MMKV.yml", version = 1)
    private static bb.a sMMKVOperationCallback;
    private static ArrayList sMMKVOperationCallback_AutoGenClazzList_QAutoInjectTransform;
    private MMKVMemoryCache cache;
    private MMKVCacheReceiver mmkvCacheReceiver;
    private final Map<String, Integer> registeredFileList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sMMKVOperationCallback_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.qmmkv.y.class);
        initQAutoInject();
    }

    public QMMKVFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        this.registeredFileList = hashMap;
        hashMap.put("common_mmkv_configurations", 65538);
        hashMap.put(FILE_ABTEST, 131074);
        hashMap.put(FILE_QCIRCLE, 131074);
        hashMap.put("QCIRCLE_MMKV_COMMON", 131074);
        hashMap.put(FILE_ZPLAN, 262146);
        hashMap.put(FILE_GUILD, 131074);
        hashMap.put(FILE_KANDIAN, 524290);
        hashMap.put(FILE_TROOP, 131074);
        hashMap.put(FILE_SEARCH, 131074);
        hashMap.put(FILE_QWALLET, 262146);
        hashMap.put("vas_mmkv_configurations", 65538);
        hashMap.put(FILE_QAV, 262146);
        hashMap.put(FILE_WEB, 262146);
        hashMap.put(FILE_JSAPI, 524290);
        hashMap.put(FILE_HOMEWORK, 262146);
        hashMap.put(FILE_QZONE, 131074);
        hashMap.put(FILE_QZONE_COMMON, 131074);
        hashMap.put(FILE_QQLIVE, 262146);
        hashMap.put("BuglySdkInfos", 524290);
        hashMap.put(FILE_PANDORA_PERMISSION, 524290);
        hashMap.put(FILE_UNITED_CONFIG, 262146);
        hashMap.put(FILE_ICGAME, 524290);
        hashMap.put(PREFIX_1, 524290);
        hashMap.put(PREFIX_2, 262146);
        hashMap.put(PREFIX_3, 262146);
        hashMap.put(SUFFIX_1, 524290);
        hashMap.put(FILE_QQVIP, 131074);
        hashMap.put(FILE_DOV, 262146);
        hashMap.put(FILE_TIAN_SHU, 524290);
        hashMap.put("msf_mmkv_file", 131074);
        hashMap.put(FILE_AD, 262146);
        hashMap.put(FILE_CHAT_FIRST_CACHE, 131074);
        hashMap.put(FILE_WTLOGIN, 524290);
        hashMap.put(FILE_MINI_APP, 131074);
        hashMap.put(FILE_MINI_GAME, 131074);
        hashMap.put(FILE_NEARBYPRO, 262146);
        hashMap.put(FILE_QQ_FILE, 262146);
        hashMap.put(FILE_UIN_UID_MAP, 131074);
        hashMap.put("qsec_mmkv_configurations", 524290);
        hashMap.put(FILE_TUX, 524290);
        hashMap.put(FILE_ADELIE, 131074);
        hashMap.put(FILE_STUDYMODE, 131074);
    }

    public static String getKeyWithUin(String str, String str2) {
        String str3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str3 = peekAppRuntime.getCurrentUin();
        } else {
            str3 = "";
        }
        return str + "_" + str3 + "_" + str2;
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sMMKVOperationCallback = (bb.a) com.tencent.mobileqq.qroute.utils.b.a(sMMKVOperationCallback_AutoGenClazzList_QAutoInjectTransform);
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public boolean isFileAvailable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        boolean containsKey = this.registeredFileList.containsKey(str);
        if (!containsKey && !TextUtils.isEmpty(str)) {
            Iterator<Map.Entry<String, Integer>> it = this.registeredFileList.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (str.startsWith(key) || str.endsWith(key)) {
                    containsKey = true;
                    break;
                }
            }
        }
        if (!containsKey && EstablishSetting.isDebugVersion()) {
            logError("QMMKVFile", "mmkvFileNotRegisterException: " + str);
        }
        return containsKey;
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public void logDebug(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else if (QLog.isDevelopLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public void logError(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        } else {
            QLog.e(str, 1, str2);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public void logInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else if (QLog.isDevelopLevel()) {
            QLog.i(str, 1, str2);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public void logWarn(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else {
            QLog.w(str, 1, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    @Override // com.tencent.mmkv.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean modeCheck(String str, int i3) {
        int i16;
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, i3)).booleanValue();
        }
        Integer num = this.registeredFileList.get(str);
        if (num != null) {
            intValue = num.intValue();
        } else {
            for (Map.Entry<String, Integer> entry : this.registeredFileList.entrySet()) {
                String key = entry.getKey();
                if (str.startsWith(key) || str.endsWith(key)) {
                    intValue = entry.getValue().intValue();
                }
            }
            i16 = -1;
            if (i16 != -1) {
                QLog.w("QMMKVFile", 1, "modeCheck: / [" + str + "] = " + i3);
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QMMKVFile", 2, "modeCheck: [" + str + "] = " + i3, " defMode=" + i16);
            }
            if (i16 != i3) {
                QLog.e("QMMKVFile", 1, "Using the wrong mmkv mode [" + str + "] = " + i3 + ", but defMode is " + i16, new RuntimeException());
            }
            return true;
        }
        i16 = intValue & 65535;
        if (i16 != -1) {
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mmkv.a
    public void onContentChangedByOuterProcess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        logInfo("QMMKVHandler", "onContentChangedOuter:" + str);
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mobileqq.qmmkv.j
    public void onDecode(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        bb.a aVar = sMMKVOperationCallback;
        if (aVar != null) {
            aVar.onDecode(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mobileqq.qmmkv.j
    public <T> void onEncode(String str, String str2, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, t16);
            return;
        }
        bb.a aVar = sMMKVOperationCallback;
        if (aVar != null) {
            aVar.onEncode(str, str2, t16);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mmkv.b
    public MMKVRecoverStrategic onMMKVCRCCheckFail(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MMKVRecoverStrategic) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        logError("QMMKVHandler", "onMMKVCRCCheckFail:" + str);
        bb.a aVar = sMMKVOperationCallback;
        if (aVar != null) {
            aVar.onMMKVCRCCheckFail(str);
        }
        return super.onMMKVCRCCheckFail(str);
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mmkv.b
    public MMKVRecoverStrategic onMMKVFileLengthError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MMKVRecoverStrategic) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        logError("QMMKVHandler", "onMMKVFileLengthError:" + str);
        bb.a aVar = sMMKVOperationCallback;
        if (aVar != null) {
            aVar.onMMKVFileLengthError(str);
        }
        return super.onMMKVFileLengthError(str);
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mobileqq.qmmkv.j
    public void onSync(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16));
            return;
        }
        bb.a aVar = sMMKVOperationCallback;
        if (aVar != null) {
            aVar.onSync(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.QMMKVHandler, com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    @NonNull
    public com.tencent.mobileqq.qmmkv.v2.k provideMemoryCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.qmmkv.v2.k) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.cache == null) {
            synchronized (this) {
                if (this.cache == null) {
                    MMKVMemoryCache mMKVMemoryCache = new MMKVMemoryCache(new HashMap(this.registeredFileList), null);
                    this.cache = mMKVMemoryCache;
                    this.mmkvCacheReceiver = new MMKVCacheReceiver(mMKVMemoryCache);
                }
            }
        }
        return this.cache;
    }

    @Override // com.tencent.mmkv.c
    public boolean wantModeCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return QLog.isColorLevel();
    }
}
