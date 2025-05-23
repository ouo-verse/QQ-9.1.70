package c.t.m.g;

import com.tencent.map.geolocation.TencentLocationLogListener;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes.dex */
public class k3 {

    /* renamed from: a, reason: collision with root package name */
    public static TencentLocationLogListener f29818a;

    public static void a(TencentLocationLogListener tencentLocationLogListener) {
        f29818a = tencentLocationLogListener;
    }

    public static void a(String str, String str2) {
        try {
            TencentLocationLogListener tencentLocationLogListener = f29818a;
            if (tencentLocationLogListener != null) {
                tencentLocationLogListener.onTencentLogChanged(str, q0.b("yyyyMMdd-HHmmss:SSS").format(new Date()) + "," + str2);
            }
        } catch (Exception unused) {
        }
    }
}
