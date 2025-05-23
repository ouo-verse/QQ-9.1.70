package com.tencent.filament.zplan.view.event;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f106349a;

    static {
        int[] iArr = new int[TouchEventState.values().length];
        f106349a = iArr;
        iArr[TouchEventState.Began.ordinal()] = 1;
        iArr[TouchEventState.Changed.ordinal()] = 2;
        iArr[TouchEventState.Ended.ordinal()] = 3;
        iArr[TouchEventState.Failed.ordinal()] = 4;
    }
}
