package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static int f281933b = 900000;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Long, c> f281934a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final g f281935a = new g();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String[] f281936a;

        /* renamed from: b, reason: collision with root package name */
        public long f281937b;

        /* renamed from: c, reason: collision with root package name */
        public MessageRecord f281938c;

        /* renamed from: d, reason: collision with root package name */
        public int f281939d;

        /* renamed from: e, reason: collision with root package name */
        String f281940e;

        public c(String[] strArr, long j3, MessageRecord messageRecord, int i3, String str) {
            this.f281936a = strArr;
            this.f281937b = j3;
            this.f281938c = messageRecord;
            this.f281939d = i3;
            this.f281940e = str;
        }

        public boolean a() {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.f281937b;
            BrowserLogHelper.getInstance().getGalleryLog().d(" LongVideoUrlCacheManager", 4, "UrlsCacheBean, now=  " + currentTimeMillis + ", mGetTime" + this.f281937b + " diff=" + j3 + " urlTimeValidDiff=" + g.f281933b);
            if (j3 < g.f281933b) {
                return true;
            }
            return false;
        }
    }

    public static final g e() {
        return b.f281935a;
    }

    public void b(long j3, String[] strArr, long j16, MessageRecord messageRecord, int i3, String str) {
        this.f281934a.put(Long.valueOf(j3), new c(strArr, j16, messageRecord, i3, str));
    }

    public void c() {
        BrowserLogHelper.getInstance().getGalleryLog().d(" LongVideoUrlCacheManager", 4, "LongVideoUrlCacheManager,clearCache");
        this.f281934a.clear();
    }

    public c d(long j3) {
        if (this.f281934a.containsKey(Long.valueOf(j3))) {
            return this.f281934a.get(Long.valueOf(j3));
        }
        return null;
    }

    g() {
        this.f281934a = new ConcurrentHashMap<>();
    }
}
