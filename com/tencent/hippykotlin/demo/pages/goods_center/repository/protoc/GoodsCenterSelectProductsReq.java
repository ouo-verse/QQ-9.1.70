package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GoodsCenterSelectProductsReq implements ISSOModel {
    public final GoodsCenterCategory cat;
    public final long categoryId;
    public final String cookie;
    public final GoodsCenterFilter filter;
    public final List<GoodsCenterFilterCond> filterCondList;
    public final String orderBy;
    public final int orderByType;
    public final String query;
    public final List<GoodsCenterRangeCond> rangeCond;

    public GoodsCenterSelectProductsReq() {
        this(null, null, null, null, 0, null, null, null, 0L, 511, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b a16 = o.a(eVar, "query", this.query);
        List<GoodsCenterFilterCond> list = this.filterCondList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a16.t(((GoodsCenterFilterCond) it.next()).encode());
            }
        }
        eVar.v("filter_cond_list", a16);
        GoodsCenterCategory goodsCenterCategory = this.cat;
        if (goodsCenterCategory != null) {
            eVar.v("cat", goodsCenterCategory.encode());
        }
        eVar.v("order_by", this.orderBy);
        eVar.t("order_by_type", this.orderByType);
        b a17 = o.a(eVar, "cookie", this.cookie);
        List<GoodsCenterRangeCond> list2 = this.rangeCond;
        if (list2 != null) {
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                a17.t(((GoodsCenterRangeCond) it5.next()).encode());
            }
        }
        eVar.v("range_cond", a17);
        GoodsCenterFilter goodsCenterFilter = this.filter;
        if (goodsCenterFilter != null) {
            eVar.v("filter", goodsCenterFilter.encode());
        }
        eVar.u(PictureConst.KEY_CATEGORY_ID, this.categoryId);
        return eVar;
    }

    public final int hashCode() {
        int hashCode = this.query.hashCode() * 31;
        List<GoodsCenterFilterCond> list = this.filterCondList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        GoodsCenterCategory goodsCenterCategory = this.cat;
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.cookie, QQAudioParams$$ExternalSyntheticOutline0.m(this.orderByType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.orderBy, (hashCode2 + (goodsCenterCategory == null ? 0 : goodsCenterCategory.hashCode())) * 31, 31), 31), 31);
        List<GoodsCenterRangeCond> list2 = this.rangeCond;
        int hashCode3 = (m3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        GoodsCenterFilter goodsCenterFilter = this.filter;
        return d.a(this.categoryId) + ((hashCode3 + (goodsCenterFilter != null ? goodsCenterFilter.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterSelectProductsReq(query=");
        m3.append(this.query);
        m3.append(", filterCondList=");
        m3.append(this.filterCondList);
        m3.append(", cat=");
        m3.append(this.cat);
        m3.append(", orderBy=");
        m3.append(this.orderBy);
        m3.append(", orderByType=");
        m3.append(this.orderByType);
        m3.append(", cookie=");
        m3.append(this.cookie);
        m3.append(", rangeCond=");
        m3.append(this.rangeCond);
        m3.append(", filter=");
        m3.append(this.filter);
        m3.append(", categoryId=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.categoryId, ')');
    }

    public GoodsCenterSelectProductsReq(String str, List<GoodsCenterFilterCond> list, GoodsCenterCategory goodsCenterCategory, String str2, int i3, String str3, List<GoodsCenterRangeCond> list2, GoodsCenterFilter goodsCenterFilter, long j3) {
        this.query = str;
        this.filterCondList = list;
        this.cat = goodsCenterCategory;
        this.orderBy = str2;
        this.orderByType = i3;
        this.cookie = str3;
        this.rangeCond = list2;
        this.filter = goodsCenterFilter;
        this.categoryId = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterSelectProductsReq)) {
            return false;
        }
        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq = (GoodsCenterSelectProductsReq) obj;
        return Intrinsics.areEqual(this.query, goodsCenterSelectProductsReq.query) && Intrinsics.areEqual(this.filterCondList, goodsCenterSelectProductsReq.filterCondList) && Intrinsics.areEqual(this.cat, goodsCenterSelectProductsReq.cat) && Intrinsics.areEqual(this.orderBy, goodsCenterSelectProductsReq.orderBy) && this.orderByType == goodsCenterSelectProductsReq.orderByType && Intrinsics.areEqual(this.cookie, goodsCenterSelectProductsReq.cookie) && Intrinsics.areEqual(this.rangeCond, goodsCenterSelectProductsReq.rangeCond) && Intrinsics.areEqual(this.filter, goodsCenterSelectProductsReq.filter) && this.categoryId == goodsCenterSelectProductsReq.categoryId;
    }

    public static GoodsCenterSelectProductsReq copy$default(GoodsCenterSelectProductsReq goodsCenterSelectProductsReq, String str, List list, GoodsCenterCategory goodsCenterCategory, String str2, int i3, List list2, int i16) {
        String str3 = (i16 & 1) != 0 ? goodsCenterSelectProductsReq.query : str;
        List list3 = (i16 & 2) != 0 ? goodsCenterSelectProductsReq.filterCondList : list;
        GoodsCenterCategory goodsCenterCategory2 = (i16 & 4) != 0 ? goodsCenterSelectProductsReq.cat : goodsCenterCategory;
        String str4 = (i16 & 8) != 0 ? goodsCenterSelectProductsReq.orderBy : str2;
        int i17 = (i16 & 16) != 0 ? goodsCenterSelectProductsReq.orderByType : i3;
        String str5 = (i16 & 32) != 0 ? goodsCenterSelectProductsReq.cookie : null;
        List list4 = (i16 & 64) != 0 ? goodsCenterSelectProductsReq.rangeCond : list2;
        GoodsCenterFilter goodsCenterFilter = (i16 & 128) != 0 ? goodsCenterSelectProductsReq.filter : null;
        long j3 = (i16 & 256) != 0 ? goodsCenterSelectProductsReq.categoryId : 0L;
        goodsCenterSelectProductsReq.getClass();
        return new GoodsCenterSelectProductsReq(str3, list3, goodsCenterCategory2, str4, i17, str5, list4, goodsCenterFilter, j3);
    }

    public /* synthetic */ GoodsCenterSelectProductsReq(String str, List list, GoodsCenterCategory goodsCenterCategory, String str2, int i3, String str3, List list2, GoodsCenterFilter goodsCenterFilter, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, null, "", 0, "", null, null, 0L);
    }
}
