package com.tencent.ecommerce.biz.orders.sellerorders.container;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f103838a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f103839b;

    static {
        int[] iArr = new int[ECSellerOrderTab.values().length];
        f103838a = iArr;
        ECSellerOrderTab eCSellerOrderTab = ECSellerOrderTab.SAAS;
        iArr[eCSellerOrderTab.ordinal()] = 1;
        ECSellerOrderTab eCSellerOrderTab2 = ECSellerOrderTab.SAMPLE;
        iArr[eCSellerOrderTab2.ordinal()] = 2;
        int[] iArr2 = new int[ECSellerOrderTab.values().length];
        f103839b = iArr2;
        iArr2[eCSellerOrderTab.ordinal()] = 1;
        iArr2[eCSellerOrderTab2.ordinal()] = 2;
    }
}
