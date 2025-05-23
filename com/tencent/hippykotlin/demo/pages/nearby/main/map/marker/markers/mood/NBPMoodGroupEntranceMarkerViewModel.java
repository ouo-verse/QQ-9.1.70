package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQContext;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.NBPMarkerTypeZIndex$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.FocusableMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerRect;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerTransform;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerUIScheduler;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.mood.NBPMainMoodGroupViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.v;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import w25.a;
import w25.c;
import w25.g;

/* loaded from: classes31.dex */
public final class NBPMoodGroupEntranceMarkerViewModel extends FocusableMarker implements IMarkerCollection, INBPMapMarkerUpdate {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMoodGroupEntranceMarkerViewModel.class, "autoJoinedMood", "getAutoJoinedMood()Z", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty autoJoinedMood$delegate;
    public final NBPMoodGroupEntranceConfig config;
    public final a entrance;
    public aa<NBPMoodGroupEntranceMarkerView> entranceMarkerViewRef;
    public MarkerRect entrancePlace;
    public final c entranceRsp;
    public d joinBtnFrame;
    public aa<v> joinBtnRef;
    public String joinedMoodNotifyRef;
    public final String key;
    public final MarkerRect markerRect;
    public NBPLatLng position;
    public final Lazy viewBuilder$delegate;
    public final double zIndex;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final boolean addCollectionMarker(NBPMapMarker nBPMapMarker, float f16) {
        return f16 >= this.config.aggregateLevel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final boolean canShowOnSubMode() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011c  */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean clickInSide(float f16, float f17, MarkerRect markerRect) {
        boolean z16;
        v b16;
        if (isFocused()) {
            markerRect = markerRect.scale(1.25f, 1.25f, 0.5f, 1.0f);
        }
        if (!markerRect.contains(f16, f17)) {
            return Boolean.FALSE;
        }
        if (this.joinBtnFrame == null) {
            aa<v> aaVar = this.joinBtnRef;
            this.joinBtnFrame = (aaVar == null || (b16 = aaVar.b()) == null) ? null : b16.getFrame();
        }
        d dVar = this.joinBtnFrame;
        if (dVar != null) {
            float f18 = isFocused() ? 1.25f : 1.0f;
            if (isFocused()) {
                dVar = new d(dVar.getX() * f18, dVar.getY() * f18, dVar.getWidth() * f18, dVar.getHeight() * f18);
            }
            float f19 = (f16 - markerRect.left) - (f18 * 54.0f);
            float f26 = f17 - markerRect.top;
            if (f19 <= dVar.getWidth() + dVar.getX() && dVar.getX() <= f19) {
                if (f26 <= dVar.getHeight() + dVar.getY() && dVar.getY() <= f26) {
                    z16 = true;
                    if (!z16) {
                        g gVar = this.entranceRsp.f444476e;
                        int i3 = (gVar != null ? gVar.f444489e : null) == null ? 1 : 0;
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[onMoodBtnClick]: mid:");
                        m3.append(this.entrance.f444465d);
                        m3.append(", moodName:");
                        m3.append(this.entrance.H);
                        m3.append(", joinGroup: ");
                        m3.append(i3);
                        kLog.i("NBPMoodGroupEntranceMarkerViewModel", m3.toString());
                        jumpMoodGroup(i3);
                        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                        jsonWithMainPgParams.v("dt_eid", "em_nearby_emotion_circle_en");
                        jsonWithMainPgParams.t("nearby_circle_type", this.entrance.f444465d != 1 ? 2 : 1);
                        jsonWithMainPgParams.t("nearby_click_area", 0);
                        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
                    } else {
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[onMoodAreaClick]: ");
                        m16.append(this.entrance.f444465d);
                        m16.append(", ");
                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, this.entrance.H, kLog2, "NBPMoodGroupEntranceMarkerViewModel");
                        jumpMoodGroup(0);
                        e jsonWithMainPgParams2 = NearbyConstKt.jsonWithMainPgParams();
                        jsonWithMainPgParams2.v("dt_eid", "em_nearby_emotion_circle_en");
                        jsonWithMainPgParams2.t("nearby_circle_type", this.entrance.f444465d == 1 ? 1 : 2);
                        jsonWithMainPgParams2.t("nearby_click_area", 1);
                        jsonWithMainPgParams2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams2);
                    }
                    return Boolean.TRUE;
                }
            }
        }
        z16 = false;
        if (!z16) {
        }
        return Boolean.TRUE;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final MarkerRect getMarkerRectOnScreen(NBPMapMarker nBPMapMarker) {
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final NBPMarkerTransform getMarkerViewTransformWhenMapChangedOnVisible(float f16, float f17, float f18, NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        w wVar = NBPMoodGroupEntranceUIConfig.size;
        return new NBPMarkerTransform(new y((f17 / wVar.getWidth()) - 0.5f, (f18 / wVar.getHeight()) - 0.5f, 0.0f, 0.0f, 12, null), new u(1.0f, 1.0f));
    }

    public final void initMarkerPosition(CameraPosition cameraPosition) {
        MarkerRect markerRect;
        if (this.config.isMoodEntryAdaptive) {
            NBPMoodGroupEntranceUIConfig nBPMoodGroupEntranceUIConfig = NBPMoodGroupEntranceUIConfig.INSTANCE;
            markerRect = this.markerRect;
        } else {
            w wVar = NBPMoodGroupEntranceUIConfig.size;
            w wVar2 = new w(64.0f, 64.0f);
            com.tencent.kuikly.core.pager.g pageData = com.tencent.kuikly.core.manager.c.f117352a.g().getPageData();
            float f16 = 2;
            MarkerRect markerRect2 = new MarkerRect(0.0f, 0.0f, pageData.m(), (pageData.l() / f16) - wVar2.getHeight());
            MarkerRect markerRect3 = new MarkerRect(0.0f, wVar2.getHeight() + (pageData.l() / f16), pageData.m(), (pageData.l() - 112.0f) - (wVar.getHeight() / 2.0f));
            int nextInt = Random.INSTANCE.nextInt(0, 2);
            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("random rect index: ", nextInt, KLog.INSTANCE, "NBPMoodGroupEntranceMarkerViewModel");
            markerRect = new MarkerRect[]{markerRect2, markerRect3}[nextInt];
        }
        this.entrancePlace = markerRect;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[initMarkerPosition], screen position: ");
        m3.append(this.entrancePlace);
        m3.append(", markerViewSize: ");
        m3.append(NBPMoodGroupEntranceUIConfig.size);
        kLog.i("NBPMoodGroupEntranceMarkerViewModel", m3.toString());
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        double m16 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar) / (cameraPosition.topRightPosition.longitude - cameraPosition.topLeftPosition.longitude);
        double l3 = cVar.g().getPageData().l() / (cameraPosition.bottomLeftPosition.latitude - cameraPosition.topLeftPosition.latitude);
        double centerX = ((cameraPosition.topLeftPosition.longitude * m16) + this.entrancePlace.getCenterX()) / m16;
        double centerY = ((cameraPosition.topLeftPosition.latitude * l3) + this.entrancePlace.getCenterY()) / l3;
        kLog.i("NBPMoodGroupEntranceMarkerViewModel", "[initMarkerPosition], lon: " + centerX + ", lat: " + centerY + ", center: " + this.entrancePlace.getCenterX() + ", " + this.entrancePlace.getCenterY());
        this.position = new NBPLatLng(centerY, centerX);
    }

