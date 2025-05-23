package com.tencent.luggage.wxa.uj;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.hn.h1;
import com.tencent.luggage.wxa.hn.v9;
import com.tencent.luggage.wxa.rj.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uj.i;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeViewNew;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.api.MiniConst;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t implements com.tencent.luggage.wxa.ml.m, com.tencent.luggage.wxa.rj.e {
    public static final d H = new d(null);
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final ImageView F;
    public e G;

    /* renamed from: a, reason: collision with root package name */
    public final Context f142607a;

    /* renamed from: b, reason: collision with root package name */
    public final int f142608b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.wj.c f142609c;

    /* renamed from: d, reason: collision with root package name */
    public final String f142610d;

    /* renamed from: e, reason: collision with root package name */
    public q f142611e;

    /* renamed from: f, reason: collision with root package name */
    public final k f142612f;

    /* renamed from: g, reason: collision with root package name */
    public final i.a f142613g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.ml.r f142614h;

    /* renamed from: i, reason: collision with root package name */
    public final int f142615i;

    /* renamed from: j, reason: collision with root package name */
    public int f142616j;

    /* renamed from: k, reason: collision with root package name */
    public final View f142617k;

    /* renamed from: l, reason: collision with root package name */
    public final FrameLayout f142618l;

    /* renamed from: m, reason: collision with root package name */
    public final EditVerifyCodeViewNew f142619m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            t.this.c("user cancel");
            com.tencent.luggage.wxa.ml.r rVar = t.this.f142614h;
            if (rVar != null) {
                rVar.b(t.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements View.OnLayoutChangeListener {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t f142622a;

            public a(t tVar) {
                this.f142622a = tVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f142622a.f142618l.getLayoutParams().height = this.f142622a.f142616j;
            }
        }

        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (Math.abs(i18 - i16) > t.this.f142616j && t.this.f142616j >= t.this.f142615i) {
                t.this.f142618l.post(new a(t.this));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements EditVerifyCodeViewNew.e {
        public c() {
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeViewNew.e
        public final void a(String str) {
            String str2;
            t tVar = t.this;
            EditVerifyCodeViewNew editVerifyCodeViewNew = tVar.f142619m;
            if (editVerifyCodeViewNew != null) {
                str2 = editVerifyCodeViewNew.getText();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            tVar.n(str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {
        public d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class e extends CountDownTimer {
        public e(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            t.this.f();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            t.this.C.setText(t.this.f142607a.getString(R.string.yyp, "" + (j3 / 1000)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends ClickableSpan {
        public f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
            if (t.this.f142612f.a()) {
                t.this.h();
                return;
            }
            t tVar = t.this;
            String string = tVar.f142607a.getString(R.string.yys);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026end_verify_code_frequent)");
            tVar.m(string);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f142627b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v9 f142628a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f142629b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ProgressDialog f142630c;

            public a(v9 v9Var, t tVar, ProgressDialog progressDialog) {
                this.f142628a = v9Var;
                this.f142629b = tVar;
                this.f142630c = progressDialog;
            }

            @Override // java.lang.Runnable
            public final void run() {
                v9 v9Var = this.f142628a;
                if (v9Var == null) {
                    this.f142629b.c(com.tencent.luggage.wxa.uj.g.f142469a.e());
                } else {
                    this.f142629b.c(v9Var.f128900e);
                }
                this.f142629b.f142619m.b();
                this.f142630c.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ProgressDialog progressDialog) {
            super(1);
            this.f142627b = progressDialog;
        }

        public final void a(v9 v9Var) {
            com.tencent.luggage.wxa.tk.l.a(new a(v9Var, t.this, this.f142627b));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((v9) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f142632b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v9 f142633a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f142634b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ProgressDialog f142635c;

            public a(v9 v9Var, t tVar, ProgressDialog progressDialog) {
                this.f142633a = v9Var;
                this.f142634b = tVar;
                this.f142635c = progressDialog;
            }

            @Override // java.lang.Runnable
            public final void run() {
                v9 v9Var = this.f142633a;
                if (v9Var == null) {
                    this.f142634b.c(com.tencent.luggage.wxa.uj.g.f142469a.e());
                } else {
                    this.f142634b.c(v9Var.f128900e);
                }
                this.f142634b.f142619m.b();
                this.f142635c.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ProgressDialog progressDialog) {
            super(1);
            this.f142632b = progressDialog;
        }

        public final void a(v9 v9Var) {
            com.tencent.luggage.wxa.tk.l.a(new a(v9Var, t.this, this.f142632b));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((v9) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f142637b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h1 f142638a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f142639b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ProgressDialog f142640c;

            public a(h1 h1Var, t tVar, ProgressDialog progressDialog) {
                this.f142638a = h1Var;
                this.f142639b = tVar;
                this.f142640c = progressDialog;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h1 h1Var = this.f142638a;
                if (h1Var == null) {
                    this.f142639b.a(com.tencent.luggage.wxa.uj.g.f142469a.e(), "", "", "", "");
                } else {
                    this.f142639b.a(h1Var.f127733e, h1Var.f127734f, h1Var.f127735g, h1Var.f127737i, h1Var.f127738j);
                }
                this.f142640c.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ProgressDialog progressDialog) {
            super(1);
            this.f142637b = progressDialog;
        }

        public final void a(h1 h1Var) {
            com.tencent.luggage.wxa.tk.l.a(new a(h1Var, t.this, this.f142637b));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h1) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f142641a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f142642b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h1 f142643a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f142644b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ProgressDialog f142645c;

            public a(h1 h1Var, t tVar, ProgressDialog progressDialog) {
                this.f142643a = h1Var;
                this.f142644b = tVar;
                this.f142645c = progressDialog;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h1 h1Var = this.f142643a;
                if (h1Var == null) {
                    this.f142644b.a(com.tencent.luggage.wxa.uj.g.f142469a.e(), "", "", "", "");
                } else {
                    this.f142644b.a(h1Var.f127733e, h1Var.f127734f, h1Var.f127735g, h1Var.f127737i, h1Var.f127738j);
                }
                this.f142645c.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ProgressDialog progressDialog, t tVar) {
            super(1);
            this.f142641a = progressDialog;
            this.f142642b = tVar;
        }

        public final void a(h1 h1Var) {
            com.tencent.luggage.wxa.tk.l.a(new a(h1Var, this.f142642b, this.f142641a));
            this.f142641a.dismiss();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h1) obj);
            return Unit.INSTANCE;
        }
    }

    public t(Context context, int i3, com.tencent.luggage.wxa.wj.c windowAndroid, String appId, q qVar, k phoneItem, i.a aVar) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(phoneItem, "phoneItem");
        this.f142607a = context;
        this.f142608b = i3;
        this.f142609c = windowAndroid;
        this.f142610d = appId;
        this.f142611e = qVar;
        this.f142612f = phoneItem;
        this.f142613g = aVar;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(com.tencent.luggage.wxa.lo.o.a(context, 360), i3);
        this.f142615i = coerceAtLeast;
        this.f142616j = e();
        w.d("Luggage.FULL.PhoneNumberVerifyCodeDialogNew", "candidateMinHeight:%d", Integer.valueOf(i3));
        View inflate = View.inflate(context, R.layout.dy7, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026mber_verify_dialog, null)");
        this.f142617k = inflate;
        View findViewById = inflate.findViewById(R.id.st5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026nd_verify_code_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.f142618l = frameLayout;
        View findViewById2 = inflate.findViewById(R.id.st9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026p_brand_verify_code_view)");
        EditVerifyCodeViewNew editVerifyCodeViewNew = (EditVerifyCodeViewNew) findViewById2;
        this.f142619m = editVerifyCodeViewNew;
        View findViewById3 = inflate.findViewById(R.id.st6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026p_brand_verify_code_desc)");
        this.C = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.st7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026verify_code_phone_number)");
        this.D = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.st8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_brand_verify_code_title)");
        this.E = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f164372st4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026p_brand_verify_code_back)");
        ImageView imageView = (ImageView) findViewById6;
        this.F = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new a());
        }
        frameLayout.setMinimumHeight(coerceAtLeast);
        frameLayout.addOnLayoutChangeListener(new b());
        editVerifyCodeViewNew.setCodeEditCompleteListener(new c());
    }

    @Override // com.tencent.luggage.wxa.rj.e
    public /* synthetic */ com.tencent.luggage.wxa.ml.r a(com.tencent.luggage.wxa.ic.d dVar) {
        return u.a(this, dVar);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return true;
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        com.tencent.luggage.wxa.ml.r rVar = this.f142614h;
        if (rVar != null) {
            rVar.b(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return this.f142617k;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return 2;
    }

    public final void m(String str) {
        this.f142619m.setText("");
        this.E.setText(str);
        this.E.setTextColor(this.f142607a.getResources().getColor(R.color.ax6));
        f();
    }

    public final void n(String str) {
        w.d("Luggage.FULL.PhoneNumberVerifyCodeDialogNew", "doVerifyCode: code:" + str);
        q qVar = this.f142611e;
        if (qVar != null) {
            Long valueOf = Long.valueOf(qVar.j());
            Intrinsics.checkNotNull(valueOf);
            qVar.l(valueOf.longValue() + 1);
        }
        Context context = this.f142607a;
        ProgressDialog a16 = com.tencent.luggage.wxa.uk.n.a(context, (CharSequence) context.getString(R.string.z4i), true, (DialogInterface.OnCancelListener) null);
        if (this.f142612f.j()) {
            new com.tencent.luggage.wxa.uj.c(this.f142610d, this.f142612f.f(), str).a(new i(a16));
        } else {
            new com.tencent.luggage.wxa.uj.b(this.f142610d, this.f142612f.f(), str).a(new j(a16, this));
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
        com.tencent.luggage.wxa.jl.a.a(this.f142617k);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return false;
    }

    public final void d() {
        Object systemService = this.f142607a.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            com.tencent.luggage.wxa.ml.t tVar = com.tencent.luggage.wxa.ml.t.f134779a;
            Context context = getContentView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
            com.tencent.luggage.wxa.ml.t.a(tVar, context, getContentView(), null, windowManager.getDefaultDisplay().getRotation(), this.f142609c, false, 32, null);
        }
    }

    public final int e() {
        int i3 = (int) (this.f142607a.getResources().getDisplayMetrics().heightPixels * (2 == this.f142607a.getResources().getConfiguration().orientation ? 1.0f : 0.75f));
        w.d("Luggage.FULL.PhoneNumberVerifyCodeDialogNew", "calculateMaxHeight, maxHeight: " + i3);
        return i3;
    }

    public final void f() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f142607a.getString(R.string.yyq));
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(new f(), 0, length, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f142607a.getResources().getColor(R.color.aud)), 0, length, 17);
        this.C.setText(spannableStringBuilder);
        this.C.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void g() {
        this.f142619m.setText("");
        this.E.setText(this.f142607a.getResources().getText(R.string.z1s));
        this.E.setTextColor(this.f142607a.getResources().getColor(R.color.c7u));
        this.D.setText(this.f142607a.getString(R.string.f170358yz0, this.f142612f.h()));
    }

    public final void h() {
        g();
        Context context = this.f142607a;
        ProgressDialog a16 = com.tencent.luggage.wxa.uk.n.a(context, (CharSequence) context.getString(R.string.z4g), true, (DialogInterface.OnCancelListener) null);
        if (this.f142612f.j()) {
            new com.tencent.luggage.wxa.uj.f(this.f142610d, this.f142612f.f()).a(new g(a16));
        } else {
            new com.tencent.luggage.wxa.uj.e(this.f142610d, this.f142612f.f()).a(new h(a16));
        }
    }

    public final void i() {
        w.d("Luggage.FULL.PhoneNumberVerifyCodeDialogNew", "startSmsListener");
        e eVar = this.G;
        if (eVar != null) {
            eVar.cancel();
        } else {
            this.G = new e(60000L, 1000L);
        }
        e eVar2 = this.G;
        if (eVar2 != null) {
            eVar2.start();
        }
    }

    public final void j() {
        w.d("Luggage.FULL.PhoneNumberVerifyCodeDialogNew", "stopSmsListener");
        e eVar = this.G;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // com.tencent.luggage.wxa.rj.e
    public void b(com.tencent.luggage.wxa.ic.d component) {
        Intrinsics.checkNotNullParameter(component, "component");
        a(component).a(this);
        h();
    }

    public final void c(int i3) {
        w.d("Luggage.FULL.PhoneNumberVerifyCodeDialogNew", "processSendSmsResp:%d", Integer.valueOf(i3));
        com.tencent.luggage.wxa.uj.g gVar = com.tencent.luggage.wxa.uj.g.f142469a;
        if (i3 == gVar.b()) {
            i();
            return;
        }
        if (i3 == gVar.c()) {
            j();
            String string = this.f142607a.getString(R.string.yyr);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026er_send_verify_code_fail)");
            m(string);
            return;
        }
        if (i3 == gVar.d()) {
            j();
            String string2 = this.f142607a.getString(R.string.yys);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026end_verify_code_frequent)");
            m(string2);
            return;
        }
        j();
        String string3 = this.f142607a.getString(R.string.yyr);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026er_send_verify_code_fail)");
        m(string3);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
        d();
        this.f142616j = e();
    }

    public final void a(int i3, String str, String str2, String str3, String str4) {
        boolean z16 = true;
        w.d("Luggage.FULL.PhoneNumberVerifyCodeDialogNew", "processVerifyCodeResp:%d", Integer.valueOf(i3));
        com.tencent.luggage.wxa.uj.g gVar = com.tencent.luggage.wxa.uj.g.f142469a;
        if (i3 == gVar.b()) {
            q qVar = this.f142611e;
            if (qVar != null) {
                Long valueOf = Long.valueOf(qVar.l());
                Intrinsics.checkNotNull(valueOf);
                qVar.n(valueOf.longValue() + 1);
            }
            a(str, str2, str3, str4);
            dismiss();
            return;
        }
        if (i3 == gVar.g()) {
            j();
            String string = this.f142607a.getString(R.string.yyr);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026er_send_verify_code_fail)");
            m(string);
            q qVar2 = this.f142611e;
            if (qVar2 == null) {
                return;
            }
            Long valueOf2 = Long.valueOf(qVar2.k());
            Intrinsics.checkNotNull(valueOf2);
            qVar2.m(valueOf2.longValue() + 1);
            return;
        }
        if (i3 != gVar.h() && i3 != gVar.i()) {
            z16 = false;
        }
        if (z16) {
            j();
            String string2 = this.f142607a.getString(R.string.yyu);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026number_verify_code_error)");
            m(string2);
            q qVar3 = this.f142611e;
            if (qVar3 == null) {
                return;
            }
            Long valueOf3 = Long.valueOf(qVar3.k());
            Intrinsics.checkNotNull(valueOf3);
            qVar3.m(valueOf3.longValue() + 1);
            return;
        }
        j();
        String string3 = this.f142607a.getString(R.string.yyz);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026_number_verify_code_fail)");
        m(string3);
        q qVar4 = this.f142611e;
        if (qVar4 == null) {
            return;
        }
        Long valueOf4 = Long.valueOf(qVar4.k());
        Intrinsics.checkNotNull(valueOf4);
        qVar4.m(valueOf4.longValue() + 1);
    }

    public final void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str);
        i.a aVar = this.f142613g;
        if (aVar != null) {
            aVar.a(false, hashMap);
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
    }

    public final void a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        if (str == null) {
            str = "";
        }
        hashMap.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("iv", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("cloud_id", str3);
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("data", str4);
        i.a aVar = this.f142613g;
        if (aVar != null) {
            aVar.a(true, hashMap);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(com.tencent.luggage.wxa.ml.r rVar) {
        this.f142614h = rVar;
        d();
    }
}
