package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.j;
import n35.z;
import v25.t;

/* loaded from: classes31.dex */
public final class NBPPOIMarkerView extends ComposeView<NBPPOIMarkerAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPPOIMarkerViewModel nBPPOIMarkerViewModel = ((NBPPOIMarkerAttr) getAttr()).viewModel;
        if (nBPPOIMarkerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nBPPOIMarkerViewModel = null;
        }
        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig = nBPPOIMarkerViewModel.uiCfg;
        final t tVar = nBPPOIMarkerViewModel.poi;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig2 = NBPPOIMarkerUIConfig.this;
                final NBPPOIMarkerViewModel nBPPOIMarkerViewModel2 = nBPPOIMarkerViewModel;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig3 = NBPPOIMarkerUIConfig.this;
                        mVar2.size(nBPPOIMarkerUIConfig3.width, nBPPOIMarkerUIConfig3.height);
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.justifyContentFlexEnd();
                        mVar2.accessibility("\u5730\u6807\uff1a" + nBPPOIMarkerViewModel2.poiTitle);
                        mVar2.accessibilityRole(AccessibilityRole.BUTTON);
                        return Unit.INSTANCE;
                    }
                });
                final NBPPOIMarkerViewModel nBPPOIMarkerViewModel3 = nBPPOIMarkerViewModel;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPPOIMarkerViewModel nBPPOIMarkerViewModel4 = NBPPOIMarkerViewModel.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                NBPPOIMarkerViewModel.this.getClass();
                                e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_middle_page_icon");
                                jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig3 = NBPPOIMarkerUIConfig.this;
                final NBPPOIMarkerViewModel nBPPOIMarkerViewModel4 = nBPPOIMarkerViewModel;
                final t tVar2 = tVar;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig4 = NBPPOIMarkerUIConfig.this;
                        final NBPPOIMarkerViewModel nBPPOIMarkerViewModel5 = nBPPOIMarkerViewModel4;
                        vVar2.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar3) {
                                com.tencent.kuikly.core.views.t tVar4 = tVar3;
                                NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig5 = NBPPOIMarkerUIConfig.this;
                                tVar4.size(nBPPOIMarkerUIConfig5.width, nBPPOIMarkerUIConfig5.height);
                                MarkerViewExtKt.bindMarkerStatusChange(tVar4, nBPPOIMarkerViewModel5, 0.0f);
                                tVar4.flexDirectionColumn();
                                tVar4.alignItemsCenter();
                                tVar4.justifyContentFlexEnd();
                                NBPMainKtxKt.boxShadowWithBlackSet$default(tVar4, new g(0.0f, 8.0f, 10.0f, h.INSTANCE.a(0.16f)));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPOIMarkerViewModel nBPPOIMarkerViewModel6 = nBPPOIMarkerViewModel4;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPPOIMarkerViewModel nBPPOIMarkerViewModel7 = NBPPOIMarkerViewModel.this;
                                MarkerViewExtKt.bindMarkerPopShow(uVar, nBPPOIMarkerViewModel7.anchor, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPPOIMarkerViewModel.this.readyToFocus = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig5 = NBPPOIMarkerUIConfig.this;
                        final t tVar3 = tVar2;
                        final NBPPOIMarkerViewModel nBPPOIMarkerViewModel7 = nBPPOIMarkerViewModel4;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig6 = NBPPOIMarkerUIConfig.this;
                                vVar4.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.t tVar4) {
                                        com.tencent.kuikly.core.views.t tVar5 = tVar4;
                                        tVar5.mo153width(NBPPOIMarkerUIConfig.this.width);
                                        NBPPOIMarkerUIConfig.this.getClass();
                                        tVar5.mo141height(56.0f);
                                        NBPPOIMarkerUIConfig.this.getClass();
                                        tVar5.borderRadius(8.0f);
                                        tVar5.mo113backgroundColor(h.INSTANCE.m());
                                        tVar5.flexDirectionRow();
                                        tVar5.overflow(true);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig7 = NBPPOIMarkerUIConfig.this;
                                final t tVar4 = tVar3;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig8 = NBPPOIMarkerUIConfig.this;
                                        vVar6.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar5) {
                                                com.tencent.kuikly.core.views.t tVar6 = tVar5;
                                                NBPPOIMarkerUIConfig.this.getClass();
                                                tVar6.mo153width(56.0f);
                                                NBPPOIMarkerUIConfig.this.getClass();
                                                tVar6.mo141height(56.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig9 = NBPPOIMarkerUIConfig.this;
                                        final t tVar5 = tVar4;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig10 = NBPPOIMarkerUIConfig.this;
                                                final t tVar6 = tVar5;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        String str;
                                                        boolean isBlank;
                                                        n35.w wVar;
                                                        List<z> list;
                                                        Object firstOrNull;
                                                        n35.v vVar7;
                                                        af afVar2 = afVar;
                                                        NBPPOIMarkerUIConfig.this.getClass();
                                                        afVar2.mo153width(56.0f);
                                                        NBPPOIMarkerUIConfig.this.getClass();
                                                        afVar2.mo141height(56.0f);
                                                        j jVar = tVar6.f440897e;
                                                        if (jVar != null && (wVar = jVar.f418083d) != null && (list = wVar.f418273d) != null) {
                                                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                                            z zVar = (z) firstOrNull;
                                                            if (zVar != null && (vVar7 = zVar.f418280d) != null) {
                                                                NearbyProKtxKt.srcWithIndexNode(afVar2, vVar7);
                                                            }
                                                        }
                                                        j jVar2 = tVar6.f440897e;
                                                        if (jVar2 != null && (str = jVar2.f418084e) != null) {
                                                            isBlank = StringsKt__StringsJVMKt.isBlank(str);
                                                            if (!isBlank) {
                                                                b.a.b(afVar2, str, false, 2, null);
                                                            }
                                                        }
                                                        afVar2.p();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPOIMarkerViewModel nBPPOIMarkerViewModel8 = nBPPOIMarkerViewModel7;
                                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig8 = NBPPOIMarkerUIConfig.this;
                                final t tVar5 = tVar3;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar6) {
                                                com.tencent.kuikly.core.views.t tVar7 = tVar6;
                                                tVar7.flexDirectionColumn();
                                                tVar7.paddingTop(6.0f);
                                                tVar7.paddingLeft(8.0f);
                                                tVar7.paddingBottom(6.0f);
                                                tVar7.justifyContentCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPOIMarkerViewModel nBPPOIMarkerViewModel9 = NBPPOIMarkerViewModel.this;
                                        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig9 = nBPPOIMarkerUIConfig8;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPPOIMarkerViewModel nBPPOIMarkerViewModel10 = NBPPOIMarkerViewModel.this;
                                                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig10 = nBPPOIMarkerUIConfig9;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.3.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.lineHeight(15.0f);
                                                        ceVar2.color(new h(4279901214L));
                                                        ceVar2.fontWeight400();
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, NBPPOIMarkerViewModel.this.poiTitle);
                                                        ceVar2.lines(nBPPOIMarkerUIConfig10.titleLines);
                                                        ceVar2.mo153width(((nBPPOIMarkerUIConfig10.width - 56.0f) - 8.0f) - 8.0f);
                                                        ceVar2.textOverFlowTail();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final t tVar6 = tVar5;
                                        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig10 = nBPPOIMarkerUIConfig8;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final t tVar7 = t.this;
                                                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig11 = nBPPOIMarkerUIConfig10;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.3.3.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                        ceVar2.lineHeight(12.0f);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.lines(1);
                                                        ceVar2.color(new h(4287664276L));
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, t.this.f440898f);
                                                        ceVar2.marginTop(2.0f);
                                                        ceVar2.mo153width(((nBPPOIMarkerUIConfig11.width - 56.0f) - 8.0f) - 8.0f);
                                                        ceVar2.textOverFlowTail();
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
                        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig6 = NBPPOIMarkerUIConfig.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig7 = NBPPOIMarkerUIConfig.this;
                                vVar4.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.t tVar4) {
                                        com.tencent.kuikly.core.views.t tVar5 = tVar4;
                                        NBPPOIMarkerUIConfig.this.getClass();
                                        tVar5.mo153width(10.0f);
                                        NBPPOIMarkerUIConfig.this.getClass();
                                        tVar5.mo141height(5.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig8 = NBPPOIMarkerUIConfig.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        final NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig9 = NBPPOIMarkerUIConfig.this;
                                        vVar5.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerView.body.1.3.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar4) {
                                                com.tencent.kuikly.core.views.t tVar5 = tVar4;
                                                NBPPOIMarkerUIConfig.this.getClass();
                                                tVar5.mo153width(10.0f);
                                                NBPPOIMarkerUIConfig.this.getClass();
                                                tVar5.mo141height(10.0f);
                                                tVar5.mo113backgroundColor(h.INSTANCE.m());
                                                d.a.a(tVar5, new com.tencent.kuikly.core.base.t(45.0f, 0.0f, 0.0f, 6, null), null, new y(0.0f, -0.5f, 0.0f, 0.0f, 12, null), null, null, 26, null);
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
        return new NBPPOIMarkerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
