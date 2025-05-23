package com.tencent.luggage.wxa.l8;

import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.g1;
import com.tencent.luggage.wxa.ol.h0;
import com.tencent.luggage.wxa.ol.m0;
import com.tencent.luggage.wxa.ol.s0;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i implements com.tencent.luggage.wxa.l8.b {

    /* renamed from: h, reason: collision with root package name */
    public static final a f133215h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.f f133216a;

    /* renamed from: b, reason: collision with root package name */
    public final InputConnection f133217b;

    /* renamed from: c, reason: collision with root package name */
    public final int f133218c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.vl.f f133219d;

    /* renamed from: e, reason: collision with root package name */
    public final h0 f133220e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.tl.b f133221f;

    /* renamed from: g, reason: collision with root package name */
    public s0 f133222g;

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
    public static final class b implements com.tencent.luggage.wxa.tl.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.tl.b
        public final InputConnection a() {
            return i.this.f133217b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements h0.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f133224a;

        public c(Function1 function1) {
            this.f133224a = function1;
        }

        @Override // com.tencent.luggage.wxa.ol.h0.b
        public final void a() {
            Function1 function1 = this.f133224a;
            if (function1 != null) {
            }
        }
    }

    public i(com.tencent.luggage.wxa.xd.f appBrandPage, InputConnection inputConnection, int i3) {
        com.tencent.luggage.wxa.fi.a aVar;
        Intrinsics.checkNotNullParameter(appBrandPage, "appBrandPage");
        Intrinsics.checkNotNullParameter(inputConnection, "inputConnection");
        this.f133216a = appBrandPage;
        this.f133217b = inputConnection;
        this.f133218c = i3;
        View contentView = appBrandPage.getContentView();
        if (appBrandPage instanceof v) {
            aVar = ((v) appBrandPage).z0();
        } else {
            aVar = null;
        }
        h0 a16 = h0.a(contentView, aVar);
        Intrinsics.checkNotNullExpressionValue(a16, "settleKeyboard(appBrandP\u2026dComponentView else null)");
        this.f133220e = a16;
        this.f133221f = new b();
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(int i3) {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b(boolean z16) {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public int c() {
        return this.f133220e.getMinimumHeight();
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public synchronized s0 d() {
        s0 s0Var;
        String str;
        s0Var = this.f133222g;
        if (s0Var == null) {
            com.tencent.luggage.wxa.vl.f fVar = this.f133219d;
            if (fVar != null) {
                str = fVar.R;
            } else {
                str = null;
            }
            s0Var = new com.tencent.luggage.wxa.ol.i(str, e());
            this.f133222g = s0Var;
        }
        return s0Var;
    }

    public BaseInputConnection e() {
        BaseInputConnection baseInputConnection;
        InputConnection inputConnection = this.f133217b;
        if (inputConnection instanceof BaseInputConnection) {
            baseInputConnection = (BaseInputConnection) inputConnection;
        } else {
            baseInputConnection = null;
        }
        if (baseInputConnection == null) {
            w.b("MicroMsg.WebviewExtendWcPayNumberKeyboard", "getInputConnection, inputConnection: " + this.f133217b);
            return null;
        }
        return baseInputConnection;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public com.tencent.luggage.wxa.vl.f getParams() {
        return this.f133219d;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public View getView() {
        return this.f133220e;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(String str) {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b(EditText text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(boolean z16) {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b() {
        this.f133220e.a(this.f133221f);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(f0.k listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public boolean a(EditText text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return true;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(Function1 l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.f133220e.setOnDoneListener(new c(l3));
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(com.tencent.luggage.wxa.vl.f params) {
        Intrinsics.checkNotNullParameter(params, "params");
        a((com.tencent.luggage.wxa.vl.i) params);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(com.tencent.luggage.wxa.vl.i params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.luggage.wxa.vl.f fVar = this.f133219d;
        if (fVar == null) {
            this.f133219d = (com.tencent.luggage.wxa.vl.f) params;
            return;
        }
        Intrinsics.checkNotNull(fVar);
        fVar.a(params);
        g1.f136743a.a(fVar, params);
        m0.a(fVar, params);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a() {
        this.f133220e.f();
    }
}
