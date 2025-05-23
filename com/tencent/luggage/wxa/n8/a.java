package com.tencent.luggage.wxa.n8;

import android.app.Activity;
import android.os.Build;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.EditText;
import com.tencent.luggage.wxa.kj.h0;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.l8.j;
import com.tencent.luggage.wxa.n8.a;
import com.tencent.luggage.wxa.ol.d1;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.ol.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.z7.a;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.XWebExtendTextAreaClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends XWebExtendTextAreaClient {

    /* renamed from: a, reason: collision with root package name */
    public final String f135558a;

    /* renamed from: b, reason: collision with root package name */
    public final long f135559b;

    /* renamed from: c, reason: collision with root package name */
    public h0 f135560c;

    /* renamed from: d, reason: collision with root package name */
    public x f135561d;

    /* renamed from: e, reason: collision with root package name */
    public f0 f135562e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f135563f;

    /* renamed from: g, reason: collision with root package name */
    public int f135564g;

    /* renamed from: h, reason: collision with root package name */
    public int f135565h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f135566i;

    /* renamed from: j, reason: collision with root package name */
    public int f135567j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f135568k;

    /* renamed from: l, reason: collision with root package name */
    public int f135569l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f135570m;

    /* renamed from: n, reason: collision with root package name */
    public final d1 f135571n;

    /* renamed from: o, reason: collision with root package name */
    public f0.k f135572o;

    /* renamed from: p, reason: collision with root package name */
    public final x.i f135573p;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n8.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6505a implements d1.b {
        public C6505a() {
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public Activity a() {
            return null;
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public int b() {
            return a.this.f135565h;
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public View getContentView() {
            if (a.this.f135560c != null && a.this.f135560c.a() != null && a.this.f135560c.a().getContentView() != null) {
                return a.this.f135560c.a().getContentView();
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public void a(int i3) {
            a.this.f135573p.a(i3);
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public void a(boolean z16) {
            a.this.f135573p.a(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements f0.k {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit b(int i3) {
            boolean z16;
            a aVar = a.this;
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.onKeyboardHeightChanged(z16, i3, false);
            return null;
        }

        @Override // com.tencent.luggage.wxa.ol.f0.k
        public void a(int i3) {
            if (a.this.f135562e == null) {
                return;
            }
            int minimumHeight = a.this.f135562e.getMinimumHeight();
            final int i16 = i3 - minimumHeight;
            w.d("WebViewExtendTextAreaClient", "OnHeightChangedListener, totalHeight: %d, lateSavedKeyboardPanelHeight: %d, currentKeyboardPanelHeight: %d", Integer.valueOf(i3), Integer.valueOf(a.this.f135564g), Integer.valueOf(minimumHeight));
            if (minimumHeight == 0 || a.this.f135564g == minimumHeight) {
                return;
            }
            a.this.f135564g = minimumHeight;
            a.this.f135565h = i3;
            com.tencent.luggage.wxa.z7.a.f146372a.a(a.this.f135560c.a(), a.this.f135560c.b(), new a.b(i3, a.this.a(i3), Integer.valueOf(a.this.f135567j), new Function0() { // from class: j31.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit b16;
                    b16 = a.b.this.b(i16);
                    return b16;
                }
            }));
        }

        @Override // com.tencent.luggage.wxa.ol.f0.k
        public EditText a() {
            return a.this.f135563f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements x.i {

        /* renamed from: a, reason: collision with root package name */
        public boolean f135576a = false;

        public c() {
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public int getHeight() {
            return a.this.f135565h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit b(int i3) {
            a.this.onKeyboardHeightChanged(i3 > 0, i3, false);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit c(boolean z16) {
            a aVar = a.this;
            aVar.onKeyboardHeightChanged(z16, z16 ? aVar.f135565h : 0, false);
            return null;
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public void a(final int i3) {
            boolean z16 = (i3 == 0 || a.this.f135565h == 0 || i3 == a.this.f135565h) ? false : true;
            a.this.f135565h = i3;
            if (z16) {
                com.tencent.luggage.wxa.z7.a.f146372a.a(a.this.f135560c.a(), a.this.f135560c.b(), new a.b(i3, a.this.a(i3), Integer.valueOf(a.this.f135567j), new Function0() { // from class: j31.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit b16;
                        b16 = a.c.this.b(i3);
                        return b16;
                    }
                }));
            }
            f0 a16 = a.this.a();
            if (a16 != null) {
                a16.a(i3);
            }
        }

        public final void b(final boolean z16) {
            f0 a16 = a.this.a();
            if (a16 != null) {
                if (a.this.f135563f != null) {
                    if (z16) {
                        a16.a(a.this.f135563f);
                    } else {
                        a16.b(a.this.f135563f);
                    }
                }
                a16.a(z16 ? a.this.f135565h : 0);
            }
            com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
            com.tencent.luggage.wxa.xd.f a17 = a.this.f135560c.a();
            com.tencent.luggage.wxa.xd.d b16 = a.this.f135560c.b();
            int i3 = z16 ? a.this.f135565h : 0;
            a aVar2 = a.this;
            aVar.a(a17, b16, new a.b(i3, aVar2.a(aVar2.f135565h), Integer.valueOf(a.this.f135567j), new Function0() { // from class: j31.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit c16;
                    c16 = a.c.this.c(z16);
                    return c16;
                }
            }));
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public void a(boolean z16) {
            this.f135576a = z16;
            if (a.this.f135560c != null && a.this.f135560c.a() != null && a.this.f135560c.a().getContentView() != null && !com.tencent.luggage.wxa.z7.a.f146372a.a()) {
                if (a.this.f135568k) {
                    return;
                }
                a.this.f135568k = true;
                a.this.f135560c.a().getContentView().postDelayed(new Runnable() { // from class: j31.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c.this.a();
                    }
                }, 250L);
                return;
            }
            b(z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (a.this.f135566i) {
                b(this.f135576a);
            }
            a.this.f135568k = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements f0.j {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.ol.f0.j
        public void a(boolean z16) {
            w.d("WebViewExtendTextAreaClient", "onInputDone#onShowKeyboard, fromDoneButton: %b, confirmHold: %b", Boolean.valueOf(z16), Boolean.valueOf(a.this.f135570m));
            a.this.a(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f135579a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f135580b;

        public e(f0 f0Var, g gVar) {
            this.f135579a = f0Var;
            this.f135580b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f135566i) {
                this.f135579a.a(this.f135580b.f135586d);
                if (Build.VERSION.SDK_INT < 33) {
                    com.tencent.luggage.wxa.z7.a aVar = com.tencent.luggage.wxa.z7.a.f146372a;
                    com.tencent.luggage.wxa.xd.f a16 = a.this.f135560c.a();
                    com.tencent.luggage.wxa.xd.d b16 = a.this.f135560c.b();
                    int i3 = a.this.f135565h;
                    a aVar2 = a.this;
                    aVar.a(a16, b16, new a.b(i3, aVar2.a(aVar2.f135565h), Integer.valueOf(a.this.f135567j), new Function0() { // from class: j31.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit a17;
                            a17 = a.e.this.a();
                            return a17;
                        }
                    }));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a() {
            a aVar = a.this;
            aVar.onKeyboardHeightChanged(true, aVar.f135566i ? a.this.f135565h : 0, false);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        public String f135583a;

        /* renamed from: b, reason: collision with root package name */
        public String f135584b;

        /* renamed from: c, reason: collision with root package name */
        public String f135585c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f135586d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f135587e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f135588f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f135589g;

        /* renamed from: h, reason: collision with root package name */
        public int f135590h;

        public g(String str) {
            JSONObject jSONObject;
            this.f135583a = "";
            this.f135584b = "";
            this.f135585c = "";
            this.f135586d = false;
            this.f135587e = false;
            this.f135588f = false;
            this.f135589g = false;
            this.f135590h = 0;
            w.d("TextAreaInfo", "totalInfo:" + str);
            this.f135583a = str;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                w.b("TextAreaInfo", "TextAreaInfo convert to json error");
                jSONObject = new JSONObject();
            }
            try {
                if (jSONObject.has("element-tag")) {
                    this.f135584b = jSONObject.getString("element-tag");
                }
            } catch (JSONException unused2) {
                w.b("TextAreaInfo", "TextAreaInfo add elementTag error");
            }
            try {
                if (jSONObject.has("keyboard-type")) {
                    this.f135585c = jSONObject.getString("keyboard-type");
                }
            } catch (JSONException unused3) {
                w.b("TextAreaInfo", "TextAreaInfo add keyboardType error");
            }
            try {
                if (jSONObject.has("show-confirm-bar")) {
                    this.f135586d = w0.a(jSONObject.getString("show-confirm-bar"), false);
                }
            } catch (JSONException unused4) {
                w.b("TextAreaInfo", "TextAreaInfo get show-confirm-bar error");
            } catch (Exception unused5) {
                w.b("TextAreaInfo", "TextAreaInfo get show-confirm-bar error");
            }
            try {
                if (jSONObject.has(NotificationActivity.PASSWORD)) {
                    this.f135587e = w0.a(jSONObject.getString(NotificationActivity.PASSWORD), false);
                }
            } catch (JSONException unused6) {
                w.b("TextAreaInfo", "TextAreaInfo get password error");
            } catch (Exception unused7) {
                w.b("TextAreaInfo", "TextAreaInfo get password error");
            }
            try {
                if (jSONObject.has("show-cover-view")) {
                    this.f135588f = w0.a(jSONObject.getString("show-cover-view"), false);
                }
            } catch (JSONException unused8) {
                w.b("TextAreaInfo", "TextAreaInfo get show-cover-view error");
            } catch (Exception unused9) {
                w.b("TextAreaInfo", "TextAreaInfo get show-cover-view error");
            }
            try {
                if (jSONObject.has("confirm-hold")) {
                    this.f135589g = w0.a(jSONObject.getString("confirm-hold"), false);
                }
            } catch (JSONException unused10) {
                w.b("TextAreaInfo", "TextAreaInfo get confirm-hold error");
            } catch (Exception unused11) {
                w.b("TextAreaInfo", "TextAreaInfo get confirm-hold error");
            }
            if (jSONObject.has("view-id")) {
                this.f135590h = jSONObject.optInt("view-id");
            }
        }
    }

    public a(XWebExtendInterface xWebExtendInterface) {
        super(xWebExtendInterface);
        this.f135558a = "WebViewExtendTextAreaClient";
        this.f135559b = 250L;
        this.f135564g = 0;
        this.f135565h = 0;
        this.f135566i = false;
        this.f135567j = -1;
        this.f135568k = false;
        this.f135569l = 0;
        this.f135570m = false;
        this.f135571n = new d1(new C6505a());
        this.f135572o = new b();
        this.f135573p = new c();
    }

    @Override // com.tencent.xweb.XWebExtendTextAreaClient
    public int getToolBarHeight(int i3) {
        h0 h0Var = this.f135560c;
        if (h0Var == null || h0Var.a() == null || n0.a(this.f135560c.a().getContentView())) {
            return 0;
        }
        return a(i3);
    }

    @Override // com.tencent.xweb.XWebExtendTextAreaClient
    public boolean onHideKeyboard(String str, InputConnection inputConnection) {
        f0 a16;
        w.a("WebViewExtendTextAreaClient", "onHideKeyboard");
        if (this.f135560c != null && (a16 = a()) != null) {
            a16.a(false);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            this.f135571n.b();
            if (this.f135560c.a() != null && this.f135560c.a().getContentView() != null && this.f135560c.a().getContentView().getViewTreeObserver() != null) {
                this.f135560c.a().getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f135571n);
            }
        } else {
            x xVar = this.f135561d;
            if (xVar != null) {
                xVar.b(this.f135573p);
            }
        }
        j.f133225a.a(true);
        this.f135566i = false;
        f0 f0Var = this.f135562e;
        if (f0Var != null) {
            f0Var.b(this.f135572o);
        }
        this.f135562e = null;
        this.f135567j = -1;
        return false;
    }

    @Override // com.tencent.xweb.XWebExtendTextAreaClient
    public boolean onShowKeyboard(String str, InputConnection inputConnection, ResultReceiver resultReceiver) {
        f0 a16;
        w.a("WebViewExtendTextAreaClient", "onShowKeyboard");
        boolean z16 = true;
        this.f135566i = true;
        g gVar = new g(str);
        com.tencent.luggage.wxa.z7.a.f146372a.a(new a.C6975a(1, gVar.f135590h));
        if (this.f135561d == null) {
            this.f135561d = q.c(this.f135560c.a().getContentView());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (this.f135560c.a() != null && this.f135560c.a().getContentView() != null && this.f135560c.a().getContentView().getViewTreeObserver() != null) {
                ViewTreeObserver viewTreeObserver = this.f135560c.a().getContentView().getViewTreeObserver();
                viewTreeObserver.removeOnGlobalLayoutListener(this.f135571n);
                viewTreeObserver.addOnGlobalLayoutListener(this.f135571n);
            }
        } else {
            x xVar = this.f135561d;
            if (xVar != null) {
                xVar.a(this.f135573p);
            }
        }
        j.f133225a.a(false);
        this.f135570m = gVar.f135589g;
        this.f135567j = gVar.f135590h;
        if (this.f135560c != null && (a16 = a()) != null && gVar.f135586d) {
            a16.setComponentView(gVar.f135588f);
            a16.x();
            if (gVar.f135587e || !"emoji".equals(gVar.f135585c)) {
                z16 = false;
            }
            a16.setCanSmileyInput(z16);
            a16.setShowDoneButton(gVar.f135586d);
            a16.setOnDoneListener(new d());
            a16.postDelayed(new e(a16, gVar), 200L);
        }
        return false;
    }

    @Override // com.tencent.xweb.XWebExtendTextAreaClient
    public boolean onShowKeyboardConfig(int i3, int i16, String str, int i17, int i18, EditorInfo editorInfo) {
        w.a("WebViewExtendTextAreaClient", "onShowKeyboardConfig");
        com.tencent.luggage.wxa.vl.c cVar = null;
        try {
            cVar = com.tencent.luggage.wxa.vl.c.a(new JSONObject(str).optString("confirm-type", null));
        } catch (Exception unused) {
            w.f("WebViewExtendTextAreaClient", "onShowKeyboardConfig, get confirm-type error");
        }
        if (cVar != null) {
            w.d("WebViewExtendTextAreaClient", "onShowKeyboardConfig, confirmType: " + cVar);
            if (com.tencent.luggage.wxa.vl.c.RETURN != cVar) {
                editorInfo.imeOptions &= -1073741825;
            }
            int i19 = editorInfo.imeOptions;
            int i26 = cVar.f143658a;
            editorInfo.imeOptions = i19 | i26;
            this.f135569l = i26;
            return false;
        }
        return false;
    }

    @Override // com.tencent.xweb.XWebExtendTextAreaClient
    public boolean performEditorAction(int i3) {
        w.a("WebViewExtendTextAreaClient", "performEditorAction, actionCode: " + i3);
        if (i3 != 0 && i3 == this.f135569l) {
            w.d("WebViewExtendTextAreaClient", "performEditorAction, confirmHold: " + this.f135570m);
            a(this.f135570m);
            return false;
        }
        return true;
    }

    public final f0 a() {
        synchronized ("WebViewExtendTextAreaClient") {
            f0 f0Var = this.f135562e;
            if (f0Var != null) {
                return f0Var;
            }
            com.tencent.luggage.wxa.fi.a aVar = null;
            if (!this.f135566i) {
                return null;
            }
            h0 h0Var = this.f135560c;
            if (h0Var == null || h0Var.a() == null) {
                return null;
            }
            View contentView = this.f135560c.a().getContentView();
            if (this.f135560c.a() != null && (this.f135560c.a() instanceof v)) {
                aVar = ((v) this.f135560c.a()).z0();
            }
            f0 a16 = f0.a(contentView, aVar);
            this.f135562e = a16;
            if (a16 != null) {
                this.f135563f = new EditText(com.tencent.luggage.wxa.ye.c.a(this.f135562e.getContext()));
                this.f135562e.a(this.f135572o);
            }
            return this.f135562e;
        }
    }

    public void a(h0 h0Var) {
        this.f135560c = h0Var;
    }

    public final int a(int i3) {
        if (a() == null) {
            return 0;
        }
        int minimumHeight = this.f135562e.getMinimumHeight();
        if (minimumHeight != 0 && minimumHeight != this.f135564g) {
            this.f135564g = minimumHeight;
        }
        w.a("WebViewExtendTextAreaClient", "getKeyboardPanelHeight, keyboardHeight: " + i3 + " mLateSavedKeyboardPanelHeight: " + this.f135564g);
        return i3 + this.f135564g;
    }

    public final void a(boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(function(){    var focusElement = document.activeElement;    if(focusElement){        if(focusElement.onkeyboardconfirm){            focusElement.onkeyboardconfirm();        }");
        sb5.append(!z16 ? "        focusElement.blur();" : "");
        sb5.append("    }})();");
        evaluateJavascript(sb5.toString(), new f());
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements ValueCallback {
        public f() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }
}
