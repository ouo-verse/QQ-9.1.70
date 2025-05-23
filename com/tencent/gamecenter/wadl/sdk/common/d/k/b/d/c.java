package com.tencent.gamecenter.wadl.sdk.common.d.k.b.d;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<b> f107201a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f107202b = "";

    /* renamed from: c, reason: collision with root package name */
    public int f107203c = 0;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, byte[]> f107204d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f107205e = null;

    public c(JSONObject jSONObject) {
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        try {
            this.f107202b = jSONObject.optString("taskid");
            this.f107203c = jSONObject.optInt("lifetime");
            JSONArray optJSONArray = jSONObject.optJSONArray("subtasks");
            if (optJSONArray != null) {
                this.f107201a = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    b bVar = new b();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    bVar.f107197a = (byte) jSONObject2.optInt("type");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("targets");
                    bVar.f107198b = new ArrayList<>();
                    if (optJSONArray2 != null) {
                        for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                            bVar.f107198b.add((String) optJSONArray2.get(i16));
                        }
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("extra");
                    Iterator keys = optJSONObject.keys();
                    bVar.f107199c = new HashMap();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        bVar.f107199c.put(str, com.tencent.gamecenter.wadl.sdk.common.e.a.a(optJSONObject.optString(str)));
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("subinfo");
                    Iterator keys2 = optJSONObject2.keys();
                    bVar.f107200d = new HashMap();
                    while (keys2.hasNext()) {
                        String str2 = (String) keys2.next();
                        bVar.f107200d.put(str2, optJSONObject2.optString(str2));
                    }
                    this.f107201a.add(bVar);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("extra");
            Iterator keys3 = optJSONObject3.keys();
            this.f107204d = new HashMap();
            while (keys3.hasNext()) {
                String str3 = (String) keys3.next();
                this.f107204d.put(str3, com.tencent.gamecenter.wadl.sdk.common.e.a.a(optJSONObject3.optString(str3)));
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(QQWinkConstants.TASKINFO);
            Iterator keys4 = optJSONObject4.keys();
            this.f107205e = new HashMap();
            while (keys4.hasNext()) {
                String str4 = (String) keys4.next();
                this.f107205e.put(str4, optJSONObject4.optString(str4));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
