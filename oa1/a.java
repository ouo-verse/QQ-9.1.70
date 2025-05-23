package oa1;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f422274a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f422275b = "";

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject == null) {
            return aVar;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("anim_emoticon_count");
        if (optJSONObject == null) {
            return aVar;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AnimEmoCountConfBean", 2, "parse AnimCountConfBean: ");
        }
        if (optJSONObject.has("model")) {
            aVar.f422274a = optJSONObject.optString("model");
        }
        if (optJSONObject.has("version")) {
            aVar.f422275b = optJSONObject.optString("version");
        }
        return aVar;
    }

    public String toString() {
        return "{mAnimEmoVersion=" + this.f422275b + ", mAnimEmoModel=" + this.f422274a + "}";
    }
}
