package com.tencent.ecommerce.biz.orders.address;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001\u0010Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,Jw\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0012H\u00d6\u0001J\u0019\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u00d6\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010 R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010 \u00a8\u0006."}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "Landroid/os/Parcelable;", "", "id", "", "province", "city", "district", "street", "detailAddress", "consignee", MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "maskedPhoneNumber", "", "isDefaultAddress", "label", "a", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "J", "e", "Ljava/lang/String;", "f", h.F, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "Z", "G", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "H", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class ECAddress implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    public final String consignee;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    public final String phoneNumber;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    public final String maskedPhoneNumber;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    public final boolean isDefaultAddress;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    public final String label;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final long id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String province;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String city;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final String district;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final String street;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final String detailAddress;

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ECAddress> CREATOR = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddress$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "a", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.address.ECAddress$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECAddress a(JSONObject jsonObject) {
            if (jsonObject.has("id")) {
                return new ECAddress(jsonObject.optLong("id"), jsonObject.optString("province"), jsonObject.optString("city"), jsonObject.optString("district"), jsonObject.optString("street"), jsonObject.optString("detail_address"), jsonObject.optString("name"), jsonObject.optString(DeviceType.DeviceCategory.MOBILE), jsonObject.optString("masked_mobile"), jsonObject.optInt("is_default") == 1, jsonObject.optString("label"));
            }
            return null;
        }

        public final ECAddress b(JSONObject jsonObject) {
            if (jsonObject.has("id")) {
                return new ECAddress(Long.parseLong(jsonObject.optString("id")), jsonObject.optString("province"), jsonObject.optString("city"), jsonObject.optString("district"), jsonObject.optString("street"), jsonObject.optString("detail_address"), jsonObject.optString("name"), jsonObject.optString(DeviceType.DeviceCategory.MOBILE), jsonObject.optString("masked_mobile"), jsonObject.optInt("is_default") == 1, jsonObject.optString("label"));
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static class b implements Parcelable.Creator<ECAddress> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ECAddress createFromParcel(Parcel parcel) {
            return new ECAddress(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ECAddress[] newArray(int i3) {
            return new ECAddress[i3];
        }
    }

    public ECAddress(long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z16, String str9) {
        this.id = j3;
        this.province = str;
        this.city = str2;
        this.district = str3;
        this.street = str4;
        this.detailAddress = str5;
        this.consignee = str6;
        this.phoneNumber = str7;
        this.maskedPhoneNumber = str8;
        this.isDefaultAddress = z16;
        this.label = str9;
    }

    public final ECAddress a(long id5, String province, String city, String district, String street, String detailAddress, String consignee, String phoneNumber, String maskedPhoneNumber, boolean isDefaultAddress, String label) {
        return new ECAddress(id5, province, city, district, street, detailAddress, consignee, phoneNumber, maskedPhoneNumber, isDefaultAddress, label);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = com.tencent.ecommerce.biz.commission.forecast.b.a(this.id) * 31;
        String str = this.province;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.city;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.district;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.street;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.detailAddress;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.consignee;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.phoneNumber;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.maskedPhoneNumber;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z16 = this.isDefaultAddress;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode8 + i3) * 31;
        String str9 = this.label;
        return i16 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        return "ECAddress(id=" + this.id + ", province=" + this.province + ", city=" + this.city + ", district=" + this.district + ", street=" + this.street + ", detailAddress=" + this.detailAddress + ", consignee=" + this.consignee + ", phoneNumber=" + this.phoneNumber + ", maskedPhoneNumber=" + this.maskedPhoneNumber + ", isDefaultAddress=" + this.isDefaultAddress + ", label=" + this.label + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(this.id);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.district);
        parcel.writeString(this.street);
        parcel.writeString(this.detailAddress);
        parcel.writeString(this.consignee);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.maskedPhoneNumber);
        parcel.writeInt(this.isDefaultAddress ? 1 : 0);
        parcel.writeString(this.label);
    }

    public /* synthetic */ ECAddress(long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z16, String str9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, str, str2, str3, str4, str5, str6, str7, (i3 & 256) != 0 ? "" : str8, z16, (i3 & 1024) != 0 ? "" : str9);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAddress)) {
            return false;
        }
        ECAddress eCAddress = (ECAddress) other;
        return this.id == eCAddress.id && Intrinsics.areEqual(this.province, eCAddress.province) && Intrinsics.areEqual(this.city, eCAddress.city) && Intrinsics.areEqual(this.district, eCAddress.district) && Intrinsics.areEqual(this.street, eCAddress.street) && Intrinsics.areEqual(this.detailAddress, eCAddress.detailAddress) && Intrinsics.areEqual(this.consignee, eCAddress.consignee) && Intrinsics.areEqual(this.phoneNumber, eCAddress.phoneNumber) && Intrinsics.areEqual(this.maskedPhoneNumber, eCAddress.maskedPhoneNumber) && this.isDefaultAddress == eCAddress.isDefaultAddress && Intrinsics.areEqual(this.label, eCAddress.label);
    }
}
