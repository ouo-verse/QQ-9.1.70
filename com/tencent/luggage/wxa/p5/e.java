package com.tencent.luggage.wxa.p5;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ei.z;
import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.fd.t;
import com.tencent.luggage.wxa.j4.a;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.kj.x;
import com.tencent.luggage.wxa.n5.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.ConstValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.m4.b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.vi.a {
        public a(int i3) {
            super(i3);
        }

        @Override // com.tencent.luggage.wxa.vi.a
        public void a(Context context, v vVar, com.tencent.luggage.wxa.mo.h hVar, String str) {
            hVar.add(a(), R.string.f167872e4);
        }

        @Override // com.tencent.luggage.wxa.vi.a
        public void a(Context context, v vVar, String str, com.tencent.luggage.wxa.ui.a aVar) {
            com.tencent.luggage.wxa.c3.a aVar2 = new com.tencent.luggage.wxa.c3.a();
            q j06 = vVar.getRuntime().j0();
            HashMap hashMap = new HashMap();
            hashMap.put("title", j06.f125955a);
            hashMap.put("desc", "");
            hashMap.put("path", vVar.B0());
            hashMap.put("imgUrl", vVar.getRuntime().S().f125810c);
            hashMap.put("mode", "common");
            aVar2.setContext(vVar.getRuntime().h0(), vVar.getComponentId()).setData(hashMap).dispatch();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends com.tencent.luggage.wxa.vi.a {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements b.e {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.n5.b.e
            public void a(int i3, String str, int i16) {
                com.tencent.luggage.wxa.s2.a.a(e.this.getRuntime(), i16);
            }
        }

        public b(int i3) {
            super(i3);
        }

        @Override // com.tencent.luggage.wxa.vi.a
        public void a(Context context, v vVar, com.tencent.luggage.wxa.mo.h hVar, String str) {
            hVar.add(a(), R.string.f167852e2);
        }

        @Override // com.tencent.luggage.wxa.vi.a
        public void a(Context context, v vVar, String str, com.tencent.luggage.wxa.ui.a aVar) {
            q j06 = vVar.getRuntime().j0();
            com.tencent.luggage.wxa.k5.i.a(vVar, e.this.getAppId(), ((com.tencent.luggage.wxa.j4.d) vVar.getRuntime().S()).G, j06.f125955a, vVar.getRuntime().n0().isLargeScreenWindow(), new a());
        }
    }

    @Deprecated
    public e() {
        this(com.tencent.luggage.wxa.z5.c.class);
    }

    @Override // com.tencent.luggage.wxa.m4.b
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.f3.a q1() {
        try {
            View findViewById = getContentView().findViewById(R.id.srk);
            if (findViewById instanceof com.tencent.luggage.wxa.f3.a) {
                return (com.tencent.luggage.wxa.f3.a) findViewById;
            }
        } catch (NullPointerException unused) {
        }
        return null;
    }

    public final void D1() {
        if (z.a((v) this) && !P0()) {
            w.d("Luggage.PageView[applaunch]", "page initNativeTransLogic");
            com.tencent.luggage.wxa.fm.b.a();
            z.a(getJsRuntime(), getComponentId(), getAppId());
            z.b(getJsRuntime(), getComponentId(), getAppId());
        }
    }

    @Override // com.tencent.luggage.wxa.m4.b, com.tencent.luggage.wxa.kj.v
    public boolean L0() {
        if (!super.L0() && ((com.tencent.luggage.wxa.j4.a) a(com.tencent.luggage.wxa.j4.a.class)).f130781b != a.EnumC6326a.FULLSCREEN) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public List S() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.luggage.wxa.ui.a(new a(com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal())));
        arrayList.add(new com.tencent.luggage.wxa.ui.a(new b(com.tencent.luggage.wxa.ui.b.Setting.ordinal())));
        if (t.a(getRuntime())) {
            arrayList.add(new com.tencent.luggage.wxa.ui.a(new com.tencent.luggage.wxa.x5.a()));
        }
        return arrayList;
    }

    @Override // com.tencent.luggage.wxa.m4.b, com.tencent.luggage.wxa.kj.v
    public boolean a(long j3, String str, k1 k1Var) {
        a(getRuntime().n0());
        return super.a(j3, str, k1Var);
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public void b(Context context) {
        super.b(context);
        if (D0() != null) {
            D0().a(context);
        }
        com.tencent.luggage.wxa.f3.a q16 = q1();
        if (q16 != null) {
            q16.a(context);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public void t() {
        super.t();
        D1();
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public Bitmap w0() {
        com.tencent.luggage.wxa.z1.d dVar = (com.tencent.luggage.wxa.z1.d) f(com.tencent.luggage.wxa.z1.d.class);
        if (dVar == null) {
            return super.w0();
        }
        try {
            Bitmap b16 = dVar.c().getMagicBrush().s().b();
            FrameLayout q06 = q0();
            if (b16 != null && q06 != null && q06.isLaidOut()) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b16, q0().getMeasuredWidth(), q0().getMeasuredHeight(), false);
                b16.recycle();
                return createScaledBitmap;
            }
            return b16;
        } catch (NullPointerException | OutOfMemoryError e16) {
            w.a("AppBrandPageView", e16, "getScreenshotWithoutDecor fail", new Object[0]);
            return null;
        }
    }

    public e(@Nullable Class<? extends x> cls) {
        super(cls, null);
        a(com.tencent.luggage.wxa.mc.w.a());
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public final void a(com.tencent.luggage.wxa.wj.c cVar) {
        if (cVar == null || D() == null || cVar.compareTo(D()) != 0) {
            super.a(cVar);
            if (cVar != null) {
                Context a16 = com.tencent.luggage.wxa.bo.a.a(cVar.getContext());
                if (a16 == null) {
                    a16 = cVar.getContext();
                }
                b(a16);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.m4.b, com.tencent.luggage.wxa.kj.v
    public void a(Context context, com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar instanceof f) {
            a(new com.tencent.luggage.wxa.ic.c(gVar, this, ((f) gVar).B1()));
        }
        super.a(context, gVar);
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(jSONObject, ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, Integer.valueOf(com.tencent.luggage.wxa.tn.e.f141563e));
        com.tencent.luggage.wxa.sd.a.d(true, jSONObject);
        com.tencent.luggage.wxa.sd.a.a(com.tencent.luggage.wxa.pq.a.b(getContext()), jSONObject);
        com.tencent.luggage.wxa.sd.a.e(com.tencent.luggage.wxa.pq.a.b(getContext()), jSONObject);
        com.tencent.luggage.wxa.sd.a.g(true, jSONObject);
        com.tencent.luggage.wxa.sd.a.b(true, jSONObject);
        com.tencent.luggage.wxa.sd.a.f(true, jSONObject);
        com.tencent.luggage.wxa.sd.a.h(false, jSONObject);
        com.tencent.luggage.wxa.sd.a.c(XWebSdk.isCurrentVersionSupportCustomTextAreaForAppbrand() && XWebSdk.isXWebView(), jSONObject);
    }
}
