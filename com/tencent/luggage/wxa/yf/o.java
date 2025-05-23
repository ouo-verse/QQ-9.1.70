package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class o extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 955;

    @NotNull
    public static final String NAME = "preloadWebview";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145731a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject, int i3) {
        String str;
        int i16;
        com.tencent.luggage.wxa.ic.g runtime;
        com.tencent.luggage.wxa.kj.p Y;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("invoke appId:");
        String str2 = null;
        if (vVar != null) {
            str = vVar.getAppId();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(", webviewId:");
        if (vVar != null) {
            i16 = vVar.getComponentId();
        } else {
            i16 = 0;
        }
        sb5.append(i16);
        sb5.append(", url:");
        if (vVar != null) {
            str2 = vVar.A0();
        }
        sb5.append(str2);
        com.tencent.luggage.wxa.tn.w.d("Luggage.JsApiPreloadNextWebview", sb5.toString());
        if (vVar != null && (runtime = vVar.getRuntime()) != null && (Y = runtime.Y()) != null) {
            Y.k(NAME);
        }
        if (vVar != null) {
            vVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
