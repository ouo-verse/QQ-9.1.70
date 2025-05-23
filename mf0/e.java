package mf0;

import com.tencent.biz.videostory.config.VSConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f416654a = "1";

    /* renamed from: b, reason: collision with root package name */
    private String f416655b = "1";

    /* renamed from: c, reason: collision with root package name */
    private String f416656c = VSConfigManager.f97066i;

    /* renamed from: d, reason: collision with root package name */
    private String f416657d = "1";

    /* renamed from: e, reason: collision with root package name */
    private String f416658e = "1";

    public static e f(String str) {
        JSONObject jSONObject;
        e eVar = new e();
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e16) {
                e16.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                eVar.f416654a = jSONObject.optString("subscribe_entrance_enable", "1");
                eVar.f416655b = jSONObject.optString("is_open_sharing", "1");
                eVar.f416656c = jSONObject.optString("subscribe_account_title", VSConfigManager.f97066i);
                eVar.f416657d = jSONObject.optString("newfollowlist", "1");
                eVar.f416658e = jSONObject.optString("subscribe_publish_entrance_enable", "1");
            }
        }
        return eVar;
    }

    public String a() {
        return this.f416654a;
    }

    public String b() {
        return this.f416655b;
    }

    public String c() {
        return this.f416657d;
    }

    public String d() {
        return this.f416658e;
    }

    public String e() {
        return this.f416656c;
    }

    public String toString() {
        return "k =subscribe_entrance_enable , value = " + this.f416654a + ",k =is_open_sharing , value = " + this.f416655b + ",k =subscribe_account_title , value = " + this.f416656c + ",k =subscribeAccountNewFollowListSwitch , value = " + this.f416657d + ",k =subscribeAccountPublishEntranceSwitch , value = " + this.f416658e;
    }
}
