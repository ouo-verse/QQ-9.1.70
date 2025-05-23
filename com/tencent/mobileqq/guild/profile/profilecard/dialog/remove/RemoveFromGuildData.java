package com.tencent.mobileqq.guild.profile.profilecard.dialog.remove;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001#BK\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000f\u0012\b\b\u0002\u0010!\u001a\u00020\u000f\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u000f\u00a2\u0006\u0004\b*\u0010+B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b*\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010$\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010)\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u001d\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/RemoveFromGuildData;", "Landroid/os/Parcelable;", "", "getTitle", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "toString", "hashCode", "", "other", "", "equals", "d", "I", "e", "()I", "removeScene", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "f", "Z", "g", "()Z", "isGuildMember", h.F, "j", "isRobot", "i", "a", "count", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "uinReportStr", BdhLogUtil.LogTag.Tag_Conn, "c", "moveToBlack", "<init>", "(ILjava/lang/String;ZZILjava/lang/String;Z)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class RemoveFromGuildData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private final boolean moveToBlack;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int removeScene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isGuildMember;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRobot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uinReportStr;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/RemoveFromGuildData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/RemoveFromGuildData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/RemoveFromGuildData;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.dialog.remove.RemoveFromGuildData$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<RemoveFromGuildData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoveFromGuildData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RemoveFromGuildData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RemoveFromGuildData[] newArray(int size) {
            return new RemoveFromGuildData[size];
        }

        Companion() {
        }
    }

    public RemoveFromGuildData(int i3, @NotNull String guildId, boolean z16, boolean z17, int i16, @NotNull String uinReportStr, boolean z18) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(uinReportStr, "uinReportStr");
        this.removeScene = i3;
        this.guildId = guildId;
        this.isGuildMember = z16;
        this.isRobot = z17;
        this.count = i16;
        this.uinReportStr = uinReportStr;
        this.moveToBlack = z18;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getMoveToBlack() {
        return this.moveToBlack;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getRemoveScene() {
        return this.removeScene;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoveFromGuildData)) {
            return false;
        }
        RemoveFromGuildData removeFromGuildData = (RemoveFromGuildData) other;
        if (this.removeScene == removeFromGuildData.removeScene && Intrinsics.areEqual(this.guildId, removeFromGuildData.guildId) && this.isGuildMember == removeFromGuildData.isGuildMember && this.isRobot == removeFromGuildData.isRobot && this.count == removeFromGuildData.count && Intrinsics.areEqual(this.uinReportStr, removeFromGuildData.uinReportStr) && this.moveToBlack == removeFromGuildData.moveToBlack) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getUinReportStr() {
        return this.uinReportStr;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsGuildMember() {
        return this.isGuildMember;
    }

    @NotNull
    public final String getTitle() {
        int i3;
        int i16;
        if (this.moveToBlack) {
            if (this.isGuildMember) {
                if (this.isRobot) {
                    i16 = R.string.f138710_a;
                } else {
                    i16 = R.string.f138740_d;
                }
                String qqStr = HardCodeUtil.qqStr(i16);
                Intrinsics.checkNotNullExpressionValue(qqStr, "{\n                if (is\u2026d_to_black)\n            }");
                return qqStr;
            }
            String qqStr2 = HardCodeUtil.qqStr(R.string.f138750_e);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "{\n                HardCo\u2026r_to_black)\n            }");
            return qqStr2;
        }
        if (this.count > 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr3 = HardCodeUtil.qqStr(R.string.f140640ei);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_batch_remove_guild_title)");
            String format = String.format(qqStr3, Arrays.copyOf(new Object[]{Integer.valueOf(this.count)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (this.isRobot) {
            i3 = R.string.f152971au;
        } else {
            i3 = R.string.f152961at;
        }
        String qqStr4 = HardCodeUtil.qqStr(i3);
        Intrinsics.checkNotNullExpressionValue(qqStr4, "{\n            if (isRobo\u2026ve_guild_title)\n        }");
        return qqStr4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.removeScene * 31) + this.guildId.hashCode()) * 31;
        boolean z16 = this.isGuildMember;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isRobot;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int hashCode2 = (((((i17 + i18) * 31) + this.count) * 31) + this.uinReportStr.hashCode()) * 31;
        boolean z18 = this.moveToBlack;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return hashCode2 + i3;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsRobot() {
        return this.isRobot;
    }

    @NotNull
    public String toString() {
        return "RemoveFromGuildData(removeScene=" + this.removeScene + ", guildId='" + this.guildId + "', isGuildMember=" + this.isGuildMember + ", isRobot=" + this.isRobot + ", count=" + this.count + ", moveToBlack=" + this.moveToBlack + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.removeScene);
        parcel.writeString(this.guildId);
        parcel.writeByte(this.isGuildMember ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRobot ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.count);
        parcel.writeString(this.uinReportStr);
        parcel.writeByte(this.moveToBlack ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RemoveFromGuildData(@NotNull Parcel parcel) {
        this(r2, r3, r0, r6, r7, r8 == null ? "" : r8, parcel.readByte() != 0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        boolean z16 = parcel.readByte() != 0;
        boolean z17 = parcel.readByte() != 0;
        int readInt2 = parcel.readInt();
        String readString2 = parcel.readString();
    }
}
