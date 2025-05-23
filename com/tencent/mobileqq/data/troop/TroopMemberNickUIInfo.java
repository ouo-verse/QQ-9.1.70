package com.tencent.mobileqq.data.troop;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\tH\u00c6\u0003J\t\u0010\f\u001a\u00020\tH\u00c6\u0003J\t\u0010\r\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\tH\u00c6\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\tH\u00c6\u0001J\t\u0010\u0015\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b!\u0010\u001d\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "component1", "component2", "component3", "component4", "component5", "uin", "uid", "showName", "showNamePyFirst", "showNamePyAll", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "getUid", "getShowName", "getShowNamePyFirst", "getShowNamePyAll", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class TroopMemberNickUIInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String showName;

    @NotNull
    private final String showNamePyAll;

    @NotNull
    private final String showNamePyFirst;

    @NotNull
    private final String uid;

    @NotNull
    private final String uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;", "<init>", "()V", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.data.troop.TroopMemberNickUIInfo$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion implements Parcelable.Creator<TroopMemberNickUIInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopMemberNickUIInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TroopMemberNickUIInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopMemberNickUIInfo[] newArray(int size) {
            return new TroopMemberNickUIInfo[size];
        }

        Companion() {
        }
    }

    public TroopMemberNickUIInfo(@NotNull String uin, @NotNull String uid, @NotNull String showName, @NotNull String showNamePyFirst, @NotNull String showNamePyAll) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(showName, "showName");
        Intrinsics.checkNotNullParameter(showNamePyFirst, "showNamePyFirst");
        Intrinsics.checkNotNullParameter(showNamePyAll, "showNamePyAll");
        this.uin = uin;
        this.uid = uid;
        this.showName = showName;
        this.showNamePyFirst = showNamePyFirst;
        this.showNamePyAll = showNamePyAll;
    }

    public static /* synthetic */ TroopMemberNickUIInfo copy$default(TroopMemberNickUIInfo troopMemberNickUIInfo, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = troopMemberNickUIInfo.uin;
        }
        if ((i3 & 2) != 0) {
            str2 = troopMemberNickUIInfo.uid;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = troopMemberNickUIInfo.showName;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            str4 = troopMemberNickUIInfo.showNamePyFirst;
        }
        String str8 = str4;
        if ((i3 & 16) != 0) {
            str5 = troopMemberNickUIInfo.showNamePyAll;
        }
        return troopMemberNickUIInfo.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getShowName() {
        return this.showName;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getShowNamePyFirst() {
        return this.showNamePyFirst;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getShowNamePyAll() {
        return this.showNamePyAll;
    }

    @NotNull
    public final TroopMemberNickUIInfo copy(@NotNull String uin, @NotNull String uid, @NotNull String showName, @NotNull String showNamePyFirst, @NotNull String showNamePyAll) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(showName, "showName");
        Intrinsics.checkNotNullParameter(showNamePyFirst, "showNamePyFirst");
        Intrinsics.checkNotNullParameter(showNamePyAll, "showNamePyAll");
        return new TroopMemberNickUIInfo(uin, uid, showName, showNamePyFirst, showNamePyAll);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopMemberNickUIInfo)) {
            return false;
        }
        TroopMemberNickUIInfo troopMemberNickUIInfo = (TroopMemberNickUIInfo) other;
        if (Intrinsics.areEqual(this.uin, troopMemberNickUIInfo.uin) && Intrinsics.areEqual(this.uid, troopMemberNickUIInfo.uid) && Intrinsics.areEqual(this.showName, troopMemberNickUIInfo.showName) && Intrinsics.areEqual(this.showNamePyFirst, troopMemberNickUIInfo.showNamePyFirst) && Intrinsics.areEqual(this.showNamePyAll, troopMemberNickUIInfo.showNamePyAll)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getShowName() {
        return this.showName;
    }

    @NotNull
    public final String getShowNamePyAll() {
        return this.showNamePyAll;
    }

    @NotNull
    public final String getShowNamePyFirst() {
        return this.showNamePyFirst;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        return (((((((this.uin.hashCode() * 31) + this.uid.hashCode()) * 31) + this.showName.hashCode()) * 31) + this.showNamePyFirst.hashCode()) * 31) + this.showNamePyAll.hashCode();
    }

    @NotNull
    public String toString() {
        return "TroopMemberNickUIInfo(uin=" + this.uin + ", uid=" + this.uid + ", showName=" + this.showName + ", showNamePyFirst=" + this.showNamePyFirst + ", showNamePyAll=" + this.showNamePyAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uin);
        parcel.writeString(this.uid);
        parcel.writeString(this.showName);
        parcel.writeString(this.showNamePyFirst);
        parcel.writeString(this.showNamePyAll);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TroopMemberNickUIInfo(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r9 == null ? "" : r9);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
    }
}
