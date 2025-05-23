package com.vivo.push.restructure.request.a.a;

import com.vivo.push.restructure.request.a.a.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f387819a;

    /* renamed from: b, reason: collision with root package name */
    private int f387820b;

    /* renamed from: c, reason: collision with root package name */
    private JSONArray f387821c;

    public a() {
        this.f387819a = 0;
        this.f387821c = new JSONArray();
    }

    public final void a(int i3) {
        this.f387821c.put(i3);
    }

    public final long b() throws JSONException {
        int i3 = this.f387819a;
        if (i3 < this.f387820b) {
            JSONArray jSONArray = this.f387821c;
            this.f387819a = i3 + 1;
            return jSONArray.getLong(i3);
        }
        return 0L;
    }

    public final String c() throws JSONException {
        int i3 = this.f387819a;
        if (i3 < this.f387820b) {
            JSONArray jSONArray = this.f387821c;
            this.f387819a = i3 + 1;
            return jSONArray.getString(i3);
        }
        return null;
    }

    public final String d() {
        JSONArray jSONArray = this.f387821c;
        if (jSONArray != null) {
            return jSONArray.toString();
        }
        return "";
    }

    public final void a(long j3) {
        this.f387821c.put(j3);
    }

    public final void a(String str) {
        this.f387821c.mo162put(str);
    }

    public a(String str) throws JSONException {
        this.f387819a = 0;
        JSONArray jSONArray = new JSONArray(str);
        this.f387821c = jSONArray;
        this.f387819a = 0;
        this.f387820b = jSONArray.length();
    }

    public final <T extends c> void a(List<T> list) {
        if (list != null) {
            this.f387821c.put(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.f387821c.mo162put(it.next().a());
            }
            return;
        }
        this.f387821c.mo162put((Object) null);
    }

    public final int a() throws JSONException {
        int i3 = this.f387819a;
        if (i3 >= this.f387820b) {
            return 0;
        }
        JSONArray jSONArray = this.f387821c;
        this.f387819a = i3 + 1;
        return jSONArray.getInt(i3);
    }

    public final <T extends c> void a(c.a<T> aVar, List<T> list) throws JSONException {
        T t16;
        int i3 = this.f387819a;
        if (i3 < this.f387820b ? this.f387821c.isNull(i3) : true) {
            this.f387819a++;
            return;
        }
        JSONArray jSONArray = this.f387821c;
        int i16 = this.f387819a;
        this.f387819a = i16 + 1;
        int i17 = jSONArray.getInt(i16);
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = this.f387819a;
            if (i19 < this.f387820b) {
                JSONArray jSONArray2 = this.f387821c;
                this.f387819a = i19 + 1;
                t16 = aVar.a(jSONArray2.getString(i19));
            } else {
                t16 = null;
            }
            list.add(t16);
        }
    }
}
