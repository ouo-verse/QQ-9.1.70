package com.tencent.ecommerce.biz.logistics;

import com.tencent.ecommerce.biz.orders.common.TrailStatus;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f102907a;

    static {
        int[] iArr = new int[TrailStatus.values().length];
        f102907a = iArr;
        iArr[TrailStatus.SIGNED.ordinal()] = 1;
        iArr[TrailStatus.WAITING_RECEIVE.ordinal()] = 2;
    }
}
