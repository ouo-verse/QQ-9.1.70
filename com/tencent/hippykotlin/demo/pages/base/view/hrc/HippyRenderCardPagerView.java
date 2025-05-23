package com.tencent.hippykotlin.demo.pages.base.view.hrc;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class HippyRenderCardPagerView extends ComposeView<HRCPagerViewAttr, HRCPagerViewEvent> {
    public final HRCPagerViewAttr pagerViewAttr = new HRCPagerViewAttr();
    public final List<aa<HippyRenderCardView>> hrcCardViewRefList = new ArrayList();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardPagerView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final HippyRenderCardPagerView hippyRenderCardPagerView = HippyRenderCardPagerView.this;
                Function0<c<e>> function0 = new Function0<c<e>>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardPagerView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final c<e> invoke() {
                        return HippyRenderCardPagerView.this.pagerViewAttr.getHrcDataList();
                    }
                };
                final HippyRenderCardPagerView hippyRenderCardPagerView2 = HippyRenderCardPagerView.this;
                LoopDirectivesViewKt.a(viewContainer, function0, new Function2<LoopDirectivesView<e>, e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardPagerView$body$1.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(LoopDirectivesView<e> loopDirectivesView, e eVar) {
                        final e eVar2 = eVar;
                        final HippyRenderCardPagerView hippyRenderCardPagerView3 = HippyRenderCardPagerView.this;
                        loopDirectivesView.addChild(new HippyRenderCardView(), new Function1<HippyRenderCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardPagerView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(HippyRenderCardView hippyRenderCardView) {
                                HippyRenderCardView hippyRenderCardView2 = hippyRenderCardView;
                                final HippyRenderCardPagerView hippyRenderCardPagerView4 = HippyRenderCardPagerView.this;
                                final e eVar3 = eVar2;
                                hippyRenderCardView2.ref(hippyRenderCardView2, new Function1<aa<HippyRenderCardView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardPagerView.body.1.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<com.tencent.kuikly.core.base.aa<com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView>>, java.util.ArrayList] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<HippyRenderCardView> aaVar) {
                                        int indexOf = HippyRenderCardPagerView.this.pagerViewAttr.getHrcDataList().indexOf(eVar3);
                                        HippyRenderCardPagerView.this.hrcCardViewRefList.add(indexOf, aaVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final e eVar4 = eVar2;
                                hippyRenderCardView2.attr(new Function1<HippyRenderCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardPagerView.body.1.2.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HippyRenderCardAttr hippyRenderCardAttr) {
                                        HippyRenderCardAttr hippyRenderCardAttr2 = hippyRenderCardAttr;
                                        Attr.absolutePosition$default(hippyRenderCardAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                        e eVar5 = e.this;
                                        hippyRenderCardAttr2.hrcData = eVar5;
                                        int j3 = eVar5.j("hrcId");
                                        hippyRenderCardAttr2.with("hrcId", Integer.valueOf(j3));
                                        hippyRenderCardAttr2.hrcId = j3;
                                        hippyRenderCardAttr2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new HRCPagerViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new HRCPagerViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void createRenderView() {
        createComponentRenderViewIfNeed();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public final void insertSubRenderView(DeclarativeBaseView<?, ?> declarativeBaseView) {
    }
}
