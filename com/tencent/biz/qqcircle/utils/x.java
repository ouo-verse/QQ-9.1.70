package com.tencent.biz.qqcircle.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes5.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static final List<a> f92789a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicLong f92790b = new AtomicLong(-1);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f92791a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f92792b;

        /* renamed from: c, reason: collision with root package name */
        private final int f92793c;

        public a(long j3, boolean z16, int i3) {
            this.f92791a = j3;
            this.f92792b = z16;
            this.f92793c = i3;
        }

        public long b() {
            return this.f92791a;
        }

        public int c() {
            return this.f92793c;
        }

        public boolean d() {
            return this.f92792b;
        }
    }

    public static String a() {
        long b16;
        int i3;
        if (f92789a.isEmpty()) {
            return "0_0_-1";
        }
        String str = "";
        int i16 = 0;
        while (true) {
            try {
                List<a> list = f92789a;
                if (i16 < list.size()) {
                    a aVar = list.get(i16);
                    if (i16 == 0) {
                        AtomicLong atomicLong = f92790b;
                        if (atomicLong.get() == -1) {
                            b16 = 0;
                        } else {
                            b16 = aVar.b() - atomicLong.get();
                        }
                    } else {
                        b16 = aVar.b() - list.get(i16 - 1).f92791a;
                        str = str + "|";
                    }
                    int i17 = (int) (b16 / 1000);
                    if (aVar.d()) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    str = str + i17 + "_" + i3 + "_" + aVar.c();
                    i16++;
                } else {
                    return str;
                }
            } catch (Throwable th5) {
                QLog.e("QCircleMSFWeakNetworkChangeUtils", 2, "error: ", th5);
                return "0_0_-1";
            }
        }
    }

    public static void b() {
        f92789a.clear();
        f92790b.set(System.currentTimeMillis());
    }

    public static void c(boolean z16, int i3) {
        f92789a.add(new a(System.currentTimeMillis(), z16, i3));
    }
}
