package com.tencent.rmonitor.base.config.data;

import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class n extends k {

    /* renamed from: m, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ArrayList<String> f365321m = new ArrayList<>();

    @Override // com.tencent.rmonitor.base.config.data.k
    public String getName() {
        return "safe_mode";
    }

    @Override // com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("crash_protect");
        ArrayList arrayList = new ArrayList();
        String str = BaseInfo.userMeta.sdkVersion;
        int i3 = 0;
        while (true) {
            if (i3 >= jSONArray.length()) {
                break;
            }
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            if (str.equals(jSONObject2.getString("sdk_version"))) {
                JSONArray optJSONArray = jSONObject2.optJSONArray("feature_names");
                for (int i16 = 0; optJSONArray != null && i16 < optJSONArray.length(); i16++) {
                    String string = optJSONArray.getString(i16);
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
            } else {
                i3++;
            }
        }
        this.f365321m.clear();
        this.f365321m.addAll(arrayList);
    }
}
