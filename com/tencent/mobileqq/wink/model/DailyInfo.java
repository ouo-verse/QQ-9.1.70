package com.tencent.mobileqq.wink.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\u0017B!\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/model/DailyInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Z", "b", "()Z", "isDaily", "e", "I", "a", "()I", ITroopAnnouncementHelperApi.CONTROL_INFO_VAILD_TIME, "f", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "<init>", "(ZILjava/lang/String;)V", "CREATOR", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class DailyInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDaily;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int validTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/model/DailyInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/model/DailyInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/model/DailyInfo;", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.model.DailyInfo$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<DailyInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DailyInfo createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readByte() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            if (readString == null) {
                readString = "";
            }
            return new DailyInfo(z16, readInt, readString);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DailyInfo[] newArray(int size) {
            return new DailyInfo[size];
        }

        Companion() {
        }
    }

    public DailyInfo(boolean z16, int i3, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.isDaily = z16;
        this.validTime = i3;
        this.tag = tag;
    }

    /* renamed from: a, reason: from getter */
    public final int getValidTime() {
        return this.validTime;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsDaily() {
        return this.isDaily;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyInfo)) {
            return false;
        }
        DailyInfo dailyInfo = (DailyInfo) other;
        if (this.isDaily == dailyInfo.isDaily && this.validTime == dailyInfo.validTime && Intrinsics.areEqual(this.tag, dailyInfo.tag)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isDaily;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.validTime) * 31) + this.tag.hashCode();
    }

    @NotNull
    public String toString() {
        return "DailyInfo(isDaily=" + this.isDaily + ", validTime=" + this.validTime + ", tag=" + this.tag + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isDaily ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.validTime);
        parcel.writeString(this.tag);
    }

    public /* synthetic */ DailyInfo(boolean z16, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, i3, (i16 & 4) != 0 ? "" : str);
    }
}
