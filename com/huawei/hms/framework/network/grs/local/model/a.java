package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f37047a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, c> f37048b = new ConcurrentHashMap(16);

    public c a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f37048b.get(str);
        }
        Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    }

    public String b() {
        return this.f37047a;
    }

    public void a() {
        Map<String, c> map = this.f37048b;
        if (map != null) {
            map.clear();
        }
    }

    public void b(String str) {
        this.f37047a = str;
    }

    public void a(long j3) {
    }

    public void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        this.f37048b.put(str, cVar);
    }
}
