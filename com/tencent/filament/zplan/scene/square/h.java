package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.view.event.TouchEventType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f106110a;

    static {
        int[] iArr = new int[TouchEventType.values().length];
        f106110a = iArr;
        iArr[TouchEventType.DoubleTap.ordinal()] = 1;
        iArr[TouchEventType.Pan.ordinal()] = 2;
        iArr[TouchEventType.Tap.ordinal()] = 3;
    }
}
