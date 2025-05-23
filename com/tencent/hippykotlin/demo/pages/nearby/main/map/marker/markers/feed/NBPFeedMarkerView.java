package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQContext;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerUIConfig;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.q;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.SliderPageAttr;
import com.tencent.kuikly.core.views.compose.SliderPageView;
import com.tencent.kuikly.core.views.compose.d;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPFeedMarkerView extends ComposeView<NBPFeedMarkerAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final float imageRenderRestoreScale;
    public final float imageRenderScale;
    public final boolean needScaleRenderImage;

    public NBPFeedMarkerView() {
        boolean isAndroid = QQContext.INSTANCE.isAndroid();
        this.needScaleRenderImage = isAndroid;
        float focusedScale = isAndroid ? NBPFeedMarkerUIConfig.Companion.getInstance().getFocusedScale() : 1.0f;
        this.imageRenderScale = focusedScale;
        this.imageRenderRestoreScale = 1.0f / focusedScale;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel = ((NBPFeedMarkerAttr) getAttr()).viewModel;
        if (nBPFeedMarkerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nBPFeedMarkerViewModel = null;
        }
        final NBPFeedMarkerUIConfig companion = NBPFeedMarkerUIConfig.Companion.getInstance();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.overflow(false);
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedMarkerViewModel nBPFeedMarkerViewModel2 = NBPFeedMarkerViewModel.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel3 = NBPFeedMarkerViewModel.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                String str;
                                NBPFeedMarkerViewModel nBPFeedMarkerViewModel4 = NBPFeedMarkerViewModel.this;
                                nBPFeedMarkerViewModel4.getClass();
                                e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_map_dynamics");
                                if (!nBPFeedMarkerViewModel4.hasImage) {
                                    str = FileReaderHelper.TXT_EXT;
                                } else {
                                    str = "pic";
                                }
                                jsonWithMainPgParamsImp.v("nearby_status_id", str);
                                jsonWithMainPgParamsImp.v("nearby_feed_id", nBPFeedMarkerViewModel4.feed.f440824d);
                                jsonWithMainPgParamsImp.u("nearby_tiny_id", UserDataManager.INSTANCE.getUserSelfInfo().tid);
                                jsonWithMainPgParamsImp.t("nearby_dynamic_fish_type", 1);
                                jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig = companion;
                final NBPFeedMarkerViewModel nBPFeedMarkerViewModel3 = NBPFeedMarkerViewModel.this;
                final NBPFeedMarkerView nBPFeedMarkerView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig2 = NBPFeedMarkerUIConfig.this;
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel4 = nBPFeedMarkerViewModel3;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig3 = NBPFeedMarkerUIConfig.this;
                                tVar2.size(nBPFeedMarkerUIConfig3.bubbleWidth, nBPFeedMarkerUIConfig3.bubbleHeight);
                                tVar2.flexDirectionColumn();
                                tVar2.overflow(false);
                                MarkerViewExtKt.bindMarkerStatusChange(tVar2, nBPFeedMarkerViewModel4, 0.0f);
                                tVar2.overflow(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel5 = nBPFeedMarkerViewModel3;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPFeedMarkerViewModel nBPFeedMarkerViewModel6 = NBPFeedMarkerViewModel.this;
                                MarkerViewExtKt.bindMarkerPopShow(uVar, nBPFeedMarkerViewModel6.anchor, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPFeedMarkerViewModel.this.readyToFocus = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig3 = NBPFeedMarkerUIConfig.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig4 = NBPFeedMarkerUIConfig.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        b.a.b(afVar2, NBPFeedMarkerUIConfig.this.bubbleBgUrl, false, 2, null);
                                        afVar2.mo153width(NBPFeedMarkerUIConfig.this.bubbleBgWidth);
                                        afVar2.mo141height(NBPFeedMarkerUIConfig.this.bubbleBgHeight);
                                        afVar2.absolutePositionAllZero();
                                        afVar2.m142left(NBPFeedMarkerUIConfig.this.bubbleBgX);
                                        afVar2.m150top(NBPFeedMarkerUIConfig.this.bubbleBgY);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig4 = NBPFeedMarkerUIConfig.this;
                        final float f16 = (nBPFeedMarkerUIConfig4.bubbleWidth - nBPFeedMarkerUIConfig4.imageWidth) / 2.0f;
                        final float f17 = nBPFeedMarkerUIConfig4.bubblePaddingTop;
                        final NBPFeedMarkerView nBPFeedMarkerView2 = nBPFeedMarkerView;
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel6 = nBPFeedMarkerViewModel3;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig5 = nBPFeedMarkerUIConfig4;
                                final float f18 = f17;
                                final float f19 = f16;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig6 = NBPFeedMarkerUIConfig.this;
                                        tVar2.size(nBPFeedMarkerUIConfig6.imageWidth, nBPFeedMarkerUIConfig6.imageHeight);
                                        tVar2.borderRadius(NBPFeedMarkerUIConfig.this.imageRadius);
                                        Attr.absolutePosition$default(tVar2, f18, f19, 0.0f, 0.0f, 12, null);
                                        tVar2.overflow(true);
                                        return Unit.INSTANCE;
                                    }
                                });
                                NBPFeedMarkerView nBPFeedMarkerView3 = NBPFeedMarkerView.this;
                                n35.v topFeedImageNode = nBPFeedMarkerViewModel6.getTopFeedImageNode();
                                String topFeedTitle = nBPFeedMarkerViewModel6.getTopFeedTitle();
                                int i3 = NBPFeedMarkerView.$r8$clinit;
                                NBPFeedMarkerUIConfig.Companion companion2 = NBPFeedMarkerUIConfig.Companion;
                                float f26 = companion2.getInstance().imageWidth;
                                float f27 = companion2.getInstance().imageHeight;
                                nBPFeedMarkerView3.getClass();
                                new NBPFeedMarkerView$buildContent$1(f26, f27, topFeedImageNode, companion2.getInstance(), false, nBPFeedMarkerView3, topFeedTitle).invoke(vVar4);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel7 = nBPFeedMarkerViewModel3;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NBPFeedMarkerViewModel.this.isFocused() && NBPFeedMarkerViewModel.this.getShowSlider());
                            }
                        };
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel8 = nBPFeedMarkerViewModel3;
                        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig5 = NBPFeedMarkerUIConfig.this;
                        final NBPFeedMarkerView nBPFeedMarkerView3 = nBPFeedMarkerView;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final ArrayList arrayList;
                                ConditionView conditionView2 = conditionView;
                                NBPFeedMarkerViewModel nBPFeedMarkerViewModel9 = NBPFeedMarkerViewModel.this;
                                if (nBPFeedMarkerViewModel9.isFocused() && nBPFeedMarkerViewModel9.getShowSlider()) {
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(new NBPFeedMarkerSliderItem(nBPFeedMarkerViewModel9.getTopFeedImageNode(), nBPFeedMarkerViewModel9.getTopFeedTitle()));
                                    Iterator<NBPMapMarker> it = nBPFeedMarkerViewModel9.collectionMarkers.iterator();
                                    while (it.hasNext()) {
                                        Object obj = it.next().data;
                                        NBPFeedMarkerViewModel nBPFeedMarkerViewModel10 = obj instanceof NBPFeedMarkerViewModel ? (NBPFeedMarkerViewModel) obj : null;
                                        if (nBPFeedMarkerViewModel10 != null) {
                                            arrayList2.add(new NBPFeedMarkerSliderItem(nBPFeedMarkerViewModel10.getTopFeedImageNode(), nBPFeedMarkerViewModel10.getTopFeedTitle()));
                                        }
                                    }
                                    arrayList = arrayList2;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    KLog kLog = KLog.INSTANCE;
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u5c55\u793a\u8f6e\u64ad\u56fe ");
                                    m3.append(arrayList.size());
                                    kLog.d("NBPFeedMarkerView", m3.toString());
                                    final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig6 = nBPFeedMarkerUIConfig5;
                                    float f18 = 1;
                                    final float f19 = nBPFeedMarkerUIConfig6.imageWidth + f18;
                                    final float f26 = nBPFeedMarkerUIConfig6.imageHeight + f18;
                                    final float f27 = f17;
                                    final float f28 = f16;
                                    final NBPFeedMarkerView nBPFeedMarkerView4 = nBPFeedMarkerView3;
                                    final NBPFeedMarkerViewModel nBPFeedMarkerViewModel11 = NBPFeedMarkerViewModel.this;
                                    com.tencent.kuikly.core.views.compose.e.a(conditionView2, new Function1<SliderPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(SliderPageView sliderPageView) {
                                            SliderPageView sliderPageView2 = sliderPageView;
                                            final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig7 = NBPFeedMarkerUIConfig.this;
                                            final float f29 = f27;
                                            final float f36 = f28;
                                            final float f37 = f19;
                                            final float f38 = f26;
                                            final List<NBPFeedMarkerSliderItem> list = arrayList;
                                            final NBPFeedMarkerView nBPFeedMarkerView5 = nBPFeedMarkerView4;
                                            sliderPageView2.attr(new Function1<SliderPageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(SliderPageAttr sliderPageAttr) {
                                                    SliderPageAttr sliderPageAttr2 = sliderPageAttr;
                                                    NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig8 = NBPFeedMarkerUIConfig.this;
                                                    sliderPageAttr2.size(nBPFeedMarkerUIConfig8.imageWidth, nBPFeedMarkerUIConfig8.imageHeight);
                                                    sliderPageAttr2.borderRadius(NBPFeedMarkerUIConfig.this.imageRadius);
                                                    Attr.absolutePosition$default(sliderPageAttr2, f29, f36, 0.0f, 0.0f, 12, null);
                                                    sliderPageAttr2.overflow(true);
                                                    sliderPageAttr2.u(f37);
                                                    sliderPageAttr2.t(f38);
                                                    sliderPageAttr2.s(1000);
                                                    sliderPageAttr2.v(false);
                                                    List<NBPFeedMarkerSliderItem> list2 = list;
                                                    final NBPFeedMarkerView nBPFeedMarkerView6 = nBPFeedMarkerView5;
                                                    final float f39 = f37;
                                                    final float f46 = f38;
                                                    sliderPageAttr2.o(list2, new Function2<PageListView<?, ?>, NBPFeedMarkerSliderItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(PageListView<?, ?> pageListView, NBPFeedMarkerSliderItem nBPFeedMarkerSliderItem) {
                                                            NBPFeedMarkerSliderItem nBPFeedMarkerSliderItem2 = nBPFeedMarkerSliderItem;
                                                            NBPFeedMarkerView nBPFeedMarkerView7 = NBPFeedMarkerView.this;
                                                            n35.v vVar3 = nBPFeedMarkerSliderItem2.image;
                                                            String str = nBPFeedMarkerSliderItem2.text;
                                                            float f47 = f39;
                                                            float f48 = f46;
                                                            int i3 = NBPFeedMarkerView.$r8$clinit;
                                                            nBPFeedMarkerView7.getClass();
                                                            new NBPFeedMarkerView$buildContent$1(f47, f48, vVar3, NBPFeedMarkerUIConfig.Companion.getInstance(), true, nBPFeedMarkerView7, str).invoke(pageListView);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPFeedMarkerViewModel nBPFeedMarkerViewModel12 = nBPFeedMarkerViewModel11;
                                            final List<NBPFeedMarkerSliderItem> list2 = arrayList;
                                            sliderPageView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(d dVar) {
                                                    final d dVar2 = dVar;
                                                    final NBPFeedMarkerViewModel nBPFeedMarkerViewModel13 = NBPFeedMarkerViewModel.this;
                                                    final List<NBPFeedMarkerSliderItem> list3 = list2;
                                                    dVar2.pageIndexDidChanged(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Object obj2) {
                                                            e eVar = obj2 instanceof e ? (e) obj2 : null;
                                                            if (eVar != null) {
                                                                int k3 = eVar.k("index", -1);
                                                                AbstractBaseView<?, ?> view = d.this.getView();
                                                                SliderPageView sliderPageView3 = view instanceof SliderPageView ? (SliderPageView) view : null;
                                                                if (sliderPageView3 != null) {
                                                                    final NBPFeedMarkerViewModel nBPFeedMarkerViewModel14 = nBPFeedMarkerViewModel13;
                                                                    List<NBPFeedMarkerSliderItem> list4 = list3;
                                                                    if (k3 == 1) {
                                                                        nBPFeedMarkerViewModel14.slidesImplReported = true;
                                                                        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                                                        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_dynamic");
                                                                        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                                                        ((SliderPageAttr) sliderPageView3.getViewAttr()).s(TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
                                                                        sliderPageView3.z();
                                                                        sliderPageView3.y();
                                                                    }
                                                                    if (k3 >= Math.min(2, list4.size() - 1)) {
                                                                        sliderPageView3.z();
                                                                        nBPFeedMarkerViewModel14.getClass();
                                                                        nBPFeedMarkerViewModel14.showSliderMoreBtnDelayHandle = TimerKt.d(FSUploadConst.ERR_FILE_NOT_EXIST, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel$showSliderMoreBtn$4
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Unit invoke() {
                                                                                NBPFeedMarkerViewModel nBPFeedMarkerViewModel15 = NBPFeedMarkerViewModel.this;
                                                                                nBPFeedMarkerViewModel15.showSliderMoreBtn$delegate.setValue(nBPFeedMarkerViewModel15, NBPFeedMarkerViewModel.$$delegatedProperties[4], Boolean.TRUE);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    }
                                                                }
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
                                    final NBPFeedMarkerViewModel nBPFeedMarkerViewModel12 = NBPFeedMarkerViewModel.this;
                                    Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            NBPFeedMarkerViewModel nBPFeedMarkerViewModel13 = NBPFeedMarkerViewModel.this;
                                            return Boolean.valueOf(((Boolean) nBPFeedMarkerViewModel13.showSliderMoreBtn$delegate.getValue(nBPFeedMarkerViewModel13, NBPFeedMarkerViewModel.$$delegatedProperties[4])).booleanValue());
                                        }
                                    };
                                    final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig7 = nBPFeedMarkerUIConfig5;
                                    final float f29 = f17;
                                    final float f36 = f16;
                                    ConditionViewKt.c(conditionView2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ConditionView conditionView3) {
                                            final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig8 = NBPFeedMarkerUIConfig.this;
                                            final float f37 = f29;
                                            final float f38 = f36;
                                            ECTransitionViewKt.TransitionFadeInOutView(conditionView3, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECTransitionView eCTransitionView) {
                                                    ECTransitionView eCTransitionView2 = eCTransitionView;
                                                    final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig9 = NBPFeedMarkerUIConfig.this;
                                                    final float f39 = f37;
                                                    final float f46 = f38;
                                                    eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.3.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                            ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                                            NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig10 = NBPFeedMarkerUIConfig.this;
                                                            eCTransitionAttr2.size(nBPFeedMarkerUIConfig10.imageWidth, nBPFeedMarkerUIConfig10.imageHeight);
                                                            eCTransitionAttr2.borderRadius(NBPFeedMarkerUIConfig.this.imageRadius);
                                                            Attr.absolutePosition$default(eCTransitionAttr2, f39, f46, 0.0f, 0.0f, 12, null);
                                                            eCTransitionAttr2.mo113backgroundColor(h.INSTANCE.a(0.5f));
                                                            eCTransitionAttr2.flexDirectionColumn();
                                                            eCTransitionAttr2.alignItemsCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(eCTransitionView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.3.1.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.3.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    b.a.b(afVar2, NBPFeedMarkerUIConfig.Companion.getInstance().sliderMoreIcon, false, 2, null);
                                                                    afVar2.size(13.33f);
                                                                    afVar2.o();
                                                                    afVar2.marginTop(10.0f);
                                                                    afVar2.marginBottom(5.33f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(eCTransitionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.3.1.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.6.3.1.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    TextViewExtKt.textWithLineHeightFix(ceVar2, "\u67e5\u770b\u66f4\u591a");
                                                                    ce.fontSize$default(ceVar2, 9.0f, null, 2, null);
                                                                    ceVar2.color(h.INSTANCE.m());
                                                                    ceVar2.lineHeight(13.33f);
                                                                    ceVar2.fontWeight400();
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
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel9 = nBPFeedMarkerViewModel3;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.7
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NBPFeedMarkerViewModel.this.getCollectionCount();
                            }
                        };
                        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig6 = NBPFeedMarkerUIConfig.this;
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel10 = nBPFeedMarkerViewModel3;
                        BindDirectivesViewKt.a(vVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig7 = NBPFeedMarkerUIConfig.this;
                                final NBPFeedMarkerViewModel nBPFeedMarkerViewModel11 = nBPFeedMarkerViewModel10;
                                w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.8.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig8 = NBPFeedMarkerUIConfig.this;
                                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel12 = nBPFeedMarkerViewModel11;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.8.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig9 = NBPFeedMarkerUIConfig.this;
                                                Attr.absolutePosition$default(tVar2, nBPFeedMarkerUIConfig9.redDotPosTop, 0.0f, 0.0f, nBPFeedMarkerUIConfig9.redDotPosRight, 6, null);
                                                tVar2.mo141height(NBPFeedMarkerUIConfig.this.redDotHeight);
                                                tVar2.m146minWidth(NBPFeedMarkerUIConfig.this.redDotHeight);
                                                tVar2.paddingLeft(NBPFeedMarkerUIConfig.this.redDotPaddingH);
                                                tVar2.paddingRight(NBPFeedMarkerUIConfig.this.redDotPaddingH);
                                                tVar2.borderRadius(NBPFeedMarkerUIConfig.this.redDotRadius);
                                                tVar2.m152visibility(nBPFeedMarkerViewModel12.getCollectionCount() != null);
                                                h.Companion companion2 = h.INSTANCE;
                                                tVar2.mo113backgroundColor(companion2.m());
                                                tVar2.allCenter();
                                                tVar2.transform(new com.tencent.kuikly.core.base.u(0.1f, 0.1f));
                                                tVar2.mo139boxShadow(new g(0.0f, 0.4f, 0.79f, companion2.a(0.15f)));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.8.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final u uVar2 = uVar;
                                                VisibilityEventKt.e(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.8.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        AbstractBaseView<?, ?> view = u.this.getView();
                                                        if (view != null) {
                                                            q.a.a(view, com.tencent.kuikly.core.base.b.INSTANCE.s(0.5f, 0.5f, 1.0f, "marker_view_animation_key_pop_show"), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.8.1.2.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Attr attr) {
                                                                    attr.transform(new com.tencent.kuikly.core.base.u(1.0f, 1.0f));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }, 2, null);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel13 = nBPFeedMarkerViewModel11;
                                        final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig9 = NBPFeedMarkerUIConfig.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.8.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPFeedMarkerViewModel nBPFeedMarkerViewModel14 = NBPFeedMarkerViewModel.this;
                                                final NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig10 = nBPFeedMarkerUIConfig9;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerView.body.1.3.8.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text(String.valueOf(NBPFeedMarkerViewModel.this.getCollectionCount()));
                                                        ce.fontSize$default(ceVar2, nBPFeedMarkerUIConfig10.redDotFontSize, null, 2, null);
                                                        ceVar2.lineHeight(nBPFeedMarkerUIConfig10.redDotLineHeight);
                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                        ceVar2.fontWeight700();
                                                        ceVar2.fontFamily("Inter");
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
        return new NBPFeedMarkerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
