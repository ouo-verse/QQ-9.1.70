package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.view.event.TouchEventType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105920a;

    static {
        int[] iArr = new int[TouchEventType.values().length];
        f105920a = iArr;
        iArr[TouchEventType.TapUp.ordinal()] = 1;
        iArr[TouchEventType.DoubleTap.ordinal()] = 2;
        iArr[TouchEventType.LongPress.ordinal()] = 3;
    }
}
