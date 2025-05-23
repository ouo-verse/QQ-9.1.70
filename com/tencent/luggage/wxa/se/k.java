package com.tencent.luggage.wxa.se;

import android.view.View;
import com.tencent.luggage.wxa.se.a;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k extends com.tencent.luggage.wxa.ee.c {
    public static final int CTRL_INDEX = 596;

    @NotNull
    public static final String NAME = "removeWebGLCanvas";

    /* renamed from: b, reason: collision with root package name */
    public static final a f140320b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getInt("canvasId");
    }

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(com.tencent.luggage.wxa.m4.b component, int i3, View view, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(view, "view");
        w.d("JsApiRemoveHTMLCanvasElement", "remove HTMLCanvasElement for canvasId[" + i3 + ']');
        a.b bVar = com.tencent.luggage.wxa.se.a.f140284c;
        String appId = component.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
        bVar.a(appId).e(i3);
        return super.a((com.tencent.luggage.wxa.xd.f) component, i3, view, jSONObject);
    }
}
