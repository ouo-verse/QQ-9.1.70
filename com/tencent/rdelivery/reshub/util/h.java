package com.tencent.rdelivery.reshub.util;

import com.tencent.rdelivery.reshub.core.ResLoadRequestPriority;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes25.dex */
public final /* synthetic */ class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f364602a;

    static {
        int[] iArr = new int[ResLoadRequestPriority.values().length];
        f364602a = iArr;
        iArr[ResLoadRequestPriority.High.ordinal()] = 1;
        iArr[ResLoadRequestPriority.Normal.ordinal()] = 2;
        iArr[ResLoadRequestPriority.Low.ordinal()] = 3;
        iArr[ResLoadRequestPriority.Preload.ordinal()] = 4;
    }
}
