package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.AdeliePolarLightView;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.AdeliePolarLightViewAttr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.f;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class AdeliePolarLightViewPropUpdater implements f {
    public static final AdeliePolarLightViewPropUpdater INSTANCE = new AdeliePolarLightViewPropUpdater();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public final void setPropToView(ComposeRenderView composeRenderView, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        DeclarativeBaseView<?, ?> b16 = composeRenderView.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.AdeliePolarLightView");
        AdeliePolarLightViewAttr adeliePolarLightViewAttr = (AdeliePolarLightViewAttr) ((AdeliePolarLightView) b16).getViewAttr();
        if (Intrinsics.areEqual(str, "scene")) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            adeliePolarLightViewAttr.with("scene", (String) obj);
        }
    }

    @Override // com.tencent.ntcompose.core.f
    public final void resetPropToView(ComposeRenderView composeRenderView, String str) {
    }
}
