package com.tencent.luggage.wxa.l8;

import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.g1;
import com.tencent.luggage.wxa.ol.m0;
import com.tencent.luggage.wxa.ol.s0;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements com.tencent.luggage.wxa.l8.b {

    /* renamed from: f, reason: collision with root package name */
    public static final a f133208f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.f f133209a;

    /* renamed from: b, reason: collision with root package name */
    public final InputConnection f133210b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.vl.f f133211c;

    /* renamed from: d, reason: collision with root package name */
    public final f0 f133212d;

    /* renamed from: e, reason: collision with root package name */
    public s0 f133213e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements f0.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f133214a;

        public b(Function1 function1) {
            this.f133214a = function1;
        }

        @Override // com.tencent.luggage.wxa.ol.f0.j
        public final void a(boolean z16) {
            Function1 function1 = this.f133214a;
            if (function1 != null) {
            }
        }
    }

    public h(com.tencent.luggage.wxa.xd.f appBrandPage, InputConnection inputConnection) {
        com.tencent.luggage.wxa.fi.a aVar;
        Intrinsics.checkNotNullParameter(appBrandPage, "appBrandPage");
        this.f133209a = appBrandPage;
        this.f133210b = inputConnection;
        View contentView = appBrandPage.getContentView();
        if (appBrandPage instanceof v) {
            aVar = ((v) appBrandPage).z0();
        } else {
            aVar = null;
        }
        f0 a16 = f0.a(contentView, aVar);
        Intrinsics.checkNotNullExpressionValue(a16, "settleKeyboard(appBrandP\u2026dComponentView else null)");
        this.f133212d = a16;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a() {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b() {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public int c() {
        return this.f133212d.getMinimumHeight();
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public synchronized s0 d() {
        s0 s0Var;
        String str;
        s0Var = this.f133213e;
        if (s0Var == null) {
            com.tencent.luggage.wxa.vl.f fVar = this.f133211c;
            if (fVar != null) {
                str = fVar.R;
            } else {
                str = null;
            }
            s0Var = new com.tencent.luggage.wxa.ol.i(str, e());
            this.f133213e = s0Var;
        }
        return s0Var;
    }

    public BaseInputConnection e() {
        BaseInputConnection baseInputConnection;
        InputConnection inputConnection = this.f133210b;
        if (inputConnection instanceof BaseInputConnection) {
            baseInputConnection = (BaseInputConnection) inputConnection;
        } else {
            baseInputConnection = null;
        }
        if (baseInputConnection == null) {
            w.b("MicroMsg.WebviewExtendSoftKeyboard", "getInputConnection, inputConnection: " + this.f133210b);
            return null;
        }
        return baseInputConnection;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public com.tencent.luggage.wxa.vl.f getParams() {
        return this.f133211c;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public View getView() {
        return this.f133212d;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(String str) {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b(boolean z16) {
        this.f133212d.setComponentView(z16);
        this.f133212d.x();
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(Function1 l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.f133212d.setOnDoneListener(new b(l3));
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(boolean z16) {
        this.f133212d.a(z16);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b(EditText text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.f133212d.a(text);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(int i3) {
        this.f133212d.a(i3);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public boolean a(EditText text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return this.f133212d.b(text);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(f0.k listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f133212d.a(listener);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(com.tencent.luggage.wxa.vl.f params) {
        Intrinsics.checkNotNullParameter(params, "params");
        a((com.tencent.luggage.wxa.vl.i) params);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(com.tencent.luggage.wxa.vl.i params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.luggage.wxa.vl.f fVar = this.f133211c;
        if (fVar == null) {
            this.f133211c = (com.tencent.luggage.wxa.vl.f) params;
            return;
        }
        Intrinsics.checkNotNull(fVar);
        fVar.a(params);
        g1.f136743a.a(fVar, params);
        m0.a(fVar, params);
    }
}
