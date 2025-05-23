package com.tencent.ecommerce.repo.live;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class m {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105172a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f105173b;

    static {
        int[] iArr = new int[ActivityStatus.values().length];
        f105172a = iArr;
        iArr[ActivityStatus.ACTIVITY_STATUS_PAUSED.ordinal()] = 1;
        iArr[ActivityStatus.ACTIVITY_STATUS_END.ordinal()] = 2;
        int[] iArr2 = new int[UIStatus.values().length];
        f105173b = iArr2;
        iArr2[UIStatus.UI_STATUS_PENDING.ordinal()] = 1;
        iArr2[UIStatus.UI_STATUS_RUNNING.ordinal()] = 2;
    }
}
