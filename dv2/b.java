package dv2;

import android.text.TextUtils;
import hv2.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f395011b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f395012a = new HashMap();

    b() {
        b();
    }

    public static b d() {
        if (f395011b == null) {
            synchronized (b.class) {
                if (f395011b == null) {
                    f395011b = new b();
                }
            }
        }
        return f395011b;
    }

    public <S extends a> S a(Class<S> cls) {
        return (S) this.f395012a.get(l.a(cls));
    }

    public void c(a aVar) {
        if (aVar == null) {
            return;
        }
        String a16 = l.a(aVar.getClass());
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        this.f395012a.put(a16, aVar);
    }

    private void b() {
    }
}
