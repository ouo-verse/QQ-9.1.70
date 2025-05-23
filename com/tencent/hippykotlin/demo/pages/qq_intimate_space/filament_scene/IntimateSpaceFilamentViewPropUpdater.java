package com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes37.dex */
public final class IntimateSpaceFilamentViewPropUpdater implements f {
    public static final IntimateSpaceFilamentViewPropUpdater INSTANCE = new IntimateSpaceFilamentViewPropUpdater();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public final void setPropToView(ComposeRenderView composeRenderView, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        DeclarativeBaseView<?, ?> b16 = composeRenderView.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.IntimateSpaceFilamentView");
        IntimateSpaceFilamentViewAttr intimateSpaceFilamentViewAttr = (IntimateSpaceFilamentViewAttr) ((IntimateSpaceFilamentView) b16).getViewAttr();
        if (Intrinsics.areEqual(str, "onMessageChannelReady")) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            intimateSpaceFilamentViewAttr.onMessageChannelReady = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 0);
        } else if (Intrinsics.areEqual(str, "onSceneReady")) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            intimateSpaceFilamentViewAttr.onSceneReady = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 0);
        }
    }

    @Override // com.tencent.ntcompose.core.f
    public final void resetPropToView(ComposeRenderView composeRenderView, String str) {
    }
}
