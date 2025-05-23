package c.t.m.g;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes.dex */
public class e2 {

    /* renamed from: c, reason: collision with root package name */
    public static e2 f29587c = new e2();

    /* renamed from: a, reason: collision with root package name */
    public a f29588a = a.UNKNOW;

    /* renamed from: b, reason: collision with root package name */
    public LinkedList<u2> f29589b = new LinkedList<>();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum a {
        UNKNOW,
        MOVE,
        STATIC
    }

    public static e2 d() {
        return f29587c;
    }

    public final boolean a(double d16) {
        return true;
    }

    public synchronized int b(u2 u2Var) {
        if (u2Var != null) {
            boolean z16 = !a(u2Var);
            this.f29589b.add(new u2(u2Var));
            if (z16) {
                return -1;
            }
            if (!a(u2Var.f30053a.getSpeed())) {
                return -1;
            }
        }
        return this.f29589b.size();
    }

    public synchronized long c() {
        f();
        if (this.f29588a == a.STATIC) {
            return 90000L;
        }
        return 30000L;
    }

    public double e() {
        long j3;
        if (this.f29589b.size() < 2) {
            return 0.0d;
        }
        int size = this.f29589b.size() - 1;
        u2 u2Var = this.f29589b.get(size);
        u2 u2Var2 = this.f29589b.get(size - 1);
        long j16 = u2Var.f30054b;
        long j17 = u2Var2.f30054b;
        if (j16 != j17) {
            j3 = j16 - j17;
        } else {
            j3 = 500;
        }
        return (t3.a(u2Var2.f30053a.getLatitude(), u2Var2.f30053a.getLongitude(), u2Var.f30053a.getLatitude(), u2Var.f30053a.getLongitude()) / j3) * 1000.0d;
    }

    public final void f() {
        double e16 = e();
        double a16 = a();
        if (h2.a() != null && this.f29589b.size() > 0) {
            h2.a().a(2, a16, e16, this.f29589b.getLast().f30054b);
        }
        long b16 = b();
        int size = this.f29589b.size();
        if (size < 2) {
            this.f29588a = a.UNKNOW;
            return;
        }
        if (size > 6 && e16 < 3.0d && a16 < 6.0d) {
            this.f29588a = a.STATIC;
        } else if (b16 > 60000 && e16 < 3.0d && a16 < 3.0d) {
            this.f29588a = a.STATIC;
        } else {
            this.f29588a = a.MOVE;
        }
    }

    public final boolean a(u2 u2Var) {
        while (this.f29589b.size() > 9) {
            this.f29589b.remove(0);
        }
        while (this.f29589b.size() > 0) {
            u2 first = this.f29589b.getFirst();
            long j3 = u2Var.f30054b - first.f30054b;
            double a16 = t3.a(first.f30053a.getLatitude(), first.f30053a.getLongitude(), u2Var.f30053a.getLatitude(), u2Var.f30053a.getLongitude());
            if (j3 <= 180000 || a16 <= 500.0d) {
                return true;
            }
            this.f29589b.remove(0);
        }
        return true;
    }

    public final long b() {
        if (this.f29589b.size() < 2) {
            return 0L;
        }
        return this.f29589b.getLast().f30054b - this.f29589b.getFirst().f30054b;
    }

    public double a() {
        if (this.f29589b.size() < 2) {
            return 0.0d;
        }
        int size = this.f29589b.size();
        double d16 = 0.0d;
        long j3 = 0;
        for (int i3 = 1; i3 < size; i3++) {
            u2 u2Var = this.f29589b.get(i3);
            u2 u2Var2 = this.f29589b.get(i3 - 1);
            d16 += t3.a(u2Var2.f30053a.getLatitude(), u2Var2.f30053a.getLongitude(), u2Var.f30053a.getLatitude(), u2Var.f30053a.getLongitude());
            j3 += u2Var.f30054b - u2Var2.f30054b;
        }
        if (j3 > 0) {
            return (d16 / j3) * 1000.0d;
        }
        return 0.0d;
    }
}
