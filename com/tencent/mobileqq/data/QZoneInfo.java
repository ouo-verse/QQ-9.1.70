package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xc26$QzoneInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001a\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/data/QZoneInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "iconUrl", "Ljava/lang/String;", "getIconUrl", "()Ljava/lang/String;", "text", "getText", "hitExpGroup", "I", "getHitExpGroup", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "Ltencent/im/oidb/oidb_0xc26$QzoneInfo;", "info", "(Ltencent/im/oidb/oidb_0xc26$QzoneInfo;)V", "CREATOR", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class QZoneInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int hitExpGroup;

    @NotNull
    private final String iconUrl;

    @NotNull
    private final String text;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/data/QZoneInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/data/QZoneInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/data/QZoneInfo;", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.data.QZoneInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion implements Parcelable.Creator<QZoneInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public QZoneInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZoneInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public QZoneInfo[] newArray(int size) {
            return new QZoneInfo[size];
        }
    }

    public QZoneInfo(@NotNull String iconUrl, @NotNull String text, int i3) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        this.iconUrl = iconUrl;
        this.text = text;
        this.hitExpGroup = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneInfo)) {
            return false;
        }
        QZoneInfo qZoneInfo = (QZoneInfo) other;
        if (Intrinsics.areEqual(this.iconUrl, qZoneInfo.iconUrl) && Intrinsics.areEqual(this.text, qZoneInfo.text) && this.hitExpGroup == qZoneInfo.hitExpGroup) {
            return true;
        }
        return false;
    }

    public final int getHitExpGroup() {
        return this.hitExpGroup;
    }

    public int hashCode() {
        return (((this.iconUrl.hashCode() * 31) + this.text.hashCode()) * 31) + this.hitExpGroup;
    }

    @NotNull
    public String toString() {
        return "QZoneInfo(iconUrl=" + this.iconUrl + ", text=" + this.text + ", hitExpGroup=" + this.hitExpGroup + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.text);
        parcel.writeInt(this.hitExpGroup);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QZoneInfo(@NotNull Parcel parcel) {
        this(r0, r2 != null ? r2 : "", parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        String readString2 = parcel.readString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QZoneInfo(@NotNull oidb_0xc26$QzoneInfo info) {
        this(r0, r2 != null ? r2 : "", info.hit_exp_group.get());
        Intrinsics.checkNotNullParameter(info, "info");
        String str = info.icon_url.get();
        str = str == null ? "" : str;
        String str2 = info.text.get();
    }
}
