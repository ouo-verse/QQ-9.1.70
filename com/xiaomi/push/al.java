package com.xiaomi.push;

import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes28.dex */
public class al extends JSONArray implements ak {

    /* renamed from: b, reason: collision with root package name */
    private int f388183b = 2;

    @Override // com.xiaomi.push.ak
    public int a() {
        return this.f388183b + (length() - 1);
    }

    @Override // org.json.JSONArray
    /* renamed from: put */
    public JSONArray mo162put(Object obj) {
        if (obj instanceof ak) {
            this.f388183b += ((ak) obj).a();
        }
        return super.mo162put(obj);
    }
}
