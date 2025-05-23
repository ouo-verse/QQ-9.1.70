package c.t.m.g;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class v2 {

    /* renamed from: e, reason: collision with root package name */
    public static long f30082e;

    /* renamed from: a, reason: collision with root package name */
    public final x2 f30083a;

    /* renamed from: b, reason: collision with root package name */
    public final t2 f30084b;

    /* renamed from: c, reason: collision with root package name */
    public final u2 f30085c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f30086d;

    public v2(x2 x2Var, t2 t2Var, u2 u2Var, boolean z16) {
        this.f30083a = x2Var;
        this.f30084b = t2Var;
        this.f30085c = u2Var;
        this.f30086d = z16;
    }

    @Nullable
    public t2 a() {
        return this.f30084b;
    }

    @Nullable
    public u2 b() {
        return this.f30085c;
    }

    @Nullable
    public x2 c() {
        return this.f30083a;
    }

    public boolean d() {
        if (this.f30084b != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f30083a != null) {
            return true;
        }
        return false;
    }

    public String a(int i3, int i16, String str, n1 n1Var, boolean z16, boolean z17) {
        String str2;
        String f16;
        if (n1Var == null) {
            return null;
        }
        try {
            t2 t2Var = this.f30084b;
            boolean z18 = true;
            if (t2Var != null) {
                long j3 = f30082e;
                long j16 = t2Var.f30007f;
                if (j3 == j16) {
                    z18 = false;
                }
                f30082e = j16;
            }
            String a16 = t3.a(this.f30083a);
            String a17 = t3.a(this.f30084b, z18);
            k3.a("cells", a17);
            String a18 = t3.a(this.f30085c);
            o1 a19 = n1Var.a();
            if (a19 == null) {
                return null;
            }
            String g16 = a19.g();
            String a26 = a19.a();
            int a27 = n3.a().a(n1Var.f29875a);
            String a28 = x3.a(n1Var);
            k3.a("waln", a28);
            String c16 = a19.c();
            if (c16 != null) {
                c16 = c16.replace("\"", "");
            }
            if (c16 != null) {
                c16 = c16.replace("|", "");
            }
            String str3 = c16 + "_" + a19.q();
            int abs = (!z17 || (f16 = a19.f()) == null) ? 203 : (Math.abs(f16.hashCode()) % 1000) + 1001;
            String str4 = ("{\"version\":\"" + a19.p() + "\",\"address\":" + i3) + ",\"source\":" + abs + ",\"access_token\":\"" + a26 + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str3 + "\",\"bearing\":1";
            if (i16 >= 0) {
                str4 = str4 + ",\"control\":" + i16;
            }
            if (z16 && !z17) {
                str2 = str4 + ",\"detectgps\":1";
            } else {
                str2 = str4 + ",\"detectgps\":0";
            }
            return ((str2 + ",\"pstat\":" + a27) + ",\"wlan\":" + a28) + ",\"attribute\":" + g16 + ",\"location\":" + a18 + ",\"cells\":" + a17 + ",\"wifis\":" + a16 + "}";
        } catch (Exception unused) {
            return null;
        }
    }

    public String a(int i3, String str, n1 n1Var, boolean z16, boolean z17, boolean z18) {
        if (z17) {
            return a(i3, 1, str, n1Var, z16, z18);
        }
        return a(i3, 0, str, n1Var, z16, z18);
    }

    public int a(v2 v2Var) {
        if (v2Var == null) {
            return 0;
        }
        if (v2Var.e() && e() && c().a(v2Var.c())) {
            return 2;
        }
        return (!v2Var.e() && !e() && v2Var.d() && d() && a().b().equalsIgnoreCase(v2Var.a().b())) ? 1 : 0;
    }
}
