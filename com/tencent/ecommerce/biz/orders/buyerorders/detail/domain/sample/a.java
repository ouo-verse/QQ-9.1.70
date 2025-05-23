package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample;

import com.tencent.ecommerce.biz.orders.common.SampleOrderState;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f103206a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f103207b;

    static {
        int[] iArr = new int[SampleOrderState.values().length];
        f103206a = iArr;
        iArr[SampleOrderState.RESERVE.ordinal()] = 1;
        iArr[SampleOrderState.AUDITING.ordinal()] = 2;
        iArr[SampleOrderState.CANCELLED.ordinal()] = 3;
        iArr[SampleOrderState.REJECTED.ordinal()] = 4;
        iArr[SampleOrderState.SIGNING.ordinal()] = 5;
        SampleOrderState sampleOrderState = SampleOrderState.FULFILLING;
        iArr[sampleOrderState.ordinal()] = 6;
        iArr[SampleOrderState.ABORT_AUDITING.ordinal()] = 7;
        iArr[SampleOrderState.UNFULFILLED.ordinal()] = 8;
        iArr[SampleOrderState.FULFILLED.ordinal()] = 9;
        int[] iArr2 = new int[SampleOrderState.values().length];
        f103207b = iArr2;
        iArr2[sampleOrderState.ordinal()] = 1;
    }
}
