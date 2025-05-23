package com.tencent.mobileqq.qzoneplayer.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f279538d;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, a> f279539a;

    /* renamed from: b, reason: collision with root package name */
    private int f279540b = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "filterVideoRetIsEnable", 1);

    /* renamed from: c, reason: collision with root package name */
    private int f279541c = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "filterVideoRetCacheExpireOverTime", 180);

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f279542a;

        /* renamed from: b, reason: collision with root package name */
        long f279543b;

        /* renamed from: c, reason: collision with root package name */
        long f279544c;

        a() {
        }
    }

    public static d c() {
        if (f279538d == null) {
            synchronized (d.class) {
                if (f279538d == null) {
                    f279538d = new d();
                    f279538d.f279539a = new HashMap<>();
                }
            }
        }
        return f279538d;
    }

    public boolean b(String str, long j3) {
        if (this.f279540b == 0 || TextUtils.isEmpty(str) || j3 == 0 || this.f279539a == null) {
            return false;
        }
        String str2 = str + j3;
        if (this.f279539a.containsKey(str2)) {
            a aVar = this.f279539a.get(str2);
            if (aVar == null) {
                return false;
            }
            boolean a16 = a(aVar);
            aVar.f279543b = System.currentTimeMillis();
            this.f279539a.put(str2, aVar);
            return a16;
        }
        a aVar2 = new a();
        aVar2.f279544c = j3;
        aVar2.f279542a = str;
        aVar2.f279543b = System.currentTimeMillis();
        this.f279539a.put(str2, aVar2);
        return false;
    }

    private boolean a(a aVar) {
        if (aVar != null) {
            if (System.currentTimeMillis() - aVar.f279543b < this.f279541c * 1000) {
                return true;
            }
        }
        return false;
    }
}
