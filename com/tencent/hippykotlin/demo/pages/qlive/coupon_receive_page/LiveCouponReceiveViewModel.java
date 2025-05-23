package com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponRetItem;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LiveCouponReceiveViewModel extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponReceiveViewModel.class, "couponReceiveState", "getCouponReceiveState()Lcom/tencent/hippykotlin/demo/pages/qlive/coupon_receive_page/LiveCouponReceiveViewModel$CouponReceiveState;", 0)};
    public b couponBatchIdArray;
    public final ReadWriteProperty couponReceiveState$delegate = c.a(CouponReceiveState.Loading.INSTANCE);
    public final String pagerId;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static abstract class CouponReceiveState {

        /* compiled from: P */
        /* loaded from: classes31.dex */
        public static final class ClosePageWithEventAndMsg extends CouponReceiveState {
            public final int couponsNum;

            /* renamed from: msg, reason: collision with root package name */
            public final String f114247msg;

            public final int hashCode() {
                return this.couponsNum + (this.f114247msg.hashCode() * 31);
            }

            public final String toString() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ClosePageWithEventAndMsg(msg=");
                m3.append(this.f114247msg);
                m3.append(", couponsNum=");
                return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.couponsNum, ')');
            }

            public ClosePageWithEventAndMsg(String str, int i3) {
                super(null);
                this.f114247msg = str;
                this.couponsNum = i3;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ClosePageWithEventAndMsg)) {
                    return false;
                }
                ClosePageWithEventAndMsg closePageWithEventAndMsg = (ClosePageWithEventAndMsg) obj;
                return Intrinsics.areEqual(this.f114247msg, closePageWithEventAndMsg.f114247msg) && this.couponsNum == closePageWithEventAndMsg.couponsNum;
            }
        }

        /* compiled from: P */
        /* loaded from: classes31.dex */
        public static final class ClosePageWithMsg extends CouponReceiveState {

            /* renamed from: msg, reason: collision with root package name */
            public final String f114248msg;

            public final int hashCode() {
                return this.f114248msg.hashCode();
            }

            public final String toString() {
                return LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ClosePageWithMsg(msg="), this.f114248msg, ')');
            }

            public ClosePageWithMsg(String str) {
                super(null);
                this.f114248msg = str;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ClosePageWithMsg) && Intrinsics.areEqual(this.f114248msg, ((ClosePageWithMsg) obj).f114248msg);
            }
        }

        /* compiled from: P */
        /* loaded from: classes31.dex */
        public static final class Loading extends CouponReceiveState {
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes31.dex */
        public static final class Success extends CouponReceiveState {
            public final ShopCouponCouponRetItem couponRetItem;
            public final int couponsNum;

            public final int hashCode() {
                return this.couponsNum + (this.couponRetItem.hashCode() * 31);
            }

            public final String toString() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Success(couponRetItem=");
                m3.append(this.couponRetItem);
                m3.append(", couponsNum=");
                return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.couponsNum, ')');
            }

            public Success(ShopCouponCouponRetItem shopCouponCouponRetItem, int i3) {
                super(null);
                this.couponRetItem = shopCouponCouponRetItem;
                this.couponsNum = i3;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.couponRetItem, success.couponRetItem) && this.couponsNum == success.couponsNum;
            }
        }

        public /* synthetic */ CouponReceiveState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public CouponReceiveState() {
        }
    }

    public LiveCouponReceiveViewModel(String str) {
        this.pagerId = str;
    }

    public final CouponReceiveState getCouponReceiveState() {
        return (CouponReceiveState) this.couponReceiveState$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setCouponReceiveState(CouponReceiveState couponReceiveState) {
        this.couponReceiveState$delegate.setValue(this, $$delegatedProperties[0], couponReceiveState);
    }
}
