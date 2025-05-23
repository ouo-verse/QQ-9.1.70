package com.tenpay.idverify.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/idverify/model/IdVerifyAddressBean;", "", "province", "", "city", "district", "detailAddress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getDetailAddress", "setDetailAddress", "getDistrict", "setDistrict", "getProvince", "setProvince", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class IdVerifyAddressBean {

    @Nullable
    private String city;

    @Nullable
    private String detailAddress;

    @Nullable
    private String district;

    @Nullable
    private String province;

    public IdVerifyAddressBean() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ IdVerifyAddressBean copy$default(IdVerifyAddressBean idVerifyAddressBean, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = idVerifyAddressBean.province;
        }
        if ((i3 & 2) != 0) {
            str2 = idVerifyAddressBean.city;
        }
        if ((i3 & 4) != 0) {
            str3 = idVerifyAddressBean.district;
        }
        if ((i3 & 8) != 0) {
            str4 = idVerifyAddressBean.detailAddress;
        }
        return idVerifyAddressBean.copy(str, str2, str3, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDetailAddress() {
        return this.detailAddress;
    }

    @NotNull
    public final IdVerifyAddressBean copy(@Nullable String province, @Nullable String city, @Nullable String district, @Nullable String detailAddress) {
        return new IdVerifyAddressBean(province, city, district, detailAddress);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdVerifyAddressBean)) {
            return false;
        }
        IdVerifyAddressBean idVerifyAddressBean = (IdVerifyAddressBean) other;
        if (Intrinsics.areEqual(this.province, idVerifyAddressBean.province) && Intrinsics.areEqual(this.city, idVerifyAddressBean.city) && Intrinsics.areEqual(this.district, idVerifyAddressBean.district) && Intrinsics.areEqual(this.detailAddress, idVerifyAddressBean.detailAddress)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Nullable
    public final String getDetailAddress() {
        return this.detailAddress;
    }

    @Nullable
    public final String getDistrict() {
        return this.district;
    }

    @Nullable
    public final String getProvince() {
        return this.province;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.province;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.city;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.district;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.detailAddress;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i18 + i3;
    }

    public final void setCity(@Nullable String str) {
        this.city = str;
    }

    public final void setDetailAddress(@Nullable String str) {
        this.detailAddress = str;
    }

    public final void setDistrict(@Nullable String str) {
        this.district = str;
    }

    public final void setProvince(@Nullable String str) {
        this.province = str;
    }

    @NotNull
    public String toString() {
        return "IdVerifyAddressBean(province=" + this.province + ", city=" + this.city + ", district=" + this.district + ", detailAddress=" + this.detailAddress + ")";
    }

    public IdVerifyAddressBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.province = str;
        this.city = str2;
        this.district = str3;
        this.detailAddress = str4;
    }

    public /* synthetic */ IdVerifyAddressBean(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4);
    }
}
