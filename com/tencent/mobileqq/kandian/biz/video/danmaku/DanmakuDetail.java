package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "d", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "getDanmakuInfo", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "danmakuInfo", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", "e", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", "getUserInfo", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/LikeInfo;", "f", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/LikeInfo;", "getLikeInfo", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/LikeInfo;", "likeInfo", "<init>", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;Lcom/tencent/mobileqq/kandian/biz/video/danmaku/UserInfo;Lcom/tencent/mobileqq/kandian/biz/video/danmaku/LikeInfo;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class DanmakuDetail implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final DanmakuInfo danmakuInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final UserInfo userInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final LikeInfo likeInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion implements Parcelable.Creator<DanmakuDetail> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DanmakuDetail createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DanmakuDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DanmakuDetail[] newArray(int size) {
            return new DanmakuDetail[size];
        }

        Companion() {
        }
    }

    public DanmakuDetail(DanmakuInfo danmakuInfo, UserInfo userInfo, LikeInfo likeInfo) {
        Intrinsics.checkNotNullParameter(danmakuInfo, "danmakuInfo");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(likeInfo, "likeInfo");
        this.danmakuInfo = danmakuInfo;
        this.userInfo = userInfo;
        this.likeInfo = likeInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return (((this.danmakuInfo.hashCode() * 31) + this.userInfo.hashCode()) * 31) + this.likeInfo.hashCode();
    }

    public String toString() {
        return "DanmakuDetail(danmakuInfo=" + this.danmakuInfo + ", userInfo=" + this.userInfo + ", likeInfo=" + this.likeInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.danmakuInfo, flags);
        parcel.writeParcelable(this.userInfo, flags);
        parcel.writeParcelable(this.likeInfo, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DanmakuDetail(Parcel parcel) {
        this((DanmakuInfo) r0, (UserInfo) r1, (LikeInfo) r4);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Parcelable readParcelable = parcel.readParcelable(DanmakuInfo.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable);
        Parcelable readParcelable2 = parcel.readParcelable(UserInfo.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable2);
        Parcelable readParcelable3 = parcel.readParcelable(LikeInfo.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DanmakuDetail)) {
            return false;
        }
        DanmakuDetail danmakuDetail = (DanmakuDetail) other;
        return Intrinsics.areEqual(this.danmakuInfo, danmakuDetail.danmakuInfo) && Intrinsics.areEqual(this.userInfo, danmakuDetail.userInfo) && Intrinsics.areEqual(this.likeInfo, danmakuDetail.likeInfo);
    }
}
