package com.huawei.hms.hatool;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d1 implements g {

    /* renamed from: a, reason: collision with root package name */
    private String f37089a;

    /* renamed from: b, reason: collision with root package name */
    private String f37090b;

    /* renamed from: c, reason: collision with root package name */
    private String f37091c;

    /* renamed from: d, reason: collision with root package name */
    private List<b1> f37092d;

    public d1(List<b1> list, String str, String str2, String str3) {
        this.f37089a = str;
        this.f37090b = str2;
        this.f37091c = str3;
        this.f37092d = list;
    }

    private void a() {
        d.a(q0.i(), "backup_event", n1.a(this.f37089a, this.f37091c, this.f37090b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<b1> list = this.f37092d;
        if (list != null && list.size() != 0) {
            if (c0.a(q0.i(), "cached_v2_1", q0.k() * 1048576)) {
                v.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.f37090b);
                return;
            }
            String a16 = n1.a(this.f37089a, this.f37091c);
            List<b1> list2 = c1.b(q0.i(), "cached_v2_1", a16).get(a16);
            if (list2 != null && list2.size() != 0) {
                this.f37092d.addAll(list2);
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<b1> it = this.f37092d.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.mo162put(it.next().d());
                } catch (JSONException unused) {
                    v.e("hmsSdk", "event to json error");
                }
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2.length() > q0.h() * 1048576) {
                v.e("hmsSdk", "this failed data is too long,can not writing it");
                this.f37092d = null;
                return;
            }
            v.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f37090b);
            d.b(q0.i(), "cached_v2_1", a16, jSONArray2);
            a();
            return;
        }
        v.d("hmsSdk", "failed events is empty");
    }
}
