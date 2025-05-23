package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import i62.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001&B!\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010!\u001a\u00020\u000e\u00a2\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/LikeInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "", "d", "J", "getLikeCount", "()J", "setLikeCount", "(J)V", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "e", "Z", "isLiked", "()Z", "setLiked", "(Z)V", "f", "getOperated", "setOperated", "operated", "<init>", "(JZZ)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class LikeInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long likeCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isLiked;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean operated;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/LikeInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/LikeInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/kandian/biz/video/danmaku/LikeInfo;", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.video.danmaku.LikeInfo$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion implements Parcelable.Creator<LikeInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LikeInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LikeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LikeInfo[] newArray(int size) {
            return new LikeInfo[size];
        }

        Companion() {
        }
    }

    public LikeInfo(long j3, boolean z16, boolean z17) {
        this.likeCount = j3;
        this.isLiked = z16;
        this.operated = z17;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = a.a(this.likeCount) * 31;
        boolean z16 = this.isLiked;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (a16 + i3) * 31;
        boolean z17 = this.operated;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "LikeInfo(likeCount=" + this.likeCount + ", isLiked=" + this.isLiked + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.likeCount);
        parcel.writeByte(this.isLiked ? (byte) 1 : (byte) 0);
    }

    public /* synthetic */ LikeInfo(long j3, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, z16, (i3 & 4) != 0 ? false : z17);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LikeInfo(Parcel parcel) {
        this(parcel.readLong(), parcel.readByte() != 0, false, 4, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeInfo)) {
            return false;
        }
        LikeInfo likeInfo = (LikeInfo) other;
        return this.likeCount == likeInfo.likeCount && this.isLiked == likeInfo.isLiked && this.operated == likeInfo.operated;
    }
}
