package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop;

import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.OrderStateUpdateType;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.BottomAreaOperation;
import com.tencent.ecommerce.biz.orders.common.QShopOrderState;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f103306a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f103307b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f103308c;

    static {
        int[] iArr = new int[OrderStateUpdateType.values().length];
        f103306a = iArr;
        iArr[OrderStateUpdateType.ALL.ordinal()] = 1;
        iArr[OrderStateUpdateType.ONLY_HEADER.ordinal()] = 2;
        int[] iArr2 = new int[BottomAreaOperation.values().length];
        f103307b = iArr2;
        iArr2[BottomAreaOperation.CONFIRM_RECEIVE.ordinal()] = 1;
        iArr2[BottomAreaOperation.CONTINUE_PAY.ordinal()] = 2;
        iArr2[BottomAreaOperation.REVIEW_COMMENT.ordinal()] = 3;
        iArr2[BottomAreaOperation.WRITE_COMMENT.ordinal()] = 4;
        iArr2[BottomAreaOperation.CANCEL_ORDER.ordinal()] = 5;
        iArr2[BottomAreaOperation.GO_DELIVERY.ordinal()] = 6;
        iArr2[BottomAreaOperation.NONE.ordinal()] = 7;
        int[] iArr3 = new int[QShopOrderState.values().length];
        f103308c = iArr3;
        iArr3[QShopOrderState.UNKNOWN.ordinal()] = 1;
        iArr3[QShopOrderState.PAYMENT_PENDING.ordinal()] = 2;
        iArr3[QShopOrderState.PAYMENT_CANCELED.ordinal()] = 3;
        iArr3[QShopOrderState.PAYMENT_DONE.ordinal()] = 4;
        iArr3[QShopOrderState.DELIVERY_PENDING.ordinal()] = 5;
        iArr3[QShopOrderState.DELIVERY_DONE.ordinal()] = 6;
        iArr3[QShopOrderState.REFUND.ordinal()] = 7;
    }
}
