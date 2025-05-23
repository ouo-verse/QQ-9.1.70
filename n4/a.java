package n4;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, Long> f418286a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected HashMap<String, Long> f418287b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected HashMap<String, Long> f418288c = new HashMap<>();

    private boolean a(String str) {
        Long l3 = this.f418286a.get(str);
        return l3 != null && l3.intValue() == 1;
    }

    public HashMap<String, Long> b() {
        return this.f418286a;
    }

    public boolean c() {
        return a("downHasMore");
    }

    public HashMap<String, Long> d() {
        return this.f418288c;
    }

    public boolean e() {
        return a("upHasMore");
    }

    public HashMap<String, Long> f() {
        return this.f418287b;
    }

    abstract void g(long j3, long j16, m4.d dVar);

    abstract void h(long j3, long j16);

    abstract void i(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(m4.c cVar, int i3) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int ceil = (int) Math.ceil(i3 / o4.a.f421922a);
        int i16 = 0;
        while (i16 < ceil) {
            int i17 = i16 + 1;
            int i18 = o4.a.f421922a;
            int i19 = i3 - (i17 * i18);
            if (i19 <= 0) {
                i19 = 0;
            }
            arrayList.add(Integer.valueOf(i19));
            if (i16 == ceil - 1) {
                arrayList2.add(Integer.valueOf(i3 - (i16 * i18)));
            } else {
                arrayList2.add(Integer.valueOf(i18));
            }
            i16 = i17;
        }
        cVar.f416104c = arrayList;
        cVar.f416105d = arrayList2;
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        ArrayList<Integer> arrayList4 = new ArrayList<>();
        for (int i26 = 0; i26 < ceil; i26++) {
            int i27 = o4.a.f421922a;
            arrayList3.add(Integer.valueOf(i26 * i27));
            if (i26 == ceil - 1) {
                arrayList4.add(Integer.valueOf(i3 - (i27 * i26)));
            } else {
                arrayList4.add(Integer.valueOf(i27));
            }
        }
        cVar.f416106e = arrayList3;
        cVar.f416107f = arrayList4;
    }

    public boolean j(int i3) {
        if (i3 == 1) {
            return e();
        }
        if (i3 != 2) {
            return false;
        }
        return c();
    }

    public void k(int i3, long j3, long j16, m4.d dVar) {
        if (i3 == 0) {
            g(j3, j16, dVar);
        } else if (i3 == 1) {
            i(j3, j16);
        } else {
            if (i3 != 2) {
                return;
            }
            h(j3, j16);
        }
    }
}
