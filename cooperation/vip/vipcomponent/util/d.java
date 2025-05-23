package cooperation.vip.vipcomponent.util;

import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {

    /* renamed from: h, reason: collision with root package name */
    private static final Object f391402h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static d f391403i;

    /* renamed from: j, reason: collision with root package name */
    private static int f391404j;

    /* renamed from: a, reason: collision with root package name */
    public String f391405a;

    /* renamed from: b, reason: collision with root package name */
    public String f391406b;

    /* renamed from: c, reason: collision with root package name */
    public int f391407c;

    /* renamed from: d, reason: collision with root package name */
    public String f391408d;

    /* renamed from: e, reason: collision with root package name */
    public String f391409e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<e> f391410f;

    /* renamed from: g, reason: collision with root package name */
    private d f391411g;

    public d(String str, int i3, String str2, WeakReference<e> weakReference) {
        this.f391406b = str;
        this.f391407c = i3;
        this.f391405a = this.f391406b + " " + str2;
        this.f391410f = weakReference;
    }

    private void a() {
        this.f391406b = null;
        this.f391405a = null;
        this.f391408d = null;
        this.f391409e = null;
        this.f391407c = -1;
        this.f391410f = null;
    }

    public static d b(String str, int i3, String str2, WeakReference<e> weakReference) {
        synchronized (f391402h) {
            d dVar = f391403i;
            if (dVar != null) {
                f391403i = dVar.f391411g;
                dVar.f391411g = null;
                dVar.f391406b = str;
                dVar.f391409e = str2;
                dVar.f391407c = i3;
                dVar.f391405a = str + " " + str2;
                dVar.f391410f = weakReference;
                f391404j = f391404j + (-1);
                return dVar;
            }
            return new d(str, i3, str2, weakReference);
        }
    }

    public void c() {
        a();
        synchronized (f391402h) {
            int i3 = f391404j;
            if (i3 < 100) {
                this.f391411g = f391403i;
                f391403i = this;
                f391404j = i3 + 1;
            }
        }
    }
}
