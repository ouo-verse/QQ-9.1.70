package com.tencent.av.foldable;

import android.content.Context;
import android.os.Build;
import com.tencent.av.utils.ax;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FoldInfoUtils {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f73727a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f73728b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f73729c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f73730d = null;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f73731e = false;

    /* renamed from: f, reason: collision with root package name */
    private static List<String> f73732f = null;

    /* renamed from: g, reason: collision with root package name */
    private static List<String> f73733g = null;

    /* renamed from: h, reason: collision with root package name */
    private static List<String> f73734h = null;

    /* renamed from: i, reason: collision with root package name */
    private static int f73735i = 30;

    /* renamed from: j, reason: collision with root package name */
    private static final List<String> f73736j = new ArrayList<String>() { // from class: com.tencent.av.foldable.FoldInfoUtils.1
        {
            add("OPPO_PEUM00");
            add("Vivo_V2178A");
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private static final List<String> f73737k = new ArrayList<String>() { // from class: com.tencent.av.foldable.FoldInfoUtils.2
        {
            add("OPPO_PEUM00");
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private static final List<String> f73738l = new ArrayList<String>() { // from class: com.tencent.av.foldable.FoldInfoUtils.3
        {
            add("OPPO_PEUM00");
        }
    };

    public static boolean a(List<String> list, String str) {
        for (String str2 : list) {
            if (str2.equalsIgnoreCase(str) || m(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static String b() {
        if (i()) {
            return "oplus_system_folding_angle";
        }
        return "fdis_system_folding_angle";
    }

    private static String c() {
        if (f73730d == null) {
            f73730d = Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel();
        }
        QLog.i("FoldInfoUtils", 1, "getModel: " + f73730d);
        return f73730d;
    }

    public static String d() {
        if (i()) {
            return "oplus_system_folding_mode";
        }
        return "fdis_system_folding_mode";
    }

    public static int e() {
        g();
        return f73735i;
    }

    private static void f() {
        f73732f = f73736j;
        f73733g = f73737k;
        f73734h = f73738l;
        f73735i = 30;
        f73731e = true;
    }

    private static void g() {
        if (f73731e) {
            return;
        }
        JSONObject a16 = ax.a("qav_fold_switch_875315181");
        if (a16 == null) {
            f();
            return;
        }
        QLog.i("FoldInfoUtils", 1, "get config json:\n" + a16);
        JSONArray optJSONArray = a16.optJSONArray("deviceList");
        JSONArray optJSONArray2 = a16.optJSONArray("leftFrontCameraDeviceList");
        JSONArray optJSONArray3 = a16.optJSONArray("contentProviderDeviceList");
        f73735i = a16.optInt("sensorMinAPILevel", 30);
        f73732f = l(optJSONArray, f73736j);
        f73733g = l(optJSONArray2, f73737k);
        f73734h = l(optJSONArray3, f73738l);
        f73731e = true;
        QLog.i("FoldInfoUtils", 1, "config [ deviceListSize = " + f73732f.size() + " leftFrontSize = " + f73733g.size() + " contentProviderSize = " + f73734h.size() + " minAPILevel = " + f73735i + " ]");
    }

    public static boolean h(Context context) {
        boolean z16;
        Boolean bool = f73727a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z17 = false;
        if (context != null && context.getPackageManager() != null) {
            z16 = context.getPackageManager().hasSystemFeature("oplus.feature.largescreen");
        } else {
            z16 = false;
        }
        g();
        if (z16 || a(f73732f, c())) {
            z17 = true;
        }
        Boolean valueOf = Boolean.valueOf(z17);
        f73727a = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean i() {
        String str = Build.MANUFACTURER;
        if (!"oppo".equalsIgnoreCase(str) && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ONEPLUS.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static boolean j(Context context) {
        Boolean bool = f73728b;
        if (bool != null) {
            return bool.booleanValue();
        }
        g();
        Boolean valueOf = Boolean.valueOf(!a(f73733g, c()));
        f73728b = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean k() {
        Boolean bool = f73729c;
        if (bool != null) {
            return bool.booleanValue();
        }
        g();
        Boolean valueOf = Boolean.valueOf(a(f73734h, c()));
        f73729c = valueOf;
        return valueOf.booleanValue();
    }

    private static List<String> l(JSONArray jSONArray, List<String> list) {
        if (jSONArray == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(jSONArray.optString(i3));
        }
        return arrayList;
    }

    private static boolean m(String str, String str2) {
        if (str != null && str2 != null) {
            if (str2.length() > str.length()) {
                return false;
            }
            return str.regionMatches(true, 0, str2, 0, str2.length());
        }
        if (str != null || str2 != null) {
            return false;
        }
        return true;
    }
}
