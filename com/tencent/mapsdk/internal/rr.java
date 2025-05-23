package com.tencent.mapsdk.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rr {

    /* renamed from: a, reason: collision with root package name */
    public static final int f150120a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static final int f150121b = 11;

    /* renamed from: g, reason: collision with root package name */
    private static final String f150122g = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":16,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";

    /* renamed from: c, reason: collision with root package name */
    public volatile List<rq> f150123c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f150124d;

    /* renamed from: e, reason: collision with root package name */
    public mv f150125e;

    /* renamed from: f, reason: collision with root package name */
    public int f150126f;

    public rr(Context context, String str) {
        Object obj = new Object();
        this.f150124d = obj;
        this.f150126f = -1;
        if (str == null) {
            this.f150125e = my.a(context);
        } else {
            this.f150125e = mx.a(context, str);
        }
        this.f150123c = new CopyOnWriteArrayList();
        String a16 = this.f150125e.a(et.A);
        try {
            JSONArray jSONArray = new JSONArray(a16 == null ? f150122g : a16);
            synchronized (obj) {
                this.f150123c.addAll(a(jSONArray));
            }
        } catch (Exception unused) {
        }
    }

    public static List<rq> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                arrayList.add(new rq(jSONObject.getInt("index"), jSONObject.getInt("id"), jSONObject.getInt("order")));
            } catch (Exception unused) {
                return null;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private void b() {
        this.f150123c = new CopyOnWriteArrayList();
        String a16 = this.f150125e.a(et.A);
        if (a16 == null) {
            a16 = f150122g;
        }
        try {
            JSONArray jSONArray = new JSONArray(a16);
            synchronized (this.f150124d) {
                this.f150123c.addAll(a(jSONArray));
            }
        } catch (Exception unused) {
        }
    }

    private void b(JSONArray jSONArray) {
        List<rq> a16;
        String a17 = this.f150125e.a(et.A);
        if (jSONArray == null || (a16 = a(jSONArray)) == null) {
            return;
        }
        synchronized (this.f150124d) {
            this.f150123c.clear();
            this.f150123c.addAll(a16);
        }
        if (jSONArray.toString().equals(a17)) {
            return;
        }
        this.f150125e.a();
        this.f150125e.a(et.A, jSONArray.toString());
    }

    public final String a() {
        if (this.f150123c == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(128);
        for (rq rqVar : this.f150123c) {
            if (rqVar.f150118b != -1) {
                if (sb5.length() == 0) {
                    sb5.append(rqVar.f150118b);
                } else {
                    sb5.append(",");
                    sb5.append(rqVar.f150118b);
                }
            } else if (sb5.length() == 0) {
                sb5.append(0);
            } else {
                sb5.append(",");
            }
        }
        return sb5.toString();
    }

    public final int b(int i3) {
        synchronized (this.f150124d) {
            if (this.f150123c != null && this.f150123c.size() != 0 && i3 >= 0) {
                if ((i3 >= 8 && i3 <= 19) || this.f150126f >= 1000) {
                    return i3 + 1000;
                }
                if (i3 > 19 && i3 < 1000) {
                    return i3 - 11;
                }
                for (rq rqVar : this.f150123c) {
                    if (i3 == rqVar.f150117a) {
                        if (i3 == 0 && rqVar.f150118b == 0 && this.f150126f <= 0) {
                            return 1000;
                        }
                        return rqVar.f150119c;
                    }
                }
                return i3;
            }
            return i3;
        }
    }

    public final rq a(int i3) {
        int i16;
        synchronized (this.f150124d) {
            if (this.f150123c != null && this.f150123c.size() != 0 && i3 >= 0 && i3 - 1000 < this.f150123c.size()) {
                this.f150126f = i3;
                if (i3 >= 1000) {
                    return this.f150123c.get(i16);
                }
                if (i3 > 8 && i3 < 989) {
                    int i17 = i3 + 11;
                    if (i17 >= this.f150123c.size()) {
                        return null;
                    }
                    return this.f150123c.get(i17);
                }
                for (rq rqVar : this.f150123c) {
                    if (rqVar.f150119c == i3) {
                        return rqVar;
                    }
                }
                return this.f150123c.get(0);
            }
            return null;
        }
    }

    private void a(ne neVar) {
        rq a16;
        if (neVar == null || (a16 = a(this.f150126f)) == null) {
            return;
        }
        neVar.f149398k.b(a16.f150117a);
    }
}
