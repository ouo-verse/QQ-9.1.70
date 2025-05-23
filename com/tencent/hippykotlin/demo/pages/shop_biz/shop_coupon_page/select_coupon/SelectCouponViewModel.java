package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import c01.c;
import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponInfo;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SelectCouponViewModel extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SelectCouponViewModel.class, "pageState", "getPageState()Lcom/tencent/hippykotlin/demo/pages/shop_biz/shop_coupon_page/select_coupon/SelectCouponViewModel$PageState;", 0)};
    public final BridgeModule bridgeModule;
    public PageData currentPageData;
    public final k notifyModule;
    public final ReadWriteProperty pageState$delegate;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class PageState {
        public final boolean showTitle;

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class Loading extends PageState {
            public final boolean needShowTitle;
            public final PageData oldPageData;

            /* JADX WARN: Multi-variable type inference failed */
            public final int hashCode() {
                int hashCode = this.oldPageData.hashCode() * 31;
                boolean z16 = this.needShowTitle;
                int i3 = z16;
                if (z16 != 0) {
                    i3 = 1;
                }
                return hashCode + i3;
            }

            public final String toString() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Loading(oldPageData=");
                m3.append(this.oldPageData);
                m3.append(", needShowTitle=");
                return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.needShowTitle, ')');
            }

            public Loading(PageData pageData, boolean z16) {
                super(z16, null);
                this.oldPageData = pageData;
                this.needShowTitle = z16;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loading)) {
                    return false;
                }
                Loading loading = (Loading) obj;
                return Intrinsics.areEqual(this.oldPageData, loading.oldPageData) && this.needShowTitle == loading.needShowTitle;
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class Succeed extends PageState {
            public final boolean needShowTitle;
            public final PageData pageData;

            /* JADX WARN: Multi-variable type inference failed */
            public final int hashCode() {
                int hashCode = this.pageData.hashCode() * 31;
                boolean z16 = this.needShowTitle;
                int i3 = z16;
                if (z16 != 0) {
                    i3 = 1;
                }
                return hashCode + i3;
            }

            public final String toString() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Succeed(pageData=");
                m3.append(this.pageData);
                m3.append(", needShowTitle=");
                return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.needShowTitle, ')');
            }

            public Succeed(PageData pageData, boolean z16) {
                super(z16, null);
                this.pageData = pageData;
                this.needShowTitle = z16;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Succeed)) {
                    return false;
                }
                Succeed succeed = (Succeed) obj;
                return Intrinsics.areEqual(this.pageData, succeed.pageData) && this.needShowTitle == succeed.needShowTitle;
            }
        }

        public /* synthetic */ PageState(boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16);
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class Empty extends PageState {
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(false, null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class InitLoading extends PageState {
            public static final InitLoading INSTANCE = new InitLoading();

            public InitLoading() {
                super(false, null);
            }
        }

        public PageState(boolean z16) {
            this.showTitle = z16;
        }
    }

    public SelectCouponViewModel(BridgeModule bridgeModule, k kVar) {
        this.bridgeModule = bridgeModule;
        this.notifyModule = kVar;
        if (kVar != null) {
            k.b(kVar, "select_coupon_info_cached_updated", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponViewModel.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    SelectCouponViewModel.this.refreshPage();
                    return Unit.INSTANCE;
                }
            }, 2, null);
        }
        if (kVar != null) {
            k.b(kVar, "select_coupon_fail", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponViewModel.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    SelectCouponViewModel.this.bridgeModule.toast("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                    return Unit.INSTANCE;
                }
            }, 2, null);
        }
        this.pageState$delegate = c.a(PageState.InitLoading.INSTANCE);
    }

    public final List<CouponItem> getAllSelectedCoupon(List<? extends SelectCouponItemModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof CouponItem) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((CouponItem) obj2).isSelected) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    public final PageState getPageState() {
        return (PageState) this.pageState$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void notifyCouponSelected(List<String> list) {
        b bVar = new b();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            bVar.t((String) it.next());
        }
        k kVar = this.notifyModule;
        if (kVar != null) {
            e eVar = new e();
            eVar.v("ids", bVar);
            Unit unit = Unit.INSTANCE;
            k.d(kVar, "select_coupon_event", eVar, false, 4, null);
        }
    }

    public final void refreshPage() {
        try {
            e eVar = new e(this.bridgeModule.getCachedFromNative("select_coupon_info"));
            ShopCouponCouponInfo decode = ShopCouponCouponInfo.Companion.decode(eVar);
            updatePageDataWithPageData(new PageData(eVar.p("seller_id"), SelectCouponItemModelKt.toCouponItemList(decode), decode.isBestDiscount, decode.discountPrice));
        } catch (JSONException e16) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("selectCoupon parse data error, e=");
            m3.append(e16.getMessage());
            utils.logToNative(m3.toString());
            updatePageDataWithPageData(null);
        }
    }

    public final void setPageState(PageState pageState) {
        this.pageState$delegate.setValue(this, $$delegatedProperties[0], pageState);
    }

    public final boolean shouldShowTitleInList(List<? extends SelectCouponItemModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof CouponItem) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((CouponItem) it.next()).commonCouponItem.isEnabled) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void updatePageDataWithPageData(PageData pageData) {
        List<SelectCouponItemModel> list;
        if (pageData != null && !pageData.list.isEmpty()) {
            this.currentPageData = pageData;
            setPageState(new PageState.Succeed(pageData, shouldShowTitleInList(pageData.list)));
            return;
        }
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updatePageDataWithPageData: size = ");
        m3.append((pageData == null || (list = pageData.list) == null) ? null : Integer.valueOf(list.size()));
        utils.logToNative(m3.toString());
        this.currentPageData = null;
        setPageState(PageState.Empty.INSTANCE);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class PageData {
        public final long discountPrice;
        public final boolean isBestDiscount;
        public final List<SelectCouponItemModel> list;
        public final String sellerId;

        /* JADX WARN: Multi-variable type inference failed */
        public PageData(String str, List<? extends SelectCouponItemModel> list, boolean z16, long j3) {
            this.sellerId = str;
            this.list = list;
            this.isBestDiscount = z16;
            this.discountPrice = j3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = (this.list.hashCode() + (this.sellerId.hashCode() * 31)) * 31;
            boolean z16 = this.isBestDiscount;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return d.a(this.discountPrice) + ((hashCode + i3) * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PageData(sellerId=");
            m3.append(this.sellerId);
            m3.append(", list=");
            m3.append(this.list);
            m3.append(", isBestDiscount=");
            m3.append(this.isBestDiscount);
            m3.append(", discountPrice=");
            return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.discountPrice, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageData)) {
                return false;
            }
            PageData pageData = (PageData) obj;
            return Intrinsics.areEqual(this.sellerId, pageData.sellerId) && Intrinsics.areEqual(this.list, pageData.list) && this.isBestDiscount == pageData.isBestDiscount && this.discountPrice == pageData.discountPrice;
        }
    }
}
