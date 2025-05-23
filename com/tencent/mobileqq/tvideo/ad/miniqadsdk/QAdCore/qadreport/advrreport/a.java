package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected Map<String, Object> f304024a = new HashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8855a {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, Object> f304025a = new HashMap();

        public C8855a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                this.f304025a.put(str, obj);
            }
            return this;
        }

        public C8855a b(a aVar) {
            if (aVar != null) {
                this.f304025a.putAll(aVar.d());
            }
            return this;
        }

        public C8855a c(Map<String, ?> map) {
            if (map != null) {
                this.f304025a.putAll(map);
            }
            return this;
        }
    }

    public void a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f304024a.put(str, obj);
    }

    public void b(Map<String, ?> map) {
        if (map != null && !map.isEmpty()) {
            this.f304024a.putAll(map);
        }
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f304024a.containsKey(str);
    }

    public Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f304024a);
        return hashMap;
    }

    public void e(String str) {
        this.f304024a.remove(str);
    }
}
