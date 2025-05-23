package kx;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    com.tencent.biz.troop.b f413343a;

    public a(com.tencent.biz.troop.b bVar) {
        this.f413343a = bVar;
    }

    public void a(ITroopMemberApiClientApi.a aVar) {
        if (aVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(b.f413344e, 7);
        bundle.putInt("seq", this.f413343a.d(aVar));
        this.f413343a.y0(8, bundle);
    }

    public void b(ITroopMemberApiClientApi.a aVar) {
        if (aVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(b.f413344e, 6);
        bundle.putInt("seq", this.f413343a.d(aVar));
        this.f413343a.y0(8, bundle);
    }

    public void c(ITroopMemberApiClientApi.a aVar) {
        if (aVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(b.f413344e, 4);
        bundle.putInt("seq", this.f413343a.d(aVar));
        this.f413343a.y0(8, bundle);
    }

    public void d(Bundle bundle) {
        int i3;
        ITroopMemberApiClientApi.a l06;
        if (bundle != null && (i3 = bundle.getInt("seq", -1)) != -1 && (l06 = this.f413343a.l0(i3)) != null) {
            l06.callback(bundle);
        }
    }

    public void e() {
        Bundle bundle = new Bundle();
        bundle.putInt(b.f413344e, 2);
        this.f413343a.y0(8, bundle);
    }

    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt(b.f413344e, 3);
        this.f413343a.y0(8, bundle);
    }

    public void g(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(b.f413344e, 5);
        bundle.putInt("mode", i3);
        this.f413343a.y0(8, bundle);
    }

    public void h(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(b.f413344e, 1);
        bundle.putString("music", str);
        this.f413343a.y0(8, bundle);
    }

    public void i() {
        Bundle bundle = new Bundle();
        bundle.putInt(b.f413344e, 8);
        this.f413343a.y0(8, bundle);
    }
}
