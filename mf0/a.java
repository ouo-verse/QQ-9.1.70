package mf0;

import com.tencent.biz.videostory.config.VSConfigManager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f416644a = VSConfigManager.f97065h;

    /* renamed from: b, reason: collision with root package name */
    private String f416645b = "1";

    /* renamed from: c, reason: collision with root package name */
    private String f416646c = VSConfigManager.f97064f;

    public static a d(String str) {
        if (str == null) {
            return null;
        }
        try {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            aVar.f416644a = jSONObject.optString("mine_videostory_entrance", VSConfigManager.f97065h);
            aVar.f416645b = jSONObject.optString("enable_click_take_picture", "1");
            aVar.f416646c = jSONObject.optString("mine_videostory_drawer_entrance", VSConfigManager.f97064f);
            return aVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String a() {
        return this.f416645b;
    }

    public String b() {
        return this.f416646c;
    }

    public String c() {
        return this.f416644a;
    }

    public String toString() {
        return "k = mine_videostory_entrance, value = " + this.f416644a + "\n k = enableClickTakePicture, value = " + this.f416645b + "\n k = mine_videostory_chouti_entrance, value = " + this.f416646c;
    }
}
