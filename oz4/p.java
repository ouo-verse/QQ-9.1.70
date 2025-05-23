package oz4;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class p implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final p f424800f = new p();

    /* renamed from: d, reason: collision with root package name */
    public String f424801d;

    /* renamed from: e, reason: collision with root package name */
    public String f424802e;

    public static p a() {
        try {
            p pVar = f424800f;
            pVar.f424801d = ((xz4.l) h.f424755i.f424763h).a();
            h.f424755i.f424763h.getClass();
            pVar.f424802e = "";
            return (p) pVar.clone();
        } catch (CloneNotSupportedException unused) {
            return f424800f;
        }
    }

    public final String toString() {
        return "TrackerEventUser{userId='" + this.f424801d + "', userGroupId='" + this.f424802e + "'}";
    }
}
