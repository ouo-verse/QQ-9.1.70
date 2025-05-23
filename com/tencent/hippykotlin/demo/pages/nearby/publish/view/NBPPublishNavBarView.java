package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishServiceKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishStatusData;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.AITechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.module.NBPPublishBridgeModule;
import com.tencent.hippykotlin.demo.pages.nearby.module.NBPPublishBridgeModule$enterLocationPage$1;
import com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.i;
import n25.k;
import n25.l;
import o25.f;

/* loaded from: classes31.dex */
public final class NBPPublishNavBarView extends ComposeView<NBPPublishNavBarAttr, NBPPublishNavBarEvent> {
    public static final void access$customDtReportEditLocation(NBPPublishNavBarView nBPPublishNavBarView, String str) {
        nBPPublishNavBarView.getClass();
        e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
        jsonWithPublishPgParams.v("dt_eid", "em_nearby_edit_location");
        jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, jsonWithPublishPgParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPublishNavBarAttr access$getAttr(NBPPublishNavBarView nBPPublishNavBarView) {
        return (NBPPublishNavBarAttr) nBPPublishNavBarView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final h hVar;
        if (Intrinsics.areEqual(((NBPPublishNavBarAttr) getAttr()).getViewModel().source, "5")) {
            hVar = QUIToken.color$default("text_secondary");
        } else {
            hVar = new h(4279901214L);
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.paddingTop(mVar2.getPagerData().getStatusBarHeight());
                        mVar2.overflow(false);
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishNavBarView nBPPublishNavBarView = NBPPublishNavBarView.this;
                final h hVar2 = hVar;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                float m3 = tVar2.getPagerData().m();
                                tVar2.getPagerData().getIsIOS();
                                tVar2.size(m3, 44.0f);
                                tVar2.justifyContent(FlexJustifyContent.SPACE_BETWEEN);
                                tVar2.alignItems(FlexAlign.CENTER);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishNavBarView nBPPublishNavBarView2 = NBPPublishNavBarView.this;
                        final h hVar3 = hVar2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.allCenter();
                                        tVar2.flexDirectionRow();
                                        tVar2.mo141height(44.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishNavBarView nBPPublishNavBarView3 = NBPPublishNavBarView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.justifyContentCenter();
                                                tVar2.size(52.0f, 44.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_oVLv6-0WgBF.png", false, 2, null);
                                                        afVar2.size(28.0f, 28.0f);
                                                        afVar2.marginLeft(16.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishNavBarView nBPPublishNavBarView4 = NBPPublishNavBarView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPPublishNavBarView nBPPublishNavBarView5 = NBPPublishNavBarView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPPublishNavBarView.access$getAttr(NBPPublishNavBarView.this).getViewModel().tryRetentionOrClose();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final h hVar4 = hVar3;
                                final NBPPublishNavBarView nBPPublishNavBarView4 = NBPPublishNavBarView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItems(FlexAlign.CENTER);
                                                tVar2.justifyContentFlexStart();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final h hVar5 = h.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final h hVar6 = h.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ARmYYgKEbTQ.png", false, 2, null);
                                                        afVar2.size(16.0f, 16.0f);
                                                        afVar2.t(h.this);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishNavBarView nBPPublishNavBarView5 = nBPPublishNavBarView4;
                                        final h hVar6 = h.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPPublishNavBarView nBPPublishNavBarView6 = NBPPublishNavBarView.this;
                                                final h hVar7 = hVar6;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        k poiInfo = NBPPublishNavBarView.access$getAttr(NBPPublishNavBarView.this).getViewModel().getPoiInfo();
                                                        if (poiInfo == null || (str = poiInfo.Q) == null) {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.color(hVar7);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.lines(1);
                                                        ceVar2.m144maxWidth((ceVar2.getPagerData().m() - 74.0f) - 126.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final h hVar7 = h.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final h hVar8 = h.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_p7mZ5IdEDXQ.png", false, 2, null);
                                                        afVar2.size(12.0f, 12.0f);
                                                        afVar2.t(h.this);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishNavBarView nBPPublishNavBarView6 = nBPPublishNavBarView4;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                u uVar2 = uVar;
                                                final NBPPublishNavBarView nBPPublishNavBarView7 = NBPPublishNavBarView.this;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.5.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPPublishNavBarView.access$customDtReportEditLocation(NBPPublishNavBarView.this, "dt_clck");
                                                        if (Intrinsics.areEqual(NBPPublishNavBarView.access$getAttr(NBPPublishNavBarView.this).getViewModel().source, "5")) {
                                                            KLog.INSTANCE.i("NBPPublishPage", "clicked Location bar wille from middle page");
                                                        } else {
                                                            final NBPPublishViewModel viewModel = NBPPublishNavBarView.access$getAttr(NBPPublishNavBarView.this).getViewModel();
                                                            NBPPublishBridgeModule bridgeModule = viewModel.bridgeModule();
                                                            Function1<k, Unit> function1 = new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$enterLocationPage$1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(k kVar) {
                                                                    i iVar;
                                                                    k kVar2 = kVar;
                                                                    String str = kVar2.I;
                                                                    k poiInfo = NBPPublishViewModel.this.getPoiInfo();
                                                                    if (!Intrinsics.areEqual(str, poiInfo != null ? poiInfo.I : null)) {
                                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u4ec5\u652f\u6301\u9009\u62e9\u672c\u5e02\u5185\u7684\u5730\u5740", QToastMode.Warning);
                                                                    } else {
                                                                        NBPPublishViewModel.this.setPoiInfo(kVar2);
                                                                        KLog kLog = KLog.INSTANCE;
                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("select location: ");
                                                                        k poiInfo2 = NBPPublishViewModel.this.getPoiInfo();
                                                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, poiInfo2 != null ? NBPPublishServiceKt.desc(poiInfo2) : null, kLog, "NBPPublishViewModel");
                                                                        k poiInfo3 = NBPPublishViewModel.this.getPoiInfo();
                                                                        if (poiInfo3 != null && (iVar = poiInfo3.C) != null) {
                                                                            QQNearbyModule.Companion companion = QQNearbyModule.Companion;
                                                                            double d16 = 1000000;
                                                                            QQNearbyModule.Companion.scrollToPositionOnMap$default(iVar.f418079d / d16, iVar.f418080e / d16);
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            bridgeModule.getClass();
                                                            bridgeModule.asyncToNativeMethod("enterLocationPage", new Object[0], new NBPPublishBridgeModule$enterLocationPage$1(function1));
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishNavBarView nBPPublishNavBarView8 = NBPPublishNavBarView.this;
                                                VisibilityEventKt.e(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.5.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPPublishNavBarView.access$customDtReportEditLocation(NBPPublishNavBarView.this, "dt_imp");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishNavBarView nBPPublishNavBarView9 = NBPPublishNavBarView.this;
                                                VisibilityEventKt.c(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.2.3.5.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPPublishNavBarView.access$customDtReportEditLocation(NBPPublishNavBarView.this, "dt_imp_end");
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
                        final NBPPublishNavBarView nBPPublishNavBarView3 = NBPPublishNavBarView.this;
                        c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ButtonView buttonView) {
                                ButtonView buttonView2 = buttonView;
                                final NBPPublishNavBarView nBPPublishNavBarView4 = NBPPublishNavBarView.this;
                                buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(a aVar) {
                                        a aVar2 = aVar;
                                        aVar2.mo141height(29.0f);
                                        aVar2.marginRight(16.0f);
                                        aVar2.paddingLeft(16.0f);
                                        aVar2.paddingRight(16.0f);
                                        aVar2.borderRadius(4.0f);
                                        aVar2.mo113backgroundColor(new h(4278229503L));
                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.value("\u53d1\u5e03");
                                                ceVar2.color(h.INSTANCE.m());
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        boolean hasPublishInfo = NBPPublishNavBarView.access$getAttr(NBPPublishNavBarView.this).getViewModel().hasPublishInfo();
                                        aVar2.m151touchEnable(hasPublishInfo);
                                        aVar2.m147opacity(hasPublishInfo ? 1.0f : 0.5f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishNavBarView nBPPublishNavBarView5 = NBPPublishNavBarView.this;
                                buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                        final NBPPublishNavBarView nBPPublishNavBarView6 = NBPPublishNavBarView.this;
                                        bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                int collectionSizeOrDefault;
                                                Object obj;
                                                Object first;
                                                k kVar;
                                                i iVar;
                                                String str;
                                                if (NBPPublishNavBarView.access$getAttr(NBPPublishNavBarView.this).getViewModel().hasPublishInfo()) {
                                                    final NBPPublishViewModel viewModel = NBPPublishNavBarView.access$getAttr(NBPPublishNavBarView.this).getViewModel();
                                                    viewModel.getClass();
                                                    if (!NearbyProUtilsKt.isInNBPMain()) {
                                                        KLog.INSTANCE.e("NBPPublishViewModel", "Illegal path, no access to edit");
                                                    } else if (viewModel.canPublish()) {
                                                        ReadWriteProperty readWriteProperty = viewModel.isPublishing$delegate;
                                                        KProperty<?>[] kPropertyArr = NBPPublishViewModel.$$delegatedProperties;
                                                        if (!((Boolean) readWriteProperty.getValue(viewModel, kPropertyArr[10])).booleanValue()) {
                                                            viewModel.isPublishing$delegate.setValue(viewModel, kPropertyArr[10], Boolean.TRUE);
                                                            KLog.INSTANCE.i("NBPPublishViewModel", "publish start");
                                                            ArrayList arrayList = new ArrayList();
                                                            Iterator<n25.m> it = viewModel.getSelectTopicList().iterator();
                                                            while (it.hasNext()) {
                                                                arrayList.add(new n25.m(it.next().f418098d, 14));
                                                            }
                                                            String str2 = viewModel.source;
                                                            String photoPath = viewModel.getPhotoPath();
                                                            NBPPublishStatusData selectStatus = viewModel.getSelectStatus();
                                                            String content = viewModel.getContent();
                                                            k poiInfo = viewModel.getPoiInfo();
                                                            com.tencent.kuikly.core.reactive.collection.c<f> selectThemeList = viewModel.getSelectThemeList();
                                                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectThemeList, 10);
                                                            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                                            Iterator<f> it5 = selectThemeList.iterator();
                                                            while (it5.hasNext()) {
                                                                arrayList2.add(it5.next().f421849d);
                                                            }
                                                            NBPPublishConfig nBPPublishConfig = new NBPPublishConfig(str2, photoPath, selectStatus, content, poiInfo, arrayList, arrayList2, Intrinsics.areEqual(viewModel.source, "4") ? 5 : 0, 640);
                                                            k kVar2 = nBPPublishConfig.poiInfo;
                                                            String str3 = kVar2 != null ? kVar2.G : null;
                                                            if ((str3 == null || str3.length() == 0) != false && (kVar = nBPPublishConfig.poiInfo) != null && (iVar = kVar.C) != null) {
                                                                long j3 = iVar.f418080e;
                                                                long j16 = iVar.f418079d;
                                                                double d16 = j3 / 1000000.0d;
                                                                double d17 = j16 / 1000000.0d;
                                                                if ((73.66d <= d16 && d16 <= 135.03d) != false) {
                                                                    if ((3.86d <= d17 && d17 <= 53.55d) != false) {
                                                                        str = CountrySelectView.NAME_CHINA;
                                                                        kVar.G = str;
                                                                    }
                                                                }
                                                                str = "\u6d77\u5916";
                                                                kVar.G = str;
                                                            }
                                                            KLog kLog = KLog.INSTANCE;
                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("publish config country: ");
                                                            k kVar3 = nBPPublishConfig.poiInfo;
                                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, kVar3 != null ? kVar3.G : null, kLog, "NBPPublishViewModel");
                                                            NBPPublishService.INSTANCE.publish(nBPPublishConfig, new Function3<Boolean, s25.f, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$publish$2
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(Boolean bool, s25.f fVar, String str4) {
                                                                    Object firstOrNull;
                                                                    String str5;
                                                                    boolean booleanValue = bool.booleanValue();
                                                                    s25.f fVar2 = fVar;
                                                                    String str6 = str4;
                                                                    NBPPublishViewModel nBPPublishViewModel = NBPPublishViewModel.this;
                                                                    nBPPublishViewModel.isPublishing$delegate.setValue(nBPPublishViewModel, NBPPublishViewModel.$$delegatedProperties[10], Boolean.FALSE);
                                                                    final l lVar = fVar2 != null ? fVar2.f433139d : null;
                                                                    if (booleanValue && lVar != null) {
                                                                        if (defpackage.k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                            NBPPublishViewModel.access$closePage(NBPPublishViewModel.this, lVar);
                                                                        } else {
                                                                            final NBPPublishViewModel nBPPublishViewModel2 = NBPPublishViewModel.this;
                                                                            TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel$publish$2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                public final Unit invoke() {
                                                                                    NBPPublishViewModel.access$closePage(NBPPublishViewModel.this, lVar);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        }
                                                                        NBPPublishViewModel nBPPublishViewModel3 = NBPPublishViewModel.this;
                                                                        f fVar3 = nBPPublishViewModel3.lastAISelectTheme;
                                                                        if (fVar3 != null) {
                                                                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) nBPPublishViewModel3.getSelectThemeList());
                                                                            f fVar4 = (f) firstOrNull;
                                                                            AITechReporter aITechReporter = nBPPublishViewModel3.aiReporter;
                                                                            boolean areEqual = Intrinsics.areEqual(fVar3, fVar4);
                                                                            String str7 = fVar3.f421849d;
                                                                            if (fVar4 == null || (str5 = fVar4.f421849d) == null) {
                                                                                str5 = "";
                                                                            }
                                                                            String str8 = lVar.f418092d;
                                                                            aITechReporter.getClass();
                                                                            e eVar = new e();
                                                                            eVar.t("detect_tag_result", areEqual ? 1 : 0);
                                                                            eVar.v("detect_tag_from", str7);
                                                                            eVar.v("detect_tag_to", str5);
                                                                            eVar.v("detect_tag_feed_id", str8);
                                                                            aITechReporter.aiDetectTag = eVar;
                                                                            aITechReporter.report();
                                                                        }
                                                                    } else if (str6 != null) {
                                                                        Utils.INSTANCE.currentBridgeModule().qToast(str6, QToastMode.Warning);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                                                            jsonWithPublishPgParams.v("dt_eid", "em_nearby_publish_now");
                                                            jsonWithPublishPgParams.t("nearby_have_location", viewModel.getPoiInfo() != null ? 1 : 0);
                                                            jsonWithPublishPgParams.t("nearby_have_topic", !viewModel.getSelectTopicList().isEmpty() ? 1 : 0);
                                                            jsonWithPublishPgParams.t("nearby_have_map", !viewModel.getSelectThemeList().isEmpty() ? 1 : 0);
                                                            if (!viewModel.getSelectThemeList().isEmpty()) {
                                                                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) viewModel.getSelectThemeList());
                                                                obj = ((f) first).f421849d;
                                                            } else {
                                                                obj = 0;
                                                            }
                                                            jsonWithPublishPgParams.v("nearby_map_id", obj);
                                                            jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPublishPgParams);
                                                        }
                                                    }
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPPublishNavBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPublishNavBarEvent();
    }
}
