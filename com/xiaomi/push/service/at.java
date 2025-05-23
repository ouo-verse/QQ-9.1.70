package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f389658a = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends XMPushService.j {
        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            at.a().b();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "RecordTimeManager clear";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final at f389659a = new at();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        long f389660a;

        /* renamed from: b, reason: collision with root package name */
        long f389661b;

        /* renamed from: c, reason: collision with root package name */
        long f389662c;

        /* renamed from: d, reason: collision with root package name */
        long f389663d;

        d() {
        }

        public long a() {
            long j3 = this.f389662c;
            long j16 = this.f389661b;
            if (j3 > j16) {
                return j3 - j16;
            }
            return 0L;
        }

        public long b() {
            long j3 = this.f389663d;
            long j16 = this.f389662c;
            if (j3 > j16) {
                return j3 - j16;
            }
            return 0L;
        }
    }

    public static at a() {
        return c.f389659a;
    }

    private void e(String str, d dVar) {
        if (!TextUtils.isEmpty(str) && dVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("xmsfVC", Long.valueOf(dVar.f389660a));
            hashMap.put("packetId", str);
            hashMap.put("pTime", Long.valueOf(dVar.a()));
            hashMap.put("bTime", Long.valueOf(dVar.b()));
            dv.b().a(new du("msg_process_time", hashMap));
        }
    }

    public void b() {
        if (!this.f389658a.isEmpty()) {
            Iterator<Map.Entry<String, d>> it = this.f389658a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, d> next = it.next();
                if (next != null && next.getValue() != null) {
                    d value = next.getValue();
                    if (Math.abs(SystemClock.elapsedRealtime() - value.f389661b) > 10000) {
                        e(next.getKey(), value);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    public void c(String str, long j3) {
        d dVar = this.f389658a.get(str);
        if (dVar != null) {
            dVar.f389662c = j3;
        }
    }

    public void d(String str, long j3, long j16) {
        d dVar = new d();
        dVar.f389660a = j16;
        dVar.f389661b = j3;
        this.f389658a.put(str, dVar);
    }

    public void f(String str, long j3) {
        d remove = this.f389658a.remove(str);
        if (remove != null) {
            remove.f389663d = j3;
            e(str, remove);
        }
    }
}
