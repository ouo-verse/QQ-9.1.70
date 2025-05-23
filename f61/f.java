package f61;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$LoveTreeInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f397914a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f397915b;

    /* renamed from: c, reason: collision with root package name */
    public String f397916c;

    /* renamed from: d, reason: collision with root package name */
    public String f397917d;

    /* renamed from: e, reason: collision with root package name */
    public String f397918e;

    /* renamed from: f, reason: collision with root package name */
    public int f397919f;

    public static f b(oidb_0xcf4$LoveTreeInfo oidb_0xcf4_lovetreeinfo) {
        if (oidb_0xcf4_lovetreeinfo == null) {
            return null;
        }
        f fVar = new f();
        if (oidb_0xcf4_lovetreeinfo.str_use_tree_icon.has()) {
            fVar.f397914a = oidb_0xcf4_lovetreeinfo.str_use_tree_icon.get();
        }
        if (oidb_0xcf4_lovetreeinfo.uint32_lack_water_flag.has()) {
            boolean z16 = true;
            if (oidb_0xcf4_lovetreeinfo.uint32_lack_water_flag.get() != 1) {
                z16 = false;
            }
            fVar.f397915b = z16;
        }
        if (oidb_0xcf4_lovetreeinfo.str_drop_icon.has()) {
            fVar.f397916c = oidb_0xcf4_lovetreeinfo.str_drop_icon.get();
        }
        if (oidb_0xcf4_lovetreeinfo.str_jump_url.has()) {
            fVar.f397917d = oidb_0xcf4_lovetreeinfo.str_jump_url.get();
        }
        if (oidb_0xcf4_lovetreeinfo.str_jump_h5_url.has()) {
            fVar.f397918e = oidb_0xcf4_lovetreeinfo.str_jump_h5_url.get();
        }
        if (oidb_0xcf4_lovetreeinfo.uint32_level.has()) {
            fVar.f397919f = oidb_0xcf4_lovetreeinfo.uint32_level.get();
        }
        return fVar;
    }

    public static f c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.f397914a = jSONObject.optString("treeIconUrl", "");
            fVar.f397915b = jSONObject.optBoolean("canWatering", false);
            fVar.f397916c = jSONObject.optString("wateringAnimUrl", "");
            fVar.f397917d = jSONObject.optString("miniAppUrl", "");
            fVar.f397918e = jSONObject.optString("h5Url", "");
            fVar.f397919f = jSONObject.optInt("level", 0);
            return fVar;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f397914a)) {
                jSONObject.put("treeIconUrl", this.f397914a);
            }
            jSONObject.put("canWatering", this.f397915b);
            if (!TextUtils.isEmpty(this.f397916c)) {
                jSONObject.put("wateringAnimUrl", this.f397916c);
            }
            if (!TextUtils.isEmpty(this.f397917d)) {
                jSONObject.put("miniAppUrl", this.f397917d);
            }
            if (!TextUtils.isEmpty(this.f397918e)) {
                jSONObject.put("h5Url", this.f397918e);
            }
            jSONObject.put("level", this.f397919f);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "LoveTreeInfo{treeIconUrl='" + this.f397914a + "', canWatering=" + this.f397915b + ", wateringAnimUrl='" + this.f397916c + "', miniAppUrl='" + this.f397917d + "', h5Url='" + this.f397918e + "', level=" + this.f397919f + '}';
    }
}
