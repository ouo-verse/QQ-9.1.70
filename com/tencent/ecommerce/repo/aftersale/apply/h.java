package com.tencent.ecommerce.repo.aftersale.apply;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f104939a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f104940b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f104941c;

    static {
        int[] iArr = new int[PageType.values().length];
        f104939a = iArr;
        PageType pageType = PageType.PAGE_TYPE_UNINIT;
        iArr[pageType.ordinal()] = 1;
        iArr[PageType.PAGE_TYPE_APPLY.ordinal()] = 2;
        PageType pageType2 = PageType.PAGE_TYPE_REFUND_ONLY;
        iArr[pageType2.ordinal()] = 3;
        PageType pageType3 = PageType.PAGE_TYPE_RETURN_REFUND;
        iArr[pageType3.ordinal()] = 4;
        PageType pageType4 = PageType.PAGE_TYPE_JUDGEMENT;
        iArr[pageType4.ordinal()] = 5;
        int[] iArr2 = new int[PageType.values().length];
        f104940b = iArr2;
        iArr2[pageType2.ordinal()] = 1;
        iArr2[pageType3.ordinal()] = 2;
        iArr2[pageType4.ordinal()] = 3;
        int[] iArr3 = new int[PageType.values().length];
        f104941c = iArr3;
        iArr3[pageType.ordinal()] = 1;
        iArr3[pageType2.ordinal()] = 2;
        iArr3[pageType3.ordinal()] = 3;
        iArr3[pageType4.ordinal()] = 4;
    }
}
