package com.tencent.luggage.wxa.f3;

import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.ee.d {
    public static final int CTRL_INDEX = 300;
    public static final String NAME = "updateHTMLWebView";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(f fVar, int i3, View view, JSONObject jSONObject) {
        if (!(view instanceof a)) {
            return false;
        }
        String optString = jSONObject.optString("src", "");
        w.d("MicroMsg.AppBrand.JsApiUpdateHTMLWebView", "onUpdateView appId[%s] viewId[%d] viewHash[%d] src[%s] wv.url[%s]", fVar.getAppId(), Integer.valueOf(i3), Integer.valueOf(view.hashCode()), optString, ((a) view).getWebView().getUrl());
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        ((com.tencent.luggage.wxa.lh.a) view).a(optString);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }
}
