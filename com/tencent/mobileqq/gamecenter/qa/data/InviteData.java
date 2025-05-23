package com.tencent.mobileqq.gamecenter.qa.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/data/InviteData;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "name", "Ljava/lang/String;", "e", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "faceUrl", "c", "l", "desc", "a", "j", "isSelected", "Z", "g", "()Z", "o", "(Z)V", "officialDes", "f", DomainData.DOMAIN_NAME, "encodeUin", "b", "k", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class InviteData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<InviteData> CREATOR = new a();

    @SerializedName("desc")
    @NotNull
    private String desc;

    @SerializedName("encodeUin")
    @NotNull
    private String encodeUin;

    @SerializedName("faceUrl")
    @NotNull
    private String faceUrl;

    @SerializedName("isSelected")
    private boolean isSelected;

    @SerializedName("name")
    @NotNull
    private String name;

    @SerializedName("officialDes")
    @NotNull
    private String officialDes;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a implements Parcelable.Creator<InviteData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InviteData createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new InviteData(readString, readString2, readString3, z16, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final InviteData[] newArray(int i3) {
            return new InviteData[i3];
        }
    }

    public InviteData() {
        this(null, null, null, false, null, null, 63, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getEncodeUin() {
        return this.encodeUin;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteData)) {
            return false;
        }
        InviteData inviteData = (InviteData) other;
        if (Intrinsics.areEqual(this.name, inviteData.name) && Intrinsics.areEqual(this.faceUrl, inviteData.faceUrl) && Intrinsics.areEqual(this.desc, inviteData.desc) && this.isSelected == inviteData.isSelected && Intrinsics.areEqual(this.officialDes, inviteData.officialDes) && Intrinsics.areEqual(this.encodeUin, inviteData.encodeUin)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getOfficialDes() {
        return this.officialDes;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.faceUrl.hashCode()) * 31) + this.desc.hashCode()) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + this.officialDes.hashCode()) * 31) + this.encodeUin.hashCode();
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encodeUin = str;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.faceUrl = str;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.officialDes = str;
    }

    public final void o(boolean z16) {
        this.isSelected = z16;
    }

    @NotNull
    public String toString() {
        return "InviteData(name=" + this.name + ", faceUrl=" + this.faceUrl + ", desc=" + this.desc + ", isSelected=" + this.isSelected + ", officialDes=" + this.officialDes + ", encodeUin=" + this.encodeUin + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.faceUrl);
        parcel.writeString(this.desc);
        parcel.writeInt(this.isSelected ? 1 : 0);
        parcel.writeString(this.officialDes);
        parcel.writeString(this.encodeUin);
    }

    public InviteData(@NotNull String name, @NotNull String faceUrl, @NotNull String desc, boolean z16, @NotNull String officialDes, @NotNull String encodeUin) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(faceUrl, "faceUrl");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(officialDes, "officialDes");
        Intrinsics.checkNotNullParameter(encodeUin, "encodeUin");
        this.name = name;
        this.faceUrl = faceUrl;
        this.desc = desc;
        this.isSelected = z16;
        this.officialDes = officialDes;
        this.encodeUin = encodeUin;
    }

    public /* synthetic */ InviteData(String str, String str2, String str3, boolean z16, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5);
    }
}
