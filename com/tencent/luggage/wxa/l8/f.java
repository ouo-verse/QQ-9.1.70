package com.tencent.luggage.wxa.l8;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.l8.a;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.ol.e0;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.g1;
import com.tencent.luggage.wxa.ol.s0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.g;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements com.tencent.luggage.wxa.l8.b {

    /* renamed from: k, reason: collision with root package name */
    public static final a f133194k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.f f133195a;

    /* renamed from: b, reason: collision with root package name */
    public final InputConnection f133196b;

    /* renamed from: c, reason: collision with root package name */
    public Function4 f133197c;

    /* renamed from: d, reason: collision with root package name */
    public final e0 f133198d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.vl.f f133199e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f133200f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f133201g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.l8.a f133202h;

    /* renamed from: i, reason: collision with root package name */
    public String f133203i;

    /* renamed from: j, reason: collision with root package name */
    public final g.c f133204j;

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
    public static final class b implements g.c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.c
        public final void onDestroy() {
            w.d("MicroMsg.WebviewExtendSecureKeyboard", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            com.tencent.luggage.wxa.nb.a.a().d(f.this.f133203i);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a.d {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f133207a;

            public a(f fVar) {
                this.f133207a = fVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f fVar = this.f133207a;
                fVar.a(fVar.f133202h);
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.l8.a.d
        public void a() {
            if (f.this.f133201g) {
                return;
            }
            com.tencent.luggage.wxa.zp.h.f146825d.a(new a(f.this));
        }
    }

    public f(com.tencent.luggage.wxa.xd.f appBrandPage, InputConnection inputConnection) {
        Intrinsics.checkNotNullParameter(appBrandPage, "appBrandPage");
        Intrinsics.checkNotNullParameter(inputConnection, "inputConnection");
        this.f133195a = appBrandPage;
        this.f133196b = inputConnection;
        e0.a aVar = e0.f136703h;
        View contentView = appBrandPage.getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView, "appBrandPage.contentView");
        e0 a16 = aVar.a(contentView, false, null);
        Intrinsics.checkNotNull(a16);
        this.f133198d = a16;
        Context context = appBrandPage.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "appBrandPage.context");
        this.f133202h = new com.tencent.luggage.wxa.l8.a(context, inputConnection);
        this.f133204j = new b();
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(int i3) {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b(EditText text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public /* bridge */ /* synthetic */ s0 d() {
        return (s0) e();
    }

    public Void e() {
        return null;
    }

    public final Editable f() {
        EditText attachedInputWidget = this.f133198d.getAttachedInputWidget();
        Intrinsics.checkNotNull(attachedInputWidget, "null cannot be cast to non-null type com.tencent.luggage.xweb_ext.extendplugin.input.DelegateEditText");
        return ((com.tencent.luggage.wxa.l8.a) attachedInputWidget).getRealText$luggage_xweb_ext_release();
    }

    public final void g() {
        String str;
        boolean z16;
        a.c c16;
        String str2 = this.f133203i;
        if (str2 != null && (c16 = com.tencent.luggage.wxa.nb.a.a().c(str2)) != null) {
            str = c16.a("SecureInputValue", (String) null);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !this.f133200f) {
            b(str);
        } else {
            b((String) null);
        }
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public com.tencent.luggage.wxa.vl.f getParams() {
        return this.f133199e;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public View getView() {
        return this.f133198d;
    }

    public final void h() {
        String str;
        String str2;
        Editable f16 = f();
        if (f16 != null) {
            str = f16.toString();
        } else {
            str = null;
        }
        if (str != null && (str2 = this.f133203i) != null) {
            com.tencent.luggage.wxa.nb.a.a().a(str2, true).b("SecureInputValue", str);
        }
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(boolean z16) {
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public int c() {
        return this.f133198d.getMinimumHeight();
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(f0.k listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b(boolean z16) {
        e0 e0Var = this.f133198d;
        com.tencent.luggage.wxa.xd.f fVar = this.f133195a;
        e0Var.a(z16, fVar instanceof v ? ((v) fVar).z0() : null);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public boolean a(EditText text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return true;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(Function1 l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void b() {
        String str;
        Integer num;
        this.f133201g = true;
        com.tencent.luggage.wxa.vl.f fVar = this.f133199e;
        if (fVar == null || (num = fVar.X) == null) {
            str = null;
        } else {
            str = String.format("AppBrandSecureInput#%s#%s", Arrays.copyOf(new Object[]{Integer.valueOf(this.f133195a.getComponentId()), num}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        }
        this.f133203i = str;
        this.f133195a.a(this.f133204j);
        g();
        this.f133202h.setListener(new c());
        this.f133198d.a(this.f133202h);
        this.f133201g = false;
    }

    public final void a(Function4 function4) {
        this.f133197c = function4;
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(com.tencent.luggage.wxa.vl.f params) {
        Intrinsics.checkNotNullParameter(params, "params");
        a((com.tencent.luggage.wxa.vl.i) params);
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(com.tencent.luggage.wxa.vl.i params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.luggage.wxa.vl.f fVar = this.f133199e;
        if (fVar == null) {
            this.f133199e = (com.tencent.luggage.wxa.vl.f) params;
        } else {
            Intrinsics.checkNotNull(fVar);
            fVar.a(params);
            g1.f136743a.a(fVar, params);
        }
        this.f133202h.a(this.f133199e);
    }

    public final void b(String str) {
        this.f133202h.setText(str);
        EditText attachedInputWidget = this.f133198d.getAttachedInputWidget();
        if (attachedInputWidget != null) {
            attachedInputWidget.setText(str);
        }
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a(String str) {
        if (w0.c(str)) {
            this.f133200f = true;
        }
    }

    @Override // com.tencent.luggage.wxa.l8.b
    public void a() {
        h();
        this.f133198d.h();
    }

    public final void a(com.tencent.luggage.wxa.l8.a aVar) {
        String message;
        String str = null;
        try {
            str = g.a(aVar, this.f133195a, this.f133199e);
            message = null;
        } catch (IllegalStateException e16) {
            message = e16.getMessage();
            w.d("MicroMsg.WebviewExtendSecureKeyboard", "dispatchKeyboardComplete, encryptErrorMsg: " + message);
        }
        Editable f16 = f();
        int length = f16 != null ? f16.length() : 0;
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append('*');
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        int selectionEnd = Selection.getSelectionEnd(f());
        Function4 function4 = this.f133197c;
        if (function4 != null) {
            function4.invoke(sb6, Integer.valueOf(selectionEnd), str, message);
        }
    }
}
