package com.tencent.hippykotlin.demo.pages.nearby.main.map;

import c45.i;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.HeatMapRenderReason;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapEvent$cameraChanged$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapEvent$cameraChangedFinish$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainMode;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPSubMode;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.IHeatMapRender;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPMainHeatMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersAttr;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.xweb.FileReaderHelper;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t25.a;

/* loaded from: classes31.dex */
public final class NBPMapView extends ComposeView<NBPMapViewAttr, NBPMapViewEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public aa<NearbyProMapView> nearbyProMapViewRef;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPMainHeatMapViewModel heatMapVM = NBPViewModelStoreKt.getHeatMapVM(NBPMainKtxKt.getNbpVMStore(getPager()));
        final NBPMarkersViewModel markersViewModel = NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        NBPViewModelStoreKt.getMapViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPMapView nBPMapView = NBPMapView.this;
                final NBPMainHeatMapViewModel nBPMainHeatMapViewModel = heatMapVM;
                NearbyProMapViewKt.NearbyProMap(viewContainer2, new Function1<NearbyProMapView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NearbyProMapView nearbyProMapView) {
                        NearbyProMapView nearbyProMapView2 = nearbyProMapView;
                        final NBPMapView nBPMapView2 = NBPMapView.this;
                        nearbyProMapView2.ref(nearbyProMapView2, new Function1<aa<NearbyProMapView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NearbyProMapView> aaVar) {
                                NBPMapView.this.nearbyProMapViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainHeatMapViewModel nBPMainHeatMapViewModel2 = nBPMainHeatMapViewModel;
                        nearbyProMapView2.attr(new Function1<NearbyProMapAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyProMapAttr nearbyProMapAttr) {
                                Integer num;
                                NearbyProMapAttr nearbyProMapAttr2 = nearbyProMapAttr;
                                nearbyProMapAttr2.absolutePositionAllZero();
                                nearbyProMapAttr2.minZoomLevel((PageDataExtKt.isPublic(c.f117352a.g().getPageData()) || (num = Utils.INSTANCE.cacheModule("").getInt("KEY_NBP_MIN_ZOOM_LEVEL")) == null) ? 7 : num.intValue());
                                nearbyProMapAttr2.maxZoomLevel(18);
                                nearbyProMapAttr2.with("heatMapMode", Integer.valueOf(BoxType$EnumUnboxingSharedUtility.ordinal(NBPMainHeatMapViewModel.this.heatMapConfig.mode)));
                                int nativeRef = nearbyProMapAttr2.getNativeRef();
                                NBPMainHeatMapViewModel nBPMainHeatMapViewModel3 = NBPMainHeatMapViewModel.this;
                                a aVar = (a) nBPMainHeatMapViewModel3.heatMapData$delegate.getValue(nBPMainHeatMapViewModel3, NBPMainHeatMapViewModel.$$delegatedProperties[0]);
                                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                companion.getClass();
                                companion.asyncToNativeMethod("updateHeatMapData", new Object[]{Integer.valueOf(nativeRef), i.d(aVar)}, (Function1<Object, Unit>) null);
                                nearbyProMapAttr2.with("mapStyle", 5);
                                e eVar = new e();
                                eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(0.5f));
                                eVar.v("y", Float.valueOf(0.45f));
                                Unit unit = Unit.INSTANCE;
                                nearbyProMapAttr2.with("centerOffset", eVar.toString());
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMapView nBPMapView3 = NBPMapView.this;
                        nearbyProMapView2.event(new Function1<NearbyProMapEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyProMapEvent nearbyProMapEvent) {
                                NearbyProMapEvent nearbyProMapEvent2 = nearbyProMapEvent;
                                final NBPMapView nBPMapView4 = NBPMapView.this;
                                Function1<CameraPosition, Unit> function1 = new Function1<CameraPosition, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CameraPosition cameraPosition) {
                                        NBPSubMode nBPSubMode;
                                        CameraPosition cameraPosition2 = cameraPosition;
                                        NBPViewModelStore nbpVMStore = NBPMainKtxKt.getNbpVMStore(NBPMapView.this.getPager());
                                        nbpVMStore.getClass();
                                        float f16 = cameraPosition2.zoomLevel;
                                        if (f16 >= 13.0f) {
                                            nBPSubMode = NBPSubMode.Normal;
                                        } else if (f16 >= 7.0f) {
                                            nBPSubMode = NBPSubMode.HeatMap;
                                        } else {
                                            nBPSubMode = NBPSubMode.Plain;
                                        }
                                        if (nBPSubMode.ordinal() != nbpVMStore.subMode.ordinal()) {
                                            nbpVMStore.subMode = nBPSubMode;
                                            nbpVMStore.onModeChanged((NBPMainMode) nbpVMStore.mainMode$delegate.getValue(nbpVMStore, NBPViewModelStore.$$delegatedProperties[0]), nbpVMStore.subMode);
                                        }
                                        Iterator it = nbpVMStore.viewModels.values().iterator();
                                        while (it.hasNext()) {
                                            ((NBPMainBaseViewModel) it.next()).onMapCameraChanged(cameraPosition2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                nearbyProMapEvent2.getClass();
                                nearbyProMapEvent2.register("cameraChanged", new NearbyProMapEvent$cameraChanged$1(function1), true);
                                final NBPMapView nBPMapView5 = NBPMapView.this;
                                nearbyProMapEvent2.register("cameraChangedFinish", new NearbyProMapEvent$cameraChangedFinish$1(new Function1<CameraPosition, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CameraPosition cameraPosition) {
                                        CameraPosition cameraPosition2 = cameraPosition;
                                        Iterator it = NBPMainKtxKt.getNbpVMStore(NBPMapView.this.getPager()).viewModels.values().iterator();
                                        while (it.hasNext()) {
                                            ((NBPMainBaseViewModel) it.next()).onMapCameraChangedFinish(cameraPosition2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }));
                                final NBPMapView nBPMapView6 = NBPMapView.this;
                                final Function1<ClickParams, Unit> function12 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ClickParams clickParams2 = clickParams;
                                        Iterator it = NBPMainKtxKt.getNbpVMStore(NBPMapView.this.getPager()).viewModels.values().iterator();
                                        while (it.hasNext()) {
                                            ((NBPMainBaseViewModel) it.next()).onMapClick(clickParams2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                nearbyProMapEvent2.register("mapClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapEvent$mapClick$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        Function1<ClickParams, Unit> function13 = function12;
                                        ClickParams.Companion companion = ClickParams.INSTANCE;
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        function13.invoke(companion.a((e) obj));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMarkersViewModel nBPMarkersViewModel = markersViewModel;
                final NBPMapView nBPMapView2 = NBPMapView.this;
                viewContainer2.addChild(new NBPMarkersView(), new Function1<NBPMarkersView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPMarkersView nBPMarkersView) {
                        final NBPMarkersViewModel nBPMarkersViewModel2 = NBPMarkersViewModel.this;
                        final NBPMapView nBPMapView3 = nBPMapView2;
                        nBPMarkersView.attr(new Function1<NBPMarkersAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPMarkersAttr nBPMarkersAttr) {
                                NBPMarkersAttr nBPMarkersAttr2 = nBPMarkersAttr;
                                nBPMarkersAttr2.viewModel = NBPMarkersViewModel.this;
                                nBPMarkersAttr2.absolutePositionAllZero();
                                if (NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(nBPMapView3.getPager())).getThemeSwitchLoadingAnimationPlaying()) {
                                    nBPMarkersAttr2.m147opacity(0.0f);
                                } else {
                                    nBPMarkersAttr2.m147opacity(1.0f);
                                }
                                nBPMarkersAttr2.animate(b.Companion.l(b.INSTANCE, 0.25f, null, 2, null), Boolean.valueOf(NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(nBPMapView3.getPager())).getThemeSwitchLoadingAnimationPlaying()));
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
        return new NBPMapViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPMapViewEvent();
    }

    public final void moveCamera(CameraUpdate cameraUpdate, Function1<? super Boolean, Unit> function1) {
        aa<NearbyProMapView> aaVar = this.nearbyProMapViewRef;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyProMapViewRef");
            aaVar = null;
        }
        NearbyProMapView b16 = aaVar.b();
        if (b16 != null) {
            b16.moveCameraWithCallback(cameraUpdate, function1);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        NBPViewModelStoreKt.getHeatMapVM(NBPMainKtxKt.getNbpVMStore(getPager())).render = null;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        NBPViewModelStoreKt.getHeatMapVM(NBPMainKtxKt.getNbpVMStore(getPager())).render = new IHeatMapRender() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView$viewDidLoad$1
            @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.IHeatMapRender
            public final void renderHeatMap(final boolean z16, final HeatMapRenderReason heatMapRenderReason, final boolean z17) {
                aa<NearbyProMapView> aaVar = NBPMapView.this.nearbyProMapViewRef;
                if (aaVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nearbyProMapViewRef");
                    aaVar = null;
                }
                final NearbyProMapView b16 = aaVar.b();
                if (b16 != null) {
                    b16.performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapView$renderHeatMap$1
                        public final /* synthetic */ boolean $ignoreTransition = false;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            e eVar = new e();
                            eVar.w("showHeatMap", z16);
                            eVar.t("renderReason", heatMapRenderReason.ordinal());
                            eVar.w(FileReaderHelper.OPEN_FILE_FROM_FORCE, z17);
                            eVar.w("ignoreTransition", this.$ignoreTransition);
                            RenderView renderView = b16.getRenderView();
                            if (renderView != null) {
                                RenderView.b(renderView, "renderHeatMap", eVar.toString(), null, 4, null);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        };
    }
}
