package com.tencent.mobileqq.onlinestatus.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u0000 02\u00020\u0001:\u0001)B5\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010+\u001a\u00020&\u00a2\u0006\u0004\b,\u0010-B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u0010.B\u0019\b\u0016\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010+\u001a\u00020&\u00a2\u0006\u0004\b,\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u0017\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/model/CustomShareInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "I", "c", "()I", "g", "(I)V", "shareType", "e", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "url", "j", QQWinkConstants.TAB_SUBTITLE, "Lmqq/app/AppRuntime$Status;", tl.h.F, "Lmqq/app/AppRuntime$Status;", "b", "()Lmqq/app/AppRuntime$Status;", "originStatus", "", "i", "J", "a", "()J", "extStatus", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lmqq/app/AppRuntime$Status;J)V", "(Landroid/os/Parcel;)V", "(Lmqq/app/AppRuntime$Status;J)V", "CREATOR", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class CustomShareInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int shareType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String url;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String subTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AppRuntime.Status originStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long extStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/model/CustomShareInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/onlinestatus/model/CustomShareInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/onlinestatus/model/CustomShareInfo;", "<init>", "()V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.model.CustomShareInfo$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion implements Parcelable.Creator<CustomShareInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomShareInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CustomShareInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CustomShareInfo[] newArray(int size) {
            return new CustomShareInfo[size];
        }

        Companion() {
        }
    }

    public CustomShareInfo(int i3, @NotNull String url, @NotNull String subTitle, @NotNull AppRuntime.Status originStatus, long j3) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(originStatus, "originStatus");
        this.shareType = i3;
        this.url = url;
        this.subTitle = subTitle;
        this.originStatus = originStatus;
        this.extStatus = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getExtStatus() {
        return this.extStatus;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final AppRuntime.Status getOriginStatus() {
        return this.originStatus;
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
    public final String getSubTitle() {
        return this.subTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomShareInfo)) {
            return false;
        }
        CustomShareInfo customShareInfo = (CustomShareInfo) other;
        if (this.shareType == customShareInfo.shareType && Intrinsics.areEqual(this.url, customShareInfo.url) && Intrinsics.areEqual(this.subTitle, customShareInfo.subTitle) && this.originStatus == customShareInfo.originStatus && this.extStatus == customShareInfo.extStatus) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final void g(int i3) {
        this.shareType = i3;
    }

    public int hashCode() {
        return (((((((this.shareType * 31) + this.url.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.originStatus.hashCode()) * 31) + androidx.fragment.app.a.a(this.extStatus);
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "CustomShareInfo(shareType=" + this.shareType + ", url=" + this.url + ", subTitle=" + this.subTitle + ", originStatus=" + this.originStatus + ", extStatus=" + this.extStatus + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.shareType);
        parcel.writeString(this.url);
        parcel.writeString(this.subTitle);
        parcel.writeInt(this.originStatus.getValue());
        parcel.writeLong(this.extStatus);
    }

    public /* synthetic */ CustomShareInfo(int i3, String str, String str2, AppRuntime.Status status, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, status, j3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CustomShareInfo(@NotNull Parcel parcel) {
        this(r2, r3, r4, r5, parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        AppRuntime.Status build = AppRuntime.Status.build(parcel.readInt());
        Intrinsics.checkNotNullExpressionValue(build, "build(parcel.readInt())");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomShareInfo(@NotNull AppRuntime.Status originStatus, long j3) {
        this(0, null, null, originStatus, j3, 6, null);
        Intrinsics.checkNotNullParameter(originStatus, "originStatus");
    }
}
