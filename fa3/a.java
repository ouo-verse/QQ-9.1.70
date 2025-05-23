package fa3;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile InterfaceC10295a f398039a;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f398040b = new AtomicBoolean(false);

    /* compiled from: P */
    /* renamed from: fa3.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC10295a {
        void d(String str, String str2);
    }

    public static void a(String str, String str2) {
        if (f398039a != null) {
            f398039a.d(str, str2);
        }
    }

    public static void b(InterfaceC10295a interfaceC10295a) {
        if (interfaceC10295a != null && f398040b.compareAndSet(false, true)) {
            f398039a = interfaceC10295a;
        }
    }
}
