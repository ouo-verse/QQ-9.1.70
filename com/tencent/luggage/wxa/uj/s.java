package com.tencent.luggage.wxa.uj;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.hn.h1;
import com.tencent.luggage.wxa.hn.v9;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uj.i;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.api.MiniConst;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s {

    /* renamed from: n, reason: collision with root package name */
    public static final a f142557n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f142558a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142559b;

    /* renamed from: c, reason: collision with root package name */
    public q f142560c;

    /* renamed from: d, reason: collision with root package name */
    public final String f142561d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.uj.k f142562e;

    /* renamed from: f, reason: collision with root package name */
    public final i.a f142563f;

    /* renamed from: g, reason: collision with root package name */
    public View f142564g;

    /* renamed from: h, reason: collision with root package name */
    public EditText f142565h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f142566i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f142567j;

    /* renamed from: k, reason: collision with root package name */
    public b f142568k;

    /* renamed from: l, reason: collision with root package name */
    public final int f142569l;

    /* renamed from: m, reason: collision with root package name */
    public final int f142570m;

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
    public final class b extends CountDownTimer {
        public b(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            s.this.j();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            TextView textView = s.this.f142566i;
            if (textView != null) {
                textView.setText(s.this.a().getString(R.string.yyp, "" + (j3 / 1000)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f142572a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f142573b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f142574c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f142575a;

            public a(s sVar) {
                this.f142575a = sVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f142575a.a(com.tencent.luggage.wxa.uj.g.f142469a.e());
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f142576a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s f142577b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ v9 f142578c;

            public b(boolean z16, s sVar, v9 v9Var) {
                this.f142576a = z16;
                this.f142577b = sVar;
                this.f142578c = v9Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f142576a) {
                    this.f142577b.f();
                }
                this.f142577b.a(this.f142578c.f128900e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ProgressDialog progressDialog, s sVar, boolean z16) {
            super(1);
            this.f142572a = progressDialog;
            this.f142573b = sVar;
            this.f142574c = z16;
        }

        public final void a(v9 v9Var) {
            this.f142572a.dismiss();
            if (v9Var == null) {
                w.b("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed");
                c0.a(new a(this.f142573b));
                this.f142573b.a("SendVerifyCode cgi fail");
            } else {
                w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
                c0.a(new b(this.f142574c, this.f142573b, v9Var));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((v9) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f142580b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f142581c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProgressDialog f142582a;

            public a(ProgressDialog progressDialog) {
                this.f142582a = progressDialog;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f142582a.dismiss();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f142583a;

            public b(s sVar) {
                this.f142583a = sVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f142583a.a(com.tencent.luggage.wxa.uj.g.f142469a.e());
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f142584a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s f142585b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ v9 f142586c;

            public c(boolean z16, s sVar, v9 v9Var) {
                this.f142584a = z16;
                this.f142585b = sVar;
                this.f142586c = v9Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f142584a) {
                    this.f142585b.f();
                }
                this.f142585b.a(this.f142586c.f128900e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ProgressDialog progressDialog, boolean z16) {
            super(1);
            this.f142580b = progressDialog;
            this.f142581c = z16;
        }

        public final void a(v9 v9Var) {
            com.tencent.luggage.wxa.tk.l.a(new a(this.f142580b));
            if (v9Var == null) {
                w.b("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed");
                s.this.a("SendVerifyCode cgi fail");
                c0.a(new b(s.this));
            } else {
                w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
                c0.a(new c(this.f142581c, s.this, v9Var));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((v9) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f142587a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f142588b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f142589a;

            public a(s sVar) {
                this.f142589a = sVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f142589a.a(com.tencent.luggage.wxa.uj.g.f142469a.e(), "", "", "", "");
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f142590a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h1 f142591b;

            public b(s sVar, h1 h1Var) {
                this.f142590a = sVar;
                this.f142591b = h1Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                s sVar = this.f142590a;
                h1 h1Var = this.f142591b;
                sVar.a(h1Var.f127733e, h1Var.f127734f, h1Var.f127735g, h1Var.f127737i, h1Var.f127738j);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ProgressDialog progressDialog, s sVar) {
            super(1);
            this.f142587a = progressDialog;
            this.f142588b = sVar;
        }

        public final void a(h1 h1Var) {
            Long l3;
            this.f142587a.dismiss();
            if (h1Var == null) {
                w.b("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi failed");
                this.f142588b.a("checkVerifyCode cgi fail");
                q c16 = this.f142588b.c();
                if (c16 != null) {
                    q c17 = this.f142588b.c();
                    if (c17 != null) {
                        l3 = Long.valueOf(c17.k());
                    } else {
                        l3 = null;
                    }
                    Intrinsics.checkNotNull(l3);
                    c16.m(l3.longValue() + 1);
                }
                c0.a(new a(this.f142588b));
                return;
            }
            w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
            c0.a(new b(this.f142588b, h1Var));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h1) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f142592a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f142593b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f142594a;

            public a(s sVar) {
                this.f142594a = sVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f142594a.a(com.tencent.luggage.wxa.uj.g.f142469a.e(), "", "", "", "");
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f142595a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h1 f142596b;

            public b(s sVar, h1 h1Var) {
                this.f142595a = sVar;
                this.f142596b = h1Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                s sVar = this.f142595a;
                h1 h1Var = this.f142596b;
                sVar.a(h1Var.f127733e, h1Var.f127734f, h1Var.f127735g, h1Var.f127737i, h1Var.f127738j);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ProgressDialog progressDialog, s sVar) {
            super(1);
            this.f142592a = progressDialog;
            this.f142593b = sVar;
        }

        public final void a(h1 h1Var) {
            Long l3;
            this.f142592a.dismiss();
            if (h1Var == null) {
                w.b("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi fail");
                this.f142593b.a("checkVerifyCode cgi fail");
                q c16 = this.f142593b.c();
                if (c16 != null) {
                    q c17 = this.f142593b.c();
                    if (c17 != null) {
                        l3 = Long.valueOf(c17.k());
                    } else {
                        l3 = null;
                    }
                    Intrinsics.checkNotNull(l3);
                    c16.m(l3.longValue() + 1);
                }
                c0.a(new a(this.f142593b));
                return;
            }
            w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
            c0.a(new b(this.f142593b, h1Var));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h1) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            w.b("MicroMsg.PhoneNumberVerifyCodeDialog", "verify code is error, do send the right code");
            s.this.f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.uj.n.f142511a.b().c(s.this.a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            s.this.a("fail");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (s.this.f142565h != null) {
                s sVar = s.this;
                EditText editText = sVar.f142565h;
                Intrinsics.checkNotNull(editText);
                sVar.a(editText);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements DialogInterface.OnDismissListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
            s.this.h();
            s.this.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements DialogInterface.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public static final a f142603a = new a();

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public static final b f142604a = new b();

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            Editable editable;
            Integer num;
            Editable text;
            Editable text2;
            Editable text3;
            boolean z16 = true;
            Object[] objArr = new Object[1];
            EditText editText = s.this.f142565h;
            Integer num2 = null;
            Editable editable2 = null;
            num2 = null;
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            objArr[0] = editable;
            w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", objArr);
            EditText editText2 = s.this.f142565h;
            if (editText2 == null || (text3 = editText2.getText()) == null || text3.length() != 6) {
                z16 = false;
            }
            if (!z16) {
                EditText editText3 = s.this.f142565h;
                if (editText3 != null && (text2 = editText3.getText()) != null) {
                    num = Integer.valueOf(text2.length());
                } else {
                    num = null;
                }
                Intrinsics.checkNotNull(num);
                if (num.intValue() != 0) {
                    EditText editText4 = s.this.f142565h;
                    if (editText4 != null && (text = editText4.getText()) != null) {
                        num2 = Integer.valueOf(text.length());
                    }
                    Intrinsics.checkNotNull(num2);
                    if (num2.intValue() < 6) {
                        w.b("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
                        com.tencent.luggage.wxa.uk.n.a(s.this.a(), s.this.a().getString(R.string.yyy), s.this.a().getString(R.string.yyo), b.f142604a);
                        return;
                    }
                    return;
                }
                w.b("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
                com.tencent.luggage.wxa.uk.n.a(s.this.a(), s.this.a().getString(R.string.yyw), s.this.a().getString(R.string.yyo), a.f142603a);
                return;
            }
            dialogInterface.dismiss();
            s.this.h();
            s.this.d();
            s sVar = s.this;
            EditText editText5 = sVar.f142565h;
            if (editText5 != null) {
                editable2 = editText5.getText();
            }
            sVar.b(String.valueOf(editable2));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
            dialogInterface.dismiss();
            s.this.h();
            s.this.a("user cancel");
            s.this.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n extends ClickableSpan {
        public n() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
            w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
            if (s.this.b().a()) {
                s.a(s.this, false, 1, (Object) null);
                return;
            }
            w.b("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
            s sVar = s.this;
            String string = sVar.a().getString(R.string.yys);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026end_verify_code_frequent)");
            sVar.c(string);
        }
    }

    public s(Context context, String appId, q qVar, String ext_desc, com.tencent.luggage.wxa.uj.k phoneItem, i.a aVar) {
        EditText editText;
        TextView textView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(ext_desc, "ext_desc");
        Intrinsics.checkNotNullParameter(phoneItem, "phoneItem");
        this.f142558a = context;
        this.f142559b = appId;
        this.f142560c = qVar;
        this.f142561d = ext_desc;
        this.f142562e = phoneItem;
        this.f142563f = aVar;
        this.f142569l = 60000;
        this.f142570m = 1000;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.dys, (ViewGroup) null);
        this.f142564g = inflate;
        if (inflate != null) {
            editText = (EditText) inflate.findViewById(R.id.st9);
        } else {
            editText = null;
        }
        this.f142565h = editText;
        View view = this.f142564g;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.st_);
        } else {
            textView = null;
        }
        this.f142567j = textView;
        View view2 = this.f142564g;
        this.f142566i = view2 != null ? (TextView) view2.findViewById(R.id.ssl) : null;
    }

    public final void g() {
        w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "startSmsListener");
        b bVar = this.f142568k;
        if (bVar != null) {
            bVar.cancel();
        } else {
            this.f142568k = new b(this.f142569l, this.f142570m);
        }
        b bVar2 = this.f142568k;
        if (bVar2 != null) {
            bVar2.start();
        }
    }

    public final void h() {
        w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
        b bVar = this.f142568k;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final void i() {
        a(true);
    }

    public final void j() {
        String string = this.f142558a.getString(R.string.yyn);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_not_receive_verify_code)");
        String string2 = this.f142558a.getString(R.string.yyq);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026umber_resend_verify_code)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.append((CharSequence) string2);
        int length = string.length();
        int length2 = string2.length() + length;
        spannableStringBuilder.setSpan(new n(), length, length2, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f142558a.getResources().getColor(R.color.aud)), length, length2, 17);
        TextView textView = this.f142566i;
        if (textView != null) {
            textView.setText(spannableStringBuilder);
        }
        TextView textView2 = this.f142566i;
        if (textView2 != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public final void d() {
        View view = this.f142564g;
        if (view != null) {
            view.post(new h());
        }
    }

    public final void e() {
        View view = this.f142564g;
        if (view != null) {
            view.post(new j());
        }
    }

    public final void f() {
        EditText editText = this.f142565h;
        if (editText != null) {
            editText.setText("");
        }
        TextView textView = this.f142567j;
        if (textView != null) {
            textView.setText(this.f142558a.getString(R.string.f170358yz0, this.f142562e.h()));
        }
        j();
        View view = this.f142564g;
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            View view2 = this.f142564g;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.f142564g);
        }
        MMAlertDialog create = new MMAlertDialog.Builder(this.f142558a).setTitle(this.f142558a.getString(R.string.f170361yz3)).create();
        create.setView(this.f142564g);
        create.setOnDismissListener(new k());
        create.setPositiveButton(this.f142558a.getString(R.string.z4v), false, new l());
        create.setNegativeButton(this.f142558a.getString(R.string.z4z), true, new m());
        create.show();
        e();
    }

    public final com.tencent.luggage.wxa.uj.k b() {
        return this.f142562e;
    }

    public final q c() {
        return this.f142560c;
    }

    public final void b(String str) {
        w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "doVerifyCode");
        q qVar = this.f142560c;
        if (qVar != null) {
            Long valueOf = Long.valueOf(qVar.j());
            Intrinsics.checkNotNull(valueOf);
            qVar.l(valueOf.longValue() + 1);
        }
        Context context = this.f142558a;
        ProgressDialog a16 = com.tencent.luggage.wxa.uk.n.a(context, (CharSequence) context.getString(R.string.z4i), true, (DialogInterface.OnCancelListener) null);
        if (this.f142562e.j()) {
            new com.tencent.luggage.wxa.uj.c(this.f142559b, this.f142562e.f(), str).a(new e(a16, this));
        } else {
            new com.tencent.luggage.wxa.uj.b(this.f142559b, this.f142562e.f(), str).a(new f(a16, this));
        }
    }

    public final void c(String str) {
        h();
        com.tencent.luggage.wxa.uk.n.a(this.f142558a, str, "", false, new i());
    }

    public final Context a() {
        return this.f142558a;
    }

    public final void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str);
        i.a aVar = this.f142563f;
        if (aVar != null) {
            aVar.a(false, hashMap);
        }
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
        i.a aVar = this.f142563f;
        if (aVar != null) {
            aVar.a(true, hashMap);
        }
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object systemService = view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    public static /* synthetic */ void a(s sVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        sVar.a(z16);
    }

    public final void a(boolean z16) {
        w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
        Context context = this.f142558a;
        ProgressDialog a16 = com.tencent.luggage.wxa.uk.n.a(context, (CharSequence) context.getString(R.string.z4g), true, (DialogInterface.OnCancelListener) null);
        if (this.f142562e.j()) {
            new com.tencent.luggage.wxa.uj.f(this.f142559b, this.f142562e.f()).a(new c(a16, this, z16));
        } else {
            new com.tencent.luggage.wxa.uj.e(this.f142559b, this.f142562e.f()).a(new d(a16, z16));
        }
    }

    public final void a(int i3) {
        w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "handleSendVerifyCodeStatus:%d", Integer.valueOf(i3));
        com.tencent.luggage.wxa.uj.g gVar = com.tencent.luggage.wxa.uj.g.f142469a;
        if (i3 == gVar.b()) {
            g();
            return;
        }
        if (i3 == gVar.c()) {
            String string = this.f142558a.getString(R.string.yyr);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026er_send_verify_code_fail)");
            c(string);
        } else if (i3 == gVar.d()) {
            String string2 = this.f142558a.getString(R.string.yys);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026end_verify_code_frequent)");
            c(string2);
        } else {
            String string3 = this.f142558a.getString(R.string.yyr);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026er_send_verify_code_fail)");
            c(string3);
        }
    }

    public final void a(int i3, String str, String str2, String str3, String str4) {
        w.d("MicroMsg.PhoneNumberVerifyCodeDialog", "handleCheckVerifyCodeStatus:%d", Integer.valueOf(i3));
        com.tencent.luggage.wxa.uj.g gVar = com.tencent.luggage.wxa.uj.g.f142469a;
        if (i3 == gVar.f()) {
            q qVar = this.f142560c;
            if (qVar != null) {
                Long valueOf = Long.valueOf(qVar.l());
                Intrinsics.checkNotNull(valueOf);
                qVar.n(valueOf.longValue() + 1);
            }
            a(str, str2, str3, str4);
            return;
        }
        if (i3 == gVar.g()) {
            String string = this.f142558a.getString(R.string.yys);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026end_verify_code_frequent)");
            c(string);
            q qVar2 = this.f142560c;
            if (qVar2 == null) {
                return;
            }
            Long valueOf2 = Long.valueOf(qVar2.k());
            Intrinsics.checkNotNull(valueOf2);
            qVar2.m(valueOf2.longValue() + 1);
            return;
        }
        if (i3 != gVar.h() && i3 != gVar.i()) {
            String string2 = this.f142558a.getString(R.string.yyz);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_number_verify_code_fail)");
            c(string2);
            q qVar3 = this.f142560c;
            if (qVar3 == null) {
                return;
            }
            Long valueOf3 = Long.valueOf(qVar3.k());
            Intrinsics.checkNotNull(valueOf3);
            qVar3.m(valueOf3.longValue() + 1);
            return;
        }
        Context context = this.f142558a;
        com.tencent.luggage.wxa.uk.n.a(context, context.getString(R.string.yyu), "", false, new g());
        q qVar4 = this.f142560c;
        if (qVar4 == null) {
            return;
        }
        Long valueOf4 = Long.valueOf(qVar4.k());
        Intrinsics.checkNotNull(valueOf4);
        qVar4.m(valueOf4.longValue() + 1);
    }
}
