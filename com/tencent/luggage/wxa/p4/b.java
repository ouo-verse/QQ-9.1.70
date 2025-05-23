package com.tencent.luggage.wxa.p4;

import android.view.View;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.l8.j;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.ol.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.luggage.wxa.xd.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements x.i, g.d, g.b, g.c, com.tencent.luggage.wxa.l8.c {

    /* renamed from: g, reason: collision with root package name */
    public static final a f137224g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final v f137225a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f137226b;

    /* renamed from: c, reason: collision with root package name */
    public int f137227c;

    /* renamed from: d, reason: collision with root package name */
    public x f137228d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f137229e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f137230f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(v pv5) {
            Intrinsics.checkNotNullParameter(pv5, "pv");
            b bVar = new b(pv5, null);
            pv5.b((g.d) bVar);
            pv5.a((g.b) bVar);
            pv5.a((g.c) bVar);
        }
    }

    public /* synthetic */ b(v vVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(vVar);
    }

    public static final void a(v vVar) {
        f137224g.a(vVar);
    }

    @Override // com.tencent.luggage.wxa.l8.c
    public void c(boolean z16) {
        w.d("MicroMsg.AppBrandPageViewKeyboardHeightEmitter", "canDispatchKeyboardStatusChanged: " + z16);
        this.f137230f = z16;
    }

    @Override // com.tencent.luggage.wxa.ol.x.i
    public int getHeight() {
        return this.f137227c;
    }

    @Override // com.tencent.luggage.wxa.xd.g.b
    public void onBackground() {
        if (this.f137229e && this.f137225a.y0() != null) {
            c0 c0Var = this.f137226b;
            l y06 = this.f137225a.y0();
            Intrinsics.checkNotNullExpressionValue(y06, "mPageView.service");
            c0.a(c0Var, 0, y06, this.f137225a, null, 8, null);
        }
        x xVar = this.f137228d;
        if (xVar != null) {
            xVar.b(this);
        }
        this.f137228d = null;
        j.f133225a.b(this);
    }

    @Override // com.tencent.luggage.wxa.xd.g.c
    public void onDestroy() {
        x xVar = this.f137228d;
        if (xVar != null) {
            xVar.b(this);
        }
        j.f133225a.b(this);
    }

    @Override // com.tencent.luggage.wxa.xd.g.d
    public void onForeground() {
        if (this.f137225a.getContentView() == null) {
            return;
        }
        View contentView = this.f137225a.getContentView();
        Intrinsics.checkNotNull(contentView);
        x c16 = q.c(contentView);
        this.f137228d = c16;
        if (c16 != null) {
            c16.a(this);
        }
        j.f133225a.a(this);
    }

    public b(v vVar) {
        this.f137225a = vVar;
        this.f137226b = new c0();
        this.f137230f = true;
    }

    @Override // com.tencent.luggage.wxa.ol.x.i
    public void a(int i3) {
        this.f137227c = i3;
    }

    @Override // com.tencent.luggage.wxa.ol.x.i
    public void a(boolean z16) {
        this.f137229e = z16;
        if (this.f137230f) {
            c0 c0Var = this.f137226b;
            int i3 = z16 ? this.f137227c : 0;
            l y06 = this.f137225a.y0();
            Intrinsics.checkNotNullExpressionValue(y06, "mPageView.service");
            c0.a(c0Var, i3, y06, this.f137225a, null, 8, null);
            return;
        }
        w.d("MicroMsg.AppBrandPageViewKeyboardHeightEmitter", "onKeyboardStateChanged been called, but interrupted");
    }
}
