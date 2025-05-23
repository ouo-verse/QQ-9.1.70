package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponQueryORConditon;
import com.tencent.kuikly.core.base.BaseObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ObtainCouponViewModel extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ObtainCouponViewModel.class, "pageState", "getPageState()Lcom/tencent/hippykotlin/demo/pages/shop_biz/shop_coupon_page/obtain_coupon/ObtainCouponViewModel$PageState;", 0)};
    public final String mediaId;
    public final String minimumPrice;
    public final ReadWriteProperty pageState$delegate = c.a(PageState.InitLoading.INSTANCE);
    public final ArrayList<ShopCouponQueryORConditon> queryCondition;
    public final int scene;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class PageState {

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class Empty extends PageState {
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class InitLoading extends PageState {
            public static final InitLoading INSTANCE = new InitLoading();

            public InitLoading() {
                super(null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class Loading extends PageState {
            public final String toString() {
                return "Loading(oldPageData=" + ((Object) null) + ')';
            }

            public final int hashCode() {
                throw null;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loading)) {
                    return false;
                }
                ((Loading) obj).getClass();
                return Intrinsics.areEqual((Object) null, (Object) null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class NetworkError extends PageState {
            public static final NetworkError INSTANCE = new NetworkError();

            public NetworkError() {
                super(null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static final class Succeed extends PageState {
            public final PageData pageData;

            public final int hashCode() {
                return this.pageData.hashCode();
            }

            public final String toString() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Succeed(pageData=");
                m3.append(this.pageData);
                m3.append(')');
                return m3.toString();
            }

            public Succeed(PageData pageData) {
                super(null);
                this.pageData = pageData;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Succeed) && Intrinsics.areEqual(this.pageData, ((Succeed) obj).pageData);
            }
        }

        public /* synthetic */ PageState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public PageState() {
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/ArrayList<Lcom/tencent/hippykotlin/demo/pages/shop_biz/shop_coupon_page/base/service/ShopCouponQueryORConditon;>;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V */
    public ObtainCouponViewModel(ArrayList arrayList, String str, String str2, int i3) {
        this.queryCondition = arrayList;
        this.minimumPrice = str;
        this.mediaId = str2;
        this.scene = i3;
    }

    public final PageState getPageState() {
        return (PageState) this.pageState$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setPageState(PageState pageState) {
        this.pageState$delegate.setValue(this, $$delegatedProperties[0], pageState);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class PageData {
        public final List<ObtainCouponItemModel> couponList;
        public final String minimumPrice;

        public PageData(List<ObtainCouponItemModel> list, String str) {
            this.couponList = list;
            this.minimumPrice = str;
        }

        public final int hashCode() {
            return this.minimumPrice.hashCode() + (this.couponList.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PageData(couponList=");
            m3.append(this.couponList);
            m3.append(", minimumPrice=");
            return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.minimumPrice, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageData)) {
                return false;
            }
            PageData pageData = (PageData) obj;
            return Intrinsics.areEqual(this.couponList, pageData.couponList) && Intrinsics.areEqual(this.minimumPrice, pageData.minimumPrice);
        }
    }
}
