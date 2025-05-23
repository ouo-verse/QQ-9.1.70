package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.FloatingPanelAttr;
import com.tencent.hippykotlin.demo.pages.base.FloatingPanelEvent;
import com.tencent.hippykotlin.demo.pages.base.FloatingPanelView;
import com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt$FloatingPanelView$1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$3;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.Scene$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowStyleInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponGetCouponByIDRsp;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponProductShowCoupons;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponQueryORConditon;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponShowDiscount;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponUserCouponUse;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import defpackage.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;

/* loaded from: classes33.dex */
public final class ObtainCouponPage extends BasePager {
    public String adClickId = "";
    public ObtainCouponViewModel viewModel;

    /* loaded from: classes33.dex */
    public static final class ObtainCouponAttr extends k {
        public ObtainCouponViewModel.PageState listState;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                AnonymousClass1 anonymousClass1 = new Function1<FloatingPanelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(FloatingPanelAttr floatingPanelAttr) {
                        Float floatOrNull;
                        FloatingPanelAttr floatingPanelAttr2 = floatingPanelAttr;
                        floatingPanelAttr2.title = "\u4f18\u60e0\u5238";
                        floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(floatingPanelAttr2.getPagerData().n().p(LayoutAttrDefine.MARGIN_TOP));
                        if (floatOrNull != null) {
                            floatingPanelAttr2.marginTop = floatOrNull.floatValue();
                        }
                        return Unit.INSTANCE;
                    }
                };
                final ObtainCouponPage obtainCouponPage = ObtainCouponPage.this;
                Function1<FloatingPanelEvent, Unit> function1 = new Function1<FloatingPanelEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(FloatingPanelEvent floatingPanelEvent) {
                        FloatingPanelEvent floatingPanelEvent2 = floatingPanelEvent;
                        final ObtainCouponPage obtainCouponPage2 = ObtainCouponPage.this;
                        floatingPanelEvent2.registerEvent("actionShow", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                ObtainCouponViewModel obtainCouponViewModel = ObtainCouponPage.this.viewModel;
                                ObtainCouponViewModel obtainCouponViewModel2 = null;
                                if (obtainCouponViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    obtainCouponViewModel = null;
                                }
                                String str = obtainCouponViewModel.mediaId;
                                ObtainCouponViewModel obtainCouponViewModel3 = ObtainCouponPage.this.viewModel;
                                if (obtainCouponViewModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                } else {
                                    obtainCouponViewModel2 = obtainCouponViewModel3;
                                }
                                int i3 = obtainCouponViewModel2.scene;
                                BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
                                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("seller_id", str);
                                m3.t("scene", Scene$EnumUnboxingLocalUtility.getValue(i3));
                                m3.t("layer_type", 1);
                                Unit unit = Unit.INSTANCE;
                                bridgeModule.reportDT("qstore_price_reduce_layer_exp", m3);
                                return Unit.INSTANCE;
                            }
                        });
                        final ObtainCouponPage obtainCouponPage3 = ObtainCouponPage.this;
                        floatingPanelEvent2.registerEvent("actionClose", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                ObtainCouponViewModel obtainCouponViewModel = ObtainCouponPage.this.viewModel;
                                ObtainCouponViewModel obtainCouponViewModel2 = null;
                                if (obtainCouponViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    obtainCouponViewModel = null;
                                }
                                String str = obtainCouponViewModel.mediaId;
                                ObtainCouponViewModel obtainCouponViewModel3 = ObtainCouponPage.this.viewModel;
                                if (obtainCouponViewModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                } else {
                                    obtainCouponViewModel2 = obtainCouponViewModel3;
                                }
                                int i3 = obtainCouponViewModel2.scene;
                                BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
                                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("seller_id", str);
                                m3.t("scene", Scene$EnumUnboxingLocalUtility.getValue(i3));
                                m3.t("layer_type", 1);
                                m3.t("act_type", 3);
                                Unit unit = Unit.INSTANCE;
                                bridgeModule.reportDT("qstore_price_reduce_layer_clk", m3);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                final ObtainCouponPage obtainCouponPage2 = this;
                viewContainer.addChild(new FloatingPanelView(new Function2<ViewContainer<?, ?>, FloatingPanelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage$body$1.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(ViewContainer<?, ?> viewContainer2, FloatingPanelView floatingPanelView) {
                        final ObtainCouponPage obtainCouponPage3 = ObtainCouponPage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ObtainCouponViewModel obtainCouponViewModel = ObtainCouponPage.this.viewModel;
                                if (obtainCouponViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    obtainCouponViewModel = null;
                                }
                                return obtainCouponViewModel.getPageState();
                            }
                        };
                        final ObtainCouponPage obtainCouponPage4 = ObtainCouponPage.this;
                        BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                final ObtainCouponPage obtainCouponPage5 = ObtainCouponPage.this;
                                ConditionViewKt.c(bindDirectivesView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        ObtainCouponViewModel obtainCouponViewModel = ObtainCouponPage.this.viewModel;
                                        if (obtainCouponViewModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                            obtainCouponViewModel = null;
                                        }
                                        return Boolean.valueOf(obtainCouponViewModel.getPageState() instanceof ObtainCouponViewModel.PageState.Loading);
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        ECLoadingViewKt.ECLoading(conditionView, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                                eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.2.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                                        eCLoadingAttr.setLoadingText("\u52a0\u8f7d\u4e2d");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ObtainCouponPage obtainCouponPage6 = ObtainCouponPage.this;
                                ConditionViewKt.c(bindDirectivesView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        ObtainCouponViewModel obtainCouponViewModel = ObtainCouponPage.this.viewModel;
                                        if (obtainCouponViewModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                            obtainCouponViewModel = null;
                                        }
                                        return Boolean.valueOf(Intrinsics.areEqual(obtainCouponViewModel.getPageState(), ObtainCouponViewModel.PageState.Empty.INSTANCE));
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showEmpty$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showEmpty$1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.alignItemsCenter();
                                                        tVar2.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showEmpty$1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt.showEmpty.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                ImageAttrExtKt.srcUrl(afVar2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/emptystate/qecommerce_skin_emptystate_img_wenjian.png", "https://qq-ecommerce.cdn-go.cn/url/latest/darkmode/emptystate/qecommerce_skin_emptystate_img_wenjian.png");
                                                                afVar2.size(256.0f, 192.0f);
                                                                afVar2.marginTop(136.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showEmpty$1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt.showEmpty.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginTop(8.0f);
                                                                ceVar2.text("\u6682\u65e0\u53ef\u7528\u4f18\u60e0\u5238");
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
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
                                final ObtainCouponPage obtainCouponPage7 = ObtainCouponPage.this;
                                ConditionViewKt.c(bindDirectivesView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.5
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        ObtainCouponViewModel obtainCouponViewModel = ObtainCouponPage.this.viewModel;
                                        if (obtainCouponViewModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                            obtainCouponViewModel = null;
                                        }
                                        return Boolean.valueOf(Intrinsics.areEqual(obtainCouponViewModel.getPageState(), ObtainCouponViewModel.PageState.NetworkError.INSTANCE));
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showNetworkError$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showNetworkError$1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.alignItemsCenter();
                                                        tVar2.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showNetworkError$1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt.showNetworkError.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.marginTop(136.0f);
                                                                b.a.b(afVar2, "qecommerce_skin_emptystate_img_wuwangluo", false, 2, null);
                                                                afVar2.size(256.0f, 192.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showNetworkError$1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt.showNetworkError.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginTop(16.0f);
                                                                ceVar2.text("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
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
                                final ObtainCouponPage obtainCouponPage8 = ObtainCouponPage.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.7
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        boolean z16;
                                        ObtainCouponViewModel obtainCouponViewModel = ObtainCouponPage.this.viewModel;
                                        ObtainCouponViewModel obtainCouponViewModel2 = null;
                                        if (obtainCouponViewModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                            obtainCouponViewModel = null;
                                        }
                                        if (!Intrinsics.areEqual(obtainCouponViewModel.getPageState(), ObtainCouponViewModel.PageState.NetworkError.INSTANCE)) {
                                            ObtainCouponViewModel obtainCouponViewModel3 = ObtainCouponPage.this.viewModel;
                                            if (obtainCouponViewModel3 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                            } else {
                                                obtainCouponViewModel2 = obtainCouponViewModel3;
                                            }
                                            if (!Intrinsics.areEqual(obtainCouponViewModel2.getPageState(), ObtainCouponViewModel.PageState.Empty.INSTANCE)) {
                                                z16 = true;
                                                return Boolean.valueOf(z16);
                                            }
                                        }
                                        z16 = false;
                                        return Boolean.valueOf(z16);
                                    }
                                };
                                final ObtainCouponPage obtainCouponPage9 = ObtainCouponPage.this;
                                ConditionViewKt.c(bindDirectivesView2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.8
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        ConditionView conditionView2 = conditionView;
                                        ObtainCouponPage obtainCouponPage10 = ObtainCouponPage.this;
                                        String str = obtainCouponPage10.adClickId;
                                        ObtainCouponViewModel obtainCouponViewModel = obtainCouponPage10.viewModel;
                                        if (obtainCouponViewModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                            obtainCouponViewModel = null;
                                        }
                                        final ObtainCouponPage obtainCouponPage11 = ObtainCouponPage.this;
                                        conditionView2.addChild(new ObtainCouponList(str, obtainCouponViewModel), new Function1<ObtainCouponList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.8.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ObtainCouponList obtainCouponList) {
                                                final ObtainCouponPage obtainCouponPage12 = ObtainCouponPage.this;
                                                obtainCouponList.attr(new Function1<ObtainCouponPage.ObtainCouponAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage.body.1.3.2.8.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ObtainCouponPage.ObtainCouponAttr obtainCouponAttr) {
                                                        ObtainCouponPage.ObtainCouponAttr obtainCouponAttr2 = obtainCouponAttr;
                                                        obtainCouponAttr2.m140flex(1.0f);
                                                        ObtainCouponViewModel obtainCouponViewModel2 = ObtainCouponPage.this.viewModel;
                                                        if (obtainCouponViewModel2 == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                            obtainCouponViewModel2 = null;
                                                        }
                                                        obtainCouponAttr2.listState = obtainCouponViewModel2.getPageState();
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
                }), new FloatingPanelViewKt$FloatingPanelView$1(anonymousClass1, function1));
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.adClickId = getPageData().n().p("qz_gdt");
        String p16 = getPageData().n().p("shop_id");
        String p17 = getPageData().n().p("spu_id");
        String p18 = getPageData().n().p("media_id");
        int j3 = getPageData().n().j("scene");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ShopCouponQueryORConditon(p16, p17, 4));
        String p19 = getPageData().n().p("minimum_price");
        for (int i3 : BoxType$EnumUnboxingSharedUtility.values(3)) {
            if (Scene$EnumUnboxingLocalUtility.getValue(i3) == j3) {
                this.viewModel = new ObtainCouponViewModel(arrayList, p19, p18, i3);
                Utils.INSTANCE.logToNative("ObtainCouponPage received paras are shopID:" + p16 + ",spuid:" + p17 + ",minimumPrice:minimum_price");
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        final ObtainCouponViewModel obtainCouponViewModel = this.viewModel;
        if (obtainCouponViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            obtainCouponViewModel = null;
        }
        ObtainCouponViewModelKt.optPageData(obtainCouponViewModel.getPageState());
        ArrayList<ShopCouponQueryORConditon> arrayList = obtainCouponViewModel.queryCondition;
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<ShopCouponGetCouponByIDRsp> iSSOModelFactory = ShopCouponGetCouponByIDRsp.Factory;
        Function1<ShopCouponGetCouponByIDRsp, Unit> function1 = new Function1<ShopCouponGetCouponByIDRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponViewModel$refreshPage$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0129 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0037 A[SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List, java.util.Collection] */
            /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(ShopCouponGetCouponByIDRsp shopCouponGetCouponByIDRsp) {
                ?? emptyList;
                ObtainCouponItemModel obtainCouponItemModel;
                ObtainStatus obtainStatus;
                String str;
                String str2;
                ArrayList<ShopCouponProductShowCoupons> arrayList2 = shopCouponGetCouponByIDRsp.couponShowInfo;
                if (arrayList2 == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        Iterable iterable = ((ShopCouponProductShowCoupons) it.next()).couponShowInfo;
                        if (iterable == null) {
                            iterable = CollectionsKt__CollectionsKt.emptyList();
                        }
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList3, iterable);
                    }
                    ObtainCouponViewModel obtainCouponViewModel2 = ObtainCouponViewModel.this;
                    emptyList = new ArrayList();
                    Iterator it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        ShopCouponCouponShowInfo shopCouponCouponShowInfo = (ShopCouponCouponShowInfo) it5.next();
                        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = shopCouponCouponShowInfo.couponListStyle;
                        if (shopCouponCouponShowStyleInfo != null) {
                            obtainCouponViewModel2.getClass();
                            String str3 = shopCouponCouponShowInfo.couponBatchId;
                            String str4 = shopCouponCouponShowStyleInfo.couponTypeName;
                            ShopCouponShowDiscount shopCouponShowDiscount = shopCouponCouponShowStyleInfo.couponShowDiscount;
                            String str5 = (shopCouponShowDiscount == null || (str2 = shopCouponShowDiscount.discountAmount) == null) ? "" : str2;
                            String str6 = (shopCouponShowDiscount == null || (str = shopCouponShowDiscount.discountThreshold) == null) ? "" : str;
                            String str7 = str5;
                            CommonCouponItemModel commonCouponItemModel = new CommonCouponItemModel(str3, str4, str5, str6, shopCouponCouponShowStyleInfo.couponIssuerName, shopCouponCouponShowStyleInfo.couponUsableRange, shopCouponCouponShowStyleInfo.couponTimeScope, true);
                            if (!(str7.length() == 0)) {
                                if (!(str6.length() == 0)) {
                                    ShopCouponUserCouponUse shopCouponUserCouponUse = shopCouponCouponShowInfo.userCouponUse;
                                    if (shopCouponUserCouponUse != null && shopCouponUserCouponUse.remainNum == 0) {
                                        obtainStatus = ObtainStatus.SUCCESS_GET_ALL;
                                    } else if (shopCouponCouponShowInfo.couponRemainNum == 0) {
                                        obtainStatus = ObtainStatus.SUCCESS_NONE_LEFT;
                                    } else {
                                        if ((shopCouponUserCouponUse != null ? shopCouponUserCouponUse.hasNum : 0) > 0) {
                                            obtainStatus = ObtainStatus.SUCCESS_GET_PART;
                                        } else {
                                            obtainStatus = ObtainStatus.INIT;
                                        }
                                    }
                                    Utils.INSTANCE.logToNative("ObtainCouponViewModel the coupon is : " + commonCouponItemModel + " and status is : " + obtainStatus);
                                    obtainCouponItemModel = new ObtainCouponItemModel(commonCouponItemModel);
                                    obtainCouponItemModel.status$delegate.setValue(obtainCouponItemModel, ObtainCouponItemModel.$$delegatedProperties[0], obtainStatus);
                                    if (obtainCouponItemModel == null) {
                                        emptyList.add(obtainCouponItemModel);
                                    }
                                }
                            }
                            Utils utils = Utils.INSTANCE;
                            StringBuilder a16 = j.a("ObtainCouponViewModel the coupon ", str3, " if lack of ", str7, " or ");
                            a16.append(str6);
                            utils.logToNative(a16.toString());
                        } else {
                            Utils utils2 = Utils.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ObtainCouponViewModel the couponListStyle is null of coupon : ");
                            m3.append(shopCouponCouponShowInfo.couponBatchId);
                            utils2.logToNative(m3.toString());
                        }
                        obtainCouponItemModel = null;
                        if (obtainCouponItemModel == null) {
                        }
                    }
                }
                if (!emptyList.isEmpty()) {
                    ObtainCouponViewModel obtainCouponViewModel3 = ObtainCouponViewModel.this;
                    obtainCouponViewModel3.setPageState(new ObtainCouponViewModel.PageState.Succeed(new ObtainCouponViewModel.PageData(emptyList, obtainCouponViewModel3.minimumPrice)));
                } else {
                    Utils utils3 = Utils.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ObtainCouponViewModel there is no coupons on condition : ");
                    m16.append(ObtainCouponViewModel.this.queryCondition);
                    utils3.logToNative(m16.toString());
                    ObtainCouponViewModel.this.setPageState(ObtainCouponViewModel.PageState.Empty.INSTANCE);
                }
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponViewModel$refreshPage$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                int intValue = num.intValue();
                Utils.INSTANCE.logToNative("ObtainCouponViewModel  failed to fetch coupon list due to  " + intValue + ProgressTracer.SEPARATOR + str);
                ObtainCouponViewModel.this.setPageState(ObtainCouponViewModel.PageState.NetworkError.INSTANCE);
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("sence", 2);
        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ShopCouponQueryORConditon) it.next()).encode());
            }
        }
        m3.v("cond", bVar);
        NetworkUtils$requestWithCmd$3 networkUtils$requestWithCmd$3 = new NetworkUtils$requestWithCmd$3(function2, iSSOModelFactory, function1);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.qshop_coupon_user_reader.QshopCouponUserReader/GetCouponByID", m3, false, networkUtils$requestWithCmd$3);
    }
}
