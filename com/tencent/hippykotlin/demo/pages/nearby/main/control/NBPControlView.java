package com.tencent.hippykotlin.demo.pages.nearby.main.control;

import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPControlView extends ComposeView<NBPControlViewAttr, NBPControlViewEvent> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPMainMapViewModel mapViewModel = NBPViewModelStoreKt.getMapViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        final NBPMainControlViewModel controlViewModel = NBPViewModelStoreKt.getControlViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        final NBPMainTitleViewModel titleViewModel = NBPViewModelStoreKt.getTitleViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.addChild(new NBPMainTitleView(), new Function1<NBPMainTitleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPMainTitleView nBPMainTitleView) {
                        nBPMainTitleView.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(k kVar) {
                                Attr.absolutePosition$default(kVar, 10.0f, 0.0f, 0.0f, 0.0f, 4, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainControlViewModel nBPMainControlViewModel = NBPMainControlViewModel.this;
                final NBPMainMapViewModel nBPMainMapViewModel = mapViewModel;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        final NBPMainControlViewModel nBPMainControlViewModel2 = NBPMainControlViewModel.this;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(50.0f, 50.0f);
                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_3ZnaomkmVhx.png", false, 2, null);
                                Attr.absolutePosition$default(afVar2, (afVar2.getPagerData().l() - 36.0f) / 2, 0.0f, 0.0f, 8.0f, 6, null);
                                NBPMainControlViewModel nBPMainControlViewModel3 = NBPMainControlViewModel.this;
                                afVar2.m152visibility(((Boolean) nBPMainControlViewModel3.showLocationBtn$delegate.getValue(nBPMainControlViewModel3, NBPMainControlViewModel.$$delegatedProperties[0])).booleanValue());
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainMapViewModel nBPMainMapViewModel2 = nBPMainMapViewModel;
                        final NBPMainControlViewModel nBPMainControlViewModel3 = NBPMainControlViewModel.this;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final NBPMainMapViewModel nBPMainMapViewModel3 = NBPMainMapViewModel.this;
                                final NBPMainControlViewModel nBPMainControlViewModel4 = nBPMainControlViewModel3;
                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPMapView b16;
                                        final NBPMainMapViewModel nBPMainMapViewModel4 = NBPMainMapViewModel.this;
                                        int i3 = nBPMainMapViewModel4.enterLocationState;
                                        if (i3 == 0) {
                                            Utils.INSTANCE.currentBridgeModule().qToast("\u6b63\u5728\u5b9a\u4f4d\u4e2d, \u8bf7\u7a0d\u5019", QToastMode.Info);
                                        } else if (i3 == 1) {
                                            aa<NBPMapView> aaVar = nBPMainMapViewModel4.mapViewRef;
                                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                b16.moveCamera(NBPMainMapViewModel.createSelfPositionCamera$default(nBPMainMapViewModel4, 0.0f, 300L, 7), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel$moveToSelfPosition$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Boolean bool) {
                                                        bool.booleanValue();
                                                        QQNearbyModule.Companion.getInstance().asyncToNativeMethod("vibrator", (e) null, (Function1<? super e, Unit>) null);
                                                        Iterator<NBPMapMarker> it = NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).getVisibleMarkers().iterator();
                                                        while (it.hasNext()) {
                                                            Object obj = it.next().data;
                                                            if (obj instanceof NBPHostMarkerViewModel) {
                                                                NBPHostMarkerViewModel nBPHostMarkerViewModel = (NBPHostMarkerViewModel) obj;
                                                                aa<ViewContainer<?, ?>> aaVar2 = nBPHostMarkerViewModel.marekViewRef;
                                                                if ((aaVar2 != null ? aaVar2.b() : null) != null) {
                                                                    aa<ViewContainer<?, ?>> aaVar3 = nBPHostMarkerViewModel.marekViewRef;
                                                                    ViewContainer<?, ?> b17 = aaVar3 != null ? aaVar3.b() : null;
                                                                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView");
                                                                    NBPHostMarkerView nBPHostMarkerView = (NBPHostMarkerView) b17;
                                                                    int i16 = nBPHostMarkerView.animationRotateIndex;
                                                                    if (i16 == 0) {
                                                                        nBPHostMarkerView.animationRotateIndex = i16 + 1;
                                                                        nBPHostMarkerView.animationRotate$delegate.setValue(nBPHostMarkerView, NBPHostMarkerView.$$delegatedProperties[0], Float.valueOf(((Float[]) nBPHostMarkerView.animationRotateGroup$delegate.getValue())[nBPHostMarkerView.animationRotateIndex].floatValue()));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                        } else if (i3 == 2) {
                                            Utils.INSTANCE.currentBridgeModule().qToast("\u5b9a\u4f4d\u5931\u8d25, \u8bf7\u91cd\u8bd5\u8fdb\u5165\u9875\u9762", QToastMode.Info);
                                        }
                                        nBPMainControlViewModel4.getClass();
                                        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                        jsonWithMainPgParams.v("dt_eid", "em_nearby_location");
                                        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainTitleViewModel nBPMainTitleViewModel = titleViewModel;
                viewContainer2.addChild(new NBPMainRightBarView(), new Function1<NBPMainRightBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPMainRightBarView nBPMainRightBarView) {
                        final NBPMainTitleViewModel nBPMainTitleViewModel2 = NBPMainTitleViewModel.this;
                        nBPMainRightBarView.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(k kVar) {
                                float statusBarHeight;
                                float f16;
                                k kVar2 = kVar;
                                NBPMainTitleViewModel nBPMainTitleViewModel3 = NBPMainTitleViewModel.this;
                                if (((c) nBPMainTitleViewModel3.scoreInfoList$delegate.getValue(nBPMainTitleViewModel3, NBPMainTitleViewModel.$$delegatedProperties[1])).size() > 2) {
                                    float statusBarHeight2 = kVar2.getPagerData().getStatusBarHeight();
                                    kVar2.getPager().getPageData().getIsIOS();
                                    statusBarHeight = statusBarHeight2 + 44.0f;
                                    f16 = 10.0f;
                                } else {
                                    statusBarHeight = kVar2.getPagerData().getStatusBarHeight();
                                    f16 = 14.0f;
                                }
                                Attr.absolutePosition$default(kVar2, statusBarHeight + f16, 0.0f, 0.0f, 16.0f, 6, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.addChild(new NBPMainBottomView(), new Function1<NBPMainBottomView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPMainBottomView nBPMainBottomView) {
                        nBPMainBottomView.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPControlView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(k kVar) {
                                Attr.absolutePosition$default(kVar, 0.0f, 0.0f, 50.0f, 0.0f, 1, null);
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
        return new NBPControlViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPControlViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        NBPViewModelStoreKt.getControlViewModel(NBPMainKtxKt.getNbpVMStore(getPager())).getClass();
        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_publish_status_en");
        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
    }
}
