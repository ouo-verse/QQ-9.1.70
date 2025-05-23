package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import com.google.gson.annotations.SerializedName;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u00a2\u0006\u0002\u0010\u0010J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u00c6\u0003Jw\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\bH\u00d6\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProduct;", "", "carouselPictures", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductPic;", "mainPics", "detailPictures", "title", "", "spuId", "price", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductPrice;", "specifications", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotSpecification;", Constants.Service.PROPERTIES, "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductProp;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductPrice;Ljava/util/List;Ljava/util/List;)V", "getCarouselPictures", "()Ljava/util/List;", "getDetailPictures", "getMainPics", "getProperties", "getSpecifications", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotProduct {

    @SerializedName("carousel_pictures")
    private final List<SnapshotProductPic> carouselPictures;

    @SerializedName("detail_pictures")
    private final List<SnapshotProductPic> detailPictures;

    @SerializedName("main_pics")
    private final List<SnapshotProductPic> mainPics;
    public final SnapshotProductPrice price;
    private final List<SnapshotProductProp> properties;
    private final List<SnapshotSpecification> specifications;

    @SerializedName("spu_id")
    public final String spuId;
    public final String title;

    public SnapshotProduct(List<SnapshotProductPic> list, List<SnapshotProductPic> list2, List<SnapshotProductPic> list3, String str, String str2, SnapshotProductPrice snapshotProductPrice, List<SnapshotSpecification> list4, List<SnapshotProductProp> list5) {
        this.carouselPictures = list;
        this.mainPics = list2;
        this.detailPictures = list3;
        this.title = str;
        this.spuId = str2;
        this.price = snapshotProductPrice;
        this.specifications = list4;
        this.properties = list5;
    }

    public final List<SnapshotProductPic> component1() {
        return this.carouselPictures;
    }

    public final List<SnapshotProductPic> component2() {
        return this.mainPics;
    }

    public final List<SnapshotProductPic> component3() {
        return this.detailPictures;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSpuId() {
        return this.spuId;
    }

    /* renamed from: component6, reason: from getter */
    public final SnapshotProductPrice getPrice() {
        return this.price;
    }

    public final List<SnapshotSpecification> component7() {
        return this.specifications;
    }

    public final List<SnapshotProductProp> component8() {
        return this.properties;
    }

    public final SnapshotProduct copy(List<SnapshotProductPic> carouselPictures, List<SnapshotProductPic> mainPics, List<SnapshotProductPic> detailPictures, String title, String spuId, SnapshotProductPrice price, List<SnapshotSpecification> specifications, List<SnapshotProductProp> properties) {
        return new SnapshotProduct(carouselPictures, mainPics, detailPictures, title, spuId, price, specifications, properties);
    }

    public final List<SnapshotProductPic> getCarouselPictures() {
        return this.carouselPictures;
    }

    public final List<SnapshotProductPic> getDetailPictures() {
        return this.detailPictures;
    }

    public final List<SnapshotProductPic> getMainPics() {
        return this.mainPics;
    }

    public final List<SnapshotProductProp> getProperties() {
        return this.properties;
    }

    public final List<SnapshotSpecification> getSpecifications() {
        return this.specifications;
    }

    public int hashCode() {
        List<SnapshotProductPic> list = this.carouselPictures;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<SnapshotProductPic> list2 = this.mainPics;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<SnapshotProductPic> list3 = this.detailPictures;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str = this.title;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.spuId;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        SnapshotProductPrice snapshotProductPrice = this.price;
        int hashCode6 = (hashCode5 + (snapshotProductPrice != null ? snapshotProductPrice.hashCode() : 0)) * 31;
        List<SnapshotSpecification> list4 = this.specifications;
        int hashCode7 = (hashCode6 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<SnapshotProductProp> list5 = this.properties;
        return hashCode7 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotProduct(carouselPictures=" + this.carouselPictures + ", mainPics=" + this.mainPics + ", detailPictures=" + this.detailPictures + ", title=" + this.title + ", spuId=" + this.spuId + ", price=" + this.price + ", specifications=" + this.specifications + ", properties=" + this.properties + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapshotProduct)) {
            return false;
        }
        SnapshotProduct snapshotProduct = (SnapshotProduct) other;
        return Intrinsics.areEqual(this.carouselPictures, snapshotProduct.carouselPictures) && Intrinsics.areEqual(this.mainPics, snapshotProduct.mainPics) && Intrinsics.areEqual(this.detailPictures, snapshotProduct.detailPictures) && Intrinsics.areEqual(this.title, snapshotProduct.title) && Intrinsics.areEqual(this.spuId, snapshotProduct.spuId) && Intrinsics.areEqual(this.price, snapshotProduct.price) && Intrinsics.areEqual(this.specifications, snapshotProduct.specifications) && Intrinsics.areEqual(this.properties, snapshotProduct.properties);
    }
}
