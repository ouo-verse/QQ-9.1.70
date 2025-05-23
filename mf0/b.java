package mf0;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f416647a = "";

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f416648b = new JSONObject();

    /* renamed from: c, reason: collision with root package name */
    private String f416649c = "";

    public static b d(String str) {
        if (str == null) {
            return null;
        }
        try {
            b bVar = new b();
            JSONObject jSONObject = new JSONObject(str);
            bVar.f416647a = jSONObject.optString("icon_image_url", "");
            bVar.f416648b = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
            bVar.f416649c = jSONObject.optString("md5", "");
            return bVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public JSONObject a() {
        return this.f416648b;
    }

    public String b() {
        return this.f416647a;
    }

    public String c() {
        return this.f416649c;
    }

    public String toString() {
        return "k = icon_image_url, value = " + this.f416647a + "\n k = config, value = " + this.f416648b.toString() + "\n k = md5, value = " + this.f416649c;
    }
}
