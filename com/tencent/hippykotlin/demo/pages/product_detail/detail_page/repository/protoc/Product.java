package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SkuInfo;
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
public final class Product implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final String brandId;
    public final ArrayList<ProductDetailPicInfo> carouselPictures;
    public final Category category;
    public final ProductDetailCommissionInfo commission;
    public final ArrayList<ProductDetailCoupon> coupons;
    public final long createTime;
    public final String desc;
    public final ArrayList<ProductDetailPicInfo> detailPictures;
    public final SpuDynamic dynamic;
    public final boolean hasCouponButton;
    public final ArrayList<ProductDetailLabelInfo> labels;
    public final ArrayList<ProductDetailPicInfo> mainPics;
    public final ProductDetailPendantInfo pendant;
    public final Price price;
    public final ArrayList<ProductDetailLabelInfo> prodTags;
    public final ProductDetailProductID productIdInfo;
    public final ArrayList<ProductDetailProperty> properties;
    public final ArrayList<SkuInfo> skuInfos;
    public final String spuId;
    public final String title;
    public final long updateTime;
    public final ArrayList<VideoPic> videoPic;
    public final int warmUpStatus;

    public Product() {
        this(null, null, null, null, null, null, null, null, null, 0L, 0L, false, null, null, null, null, null, null, 0, null, null, null, null, 8388607, null);
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
        ArrayList<VideoPic> arrayList2 = this.videoPic;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((VideoPic) it5.next()).encode());
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
        Category category = this.category;
        if (category != null) {
            eVar.v("category", category.encode());
        }
        eVar.u(AlbumCacheData.CREATE_TIME, this.createTime);
        eVar.u("update_time", this.updateTime);
        eVar.w("has_coupon_button", this.hasCouponButton);
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
        ArrayList<ProductDetailLabelInfo> arrayList7 = this.prodTags;
        if (arrayList7 != null) {
            Iterator<T> it10 = arrayList7.iterator();
            while (it10.hasNext()) {
                m19.t(((ProductDetailLabelInfo) it10.next()).encode());
            }
        }
        b m26 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "prod_tags", m19);
        ArrayList<ProductDetailCoupon> arrayList8 = this.coupons;
        if (arrayList8 != null) {
            Iterator<T> it11 = arrayList8.iterator();
            while (it11.hasNext()) {
                m26.t(((ProductDetailCoupon) it11.next()).encode());
            }
        }
        eVar.v("coupons", m26);
        eVar.v("brand_id", this.brandId);
        Price price = this.price;
        if (price != null) {
            eVar.v("price", price.encode());
        }
        eVar.t("warm_up_status", this.warmUpStatus);
        b bVar2 = new b();
        ArrayList<SkuInfo> arrayList9 = this.skuInfos;
        if (arrayList9 != null) {
            Iterator<T> it12 = arrayList9.iterator();
            while (it12.hasNext()) {
                bVar2.t(((SkuInfo) it12.next()).encode());
            }
        }
        eVar.v("sku_infos", bVar2);
        SpuDynamic spuDynamic = this.dynamic;
        if (spuDynamic != null) {
            eVar.v(TabPreloadItem.TAB_NAME_DYNAMIC, spuDynamic.encode());
        }
        ProductDetailCommissionInfo productDetailCommissionInfo = this.commission;
        if (productDetailCommissionInfo != null) {
            eVar.v("commission", productDetailCommissionInfo.encode());
        }
        ProductDetailProductID productDetailProductID = this.productIdInfo;
        if (productDetailProductID != null) {
            eVar.v("product_id_info", productDetailProductID.encode());
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.desc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, this.spuId.hashCode() * 31, 31), 31);
        ArrayList<ProductDetailProperty> arrayList = this.properties;
        int hashCode = (m3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<VideoPic> arrayList2 = this.videoPic;
        int hashCode2 = (hashCode + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<ProductDetailPicInfo> arrayList3 = this.carouselPictures;
        int hashCode3 = (hashCode2 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
        ArrayList<ProductDetailPicInfo> arrayList4 = this.mainPics;
        int hashCode4 = (hashCode3 + (arrayList4 == null ? 0 : arrayList4.hashCode())) * 31;
        ArrayList<ProductDetailPicInfo> arrayList5 = this.detailPictures;
        int hashCode5 = (hashCode4 + (arrayList5 == null ? 0 : arrayList5.hashCode())) * 31;
        Category category = this.category;
        int m16 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.updateTime, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.createTime, (hashCode5 + (category == null ? 0 : category.hashCode())) * 31, 31), 31);
        boolean z16 = this.hasCouponButton;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (m16 + i3) * 31;
        ProductDetailPendantInfo productDetailPendantInfo = this.pendant;
        int hashCode6 = (i16 + (productDetailPendantInfo == null ? 0 : productDetailPendantInfo.coverUrl.hashCode())) * 31;
        ArrayList<ProductDetailLabelInfo> arrayList6 = this.labels;
        int hashCode7 = (hashCode6 + (arrayList6 == null ? 0 : arrayList6.hashCode())) * 31;
        ArrayList<ProductDetailLabelInfo> arrayList7 = this.prodTags;
        int hashCode8 = (hashCode7 + (arrayList7 == null ? 0 : arrayList7.hashCode())) * 31;
        ArrayList<ProductDetailCoupon> arrayList8 = this.coupons;
        int m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.brandId, (hashCode8 + (arrayList8 == null ? 0 : arrayList8.hashCode())) * 31, 31);
        Price price = this.price;
        int m18 = QQAudioParams$$ExternalSyntheticOutline0.m(this.warmUpStatus, (m17 + (price == null ? 0 : price.hashCode())) * 31, 31);
        ArrayList<SkuInfo> arrayList9 = this.skuInfos;
        int hashCode9 = (m18 + (arrayList9 == null ? 0 : arrayList9.hashCode())) * 31;
        SpuDynamic spuDynamic = this.dynamic;
        int hashCode10 = (hashCode9 + (spuDynamic == null ? 0 : spuDynamic.hashCode())) * 31;
        ProductDetailCommissionInfo productDetailCommissionInfo = this.commission;
        int hashCode11 = (hashCode10 + (productDetailCommissionInfo == null ? 0 : productDetailCommissionInfo.hashCode())) * 31;
        ProductDetailProductID productDetailProductID = this.productIdInfo;
        return hashCode11 + (productDetailProductID != null ? productDetailProductID.hashCode() : 0);
    }

    public final String toString() {
        return "Product(spuId=" + this.spuId + ", title=" + this.title + ", desc=" + this.desc + ", properties=" + this.properties + ", videoPic=" + this.videoPic + ", carouselPictures=" + this.carouselPictures + ", mainPics=" + this.mainPics + ", detailPictures=" + this.detailPictures + ", category=" + this.category + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", hasCouponButton=" + this.hasCouponButton + ", pendant=" + this.pendant + ", labels=" + this.labels + ", prodTags=" + this.prodTags + ", coupons=" + this.coupons + ", brandId=" + this.brandId + ", price=" + this.price + ", warmUpStatus=" + this.warmUpStatus + ", skuInfos=" + this.skuInfos + ", dynamic=" + this.dynamic + ", commission=" + this.commission + ", productIdInfo=" + this.productIdInfo + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final Product decode(e eVar) {
            String str;
            ArrayList arrayList;
            String str2;
            String str3;
            ArrayList arrayList2;
            String str4;
            ArrayList arrayList3;
            ArrayList arrayList4;
            ArrayList arrayList5;
            ArrayList arrayList6;
            ArrayList arrayList7;
            ArrayList arrayList8;
            ArrayList arrayList9;
            String str5;
            String str6;
            String str7;
            ArrayList arrayList10;
            ArrayList arrayList11;
            ArrayList arrayList12;
            String str8;
            ArrayList arrayList13;
            ArrayList arrayList14;
            SpuDynamic spuDynamic;
            int i3;
            ProductDetailCommissionInfo productDetailCommissionInfo;
            String str9;
            String str10;
            String str11;
            b bVar;
            String str12;
            b bVar2;
            String str13;
            b bVar3;
            b bVar4;
            b bVar5;
            b bVar6;
            String str14;
            String str15;
            b bVar7;
            String str16;
            int i16;
            String q16 = eVar.q("spu_id", "");
            String q17 = eVar.q("title", "");
            String q18 = eVar.q("desc", "");
            b l3 = eVar.l(Constants.Service.PROPERTIES);
            String str17 = "id";
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                int i17 = 0;
                while (i17 < c16) {
                    Object d16 = l3.d(i17);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        bVar7 = l3;
                        i16 = c16;
                        str16 = q18;
                        arrayList.add(new ProductDetailProperty(eVar2.q("id", ""), eVar2.q("name", ""), eVar2.q("value", ""), eVar2.g("has_brand", false)));
                    } else {
                        bVar7 = l3;
                        str16 = q18;
                        i16 = c16;
                    }
                    i17++;
                    l3 = bVar7;
                    c16 = i16;
                    q18 = str16;
                }
                str = q18;
            } else {
                str = q18;
                arrayList = null;
            }
            b l16 = eVar.l("video_pic");
            if (l16 != null) {
                arrayList2 = new ArrayList();
                int c17 = l16.c();
                int i18 = 0;
                while (i18 < c17) {
                    Object d17 = l16.d(i18);
                    if (d17 != null) {
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar3 = (e) d17;
                        bVar6 = l16;
                        str14 = q16;
                        str15 = q17;
                        arrayList2.add(new VideoPic(eVar3.q("vid", ""), eVar3.q("url", ""), eVar3.k("type", 0), eVar3.o("duration", 0L), eVar3.q("cover", "")));
                    } else {
                        bVar6 = l16;
                        str14 = q16;
                        str15 = q17;
                    }
                    i18++;
                    l16 = bVar6;
                    q16 = str14;
                    q17 = str15;
                }
                str2 = q16;
                str3 = q17;
            } else {
                str2 = q16;
                str3 = q17;
                arrayList2 = null;
            }
            b l17 = eVar.l("carousel_pictures");
            if (l17 == null) {
                str4 = "type";
                arrayList3 = arrayList2;
                arrayList4 = arrayList;
                arrayList5 = null;
            } else {
                arrayList3 = arrayList2;
                arrayList5 = new ArrayList();
                arrayList4 = arrayList;
                int c18 = l17.c();
                str4 = "type";
                int i19 = 0;
                while (i19 < c18) {
                    int i26 = c18;
                    Object d18 = l17.d(i19);
                    if (d18 != null) {
                        Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar4 = (e) d18;
                        bVar5 = l17;
                        arrayList5.add(new ProductDetailPicInfo(eVar4.q("url", ""), eVar4.k("width", 0), eVar4.k("height", 0), eVar4.q("desc", ""), eVar4.q("thumbnail_url", ""), eVar4.k(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), eVar4.k(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0)));
                    } else {
                        bVar5 = l17;
                    }
                    i19++;
                    c18 = i26;
                    l17 = bVar5;
                }
            }
            b l18 = eVar.l("main_pics");
            if (l18 != null) {
                ArrayList arrayList15 = new ArrayList();
                int c19 = l18.c();
                arrayList6 = arrayList5;
                int i27 = 0;
                while (i27 < c19) {
                    int i28 = c19;
                    Object d19 = l18.d(i27);
                    if (d19 != null) {
                        Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar5 = (e) d19;
                        bVar4 = l18;
                        arrayList15.add(new ProductDetailPicInfo(eVar5.q("url", ""), eVar5.k("width", 0), eVar5.k("height", 0), eVar5.q("desc", ""), eVar5.q("thumbnail_url", ""), eVar5.k(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), eVar5.k(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0)));
                    } else {
                        bVar4 = l18;
                    }
                    i27++;
                    c19 = i28;
                    l18 = bVar4;
                }
                arrayList7 = arrayList15;
            } else {
                arrayList6 = arrayList5;
                arrayList7 = null;
            }
            b l19 = eVar.l("detail_pictures");
            if (l19 != null) {
                ArrayList arrayList16 = new ArrayList();
                int c26 = l19.c();
                arrayList8 = arrayList7;
                int i29 = 0;
                while (i29 < c26) {
                    int i36 = c26;
                    Object d26 = l19.d(i29);
                    if (d26 != null) {
                        Intrinsics.checkNotNull(d26, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar6 = (e) d26;
                        bVar3 = l19;
                        arrayList16.add(new ProductDetailPicInfo(eVar6.q("url", ""), eVar6.k("width", 0), eVar6.k("height", 0), eVar6.q("desc", ""), eVar6.q("thumbnail_url", ""), eVar6.k(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), eVar6.k(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0)));
                    } else {
                        bVar3 = l19;
                    }
                    i29++;
                    c26 = i36;
                    l19 = bVar3;
                }
                arrayList9 = arrayList16;
            } else {
                arrayList8 = arrayList7;
                arrayList9 = null;
            }
            e m3 = eVar.m("category");
            Category category = m3 != null ? new Category(m3.q("first_cat_id", ""), m3.q("first_cat_name", ""), m3.q("second_cat_id", ""), m3.q("second_cat_name", ""), m3.q("third_cat_id", ""), m3.q("third_cat_name", ""), m3.q("forth_cat_id", ""), m3.q("forth_cat_name", ""), m3.q("fifth_cat_id", ""), m3.q("fifth_cat_name", "")) : null;
            long o16 = eVar.o(AlbumCacheData.CREATE_TIME, 0L);
            long o17 = eVar.o("update_time", 0L);
            boolean g16 = eVar.g("has_coupon_button", false);
            e m16 = eVar.m(IndividuationUrlHelper.UrlId.PENDANT_HOME);
            ProductDetailPendantInfo productDetailPendantInfo = m16 != null ? new ProductDetailPendantInfo(m16.q("cover_url", "")) : null;
            b l26 = eVar.l("labels");
            String str18 = LayoutAttrDefine.BorderColor;
            Category category2 = category;
            if (l26 == null) {
                str5 = "desc";
                str6 = "name";
                str7 = "id";
                arrayList10 = arrayList9;
                arrayList11 = null;
            } else {
                arrayList10 = arrayList9;
                ArrayList arrayList17 = new ArrayList();
                str5 = "desc";
                int c27 = l26.c();
                str6 = "name";
                int i37 = 0;
                while (i37 < c27) {
                    int i38 = c27;
                    Object d27 = l26.d(i37);
                    if (d27 != null) {
                        Intrinsics.checkNotNull(d27, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar7 = (e) d27;
                        bVar2 = l26;
                        str13 = str17;
                        arrayList17.add(new ProductDetailLabelInfo(eVar7.q("background_color", ""), eVar7.q("text_color", ""), eVar7.q("text", ""), eVar7.q("text_prefix", ""), eVar7.k("text_style_type", 0), eVar7.q(LayoutAttrDefine.BorderColor, ""), eVar7.q("pic_url", ""), eVar7.k("width", 0), eVar7.k("height", 0), eVar7.q("pic_token", "")));
                    } else {
                        bVar2 = l26;
                        str13 = str17;
                    }
                    i37++;
                    c27 = i38;
                    l26 = bVar2;
                    str17 = str13;
                }
                str7 = str17;
                arrayList11 = arrayList17;
            }
            b l27 = eVar.l("prod_tags");
            if (l27 != null) {
                ArrayList arrayList18 = new ArrayList();
                int c28 = l27.c();
                int i39 = 0;
                while (i39 < c28) {
                    int i46 = c28;
                    Object d28 = l27.d(i39);
                    if (d28 != null) {
                        Intrinsics.checkNotNull(d28, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar8 = (e) d28;
                        bVar = l27;
                        str12 = str18;
                        arrayList18.add(new ProductDetailLabelInfo(eVar8.q("background_color", ""), eVar8.q("text_color", ""), eVar8.q("text", ""), eVar8.q("text_prefix", ""), eVar8.k("text_style_type", 0), eVar8.q(str18, ""), eVar8.q("pic_url", ""), eVar8.k("width", 0), eVar8.k("height", 0), eVar8.q("pic_token", "")));
                    } else {
                        bVar = l27;
                        str12 = str18;
                    }
                    i39++;
                    c28 = i46;
                    l27 = bVar;
                    str18 = str12;
                }
                arrayList12 = arrayList18;
            } else {
                arrayList12 = null;
            }
            b l28 = eVar.l("coupons");
            if (l28 != null) {
                ArrayList arrayList19 = new ArrayList();
                int c29 = l28.c();
                int i47 = 0;
                while (i47 < c29) {
                    Object d29 = l28.d(i47);
                    if (d29 != null) {
                        Intrinsics.checkNotNull(d29, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar9 = (e) d29;
                        str11 = str7;
                        str10 = str6;
                        str9 = str5;
                        arrayList19.add(new ProductDetailCoupon(eVar9.q(str11, ""), eVar9.q(str10, ""), eVar9.q(str9, "")));
                    } else {
                        str9 = str5;
                        str10 = str6;
                        str11 = str7;
                    }
                    i47++;
                    str7 = str11;
                    str6 = str10;
                    str5 = str9;
                }
                str8 = str7;
                arrayList13 = arrayList19;
            } else {
                str8 = str7;
                arrayList13 = null;
            }
            String q19 = eVar.q("brand_id", "");
            e m17 = eVar.m("price");
            Price price = m17 != null ? new Price(m17.q("origin_price_txt", ""), m17.q("price_txt", ""), m17.q("discount_price_txt", ""), m17.q("discount_price_desc", ""), m17.o("discount_price", 0L), m17.o("off_price", 0L)) : null;
            int k3 = eVar.k("warm_up_status", 0);
            b l29 = eVar.l("sku_infos");
            if (l29 != null) {
                ArrayList arrayList20 = new ArrayList();
                int c36 = l29.c();
                for (int i48 = 0; i48 < c36; i48++) {
                    Object d36 = l29.d(i48);
                    if (d36 != null) {
                        SkuInfo.Companion companion = SkuInfo.Companion;
                        Intrinsics.checkNotNull(d36, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList20.add(companion.decode((e) d36));
                    }
                }
                arrayList14 = arrayList20;
            } else {
                arrayList14 = null;
            }
            e m18 = eVar.m(TabPreloadItem.TAB_NAME_DYNAMIC);
            if (m18 != null) {
                String q26 = m18.q("stock", "");
                e m19 = m18.m("buy_limit");
                spuDynamic = new SpuDynamic(q26, m19 != null ? new BuyLimit(m19.k("user_daily_limit", 0)) : null, m18.q("sales", ""), m18.o("stock_num", 0L), m18.o("sales_num", 0L));
            } else {
                spuDynamic = null;
            }
            e m26 = eVar.m("commission");
            if (m26 != null) {
                i3 = 0;
                productDetailCommissionInfo = new ProductDetailCommissionInfo(m26.q("commission", ""), m26.q("commission_rate", ""), m26.q("commission_rate_txt", ""), m26.k("plan_type", 0));
            } else {
                i3 = 0;
                productDetailCommissionInfo = null;
            }
            e m27 = eVar.m("product_id_info");
            return new Product(str2, str3, str, arrayList4, arrayList3, arrayList6, arrayList8, arrayList10, category2, o16, o17, g16, productDetailPendantInfo, arrayList11, arrayList12, arrayList13, q19, price, k3, arrayList14, spuDynamic, productDetailCommissionInfo, m27 != null ? new ProductDetailProductID(m27.k(str4, i3), m27.q(str8, ""), m27.q("sub_type", "")) : null);
        }
    }

    public Product(String str, String str2, String str3, ArrayList<ProductDetailProperty> arrayList, ArrayList<VideoPic> arrayList2, ArrayList<ProductDetailPicInfo> arrayList3, ArrayList<ProductDetailPicInfo> arrayList4, ArrayList<ProductDetailPicInfo> arrayList5, Category category, long j3, long j16, boolean z16, ProductDetailPendantInfo productDetailPendantInfo, ArrayList<ProductDetailLabelInfo> arrayList6, ArrayList<ProductDetailLabelInfo> arrayList7, ArrayList<ProductDetailCoupon> arrayList8, String str4, Price price, int i3, ArrayList<SkuInfo> arrayList9, SpuDynamic spuDynamic, ProductDetailCommissionInfo productDetailCommissionInfo, ProductDetailProductID productDetailProductID) {
        this.spuId = str;
        this.title = str2;
        this.desc = str3;
        this.properties = arrayList;
        this.videoPic = arrayList2;
        this.carouselPictures = arrayList3;
        this.mainPics = arrayList4;
        this.detailPictures = arrayList5;
        this.category = category;
        this.createTime = j3;
        this.updateTime = j16;
        this.hasCouponButton = z16;
        this.pendant = productDetailPendantInfo;
        this.labels = arrayList6;
        this.prodTags = arrayList7;
        this.coupons = arrayList8;
        this.brandId = str4;
        this.price = price;
        this.warmUpStatus = i3;
        this.skuInfos = arrayList9;
        this.dynamic = spuDynamic;
        this.commission = productDetailCommissionInfo;
        this.productIdInfo = productDetailProductID;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return Intrinsics.areEqual(this.spuId, product.spuId) && Intrinsics.areEqual(this.title, product.title) && Intrinsics.areEqual(this.desc, product.desc) && Intrinsics.areEqual(this.properties, product.properties) && Intrinsics.areEqual(this.videoPic, product.videoPic) && Intrinsics.areEqual(this.carouselPictures, product.carouselPictures) && Intrinsics.areEqual(this.mainPics, product.mainPics) && Intrinsics.areEqual(this.detailPictures, product.detailPictures) && Intrinsics.areEqual(this.category, product.category) && this.createTime == product.createTime && this.updateTime == product.updateTime && this.hasCouponButton == product.hasCouponButton && Intrinsics.areEqual(this.pendant, product.pendant) && Intrinsics.areEqual(this.labels, product.labels) && Intrinsics.areEqual(this.prodTags, product.prodTags) && Intrinsics.areEqual(this.coupons, product.coupons) && Intrinsics.areEqual(this.brandId, product.brandId) && Intrinsics.areEqual(this.price, product.price) && this.warmUpStatus == product.warmUpStatus && Intrinsics.areEqual(this.skuInfos, product.skuInfos) && Intrinsics.areEqual(this.dynamic, product.dynamic) && Intrinsics.areEqual(this.commission, product.commission) && Intrinsics.areEqual(this.productIdInfo, product.productIdInfo);
    }

    public /* synthetic */ Product(String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, Category category, long j3, long j16, boolean z16, ProductDetailPendantInfo productDetailPendantInfo, ArrayList arrayList6, ArrayList arrayList7, ArrayList arrayList8, String str4, Price price, int i3, ArrayList arrayList9, SpuDynamic spuDynamic, ProductDetailCommissionInfo productDetailCommissionInfo, ProductDetailProductID productDetailProductID, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", null, null, null, null, null, null, 0L, 0L, false, null, null, null, null, "", null, 0, null, null, null, null);
    }
}
