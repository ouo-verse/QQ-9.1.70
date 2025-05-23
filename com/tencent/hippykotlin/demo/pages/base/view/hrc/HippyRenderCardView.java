package com.tencent.hippykotlin.demo.pages.base.view.hrc;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HippyRenderCardView extends ComposeView<HippyRenderCardAttr, l> implements c {
    public static final Companion Companion = new Companion();
    public static Map<String, Function1<e, HippyRenderCardCompose<?>>> hrcComposeMap = new LinkedHashMap();
    public final HippyRenderCardAttr hrcAttr = new HippyRenderCardAttr();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, kotlin.jvm.functions.Function1<com.tencent.kuikly.core.nvi.serialization.json.e, com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardCompose<?>>>] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                Function1 function1 = (Function1) HippyRenderCardView.hrcComposeMap.get(HippyRenderCardView.this.hrcAttr.getHRCData().q("cardName", ""));
                final HippyRenderCardCompose hippyRenderCardCompose = function1 != null ? (HippyRenderCardCompose) function1.invoke(HippyRenderCardView.this.hrcAttr.getHRCData()) : null;
                if (hippyRenderCardCompose != null) {
                    HippyRenderCardView hippyRenderCardView = HippyRenderCardView.this;
                    HippyRenderCardView hippyRenderCardView2 = this;
                    ((HRCComposeAttr) hippyRenderCardCompose.getViewAttr()).setPagerId(hippyRenderCardView.getPagerId());
                    ((HRCComposeAttr) hippyRenderCardCompose.getViewAttr()).hrcData = hippyRenderCardView.hrcAttr.getHRCData();
                    ((HRCComposeAttr) hippyRenderCardCompose.getViewAttr()).with("hrcId", Integer.valueOf(hippyRenderCardView.hrcAttr.hrcId));
                    hippyRenderCardView2.addChild(hippyRenderCardCompose, new Function1<HippyRenderCardCompose<?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView$body$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(HippyRenderCardCompose<?> hippyRenderCardCompose2) {
                            hippyRenderCardCompose.body();
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.hrcAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getPager().removePagerEventObserver(this);
    }

    public final void onReceiveCustomEvent(String str, e eVar) {
        Iterator<T> it = getChildren().iterator();
        while (it.hasNext()) {
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) it.next();
            Intrinsics.checkNotNull(declarativeBaseView, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardCompose<*>");
            ((HippyRenderCardCompose) declarativeBaseView).onReceiveCustomEvent(str, eVar);
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "HRCView";
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
    }
}
