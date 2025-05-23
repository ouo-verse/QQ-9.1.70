package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m implements IConfigData {

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f202671i = {"sysface", "favorite", "hotpic"};

    /* renamed from: d, reason: collision with root package name */
    private int f202672d;

    /* renamed from: e, reason: collision with root package name */
    public List<String> f202673e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public List<String> f202674f = new ArrayList(Arrays.asList(f202671i));

    /* renamed from: h, reason: collision with root package name */
    public String f202675h = "";

    public static m b(String str) {
        m mVar = new m();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("setting_change_style")) {
                mVar.f202672d = jSONObject.optInt("setting_change_style", 0);
            }
            if (jSONObject.has("setting_orders")) {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("setting_orders");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        String optString = optJSONArray.optString(i3);
                        if (!arrayList.contains(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
                mVar.f202673e.clear();
                mVar.f202673e.addAll(arrayList);
            }
            if (jSONObject.has("face_orders")) {
                ArrayList arrayList2 = new ArrayList();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("face_orders");
                if (optJSONArray2 != null) {
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        String optString2 = optJSONArray2.optString(i16);
                        if (!arrayList2.contains(optString2)) {
                            arrayList2.add(optString2);
                        }
                        if ("camera".equals(optString2)) {
                            h.INSTANCE.d(true);
                        }
                    }
                }
                mVar.f202674f.clear();
                mVar.f202674f.addAll(arrayList2);
            }
            if (jSONObject.has("gif_entrance_icon_url")) {
                mVar.f202675h = jSONObject.optString("gif_entrance_icon_url");
            }
            QLog.i("EmoticonTabSortConfBean", 1, "parse S$EConfBean: " + str + ", final entry:" + mVar.f202674f);
        } catch (Throwable th5) {
            QLog.d("EmoticonTabSortConfBean", 2, "parse S$EConfBean failed!", th5);
        }
        return mVar;
    }

    public boolean a() {
        if (this.f202672d == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "EmoticonTabSortConfBean{mChangeNewSettingStyle=" + this.f202672d + ", mSettingOrder=" + this.f202673e + ", mEntryOrder=" + this.f202674f + ", mGifEntranceIconUrl=" + this.f202675h + '}';
    }
}
