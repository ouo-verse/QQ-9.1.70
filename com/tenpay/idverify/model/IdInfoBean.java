package com.tenpay.idverify.model;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006%"}, d2 = {"Lcom/tenpay/idverify/model/IdInfoBean;", "", "name", "", "sex", "", "creType", "creId", "creBeginDate", "creEndDate", UserInfo.OCCUPATION, "address", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getCreBeginDate", "getCreEndDate", "getCreId", "getCreType", "()I", "getName", "getOccupation", "getSex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class IdInfoBean {

    @SerializedName("address")
    @NotNull
    private final String address;

    @SerializedName("cre_begin_date")
    @NotNull
    private final String creBeginDate;

    @SerializedName("cre_end_date")
    @NotNull
    private final String creEndDate;

    @SerializedName("cre_id")
    @NotNull
    private final String creId;

    @SerializedName("cre_type")
    private final int creType;

    @SerializedName("name")
    @NotNull
    private final String name;

    @SerializedName(UserInfo.OCCUPATION)
    @NotNull
    private final String occupation;

    @SerializedName("sex")
    private final int sex;

    public IdInfoBean(@NotNull String name, int i3, int i16, @NotNull String creId, @NotNull String creBeginDate, @NotNull String creEndDate, @NotNull String occupation, @NotNull String address) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(creId, "creId");
        Intrinsics.checkNotNullParameter(creBeginDate, "creBeginDate");
        Intrinsics.checkNotNullParameter(creEndDate, "creEndDate");
        Intrinsics.checkNotNullParameter(occupation, "occupation");
        Intrinsics.checkNotNullParameter(address, "address");
        this.name = name;
        this.sex = i3;
        this.creType = i16;
        this.creId = creId;
        this.creBeginDate = creBeginDate;
        this.creEndDate = creEndDate;
        this.occupation = occupation;
        this.address = address;
    }

    public static /* synthetic */ IdInfoBean copy$default(IdInfoBean idInfoBean, String str, int i3, int i16, String str2, String str3, String str4, String str5, String str6, int i17, Object obj) {
        String str7;
        int i18;
        int i19;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        if ((i17 & 1) != 0) {
            str7 = idInfoBean.name;
        } else {
            str7 = str;
        }
        if ((i17 & 2) != 0) {
            i18 = idInfoBean.sex;
        } else {
            i18 = i3;
        }
        if ((i17 & 4) != 0) {
            i19 = idInfoBean.creType;
        } else {
            i19 = i16;
        }
        if ((i17 & 8) != 0) {
            str8 = idInfoBean.creId;
        } else {
            str8 = str2;
        }
        if ((i17 & 16) != 0) {
            str9 = idInfoBean.creBeginDate;
        } else {
            str9 = str3;
        }
        if ((i17 & 32) != 0) {
            str10 = idInfoBean.creEndDate;
        } else {
            str10 = str4;
        }
        if ((i17 & 64) != 0) {
            str11 = idInfoBean.occupation;
        } else {
            str11 = str5;
        }
        if ((i17 & 128) != 0) {
            str12 = idInfoBean.address;
        } else {
            str12 = str6;
        }
        return idInfoBean.copy(str7, i18, i19, str8, str9, str10, str11, str12);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCreType() {
        return this.creType;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getCreId() {
        return this.creId;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getCreBeginDate() {
        return this.creBeginDate;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCreEndDate() {
        return this.creEndDate;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getOccupation() {
        return this.occupation;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final IdInfoBean copy(@NotNull String name, int sex, int creType, @NotNull String creId, @NotNull String creBeginDate, @NotNull String creEndDate, @NotNull String occupation, @NotNull String address) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(creId, "creId");
        Intrinsics.checkNotNullParameter(creBeginDate, "creBeginDate");
        Intrinsics.checkNotNullParameter(creEndDate, "creEndDate");
        Intrinsics.checkNotNullParameter(occupation, "occupation");
        Intrinsics.checkNotNullParameter(address, "address");
        return new IdInfoBean(name, sex, creType, creId, creBeginDate, creEndDate, occupation, address);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdInfoBean)) {
            return false;
        }
        IdInfoBean idInfoBean = (IdInfoBean) other;
        if (Intrinsics.areEqual(this.name, idInfoBean.name) && this.sex == idInfoBean.sex && this.creType == idInfoBean.creType && Intrinsics.areEqual(this.creId, idInfoBean.creId) && Intrinsics.areEqual(this.creBeginDate, idInfoBean.creBeginDate) && Intrinsics.areEqual(this.creEndDate, idInfoBean.creEndDate) && Intrinsics.areEqual(this.occupation, idInfoBean.occupation) && Intrinsics.areEqual(this.address, idInfoBean.address)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final String getCreBeginDate() {
        return this.creBeginDate;
    }

    @NotNull
    public final String getCreEndDate() {
        return this.creEndDate;
    }

    @NotNull
    public final String getCreId() {
        return this.creId;
    }

    public final int getCreType() {
        return this.creType;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getOccupation() {
        return this.occupation;
    }

    public final int getSex() {
        return this.sex;
    }

    public int hashCode() {
        return (((((((((((((this.name.hashCode() * 31) + this.sex) * 31) + this.creType) * 31) + this.creId.hashCode()) * 31) + this.creBeginDate.hashCode()) * 31) + this.creEndDate.hashCode()) * 31) + this.occupation.hashCode()) * 31) + this.address.hashCode();
    }

    @NotNull
    public String toString() {
        return "IdInfoBean(name=" + this.name + ", sex=" + this.sex + ", creType=" + this.creType + ", creId=" + this.creId + ", creBeginDate=" + this.creBeginDate + ", creEndDate=" + this.creEndDate + ", occupation=" + this.occupation + ", address=" + this.address + ")";
    }
}
