package lj4;

import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC10728a f414891a;

    /* renamed from: b, reason: collision with root package name */
    private static HashSet<Integer> f414892b = new HashSet<>();

    /* compiled from: P */
    /* renamed from: lj4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC10728a {
        void show();
    }

    public static boolean a() {
        return !f414892b.isEmpty();
    }

    public static void b() {
        f414891a = null;
        f414892b.clear();
    }

    public static void c(int i3, boolean z16) {
        InterfaceC10728a interfaceC10728a;
        if (z16) {
            f414892b.add(Integer.valueOf(i3));
        } else {
            f414892b.remove(Integer.valueOf(i3));
        }
        if (f414892b.isEmpty() && (interfaceC10728a = f414891a) != null) {
            interfaceC10728a.show();
        }
    }

    public static void d(InterfaceC10728a interfaceC10728a) {
        if (f414892b.isEmpty()) {
            interfaceC10728a.show();
        } else {
            f414891a = interfaceC10728a;
        }
    }
}
