package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view;

import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveExplainBanner extends ComposeView<LiveExplainBannerAttr, l> {
    public final LiveExplainBannerAttr viewAttr = new LiveExplainBannerAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final LiveExplainBanner liveExplainBanner = LiveExplainBanner.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        if (LiveExplainBanner.this.viewAttr.getState() == ExplainState.EXPLAINING) {
                            mVar2.mo113backgroundColor(new h(2150575919L));
                            mVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(16003961L), 0.0f), new j(new h(16727637L), 1.0f));
                        } else {
                            mVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4294194041L), 0.0f), new j(new h(4294917717L), 1.0f));
                        }
                        mVar2.flexDirectionRow().mo141height(18.0f);
                        mVar2.alignItemsCenter();
                        mVar2.m137borderRadius(new f(4.0f, 0.0f, 0.0f, 4.0f));
                        return Unit.INSTANCE;
                    }
                });
                PAGViewKt.PAG(viewContainer2, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PAGView pAGView) {
                        pAGView.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PAGAttr pAGAttr) {
                                PAGAttr pAGAttr2 = pAGAttr;
                                pAGAttr2.marginLeft(4.0f).size(12.0f, 12.0f);
                                pAGAttr2.src("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/bNi3aySK.pag");
                                pAGAttr2.repeatCount(Integer.MAX_VALUE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainBanner liveExplainBanner2 = LiveExplainBanner.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final LiveExplainBanner liveExplainBanner3 = LiveExplainBanner.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                String str;
                                ce ceVar2 = ceVar;
                                ceVar2.marginRight(4.0f).marginLeft(2.0f);
                                ce.fontSize$default(ceVar2.fontWeightMedium(), 10.0f, null, 2, null).color(h.INSTANCE.m());
                                if (LiveExplainBanner.this.viewAttr.getState() == ExplainState.EXPLAINING) {
                                    str = "\u8bb2\u89e3\u4e2d";
                                } else {
                                    str = "\u5373\u5c06\u5f00\u62a2";
                                }
                                ceVar2.value(str);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainBanner liveExplainBanner3 = LiveExplainBanner.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(LiveExplainBanner.this.viewAttr.getState() != ExplainState.EXPLAINING);
                    }
                };
                final LiveExplainBanner liveExplainBanner4 = LiveExplainBanner.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final LiveExplainBanner liveExplainBanner5 = LiveExplainBanner.this;
                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final LiveExplainBanner liveExplainBanner6 = LiveExplainBanner.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBanner.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null).marginRight(4.0f);
                                        ceVar2.color(h.INSTANCE.m()).fontWeightMedium();
                                        LiveExplainBannerAttr liveExplainBannerAttr = LiveExplainBanner.this.viewAttr;
                                        ceVar2.text((String) liveExplainBannerAttr.leftTimeInfo$delegate.getValue(liveExplainBannerAttr, LiveExplainBannerAttr.$$delegatedProperties[1]));
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
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
