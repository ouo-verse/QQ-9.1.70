package hynb.t;

import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f406845c = UUID.randomUUID().toString();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLong f406846d = new AtomicLong(1);

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicLong f406847e = new AtomicLong(1);

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f406848a;

    /* renamed from: b, reason: collision with root package name */
    public UUID f406849b;

    public a() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        this.f406848a = concurrentHashMap;
        concurrentHashMap.put("cutc", String.valueOf(System.currentTimeMillis()));
    }

    public static void b() {
        f406847e.getAndIncrement();
    }

    public synchronized String a(String str, String str2) {
        String put;
        if (TextUtils.isEmpty(str)) {
            put = null;
        } else {
            ConcurrentHashMap<String, String> concurrentHashMap = this.f406848a;
            if (str2 == null) {
                str2 = "";
            }
            put = concurrentHashMap.put(str, str2);
        }
        return put;
    }

    public void c() {
        UUID randomUUID = UUID.randomUUID();
        this.f406849b = randomUUID;
        a("uuid", randomUUID.toString());
    }

    public void a() {
        a("pro_uuid", f406845c);
        a("rep_cnt", f406846d.getAndIncrement() + "");
        a("rep_times", f406847e.get() + "");
    }
}
