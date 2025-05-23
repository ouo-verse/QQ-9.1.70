package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f37042a = new ConcurrentHashMap(16);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f37043a;

        /* renamed from: b, reason: collision with root package name */
        private final long f37044b;

        public a(long j3, long j16) {
            this.f37043a = j3;
            this.f37044b = j16;
        }

        public boolean a() {
            if (SystemClock.elapsedRealtime() - this.f37044b <= this.f37043a) {
                return true;
            }
            return false;
        }
    }

    public static a a(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("map size of get is before: ");
        Map<String, a> map = f37042a;
        sb5.append(map.size());
        Logger.v("RequestUtil", sb5.toString());
        a aVar = map.get(str);
        Logger.v("RequestUtil", "map size of get is after: " + map.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("map size of put is before: ");
        Map<String, a> map = f37042a;
        sb5.append(map.size());
        Logger.v("RequestUtil", sb5.toString());
        map.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after: " + map.size());
    }
}
