package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailSkuInfo;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.raft.codegenmeta.utils.Constants;
import cooperation.peak.PeakConstants;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailProduct implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final String brandId;
    public final ArrayList<ProductDetailPicInfo> carouselPictures;
    public final ProductDetailCategory category;
    public final ProductDetailCommissionInfo commission;
    public final ArrayList<ProductDetailCoupon> coupons;
    public final long createTime;
    public final String desc;
    public final ArrayList<ProductDetailPicInfo> detailPictures;
    public final ArrayList<ProductDetailLabelInfo> discountLabels;
    public final ProductDetailSpuDynamic dynamic;
    public final ArrayList<ProductDetailLabelInfo> labels;
    public final ArrayList<ProductDetailPicInfo> mainPics;
    public final ProductDetailPendantInfo pendant;
    public final ProductDetailPrice price;
    public final ArrayList<ProductDetailLabelInfo> prodTags;
    public final ProductDetailProductID productIdInfo;
    public final ArrayList<ProductDetailProperty> properties;
    public final ArrayList<ProductDetailSkuInfo> skuInfos;
    public final String spuId;
    public final String title;
    public final ProductDetailProductTradeInfo tradeInfo;
    public final long updateTime;
    public final ArrayList<ProductDetailVideoPic> videoPic;

    public ProductDetailProduct() {
        this(null, null, null, null, null, null, null, null, null, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("spu_id", this.spuId);
        eVar.v("title", this.title);
        b a16 = o.a(eVar, "desc", this.desc);
        ArrayList<ProductDetailProperty> arrayList = this.properties;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t(((ProductDetailProperty) it.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, Constants.Service.PROPERTIES, a16);
        ArrayList<ProductDetailVideoPic> arrayList2 = this.videoPic;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((ProductDetailVideoPic) it5.next()).encode());
            }
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "video_pic", m3);
        ArrayList<ProductDetailPicInfo> arrayList3 = this.carouselPictures;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                m16.t(((ProductDetailPicInfo) it6.next()).encode());
            }
        }
        b m17 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "carousel_pictures", m16);
        ArrayList<ProductDetailPicInfo> arrayList4 = this.mainPics;
        if (arrayList4 != null) {
            Iterator<T> it7 = arrayList4.iterator();
            while (it7.hasNext()) {
                m17.t(((ProductDetailPicInfo) it7.next()).encode());
            }
        }
        b m18 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "main_pics", m17);
        ArrayList<ProductDetailPicInfo> arrayList5 = this.detailPictures;
        if (arrayList5 != null) {
            Iterator<T> it8 = arrayList5.iterator();
            while (it8.hasNext()) {
                m18.t(((ProductDetailPicInfo) it8.next()).encode());
            }
        }
        eVar.v("detail_pictures", m18);
        ProductDetailCategory productDetailCategory = this.category;
        if (productDetailCategory != null) {
            eVar.v("category", productDetailCategory.encode());
        }
        eVar.u(AlbumCacheData.CREATE_TIME, this.createTime);
        eVar.u("update_time", this.updateTime);
        ProductDetailPendantInfo productDetailPendantInfo = this.pendant;
        if (productDetailPendantInfo != null) {
            eVar.v(IndividuationUrlHelper.UrlId.PENDANT_HOME, productDetailPendantInfo.encode());
        }
        b bVar = new b();
        ArrayList<ProductDetailLabelInfo> arrayList6 = this.labels;
        if (arrayList6 != null) {
            Iterator<T> it9 = arrayList6.iterator();
            while (it9.hasNext()) {
                bVar.t(((ProductDetailLabelInfo) it9.next()).encode());
            }
        }
        b m19 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "labels", bVar);
        ArrayList<ProductDetailLabelInfo> arrayList7 = this.discountLabels;
        if (arrayList7 != null) {
            Iterator<T> it10 = arrayList7.iterator();
            while (it10.hasNext()) {
                m19.t(((ProductDetailLabelInfo) it10.next()).encode());
            }
        }
        b m26 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "discount_labels", m19);
        ArrayList<ProductDetailCoupon> arrayList8 = this.coupons;
        if (arrayList8 != null) {
            Iterator<T> it11 = arrayList8.iterator();
            while (it11.hasNext()) {
                m26.t(((ProductDetailCoupon) it11.next()).encode());
            }
        }
        eVar.v("coupons", m26);
        eVar.v("brand_id", this.brandId);
        ProductDetailPrice productDetailPrice = this.price;
        if (productDetailPrice != null) {
            eVar.v("price", productDetailPrice.encode());
        }
        ProductDetailProductTradeInfo productDetailProductTradeInfo = this.tradeInfo;
        if (productDetailProductTradeInfo != null) {
            eVar.v("trade_info", productDetailProductTradeInfo.encode());
        }
        b bVar2 = new b();
        ArrayList<ProductDetailSkuInfo> arrayList9 = this.skuInfos;
        if (arrayList9 != null) {
            Iterator<T> it12 = arrayList9.iterator();
            while (it12.hasNext()) {
                bVar2.t(((ProductDetailSkuInfo) it12.next()).encode());
            }
        }
        eVar.v("sku_infos", bVar2);
        ProductDetailSpuDynamic productDetailSpuDynamic = this.dynamic;
        if (productDetailSpuDynamic != null) {
            eVar.v(TabPreloadItem.TAB_NAME_DYNAMIC, productDetailSpuDynamic.encode());
        }
        ProductDetailCommissionInfo productDetailCommissionInfo = this.commission;
        if (productDetailCommissionInfo != null) {
            eVar.v("commission", productDetailCommissionInfo.encode());
        }
        ProductDetailProductID productDetailProductID = this.productIdInfo;
        if (productDetailProductID != null) {
            eVar.v("product_id_info", productDetailProductID.encode());
        }
        b bVar3 = new b();
        ArrayList<ProductDetailLabelInfo> arrayList10 = this.prodTags;
        if (arrayList10 != null) {
            Iterator<T> it13 = arrayList10.iterator();
            while (it13.hasNext()) {
                bVar3.t(((ProductDetailLabelInfo) it13.next()).encode());
            }
        }
        eVar.v("prod_tags", bVar3);
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.desc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, this.spuId.hashCode() * 31, 31), 31);
        ArrayList<ProductDetailProperty> arrayList = this.properties;
        int hashCode = (m3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<ProductDetailVideoPic> arrayList2 = this.videoPic;
        int hashCode2 = (hashCode + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<ProductDetailPicInfo> arrayList3 = this.carouselPictures;
        int hashCode3 = (hashCode2 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
        ArrayList<ProductDetailPicInfo> arrayList4 = this.mainPics;
        int hashCode4 = (hashCode3 + (arrayList4 == null ? 0 : arrayList4.hashCode())) * 31;
        ArrayList<ProductDetailPicInfo> arrayList5 = this.detailPictures;
        int hashCode5 = (hashCode4 + (arrayList5 == null ? 0 : arrayList5.hashCode())) * 31;
        ProductDetailCategory productDetailCategory = this.category;
        int m16 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.updateTime, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.createTime, (hashCode5 + (productDetailCategory == null ? 0 : productDetailCategory.hashCode())) * 31, 31), 31);
        ProductDetailPendantInfo productDetailPendantInfo = this.pendant;
        int hashCode6 = (m16 + (productDetailPendantInfo == null ? 0 : productDetailPendantInfo.coverUrl.hashCode())) * 31;
        ArrayList<ProductDetailLabelInfo> arrayList6 = this.labels;
        int hashCode7 = (hashCode6 + (arrayList6 == null ? 0 : arrayList6.hashCode())) * 31;
        ArrayList<ProductDetailLabelInfo> arrayList7 = this.discountLabels;
        int hashCode8 = (hashCode7 + (arrayList7 == null ? 0 : arrayList7.hashCode())) * 31;
        ArrayList<ProductDetailCoupon> arrayList8 = this.coupons;
        int m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.brandId, (hashCode8 + (arrayList8 == null ? 0 : arrayList8.hashCode())) * 31, 31);
        ProductDetailPrice productDetailPrice = this.price;
        int hashCode9 = (m17 + (productDetailPrice == null ? 0 : productDetailPrice.hashCode())) * 31;
        ProductDetailProductTradeInfo productDetailProductTradeInfo = this.tradeInfo;
        int hashCode10 = (hashCode9 + (productDetailProductTradeInfo == null ? 0 : productDetailProductTradeInfo.hashCode())) * 31;
        ArrayList<ProductDetailSkuInfo> arrayList9 = this.skuInfos;
        int hashCode11 = (hashCode10 + (arrayList9 == null ? 0 : arrayList9.hashCode())) * 31;
        ProductDetailSpuDynamic productDetailSpuDynamic = this.dynamic;
        int hashCode12 = (hashCode11 + (productDetailSpuDynamic == null ? 0 : productDetailSpuDynamic.hashCode())) * 31;
        ProductDetailCommissionInfo productDetailCommissionInfo = this.commission;
        int hashCode13 = (hashCode12 + (productDetailCommissionInfo == null ? 0 : productDetailCommissionInfo.hashCode())) * 31;
        ProductDetailProductID productDetailProductID = this.productIdInfo;
        int hashCode14 = (hashCode13 + (productDetailProductID == null ? 0 : productDetailProductID.hashCode())) * 31;
        ArrayList<ProductDetailLabelInfo> arrayList10 = this.prodTags;
        return hashCode14 + (arrayList10 != null ? arrayList10.hashCode() : 0);
    }

    public final String toString() {
        return "ProductDetailProduct(spuId=" + this.spuId + ", title=" + this.title + ", desc=" + this.desc + ", properties=" + this.properties + ", videoPic=" + this.videoPic + ", carouselPictures=" + this.carouselPictures + ", mainPics=" + this.mainPics + ", detailPictures=" + this.detailPictures + ", category=" + this.category + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", pendant=" + this.pendant + ", labels=" + this.labels + ", discountLabels=" + this.discountLabels + ", coupons=" + this.coupons + ", brandId=" + this.brandId + ", price=" + this.price + ", tradeInfo=" + this.tradeInfo + ", skuInfos=" + this.skuInfos + ", dynamic=" + this.dynamic + ", commission=" + this.commission + ", productIdInfo=" + this.productIdInfo + ", prodTags=" + this.prodTags + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final ProductDetailProduct decode(e eVar) {
            ArrayList arrayList;
            ArrayList arrayList2;
            String str;
            String str2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            ArrayList arrayList5;
            ArrayList arrayList6;
            ArrayList arrayList7;
            ArrayList arrayList8;
            String str3;
            ArrayList arrayList9;
            ArrayList arrayList10;
            ArrayList arrayList11;
            ArrayList arrayList12;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            ArrayList arrayList13;
            String str9;
            ProductDetailPrice productDetailPrice;
            String str10;
            String str11;
            String str12;
            ProductDetailProductTradeInfo productDetailProductTradeInfo;
            ArrayList arrayList14;
            ProductDetailSpuDynamic productDetailSpuDynamic;
            int i3;
            ProductDetailCommissionInfo productDetailCommissionInfo;
            ArrayList arrayList15;
            b bVar;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            b bVar2;
            String str18;
            String str19;
            String str20;
            String str21;
            b bVar3;
            b bVar4;
            b bVar5;
            b bVar6;
            b bVar7;
            b bVar8;
            int i16;
            b bVar9;
            int i17;
            String q16 = eVar.q("spu_id", "");
            String q17 = eVar.q("title", "");
            String q18 = eVar.q("desc", "");
            b l3 = eVar.l(Constants.Service.PROPERTIES);
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                int i18 = 0;
                while (i18 < c16) {
                    Object d16 = l3.d(i18);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        bVar9 = l3;
                        i17 = c16;
                        arrayList.add(new ProductDetailProperty(eVar2.q("id", ""), eVar2.q("name", ""), eVar2.q("value", ""), eVar2.g("has_brand", false)));
                    } else {
                        bVar9 = l3;
                        i17 = c16;
                    }
                    i18++;
                    l3 = bVar9;
                    c16 = i17;
                }
            } else {
                arrayList = null;
            }
            b l16 = eVar.l("video_pic");
            if (l16 != null) {
                arrayList2 = new ArrayList();
                int c17 = l16.c();
                int i19 = 0;
                while (i19 < c17) {
                    Object d17 = l16.d(i19);
                    if (d17 != null) {
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar3 = (e) d17;
                        bVar8 = l16;
                        i16 = c17;
                        arrayList2.add(new ProductDetailVideoPic(eVar3.q("vid", ""), eVar3.q("url", ""), eVar3.k("type", 0), eVar3.o("duration", 0L), eVar3.q("cover", "")));
                    } else {
                        bVar8 = l16;
                        i16 = c17;
                    }
                    i19++;
                    l16 = bVar8;
                    c17 = i16;
                }
            } else {
                arrayList2 = null;
            }
            b l17 = eVar.l("carousel_pictures");
            String str22 = "height";
            ArrayList arrayList16 = arrayList2;
            String str23 = "width";
            if (l17 != null) {
                arrayList3 = arrayList;
                arrayList4 = new ArrayList();
                str2 = q18;
                int c18 = l17.c();
                str = q17;
                int i26 = 0;
                while (i26 < c18) {
                    int i27 = c18;
                    Object d18 = l17.d(i26);
                    if (d18 != null) {
                        Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar4 = (e) d18;
                        bVar7 = l17;
                        arrayList4.add(new ProductDetailPicInfo(eVar4.q("url", ""), eVar4.k("width", 0), eVar4.k("height", 0), eVar4.q("desc", ""), eVar4.q("thumbnail_url", ""), eVar4.k(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), eVar4.k(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0)));
                    } else {
                        bVar7 = l17;
                    }
                    i26++;
                    c18 = i27;
                    l17 = bVar7;
                }
            } else {
                str = q17;
                str2 = q18;
                arrayList3 = arrayList;
                arrayList4 = null;
            }
            b l18 = eVar.l("main_pics");
            if (l18 != null) {
                ArrayList arrayList17 = new ArrayList();
                int c19 = l18.c();
                arrayList5 = arrayList4;
                int i28 = 0;
                while (i28 < c19) {
                    int i29 = c19;
                    Object d19 = l18.d(i28);
                    if (d19 != null) {
                        Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar5 = (e) d19;
                        bVar6 = l18;
                        arrayList17.add(new ProductDetailPicInfo(eVar5.q("url", ""), eVar5.k("width", 0), eVar5.k("height", 0), eVar5.q("desc", ""), eVar5.q("thumbnail_url", ""), eVar5.k(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), eVar5.k(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0)));
                    } else {
                        bVar6 = l18;
                    }
                    i28++;
                    c19 = i29;
                    l18 = bVar6;
                }
                arrayList6 = arrayList17;
            } else {
                arrayList5 = arrayList4;
                arrayList6 = null;
            }
            b l19 = eVar.l("detail_pictures");
            if (l19 != null) {
                ArrayList arrayList18 = new ArrayList();
                int c26 = l19.c();
                arrayList7 = arrayList6;
                int i36 = 0;
                while (i36 < c26) {
                    int i37 = c26;
                    Object d26 = l19.d(i36);
                    if (d26 != null) {
                        Intrinsics.checkNotNull(d26, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar6 = (e) d26;
                        bVar5 = l19;
                        arrayList18.add(new ProductDetailPicInfo(eVar6.q("url", ""), eVar6.k("width", 0), eVar6.k("height", 0), eVar6.q("desc", ""), eVar6.q("thumbnail_url", ""), eVar6.k(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), eVar6.k(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0)));
                    } else {
                        bVar5 = l19;
                    }
                    i36++;
                    c26 = i37;
                    l19 = bVar5;
                }
                arrayList8 = arrayList18;
            } else {
                arrayList7 = arrayList6;
                arrayList8 = null;
            }
            e m3 = eVar.m("category");
            ProductDetailCategory productDetailCategory = m3 != null ? new ProductDetailCategory(m3.q("first_cat_id", ""), m3.q("first_cat_name", ""), m3.q("second_cat_id", ""), m3.q("second_cat_name", ""), m3.q("third_cat_id", ""), m3.q("third_cat_name", ""), m3.q("forth_cat_id", ""), m3.q("forth_cat_name", ""), m3.q("fifth_cat_id", ""), m3.q("fifth_cat_name", "")) : null;
            long o16 = eVar.o(AlbumCacheData.CREATE_TIME, 0L);
            long o17 = eVar.o("update_time", 0L);
            e m16 = eVar.m(IndividuationUrlHelper.UrlId.PENDANT_HOME);
            ProductDetailPendantInfo productDetailPendantInfo = m16 != null ? new ProductDetailPendantInfo(m16.q("cover_url", "")) : null;
            b l26 = eVar.l("labels");
            String str24 = "pic_url";
            ProductDetailCategory productDetailCategory2 = productDetailCategory;
            ArrayList arrayList19 = arrayList8;
            if (l26 == null) {
                str3 = "id";
                arrayList9 = null;
            } else {
                arrayList9 = new ArrayList();
                str3 = "id";
                int c27 = l26.c();
                int i38 = 0;
                while (i38 < c27) {
                    int i39 = c27;
                    Object d27 = l26.d(i38);
                    if (d27 != null) {
                        Intrinsics.checkNotNull(d27, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar7 = (e) d27;
                        bVar4 = l26;
                        arrayList9.add(new ProductDetailLabelInfo(eVar7.q("background_color", ""), eVar7.q("text_color", ""), eVar7.q("text", ""), eVar7.q("text_prefix", ""), eVar7.k("text_style_type", 0), eVar7.q(LayoutAttrDefine.BorderColor, ""), eVar7.q("pic_url", ""), eVar7.k("width", 0), eVar7.k("height", 0), eVar7.q("pic_token", "")));
                    } else {
                        bVar4 = l26;
                    }
                    i38++;
                    c27 = i39;
                    l26 = bVar4;
                }
            }
            b l27 = eVar.l("discount_labels");
            if (l27 != null) {
                ArrayList arrayList20 = new ArrayList();
                arrayList10 = arrayList9;
                int c28 = l27.c();
                int i46 = 0;
                while (i46 < c28) {
                    int i47 = c28;
                    Object d28 = l27.d(i46);
                    if (d28 != null) {
                        Intrinsics.checkNotNull(d28, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar8 = (e) d28;
                        bVar3 = l27;
                        arrayList20.add(new ProductDetailLabelInfo(eVar8.q("background_color", ""), eVar8.q("text_color", ""), eVar8.q("text", ""), eVar8.q("text_prefix", ""), eVar8.k("text_style_type", 0), eVar8.q(LayoutAttrDefine.BorderColor, ""), eVar8.q("pic_url", ""), eVar8.k("width", 0), eVar8.k("height", 0), eVar8.q("pic_token", "")));
                    } else {
                        bVar3 = l27;
                    }
                    i46++;
                    c28 = i47;
                    l27 = bVar3;
                }
                arrayList11 = arrayList20;
            } else {
                arrayList10 = arrayList9;
                arrayList11 = null;
            }
            b l28 = eVar.l("coupons");
            if (l28 == null) {
                arrayList12 = arrayList11;
                str4 = "pic_token";
                str5 = "pic_url";
                str6 = "width";
                str7 = str3;
                str8 = "height";
                arrayList13 = null;
            } else {
                ArrayList arrayList21 = new ArrayList();
                arrayList12 = arrayList11;
                int c29 = l28.c();
                str4 = "pic_token";
                int i48 = 0;
                while (i48 < c29) {
                    int i49 = c29;
                    Object d29 = l28.d(i48);
                    if (d29 != null) {
                        Intrinsics.checkNotNull(d29, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar9 = (e) d29;
                        bVar2 = l28;
                        str20 = str3;
                        str21 = str22;
                        str19 = str23;
                        str18 = str24;
                        arrayList21.add(new ProductDetailCoupon(eVar9.q(str20, ""), eVar9.q("name", ""), eVar9.q("desc", "")));
                    } else {
                        bVar2 = l28;
                        str18 = str24;
                        str19 = str23;
                        str20 = str3;
                        str21 = str22;
                    }
                    i48++;
                    str22 = str21;
                    c29 = i49;
                    str23 = str19;
                    str24 = str18;
                    str3 = str20;
                    l28 = bVar2;
                }
                str5 = str24;
                str6 = str23;
                str7 = str3;
                str8 = str22;
                arrayList13 = arrayList21;
            }
            String q19 = eVar.q("brand_id", "");
            e m17 = eVar.m("price");
            if (m17 == null) {
                str9 = LayoutAttrDefine.BorderColor;
                productDetailPrice = null;
            } else {
                String q26 = m17.q("origin_price_txt", "");
                String q27 = m17.q("discount_price_txt", "");
                String q28 = m17.q("price_txt", "");
                str9 = LayoutAttrDefine.BorderColor;
                productDetailPrice = new ProductDetailPrice(q26, q27, q28, m17.o("discount_price", 0L), m17.q("discount_price_desc", ""));
            }
            e m18 = eVar.m("trade_info");
            if (m18 != null) {
                str10 = "text_color";
                str11 = "text_style_type";
                str12 = "text_prefix";
                productDetailProductTradeInfo = new ProductDetailProductTradeInfo(m18.k("delivery_mode", 0), m18.o("presale_end_time", 0L), m18.k("has_end_time", 0));
            } else {
                str10 = "text_color";
                str11 = "text_style_type";
                str12 = "text_prefix";
                productDetailProductTradeInfo = null;
            }
            b l29 = eVar.l("sku_infos");
            if (l29 != null) {
                ArrayList arrayList22 = new ArrayList();
                int c36 = l29.c();
                for (int i56 = 0; i56 < c36; i56++) {
                    Object d36 = l29.d(i56);
                    if (d36 != null) {
                        ProductDetailSkuInfo.Companion companion = ProductDetailSkuInfo.Companion;
                        Intrinsics.checkNotNull(d36, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList22.add(companion.decode((e) d36));
                    }
                }
                arrayList14 = arrayList22;
            } else {
                arrayList14 = null;
            }
            e m19 = eVar.m(TabPreloadItem.TAB_NAME_DYNAMIC);
            if (m19 != null) {
                String q29 = m19.q("stock", "");
                e m26 = m19.m("buy_limit");
                productDetailSpuDynamic = new ProductDetailSpuDynamic(q29, m26 != null ? new ProductDetailBuyLimit(m26.k("user_daily_limit", 0)) : null, m19.q("sales", ""), m19.o("stock_num", 0L), m19.o("sales_num", 0L));
            } else {
                productDetailSpuDynamic = null;
            }
            e m27 = eVar.m("commission");
            if (m27 != null) {
                i3 = 0;
                productDetailCommissionInfo = new ProductDetailCommissionInfo(m27.q("commission", ""), m27.q("commission_rate", ""), m27.q("commission_rate_txt", ""), m27.k("plan_type", 0));
            } else {
                i3 = 0;
                productDetailCommissionInfo = null;
            }
            e m28 = eVar.m("product_id_info");
            ProductDetailProductID productDetailProductID = m28 != null ? new ProductDetailProductID(m28.k("type", i3), m28.q(str7, ""), m28.q("sub_type", "")) : null;
            b l36 = eVar.l("prod_tags");
            if (l36 != null) {
                ArrayList arrayList23 = new ArrayList();
                int c37 = l36.c();
                int i57 = 0;
                while (i57 < c37) {
                    Object d37 = l36.d(i57);
                    if (d37 != null) {
                        Intrinsics.checkNotNull(d37, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar10 = (e) d37;
                        str17 = str10;
                        str16 = str12;
                        str13 = str11;
                        bVar = l36;
                        str14 = str8;
                        str15 = str4;
                        arrayList23.add(new ProductDetailLabelInfo(eVar10.q("background_color", ""), eVar10.q(str17, ""), eVar10.q("text", ""), eVar10.q(str16, ""), eVar10.k(str13, 0), eVar10.q(str9, ""), eVar10.q(str5, ""), eVar10.k(str6, 0), eVar10.k(str14, 0), eVar10.q(str15, "")));
                    } else {
                        bVar = l36;
                        str13 = str11;
                        str14 = str8;
                        str15 = str4;
                        str16 = str12;
                        str17 = str10;
                    }
                    i57++;
                    str8 = str14;
                    str10 = str17;
                    str12 = str16;
                    str4 = str15;
                    l36 = bVar;
                    str11 = str13;
                }
                arrayList15 = arrayList23;
            } else {
                arrayList15 = null;
            }
            return new ProductDetailProduct(q16, str, str2, arrayList3, arrayList16, arrayList5, arrayList7, arrayList19, productDetailCategory2, o16, o17, productDetailPendantInfo, arrayList10, arrayList12, arrayList13, q19, productDetailPrice, productDetailProductTradeInfo, arrayList14, productDetailSpuDynamic, productDetailCommissionInfo, productDetailProductID, arrayList15);
        }
    }

    public ProductDetailProduct(String str, String str2, String str3, ArrayList<ProductDetailProperty> arrayList, ArrayList<ProductDetailVideoPic> arrayList2, ArrayList<ProductDetailPicInfo> arrayList3, ArrayList<ProductDetailPicInfo> arrayList4, ArrayList<ProductDetailPicInfo> arrayList5, ProductDetailCategory productDetailCategory, long j3, long j16, ProductDetailPendantInfo productDetailPendantInfo, ArrayList<ProductDetailLabelInfo> arrayList6, ArrayList<ProductDetailLabelInfo> arrayList7, ArrayList<ProductDetailCoupon> arrayList8, String str4, ProductDetailPrice productDetailPrice, ProductDetailProductTradeInfo productDetailProductTradeInfo, ArrayList<ProductDetailSkuInfo> arrayList9, ProductDetailSpuDynamic productDetailSpuDynamic, ProductDetailCommissionInfo productDetailCommissionInfo, ProductDetailProductID productDetailProductID, ArrayList<ProductDetailLabelInfo> arrayList10) {
        this.spuId = str;
        this.title = str2;
        this.desc = str3;
        this.properties = arrayList;
        this.videoPic = arrayList2;
        this.carouselPictures = arrayList3;
        this.mainPics = arrayList4;
        this.detailPictures = arrayList5;
        this.category = productDetailCategory;
        this.createTime = j3;
        this.updateTime = j16;
        this.pendant = productDetailPendantInfo;
        this.labels = arrayList6;
        this.discountLabels = arrayList7;
        this.coupons = arrayList8;
        this.brandId = str4;
        this.price = productDetailPrice;
        this.tradeInfo = productDetailProductTradeInfo;
        this.skuInfos = arrayList9;
        this.dynamic = productDetailSpuDynamic;
        this.commission = productDetailCommissionInfo;
        this.productIdInfo = productDetailProductID;
        this.prodTags = arrayList10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailProduct)) {
            return false;
        }
        ProductDetailProduct productDetailProduct = (ProductDetailProduct) obj;
        return Intrinsics.areEqual(this.spuId, productDetailProduct.spuId) && Intrinsics.areEqual(this.title, productDetailProduct.title) && Intrinsics.areEqual(this.desc, productDetailProduct.desc) && Intrinsics.areEqual(this.properties, productDetailProduct.properties) && Intrinsics.areEqual(this.videoPic, productDetailProduct.videoPic) && Intrinsics.areEqual(this.carouselPictures, productDetailProduct.carouselPictures) && Intrinsics.areEqual(this.mainPics, productDetailProduct.mainPics) && Intrinsics.areEqual(this.detailPictures, productDetailProduct.detailPictures) && Intrinsics.areEqual(this.category, productDetailProduct.category) && this.createTime == productDetailProduct.createTime && this.updateTime == productDetailProduct.updateTime && Intrinsics.areEqual(this.pendant, productDetailProduct.pendant) && Intrinsics.areEqual(this.labels, productDetailProduct.labels) && Intrinsics.areEqual(this.discountLabels, productDetailProduct.discountLabels) && Intrinsics.areEqual(this.coupons, productDetailProduct.coupons) && Intrinsics.areEqual(this.brandId, productDetailProduct.brandId) && Intrinsics.areEqual(this.price, productDetailProduct.price) && Intrinsics.areEqual(this.tradeInfo, productDetailProduct.tradeInfo) && Intrinsics.areEqual(this.skuInfos, productDetailProduct.skuInfos) && Intrinsics.areEqual(this.dynamic, productDetailProduct.dynamic) && Intrinsics.areEqual(this.commission, productDetailProduct.commission) && Intrinsics.areEqual(this.productIdInfo, productDetailProduct.productIdInfo) && Intrinsics.areEqual(this.prodTags, productDetailProduct.prodTags);
    }

    public /* synthetic */ ProductDetailProduct(String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ProductDetailCategory productDetailCategory, long j3, long j16, ProductDetailPendantInfo productDetailPendantInfo, ArrayList arrayList6, ArrayList arrayList7, ArrayList arrayList8, String str4, ProductDetailPrice productDetailPrice, ProductDetailProductTradeInfo productDetailProductTradeInfo, ArrayList arrayList9, ProductDetailSpuDynamic productDetailSpuDynamic, ProductDetailCommissionInfo productDetailCommissionInfo, ProductDetailProductID productDetailProductID, ArrayList arrayList10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", null, null, null, null, null, null, 0L, 0L, null, null, null, null, "", null, null, null, null, null, null, null);
    }
}
