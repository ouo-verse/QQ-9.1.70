package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.sep_line.QPlusTrafficHomeCardSepLineView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.sep_line.QPlusTrafficHomeCardSepLineViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetAccountRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.QPlusTrafficHomeCardAttr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeAccountView extends QPlusTrafficHomeCardView {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPlusTrafficCardHomeViewModel viewModel = ((QPlusTrafficHomeCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel");
        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel = (QPlusTrafficHomeAccountViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.flexDirection(FlexDirection.COLUMN);
                        mVar2.mo153width(mVar2.getPagerData().m()).mo141height(121.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                QPlusTrafficHomeCardSepLineViewKt.CardSepLineView(viewContainer2, new Function1<QPlusTrafficHomeCardSepLineView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPlusTrafficHomeCardSepLineView qPlusTrafficHomeCardSepLineView) {
                        qPlusTrafficHomeCardSepLineView.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(k kVar) {
                                kVar.marginTop(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel2 = QPlusTrafficHomeAccountViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(QPlusTrafficHomeAccountViewModel.this.getUiState() == QPlusTrafficUIState.COMPLETED || QPlusTrafficHomeAccountViewModel.this.getUiState() == QPlusTrafficUIState.FAILURE);
                    }
                };
                final QPlusTrafficHomeAccountView qPlusTrafficHomeAccountView = this;
                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel3 = QPlusTrafficHomeAccountViewModel.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        QPlusTrafficHomeAccountView qPlusTrafficHomeAccountView2 = QPlusTrafficHomeAccountView.this;
                        int i3 = QPlusTrafficHomeAccountView.$r8$clinit;
                        qPlusTrafficHomeAccountView2.getClass();
                        QPlusTrafficHomeAccountView$bodyWithTopView$1.INSTANCE.invoke(conditionView2);
                        final QPlusTrafficHomeAccountView qPlusTrafficHomeAccountView3 = QPlusTrafficHomeAccountView.this;
                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel4 = qPlusTrafficHomeAccountViewModel3;
                        qPlusTrafficHomeAccountView3.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$bodyWithContentView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final QPlusTrafficHomeAccountView qPlusTrafficHomeAccountView4 = QPlusTrafficHomeAccountView.this;
                                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel5 = qPlusTrafficHomeAccountViewModel4;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$bodyWithContentView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithContentView.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirection(FlexDirection.ROW);
                                                tVar2.justifyContent(FlexJustifyContent.SPACE_BETWEEN);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        QPlusTrafficHomeAccountView qPlusTrafficHomeAccountView5 = QPlusTrafficHomeAccountView.this;
                                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel6 = qPlusTrafficHomeAccountViewModel5;
                                        int i16 = QPlusTrafficHomeAccountView.$r8$clinit;
                                        qPlusTrafficHomeAccountView5.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$bodyWithGoldView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel7 = QPlusTrafficHomeAccountViewModel.this;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$bodyWithGoldView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirection(FlexDirection.COLUMN);
                                                                tVar2.allCenter();
                                                                tVar2.mo153width(tVar2.getPagerData().m() / 2).mo141height(76.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel8 = QPlusTrafficHomeAccountViewModel.this;
                                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel9 = QPlusTrafficHomeAccountViewModel.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel10 = QPlusTrafficHomeAccountViewModel.this;
                                                                        qPlusTrafficHomeAccountViewModel10.pageDelegate.showLoading(true);
                                                                        KLog.INSTANCE.i("QPlus_Home", "show vas loading");
                                                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                                        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel$handleAddQQGoldAction$1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Boolean bool) {
                                                                                CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("open vas vc state:", bool.booleanValue(), KLog.INSTANCE, "QPlus_Home");
                                                                                QPlusTrafficHomeAccountViewModel.this.pageDelegate.showLoading(false);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        int i17 = BridgeModule.$r8$clinit;
                                                                        e eVar = new e();
                                                                        currentBridgeModule.getClass();
                                                                        e eVar2 = new e();
                                                                        eVar2.t("appId", 1012);
                                                                        eVar2.v("title", IVasNativePayManager.TITLE_RECHARGE);
                                                                        eVar2.v("appName", "");
                                                                        eVar2.t(WadlProxyConsts.SCENE_ID, 0);
                                                                        eVar2.t("sourceId", 0);
                                                                        eVar2.v("reportExt", eVar);
                                                                        currentBridgeModule.callNativeMethod("openVasRecharge", eVar2, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$openVasRecharge$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(e eVar3) {
                                                                                e eVar4 = eVar3;
                                                                                function1.invoke(Boolean.valueOf(Intrinsics.areEqual(eVar4 != null ? eVar4.p(VRReportDefine$ReportParam.IS_SUCCESS) : null, "1")));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel9 = QPlusTrafficHomeAccountViewModel.this;
                                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                v vVar6 = vVar5;
                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.flexDirection(FlexDirection.ROW);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.3.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.3.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.mo153width(16.0f).mo141height(16.0f);
                                                                                b.a.b(afVar2, "qecommerce_icon_qqjinbi", false, 2, null);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel10 = QPlusTrafficHomeAccountViewModel.this;
                                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.3.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel11 = QPlusTrafficHomeAccountViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.3.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                h hVar;
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.marginLeft(4.0f);
                                                                                ce.fontSize$default(ceVar2, 22.0f, null, 2, null);
                                                                                ceVar2.fontFamily("Qvideo Digit");
                                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                                ceVar2.color(hVar);
                                                                                QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel12 = QPlusTrafficHomeAccountViewModel.this;
                                                                                ceVar2.text((String) qPlusTrafficHomeAccountViewModel12.coinStr$delegate.getValue(qPlusTrafficHomeAccountViewModel12, QPlusTrafficHomeAccountViewModel.$$delegatedProperties[0]));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                v vVar6 = vVar5;
                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        if (!tVar2.getPagerData().getIsIOS()) {
                                                                            tVar2.marginTop(4.0f);
                                                                        }
                                                                        tVar2.flexDirection(FlexDirection.ROW);
                                                                        tVar2.alignItems(FlexAlign.CENTER);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.4.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.4.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                h hVar;
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.fontFamily("PingFang SC");
                                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                                ceVar2.color(hVar);
                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                ceVar2.text("QQ\u91d1\u5e01 \u5145\u503c");
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.4.3
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithGoldView.1.1.4.3.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.mo153width(12.0f);
                                                                                afVar2.mo141height(12.0f);
                                                                                b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_secondary", false, 2, null);
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
                                        }.invoke(vVar2);
                                        QPlusTrafficHomeAccountView qPlusTrafficHomeAccountView6 = QPlusTrafficHomeAccountView.this;
                                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel7 = qPlusTrafficHomeAccountViewModel5;
                                        qPlusTrafficHomeAccountView6.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$bodyWithCouponView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel8 = QPlusTrafficHomeAccountViewModel.this;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$bodyWithCouponView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithCouponView.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirection(FlexDirection.COLUMN);
                                                                tVar2.allCenter();
                                                                tVar2.mo153width(tVar2.getPagerData().m() / 2).mo141height(76.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel9 = QPlusTrafficHomeAccountViewModel.this;
                                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithCouponView.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel10 = QPlusTrafficHomeAccountViewModel.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithCouponView.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        QPlusTrafficHomeAccountViewModel.this.getClass();
                                                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), "mqqapi://kuikly/open?target=52&page_name=qplus_coupon_package&channel=2&src_type=internal&version=1&bundle_name=new_qecommerce", false, null, null, 30);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel10 = QPlusTrafficHomeAccountViewModel.this;
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithCouponView.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel11 = QPlusTrafficHomeAccountViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithCouponView.1.1.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 22.0f, null, 2, null).fontWeight700();
                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                        ceVar2.color(hVar);
                                                                        QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel12 = QPlusTrafficHomeAccountViewModel.this;
                                                                        ceVar2.text((String) qPlusTrafficHomeAccountViewModel12.couponStr$delegate.getValue(qPlusTrafficHomeAccountViewModel12, QPlusTrafficHomeAccountViewModel.$$delegatedProperties[1]));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithCouponView.1.1.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithCouponView.1.1.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        if (!ceVar2.getPagerData().getIsIOS()) {
                                                                            ceVar2.marginTop(4.0f);
                                                                        }
                                                                        ceVar2.fontFamily("PingFang SC");
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        ceVar2.text("\u5238\u5305");
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
                                        }.invoke(vVar2);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(conditionView2);
                        return Unit.INSTANCE;
                    }
                });
                final QPlusTrafficHomeAccountView qPlusTrafficHomeAccountView2 = this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        QPlusTrafficHomeAccountView qPlusTrafficHomeAccountView3 = QPlusTrafficHomeAccountView.this;
                        int i3 = QPlusTrafficHomeAccountView.$r8$clinit;
                        qPlusTrafficHomeAccountView3.getClass();
                        QPlusTrafficHomeAccountView$bodyWithSkeletonView$1.INSTANCE.invoke(conditionView);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        IQPlusTrafficCardHomeViewModel viewModel = ((QPlusTrafficHomeCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel");
        final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel = (QPlusTrafficHomeAccountViewModel) viewModel;
        qPlusTrafficHomeAccountViewModel.getClass();
        qPlusTrafficHomeAccountViewModel.notifyCallbackRef = com.tencent.kuikly.core.module.k.b(Utils.INSTANCE.notifyModule(""), "VASTopUpScuccessfullyNotify", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel$initViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                KLog.INSTANCE.i("QPlus_Home", "notify vas success");
                QPlusTrafficRepository qPlusTrafficRepository = QPlusTrafficRepository.INSTANCE;
                final QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel2 = QPlusTrafficHomeAccountViewModel.this;
                qPlusTrafficRepository.reqAccountInfo(new Function1<QPlusGetAccountRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel$initViewModel$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPlusGetAccountRsp qPlusGetAccountRsp) {
                        QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel3 = QPlusTrafficHomeAccountViewModel.this;
                        KProperty<Object>[] kPropertyArr = QPlusTrafficHomeAccountViewModel.$$delegatedProperties;
                        qPlusTrafficHomeAccountViewModel3.refreshData(qPlusGetAccountRsp);
                        return Unit.INSTANCE;
                    }
                }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel$initViewModel$1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                        num.intValue();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        IQPlusTrafficCardHomeViewModel viewModel = ((QPlusTrafficHomeCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel");
        QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel = (QPlusTrafficHomeAccountViewModel) viewModel;
        qPlusTrafficHomeAccountViewModel.getClass();
        Utils.INSTANCE.notifyModule("").e("VASTopUpScuccessfullyNotify", qPlusTrafficHomeAccountViewModel.notifyCallbackRef);
        super.viewDestroyed();
    }
}
