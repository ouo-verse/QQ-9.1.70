package com.tencent.biz.qqcircle.immersive.report;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<String> f89738a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Object> f89739b;

    /* renamed from: c, reason: collision with root package name */
    private long f89740c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, Object> f89741d;

    public g(HashSet<String> hashSet) {
        HashSet<String> hashSet2 = new HashSet<>();
        this.f89738a = hashSet2;
        this.f89741d = new HashMap<>();
        hashSet2.addAll(hashSet);
    }

    private void e(int i3, String str) {
        if (RFWLog.isDevelopLevel()) {
            RFWLog.d("QFSPlayPageReporter-QFSReportCollector" + hashCode(), i3, str);
        }
    }

    public synchronized boolean a(String str, Object obj) {
        if (obj != null && str != null) {
            Map<String, Object> map = this.f89739b;
            if (map == null) {
                e(RFWLog.USR, "collect but collectorMap is null key:" + str + ",new val" + obj);
                return false;
            }
            if (map.containsKey(str)) {
                if (this.f89738a.contains(str)) {
                    return false;
                }
                map.put(str, obj);
                e(RFWLog.USR, "collect key:" + str + ",new val\uff1a" + obj);
                return true;
            }
            if (RFWLog.isDevelopLevel()) {
                e(RFWLog.USR, "collect new key:" + str + ",val\uff1a" + obj);
            }
            map.put(str, obj);
            return true;
        }
        e(RFWLog.USR, "collect but is null key:" + str + ", val" + obj);
        return false;
    }

    @NonNull
    public HashMap<String, Object> b() {
        return this.f89741d;
    }

    public synchronized Map<String, Object> c() {
        Map<String, Object> map = this.f89739b;
        HashMap<String, Object> hashMap = this.f89741d;
        if (map == null) {
            if (hashMap != null) {
                return new ConcurrentHashMap(hashMap);
            }
            return new ConcurrentHashMap();
        }
        return new HashMap(map);
    }

    public long d() {
        return this.f89740c;
    }

    public synchronized void f() {
        this.f89740c++;
        e(RFWLog.USR, "reset mResetCount" + this.f89740c);
        this.f89739b = new HashMap(this.f89741d);
    }

    public synchronized void g(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        this.f89741d = new HashMap<>(map);
        this.f89739b = new HashMap(this.f89741d);
    }
}
