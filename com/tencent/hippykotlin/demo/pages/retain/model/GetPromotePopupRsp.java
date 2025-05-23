package com.tencent.hippykotlin.demo.pages.retain.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.retain.model.ActiveLabelInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class GetPromotePopupRsp implements ISSOModel {
    public static final Companion Companion = new Companion();
    public static final ISSOModelFactory<GetPromotePopupRsp> Factory = new ISSOModelFactory<GetPromotePopupRsp>() { // from class: com.tencent.hippykotlin.demo.pages.retain.model.GetPromotePopupRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final GetPromotePopupRsp decode(e eVar) {
            return GetPromotePopupRsp.Companion.decode(eVar);
        }
    };
    public final ArrayList<ActiveLabelInfo> activeLables;
    public final Button button;
    public final ArrayList<CouponLabelInfo> couponLables;
    public final Labelheader header;
    public final int type;

    /* loaded from: classes33.dex */
    public static final class Companion {
        public final GetPromotePopupRsp decode(e eVar) {
            ArrayList arrayList;
            ArrayList arrayList2;
            int k3 = eVar.k("type", 0);
            e m3 = eVar.m("header");
            Labelheader labelheader = m3 != null ? new Labelheader(m3.q("top_text", ""), m3.q("countdown_text", ""), m3.o(StateEvent.Name.COUNTDOWN_TIME, 0L)) : null;
            b l3 = eVar.l("coupon_lables");
            if (l3 != null) {
                ArrayList arrayList3 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e m16 = ((e) d16).m("coupon_show_info");
                        arrayList3.add(new CouponLabelInfo(m16 != null ? ShopCouponCouponShowInfo.Companion.decode(m16) : null));
                    }
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            b l16 = eVar.l("active_lables");
            if (l16 != null) {
                ArrayList arrayList4 = new ArrayList();
                int c17 = l16.c();
                for (int i16 = 0; i16 < c17; i16++) {
                    Object d17 = l16.d(i16);
                    if (d17 != null) {
                        ActiveLabelInfo.Companion companion = ActiveLabelInfo.Companion;
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList4.add(companion.decode((e) d17));
                    }
                }
                arrayList2 = arrayList4;
            } else {
                arrayList2 = null;
            }
            e m17 = eVar.m("button");
            return new GetPromotePopupRsp(k3, labelheader, arrayList, arrayList2, m17 != null ? new Button(m17.q("left_text", ""), m17.q("right_text", ""), m17.q("right_jumpurl", "")) : null);
        }
    }

    public GetPromotePopupRsp() {
        this(0, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("type", this.type);
        Labelheader labelheader = this.header;
        if (labelheader != null) {
            eVar.v("header", labelheader.encode());
        }
        b bVar = new b();
        ArrayList<CouponLabelInfo> arrayList = this.couponLables;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((CouponLabelInfo) it.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "coupon_lables", bVar);
        ArrayList<ActiveLabelInfo> arrayList2 = this.activeLables;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((ActiveLabelInfo) it5.next()).encode());
            }
        }
        eVar.v("active_lables", m3);
        Button button = this.button;
        if (button != null) {
            eVar.v("button", button.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int i3 = this.type * 31;
        Labelheader labelheader = this.header;
        int hashCode = (i3 + (labelheader == null ? 0 : labelheader.hashCode())) * 31;
        ArrayList<CouponLabelInfo> arrayList = this.couponLables;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<ActiveLabelInfo> arrayList2 = this.activeLables;
        int hashCode3 = (hashCode2 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        Button button = this.button;
        return hashCode3 + (button != null ? button.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GetPromotePopupRsp(type=");
        m3.append(this.type);
        m3.append(", header=");
        m3.append(this.header);
        m3.append(", couponLables=");
        m3.append(this.couponLables);
        m3.append(", activeLables=");
        m3.append(this.activeLables);
        m3.append(", button=");
        m3.append(this.button);
        m3.append(')');
        return m3.toString();
    }

    public GetPromotePopupRsp(int i3, Labelheader labelheader, ArrayList<CouponLabelInfo> arrayList, ArrayList<ActiveLabelInfo> arrayList2, Button button) {
        this.type = i3;
        this.header = labelheader;
        this.couponLables = arrayList;
        this.activeLables = arrayList2;
        this.button = button;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPromotePopupRsp)) {
            return false;
        }
        GetPromotePopupRsp getPromotePopupRsp = (GetPromotePopupRsp) obj;
        return this.type == getPromotePopupRsp.type && Intrinsics.areEqual(this.header, getPromotePopupRsp.header) && Intrinsics.areEqual(this.couponLables, getPromotePopupRsp.couponLables) && Intrinsics.areEqual(this.activeLables, getPromotePopupRsp.activeLables) && Intrinsics.areEqual(this.button, getPromotePopupRsp.button);
    }

    public /* synthetic */ GetPromotePopupRsp(int i3, Labelheader labelheader, ArrayList arrayList, ArrayList arrayList2, Button button, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null, null, null, null);
    }
}
