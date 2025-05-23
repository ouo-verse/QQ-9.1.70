package com.tencent.mobileqq.qqlive.sail.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b \b\u0086\b\u0018\u0000 02\u00020\u0001:\u0001$BW\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u0012\b\b\u0002\u0010-\u001a\u00020\u0011\u00a2\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\"\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u0017\u0010(\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001aR\u0017\u0010+\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u0017\u0010-\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "Landroid/os/Parcelable;", "", "g", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "equals", "", "d", "J", "f", "()J", "uid", "e", "I", "c", "()I", "sex", "getExplicitId", "explicitId", h.F, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "nickName", "i", "a", PhotoCategorySummaryInfo.AVATAR_URL, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getInitialClientType", "initialClientType", BdhLogUtil.LogTag.Tag_Conn, "getBusinessUid", "businessUid", "D", "tinyId", "<init>", "(JIJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "CREATOR", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class UserInfo implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String businessUid;

    /* renamed from: D, reason: from kotlin metadata */
    private final long tinyId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long uid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int sex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long explicitId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nickName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String avatarUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int initialClientType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "c", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.common.UserInfo$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<UserInfo> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (UserInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UserInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (UserInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new UserInfo[size];
        }

        @NotNull
        public final UserInfo c(@NotNull Parcel parcel) {
            String str;
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (UserInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            if (readString == null) {
                str = "";
            } else {
                str = readString;
            }
            String readString2 = parcel.readString();
            if (readString2 == null) {
                str2 = "";
            } else {
                str2 = readString2;
            }
            int readInt2 = parcel.readInt();
            String readString3 = parcel.readString();
            if (readString3 == null) {
                str3 = "";
            } else {
                str3 = readString3;
            }
            return new UserInfo(readLong, readInt, readLong2, str, str2, readInt2, str3, parcel.readLong());
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30875);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public UserInfo() {
        this(0L, 0, 0L, null, null, 0, null, 0L, 255, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return;
        }
        iPatchRedirector.redirect((short) 26, (Object) this);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.avatarUrl;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.nickName;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.sex;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 0;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.tinyId;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        if (this.uid == userInfo.uid && this.sex == userInfo.sex && this.explicitId == userInfo.explicitId && Intrinsics.areEqual(this.nickName, userInfo.nickName) && Intrinsics.areEqual(this.avatarUrl, userInfo.avatarUrl) && this.initialClientType == userInfo.initialClientType && Intrinsics.areEqual(this.businessUid, userInfo.businessUid) && this.tinyId == userInfo.tinyId) {
            return true;
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.uid;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.uid > 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return (((((((((((((a.a(this.uid) * 31) + this.sex) * 31) + a.a(this.explicitId)) * 31) + this.nickName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.initialClientType) * 31) + this.businessUid.hashCode()) * 31) + a.a(this.tinyId);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "UserInfo(uid=" + this.uid + ", sex=" + this.sex + ", explicitId=" + this.explicitId + ", nickName=" + this.nickName + ", avatarUrl=" + this.avatarUrl + ", initialClientType=" + this.initialClientType + ", businessUid=" + this.businessUid + ", tinyId=" + this.tinyId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.uid);
        parcel.writeInt(this.sex);
        parcel.writeLong(this.explicitId);
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatarUrl);
        parcel.writeInt(this.initialClientType);
        parcel.writeString(this.businessUid);
        parcel.writeLong(this.tinyId);
    }

    public UserInfo(long j3, int i3, long j16, @NotNull String nickName, @NotNull String avatarUrl, int i16, @NotNull String businessUid, long j17) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(businessUid, "businessUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), nickName, avatarUrl, Integer.valueOf(i16), businessUid, Long.valueOf(j17));
            return;
        }
        this.uid = j3;
        this.sex = i3;
        this.explicitId = j16;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.initialClientType = i16;
        this.businessUid = businessUid;
        this.tinyId = j17;
    }

    public /* synthetic */ UserInfo(long j3, int i3, long j16, String str, String str2, int i16, String str3, long j17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0L : j3, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0L : j16, (i17 & 8) != 0 ? "" : str, (i17 & 16) != 0 ? "" : str2, (i17 & 32) != 0 ? 0 : i16, (i17 & 64) != 0 ? "" : str3, (i17 & 128) != 0 ? 0L : j17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), str, str2, Integer.valueOf(i16), str3, Long.valueOf(j17), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
