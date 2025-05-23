package com.tencent.qqmini.sdk.core.generated;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver1;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver2;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI1;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI2;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.GameActivity2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver3;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver4;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.api.ProcessConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class CustomConfiguration {
    public static final Boolean DEXLOADER_ENABLED;
    public static String DEX_CONFIG;
    public static final Boolean FLUTTER_ENABLED;
    public static final Boolean LOCAL_DEX_ENABLED;
    public static final Map MINI_PROCESS_0;
    public static final Map MINI_PROCESS_1;
    public static final Map MINI_PROCESS_2;
    public static final Map MINI_PROCESS_3;
    public static final Map MINI_PROCESS_4;
    public static final Map MINI_PROCESS_5;
    public static final List MINI_PROCESS_LIST;

    static {
        Boolean bool = Boolean.FALSE;
        FLUTTER_ENABLED = bool;
        DEXLOADER_ENABLED = Boolean.TRUE;
        LOCAL_DEX_ENABLED = bool;
        ArrayList arrayList = new ArrayList();
        MINI_PROCESS_LIST = arrayList;
        HashMap hashMap = new HashMap();
        MINI_PROCESS_0 = hashMap;
        HashMap hashMap2 = new HashMap();
        MINI_PROCESS_1 = hashMap2;
        HashMap hashMap3 = new HashMap();
        MINI_PROCESS_2 = hashMap3;
        HashMap hashMap4 = new HashMap();
        MINI_PROCESS_3 = hashMap4;
        HashMap hashMap5 = new HashMap();
        MINI_PROCESS_4 = hashMap5;
        MINI_PROCESS_5 = new HashMap();
        DEX_CONFIG = "";
        hashMap.put("name", "mini");
        hashMap.put("processType", "MINI_APP");
        hashMap.put(SensorJsPlugin.SENSOR_INTERVAL_UI, AppBrandUI.class);
        hashMap.put("internalUI", "com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3");
        hashMap.put("receiver", AppBrandTaskPreloadReceiver.class);
        hashMap.put("supportRuntimeType", 3);
        arrayList.add(hashMap);
        hashMap2.put("name", ProcessConstant.MINI_1);
        hashMap2.put("processType", "MINI_APP");
        hashMap2.put(SensorJsPlugin.SENSOR_INTERVAL_UI, AppBrandUI1.class);
        hashMap2.put("receiver", AppBrandTaskPreloadReceiver1.class);
        hashMap2.put("supportRuntimeType", 1);
        arrayList.add(hashMap2);
        hashMap3.put("name", ProcessConstant.MINI_2);
        hashMap3.put("processType", "MINI_APP");
        hashMap3.put(SensorJsPlugin.SENSOR_INTERVAL_UI, AppBrandUI2.class);
        hashMap3.put("receiver", AppBrandTaskPreloadReceiver2.class);
        hashMap3.put("supportRuntimeType", 1);
        arrayList.add(hashMap3);
        hashMap4.put("name", ProcessConstant.MINI_3);
        hashMap4.put("processType", "MINI_GAME");
        hashMap4.put(SensorJsPlugin.SENSOR_INTERVAL_UI, GameActivity1.class);
        hashMap4.put("receiver", AppBrandMainReceiver3.class);
        hashMap4.put("supportRuntimeType", 4);
        hashMap4.put("internalUI", "com.tencent.mobileqq.minigame.ui.GameActivity6");
        arrayList.add(hashMap4);
        hashMap5.put("name", ProcessConstant.MINI_4);
        hashMap5.put("processType", "MINI_GAME");
        hashMap5.put(SensorJsPlugin.SENSOR_INTERVAL_UI, GameActivity2.class);
        hashMap5.put("receiver", AppBrandMainReceiver4.class);
        hashMap5.put("supportRuntimeType", 4);
        arrayList.add(hashMap5);
        DEX_CONFIG = MiniAppConfProcessor.g(QzoneConfig.SECONDARY_MINI_APP_DEX_CONFIG, "");
        try {
            SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_safe_mode", 0);
            int i3 = sharedPreferences.getInt("key_count_crash", 0);
            String string = sharedPreferences.getString("key_crash_info", "");
            QLog.w(AppLoaderFactory.TAG, 1, "CrashInfo crashCount=" + i3 + " time=" + sharedPreferences.getLong("key_crash_time", 0L) + " detail=" + string);
            if (i3 <= 2) {
                TextUtils.isEmpty(DEX_CONFIG);
            }
            if (TextUtils.isEmpty(DEX_CONFIG)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(DEX_CONFIG);
            if (TextUtils.isEmpty(jSONObject.optString("ver"))) {
                return;
            }
            jSONObject.putOpt("app_version", AppSetting.f99551k + "." + AppSetting.f99542b);
            DEX_CONFIG = jSONObject.toString();
        } catch (Throwable th5) {
            QLog.e(AppLoaderFactory.TAG, 1, "CustomConfiguration DEX_CONFIG init error! DEX_CONFIG=" + DEX_CONFIG, th5);
        }
    }
}
