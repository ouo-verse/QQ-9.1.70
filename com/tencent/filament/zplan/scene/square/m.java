package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.view.event.TouchEventType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class m {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f106115a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f106116b;

    static {
        int[] iArr = new int[TouchEventType.values().length];
        f106115a = iArr;
        iArr[TouchEventType.Pan.ordinal()] = 1;
        iArr[TouchEventType.Pinch.ordinal()] = 2;
        iArr[TouchEventType.Tap.ordinal()] = 3;
        iArr[TouchEventType.DoubleTap.ordinal()] = 4;
        iArr[TouchEventType.LongPress.ordinal()] = 5;
        int[] iArr2 = new int[ObjectType.values().length];
        f106116b = iArr2;
        iArr2[ObjectType.AVATAR.ordinal()] = 1;
        iArr2[ObjectType.IMAGE.ordinal()] = 2;
    }
}
