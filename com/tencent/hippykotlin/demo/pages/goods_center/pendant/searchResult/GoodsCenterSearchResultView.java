package com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataSearchText;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.InputParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterSearchResultView extends GoodsCenterPendantView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterSearchResultView.class, "isVisible", "isVisible()Z", 0)};
    public final ReadWriteProperty isVisible$delegate = c.a(Boolean.FALSE);
    public aa<GoodsCenterSearchHistoryView> resultViewRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterEvent access$getEvent(GoodsCenterSearchResultView goodsCenterSearchResultView) {
        return (GoodsCenterEvent) goodsCenterSearchResultView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterPendantViewModel viewModel = ((GoodsCenterPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultViewModel");
        final GoodsCenterSearchResultViewModel goodsCenterSearchResultViewModel = (GoodsCenterSearchResultViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GoodsCenterSearchResultViewModel goodsCenterSearchResultViewModel2 = GoodsCenterSearchResultViewModel.this;
                final GoodsCenterSearchResultView goodsCenterSearchResultView = this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        Attr.absolutePosition$default(mVar2, (mVar2.getPagerData().getNavigationBarHeight() + 52.0f) - 45.0f, 0.0f, 0.0f, 0.0f, 10, null);
                        if (GoodsCenterSearchResultViewModel.this.getBShowResultView()) {
                            GoodsCenterSearchResultView goodsCenterSearchResultView2 = goodsCenterSearchResultView;
                            goodsCenterSearchResultView2.isVisible$delegate.setValue(goodsCenterSearchResultView2, GoodsCenterSearchResultView.$$delegatedProperties[0], Boolean.TRUE);
                            GoodsCenterSearchResultViewModel goodsCenterSearchResultViewModel3 = GoodsCenterSearchResultViewModel.this;
                            goodsCenterSearchResultViewModel3.query$delegate.setValue(goodsCenterSearchResultViewModel3, GoodsCenterSearchResultViewModel.$$delegatedProperties[1], "");
                            mVar2.m147opacity(1.0f);
                            mVar2.m134animation(b.Companion.l(b.INSTANCE, 0.2f, null, 2, null), (Object) Boolean.valueOf(GoodsCenterSearchResultViewModel.this.getBShowResultView()));
                        } else {
                            mVar2.m147opacity(0.0f);
                            mVar2.m134animation(b.Companion.l(b.INSTANCE, 0.2f, null, 2, null), (Object) Boolean.valueOf(GoodsCenterSearchResultViewModel.this.getBShowResultView()));
                        }
                        GoodsCenterSearchResultView goodsCenterSearchResultView3 = goodsCenterSearchResultView;
                        mVar2.m152visibility(((Boolean) goodsCenterSearchResultView3.isVisible$delegate.getValue(goodsCenterSearchResultView3, GoodsCenterSearchResultView.$$delegatedProperties[0])).booleanValue());
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterSearchResultView goodsCenterSearchResultView2 = this;
                final GoodsCenterSearchResultViewModel goodsCenterSearchResultViewModel3 = GoodsCenterSearchResultViewModel.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final GoodsCenterSearchResultView goodsCenterSearchResultView3 = GoodsCenterSearchResultView.this;
                        final GoodsCenterSearchResultViewModel goodsCenterSearchResultViewModel4 = goodsCenterSearchResultViewModel3;
                        event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                GoodsCenterSearchResultView goodsCenterSearchResultView4 = GoodsCenterSearchResultView.this;
                                goodsCenterSearchResultView4.isVisible$delegate.setValue(goodsCenterSearchResultView4, GoodsCenterSearchResultView.$$delegatedProperties[0], Boolean.valueOf(!goodsCenterSearchResultViewModel4.getBShowResultView()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterSearchResultView goodsCenterSearchResultView3 = this;
                viewContainer2.addChild(new GoodsCenterSearchHistoryView(), new Function1<GoodsCenterSearchHistoryView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GoodsCenterSearchHistoryView goodsCenterSearchHistoryView) {
                        GoodsCenterSearchHistoryView goodsCenterSearchHistoryView2 = goodsCenterSearchHistoryView;
                        final GoodsCenterSearchResultView goodsCenterSearchResultView4 = GoodsCenterSearchResultView.this;
                        goodsCenterSearchHistoryView2.ref(goodsCenterSearchHistoryView2, new Function1<aa<GoodsCenterSearchHistoryView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<GoodsCenterSearchHistoryView> aaVar) {
                                GoodsCenterSearchResultView.this.resultViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        goodsCenterSearchHistoryView2.attr(new Function1<GoodsCenterSearchHistoryAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterSearchHistoryAttr goodsCenterSearchHistoryAttr) {
                                goodsCenterSearchHistoryAttr.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterSearchResultView goodsCenterSearchResultView5 = GoodsCenterSearchResultView.this;
                        goodsCenterSearchHistoryView2.event(new Function1<GoodsCenterSearchHistoryEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterSearchHistoryEvent goodsCenterSearchHistoryEvent) {
                                GoodsCenterSearchHistoryEvent goodsCenterSearchHistoryEvent2 = goodsCenterSearchHistoryEvent;
                                final GoodsCenterSearchResultView goodsCenterSearchResultView6 = GoodsCenterSearchResultView.this;
                                final Function1<InputParams, Unit> function1 = new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InputParams inputParams) {
                                        GoodsCenterSearchResultView.access$getEvent(GoodsCenterSearchResultView.this).onFireEvent("click_search", new GoodsCenterEventDataSearchText(inputParams.getText(), 2));
                                        return Unit.INSTANCE;
                                    }
                                };
                                goodsCenterSearchHistoryEvent2.getClass();
                                goodsCenterSearchHistoryEvent2.register("searchCallBack", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchHistoryEvent$didSearchWithText$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        function1.invoke(new InputParams(((e) obj).p("text"), null, 2, null));
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

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterPendantAttr createAttr() {
        return new GoodsCenterPendantAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterEvent createEvent() {
        return new GoodsCenterEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        IGoodsCenterPendantViewModel viewModel = ((GoodsCenterPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultViewModel");
        final GoodsCenterSearchResultViewModel goodsCenterSearchResultViewModel = (GoodsCenterSearchResultViewModel) viewModel;
        ReactiveObserver.INSTANCE.b(goodsCenterSearchResultViewModel.getQuery(), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultView$viewDidLoad$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                bool.booleanValue();
                if (!Intrinsics.areEqual(GoodsCenterSearchResultViewModel.this.getQuery(), "")) {
                    aa<GoodsCenterSearchHistoryView> aaVar = this.resultViewRef;
                    if (aaVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("resultViewRef");
                        aaVar = null;
                    }
                    GoodsCenterSearchHistoryView b16 = aaVar.b();
                    if (b16 != null) {
                        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("text", GoodsCenterSearchResultViewModel.this.getQuery());
                        RenderView renderView = b16.getRenderView();
                        if (renderView != null) {
                            RenderView.b(renderView, "addSearchRecord", m3.toString(), null, 4, null);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterPendantAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }
}
