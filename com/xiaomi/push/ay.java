package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class ay {

    /* renamed from: a, reason: collision with root package name */
    private String f388232a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<ax> f388233b = new ArrayList<>();

    public ay(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f388232a = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    public synchronized ax a() {
        for (int size = this.f388233b.size() - 1; size >= 0; size--) {
            ax axVar = this.f388233b.get(size);
            if (axVar.p()) {
                bb.c().l(axVar.b());
                return axVar;
            }
        }
        return null;
    }

    public synchronized ay b(JSONObject jSONObject) {
        this.f388232a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            this.f388233b.add(new ax(this.f388232a).a(jSONArray.getJSONObject(i3)));
        }
        return this;
    }

    public String c() {
        return this.f388232a;
    }

    public ArrayList<ax> d() {
        return this.f388233b;
    }

    public synchronized JSONObject e() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f388232a);
        JSONArray jSONArray = new JSONArray();
        Iterator<ax> it = this.f388233b.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().f());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void f(ax axVar) {
        int i3 = 0;
        while (true) {
            if (i3 >= this.f388233b.size()) {
                break;
            }
            if (this.f388233b.get(i3).q(axVar)) {
                this.f388233b.set(i3, axVar);
                break;
            }
            i3++;
        }
        if (i3 >= this.f388233b.size()) {
            this.f388233b.add(axVar);
        }
    }

    public synchronized void g(boolean z16) {
        for (int size = this.f388233b.size() - 1; size >= 0; size--) {
            ax axVar = this.f388233b.get(size);
            if (z16) {
                if (axVar.w()) {
                    this.f388233b.remove(size);
                }
            } else if (!axVar.u()) {
                this.f388233b.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f388232a);
        sb5.append("\n");
        Iterator<ax> it = this.f388233b.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
        }
        return sb5.toString();
    }

    public ay() {
    }
}
