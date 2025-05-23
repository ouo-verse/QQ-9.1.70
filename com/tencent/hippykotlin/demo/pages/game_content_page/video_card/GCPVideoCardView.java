package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.AdCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.AdData;
import com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GCPVideoCardView extends ComposeView<GCPVideoCardAttr, GCPVideoCardEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPVideoCardAttr access$getAttr(GCPVideoCardView gCPVideoCardView) {
        return (GCPVideoCardAttr) gCPVideoCardView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPVideoCardEvent access$getEvent(GCPVideoCardView gCPVideoCardView) {
        return (GCPVideoCardEvent) gCPVideoCardView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(new h("qecommerce_skin_color_bg_default"));
                        return Unit.INSTANCE;
                    }
                });
                final GCPVideoCardView gCPVideoCardView = GCPVideoCardView.this;
                viewContainer2.addChild(new GCPBaseInfoView(), new Function1<GCPBaseInfoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GCPBaseInfoView gCPBaseInfoView) {
                        final GCPVideoCardView gCPVideoCardView2 = GCPVideoCardView.this;
                        gCPBaseInfoView.attr(new Function1<GCPBaseInfoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPBaseInfoAttr gCPBaseInfoAttr) {
                                GCPBaseInfoAttr gCPBaseInfoAttr2 = gCPBaseInfoAttr;
                                gCPBaseInfoAttr2.marginLeft(16.0f).marginRight(16.0f).marginTop(16.0f);
                                gCPBaseInfoAttr2.gameFeedModel = GCPVideoCardView.access$getAttr(GCPVideoCardView.this).getGameFeedModel();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPVideoCardView gCPVideoCardView2 = GCPVideoCardView.this;
                viewContainer2.addChild(new GCPVideoView(), new Function1<GCPVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GCPVideoView gCPVideoView) {
                        GCPVideoView gCPVideoView2 = gCPVideoView;
                        final GCPVideoCardView gCPVideoCardView3 = GCPVideoCardView.this;
                        gCPVideoView2.attr(new Function1<GCPVideoViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPVideoViewAttr gCPVideoViewAttr) {
                                GCPVideoViewAttr gCPVideoViewAttr2 = gCPVideoViewAttr;
                                gCPVideoViewAttr2.marginLeft(16.0f).marginRight(16.0f).marginTop(8.0f);
                                gCPVideoViewAttr2.feed = GCPVideoCardView.access$getAttr(GCPVideoCardView.this).getGameFeedModel().gameFeed;
                                GCPVideoCardAttr access$getAttr = GCPVideoCardView.access$getAttr(GCPVideoCardView.this);
                                gCPVideoViewAttr2.playControl$delegate.setValue(gCPVideoViewAttr2, GCPVideoViewAttr.$$delegatedProperties[0], (QVideoPlayControl) access$getAttr.playControl$delegate.getValue(access$getAttr, GCPVideoCardAttr.$$delegatedProperties[0]));
                                gCPVideoViewAttr2.index = GCPVideoCardView.access$getAttr(GCPVideoCardView.this).feedIndex;
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPVideoCardView gCPVideoCardView4 = GCPVideoCardView.this;
                        gCPVideoView2.event(new Function1<GCPVideoViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPVideoViewEvent gCPVideoViewEvent) {
                                GCPVideoViewEvent gCPVideoViewEvent2 = gCPVideoViewEvent;
                                final GCPVideoCardView gCPVideoCardView5 = GCPVideoCardView.this;
                                VisibilityEventKt.a(gCPVideoViewEvent2, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Float f16) {
                                        float floatValue = f16.floatValue();
                                        Function1<? super Float, Unit> function1 = GCPVideoCardView.access$getEvent(GCPVideoCardView.this).videoAppearPercentageHandlerFn;
                                        if (function1 != null) {
                                            function1.invoke(Float.valueOf(floatValue));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPVideoCardView gCPVideoCardView6 = GCPVideoCardView.this;
                                gCPVideoViewEvent2.onClickVideoHandlerFn = new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Long l3) {
                                        long longValue = l3.longValue();
                                        Function1<? super Long, Unit> function1 = GCPVideoCardView.access$getEvent(GCPVideoCardView.this).onClickVideoHandlerFn;
                                        if (function1 != null) {
                                            function1.invoke(Long.valueOf(longValue));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final GCPVideoCardView gCPVideoCardView7 = GCPVideoCardView.this;
                                gCPVideoViewEvent2.onClickPlayVideoIconHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        Function1<Object, Unit> function1 = GCPVideoCardView.access$getEvent(GCPVideoCardView.this).onClickPlayVideoIconHandlerFn;
                                        if (function1 != null) {
                                            function1.invoke(obj);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final GCPVideoCardView gCPVideoCardView8 = GCPVideoCardView.this;
                                gCPVideoViewEvent2.onClickPauseVideoIconHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.3.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        Function1<Object, Unit> function1 = GCPVideoCardView.access$getEvent(GCPVideoCardView.this).onClickPauseVideoIconHandlerFn;
                                        if (function1 != null) {
                                            function1.invoke(obj);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPVideoCardView gCPVideoCardView3 = GCPVideoCardView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        AdData adData = GCPVideoCardView.access$getAttr(GCPVideoCardView.this).getGameFeedModel().gameFeed.adData;
                        return Boolean.valueOf((adData != null ? adData.adCard : null) != null);
                    }
                };
                final GCPVideoCardView gCPVideoCardView4 = GCPVideoCardView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GCPVideoCardView gCPVideoCardView5 = GCPVideoCardView.this;
                        conditionView.addChild(new GCPGameCardView(), new Function1<GCPGameCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPGameCardView gCPGameCardView) {
                                final GCPVideoCardView gCPVideoCardView6 = GCPVideoCardView.this;
                                gCPGameCardView.attr(new Function1<GCPGameCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPGameCardViewAttr gCPGameCardViewAttr) {
                                        GCPGameCardViewAttr gCPGameCardViewAttr2 = gCPGameCardViewAttr;
                                        AdData adData = GCPVideoCardView.access$getAttr(GCPVideoCardView.this).getGameFeedModel().gameFeed.adData;
                                        AdCard adCard = adData != null ? adData.adCard : null;
                                        Intrinsics.checkNotNull(adCard);
                                        gCPGameCardViewAttr2.adCard = adCard;
                                        AdData adData2 = GCPVideoCardView.access$getAttr(GCPVideoCardView.this).getGameFeedModel().gameFeed.adData;
                                        Intrinsics.checkNotNull(adData2);
                                        gCPGameCardViewAttr2.uiType = adData2.uiType;
                                        gCPGameCardViewAttr2.gameTab = GCPVideoCardView.access$getAttr(GCPVideoCardView.this).gameTab;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPVideoCardView gCPVideoCardView5 = GCPVideoCardView.this;
                viewContainer2.addChild(new GCPInteractView(), new Function1<GCPInteractView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GCPInteractView gCPInteractView) {
                        final GCPVideoCardView gCPVideoCardView6 = GCPVideoCardView.this;
                        gCPInteractView.attr(new Function1<GCPInteractAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPInteractAttr gCPInteractAttr) {
                                GCPInteractAttr gCPInteractAttr2 = gCPInteractAttr;
                                gCPInteractAttr2.marginLeft(16.0f);
                                GCPVideoView.Companion companion = GCPVideoView.Companion;
                                gCPInteractAttr2.getPagerId();
                                companion.getClass();
                                gCPInteractAttr2.mo153width(248.0f);
                                gCPInteractAttr2.gameFeedModel = GCPVideoCardView.access$getAttr(GCPVideoCardView.this).getGameFeedModel();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView$body$1.7
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView.body.1.7.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(8.0f);
                                tVar2.mo141height(8.0f);
                                tVar2.mo113backgroundColor(new h("qecommerce_skin_color_bg_backplate"));
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
        return new GCPVideoCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GCPVideoCardEvent();
    }
}
