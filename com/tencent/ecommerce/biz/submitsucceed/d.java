package com.tencent.ecommerce.biz.submitsucceed;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f104811a;

    static {
        int[] iArr = new int[SubmitSucceedFrom.values().length];
        f104811a = iArr;
        iArr[SubmitSucceedFrom.PAY_IN_SUBMIT_ORDER.ordinal()] = 1;
        iArr[SubmitSucceedFrom.PAY_IN_ORDER_LIST.ordinal()] = 2;
        iArr[SubmitSucceedFrom.PAY_IN_ORDER_DETAIL.ordinal()] = 3;
        iArr[SubmitSucceedFrom.WRITE_COMMENT.ordinal()] = 4;
        iArr[SubmitSucceedFrom.APPLY_SAMPLE_ORDER.ordinal()] = 5;
    }
}
