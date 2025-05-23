package com.tencent.aelight.camera.ae.gif;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f65338a;

    /* renamed from: b, reason: collision with root package name */
    public String f65339b;

    /* renamed from: c, reason: collision with root package name */
    public int f65340c;

    /* renamed from: d, reason: collision with root package name */
    public int f65341d;

    public c(List<String> list, String str, JSONObject jSONObject) {
        this.f65340c = 3;
        this.f65341d = 6;
        this.f65338a = list;
        this.f65339b = str;
        if (jSONObject != null) {
            a(jSONObject);
        } else {
            this.f65340c = 3;
            this.f65341d = 6;
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            String str = this.f65339b;
            if (str == null) {
                str = "default";
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            this.f65340c = jSONObject2.getInt("wordNum");
            this.f65341d = jSONObject2.getInt("pendantNum");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public c() {
        this.f65339b = "default";
        this.f65340c = 3;
        this.f65341d = 6;
        this.f65338a = new ArrayList();
    }
}
