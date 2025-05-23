package oi0;

import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\n"}, d2 = {"Lorg/json/JSONObject;", "", "a", "e", "d", "f", "", "g", "b", "c", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final String a(JSONObject jSONObject) {
        return jSONObject.optString("background_color", "");
    }

    public static final int b(JSONObject jSONObject) {
        return jSONObject.optInt("height", 0);
    }

    public static final String c(JSONObject jSONObject) {
        return jSONObject.optString("pic_token", "");
    }

    public static final String d(JSONObject jSONObject) {
        return jSONObject.optString("text", "");
    }

    public static final String e(JSONObject jSONObject) {
        return jSONObject.optString("text_color", "");
    }

    public static final String f(JSONObject jSONObject) {
        return jSONObject.optString("pic_url", "");
    }

    public static final int g(JSONObject jSONObject) {
        return jSONObject.optInt("width", 0);
    }
}
