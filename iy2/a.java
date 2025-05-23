package iy2;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import gy2.c;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f408983a;

    /* renamed from: b, reason: collision with root package name */
    private static String f408984b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f408985c;

    public static void a() {
        f408984b = "";
    }

    public static int b(String str, String str2) {
        String str3;
        Map<String, String> c16 = c(str);
        if (c16 != null && (str3 = c16.get(str2)) != null && TextUtils.isDigitsOnly(str3)) {
            return Integer.parseInt(str3);
        }
        return 0;
    }

    public static Map<String, String> c(String str) {
        if (!f408985c) {
            d();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_5608, str);
        if (expEntity == null) {
            return null;
        }
        f(expEntity.getGrayId());
        expEntity.reportExpExposure();
        return expEntity.getTabParams();
    }

    public static void d() {
        ABTestController.getInstance().doInit5608(TVideoConfig.f304492a.k());
        f408985c = true;
    }

    public static boolean e() {
        return f408983a;
    }

    public static void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(f408984b) || !f408984b.contains(str)) {
                if (!TextUtils.isEmpty(f408984b)) {
                    f408984b += "#" + str;
                } else {
                    f408984b = str;
                }
                c.a(f408984b);
            }
        }
    }

    public static boolean g() {
        if (b("exp_ug_qqoa_slide20230413", "use_new_guide") != 0) {
            return true;
        }
        return false;
    }
}
