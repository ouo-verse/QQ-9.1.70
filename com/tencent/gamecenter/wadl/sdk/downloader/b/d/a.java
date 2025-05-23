package com.tencent.gamecenter.wadl.sdk.downloader.b.d;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f107328a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, c> f107329b = new HashMap();

    public a(String str) {
        this.f107328a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        if (r5 != 3) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<List<String>, List<String>> a(String str, String str2) {
        List<String> arrayList = new ArrayList<>();
        List<String> arrayList2 = new ArrayList<>();
        if (!this.f107328a.equals(str)) {
            return new Pair<>(arrayList, arrayList2);
        }
        c cVar = this.f107329b.get(str2);
        if (cVar == null) {
            return new Pair<>(arrayList, arrayList);
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl_IPCachePool", "[fetchIpsByApnName] current ip type: " + ((int) com.tencent.gamecenter.wadl.sdk.common.b.c.c()));
        byte c16 = com.tencent.gamecenter.wadl.sdk.common.b.c.c();
        if (c16 != 1) {
            if (c16 == 2) {
                arrayList = cVar.a();
            }
            arrayList2 = cVar.b();
        } else {
            arrayList = cVar.a();
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public void a(Map<String, b> map) {
        if (map == null || map.isEmpty()) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl_IPCachePool", "[cacheDomainIpMapInfo] ipInfoMap is empty!!!");
            return;
        }
        synchronized (this.f107329b) {
            this.f107329b.clear();
            for (Map.Entry<String, b> entry : map.entrySet()) {
                this.f107329b.put(entry.getKey(), new c(entry.getValue()));
            }
        }
    }
}
