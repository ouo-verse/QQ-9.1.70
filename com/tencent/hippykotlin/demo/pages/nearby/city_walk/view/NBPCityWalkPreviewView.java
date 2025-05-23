package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ColorPick;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
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
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt___StringsKt;
import n25.a;
import n25.b;
import n25.k;
import n25.l;

/* loaded from: classes31.dex */
public final class NBPCityWalkPreviewView extends ComposeView<NBPCityWalkPreviewViewAttr, NBPCityWalkPreviewViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkPreviewView.class, "keyboardHeight", "getKeyboardHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkPreviewView.class, "textContentHeight", "getTextContentHeight()F", 0)};
    public boolean hasInit;
    public final ReadWriteProperty keyboardHeight$delegate;
    public aa<NBPCityWalkMapView> mapRef;
    public aa<TextAreaView> textAreaRef;
    public final ReadWriteProperty textContentHeight$delegate;

    public NBPCityWalkPreviewView() {
        Float valueOf = Float.valueOf(0.0f);
        this.keyboardHeight$delegate = c.a(valueOf);
        this.textContentHeight$delegate = c.a(valueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPCityWalkPreviewViewAttr access$getAttr(NBPCityWalkPreviewView nBPCityWalkPreviewView) {
        return (NBPCityWalkPreviewViewAttr) nBPCityWalkPreviewView.getAttr();
    }

    public static final boolean access$needFixSmallScreen(NBPCityWalkPreviewView nBPCityWalkPreviewView) {
        if (!(nBPCityWalkPreviewView.getTextContentHeight() == 0.0f)) {
            float textContentHeight = nBPCityWalkPreviewView.getTextContentHeight() - nBPCityWalkPreviewView.getKeyboardHeight();
            KLog.INSTANCE.i("NBPCityWalkPreviewPager", "needFixSmallScreen: heightLast=" + textContentHeight + ", safeHeight=56.0");
            if (textContentHeight < 56.0f) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$textareaAutofocus(final NBPCityWalkPreviewView nBPCityWalkPreviewView) {
        float l3 = nBPCityWalkPreviewView.getPager().getPageData().l();
        KLog.INSTANCE.i("NBPCityWalkPreviewPager", "TextArea didAppear, pageHeight: " + l3 + ", keyboardHeight: " + nBPCityWalkPreviewView.getKeyboardHeight() + ", isPreview = " + ((NBPCityWalkPreviewViewAttr) nBPCityWalkPreviewView.getAttr()).getViewModel().isPreview());
        if (((NBPCityWalkPreviewViewAttr) nBPCityWalkPreviewView.getAttr()).getViewModel().isPublishing() || l3 <= 700.0f || nBPCityWalkPreviewView.getKeyboardHeight() > 10.0f || !((NBPCityWalkPreviewViewAttr) nBPCityWalkPreviewView.getAttr()).getViewModel().isPreview()) {
            return;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$textareaAutofocus$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                TextAreaView b16;
                KLog.INSTANCE.i("NBPCityWalkPreviewPager", "TextArea do focus");
                aa<TextAreaView> aaVar = NBPCityWalkPreviewView.this.textAreaRef;
                if (aaVar != null && (b16 = aaVar.b()) != null) {
                    b16.l();
                }
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(nBPCityWalkPreviewView.getPagerId(), 100, function0);
    }

    public static final void access$textareaBlur(NBPCityWalkPreviewView nBPCityWalkPreviewView) {
        TextAreaView b16;
        aa<TextAreaView> aaVar = nBPCityWalkPreviewView.textAreaRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            b16.h();
        }
        KLog.INSTANCE.i("NBPCityWalkPreviewPager", "textareaBlur");
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPCityWalkPreviewView nBPCityWalkPreviewView = NBPCityWalkPreviewView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        if (NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().isPreview()) {
                            e jsonWithPreviewPgId = NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().jsonWithPreviewPgId();
                            jsonWithPreviewPgId.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_pgin", jsonWithPreviewPgId);
                        } else {
                            NBPCityWalkPreviewView nBPCityWalkPreviewView2 = NBPCityWalkPreviewView.this;
                            nBPCityWalkPreviewView2.keyboardHeight$delegate.setValue(nBPCityWalkPreviewView2, NBPCityWalkPreviewView.$$delegatedProperties[0], Float.valueOf(0.0f));
                            NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().content = "";
                            NBPCityWalkPreviewView.access$textareaBlur(NBPCityWalkPreviewView.this);
                            NBPCityWalkPreviewView nBPCityWalkPreviewView3 = NBPCityWalkPreviewView.this;
                            if (nBPCityWalkPreviewView3.hasInit) {
                                e jsonWithPreviewPgId2 = NBPCityWalkPreviewView.access$getAttr(nBPCityWalkPreviewView3).getViewModel().jsonWithPreviewPgId();
                                jsonWithPreviewPgId2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_pgout", jsonWithPreviewPgId2);
                            } else {
                                nBPCityWalkPreviewView3.hasInit = true;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkPreviewView nBPCityWalkPreviewView2 = NBPCityWalkPreviewView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPCityWalkPreviewView nBPCityWalkPreviewView3 = NBPCityWalkPreviewView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPCityWalkPreviewView.access$textareaBlur(NBPCityWalkPreviewView.this);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkPreviewView nBPCityWalkPreviewView3 = NBPCityWalkPreviewView.this;
                NBPCityWalkMapViewKt.NBPCityWalkMap(viewContainer2, new Function1<NBPCityWalkMapView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPCityWalkMapView nBPCityWalkMapView) {
                        NBPCityWalkMapView nBPCityWalkMapView2 = nBPCityWalkMapView;
                        final NBPCityWalkPreviewView nBPCityWalkPreviewView4 = NBPCityWalkPreviewView.this;
                        nBPCityWalkMapView2.ref(nBPCityWalkMapView2, new Function1<aa<NBPCityWalkMapView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPCityWalkMapView> aaVar) {
                                NBPCityWalkPreviewView.this.mapRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkPreviewView nBPCityWalkPreviewView5 = NBPCityWalkPreviewView.this;
                        final float f16 = 358.0f;
                        final float f17 = 8.0f;
                        nBPCityWalkMapView2.attr(new Function1<NBPCityWalkMapViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkMapViewAttr nBPCityWalkMapViewAttr) {
                                aa<NBPCityWalkMapView> aaVar;
                                NBPCityWalkMapView b16;
                                List<a> list;
                                NBPCityWalkMapViewAttr nBPCityWalkMapViewAttr2 = nBPCityWalkMapViewAttr;
                                nBPCityWalkMapViewAttr2.size(nBPCityWalkMapViewAttr2.getPagerData().m(), f16);
                                nBPCityWalkMapViewAttr2.getPagerData().getIsIOS();
                                nBPCityWalkMapViewAttr2.topDistance = (nBPCityWalkMapViewAttr2.getPagerData().getStatusBarHeight() + 44.0f) / 2;
                                nBPCityWalkMapViewAttr2.bottomDistance = f17;
                                nBPCityWalkMapViewAttr2.showCount = false;
                                nBPCityWalkMapViewAttr2.canClick = false;
                                nBPCityWalkMapViewAttr2.setStatusFeed(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 1, NBPCityWalkPreviewView.access$getAttr(nBPCityWalkPreviewView5).getViewModel().makeCityWalkInfo(), null, 1998847));
                                nBPCityWalkMapViewAttr2.jumpArticleFeedDetailSource = 4;
                                if (NBPCityWalkPreviewView.access$getAttr(nBPCityWalkPreviewView5).getViewModel().isPreview() && (aaVar = nBPCityWalkPreviewView5.mapRef) != null && (b16 = aaVar.b()) != null) {
                                    l lVar = new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 1, NBPCityWalkPreviewView.access$getAttr(nBPCityWalkPreviewView5).getViewModel().makeCityWalkInfo(), null, 1998847);
                                    b16.getList().clear();
                                    b bVar = lVar.M;
                                    if (bVar != null && (list = bVar.f418049d) != null) {
                                        b16.getList().addAll(list);
                                    }
                                    b16.updateMap();
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkPreviewView nBPCityWalkPreviewView6 = NBPCityWalkPreviewView.this;
                        nBPCityWalkMapView2.event(new Function1<NBPCityWalkMapViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkMapViewEvent nBPCityWalkMapViewEvent) {
                                final NBPCityWalkPreviewView nBPCityWalkPreviewView7 = NBPCityWalkPreviewView.this;
                                nBPCityWalkMapViewEvent.onMapClickHandler = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(a aVar) {
                                        NBPCityWalkPreviewView.access$textareaBlur(NBPCityWalkPreviewView.this);
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                NBPCityWalkTopMaskViewKt.NBPCityWalkTopMask(viewContainer2, new Function1<NBPCityWalkTopMaskView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(NBPCityWalkTopMaskView nBPCityWalkTopMaskView) {
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkPreviewView nBPCityWalkPreviewView4 = NBPCityWalkPreviewView.this;
                NBPCityWalkNavViewKt.NBPCityWalkNav(viewContainer2, new Function1<NBPCityWalkNavView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPCityWalkNavView nBPCityWalkNavView) {
                        NBPCityWalkNavView nBPCityWalkNavView2 = nBPCityWalkNavView;
                        final NBPCityWalkPreviewView nBPCityWalkPreviewView5 = NBPCityWalkPreviewView.this;
                        nBPCityWalkNavView2.attr(new Function1<NBPCityWalkNavAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkNavAttr nBPCityWalkNavAttr) {
                                NBPCityWalkNavAttr nBPCityWalkNavAttr2 = nBPCityWalkNavAttr;
                                nBPCityWalkNavAttr2.viewModel = NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel();
                                nBPCityWalkNavAttr2.from = CityWalkNavFrom.PREVIEW;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkPreviewView nBPCityWalkPreviewView6 = NBPCityWalkPreviewView.this;
                        nBPCityWalkNavView2.event(new Function1<NNBPCityWalkNavEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NNBPCityWalkNavEvent nNBPCityWalkNavEvent) {
                                final NBPCityWalkPreviewView nBPCityWalkPreviewView7 = NBPCityWalkPreviewView.this;
                                nNBPCityWalkNavEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.5.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPCityWalkPreviewView.access$textareaBlur(NBPCityWalkPreviewView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkPreviewView nBPCityWalkPreviewView5 = NBPCityWalkPreviewView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().isPreview());
                    }
                };
                final NBPCityWalkPreviewView nBPCityWalkPreviewView6 = NBPCityWalkPreviewView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPCityWalkPreviewView nBPCityWalkPreviewView7 = NBPCityWalkPreviewView.this;
                        final float f16 = 8.0f;
                        final float f17 = 100.0f;
                        final float f18 = 358.0f;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final float f19 = f18;
                                final float f26 = f16;
                                final NBPCityWalkPreviewView nBPCityWalkPreviewView8 = nBPCityWalkPreviewView7;
                                final float f27 = f17;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(tVar2.getPagerData().m());
                                        tVar2.flexDirectionColumn();
                                        tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                        tVar2.mo139boxShadow(new g(0.0f, -2.0f, 2.0f, new h(0L, 0.08f)));
                                        tVar2.positionAbsolute();
                                        tVar2.m142left(0.0f);
                                        tVar2.mo141height((tVar2.getPagerData().l() - f19) + f26);
                                        if (NBPCityWalkPreviewView.access$needFixSmallScreen(nBPCityWalkPreviewView8) && NBPCityWalkPreviewView.access$getAttr(nBPCityWalkPreviewView8).getViewModel().isPreview()) {
                                            tVar2.m150top(f27);
                                        } else {
                                            tVar2.m150top(f19 - f26);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkPreviewView nBPCityWalkPreviewView9 = nBPCityWalkPreviewView7;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(tVar2.getPagerData().m() - 32);
                                                tVar2.mo141height(25.0f);
                                                tVar2.mo113backgroundColor(new h(16250871L, 0.8f));
                                                tVar2.paddingLeft(6.0f);
                                                tVar2.alignSelfCenter();
                                                tVar2.marginTop(10.0f);
                                                tVar2.marginBottom(10.0f);
                                                tVar2.borderRadius(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView10 = NBPCityWalkPreviewView.this;
                                        ar.a(vVar4, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aq<?, ?> aqVar) {
                                                aq<?, ?> aqVar2 = aqVar;
                                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.1
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
                                                final NBPCityWalkPreviewView nBPCityWalkPreviewView11 = NBPCityWalkPreviewView.this;
                                                aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ap apVar) {
                                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView12 = NBPCityWalkPreviewView.this;
                                                        apVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPCityWalkPreviewView.access$textareaBlur(NBPCityWalkPreviewView.this);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCityWalkPreviewView nBPCityWalkPreviewView12 = NBPCityWalkPreviewView.this;
                                                Function0<com.tencent.kuikly.core.reactive.collection.c<l>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<l>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.3
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final com.tencent.kuikly.core.reactive.collection.c<l> invoke() {
                                                        return NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().getPreviewList();
                                                    }
                                                };
                                                final NBPCityWalkPreviewView nBPCityWalkPreviewView13 = NBPCityWalkPreviewView.this;
                                                LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<l>, l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4
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
                                                            final int indexOf = NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().getPreviewList().indexOf(lVar2);
                                                            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().getPreviewList());
                                                            final boolean z16 = indexOf == lastIndex;
                                                            final NBPCityWalkPreviewView nBPCityWalkPreviewView14 = NBPCityWalkPreviewView.this;
                                                            w.a(loopDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar5) {
                                                                    v vVar6 = vVar5;
                                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4.1.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.flexDirectionRow();
                                                                            tVar2.alignItemsCenter();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final int i3 = indexOf;
                                                                    final NBPCityWalkPreviewView nBPCityWalkPreviewView15 = nBPCityWalkPreviewView14;
                                                                    w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4.1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(v vVar7) {
                                                                            final int i16 = i3;
                                                                            final NBPCityWalkPreviewView nBPCityWalkPreviewView16 = nBPCityWalkPreviewView15;
                                                                            vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4.1.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(t tVar) {
                                                                                    t tVar2 = tVar;
                                                                                    tVar2.mo153width(6.0f);
                                                                                    tVar2.mo141height(6.0f);
                                                                                    tVar2.borderRadius(6.0f);
                                                                                    tVar2.marginRight(4.0f);
                                                                                    tVar2.mo113backgroundColor(new h(ColorPick.INSTANCE.getColor(i16, NBPCityWalkPreviewView.access$getAttr(nBPCityWalkPreviewView16).getViewModel().getPreviewList().size()), 1.0f));
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final String str2 = str;
                                                                    cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4.1.3
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            final String str3 = str2;
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4.1.3.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                                    ceVar2.color(new h(9211020L, 1.0f));
                                                                                    ceVar2.text(str3);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    if (!z16) {
                                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4.1.4
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar7) {
                                                                                vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.2.2.4.1.4.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.mo153width(26.0f);
                                                                                        tVar2.mo141height(1.0f);
                                                                                        tVar2.alignSelfCenter();
                                                                                        tVar2.marginLeft(4.0f);
                                                                                        tVar2.marginRight(4.0f);
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
                                final NBPCityWalkPreviewView nBPCityWalkPreviewView10 = nBPCityWalkPreviewView7;
                                final float f28 = f18;
                                final float f29 = f16;
                                final float f36 = f17;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView11 = NBPCityWalkPreviewView.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPCityWalkPreviewView nBPCityWalkPreviewView12 = NBPCityWalkPreviewView.this;
                                                FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(d dVar) {
                                                        d dVar2 = dVar;
                                                        NBPCityWalkPreviewView nBPCityWalkPreviewView13 = NBPCityWalkPreviewView.this;
                                                        nBPCityWalkPreviewView13.textContentHeight$delegate.setValue(nBPCityWalkPreviewView13, NBPCityWalkPreviewView.$$delegatedProperties[1], Float.valueOf(dVar2.getHeight()));
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
                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView12 = NBPCityWalkPreviewView.this;
                                        final float f37 = f28;
                                        final float f38 = f29;
                                        final float f39 = f36;
                                        cd.a(vVar4, new Function1<TextAreaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextAreaView textAreaView) {
                                                TextAreaView textAreaView2 = textAreaView;
                                                final NBPCityWalkPreviewView nBPCityWalkPreviewView13 = NBPCityWalkPreviewView.this;
                                                textAreaView2.ref(textAreaView2, new Function1<aa<TextAreaView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<TextAreaView> aaVar) {
                                                        NBPCityWalkPreviewView.this.textAreaRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCityWalkPreviewView nBPCityWalkPreviewView14 = NBPCityWalkPreviewView.this;
                                                final float f46 = f37;
                                                final float f47 = f38;
                                                final float f48 = f39;
                                                textAreaView2.attr(new Function1<cc, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(cc ccVar) {
                                                        float coerceAtLeast;
                                                        cc ccVar2 = ccVar;
                                                        ccVar2.h(NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().isPreview() && ccVar2.getPagerData().l() > 700.0f);
                                                        ccVar2.mo153width(ccVar2.getPagerData().m() - 32);
                                                        ccVar2.alignSelfCenter();
                                                        ccVar2.w("\u8bf4\u70b9\u4ec0\u4e48\u5427...");
                                                        ccVar2.x(new h(10921638L, 1.0f));
                                                        cc.m(ccVar2, 17.0f, null, 2, null);
                                                        ccVar2.i(new h(0L, 1.0f));
                                                        ccVar2.v(800);
                                                        ccVar2.p();
                                                        ccVar2.j(!NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().isPublishing());
                                                        if (NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().isPublishing()) {
                                                            NBPCityWalkPreviewView.access$textareaBlur(NBPCityWalkPreviewView.this);
                                                        }
                                                        if (NBPCityWalkPreviewView.access$needFixSmallScreen(NBPCityWalkPreviewView.this)) {
                                                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(NBPCityWalkPreviewView.this.getKeyboardHeight() - ((f46 - f47) - f48), 0.0f);
                                                            ccVar2.mo141height(NBPCityWalkPreviewView.this.getTextContentHeight() - coerceAtLeast);
                                                            KLog.INSTANCE.i("NBPCityWalkPreviewPager", "textArea, heightLast: " + coerceAtLeast);
                                                        } else {
                                                            ccVar2.mo141height(NBPCityWalkPreviewView.this.getTextContentHeight() - NBPCityWalkPreviewView.this.getKeyboardHeight());
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCityWalkPreviewView nBPCityWalkPreviewView15 = NBPCityWalkPreviewView.this;
                                                textAreaView2.event(new Function1<TextAreaEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextAreaEvent textAreaEvent) {
                                                        TextAreaEvent textAreaEvent2 = textAreaEvent;
                                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView16 = NBPCityWalkPreviewView.this;
                                                        VisibilityEventKt.b(textAreaEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPCityWalkPreviewView.access$textareaAutofocus(NBPCityWalkPreviewView.this);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView17 = NBPCityWalkPreviewView.this;
                                                        FrameEventKt.g(textAreaEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().content = "";
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView18 = NBPCityWalkPreviewView.this;
                                                        textAreaEvent2.n(true, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.3.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(InputParams inputParams) {
                                                                String take;
                                                                take = StringsKt___StringsKt.take(inputParams.getText(), 800);
                                                                NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().content = take;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        textAreaEvent2.p(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.3.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u8d85\u8fc7\u5b57\u6570\u6700\u5927\u9650\u5236", QToastMode.Warning);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView19 = NBPCityWalkPreviewView.this;
                                                        TextAreaEvent.k(textAreaEvent2, false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.3.5
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(KeyboardParams keyboardParams) {
                                                                KeyboardParams keyboardParams2 = keyboardParams;
                                                                NBPCityWalkPreviewView nBPCityWalkPreviewView20 = NBPCityWalkPreviewView.this;
                                                                nBPCityWalkPreviewView20.keyboardHeight$delegate.setValue(nBPCityWalkPreviewView20, NBPCityWalkPreviewView.$$delegatedProperties[0], Float.valueOf(keyboardParams2.getHeight()));
                                                                KLog kLog = KLog.INSTANCE;
                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("keyboardHeight: ");
                                                                m3.append(keyboardParams2.getHeight());
                                                                kLog.i("NBPCityWalkPreviewPager", m3.toString());
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 1, null);
                                                        final NBPCityWalkPreviewView nBPCityWalkPreviewView20 = NBPCityWalkPreviewView.this;
                                                        textAreaEvent2.i(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView.body.1.7.1.3.3.3.6
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(InputParams inputParams) {
                                                                e jsonWithPreviewPgId = NBPCityWalkPreviewView.access$getAttr(NBPCityWalkPreviewView.this).getViewModel().jsonWithPreviewPgId();
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPCityWalkPreviewViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPCityWalkPreviewViewEvent();
    }

    public final float getKeyboardHeight() {
        return ((Number) this.keyboardHeight$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final float getTextContentHeight() {
        return ((Number) this.textContentHeight$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        if (((NBPCityWalkPreviewViewAttr) getAttr()).getViewModel().isPreview()) {
            e jsonWithPreviewPgId = ((NBPCityWalkPreviewViewAttr) getAttr()).getViewModel().jsonWithPreviewPgId();
            jsonWithPreviewPgId.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_pgout", jsonWithPreviewPgId);
        }
        KLog.INSTANCE.i("NBPCityWalkPreviewPager", Pager.PAGER_EVENT_WILL_DESTROY);
    }
}
