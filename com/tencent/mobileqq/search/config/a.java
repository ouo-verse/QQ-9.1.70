package com.tencent.mobileqq.search.config;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public String f283105d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, C8530a> f283106e = new ArrayMap();

    /* renamed from: f, reason: collision with root package name */
    boolean f283107f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.search.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C8530a {

        /* renamed from: a, reason: collision with root package name */
        int[] f283108a;

        public C8530a(int[] iArr) {
            this.f283108a = iArr;
        }
    }

    private static void a(a aVar, String str) {
        int[] iArr;
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("scene");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("sort");
                    if (optJSONArray != null) {
                        iArr = new int[optJSONArray.length()];
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            iArr[i16] = optJSONArray.getInt(i16);
                        }
                    } else {
                        iArr = null;
                    }
                    aVar.d(optString, new C8530a(iArr));
                }
            }
        } catch (JSONException unused) {
            QLog.e("search_manager_configGroupSearchResultConfigBean", 1, "parse json error");
        }
        aVar.f283105d = str;
        aVar.f283107f = true;
    }

    public static a b(String str) {
        a aVar = new a();
        a(aVar, str);
        return aVar;
    }

    public static a c(ai[] aiVarArr) {
        String str;
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0) {
            str = aiVarArr[0].f202268b;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        QLog.d("search_manager_configGroupSearchResultConfigBean", 1, "parse conf=" + str);
        a(aVar, str);
        return aVar;
    }

    void d(String str, C8530a c8530a) {
        this.f283106e.put(str, c8530a);
    }
}
