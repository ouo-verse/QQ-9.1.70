package com.tencent.luggage.wxa.l8;

import android.app.Activity;
import android.os.Build;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.EditText;
import com.tencent.luggage.wxa.kj.h0;
import com.tencent.luggage.wxa.ol.d1;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.g1;
import com.tencent.luggage.wxa.ol.l0;
import com.tencent.luggage.wxa.ol.m0;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.ol.r;
import com.tencent.luggage.wxa.ol.s0;
import com.tencent.luggage.wxa.ol.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.x0;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.z7.a;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.xweb.XWebExtendInputClient;
import com.tencent.xweb.XWebExtendInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends XWebExtendInputClient {

    /* renamed from: a, reason: collision with root package name */
    public final XWebExtendInterface f133123a;

    /* renamed from: b, reason: collision with root package name */
    public final String f133124b;

    /* renamed from: c, reason: collision with root package name */
    public final long f133125c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f133126d;

    /* renamed from: e, reason: collision with root package name */
    public h0 f133127e;

    /* renamed from: f, reason: collision with root package name */
    public x f133128f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.l8.b f133129g;

    /* renamed from: h, reason: collision with root package name */
    public EditText f133130h;

    /* renamed from: i, reason: collision with root package name */
    public int f133131i;

    /* renamed from: j, reason: collision with root package name */
    public int f133132j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f133133k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f133134l;

    /* renamed from: m, reason: collision with root package name */
    public Integer f133135m;

    /* renamed from: n, reason: collision with root package name */
    public String f133136n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f133137o;

    /* renamed from: p, reason: collision with root package name */
    public int f133138p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f133139q;

    /* renamed from: r, reason: collision with root package name */
    public String f133140r;

    /* renamed from: s, reason: collision with root package name */
    public int f133141s;

    /* renamed from: t, reason: collision with root package name */
    public final d1 f133142t;

    /* renamed from: u, reason: collision with root package name */
    public final x.i f133143u;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        public static final C6426a f133144i = new C6426a(null);

        /* renamed from: a, reason: collision with root package name */
        public String f133145a;

        /* renamed from: b, reason: collision with root package name */
        public String f133146b;

        /* renamed from: c, reason: collision with root package name */
        public String f133147c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f133148d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f133149e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f133150f;

        /* renamed from: g, reason: collision with root package name */
        public com.tencent.luggage.wxa.vl.f f133151g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f133152h;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.l8.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6426a {
            public C6426a() {
            }

            public /* synthetic */ C6426a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(String json) {
            JSONObject jSONObject;
            Intrinsics.checkNotNullParameter(json, "json");
            this.f133145a = "";
            this.f133146b = "";
            this.f133147c = "";
            this.f133151g = new com.tencent.luggage.wxa.vl.f();
            w.d("TextAreaInfo", "totalInfo:" + json);
            this.f133145a = json;
            try {
                jSONObject = new JSONObject(json);
            } catch (Exception unused) {
                w.b("TextAreaInfo", "TextAreaInfo convert to json error");
                jSONObject = new JSONObject();
            }
            try {
                if (jSONObject.has("element-tag")) {
                    this.f133146b = jSONObject.getString("element-tag");
                }
            } catch (JSONException unused2) {
                w.b("TextAreaInfo", "TextAreaInfo add elementTag error");
            }
            try {
                if (jSONObject.has("keyboard-type")) {
                    String string = jSONObject.getString("keyboard-type");
                    Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"keyboard-type\")");
                    this.f133147c = string;
                    this.f133151g.R = string;
                }
            } catch (JSONException unused3) {
                w.b("TextAreaInfo", "TextAreaInfo add keyboardType error");
            }
            try {
                if (jSONObject.has("cursor-spacing")) {
                    this.f133151g.f143687y = Integer.valueOf(com.tencent.luggage.wxa.tk.g.c(jSONObject, "cursor-spacing"));
                }
            } catch (NumberFormatException unused4) {
                w.b("TextAreaInfo", "TextAreaInfo get cursor-spacing parseInt error");
            } catch (JSONException unused5) {
                w.b("TextAreaInfo", "TextAreaInfo get cursor-spacing error");
            } catch (Exception unused6) {
                w.b("TextAreaInfo", "TextAreaInfo get cursor-spacing parseInt error");
            }
            try {
                if (jSONObject.has("adjust-position")) {
                    this.f133151g.B = Boolean.valueOf(w0.a(jSONObject.getString("adjust-position"), true));
                }
            } catch (JSONException unused7) {
                w.b("TextAreaInfo", "TextAreaInfo get adjust-position error");
            } catch (Exception unused8) {
                w.b("TextAreaInfo", "TextAreaInfo get adjust-position error");
            }
            try {
                if (jSONObject.has("show-confirm-bar")) {
                    this.f133148d = w0.a(jSONObject.getString("show-confirm-bar"), false);
                }
            } catch (JSONException unused9) {
                w.b("TextAreaInfo", "TextAreaInfo get show-confirm-bar error");
            } catch (Exception unused10) {
                w.b("TextAreaInfo", "TextAreaInfo get show-confirm-bar error");
            }
            try {
                if (jSONObject.has(NotificationActivity.PASSWORD)) {
                    this.f133149e = w0.a(jSONObject.getString(NotificationActivity.PASSWORD), false);
                }
            } catch (JSONException unused11) {
                w.b("TextAreaInfo", "TextAreaInfo get password error");
            } catch (Exception unused12) {
                w.b("TextAreaInfo", "TextAreaInfo get password error");
            }
            try {
                if (jSONObject.has("show-cover-view")) {
                    this.f133150f = w0.a(jSONObject.getString("show-cover-view"), false);
                }
            } catch (JSONException unused13) {
                w.b("TextAreaInfo", "TextAreaInfo get show-cover-view error");
            } catch (Exception unused14) {
                w.b("TextAreaInfo", "TextAreaInfo get show-cover-view error");
            }
            try {
                if (jSONObject.has("confirm-hold")) {
                    this.f133152h = w0.a(jSONObject.getString("confirm-hold"), false);
                }
            } catch (JSONException unused15) {
                w.b("TextAreaInfo", "TextAreaInfo get confirm-hold error");
            } catch (Exception unused16) {
                w.b("TextAreaInfo", "TextAreaInfo get confirm-hold error");
            }
            g1.b(jSONObject, this.f133151g);
            m0.b(jSONObject, this.f133151g);
        }

        public final boolean a() {
            return this.f133152h;
        }

        public final com.tencent.luggage.wxa.vl.f b() {
            return this.f133151g;
        }

        public final String c() {
            return this.f133147c;
        }

        public final boolean d() {
            return this.f133148d;
        }

        public final boolean e() {
            return this.f133150f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function4 {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133160a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar) {
                super(0);
                this.f133160a = dVar;
            }

            public final void a() {
                this.f133160a.onKeyboardHeightChanged(true, 0, false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public e() {
            super(4);
        }

        public final void a(String value, int i3, String str, String str2) {
            Intrinsics.checkNotNullParameter(value, "value");
            d.this.a(value, i3, str, str2);
            com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
            h0 h0Var = d.this.f133127e;
            Intrinsics.checkNotNull(h0Var);
            com.tencent.luggage.wxa.xd.f a16 = h0Var.a();
            h0 h0Var2 = d.this.f133127e;
            Intrinsics.checkNotNull(h0Var2);
            aVar.a(a16, h0Var2.b(), new a.b(0, 0, d.this.f133135m, new a(d.this)));
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            a((String) obj, ((Number) obj2).intValue(), (String) obj3, (String) obj4);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements x.i {

        /* renamed from: a, reason: collision with root package name */
        public boolean f133161a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133163a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f133164b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, boolean z16) {
                super(0);
                this.f133163a = dVar;
                this.f133164b = z16;
            }

            public final void a() {
                int i3;
                d dVar = this.f133163a;
                boolean z16 = this.f133164b;
                if (z16) {
                    i3 = dVar.f133132j;
                } else {
                    i3 = 0;
                }
                dVar.onKeyboardHeightChanged(z16, i3, false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133165a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f133166b;

            public b(d dVar, f fVar) {
                this.f133165a = dVar;
                this.f133166b = fVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f133165a.f133133k) {
                    f fVar = this.f133166b;
                    fVar.b(fVar.a());
                }
                this.f133165a.f133137o = false;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133167a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f133168b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(d dVar, int i3) {
                super(0);
                this.f133167a = dVar;
                this.f133168b = i3;
            }

            public final void a() {
                boolean z16;
                d dVar = this.f133167a;
                int i3 = this.f133168b;
                if (i3 > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                dVar.onKeyboardHeightChanged(z16, i3, false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public f() {
        }

        public final void b(boolean z16) {
            int i3;
            com.tencent.luggage.wxa.l8.b a16 = d.a(d.this, (InputConnection) null, 1, (Object) null);
            int i16 = 0;
            if (a16 != null) {
                d dVar = d.this;
                EditText editText = dVar.f133130h;
                if (editText != null) {
                    if (z16) {
                        a16.b(editText);
                    } else {
                        a16.a(editText);
                    }
                }
                if (z16) {
                    i3 = dVar.f133132j;
                } else {
                    i3 = 0;
                }
                a16.a(i3);
            }
            com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
            h0 h0Var = d.this.f133127e;
            Intrinsics.checkNotNull(h0Var);
            com.tencent.luggage.wxa.xd.f a17 = h0Var.a();
            h0 h0Var2 = d.this.f133127e;
            Intrinsics.checkNotNull(h0Var2);
            com.tencent.luggage.wxa.xd.d b16 = h0Var2.b();
            if (z16) {
                i16 = d.this.f133132j;
            }
            d dVar2 = d.this;
            aVar.a(a17, b16, new a.b(i16, dVar2.a(dVar2.f133132j), d.this.f133135m, new a(d.this, z16)));
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public int getHeight() {
            return d.this.f133132j;
        }

        public final boolean a() {
            return this.f133161a;
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public void a(int i3) {
            boolean z16 = (i3 == 0 || d.this.f133132j == 0 || i3 == d.this.f133132j) ? false : true;
            d.this.f133132j = i3;
            if (z16) {
                com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
                h0 h0Var = d.this.f133127e;
                Intrinsics.checkNotNull(h0Var);
                com.tencent.luggage.wxa.xd.f a16 = h0Var.a();
                h0 h0Var2 = d.this.f133127e;
                Intrinsics.checkNotNull(h0Var2);
                aVar.a(a16, h0Var2.b(), new a.b(i3, d.this.a(i3), d.this.f133135m, new c(d.this, i3)));
            }
            com.tencent.luggage.wxa.l8.b a17 = d.a(d.this, (InputConnection) null, 1, (Object) null);
            if (a17 != null) {
                a17.a(i3);
            }
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public void a(boolean z16) {
            com.tencent.luggage.wxa.xd.f a16;
            View contentView;
            com.tencent.luggage.wxa.xd.f a17;
            d dVar = d.this;
            if (dVar.a(dVar.f133140r)) {
                w.f(d.this.f133124b, "is keyboard showing: " + d.this.f133133k + ", state change: " + z16);
                return;
            }
            this.f133161a = z16;
            h0 h0Var = d.this.f133127e;
            if (((h0Var == null || (a17 = h0Var.a()) == null) ? null : a17.getContentView()) != null && !com.tencent.luggage.wxa.z7.a.f146372a.a()) {
                if (d.this.f133137o) {
                    return;
                }
                d.this.f133137o = true;
                h0 h0Var2 = d.this.f133127e;
                if (h0Var2 == null || (a16 = h0Var2.a()) == null || (contentView = a16.getContentView()) == null) {
                    return;
                }
                contentView.postDelayed(new b(d.this, this), d.this.f133125c);
                return;
            }
            b(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements d1.b {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public Activity a() {
            return null;
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public int b() {
            return d.this.f133132j;
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public View getContentView() {
            com.tencent.luggage.wxa.xd.f a16;
            h0 h0Var = d.this.f133127e;
            if (h0Var != null && (a16 = h0Var.a()) != null) {
                return a16.getContentView();
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public void a(int i3) {
            d.this.f133143u.a(i3);
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public void a(boolean z16) {
            d.this.f133143u.a(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.l8.b f133171b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133172a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar) {
                super(0);
                this.f133172a = dVar;
            }

            public final void a() {
                this.f133172a.onKeyboardHeightChanged(true, 0, false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(com.tencent.luggage.wxa.l8.b bVar) {
            super(1);
            this.f133171b = bVar;
        }

        public final void a(boolean z16) {
            w.d(d.this.f133124b, "onInputDone#onShowKeyboard, fromDoneButton: %b, confirmHold: %b", Boolean.valueOf(z16), Boolean.valueOf(d.this.f133139q));
            d.this.a(false, this.f133171b);
            com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
            h0 h0Var = d.this.f133127e;
            Intrinsics.checkNotNull(h0Var);
            com.tencent.luggage.wxa.xd.f a16 = h0Var.a();
            h0 h0Var2 = d.this.f133127e;
            Intrinsics.checkNotNull(h0Var2);
            aVar.a(a16, h0Var2.b(), new a.b(0, 0, d.this.f133135m, new a(d.this)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.l8.b f133174b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f133175c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f133176d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133177a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f133178b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i3) {
                super(0);
                this.f133177a = dVar;
                this.f133178b = i3;
            }

            public final void a() {
                this.f133177a.onKeyboardHeightChanged(true, this.f133178b, false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133179a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(d dVar) {
                super(0);
                this.f133179a = dVar;
            }

            public final void a() {
                d dVar = this.f133179a;
                dVar.onKeyboardHeightChanged(true, dVar.f133132j, false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public i(com.tencent.luggage.wxa.l8.b bVar, a aVar, boolean z16) {
            this.f133174b = bVar;
            this.f133175c = aVar;
            this.f133176d = z16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.this.f133133k) {
                this.f133174b.a(this.f133175c.d());
                if (this.f133176d) {
                    int measuredHeight = this.f133174b.getView().getMeasuredHeight();
                    com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
                    h0 h0Var = d.this.f133127e;
                    Intrinsics.checkNotNull(h0Var);
                    com.tencent.luggage.wxa.xd.f a16 = h0Var.a();
                    h0 h0Var2 = d.this.f133127e;
                    Intrinsics.checkNotNull(h0Var2);
                    aVar.a(a16, h0Var2.b(), new a.b(measuredHeight, d.this.a(measuredHeight), d.this.f133135m, new a(d.this, measuredHeight)));
                    return;
                }
                com.tencent.luggage.wxa.z7.a aVar2 = com.tencent.luggage.wxa.z7.a.f146372a;
                h0 h0Var3 = d.this.f133127e;
                Intrinsics.checkNotNull(h0Var3);
                com.tencent.luggage.wxa.xd.f a17 = h0Var3.a();
                h0 h0Var4 = d.this.f133127e;
                Intrinsics.checkNotNull(h0Var4);
                com.tencent.luggage.wxa.xd.d b16 = h0Var4.b();
                int i3 = d.this.f133132j;
                d dVar = d.this;
                aVar2.a(a17, b16, new a.b(i3, dVar.a(dVar.f133132j), d.this.f133135m, new b(d.this)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.l8.b f133180a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f133181b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133182a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f133183b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i3) {
                super(0);
                this.f133182a = dVar;
                this.f133183b = i3;
            }

            public final void a() {
                this.f133182a.onKeyboardHeightChanged(true, this.f133183b, false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public j(com.tencent.luggage.wxa.l8.b bVar, d dVar) {
            this.f133180a = bVar;
            this.f133181b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int measuredHeight = this.f133180a.getView().getMeasuredHeight();
            com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
            h0 h0Var = this.f133181b.f133127e;
            Intrinsics.checkNotNull(h0Var);
            com.tencent.luggage.wxa.xd.f a16 = h0Var.a();
            h0 h0Var2 = this.f133181b.f133127e;
            Intrinsics.checkNotNull(h0Var2);
            aVar.a(a16, h0Var2.b(), new a.b(measuredHeight, this.f133181b.a(measuredHeight), this.f133181b.f133135m, new a(this.f133181b, measuredHeight)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(XWebExtendInterface view) {
        super(view);
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        this.f133123a = view;
        this.f133124b = "WebViewExtendInputClient";
        this.f133125c = 250L;
        if (!com.tencent.luggage.wxa.tn.e.f141559a && !com.tencent.luggage.wxa.tn.e.f141565g && !com.tencent.luggage.wxa.tn.e.f141566h && !x0.a()) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f133126d = z16;
        this.f133142t = new d1(new g());
        this.f133143u = new f();
    }

    @Override // com.tencent.xweb.XWebExtendInputClient
    public int getToolBarHeight(int i3) {
        h0 h0Var = this.f133127e;
        if (h0Var != null) {
            Intrinsics.checkNotNull(h0Var);
            if (h0Var.a() != null) {
                h0 h0Var2 = this.f133127e;
                Intrinsics.checkNotNull(h0Var2);
                if (n0.a(h0Var2.a().getContentView())) {
                    return 0;
                }
                return a(i3);
            }
        }
        return 0;
    }

    @Override // com.tencent.xweb.XWebExtendInputClient
    public void onExtraInfoChanged(String str) {
        if (str != null) {
            a aVar = new a(str);
            com.tencent.luggage.wxa.l8.b a16 = a(this, (InputConnection) null, 1, (Object) null);
            if (a16 != null) {
                a16.a((com.tencent.luggage.wxa.vl.i) aVar.b());
            }
        }
    }

    @Override // com.tencent.xweb.XWebExtendInputClient
    public boolean onHideKeyboard(String str, InputConnection inputConnection) {
        View contentView;
        ViewTreeObserver viewTreeObserver;
        com.tencent.luggage.wxa.l8.b a16;
        if (this.f133126d && inputConnection != null) {
            boolean z16 = inputConnection instanceof BaseInputConnection;
        }
        w.a(this.f133124b, "onHideKeyboard");
        this.f133133k = false;
        if (this.f133127e != null && (a16 = a(this, (InputConnection) null, 1, (Object) null)) != null) {
            a16.a();
            a16.a(false);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            this.f133142t.b();
            h0 h0Var = this.f133127e;
            Intrinsics.checkNotNull(h0Var);
            com.tencent.luggage.wxa.xd.f a17 = h0Var.a();
            if (a17 != null && (contentView = a17.getContentView()) != null && (viewTreeObserver = contentView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.f133142t);
            }
        } else {
            x xVar = this.f133128f;
            if (xVar != null) {
                xVar.b(this.f133143u);
            }
        }
        com.tencent.luggage.wxa.l8.j.f133225a.a(true);
        this.f133140r = null;
        this.f133129g = null;
        this.f133134l = false;
        this.f133135m = null;
        this.f133136n = null;
        return false;
    }

    @Override // com.tencent.xweb.XWebExtendInputClient
    public boolean onShowKeyboard(String str, String extendInfo, InputConnection inputConnection, ResultReceiver resultReceiver) {
        View contentView;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        if (this.f133126d && inputConnection != null) {
            boolean z16 = inputConnection instanceof BaseInputConnection;
        }
        w.a(this.f133124b, "onShowKeyboard");
        this.f133133k = true;
        a aVar = new a(extendInfo);
        com.tencent.luggage.wxa.z7.a aVar2 = com.tencent.luggage.wxa.z7.a.f146372a;
        Integer num = aVar.b().X;
        if (num == null) {
            num = -1;
        }
        aVar2.a(new a.C6975a(0, num.intValue()));
        x xVar = this.f133128f;
        if (xVar == null) {
            h0 h0Var = this.f133127e;
            Intrinsics.checkNotNull(h0Var);
            xVar = q.c(h0Var.a().getContentView());
        }
        this.f133128f = xVar;
        if (Build.VERSION.SDK_INT >= 33) {
            h0 h0Var2 = this.f133127e;
            Intrinsics.checkNotNull(h0Var2);
            com.tencent.luggage.wxa.xd.f a16 = h0Var2.a();
            if (a16 != null && (contentView = a16.getContentView()) != null && (viewTreeObserver = contentView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.f133142t);
                viewTreeObserver.addOnGlobalLayoutListener(this.f133142t);
            }
        } else if (xVar != null) {
            xVar.a(this.f133143u);
        }
        com.tencent.luggage.wxa.l8.j.f133225a.a(false);
        this.f133139q = aVar.a();
        String c16 = aVar.c();
        this.f133140r = c16;
        this.f133141s = w0.a((Integer) r.f136917a.get(c16), 0);
        this.f133134l = aVar.d();
        this.f133135m = aVar.b().X;
        this.f133136n = str;
        boolean a17 = a(this.f133140r);
        if (this.f133127e == null) {
            return false;
        }
        com.tencent.luggage.wxa.l8.b a18 = a(inputConnection);
        if (a18 != null) {
            if (aVar.d()) {
                a18.b(aVar.e());
            }
            a18.a(new h(a18));
            a18.a(aVar.b());
            a18.a(this.f133136n);
            a18.b();
            if (aVar.d()) {
                a18.getView().postDelayed(new i(a18, aVar, a17), 200L);
            } else if (a17) {
                a18.a(aVar.d());
                a18.getView().post(new j(a18, this));
            }
        }
        return a17;
    }

    @Override // com.tencent.xweb.XWebExtendInputClient
    public boolean onShowKeyboardConfig(String str, int i3, int i16, String str2, int i17, int i18, EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        w.a(this.f133124b, "onShowKeyboardConfig");
        com.tencent.luggage.wxa.vl.c cVar = null;
        try {
            cVar = com.tencent.luggage.wxa.vl.c.a(new JSONObject(str2).optString("confirm-type", null));
        } catch (Exception unused) {
            w.f(this.f133124b, "onShowKeyboardConfig, get confirm-type error");
        }
        if (cVar != null) {
            w.d(this.f133124b, "onShowKeyboardConfig, confirmType: " + cVar);
            if (com.tencent.luggage.wxa.vl.c.RETURN != cVar) {
                outAttrs.imeOptions &= -1073741825;
            }
            int i19 = outAttrs.imeOptions;
            int i26 = cVar.f143658a;
            outAttrs.imeOptions = i19 | i26;
            this.f133138p = i26;
            return false;
        }
        return false;
    }

    @Override // com.tencent.xweb.XWebExtendInputClient
    public boolean performEditorAction(int i3) {
        w.a(this.f133124b, "performEditorAction, actionCode: " + i3);
        if (i3 != 0 && i3 == this.f133138p) {
            w.d(this.f133124b, "performEditorAction, confirmHold: " + this.f133139q);
            a(this, this.f133139q, (com.tencent.luggage.wxa.l8.b) null, 2, (Object) null);
            return false;
        }
        return true;
    }

    public final boolean d(String str) {
        return Intrinsics.areEqual(str, "safe-password");
    }

    public final boolean b(String str) {
        return r.e(str);
    }

    public final boolean c(String str) {
        return r.f(str);
    }

    public static /* synthetic */ com.tencent.luggage.wxa.l8.b a(d dVar, InputConnection inputConnection, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            inputConnection = null;
        }
        return dVar.a(inputConnection);
    }

    public final com.tencent.luggage.wxa.l8.b a(InputConnection inputConnection) {
        synchronized (this.f133124b) {
            com.tencent.luggage.wxa.l8.b bVar = this.f133129g;
            if (bVar != null) {
                return bVar;
            }
            String str = this.f133140r;
            com.tencent.luggage.wxa.l8.b bVar2 = null;
            if (str == null) {
                return null;
            }
            if (a(str) && inputConnection == null) {
                return null;
            }
            h0 h0Var = this.f133127e;
            if (h0Var != null && h0Var.a() != null) {
                String str2 = this.f133140r;
                Intrinsics.checkNotNull(str2);
                com.tencent.luggage.wxa.l8.b a16 = a(str2, inputConnection);
                this.f133129g = a16;
                if (a16 != null) {
                    this.f133130h = new EditText(a16.getView().getContext());
                    a16.a(new C6427d(a16, this));
                }
                bVar2 = this.f133129g;
            }
            return bVar2;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.l8.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6427d implements f0.k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.l8.b f133155a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f133156b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.l8.d$d$a */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f133157a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f133158b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i3) {
                super(0);
                this.f133157a = dVar;
                this.f133158b = i3;
            }

            public final void a() {
                boolean z16;
                d dVar = this.f133157a;
                int i3 = this.f133158b;
                if (i3 > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                dVar.onKeyboardHeightChanged(z16, i3, false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public C6427d(com.tencent.luggage.wxa.l8.b bVar, d dVar) {
            this.f133155a = bVar;
            this.f133156b = dVar;
        }

        @Override // com.tencent.luggage.wxa.ol.f0.k
        public void a(int i3) {
            int c16 = this.f133155a.c();
            int i16 = i3 - c16;
            w.d(this.f133156b.f133124b, "OnHeightChangedListener, totalHeight: %d, lateSavedKeyboardPanelHeight: %d, currentKeyboardPanelHeight: %d", Integer.valueOf(i3), Integer.valueOf(this.f133156b.f133131i), Integer.valueOf(c16));
            if (c16 == 0 || this.f133156b.f133131i == c16) {
                return;
            }
            this.f133156b.f133131i = c16;
            this.f133156b.f133132j = i3;
            com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
            h0 h0Var = this.f133156b.f133127e;
            Intrinsics.checkNotNull(h0Var);
            com.tencent.luggage.wxa.xd.f a16 = h0Var.a();
            h0 h0Var2 = this.f133156b.f133127e;
            Intrinsics.checkNotNull(h0Var2);
            aVar.a(a16, h0Var2.b(), new a.b(i3, this.f133156b.a(i3), this.f133156b.f133135m, new a(this.f133156b, i16)));
        }

        @Override // com.tencent.luggage.wxa.ol.f0.k
        public EditText a() {
            EditText editText = this.f133156b.f133130h;
            Intrinsics.checkNotNull(editText);
            return editText;
        }
    }

    public final void a(h0 appBrandXWebKeyboard) {
        Intrinsics.checkNotNullParameter(appBrandXWebKeyboard, "appBrandXWebKeyboard");
        this.f133127e = appBrandXWebKeyboard;
    }

    public final int a(int i3) {
        com.tencent.luggage.wxa.l8.b a16 = a(this, (InputConnection) null, 1, (Object) null);
        if (a16 == null || !this.f133134l) {
            return i3;
        }
        int c16 = a16.c();
        if (c16 != 0 && c16 != this.f133131i) {
            this.f133131i = c16;
        }
        return i3 + this.f133131i;
    }

    public final void a(String str, int i3, String str2, String str3) {
        JSONObject put = new JSONObject().put("value", str).put("keyCode", (int) (str.length() > 0 ? str.charAt(str.length() - 1) : (char) 0)).put("cursor", i3);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject().put(\"value\"\u2026ut(\"cursor\", cursorIndex)");
        if (str2 != null) {
            put.put("encryptedValue", str2);
        }
        if (str3 != null) {
            put.put("encryptError", str3);
        }
        String jSONObject = put.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "eventDataObj.toString()");
        evaluateJavascript("(function(){    var focusElement = document.activeElement;    if(focusElement){        if(focusElement.onkeyboardcomplete){            focusElement.onkeyboardcomplete(" + jSONObject + ");        }        focusElement.blur();    }})();", c.f133154a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public static final b f133153a = new b();

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceiveValue(String str) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public static final c f133154a = new c();

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceiveValue(String str) {
        }
    }

    public static /* synthetic */ void a(d dVar, boolean z16, com.tencent.luggage.wxa.l8.b bVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bVar = dVar.f133129g;
        }
        dVar.a(z16, bVar);
    }

    public final void a(boolean z16, com.tencent.luggage.wxa.l8.b bVar) {
        String str;
        s0 d16;
        String message;
        if (!this.f133133k) {
            w.f(this.f133124b, "send confirm after keyboard hide");
            return;
        }
        String str2 = null;
        com.tencent.luggage.wxa.vl.f params = bVar != null ? bVar.getParams() : null;
        if (r.b(params != null ? params.R : null)) {
            w.d(this.f133124b, "onKeyboardComplete, do encrypt");
            if (bVar != null) {
                try {
                    d16 = bVar.d();
                } catch (l0 e16) {
                    w.b(this.f133124b, "onKeyboardComplete, encrypt fail since " + e16);
                    message = e16.getMessage();
                }
            } else {
                d16 = null;
            }
            h0 h0Var = this.f133127e;
            str2 = m0.a(d16, h0Var != null ? h0Var.a() : null, params);
            message = null;
            JSONObject jSONObject = new JSONObject();
            if (str2 != null) {
                jSONObject.put("encryptedValue", str2);
            }
            if (message != null) {
                jSONObject.put("encryptError", message);
            }
            str = jSONObject.toString();
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (AppBrandInputService\u2026g()\n            } else \"\"");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(function(){    var focusElement = document.activeElement;    if(focusElement){        if(focusElement.onkeyboardconfirm){            focusElement.onkeyboardconfirm(");
        sb5.append(str);
        sb5.append(");        }");
        sb5.append(z16 ? "" : "        focusElement.blur();");
        sb5.append("    }})();");
        evaluateJavascript(sb5.toString(), b.f133153a);
    }

    public final com.tencent.luggage.wxa.l8.b a(String str, InputConnection inputConnection) {
        if (b(str)) {
            h0 h0Var = this.f133127e;
            Intrinsics.checkNotNull(h0Var);
            com.tencent.luggage.wxa.xd.f a16 = h0Var.a();
            Intrinsics.checkNotNullExpressionValue(a16, "mAppBrandXWebKeyboard!!.appBrandPage");
            Intrinsics.checkNotNull(inputConnection);
            return new com.tencent.luggage.wxa.l8.e(a16, inputConnection, this.f133141s);
        }
        if (d(str)) {
            h0 h0Var2 = this.f133127e;
            Intrinsics.checkNotNull(h0Var2);
            com.tencent.luggage.wxa.xd.f a17 = h0Var2.a();
            Intrinsics.checkNotNullExpressionValue(a17, "mAppBrandXWebKeyboard!!.appBrandPage");
            Intrinsics.checkNotNull(inputConnection);
            com.tencent.luggage.wxa.l8.f fVar = new com.tencent.luggage.wxa.l8.f(a17, inputConnection);
            fVar.a(new e());
            return fVar;
        }
        if (c(str)) {
            h0 h0Var3 = this.f133127e;
            Intrinsics.checkNotNull(h0Var3);
            com.tencent.luggage.wxa.xd.f a18 = h0Var3.a();
            Intrinsics.checkNotNullExpressionValue(a18, "mAppBrandXWebKeyboard!!.appBrandPage");
            Intrinsics.checkNotNull(inputConnection);
            return new com.tencent.luggage.wxa.l8.i(a18, inputConnection, this.f133141s);
        }
        h0 h0Var4 = this.f133127e;
        Intrinsics.checkNotNull(h0Var4);
        com.tencent.luggage.wxa.xd.f a19 = h0Var4.a();
        Intrinsics.checkNotNullExpressionValue(a19, "mAppBrandXWebKeyboard!!.appBrandPage");
        return new com.tencent.luggage.wxa.l8.h(a19, inputConnection);
    }

    public final boolean a(String str) {
        return b(str) || d(str) || c(str);
    }
}
