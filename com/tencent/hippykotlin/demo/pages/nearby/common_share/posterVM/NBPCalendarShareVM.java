package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyCalendarPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PageLoadTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterViewEvent;
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
import k25.d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPCalendarShareVM extends NBPBaseShareVM<NearbyCalendarPosterData> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCalendarShareVM.class, "luckyCard", "getLuckyCard()Lkuikly/com/tencent/trpcprotocol/lplan/attendance_svr/attendance/LuckyCard;", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty luckyCard$delegate;
    public final Lazy middleViewBuilder$delegate;
    public PageLoadTechReporter pageLoadReporter;
    public NearbyCalendarPosterData posterData;
    public final NBPBaseShareVM<NearbyCalendarPosterData> shareVM;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public static final boolean access$isReadyToShowShare(NBPCalendarShareVM nBPCalendarShareVM) {
        return nBPCalendarShareVM.shareVM.isDataReady() && nBPCalendarShareVM.shareVM.isMainViewRendered() && nBPCalendarShareVM.shareVM.isQQArkViewRendered() && nBPCalendarShareVM.shareVM.isWXArkViewRendered() && !nBPCalendarShareVM.shareVM.isPageClosed();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM
    public final NearbyCalendarPosterData getPosterData() {
        return this.posterData;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM
    public final void setPosterData(NearbyCalendarPosterData nearbyCalendarPosterData) {
        this.posterData = nearbyCalendarPosterData;
    }

    public NBPCalendarShareVM(NBPBaseShareVM<NearbyCalendarPosterData> nBPBaseShareVM, NearbyCalendarPosterData nearbyCalendarPosterData, Function2<? super Boolean, ? super String, Unit> function2) {
        super(2);
        Lazy lazy;
        this.shareVM = nBPBaseShareVM;
        this.posterData = nearbyCalendarPosterData;
        this.luckyCard$delegate = c.a(new d(null, null, null, 0, null, null, null, 127, null));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM$middleViewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPCalendarShareVM nBPCalendarShareVM = NBPCalendarShareVM.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM$middleViewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPCalendarShareVM nBPCalendarShareVM2 = NBPCalendarShareVM.this;
                        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPCalendarShareVM nBPCalendarShareVM3 = NBPCalendarShareVM.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        float posterContainerHeight = ((NBPCalendarShareVM.this.shareVM.getPosterContainerHeight() * 0.75f) / 424.0f) * 0.5f;
                                        u uVar = new u(posterContainerHeight, posterContainerHeight);
                                        boolean z16 = NBPCalendarShareVM.this.shareVM.getPosterContainerHeight() > 0.0f;
                                        tVar2.borderRadius(8.0f);
                                        tVar2.transform(uVar);
                                        tVar2.m147opacity(z16 ? 1.0f : 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCalendarShareVM nBPCalendarShareVM4 = NBPCalendarShareVM.this;
                                ECTransitionViewKt.TransitionFadeInOutView(vVar2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionView eCTransitionView) {
                                        ECTransitionView eCTransitionView2 = eCTransitionView;
                                        final NBPCalendarShareVM nBPCalendarShareVM5 = NBPCalendarShareVM.this;
                                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                eCTransitionAttr.setTransitionAppear(NBPCalendarShareVM.access$isReadyToShowShare(NBPCalendarShareVM.this));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCalendarShareVM nBPCalendarShareVM6 = NBPCalendarShareVM.this;
                                        eCTransitionView2.addChild(new NearbyPrayPosterView(), new Function1<NearbyPrayPosterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyPrayPosterView nearbyPrayPosterView) {
                                                NearbyPrayPosterView nearbyPrayPosterView2 = nearbyPrayPosterView;
                                                NBPCalendarShareVM.this.shareVM.shareMainViewTag = Integer.valueOf(nearbyPrayPosterView2.getNativeRef());
                                                final NBPCalendarShareVM nBPCalendarShareVM7 = NBPCalendarShareVM.this;
                                                nearbyPrayPosterView2.attr(new Function1<NearbyPrayPosterViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NearbyPrayPosterViewAttr nearbyPrayPosterViewAttr) {
                                                        NearbyPrayPosterViewAttr nearbyPrayPosterViewAttr2 = nearbyPrayPosterViewAttr;
                                                        nearbyPrayPosterViewAttr2.size(630.0f, 848.0f);
                                                        NBPCalendarShareVM nBPCalendarShareVM8 = NBPCalendarShareVM.this;
                                                        nearbyPrayPosterViewAttr2.luckyCard = (d) nBPCalendarShareVM8.luckyCard$delegate.getValue(nBPCalendarShareVM8, NBPCalendarShareVM.$$delegatedProperties[0]);
                                                        nearbyPrayPosterViewAttr2.timeStamp = NBPCalendarShareVM.this.shareVM.getPosterData().timeStamp;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCalendarShareVM nBPCalendarShareVM8 = NBPCalendarShareVM.this;
                                                nearbyPrayPosterView2.event(new Function1<NearbyPrayPosterViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NearbyPrayPosterViewEvent nearbyPrayPosterViewEvent) {
                                                        final NearbyPrayPosterViewEvent nearbyPrayPosterViewEvent2 = nearbyPrayPosterViewEvent;
                                                        final NBPCalendarShareVM nBPCalendarShareVM9 = NBPCalendarShareVM.this;
                                                        new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2.2.2.1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                NBPCalendarShareVM.this.setMainViewRendered();
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        nearbyPrayPosterViewEvent2.getClass();
                                                        nearbyPrayPosterViewEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2.2.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPCalendarShareVM nBPCalendarShareVM10 = NBPCalendarShareVM.this;
                                                        FrameEventKt.f(nearbyPrayPosterViewEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2.2.2.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                KLog.INSTANCE.i("NBPMoodShareVM", "mood poster view did created");
                                                                NearbyPrayPosterViewEvent nearbyPrayPosterViewEvent3 = NearbyPrayPosterViewEvent.this;
                                                                final NBPCalendarShareVM nBPCalendarShareVM11 = nBPCalendarShareVM10;
                                                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM.middleViewBuilder.2.1.1.2.2.2.3.1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        AsyncTaskTracker<Unit> asyncTaskTracker = NBPCalendarShareVM.this.shareVM.shareMainViewReadyToCapture;
                                                                        Unit unit = Unit.INSTANCE;
                                                                        asyncTaskTracker.markDone(unit);
                                                                        return unit;
                                                                    }
                                                                };
                                                                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                                TimerKt.e(nearbyPrayPosterViewEvent3.getPagerId(), 100, function0);
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
        LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPCalendarShareVM$dtReportBaseParams$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
                NBPCalendarShareVM nBPCalendarShareVM = NBPCalendarShareVM.this;
                nearbyDTBaseParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                nearbyDTBaseParams.t("come_from", nBPCalendarShareVM.shareType);
                nearbyDTBaseParams.v("dt_pgid", "pg_nearby_share");
                e nearbyDTBaseParams2 = NearbyConstKt.getNearbyDTBaseParams();
                nearbyDTBaseParams2.v("dt_pgid", "pg_nearby_share");
                nearbyDTBaseParams2.t("come_from", nBPCalendarShareVM.shareType);
                Unit unit = Unit.INSTANCE;
                nearbyDTBaseParams.v("cur_pg", nearbyDTBaseParams2);
                return nearbyDTBaseParams;
            }
        });
    }
}
