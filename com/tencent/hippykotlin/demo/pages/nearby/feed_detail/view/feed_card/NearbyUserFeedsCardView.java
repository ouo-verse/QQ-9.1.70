package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedTimelineItemViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.views.av;
import com.tencent.kuikly.core.views.aw;
import com.tencent.kuikly.core.views.ax;
import com.tencent.kuikly.core.views.ay;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyUserFeedsCardView extends ComposeView<NearbyUserFeedsAttr, NearbyUserFeedsEvent> implements c {
    public static final /* synthetic */ int $r8$clinit = 0;
    public aa<NearbyFDPStatusContentView> contentViewRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyUserFeedsAttr access$getAttr(NearbyUserFeedsCardView nearbyUserFeedsCardView) {
        return (NearbyUserFeedsAttr) nearbyUserFeedsCardView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NearbyUserFeedsCardView nearbyUserFeedsCardView = NearbyUserFeedsCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.absolutePosition(5.0f, 5.0f, 5.0f, 5.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyUserFeedsCardView nearbyUserFeedsCardView2 = NearbyUserFeedsCardView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                final NearbyUserFeedsCardView nearbyUserFeedsCardView3 = NearbyUserFeedsCardView.this;
                                VisibilityEventKt.f(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NearbyUserFeedsCardView nearbyUserFeedsCardView4 = NearbyUserFeedsCardView.this;
                                        int i3 = NearbyUserFeedsCardView.$r8$clinit;
                                        nearbyUserFeedsCardView4.cardDisAppear();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsCardView nearbyUserFeedsCardView4 = NearbyUserFeedsCardView.this;
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.1.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        u.this.getPager().addPagerEventObserver(nearbyUserFeedsCardView4);
                                        NearbyUserFeedsCardView nearbyUserFeedsCardView5 = nearbyUserFeedsCardView4;
                                        int i3 = NearbyUserFeedsCardView.$r8$clinit;
                                        nearbyUserFeedsCardView5.cardAppear();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsCardView nearbyUserFeedsCardView5 = NearbyUserFeedsCardView.this;
                                VisibilityEventKt.c(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.1.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        u.this.getPager().removePagerEventObserver(nearbyUserFeedsCardView5);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyUserFeedsCardView nearbyUserFeedsCardView2 = NearbyUserFeedsCardView.this;
                viewContainer2.addChild(new NearbyUserFeedsTopBarView(), new Function1<NearbyUserFeedsTopBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView) {
                        final NearbyUserFeedsCardView nearbyUserFeedsCardView3 = NearbyUserFeedsCardView.this;
                        nearbyUserFeedsTopBarView.attr(new Function1<NearbyUserFeedsTopBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyUserFeedsTopBarAttr nearbyUserFeedsTopBarAttr) {
                                NearbyUserFeedsTopBarAttr nearbyUserFeedsTopBarAttr2 = nearbyUserFeedsTopBarAttr;
                                nearbyUserFeedsTopBarAttr2.viewModel = NearbyUserFeedsCardView.access$getAttr(NearbyUserFeedsCardView.this).getViewModel();
                                nearbyUserFeedsTopBarAttr2.dtReporter = NearbyUserFeedsCardView.access$getAttr(NearbyUserFeedsCardView.this).dtReporter;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyUserFeedsCardView nearbyUserFeedsCardView3 = NearbyUserFeedsCardView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NearbyUserFeedsCardView.access$getAttr(NearbyUserFeedsCardView.this).getViewModel().getContentModel() != null);
                    }
                };
                final NearbyUserFeedsCardView nearbyUserFeedsCardView4 = NearbyUserFeedsCardView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsCardView.access$getAttr(NearbyUserFeedsCardView.this).getViewModel().getContentModel();
                        Intrinsics.checkNotNull(contentModel);
                        final NearbyUserFeedsCardView nearbyUserFeedsCardView5 = NearbyUserFeedsCardView.this;
                        conditionView2.addChild(new NearbyFDPStatusContentView(), new Function1<NearbyFDPStatusContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyFDPStatusContentView nearbyFDPStatusContentView) {
                                NearbyFDPStatusContentView nearbyFDPStatusContentView2 = nearbyFDPStatusContentView;
                                final NearbyUserFeedsCardView nearbyUserFeedsCardView6 = NearbyUserFeedsCardView.this;
                                nearbyFDPStatusContentView2.ref(nearbyFDPStatusContentView2, new Function1<aa<NearbyFDPStatusContentView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<NearbyFDPStatusContentView> aaVar) {
                                        NearbyUserFeedsCardView.this.contentViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel = contentModel;
                                final NearbyUserFeedsCardView nearbyUserFeedsCardView7 = NearbyUserFeedsCardView.this;
                                nearbyFDPStatusContentView2.attr(new Function1<NearbyFDPStatusContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NearbyFDPStatusContentAttr nearbyFDPStatusContentAttr) {
                                        NearbyFDPStatusContentAttr nearbyFDPStatusContentAttr2 = nearbyFDPStatusContentAttr;
                                        NearbyFDPStatusContentViewModel statusContentViewModel = NearbyFDPUserFeedTimelineItemViewModel.this.getStatusContentViewModel();
                                        ReadWriteProperty readWriteProperty = nearbyFDPStatusContentAttr2.viewModel$delegate;
                                        KProperty<?>[] kPropertyArr = NearbyFDPStatusContentAttr.$$delegatedProperties;
                                        readWriteProperty.setValue(nearbyFDPStatusContentAttr2, kPropertyArr[0], statusContentViewModel);
                                        nearbyFDPStatusContentAttr2.cardViewModel$delegate.setValue(nearbyFDPStatusContentAttr2, kPropertyArr[1], NearbyUserFeedsCardView.access$getAttr(nearbyUserFeedsCardView7).getViewModel());
                                        nearbyFDPStatusContentAttr2.dtReporter = NearbyUserFeedsCardView.access$getAttr(nearbyUserFeedsCardView7).dtReporter;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ConditionViewKt.c(conditionView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPLikeData nBPLikeData;
                                NearbyFDPStatusContentViewModel statusContentViewModel = NearbyFDPUserFeedTimelineItemViewModel.this.getStatusContentViewModel();
                                if (statusContentViewModel == null || (nBPLikeData = statusContentViewModel.likeData) == null) {
                                    return null;
                                }
                                return Boolean.valueOf(nBPLikeData.getDoubleClickAnimation());
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                final NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel = NearbyFDPUserFeedTimelineItemViewModel.this;
                                ay.a(conditionView3, new Function1<ax, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ax axVar) {
                                        ax axVar2 = axVar;
                                        final NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel2 = NearbyFDPUserFeedTimelineItemViewModel.this;
                                        axVar2.attr(new Function1<av, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(av avVar) {
                                                NBPLikeData nBPLikeData;
                                                ClickLocation clickLocation;
                                                av avVar2 = avVar;
                                                avVar2.positionAbsolute();
                                                NearbyFDPStatusContentViewModel statusContentViewModel = NearbyFDPUserFeedTimelineItemViewModel.this.getStatusContentViewModel();
                                                if (statusContentViewModel != null && (nBPLikeData = statusContentViewModel.likeData) != null && (clickLocation = nBPLikeData.doubleClickLocation) != null) {
                                                    avVar2.m142left(clickLocation.f114210x - 53.5f);
                                                    avVar2.m150top(clickLocation.f114211y - 67.5f);
                                                }
                                                avVar2.src("https://image.superqqshow.qq.com/files/3c6784d9_ZBp37qLwtTO.json");
                                                avVar2.size(107.0f, 135.0f);
                                                avVar2.m154zIndex(1);
                                                avVar2.transform(new com.tencent.kuikly.core.base.t(Random.INSTANCE.nextInt(-10, 11), 0.0f, 0.0f, 6, null));
                                                avVar2.h(false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel3 = NearbyFDPUserFeedTimelineItemViewModel.this;
                                        axVar2.event(new Function1<aw, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.3.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aw awVar) {
                                                aw awVar2 = awVar;
                                                final NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel4 = NearbyFDPUserFeedTimelineItemViewModel.this;
                                                FrameEventKt.g(awVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.3.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPLikeData nBPLikeData;
                                                        NearbyFDPStatusContentViewModel statusContentViewModel = NearbyFDPUserFeedTimelineItemViewModel.this.getStatusContentViewModel();
                                                        if (statusContentViewModel != null && (nBPLikeData = statusContentViewModel.likeData) != null) {
                                                            nBPLikeData.setDoubleClickAnimation(false);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel5 = NearbyFDPUserFeedTimelineItemViewModel.this;
                                                awVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.4.3.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPLikeData nBPLikeData;
                                                        NearbyFDPStatusContentViewModel statusContentViewModel = NearbyFDPUserFeedTimelineItemViewModel.this.getStatusContentViewModel();
                                                        if (statusContentViewModel != null && (nBPLikeData = statusContentViewModel.likeData) != null) {
                                                            nBPLikeData.setDoubleClickAnimation(false);
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
                });
                final NearbyUserFeedsCardView nearbyUserFeedsCardView5 = NearbyUserFeedsCardView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NearbyUserFeedsCardView nearbyUserFeedsCardView6 = NearbyUserFeedsCardView.this;
                        event.doubleClick(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NearbyFDPStatusContentViewModel statusContentViewModel;
                                ClickParams clickParams2 = clickParams;
                                NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsCardView.access$getAttr(NearbyUserFeedsCardView.this).getViewModel().getContentModel();
                                if (contentModel != null && (statusContentViewModel = contentModel.getStatusContentViewModel()) != null) {
                                    statusContentViewModel.onClickLikeBtn(true, new ClickLocation(clickParams2.getX(), clickParams2.getY()).getTargetLocation(NearbyUserFeedsCardView.this, Reflection.getOrCreateKotlinClass(NearbyUserFeedsCardView.class)));
                                }
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>>, java.util.ArrayList] */
    public final void cardAppear() {
        List list;
        NearbyFDPStatusContentView b16;
        NearbyFDPageViewModel pageModel;
        String str;
        NearbyFDPUserFeedsCardViewModel viewModel = ((NearbyUserFeedsAttr) getAttr()).getViewModel();
        viewModel.cardDidAppear$delegate.setValue(viewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[7], Boolean.TRUE);
        list = CollectionsKt___CollectionsKt.toList(viewModel.cardDidAppearLazyTask);
        viewModel.cardDidAppearLazyTask.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
        b pager = getPager();
        NearbyFeedDetailPage nearbyFeedDetailPage = pager instanceof NearbyFeedDetailPage ? (NearbyFeedDetailPage) pager : null;
        if (nearbyFeedDetailPage != null && (pageModel = nearbyFeedDetailPage.getPageModel()) != null) {
            NearbyFDPUserFeedsCardViewModel viewModel2 = ((NearbyUserFeedsAttr) getAttr()).getViewModel();
            int i3 = pageModel.lastDidAppearCardIndex;
            int i16 = viewModel2.index;
            if (i3 != i16) {
                if (i16 > i3) {
                    str = "up";
                } else {
                    str = "down";
                }
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_footprint_slide", AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("nearby_action_id", str, DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"));
            }
            pageModel.lastDidAppearCardIndex = viewModel2.index;
        }
        aa<NearbyFDPStatusContentView> aaVar = this.contentViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null || !b16.cardDidAppear) {
            return;
        }
        b16.cardDidAppear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void cardDisAppear() {
        NearbyFDPUserFeedsCardViewModel viewModel = ((NearbyUserFeedsAttr) getAttr()).getViewModel();
        viewModel.cardDidAppear$delegate.setValue(viewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[7], Boolean.FALSE);
        aa<NearbyFDPStatusContentView> aaVar = this.contentViewRef;
        if (aaVar != null) {
            aaVar.b();
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyUserFeedsAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyUserFeedsEvent();
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_DID_APPEAR)) {
            cardAppear();
        } else if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_DID_DISAPPEAR)) {
            cardDisAppear();
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }
}
