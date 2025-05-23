package gy;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f403829a = new HashSet();

    public static d b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountLongClickBean", 2, "parse json:\n" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            JSONArray optJSONArray = jSONObject.optJSONArray("unsubscribeWhiteList");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        dVar.f403829a.add(optString);
                    }
                }
            }
            return dVar;
        } catch (JSONException e16) {
            QLog.e("PublicAccountLongClickBean", 1, "parse error\n", e16);
            return null;
        }
    }

    public Set<String> a() {
        return this.f403829a;
    }
}
