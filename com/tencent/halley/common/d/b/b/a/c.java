package com.tencent.halley.common.d.b.b.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<b> f113484a;

    /* renamed from: b, reason: collision with root package name */
    public String f113485b;

    /* renamed from: c, reason: collision with root package name */
    public int f113486c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, byte[]> f113487d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f113488e;

    public c(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject);
            return;
        }
        this.f113484a = null;
        this.f113485b = "";
        this.f113486c = 0;
        this.f113487d = null;
        this.f113488e = null;
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        try {
            this.f113485b = jSONObject.optString("taskid");
            this.f113486c = jSONObject.optInt("lifetime");
            JSONArray optJSONArray = jSONObject.optJSONArray("subtasks");
            if (optJSONArray != null) {
                this.f113484a = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    b bVar = new b();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    bVar.f113480a = (byte) jSONObject2.optInt("type");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("targets");
                    bVar.f113481b = new ArrayList<>();
                    if (optJSONArray2 != null) {
                        for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                            bVar.f113481b.add((String) optJSONArray2.get(i16));
                        }
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("extra");
                    Iterator keys = optJSONObject.keys();
                    bVar.f113482c = new HashMap();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        bVar.f113482c.put(str, com.tencent.halley.common.utils.a.a(optJSONObject.optString(str)));
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("subinfo");
                    Iterator keys2 = optJSONObject2.keys();
                    bVar.f113483d = new HashMap();
                    while (keys2.hasNext()) {
                        String str2 = (String) keys2.next();
                        bVar.f113483d.put(str2, optJSONObject2.optString(str2));
                    }
                    this.f113484a.add(bVar);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("extra");
            Iterator keys3 = optJSONObject3.keys();
            this.f113487d = new HashMap();
            while (keys3.hasNext()) {
                String str3 = (String) keys3.next();
                this.f113487d.put(str3, com.tencent.halley.common.utils.a.a(optJSONObject3.optString(str3)));
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(QQWinkConstants.TASKINFO);
            Iterator keys4 = optJSONObject4.keys();
            this.f113488e = new HashMap();
            while (keys4.hasNext()) {
                String str4 = (String) keys4.next();
                this.f113488e.put(str4, optJSONObject4.optString(str4));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
