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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class GCPActivityEntranceBar extends ComposeView<GCPActivityEntranceBarAttr, l> {
    public final GCPActivityEntranceBarAttr viewAttr = new GCPActivityEntranceBarAttr();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPActivityEntranceBarAttr access$getAttr(GCPActivityEntranceBar gCPActivityEntranceBar) {
        return (GCPActivityEntranceBarAttr) gCPActivityEntranceBar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GCPActivityEntranceBar gCPActivityEntranceBar = GCPActivityEntranceBar.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceBar$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentSpaceBetween();
                        if (GCPActivityEntranceBar.this.viewAttr.getDataList().size() == 3) {
                            mVar2.marginLeft(38.5f);
                            mVar2.marginRight(38.5f);
                        } else {
                            mVar2.marginLeft(22.7f);
                            mVar2.marginRight(22.7f);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final GCPActivityEntranceBar gCPActivityEntranceBar2 = GCPActivityEntranceBar.this;
                Function0<c<IconButton>> function0 = new Function0<c<IconButton>>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceBar$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final c<IconButton> invoke() {
                        return GCPActivityEntranceBar.access$getAttr(GCPActivityEntranceBar.this).getDataList();
                    }
                };
                final GCPActivityEntranceBar gCPActivityEntranceBar3 = GCPActivityEntranceBar.this;
                LoopDirectivesViewKt.a(viewContainer2, function0, new Function2<LoopDirectivesView<IconButton>, IconButton, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceBar$body$1.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(LoopDirectivesView<IconButton> loopDirectivesView, IconButton iconButton) {
                        final IconButton iconButton2 = iconButton;
                        final GCPActivityEntranceBar gCPActivityEntranceBar4 = GCPActivityEntranceBar.this;
                        loopDirectivesView.addChild(new GCPActivityEntranceItem(), new Function1<GCPActivityEntranceItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceBar.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPActivityEntranceItem gCPActivityEntranceItem) {
                                final IconButton iconButton3 = IconButton.this;
                                final GCPActivityEntranceBar gCPActivityEntranceBar5 = gCPActivityEntranceBar4;
                                gCPActivityEntranceItem.attr(new Function1<GCPActivityEntranceItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceBar.body.1.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPActivityEntranceItemAttr gCPActivityEntranceItemAttr) {
                                        GCPActivityEntranceItemAttr gCPActivityEntranceItemAttr2 = gCPActivityEntranceItemAttr;
                                        gCPActivityEntranceItemAttr2.activityData = IconButton.this;
                                        gCPActivityEntranceItemAttr2.index = GCPActivityEntranceBar.access$getAttr(gCPActivityEntranceBar5).getDataList().indexOf(IconButton.this);
                                        gCPActivityEntranceItemAttr2.gameTab = GCPActivityEntranceBar.access$getAttr(gCPActivityEntranceBar5).gameTab;
                                        GCPActivityEntranceBarAttr access$getAttr = GCPActivityEntranceBar.access$getAttr(gCPActivityEntranceBar5);
                                        gCPActivityEntranceItemAttr2.pageDidAppearTimes$delegate.setValue(gCPActivityEntranceItemAttr2, GCPActivityEntranceItemAttr.$$delegatedProperties[0], Integer.valueOf(((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPActivityEntranceBarAttr.$$delegatedProperties[1])).intValue()));
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
