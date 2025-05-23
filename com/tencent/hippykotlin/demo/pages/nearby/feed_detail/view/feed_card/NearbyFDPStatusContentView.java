package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.ReportReadFeedsRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.l;
import r25.e;

/* loaded from: classes31.dex */
public final class NearbyFDPStatusContentView extends ComposeView<NearbyFDPStatusContentAttr, NearbyFDPStatusContentEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentView.class, "cardWillAppear", "getCardWillAppear()Z", 0)};
    public boolean cardDidAppear;
    public final ReadWriteProperty cardWillAppear$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyFDPStatusContentAttr access$getAttr(NearbyFDPStatusContentView nearbyFDPStatusContentView) {
        return (NearbyFDPStatusContentAttr) nearbyFDPStatusContentView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NearbyFDPStatusContentView nearbyFDPStatusContentView = NearbyFDPStatusContentView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final NearbyFDPStatusContentView nearbyFDPStatusContentView2 = NearbyFDPStatusContentView.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                String str;
                                String str2;
                                NearbyFDPStatusContentViewModel viewModel = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                if (viewModel != null) {
                                    NearbyFDPUserFeedsCardViewModel cardViewModel = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getCardViewModel();
                                    viewModel.onClickCardContent(cardViewModel != null ? Boolean.valueOf(((Boolean) cardViewModel.showGreetingBtn$delegate.getValue(cardViewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[3])).booleanValue()) : null);
                                }
                                INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).dtReporter;
                                if (iNearbyFeedDetailDTReporter != null) {
                                    NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                    if (viewModel2 == null || (str = viewModel2.getFeedID()) == null) {
                                        str = "";
                                    }
                                    NearbyFDPUserFeedsCardViewModel cardViewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getCardViewModel();
                                    if (cardViewModel2 == null || (str2 = Long.valueOf(cardViewModel2.getTinyId()).toString()) == null) {
                                        str2 = "";
                                    }
                                    iNearbyFeedDetailDTReporter.dtReportElementClick(str, str2, "em_nearby_dynamic", false);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPStatusContentView nearbyFDPStatusContentView3 = NearbyFDPStatusContentView.this;
                        event2.doubleClick(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                ClickParams clickParams2 = clickParams;
                                NearbyFDPStatusContentViewModel viewModel = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                if (viewModel != null) {
                                    viewModel.onClickLikeBtn(true, new ClickLocation(clickParams2.getX(), clickParams2.getY()).getTargetLocation(NearbyFDPStatusContentView.this, Reflection.getOrCreateKotlinClass(NearbyUserFeedsCardView.class)));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPStatusContentView nearbyFDPStatusContentView4 = NearbyFDPStatusContentView.this;
                        event2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LongPressParams longPressParams) {
                                l statusFeed;
                                NearbyFDPUserFeedsCardViewModel cardViewModel;
                                Function1<l, Unit> function1;
                                NearbyFDPStatusContentViewModel viewModel = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                if (viewModel != null && (statusFeed = viewModel.getStatusFeed()) != null && (cardViewModel = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getCardViewModel()) != null && (function1 = cardViewModel.onShowFeedActionSheet) != null) {
                                    function1.invoke(statusFeed);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFDPStatusContentView nearbyFDPStatusContentView2 = NearbyFDPStatusContentView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.absolutePosition(5.0f, 5.0f, 5.0f, 5.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPStatusContentView nearbyFDPStatusContentView3 = NearbyFDPStatusContentView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NearbyFDPStatusContentView nearbyFDPStatusContentView4 = NearbyFDPStatusContentView.this;
                                VisibilityEventKt.f(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NearbyFDPStatusContentView.this.cardDidAppear = false;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPStatusContentView nearbyFDPStatusContentView5 = NearbyFDPStatusContentView.this;
                                VisibilityEventKt.c(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NearbyFDPStatusContentView nearbyFDPStatusContentView6 = NearbyFDPStatusContentView.this;
                                        nearbyFDPStatusContentView6.cardWillAppear$delegate.setValue(nearbyFDPStatusContentView6, NearbyFDPStatusContentView.$$delegatedProperties[0], Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPStatusContentView nearbyFDPStatusContentView6 = NearbyFDPStatusContentView.this;
                                VisibilityEventKt.e(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NearbyFDPStatusContentView nearbyFDPStatusContentView7 = NearbyFDPStatusContentView.this;
                                        nearbyFDPStatusContentView7.cardWillAppear$delegate.setValue(nearbyFDPStatusContentView7, NearbyFDPStatusContentView.$$delegatedProperties[0], Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPStatusContentView nearbyFDPStatusContentView7 = NearbyFDPStatusContentView.this;
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.2.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        String str;
                                        String l3;
                                        NearbyFDPStatusContentView nearbyFDPStatusContentView8 = NearbyFDPStatusContentView.this;
                                        nearbyFDPStatusContentView8.cardDidAppear = true;
                                        nearbyFDPStatusContentView8.cardDidAppear();
                                        INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).dtReporter;
                                        if (iNearbyFeedDetailDTReporter != null) {
                                            NearbyFDPStatusContentViewModel viewModel = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                            String str2 = "";
                                            if (viewModel == null || (str = viewModel.getFeedID()) == null) {
                                                str = "";
                                            }
                                            NearbyFDPUserFeedsCardViewModel cardViewModel = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getCardViewModel();
                                            if (cardViewModel != null && (l3 = Long.valueOf(cardViewModel.getTinyId()).toString()) != null) {
                                                str2 = l3;
                                            }
                                            iNearbyFeedDetailDTReporter.dtReportElementImp(str, str2, "em_nearby_dynamic", false);
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
                final NearbyFDPStatusContentView nearbyFDPStatusContentView3 = NearbyFDPStatusContentView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginLeft(16.0f);
                                tVar2.marginRight(16.0f);
                                tVar2.marginBottom(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        NearbyFDPStatusContentViewModel viewModel = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                        boolean z16 = false;
                        if (viewModel != null) {
                            if (viewModel.getStatusImageIndexNode() != null) {
                                z16 = true;
                            }
                        }
                        if (z16) {
                            final NearbyFDPStatusContentView nearbyFDPStatusContentView4 = NearbyFDPStatusContentView.this;
                            vVar2.addChild(new NearbyImageContentView(), new Function1<NearbyImageContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NearbyImageContentView nearbyImageContentView) {
                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView5 = NearbyFDPStatusContentView.this;
                                    final float f16 = 16.0f;
                                    nearbyImageContentView.attr(new Function1<NearbyImageContentViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NearbyImageContentViewAttr nearbyImageContentViewAttr) {
                                            NearbyImageContentViewAttr nearbyImageContentViewAttr2 = nearbyImageContentViewAttr;
                                            float m3 = nearbyImageContentViewAttr2.getPagerData().m() - (f16 * 2.0f);
                                            ReadWriteProperty readWriteProperty = nearbyImageContentViewAttr2.contentWidth$delegate;
                                            KProperty<?>[] kPropertyArr = NearbyImageContentViewAttr.$$delegatedProperties;
                                            readWriteProperty.setValue(nearbyImageContentViewAttr2, kPropertyArr[0], Float.valueOf(m3));
                                            nearbyImageContentViewAttr2.viewModel$delegate.setValue(nearbyImageContentViewAttr2, kPropertyArr[1], NearbyFDPStatusContentView.access$getAttr(nearbyFDPStatusContentView5).getViewModel());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFDPStatusContentView nearbyFDPStatusContentView5 = NearbyFDPStatusContentView.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            Attr.absolutePosition$default(tVar, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView6 = NearbyFDPStatusContentView.this;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionRow();
                                                    tVar2.alignItemsFlexEnd();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView7 = NearbyFDPStatusContentView.this;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    v vVar8 = vVar7;
                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.m140flex(1.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView8 = NearbyFDPStatusContentView.this;
                                                    vVar8.addChild(new NearbyFDPContentTitleView(), new Function1<NearbyFDPContentTitleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NearbyFDPContentTitleView nearbyFDPContentTitleView) {
                                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView9 = NearbyFDPStatusContentView.this;
                                                            nearbyFDPContentTitleView.attr(new Function1<NearbyFDPContentTitleViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NearbyFDPContentTitleViewAttr nearbyFDPContentTitleViewAttr) {
                                                                    NearbyFDPContentTitleViewAttr nearbyFDPContentTitleViewAttr2 = nearbyFDPContentTitleViewAttr;
                                                                    nearbyFDPContentTitleViewAttr2.marginBottom(8.0f);
                                                                    nearbyFDPContentTitleViewAttr2.marginLeft(16.0f);
                                                                    ReadWriteProperty readWriteProperty = nearbyFDPContentTitleViewAttr2.isDarkStyle$delegate;
                                                                    KProperty<?>[] kPropertyArr = NearbyFDPContentTitleViewAttr.$$delegatedProperties;
                                                                    readWriteProperty.setValue(nearbyFDPContentTitleViewAttr2, kPropertyArr[1], Boolean.FALSE);
                                                                    nearbyFDPContentTitleViewAttr2.viewModel$delegate.setValue(nearbyFDPContentTitleViewAttr2, kPropertyArr[0], NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel());
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView9 = NearbyFDPStatusContentView.this;
                                                    vVar8.addChild(new NearbyContentTagsView(), new Function1<NearbyContentTagsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.2.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NearbyContentTagsView nearbyContentTagsView) {
                                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView10 = NearbyFDPStatusContentView.this;
                                                            nearbyContentTagsView.attr(new Function1<NearbyContentTagsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.2.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NearbyContentTagsAttr nearbyContentTagsAttr) {
                                                                    NearbyContentTagsAttr nearbyContentTagsAttr2 = nearbyContentTagsAttr;
                                                                    nearbyContentTagsAttr2.marginLeft(16.0f);
                                                                    NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                    if (viewModel2 != null) {
                                                                        nearbyContentTagsAttr2.viewModel$delegate.setValue(nearbyContentTagsAttr2, NearbyContentTagsAttr.$$delegatedProperties[0], viewModel2);
                                                                    }
                                                                    nearbyContentTagsAttr2.isDarkStyle = false;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView8 = NearbyFDPStatusContentView.this;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    v vVar8 = vVar7;
                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo153width(80.0f);
                                                            tVar2.mo141height(80.0f);
                                                            tVar2.marginLeft(16.0f);
                                                            tVar2.marginRight(10.0f);
                                                            tVar2.allCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView9 = NearbyFDPStatusContentView.this;
                                                    NearbyContentFeedAvatarViewKt.NearbyContentFeedAvatar(vVar8, new Function1<NearbyFDPContentFeedAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView) {
                                                            NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView2 = nearbyFDPContentFeedAvatarView;
                                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView10 = NearbyFDPStatusContentView.this;
                                                            nearbyFDPContentFeedAvatarView2.ref(nearbyFDPContentFeedAvatarView2, new Function1<aa<NearbyFDPContentFeedAvatarView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(aa<NearbyFDPContentFeedAvatarView> aaVar) {
                                                                    NearbyFDPStatusContentView nearbyFDPStatusContentView11 = NearbyFDPStatusContentView.this;
                                                                    KProperty<Object>[] kPropertyArr = NearbyFDPStatusContentView.$$delegatedProperties;
                                                                    nearbyFDPStatusContentView11.getClass();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView11 = NearbyFDPStatusContentView.this;
                                                            nearbyFDPContentFeedAvatarView2.attr(new Function1<NearbyFDPContentFeedAvatarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.3.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
                                                                
                                                                    if (r0.K == 1) goto L18;
                                                                 */
                                                                @Override // kotlin.jvm.functions.Function1
                                                                /*
                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                */
                                                                public final Unit invoke(NearbyFDPContentFeedAvatarViewAttr nearbyFDPContentFeedAvatarViewAttr) {
                                                                    boolean z17;
                                                                    l statusFeed;
                                                                    e eVar;
                                                                    l statusFeed2;
                                                                    l statusFeed3;
                                                                    NearbyFDPContentFeedAvatarViewAttr nearbyFDPContentFeedAvatarViewAttr2 = nearbyFDPContentFeedAvatarViewAttr;
                                                                    NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                    nearbyFDPContentFeedAvatarViewAttr2.setFilamentResource((viewModel2 == null || (statusFeed3 = viewModel2.getStatusFeed()) == null) ? null : statusFeed3.f418095h);
                                                                    NearbyFDPStatusContentViewModel viewModel3 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                    if (viewModel3 != null && (statusFeed2 = viewModel3.getStatusFeed()) != null && (r0 = statusFeed2.f418093e) != null) {
                                                                        z17 = true;
                                                                    }
                                                                    z17 = false;
                                                                    nearbyFDPContentFeedAvatarViewAttr2.setMale(z17);
                                                                    NearbyFDPStatusContentViewModel viewModel4 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                    nearbyFDPContentFeedAvatarViewAttr2.setTinyId((viewModel4 == null || (statusFeed = viewModel4.getStatusFeed()) == null || (eVar = statusFeed.f418093e) == null) ? 0L : eVar.f430610d);
                                                                    nearbyFDPContentFeedAvatarViewAttr2.size(100.0f, 100.0f);
                                                                    NearbyFDPStatusContentView nearbyFDPStatusContentView12 = NearbyFDPStatusContentView.this;
                                                                    nearbyFDPContentFeedAvatarViewAttr2.setLoadAvatarView(((Boolean) nearbyFDPStatusContentView12.cardWillAppear$delegate.getValue(nearbyFDPStatusContentView12, NearbyFDPStatusContentView.$$delegatedProperties[0])).booleanValue());
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView12 = NearbyFDPStatusContentView.this;
                                                            nearbyFDPContentFeedAvatarView2.event(new Function1<NearbyFDPContentFeedAvatarViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.3.2.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NearbyFDPContentFeedAvatarViewEvent nearbyFDPContentFeedAvatarViewEvent) {
                                                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView13 = NearbyFDPStatusContentView.this;
                                                                    nearbyFDPContentFeedAvatarViewEvent.clickHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.2.3.2.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(Object obj) {
                                                                            KLog kLog = KLog.INSTANCE;
                                                                            NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                                                            kLog.i("feed_detail_page", "singleClick to enter detail");
                                                                            NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                            if (viewModel2 != null) {
                                                                                KProperty<Object>[] kPropertyArr = NearbyFDPStatusContentViewModel.$$delegatedProperties;
                                                                                viewModel2.onClickCardContent(Boolean.FALSE);
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
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView7 = NearbyFDPStatusContentView.this;
                                    vVar4.addChild(new NearbyContentInteractionView(), new Function1<NearbyContentInteractionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NearbyContentInteractionView nearbyContentInteractionView) {
                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView8 = NearbyFDPStatusContentView.this;
                                            nearbyContentInteractionView.attr(new Function1<NearbyContentInteractionViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.3.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NearbyContentInteractionViewAttr nearbyContentInteractionViewAttr) {
                                                    NearbyContentInteractionViewAttr nearbyContentInteractionViewAttr2 = nearbyContentInteractionViewAttr;
                                                    nearbyContentInteractionViewAttr2.marginTop(8.0f);
                                                    nearbyContentInteractionViewAttr2.mo141height(48.0f);
                                                    NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                    ReadWriteProperty readWriteProperty = nearbyContentInteractionViewAttr2.viewModel$delegate;
                                                    KProperty<?>[] kPropertyArr = NearbyContentInteractionViewAttr.$$delegatedProperties;
                                                    readWriteProperty.setValue(nearbyContentInteractionViewAttr2, kPropertyArr[0], viewModel2);
                                                    nearbyContentInteractionViewAttr2.cardViewModel$delegate.setValue(nearbyContentInteractionViewAttr2, kPropertyArr[1], NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getCardViewModel());
                                                    nearbyContentInteractionViewAttr2.isDarkStyle = false;
                                                    nearbyContentInteractionViewAttr2.dtReporter = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).dtReporter;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            final NearbyFDPStatusContentView nearbyFDPStatusContentView6 = NearbyFDPStatusContentView.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo113backgroundColor(new h(4293915903L));
                                            tVar2.borderRadius(8.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    Attr.absolutePosition$default(afVar2, 24.0f, 16.0f, 0.0f, 0.0f, 12, null);
                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_eBOVl8UjRq6.png", false, 2, null);
                                                    afVar2.size(48.0f, 44.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView7 = NearbyFDPStatusContentView.this;
                                    vVar4.addChild(new NearbyFDPContentTitleView(), new Function1<NearbyFDPContentTitleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NearbyFDPContentTitleView nearbyFDPContentTitleView) {
                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView8 = NearbyFDPStatusContentView.this;
                                            nearbyFDPContentTitleView.attr(new Function1<NearbyFDPContentTitleViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NearbyFDPContentTitleViewAttr nearbyFDPContentTitleViewAttr) {
                                                    NearbyFDPContentTitleViewAttr nearbyFDPContentTitleViewAttr2 = nearbyFDPContentTitleViewAttr;
                                                    nearbyFDPContentTitleViewAttr2.marginBottom(-8.0f);
                                                    nearbyFDPContentTitleViewAttr2.marginLeft(16.0f);
                                                    nearbyFDPContentTitleViewAttr2.marginTop(48.0f);
                                                    ReadWriteProperty readWriteProperty = nearbyFDPContentTitleViewAttr2.isDarkStyle$delegate;
                                                    KProperty<?>[] kPropertyArr = NearbyFDPContentTitleViewAttr.$$delegatedProperties;
                                                    readWriteProperty.setValue(nearbyFDPContentTitleViewAttr2, kPropertyArr[1], Boolean.TRUE);
                                                    nearbyFDPContentTitleViewAttr2.viewModel$delegate.setValue(nearbyFDPContentTitleViewAttr2, kPropertyArr[0], NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView8 = NearbyFDPStatusContentView.this;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionRow();
                                                    tVar2.alignItemsFlexEnd();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView9 = NearbyFDPStatusContentView.this;
                                            vVar6.addChild(new NearbyContentTagsView(), new Function1<NearbyContentTagsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NearbyContentTagsView nearbyContentTagsView) {
                                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView10 = NearbyFDPStatusContentView.this;
                                                    nearbyContentTagsView.attr(new Function1<NearbyContentTagsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NearbyContentTagsAttr nearbyContentTagsAttr) {
                                                            NearbyContentTagsAttr nearbyContentTagsAttr2 = nearbyContentTagsAttr;
                                                            nearbyContentTagsAttr2.marginLeft(16.0f);
                                                            nearbyContentTagsAttr2.m140flex(1.0f);
                                                            nearbyContentTagsAttr2.isDarkStyle = true;
                                                            NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                            if (viewModel2 != null) {
                                                                nearbyContentTagsAttr2.viewModel$delegate.setValue(nearbyContentTagsAttr2, NearbyContentTagsAttr.$$delegatedProperties[0], viewModel2);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView10 = NearbyFDPStatusContentView.this;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    v vVar8 = vVar7;
                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo153width(80.0f);
                                                            tVar2.mo141height(80.0f);
                                                            tVar2.marginLeft(15.0f);
                                                            tVar2.allCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView11 = NearbyFDPStatusContentView.this;
                                                    NearbyContentFeedAvatarViewKt.NearbyContentFeedAvatar(vVar8, new Function1<NearbyFDPContentFeedAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView) {
                                                            NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView2 = nearbyFDPContentFeedAvatarView;
                                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView12 = NearbyFDPStatusContentView.this;
                                                            nearbyFDPContentFeedAvatarView2.ref(nearbyFDPContentFeedAvatarView2, new Function1<aa<NearbyFDPContentFeedAvatarView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(aa<NearbyFDPContentFeedAvatarView> aaVar) {
                                                                    NearbyFDPStatusContentView nearbyFDPStatusContentView13 = NearbyFDPStatusContentView.this;
                                                                    KProperty<Object>[] kPropertyArr = NearbyFDPStatusContentView.$$delegatedProperties;
                                                                    nearbyFDPStatusContentView13.getClass();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView13 = NearbyFDPStatusContentView.this;
                                                            nearbyFDPContentFeedAvatarView2.attr(new Function1<NearbyFDPContentFeedAvatarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.3.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
                                                                
                                                                    if (r0.K == 1) goto L18;
                                                                 */
                                                                @Override // kotlin.jvm.functions.Function1
                                                                /*
                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                */
                                                                public final Unit invoke(NearbyFDPContentFeedAvatarViewAttr nearbyFDPContentFeedAvatarViewAttr) {
                                                                    boolean z17;
                                                                    l statusFeed;
                                                                    e eVar;
                                                                    l statusFeed2;
                                                                    l statusFeed3;
                                                                    NearbyFDPContentFeedAvatarViewAttr nearbyFDPContentFeedAvatarViewAttr2 = nearbyFDPContentFeedAvatarViewAttr;
                                                                    NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                    nearbyFDPContentFeedAvatarViewAttr2.setFilamentResource((viewModel2 == null || (statusFeed3 = viewModel2.getStatusFeed()) == null) ? null : statusFeed3.f418095h);
                                                                    NearbyFDPStatusContentViewModel viewModel3 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                    if (viewModel3 != null && (statusFeed2 = viewModel3.getStatusFeed()) != null && (r0 = statusFeed2.f418093e) != null) {
                                                                        z17 = true;
                                                                    }
                                                                    z17 = false;
                                                                    nearbyFDPContentFeedAvatarViewAttr2.setMale(z17);
                                                                    NearbyFDPStatusContentViewModel viewModel4 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                    nearbyFDPContentFeedAvatarViewAttr2.setTinyId((viewModel4 == null || (statusFeed = viewModel4.getStatusFeed()) == null || (eVar = statusFeed.f418093e) == null) ? 0L : eVar.f430610d);
                                                                    nearbyFDPContentFeedAvatarViewAttr2.size(100.0f, 100.0f);
                                                                    NearbyFDPStatusContentView nearbyFDPStatusContentView14 = NearbyFDPStatusContentView.this;
                                                                    nearbyFDPContentFeedAvatarViewAttr2.setLoadAvatarView(((Boolean) nearbyFDPStatusContentView14.cardWillAppear$delegate.getValue(nearbyFDPStatusContentView14, NearbyFDPStatusContentView.$$delegatedProperties[0])).booleanValue());
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView14 = NearbyFDPStatusContentView.this;
                                                            nearbyFDPContentFeedAvatarView2.event(new Function1<NearbyFDPContentFeedAvatarViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.3.2.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NearbyFDPContentFeedAvatarViewEvent nearbyFDPContentFeedAvatarViewEvent) {
                                                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView15 = NearbyFDPStatusContentView.this;
                                                                    nearbyFDPContentFeedAvatarViewEvent.clickHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.4.3.2.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(Object obj) {
                                                                            KLog kLog = KLog.INSTANCE;
                                                                            NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                                                            kLog.i("feed_detail_page", "singleClick to enter detail");
                                                                            NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                                            if (viewModel2 != null) {
                                                                                KProperty<Object>[] kPropertyArr = NearbyFDPStatusContentViewModel.$$delegatedProperties;
                                                                                viewModel2.onClickCardContent(Boolean.FALSE);
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
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFDPStatusContentView nearbyFDPStatusContentView9 = NearbyFDPStatusContentView.this;
                                    vVar4.addChild(new NearbyContentInteractionView(), new Function1<NearbyContentInteractionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.5
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NearbyContentInteractionView nearbyContentInteractionView) {
                                            final NearbyFDPStatusContentView nearbyFDPStatusContentView10 = NearbyFDPStatusContentView.this;
                                            nearbyContentInteractionView.attr(new Function1<NearbyContentInteractionViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPStatusContentView.body.1.3.4.5.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NearbyContentInteractionViewAttr nearbyContentInteractionViewAttr) {
                                                    NearbyContentInteractionViewAttr nearbyContentInteractionViewAttr2 = nearbyContentInteractionViewAttr;
                                                    nearbyContentInteractionViewAttr2.marginTop(8.0f);
                                                    nearbyContentInteractionViewAttr2.mo141height(48.0f);
                                                    NearbyFDPStatusContentViewModel viewModel2 = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getViewModel();
                                                    ReadWriteProperty readWriteProperty = nearbyContentInteractionViewAttr2.viewModel$delegate;
                                                    KProperty<?>[] kPropertyArr = NearbyContentInteractionViewAttr.$$delegatedProperties;
                                                    readWriteProperty.setValue(nearbyContentInteractionViewAttr2, kPropertyArr[0], viewModel2);
                                                    nearbyContentInteractionViewAttr2.cardViewModel$delegate.setValue(nearbyContentInteractionViewAttr2, kPropertyArr[1], NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).getCardViewModel());
                                                    nearbyContentInteractionViewAttr2.isDarkStyle = true;
                                                    nearbyContentInteractionViewAttr2.dtReporter = NearbyFDPStatusContentView.access$getAttr(NearbyFDPStatusContentView.this).dtReporter;
                                                    return Unit.INSTANCE;
                                                }
                                            });
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
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void cardDidAppear() {
        final String feedID;
        final NearbyFDPStatusContentViewModel viewModel = ((NearbyFDPStatusContentAttr) getAttr()).getViewModel();
        if (viewModel == null || viewModel.didReportFeedRead || (feedID = viewModel.getFeedID()) == null) {
            return;
        }
        viewModel.didReportFeedRead = true;
        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel$reportFeedRead$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                List listOf;
                e eVar;
                KLog kLog = KLog.INSTANCE;
                NearbyConst nearbyConst = NearbyConst.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reportFeedRead feed:");
                m3.append(feedID);
                m3.append(", tid=");
                l statusFeed = viewModel.getStatusFeed();
                m3.append((statusFeed == null || (eVar = statusFeed.f418093e) == null) ? null : Long.valueOf(eVar.f430610d));
                m3.append(", isSelfFeed=");
                m3.append(viewModel.isSelfFeed());
                kLog.i("feed_detail_page", m3.toString());
                if (!viewModel.isSelfFeed()) {
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(feedID);
                    ReportReadFeedsRequest reportReadFeedsRequest = new ReportReadFeedsRequest(2, listOf);
                    final NearbyFDPStatusContentViewModel nearbyFDPStatusContentViewModel = viewModel;
                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(reportReadFeedsRequest, null, new Function1<PbResponse<s25.h>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel$reportFeedRead$1$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(PbResponse<s25.h> pbResponse) {
                            PbResponse<s25.h> pbResponse2 = pbResponse;
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reportReadFeeds[map] code: ");
                            m16.append(pbResponse2.code);
                            m16.append(", msg: ");
                            m16.append(pbResponse2.f114187msg);
                            m16.append(" feed id:");
                            m16.append(NearbyFDPStatusContentViewModel.this.getFeedID());
                            kLog2.i("ReportReadFeedsRepo", m16.toString());
                            return Unit.INSTANCE;
                        }
                    }, 6);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyFDPStatusContentAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyFDPStatusContentEvent();
    }
}
