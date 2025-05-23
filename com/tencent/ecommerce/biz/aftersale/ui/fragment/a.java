package com.tencent.ecommerce.biz.aftersale.ui.fragment;

import com.tencent.ecommerce.repo.aftersale.apply.ApplyType;
import com.tencent.ecommerce.repo.aftersale.apply.PageType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f101304a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f101305b;

    static {
        int[] iArr = new int[ApplyType.values().length];
        f101304a = iArr;
        iArr[ApplyType.APPLY_TYPE_REFUND_ONLY.ordinal()] = 1;
        iArr[ApplyType.APPLY_TYPE_RETURN_REFUND.ordinal()] = 2;
        int[] iArr2 = new int[PageType.values().length];
        f101305b = iArr2;
        iArr2[PageType.PAGE_TYPE_UNINIT.ordinal()] = 1;
        iArr2[PageType.PAGE_TYPE_APPLY.ordinal()] = 2;
        iArr2[PageType.PAGE_TYPE_RETURN_REFUND.ordinal()] = 3;
        iArr2[PageType.PAGE_TYPE_REFUND_ONLY.ordinal()] = 4;
        iArr2[PageType.PAGE_TYPE_JUDGEMENT.ordinal()] = 5;
    }
}
