package com.tencent.ecommerce.biz.live.ui.viewholder;

import com.tencent.ecommerce.repo.live.UIStatus;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f102824a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f102825b;

    static {
        int[] iArr = new int[PayloadType.values().length];
        f102824a = iArr;
        iArr[PayloadType.UpdateWholeItem.ordinal()] = 1;
        iArr[PayloadType.OnlyUpdateCountdown.ordinal()] = 2;
        iArr[PayloadType.OnlyUpdateStock.ordinal()] = 3;
        iArr[PayloadType.NoChange.ordinal()] = 4;
        int[] iArr2 = new int[UIStatus.values().length];
        f102825b = iArr2;
        iArr2[UIStatus.UI_STATUS_PENDING.ordinal()] = 1;
        iArr2[UIStatus.UI_STATUS_RUNNING.ordinal()] = 2;
    }
}
