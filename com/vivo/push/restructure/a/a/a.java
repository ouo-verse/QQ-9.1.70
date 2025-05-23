package com.vivo.push.restructure.a.a;

import com.vivo.push.util.u;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    protected T f387772a;

    /* renamed from: b, reason: collision with root package name */
    private String f387773b;

    /* renamed from: e, reason: collision with root package name */
    private i f387776e;

    /* renamed from: g, reason: collision with root package name */
    private a f387778g;

    /* renamed from: c, reason: collision with root package name */
    private long f387774c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f387775d = -1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f387777f = false;

    public a(String str, T t16, i iVar) {
        this.f387773b = str;
        this.f387772a = t16;
        this.f387776e = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f387775d = a((a<T>) this.f387772a);
        this.f387774c = System.currentTimeMillis() - currentTimeMillis;
        int i3 = this.f387775d;
        if (i3 != 0) {
            i iVar = this.f387776e;
            if (iVar != null) {
                iVar.a(this, this.f387772a, i3);
                return;
            }
            return;
        }
        a aVar = this.f387778g;
        if (aVar != null) {
            aVar.a();
            return;
        }
        i iVar2 = this.f387776e;
        if (iVar2 != null) {
            iVar2.a((i) this.f387772a);
        }
    }

    protected abstract int a(T t16);

    public final void a(a aVar) {
        if (this != aVar) {
            this.f387778g = aVar;
        }
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (a<T> aVar = this; aVar != null; aVar = aVar.f387778g) {
            try {
                jSONArray.mo162put(aVar.b());
            } catch (Exception e16) {
                u.a("AbstractMessageNodeMoni", e16);
            }
        }
        return jSONArray;
    }

    public final void a(long j3) {
        this.f387774c = j3;
    }

    public synchronized String b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f387773b);
            jSONObject.put("code", this.f387775d);
            jSONObject.put(QCircleWeakNetReporter.KEY_COST, this.f387774c);
        } catch (Exception e16) {
            u.a("AbstractMessageNodeMoni", e16);
        }
        return jSONObject.toString();
    }

    public final void a() {
        if (this.f387777f) {
            com.vivo.push.util.g.a().execute(new b(this));
        } else {
            d();
        }
    }
}
