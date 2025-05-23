package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class z2 {

    /* renamed from: a, reason: collision with root package name */
    public static z2 f30127a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a extends z2 {
    }

    public static z2 a() {
        return new a();
    }

    public y2 b() {
        z2 z2Var = f30127a;
        if (z2Var != null) {
            return (y2) z3.a(z2Var.b(), "http client should NOT be null");
        }
        return new k2();
    }
}
