package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B3\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getUserUin", "()Ljava/lang/String;", "userUin", "e", "I", "getUserSource", "()I", "userSource", "f", "getUserNickName", "userNickName", h.F, "getUserAvator", "userAvator", "i", "getIdentity", "identity", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class UserInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String userUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int userSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String userNickName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String userAvator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int identity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.video.danmaku.UserInfo$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion implements Parcelable.Creator<UserInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }

        Companion() {
        }
    }

    public UserInfo(String userUin, int i3, String str, String str2, int i16) {
        Intrinsics.checkNotNullParameter(userUin, "userUin");
        this.userUin = userUin;
        this.userSource = i3;
        this.userNickName = str;
        this.userAvator = str2;
        this.identity = i16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        int hashCode = ((this.userUin.hashCode() * 31) + this.userSource) * 31;
        String str = this.userNickName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userAvator;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.identity;
    }

    public String toString() {
        return "UserInfo(userUin='" + this.userUin + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.userUin);
        parcel.writeInt(this.userSource);
        parcel.writeString(this.userNickName);
        parcel.writeString(this.userAvator);
        parcel.writeInt(this.identity);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserInfo(Parcel parcel) {
        this(r2, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.userUin, userInfo.userUin) && this.userSource == userInfo.userSource && Intrinsics.areEqual(this.userNickName, userInfo.userNickName) && Intrinsics.areEqual(this.userAvator, userInfo.userAvator) && this.identity == userInfo.identity;
    }
}
