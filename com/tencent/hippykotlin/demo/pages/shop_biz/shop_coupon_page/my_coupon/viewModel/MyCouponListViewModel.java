package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowStyleInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponStyle;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponGetUserCouponsReq;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponGetUserCouponsRsp;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponUserCouponInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.IPageRequestLogic;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.PageRequestLogic;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MyCouponListViewModel extends BaseObject implements IMyCouponListViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MyCouponListViewModel.class, "displayTabTitle", "getDisplayTabTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MyCouponListViewModel.class, ViewStickEventHelper.IS_SHOW, "isShow()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MyCouponListViewModel.class, "isLoadFinishing", "isLoadFinishing()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MyCouponListViewModel.class, "couponDataStatus", "getCouponDataStatus()Lcom/tencent/hippykotlin/demo/pages/shop_biz/shop_coupon_page/my_coupon/viewModel/MyCouponDataStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MyCouponListViewModel.class, "list", "getList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public int autoReqCount;
    public boolean bShowCount;
    public final ReadWriteProperty couponDataStatus$delegate;
    public final ReadWriteProperty displayTabTitle$delegate = c.a("");
    public final ReadWriteProperty isLoadFinishing$delegate;
    public boolean isLoading;
    public final ReadWriteProperty isShow$delegate;
    public boolean isShowLoadMore;
    public final ReadWriteProperty list$delegate;
    public IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp> pageReqLogic;
    public MyCouponTabPageType pageType;
    public final String pagerId;
    public long showPageBeginTime;
    public String tabTitle;

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final MyCouponDataStatus getCouponDataStatus() {
        return (MyCouponDataStatus) this.couponDataStatus$delegate.getValue(this, $$delegatedProperties[3]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final String getDisplayTabTitle() {
        return (String) this.displayTabTitle$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final com.tencent.kuikly.core.reactive.collection.c<IMyCouponListItemViewModel> getList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.list$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final MyCouponTabPageType getPageType() {
        MyCouponTabPageType myCouponTabPageType = this.pageType;
        if (myCouponTabPageType != null) {
            return myCouponTabPageType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final boolean isLoadFinishing() {
        return ((Boolean) this.isLoadFinishing$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final boolean isShow() {
        return ((Boolean) this.isShow$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final boolean isShowLoadMore() {
        return this.isShowLoadMore;
    }

    public final void refreshDisplayText(long j3) {
        String str;
        if (this.bShowCount && j3 > 0) {
            str = this.tabTitle + '(' + j3 + ')';
        } else {
            str = this.tabTitle;
        }
        this.displayTabTitle$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final void reqFirstPage() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        int i3 = getPageType().status;
        final Function2<IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp>, ShopCouponGetUserCouponsRsp, Unit> function2 = new Function2<IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp>, ShopCouponGetUserCouponsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.MyCouponListViewModel$reqFirstPage$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp> iPageRequestLogic, ShopCouponGetUserCouponsRsp shopCouponGetUserCouponsRsp) {
                MyCouponListViewModel.this.getList().clear();
                MyCouponListViewModel myCouponListViewModel = MyCouponListViewModel.this;
                myCouponListViewModel.pageReqLogic = iPageRequestLogic;
                MyCouponListViewModel.access$handleRspPageDataSuccess(myCouponListViewModel, shopCouponGetUserCouponsRsp);
                MyCouponListViewModel myCouponListViewModel2 = MyCouponListViewModel.this;
                if (myCouponListViewModel2.autoReqCount <= 3 && !((Boolean) myCouponListViewModel2.isLoadFinishing$delegate.getValue(myCouponListViewModel2, MyCouponListViewModel.$$delegatedProperties[2])).booleanValue() && myCouponListViewModel2.getList().size() < 8) {
                    myCouponListViewModel2.autoReqCount++;
                    myCouponListViewModel2.reqNextPage();
                }
                MyCouponTabPageType pageType = MyCouponListViewModel.this.getPageType();
                long j3 = MyCouponListViewModel.this.showPageBeginTime;
                if (pageType == MyCouponTabPageType.WaitUse && j3 > 0) {
                    Utils utils = Utils.INSTANCE;
                    BridgeModule currentBridgeModule = utils.currentBridgeModule();
                    e eVar = new e();
                    eVar.u("cost_time", utils.currentBridgeModule().currentTimeStamp() - j3);
                    eVar.t("scene", 1021);
                    eVar.t("is_host", 1);
                    eVar.t("result_code", 2);
                    Unit unit = Unit.INSTANCE;
                    currentBridgeModule.reportDT("ec_quality_show_page_cost_time", eVar);
                }
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.MyCouponListViewModel$reqFirstPage$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                num.intValue();
                MyCouponListViewModel myCouponListViewModel = MyCouponListViewModel.this;
                myCouponListViewModel.isLoading = false;
                myCouponListViewModel.couponDataStatus$delegate.setValue(myCouponListViewModel, MyCouponListViewModel.$$delegatedProperties[3], MyCouponDataStatus.FAILURE);
                MyCouponTabPageType pageType = MyCouponListViewModel.this.getPageType();
                long j3 = MyCouponListViewModel.this.showPageBeginTime;
                if (pageType == MyCouponTabPageType.WaitUse && j3 > 0) {
                    Utils utils = Utils.INSTANCE;
                    BridgeModule currentBridgeModule = utils.currentBridgeModule();
                    e eVar = new e();
                    eVar.u("cost_time", utils.currentBridgeModule().currentTimeStamp() - j3);
                    eVar.t("scene", 1021);
                    eVar.t("is_host", 1);
                    eVar.t("result_code", 3);
                    Unit unit = Unit.INSTANCE;
                    currentBridgeModule.reportDT("ec_quality_show_page_cost_time", eVar);
                }
                return Unit.INSTANCE;
            }
        };
        final PageRequestLogic pageRequestLogic = new PageRequestLogic("trpc.ecom.qshop_coupon_user_reader.QshopCouponUserReader/GetUserCoupons", new ShopCouponGetUserCouponsReq(BoxType$EnumUnboxingSharedUtility.ordinal(i3), null), ShopCouponGetUserCouponsRsp.Factory, 1);
        pageRequestLogic.reqFirstPage(new Function1<ShopCouponGetUserCouponsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.MyCouponRepository$reqMyCouponList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ShopCouponGetUserCouponsRsp shopCouponGetUserCouponsRsp) {
                ShopCouponGetUserCouponsRsp shopCouponGetUserCouponsRsp2 = shopCouponGetUserCouponsRsp;
                Function2<IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp>, ShopCouponGetUserCouponsRsp, Unit> function23 = function2;
                PageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp> pageRequestLogic2 = pageRequestLogic;
                if (shopCouponGetUserCouponsRsp2 == null) {
                    shopCouponGetUserCouponsRsp2 = new ShopCouponGetUserCouponsRsp(null, 0L, null, false, 15, null);
                }
                function23.invoke(pageRequestLogic2, shopCouponGetUserCouponsRsp2);
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.MyCouponRepository$reqMyCouponList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                int intValue = num.intValue();
                function22.invoke(Integer.valueOf(intValue), str);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final void reqNextPage() {
        if (this.isLoading) {
            return;
        }
        IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp> iPageRequestLogic = this.pageReqLogic;
        IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp> iPageRequestLogic2 = null;
        if (iPageRequestLogic == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageReqLogic");
            iPageRequestLogic = null;
        }
        if (iPageRequestLogic.isEnd()) {
            return;
        }
        this.isLoading = true;
        IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp> iPageRequestLogic3 = this.pageReqLogic;
        if (iPageRequestLogic3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageReqLogic");
        } else {
            iPageRequestLogic2 = iPageRequestLogic3;
        }
        iPageRequestLogic2.reqNextPage(new Function1<ShopCouponGetUserCouponsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.MyCouponListViewModel$reqNextPage$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ShopCouponGetUserCouponsRsp shopCouponGetUserCouponsRsp) {
                MyCouponListViewModel.access$handleRspPageDataSuccess(MyCouponListViewModel.this, shopCouponGetUserCouponsRsp);
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.MyCouponListViewModel$reqNextPage$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                num.intValue();
                MyCouponListViewModel myCouponListViewModel = MyCouponListViewModel.this;
                myCouponListViewModel.isLoading = false;
                myCouponListViewModel.couponDataStatus$delegate.setValue(myCouponListViewModel, MyCouponListViewModel.$$delegatedProperties[3], MyCouponDataStatus.FAILURE);
                return Unit.INSTANCE;
            }
        });
    }

    public final void setBShowCount(boolean z16) {
        this.bShowCount = z16;
    }

    public final void setPageType(MyCouponTabPageType myCouponTabPageType) {
        this.pageType = myCouponTabPageType;
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final void setShow(boolean z16) {
        this.isShow$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public final void setTabTitle(String str) {
        this.tabTitle = str;
        refreshDisplayText(0L);
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel
    public final h textColor() {
        if (this.pagerId.length() == 0) {
            return h.INSTANCE.m();
        }
        return SkinColor.INSTANCE.tokenColor("qecommerce_skin_color_text_primary", false);
    }

    public MyCouponListViewModel(String str) {
        this.pagerId = str;
        Boolean bool = Boolean.FALSE;
        this.isShow$delegate = c.a(bool);
        this.isLoadFinishing$delegate = c.a(bool);
        this.couponDataStatus$delegate = c.a(MyCouponDataStatus.NORMAL);
        this.list$delegate = c.b();
        this.tabTitle = "";
        this.showPageBeginTime = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        for (int i3 = 0; i3 < 5; i3++) {
            getList().add(new MyCouponListItemViewModel(this.pagerId, "", "", "", new ShopCouponCouponShowStyleInfo(null, null, null, null, null, null, 63, null), 5));
        }
    }

    public static final void access$handleRspPageDataSuccess(MyCouponListViewModel myCouponListViewModel, ShopCouponGetUserCouponsRsp shopCouponGetUserCouponsRsp) {
        MyCouponDataStatus myCouponDataStatus;
        myCouponListViewModel.isLoading = false;
        myCouponListViewModel.isShowLoadMore = true;
        IPageRequestLogic<ShopCouponGetUserCouponsReq, ShopCouponGetUserCouponsRsp> iPageRequestLogic = myCouponListViewModel.pageReqLogic;
        if (iPageRequestLogic == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageReqLogic");
            iPageRequestLogic = null;
        }
        int i3 = 2;
        myCouponListViewModel.isLoadFinishing$delegate.setValue(myCouponListViewModel, $$delegatedProperties[2], Boolean.valueOf(iPageRequestLogic.isEnd()));
        ArrayList<ShopCouponUserCouponInfo> arrayList = shopCouponGetUserCouponsRsp.coupons;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        for (ShopCouponUserCouponInfo shopCouponUserCouponInfo : arrayList) {
            com.tencent.kuikly.core.reactive.collection.c<IMyCouponListItemViewModel> list = myCouponListViewModel.getList();
            ShopCouponCouponShowInfo shopCouponCouponShowInfo = shopCouponUserCouponInfo.couponShowInfo;
            int i16 = MyCouponListViewModelKt.access$isFutureCoupon(shopCouponUserCouponInfo, myCouponListViewModel.pagerId) ? i3 : myCouponListViewModel.getPageType().itemConfig;
            ArrayList arrayList2 = new ArrayList();
            ArrayList<ShopCouponCouponStyle> arrayList3 = shopCouponUserCouponInfo.couponStyle;
            if (arrayList3 != null) {
                for (ShopCouponCouponStyle shopCouponCouponStyle : arrayList3) {
                    String str = myCouponListViewModel.pagerId;
                    String str2 = shopCouponUserCouponInfo.couponBatchId;
                    String str3 = shopCouponCouponStyle.couponId;
                    String str4 = shopCouponCouponStyle.useCouponUrl;
                    ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = shopCouponCouponStyle.couponStyle;
                    if (shopCouponCouponShowStyleInfo == null) {
                        shopCouponCouponShowStyleInfo = new ShopCouponCouponShowStyleInfo(null, null, null, null, null, null, 63, null);
                    }
                    arrayList2.add(new MyCouponListItemViewModel(str, str2, str3, str4, shopCouponCouponShowStyleInfo, i16));
                }
            }
            list.addAll(arrayList2);
            i3 = 2;
        }
        if (myCouponListViewModel.getList().isEmpty()) {
            myCouponDataStatus = MyCouponDataStatus.NO_DATA;
        } else {
            myCouponDataStatus = MyCouponDataStatus.NORMAL;
        }
        myCouponListViewModel.couponDataStatus$delegate.setValue(myCouponListViewModel, $$delegatedProperties[3], myCouponDataStatus);
        myCouponListViewModel.refreshDisplayText(shopCouponGetUserCouponsRsp.total);
    }
}
