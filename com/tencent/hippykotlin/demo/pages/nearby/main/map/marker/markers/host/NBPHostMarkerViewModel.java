package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.NBPMarkerTypeZIndex$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.FocusableMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerRect;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerTransform;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerUIScheduler;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerUIConfig;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import v25.p;

/* loaded from: classes31.dex */
public final class NBPHostMarkerViewModel extends FocusableMarker implements IMarkerCollection, INBPMapMarkerUpdate {
    public static final Companion Companion = new Companion();
    public final String key;
    public aa<ViewContainer<?, ?>> marekViewRef;
    public p person;
    public NBPLatLng position;
    public final Lazy viewBuilder$delegate;
    public final double zIndex;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final String markerKey(long j3) {
            return "host_" + j3;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final boolean addCollectionMarker(NBPMapMarker nBPMapMarker, float f16) {
        return f16 >= NBPFeedMarkerUIConfig.Companion.getInstance().collectionAreaPercent;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final boolean canShowOnSubMode() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final Boolean clickInSide(float f16, float f17, MarkerRect markerRect) {
        if (isFocused()) {
            markerRect = markerRect.scale(1.0f, 1.0f, 0.5f, 1.0f);
        }
        if (markerRect.contains(f16, f17)) {
            String valueOf = String.valueOf(this.person.f440880d);
            UserDataManager userDataManager = UserDataManager.INSTANCE;
            p pVar = this.person;
            NBPJumpUtil.jumpPersonaPage$default(2, valueOf, pVar != null && userDataManager.isHostTid(Long.valueOf(pVar.f440880d)), false, HomepageSource.INDEX_MARKER, null, 40);
            e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
            jsonWithMainPgParams.v("dt_eid", "em_nearby_avatar_icon");
            jsonWithMainPgParams.v("nearby_frame_id", NearbyProKtxKt.avatarDressBorderUrl(this.person));
            jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final MarkerRect getMarkerRectOnScreen(NBPMapMarker nBPMapMarker) {
        float width = nBPMapMarker.screenX - (nBPMapMarker.markerViewSize.getWidth() * 0.5f);
        float height = nBPMapMarker.screenY - (nBPMapMarker.markerViewSize.getHeight() * 1.0f);
        return new MarkerRect(width, height, nBPMapMarker.markerViewSize.getWidth() + width, nBPMapMarker.markerViewSize.getHeight() + height);
    }

    public NBPHostMarkerViewModel(p pVar) {
        super(1.0f, 0.5f, 1.0f);
        Lazy lazy;
        this.person = pVar;
        this.key = Companion.markerKey(pVar.f440880d);
        this.position = this.person.f440881e != null ? new NBPLatLng(r6.f421846d, r6.f421847e) : null;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerViewModel$viewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPHostMarkerViewModel nBPHostMarkerViewModel = NBPHostMarkerViewModel.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerViewModel$viewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPHostMarkerViewModel nBPHostMarkerViewModel2 = NBPHostMarkerViewModel.this;
                        viewContainer.addChild(new NBPHostMarkerView(), new Function1<NBPHostMarkerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerViewModel.viewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHostMarkerView nBPHostMarkerView) {
                                final NBPHostMarkerViewModel nBPHostMarkerViewModel3 = NBPHostMarkerViewModel.this;
                                nBPHostMarkerView.attr(new Function1<NBPHostMarkerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerViewModel.viewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPHostMarkerAttr nBPHostMarkerAttr) {
                                        NBPHostMarkerAttr nBPHostMarkerAttr2 = nBPHostMarkerAttr;
                                        nBPHostMarkerAttr2.viewModel = NBPHostMarkerViewModel.this;
                                        nBPHostMarkerAttr2.accessibility("\u81ea\u5df1");
                                        nBPHostMarkerAttr2.accessibilityRole(AccessibilityRole.BUTTON);
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
        this.zIndex = NBPMarkerTypeZIndex$EnumUnboxingLocalUtility._getIndex(1);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final NBPMarkerTransform getMarkerViewTransformWhenMapChangedOnVisible(float f16, float f17, float f18, NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        return new NBPMarkerTransform(new y((f17 / 54.0f) - 0.5f, (f18 / 60.0f) - 1.0f, 0.0f, 0.0f, 12, null), new u(1.0f, 1.0f));
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
