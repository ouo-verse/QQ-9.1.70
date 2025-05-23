package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.IconButton;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.be;
import com.tencent.kuikly.core.views.bf;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes31.dex */
public final class GCPGameActivityPageList extends ComposeView<GCPGameActivityViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPGameActivityViewAttr access$getAttr(GCPGameActivityPageList gCPGameActivityPageList) {
        return (GCPGameActivityViewAttr) gCPGameActivityPageList.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        float f16;
        float m3;
        float f17;
        boolean z16 = ((GCPGameActivityViewAttr) getAttr()).getDataList().size() == 1;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        if (((GCPGameActivityViewAttr) getAttr()).getDataList().size() == 1 && ((GCPGameActivityViewAttr) getAttr()).getDataList().get(0).gameCardStyle == 0) {
            f16 = (((GCPGameActivityViewAttr) getAttr()).getPagerData().getIsIOS() || ((GCPGameActivityViewAttr) getAttr()).getDataList().get(0).privilege == null) ? 88.0f : 99.0f;
        } else {
            f16 = !((GCPGameActivityViewAttr) getAttr()).getPagerData().getIsIOS() ? 191.0f : 172.0f;
        }
        floatRef.element = f16;
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        if (z16) {
            m3 = getPagerData().m();
            f17 = 16.0f;
        } else {
            m3 = getPagerData().m();
            f17 = 43.0f;
        }
        floatRef2.element = m3 - f17;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                final Ref.FloatRef floatRef3 = Ref.FloatRef.this;
                final GCPGameActivityPageList gCPGameActivityPageList = this;
                final Ref.FloatRef floatRef4 = floatRef2;
                bf.a(viewContainer2, new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PageListView<?, ?> pageListView) {
                        PageListView<?, ?> pageListView2 = pageListView;
                        final Ref.FloatRef floatRef5 = Ref.FloatRef.this;
                        final GCPGameActivityPageList gCPGameActivityPageList2 = gCPGameActivityPageList;
                        pageListView2.attr(new Function1<be, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(be beVar) {
                                be beVar2 = beVar;
                                beVar2.overflow(false);
                                beVar2.mo141height(Ref.FloatRef.this.element);
                                beVar2.mo153width(gCPGameActivityPageList2.getPagerData().m());
                                beVar2.pageDirection(true);
                                beVar2.showScrollerIndicator(false);
                                beVar2.m140flex(1.0f);
                                ScrollerAttr.bouncesEnable$default(beVar2, false, false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameActivityPageList gCPGameActivityPageList3 = gCPGameActivityPageList;
                        Function0<c<GameCard>> function0 = new Function0<c<GameCard>>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<GameCard> invoke() {
                                return GCPGameActivityPageList.access$getAttr(GCPGameActivityPageList.this).getDataList();
                            }
                        };
                        final Ref.FloatRef floatRef6 = floatRef4;
                        final Ref.FloatRef floatRef7 = Ref.FloatRef.this;
                        final GCPGameActivityPageList gCPGameActivityPageList4 = gCPGameActivityPageList;
                        LoopDirectivesViewKt.a(pageListView2, function0, new Function2<LoopDirectivesView<GameCard>, GameCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<GameCard> loopDirectivesView, GameCard gameCard) {
                                LoopDirectivesView<GameCard> loopDirectivesView2 = loopDirectivesView;
                                final GameCard gameCard2 = gameCard;
                                int i3 = gameCard2.gameCardStyle;
                                if (i3 == 0) {
                                    final Ref.FloatRef floatRef8 = Ref.FloatRef.this;
                                    final Ref.FloatRef floatRef9 = floatRef7;
                                    final GCPGameActivityPageList gCPGameActivityPageList5 = gCPGameActivityPageList4;
                                    loopDirectivesView2.addChild(new GCPGameActivityCard(), new Function1<GCPGameActivityCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.2.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(GCPGameActivityCard gCPGameActivityCard) {
                                            final Ref.FloatRef floatRef10 = Ref.FloatRef.this;
                                            final Ref.FloatRef floatRef11 = floatRef9;
                                            final GameCard gameCard3 = gameCard2;
                                            final GCPGameActivityPageList gCPGameActivityPageList6 = gCPGameActivityPageList5;
                                            gCPGameActivityCard.attr(new Function1<GCPGameActivityCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.2.3.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(GCPGameActivityCardAttr gCPGameActivityCardAttr) {
                                                    GCPGameActivityCardAttr gCPGameActivityCardAttr2 = gCPGameActivityCardAttr;
                                                    gCPGameActivityCardAttr2.mo153width(Ref.FloatRef.this.element);
                                                    gCPGameActivityCardAttr2.mo141height(floatRef11.element);
                                                    gCPGameActivityCardAttr2.cardHeight = floatRef11.element;
                                                    gCPGameActivityCardAttr2.activityData = gameCard3;
                                                    gCPGameActivityCardAttr2.index = GCPGameActivityPageList.access$getAttr(gCPGameActivityPageList6).getDataList().indexOf(gameCard3);
                                                    gCPGameActivityCardAttr2.listSize = GCPGameActivityPageList.access$getAttr(gCPGameActivityPageList6).getDataList().size();
                                                    gCPGameActivityCardAttr2.gameTab = GCPGameActivityPageList.access$getAttr(gCPGameActivityPageList6).gameTab;
                                                    gCPGameActivityCardAttr2.pageDidAppearTimes$delegate.setValue(gCPGameActivityCardAttr2, GCPGameActivityCardAttr.$$delegatedProperties[0], Integer.valueOf(GCPGameActivityPageList.access$getAttr(gCPGameActivityPageList6).getPageDidAppearTimes()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (i3 == 1) {
                                    final Ref.FloatRef floatRef10 = Ref.FloatRef.this;
                                    final Ref.FloatRef floatRef11 = floatRef7;
                                    final GCPGameActivityPageList gCPGameActivityPageList6 = gCPGameActivityPageList4;
                                    loopDirectivesView2.addChild(new GCPGameActivityBigCard(), new Function1<GCPGameActivityBigCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.2.3.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(GCPGameActivityBigCard gCPGameActivityBigCard) {
                                            final Ref.FloatRef floatRef12 = Ref.FloatRef.this;
                                            final Ref.FloatRef floatRef13 = floatRef11;
                                            final GameCard gameCard3 = gameCard2;
                                            final GCPGameActivityPageList gCPGameActivityPageList7 = gCPGameActivityPageList6;
                                            gCPGameActivityBigCard.attr(new Function1<GCPGameActivityBigCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.2.3.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(GCPGameActivityBigCardAttr gCPGameActivityBigCardAttr) {
                                                    GCPGameActivityBigCardAttr gCPGameActivityBigCardAttr2 = gCPGameActivityBigCardAttr;
                                                    gCPGameActivityBigCardAttr2.mo153width(Ref.FloatRef.this.element);
                                                    gCPGameActivityBigCardAttr2.mo141height(floatRef13.element);
                                                    gCPGameActivityBigCardAttr2.cardHeight = floatRef13.element;
                                                    gCPGameActivityBigCardAttr2.activityData = gameCard3;
                                                    gCPGameActivityBigCardAttr2.index = GCPGameActivityPageList.access$getAttr(gCPGameActivityPageList7).getDataList().indexOf(gameCard3);
                                                    gCPGameActivityBigCardAttr2.listSize = GCPGameActivityPageList.access$getAttr(gCPGameActivityPageList7).getDataList().size();
                                                    gCPGameActivityBigCardAttr2.gameTab = GCPGameActivityPageList.access$getAttr(gCPGameActivityPageList7).gameTab;
                                                    gCPGameActivityBigCardAttr2.pageDidAppearTimes$delegate.setValue(gCPGameActivityBigCardAttr2, GCPGameActivityBigCardAttr.$$delegatedProperties[0], Integer.valueOf(GCPGameActivityPageList.access$getAttr(gCPGameActivityPageList7).getPageDidAppearTimes()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameActivityPageList gCPGameActivityPageList2 = this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean z17 = false;
                        if (GCPGameActivityPageList.access$getAttr(GCPGameActivityPageList.this).getDataList().size() == 1 && GCPGameActivityPageList.access$getAttr(GCPGameActivityPageList.this).getDataList().get(0).gameCardStyle == 0) {
                            List<IconButton> list = GCPGameActivityPageList.access$getAttr(GCPGameActivityPageList.this).getDataList().get(0).iconButtons;
                            if (list != null && (list.isEmpty() ^ true)) {
                                z17 = true;
                            }
                        }
                        return Boolean.valueOf(z17);
                    }
                };
                final GCPGameActivityPageList gCPGameActivityPageList3 = this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GCPGameActivityPageList gCPGameActivityPageList4 = GCPGameActivityPageList.this;
                        conditionView.addChild(new GCPIconButtonList(), new Function1<GCPIconButtonList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPIconButtonList gCPIconButtonList) {
                                final GCPGameActivityPageList gCPGameActivityPageList5 = GCPGameActivityPageList.this;
                                gCPIconButtonList.attr(new Function1<GCPIconButtonListAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityPageList.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPIconButtonListAttr gCPIconButtonListAttr) {
                                        GCPIconButtonListAttr gCPIconButtonListAttr2 = gCPIconButtonListAttr;
                                        gCPIconButtonListAttr2.overflow(false);
                                        List<IconButton> list = GCPGameActivityPageList.access$getAttr(GCPGameActivityPageList.this).getDataList().get(0).iconButtons;
                                        gCPIconButtonListAttr2.getDataList().clear();
                                        if (list != null) {
                                            Iterator<IconButton> it = list.iterator();
                                            while (it.hasNext()) {
                                                gCPIconButtonListAttr2.getDataList().add(it.next());
                                            }
                                        }
                                        gCPIconButtonListAttr2.gameTab = GCPGameActivityPageList.access$getAttr(GCPGameActivityPageList.this).gameTab;
                                        gCPIconButtonListAttr2.pageDidAppearTimes$delegate.setValue(gCPIconButtonListAttr2, GCPIconButtonListAttr.$$delegatedProperties[1], Integer.valueOf(GCPGameActivityPageList.access$getAttr(GCPGameActivityPageList.this).getPageDidAppearTimes()));
                                        gCPIconButtonListAttr2.marginTop(16.0f);
                                        gCPIconButtonListAttr2.marginBottom(16.0f);
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
        return new GCPGameActivityViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
