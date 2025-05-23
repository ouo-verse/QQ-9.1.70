package m2;

import android.content.Context;
import com.hihonor.honorid.core.data.HonorAccount;
import java.util.ArrayList;
import java.util.HashMap;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f416024c;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f416025d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f416026a;

    /* renamed from: b, reason: collision with root package name */
    private HonorAccount f416027b;

    a(Context context) {
        new HashMap();
        this.f416026a = context;
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f416025d) {
            if (f416024c == null) {
                f416024c = new a(context.getApplicationContext());
            }
            aVar = f416024c;
        }
        return aVar;
    }

    public HonorAccount a() {
        if (this.f416027b == null) {
            d();
        }
        return this.f416027b;
    }

    public void c(HonorAccount honorAccount) {
        e.c("HnIDMemCache", "saveHnAccountToCache", true);
        if (j2.a.d(honorAccount)) {
            this.f416027b = honorAccount;
        } else {
            e.b("HnIDMemCache", "save honorAccount is null", true);
            this.f416027b = null;
        }
    }

    public void d() {
        e.c("HnIDMemCache", "initHnAccountMemCache", true);
        ArrayList<HonorAccount> a16 = k2.a.a(this.f416026a).a(this.f416026a);
        if (a16.size() > 0) {
            this.f416027b = a16.get(0);
        } else {
            e.c("HnIDMemCache", "file has no account", true);
        }
    }
}
