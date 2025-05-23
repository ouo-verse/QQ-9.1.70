package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMoodPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.moodPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PageLoadTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterViewEvent;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import w25.g;

/* loaded from: classes31.dex */
public final class NBPMoodShareVM extends NBPBaseShareVM<NearbyMoodPosterData> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMoodShareVM.class, QCircleAlphaUserReporter.KEY_USER, "getUser()Lkuikly/com/tencent/trpcprotocol/lplan/mood_svr/mood_svr/User;", 0)};
    public static final Companion Companion = new Companion();
    public moodPosterData keyMoodData;
    public String mainPosterBgUrl;
    public int mid;
    public final Lazy middleViewBuilder$delegate;
    public PageLoadTechReporter pageLoadReporter;
    public NearbyMoodPosterData posterData;
    public final NBPBaseShareVM<NearbyMoodPosterData> shareVM;
    public final ReadWriteProperty user$delegate;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public static final boolean access$isReadyToShowShare(NBPMoodShareVM nBPMoodShareVM) {
        return nBPMoodShareVM.shareVM.isDataReady() && nBPMoodShareVM.shareVM.isMainViewRendered() && nBPMoodShareVM.shareVM.isQQArkViewRendered() && nBPMoodShareVM.shareVM.isWXArkViewRendered() && !nBPMoodShareVM.shareVM.isPageClosed();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM
    public final NearbyMoodPosterData getPosterData() {
        return this.posterData;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM
    public final void setPosterData(NearbyMoodPosterData nearbyMoodPosterData) {
        this.posterData = nearbyMoodPosterData;
    }

    public NBPMoodShareVM(NBPBaseShareVM<NearbyMoodPosterData> nBPBaseShareVM, NearbyMoodPosterData nearbyMoodPosterData, Function2<? super Boolean, ? super String, Unit> function2) {
        super(2);
        Lazy lazy;
        this.shareVM = nBPBaseShareVM;
        this.posterData = nearbyMoodPosterData;
        this.user$delegate = c.a(new g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null));
        this.mid = 2;
        this.mainPosterBgUrl = "";
        this.keyMoodData = new moodPosterData(0, null, null, null, null, null, 511);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM$middleViewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPMoodShareVM nBPMoodShareVM = NBPMoodShareVM.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM$middleViewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPMoodShareVM nBPMoodShareVM2 = NBPMoodShareVM.this;
                        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPMoodShareVM nBPMoodShareVM3 = NBPMoodShareVM.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        float posterContainerHeight = ((NBPMoodShareVM.this.shareVM.getPosterContainerHeight() * 0.75f) / 424.0f) * 0.5f;
                                        u uVar = new u(posterContainerHeight, posterContainerHeight);
                                        boolean z16 = NBPMoodShareVM.this.shareVM.getPosterContainerHeight() > 0.0f;
                                        tVar2.borderRadius(8.0f);
                                        tVar2.transform(uVar);
                                        tVar2.m147opacity(z16 ? 1.0f : 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMoodShareVM nBPMoodShareVM4 = NBPMoodShareVM.this;
                                ECTransitionViewKt.TransitionFadeInOutView(vVar2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionView eCTransitionView) {
                                        ECTransitionView eCTransitionView2 = eCTransitionView;
                                        final NBPMoodShareVM nBPMoodShareVM5 = NBPMoodShareVM.this;
                                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                eCTransitionAttr.setTransitionAppear(NBPMoodShareVM.access$isReadyToShowShare(NBPMoodShareVM.this));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMoodShareVM nBPMoodShareVM6 = NBPMoodShareVM.this;
                                        eCTransitionView2.addChild(new NearbyMoodPosterView(), new Function1<NearbyMoodPosterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyMoodPosterView nearbyMoodPosterView) {
                                                NearbyMoodPosterView nearbyMoodPosterView2 = nearbyMoodPosterView;
                                                NBPMoodShareVM.this.shareVM.shareMainViewTag = Integer.valueOf(nearbyMoodPosterView2.getNativeRef());
                                                final NBPMoodShareVM nBPMoodShareVM7 = NBPMoodShareVM.this;
                                                nearbyMoodPosterView2.attr(new Function1<NearbyMoodPosterViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NearbyMoodPosterViewAttr nearbyMoodPosterViewAttr) {
                                                        NearbyMoodPosterViewAttr nearbyMoodPosterViewAttr2 = nearbyMoodPosterViewAttr;
                                                        nearbyMoodPosterViewAttr2.size(630.0f, 848.0f);
                                                        NBPMoodShareVM nBPMoodShareVM8 = NBPMoodShareVM.this;
                                                        NBPBaseShareVM<NearbyMoodPosterData> nBPBaseShareVM2 = nBPMoodShareVM8.shareVM;
                                                        nearbyMoodPosterViewAttr2.data = nBPMoodShareVM8.keyMoodData;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPMoodShareVM nBPMoodShareVM8 = NBPMoodShareVM.this;
                                                nearbyMoodPosterView2.event(new Function1<NearbyMoodPosterViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NearbyMoodPosterViewEvent nearbyMoodPosterViewEvent) {
                                                        final NearbyMoodPosterViewEvent nearbyMoodPosterViewEvent2 = nearbyMoodPosterViewEvent;
                                                        final NBPMoodShareVM nBPMoodShareVM9 = NBPMoodShareVM.this;
                                                        nearbyMoodPosterViewEvent2.onRenderSuccessListener = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2.2.2.1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                NBPMoodShareVM.this.setMainViewRendered();
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        nearbyMoodPosterViewEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2.2.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPMoodShareVM nBPMoodShareVM10 = NBPMoodShareVM.this;
                                                        FrameEventKt.f(nearbyMoodPosterViewEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2.2.2.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                KLog.INSTANCE.i("NBPMoodShareVM", "mood poster view did created");
                                                                NearbyMoodPosterViewEvent nearbyMoodPosterViewEvent3 = NearbyMoodPosterViewEvent.this;
                                                                final NBPMoodShareVM nBPMoodShareVM11 = nBPMoodShareVM10;
                                                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM.middleViewBuilder.2.1.1.2.2.2.3.1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        AsyncTaskTracker<Unit> asyncTaskTracker = NBPMoodShareVM.this.shareVM.shareMainViewReadyToCapture;
                                                                        Unit unit = Unit.INSTANCE;
                                                                        asyncTaskTracker.markDone(unit);
                                                                        return unit;
                                                                    }
                                                                };
                                                                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                                TimerKt.e(nearbyMoodPosterViewEvent3.getPagerId(), 100, function0);
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
        });
        this.middleViewBuilder$delegate = lazy;
        LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPMoodShareVM$dtReportBaseParams$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
                NBPMoodShareVM nBPMoodShareVM = NBPMoodShareVM.this;
                nearbyDTBaseParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                nearbyDTBaseParams.t("come_from", nBPMoodShareVM.shareType);
                nearbyDTBaseParams.v("dt_pgid", "pg_nearby_share");
                e nearbyDTBaseParams2 = NearbyConstKt.getNearbyDTBaseParams();
                nearbyDTBaseParams2.v("dt_pgid", "pg_nearby_share");
                nearbyDTBaseParams2.t("come_from", nBPMoodShareVM.shareType);
                Unit unit = Unit.INSTANCE;
                nearbyDTBaseParams.v("cur_pg", nearbyDTBaseParams2);
                return nearbyDTBaseParams;
            }
        });
    }
}
