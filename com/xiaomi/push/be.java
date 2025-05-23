package com.xiaomi.push;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
class be implements Comparable<be> {

    /* renamed from: d, reason: collision with root package name */
    private final LinkedList<aw> f388257d;

    /* renamed from: e, reason: collision with root package name */
    String f388258e;

    /* renamed from: f, reason: collision with root package name */
    private long f388259f;

    /* renamed from: h, reason: collision with root package name */
    protected int f388260h;

    public be() {
        this(null, 0);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(be beVar) {
        if (beVar == null) {
            return 1;
        }
        return beVar.f388260h - this.f388260h;
    }

    public synchronized be d(JSONObject jSONObject) {
        this.f388259f = jSONObject.getLong(TtmlNode.TAG_TT);
        this.f388260h = jSONObject.getInt("wt");
        this.f388258e = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray(lo2.ah.f415119g0);
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            this.f388257d.add(new aw().b(jSONArray.getJSONObject(i3)));
        }
        return this;
    }

    public synchronized JSONObject h() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(TtmlNode.TAG_TT, this.f388259f);
        jSONObject.put("wt", this.f388260h);
        jSONObject.put("host", this.f388258e);
        JSONArray jSONArray = new JSONArray();
        Iterator<aw> it = this.f388257d.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().c());
        }
        jSONObject.put(lo2.ah.f415119g0, jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void i(aw awVar) {
        if (awVar != null) {
            this.f388257d.add(awVar);
            int a16 = awVar.a();
            if (a16 > 0) {
                this.f388260h += awVar.a();
            } else {
                int i3 = 0;
                for (int size = this.f388257d.size() - 1; size >= 0 && this.f388257d.get(size).a() < 0; size--) {
                    i3++;
                }
                this.f388260h += a16 * i3;
            }
            if (this.f388257d.size() > 30) {
                this.f388260h -= this.f388257d.remove().a();
            }
        }
    }

    public String toString() {
        return this.f388258e + ":" + this.f388260h;
    }

    public be(String str) {
        this(str, 0);
    }

    public be(String str, int i3) {
        this.f388257d = new LinkedList<>();
        this.f388259f = 0L;
        this.f388258e = str;
        this.f388260h = i3;
    }
}
