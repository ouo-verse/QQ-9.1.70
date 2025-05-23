package com.tencent.mobileqq.guild.setting.guildinfo;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\"\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "e", "a", "desc", "f", "Z", "b", "()Z", "c", "(Z)V", "isExpand", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class ProfileRuleData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String desc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isExpand;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildinfo.ProfileRuleData$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<ProfileRuleData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProfileRuleData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProfileRuleData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProfileRuleData[] newArray(int size) {
            return new ProfileRuleData[size];
        }

        Companion() {
        }
    }

    public ProfileRuleData(@NotNull String title, @Nullable String str, boolean z16) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.desc = str;
        this.isExpand = z16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsExpand() {
        return this.isExpand;
    }

    public final void c(boolean z16) {
        this.isExpand = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileRuleData)) {
            return false;
        }
        ProfileRuleData profileRuleData = (ProfileRuleData) other;
        if (Intrinsics.areEqual(this.title, profileRuleData.title) && Intrinsics.areEqual(this.desc, profileRuleData.desc) && this.isExpand == profileRuleData.isExpand) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.title.hashCode() * 31;
        String str = this.desc;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.isExpand;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "ProfileRuleData(title=" + this.title + ", desc=" + this.desc + ", isExpand=" + this.isExpand + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeByte(this.isExpand ? (byte) 1 : (byte) 0);
    }

    public /* synthetic */ ProfileRuleData(String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? false : z16);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ProfileRuleData(@NotNull Parcel parcel) {
        this(r0 == null ? "" : r0, parcel.readString(), parcel.readByte() != 0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
