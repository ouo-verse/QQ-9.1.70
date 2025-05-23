package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
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
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.base.y;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import o25.e;
import o25.g;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes31.dex */
public final class NBPOperationMarkerViewModel extends FocusableMarker implements IMarkerCollection, INBPMapMarkerUpdate {
    public static final Companion Companion = new Companion();
    public final Lazy key$delegate;
    public final Lazy markerViewSize$delegate;
    public final g operator;
    public NBPLatLng position;
    public final Lazy viewBuilder$delegate;
    public final double zIndex;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final boolean addCollectionMarker(NBPMapMarker nBPMapMarker, float f16) {
        boolean contains$default;
        float f17 = NBPFeedMarkerUIConfig.Companion.getInstance().collectionAreaPercent;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) nBPMapMarker.key, (CharSequence) "mood", false, 2, (Object) null);
        return !contains$default && f16 >= f17;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final boolean canShowOnSubMode() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final Boolean clickInSide(float f16, float f17, MarkerRect markerRect) {
        if (isFocused()) {
            markerRect = markerRect.scale(1.5f, 1.5f, 0.5f, 1.0f);
        }
        if (markerRect.contains(f16, f17)) {
            QQNearbyModule.Companion.getInstance().launchZPlanScheme(this.operator.f421859i);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final MarkerRect getMarkerRectOnScreen(NBPMapMarker nBPMapMarker) {
        return null;
    }

    public final w getMarkerViewSize() {
        return (w) this.markerViewSize$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final NBPMarkerTransform getMarkerViewTransformWhenMapChangedOnVisible(float f16, float f17, float f18, NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        return new NBPMarkerTransform(new y((f17 / getMarkerViewSize().getWidth()) - 0.5f, (f18 / getMarkerViewSize().getHeight()) - 0.5f, 0.0f, 0.0f, 12, null), new u(1.0f, 1.0f));
    }

    public NBPOperationMarkerViewModel(g gVar) {
        super(1.5f, 0.5f, 1.0f);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        this.operator = gVar;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerViewModel$key$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("operation_");
                e eVar = NBPOperationMarkerViewModel.this.operator.f421855d;
                m3.append(eVar != null ? Float.valueOf(eVar.f421846d) : null);
                m3.append(util.base64_pad_url);
                e eVar2 = NBPOperationMarkerViewModel.this.operator.f421855d;
                m3.append(eVar2 != null ? Float.valueOf(eVar2.f421847e) : null);
                return m3.toString();
            }
        });
        this.key$delegate = lazy;
        this.zIndex = NBPMarkerTypeZIndex$EnumUnboxingLocalUtility._getIndex(2);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerViewModel$viewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPOperationMarkerViewModel nBPOperationMarkerViewModel = NBPOperationMarkerViewModel.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerViewModel$viewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPOperationMarkerViewModel nBPOperationMarkerViewModel2 = NBPOperationMarkerViewModel.this;
                        viewContainer.addChild(new NBPOperationMarkerView(), new Function1<NBPOperationMarkerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerViewModel.viewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPOperationMarkerView nBPOperationMarkerView) {
                                final NBPOperationMarkerViewModel nBPOperationMarkerViewModel3 = NBPOperationMarkerViewModel.this;
                                nBPOperationMarkerView.attr(new Function1<NBPOperationMarkerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerViewModel.viewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPOperationMarkerAttr nBPOperationMarkerAttr) {
                                        nBPOperationMarkerAttr.f114227vm = NBPOperationMarkerViewModel.this;
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
        this.viewBuilder$delegate = lazy2;
        if (gVar.f421855d != null) {
            this.position = new NBPLatLng(r7.f421846d, r7.f421847e);
        }
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<w>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerViewModel$markerViewSize$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                g gVar2 = NBPOperationMarkerViewModel.this.operator;
                return new w(gVar2.f421856e, gVar2.f421857f);
            }
        });
        this.markerViewSize$delegate = lazy3;
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
