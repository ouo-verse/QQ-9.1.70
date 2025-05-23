package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class a2 {

    /* renamed from: b, reason: collision with root package name */
    public float f29471b;

    /* renamed from: g, reason: collision with root package name */
    public double f29476g;

    /* renamed from: d, reason: collision with root package name */
    public double f29473d = -1.0d;

    /* renamed from: e, reason: collision with root package name */
    public double f29474e = -1.0d;

    /* renamed from: f, reason: collision with root package name */
    public double f29475f = -1.0d;

    /* renamed from: a, reason: collision with root package name */
    public float f29470a = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    public long f29472c = -1;

    /* renamed from: h, reason: collision with root package name */
    public double f29477h = 0.0d;

    /* renamed from: i, reason: collision with root package name */
    public double f29478i = 0.0d;

    public double a() {
        return this.f29473d;
    }

    public double b() {
        return this.f29474e;
    }

    public void c() {
        this.f29475f = -1.0d;
        this.f29470a = -1.0f;
        this.f29472c = -1L;
        this.f29477h = 0.0d;
        this.f29478i = 0.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0244, code lost:
    
        if ((r1 - r30.f29473d) <= 0.0d) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0255, code lost:
    
        r30.f29473d += r3 * (r7 / 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0253, code lost:
    
        if ((r1 - r30.f29473d) < 0.0d) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(double d16, double d17, double d18, long j3) {
        double d19;
        double d26;
        double d27;
        double d28;
        double d29 = d18 < 1.0d ? 1.0d : d18;
        o3.a("a", "lat_me:" + d16 + ",lng_me:" + d17 + ",accuracy:" + d29 + ",time:" + j3 + ",lat:" + this.f29473d + ",lng:" + this.f29474e);
        if (j3 - this.f29472c >= 20000) {
            c();
            o3.a("a", "Time:" + j3 + ",last_time:" + this.f29472c);
        }
        this.f29470a = (float) (Math.abs(d16 - this.f29473d) * 1000000.0d);
        this.f29471b = (float) (Math.abs(d17 - this.f29474e) * 1000000.0d);
        o3.a("a", "Q:" + this.f29470a + ",QLng:" + this.f29471b);
        double d36 = this.f29475f;
        if (d36 < 0.0d) {
            this.f29472c = j3;
            this.f29473d = d16;
            this.f29474e = d17;
            this.f29475f = d29 * d29;
            return;
        }
        long j16 = j3 - this.f29472c;
        if (j16 < 1000) {
            j16 = 1000;
        }
        if (j16 > 0) {
            double d37 = j16;
            this.f29475f = d36 + d37;
            this.f29476g += d37;
        }
        double d38 = this.f29475f;
        double d39 = d29 * d29;
        double d46 = d29;
        double d47 = d38 / ((d38 + d39) + (this.f29470a * 5.0f));
        double d48 = this.f29476g;
        double d49 = d48 / ((d48 + d39) + (this.f29471b * 5.0f));
        o3.a("a", "K:" + d47 + ",KLng:" + d49);
        if (d47 >= 0.4d && d49 >= 0.4d) {
            double d56 = this.f29473d;
            d26 = d49;
            double d57 = this.f29477h;
            if ((d57 > 0.0d && d16 - d56 > 0.0d) || (d57 < 0.0d && d16 - d56 < 0.0d)) {
                this.f29473d = (d57 * (j16 / 1000)) + d56;
            }
            double d58 = this.f29473d;
            this.f29473d = d58 + ((d16 - d58) * d47);
            o3.a("a", "lat:" + this.f29473d + ",tmp:" + d56 + ",timeInc:" + j16);
            double d59 = this.f29473d - d56;
            double d65 = (double) (j16 / 1000);
            this.f29477h = d59 / d65;
            double d66 = this.f29474e;
            double d67 = this.f29478i;
            d19 = d47;
            d27 = d17;
            if ((d67 > 0.0d && d27 - d66 > 0.0d) || (d67 < 0.0d && d27 - d66 < 0.0d)) {
                this.f29474e = (d67 * d65) + d66;
            }
            double d68 = this.f29474e;
            this.f29474e = d68 + ((d27 - d68) * d26);
            o3.a("a", "lng:" + this.f29474e + ",tmp:" + d66 + ",timeInc:" + j16);
            this.f29478i = (this.f29474e - d66) / d65;
            this.f29475f = (1.0d - d19) * this.f29475f;
            this.f29476g = (1.0d - d26) * this.f29476g;
            this.f29472c = j3;
            o3.a("a", "last_metres_per_second:" + this.f29477h + ",last_metres_per_second_lng:" + this.f29478i);
            d28 = d16;
        } else {
            d19 = d47;
            d26 = d49;
            d27 = d17;
            double d69 = this.f29477h;
            if (d69 > 0.0d) {
                d28 = d16;
            } else {
                d28 = d16;
            }
            if (d69 < 0.0d) {
            }
            double d75 = this.f29478i;
            if ((d75 > 0.0d && d27 - this.f29474e > 0.0d) || (d75 < 0.0d && d27 - this.f29474e < 0.0d)) {
                this.f29474e += d75 * (j16 / 1000);
            }
            double d76 = j16;
            this.f29475f -= d76;
            this.f29476g -= d76;
        }
        o3.a("a", "variance:" + this.f29475f + ",vaLng:" + this.f29476g);
        if (d46 != 30.0d || d19 < 0.5d || d26 < 0.5d) {
            return;
        }
        this.f29473d = d28;
        this.f29474e = d27;
        this.f29472c = j3;
        this.f29477h = 0.0d;
        this.f29478i = 0.0d;
        this.f29475f = d39;
    }
}
