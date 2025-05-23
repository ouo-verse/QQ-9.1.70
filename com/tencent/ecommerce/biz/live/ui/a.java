package com.tencent.ecommerce.biz.live.ui;

import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.UIStatus;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f102787a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f102788b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f102789c;

    static {
        int[] iArr = new int[LiveTabId.values().length];
        f102787a = iArr;
        iArr[LiveTabId.LIVE_TAB_PRODUCT.ordinal()] = 1;
        LiveTabId liveTabId = LiveTabId.LIVE_TAB_QSHOP;
        iArr[liveTabId.ordinal()] = 2;
        int[] iArr2 = new int[LiveTabId.values().length];
        f102788b = iArr2;
        iArr2[liveTabId.ordinal()] = 1;
        int[] iArr3 = new int[UIStatus.values().length];
        f102789c = iArr3;
        iArr3[UIStatus.UI_STATUS_RUNNING.ordinal()] = 1;
        iArr3[UIStatus.UI_STATUS_NONE.ordinal()] = 2;
    }
}
