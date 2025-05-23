package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCardBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.IconButton;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.NavigationBlock;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GCPContentBannerView extends ComposeView<GCPContentBanneAttr, l> {
    public final GCPContentBanneAttr viewAttr = new GCPContentBanneAttr();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPContentBanneAttr access$getAttr(GCPContentBannerView gCPContentBannerView) {
        return (GCPContentBanneAttr) gCPContentBannerView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        AttrExtKt.backgroundColorToken(mVar2, "qecommerce_skin_color_bg_default");
                        return Unit.INSTANCE;
                    }
                });
                final GCPContentBannerView gCPContentBannerView = GCPContentBannerView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GCPContentBanneAttr access$getAttr = GCPContentBannerView.access$getAttr(GCPContentBannerView.this);
                        GameCardBlock gameCardBlock = (GameCardBlock) access$getAttr.gameActivityData$delegate.getValue(access$getAttr, GCPContentBanneAttr.$$delegatedProperties[1]);
                        if (gameCardBlock != null) {
                            return gameCardBlock.gameCards;
                        }
                        return null;
                    }
                };
                final GCPContentBannerView gCPContentBannerView2 = GCPContentBannerView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final GCPContentBannerView gCPContentBannerView3 = GCPContentBannerView.this;
                        bindDirectivesView.addChild(new GCPGameActivityPageList(), new Function1<GCPGameActivityPageList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPGameActivityPageList gCPGameActivityPageList) {
                                final GCPContentBannerView gCPContentBannerView4 = GCPContentBannerView.this;
                                gCPGameActivityPageList.attr(new Function1<GCPGameActivityViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPGameActivityViewAttr gCPGameActivityViewAttr) {
                                        GCPGameActivityViewAttr gCPGameActivityViewAttr2 = gCPGameActivityViewAttr;
                                        GCPContentBanneAttr access$getAttr = GCPContentBannerView.access$getAttr(GCPContentBannerView.this);
                                        GameCardBlock gameCardBlock = (GameCardBlock) access$getAttr.gameActivityData$delegate.getValue(access$getAttr, GCPContentBanneAttr.$$delegatedProperties[1]);
                                        Intrinsics.checkNotNull(gameCardBlock);
                                        List<GameCard> list = gameCardBlock.gameCards;
                                        Intrinsics.checkNotNull(list);
                                        gCPGameActivityViewAttr2.getDataList().clear();
                                        if (list != null) {
                                            Iterator<GameCard> it = list.iterator();
                                            while (it.hasNext()) {
                                                gCPGameActivityViewAttr2.getDataList().add(it.next());
                                            }
                                        }
                                        gCPGameActivityViewAttr2.gameTab = GCPContentBannerView.access$getAttr(GCPContentBannerView.this).gameTab;
                                        GCPContentBanneAttr access$getAttr2 = GCPContentBannerView.access$getAttr(GCPContentBannerView.this);
                                        gCPGameActivityViewAttr2.pageDidAppearTimes$delegate.setValue(gCPGameActivityViewAttr2, GCPGameActivityViewAttr.$$delegatedProperties[1], Integer.valueOf(((Number) access$getAttr2.pageDidAppearTimes$delegate.getValue(access$getAttr2, GCPContentBanneAttr.$$delegatedProperties[2])).intValue()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPContentBannerView gCPContentBannerView3 = GCPContentBannerView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GCPContentBanneAttr access$getAttr = GCPContentBannerView.access$getAttr(GCPContentBannerView.this);
                        NavigationBlock navigationBlock = (NavigationBlock) access$getAttr.entranceData$delegate.getValue(access$getAttr, GCPContentBanneAttr.$$delegatedProperties[0]);
                        return Boolean.valueOf((navigationBlock != null ? navigationBlock.iconButtons : null) != null);
                    }
                };
                final GCPContentBannerView gCPContentBannerView4 = GCPContentBannerView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GCPContentBannerView gCPContentBannerView5 = GCPContentBannerView.this;
                        conditionView.addChild(new GCPActivityEntranceBar(), new Function1<GCPActivityEntranceBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPActivityEntranceBar gCPActivityEntranceBar) {
                                final GCPContentBannerView gCPContentBannerView6 = GCPContentBannerView.this;
                                gCPActivityEntranceBar.attr(new Function1<GCPActivityEntranceBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPActivityEntranceBarAttr gCPActivityEntranceBarAttr) {
                                        GCPActivityEntranceBarAttr gCPActivityEntranceBarAttr2 = gCPActivityEntranceBarAttr;
                                        GCPContentBanneAttr access$getAttr = GCPContentBannerView.access$getAttr(GCPContentBannerView.this);
                                        NavigationBlock navigationBlock = (NavigationBlock) access$getAttr.entranceData$delegate.getValue(access$getAttr, GCPContentBanneAttr.$$delegatedProperties[0]);
                                        Intrinsics.checkNotNull(navigationBlock);
                                        List<IconButton> list = navigationBlock.iconButtons;
                                        Intrinsics.checkNotNull(list);
                                        gCPActivityEntranceBarAttr2.getDataList().clear();
                                        if (list != null) {
                                            Iterator<IconButton> it = list.iterator();
                                            while (it.hasNext()) {
                                                gCPActivityEntranceBarAttr2.getDataList().add(it.next());
                                            }
                                        }
                                        gCPActivityEntranceBarAttr2.gameTab = GCPContentBannerView.access$getAttr(GCPContentBannerView.this).gameTab;
                                        GCPContentBanneAttr access$getAttr2 = GCPContentBannerView.access$getAttr(GCPContentBannerView.this);
                                        gCPActivityEntranceBarAttr2.pageDidAppearTimes$delegate.setValue(gCPActivityEntranceBarAttr2, GCPActivityEntranceBarAttr.$$delegatedProperties[1], Integer.valueOf(((Number) access$getAttr2.pageDidAppearTimes$delegate.getValue(access$getAttr2, GCPContentBanneAttr.$$delegatedProperties[2])).intValue()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView$body$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(8.0f);
                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_backplate");
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
