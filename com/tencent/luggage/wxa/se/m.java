package com.tencent.luggage.wxa.se;

import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m extends com.tencent.luggage.wxa.ee.d {
    public static final int CTRL_INDEX = 595;

    @NotNull
    public static final String NAME = "updateWebGLCanvas";

    /* renamed from: b, reason: collision with root package name */
    public static final a f140321b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean enableGesture() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getInt("canvasId");
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.m4.b bVar, int i3, View view, JSONObject jSONObject) {
        w.d("JsApiUpdateHTMLCanvasElement", "update HTMLCanvasElement for canvasId[" + i3 + ']');
        return super.a((com.tencent.luggage.wxa.xd.f) bVar, i3, view, jSONObject);
    }
}
