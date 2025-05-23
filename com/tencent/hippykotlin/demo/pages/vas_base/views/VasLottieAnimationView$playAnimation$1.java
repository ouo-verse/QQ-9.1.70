package com.tencent.hippykotlin.demo.pages.vas_base.views;

import com.tencent.kuikly.core.base.RenderView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasLottieAnimationView$playAnimation$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ VasLottieAnimationView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasLottieAnimationView$playAnimation$1(VasLottieAnimationView vasLottieAnimationView) {
        super(0);
        this.this$0 = vasLottieAnimationView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        RenderView renderView = this.this$0.getRenderView();
        if (renderView != null) {
            RenderView.b(renderView, QZoneJsConstants.METHOD_PLAY, null, null, 6, null);
        }
        return Unit.INSTANCE;
    }
}
