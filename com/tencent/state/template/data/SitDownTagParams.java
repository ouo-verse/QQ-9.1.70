package com.tencent.state.template.data;

import android.graphics.Point;
import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/template/data/SitDownTagParams;", "", "roomId", "", "tableId", "targetTagId", "", "subTagId", "isShowInSquare", "", "sitLocation", "Landroid/graphics/Point;", "(JJLjava/lang/String;Ljava/lang/String;ZLandroid/graphics/Point;)V", "()Z", "getRoomId", "()J", "getSitLocation", "()Landroid/graphics/Point;", "getSubTagId", "()Ljava/lang/String;", "getTableId", "getTargetTagId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SitDownTagParams {
    private final boolean isShowInSquare;
    private final long roomId;
    private final Point sitLocation;
    private final String subTagId;
    private final long tableId;
    private final String targetTagId;

    public SitDownTagParams(long j3, long j16, String str, String str2, boolean z16, Point point) {
        this.roomId = j3;
        this.tableId = j16;
        this.targetTagId = str;
        this.subTagId = str2;
        this.isShowInSquare = z16;
        this.sitLocation = point;
    }

    /* renamed from: component1, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTableId() {
        return this.tableId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTargetTagId() {
        return this.targetTagId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubTagId() {
        return this.subTagId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsShowInSquare() {
        return this.isShowInSquare;
    }

    /* renamed from: component6, reason: from getter */
    public final Point getSitLocation() {
        return this.sitLocation;
    }

    public final SitDownTagParams copy(long roomId, long tableId, String targetTagId, String subTagId, boolean isShowInSquare, Point sitLocation) {
        return new SitDownTagParams(roomId, tableId, targetTagId, subTagId, isShowInSquare, sitLocation);
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final Point getSitLocation() {
        return this.sitLocation;
    }

    public final String getSubTagId() {
        return this.subTagId;
    }

    public final long getTableId() {
        return this.tableId;
    }

    public final String getTargetTagId() {
        return this.targetTagId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((c.a(this.roomId) * 31) + c.a(this.tableId)) * 31;
        String str = this.targetTagId;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.subTagId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.isShowInSquare;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        Point point = this.sitLocation;
        return i16 + (point != null ? point.hashCode() : 0);
    }

    public final boolean isShowInSquare() {
        return this.isShowInSquare;
    }

    public String toString() {
        return "SitDownTagParams(roomId=" + this.roomId + ", tableId=" + this.tableId + ", targetTagId=" + this.targetTagId + ", subTagId=" + this.subTagId + ", isShowInSquare=" + this.isShowInSquare + ", sitLocation=" + this.sitLocation + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SitDownTagParams)) {
            return false;
        }
        SitDownTagParams sitDownTagParams = (SitDownTagParams) other;
        return this.roomId == sitDownTagParams.roomId && this.tableId == sitDownTagParams.tableId && Intrinsics.areEqual(this.targetTagId, sitDownTagParams.targetTagId) && Intrinsics.areEqual(this.subTagId, sitDownTagParams.subTagId) && this.isShowInSquare == sitDownTagParams.isShowInSquare && Intrinsics.areEqual(this.sitLocation, sitDownTagParams.sitLocation);
    }
}
