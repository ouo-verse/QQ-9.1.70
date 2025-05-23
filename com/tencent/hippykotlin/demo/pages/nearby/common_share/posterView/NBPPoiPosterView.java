package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.MiddlePageShareConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p35.af;
import p35.ah;
import x25.l;

/* loaded from: classes31.dex */
public final class NBPPoiPosterView extends ComposeView<NBPPoiPosterViewAttr, NBPPoiPosterViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPoiPosterView.class, "showQRCode", "getShowQRCode()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPoiPosterView.class, "qrCodeReady", "getQrCodeReady()Z", 0)};
    public int mapRenderImgViewNativeRef;
    public aa<NearbyProMapView> nearbyProMapViewRef;
    public final ReadWriteProperty qrCodeReady$delegate;
    public final ReadWriteProperty showQRCode$delegate;

    public NBPPoiPosterView() {
        Boolean bool = Boolean.FALSE;
        this.showQRCode$delegate = c.a(bool);
        this.qrCodeReady$delegate = c.a(bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPoiPosterViewAttr access$getAttr(NBPPoiPosterView nBPPoiPosterView) {
        return (NBPPoiPosterViewAttr) nBPPoiPosterView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPoiPosterViewEvent access$getEvent(NBPPoiPosterView nBPPoiPosterView) {
        return (NBPPoiPosterViewEvent) nBPPoiPosterView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        mVar2.size(630.0f, 848.0f);
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        VisibilityEventKt.e(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                KLog.INSTANCE.i("NBPPoiPosterView", "nearbyProMapView will appear");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPoiPosterView nBPPoiPosterView = NBPPoiPosterView.this;
                NearbyProMapViewKt.NearbyProMap(viewContainer2, new Function1<NearbyProMapView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NearbyProMapView nearbyProMapView) {
                        NearbyProMapView nearbyProMapView2 = nearbyProMapView;
                        final NBPPoiPosterView nBPPoiPosterView2 = NBPPoiPosterView.this;
                        nearbyProMapView2.ref(nearbyProMapView2, new Function1<aa<NearbyProMapView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NearbyProMapView> aaVar) {
                                NBPPoiPosterView.this.nearbyProMapViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        nearbyProMapView2.attr(new Function1<NearbyProMapAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyProMapAttr nearbyProMapAttr) {
                                NearbyProMapAttr nearbyProMapAttr2 = nearbyProMapAttr;
                                nearbyProMapAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                nearbyProMapAttr2.m140flex(1.0f);
                                nearbyProMapAttr2.maxZoomLevel(18);
                                nearbyProMapAttr2.minZoomLevel(7);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPoiPosterView nBPPoiPosterView3 = NBPPoiPosterView.this;
                        nearbyProMapView2.event(new Function1<NearbyProMapEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyProMapEvent nearbyProMapEvent) {
                                NearbyProMapEvent nearbyProMapEvent2 = nearbyProMapEvent;
                                final NBPPoiPosterView nBPPoiPosterView4 = NBPPoiPosterView.this;
                                FrameEventKt.f(nearbyProMapEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NBPLatLng nBPLatLng;
                                        NearbyProMapView b16;
                                        af afVar;
                                        af afVar2;
                                        KLog kLog = KLog.INSTANCE;
                                        kLog.i("NBPPoiPosterView", "map did created");
                                        NBPPoiPosterView nBPPoiPosterView5 = NBPPoiPosterView.this;
                                        ah ahVar = NBPPoiPosterView.access$getAttr(nBPPoiPosterView5).getVm().getPosterData().poiData.f447113d;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateMap target: poiGps\uff1alat:");
                                        m3.append((ahVar == null || (afVar2 = ahVar.C) == null) ? null : Long.valueOf(afVar2.f425135d));
                                        m3.append("\uff0clon:");
                                        m3.append((ahVar == null || (afVar = ahVar.C) == null) ? null : Long.valueOf(afVar.f425136e));
                                        m3.append(", UserLocation: ");
                                        UserDataManager userDataManager = UserDataManager.INSTANCE;
                                        m3.append(userDataManager.getUserSelfInfo().latLng);
                                        kLog.i("NBPPoiPosterView", m3.toString());
                                        if (ahVar != null) {
                                            af afVar3 = ahVar.C;
                                            nBPLatLng = new NBPLatLng(afVar3 != null ? afVar3.f425135d / 1000000.0d : 22.535883d, afVar3 != null ? afVar3.f425136e / 1000000.0d : 113.930514d);
                                        } else {
                                            nBPLatLng = userDataManager.getUserSelfInfo().latLng;
                                        }
                                        aa<NearbyProMapView> aaVar = nBPPoiPosterView5.nearbyProMapViewRef;
                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                            CameraUpdate cameraUpdate = new CameraUpdate();
                                            cameraUpdate.target = new NBPLatLng(nBPLatLng.latitude, nBPLatLng.longitude);
                                            cameraUpdate.zoomLevel = 16.0f;
                                            cameraUpdate.animate = false;
                                            cameraUpdate.animateDuration = 250L;
                                            b16.moveCameraWithCallback(cameraUpdate, null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPoiPosterView nBPPoiPosterView5 = NBPPoiPosterView.this;
                                nearbyProMapEvent2.register("mapLoaded", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        final NearbyProMapView b16;
                                        KLog.INSTANCE.i("NBPPoiPosterView", "map loaded");
                                        aa<NearbyProMapView> aaVar = NBPPoiPosterView.this.nearbyProMapViewRef;
                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                            final NBPPoiPosterView nBPPoiPosterView6 = NBPPoiPosterView.this;
                                            final int i3 = nBPPoiPosterView6.mapRenderImgViewNativeRef;
                                            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.3.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Boolean bool) {
                                                    bool.booleanValue();
                                                    KLog.INSTANCE.i("NBPPoiPosterView", "render snapshot to image view");
                                                    Function0<Unit> function0 = NBPPoiPosterView.access$getEvent(NBPPoiPosterView.this).onReadyToCaptureListener;
                                                    if (function0 != null) {
                                                        function0.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            b16.performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapView$renderSnapshotToImageView$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    RenderView renderView = NearbyProMapView.this.getRenderView();
                                                    if (renderView != null) {
                                                        e eVar = new e();
                                                        eVar.t("imageViewTag", i3);
                                                        Unit unit = Unit.INSTANCE;
                                                        String eVar2 = eVar.toString();
                                                        final Function1<Boolean, Unit> function12 = function1;
                                                        renderView.a("renderSnapshotToImageView", eVar2, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapView$renderSnapshotToImageView$1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
                                                            
                                                                if (r2.j("result") == 1) goto L8;
                                                             */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            /*
                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                            */
                                                            public final Unit invoke(e eVar3) {
                                                                e eVar4 = eVar3;
                                                                boolean z16 = eVar4 != null;
                                                                function12.invoke(Boolean.valueOf(z16));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
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
                final NBPPoiPosterView nBPPoiPosterView2 = NBPPoiPosterView.this;
                com.tencent.kuikly.core.views.ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        NBPPoiPosterView.this.mapRenderImgViewNativeRef = imageView2.getNativeRef();
                        imageView2.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                afVar2.q();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPoiPosterView nBPPoiPosterView3 = NBPPoiPosterView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentCenter();
                                tVar2.size(630.0f, 848.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        tVar2.alignItemsCenter();
                                        tVar2.justifyContentCenter();
                                        Direction direction = Direction.TO_BOTTOM;
                                        h.Companion companion = h.INSTANCE;
                                        tVar2.mo135backgroundLinearGradient(direction, new j(companion.j(), 0.0f), new j(companion.j(), 0.4f), new j(companion.k(), 0.0f), new j(companion.k(), 0.4f), new j(companion.m(), 0.7f), new j(companion.m(), 1.0f));
                                        tVar2.size(630.0f, 848.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPoiPosterView nBPPoiPosterView4 = NBPPoiPosterView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final long NBPCurrentTime;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 24.0f, 24.0f, 0.0f, 0.0f, 12, null);
                                        tVar2.mo141height(60.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_tertiary"));
                                        tVar2.borderRadius(40.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (NBPPoiPosterView.access$getAttr(NBPPoiPosterView.this).getVm().poiCanceled) {
                                    NBPCurrentTime = APICallTechReporterKt.NBPCurrentTime();
                                } else {
                                    l lVar = NBPPoiPosterView.access$getAttr(NBPPoiPosterView.this).getVm().getPosterData().poiData.E;
                                    if (lVar != null) {
                                        Long valueOf = Long.valueOf(lVar.f447110e);
                                        if (!(valueOf.longValue() > 0)) {
                                            valueOf = null;
                                        }
                                        if (valueOf != null) {
                                            NBPCurrentTime = valueOf.longValue();
                                        }
                                    }
                                    NBPCurrentTime = APICallTechReporterKt.NBPCurrentTime();
                                }
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.4.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final long j3 = NBPCurrentTime;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.4.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                c.a.a(ceVar2, 0.0f, 10.0f, 0.0f, 10.0f, 5, null);
                                                ceVar2.text(TextViewExtKt.fixLineHeightForView(((b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule")).a(j3, "yyyy\u5e74MM\u6708dd\u65e5")));
                                                ceVar2.fontWeight400();
                                                ceVar2.color(new h(4287664276L));
                                                ce.fontSize$default(ceVar2, 28.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPoiPosterView nBPPoiPosterView5 = NBPPoiPosterView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        Attr.absolutePosition$default(tVar2, 200.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                        tVar2.allCenter();
                                        tVar2.marginTop(100.0f);
                                        tVar2.size(630.0f, 120.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                com.tencent.kuikly.core.views.ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.5.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.5.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                afVar2.mo153width(320.0f);
                                                afVar2.mo141height(284.4f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Jb40fhe9mND.png", false, 2, null);
                                                afVar2.p();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPoiPosterView nBPPoiPosterView6 = NBPPoiPosterView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.5.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPPoiPosterView nBPPoiPosterView7 = NBPPoiPosterView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.5.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String fixLineHeightForView;
                                                ce ceVar2 = ceVar;
                                                ah ahVar = NBPPoiPosterView.access$getAttr(NBPPoiPosterView.this).getVm().getPosterData().poiData.f447113d;
                                                if (ahVar == null || (fixLineHeightForView = ahVar.Q) == null) {
                                                    fixLineHeightForView = TextViewExtKt.fixLineHeightForView("");
                                                }
                                                ceVar2.text(fixLineHeightForView);
                                                ceVar2.fontWeight500();
                                                c.a.a(ceVar2, 0.0f, 40.0f, 0.0f, 40.0f, 5, null);
                                                ceVar2.alignSelfCenter();
                                                ceVar2.textAlignCenter();
                                                ceVar2.lines(1);
                                                ceVar2.color(h.INSTANCE.b());
                                                ce.fontSize$default(ceVar2, 48.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.5.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.5.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(TextViewExtKt.fixLineHeightForView("\u70b9\u4eae\u6210\u529f"));
                                                c.a.a(ceVar2, 8.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(h.INSTANCE.b());
                                                ce.fontSize$default(ceVar2, 48.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPoiPosterView nBPPoiPosterView6 = NBPPoiPosterView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.alignItemsFlexStart();
                                        tVar2.mo141height(200.0f);
                                        Attr.absolutePosition$default(tVar2, 0.0f, 24.0f, 24.0f, 24.0f, 1, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPoiPosterView nBPPoiPosterView7 = NBPPoiPosterView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPPoiPosterView nBPPoiPosterView8 = NBPPoiPosterView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                NBPBaseShareVM<NearbyMiddlePosterData> vm5 = NBPPoiPosterView.access$getAttr(NBPPoiPosterView.this).getVm();
                                                ceVar2.text(((MiddlePageShareConfig) vm5.middlePosterConfig$delegate.getValue(vm5, NBPBaseShareVM.$$delegatedProperties[2])).posterText);
                                                ceVar2.fontWeight500();
                                                ce.fontSize$default(ceVar2, 44.0f, null, 2, null);
                                                ceVar2.lineHeight(61.6f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                c.a.a(tVar2, 16.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        com.tencent.kuikly.core.views.ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                        com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                        afVar2.size(48.0f);
                                                        afVar2.borderRadius(24.0f);
                                                        b.a.b(afVar2, UserDataManager.INSTANCE.getUserSelfInfo().avatarUrl, false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        c.a.a(ceVar2, 0.0f, 8.0f, 0.0f, 0.0f, 13, null);
                                                        ceVar2.text(TextViewExtKt.fixLineHeightForView(UserDataManager.INSTANCE.getUserSelfInfo().nickName));
                                                        ceVar2.fontWeight400();
                                                        ceVar2.color(new h(4287664276L));
                                                        ce.fontSize$default(ceVar2, 28.0f, null, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                com.tencent.kuikly.core.views.ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.6.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                afVar2.size(240.0f, 36.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_KNuZ1qRG395.png", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.7
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.7.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 24.0f, 24.0f, 3, null);
                                        tVar2.flexDirectionColumn();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                com.tencent.kuikly.core.views.ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.7.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.7.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                afVar2.size(78.6f);
                                                afVar2.mo139boxShadow(new g(0.0f, FloatExtKt.getTo375(3.0f), FloatExtKt.getTo375(3.0f), new h(0L, 0.18f)));
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Qh-vQm0h1oc.png", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.7.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.7.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                c.a.a(ceVar2, 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                ceVar2.text(TextViewExtKt.fixLineHeightForView("\u626b\u7801\u53bb\u9644\u8fd1"));
                                                ceVar2.fontWeight500();
                                                ceVar2.color(h.INSTANCE.b());
                                                ceVar2.lineHeight(20.0f);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPoiPosterView nBPPoiPosterView7 = NBPPoiPosterView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.8
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPPoiPosterView nBPPoiPosterView8 = NBPPoiPosterView.this;
                                return Boolean.valueOf(((Boolean) nBPPoiPosterView8.showQRCode$delegate.getValue(nBPPoiPosterView8, NBPPoiPosterView.$$delegatedProperties[0])).booleanValue());
                            }
                        };
                        final NBPPoiPosterView nBPPoiPosterView8 = NBPPoiPosterView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.9
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPPoiPosterView nBPPoiPosterView9 = NBPPoiPosterView.this;
                                conditionView.addChild(new QRCodeView(), new Function1<QRCodeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.9.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QRCodeView qRCodeView) {
                                        QRCodeView qRCodeView2 = qRCodeView;
                                        final NBPPoiPosterView nBPPoiPosterView10 = NBPPoiPosterView.this;
                                        qRCodeView2.attr(new Function1<n01.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.9.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(n01.b bVar) {
                                                String str;
                                                n01.b bVar2 = bVar;
                                                ah ahVar = NBPPoiPosterView.access$getAttr(NBPPoiPosterView.this).getVm().getPosterData().poiData.f447113d;
                                                if (ahVar == null || (str = ahVar.R) == null) {
                                                    str = "";
                                                }
                                                String m3 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("nbp_forward=4&poi_key=", str, "&nbp_forward_source=19&local_bundle_name=nearbypro");
                                                StringBuilder m16 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?page_name=nearbypro_main&target=52&channel=2&version=1&src_type=app&source=", 103, "&key_scheme=");
                                                m16.append(UriKt.encodeURIComponent(m3));
                                                String sb5 = m16.toString();
                                                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://ti.qq.com/open_qq/index.html?url=");
                                                m17.append(UriKt.encodeURIComponent(sb5));
                                                bVar2.i(m17.toString(), 78.6f);
                                                bVar2.positionAbsolute();
                                                bVar2.m149right(24.0f);
                                                bVar2.m138bottom(54.6f);
                                                NBPPoiPosterView nBPPoiPosterView11 = NBPPoiPosterView.this;
                                                ReadWriteProperty readWriteProperty = nBPPoiPosterView11.qrCodeReady$delegate;
                                                KProperty<?>[] kPropertyArr = NBPPoiPosterView.$$delegatedProperties;
                                                bVar2.m147opacity(((Boolean) readWriteProperty.getValue(nBPPoiPosterView11, kPropertyArr[1])).booleanValue() ? 1.0f : 0.01f);
                                                com.tencent.kuikly.core.base.b f16 = b.Companion.f(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null);
                                                NBPPoiPosterView nBPPoiPosterView12 = NBPPoiPosterView.this;
                                                bVar2.m134animation(f16, (Object) Boolean.valueOf(((Boolean) nBPPoiPosterView12.qrCodeReady$delegate.getValue(nBPPoiPosterView12, kPropertyArr[1])).booleanValue()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPoiPosterView nBPPoiPosterView11 = NBPPoiPosterView.this;
                                        qRCodeView2.event(new Function1<n01.c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.9.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(n01.c cVar) {
                                                final NBPPoiPosterView nBPPoiPosterView12 = NBPPoiPosterView.this;
                                                cVar.f417921a = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView.body.1.5.9.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPPoiPosterView nBPPoiPosterView13 = NBPPoiPosterView.this;
                                                        nBPPoiPosterView13.qrCodeReady$delegate.setValue(nBPPoiPosterView13, NBPPoiPosterView.$$delegatedProperties[1], Boolean.TRUE);
                                                        KLog.INSTANCE.i("NBPPoiPosterView", "qrCode didRender");
                                                        return Unit.INSTANCE;
                                                    }
                                                };
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPPoiPosterViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPoiPosterViewEvent();
    }
}
