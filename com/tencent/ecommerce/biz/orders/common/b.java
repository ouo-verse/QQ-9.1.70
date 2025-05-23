package com.tencent.ecommerce.biz.orders.common;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ int a(double d16) {
        long doubleToLongBits = Double.doubleToLongBits(d16);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
