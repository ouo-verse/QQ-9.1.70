package com.tencent.mobileqq.guild.setting.guildmanage.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001\u001cB;\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\t\u00a2\u0006\u0004\b&\u0010'B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "e", "c", "content", "f", "b", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, h.F, "a", "againConfirm", "i", "I", "getType", "()I", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getCancel", "cancel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class GuildAgainConfirmData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String confirm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String againConfirm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String cancel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmData;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmData$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<GuildAgainConfirmData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildAgainConfirmData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuildAgainConfirmData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildAgainConfirmData[] newArray(int size) {
            return new GuildAgainConfirmData[size];
        }

        Companion() {
        }
    }

    public GuildAgainConfirmData(@NotNull String title, @NotNull String content, @NotNull String confirm, @NotNull String againConfirm, int i3, @NotNull String cancel) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(confirm, "confirm");
        Intrinsics.checkNotNullParameter(againConfirm, "againConfirm");
        Intrinsics.checkNotNullParameter(cancel, "cancel");
        this.title = title;
        this.content = content;
        this.confirm = confirm;
        this.againConfirm = againConfirm;
        this.type = i3;
        this.cancel = cancel;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAgainConfirm() {
        return this.againConfirm;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getConfirm() {
        return this.confirm;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildAgainConfirmData)) {
            return false;
        }
        GuildAgainConfirmData guildAgainConfirmData = (GuildAgainConfirmData) other;
        if (Intrinsics.areEqual(this.title, guildAgainConfirmData.title) && Intrinsics.areEqual(this.content, guildAgainConfirmData.content) && Intrinsics.areEqual(this.confirm, guildAgainConfirmData.confirm) && Intrinsics.areEqual(this.againConfirm, guildAgainConfirmData.againConfirm) && this.type == guildAgainConfirmData.type && Intrinsics.areEqual(this.cancel, guildAgainConfirmData.cancel)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + this.confirm.hashCode()) * 31) + this.againConfirm.hashCode()) * 31) + this.type) * 31) + this.cancel.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildAgainConfirmData(title=" + this.title + ", content=" + this.content + ", confirm=" + this.confirm + ", againConfirm=" + this.againConfirm + ", type=" + this.type + ", cancel=" + this.cancel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.confirm);
        parcel.writeString(this.againConfirm);
        parcel.writeInt(this.type);
        parcel.writeString(this.cancel);
    }

    public /* synthetic */ GuildAgainConfirmData(String str, String str2, String str3, String str4, int i3, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i16 & 16) != 0 ? 0 : i3, (i16 & 32) != 0 ? "\u53d6\u6d88" : str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildAgainConfirmData(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r7, r10 == null ? "" : r10);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        int readInt = parcel.readInt();
        String readString5 = parcel.readString();
    }
}
