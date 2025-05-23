package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
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
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.v;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import v25.p;

/* loaded from: classes31.dex */
public final class NBPPersonMarkerViewModel extends FocusableMarker implements IMarkerCollection, INBPMapMarkerUpdate {
    public static final Companion Companion = new Companion();
    public aa<NBPPersonMarkerFocusedAttachmentView> attachmentViewRef;
    public final String key;
    public p person;
    public NBPLatLng position;
    public final Lazy viewBuilder$delegate;
    public final double zIndex;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final String markerKey(long j3) {
            return "person_" + j3;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final boolean addCollectionMarker(NBPMapMarker nBPMapMarker, float f16) {
        return f16 >= NBPFeedMarkerUIConfig.Companion.getInstance().collectionAreaPercent;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final boolean canShowOnSubMode() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.FocusableMarker
    public final MarkerRect getFocusedMarkerRect(MarkerRect markerRect) {
        float f16 = this.focusedScale;
        MarkerRect scale = markerRect.scale(f16, f16, this.anchorX, this.anchorY);
        return new MarkerRect(scale.left - 70.0f, scale.top - 4.0f, scale.right + 70.0f, scale.bottom + 40.0f);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final MarkerRect getMarkerRectOnScreen(NBPMapMarker nBPMapMarker) {
        float width = nBPMapMarker.screenX - (nBPMapMarker.markerViewSize.getWidth() / 2.0f);
        float height = nBPMapMarker.screenY - (nBPMapMarker.markerViewSize.getHeight() / 2.0f);
        return new MarkerRect(width, height, nBPMapMarker.markerViewSize.getWidth() + width, nBPMapMarker.markerViewSize.getHeight() + height);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.FocusableMarker
    public final void onStatusChanged(NBPMarkerStatus nBPMarkerStatus) {
        String str;
        if (nBPMarkerStatus == NBPMarkerStatus.Focused) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_greet");
        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, jsonWithMainPgParamsImp);
    }

    public NBPPersonMarkerViewModel(p pVar) {
        super(2.0f, 0.5f, 0.5f);
        Lazy lazy;
        this.person = pVar;
        this.key = Companion.markerKey(pVar.f440880d);
        this.position = this.person.f440881e != null ? new NBPLatLng(r6.f421846d, r6.f421847e) : null;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerViewModel$viewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPPersonMarkerViewModel nBPPersonMarkerViewModel = NBPPersonMarkerViewModel.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerViewModel$viewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPPersonMarkerViewModel nBPPersonMarkerViewModel2 = NBPPersonMarkerViewModel.this;
                        viewContainer.addChild(new NBPPersonMarkerView(), new Function1<NBPPersonMarkerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerViewModel.viewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPPersonMarkerView nBPPersonMarkerView) {
                                final NBPPersonMarkerViewModel nBPPersonMarkerViewModel3 = NBPPersonMarkerViewModel.this;
                                nBPPersonMarkerView.attr(new Function1<NBPPersonMarkerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerViewModel.viewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPPersonMarkerAttr nBPPersonMarkerAttr) {
                                        NBPPersonMarkerAttr nBPPersonMarkerAttr2 = nBPPersonMarkerAttr;
                                        nBPPersonMarkerAttr2.viewModel = NBPPersonMarkerViewModel.this;
                                        nBPPersonMarkerAttr2.accessibility("\u7528\u6237");
                                        nBPPersonMarkerAttr2.accessibilityRole(AccessibilityRole.BUTTON);
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
        this.zIndex = NBPMarkerTypeZIndex$EnumUnboxingLocalUtility._getIndex(10) + this.person.C;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00df, code lost:
    
        if ((r2 <= r3.getHeight() + r3.getY() && r3.getY() <= r2) != false) goto L44;
     */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean clickInSide(float f16, float f17, MarkerRect markerRect) {
        aa<NBPPersonMarkerFocusedAttachmentView> aaVar;
        NBPPersonMarkerFocusedAttachmentView b16;
        v b17;
        d frame;
        boolean z16 = true;
        if ((isFocused() ? markerRect.scale(2.0f, 2.0f, 0.5f, 0.5f) : markerRect).contains(f16, f17)) {
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
        if (isFocused() && (aaVar = this.attachmentViewRef) != null && (b16 = aaVar.b()) != null) {
            float f18 = markerRect.right;
            float f19 = markerRect.left;
            float f26 = markerRect.bottom;
            float f27 = markerRect.top;
            float f28 = f16 - (((f18 - f19) * 0.5f) + f19);
            float f29 = f17 - (((f26 - f27) * 0.5f) + f27);
            aa<v> aaVar2 = b16.sayHiRef;
            if (aaVar2 != null && (b17 = aaVar2.b()) != null && (frame = b17.getFrame()) != null) {
                if (f28 <= frame.getWidth() + frame.getX() && frame.getX() <= f28) {
                }
            }
            z16 = false;
            if (z16) {
                String valueOf2 = String.valueOf(this.person.f440880d);
                p pVar2 = this.person;
                String str = pVar2.f440882f;
                String str2 = pVar2.f440883h;
                KLog kLog = KLog.INSTANCE;
                StringBuilder a16 = j.a("\u6253\u62db\u547c: ", valueOf2, ", ", str, ", ");
                a16.append(str2);
                kLog.i("NBPPersonMarkerViewModel", a16.toString());
                e jsonWithMainPgParams2 = NearbyConstKt.jsonWithMainPgParams();
                jsonWithMainPgParams2.v("dt_eid", "em_nearby_greet");
                jsonWithMainPgParams2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams2);
                QQNearbyModule.Companion.getInstance().openGreetingPage(valueOf2, str, str2, 24, 0);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final NBPMarkerTransform getMarkerViewTransformWhenMapChangedOnVisible(float f16, float f17, float f18, NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        return new NBPMarkerTransform(new y((f17 / 28.0f) - 0.5f, (f18 / 28.0f) - 0.5f, 0.0f, 0.0f, 12, null), new u(1.0f, 1.0f));
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
