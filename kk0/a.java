package kk0;

import com.tencent.ecommerce.richtext.ui.dom.style.FlexNode;
import com.tencent.ecommerce.richtext.ui.dom.style.j;
import com.tencent.ecommerce.richtext.ui.dom.style.k;
import com.tencent.ecommerce.richtext.ui.dom.style.m;
import lk0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: kk0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C10663a implements b.a {
        C10663a() {
        }

        @Override // lk0.b.a
        public void a(lk0.b bVar) {
            if (!bVar.j0()) {
                return;
            }
            bVar.m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f412587a;

        b(j jVar) {
            this.f412587a = jVar;
        }

        @Override // lk0.b.a
        public void a(lk0.b bVar) {
            if (!bVar.j0()) {
                return;
            }
            if (!Float.isNaN(bVar.f105336e.f105404q)) {
                synchronized (FlexNode.K) {
                    k kVar = bVar.f105336e;
                    float f16 = kVar.f105404q;
                    if (f16 <= bVar.f105335d.f105382b[1]) {
                        kVar.f105401n[1] = f16;
                        if (kVar.f105397j.a(1) > 0.0f) {
                            float[] fArr = bVar.f105335d.f105381a;
                            fArr[1] = fArr[1] - bVar.f105336e.f105397j.a(1);
                        }
                        if (bVar.f105336e.f105397j.a(0) > 0.0f) {
                            float[] fArr2 = bVar.f105335d.f105381a;
                            fArr2[0] = fArr2[0] - bVar.f105336e.f105397j.a(0);
                        }
                        if (bVar.f105336e.f105397j.a(2) > 0.0f) {
                            float[] fArr3 = bVar.f105335d.f105381a;
                            fArr3[2] = fArr3[2] - bVar.f105336e.f105397j.a(2);
                        }
                        if (bVar.f105336e.f105397j.a(3) > 0.0f) {
                            float[] fArr4 = bVar.f105335d.f105381a;
                            fArr4[3] = fArr4[3] - bVar.f105336e.f105397j.a(3);
                        }
                        m.h(this.f412587a, bVar, bVar.f105335d.f105382b[0], null);
                    }
                }
            }
            bVar.l0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c implements b.a {
        @Override // lk0.b.a
        public void a(lk0.b bVar) {
            if (bVar.g0().size() > 0) {
                bVar.V();
            }
        }
    }

    public static void a(lk0.b bVar, j jVar) {
        if (bVar == null) {
            return;
        }
        bVar.v0(new C10663a());
        if (jVar == null) {
            jVar = new j();
        }
        bVar.b(jVar);
        bVar.v0(new b(jVar));
    }
}