    public final void jumpMoodGroup(int i3) {
        NBPViewModelStore nbpVMStore;
        a aVar = this.entrance;
        NBPJumpUtil.jumpMoodGroupPage$default(1, aVar.f444465d, i3, aVar.F, false, 16);
        if (i3 == 1) {
            nbpVMStore = NBPMainKtxKt.getNbpVMStore(com.tencent.kuikly.core.manager.c.f117352a.g());
            ((NBPMainMoodGroupViewModel) nbpVMStore.getViewModel("NBPMainMoodGroupViewModel")).needFetchMoodGroupEntranceWhenAppear = true;
        }
    }

    public NBPMoodGroupEntranceMarkerViewModel(a aVar, c cVar, NBPMoodGroupEntranceConfig nBPMoodGroupEntranceConfig, CameraPosition cameraPosition, MarkerRect markerRect) {
        super(1.25f, 0.5f, 1.0f);
        Lazy lazy;
        this.entrance = aVar;
        this.entranceRsp = cVar;
        this.config = nBPMoodGroupEntranceConfig;
        this.markerRect = markerRect;
        this.autoJoinedMood$delegate = c01.c.a(Boolean.FALSE);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel$viewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel = NBPMoodGroupEntranceMarkerViewModel.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel$viewBuilder$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel2 = NBPMoodGroupEntranceMarkerViewModel.this;
                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel3 = nBPMoodGroupEntranceMarkerViewModel;
                        viewContainer.addChild(new NBPMoodGroupEntranceMarkerView(), new Function1<NBPMoodGroupEntranceMarkerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel.viewBuilder.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView) {
                                NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView2 = nBPMoodGroupEntranceMarkerView;
                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel4 = NBPMoodGroupEntranceMarkerViewModel.this;
                                nBPMoodGroupEntranceMarkerView2.ref(nBPMoodGroupEntranceMarkerView2, new Function1<aa<NBPMoodGroupEntranceMarkerView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel.viewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<NBPMoodGroupEntranceMarkerView> aaVar) {
                                        NBPMoodGroupEntranceMarkerViewModel.this.entranceMarkerViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel5 = nBPMoodGroupEntranceMarkerViewModel3;
                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel6 = NBPMoodGroupEntranceMarkerViewModel.this;
                                nBPMoodGroupEntranceMarkerView2.attr(new Function1<NBPMoodGroupEntranceAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel.viewBuilder.2.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPMoodGroupEntranceAttr nBPMoodGroupEntranceAttr) {
                                        NBPMoodGroupEntranceAttr nBPMoodGroupEntranceAttr2 = nBPMoodGroupEntranceAttr;
                                        nBPMoodGroupEntranceAttr2.viewModel = NBPMoodGroupEntranceMarkerViewModel.this;
                                        NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel7 = nBPMoodGroupEntranceMarkerViewModel6;
                                        nBPMoodGroupEntranceAttr2.joinedMood$delegate.setValue(nBPMoodGroupEntranceAttr2, NBPMoodGroupEntranceAttr.$$delegatedProperties[0], Boolean.valueOf(((Boolean) nBPMoodGroupEntranceMarkerViewModel7.autoJoinedMood$delegate.getValue(nBPMoodGroupEntranceMarkerViewModel7, NBPMoodGroupEntranceMarkerViewModel.$$delegatedProperties[0])).booleanValue()));
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
        this.viewBuilder$delegate = lazy;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mood_");
        m3.append(aVar.f444465d);
        this.key = m3.toString();
        this.zIndex = NBPMarkerTypeZIndex$EnumUnboxingLocalUtility._getIndex(4);
        this.position = UserDataManager.INSTANCE.getSelfVaguePos();
        new d(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        this.entrancePlace = MarkerRect.Companion.createRectWithSize((QQContext.INSTANCE.getPageData().m() - 160.0f) / 2, 100.0f, 160.0f, 81.0f);
        initMarkerPosition(cameraPosition);
        TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPMoodGroupEntranceMarkerView b16;
                int i3;
                aa<NBPMoodGroupEntranceMarkerView> aaVar = NBPMoodGroupEntranceMarkerViewModel.this.entranceMarkerViewRef;
                if (aaVar != null && (b16 = aaVar.b()) != null && (i3 = b16.animationRotateIndex) == 0) {
                    b16.animationRotateIndex = i3 + 1;
                    b16.animationRotate$delegate.setValue(b16, NBPMoodGroupEntranceMarkerView.$$delegatedProperties[2], Float.valueOf(((Float[]) b16.animationRotateGroup$delegate.getValue())[b16.animationRotateIndex].floatValue()));
                }
                NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel = NBPMoodGroupEntranceMarkerViewModel.this;
                k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel2 = NBPMoodGroupEntranceMarkerViewModel.this;
                nBPMoodGroupEntranceMarkerViewModel.joinedMoodNotifyRef = k.b(kVar, "NEARBY_JOIN_MOOD_GROUP_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerViewModel.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel3 = NBPMoodGroupEntranceMarkerViewModel.this;
                        nBPMoodGroupEntranceMarkerViewModel3.autoJoinedMood$delegate.setValue(nBPMoodGroupEntranceMarkerViewModel3, NBPMoodGroupEntranceMarkerViewModel.$$delegatedProperties[0], Boolean.TRUE);
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final void resetCollection() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final void themeConfigDidLoad() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final void onClickMarkerFromMap(float f16, float f17) {
    }
}
