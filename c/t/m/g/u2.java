package c.t.m.g;

import android.location.Location;

/* compiled from: P */
/* loaded from: classes.dex */
public class u2 extends w2 {

    /* renamed from: a, reason: collision with root package name */
    public final Location f30053a;

    /* renamed from: b, reason: collision with root package name */
    public final long f30054b;

    /* renamed from: c, reason: collision with root package name */
    public final int f30055c;

    /* renamed from: d, reason: collision with root package name */
    public final int f30056d;

    /* renamed from: e, reason: collision with root package name */
    public final int f30057e;

    /* renamed from: f, reason: collision with root package name */
    public final a f30058f;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        GPS,
        PDR,
        VDR
    }

    public u2(u2 u2Var) {
        this.f30053a = u2Var.f30053a == null ? null : new Location(u2Var.f30053a);
        this.f30054b = u2Var.f30054b;
        this.f30055c = u2Var.f30055c;
        this.f30056d = u2Var.f30056d;
        this.f30057e = u2Var.f30057e;
        this.f30058f = u2Var.f30058f;
    }

    public String toString() {
        return "TxGpsInfo [location=" + this.f30053a + ", gpsTime=" + this.f30054b + ", visbleSatelliteNum=" + this.f30055c + ", usedSatelliteNum=" + this.f30056d + ", gpsStatus=" + this.f30057e + "]";
    }

    public u2(Location location, long j3, int i3, int i16, int i17, a aVar) {
        this.f30053a = location;
        this.f30054b = j3;
        this.f30055c = i3;
        this.f30056d = i16;
        this.f30057e = i17;
        this.f30058f = aVar;
    }
}
