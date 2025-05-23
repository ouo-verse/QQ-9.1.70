package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM;

import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PageLoadTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemePosterConfig;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedShareVM extends NBPBaseShareVM<NearbyFeedPosterData> {
    public static final Companion Companion = new Companion();
    public final Lazy feedViewBuilder$delegate;
    public final Function2<Boolean, String, Unit> handleError;
    public PageLoadTechReporter pageLoadReporter;
    public NearbyFeedPosterData posterData;
    public final NBPBaseShareVM<NearbyFeedPosterData> shareVM;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NBPFeedShareVM(int i3, NBPBaseShareVM<NearbyFeedPosterData> nBPBaseShareVM, NearbyFeedPosterData nearbyFeedPosterData, Function2<? super Boolean, ? super String, Unit> function2) {
        super(i3);
        Lazy lazy;
        this.shareVM = nBPBaseShareVM;
        this.posterData = nearbyFeedPosterData;
        this.handleError = function2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM$feedViewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPFeedShareVM nBPFeedShareVM = NBPFeedShareVM.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM$feedViewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        ViewContainer<?, ?> viewContainer2 = viewContainer;
                        final NBPFeedShareVM nBPFeedShareVM2 = NBPFeedShareVM.this;
                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPFeedShareVM nBPFeedShareVM3 = NBPFeedShareVM.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        float posterContainerHeight = ((NBPFeedShareVM.this.shareVM.getPosterContainerHeight() * 0.75f) / 424.0f) * 0.5f;
                                        u uVar = new u(posterContainerHeight, posterContainerHeight);
                                        boolean z16 = NBPFeedShareVM.this.shareVM.getPosterContainerHeight() > 0.0f;
                                        tVar2.borderRadius(8.0f);
                                        tVar2.transform(uVar);
                                        tVar2.m147opacity(z16 ? 1.0f : 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedShareVM nBPFeedShareVM4 = NBPFeedShareVM.this;
                                ECTransitionViewKt.TransitionFadeInOutView(vVar2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionView eCTransitionView) {
                                        ECTransitionView eCTransitionView2 = eCTransitionView;
                                        final NBPFeedShareVM nBPFeedShareVM5 = NBPFeedShareVM.this;
                                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                eCTransitionAttr.setTransitionAppear(NBPFeedShareVM.access$isReadyToShowShare(NBPFeedShareVM.this));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedShareVM nBPFeedShareVM6 = NBPFeedShareVM.this;
                                        NearbyFeedPosterViewKt.NearbyFeedPoster(eCTransitionView2, new Function1<NearbyFeedPosterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyFeedPosterView nearbyFeedPosterView) {
                                                NearbyFeedPosterView nearbyFeedPosterView2 = nearbyFeedPosterView;
                                                NBPFeedShareVM.this.shareVM.shareMainViewTag = Integer.valueOf(nearbyFeedPosterView2.getNativeRef());
                                                final NBPFeedShareVM nBPFeedShareVM7 = NBPFeedShareVM.this;
                                                nearbyFeedPosterView2.ref(nearbyFeedPosterView2, new Function1<aa<NearbyFeedPosterView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<NearbyFeedPosterView> aaVar) {
                                                        NBPFeedShareVM.this.shareVM.shareFeedMainViewRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedShareVM nBPFeedShareVM8 = NBPFeedShareVM.this;
                                                nearbyFeedPosterView2.attr(new Function1<NearbyFeedPosterViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NearbyFeedPosterViewAttr nearbyFeedPosterViewAttr) {
                                                        NearbyFeedPosterViewAttr nearbyFeedPosterViewAttr2 = nearbyFeedPosterViewAttr;
                                                        NBPFeedShareVM nBPFeedShareVM9 = NBPFeedShareVM.this;
                                                        nearbyFeedPosterViewAttr2.data = nBPFeedShareVM9.posterData;
                                                        nearbyFeedPosterViewAttr2.config = nBPFeedShareVM9.getPosterConfig();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedShareVM nBPFeedShareVM9 = NBPFeedShareVM.this;
                                                nearbyFeedPosterView2.event(new Function1<NearbyFeedPosterViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NearbyFeedPosterViewEvent nearbyFeedPosterViewEvent) {
                                                        NearbyFeedPosterViewEvent nearbyFeedPosterViewEvent2 = nearbyFeedPosterViewEvent;
                                                        final NBPFeedShareVM nBPFeedShareVM10 = NBPFeedShareVM.this;
                                                        nearbyFeedPosterViewEvent2.onReadyToShowListener = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2.3.1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                Long l3;
                                                                KLog.INSTANCE.i("NBPFeedShareVM", "main poster ready to show");
                                                                NBPFeedShareVM.this.shareVM.setMainViewRendered();
                                                                PageLoadTechReporter pageLoadTechReporter = NBPFeedShareVM.this.pageLoadReporter;
                                                                if (pageLoadTechReporter != null && (l3 = pageLoadTechReporter.part2StartTime) != null) {
                                                                    pageLoadTechReporter.part2Time = Integer.valueOf((int) (APICallTechReporterKt.NBPCurrentTime() - l3.longValue()));
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        final NBPFeedShareVM nBPFeedShareVM11 = NBPFeedShareVM.this;
                                                        nearbyFeedPosterViewEvent2.onReadyToCaptureListener = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2.3.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                KLog.INSTANCE.i("NBPFeedShareVM", "main poster ready to capture");
                                                                AsyncTaskTracker<Unit> asyncTaskTracker = NBPFeedShareVM.this.shareVM.shareMainViewReadyToCapture;
                                                                Unit unit = Unit.INSTANCE;
                                                                asyncTaskTracker.markDone(unit);
                                                                return unit;
                                                            }
                                                        };
                                                        final NBPFeedShareVM nBPFeedShareVM12 = NBPFeedShareVM.this;
                                                        nearbyFeedPosterViewEvent2.register("setQRCodeState", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2.3.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                e eVar = obj instanceof e ? (e) obj : null;
                                                                Boolean valueOf = eVar != null ? Boolean.valueOf(eVar.f("state")) : null;
                                                                NBPBaseShareVM<NearbyFeedPosterData> nBPBaseShareVM2 = NBPFeedShareVM.this.shareVM;
                                                                nBPBaseShareVM2.isQRCodeRendering$delegate.setValue(nBPBaseShareVM2, NBPBaseShareVM.$$delegatedProperties[6], Boolean.valueOf(valueOf != null ? valueOf.booleanValue() : false));
                                                                if (Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
                                                                    final NBPFeedShareVM nBPFeedShareVM13 = NBPFeedShareVM.this;
                                                                    TimerKt.d(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2.3.3.1
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            NBPBaseShareVM<NearbyFeedPosterData> nBPBaseShareVM3 = NBPFeedShareVM.this.shareVM;
                                                                            nBPBaseShareVM3.isQRCodeRendering$delegate.setValue(nBPBaseShareVM3, NBPBaseShareVM.$$delegatedProperties[6], Boolean.FALSE);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        nearbyFeedPosterViewEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.1.2.2.3.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
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
                        final NBPFeedShareVM nBPFeedShareVM3 = NBPFeedShareVM.this;
                        final boolean z16 = false;
                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final boolean z17 = z16;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m147opacity(z17 ? 1.0f : 0.0f);
                                        Attr.absolutePosition$default(tVar2, 100.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedShareVM nBPFeedShareVM4 = nBPFeedShareVM3;
                                NearbyFeedPosterViewKt.NearbyFeedPoster(vVar2, new Function1<NearbyFeedPosterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NearbyFeedPosterView nearbyFeedPosterView) {
                                        NearbyFeedPosterView nearbyFeedPosterView2 = nearbyFeedPosterView;
                                        NBPFeedShareVM.this.shareVM.shareQQArkViewTag = Integer.valueOf(nearbyFeedPosterView2.getNativeRef());
                                        final NBPFeedShareVM nBPFeedShareVM5 = NBPFeedShareVM.this;
                                        nearbyFeedPosterView2.attr(new Function1<NearbyFeedPosterViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyFeedPosterViewAttr nearbyFeedPosterViewAttr) {
                                                NearbyFeedPosterViewAttr nearbyFeedPosterViewAttr2 = nearbyFeedPosterViewAttr;
                                                nearbyFeedPosterViewAttr2.mode = 2;
                                                NBPFeedShareVM nBPFeedShareVM6 = NBPFeedShareVM.this;
                                                nearbyFeedPosterViewAttr2.data = nBPFeedShareVM6.posterData;
                                                nearbyFeedPosterViewAttr2.config = nBPFeedShareVM6.getPosterConfig();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedShareVM nBPFeedShareVM6 = NBPFeedShareVM.this;
                                        nearbyFeedPosterView2.event(new Function1<NearbyFeedPosterViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyFeedPosterViewEvent nearbyFeedPosterViewEvent) {
                                                final NBPFeedShareVM nBPFeedShareVM7 = NBPFeedShareVM.this;
                                                nearbyFeedPosterViewEvent.onReadyToShowListener = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.2.2.2.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        Long l3;
                                                        NBPFeedShareVM.this.shareVM.setQQArkViewRendered();
                                                        PageLoadTechReporter pageLoadTechReporter = NBPFeedShareVM.this.pageLoadReporter;
                                                        if (pageLoadTechReporter != null && (l3 = pageLoadTechReporter.part3StartTime) != null) {
                                                            pageLoadTechReporter.part3Time = Integer.valueOf((int) (APICallTechReporterKt.NBPCurrentTime() - l3.longValue()));
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
                        final NBPFeedShareVM nBPFeedShareVM4 = NBPFeedShareVM.this;
                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final boolean z17 = z16;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m147opacity(z17 ? 1.0f : 0.0f);
                                        Attr.absolutePosition$default(tVar2, 300.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedShareVM nBPFeedShareVM5 = nBPFeedShareVM4;
                                NearbyFeedPosterViewKt.NearbyFeedPoster(vVar2, new Function1<NearbyFeedPosterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NearbyFeedPosterView nearbyFeedPosterView) {
                                        NearbyFeedPosterView nearbyFeedPosterView2 = nearbyFeedPosterView;
                                        NBPFeedShareVM.this.shareVM.shareWXArkViewTag = Integer.valueOf(nearbyFeedPosterView2.getNativeRef());
                                        final NBPFeedShareVM nBPFeedShareVM6 = NBPFeedShareVM.this;
                                        nearbyFeedPosterView2.attr(new Function1<NearbyFeedPosterViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyFeedPosterViewAttr nearbyFeedPosterViewAttr) {
                                                NearbyFeedPosterViewAttr nearbyFeedPosterViewAttr2 = nearbyFeedPosterViewAttr;
                                                nearbyFeedPosterViewAttr2.mode = 3;
                                                NBPFeedShareVM nBPFeedShareVM7 = NBPFeedShareVM.this;
                                                nearbyFeedPosterViewAttr2.data = nBPFeedShareVM7.posterData;
                                                nearbyFeedPosterViewAttr2.config = nBPFeedShareVM7.getPosterConfig();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedShareVM nBPFeedShareVM7 = NBPFeedShareVM.this;
                                        nearbyFeedPosterView2.event(new Function1<NearbyFeedPosterViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyFeedPosterViewEvent nearbyFeedPosterViewEvent) {
                                                final NBPFeedShareVM nBPFeedShareVM8 = NBPFeedShareVM.this;
                                                nearbyFeedPosterViewEvent.onReadyToShowListener = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPFeedShareVM.feedViewBuilder.2.1.3.2.2.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NBPFeedShareVM.this.shareVM.setWXArkViewRendered();
                                                        PageLoadTechReporter pageLoadTechReporter = NBPFeedShareVM.this.pageLoadReporter;
                                                        if (pageLoadTechReporter != null) {
                                                            Long l3 = pageLoadTechReporter.part4StartTime;
                                                            if (l3 != null) {
                                                                pageLoadTechReporter.part4Time = Integer.valueOf((int) (APICallTechReporterKt.NBPCurrentTime() - l3.longValue()));
                                                            }
                                                            pageLoadTechReporter.report();
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
                };
            }
        });
        this.feedViewBuilder$delegate = lazy;
    }

    public static final boolean access$isReadyToShowShare(NBPFeedShareVM nBPFeedShareVM) {
        return nBPFeedShareVM.shareVM.isDataReady() && nBPFeedShareVM.shareVM.isMainViewRendered() && nBPFeedShareVM.shareVM.isQQArkViewRendered() && nBPFeedShareVM.shareVM.isWXArkViewRendered() && !nBPFeedShareVM.shareVM.isPageClosed();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM
    public final NearbyFeedPosterData getPosterData() {
        return this.posterData;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM
    public final void setPosterData(NearbyFeedPosterData nearbyFeedPosterData) {
        this.posterData = nearbyFeedPosterData;
    }

    public final void updatePosterConfig(NBPThemePosterConfig nBPThemePosterConfig) {
        KLog kLog = KLog.INSTANCE;
        kLog.d("NBPFeedShareVM", "initData: cfg=" + nBPThemePosterConfig);
        if (nBPThemePosterConfig == null) {
            kLog.e("NBPFeedShareVM", "initData: cfg is null");
            this.handleError.invoke(Boolean.TRUE, "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            return;
        }
        ReadWriteProperty readWriteProperty = this.posterConfig$delegate;
        KProperty<?>[] kPropertyArr = NBPBaseShareVM.$$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[1], nBPThemePosterConfig);
        NBPBaseShareVM<NearbyFeedPosterData> nBPBaseShareVM = this.shareVM;
        nBPBaseShareVM.posterConfig$delegate.setValue(nBPBaseShareVM, kPropertyArr[1], nBPThemePosterConfig);
        this.shareVM.setDataReady();
        PageLoadTechReporter pageLoadTechReporter = this.pageLoadReporter;
        if (pageLoadTechReporter != null) {
            pageLoadTechReporter.finishPart1();
        }
        PageLoadTechReporter pageLoadTechReporter2 = this.pageLoadReporter;
        if (pageLoadTechReporter2 != null) {
            pageLoadTechReporter2.startPart2();
        }
        PageLoadTechReporter pageLoadTechReporter3 = this.pageLoadReporter;
        if (pageLoadTechReporter3 != null) {
            pageLoadTechReporter3.startPart3();
        }
        PageLoadTechReporter pageLoadTechReporter4 = this.pageLoadReporter;
        if (pageLoadTechReporter4 != null) {
            pageLoadTechReporter4.startPart4();
        }
    }
}
