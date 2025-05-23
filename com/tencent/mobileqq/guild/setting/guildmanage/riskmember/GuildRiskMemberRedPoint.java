package com.tencent.mobileqq.guild.setting.guildmanage.riskmember;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B/\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0015\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\"\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberRedPoint;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Z", "getHasConsumption", "()Z", "hasConsumption", "", "e", "J", "getSeqNo", "()J", "seqNo", "f", "getNextRequestTime", "nextRequestTime", tl.h.F, "Ljava/lang/String;", "getTips", "()Ljava/lang/String;", "tips", "<init>", "(ZJJLjava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class GuildRiskMemberRedPoint implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasConsumption;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long seqNo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long nextRequestTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tips;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberRedPoint$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberRedPoint;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberRedPoint;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildRiskMemberRedPoint$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<GuildRiskMemberRedPoint> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildRiskMemberRedPoint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuildRiskMemberRedPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildRiskMemberRedPoint[] newArray(int size) {
            return new GuildRiskMemberRedPoint[size];
        }

        Companion() {
        }
    }

    public GuildRiskMemberRedPoint() {
        this(false, 0L, 0L, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRiskMemberRedPoint)) {
            return false;
        }
        GuildRiskMemberRedPoint guildRiskMemberRedPoint = (GuildRiskMemberRedPoint) other;
        if (this.hasConsumption == guildRiskMemberRedPoint.hasConsumption && this.seqNo == guildRiskMemberRedPoint.seqNo && this.nextRequestTime == guildRiskMemberRedPoint.nextRequestTime && Intrinsics.areEqual(this.tips, guildRiskMemberRedPoint.tips)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.hasConsumption;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + androidx.fragment.app.a.a(this.seqNo)) * 31) + androidx.fragment.app.a.a(this.nextRequestTime)) * 31) + this.tips.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildRiskMemberRedPoint(hasConsumption=" + this.hasConsumption + ", seqNo=" + this.seqNo + ", nextRequestTime=" + this.nextRequestTime + ", tips=" + this.tips + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.hasConsumption ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.seqNo);
        parcel.writeLong(this.nextRequestTime);
        parcel.writeString(this.tips);
    }

    public GuildRiskMemberRedPoint(boolean z16, long j3, long j16, @NotNull String tips) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.hasConsumption = z16;
        this.seqNo = j3;
        this.nextRequestTime = j16;
        this.tips = tips;
    }

    public /* synthetic */ GuildRiskMemberRedPoint(boolean z16, long j3, long j16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) == 0 ? j16 : 0L, (i3 & 8) != 0 ? "" : str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildRiskMemberRedPoint(@NotNull Parcel parcel) {
        this(r2, r3, r5, r9 == null ? "" : r9);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        boolean z16 = parcel.readByte() != 0;
        long readLong = parcel.readLong();
        long readLong2 = parcel.readLong();
        String readString = parcel.readString();
    }
}
