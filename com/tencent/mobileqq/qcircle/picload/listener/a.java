package com.tencent.mobileqq.qcircle.picload.listener;

import com.tencent.biz.richframework.network.util.VSNetworkSpeedTest;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final VSNetworkSpeedTest f261744a = new VSNetworkSpeedTest();

    public static void a() {
        f261744a.collectNetWorkError("");
    }

    public static void b(double d16) {
        f261744a.collectNetWorkSucceed("", (long) d16);
    }

    public static VSNetworkSpeedTest c() {
        return f261744a;
    }
}
