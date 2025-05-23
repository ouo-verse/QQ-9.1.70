package mf0;

import com.qzone.proxy.personalitycomponent.model.WidgetPublicCacheData;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f416650a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f416651b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f416652c = "";

    public static c d(String str) {
        if (str == null) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.f416650a = jSONObject.optString("icon_image_url", "");
            cVar.f416651b = jSONObject.optString("md5", "");
            cVar.f416652c = jSONObject.optString(WidgetPublicCacheData.COLUMN_WIDGET_ID, "");
            return cVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String a() {
        return this.f416650a;
    }

    public String b() {
        return this.f416652c;
    }

    public String c() {
        return this.f416651b;
    }

    public String toString() {
        return "k = icon_image_url, value = " + this.f416650a + "\n k = md5, value = " + this.f416651b + "\n k = widget_id, value = " + this.f416652c;
    }
}
