package com.tencent.luggage.wxa.p4;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.luggage.wxa.xd.u;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public int f137253b;

    /* renamed from: c, reason: collision with root package name */
    public int f137254c;

    /* renamed from: g, reason: collision with root package name */
    public final v f137258g;

    /* renamed from: a, reason: collision with root package name */
    public boolean f137252a = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f137255d = false;

    /* renamed from: e, reason: collision with root package name */
    public final Map f137256e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public boolean f137257f = false;

    /* renamed from: h, reason: collision with root package name */
    public final u f137259h = new u();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends u {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAppRouteResized";

        public b() {
        }
    }

    public e(v vVar) {
        this.f137258g = vVar;
    }

    public void a(boolean z16) {
        this.f137257f = z16;
    }

    public final View b() {
        return this.f137258g.q0();
    }

    public final b.e c() {
        return this.f137258g.r0();
    }

    public final l d() {
        return this.f137258g.y0();
    }

    public final String e() {
        return this.f137258g.A0();
    }

    public final String f() {
        return this.f137258g.C0();
    }

    public final boolean g() {
        boolean isInMultiWindowMode;
        if ((this.f137258g.D() instanceof WindowAndroidActivityImpl) && Build.VERSION.SDK_INT >= 24 && this.f137258g.a0() != null) {
            isInMultiWindowMode = this.f137258g.a0().isInMultiWindowMode();
            if (!isInMultiWindowMode) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean h() {
        return this.f137258g.isRunning();
    }

    public void i() {
        this.f137255d = false;
    }

    public void j() {
        if (this.f137252a) {
            w.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", a(), e());
            l();
            this.f137252a = false;
        }
        this.f137255d = true;
    }

    public final Map k() {
        HashMap hashMap = new HashMap(this.f137256e);
        this.f137256e.clear();
        return hashMap;
    }

    public final void l() {
        if (!h()) {
            return;
        }
        if (this.f137257f) {
            a(new b());
            this.f137257f = false;
            w.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", a(), e(), f());
            return;
        }
        a(this.f137259h);
    }

    public void a(Map map) {
        if (map != null) {
            this.f137256e.putAll(map);
        }
    }

    public final String a() {
        return this.f137258g.getAppId();
    }

    public final boolean a(int i3, int i16) {
        boolean z16;
        e.b a16 = this.f137258g.h0() != null ? this.f137258g.h0().a() : null;
        if (a16 == null) {
            a16 = e.b.a(f());
        }
        if (a16 == null) {
            a16 = e.b.PORTRAIT;
        }
        if (ArrayUtils.contains(e.b.f144275h, a16)) {
            return i3 > i16;
        }
        e.b bVar = e.b.PORTRAIT;
        if (bVar != a16) {
            return true;
        }
        if (i16 > i3) {
            return true;
        }
        if (!g()) {
            return false;
        }
        if (this.f137258g.D().getOrientationHandler().a() == bVar || this.f137258g.a0().getRequestedOrientation() == 1) {
            if ((i3 > 0) & (i16 > 0)) {
                z16 = true;
                w.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
                return z16;
            }
        }
        z16 = false;
        w.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        return z16;
    }

    public void a(l lVar) {
        int width = b().getWidth();
        int height = b().getHeight();
        if (width <= 0 || height <= 0) {
            w.b("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", Integer.valueOf(width), Integer.valueOf(height), a(), e());
            return;
        }
        boolean z16 = (width == this.f137253b && height == this.f137254c) ? false : true;
        this.f137253b = width;
        this.f137254c = height;
        int[] a16 = n0.a((i) this.f137258g);
        boolean z17 = a(width, height) && a(a16[0], a16[1]);
        boolean z18 = (this.f137253b == 0 || this.f137254c == 0) ? false : true;
        boolean z19 = (z18 && z16 && z17) || (this.f137257f && z17);
        w.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], shouldDispatch[%b], this.needDispatch[%b]", a(), e(), Boolean.valueOf(z18), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(this.f137255d), Boolean.valueOf(z19), Boolean.valueOf(this.f137252a));
        if (!z19 && this.f137257f) {
            w.b("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], window[%d x %d], screen[%d x %d]", a(), e(), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(a16[0]), Integer.valueOf(a16[1]));
        }
        if (z19) {
            if (this.f137255d) {
                l();
                return;
            } else {
                this.f137252a = true;
                return;
            }
        }
        this.f137252a = false;
    }

    public final void a(u uVar) {
        b.e c16 = c();
        if (c16 == null) {
            return;
        }
        int[] a16 = n0.a((i) d());
        Map k3 = k();
        String str = c16.f125694n;
        String f16 = f();
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(f16)) {
            k3.put("originalPageOrientation", str);
            k3.put("lastPageOrientation", f16);
        }
        v vVar = this.f137258g;
        uVar.a(vVar, vVar.getComponentId(), this.f137258g.q0().getWidth(), this.f137258g.q0().getHeight(), a16[0], a16[1], this.f137258g.D().getOrientationHandler().a(), k3);
    }
}
