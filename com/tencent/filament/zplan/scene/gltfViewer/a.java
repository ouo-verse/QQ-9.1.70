package com.tencent.filament.zplan.scene.gltfViewer;

import com.tencent.filament.zplan.view.event.TouchEventState;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105961a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f105962b;

    static {
        int[] iArr = new int[TouchEventState.values().length];
        f105961a = iArr;
        TouchEventState touchEventState = TouchEventState.Began;
        iArr[touchEventState.ordinal()] = 1;
        TouchEventState touchEventState2 = TouchEventState.Changed;
        iArr[touchEventState2.ordinal()] = 2;
        TouchEventState touchEventState3 = TouchEventState.Ended;
        iArr[touchEventState3.ordinal()] = 3;
        int[] iArr2 = new int[TouchEventState.values().length];
        f105962b = iArr2;
        iArr2[touchEventState.ordinal()] = 1;
        iArr2[touchEventState2.ordinal()] = 2;
        iArr2[touchEventState3.ordinal()] = 3;
    }
}
