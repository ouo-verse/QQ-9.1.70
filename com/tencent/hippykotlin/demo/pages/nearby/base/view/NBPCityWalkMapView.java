package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.CanvasLinearGradient;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.CanvasViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.p;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.a;
import n25.i;
import n25.j;
import n35.z;
import r25.e;
import t25.d;

/* loaded from: classes31.dex */
public final class NBPCityWalkMapView extends ComposeView<NBPCityWalkMapViewAttr, NBPCityWalkMapViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkMapView.class, "list", "getList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkMapView.class, "cameraPosition", "getCameraPosition()Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/CameraPosition;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkMapView.class, "cameraMoveFixed", "getCameraMoveFixed()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkMapView.class, "updatedStatus", "getUpdatedStatus()Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/MapStatus;", 0)};
    public aa<NearbyProMapView> nearbyProMapViewRef;
    public final ReadWriteProperty list$delegate = c.b();
    public final ReadWriteProperty cameraPosition$delegate = c.a(CameraPosition.Companion.emptyCameraPosition());
    public final ReadWriteProperty cameraMoveFixed$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty updatedStatus$delegate = c.a(MapStatus.INIT);
    public String timeout = "";

    /* loaded from: classes31.dex */
    public static final class Position {
        public final long color;
        public final float left;
        public final float top;

        public Position(float f16, float f17, long j3) {
            this.left = f16;
            this.top = f17;
            this.color = j3;
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("left: ");
            m3.append(this.left);
            m3.append(", top: ");
            m3.append(this.top);
            return m3.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPCityWalkMapViewAttr access$getAttr(NBPCityWalkMapView nBPCityWalkMapView) {
        return (NBPCityWalkMapViewAttr) nBPCityWalkMapView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPCityWalkMapViewEvent access$getEvent(NBPCityWalkMapView nBPCityWalkMapView) {
        return (NBPCityWalkMapViewEvent) nBPCityWalkMapView.getEvent();
    }

    public static final MapStatus access$getUpdatedStatus(NBPCityWalkMapView nBPCityWalkMapView) {
        return (MapStatus) nBPCityWalkMapView.updatedStatus$delegate.getValue(nBPCityWalkMapView, $$delegatedProperties[3]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$jumpPersonDetail(NBPCityWalkMapView nBPCityWalkMapView, String str) {
        e eVar;
        String l3;
        byte[] encodeToByteArray;
        if (!((NBPCityWalkMapViewAttr) nBPCityWalkMapView.getAttr()).canClick || (eVar = ((NBPCityWalkMapViewAttr) nBPCityWalkMapView.getAttr()).getStatusFeed().f418093e) == null || (l3 = Long.valueOf(eVar.f430610d).toString()) == null) {
            return;
        }
        int i3 = ((NBPCityWalkMapViewAttr) nBPCityWalkMapView.getAttr()).jumpArticleFeedDetailSource;
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("feed_id", str, "poster_user_id", l3);
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        m3.u("user_id", userDataManager.getUserSelfInfo().tid);
        m3.v("user_nickname", userDataManager.getUserSelfInfo().nickName);
        m3.v("user_avatar", userDataManager.getUserSelfInfo().avatarUrl);
        m3.t("app_id", 2);
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(m3.toString());
        companion.setSharePenetratePageData(new byte[][]{encodeToByteArray});
        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_article_feed_detail&custom_back_pressed=1&nbp_source=" + i3, false, 6);
        nBPCityWalkMapView.report(102, str);
        KLog.INSTANCE.i("NBPCityWalkMapView", QUISkinImage$$ExternalSyntheticOutline0.m("open detail page, feedId=", str, ",tid=", l3));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(h.INSTANCE.m());
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkMapView nBPCityWalkMapView = NBPCityWalkMapView.this;
                NearbyProMapViewKt.NearbyProMap(viewContainer2, new Function1<NearbyProMapView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NearbyProMapView nearbyProMapView) {
                        NearbyProMapView nearbyProMapView2 = nearbyProMapView;
                        final NBPCityWalkMapView nBPCityWalkMapView2 = NBPCityWalkMapView.this;
                        nearbyProMapView2.ref(nearbyProMapView2, new Function1<aa<NearbyProMapView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NearbyProMapView> aaVar) {
                                NBPCityWalkMapView.this.nearbyProMapViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        nearbyProMapView2.attr(new Function1<NearbyProMapAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyProMapAttr nearbyProMapAttr) {
                                NearbyProMapAttr nearbyProMapAttr2 = nearbyProMapAttr;
                                nearbyProMapAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                nearbyProMapAttr2.m140flex(1.0f);
                                nearbyProMapAttr2.maxZoomLevel(99);
                                nearbyProMapAttr2.minZoomLevel(1);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkMapView nBPCityWalkMapView3 = NBPCityWalkMapView.this;
                        nearbyProMapView2.event(new Function1<NearbyProMapEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyProMapEvent nearbyProMapEvent) {
                                final NearbyProMapEvent nearbyProMapEvent2 = nearbyProMapEvent;
                                FrameEventKt.f(nearbyProMapEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkMapView nBPCityWalkMapView4 = NBPCityWalkMapView.this;
                                FrameEventKt.g(nearbyProMapEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        r2.updatedStatus$delegate.setValue(NBPCityWalkMapView.this, NBPCityWalkMapView.$$delegatedProperties[3], MapStatus.RESET);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkMapView nBPCityWalkMapView5 = NBPCityWalkMapView.this;
                                VisibilityEventKt.b(nearbyProMapEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        String joinToString$default;
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("event_map didAppear, ");
                                        m3.append(NBPCityWalkMapView.access$getUpdatedStatus(NBPCityWalkMapView.this));
                                        m3.append(", ");
                                        m3.append(NBPCityWalkMapView.this.getCameraPosition());
                                        kLog.i("NBPCityWalkMapView", m3.toString());
                                        NBPCityWalkMapView nBPCityWalkMapView6 = NBPCityWalkMapView.this;
                                        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(nBPCityWalkMapView6.getList(), ",", null, null, 0, null, new Function1<a, CharSequence>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final CharSequence invoke(a aVar) {
                                                return aVar.f418043d;
                                            }
                                        }, 30, null);
                                        nBPCityWalkMapView6.report(101, joinToString$default);
                                        if (NBPCityWalkMapView.access$getUpdatedStatus(NBPCityWalkMapView.this) != MapStatus.INIT) {
                                            final NBPCityWalkMapView nBPCityWalkMapView7 = NBPCityWalkMapView.this;
                                            NearbyProMapEvent nearbyProMapEvent3 = nearbyProMapEvent2;
                                            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.3.2
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    KLog kLog2 = KLog.INSTANCE;
                                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("event_map didAppear timeout, ");
                                                    m16.append(NBPCityWalkMapView.access$getUpdatedStatus(NBPCityWalkMapView.this));
                                                    m16.append(", ");
                                                    m16.append(NBPCityWalkMapView.this.getCameraPosition());
                                                    kLog2.i("NBPCityWalkMapView", m16.toString());
                                                    if (NBPCityWalkMapView.access$getUpdatedStatus(NBPCityWalkMapView.this) != MapStatus.SUCCESS_UPDATE) {
                                                        NBPCityWalkMapView.this.updateMap();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                            nBPCityWalkMapView7.timeout = TimerKt.e(nearbyProMapEvent3.getPagerId(), 100, function0);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkMapView nBPCityWalkMapView6 = NBPCityWalkMapView.this;
                                VisibilityEventKt.c(nearbyProMapEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        TimerKt.b(NBPCityWalkMapView.this.timeout);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkMapView nBPCityWalkMapView7 = NBPCityWalkMapView.this;
                                nearbyProMapEvent2.register("mapLoaded", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("event_map mapLoaded, "), NBPCityWalkMapView.access$getAttr(NBPCityWalkMapView.this).getStatusFeed().f418092d, KLog.INSTANCE, "NBPCityWalkMapView");
                                        NBPCityWalkMapView.this.updateMap();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkMapView nBPCityWalkMapView8 = NBPCityWalkMapView.this;
                                nearbyProMapEvent2.register("cameraChanged", new NearbyProMapEvent$cameraChanged$1(new Function1<CameraPosition, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CameraPosition cameraPosition) {
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("event_map cameraChanged, ");
                                        m3.append(NBPCityWalkMapView.access$getAttr(NBPCityWalkMapView.this).getStatusFeed().f418092d);
                                        m3.append(", ");
                                        m3.append(cameraPosition.zoomLevel);
                                        kLog.i("NBPCityWalkMapView", m3.toString());
                                        NBPCityWalkMapView nBPCityWalkMapView9 = NBPCityWalkMapView.this;
                                        nBPCityWalkMapView9.cameraMoveFixed$delegate.setValue(nBPCityWalkMapView9, NBPCityWalkMapView.$$delegatedProperties[2], Boolean.FALSE);
                                        if (NBPCityWalkMapView.access$getUpdatedStatus(NBPCityWalkMapView.this) != MapStatus.DO_UPDATE) {
                                            r4.updatedStatus$delegate.setValue(NBPCityWalkMapView.this, NBPCityWalkMapView.$$delegatedProperties[3], MapStatus.CHANGED);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), true);
                                final NBPCityWalkMapView nBPCityWalkMapView9 = NBPCityWalkMapView.this;
                                nearbyProMapEvent2.register("cameraChangedFinish", new NearbyProMapEvent$cameraChangedFinish$1(new Function1<CameraPosition, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.3.3.7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CameraPosition cameraPosition) {
                                        CameraPosition cameraPosition2 = cameraPosition;
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("event_map cameraChangedFinish, ");
                                        m3.append(NBPCityWalkMapView.access$getAttr(NBPCityWalkMapView.this).getStatusFeed().f418092d);
                                        m3.append(", ");
                                        m3.append(cameraPosition2.zoomLevel);
                                        m3.append(", ");
                                        m3.append(NBPCityWalkMapView.access$getUpdatedStatus(NBPCityWalkMapView.this));
                                        kLog.i("NBPCityWalkMapView", m3.toString());
                                        NBPCityWalkMapView nBPCityWalkMapView10 = NBPCityWalkMapView.this;
                                        ReadWriteProperty readWriteProperty = nBPCityWalkMapView10.cameraMoveFixed$delegate;
                                        KProperty<?>[] kPropertyArr = NBPCityWalkMapView.$$delegatedProperties;
                                        readWriteProperty.setValue(nBPCityWalkMapView10, kPropertyArr[2], Boolean.TRUE);
                                        if (nearbyProMapEvent2.getPager().getPageData().getIsIOS() || (nearbyProMapEvent2.getPager().getPageData().getIsAndroid() && NBPCityWalkMapView.access$getUpdatedStatus(NBPCityWalkMapView.this) == MapStatus.DO_UPDATE)) {
                                            NBPCityWalkMapView nBPCityWalkMapView11 = NBPCityWalkMapView.this;
                                            nBPCityWalkMapView11.cameraPosition$delegate.setValue(nBPCityWalkMapView11, kPropertyArr[1], cameraPosition2);
                                            r6.updatedStatus$delegate.setValue(NBPCityWalkMapView.this, NBPCityWalkMapView.$$delegatedProperties[3], MapStatus.SUCCESS_UPDATE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkMapView nBPCityWalkMapView2 = NBPCityWalkMapView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkMapView nBPCityWalkMapView3 = NBPCityWalkMapView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPCityWalkMapView nBPCityWalkMapView4 = NBPCityWalkMapView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPCityWalkMapView.access$getAttr(NBPCityWalkMapView.this).getClass();
                                        Function1<? super a, Unit> function1 = NBPCityWalkMapView.access$getEvent(NBPCityWalkMapView.this).onMapClickHandler;
                                        if (function1 != null) {
                                            function1.invoke(null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkMapView nBPCityWalkMapView5 = NBPCityWalkMapView.this;
                                uVar2.doubleClick(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ClickParams clickParams2 = clickParams;
                                        Function2<? super ClickParams, ? super NBPCityWalkMapView, Unit> function2 = NBPCityWalkMapView.access$getEvent(NBPCityWalkMapView.this).onMapDoubleClick;
                                        if (function2 != null) {
                                            function2.invoke(clickParams2, NBPCityWalkMapView.this);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkMapView nBPCityWalkMapView6 = NBPCityWalkMapView.this;
                                uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.4.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LongPressParams longPressParams) {
                                        Function0<Unit> function0 = NBPCityWalkMapView.access$getEvent(NBPCityWalkMapView.this).onMapLongPress;
                                        if (function0 != null) {
                                            function0.invoke();
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
                final NBPCityWalkMapView nBPCityWalkMapView3 = NBPCityWalkMapView.this;
                Function0<com.tencent.kuikly.core.reactive.collection.c<a>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<a>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final com.tencent.kuikly.core.reactive.collection.c<a> invoke() {
                        return NBPCityWalkMapView.this.getList();
                    }
                };
                final NBPCityWalkMapView nBPCityWalkMapView4 = NBPCityWalkMapView.this;
                LoopDirectivesViewKt.a(viewContainer2, function0, new Function2<LoopDirectivesView<a>, a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.6
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(LoopDirectivesView<a> loopDirectivesView, a aVar) {
                        int lastIndex;
                        LoopDirectivesView<a> loopDirectivesView2 = loopDirectivesView;
                        final a aVar2 = aVar;
                        final i iVar = aVar2.f418046h;
                        if (iVar != null) {
                            final int size = NBPCityWalkMapView.this.getList().size();
                            final int indexOf = NBPCityWalkMapView.this.getList().indexOf(aVar2);
                            final boolean z16 = indexOf == 0;
                            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(NBPCityWalkMapView.this.getList());
                            final boolean z17 = indexOf == lastIndex;
                            final NBPCityWalkMapView nBPCityWalkMapView5 = NBPCityWalkMapView.this;
                            w.a(loopDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    final NBPCityWalkMapView nBPCityWalkMapView6 = NBPCityWalkMapView.this;
                                    final int i3 = indexOf;
                                    final i iVar2 = iVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.positionAbsolute();
                                            float f16 = NBPCityWalkMapView$Companion$PageConfig.cardWidth;
                                            float f17 = NBPCityWalkMapView$Companion$PageConfig.cardHeight;
                                            tVar2.size(f16, f17);
                                            tVar2.flexDirectionColumn();
                                            tVar2.alignItemsCenter();
                                            tVar2.justifyContentSpaceBetween();
                                            tVar2.m154zIndex(NBPCityWalkMapView.this.getList().size() - i3);
                                            tVar2.m142left(-f16);
                                            tVar2.m150top(-f17);
                                            NBPCityWalkMapView.Position access$getPosInMap = NBPCityWalkMapView.access$getPosInMap(NBPCityWalkMapView.this, iVar2);
                                            if (access$getPosInMap != null) {
                                                tVar2.m142left(access$getPosInMap.left);
                                                tVar2.m150top(access$getPosInMap.top);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPCityWalkMapView nBPCityWalkMapView7 = NBPCityWalkMapView.this;
                                    final a aVar3 = aVar2;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    float f16 = NBPCityWalkMapView$Companion$PageConfig.cardWidth;
                                                    tVar2.mo153width(f16);
                                                    tVar2.mo141height(f16);
                                                    tVar2.mo113backgroundColor(new h(16777215L, 1.0f));
                                                    tVar2.borderRadius(FloatExtKt.getTo375(10.0f));
                                                    tVar2.allCenter();
                                                    tVar2.mo139boxShadow(new g(0.0f, FloatExtKt.getTo375(6.0f), FloatExtKt.getTo375(6.0f), new h(0L, 0.18f)));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPCityWalkMapView nBPCityWalkMapView8 = NBPCityWalkMapView.this;
                                            final a aVar4 = aVar3;
                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final NBPCityWalkMapView nBPCityWalkMapView9 = NBPCityWalkMapView.this;
                                                    final a aVar5 = aVar4;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.2.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            NBPCityWalkMapView.access$jumpPersonDetail(NBPCityWalkMapView.this, aVar5.f418043d);
                                                            Function1<? super a, Unit> function1 = NBPCityWalkMapView.access$getEvent(NBPCityWalkMapView.this).onMapClickHandler;
                                                            if (function1 != null) {
                                                                function1.invoke(aVar5);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final a aVar5 = aVar3;
                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.2.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    final a aVar6 = a.this;
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.2.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            Object firstOrNull;
                                                            n35.v vVar5;
                                                            n35.w wVar;
                                                            List<z> list;
                                                            Object firstOrNull2;
                                                            af afVar2 = afVar;
                                                            afVar2.mo153width(FloatExtKt.getTo375(56.0f));
                                                            afVar2.mo141height(FloatExtKt.getTo375(56.0f));
                                                            afVar2.borderRadius(FloatExtKt.getTo375(10.0f));
                                                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a.this.f418045f);
                                                            j jVar = (j) firstOrNull;
                                                            if (jVar != null && (wVar = jVar.f418083d) != null && (list = wVar.f418273d) != null) {
                                                                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                                                z zVar = (z) firstOrNull2;
                                                                if (zVar != null) {
                                                                    vVar5 = zVar.f418280d;
                                                                    NearbyProKtxKt.srcWithIndexNode(afVar2, vVar5);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }
                                                            vVar5 = null;
                                                            NearbyProKtxKt.srcWithIndexNode(afVar2, vVar5);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.size(6.0f, 30.0f);
                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_H8988hTDbm3.png", false, 2, null);
                                                    float f16 = NBPCityWalkMapView$Companion$PageConfig.cardWidth;
                                                    Attr.absolutePosition$default(afVar2, f16, (f16 - 6.0f) / 2.0f, 0.0f, 0.0f, 12, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final boolean z18 = z16;
                                    final boolean z19 = z17;
                                    final int i16 = indexOf;
                                    final int i17 = size;
                                    final a aVar4 = aVar2;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.4.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    float f16 = NBPCityWalkMapView$Companion$PageConfig.pointSizeBig;
                                                    tVar2.size(f16, f16);
                                                    tVar2.allCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final boolean z26 = z18;
                                            final boolean z27 = z19;
                                            final int i18 = i16;
                                            final int i19 = i17;
                                            final a aVar5 = aVar4;
                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.4.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    final boolean z28 = z26;
                                                    final boolean z29 = z27;
                                                    final int i26 = i18;
                                                    final int i27 = i19;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.4.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            float f16;
                                                            t tVar2 = tVar;
                                                            if (!z28 && !z29) {
                                                                f16 = NBPCityWalkMapView$Companion$PageConfig.pointSizeSmall;
                                                            } else {
                                                                f16 = NBPCityWalkMapView$Companion$PageConfig.pointSizeBig;
                                                            }
                                                            tVar2.size(f16, f16);
                                                            tVar2.allCenter();
                                                            tVar2.mo113backgroundColor(new h(ColorPick.INSTANCE.getColor(i26, i27), 1.0f));
                                                            tVar2.m136border(new com.tencent.kuikly.core.base.e(FloatExtKt.getTo375(2.0f), BorderStyle.SOLID, new h(16777215L, 1.0f)));
                                                            tVar2.borderRadius((f16 / 2) + 1.0f);
                                                            tVar2.mo139boxShadow(new g(0.0f, FloatExtKt.getTo375(3.0f), FloatExtKt.getTo375(3.0f), new h(0L, 0.18f)));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final a aVar6 = aVar5;
                                                    cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.4.2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final a aVar7 = a.this;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.6.1.4.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ce.fontSize$default(ceVar2, FloatExtKt.getTo375(10.0f), null, 2, null);
                                                                    ceVar2.color(new h(16777215L, 1.0f));
                                                                    ceVar2.text(String.valueOf(a.this.f418044e + 1));
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
                        }
                        return Unit.INSTANCE;
                    }
                });
                AnonymousClass7 anonymousClass7 = new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.7
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(CanvasView canvasView) {
                        canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.7.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Attr attr) {
                                Attr attr2 = attr;
                                attr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                attr2.m151touchEnable(false);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                final NBPCityWalkMapView nBPCityWalkMapView5 = NBPCityWalkMapView.this;
                CanvasViewKt.a(viewContainer2, anonymousClass7, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.8
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(p pVar, Float f16, Float f17) {
                        NBPCityWalkMapView.Position access$getPosInMap;
                        p pVar2 = pVar;
                        f16.floatValue();
                        f17.floatValue();
                        com.tencent.kuikly.core.reactive.collection.c<a> list = NBPCityWalkMapView.this.getList();
                        NBPCityWalkMapView nBPCityWalkMapView6 = NBPCityWalkMapView.this;
                        ArrayList arrayList = new ArrayList();
                        Iterator<a> it = list.iterator();
                        while (true) {
                            r3 = null;
                            NBPCityWalkMapView.Position position = null;
                            if (!it.hasNext()) {
                                break;
                            }
                            a next = it.next();
                            i iVar = next.f418046h;
                            int indexOf = nBPCityWalkMapView6.getList().indexOf(next);
                            float f18 = 2;
                            float f19 = NBPCityWalkMapView$Companion$PageConfig.pointSizeBig / f18;
                            long color = ColorPick.INSTANCE.getColor(indexOf, nBPCityWalkMapView6.getList().size());
                            KLog.INSTANCE.i("NBPCityWalkMapView", "color: " + color);
                            if (iVar != null && (access$getPosInMap = NBPCityWalkMapView.access$getPosInMap(nBPCityWalkMapView6, iVar)) != null) {
                                position = new NBPCityWalkMapView.Position((NBPCityWalkMapView$Companion$PageConfig.cardWidth / f18) + access$getPosInMap.left, (access$getPosInMap.top + NBPCityWalkMapView$Companion$PageConfig.cardHeight) - f19, color);
                            }
                            if (position != null) {
                                arrayList.add(position);
                            }
                        }
                        ArrayList arrayList2 = arrayList.isEmpty() ^ true ? arrayList : null;
                        List<List> windowed$default = arrayList2 != null ? CollectionsKt___CollectionsKt.windowed$default(arrayList2, 2, 0, false, 6, null) : null;
                        KLog.INSTANCE.i("NBPCityWalkMapView", "pointList: " + windowed$default);
                        if (windowed$default != null) {
                            for (List list2 : windowed$default) {
                                NBPCityWalkMapView.Position position2 = (NBPCityWalkMapView.Position) list2.get(0);
                                NBPCityWalkMapView.Position position3 = (NBPCityWalkMapView.Position) list2.get(1);
                                pVar2.b();
                                pVar2.j(6.0f);
                                pVar2.k(position2.left, position2.top);
                                pVar2.i(position3.left, position3.top);
                                CanvasLinearGradient d16 = pVar2.d(position2.left, position2.top, position3.left, position3.top);
                                d16.a(0.0f, new h(position2.color, 1.0f));
                                d16.a(1.0f, new h(position3.color, 1.0f));
                                pVar2.o(d16);
                                pVar2.m();
                                pVar2.c();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkMapView nBPCityWalkMapView6 = NBPCityWalkMapView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView$body$1.9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPCityWalkMapView nBPCityWalkMapView7 = NBPCityWalkMapView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.9.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                tVar2.m149right(0.0f);
                                tVar2.m138bottom(0.0f);
                                tVar2.mo141height(24.0f);
                                tVar2.borderRadius(FloatExtKt.getTo375(8.0f), 0.0f, 0.0f, 0.0f);
                                tVar2.mo113backgroundColor(new h(16777215L, 1.0f));
                                tVar2.allCenter();
                                tVar2.paddingLeft(FloatExtKt.getTo375(7.0f));
                                tVar2.paddingRight(FloatExtKt.getTo375(7.0f));
                                tVar2.m152visibility(NBPCityWalkMapView.access$getAttr(NBPCityWalkMapView.this).showCount);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkMapView nBPCityWalkMapView8 = NBPCityWalkMapView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.9.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NBPCityWalkMapView nBPCityWalkMapView9 = NBPCityWalkMapView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView.body.1.9.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, FloatExtKt.getTo375(12.0f), null, 2, null);
                                        ceVar2.color(new h(39423L, 1.0f));
                                        ceVar2.text("\u8db3\u8ff9\u00b7" + NBPCityWalkMapView.this.getList().size());
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
        return new NBPCityWalkMapViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPCityWalkMapViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        List<a> list;
        super.created();
        getList().clear();
        n25.b bVar = ((NBPCityWalkMapViewAttr) getAttr()).getStatusFeed().M;
        if (bVar == null || (list = bVar.f418049d) == null) {
            return;
        }
        getList().addAll(list);
    }

    public final CameraPosition getCameraPosition() {
        return (CameraPosition) this.cameraPosition$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<a> getList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.list$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void report(int i3, String str) {
        int i16;
        String pageName = getPager().getPageName();
        switch (pageName.hashCode()) {
            case -2131939703:
                if (pageName.equals("nearby_article_feed_detail")) {
                    i16 = 3;
                    break;
                }
                i16 = 0;
                break;
            case -329776046:
                if (pageName.equals("nearby_feed_detail")) {
                    i16 = 4;
                    break;
                }
                i16 = 0;
                break;
            case 645803091:
                if (pageName.equals("nearby_personal_feed_detail")) {
                    i16 = 2;
                    break;
                }
                i16 = 0;
                break;
            case 678693862:
                if (pageName.equals("nearby_city_walk_preview")) {
                    i16 = 5;
                    break;
                }
                i16 = 0;
                break;
            case 706608813:
                if (pageName.equals("nearby_feed_polymer")) {
                    i16 = 1;
                    break;
                }
                i16 = 0;
                break;
            default:
                i16 = 0;
                break;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.t("nearby_action_id", i3);
        eVar.t("nearby_page_id", i16);
        eVar.v("nearby_feed_id", str);
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_citywalk_sub_content", eVar);
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("report: type: ");
        sb5.append(i3);
        sb5.append(", pageId:");
        sb5.append(i16);
        sb5.append(", feedIds:");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(sb5, str, kLog, "NBPCityWalkMapView");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateMap() {
        List mutableList;
        final NearbyProMapView b16;
        d dVar;
        this.updatedStatus$delegate.setValue(this, $$delegatedProperties[3], MapStatus.DO_UPDATE);
        com.tencent.kuikly.core.reactive.collection.c<a> list = getList();
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().f418046h != null) {
                double d16 = 1000000;
                dVar = new d((r2.f418079d * 1.0d) / d16, (r2.f418080e * 1.0d) / d16);
            } else {
                dVar = null;
            }
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        if (mutableList.isEmpty()) {
            return;
        }
        int i3 = (int) NBPCityWalkMapView$Companion$PageConfig.cardWidth;
        float f16 = ((NBPCityWalkMapViewAttr) getAttr()).topDistance + NBPCityWalkMapView$Companion$PageConfig.cardHeight;
        float f17 = NBPCityWalkMapView$Companion$PageConfig.pointSizeBig;
        final y25.a aVar = new y25.a(mutableList, i3, i3, (int) (f16 + f17), (int) (((NBPCityWalkMapViewAttr) getAttr()).bottomDistance + f17));
        aa<NearbyProMapView> aaVar = this.nearbyProMapViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapView$moveBoundsInMapRect$1
            public final /* synthetic */ boolean $animate = false;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                int nativeRef = NearbyProMapView.this.getNativeRef();
                y25.a aVar2 = aVar;
                boolean z16 = this.$animate;
                companion.getClass();
                companion.asyncToNativeMethod("moveBoundsInMapRect", new Object[]{Integer.valueOf(nativeRef), Integer.valueOf(com.tencent.kuikly.core.base.d.b(z16)), c45.i.d(aVar2)}, (Function1<Object, Unit>) null);
                return Unit.INSTANCE;
            }
        });
    }

    public static final Position access$getPosInMap(NBPCityWalkMapView nBPCityWalkMapView, i iVar) {
        if (nBPCityWalkMapView.getCameraPosition().zoomLevel == -1.0f) {
            return null;
        }
        CameraPosition cameraPosition = nBPCityWalkMapView.getCameraPosition();
        float v3 = nBPCityWalkMapView.getFlexNode().v();
        float t16 = nBPCityWalkMapView.getFlexNode().t();
        double d16 = v3 * 1.0d;
        double d17 = cameraPosition.topRightPosition.longitude;
        NBPLatLng nBPLatLng = cameraPosition.topLeftPosition;
        double d18 = nBPLatLng.longitude;
        double d19 = d16 / (d17 - d18);
        double d26 = cameraPosition.bottomLeftPosition.latitude;
        double d27 = nBPLatLng.latitude;
        double d28 = (t16 * 1.0d) / (d26 - d27);
        double d29 = 1000000;
        double d36 = (iVar.f418080e * 1.0d) / d29;
        double d37 = (iVar.f418079d * 1.0d) / d29;
        float f16 = 2;
        float f17 = (float) (((d36 - d18) * d19) - (NBPCityWalkMapView$Companion$PageConfig.cardWidth / f16));
        float f18 = (float) (((d37 - d27) * d28) - (NBPCityWalkMapView$Companion$PageConfig.cardHeight - (NBPCityWalkMapView$Companion$PageConfig.pointSizeBig / f16)));
        KLog.INSTANCE.i("NBPCityWalkMapView", "item: distanceAspectX:" + d19 + ", distanceAspectY: " + d28 + ",screenX:" + f17 + ",screenY=" + f18 + ",gLeft:" + d36 + ", gTop:" + d37 + ',');
        return new Position(f17, f18, 0L);
    }
}
