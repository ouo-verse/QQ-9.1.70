package c.t.m.g;

import android.os.Bundle;
import c.t.m.g.z0;

/* compiled from: P */
/* loaded from: classes.dex */
public class z implements y {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements z0.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f30124a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f30125b;

        public a(z zVar, Bundle bundle, x xVar) {
            this.f30124a = bundle;
            this.f30125b = xVar;
        }

        @Override // c.t.m.g.z0.c
        public void a(String str) {
            this.f30124a.putString("msg_fail", str);
            x xVar = this.f30125b;
            if (xVar != null) {
                xVar.a(str);
            }
        }

        @Override // c.t.m.g.z0.c
        public void b(String str) {
            this.f30124a.putString("msg_suc", str);
            x xVar = this.f30125b;
            if (xVar != null) {
                xVar.b(str);
            }
        }
    }

    @Override // c.t.m.g.y
    public Bundle a(String str, byte[] bArr, x xVar) {
        Bundle bundle = new Bundle();
        z0.a(str, bArr, new a(this, bundle, xVar));
        return bundle;
    }
}
