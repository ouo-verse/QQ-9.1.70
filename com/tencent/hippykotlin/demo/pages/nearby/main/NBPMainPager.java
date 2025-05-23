package com.tencent.hippykotlin.demo.pages.nearby.main;

import c01.c;
import c45.i;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyFontModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLngExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.OffsetRandom;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainMode;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPMainControlViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideView;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPMarkerGuideViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.notify.NBPNotifyViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.NBPMarkerFactory;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerRect;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationAttr;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.MemoryCacheModule;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.nearbypro.api.impl.NearbyProChatApiImpl;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.j;
import n25.l;
import o25.f;
import q25.g;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPMainPager extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainPager.class, "pageAutoReportParams", "getPageAutoReportParams()Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;", 0)};
    public String aioClearMsgNotifyRef;
    public String conciseModeChangeNotifyRef;
    public String feedDeleteNotifyRef;
    public String interactivePushNotifyRef;
    public String mapThemeChangedNotifyRef;
    public a markerGuideTag;
    public final ReadWriteProperty pageAutoReportParams$delegate = c.a(new e());
    public long pgInStart;
    public long pgStayTime;
    public String publishFeedFinishNotifyRef;
    public int source;
    public String updateCameraPositionNotifyRef;
    public String userSelfInfoChangeNotifyRef;
    public NBPViewModelStore vmStore;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        if (!(!getPageData().n().g("isIpad", false))) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPMainPager nBPMainPager = NBPMainPager.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        mVar2.overflow(true);
                        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(com.tencent.kuikly.core.manager.c.f117352a)) {
                            NBPMainPager nBPMainPager2 = NBPMainPager.this;
                            EcommerceExtKt.pageVR(mVar2, "pg_nearby_home_map", (e) nBPMainPager2.pageAutoReportParams$delegate.getValue(nBPMainPager2, NBPMainPager.$$delegatedProperties[0]));
                        }
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.addChild(new NBPMapView(), new Function1<NBPMapView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPMapView nBPMapView) {
                        final NBPMapView nBPMapView2 = nBPMapView;
                        nBPMapView2.ref(nBPMapView2, new Function1<aa<NBPMapView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager.body.2.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPMapView> aaVar) {
                                NBPViewModelStoreKt.getMapViewModel(NBPMainKtxKt.getNbpVMStore(NBPMapView.this.getPager())).mapViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        nBPMapView2.attr(new Function1<NBPMapViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager.body.2.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPMapViewAttr nBPMapViewAttr) {
                                nBPMapViewAttr.absolutePositionAllZero();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainPager nBPMainPager2 = NBPMainPager.this;
                viewContainer2.addChild(new NBPControlView(), new Function1<NBPControlView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPControlView nBPControlView) {
                        final NBPMainPager nBPMainPager3 = NBPMainPager.this;
                        nBPControlView.attr(new Function1<NBPControlViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager.body.2.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPControlViewAttr nBPControlViewAttr) {
                                NBPControlViewAttr nBPControlViewAttr2 = nBPControlViewAttr;
                                nBPControlViewAttr2.absolutePositionAllZero();
                                NBPViewModelStore vmStore = NBPMainPager.this.getVmStore();
                                nBPControlViewAttr2.m152visibility(((NBPMainMode) vmStore.mainMode$delegate.getValue(vmStore, NBPViewModelStore.$$delegatedProperties[0])) == NBPMainMode.Normal);
                                if (NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore()).getThemeSwitchLoadingAnimationPlaying()) {
                                    nBPControlViewAttr2.m147opacity(0.0f);
                                } else {
                                    nBPControlViewAttr2.m147opacity(1.0f);
                                }
                                nBPControlViewAttr2.animate(b.Companion.l(b.INSTANCE, 0.25f, null, 2, null), Boolean.valueOf(NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore()).getThemeSwitchLoadingAnimationPlaying()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainPager nBPMainPager3 = NBPMainPager.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$2.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPMainMapThemeViewModel mapThemeVM = NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore());
                        return Boolean.valueOf(((Boolean) mapThemeVM.showThemeSwitchLoadingAnimationView$delegate.getValue(mapThemeVM, NBPMainMapThemeViewModel.$$delegatedProperties[10])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$2.5
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        KLog.INSTANCE.i("ThemeLoadingAnimation", "did Create ThemeSwitchLoadingAnimationView");
                        conditionView.addChild(new NBPThemeLoadingAnimationView(), new Function1<NBPThemeLoadingAnimationView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager.body.2.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPThemeLoadingAnimationView nBPThemeLoadingAnimationView) {
                                nBPThemeLoadingAnimationView.attr(new Function1<NBPThemeLoadingAnimationAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager.body.2.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPThemeLoadingAnimationAttr nBPThemeLoadingAnimationAttr) {
                                        nBPThemeLoadingAnimationAttr.absolutePositionAllZero();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainPager nBPMainPager4 = NBPMainPager.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$2.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPGuideViewModel guideViewModel = NBPViewModelStoreKt.getGuideViewModel(NBPMainPager.this.getVmStore());
                        boolean z16 = false;
                        if (((Boolean) guideViewModel.showMarkerTouchGuide$delegate.getValue(guideViewModel, NBPGuideViewModel.$$delegatedProperties[0])).booleanValue()) {
                            NBPMainMapViewModel mapViewModel = NBPViewModelStoreKt.getMapViewModel(NBPMainPager.this.getVmStore());
                            if (((Boolean) mapViewModel.didEnterMapFinishWithMarkers$delegate.getValue(mapViewModel, NBPMainMapViewModel.$$delegatedProperties[0])).booleanValue() && NBPViewModelStoreKt.getMarkersViewModel(NBPMainPager.this.getVmStore()).getVisibleMarkers().size() > 0) {
                                z16 = true;
                            }
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPMainPager nBPMainPager5 = NBPMainPager.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$body$2.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        Object randomOrNull;
                        ConditionView conditionView2 = conditionView;
                        com.tencent.kuikly.core.reactive.collection.c<NBPMapMarker> visibleMarkers = NBPViewModelStoreKt.getMarkersViewModel(NBPMainPager.this.getVmStore()).getVisibleMarkers();
                        NBPMainPager nBPMainPager6 = NBPMainPager.this;
                        ArrayList arrayList = new ArrayList();
                        Iterator<NBPMapMarker> it = visibleMarkers.iterator();
                        while (it.hasNext()) {
                            NBPMapMarker next = it.next();
                            NBPMapMarker nBPMapMarker = next;
                            Object obj = nBPMapMarker.data;
                            boolean z16 = false;
                            if ((obj instanceof NBPFeedMarkerViewModel) && !UserDataManager.INSTANCE.isHostTid(Long.valueOf(((NBPFeedMarkerViewModel) obj).feed.f440825e))) {
                                MarkerRect markerRectOnScreen = nBPMapMarker.getMarkerRectOnScreen();
                                if (!(markerRectOnScreen.left > 0.0f && markerRectOnScreen.top > 126.0f && markerRectOnScreen.right < nBPMainPager6.getPagerData().m() && markerRectOnScreen.bottom < nBPMainPager6.getPagerData().l() - 126.0f)) {
                                    markerRectOnScreen = null;
                                }
                                if (markerRectOnScreen != null) {
                                    z16 = true;
                                }
                            }
                            if (z16) {
                                arrayList.add(next);
                            }
                        }
                        randomOrNull = CollectionsKt___CollectionsKt.randomOrNull(arrayList, Random.INSTANCE);
                        final NBPMapMarker nBPMapMarker2 = (NBPMapMarker) randomOrNull;
                        if (nBPMapMarker2 != null) {
                            final NBPMainPager nBPMainPager7 = NBPMainPager.this;
                            conditionView2.addChild(new NBPMarkerGuideView(), new Function1<NBPMarkerGuideView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager.body.2.7.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPMarkerGuideView nBPMarkerGuideView) {
                                    final NBPMainPager nBPMainPager8 = NBPMainPager.this;
                                    final NBPMapMarker nBPMapMarker3 = nBPMapMarker2;
                                    nBPMarkerGuideView.attr(new Function1<NBPMarkerGuideViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager.body.2.7.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NBPMarkerGuideViewAttr nBPMarkerGuideViewAttr) {
                                            NBPMarkerGuideViewAttr nBPMarkerGuideViewAttr2 = nBPMarkerGuideViewAttr;
                                            a aVar = NBPMainPager.this.markerGuideTag;
                                            if (aVar != null) {
                                                nBPMarkerGuideViewAttr2.tag$delegate.setValue(nBPMarkerGuideViewAttr2, NBPMarkerGuideViewAttr.$$delegatedProperties[0], aVar);
                                            }
                                            nBPMarkerGuideViewAttr2.marker = nBPMapMarker3;
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
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final boolean debugUIInspector() {
        return false;
    }

    public final NBPViewModelStore getVmStore() {
        NBPViewModelStore nBPViewModelStore = this.vmStore;
        if (nBPViewModelStore != null) {
            return nBPViewModelStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vmStore");
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            NBPMainControlViewModel controlViewModel = NBPViewModelStoreKt.getControlViewModel(getVmStore());
            if (((Boolean) controlViewModel.showDeletePositionActionSheet$delegate.getValue(controlViewModel, NBPMainControlViewModel.$$delegatedProperties[1])).booleanValue()) {
                NBPViewModelStoreKt.getControlViewModel(getVmStore()).setShowDeletePositionActionSheet(false);
            } else {
                if (NBPViewModelStoreKt.getMapThemeVM(getVmStore()).onBackPress()) {
                    return;
                }
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        KLog.INSTANCE.i("NBPMainPager", "pageDidAppear");
        this.pgInStart = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        Iterator it = getVmStore().viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onPageDidAppear();
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$pageDidAppear$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPMainPager nBPMainPager = NBPMainPager.this;
                if (nBPMainPager.pagerAppear) {
                    IPagerIdKtxKt.getBridgeModule(nBPMainPager).setBlackStatusBarStyle();
                }
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 200, function0);
        TimerKt.e(getPagerId(), 1, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$pageDidAppear$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NBPMainPager nBPMainPager = NBPMainPager.this;
                nBPMainPager.getClass();
                nBPMainPager.interactivePushNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager), NearbyProChatApiImpl.NEARBY_INTERACTIVE_MSG_COUNT_CHANGED, false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addInteractivePushNotify$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        Integer valueOf = eVar2 != null ? Integer.valueOf(eVar2.j(WidgetCacheConstellationData.NUM)) : null;
                        KLog.INSTANCE.i("NBPMainPager", "receive interactivePushNotifyRef, num=" + valueOf);
                        NBPNotifyViewModel msgNotifyViewModel = NBPViewModelStoreKt.getMsgNotifyViewModel(NBPMainPager.this.getVmStore());
                        if (msgNotifyViewModel.hadEntryMap && valueOf != null) {
                            Integer num = valueOf.intValue() != 0 ? valueOf : null;
                            if (num != null) {
                                num.intValue();
                                msgNotifyViewModel.updateInteractiveMsgCount(valueOf.intValue());
                                Utils.INSTANCE.cacheModule("").setInt(NearbyProUtilsKt.getInteractiveNumCacheKey(), valueOf);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        });
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi");
        h m3 = h.INSTANCE.m();
        qQKuiklyPlatformApi.getClass();
        if (defpackage.k.a(cVar)) {
            e eVar = new e();
            eVar.v("color", m3.toString());
            Unit unit = Unit.INSTANCE;
            qQKuiklyPlatformApi.callNativeMethod("setAndroidNavigationBarColor", eVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        KLog.INSTANCE.i("NBPMainPager", "pageDidDisappear");
        String str = this.interactivePushNotifyRef;
        if (str != null) {
            IPagerIdKtxKt.getNotifyModule(this).e(NearbyProChatApiImpl.NEARBY_INTERACTIVE_MSG_COUNT_CHANGED, str);
        }
        Iterator it = getVmStore().viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onPageDidDisappear();
        }
        this.pgStayTime = (Utils.INSTANCE.currentBridgeModule().currentTimeStamp() - this.pgInStart) + this.pgStayTime;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        KLog.INSTANCE.i("NBPMainPager", Pager.PAGER_EVENT_WILL_DESTROY);
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (defpackage.k.a(cVar)) {
            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_home_map");
            m3.t("nearby_user_from", this.source);
            m3.t("nearby_map_type", NBPViewModelStoreKt.getMapThemeVM(getVmStore()).getThemeMapType());
            m3.v("nearby_map_id", NBPViewModelStoreKt.getMapThemeVM(getVmStore()).reportThemeMapId);
            Utils utils = Utils.INSTANCE;
            m3.u(DTParamKey.REPORT_KEY_LVTM, utils.currentBridgeModule().currentTimeStamp() - this.pgInStart);
            m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            utils.currentBridgeModule().reportCustomDtEvent("dt_pgout", m3);
        }
        String str = this.conciseModeChangeNotifyRef;
        if (str != null) {
            k notifyModule = IPagerIdKtxKt.getNotifyModule(this);
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            notifyModule.e("update_map_concise_action", str);
        }
        String str2 = this.updateCameraPositionNotifyRef;
        if (str2 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("MSG_LOCATION_ACTION", str2);
        }
        String str3 = this.userSelfInfoChangeNotifyRef;
        if (str3 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("onNearbyProUserInfoChange", str3);
        }
        String str4 = this.publishFeedFinishNotifyRef;
        if (str4 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("onPublishFeedFinish", str4);
        }
        String str5 = this.feedDeleteNotifyRef;
        if (str5 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("NBPFeedDeleteEvent", str5);
        }
        String str6 = this.mapThemeChangedNotifyRef;
        if (str6 != null) {
            ((k) cVar.g().acquireModule("KRNotifyModule")).e("NEARBY_CHANGE_MAP_THEME", str6);
            this.mapThemeChangedNotifyRef = null;
        }
        String str7 = this.aioClearMsgNotifyRef;
        if (str7 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("NEARBY_AIO_LIST_CLEAR_MSG_EVENT", str7);
        }
        NearbyProUtilsKt.setEnterNBPMain(false);
        Iterator it = getVmStore().viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onPagerWillDestroy();
        }
        AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.getNotifyModule(this), "NEARBY_MAIN_PAGER_CLOSE_EVENT", false, 4, null);
        QQNearbyModule.Companion companion = QQNearbyModule.Companion;
        companion.getInstance().asyncToNativeMethod("cleanAvatarInfoMap", (e) null, (Function1<? super e, Unit>) null);
        companion.getInstance().asyncToNativeMethod("recycleAIRes", (e) null, (Function1<? super e, Unit>) null);
        NearbyProUtilsKt.setCachedMapThemeList(null);
        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).clearImageMemoryCache();
        MemoryCacheModule memoryCacheModule = (MemoryCacheModule) acquireModule("KRMemoryCacheModule");
        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
        memoryCacheModule.a("nearbypro");
        companion.getInstance().asyncToNativeMethod("clearNTUserInfo", (e) null, (Function1<? super e, Unit>) null);
        companion.getInstance().syncToNativeMethod("onMainPageDestroyed", (e) null, (Function1<? super e, Unit>) null);
    }

    public final void updatePageAutoReportParams() {
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.t("nearby_user_from", this.source);
        nearbyDTBaseParams.t("nearby_map_type", NBPViewModelStoreKt.getMapThemeVM(getVmStore()).getThemeMapType());
        nearbyDTBaseParams.v("nearby_map_id", NBPViewModelStoreKt.getMapThemeVM(getVmStore()).reportThemeMapId);
        long j3 = this.pgStayTime;
        if (j3 > 0) {
            nearbyDTBaseParams.v(DTParamKey.REPORT_KEY_LVTM, String.valueOf(j3));
        }
        nearbyDTBaseParams.v("nearby_tiny_id", String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid));
        this.pageAutoReportParams$delegate.setValue(this, $$delegatedProperties[0], nearbyDTBaseParams);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        Iterator it = getVmStore().viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onPagerViewDidLoad();
        }
        if (defpackage.k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_home_map");
            m3.t("nearby_user_from", this.source);
            m3.t("nearby_map_type", NBPViewModelStoreKt.getMapThemeVM(getVmStore()).getThemeMapType());
            m3.v("nearby_map_id", NBPViewModelStoreKt.getMapThemeVM(getVmStore()).reportThemeMapId);
            m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_pgin", m3);
        }
        NBPMainPager$viewDidLoad$1 nBPMainPager$viewDidLoad$1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$viewDidLoad$1
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQKuiklyPlatformApi.Companion.setEdgePopWidth(0.0f);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 16, nBPMainPager$viewDidLoad$1);
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        int random;
        int random2;
        byte[] a16;
        super.created();
        KLog kLog = KLog.INSTANCE;
        kLog.i("NBPMainPager", "created");
        a aVar = null;
        QQNearbyModule.Companion.getInstance().syncToNativeMethod("onMainPageCreated", (e) null, (Function1<? super e, Unit>) null);
        if (!(!getPageData().n().g("isIpad", false))) {
            kLog.i("NBPMainPager", "device not support NBP");
            Utils.INSTANCE.currentBridgeModule().showAlert(null, "\u8be5\u8bbe\u5907\u6682\u4e0d\u652f\u6301\uff0c\u6211\u4eec\u6b63\u5728\u52aa\u529b\u9002\u914d\u4e2d\uff0c\u6362\u4e2a\u8bbe\u5907\u8bd5\u8bd5\u5427", "\u6211\u77e5\u9053\u4e86", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$created$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.closePage$default();
                    return Unit.INSTANCE;
                }
            });
        }
        Pair pair = new Pair(800, 1200);
        IntRange intRange = new IntRange(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
        Random.Companion companion = Random.INSTANCE;
        random = RangesKt___RangesKt.random(intRange, companion);
        random2 = RangesKt___RangesKt.random(new IntRange(0, 360), companion);
        double d16 = random2 * 0.017453292519943295d;
        double d17 = (random / 1000) / 6371.0d;
        double asin = Math.asin((Math.cos(d16) * Math.sin(d17) * Math.cos(0.0d)) + (Math.cos(d17) * Math.sin(0.0d)));
        double atan2 = Math.atan2(Math.cos(0.0d) * Math.sin(d17) * Math.sin(d16), Math.cos(d17) - (Math.sin(asin) * Math.sin(0.0d))) + 0.0d;
        OffsetRandom offsetRandom = NBPLatLngExtKt.offsetRandom;
        offsetRandom.offsetLat = asin * 57.29577951308232d;
        offsetRandom.offsetLng = atan2 * 57.29577951308232d;
        this.vmStore = new NBPViewModelStore();
        Iterator it = getVmStore().viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onPagerCreated();
        }
        this.source = getPageData().n().k("source", 0);
        NBPViewModelStoreKt.getGuideViewModel(getVmStore()).setShowMarkerTouchGuide(Intrinsics.areEqual(getPageData().n().q("show_marker_guide", "0"), "1"));
        String q16 = getPageData().n().q("marker_guide_tag", "");
        if (!(q16.length() > 0)) {
            q16 = null;
        }
        if (q16 != null && (a16 = d45.a.a(q16)) != null) {
            aVar = (a) i.b(new a(0, null, 63), a16);
        }
        this.markerGuideTag = aVar;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$created$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NBPMainPager nBPMainPager = NBPMainPager.this;
                nBPMainPager.getClass();
                k notifyModule = IPagerIdKtxKt.getNotifyModule(nBPMainPager);
                NearbyConst nearbyConst = NearbyConst.INSTANCE;
                nBPMainPager.conciseModeChangeNotifyRef = k.b(notifyModule, "update_map_concise_action", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addConciseModeChangeEvent$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        NBPMainMode nBPMainMode;
                        e eVar2 = eVar;
                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("on concise mode change: ", eVar2, KLog.INSTANCE, "NBPMainPager");
                        if (eVar2 != null) {
                            NBPMainPager nBPMainPager2 = NBPMainPager.this;
                            NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                            if (eVar2.f("nearbyData")) {
                                nBPMainMode = NBPMainMode.Concise;
                            } else {
                                nBPMainMode = NBPMainMode.Normal;
                            }
                            NBPViewModelStore vmStore = nBPMainPager2.getVmStore();
                            vmStore.mainMode$delegate.setValue(vmStore, NBPViewModelStore.$$delegatedProperties[0], nBPMainMode);
                            vmStore.onModeChanged(nBPMainMode, vmStore.subMode);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                final NBPMainPager nBPMainPager2 = NBPMainPager.this;
                nBPMainPager2.getClass();
                nBPMainPager2.updateCameraPositionNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager2), "MSG_LOCATION_ACTION", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addUpdateCameraPositionEvent$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        NBPMapView b16;
                        e eVar2 = eVar;
                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("on update camera position change: ", eVar2, KLog.INSTANCE, "NBPMainPager");
                        if (eVar2 != null) {
                            NBPMainPager nBPMainPager3 = NBPMainPager.this;
                            NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                            if (eVar2.a("nearbyData") && (eVar2 = eVar2.m("nearbyData")) == null) {
                                eVar2 = new e();
                            }
                            NBPLatLng nBPLatLng = new NBPLatLng(eVar2.i("latitude", 0.0d), eVar2.i("longitude", 0.0d));
                            long o16 = eVar2.o("animateDuration", 300L);
                            aa<NBPMapView> aaVar = NBPViewModelStoreKt.getMapViewModel(nBPMainPager3.getVmStore()).mapViewRef;
                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                CameraUpdate cameraUpdate = new CameraUpdate();
                                cameraUpdate.target = nBPLatLng;
                                cameraUpdate.animate = true;
                                cameraUpdate.animateDuration = o16;
                                int i3 = NBPMapView.$r8$clinit;
                                b16.moveCamera(cameraUpdate, null);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                final NBPMainPager nBPMainPager3 = NBPMainPager.this;
                nBPMainPager3.getClass();
                nBPMainPager3.updateCameraPositionNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager3), "NEARBY_MAP_CAMERA_POSITION_REQ_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addCameraPositionRequestEvent$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        NBPLatLng nBPLatLng = NBPViewModelStoreKt.getMapViewModel(NBPMainPager.this.getVmStore()).currentTargetPosition;
                        k notifyModule2 = IPagerIdKtxKt.getNotifyModule(NBPMainPager.this);
                        e eVar2 = new e();
                        eVar2.s(QCircleSchemeAttr.Polymerize.LAT, nBPLatLng.latitude);
                        eVar2.s("lng", nBPLatLng.longitude);
                        Unit unit = Unit.INSTANCE;
                        k.d(notifyModule2, "NEARBY_MAP_CAMERA_POSITION_RSP_EVENT", eVar2, false, 4, null);
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                final NBPMainPager nBPMainPager4 = NBPMainPager.this;
                nBPMainPager4.getClass();
                nBPMainPager4.userSelfInfoChangeNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager4), "onNearbyProUserInfoChange", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addUserSelfInfoChangeEvent$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("on user info change: ", eVar, KLog.INSTANCE, "NBPMainPager");
                        UserDataManager userDataManager = UserDataManager.INSTANCE;
                        NBPUserSelfInfo loadUserInfo = userDataManager.loadUserInfo();
                        NBPUserSelfInfo userSelfInfo = userDataManager.getUserSelfInfo();
                        userSelfInfo.getClass();
                        userSelfInfo.tid = loadUserInfo.tid;
                        userSelfInfo.avatarUrl = loadUserInfo.avatarUrl;
                        userSelfInfo.latLng = loadUserInfo.latLng;
                        userSelfInfo.gender = loadUserInfo.gender;
                        userSelfInfo.nickName = loadUserInfo.nickName;
                        userSelfInfo.statusInfo = loadUserInfo.statusInfo;
                        userSelfInfo.locationAddress = loadUserInfo.locationAddress;
                        userSelfInfo.locationName = loadUserInfo.locationName;
                        userSelfInfo.locationCountry = loadUserInfo.locationCountry;
                        userSelfInfo.locationProvince = loadUserInfo.locationProvince;
                        userSelfInfo.locationCity = loadUserInfo.locationCity;
                        userSelfInfo.locationDistrict = loadUserInfo.locationDistrict;
                        userSelfInfo.avatarDressBorderUrl = loadUserInfo.avatarDressBorderUrl;
                        NBPMapMarker generateHostMapMarker = NBPMarkerFactory.INSTANCE.generateHostMapMarker(userDataManager.getUserSelfInfo().latLng);
                        if (generateHostMapMarker != null) {
                            NBPViewModelStoreKt.getMapViewModel(NBPMainPager.this.getVmStore()).updateHostMarker(generateHostMapMarker);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                final NBPMainPager nBPMainPager5 = NBPMainPager.this;
                nBPMainPager5.getClass();
                nBPMainPager5.publishFeedFinishNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager5), "onPublishFeedFinish", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addPublishFeedFinishNotify$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        l lVar;
                        float f16;
                        float f17;
                        String decodeToString;
                        Object firstOrNull;
                        List mutableList;
                        List mutableList2;
                        Object firstOrNull2;
                        String poiDetailName;
                        String str;
                        String str2;
                        n25.i iVar;
                        String p16;
                        e eVar2 = eVar;
                        l statusFeed = (eVar2 == null || (p16 = eVar2.p("statusFeed")) == null) ? null : NearbyProUtilsKt.toStatusFeed(p16);
                        boolean areEqual = Intrinsics.areEqual(eVar2 != null ? eVar2.p("isSelectedTheme") : null, "1");
                        if (statusFeed != null) {
                            n25.k kVar = statusFeed.C;
                            if (kVar == null || (iVar = kVar.C) == null) {
                                f16 = 0.0f;
                                f17 = 0.0f;
                            } else {
                                double d18 = 1000000;
                                f16 = (float) (iVar.f418080e / d18);
                                f17 = (float) (iVar.f418079d / d18);
                            }
                            decodeToString = StringsKt__StringsJVMKt.decodeToString(statusFeed.f418096i.f30291a);
                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) statusFeed.f418097m);
                            j jVar = (j) firstOrNull;
                            String str3 = statusFeed.f418092d;
                            r25.e eVar3 = statusFeed.f418093e;
                            long j3 = eVar3 != null ? eVar3.f430610d : 0L;
                            o25.e eVar4 = new o25.e(f17, f16, 4);
                            g gVar = statusFeed.f418094f;
                            int b16 = d.b(true);
                            int i3 = (int) statusFeed.D;
                            n25.k kVar2 = statusFeed.C;
                            String str4 = (kVar2 == null || (str2 = kVar2.f418086d) == null) ? "" : str2;
                            String str5 = (kVar2 == null || (str = kVar2.f418087e) == null) ? "" : str;
                            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) statusFeed.J);
                            int i16 = statusFeed.L;
                            n25.b bVar = statusFeed.M;
                            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) statusFeed.P);
                            n25.k kVar3 = statusFeed.C;
                            lVar = statusFeed;
                            v25.a aVar2 = new v25.a(str3, j3, eVar4, decodeToString, gVar, jVar, b16, i3, "", str4, str5, mutableList, i16, bVar, mutableList2, (kVar3 == null || (poiDetailName = NearbyProUtilsKt.getPoiDetailName(kVar3)) == null) ? "" : poiDetailName, 1974272);
                            NBPMainPager nBPMainPager6 = NBPMainPager.this;
                            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) aVar2.M);
                            String str6 = (String) firstOrNull2;
                            String str7 = NBPViewModelStoreKt.getMarkersViewModel(nBPMainPager6.getVmStore()).currentMapThemeId;
                            if (!Intrinsics.areEqual(str7, "") && !Intrinsics.areEqual(str6, str7)) {
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder a17 = defpackage.j.a("publish feed not in current themeId: ", str7, " , feed themeId:", str6, " feedId:");
                                a17.append(aVar2.f440824d);
                                a17.append(", feed title:");
                                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(a17, aVar2.f440827h, kLog2, "NBPMainPager");
                            } else {
                                NBPMapMarker generateMapMarker = NBPMarkerFactory.INSTANCE.generateMapMarker(aVar2);
                                if (generateMapMarker != null) {
                                    NBPViewModelStoreKt.getMarkersViewModel(nBPMainPager6.getVmStore()).addMarker(generateMapMarker);
                                    NBPViewModelStoreKt.getMapViewModel(nBPMainPager6.getVmStore()).moveCameraToTarget(generateMapMarker.position);
                                    KLog kLog3 = KLog.INSTANCE;
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("did insert local feed marker ");
                                    m3.append(generateMapMarker.key);
                                    m3.append(" , notify data:");
                                    m3.append(eVar2);
                                    kLog3.i("NBPMainPager", m3.toString());
                                }
                            }
                        } else {
                            lVar = statusFeed;
                        }
                        if (areEqual) {
                            final NBPMainMapThemeViewModel mapThemeVM = NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore());
                            mapThemeVM.getClass();
                            KLog.INSTANCE.i("NBPMainMapThemeViewModel", "refreshMapThemesData");
                            mapThemeVM.fetchMapThemes(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$refreshMapThemesData$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    f currentMapTheme = NBPMainMapThemeViewModel.this.getCurrentMapTheme();
                                    if (currentMapTheme != null) {
                                        NBPMainMapThemeViewModel nBPMainMapThemeViewModel = NBPMainMapThemeViewModel.this;
                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("find current refresh theme: "), currentMapTheme.f421849d, KLog.INSTANCE, "NBPMainMapThemeViewModel");
                                        nBPMainMapThemeViewModel.refreshCurrentMapThemeData(currentMapTheme);
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        KLog kLog4 = KLog.INSTANCE;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("on feed publish finish with fid: ");
                        m16.append(lVar != null ? lVar.f418092d : null);
                        m16.append(", ");
                        m16.append(areEqual);
                        kLog4.i("NBPMainPager", m16.toString());
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                final NBPMainPager nBPMainPager6 = NBPMainPager.this;
                nBPMainPager6.getClass();
                nBPMainPager6.feedDeleteNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager6), "NBPFeedDeleteEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addFeedDeleteNotify$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        String str;
                        e eVar2 = eVar;
                        if (eVar2 == null || (str = eVar2.p("feedId")) == null) {
                            str = "";
                        }
                        NBPMarkersViewModel markersViewModel = NBPViewModelStoreKt.getMarkersViewModel(NBPMainPager.this.getVmStore());
                        NBPFeedMarkerViewModel.Companion.getClass();
                        markersViewModel.removeMarker("feed_" + str);
                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("receive feed delete event with fid: ", str, KLog.INSTANCE, "NBPMainPager");
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                final NBPMainPager nBPMainPager7 = NBPMainPager.this;
                nBPMainPager7.getClass();
                final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addMapThemeChangedNotify$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(String str) {
                        String str2 = str;
                        final NBPMainMapThemeViewModel mapThemeVM = NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore());
                        mapThemeVM.getClass();
                        KLog kLog2 = KLog.INSTANCE;
                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("onMapThemeChange: ", str2, kLog2, "NBPMainMapThemeViewModel");
                        if (mapThemeVM.getTheme(str2) != null) {
                            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("theme list  ready, get theme from cache: ", str2, kLog2, "NBPMainMapThemeViewModel");
                            mapThemeVM.changeMapTheme(str2, true);
                        } else {
                            mapThemeVM.paddingSelectedThemeId = str2;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("theme list not ready, get theme from network: ");
                            m3.append(mapThemeVM.paddingSelectedThemeId);
                            kLog2.i("NBPMainMapThemeViewModel", m3.toString());
                            mapThemeVM.fetchMapThemes(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$onMapThemeChange$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPMainMapThemeViewModel nBPMainMapThemeViewModel = NBPMainMapThemeViewModel.this;
                                    nBPMainMapThemeViewModel.changeMapTheme(nBPMainMapThemeViewModel.paddingSelectedThemeId, true);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                };
                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                nBPMainPager7.mapThemeChangedNotifyRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "NEARBY_CHANGE_MAP_THEME", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt$addMapThemeChangedNotify$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        String str;
                        e eVar2 = eVar;
                        Function1<String, Unit> function12 = function1;
                        if (eVar2 == null || (str = eVar2.p("id")) == null) {
                            str = "";
                        }
                        function12.invoke(str);
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                NBPMainPager nBPMainPager8 = NBPMainPager.this;
                nBPMainPager8.getClass();
                k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager8), "QQNearbyProTempAIOWillAppear", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addTempAIOLifeCycleNotify$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).callNativeMethod("setNativeRootViewHidden", null);
                        KLog.INSTANCE.i("NBPMainPager", "QQNearbyProTempAIOWillAppear did setNativeRootViewHidden");
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager8), "QQNearbyProTempAIOWillDisappear", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addTempAIOLifeCycleNotify$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).callNativeMethod("setNativeRootViewVisible", null);
                        KLog.INSTANCE.i("NBPMainPager", "QQNearbyProTempAIODidDisappear did setNativeRootViewVisible");
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                final NBPMainPager nBPMainPager9 = NBPMainPager.this;
                nBPMainPager9.getClass();
                nBPMainPager9.aioClearMsgNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPMainPager9), "NEARBY_AIO_LIST_CLEAR_MSG_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$addAioClearMsgNotify$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        KLog.INSTANCE.i("NBPMainPager", "receive addAioClearMsgNotify");
                        NBPViewModelStoreKt.getMsgNotifyViewModel(NBPMainPager.this.getVmStore()).setInteractiveCacheNum("notify");
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                ((QQKuiklyFontModule) cVar.g().acquireModule("QQKuiklyFontModule")).registerFont("https://qqvip-web.cdn-go.cn/mono/latest/innovation/cooperation.d08a389a788c7f5bc749.ttf", false, null);
                AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.getNotifyModule(NBPMainPager.this), "NBPEnterEvent", false, 4, null);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 1, function0);
        this.pgInStart = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        updatePageAutoReportParams();
        MemoryCacheModule memoryCacheModule = (MemoryCacheModule) acquireModule("KRMemoryCacheModule");
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        memoryCacheModule.f("nearbypro", 10485760, 20);
    }
}
