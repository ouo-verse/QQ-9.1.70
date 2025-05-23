package o03;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Integer, b> f421704a = new HashMap<>();

    public static b a(int i3) {
        b bVar;
        b bVar2 = f421704a.get(Integer.valueOf(i3));
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (f421704a) {
            if (!f421704a.containsKey(Integer.valueOf(i3))) {
                bVar = f421704a.get(Integer.valueOf(i3));
            } else {
                if (i3 == 3) {
                    bVar2 = new a();
                }
                if (bVar2 != null) {
                    f421704a.put(Integer.valueOf(i3), bVar2);
                }
                bVar = bVar2;
            }
        }
        return bVar;
    }

    public static void b() {
        synchronized (f421704a) {
            f421704a.clear();
        }
    }
}
