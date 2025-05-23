package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.IconButton;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes31.dex */
public final class GCPIconButtonList extends ComposeView<GCPIconButtonListAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPIconButtonListAttr access$getAttr(GCPIconButtonList gCPIconButtonList) {
        return (GCPIconButtonListAttr) gCPIconButtonList.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 40.0f;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonList$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonList$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                final Ref.FloatRef floatRef2 = Ref.FloatRef.this;
                final GCPIconButtonList gCPIconButtonList = this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonList$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final Ref.FloatRef floatRef3 = Ref.FloatRef.this;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonList.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.overflow(false);
                                aoVar2.m140flex(1.0f);
                                aoVar2.mo141height(Ref.FloatRef.this.element);
                                aoVar2.flexDirectionRow();
                                aoVar2.showScrollerIndicator(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPIconButtonList gCPIconButtonList2 = gCPIconButtonList;
                        Function0<c<IconButton>> function0 = new Function0<c<IconButton>>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonList.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<IconButton> invoke() {
                                return GCPIconButtonList.access$getAttr(GCPIconButtonList.this).getDataList();
                            }
                        };
                        final GCPIconButtonList gCPIconButtonList3 = gCPIconButtonList;
                        LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<IconButton>, IconButton, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonList.body.1.2.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<IconButton> loopDirectivesView, IconButton iconButton) {
                                final IconButton iconButton2 = iconButton;
                                final GCPIconButtonList gCPIconButtonList4 = GCPIconButtonList.this;
                                loopDirectivesView.addChild(new GCPIconButtonItem(), new Function1<GCPIconButtonItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonList.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPIconButtonItem gCPIconButtonItem) {
                                        final IconButton iconButton3 = IconButton.this;
                                        final GCPIconButtonList gCPIconButtonList5 = gCPIconButtonList4;
                                        gCPIconButtonItem.attr(new Function1<GCPIconButtonItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonList.body.1.2.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GCPIconButtonItemAttr gCPIconButtonItemAttr) {
                                                GCPIconButtonItemAttr gCPIconButtonItemAttr2 = gCPIconButtonItemAttr;
                                                gCPIconButtonItemAttr2.activityData = IconButton.this;
                                                gCPIconButtonItemAttr2.index = GCPIconButtonList.access$getAttr(gCPIconButtonList5).getDataList().indexOf(IconButton.this);
                                                gCPIconButtonItemAttr2.gameTab = GCPIconButtonList.access$getAttr(gCPIconButtonList5).gameTab;
                                                GCPIconButtonListAttr access$getAttr = GCPIconButtonList.access$getAttr(gCPIconButtonList5);
                                                gCPIconButtonItemAttr2.pageDidAppearTimes$delegate.setValue(gCPIconButtonItemAttr2, GCPIconButtonItemAttr.$$delegatedProperties[0], Integer.valueOf(((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPIconButtonListAttr.$$delegatedProperties[1])).intValue()));
                                                if (gCPIconButtonItemAttr2.index == 0) {
                                                    gCPIconButtonItemAttr2.marginLeft(16.0f);
                                                } else {
                                                    gCPIconButtonItemAttr2.marginLeft(24.0f);
                                                }
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GCPIconButtonListAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
