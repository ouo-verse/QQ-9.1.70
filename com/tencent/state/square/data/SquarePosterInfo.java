package com.tencent.state.square.data;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u00c6\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\tH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/data/SquarePosterInfo;", "", "totalLikeCount", "", "motionInfo", "Lcom/tencent/state/square/data/PosterMotionInfo;", "statusChangeNum", "", "qrCodeUrl", "", "(ILcom/tencent/state/square/data/PosterMotionInfo;JLjava/lang/String;)V", "getMotionInfo", "()Lcom/tencent/state/square/data/PosterMotionInfo;", "getQrCodeUrl", "()Ljava/lang/String;", "getStatusChangeNum", "()J", "getTotalLikeCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquarePosterInfo {
    private final PosterMotionInfo motionInfo;
    private final String qrCodeUrl;
    private final long statusChangeNum;
    private final int totalLikeCount;

    public SquarePosterInfo() {
        this(0, null, 0L, null, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTotalLikeCount() {
        return this.totalLikeCount;
    }

    /* renamed from: component2, reason: from getter */
    public final PosterMotionInfo getMotionInfo() {
        return this.motionInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final long getStatusChangeNum() {
        return this.statusChangeNum;
    }

    /* renamed from: component4, reason: from getter */
    public final String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public final SquarePosterInfo copy(int totalLikeCount, PosterMotionInfo motionInfo, long statusChangeNum, String qrCodeUrl) {
        return new SquarePosterInfo(totalLikeCount, motionInfo, statusChangeNum, qrCodeUrl);
    }

    public final PosterMotionInfo getMotionInfo() {
        return this.motionInfo;
    }

    public final String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public final long getStatusChangeNum() {
        return this.statusChangeNum;
    }

    public final int getTotalLikeCount() {
        return this.totalLikeCount;
    }

    public int hashCode() {
        int i3 = this.totalLikeCount * 31;
        PosterMotionInfo posterMotionInfo = this.motionInfo;
        int hashCode = (((i3 + (posterMotionInfo != null ? posterMotionInfo.hashCode() : 0)) * 31) + c.a(this.statusChangeNum)) * 31;
        String str = this.qrCodeUrl;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SquarePosterInfo(totalLikeCount=" + this.totalLikeCount + ", motionInfo=" + this.motionInfo + ", statusChangeNum=" + this.statusChangeNum + ", qrCodeUrl=" + this.qrCodeUrl + ")";
    }

    public SquarePosterInfo(int i3, PosterMotionInfo posterMotionInfo, long j3, String str) {
        this.totalLikeCount = i3;
        this.motionInfo = posterMotionInfo;
        this.statusChangeNum = j3;
        this.qrCodeUrl = str;
    }

    public /* synthetic */ SquarePosterInfo(int i3, PosterMotionInfo posterMotionInfo, long j3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : posterMotionInfo, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) == 0 ? str : null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquarePosterInfo)) {
            return false;
        }
        SquarePosterInfo squarePosterInfo = (SquarePosterInfo) other;
        return this.totalLikeCount == squarePosterInfo.totalLikeCount && Intrinsics.areEqual(this.motionInfo, squarePosterInfo.motionInfo) && this.statusChangeNum == squarePosterInfo.statusChangeNum && Intrinsics.areEqual(this.qrCodeUrl, squarePosterInfo.qrCodeUrl);
    }

    public static /* synthetic */ SquarePosterInfo copy$default(SquarePosterInfo squarePosterInfo, int i3, PosterMotionInfo posterMotionInfo, long j3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = squarePosterInfo.totalLikeCount;
        }
        if ((i16 & 2) != 0) {
            posterMotionInfo = squarePosterInfo.motionInfo;
        }
        PosterMotionInfo posterMotionInfo2 = posterMotionInfo;
        if ((i16 & 4) != 0) {
            j3 = squarePosterInfo.statusChangeNum;
        }
        long j16 = j3;
        if ((i16 & 8) != 0) {
            str = squarePosterInfo.qrCodeUrl;
        }
        return squarePosterInfo.copy(i3, posterMotionInfo2, j16, str);
    }
}
