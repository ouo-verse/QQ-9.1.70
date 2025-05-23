package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import com.tencent.ecommerce.biz.orders.common.QShopOrderState;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f103192a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f103193b;

    static {
        int[] iArr = new int[QShopOrderState.values().length];
        f103192a = iArr;
        iArr[QShopOrderState.UNKNOWN.ordinal()] = 1;
        QShopOrderState qShopOrderState = QShopOrderState.PAYMENT_PENDING;
        iArr[qShopOrderState.ordinal()] = 2;
        iArr[QShopOrderState.PAYMENT_DONE.ordinal()] = 3;
        QShopOrderState qShopOrderState2 = QShopOrderState.DELIVERY_PENDING;
        iArr[qShopOrderState2.ordinal()] = 4;
        iArr[QShopOrderState.DELIVERY_DONE.ordinal()] = 5;
        iArr[QShopOrderState.REFUND.ordinal()] = 6;
        iArr[QShopOrderState.PAYMENT_CANCELED.ordinal()] = 7;
        int[] iArr2 = new int[QShopOrderState.values().length];
        f103193b = iArr2;
        iArr2[qShopOrderState.ordinal()] = 1;
        iArr2[qShopOrderState2.ordinal()] = 2;
    }
}
