package ax;

import android.os.Build;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static dx.e a() {
        try {
            JSONObject b16 = b("100155");
            if (b16 == null) {
                QLog.i("AvAvatarSwitch", 1, "getMachineConfig exception");
                return null;
            }
            if (AEModule.getContext() == null) {
                AEModule.setContext(BaseApplication.context);
            }
            JSONObject jSONObject = b16.getJSONObject(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY).getJSONObject(String.valueOf(AEOfflineConfig.getPhonePerfLevel()));
            dx.e eVar = new dx.e();
            eVar.f(b16.optBoolean("enableInterpolate"));
            eVar.e(jSONObject.getInt("new_collect_fps"));
            eVar.g(jSONObject.getInt("render_fps"));
            eVar.h(jSONObject.getInt("render_width"));
            QLog.i("AvAvatarSwitch", 1, "getMachineConfig: " + eVar.toString());
            return eVar;
        } catch (Throwable unused) {
            QLog.i("AvAvatarSwitch", 1, "getMachineConfig exception");
            return null;
        }
    }

    private static JSONObject b(String str) {
        String str2;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]);
        if (loadRawConfig == null || loadRawConfig.length == 0) {
            return null;
        }
        try {
            str2 = new String(loadRawConfig, StandardCharsets.UTF_8);
            try {
                return new JSONObject(str2);
            } catch (Exception e16) {
                e = e16;
                QLog.e("AvAvatarSwitch", 1, "parse raw config failed!!! str: " + str2 + "\n", e);
                return null;
            }
        } catch (Exception e17) {
            e = e17;
            str2 = null;
        }
    }

    public static boolean c(AppRuntime appRuntime) {
        boolean z16;
        if (appRuntime == null) {
            return false;
        }
        if (d()) {
            return true;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qav_zplan_avatar", false);
        boolean m26 = ea.m2(appRuntime.getCurrentUin());
        boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase(null);
        QLog.i("AvAvatarSwitch", 2, "isInSpringWhiteList " + m26 + " isSwitchOpen " + isSwitchOn + " isEnableZPlanFilament " + enableZPlanFilamentBase);
        if (!enableZPlanFilamentBase) {
            QLog.e("AvAvatarSwitch", 1, "switch off: machine not support");
            return false;
        }
        if (!isSwitchOn && !m26) {
            QLog.e("AvAvatarSwitch", 1, "switch off: toggle close");
            return false;
        }
        if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(210003L, appRuntime.getLongAccountUin())) {
            QLog.i("AvAvatarSwitch", 2, "switch off: not in whiteList");
            return false;
        }
        JSONObject b16 = b("100155");
        QLog.i("AvAvatarSwitch", 1, "get config json:\n" + b16);
        if (b16 == null) {
            return false;
        }
        try {
            int i3 = b16.getInt("level");
            if (AEModule.getContext() == null) {
                AEModule.setContext(BaseApplication.context);
            }
            int phonePerfLevel = AEOfflineConfig.getPhonePerfLevel();
            if (phonePerfLevel >= i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.e("AvAvatarSwitch", 1, "switch off: phone level not match" + phonePerfLevel + " BenchmarkStrategy=" + OfflineConfig.getBenchmarkStrategy());
                return false;
            }
            if (b16.getBoolean("forceForbid")) {
                QLog.e("AvAvatarSwitch", 1, "switch off: forceForbid");
                return false;
            }
            List<String> e16 = e(b16.optJSONArray("avatarDeviceBlackList"));
            if (e16 != null) {
                String str = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel();
                Iterator<String> it = e16.iterator();
                while (it.hasNext()) {
                    if (str.equalsIgnoreCase(it.next())) {
                        QLog.i("AvAvatarSwitch", 2, "switch off: phone is blacklisted");
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean d() {
        List<String> e16;
        try {
            JSONObject b16 = b("102853");
            if (b16 != null && (e16 = e(b16.optJSONArray("whiteList"))) != null) {
                String model = DeviceInfoMonitor.getModel();
                Iterator<String> it = e16.iterator();
                while (it.hasNext()) {
                    if (model.equals(it.next())) {
                        QLog.i("AvAvatarSwitch", 2, "switch on: phone is whitelisted");
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e17) {
            QLog.d("AvAvatarSwitch", 1, "isWhiteModel exception: " + e17);
            return false;
        }
    }

    private static List<String> e(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(jSONArray.optString(i3));
        }
        return arrayList;
    }

    public static boolean f() {
        try {
            JSONObject b16 = b("100155");
            if (b16 == null) {
                QLog.i("AvAvatarSwitch", 1, "useOldNotification exception");
                return true;
            }
            boolean optBoolean = b16.optBoolean("useOldNotification", false);
            QLog.i("AvAvatarSwitch", 1, "useOldNotification: " + optBoolean + " hasKey:" + b16.has("useOldNotification"));
            return optBoolean;
        } catch (Throwable unused) {
            QLog.i("AvAvatarSwitch", 1, "useOldNotification exception");
            return true;
        }
    }
}
