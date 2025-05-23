package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SkuInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ActiveSku activeSku;
    public final long createTime;
    public final SkuDynamic dynamic;
    public final ArrayList<PicInfo> previewPics;
    public final Price price;
    public final String skuId;
    public final int skuType;
    public final SpecInfo specInfo;
    public final String spuId;
    public final int status;
    public final long updateTime;

    public SkuInfo() {
        this(null, null, null, null, null, 0L, 0L, 0, 0, null, null, 2047, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("sku_id", this.skuId);
        eVar.v("spu_id", this.spuId);
        Price price = this.price;
        if (price != null) {
            eVar.v("price", price.encode());
        }
        b bVar = new b();
        ArrayList<PicInfo> arrayList = this.previewPics;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((PicInfo) it.next()).encode());
            }
        }
        eVar.v("preview_pics", bVar);
        SpecInfo specInfo = this.specInfo;
        if (specInfo != null) {
            eVar.v("spec_info", specInfo.encode());
        }
        eVar.u(AlbumCacheData.CREATE_TIME, this.createTime);
        eVar.u("update_time", this.updateTime);
        eVar.t("status", this.status);
        eVar.t("sku_type", this.skuType);
        SkuDynamic skuDynamic = this.dynamic;
        if (skuDynamic != null) {
            eVar.v(TabPreloadItem.TAB_NAME_DYNAMIC, skuDynamic.encode());
        }
        ActiveSku activeSku = this.activeSku;
        if (activeSku != null) {
            eVar.v("active_sku", activeSku.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.spuId, this.skuId.hashCode() * 31, 31);
        Price price = this.price;
        int hashCode = (m3 + (price == null ? 0 : price.hashCode())) * 31;
        ArrayList<PicInfo> arrayList = this.previewPics;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        SpecInfo specInfo = this.specInfo;
        int m16 = QQAudioParams$$ExternalSyntheticOutline0.m(this.skuType, QQAudioParams$$ExternalSyntheticOutline0.m(this.status, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.updateTime, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.createTime, (hashCode2 + (specInfo == null ? 0 : specInfo.hashCode())) * 31, 31), 31), 31), 31);
        SkuDynamic skuDynamic = this.dynamic;
        int hashCode3 = (m16 + (skuDynamic == null ? 0 : skuDynamic.hashCode())) * 31;
        ActiveSku activeSku = this.activeSku;
        return hashCode3 + (activeSku != null ? activeSku.hashCode() : 0);
    }

    public final String toString() {
        return "SkuInfo(skuId=" + this.skuId + ", spuId=" + this.spuId + ", price=" + this.price + ", previewPics=" + this.previewPics + ", specInfo=" + this.specInfo + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", status=" + this.status + ", skuType=" + this.skuType + ", dynamic=" + this.dynamic + ", activeSku=" + this.activeSku + ')';
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final SkuInfo decode(e eVar) {
            ArrayList arrayList;
            SpecInfo specInfo;
            int i3;
            SkuDynamic skuDynamic;
            BuyLimit buyLimit;
            ArrayList arrayList2;
            String q16 = eVar.q("sku_id", "");
            String q17 = eVar.q("spu_id", "");
            e m3 = eVar.m("price");
            Price price = m3 != null ? new Price(m3.q("origin_price_txt", ""), m3.q("price_txt", ""), m3.q("discount_price_txt", ""), m3.q("discount_price_desc", ""), m3.o("discount_price", 0L), m3.o("off_price", 0L)) : null;
            b l3 = eVar.l("preview_pics");
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i16 = 0; i16 < c16; i16++) {
                    Object d16 = l3.d(i16);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        arrayList.add(new PicInfo(eVar2.q("url", ""), eVar2.k("width", 0), eVar2.k("height", 0), eVar2.q("desc", ""), eVar2.q("thumbnail_url", ""), eVar2.k(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), eVar2.k(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0)));
                    }
                }
            } else {
                arrayList = null;
            }
            e m16 = eVar.m("spec_info");
            if (m16 != null) {
                b l16 = m16.l("items");
                if (l16 != null) {
                    arrayList2 = new ArrayList();
                    int c17 = l16.c();
                    for (int i17 = 0; i17 < c17; i17++) {
                        Object d17 = l16.d(i17);
                        if (d17 != null) {
                            Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            e eVar3 = (e) d17;
                            arrayList2.add(new SpecItem(eVar3.q("id", ""), eVar3.q("name", ""), eVar3.q("value", "")));
                        }
                    }
                } else {
                    arrayList2 = null;
                }
                specInfo = new SpecInfo(arrayList2);
            } else {
                specInfo = null;
            }
            long o16 = eVar.o(AlbumCacheData.CREATE_TIME, 0L);
            long o17 = eVar.o("update_time", 0L);
            int k3 = eVar.k("status", 0);
            int k16 = eVar.k("sku_type", 0);
            e m17 = eVar.m(TabPreloadItem.TAB_NAME_DYNAMIC);
            if (m17 != null) {
                String q18 = m17.q("stock", "");
                long o18 = m17.o("stock_nums", 0L);
                e m18 = m17.m("buy_limit");
                if (m18 != null) {
                    i3 = k3;
                    buyLimit = new BuyLimit(m18.k("user_daily_limit", 0));
                } else {
                    i3 = k3;
                    buyLimit = null;
                }
                skuDynamic = new SkuDynamic(q18, o18, buyLimit);
            } else {
                i3 = k3;
                skuDynamic = null;
            }
            e m19 = eVar.m("active_sku");
            return new SkuInfo(q16, q17, price, arrayList, specInfo, o16, o17, i3, k16, skuDynamic, m19 != null ? ActiveSku.Companion.decode(m19) : null);
        }
    }

    public SkuInfo(String str, String str2, Price price, ArrayList<PicInfo> arrayList, SpecInfo specInfo, long j3, long j16, int i3, int i16, SkuDynamic skuDynamic, ActiveSku activeSku) {
        this.skuId = str;
        this.spuId = str2;
        this.price = price;
        this.previewPics = arrayList;
        this.specInfo = specInfo;
        this.createTime = j3;
        this.updateTime = j16;
        this.status = i3;
        this.skuType = i16;
        this.dynamic = skuDynamic;
        this.activeSku = activeSku;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuInfo)) {
            return false;
        }
        SkuInfo skuInfo = (SkuInfo) obj;
        return Intrinsics.areEqual(this.skuId, skuInfo.skuId) && Intrinsics.areEqual(this.spuId, skuInfo.spuId) && Intrinsics.areEqual(this.price, skuInfo.price) && Intrinsics.areEqual(this.previewPics, skuInfo.previewPics) && Intrinsics.areEqual(this.specInfo, skuInfo.specInfo) && this.createTime == skuInfo.createTime && this.updateTime == skuInfo.updateTime && this.status == skuInfo.status && this.skuType == skuInfo.skuType && Intrinsics.areEqual(this.dynamic, skuInfo.dynamic) && Intrinsics.areEqual(this.activeSku, skuInfo.activeSku);
    }

    public /* synthetic */ SkuInfo(String str, String str2, Price price, ArrayList arrayList, SpecInfo specInfo, long j3, long j16, int i3, int i16, SkuDynamic skuDynamic, ActiveSku activeSku, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", null, null, null, 0L, 0L, 0, 0, null, null);
    }
}
