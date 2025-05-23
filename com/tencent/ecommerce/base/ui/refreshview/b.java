package com.tencent.ecommerce.base.ui.refreshview;

import com.tencent.ecommerce.base.ui.refreshview.RecycleViewScrollListener;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f101231a;

    static {
        int[] iArr = new int[RecycleViewScrollListener.LAYOUT_MANAGER_TYPE.values().length];
        f101231a = iArr;
        iArr[RecycleViewScrollListener.LAYOUT_MANAGER_TYPE.LINEAR.ordinal()] = 1;
        iArr[RecycleViewScrollListener.LAYOUT_MANAGER_TYPE.GRID.ordinal()] = 2;
        iArr[RecycleViewScrollListener.LAYOUT_MANAGER_TYPE.STAGGERED_GRID.ordinal()] = 3;
    }
}
