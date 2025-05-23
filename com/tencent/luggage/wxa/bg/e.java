package com.tencent.luggage.wxa.bg;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.il.n;
import com.tencent.luggage.wxa.mo.h;
import com.tencent.luggage.wxa.mo.p;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 1417;

    @NotNull
    private static final String NAME = "updateActionSheet";

    /* renamed from: a, reason: collision with root package name */
    public static final a f122677a = new a(null);

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
        public final /* synthetic */ l f122678a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122679b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122680c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f122681d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f122682e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f122683f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements p {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f122684a;

            public a(ArrayList arrayList) {
                this.f122684a = arrayList;
            }

            @Override // com.tencent.luggage.wxa.mo.p
            public final void a(h hVar) {
                int size = this.f122684a.size();
                for (int i3 = 0; i3 < size; i3++) {
                    hVar.getItem(i3).setTitle((CharSequence) this.f122684a.get(i3));
                }
            }
        }

        public b(l lVar, int i3, int i16, e eVar, String str, ArrayList arrayList) {
            this.f122678a = lVar;
            this.f122679b = i3;
            this.f122680c = i16;
            this.f122681d = eVar;
            this.f122682e = str;
            this.f122683f = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z16;
            n X = this.f122678a.getRuntime().X();
            Intrinsics.checkNotNullExpressionValue(X, "env.runtime.getNativeWidgetManager()");
            MMBottomSheet a16 = X.a(this.f122679b);
            if (a16 == null) {
                w.f("Luggage.JsApiUpdateActionSheet", "bottomSheet is null, id:" + this.f122679b + " return");
                this.f122678a.a(this.f122680c, this.f122681d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                return;
            }
            if (com.tencent.luggage.wxa.h6.d.a(this.f122682e)) {
                if (this.f122682e.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    com.tencent.luggage.wxa.bg.b.a(this.f122678a.getContext(), a16, this.f122682e);
                }
            }
            a16.setOnCreateMenuListener(new a(this.f122683f));
            a16.tryShow();
            this.f122678a.a(this.f122680c, this.f122681d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        int i16;
        w.d("Luggage.JsApiUpdateActionSheet", "updateActionSheet data:" + jSONObject);
        if (lVar == null) {
            w.f("Luggage.JsApiUpdateActionSheet", "env is null, return");
            return;
        }
        if (jSONObject != null) {
            i16 = jSONObject.optInt("id", -1);
        } else {
            i16 = -1;
        }
        if (i16 == -1) {
            w.f("Luggage.JsApiUpdateActionSheet", "invalid id, return");
            lVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        Intrinsics.checkNotNull(jSONObject);
        String a16 = com.tencent.luggage.wxa.h6.d.a(jSONObject, "alertText");
        w.d("Luggage.JsApiUpdateActionSheet", "invoke, alertText: " + a16);
        String optString = jSONObject.optString(VideoTemplateParser.ITEM_LIST);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            int length = jSONArray.length();
            for (int i17 = 0; i17 < length; i17++) {
                Object obj = jSONArray.get(i17);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList.add((String) obj);
            }
            lVar.a(new b(lVar, i16, i3, this, a16, arrayList));
        } catch (Exception e16) {
            w.b("Luggage.JsApiUpdateActionSheet", e16.getMessage());
            lVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
        }
    }
}
