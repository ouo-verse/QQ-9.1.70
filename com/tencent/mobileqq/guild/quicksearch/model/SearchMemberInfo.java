package com.tencent.mobileqq.guild.quicksearch.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.util.ay;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/model/SearchMemberInfo;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tinyId", "e", "a", "name", "f", "I", "c", "()I", MessageRoamJsPlugin.USERTYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class SearchMemberInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int userType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/model/SearchMemberInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/quicksearch/model/SearchMemberInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/quicksearch/model/SearchMemberInfo;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.model.SearchMemberInfo$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<SearchMemberInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SearchMemberInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SearchMemberInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SearchMemberInfo[] newArray(int size) {
            return new SearchMemberInfo[size];
        }

        Companion() {
        }
    }

    public SearchMemberInfo(@NotNull String tinyId, @NotNull String name, int i3) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.tinyId = tinyId;
        this.name = name;
        this.userType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: c, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchMemberInfo)) {
            return false;
        }
        SearchMemberInfo searchMemberInfo = (SearchMemberInfo) other;
        if (Intrinsics.areEqual(this.tinyId, searchMemberInfo.tinyId) && Intrinsics.areEqual(this.name, searchMemberInfo.name) && this.userType == searchMemberInfo.userType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.tinyId.hashCode() * 31) + this.name.hashCode()) * 31) + this.userType;
    }

    @NotNull
    public String toString() {
        return "SearchMemberInfo(tinyId='" + this.tinyId + "', name='" + ay.a(this.name) + "', userType=" + this.userType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.tinyId);
        dest.writeString(this.name);
        dest.writeInt(this.userType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchMemberInfo(@NotNull Parcel parcel) {
        this(r0, r2 != null ? r2 : "", parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        String readString2 = parcel.readString();
    }
}
