package lm2;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    static g f415006a;

    public static void a(Runnable runnable) {
        g gVar = f415006a;
        if (gVar != null) {
            gVar.post(runnable);
            return;
        }
        throw new RuntimeException("not initialized");
    }

    public static void b(g gVar) {
        f415006a = gVar;
    }
}
