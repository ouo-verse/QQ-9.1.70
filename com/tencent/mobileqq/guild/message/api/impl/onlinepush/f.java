package com.tencent.mobileqq.guild.message.api.impl.onlinepush;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f230312a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Long> f230313b = new ConcurrentHashMap();

    public f(int i3) {
        this.f230312a = 0;
        this.f230312a = i3;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (!this.f230313b.containsKey(str)) {
            this.f230313b.put(str, 0L);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f230313b.get(str).longValue() > this.f230312a) {
            this.f230313b.put(str, Long.valueOf(uptimeMillis));
            return true;
        }
        return false;
    }
}
