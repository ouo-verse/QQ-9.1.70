package com.tencent.luggage.wxa.bg;

import android.widget.Button;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.il.n;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 1416;

    @NotNull
    private static final String NAME = "updateModal";

    /* renamed from: a, reason: collision with root package name */
    public static final a f122685a = new a(null);

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
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f122686a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122687b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122688c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f122689d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f122690e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f122691f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f122692g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f122693h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f122694i;

        public b(l lVar, int i3, int i16, f fVar, String str, String str2, String str3, String str4, String str5) {
            this.f122686a = lVar;
            this.f122687b = i3;
            this.f122688c = i16;
            this.f122689d = fVar;
            this.f122690e = str;
            this.f122691f = str2;
            this.f122692g = str3;
            this.f122693h = str4;
            this.f122694i = str5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.ml.b bVar;
            boolean z16;
            n X = this.f122686a.getRuntime().X();
            Intrinsics.checkNotNullExpressionValue(X, "env.runtime.getNativeWidgetManager()");
            m b16 = X.b(this.f122687b);
            if (b16 == null) {
                w.f("Luggage.JsApiUpdateModal", "dialog is not exist, return");
                this.f122686a.a(this.f122688c, this.f122689d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                return;
            }
            if (b16 instanceof com.tencent.luggage.wxa.ml.b) {
                bVar = (com.tencent.luggage.wxa.ml.b) b16;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                w.f("Luggage.JsApiUpdateModal", "appbrandDialog is not AppBrandAlertDialog, return");
                this.f122686a.a(this.f122688c, this.f122689d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
                return;
            }
            if (bVar.getmEditText().getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!w0.c(this.f122690e)) {
                if (w0.c(this.f122691f) && !z16) {
                    bVar.setMessage(this.f122690e);
                } else {
                    bVar.setTitle(this.f122690e);
                }
            }
            if (!w0.c(this.f122691f) && !z16) {
                bVar.setMessage(this.f122691f);
            }
            if (z16) {
                if (!w0.c(this.f122691f)) {
                    bVar.setEditTextDefaultText(this.f122691f);
                } else if (!w0.c(this.f122692g)) {
                    bVar.setEditTextHint(this.f122692g);
                }
            }
            Button oKBtn = bVar.getOKBtn();
            if (oKBtn != null) {
                oKBtn.setText(this.f122693h);
            }
            Button cancelBtn = bVar.getCancelBtn();
            if (cancelBtn != null) {
                cancelBtn.setText(this.f122694i);
            }
            this.f122686a.a(this.f122688c, this.f122689d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        int i16;
        w.d("Luggage.JsApiUpdateModal", "updateModal data:" + jSONObject);
        if (lVar == null) {
            w.f("Luggage.JsApiUpdateModal", "env is null, return");
            return;
        }
        if (jSONObject != null) {
            i16 = jSONObject.optInt("id", -1);
        } else {
            i16 = -1;
        }
        if (i16 == -1) {
            w.f("Luggage.JsApiUpdateModal", "invalid id, return");
            lVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        Intrinsics.checkNotNull(jSONObject);
        lVar.a(new b(lVar, i16, i3, this, jSONObject.optString("title"), jSONObject.optString("content", ""), jSONObject.optString("placeholderText"), jSONObject.optString("confirmText", lVar.getContext().getString(R.string.f1640324q)), jSONObject.optString("cancelText", lVar.getContext().getString(R.string.f1640124o))));
    }
}
