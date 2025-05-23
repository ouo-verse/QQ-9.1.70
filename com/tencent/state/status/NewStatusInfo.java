package com.tencent.state.status;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\bH\u00d6\u0001J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/status/NewStatusInfo;", "", "redDotId", "", "redDotImg", "", "categoryId", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", DetailMeFragmentConfig.CURRENT_RICH_ID, "motionId", "(JLjava/lang/String;Ljava/lang/String;IILjava/lang/Integer;)V", "getCategoryId", "()Ljava/lang/String;", "getMotionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRedDotId", "()J", "getRedDotImg", "getRichStatusId", "()I", "getStatusId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLjava/lang/String;Ljava/lang/String;IILjava/lang/Integer;)Lcom/tencent/state/status/NewStatusInfo;", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class NewStatusInfo {
    private final String categoryId;
    private final Integer motionId;
    private final long redDotId;
    private final String redDotImg;
    private final int richStatusId;
    private final int statusId;

    public NewStatusInfo() {
        this(0L, null, null, 0, 0, null, 63, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRedDotId() {
        return this.redDotId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRedDotImg() {
        return this.redDotImg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStatusId() {
        return this.statusId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRichStatusId() {
        return this.richStatusId;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getMotionId() {
        return this.motionId;
    }

    public final NewStatusInfo copy(long redDotId, String redDotImg, String categoryId, int statusId, int richStatusId, Integer motionId) {
        Intrinsics.checkNotNullParameter(redDotImg, "redDotImg");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return new NewStatusInfo(redDotId, redDotImg, categoryId, statusId, richStatusId, motionId);
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final Integer getMotionId() {
        return this.motionId;
    }

    public final long getRedDotId() {
        return this.redDotId;
    }

    public final String getRedDotImg() {
        return this.redDotImg;
    }

    public final int getRichStatusId() {
        return this.richStatusId;
    }

    public final int getStatusId() {
        return this.statusId;
    }

    public int hashCode() {
        int a16 = c.a(this.redDotId) * 31;
        String str = this.redDotImg;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.categoryId;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.statusId) * 31) + this.richStatusId) * 31;
        Integer num = this.motionId;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "NewStatusInfo(redDotId=" + this.redDotId + ", redDotImg=" + this.redDotImg + ", categoryId=" + this.categoryId + ", statusId=" + this.statusId + ", richStatusId=" + this.richStatusId + ", motionId=" + this.motionId + ")";
    }

    public NewStatusInfo(long j3, String redDotImg, String categoryId, int i3, int i16, Integer num) {
        Intrinsics.checkNotNullParameter(redDotImg, "redDotImg");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        this.redDotId = j3;
        this.redDotImg = redDotImg;
        this.categoryId = categoryId;
        this.statusId = i3;
        this.richStatusId = i16;
        this.motionId = num;
    }

    public /* synthetic */ NewStatusInfo(long j3, String str, String str2, int i3, int i16, Integer num, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1L : j3, (i17 & 2) != 0 ? "" : str, (i17 & 4) == 0 ? str2 : "", (i17 & 8) != 0 ? -1 : i3, (i17 & 16) == 0 ? i16 : -1, (i17 & 32) != 0 ? null : num);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewStatusInfo)) {
            return false;
        }
        NewStatusInfo newStatusInfo = (NewStatusInfo) other;
        return this.redDotId == newStatusInfo.redDotId && Intrinsics.areEqual(this.redDotImg, newStatusInfo.redDotImg) && Intrinsics.areEqual(this.categoryId, newStatusInfo.categoryId) && this.statusId == newStatusInfo.statusId && this.richStatusId == newStatusInfo.richStatusId && Intrinsics.areEqual(this.motionId, newStatusInfo.motionId);
    }
}
