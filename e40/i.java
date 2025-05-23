package e40;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final List<a> f395616a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private float f395617a;

        /* renamed from: b, reason: collision with root package name */
        private long f395618b;

        /* renamed from: c, reason: collision with root package name */
        private long f395619c;

        a() {
        }
    }

    private void d(long j3) {
        if (this.f395616a.size() == 0) {
            return;
        }
        a aVar = this.f395616a.get(r0.size() - 1);
        if (aVar.f395619c == 0) {
            aVar.f395619c = j3;
        }
    }

    public synchronized String a(long j3) {
        StringBuilder sb5;
        d(j3);
        sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.f395616a.size(); i3++) {
            a aVar = this.f395616a.get(i3);
            sb5.append(aVar.f395617a);
            sb5.append("-");
            sb5.append(aVar.f395618b);
            sb5.append("-");
            sb5.append(aVar.f395619c);
            if (i3 != this.f395616a.size() - 1) {
                sb5.append("|");
            }
        }
        return sb5.toString();
    }

    public boolean b() {
        if (this.f395616a.size() > 0) {
            return true;
        }
        return false;
    }

    public synchronized void c(float f16, long j3) {
        d(j3);
        if (f16 == 1.0f) {
            return;
        }
        a aVar = new a();
        aVar.f395617a = f16;
        aVar.f395618b = j3;
        this.f395616a.add(aVar);
    }
}
