package com.tencent.luggage.wxa.bg;

import android.content.DialogInterface;
import android.widget.RelativeLayout;
import com.tencent.luggage.wxa.h6.h;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.il.n;
import com.tencent.luggage.wxa.kj.n0;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ml.b;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.ol.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f122620a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122621b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f122622c;

        public a(l lVar, int i3, JSONObject jSONObject) {
            this.f122620a = lVar;
            this.f122621b = i3;
            this.f122622c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", this.f122620a.getAppId(), Integer.valueOf(this.f122621b));
            c.this.invoke(this.f122620a, this.f122622c, this.f122621b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public final /* synthetic */ JSONObject C;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f122624a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122625b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f122626c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f122627d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f122628e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f122629f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f122630g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f122631h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f122632i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f122633j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f122634k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f122635l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f122636m;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ml.b f122637a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n f122638b;

            public a(com.tencent.luggage.wxa.ml.b bVar, n nVar) {
                this.f122637a = bVar;
                this.f122638b = nVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                HashMap hashMap = new HashMap();
                hashMap.put(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, Boolean.TRUE);
                hashMap.put("cancel", Boolean.FALSE);
                if (b.this.f122629f) {
                    hashMap.put("content", this.f122637a.getEditTextValue());
                }
                this.f122638b.d(b.this.f122631h);
                b bVar = b.this;
                bVar.f122624a.a(bVar.f122632i, c.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bg.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterfaceOnClickListenerC6060b implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f122640a;

            public DialogInterfaceOnClickListenerC6060b(n nVar) {
                this.f122640a = nVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                HashMap hashMap = new HashMap();
                hashMap.put(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, Boolean.FALSE);
                hashMap.put("cancel", Boolean.TRUE);
                dialogInterface.dismiss();
                this.f122640a.d(b.this.f122631h);
                b bVar = b.this;
                bVar.f122624a.a(bVar.f122632i, c.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bg.c$b$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterfaceOnCancelListenerC6061c implements DialogInterface.OnCancelListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f122642a;

            public DialogInterfaceOnCancelListenerC6061c(n nVar) {
                this.f122642a = nVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                HashMap hashMap = new HashMap();
                hashMap.put(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, Boolean.FALSE);
                hashMap.put("cancel", Boolean.TRUE);
                this.f122642a.d(b.this.f122631h);
                b bVar = b.this;
                bVar.f122624a.a(bVar.f122632i, c.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class d implements DialogInterface.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f122644a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x f122645b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ C6062c f122646c;

            public d(n nVar, x xVar, C6062c c6062c) {
                this.f122644a = nVar;
                this.f122645b = xVar;
                this.f122646c = c6062c;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                h.a(b.this.f122625b.getContext());
                this.f122644a.d(b.this.f122631h);
                x xVar = this.f122645b;
                if (xVar != null) {
                    xVar.b(this.f122646c);
                }
            }
        }

        public b(l lVar, v vVar, boolean z16, String str, String str2, boolean z17, String str3, int i3, int i16, boolean z18, String str4, int i17, int i18, JSONObject jSONObject) {
            this.f122624a = lVar;
            this.f122625b = vVar;
            this.f122626c = z16;
            this.f122627d = str;
            this.f122628e = str2;
            this.f122629f = z17;
            this.f122630g = str3;
            this.f122631h = i3;
            this.f122632i = i16;
            this.f122633j = z18;
            this.f122634k = str4;
            this.f122635l = i17;
            this.f122636m = i18;
            this.C = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            r N;
            if (!this.f122624a.isRunning()) {
                return;
            }
            n X = this.f122624a.getRuntime().X();
            this.f122625b.m0().a(n0.MODAL);
            if (this.f122626c) {
                N = this.f122624a.getRuntime().k0();
            } else {
                N = this.f122624a.getRuntime().N();
            }
            final com.tencent.luggage.wxa.ml.b bVar = new com.tencent.luggage.wxa.ml.b(this.f122624a.getContext());
            if (!w0.c(this.f122627d)) {
                if (w0.c(this.f122628e) && !this.f122629f) {
                    bVar.setMessage(this.f122627d);
                } else {
                    bVar.setTitle(this.f122627d);
                }
            }
            if (!w0.c(this.f122628e) && !this.f122629f) {
                bVar.setMessage(this.f122628e);
            }
            bVar.setPositiveButton(this.f122630g, true, new a(bVar, X));
            if (this.f122633j) {
                bVar.setNegativeButton(this.f122634k, false, new DialogInterfaceOnClickListenerC6060b(X));
            }
            bVar.setOnCancelListener(new DialogInterfaceOnCancelListenerC6061c(X));
            bVar.setPositiveButtonColor(this.f122635l);
            if (this.f122633j) {
                bVar.setNegativeButtonColor(this.f122636m);
            }
            if (this.f122629f) {
                bVar.hasEditText(true);
                if (!w0.c(this.f122628e)) {
                    bVar.setEditTextDefaultText(this.f122628e);
                } else {
                    String optString = this.C.optString("placeholderText");
                    if (!w0.c(optString)) {
                        bVar.setEditTextHint(optString);
                    }
                }
                x c16 = q.c(this.f122625b.getContentView());
                C6062c c6062c = new C6062c(bVar, this.f122624a, null);
                c16.a(c6062c);
                bVar.setOnDismissListener(new d(X, c16, c6062c));
            }
            N.a(bVar);
            int i3 = this.f122631h;
            if (i3 != -1) {
                X.a(i3, bVar);
            }
            if (this.f122629f) {
                bVar.editTextRequestFocus();
                h.b(this.f122625b.getContext());
                this.f122624a.a(new Runnable() { // from class: d21.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.editTextRequestFocus();
                    }
                }, 500L);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bg.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6062c implements x.i {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.ml.b f122648a;

        /* renamed from: b, reason: collision with root package name */
        public final l f122649b;

        /* renamed from: c, reason: collision with root package name */
        public int f122650c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f122651d;

        /* renamed from: e, reason: collision with root package name */
        public int f122652e;

        public /* synthetic */ C6062c(com.tencent.luggage.wxa.ml.b bVar, l lVar, a aVar) {
            this(bVar, lVar);
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public void a(int i3) {
            w.a("MicroMsg.JsApiShowModal", "refreshHeight height:%d", Integer.valueOf(i3));
            if (this.f122650c != i3 && this.f122651d) {
                a(true, i3);
            }
            this.f122650c = i3;
        }

        public final int b(int i3) {
            int i16;
            int i17 = this.f122652e;
            if (i17 > 0) {
                return i17;
            }
            v J = this.f122649b.J();
            if (J == null) {
                return this.f122652e;
            }
            int i18 = com.tencent.luggage.wxa.uk.n0.a((i) J)[1];
            c.b navigationBar = J.D().getNavigationBar();
            if (navigationBar == null) {
                i16 = 0;
            } else {
                i16 = navigationBar.f144266a;
            }
            int height = ((((i18 + i3) - J.W().getHeight()) - i16) - this.f122648a.getContentView().getHeight()) / 2;
            this.f122652e = height;
            if (height <= i3) {
                this.f122652e = i3 + 12;
            }
            return this.f122652e;
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public int getHeight() {
            return this.f122650c;
        }

        public C6062c(com.tencent.luggage.wxa.ml.b bVar, l lVar) {
            this.f122651d = false;
            this.f122652e = -1;
            this.f122648a = bVar;
            this.f122649b = lVar;
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public void a(boolean z16) {
            w.a("MicroMsg.JsApiShowModal", "onKeyboardStateChanged shown:%b, keyboardHeight:%d", Boolean.valueOf(z16), Integer.valueOf(this.f122650c));
            if (z16 == this.f122651d) {
                return;
            }
            this.f122651d = z16;
            a(z16, this.f122650c);
        }

        public final void a(boolean z16, int i3) {
            if (!z16) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f122648a.getContentView().getLayoutParams();
                layoutParams.addRule(14);
                layoutParams.removeRule(12);
                layoutParams.addRule(13);
                layoutParams.bottomMargin = 0;
                this.f122648a.getContentView().setLayoutParams(layoutParams);
                return;
            }
            if (i3 > 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f122648a.getContentView().getLayoutParams();
                layoutParams2.removeRule(13);
                layoutParams2.addRule(12);
                layoutParams2.addRule(14);
                layoutParams2.bottomMargin = b(i3);
                this.f122648a.getContentView().setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        int a16;
        int a17;
        v J = lVar.J();
        if (J == null) {
            if (lVar.getRuntime() != null && !lVar.getRuntime().t0() && !lVar.getRuntime().s0()) {
                w.h("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", lVar.getAppId(), Integer.valueOf(i3));
                lVar.getRuntime().c(new a(lVar, i3, jSONObject));
                return;
            } else {
                w.h("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", lVar.getAppId(), Integer.valueOf(i3));
                lVar.a(i3, makeReturnJson("fail:page don't exist"));
                return;
            }
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("confirmText", lVar.getContext().getString(R.string.f1640324q));
        String optString3 = jSONObject.optString("cancelText", lVar.getContext().getString(R.string.f1640124o));
        boolean optBoolean = jSONObject.optBoolean("showCancel", true);
        boolean optBoolean2 = jSONObject.optBoolean("editable", false);
        if (com.tencent.luggage.wxa.h6.l.f126905a.a(lVar.getAppId())) {
            a16 = com.tencent.luggage.wxa.tk.g.a(jSONObject.optString("confirmColorDark", ""), z.c().getResources().getColor(R.color.b_2));
            a17 = com.tencent.luggage.wxa.tk.g.a(jSONObject.optString("cancelColorDark", ""), z.c().getResources().getColor(R.color.b98));
        } else {
            a16 = com.tencent.luggage.wxa.tk.g.a(jSONObject.optString("confirmColor", ""), z.c().getResources().getColor(R.color.b_2));
            a17 = com.tencent.luggage.wxa.tk.g.a(jSONObject.optString("cancelColor", ""), z.c().getResources().getColor(R.color.b98));
        }
        String optString4 = jSONObject.optString("content");
        boolean optBoolean3 = jSONObject.optBoolean("upper", false);
        w.d("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s] upper[%b]", lVar.getAppId(), optString, optString4, Boolean.valueOf(optBoolean3));
        lVar.a(new b(lVar, J, optBoolean3, optString, optString4, optBoolean2, optString2, optInt, i3, optBoolean, optString3, a16, a17, jSONObject));
    }
}
