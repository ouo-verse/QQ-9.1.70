package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.view.event.TouchEventType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f106114a;

    static {
        int[] iArr = new int[TouchEventType.values().length];
        f106114a = iArr;
        iArr[TouchEventType.Tap.ordinal()] = 1;
        iArr[TouchEventType.DoubleTap.ordinal()] = 2;
        iArr[TouchEventType.LongPress.ordinal()] = 3;
    }
}
