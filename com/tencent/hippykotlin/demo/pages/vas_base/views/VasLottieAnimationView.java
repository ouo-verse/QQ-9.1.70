package com.tencent.hippykotlin.demo.pages.vas_base.views;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasLottieAnimationView extends DeclarativeBaseView<LottieAnimationAttr, LottieAnimationEvent> {
    public final LottieAnimationEvent eventInstance = new LottieAnimationEvent();

    public VasLottieAnimationView() {
        registerListener();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new LottieAnimationAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return this.eventInstance;
    }

    public final void registerListener() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieAnimationView$registerListener$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                RenderView renderView = VasLottieAnimationView.this.getRenderView();
                if (renderView != null) {
                    final VasLottieAnimationView vasLottieAnimationView = VasLottieAnimationView.this;
                    RenderView.b(renderView, "setAnimationStartListener", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieAnimationView$registerListener$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            Function1<Object, Unit> handlerWithEventName;
                            e eVar2 = eVar;
                            String p16 = eVar2 != null ? eVar2.p("event") : null;
                            if (!(p16 == null || p16.length() == 0) && (handlerWithEventName = VasLottieAnimationView.this.eventInstance.handlerWithEventName(p16)) != null) {
                                handlerWithEventName.invoke("");
                            }
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                }
                RenderView renderView2 = VasLottieAnimationView.this.getRenderView();
                if (renderView2 != null) {
                    final VasLottieAnimationView vasLottieAnimationView2 = VasLottieAnimationView.this;
                    RenderView.b(renderView2, "setAnimationEndListener", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieAnimationView$registerListener$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            Function1<Object, Unit> handlerWithEventName;
                            e eVar2 = eVar;
                            String p16 = eVar2 != null ? eVar2.p("event") : null;
                            if (!(p16 == null || p16.length() == 0) && (handlerWithEventName = VasLottieAnimationView.this.eventInstance.handlerWithEventName(p16)) != null) {
                                handlerWithEventName.invoke("");
                            }
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "VasLottieAnimationView";
    }
}
