package com.tencent.aelight.camera.ae;

import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CommonMMKVUtils;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p {

    /* renamed from: b, reason: collision with root package name */
    private static Hashtable<String, String> f65625b;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f65624a = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    static String f65626c = "GT-I8262D|SCH-I879|SCH-I829";

    /* renamed from: d, reason: collision with root package name */
    static String f65627d = "M040|GT-N7102|GT-N7108|HTC_7060|OPPO_R1S|SM-G9250|HUAWEI NXT-TL00|DOOV L5|Lenovo A5860|Nexus 6P|R827T|VIE-AL10|OPPO A59m|OPPO A37m|OPPO R9m|OPPO R9tm|MI 4LTE|HUAWEI GRA-CL00|vivo X6A|SM-N9100|MX4 Pro|HUAWEI TAG-TL00|H60-L12|SM-G9200|vivo X6Plus D|vivo X6D|OPPO R7|vivo X5Pro D";

    /* renamed from: e, reason: collision with root package name */
    static String f65628e = "M351";

    /* renamed from: f, reason: collision with root package name */
    static String f65629f = "Meizu;M351;17";

    /* renamed from: g, reason: collision with root package name */
    static String f65630g = "Nexus 6|Lenovo K860|Nexus 6P|Lenovo A3000-H|M823";

    /* renamed from: h, reason: collision with root package name */
    static String f65631h = "ZTE;U9180;18;JLS36C|motorola;Moto X Pro;21;LXG22.67-7.1|redbird;redbird H1;23;MMB29M";

    /* renamed from: i, reason: collision with root package name */
    static String f65632i = "Nexus 5X";

    /* renamed from: j, reason: collision with root package name */
    static String f65633j = "HTC T329t";

    /* renamed from: k, reason: collision with root package name */
    static String f65634k = "ZTE-T U880|Coolpad 5219|K-Touch S2";

    /* renamed from: l, reason: collision with root package name */
    static String f65635l = "M040|MX4 Pro";

    /* renamed from: m, reason: collision with root package name */
    static String f65636m = "Mi-4c|MI NOTE Pro";

    /* renamed from: n, reason: collision with root package name */
    static String f65637n = "samsung;SM-G5108Q;19;KTU84P";

    /* renamed from: o, reason: collision with root package name */
    static String f65638o = "OPPO;R7c;19|OPPO;A51kc;22|OPPO;OPPO A51kc;22|OPPO;3007;19|OPPO;OPPO 3007;19|OPPO;A31;19|OPPO;OPPO A31;19|OPPO;R7Plusm;22|OPPO;OPPO R7Plusm;22|OPPO;A51;22|OPPO;OPPO A51;22|OPPO;R7sm;22|OPPO;OPPO R7sm;22|OPPO;A53;22|OPPO;OPPO A53;22|OPPO;A53m;22|OPPO;OPPO A53m;22|OPPO;A33;22|OPPO;OPPO A33;22|OPPO;R7sPlus;22|OPPO;OPPO R7sPlus;22|OPPO;A35;22|OPPO;OPPO A35;22|OPPO;A11;19|OPPO;OPPO A11;19|OPPO;R7;19|OPPO;OPPO R7;19|OPPO;R8107;19|OPPO;OPPO R8107;19|OPPO;1107;19|OPPO;OPPO 1107;19|OPPO;R8007;18|OPPO;OPPO R8007;18|OPPO;R8207;19|OPPO;OPPO R8207;19|OPPO;R7007;18|OPPO;OPPO R7007;18|OPPO;N5110;18|OPPO;OPPO N5110;18|OPPO;A33m;22|OPPO;OPPO A33m;22|OPPO;A33t;22|OPPO;OPPO A33t;22|OPPO;N5117;18|OPPO;OPPO N5117;18|ONEPLUS;A0001;22|OnePlus;ONE E1001;22|OnePlus;ONE E1003;22";

    /* renamed from: p, reason: collision with root package name */
    static String f65639p = "Coolpad 8675|Coolpad 8675-HD|SM-G900|H30-U10|MB855|HUAWEI G730-T00|lPHONE 6";

    /* renamed from: q, reason: collision with root package name */
    static String f65640q = "GiONEE;E3T;17";

    /* renamed from: r, reason: collision with root package name */
    static String f65641r = "Xiaomi;MI 2A;16|meizu;M356;18|meizu;MX4;19|Meizu;m1 note;19";

    /* renamed from: s, reason: collision with root package name */
    static String f65642s = "BBK;vivo X5L;19|HTC;HTC ONE X;15";

    /* renamed from: t, reason: collision with root package name */
    static String f65643t = "LGE;Nexus 5";

    /* renamed from: u, reason: collision with root package name */
    static String f65644u = "Xiaomi;MI 2S|nubia;NX513J|OPPO;1107|OPPO;OPPO R7sm|vivo;vivo Y27|HUAWEI;HUAWEI RIO-AL00|Xiaomi;Redmi Note 3|Xiaomi;MI 3|Meizu;m1 metal|Meizu;M3s|Xiaomi;MI 4LTE|Xiaomi;MI 5|Xiaomi;MI NOTE LTE";

    /* renamed from: v, reason: collision with root package name */
    static String f65645v = "asus;ASUS_T00F;21";

    /* renamed from: w, reason: collision with root package name */
    static String f65646w = "Meizu;MX4 Pro;21";

    /* renamed from: x, reason: collision with root package name */
    static String f65647x = "htc;HTC T329t;16|htc;HTC T528t;15";

    /* renamed from: y, reason: collision with root package name */
    static String f65648y = "Xiaomi;MI 2S";

    /* renamed from: z, reason: collision with root package name */
    static String f65649z = "HUAWEI;HUAWEI GRA-CL10";
    static String A = "samsung;GT-I8558|samsung;SM-G3818|Lenovo;Lenovo A828t|XiaoMi;HM 2A|OPPO;OPPO R823T|OPPO;R823T|Meizu;M355|samsung;SM-G3812|Meizu;m1 note|OPPO;U707T|OPPO;OPPO U707T|samsung;GT-I9502|HUAWEI;HUAWEI P6-T00|Meizu;M351|nubia;NX513J|meizu;M356|samsung;GT-I9500|OPPO;R815T|YuLong;Coolpad8750|BBK;vivo X3t|Xiaomi;2013022|Xiaomi;2013023|OPPO;N1T";
    static String B = "HUAWEI;NTS-AL00";
    static String C = "";
    static String D = "samsung;17;JDQ39";
    static String E = "LGE;Nexus 5";
    static String F = "Xiaomi;MI 3|samsung;GT-I9500|OPPO;X907";
    static String G = "samsung;SM-A7100;22;LMY47X|OPPO;OPPO A37m;22;LMY47I|HUAWEI;CHE-TL00H;21;HonorCHE-TL00H|samsung;SM-G9208;23;MMB29K|HUAWEI;HUAWEI NXT-AL10;23;HUAWEINXT-AL10|OPPO;OPPO R7;19;KTU84P|lephone;lephone W9;22;LMY47D";
    static String H = "HUAWEI;CHE-TL00H;21;HonorCHE-TL00H|HUAWEI;H30-T00;17;HuaweiH30-T00|BBK;vivo X5L;19;KOT49H";
    static String I = "HTC D820u";
    static String J = "samsung;SM-N9009;18;JSS15J|OPPO;X907;15;IML74K";
    static String K = "vivo;vivo X7Plus;22|OPPO;N1T;17|samsung;SM-A7000;19";
    static String L = "Xiaomi;MI 3;19";
    static String M = "OPPO;OPPO R9 Plustm A;22";
    static String N = "Xiaomi;MI 6;25|samsung;SM-G5500;22|samsung;SM-J3110;22|samsung;SM-G6000;22|ZTE;BV0701;23|GiONEE;GN8001;22";
    static String O = "VIVO;V1821A|VIVO;V1821T";
    static String P = "";
    static String Q = "VIVO;V1732T|VIVO;V1732A";
    private static String R = null;

    static {
        f65625b = null;
        f65625b = new Hashtable<>();
        f65625b.put(com.tencent.aelight.camera.constants.a.f68987a, f65626c);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68988b, f65627d);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68989c, f65628e);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68990d, f65629f);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68991e, f65630g);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68992f, f65631h);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68993g, f65632i);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68994h, f65633j);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68995i, f65634k);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68996j, f65635l);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68997k, f65636m);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68998l, f65638o);
        f65625b.put(com.tencent.aelight.camera.constants.a.f68999m, f65639p);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69000n, f65640q);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69001o, f65644u);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69002p, f65641r);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69003q, f65642s);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69004r, f65645v);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69012z, f65646w);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69005s, f65647x);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69006t, f65648y);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69007u, f65649z);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69008v, C);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69009w, A);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69010x, B);
        f65625b.put(com.tencent.aelight.camera.constants.a.f69011y, f65637n);
        f65625b.put(com.tencent.aelight.camera.constants.a.A, D);
        f65625b.put(com.tencent.aelight.camera.constants.a.B, f65643t);
        f65625b.put(com.tencent.aelight.camera.constants.a.C, E);
        f65625b.put(com.tencent.aelight.camera.constants.a.D, F);
        f65625b.put(com.tencent.aelight.camera.constants.a.E, G);
        f65625b.put(com.tencent.aelight.camera.constants.a.F, H);
        f65625b.put(com.tencent.aelight.camera.constants.a.G, I);
        f65625b.put(com.tencent.aelight.camera.constants.a.H, J);
        f65625b.put(com.tencent.aelight.camera.constants.a.I, K);
        f65625b.put(com.tencent.aelight.camera.constants.a.J, O);
        f65625b.put(com.tencent.aelight.camera.constants.a.K, P);
    }

    public static boolean b() {
        if (!f65624a.get()) {
            d();
        }
        String str = f65625b.get(com.tencent.aelight.camera.constants.a.K);
        return !i(Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel(), str);
    }

    private static String c() {
        if (TextUtils.isEmpty(R)) {
            R = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel() + ";" + Build.VERSION.SDK_INT;
        }
        return R;
    }

    private static void d() {
        if (f65624a.get()) {
            return;
        }
        String string = CommonMMKVUtils.getString("camera_compatible_list", "", false);
        if (!TextUtils.isEmpty(string)) {
            r(string, false);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.o
                @Override // java.lang.Runnable
                public final void run() {
                    p.p();
                }
            }, 64, null, false);
        }
        f65624a.set(true);
    }

    public static boolean e() {
        return f(com.tencent.aelight.camera.constants.a.J);
    }

    private static boolean f(String str) {
        return i(Build.MANUFACTURER.toUpperCase() + ";" + DeviceInfoMonitor.getModel().toUpperCase(), f65625b.get(str));
    }

    public static boolean g() {
        return i(c(), "YuLong;Coolpad Y75;19|YuLong;Coolpad Y76;19|YuLong;Coolpad K1-NT;19|YuLong;Coolpad SK1-01;19|YuLong;ivvi SK1-02;19|YuLong;Coolpad 5956;19|YuLong;Coolpad Y80D;19|YuLong;Coolpad 8297-C00;19");
    }

    public static boolean h(String str) {
        if (!f65624a.get()) {
            d();
        }
        Hashtable<String, String> hashtable = f65625b;
        if (hashtable == null) {
            return false;
        }
        return i(DeviceInfoMonitor.getModel(), hashtable.get(str));
    }

    private static boolean i(String str, String str2) {
        String[] split;
        if (str2 == null || (split = str2.split("\\|")) == null) {
            return false;
        }
        for (String str3 : split) {
            if (str3.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(String str) {
        if (!f65624a.get()) {
            d();
        }
        if (f65625b == null) {
            return false;
        }
        return i(Build.MANUFACTURER + ";" + Build.VERSION.SDK_INT + ";" + Build.ID, f65625b.get(str));
    }

    public static boolean k(String str) {
        if (!f65624a.get()) {
            d();
        }
        if (f65625b == null) {
            return false;
        }
        return i(Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel() + ";" + Build.VERSION.SDK_INT, f65625b.get(str));
    }

    public static boolean l(String str) {
        if (!f65624a.get()) {
            d();
        }
        if (f65625b == null) {
            return false;
        }
        return i(Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel(), f65625b.get(str));
    }

    public static boolean m() {
        return i(c(), N);
    }

    public static boolean n() {
        return i(c(), M);
    }

    public static boolean o() {
        return i(c(), L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p() {
        r(PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("camera_compatible_list", ""), true);
    }

    public static boolean q() {
        return i(Build.MANUFACTURER.toUpperCase() + ";" + DeviceInfoMonitor.getModel().toUpperCase(), Q);
    }

    public static void r(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f65625b == null) {
            f65625b = new Hashtable<>();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                String str3 = (String) jSONObject.get(str2);
                String str4 = f65625b.get(str2);
                if (f65625b.containsKey(str2) && str4 != null) {
                    f65625b.put(str2, str4 + "|" + str3);
                } else {
                    f65625b.put(str2, str3);
                }
            }
            if (z16) {
                CommonMMKVUtils.putString("camera_compatible_list", str, false);
            }
            f65624a.set(true);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CameraCompatibleList", 2, "updateCompatibleList json ERROR, msg=" + e16.getMessage());
            }
        }
    }
}
