package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerRect;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerTransform;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPMarkerGuideView extends ComposeView<NBPMarkerGuideViewAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMarkerGuideView.class, "startViewAnimate", "getStartViewAnimate()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMarkerGuideView.class, CanvasView.ACTION_TRANSLATE, "getTranslate()Lcom/tencent/kuikly/core/base/Translate;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMarkerGuideView.class, "scale", "getScale()Lcom/tencent/kuikly/core/base/Scale;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMarkerGuideView.class, "txtPosX", "getTxtPosX()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMarkerGuideView.class, "txtPosY", "getTxtPosY()F", 0)};
    public final ReadWriteProperty scale$delegate;
    public final ReadWriteProperty translate$delegate;
    public final ReadWriteProperty txtPosX$delegate;
    public final ReadWriteProperty txtPosY$delegate;

    public NBPMarkerGuideView() {
        c.a(Boolean.FALSE);
        this.translate$delegate = c.a(y.INSTANCE.a());
        this.scale$delegate = c.a(u.INSTANCE.a());
        Float valueOf = Float.valueOf(0.0f);
        this.txtPosX$delegate = c.a(valueOf);
        this.txtPosY$delegate = c.a(valueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPMarkerGuideViewAttr access$getAttr(NBPMarkerGuideView nBPMarkerGuideView) {
        return (NBPMarkerGuideViewAttr) nBPMarkerGuideView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleClickMarker(final NBPMarkerGuideView nBPMarkerGuideView) {
        nBPMarkerGuideView.getClass();
        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
        jsonWithMainPgParams.v("dt_eid", "em_nearby_cover_guide_bubble");
        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
        Object obj = ((NBPMarkerGuideViewAttr) nBPMarkerGuideView.getAttr()).getMarker().data;
        NBPFeedMarkerViewModel nBPFeedMarkerViewModel = obj instanceof NBPFeedMarkerViewModel ? (NBPFeedMarkerViewModel) obj : null;
        if (nBPFeedMarkerViewModel != null) {
            nBPFeedMarkerViewModel.onClickMarker();
        }
        TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView$handleClickMarker$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPViewModelStoreKt.getGuideViewModel(NBPMainKtxKt.getNbpVMStore(NBPMarkerGuideView.this.getPager())).setShowMarkerTouchGuide(false);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        y a16;
        u a17;
        final NBPGuideViewModel guideViewModel = NBPViewModelStoreKt.getGuideViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        NBPMarkerTransform nBPMarkerTransform = ((NBPMarkerGuideViewAttr) getAttr()).getMarker().viewPositionTransform;
        if (nBPMarkerTransform == null || (a16 = nBPMarkerTransform.translate) == null) {
            a16 = y.INSTANCE.a();
        }
        ReadWriteProperty readWriteProperty = this.translate$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[1], a16);
        NBPMarkerTransform nBPMarkerTransform2 = ((NBPMarkerGuideViewAttr) getAttr()).getMarker().viewPositionTransform;
        if (nBPMarkerTransform2 == null || (a17 = nBPMarkerTransform2.scale) == null) {
            a17 = u.INSTANCE.a();
        }
        this.scale$delegate.setValue(this, kPropertyArr[2], a17);
        MarkerRect markerRectOnScreen = ((NBPMarkerGuideViewAttr) getAttr()).getMarker().getMarkerRectOnScreen();
        if (markerRectOnScreen.getCenterX() <= 160.0f) {
            setTxtPosX(markerRectOnScreen.right + 12.0f);
            setTxtPosY(markerRectOnScreen.top + 26.0f);
        } else if (markerRectOnScreen.getCenterX() >= getPagerData().m() - 160.0f) {
            setTxtPosX((markerRectOnScreen.left - 160.0f) - 12.0f);
            setTxtPosY(markerRectOnScreen.top + 26.0f);
        } else if (markerRectOnScreen.getCenterY() > getPagerData().l() / 2) {
            setTxtPosX(markerRectOnScreen.getCenterX() - 80.0f);
            setTxtPosY((markerRectOnScreen.top - 52.0f) - 12.0f);
        } else {
            setTxtPosX(markerRectOnScreen.getCenterX() - 80.0f);
            setTxtPosY(markerRectOnScreen.bottom + 42.0f);
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        mVar2.mo113backgroundColor(new h(0L, 0.5f));
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideViewModel nBPGuideViewModel = NBPGuideViewModel.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPGuideViewModel nBPGuideViewModel2 = NBPGuideViewModel.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPGuideViewModel.this.setShowMarkerTouchGuide(false);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMarkerGuideView nBPMarkerGuideView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPMarkerGuideView nBPMarkerGuideView2 = NBPMarkerGuideView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                NBPMarkerGuideView nBPMarkerGuideView3 = NBPMarkerGuideView.this;
                                ReadWriteProperty readWriteProperty2 = nBPMarkerGuideView3.txtPosX$delegate;
                                KProperty<?>[] kPropertyArr2 = NBPMarkerGuideView.$$delegatedProperties;
                                tVar2.m142left(((Number) readWriteProperty2.getValue(nBPMarkerGuideView3, kPropertyArr2[3])).floatValue());
                                NBPMarkerGuideView nBPMarkerGuideView4 = NBPMarkerGuideView.this;
                                tVar2.m150top(((Number) nBPMarkerGuideView4.txtPosY$delegate.getValue(nBPMarkerGuideView4, kPropertyArr2[4])).floatValue());
                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                tVar2.borderRadius(4.0f);
                                tVar2.mo141height(52.0f);
                                tVar2.size(160.0f, 52.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.mo153width(140.0f);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.text("\u70b9\u51fb\u53ef\u67e5\u770b\u66f4\u591a\u9644\u8fd1\u5185\u5bb9\u54e6");
                                        ceVar2.lines(2);
                                        ceVar2.textOverFlowTail();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMarkerGuideView nBPMarkerGuideView3 = NBPMarkerGuideView.this;
                        vVar2.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                final NBPMarkerGuideView nBPMarkerGuideView4 = NBPMarkerGuideView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPMarkerGuideView.access$handleClickMarker(NBPMarkerGuideView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMarkerGuideView nBPMarkerGuideView2 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPMarkerGuideView nBPMarkerGuideView3 = NBPMarkerGuideView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                tVar2.m150top(0.0f);
                                tVar2.m142left(0.0f);
                                tVar2.size(NBPMarkerGuideView.access$getAttr(NBPMarkerGuideView.this).getMarker().markerViewSize.getWidth(), NBPMarkerGuideView.access$getAttr(NBPMarkerGuideView.this).getMarker().markerViewSize.getHeight());
                                NBPMarkerGuideView nBPMarkerGuideView4 = NBPMarkerGuideView.this;
                                ReadWriteProperty readWriteProperty2 = nBPMarkerGuideView4.translate$delegate;
                                KProperty<?>[] kPropertyArr2 = NBPMarkerGuideView.$$delegatedProperties;
                                y yVar = (y) readWriteProperty2.getValue(nBPMarkerGuideView4, kPropertyArr2[1]);
                                NBPMarkerGuideView nBPMarkerGuideView5 = NBPMarkerGuideView.this;
                                d.a.a(tVar2, null, (u) nBPMarkerGuideView5.scale$delegate.getValue(nBPMarkerGuideView5, kPropertyArr2[2]), yVar, null, null, 25, null);
                                tVar2.m152visibility(NBPMarkerGuideView.access$getAttr(NBPMarkerGuideView.this).getMarker().isVisibleOnMap);
                                return Unit.INSTANCE;
                            }
                        });
                        NBPMarkerGuideView.access$getAttr(NBPMarkerGuideView.this).getMarker().markerViewBuilder.invoke(vVar2);
                        final NBPMarkerGuideView nBPMarkerGuideView4 = NBPMarkerGuideView.this;
                        vVar2.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                com.tencent.kuikly.core.views.u uVar2 = uVar;
                                final NBPMarkerGuideView nBPMarkerGuideView5 = NBPMarkerGuideView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPMarkerGuideView.access$handleClickMarker(NBPMarkerGuideView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView.body.1.4.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                        jsonWithMainPgParams.v("dt_eid", "em_nearby_cover_guide_bubble");
                                        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParams);
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
        return new NBPMarkerGuideViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    public final void setTxtPosX(float f16) {
        this.txtPosX$delegate.setValue(this, $$delegatedProperties[3], Float.valueOf(f16));
    }

    public final void setTxtPosY(float f16) {
        this.txtPosY$delegate.setValue(this, $$delegatedProperties[4], Float.valueOf(f16));
    }
}
