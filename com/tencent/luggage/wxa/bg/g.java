package com.tencent.luggage.wxa.bg;

import android.view.View;
import android.widget.TextView;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 639;

    @NotNull
    private static final String NAME = "updateToast";

    /* renamed from: a, reason: collision with root package name */
    public static final a f122695a = new a(null);

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
        public final /* synthetic */ v f122696a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f122697b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122698c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f122699d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f122700e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f122701f;

        public b(v vVar, l lVar, int i3, g gVar, int i16, String str) {
            this.f122696a = vVar;
            this.f122697b = lVar;
            this.f122698c = i3;
            this.f122699d = gVar;
            this.f122700e = i16;
            this.f122701f = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View c16 = this.f122696a.u0().c();
            if (c16 != null && c16.getTag() != null) {
                try {
                    Object tag = c16.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                    if (((Integer) tag).intValue() != this.f122700e) {
                        w.f("Luggage.JsApiUpdateToast", "toastView is null, error");
                        this.f122697b.a(this.f122698c, this.f122699d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                        return;
                    }
                    TextView textView = (TextView) c16.findViewById(R.id.title);
                    if (textView == null) {
                        w.f("Luggage.JsApiUpdateToast", "textView is null, error");
                        this.f122697b.a(this.f122698c, this.f122699d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
                        return;
                    } else {
                        textView.setText(this.f122701f);
                        return;
                    }
                } catch (Exception unused) {
                    w.f("Luggage.JsApiUpdateToast", "toastView tag is " + c16.getTag() + ", error");
                    this.f122697b.a(this.f122698c, this.f122699d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                    return;
                }
            }
            w.f("Luggage.JsApiUpdateToast", "toastView or tag is null, error");
            this.f122697b.a(this.f122698c, this.f122699d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        w.d("Luggage.JsApiUpdateToast", "updateToast: %s", jSONObject);
        if (lVar == null) {
            w.f("Luggage.JsApiUpdateToast", "env is null, return");
            return;
        }
        v J = lVar.J();
        Intrinsics.checkNotNullExpressionValue(J, "env.currentPageView");
        Intrinsics.checkNotNull(jSONObject);
        int optInt = jSONObject.optInt("id", -1);
        if (optInt == -1) {
            w.f("Luggage.JsApiUpdateToast", "invalid id, return");
            lVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
        } else {
            lVar.getRuntime().e(new b(J, lVar, i3, this, optInt, jSONObject.optString("title")));
        }
    }
}
