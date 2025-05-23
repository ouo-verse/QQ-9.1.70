package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.NBPMarkerTypeZIndex$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.FocusableMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerRect;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerStatus;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerTransform;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerUIScheduler;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerUIConfig;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import n25.j;
import n35.v;
import n35.w;
import n35.z;
import v25.a;

/* loaded from: classes31.dex */
public final class NBPFeedMarkerViewModel extends FocusableMarker implements IMarkerCollection, INBPMapMarkerUpdate {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedMarkerViewModel.class, "topFeedImageNode", "getTopFeedImageNode()Lkuikly/com/tencent/trpcprotocol/qqntv2/richmedia/richmedia/IndexNode;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedMarkerViewModel.class, "topFeedTitle", "getTopFeedTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedMarkerViewModel.class, "topFeedIsCityWalk", "getTopFeedIsCityWalk()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedMarkerViewModel.class, "collectionCount", "getCollectionCount()Ljava/lang/Integer;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedMarkerViewModel.class, "showSliderMoreBtn", "getShowSliderMoreBtn()Z", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty collectionCount$delegate;
    public Integer collectionCountRaw;
    public ArrayList<NBPMapMarker> collectionMarkers;
    public float currentZoomLevel;
    public final a feed;
    public final boolean hasImage;
    public final String key;
    public final NBPLatLng position;
    public final ReadWriteProperty showSliderMoreBtn$delegate;
    public String showSliderMoreBtnDelayHandle;
    public boolean slidesImplReported;
    public final String title;
    public final ReadWriteProperty topFeedImageNode$delegate;
    public final ReadWriteProperty topFeedTitle$delegate;
    public final Lazy viewBuilder$delegate;
    public final Lazy zIndex$delegate;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final String markerKey(String str) {
            return AgreementConsentViewKt$$ExternalSyntheticOutline0.m("feed_", str);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NBPFeedMarkerViewModel(a aVar) {
        super(r0.getInstance().getFocusedScale(), r0.getInstance().getTargetXPercent(), r0.getInstance().getTargetYPercent());
        Lazy lazy;
        v vVar;
        CharSequence trim;
        Lazy lazy2;
        j jVar;
        v vVar2;
        CharSequence trim2;
        w wVar;
        List<z> list;
        Object firstOrNull;
        z zVar;
        w wVar2;
        List<z> list2;
        Object firstOrNull2;
        NBPFeedMarkerUIConfig.Companion companion = NBPFeedMarkerUIConfig.Companion;
        this.feed = aVar;
        this.key = Companion.markerKey(aVar.f440824d);
        this.position = aVar.f440826f != null ? new NBPLatLng(r0.f421846d, r0.f421847e) : null;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel$viewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPFeedMarkerViewModel nBPFeedMarkerViewModel = NBPFeedMarkerViewModel.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel$viewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPFeedMarkerViewModel nBPFeedMarkerViewModel2 = NBPFeedMarkerViewModel.this;
                        viewContainer.addChild(new NBPFeedMarkerView(), new Function1<NBPFeedMarkerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel.viewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedMarkerView nBPFeedMarkerView) {
                                final NBPFeedMarkerViewModel nBPFeedMarkerViewModel3 = NBPFeedMarkerViewModel.this;
                                nBPFeedMarkerView.attr(new Function1<NBPFeedMarkerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel.viewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedMarkerAttr nBPFeedMarkerAttr) {
                                        NBPFeedMarkerAttr nBPFeedMarkerAttr2 = nBPFeedMarkerAttr;
                                        nBPFeedMarkerAttr2.viewModel = NBPFeedMarkerViewModel.this;
                                        nBPFeedMarkerAttr2.accessibility("\u5e16\u5b50");
                                        nBPFeedMarkerAttr2.accessibilityRole(AccessibilityRole.BUTTON);
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
        j jVar2 = aVar.f440829m;
        if (jVar2 != null && (wVar2 = jVar2.f418083d) != null && (list2 = wVar2.f418273d) != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            z zVar2 = (z) firstOrNull2;
            if (zVar2 != null) {
                vVar = zVar2.f418280d;
                this.hasImage = vVar == null;
                trim = StringsKt__StringsKt.trim((CharSequence) aVar.f440827h);
                this.title = trim.toString();
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Double>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel$zIndex$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0027, code lost:
                    
                        if (com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt.getMarkersViewModel(r0).officialPOIs.contains(r10.this$0.feed.S) != false) goto L11;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Double invoke() {
                        double d16;
                        float f16;
                        NBPViewModelStore nbpVMStore;
                        boolean z16 = true;
                        if (NBPFeedMarkerViewModel.this.feed.S.length() > 0) {
                            nbpVMStore = NBPMainKtxKt.getNbpVMStore(c.f117352a.g());
                        }
                        z16 = false;
                        NBPFeedMarkerViewModel nBPFeedMarkerViewModel = NBPFeedMarkerViewModel.this;
                        if (nBPFeedMarkerViewModel.hasImage) {
                            double index = NBPMarkerTypeZIndex$EnumUnboxingLocalUtility.getIndex(z16 ? 8 : 5);
                            d16 = index + r0.E;
                            f16 = nBPFeedMarkerViewModel.feed.Q;
                        } else {
                            double index2 = NBPMarkerTypeZIndex$EnumUnboxingLocalUtility.getIndex(z16 ? 9 : 6);
                            d16 = index2 + r0.E;
                            f16 = nBPFeedMarkerViewModel.feed.Q;
                        }
                        return Double.valueOf((f16 * 3600 * 24 * 360) + d16);
                    }
                });
                this.zIndex$delegate = lazy2;
                jVar = aVar.f440829m;
                if (jVar != null && (wVar = jVar.f418083d) != null && (list = wVar.f418273d) != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                    zVar = (z) firstOrNull;
                    if (zVar != null) {
                        vVar2 = zVar.f418280d;
                        this.topFeedImageNode$delegate = c01.c.a(vVar2);
                        trim2 = StringsKt__StringsKt.trim((CharSequence) aVar.f440827h);
                        this.topFeedTitle$delegate = c01.c.a(trim2.toString());
                        c01.c.a(Boolean.valueOf(aVar.K == 1));
                        this.collectionCount$delegate = c01.c.a(null);
                        this.showSliderMoreBtn$delegate = c01.c.a(Boolean.FALSE);
                        this.collectionMarkers = new ArrayList<>();
                    }
                }
                vVar2 = null;
                this.topFeedImageNode$delegate = c01.c.a(vVar2);
                trim2 = StringsKt__StringsKt.trim((CharSequence) aVar.f440827h);
                this.topFeedTitle$delegate = c01.c.a(trim2.toString());
                c01.c.a(Boolean.valueOf(aVar.K == 1));
                this.collectionCount$delegate = c01.c.a(null);
                this.showSliderMoreBtn$delegate = c01.c.a(Boolean.FALSE);
                this.collectionMarkers = new ArrayList<>();
            }
        }
        vVar = null;
        this.hasImage = vVar == null;
        trim = StringsKt__StringsKt.trim((CharSequence) aVar.f440827h);
        this.title = trim.toString();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Double>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel$zIndex$2
            {
                super(0);
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0027, code lost:
            
                if (com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt.getMarkersViewModel(r0).officialPOIs.contains(r10.this$0.feed.S) != false) goto L11;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Double invoke() {
                double d16;
                float f16;
                NBPViewModelStore nbpVMStore;
                boolean z16 = true;
                if (NBPFeedMarkerViewModel.this.feed.S.length() > 0) {
                    nbpVMStore = NBPMainKtxKt.getNbpVMStore(c.f117352a.g());
                }
                z16 = false;
                NBPFeedMarkerViewModel nBPFeedMarkerViewModel = NBPFeedMarkerViewModel.this;
                if (nBPFeedMarkerViewModel.hasImage) {
                    double index = NBPMarkerTypeZIndex$EnumUnboxingLocalUtility.getIndex(z16 ? 8 : 5);
                    d16 = index + r0.E;
                    f16 = nBPFeedMarkerViewModel.feed.Q;
                } else {
                    double index2 = NBPMarkerTypeZIndex$EnumUnboxingLocalUtility.getIndex(z16 ? 9 : 6);
                    d16 = index2 + r0.E;
                    f16 = nBPFeedMarkerViewModel.feed.Q;
                }
                return Double.valueOf((f16 * 3600 * 24 * 360) + d16);
            }
        });
        this.zIndex$delegate = lazy2;
        jVar = aVar.f440829m;
        if (jVar != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            zVar = (z) firstOrNull;
            if (zVar != null) {
            }
        }
        vVar2 = null;
        this.topFeedImageNode$delegate = c01.c.a(vVar2);
        trim2 = StringsKt__StringsKt.trim((CharSequence) aVar.f440827h);
        this.topFeedTitle$delegate = c01.c.a(trim2.toString());
        c01.c.a(Boolean.valueOf(aVar.K == 1));
        this.collectionCount$delegate = c01.c.a(null);
        this.showSliderMoreBtn$delegate = c01.c.a(Boolean.FALSE);
        this.collectionMarkers = new ArrayList<>();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final boolean addCollectionMarker(NBPMapMarker nBPMapMarker, float f16) {
        float f17 = NBPFeedMarkerUIConfig.Companion.getInstance().collectionAreaPercent;
        Object obj = nBPMapMarker.data;
        boolean z16 = obj instanceof NBPFeedMarkerViewModel;
        if (!z16) {
            return f16 >= f17;
        }
        if (f16 < f17) {
            return false;
        }
        if ((z16 ? (NBPFeedMarkerViewModel) obj : null) != null) {
            this.collectionMarkers.add(nBPMapMarker);
        }
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final boolean canShowOnSubMode() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final Boolean clickInSide(float f16, float f17, MarkerRect markerRect) {
        if (isFocused()) {
            NBPFeedMarkerUIConfig.Companion companion = NBPFeedMarkerUIConfig.Companion;
            markerRect = markerRect.scale(companion.getInstance().focusedScale, companion.getInstance().focusedScale, companion.getInstance().targetXPercent, companion.getInstance().targetYPercent);
        }
        if (markerRect.contains(f16, f17)) {
            onClickMarker();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public final Integer getCollectionCount() {
        return (Integer) this.collectionCount$delegate.getValue(this, $$delegatedProperties[3]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final MarkerRect getMarkerRectOnScreen(NBPMapMarker nBPMapMarker) {
        float width = nBPMapMarker.screenX - (nBPMapMarker.markerViewSize.getWidth() / 2.0f);
        float height = nBPMapMarker.screenY - nBPMapMarker.markerViewSize.getHeight();
        return new MarkerRect(width, height, nBPMapMarker.markerViewSize.getWidth() + width, nBPMapMarker.markerViewSize.getHeight() + height);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final NBPMarkerTransform getMarkerViewTransformWhenMapChangedOnVisible(float f16, float f17, float f18, NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        this.currentZoomLevel = f16;
        if (!this.collectionMarkers.isEmpty()) {
            this.collectionCountRaw = Integer.valueOf(this.collectionMarkers.size() + 1);
            if (!Intrinsics.areEqual(getCollectionCount(), this.collectionCountRaw)) {
                nBPMarkerUIScheduler.addUITask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel$getMarkerViewTransformWhenMapChangedOnVisible$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (!Intrinsics.areEqual(NBPFeedMarkerViewModel.this.getCollectionCount(), NBPFeedMarkerViewModel.this.collectionCountRaw)) {
                            NBPFeedMarkerViewModel nBPFeedMarkerViewModel = NBPFeedMarkerViewModel.this;
                            nBPFeedMarkerViewModel.collectionCount$delegate.setValue(nBPFeedMarkerViewModel, NBPFeedMarkerViewModel.$$delegatedProperties[3], nBPFeedMarkerViewModel.collectionCountRaw);
                            Integer collectionCount = NBPFeedMarkerViewModel.this.getCollectionCount();
                            if (collectionCount != null && collectionCount.intValue() > 1) {
                                e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_feeds_num_btn");
                                jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        } else if (getCollectionCount() != null) {
            this.collectionCountRaw = null;
            nBPMarkerUIScheduler.addUITask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerViewModel$getMarkerViewTransformWhenMapChangedOnVisible$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPFeedMarkerViewModel nBPFeedMarkerViewModel = NBPFeedMarkerViewModel.this;
                    if (nBPFeedMarkerViewModel.collectionCountRaw == null) {
                        nBPFeedMarkerViewModel.collectionCount$delegate.setValue(nBPFeedMarkerViewModel, NBPFeedMarkerViewModel.$$delegatedProperties[3], null);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        NBPFeedMarkerUIConfig.Companion companion = NBPFeedMarkerUIConfig.Companion;
        return new NBPMarkerTransform(new y((f17 / companion.getInstance().bubbleWidth) - 0.5f, (f18 / companion.getInstance().bubbleHeight) - 1.0f, 0.0f, 0.0f, 12, null), new u(1.0f, 1.0f));
    }

    public final boolean getShowSlider() {
        Integer collectionCount = getCollectionCount();
        if (collectionCount != null) {
            return collectionCount.intValue() >= 2;
        }
        return false;
    }

    public final v getTopFeedImageNode() {
        return (v) this.topFeedImageNode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final String getTopFeedTitle() {
        return (String) this.topFeedTitle$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void onClickMarker() {
        NBPViewModelStore nbpVMStore;
        String str;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onClickMarker title:");
        m3.append(this.title);
        m3.append(" feed id:");
        m3.append(this.feed.f440824d);
        m3.append(" zoom:");
        m3.append(this.currentZoomLevel);
        kLog.i("NBPFeedMarkerViewModel", m3.toString());
        ArrayList<NBPMapMarker> arrayList = this.collectionMarkers;
        ArrayList arrayList2 = new ArrayList();
        Iterator<NBPMapMarker> it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj = it.next().data;
            NBPFeedMarkerViewModel nBPFeedMarkerViewModel = obj instanceof NBPFeedMarkerViewModel ? (NBPFeedMarkerViewModel) obj : null;
            a aVar = nBPFeedMarkerViewModel != null ? nBPFeedMarkerViewModel.feed : null;
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = arrayList2.iterator();
        int i3 = 0;
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (i3 < 9) {
                arrayList3.add(next);
            }
            i3 = i16;
        }
        a aVar2 = this.feed;
        nbpVMStore = NBPMainKtxKt.getNbpVMStore(c.f117352a.g());
        NBPJumpUtil.jumpSquareFeedList$default(null, null, aVar2, "1", false, NBPViewModelStoreKt.getMarkersViewModel(nbpVMStore).currentMapThemeId, null, arrayList3, 80);
        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
        jsonWithMainPgParams.v("dt_eid", "em_nearby_map_dynamics");
        if (!this.hasImage) {
            str = FileReaderHelper.TXT_EXT;
        } else {
            str = "pic";
        }
        jsonWithMainPgParams.v("nearby_status_id", str);
        jsonWithMainPgParams.v("nearby_feed_id", this.feed.f440824d);
        jsonWithMainPgParams.u("nearby_tiny_id", UserDataManager.INSTANCE.getUserSelfInfo().tid);
        jsonWithMainPgParams.t("nearby_dynamic_fish_type", 1);
        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
        if (this.slidesImplReported) {
            e jsonWithMainPgParams2 = NearbyConstKt.jsonWithMainPgParams();
            jsonWithMainPgParams2.v("dt_eid", "em_nearby_dynamic");
            jsonWithMainPgParams2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            utils.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams2);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.FocusableMarker
    public final void onStatusChanged(NBPMarkerStatus nBPMarkerStatus) {
        this.showSliderMoreBtn$delegate.setValue(this, $$delegatedProperties[4], Boolean.FALSE);
        String str = this.showSliderMoreBtnDelayHandle;
        if (str != null) {
            TimerKt.b(str);
            this.showSliderMoreBtnDelayHandle = null;
        }
        if (nBPMarkerStatus == NBPMarkerStatus.Normal && this.slidesImplReported) {
            this.slidesImplReported = false;
            e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
            jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_dynamic");
            jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp_end", jsonWithMainPgParamsImp);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final void resetCollection() {
        this.collectionMarkers.clear();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final void themeConfigDidLoad() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final void onClickMarkerFromMap(float f16, float f17) {
    }
}
