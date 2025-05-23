package com.tencent.hippykotlin.demo.pages.nearby.city_walk;

import c01.c;
import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ColorPick;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.CityWalkNavFrom;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavAttr;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkTopMaskView;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkTopMaskViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NNBPCityWalkNavEvent;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.kuikly.core.views.TextAreaEvent;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.cc;
import com.tencent.kuikly.core.views.cd;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt___StringsKt;
import n25.k;
import n25.l;
import q25.f;
import q25.g;

/* loaded from: classes31.dex */
public final class NBPCityWalkPreviewPager extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkPreviewPager.class, "autoFocus", "getAutoFocus()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkPreviewPager.class, "keyboardHeight", "getKeyboardHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkPreviewPager.class, "textContentHeight", "getTextContentHeight()F", 0)};
    public final ReadWriteProperty keyboardHeight$delegate;
    public aa<TextAreaView> textAreaRef;
    public final ReadWriteProperty textContentHeight$delegate;
    public NBPCityWalkViewModel viewModelCityWalk;
    public String source = "0";
    public final ReadWriteProperty autoFocus$delegate = c.a(Boolean.TRUE);

    public NBPCityWalkPreviewPager() {
        Float valueOf = Float.valueOf(0.0f);
        this.keyboardHeight$delegate = c.a(valueOf);
        this.textContentHeight$delegate = c.a(valueOf);
    }

    public static final boolean access$needFixSmallScreen(NBPCityWalkPreviewPager nBPCityWalkPreviewPager) {
        if (nBPCityWalkPreviewPager.getTextContentHeight() == 0.0f) {
            return false;
        }
        float textContentHeight = nBPCityWalkPreviewPager.getTextContentHeight() - ((Number) nBPCityWalkPreviewPager.keyboardHeight$delegate.getValue(nBPCityWalkPreviewPager, $$delegatedProperties[1])).floatValue();
        float to812 = FloatExtKt.getTo812(56.0f);
        KLog.INSTANCE.i("NBPCityWalkPreviewPager", "needFixSmallScreen: heightLast=" + textContentHeight + ", safeHeight=" + to812);
        return textContentHeight < to812;
    }

    public static final void access$textareaBlur(NBPCityWalkPreviewPager nBPCityWalkPreviewPager) {
        TextAreaView b16;
        nBPCityWalkPreviewPager.autoFocus$delegate.setValue(nBPCityWalkPreviewPager, $$delegatedProperties[0], Boolean.FALSE);
        aa<TextAreaView> aaVar = nBPCityWalkPreviewPager.textAreaRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            b16.h();
        }
        KLog.INSTANCE.i("NBPCityWalkPreviewPager", "textareaBlur");
    }

    public final float getTextContentHeight() {
        return ((Number) this.textContentHeight$delegate.getValue(this, $$delegatedProperties[2])).floatValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        NBPCityWalkViewModel nBPCityWalkViewModel = this.viewModelCityWalk;
        if (nBPCityWalkViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
            nBPCityWalkViewModel = null;
        }
        e jsonWithPreviewPgId = nBPCityWalkViewModel.jsonWithPreviewPgId();
        jsonWithPreviewPgId.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_pgout", jsonWithPreviewPgId);
        KLog.INSTANCE.i("NBPCityWalkPreviewPager", Pager.PAGER_EVENT_WILL_DESTROY);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float to812 = FloatExtKt.getTo812(358.0f);
        final float to8122 = FloatExtKt.getTo812(8.0f);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager = NBPCityWalkPreviewPager.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager2 = NBPCityWalkPreviewPager.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPCityWalkPreviewPager.access$textareaBlur(NBPCityWalkPreviewPager.this);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final float f16 = to812;
                final float f17 = to8122;
                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager2 = NBPCityWalkPreviewPager.this;
                NBPCityWalkMapViewKt.NBPCityWalkMap(viewContainer2, new Function1<NBPCityWalkMapView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPCityWalkMapView nBPCityWalkMapView) {
                        NBPCityWalkMapView nBPCityWalkMapView2 = nBPCityWalkMapView;
                        final float f18 = f16;
                        final float f19 = f17;
                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager3 = nBPCityWalkPreviewPager2;
                        nBPCityWalkMapView2.attr(new Function1<NBPCityWalkMapViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkMapViewAttr nBPCityWalkMapViewAttr) {
                                NBPCityWalkMapViewAttr nBPCityWalkMapViewAttr2 = nBPCityWalkMapViewAttr;
                                nBPCityWalkMapViewAttr2.size(nBPCityWalkMapViewAttr2.getPagerData().m(), f18);
                                nBPCityWalkMapViewAttr2.getPagerData().getIsIOS();
                                nBPCityWalkMapViewAttr2.topDistance = (nBPCityWalkMapViewAttr2.getPagerData().getStatusBarHeight() + 44.0f) / 2;
                                nBPCityWalkMapViewAttr2.bottomDistance = f19;
                                nBPCityWalkMapViewAttr2.showCount = false;
                                nBPCityWalkMapViewAttr2.canClick = false;
                                String str = null;
                                r25.e eVar = null;
                                g gVar = null;
                                f fVar = null;
                                a aVar = null;
                                List list = null;
                                k kVar = null;
                                long j3 = 0;
                                n25.f fVar2 = null;
                                boolean z16 = false;
                                int i3 = 0;
                                List list2 = null;
                                int i16 = 1;
                                NBPCityWalkViewModel nBPCityWalkViewModel = nBPCityWalkPreviewPager3.viewModelCityWalk;
                                if (nBPCityWalkViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                    nBPCityWalkViewModel = null;
                                }
                                nBPCityWalkMapViewAttr2.setStatusFeed(new l(str, eVar, gVar, fVar, aVar, list, kVar, j3, fVar2, z16, i3, list2, i16, nBPCityWalkViewModel.makeCityWalkInfo(), null, 1998847));
                                nBPCityWalkMapViewAttr2.jumpArticleFeedDetailSource = 4;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager4 = nBPCityWalkPreviewPager2;
                        nBPCityWalkMapView2.event(new Function1<NBPCityWalkMapViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkMapViewEvent nBPCityWalkMapViewEvent) {
                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager5 = NBPCityWalkPreviewPager.this;
                                nBPCityWalkMapViewEvent.onMapClickHandler = new Function1<n25.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(n25.a aVar) {
                                        NBPCityWalkPreviewPager.access$textareaBlur(NBPCityWalkPreviewPager.this);
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                NBPCityWalkTopMaskViewKt.NBPCityWalkTopMask(viewContainer2, new Function1<NBPCityWalkTopMaskView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(NBPCityWalkTopMaskView nBPCityWalkTopMaskView) {
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager3 = NBPCityWalkPreviewPager.this;
                NBPCityWalkNavViewKt.NBPCityWalkNav(viewContainer2, new Function1<NBPCityWalkNavView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPCityWalkNavView nBPCityWalkNavView) {
                        NBPCityWalkNavView nBPCityWalkNavView2 = nBPCityWalkNavView;
                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager4 = NBPCityWalkPreviewPager.this;
                        nBPCityWalkNavView2.attr(new Function1<NBPCityWalkNavAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkNavAttr nBPCityWalkNavAttr) {
                                NBPCityWalkNavAttr nBPCityWalkNavAttr2 = nBPCityWalkNavAttr;
                                NBPCityWalkViewModel nBPCityWalkViewModel = NBPCityWalkPreviewPager.this.viewModelCityWalk;
                                if (nBPCityWalkViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                    nBPCityWalkViewModel = null;
                                }
                                nBPCityWalkNavAttr2.viewModel = nBPCityWalkViewModel;
                                nBPCityWalkNavAttr2.from = CityWalkNavFrom.PREVIEW;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager5 = NBPCityWalkPreviewPager.this;
                        nBPCityWalkNavView2.event(new Function1<NNBPCityWalkNavEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NNBPCityWalkNavEvent nNBPCityWalkNavEvent) {
                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager6 = NBPCityWalkPreviewPager.this;
                                nNBPCityWalkNavEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.5.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPCityWalkPreviewPager.access$textareaBlur(NBPCityWalkPreviewPager.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final float f18 = to812;
                final float f19 = to8122;
                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager4 = NBPCityWalkPreviewPager.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager$body$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f26 = f18;
                        final float f27 = f19;
                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager5 = nBPCityWalkPreviewPager4;
                        final float f28 = 100.0f;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.flexDirectionColumn();
                                tVar2.borderRadius(FloatExtKt.getTo375(8.0f), FloatExtKt.getTo375(8.0f), 0.0f, 0.0f);
                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                tVar2.mo139boxShadow(new com.tencent.kuikly.core.base.g(0.0f, FloatExtKt.getTo375(-2.0f), FloatExtKt.getTo375(2.0f), new h(0L, 0.08f)));
                                tVar2.positionAbsolute();
                                tVar2.m142left(0.0f);
                                tVar2.mo141height((tVar2.getPagerData().l() - f26) + f27);
                                if (NBPCityWalkPreviewPager.access$needFixSmallScreen(nBPCityWalkPreviewPager5)) {
                                    tVar2.m150top(f28);
                                } else {
                                    tVar2.m150top(f26 - f27);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager6 = nBPCityWalkPreviewPager4;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(FloatExtKt.getTo375(343.0f));
                                        tVar2.mo141height(FloatExtKt.getTo375(25.0f));
                                        tVar2.mo113backgroundColor(new h(16250871L, 0.8f));
                                        tVar2.paddingLeft(FloatExtKt.getTo375(6.0f));
                                        tVar2.alignSelfCenter();
                                        tVar2.marginTop(FloatExtKt.getTo375(10.0f));
                                        tVar2.marginBottom(FloatExtKt.getTo375(10.0f));
                                        tVar2.borderRadius(FloatExtKt.getTo375(4.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager7 = NBPCityWalkPreviewPager.this;
                                ar.a(vVar4, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aq<?, ?> aqVar) {
                                        aq<?, ?> aqVar2 = aqVar;
                                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ao aoVar) {
                                                ao aoVar2 = aoVar;
                                                aoVar2.m140flex(1.0f);
                                                aoVar2.justifyContentCenter();
                                                aoVar2.flexDirectionRow();
                                                aoVar2.alignItemsCenter();
                                                aoVar2.showScrollerIndicator(false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager8 = NBPCityWalkPreviewPager.this;
                                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ap apVar) {
                                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager9 = NBPCityWalkPreviewPager.this;
                                                apVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPCityWalkPreviewPager.access$textareaBlur(NBPCityWalkPreviewPager.this);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager9 = NBPCityWalkPreviewPager.this;
                                        Function0<com.tencent.kuikly.core.reactive.collection.c<l>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<l>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final com.tencent.kuikly.core.reactive.collection.c<l> invoke() {
                                                NBPCityWalkViewModel nBPCityWalkViewModel = NBPCityWalkPreviewPager.this.viewModelCityWalk;
                                                if (nBPCityWalkViewModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                    nBPCityWalkViewModel = null;
                                                }
                                                return nBPCityWalkViewModel.getPreviewList();
                                            }
                                        };
                                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager10 = NBPCityWalkPreviewPager.this;
                                        LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<l>, l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(LoopDirectivesView<l> loopDirectivesView, l lVar) {
                                                final String str;
                                                int lastIndex;
                                                LoopDirectivesView<l> loopDirectivesView2 = loopDirectivesView;
                                                l lVar2 = lVar;
                                                k kVar = lVar2.C;
                                                if (kVar != null && (str = kVar.Q) != null) {
                                                    NBPCityWalkViewModel nBPCityWalkViewModel = NBPCityWalkPreviewPager.this.viewModelCityWalk;
                                                    NBPCityWalkViewModel nBPCityWalkViewModel2 = null;
                                                    if (nBPCityWalkViewModel == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                        nBPCityWalkViewModel = null;
                                                    }
                                                    final int indexOf = nBPCityWalkViewModel.getPreviewList().indexOf(lVar2);
                                                    NBPCityWalkViewModel nBPCityWalkViewModel3 = NBPCityWalkPreviewPager.this.viewModelCityWalk;
                                                    if (nBPCityWalkViewModel3 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                    } else {
                                                        nBPCityWalkViewModel2 = nBPCityWalkViewModel3;
                                                    }
                                                    lastIndex = CollectionsKt__CollectionsKt.getLastIndex(nBPCityWalkViewModel2.getPreviewList());
                                                    final boolean z16 = indexOf == lastIndex;
                                                    final NBPCityWalkPreviewPager nBPCityWalkPreviewPager11 = NBPCityWalkPreviewPager.this;
                                                    w.a(loopDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            v vVar6 = vVar5;
                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.flexDirectionRow();
                                                                    tVar2.alignItemsCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final int i3 = indexOf;
                                                            final NBPCityWalkPreviewPager nBPCityWalkPreviewPager12 = nBPCityWalkPreviewPager11;
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    final int i16 = i3;
                                                                    final NBPCityWalkPreviewPager nBPCityWalkPreviewPager13 = nBPCityWalkPreviewPager12;
                                                                    vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4.1.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.mo153width(FloatExtKt.getTo375(6.0f));
                                                                            tVar2.mo141height(FloatExtKt.getTo375(6.0f));
                                                                            tVar2.borderRadius(FloatExtKt.getTo375(6.0f));
                                                                            tVar2.marginRight(FloatExtKt.getTo375(4.0f));
                                                                            ColorPick colorPick = ColorPick.INSTANCE;
                                                                            int i17 = i16;
                                                                            NBPCityWalkViewModel nBPCityWalkViewModel4 = nBPCityWalkPreviewPager13.viewModelCityWalk;
                                                                            if (nBPCityWalkViewModel4 == null) {
                                                                                Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                                                nBPCityWalkViewModel4 = null;
                                                                            }
                                                                            tVar2.mo113backgroundColor(new h(colorPick.getColor(i17, nBPCityWalkViewModel4.getPreviewList().size()), 1.0f));
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final String str2 = str;
                                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4.1.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    final String str3 = str2;
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4.1.3.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ce.fontSize$default(ceVar2, FloatExtKt.getTo375(10.0f), null, 2, null);
                                                                            ceVar2.color(new h(9211020L, 1.0f));
                                                                            ceVar2.text(str3);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            if (!z16) {
                                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4.1.4
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar7) {
                                                                        vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.2.2.4.1.4.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo153width(FloatExtKt.getTo375(26.0f));
                                                                                tVar2.mo141height(FloatExtKt.getTo375(1.0f));
                                                                                tVar2.alignSelfCenter();
                                                                                tVar2.marginLeft(FloatExtKt.getTo375(4.0f));
                                                                                tVar2.marginRight(FloatExtKt.getTo375(4.0f));
                                                                                tVar2.mo113backgroundColor(new h(0L, 0.1f));
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
                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager7 = nBPCityWalkPreviewPager4;
                        final float f29 = f18;
                        final float f36 = f19;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager8 = NBPCityWalkPreviewPager.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager9 = NBPCityWalkPreviewPager.this;
                                        FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(d dVar) {
                                                d dVar2 = dVar;
                                                NBPCityWalkPreviewPager nBPCityWalkPreviewPager10 = NBPCityWalkPreviewPager.this;
                                                nBPCityWalkPreviewPager10.textContentHeight$delegate.setValue(nBPCityWalkPreviewPager10, NBPCityWalkPreviewPager.$$delegatedProperties[2], Float.valueOf(dVar2.getHeight()));
                                                KLog kLog = KLog.INSTANCE;
                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("contentHeight: ");
                                                m3.append(dVar2.getHeight());
                                                kLog.i("NBPCityWalkPreviewPager", m3.toString());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager9 = NBPCityWalkPreviewPager.this;
                                final float f37 = f29;
                                final float f38 = f36;
                                final float f39 = f28;
                                cd.a(vVar4, new Function1<TextAreaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextAreaView textAreaView) {
                                        TextAreaView textAreaView2 = textAreaView;
                                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager10 = NBPCityWalkPreviewPager.this;
                                        textAreaView2.ref(textAreaView2, new Function1<aa<TextAreaView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<TextAreaView> aaVar) {
                                                NBPCityWalkPreviewPager.this.textAreaRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager11 = NBPCityWalkPreviewPager.this;
                                        final float f46 = f37;
                                        final float f47 = f38;
                                        final float f48 = f39;
                                        textAreaView2.attr(new Function1<cc, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cc ccVar) {
                                                float floatValue;
                                                float floatValue2;
                                                float coerceAtLeast;
                                                cc ccVar2 = ccVar;
                                                NBPCityWalkPreviewPager nBPCityWalkPreviewPager12 = NBPCityWalkPreviewPager.this;
                                                boolean z16 = false;
                                                if (((Boolean) nBPCityWalkPreviewPager12.autoFocus$delegate.getValue(nBPCityWalkPreviewPager12, NBPCityWalkPreviewPager.$$delegatedProperties[0])).booleanValue() && ccVar2.getPagerData().l() > 700.0f) {
                                                    z16 = true;
                                                }
                                                ccVar2.h(z16);
                                                ccVar2.mo153width(FloatExtKt.getTo375(343.0f));
                                                ccVar2.alignSelfCenter();
                                                ccVar2.w("\u8bf4\u70b9\u4ec0\u4e48\u5427...");
                                                ccVar2.x(new h(10921638L, 1.0f));
                                                NBPCityWalkViewModel nBPCityWalkViewModel = null;
                                                cc.m(ccVar2, FloatExtKt.getTo375(17.0f), null, 2, null);
                                                ccVar2.i(new h(0L, 1.0f));
                                                ccVar2.v(800);
                                                ccVar2.p();
                                                NBPCityWalkViewModel nBPCityWalkViewModel2 = NBPCityWalkPreviewPager.this.viewModelCityWalk;
                                                if (nBPCityWalkViewModel2 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                    nBPCityWalkViewModel2 = null;
                                                }
                                                ccVar2.j(!nBPCityWalkViewModel2.isPublishing());
                                                NBPCityWalkViewModel nBPCityWalkViewModel3 = NBPCityWalkPreviewPager.this.viewModelCityWalk;
                                                if (nBPCityWalkViewModel3 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                } else {
                                                    nBPCityWalkViewModel = nBPCityWalkViewModel3;
                                                }
                                                if (nBPCityWalkViewModel.isPublishing()) {
                                                    NBPCityWalkPreviewPager.access$textareaBlur(NBPCityWalkPreviewPager.this);
                                                }
                                                if (NBPCityWalkPreviewPager.access$needFixSmallScreen(NBPCityWalkPreviewPager.this)) {
                                                    floatValue2 = ((Number) r0.keyboardHeight$delegate.getValue(NBPCityWalkPreviewPager.this, NBPCityWalkPreviewPager.$$delegatedProperties[1])).floatValue();
                                                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(floatValue2 - ((f46 - f47) - f48), 0.0f);
                                                    ccVar2.mo141height(NBPCityWalkPreviewPager.this.getTextContentHeight() - coerceAtLeast);
                                                    KLog.INSTANCE.i("NBPCityWalkPreviewPager", "textArea, heightLast: " + coerceAtLeast);
                                                } else {
                                                    float textContentHeight = NBPCityWalkPreviewPager.this.getTextContentHeight();
                                                    floatValue = ((Number) r1.keyboardHeight$delegate.getValue(NBPCityWalkPreviewPager.this, NBPCityWalkPreviewPager.$$delegatedProperties[1])).floatValue();
                                                    ccVar2.mo141height(textContentHeight - floatValue);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkPreviewPager nBPCityWalkPreviewPager12 = NBPCityWalkPreviewPager.this;
                                        textAreaView2.event(new Function1<TextAreaEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextAreaEvent textAreaEvent) {
                                                final TextAreaEvent textAreaEvent2 = textAreaEvent;
                                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager13 = NBPCityWalkPreviewPager.this;
                                                VisibilityEventKt.b(textAreaEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        float floatValue;
                                                        float floatValue2;
                                                        float l3 = TextAreaEvent.this.getPager().getPageData().l();
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("TextArea didAppear, pageHeight: ");
                                                        sb5.append(l3);
                                                        sb5.append(", keyboardHeight: ");
                                                        floatValue = ((Number) r2.keyboardHeight$delegate.getValue(nBPCityWalkPreviewPager13, NBPCityWalkPreviewPager.$$delegatedProperties[1])).floatValue();
                                                        sb5.append(floatValue);
                                                        kLog.i("NBPCityWalkPreviewPager", sb5.toString());
                                                        NBPCityWalkViewModel nBPCityWalkViewModel = nBPCityWalkPreviewPager13.viewModelCityWalk;
                                                        if (nBPCityWalkViewModel == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                            nBPCityWalkViewModel = null;
                                                        }
                                                        if (!nBPCityWalkViewModel.isPublishing() && l3 > 700.0f) {
                                                            floatValue2 = ((Number) r4.keyboardHeight$delegate.getValue(nBPCityWalkPreviewPager13, NBPCityWalkPreviewPager.$$delegatedProperties[1])).floatValue();
                                                            if (floatValue2 <= 10.0f) {
                                                                TextAreaEvent textAreaEvent3 = TextAreaEvent.this;
                                                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager14 = nBPCityWalkPreviewPager13;
                                                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.3.1.1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        TextAreaView b16;
                                                                        KLog.INSTANCE.i("NBPCityWalkPreviewPager", "TextArea do focus");
                                                                        aa<TextAreaView> aaVar = NBPCityWalkPreviewPager.this.textAreaRef;
                                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                            b16.l();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                                TimerKt.e(textAreaEvent3.getPagerId(), 100, function0);
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager14 = NBPCityWalkPreviewPager.this;
                                                textAreaEvent2.n(true, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InputParams inputParams) {
                                                        String take;
                                                        take = StringsKt___StringsKt.take(inputParams.getText(), 800);
                                                        NBPCityWalkViewModel nBPCityWalkViewModel = NBPCityWalkPreviewPager.this.viewModelCityWalk;
                                                        if (nBPCityWalkViewModel == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                            nBPCityWalkViewModel = null;
                                                        }
                                                        nBPCityWalkViewModel.content = take;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                textAreaEvent2.p(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.3.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u8d85\u8fc7\u5b57\u6570\u6700\u5927\u9650\u5236", QToastMode.Warning);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager15 = NBPCityWalkPreviewPager.this;
                                                TextAreaEvent.k(textAreaEvent2, false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.3.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(KeyboardParams keyboardParams) {
                                                        KeyboardParams keyboardParams2 = keyboardParams;
                                                        NBPCityWalkPreviewPager nBPCityWalkPreviewPager16 = NBPCityWalkPreviewPager.this;
                                                        nBPCityWalkPreviewPager16.keyboardHeight$delegate.setValue(nBPCityWalkPreviewPager16, NBPCityWalkPreviewPager.$$delegatedProperties[1], Float.valueOf(keyboardParams2.getHeight()));
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("keyboardHeight: ");
                                                        m3.append(keyboardParams2.getHeight());
                                                        kLog.i("NBPCityWalkPreviewPager", m3.toString());
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 1, null);
                                                final NBPCityWalkPreviewPager nBPCityWalkPreviewPager16 = NBPCityWalkPreviewPager.this;
                                                textAreaEvent2.i(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager.body.1.6.3.3.3.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InputParams inputParams) {
                                                        NBPCityWalkViewModel nBPCityWalkViewModel = NBPCityWalkPreviewPager.this.viewModelCityWalk;
                                                        if (nBPCityWalkViewModel == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                            nBPCityWalkViewModel = null;
                                                        }
                                                        e jsonWithPreviewPgId = nBPCityWalkViewModel.jsonWithPreviewPgId();
                                                        jsonWithPreviewPgId.v("dt_eid", "em_nearby_edit_text");
                                                        jsonWithPreviewPgId.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPreviewPgId);
                                                        KLog.INSTANCE.i("NBPCityWalkPreviewPager", "inputFocus");
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
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0038, code lost:
    
        r1 = kotlin.collections.ArraysKt___ArraysKt.toList(r1);
     */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        NBPCityWalkViewModel nBPCityWalkViewModel;
        List list;
        super.created();
        this.source = getPageData().n().q("source", "0");
        getPagerId();
        byte[] bArr = null;
        this.viewModelCityWalk = new NBPCityWalkViewModel(this.source, null);
        Object[] sharePenetratePageData = QQNearbyModule.Companion.getInstance().getSharePenetratePageData();
        if (sharePenetratePageData != null && list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                byte[] bArr2 = obj instanceof byte[] ? (byte[]) obj : bArr;
                l lVar = bArr2 != null ? (l) i.b(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151), bArr2) : null;
                if (lVar != null) {
                    arrayList.add(lVar);
                }
                bArr = null;
            }
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getSharePenetratePageData: ");
            m3.append(arrayList.size());
            m3.append(", ");
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, this.source, kLog, "NBPCityWalkPreviewPager");
            NBPCityWalkViewModel nBPCityWalkViewModel2 = this.viewModelCityWalk;
            if (nBPCityWalkViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                nBPCityWalkViewModel2 = null;
            }
            nBPCityWalkViewModel2.getPreviewList().addAll(arrayList);
        }
        NBPCityWalkViewModel nBPCityWalkViewModel3 = this.viewModelCityWalk;
        if (nBPCityWalkViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
            nBPCityWalkViewModel = null;
        } else {
            nBPCityWalkViewModel = nBPCityWalkViewModel3;
        }
        e jsonWithPreviewPgId = nBPCityWalkViewModel.jsonWithPreviewPgId();
        jsonWithPreviewPgId.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_pgin", jsonWithPreviewPgId);
        KLog.INSTANCE.i("NBPCityWalkPreviewPager", "created");
    }
}
