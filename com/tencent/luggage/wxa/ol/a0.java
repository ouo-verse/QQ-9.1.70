package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.ol.b0;
import com.tencent.luggage.wxa.ol.e0;
import com.tencent.luggage.wxa.qo.a;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a0 extends com.tencent.luggage.wxa.ol.c {
    public boolean C;
    public boolean D;
    public boolean E;

    /* renamed from: i, reason: collision with root package name */
    public final String f136647i;

    /* renamed from: j, reason: collision with root package name */
    public final String f136648j;

    /* renamed from: k, reason: collision with root package name */
    public b0 f136649k;

    /* renamed from: l, reason: collision with root package name */
    public e0 f136650l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.vl.i f136651m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements g.c {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.c
        public final void onDestroy() {
            com.tencent.luggage.wxa.tn.w.d(a0.this.f136647i, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            com.tencent.luggage.wxa.nb.a.a().d(a0.this.f136648j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements b0.c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ol.b0.c
        public void a() {
            a0.this.c(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e0.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.ol.e0.b
        public void a() {
            com.tencent.luggage.wxa.tn.w.a(a0.this.f136647i, "onDone#OnDoneListener");
            a0.this.a(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f136656b;

        public d(Integer num) {
            this.f136656b = num;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Integer num;
            b0 b0Var = a0.this.f136649k;
            if (b0Var != null && (num = this.f136656b) != null) {
                int intValue = num.intValue();
                com.tencent.luggage.wxa.tn.w.d(a0.this.f136647i, "updateStyle, maxLength: " + intValue);
                s.a(b0Var).b(intValue).a(false).a(a.EnumC6654a.MODE_CHINESE_AS_1).a((b.a) null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(String inputType, com.tencent.luggage.wxa.kj.v pageView, com.tencent.luggage.wxa.vl.f inputParams) {
        super(inputType, pageView, inputParams.Q);
        String str;
        b0 b0Var;
        a.c c16;
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(inputParams, "inputParams");
        String str2 = "MicroMsg.AppBrand.AppBrandSecureInputComponent#" + this.f136668c;
        this.f136647i = str2;
        Integer num = inputParams.X;
        boolean z16 = true;
        String str3 = null;
        if (num != null) {
            str = String.format("AppBrandSecureInput#%s#%s", Arrays.copyOf(new Object[]{Integer.valueOf(pageView.getComponentId()), num}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        } else {
            str = null;
        }
        this.f136648j = str;
        Context context = pageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "pageView.context");
        this.f136649k = new b0(context);
        com.tencent.luggage.wxa.tn.w.a(str2, "<init>, inputType: " + inputType + ", inputId: " + this.f136668c + ", sessionId: " + str);
        pageView.a(new a());
        b0 b0Var2 = this.f136649k;
        if (b0Var2 != null) {
            b0Var2.setListener(new b());
        }
        if (str != null && (c16 = com.tencent.luggage.wxa.nb.a.a().c(str)) != null) {
            str3 = c16.a("SecureInputValue", (String) null);
        }
        if (str3 != null && str3.length() != 0) {
            z16 = false;
        }
        if (!z16 && (b0Var = this.f136649k) != null) {
            b0Var.setText(str3);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.c, com.tencent.luggage.wxa.ol.p0
    public Editable currentValue() {
        Editable currentValue = super.currentValue();
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "currentValue, curVal: " + ((Object) currentValue));
        return currentValue;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean e() {
        boolean z16;
        com.tencent.luggage.wxa.vl.i iVar = this.f136651m;
        if (iVar != null) {
            z16 = Intrinsics.areEqual(Boolean.TRUE, iVar.B);
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "adjustPositionOnFocused, adjustPos: " + z16);
        return z16;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public View getInputPanel() {
        e0 r16 = r();
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "getInputPanel, keyboardPanel: " + r16);
        return r16;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public Rect j() {
        com.tencent.luggage.wxa.vl.i iVar = this.f136651m;
        if (iVar == null) {
            return null;
        }
        Integer num = iVar.f143667e;
        Intrinsics.checkNotNullExpressionValue(num, "styleSnapshot.inputLeft");
        int intValue = num.intValue();
        Integer num2 = iVar.f143666d;
        Intrinsics.checkNotNullExpressionValue(num2, "styleSnapshot.inputTop");
        int intValue2 = num2.intValue();
        int intValue3 = iVar.f143667e.intValue();
        Integer num3 = iVar.f143664b;
        Intrinsics.checkNotNullExpressionValue(num3, "styleSnapshot.inputWidth");
        int intValue4 = intValue3 + num3.intValue();
        int intValue5 = iVar.f143666d.intValue();
        Integer num4 = iVar.f143665c;
        Intrinsics.checkNotNullExpressionValue(num4, "styleSnapshot.inputHeight");
        return new Rect(intValue, intValue2, intValue4, intValue5 + num4.intValue());
    }

    public final void p() {
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "clearInputWidgetFocus, inputWidget: " + this.f136649k);
        b0 b0Var = this.f136649k;
        if (b0Var != null) {
            b0Var.setFocusable(false);
            b0Var.setFocusableInTouchMode(false);
            b0Var.setEnabled(false);
        }
    }

    public final void q() {
        boolean t16 = t();
        if (!this.D && !t16) {
            this.D = true;
            a(-2, -2, this.C);
            this.D = false;
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(this.f136647i, "doShowKeyboard, performingShowKeyboard: " + this.D + ", isFocused: " + t16);
    }

    public final e0 r() {
        e0 e0Var;
        if (this.f136650l == null) {
            b0 b0Var = this.f136649k;
            if (b0Var != null) {
                e0Var = b0Var.getInputPanel();
            } else {
                e0Var = null;
            }
            this.f136650l = e0Var;
        }
        return this.f136650l;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public b0 i() {
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "getInput, inputWidget: " + this.f136649k);
        return this.f136649k;
    }

    public boolean t() {
        boolean z16;
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, HippyTextInputController.COMMAND_IS_FOCUSED);
        b0 b0Var = this.f136649k;
        if (b0Var == null) {
            com.tencent.luggage.wxa.tn.w.a(this.f136647i, "isFocused, inputWidget is null");
            return false;
        }
        if (true == b0Var.isFocused()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.luggage.wxa.tn.w.a(this.f136647i, "isFocused, inputWidget focused");
            return true;
        }
        e0 r16 = r();
        if (r16 == null) {
            com.tencent.luggage.wxa.tn.w.a(this.f136647i, "isFocused, keyboardPanel is null");
            return false;
        }
        if (!r16.isShown()) {
            com.tencent.luggage.wxa.tn.w.a(this.f136647i, "isFocused, keyboardPanel is not shown");
            return false;
        }
        return Intrinsics.areEqual(r16.getAttachedInputWidget(), this.f136649k);
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public com.tencent.luggage.wxa.vl.i b(com.tencent.luggage.wxa.vl.i params) {
        b0 b0Var;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, IECSearchBar.METHOD_UPDATE_STYLE);
        com.tencent.luggage.wxa.vl.i iVar = this.f136651m;
        if (iVar == null) {
            this.f136651m = params;
        } else {
            iVar.a(params);
            g1.f136743a.a(iVar, params);
        }
        b0 b0Var2 = this.f136649k;
        if (b0Var2 == null) {
            return null;
        }
        com.tencent.luggage.wxa.ol.b.a(b0Var2, this.f136651m);
        com.tencent.luggage.wxa.vl.i iVar2 = this.f136651m;
        Integer num = iVar2 != null ? iVar2.I : null;
        if (num != null && (b0Var = this.f136649k) != null) {
            b0Var.setLength$luggage_wxa_app_input_ext_release(num.intValue());
        }
        com.tencent.luggage.wxa.zp.h.f146825d.a(new d(num));
        return this.f136651m;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public int c() {
        com.tencent.luggage.wxa.vl.i iVar = this.f136651m;
        Integer num = iVar != null ? iVar.f143687y : null;
        int intValue = num == null ? 0 : num.intValue();
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "getInputPanelMarginBottom, marginBottom: " + intValue);
        return intValue;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a(int i3, int i16, boolean z16) {
        e0 e0Var;
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "showKeyboard, selectionStart: " + i3 + ", selectionEnd: " + i16 + ", forceLightMode: " + z16);
        if (this.f136649k == null) {
            com.tencent.luggage.wxa.tn.w.d(this.f136647i, "showKeyboard, inputWidget is null");
            return false;
        }
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136670e.get();
        View contentView = vVar != null ? vVar.getContentView() : null;
        if (contentView == null) {
            com.tencent.luggage.wxa.tn.w.f(this.f136647i, "showKeyboard, pageContentView is null");
            return false;
        }
        e0.a aVar = e0.f136703h;
        com.tencent.luggage.wxa.vl.i iVar = this.f136651m;
        Boolean bool = iVar != null ? iVar.G : null;
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        com.tencent.luggage.wxa.kj.v vVar2 = (com.tencent.luggage.wxa.kj.v) this.f136670e.get();
        e0 a16 = aVar.a(contentView, booleanValue, vVar2 != null ? vVar2.z0() : null);
        this.f136650l = a16;
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(this.f136647i, "showKeyboard, keyboardPanel is null");
            return false;
        }
        this.D = true;
        f();
        this.C = z16;
        if (z16 && (e0Var = this.f136650l) != null) {
            e0Var.g();
        }
        e0 e0Var2 = this.f136650l;
        if (e0Var2 != null) {
            e0Var2.a(this.f136649k);
        }
        e0 e0Var3 = this.f136650l;
        if (e0Var3 != null) {
            e0Var3.setOnDoneListener(new c());
        }
        a(i3, i16);
        k();
        this.D = false;
        return true;
    }

    public final void c(boolean z16) {
        String str;
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "doHideKeyboard, isInputDone: " + z16);
        boolean t16 = t();
        if (!this.E && t16) {
            this.E = true;
            b(z16);
            b0 b0Var = this.f136649k;
            String realText$luggage_wxa_app_input_ext_release = b0Var != null ? b0Var.getRealText$luggage_wxa_app_input_ext_release() : null;
            if (realText$luggage_wxa_app_input_ext_release != null && (str = this.f136648j) != null) {
                com.tencent.luggage.wxa.nb.a.a().a(str, true).b("SecureInputValue", realText$luggage_wxa_app_input_ext_release);
            }
            a();
            l();
            this.E = false;
            this.f136649k = null;
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(this.f136647i, "doHideKeyboard, performingHideKeyboard: " + this.E + ", isFocused: " + t16);
    }

    public final void b(boolean z16) {
        String message;
        if (!z16) {
            b(currentValue());
            return;
        }
        String str = null;
        try {
            str = c0.a(this.f136649k, (com.tencent.luggage.wxa.kj.v) this.f136670e.get(), this.f136651m);
            message = null;
        } catch (IllegalStateException e16) {
            message = e16.getMessage();
            com.tencent.luggage.wxa.tn.w.d(this.f136647i, "dispatchKeyboardComplete, encryptErrorMsg: " + message);
        }
        a(currentValue(), str, message);
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a() {
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "hideKeyboard");
        e0 r16 = r();
        if (r16 == null) {
            com.tencent.luggage.wxa.tn.w.d(this.f136647i, "hideKeyboardInternal, keyboardPanel is null");
            return false;
        }
        if (!t()) {
            return false;
        }
        r16.h();
        p();
        o();
        n();
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public boolean a(boolean z16) {
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "onFocusChanged, hasFocus: " + z16);
        if (!z16) {
            c(false);
            return true;
        }
        q();
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public boolean a(String str) {
        com.tencent.luggage.wxa.tn.w.a(this.f136647i, "updateValue, value: " + str);
        if (!(str == null || str.length() == 0)) {
            return false;
        }
        b0 b0Var = this.f136649k;
        if (b0Var != null) {
            b0Var.setText(str);
        }
        return true;
    }
}
