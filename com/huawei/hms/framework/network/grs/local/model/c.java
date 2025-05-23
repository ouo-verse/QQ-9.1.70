package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f37051a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, d> f37052b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private List<b> f37053c = new ArrayList(16);

    public d a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f37052b.get(str);
        }
        Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    public String b() {
        return this.f37051a;
    }

    public void c(String str) {
        this.f37051a = str;
    }

    public List<b> a() {
        return this.f37053c;
    }

    public void b(String str) {
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        this.f37052b.put(str, dVar);
    }

    public void a(List<b> list) {
        this.f37053c = list;
    }
}
