package o70;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f422177a;

    public static boolean a() {
        String d16 = d();
        if (!TextUtils.equals(d16, "exp_bullet_C") && !TextUtils.equals(d16, "exp_bullet_D")) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        return TextUtils.equals(d(), "exp_bullet_D");
    }

    public static boolean c() {
        String d16 = d();
        if (!TextUtils.equals(d16, "exp_bullet_B") && !TextUtils.equals(d16, "exp_bullet_C") && !TextUtils.equals(d16, "exp_bullet_D")) {
            return false;
        }
        return true;
    }

    public static String d() {
        String str = f422177a;
        if (str != null) {
            return str;
        }
        String a16 = k.a("exp_bullet");
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_barrage_show_exp", true)) {
            a16 = null;
        }
        QLog.d("QFSBarrageExpStrategy", 1, "[getHitName]" + a16);
        f422177a = a16;
        return a16;
    }

    private boolean f() {
        boolean z16;
        if (Build.VERSION.SDK_INT >= 29) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (c.B5() && z16) {
            return true;
        }
        return false;
    }

    private boolean g() {
        boolean z16;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24 && i3 <= 28) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (c.C5() && z16) {
            return true;
        }
        return false;
    }

    private boolean h() {
        if (!c.a6()) {
            return false;
        }
        return i(c.p2("PDVM00|22011211C|M2012K11AC|2201122C|S6|MI 8|Redmi K30 Pro|Redmi K30|M2101K9C|V2196A|RMX3300|LGE-AN00|ANY-AN00|NTH-AN00|V2073A|LGE-AN00|LSA-AN00|RNA-AN00|TFY-AN00|PGAM10|NE2210|RMX3300"));
    }

    private boolean i(String str) {
        String lowerCase;
        String deviceName = PlatformInfor.getDeviceName();
        QLog.d("QFSBarrageExpStrategy", 2, "[isBarrageMainDraw] deviceName: " + deviceName + " | modelListStr: " + str);
        String[] split = str.split("\\|");
        if (!TextUtils.isEmpty(deviceName) && split != null && split.length != 0) {
            String lowerCase2 = deviceName.toLowerCase();
            for (String str2 : split) {
                if (str2 == null) {
                    lowerCase = "";
                } else {
                    lowerCase = str2.toLowerCase();
                }
                if (TextUtils.equals(lowerCase, lowerCase2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void j() {
        f422177a = null;
    }

    public boolean e() {
        if (f() || g() || h()) {
            return true;
        }
        return false;
    }
}
