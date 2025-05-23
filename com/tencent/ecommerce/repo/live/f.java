package com.tencent.ecommerce.repo.live;

import com.tencent.ecommerce.biz.live.LiveTabId;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105132a;

    static {
        int[] iArr = new int[LiveTabId.values().length];
        f105132a = iArr;
        iArr[LiveTabId.LIVE_TAB_PRODUCT.ordinal()] = 1;
        iArr[LiveTabId.LIVE_TAB_QSHOP.ordinal()] = 2;
        iArr[LiveTabId.LIVE_TAB_GOK.ordinal()] = 3;
    }
}
