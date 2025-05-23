package com.tencent.mobileqq.search.mostused;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MostUsedSearch implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static String f283554d = "MostUsedSearch";
    String orgKey = "";
    ArrayList<MostUsedSearchItem> items = new ArrayList<>();
    long latestUsedTime = -1;

    public static MostUsedSearch fromJson(String str) {
        String str2;
        JSONArray jSONArray;
        String str3 = f283554d;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        QLog.d(str3, 2, str2);
        MostUsedSearch mostUsedSearch = new MostUsedSearch();
        if (str == null) {
            return mostUsedSearch;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("orgKey")) {
                mostUsedSearch.orgKey = jSONObject.getString("orgKey");
            }
            if (jSONObject.has("latestUsedTime")) {
                mostUsedSearch.latestUsedTime = jSONObject.getLong("latestUsedTime");
            }
            if (jSONObject.has("items") && (jSONArray = jSONObject.getJSONArray("items")) != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        MostUsedSearchItem fromJson = MostUsedSearchItem.fromJson(optJSONObject.toString());
                        if (!fromJson.searchKey.isEmpty()) {
                            mostUsedSearch.items.add(fromJson);
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e(f283554d, 2, "MostUsedSearch fromJson ERR;" + e16.toString());
        }
        return mostUsedSearch;
    }

    public static JSONObject toJson(MostUsedSearch mostUsedSearch) {
        JSONObject jSONObject = new JSONObject();
        if (mostUsedSearch == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("orgKey", mostUsedSearch.orgKey);
            jSONObject.put("latestUsedTime", mostUsedSearch.latestUsedTime);
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < mostUsedSearch.items.size(); i3++) {
                JSONObject json = MostUsedSearchItem.toJson(mostUsedSearch.items.get(i3));
                if (json != null && !TextUtils.isEmpty(json.toString())) {
                    jSONArray.mo162put(json);
                }
            }
            jSONObject.put("items", jSONArray);
        } catch (JSONException e16) {
            QLog.e(f283554d, 2, "MostUsedSearch fromJson ERR;" + e16.toString());
        }
        return jSONObject;
    }

    public static String toJsonString(MostUsedSearch mostUsedSearch) {
        String str;
        String str2;
        if (mostUsedSearch != null) {
            str = toJson(mostUsedSearch).toString();
        } else {
            str = null;
        }
        String str3 = f283554d;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        QLog.d(str3, 2, str2);
        return str;
    }
}
