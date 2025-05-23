package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.LoadingStatus;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cl;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n25.l;

/* loaded from: classes31.dex */
public final class NBPCityWalkSelectListView extends ComposeView<NBPCityWalkSelectListAttr, NBPCityWalkSelectListEvent> {
    public aa<cm> fallListViewRef;
    public boolean firstShow = true;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPCityWalkSelectListAttr access$getAttr(NBPCityWalkSelectListView nBPCityWalkSelectListView) {
        return (NBPCityWalkSelectListAttr) nBPCityWalkSelectListView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$pageViewReport(NBPCityWalkSelectListView nBPCityWalkSelectListView) {
        String str;
        boolean isDisplay = ((NBPCityWalkSelectListAttr) nBPCityWalkSelectListView.getAttr()).getViewModel().isDisplay();
        if (!isDisplay && nBPCityWalkSelectListView.firstShow) {
            nBPCityWalkSelectListView.firstShow = false;
            return;
        }
        if (!isDisplay) {
            str = "dt_pgout";
        } else {
            str = "dt_pgin";
        }
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_citywalk_choose_content", DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"));
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("pageChange\uff1a", str, ", ");
        NBPCityWalkViewModel viewModel = ((NBPCityWalkSelectListAttr) nBPCityWalkSelectListView.getAttr()).getViewModel();
        m3.append(((Number) viewModel.barIndex$delegate.getValue(viewModel, NBPCityWalkViewModel.$$delegatedProperties[2])).intValue());
        kLog.i("NBPCityWalkSelectListView", m3.toString());
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPCityWalkSelectListView nBPCityWalkSelectListView = NBPCityWalkSelectListView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.positionAbsolute();
                        mVar2.m142left(0.0f);
                        mVar2.m150top(0.0f);
                        mVar2.mo139boxShadow(new g(0.0f, -4.0f, 4.0f, new h(0L, 0.08f)));
                        final NBPCityWalkSelectListView nBPCityWalkSelectListView2 = NBPCityWalkSelectListView.this;
                        Function0<? extends Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().isDisplay());
                            }
                        };
                        final NBPCityWalkSelectListView nBPCityWalkSelectListView3 = NBPCityWalkSelectListView.this;
                        mVar2.bindValueChange(function0, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                NBPCityWalkSelectListView.access$pageViewReport(NBPCityWalkSelectListView.this);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                NBPCityWalkTopMaskViewKt.NBPCityWalkTopMask(viewContainer2, new Function1<NBPCityWalkTopMaskView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(NBPCityWalkTopMaskView nBPCityWalkTopMaskView) {
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkSelectListView nBPCityWalkSelectListView2 = NBPCityWalkSelectListView.this;
                NBPCityWalkNavViewKt.NBPCityWalkNav(viewContainer2, new Function1<NBPCityWalkNavView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPCityWalkNavView nBPCityWalkNavView) {
                        final NBPCityWalkSelectListView nBPCityWalkSelectListView3 = NBPCityWalkSelectListView.this;
                        nBPCityWalkNavView.attr(new Function1<NBPCityWalkNavAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkNavAttr nBPCityWalkNavAttr) {
                                NBPCityWalkNavAttr nBPCityWalkNavAttr2 = nBPCityWalkNavAttr;
                                nBPCityWalkNavAttr2.viewModel = NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel();
                                nBPCityWalkNavAttr2.from = CityWalkNavFrom.SELECT_LIST;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkSelectListView nBPCityWalkSelectListView3 = NBPCityWalkSelectListView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                tVar2.flexDirectionColumn();
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.borderRadius(8.0f);
                                float l3 = tVar2.getPagerData().l();
                                tVar2.getPagerData().getIsIOS();
                                tVar2.mo141height(l3 - (tVar2.getPagerData().getStatusBarHeight() + 60.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.marginTop(16.0f);
                                        ceVar2.marginBottom(12.0f);
                                        ceVar2.lineHeight(24.0f);
                                        ceVar2.mo141height(24.0f);
                                        ceVar2.text("\u9009\u62e9\u52a8\u6001\u751f\u6210\u8db3\u8ff9");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkSelectListView nBPCityWalkSelectListView4 = NBPCityWalkSelectListView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(!NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListView().isEmpty());
                            }
                        };
                        final NBPCityWalkSelectListView nBPCityWalkSelectListView5 = NBPCityWalkSelectListView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPCityWalkSelectListView nBPCityWalkSelectListView6 = NBPCityWalkSelectListView.this;
                                cn.a(conditionView, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cm cmVar) {
                                        cm cmVar2 = cmVar;
                                        final NBPCityWalkSelectListView nBPCityWalkSelectListView7 = NBPCityWalkSelectListView.this;
                                        cmVar2.ref(cmVar2, new Function1<aa<cm>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<cm> aaVar) {
                                                NBPCityWalkSelectListView.this.fallListViewRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkSelectListView nBPCityWalkSelectListView8 = NBPCityWalkSelectListView.this;
                                        cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ck ckVar) {
                                                ck ckVar2 = ckVar;
                                                ckVar2.m140flex(1.0f);
                                                ckVar2.w(ckVar2.getPagerData().m());
                                                ckVar2.u(8.0f);
                                                ckVar2.t(8.0f);
                                                ckVar2.h(2);
                                                ckVar2.justifyContentCenter();
                                                ckVar2.alignSelfCenter();
                                                NBPCityWalkViewModel viewModel = NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel();
                                                ckVar2.marginBottom(((Number) viewModel.bottomBarHeight$delegate.getValue(viewModel, NBPCityWalkViewModel.$$delegatedProperties[1])).floatValue() + 5.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkSelectListView nBPCityWalkSelectListView9 = NBPCityWalkSelectListView.this;
                                        cmVar2.event(new Function1<cl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cl clVar) {
                                                cl clVar2 = clVar;
                                                clVar2.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                clVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.3.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCityWalkSelectListView nBPCityWalkSelectListView10 = NBPCityWalkSelectListView.this;
                                                clVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        FlexNode flexNode;
                                                        d layoutFrame;
                                                        ScrollParams scrollParams2 = scrollParams;
                                                        if (NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListLoadingStatus() != LoadingStatus.NO_MORE) {
                                                            aa<cm> aaVar = NBPCityWalkSelectListView.this.fallListViewRef;
                                                            if (aaVar == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("fallListViewRef");
                                                                aaVar = null;
                                                            }
                                                            cm b16 = aaVar.b();
                                                            double ceil = (Math.ceil((NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListView().size() * 1.0d) / 2) * 209.0f) - ((b16 == null || (flexNode = b16.getFlexNode()) == null || (layoutFrame = flexNode.getLayoutFrame()) == null) ? 0.0f : layoutFrame.getHeight());
                                                            float offsetY = (209.0f / 2) + scrollParams2.getOffsetY();
                                                            if (offsetY >= ceil) {
                                                                NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().fetchSelectList();
                                                            }
                                                            KLog.INSTANCE.i("NBPCityWalkSelectListView", "fallListView scroll offsetY\uff1a" + offsetY + " ,offsetScreen\uff1a" + ceil);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkSelectListView nBPCityWalkSelectListView10 = NBPCityWalkSelectListView.this;
                                        Function0<c<l>> function02 = new Function0<c<l>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.4
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final c<l> invoke() {
                                                return NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListView();
                                            }
                                        };
                                        final NBPCityWalkSelectListView nBPCityWalkSelectListView11 = NBPCityWalkSelectListView.this;
                                        LoopDirectivesViewKt.a(cmVar2, function02, new Function2<LoopDirectivesView<l>, l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.5
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(LoopDirectivesView<l> loopDirectivesView, l lVar) {
                                                final l lVar2 = lVar;
                                                final NBPCityWalkSelectListView nBPCityWalkSelectListView12 = NBPCityWalkSelectListView.this;
                                                loopDirectivesView.addChild(new NBPCityWalkSelectPageItemView(), new Function1<NBPCityWalkSelectPageItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.5.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPCityWalkSelectPageItemView nBPCityWalkSelectPageItemView) {
                                                        final l lVar3 = l.this;
                                                        final NBPCityWalkSelectListView nBPCityWalkSelectListView13 = nBPCityWalkSelectListView12;
                                                        nBPCityWalkSelectPageItemView.attr(new Function1<NBPCityWalkItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.5.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPCityWalkItemViewAttr nBPCityWalkItemViewAttr) {
                                                                NBPCityWalkItemViewAttr nBPCityWalkItemViewAttr2 = nBPCityWalkItemViewAttr;
                                                                nBPCityWalkItemViewAttr2.statusFeed = l.this;
                                                                nBPCityWalkItemViewAttr2.viewModel = NBPCityWalkSelectListView.access$getAttr(nBPCityWalkSelectListView13).getViewModel();
                                                                nBPCityWalkItemViewAttr2.isLineFirst$delegate.setValue(nBPCityWalkItemViewAttr2, NBPCityWalkItemViewAttr.$$delegatedProperties[0], Boolean.valueOf(NBPCityWalkSelectListView.access$getAttr(nBPCityWalkSelectListView13).getViewModel().getSelectListView().indexOf(l.this) % 2 == 0));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkSelectListView nBPCityWalkSelectListView12 = NBPCityWalkSelectListView.this;
                                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.6
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListLoadingStatus();
                                            }
                                        };
                                        final NBPCityWalkSelectListView nBPCityWalkSelectListView13 = NBPCityWalkSelectListView.this;
                                        BindDirectivesViewKt.a(cmVar2, function03, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.7
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                                int ordinal = NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListLoadingStatus().ordinal();
                                                if (ordinal == 1) {
                                                    final NBPCityWalkSelectListView nBPCityWalkSelectListView14 = NBPCityWalkSelectListView.this;
                                                    bindDirectivesView2.addChild(new NBPCityWalkListLoadingView(), new Function1<NBPCityWalkListLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.7.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPCityWalkListLoadingView nBPCityWalkListLoadingView) {
                                                            final NBPCityWalkSelectListView nBPCityWalkSelectListView15 = NBPCityWalkSelectListView.this;
                                                            nBPCityWalkListLoadingView.attr(new Function1<NBPCityWalkListLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.7.1.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPCityWalkListLoadingAttr nBPCityWalkListLoadingAttr) {
                                                                    NBPCityWalkListLoadingAttr nBPCityWalkListLoadingAttr2 = nBPCityWalkListLoadingAttr;
                                                                    NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel();
                                                                    nBPCityWalkListLoadingAttr2.getClass();
                                                                    nBPCityWalkListLoadingAttr2.mo153width(nBPCityWalkListLoadingAttr2.getPagerData().m());
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                } else if (ordinal == 4) {
                                                    final NBPCityWalkSelectListView nBPCityWalkSelectListView15 = NBPCityWalkSelectListView.this;
                                                    bindDirectivesView2.addChild(new NBPCityWalkListNoMoreView(), new Function1<NBPCityWalkListNoMoreView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.7.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPCityWalkListNoMoreView nBPCityWalkListNoMoreView) {
                                                            final NBPCityWalkSelectListView nBPCityWalkSelectListView16 = NBPCityWalkSelectListView.this;
                                                            nBPCityWalkListNoMoreView.attr(new Function1<NBPCityWalkListNoMoreAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.5.1.7.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPCityWalkListNoMoreAttr nBPCityWalkListNoMoreAttr) {
                                                                    NBPCityWalkListNoMoreAttr nBPCityWalkListNoMoreAttr2 = nBPCityWalkListNoMoreAttr;
                                                                    nBPCityWalkListNoMoreAttr2.viewModel = NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel();
                                                                    nBPCityWalkListNoMoreAttr2.mo153width(nBPCityWalkListNoMoreAttr2.getPagerData().m());
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
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkSelectListView nBPCityWalkSelectListView6 = NBPCityWalkSelectListView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListView().isEmpty());
                            }
                        };
                        final NBPCityWalkSelectListView nBPCityWalkSelectListView7 = NBPCityWalkSelectListView.this;
                        ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPCityWalkSelectListView nBPCityWalkSelectListView8 = NBPCityWalkSelectListView.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListLoadingStatus();
                                    }
                                };
                                final NBPCityWalkSelectListView nBPCityWalkSelectListView9 = NBPCityWalkSelectListView.this;
                                BindDirectivesViewKt.a(conditionView, function03, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                        int ordinal = NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel().getSelectListLoadingStatus().ordinal();
                                        if (ordinal == 1) {
                                            final NBPCityWalkSelectListView nBPCityWalkSelectListView10 = NBPCityWalkSelectListView.this;
                                            bindDirectivesView2.addChild(new NBPCityWalkListLoadingView(), new Function1<NBPCityWalkListLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NBPCityWalkListLoadingView nBPCityWalkListLoadingView) {
                                                    final NBPCityWalkSelectListView nBPCityWalkSelectListView11 = NBPCityWalkSelectListView.this;
                                                    nBPCityWalkListLoadingView.attr(new Function1<NBPCityWalkListLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7.2.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPCityWalkListLoadingAttr nBPCityWalkListLoadingAttr) {
                                                            NBPCityWalkListLoadingAttr nBPCityWalkListLoadingAttr2 = nBPCityWalkListLoadingAttr;
                                                            NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel();
                                                            nBPCityWalkListLoadingAttr2.getClass();
                                                            nBPCityWalkListLoadingAttr2.mo153width(nBPCityWalkListLoadingAttr2.getPagerData().m());
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (ordinal == 2) {
                                            final NBPCityWalkSelectListView nBPCityWalkSelectListView11 = NBPCityWalkSelectListView.this;
                                            bindDirectivesView2.addChild(new NBPCityWalkListErrorTipsView(), new Function1<NBPCityWalkListErrorTipsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NBPCityWalkListErrorTipsView nBPCityWalkListErrorTipsView) {
                                                    final NBPCityWalkSelectListView nBPCityWalkSelectListView12 = NBPCityWalkSelectListView.this;
                                                    nBPCityWalkListErrorTipsView.attr(new Function1<NBPCityWalkListErrorTipsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7.2.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPCityWalkListErrorTipsAttr nBPCityWalkListErrorTipsAttr) {
                                                            nBPCityWalkListErrorTipsAttr.viewModel = NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (ordinal == 4) {
                                            final NBPCityWalkSelectListView nBPCityWalkSelectListView12 = NBPCityWalkSelectListView.this;
                                            bindDirectivesView2.addChild(new NBPCityWalkListNoMoreView(), new Function1<NBPCityWalkListNoMoreView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7.2.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NBPCityWalkListNoMoreView nBPCityWalkListNoMoreView) {
                                                    final NBPCityWalkSelectListView nBPCityWalkSelectListView13 = NBPCityWalkSelectListView.this;
                                                    nBPCityWalkListNoMoreView.attr(new Function1<NBPCityWalkListNoMoreAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView.body.1.4.7.2.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPCityWalkListNoMoreAttr nBPCityWalkListNoMoreAttr) {
                                                            NBPCityWalkListNoMoreAttr nBPCityWalkListNoMoreAttr2 = nBPCityWalkListNoMoreAttr;
                                                            nBPCityWalkListNoMoreAttr2.viewModel = NBPCityWalkSelectListView.access$getAttr(NBPCityWalkSelectListView.this).getViewModel();
                                                            nBPCityWalkListNoMoreAttr2.mo153width(nBPCityWalkListNoMoreAttr2.getPagerData().m());
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPCityWalkSelectListAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPCityWalkSelectListEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        ((NBPCityWalkSelectListAttr) getAttr()).getViewModel().fetchSelectList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        if (((NBPCityWalkSelectListAttr) getAttr()).getViewModel().isDisplay()) {
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_pgout", AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_citywalk_choose_content", DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"));
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("pageChange viewDestroyed\uff1a ");
            m3.append(((NBPCityWalkSelectListAttr) getAttr()).getViewModel().isDisplay());
            kLog.i("NBPCityWalkSelectListView", m3.toString());
        }
    }
}
