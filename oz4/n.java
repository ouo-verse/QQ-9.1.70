package oz4;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class n implements Cloneable {

    /* renamed from: h, reason: collision with root package name */
    public static final n f424793h = new n();

    /* renamed from: d, reason: collision with root package name */
    public String f424794d;

    /* renamed from: e, reason: collision with root package name */
    public String f424795e;

    /* renamed from: f, reason: collision with root package name */
    public int f424796f;

    public static n a() {
        try {
            n nVar = f424793h;
            h.f424755i.f424763h.getClass();
            nVar.f424794d = "";
            h.f424755i.f424763h.getClass();
            nVar.f424795e = "";
            h.f424755i.f424763h.getClass();
            nVar.f424796f = 1;
            return (n) nVar.clone();
        } catch (CloneNotSupportedException unused) {
            return f424793h;
        }
    }

    public final String toString() {
        return "TrackerEventEnv{sessionId='" + this.f424794d + "', launchId='" + this.f424795e + "', appMode=" + b.b(this.f424796f) + '}';
    }
}
