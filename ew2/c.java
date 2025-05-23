package ew2;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public String f397280b;

    /* renamed from: c, reason: collision with root package name */
    public String f397281c;

    /* renamed from: a, reason: collision with root package name */
    public int f397279a = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f397282d = -1;

    public static c a(String str, c cVar) {
        if (cVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                cVar.f397279a = jSONObject.optInt("ret", -1);
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    cVar.f397280b = optJSONObject.optString("clickid");
                    cVar.f397281c = optJSONObject.optString("dstlink");
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return cVar;
    }

    public String toString() {
        return "clickId:" + this.f397280b + " desLinkUrl:" + this.f397281c;
    }
}
