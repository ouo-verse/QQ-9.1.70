package oz4;

import com.heytap.databaseengine.type.DeviceType;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class o implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final o f424797f = new o();

    /* renamed from: d, reason: collision with root package name */
    public String f424798d;

    /* renamed from: e, reason: collision with root package name */
    public String f424799e;

    public static o a() {
        try {
            o oVar = f424797f;
            h.f424755i.f424763h.getClass();
            oVar.f424798d = DeviceType.DeviceCategory.MOBILE;
            h.f424755i.f424763h.getClass();
            oVar.f424799e = "";
            return (o) oVar.clone();
        } catch (CloneNotSupportedException unused) {
            return f424797f;
        }
    }

    public final String toString() {
        return "TrackerEventNetwork{networkType='" + this.f424798d + "', ispName='" + this.f424799e + "'}";
    }
}
