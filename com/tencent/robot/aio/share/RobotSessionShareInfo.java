package com.tencent.robot.aio.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b\"\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "shareLink", "f", "shareTitle", "b", "shareDesc", h.F, "c", "shareIcon", "i", "getShareFrom", "shareFrom", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", AppConstants.Key.SHARE_REQ_ARK_INFO, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lzo4/c;", "rsp", "(Lzo4/c;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class RobotSessionShareInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RobotSessionShareInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareLink;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareFrom;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareArkInfo;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<RobotSessionShareInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RobotSessionShareInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RobotSessionShareInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RobotSessionShareInfo[] newArray(int i3) {
            return new RobotSessionShareInfo[i3];
        }
    }

    public RobotSessionShareInfo(@NotNull String shareLink, @NotNull String shareTitle, @NotNull String shareDesc, @NotNull String shareIcon, @NotNull String shareFrom, @NotNull String shareArkInfo) {
        Intrinsics.checkNotNullParameter(shareLink, "shareLink");
        Intrinsics.checkNotNullParameter(shareTitle, "shareTitle");
        Intrinsics.checkNotNullParameter(shareDesc, "shareDesc");
        Intrinsics.checkNotNullParameter(shareIcon, "shareIcon");
        Intrinsics.checkNotNullParameter(shareFrom, "shareFrom");
        Intrinsics.checkNotNullParameter(shareArkInfo, "shareArkInfo");
        this.shareLink = shareLink;
        this.shareTitle = shareTitle;
        this.shareDesc = shareDesc;
        this.shareIcon = shareIcon;
        this.shareFrom = shareFrom;
        this.shareArkInfo = shareArkInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getShareArkInfo() {
        return this.shareArkInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getShareDesc() {
        return this.shareDesc;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getShareIcon() {
        return this.shareIcon;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShareLink() {
        return this.shareLink;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotSessionShareInfo)) {
            return false;
        }
        RobotSessionShareInfo robotSessionShareInfo = (RobotSessionShareInfo) other;
        if (Intrinsics.areEqual(this.shareLink, robotSessionShareInfo.shareLink) && Intrinsics.areEqual(this.shareTitle, robotSessionShareInfo.shareTitle) && Intrinsics.areEqual(this.shareDesc, robotSessionShareInfo.shareDesc) && Intrinsics.areEqual(this.shareIcon, robotSessionShareInfo.shareIcon) && Intrinsics.areEqual(this.shareFrom, robotSessionShareInfo.shareFrom) && Intrinsics.areEqual(this.shareArkInfo, robotSessionShareInfo.shareArkInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getShareTitle() {
        return this.shareTitle;
    }

    public int hashCode() {
        return (((((((((this.shareLink.hashCode() * 31) + this.shareTitle.hashCode()) * 31) + this.shareDesc.hashCode()) * 31) + this.shareIcon.hashCode()) * 31) + this.shareFrom.hashCode()) * 31) + this.shareArkInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotSessionShareInfo(shareLink=" + this.shareLink + ", shareTitle=" + this.shareTitle + ", shareDesc=" + this.shareDesc + ", shareIcon=" + this.shareIcon + ", shareFrom=" + this.shareFrom + ", shareArkInfo=" + this.shareArkInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.shareLink);
        parcel.writeString(this.shareTitle);
        parcel.writeString(this.shareDesc);
        parcel.writeString(this.shareIcon);
        parcel.writeString(this.shareFrom);
        parcel.writeString(this.shareArkInfo);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RobotSessionShareInfo(@NotNull zo4.c rsp) {
        this(r3, r4, r5, r6, r7, r10 == null ? "" : r10);
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        String str = rsp.f452917b;
        String str2 = str == null ? "" : str;
        String str3 = rsp.f452918c;
        String str4 = str3 == null ? "" : str3;
        String str5 = rsp.f452919d;
        String str6 = str5 == null ? "" : str5;
        String str7 = rsp.f452920e;
        String str8 = str7 == null ? "" : str7;
        String str9 = rsp.f452921f;
        String str10 = str9 == null ? "" : str9;
        String str11 = rsp.f452923h;
    }
}
