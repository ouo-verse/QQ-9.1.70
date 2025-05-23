package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.advertising_attribution.AdAttributionReporter;
import com.tencent.hippykotlin.demo.pages.advertising_attribution.AdAttributionReporter$shopClamOfferReport$1;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$3;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.SCPUtilsKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.Scene$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponReqItem;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponRetItem;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponDeviceInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponGetCouponRsp;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponUserCouponUse;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ObtainCouponList extends ComposeView<ObtainCouponPage.ObtainCouponAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final String adClickId;
    public final ObtainCouponViewModel viewModel;

    public ObtainCouponList(String str, ObtainCouponViewModel obtainCouponViewModel) {
        this.adClickId = str;
        this.viewModel = obtainCouponViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final ObtainCouponViewModel.PageState pageState = ((ObtainCouponPage.ObtainCouponAttr) getAttr()).listState;
        if (pageState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listState");
            pageState = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ObtainCouponViewModel.PageState pageState2 = ObtainCouponViewModel.PageState.this;
                final ObtainCouponList obtainCouponList = this;
                final ObtainCouponList obtainCouponList2 = this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                a.C5863a.a(tVar2, 0.0f, 16.0f, 4.0f, 16.0f, 1, null);
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final ObtainCouponViewModel.PageState pageState3 = ObtainCouponViewModel.PageState.this;
                        if (pageState3 instanceof ObtainCouponViewModel.PageState.InitLoading) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showInitLoading$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showInitLoading$1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.marginBottom(16.0f);
                                            tVar2.marginTop(16.0f);
                                            tVar2.size(250.0f, 20.0f);
                                            AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_backplate");
                                            tVar2.borderRadius(4.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (pageState3 instanceof ObtainCouponViewModel.PageState.Succeed) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showMinimumPrice$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showMinimumPrice$1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.marginBottom(11.0f);
                                            tVar2.mo141height(28.0f);
                                            tVar2.flexDirectionRow();
                                            tVar2.alignItemsCenter();
                                            tVar2.justifyContentSpaceBetween();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ObtainCouponViewModel.PageState pageState4 = ObtainCouponViewModel.PageState.this;
                                    RichTextViewKt.b(vVar4, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt$showMinimumPrice$1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(RichTextView richTextView) {
                                            final RichTextView richTextView2 = richTextView;
                                            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt.showMinimumPrice.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(cf cfVar) {
                                                    cf cfVar2 = cfVar;
                                                    cfVar2.text("\u5f53\u524d\u5546\u54c1\u4eab\u53d7\u5982\u4e0b\u4f18\u60e0\uff0c\u4e0b\u5355\u7acb\u4eab");
                                                    ce.fontSize$default(cfVar2, 13.0f, null, 2, null);
                                                    cfVar2.color(IPagerIdKtxKt.getSkinColor(RichTextView.this).getPrimaryTextColor());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ObtainCouponViewModel.PageState pageState5 = ObtainCouponViewModel.PageState.this;
                                            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPageKt.showMinimumPrice.1.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(cf cfVar) {
                                                    cf cfVar2 = cfVar;
                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(" \u00a5");
                                                    ObtainCouponViewModel.PageData optPageData = ObtainCouponViewModelKt.optPageData(ObtainCouponViewModel.PageState.this);
                                                    m3.append(optPageData != null ? optPageData.minimumPrice : null);
                                                    m3.append(" \u8d77");
                                                    cfVar2.text(m3.toString());
                                                    ce.fontSize$default(cfVar2, 13.0f, null, 2, null);
                                                    cfVar2.color(IPagerIdKtxKt.getSkinColor(richTextView2).getRedTextColor());
                                                    cfVar2.fontWeightBold();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final ObtainCouponViewModel.PageState pageState4 = ObtainCouponViewModel.PageState.this;
                        final ObtainCouponList obtainCouponList3 = obtainCouponList;
                        final ObtainCouponList obtainCouponList4 = obtainCouponList2;
                        ar.a(vVar2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                List<ObtainCouponItemModel> list;
                                aq<?, ?> aqVar2 = aqVar;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.showScrollerIndicator(false);
                                        aoVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ObtainCouponViewModel.PageData optPageData = ObtainCouponViewModelKt.optPageData(ObtainCouponViewModel.PageState.this);
                                if (optPageData != null && (list = optPageData.couponList) != null) {
                                    final ObtainCouponList obtainCouponList5 = obtainCouponList3;
                                    final ObtainCouponList obtainCouponList6 = obtainCouponList4;
                                    for (final ObtainCouponItemModel obtainCouponItemModel : list) {
                                        aqVar2.addChild(new ObtainCouponItemView(), new Function1<ObtainCouponItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList$body$1$1$2$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ObtainCouponItemView obtainCouponItemView) {
                                                final ObtainCouponItemView obtainCouponItemView2 = obtainCouponItemView;
                                                final ObtainCouponItemModel obtainCouponItemModel2 = ObtainCouponItemModel.this;
                                                obtainCouponItemView2.attr(new Function1<ObtainCouponItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList$body$1$1$2$2$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ObtainCouponItemAttr obtainCouponItemAttr) {
                                                        obtainCouponItemAttr.couponItem = ObtainCouponItemModel.this;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ObtainCouponList obtainCouponList7 = obtainCouponList5;
                                                final ObtainCouponItemModel obtainCouponItemModel3 = ObtainCouponItemModel.this;
                                                final ObtainCouponList obtainCouponList8 = obtainCouponList6;
                                                obtainCouponItemView2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList$body$1$1$2$2$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(l lVar) {
                                                        ObtainCouponList obtainCouponList9 = ObtainCouponList.this;
                                                        final ObtainCouponItemModel obtainCouponItemModel4 = obtainCouponItemModel3;
                                                        final ObtainCouponList obtainCouponList10 = obtainCouponList8;
                                                        final ObtainCouponItemView obtainCouponItemView3 = obtainCouponItemView2;
                                                        int i3 = ObtainCouponList.$r8$clinit;
                                                        obtainCouponList9.getClass();
                                                        lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList$setClickListener$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainStatus, T] */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                int ordinal = ObtainCouponItemModel.this.getStatus().ordinal();
                                                                if (ordinal == 0 || ordinal == 2) {
                                                                    final ObtainCouponList obtainCouponList11 = obtainCouponList10;
                                                                    final ObtainCouponViewModel obtainCouponViewModel = obtainCouponList11.viewModel;
                                                                    ObtainCouponItemModel obtainCouponItemModel5 = ObtainCouponItemModel.this;
                                                                    final ObtainCouponItemView obtainCouponItemView4 = obtainCouponItemView3;
                                                                    final Function2<String, ObtainStatus, Unit> function2 = new Function2<String, ObtainStatus, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponList$setClickListener$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(2);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public final Unit invoke(String str, ObtainStatus obtainStatus) {
                                                                            ObtainStatus obtainStatus2 = obtainStatus;
                                                                            IPagerIdKtxKt.getBridgeModule(ObtainCouponList.this).toast(str);
                                                                            ObtainCouponItemModel item = obtainCouponItemView4.getItem();
                                                                            item.status$delegate.setValue(item, ObtainCouponItemModel.$$delegatedProperties[0], obtainStatus2);
                                                                            if (obtainStatus2 == ObtainStatus.SUCCESS_GET_ALL || obtainStatus2 == ObtainStatus.SUCCESS_GET_PART || obtainStatus2 == ObtainStatus.SUCCESS_NONE_LEFT) {
                                                                                AdAttributionReporter adAttributionReporter = AdAttributionReporter.INSTANCE;
                                                                                String str2 = ObtainCouponList.this.adClickId;
                                                                                if (str2 != null) {
                                                                                    if (!(str2.length() == 0)) {
                                                                                        BuildersKt.e((e) AdAttributionReporter.viewModelScope$delegate.getValue(), null, null, new AdAttributionReporter$shopClamOfferReport$1(adAttributionReporter.combineReportData(str2, "CLAIM_OFFER"), null), 3, null);
                                                                                    }
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    String str = obtainCouponViewModel.mediaId;
                                                                    int i16 = obtainCouponViewModel.scene;
                                                                    Utils utils = Utils.INSTANCE;
                                                                    BridgeModule bridgeModule = utils.bridgeModule(BridgeManager.f117344a.u());
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("seller_id", str);
                                                                    m3.t("scene", Scene$EnumUnboxingLocalUtility.getValue(i16));
                                                                    m3.t("layer_type", 1);
                                                                    m3.t("act_type", 1);
                                                                    Unit unit = Unit.INSTANCE;
                                                                    bridgeModule.reportDT("qstore_price_reduce_layer_clk", m3);
                                                                    final String str2 = obtainCouponItemModel5.commonItemModel.f114301id;
                                                                    if (str2.length() == 0) {
                                                                        utils.logToNative("ObtainCouponViewModel the coupon has no id");
                                                                    } else {
                                                                        ArrayList arrayList = new ArrayList();
                                                                        arrayList.add(new ShopCouponCouponReqItem(str2, 1));
                                                                        ShopCouponDeviceInfo shopCouponDeviceInfo = SCPUtilsKt.toShopCouponDeviceInfo(utils.currentBridgeModule().getDeviceInfo());
                                                                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                                                        objectRef.element = "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
                                                                        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                                                                        objectRef2.element = obtainCouponItemModel5.getStatus();
                                                                        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
                                                                        ISSOModelFactory<ShopCouponGetCouponRsp> iSSOModelFactory = ShopCouponGetCouponRsp.Factory;
                                                                        Function1<ShopCouponGetCouponRsp, Unit> function1 = new Function1<ShopCouponGetCouponRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponViewModel$toggleObtainCouponById$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            /* JADX WARN: Type inference failed for: r8v13, types: [java.lang.String] */
                                                                            /* JADX WARN: Type inference failed for: r8v15, types: [T, java.lang.String] */
                                                                            /* JADX WARN: Type inference failed for: r8v16 */
                                                                            /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.String] */
                                                                            /* JADX WARN: Type inference failed for: r9v11 */
                                                                            /* JADX WARN: Type inference failed for: r9v18 */
                                                                            /* JADX WARN: Type inference failed for: r9v20 */
                                                                            /* JADX WARN: Type inference failed for: r9v21 */
                                                                            /* JADX WARN: Type inference failed for: r9v22 */
                                                                            /* JADX WARN: Type inference failed for: r9v23 */
                                                                            /* JADX WARN: Type inference failed for: r9v3, types: [com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainStatus] */
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ShopCouponGetCouponRsp shopCouponGetCouponRsp) {
                                                                                ObtainStatus obtainStatus;
                                                                                ShopCouponUserCouponUse shopCouponUserCouponUse;
                                                                                ShopCouponUserCouponUse shopCouponUserCouponUse2;
                                                                                ShopCouponGetCouponRsp shopCouponGetCouponRsp2 = shopCouponGetCouponRsp;
                                                                                ArrayList<ShopCouponCouponRetItem> arrayList2 = shopCouponGetCouponRsp2.items;
                                                                                if (arrayList2 != null && (arrayList2.isEmpty() ^ true)) {
                                                                                    ArrayList<ShopCouponCouponRetItem> arrayList3 = shopCouponGetCouponRsp2.items;
                                                                                    String str3 = str2;
                                                                                    ObtainCouponViewModel obtainCouponViewModel2 = obtainCouponViewModel;
                                                                                    Ref.ObjectRef<String> objectRef3 = objectRef;
                                                                                    Ref.ObjectRef<ObtainStatus> objectRef4 = objectRef2;
                                                                                    for (ShopCouponCouponRetItem shopCouponCouponRetItem : arrayList3) {
                                                                                        Utils utils2 = Utils.INSTANCE;
                                                                                        utils2.logToNative("ObtainCouponViewModel the result of coupon " + str3 + " is : retItem:" + shopCouponCouponRetItem);
                                                                                        String str4 = objectRef3.element;
                                                                                        ObtainStatus obtainStatus2 = objectRef4.element;
                                                                                        obtainCouponViewModel2.getClass();
                                                                                        String str5 = shopCouponCouponRetItem.retMsg;
                                                                                        if (str5.length() == 0) {
                                                                                            str5 = "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
                                                                                        }
                                                                                        int i17 = shopCouponCouponRetItem.retCode;
                                                                                        if (i17 != 0) {
                                                                                            switch (i17) {
                                                                                                case 36315:
                                                                                                    obtainStatus2 = ObtainStatus.FAIL_OUT_OF_DATE;
                                                                                                    break;
                                                                                                case 36316:
                                                                                                    obtainStatus2 = ObtainStatus.FAIL_NONE_LEFT;
                                                                                                    break;
                                                                                                case 36317:
                                                                                                    obtainStatus2 = ObtainStatus.FAIL_OVER_LIMIT;
                                                                                                    break;
                                                                                                case 36318:
                                                                                                    obtainStatus2 = ObtainStatus.FAIL_INVALIDATE;
                                                                                                    break;
                                                                                            }
                                                                                            str4 = str5;
                                                                                        } else {
                                                                                            ShopCouponCouponShowInfo shopCouponCouponShowInfo = shopCouponCouponRetItem.couponShowInfo;
                                                                                            if (shopCouponCouponShowInfo != null && shopCouponCouponShowInfo.couponRemainNum == 0) {
                                                                                                obtainStatus = ObtainStatus.SUCCESS_NONE_LEFT;
                                                                                            } else if ((shopCouponCouponShowInfo == null || (shopCouponUserCouponUse2 = shopCouponCouponShowInfo.userCouponUse) == null || shopCouponUserCouponUse2.remainNum != 0) ? false : true) {
                                                                                                obtainStatus = ObtainStatus.SUCCESS_GET_ALL;
                                                                                            } else if (((shopCouponCouponShowInfo == null || (shopCouponUserCouponUse = shopCouponCouponShowInfo.userCouponUse) == null) ? 0 : shopCouponUserCouponUse.remainNum) > 0) {
                                                                                                obtainStatus = ObtainStatus.SUCCESS_GET_PART;
                                                                                            } else {
                                                                                                obtainStatus = ObtainStatus.SUCCESS_GET_ALL;
                                                                                            }
                                                                                            obtainStatus2 = obtainStatus;
                                                                                            str4 = "\u9886\u53d6\u6210\u529f";
                                                                                        }
                                                                                        StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("ObtainCouponViewModel the result of obtain coupon : ", str4, " and return code is : ");
                                                                                        m16.append(shopCouponCouponRetItem.retCode);
                                                                                        utils2.logToNative(m16.toString());
                                                                                        objectRef3.element = str4;
                                                                                        objectRef4.element = obtainStatus2;
                                                                                    }
                                                                                } else {
                                                                                    Utils.INSTANCE.logToNative("ObtainCouponViewModel the result of obtain coupon is empty");
                                                                                }
                                                                                function2.invoke(objectRef.element, objectRef2.element);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponViewModel$toggleObtainCouponById$2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Unit invoke(Integer num, String str3) {
                                                                                int intValue = num.intValue();
                                                                                Utils.INSTANCE.logToNative("ObtainCouponViewModel  failed to obtain coupon due to " + intValue + ':' + str3);
                                                                                function2.invoke(objectRef.element, objectRef2.element);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        BridgeModule currentBridgeModule = utils.currentBridgeModule();
                                                                        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                        b bVar = new b();
                                                                        Iterator it = arrayList.iterator();
                                                                        while (it.hasNext()) {
                                                                            bVar.t(((ShopCouponCouponReqItem) it.next()).encode());
                                                                        }
                                                                        eVar.v("items", bVar);
                                                                        eVar.t("sence", 1);
                                                                        eVar.t("mode", 1);
                                                                        eVar.v("device_info", shopCouponDeviceInfo.encode());
                                                                        currentBridgeModule.ssoRequest("trpc.ecom.qshop_coupon_user_writer.QshopCouponUserWriter/GetCoupon", eVar, false, new NetworkUtils$requestWithCmd$3(function22, iSSOModelFactory, function1));
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
                                    }
                                }
                                if (ObtainCouponViewModel.PageState.this instanceof ObtainCouponViewModel.PageState.InitLoading) {
                                    ObtainCouponItemSkeletonViewKt.obtainCouponItemSkeleton(aqVar2);
                                    ObtainCouponItemSkeletonViewKt.obtainCouponItemSkeleton(aqVar2);
                                    ObtainCouponItemSkeletonViewKt.obtainCouponItemSkeleton(aqVar2);
                                }
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
        return new ObtainCouponPage.ObtainCouponAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
