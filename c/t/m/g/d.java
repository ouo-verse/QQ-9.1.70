package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f29522a;

    /* renamed from: b, reason: collision with root package name */
    public final int f29523b;

    /* renamed from: c, reason: collision with root package name */
    public final int f29524c;

    /* renamed from: d, reason: collision with root package name */
    public final int f29525d;

    /* renamed from: e, reason: collision with root package name */
    public final long f29526e;

    /* renamed from: f, reason: collision with root package name */
    public final int f29527f;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        GSM,
        CDMA,
        WCDMA,
        LTE,
        NR,
        TEMP6,
        TEMP7,
        NOSIM
    }

    public d(int i3, int i16, int i17, long j3, int i18, int i19) {
        this.f29522a = i3;
        this.f29523b = i16;
        this.f29524c = i17;
        this.f29526e = j3;
        this.f29525d = i18;
        this.f29527f = i19;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f29522a == dVar.f29522a && this.f29523b == dVar.f29523b && this.f29524c == dVar.f29524c && this.f29526e == dVar.f29526e) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "CellCoreInfo{MCC=" + this.f29522a + ", MNC=" + this.f29523b + ", LAC=" + this.f29524c + ", RSSI=" + this.f29525d + ", CID=" + this.f29526e + ", PhoneType=" + this.f29527f + '}';
    }
}
