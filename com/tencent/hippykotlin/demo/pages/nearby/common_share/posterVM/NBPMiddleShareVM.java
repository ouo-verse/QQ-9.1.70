package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM;

import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PageLoadTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterViewEvent;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPMiddleShareVM extends NBPBaseShareVM<NearbyMiddlePosterData> {
    public static final Companion Companion = new Companion();
    public final Lazy middleViewBuilder$delegate;
    public PageLoadTechReporter pageLoadReporter;
    public NearbyMiddlePosterData posterData;
    public final NBPBaseShareVM<NearbyMiddlePosterData> shareVM;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public NBPMiddleShareVM(int i3, NBPBaseShareVM<NearbyMiddlePosterData> nBPBaseShareVM, NearbyMiddlePosterData nearbyMiddlePosterData, Function2<? super Boolean, ? super String, Unit> function2) {
        super(i3);
        Lazy lazy;
        this.shareVM = nBPBaseShareVM;
        this.posterData = nearbyMiddlePosterData;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM$middleViewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPMiddleShareVM nBPMiddleShareVM = NBPMiddleShareVM.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM$middleViewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPMiddleShareVM nBPMiddleShareVM2 = NBPMiddleShareVM.this;
                        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPMiddleShareVM nBPMiddleShareVM3 = NBPMiddleShareVM.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        float posterContainerHeight = ((NBPMiddleShareVM.this.shareVM.getPosterContainerHeight() * 0.75f) / 424.0f) * 0.5f;
                                        u uVar = new u(posterContainerHeight, posterContainerHeight);
                                        boolean z16 = NBPMiddleShareVM.this.shareVM.getPosterContainerHeight() > 0.0f;
                                        tVar2.borderRadius(8.0f);
                                        tVar2.transform(uVar);
                                        tVar2.m147opacity(z16 ? 1.0f : 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMiddleShareVM nBPMiddleShareVM4 = NBPMiddleShareVM.this;
                                ECTransitionViewKt.TransitionFadeInOutView(vVar2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionView eCTransitionView) {
                                        ECTransitionView eCTransitionView2 = eCTransitionView;
                                        final NBPMiddleShareVM nBPMiddleShareVM5 = NBPMiddleShareVM.this;
                                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                                NBPMiddleShareVM nBPMiddleShareVM6 = NBPMiddleShareVM.this;
                                                if (nBPMiddleShareVM6.shareVM.isDataReady() && nBPMiddleShareVM6.shareVM.isMainViewRendered() && nBPMiddleShareVM6.shareVM.isQQArkViewRendered() && nBPMiddleShareVM6.shareVM.isWXArkViewRendered()) {
                                                    nBPMiddleShareVM6.shareVM.isPageClosed();
                                                }
                                                eCTransitionAttr2.setTransitionAppear(true);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMiddleShareVM nBPMiddleShareVM6 = NBPMiddleShareVM.this;
                                        eCTransitionView2.addChild(new NBPPoiPosterView(), new Function1<NBPPoiPosterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPPoiPosterView nBPPoiPosterView) {
                                                NBPPoiPosterView nBPPoiPosterView2 = nBPPoiPosterView;
                                                NBPMiddleShareVM.this.shareVM.shareMainViewTag = Integer.valueOf(nBPPoiPosterView2.getNativeRef());
                                                final NBPMiddleShareVM nBPMiddleShareVM7 = NBPMiddleShareVM.this;
                                                nBPPoiPosterView2.ref(nBPPoiPosterView2, new Function1<aa<NBPPoiPosterView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<NBPPoiPosterView> aaVar) {
                                                        NBPMiddleShareVM.this.shareVM.shareMiddleMainViewRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPMiddleShareVM nBPMiddleShareVM8 = NBPMiddleShareVM.this;
                                                nBPPoiPosterView2.attr(new Function1<NBPPoiPosterViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPPoiPosterViewAttr nBPPoiPosterViewAttr) {
                                                        NBPPoiPosterViewAttr nBPPoiPosterViewAttr2 = nBPPoiPosterViewAttr;
                                                        nBPPoiPosterViewAttr2.mo113backgroundColor(h.INSTANCE.m());
                                                        nBPPoiPosterViewAttr2.size(630.0f, 848.0f);
                                                        nBPPoiPosterViewAttr2.f114217vm = NBPMiddleShareVM.this.shareVM;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPMiddleShareVM nBPMiddleShareVM9 = NBPMiddleShareVM.this;
                                                nBPPoiPosterView2.event(new Function1<NBPPoiPosterViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.2.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPPoiPosterViewEvent nBPPoiPosterViewEvent) {
                                                        final NBPPoiPosterViewEvent nBPPoiPosterViewEvent2 = nBPPoiPosterViewEvent;
                                                        final NBPMiddleShareVM nBPMiddleShareVM10 = NBPMiddleShareVM.this;
                                                        nBPPoiPosterViewEvent2.onReadyToCaptureListener = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.2.2.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                KLog.INSTANCE.i("NBPMiddleShareVM", "poi poster view ready to capture");
                                                                NBPPoiPosterViewEvent nBPPoiPosterViewEvent3 = NBPPoiPosterViewEvent.this;
                                                                final NBPMiddleShareVM nBPMiddleShareVM11 = nBPMiddleShareVM10;
                                                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMiddleShareVM.middleViewBuilder.2.1.1.2.2.3.1.1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        AsyncTaskTracker<Unit> asyncTaskTracker = NBPMiddleShareVM.this.shareVM.shareMainViewReadyToCapture;
                                                                        Unit unit = Unit.INSTANCE;
                                                                        asyncTaskTracker.markDone(unit);
                                                                        return unit;
                                                                    }
                                                                };
                                                                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                                TimerKt.e(nBPPoiPosterViewEvent3.getPagerId(), 250, function0);
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
                        return Unit.INSTANCE;
                    }
                };
            }
        });
        this.middleViewBuilder$delegate = lazy;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM
    public final NearbyMiddlePosterData getPosterData() {
        return this.posterData;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM
    public final void setPosterData(NearbyMiddlePosterData nearbyMiddlePosterData) {
        this.posterData = nearbyMiddlePosterData;
    }
}
