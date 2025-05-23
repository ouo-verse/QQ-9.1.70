package com.tencent.robot.aio.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013\u00a8\u0006#"}, d2 = {"Lcom/tencent/robot/aio/share/RobotSessionShareParams;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "a", "()I", "action", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "f", "uinType", h.F, "b", "robotUin", "i", "c", "shareType", "<init>", "(ILjava/lang/String;ILjava/lang/String;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class RobotSessionShareParams implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RobotSessionShareParams> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int action;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int uinType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String robotUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int shareType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<RobotSessionShareParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RobotSessionShareParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RobotSessionShareParams(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RobotSessionShareParams[] newArray(int i3) {
            return new RobotSessionShareParams[i3];
        }
    }

    public RobotSessionShareParams(int i3, @NotNull String uin, int i16, @Nullable String str, int i17) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.action = i3;
        this.uin = uin;
        this.uinType = i16;
        this.robotUin = str;
        this.shareType = i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    /* renamed from: c, reason: from getter */
    public final int getShareType() {
        return this.shareType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotSessionShareParams)) {
            return false;
        }
        RobotSessionShareParams robotSessionShareParams = (RobotSessionShareParams) other;
        if (this.action == robotSessionShareParams.action && Intrinsics.areEqual(this.uin, robotSessionShareParams.uin) && this.uinType == robotSessionShareParams.uinType && Intrinsics.areEqual(this.robotUin, robotSessionShareParams.robotUin) && this.shareType == robotSessionShareParams.shareType) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getUinType() {
        return this.uinType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.action * 31) + this.uin.hashCode()) * 31) + this.uinType) * 31;
        String str = this.robotUin;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.shareType;
    }

    @NotNull
    public String toString() {
        return "RobotSessionShareParams(action=" + this.action + ", uin=" + this.uin + ", uinType=" + this.uinType + ", robotUin=" + this.robotUin + ", shareType=" + this.shareType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.action);
        parcel.writeString(this.uin);
        parcel.writeInt(this.uinType);
        parcel.writeString(this.robotUin);
        parcel.writeInt(this.shareType);
    }

    public /* synthetic */ RobotSessionShareParams(int i3, String str, int i16, String str2, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, (i18 & 8) != 0 ? "" : str2, (i18 & 16) != 0 ? 2 : i17);
    }
}
