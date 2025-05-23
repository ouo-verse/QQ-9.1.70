package com.tencent.mobileqq.guild.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001\u001fBC\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010 \u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "I", "e", "()I", "setLastMsgType", "(I)V", "lastMsgType", "Ljava/lang/String;", "getJumpLink", "()Ljava/lang/String;", "jumpLink", "f", "c", "jumpFrom", tl.h.F, "a", "busiInfo", "i", "b", "jumpDetail", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isDirect", "<init>", "(ILjava/lang/String;ILjava/lang/String;II)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class GuildPublicAccountParams implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int lastMsgType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpLink;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int jumpFrom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String busiInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int jumpDetail;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final int isDirect;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.api.GuildPublicAccountParams$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion implements Parcelable.Creator<GuildPublicAccountParams> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildPublicAccountParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuildPublicAccountParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildPublicAccountParams[] newArray(int size) {
            return new GuildPublicAccountParams[size];
        }

        Companion() {
        }
    }

    public GuildPublicAccountParams() {
        this(0, null, 0, null, 0, 0, 63, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBusiInfo() {
        return this.busiInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getJumpDetail() {
        return this.jumpDetail;
    }

    /* renamed from: c, reason: from getter */
    public final int getJumpFrom() {
        return this.jumpFrom;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getLastMsgType() {
        return this.lastMsgType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildPublicAccountParams)) {
            return false;
        }
        GuildPublicAccountParams guildPublicAccountParams = (GuildPublicAccountParams) other;
        if (this.lastMsgType == guildPublicAccountParams.lastMsgType && Intrinsics.areEqual(this.jumpLink, guildPublicAccountParams.jumpLink) && this.jumpFrom == guildPublicAccountParams.jumpFrom && Intrinsics.areEqual(this.busiInfo, guildPublicAccountParams.busiInfo) && this.jumpDetail == guildPublicAccountParams.jumpDetail && this.isDirect == guildPublicAccountParams.isDirect) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.lastMsgType * 31) + this.jumpLink.hashCode()) * 31) + this.jumpFrom) * 31) + this.busiInfo.hashCode()) * 31) + this.jumpDetail) * 31) + this.isDirect;
    }

    @NotNull
    public String toString() {
        return "GuildPublicAccountParams(lastMsgType=" + this.lastMsgType + ", jumpLink=" + this.jumpLink + ", jumpFrom=" + this.jumpFrom + ", busiInfo=" + this.busiInfo + ", jumpDetail=" + this.jumpDetail + ", isDirect=" + this.isDirect + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.lastMsgType);
        parcel.writeString(this.jumpLink);
        parcel.writeInt(this.jumpFrom);
        parcel.writeString(this.busiInfo);
        parcel.writeInt(this.jumpDetail);
        parcel.writeInt(this.isDirect);
    }

    public GuildPublicAccountParams(int i3, @NotNull String jumpLink, int i16, @NotNull String busiInfo, int i17, int i18) {
        Intrinsics.checkNotNullParameter(jumpLink, "jumpLink");
        Intrinsics.checkNotNullParameter(busiInfo, "busiInfo");
        this.lastMsgType = i3;
        this.jumpLink = jumpLink;
        this.jumpFrom = i16;
        this.busiInfo = busiInfo;
        this.jumpDetail = i17;
        this.isDirect = i18;
    }

    public /* synthetic */ GuildPublicAccountParams(int i3, String str, int i16, String str2, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? "" : str, (i19 & 4) != 0 ? 0 : i16, (i19 & 8) == 0 ? str2 : "", (i19 & 16) != 0 ? 0 : i17, (i19 & 32) != 0 ? 0 : i18);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildPublicAccountParams(@NotNull Parcel parcel) {
        this(r2, r3, r4, r0 == null ? "" : r0, parcel.readInt(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        int readInt2 = parcel.readInt();
        String readString2 = parcel.readString();
    }

    public GuildPublicAccountParams(int i3) {
        this(0, "", i3, "", 0, 0);
    }
}
