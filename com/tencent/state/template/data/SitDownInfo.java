package com.tencent.state.template.data;

import android.graphics.Point;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0012H\u00c6\u0003J\t\u0010H\u001a\u00020\u0014H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\bH\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u0089\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u00c6\u0001J\u0013\u0010R\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010T\u001a\u00020\u0012H\u00d6\u0001J\t\u0010U\u001a\u00020VH\u00d6\u0001R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u0002008F\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010:\u00a8\u0006W"}, d2 = {"Lcom/tencent/state/template/data/SitDownInfo;", "", "tableId", "", "resource", "Lcom/tencent/state/square/data/Resource;", "likeNum", "hasLiked", "", "sitDownStartTime", "tag", "Lcom/tencent/state/common/tag/CommonTagInfo;", "subTag", "lastSwitchTableTime", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "roomId", "option", "", "sitLocation", "Landroid/graphics/Point;", "(JLcom/tencent/state/square/data/Resource;JZJLcom/tencent/state/common/tag/CommonTagInfo;Lcom/tencent/state/common/tag/CommonTagInfo;JLcom/tencent/state/square/data/OnlineStatus;JILandroid/graphics/Point;)V", "createdAt", "getCreatedAt", "()J", "fixedResource", "getFixedResource", "()Lcom/tencent/state/square/data/Resource;", "setFixedResource", "(Lcom/tencent/state/square/data/Resource;)V", "getHasLiked", "()Z", "setHasLiked", "(Z)V", "isFlexTable", "getLastSwitchTableTime", "getLikeNum", "setLikeNum", "(J)V", "getOnlineStatus", "()Lcom/tencent/state/square/data/OnlineStatus;", "setOnlineStatus", "(Lcom/tencent/state/square/data/OnlineStatus;)V", "getOption", "()I", "setOption", "(I)V", "pkResult", "Lcom/tencent/state/template/data/PKResult;", "getPkResult", "()Lcom/tencent/state/template/data/PKResult;", "getResource", "setResource", "getRoomId", "getSitDownStartTime", "getSitLocation", "()Landroid/graphics/Point;", "getSubTag", "()Lcom/tencent/state/common/tag/CommonTagInfo;", "setSubTag", "(Lcom/tencent/state/common/tag/CommonTagInfo;)V", "table", "Lcom/tencent/state/template/data/Table;", "getTable", "()Lcom/tencent/state/template/data/Table;", "setTable", "(Lcom/tencent/state/template/data/Table;)V", "getTableId", "getTag", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SitDownInfo {
    private final long createdAt;
    private Resource fixedResource;
    private boolean hasLiked;
    private final boolean isFlexTable;
    private final long lastSwitchTableTime;
    private long likeNum;
    private OnlineStatus onlineStatus;
    private int option;
    private Resource resource;
    private final long roomId;
    private final long sitDownStartTime;
    private final Point sitLocation;
    private CommonTagInfo subTag;
    private Table table;
    private final long tableId;
    private final CommonTagInfo tag;

    public SitDownInfo(long j3, Resource resource, long j16, boolean z16, long j17, CommonTagInfo commonTagInfo, CommonTagInfo commonTagInfo2, long j18, OnlineStatus onlineStatus, long j19, int i3, Point sitLocation) {
        Intrinsics.checkNotNullParameter(sitLocation, "sitLocation");
        this.tableId = j3;
        this.resource = resource;
        this.likeNum = j16;
        this.hasLiked = z16;
        this.sitDownStartTime = j17;
        this.tag = commonTagInfo;
        this.subTag = commonTagInfo2;
        this.lastSwitchTableTime = j18;
        this.onlineStatus = onlineStatus;
        this.roomId = j19;
        this.option = i3;
        this.sitLocation = sitLocation;
        this.createdAt = System.currentTimeMillis();
        this.isFlexTable = j3 == -1;
    }

    /* renamed from: component1, reason: from getter */
    public final long getTableId() {
        return this.tableId;
    }

    /* renamed from: component10, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component11, reason: from getter */
    public final int getOption() {
        return this.option;
    }

    /* renamed from: component12, reason: from getter */
    public final Point getSitLocation() {
        return this.sitLocation;
    }

    /* renamed from: component2, reason: from getter */
    public final Resource getResource() {
        return this.resource;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLikeNum() {
        return this.likeNum;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasLiked() {
        return this.hasLiked;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSitDownStartTime() {
        return this.sitDownStartTime;
    }

    /* renamed from: component6, reason: from getter */
    public final CommonTagInfo getTag() {
        return this.tag;
    }

    /* renamed from: component7, reason: from getter */
    public final CommonTagInfo getSubTag() {
        return this.subTag;
    }

    /* renamed from: component8, reason: from getter */
    public final long getLastSwitchTableTime() {
        return this.lastSwitchTableTime;
    }

    /* renamed from: component9, reason: from getter */
    public final OnlineStatus getOnlineStatus() {
        return this.onlineStatus;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final Resource getFixedResource() {
        return this.fixedResource;
    }

    public final boolean getHasLiked() {
        return this.hasLiked;
    }

    public final long getLastSwitchTableTime() {
        return this.lastSwitchTableTime;
    }

    public final long getLikeNum() {
        return this.likeNum;
    }

    public final OnlineStatus getOnlineStatus() {
        return this.onlineStatus;
    }

    public final int getOption() {
        return this.option;
    }

    public final PKResult getPkResult() {
        int i3 = this.option;
        if (i3 == 1) {
            return PKResult.SUPPORT;
        }
        if (i3 != 2) {
            return PKResult.UNSELECTED;
        }
        return PKResult.OPPOSE;
    }

    public final Resource getResource() {
        return this.resource;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getSitDownStartTime() {
        return this.sitDownStartTime;
    }

    public final Point getSitLocation() {
        return this.sitLocation;
    }

    public final CommonTagInfo getSubTag() {
        return this.subTag;
    }

    public final Table getTable() {
        return this.table;
    }

    public final long getTableId() {
        return this.tableId;
    }

    public final CommonTagInfo getTag() {
        return this.tag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = c.a(this.tableId) * 31;
        Resource resource = this.resource;
        int hashCode = (((a16 + (resource != null ? resource.hashCode() : 0)) * 31) + c.a(this.likeNum)) * 31;
        boolean z16 = this.hasLiked;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int a17 = (((hashCode + i3) * 31) + c.a(this.sitDownStartTime)) * 31;
        CommonTagInfo commonTagInfo = this.tag;
        int hashCode2 = (a17 + (commonTagInfo != null ? commonTagInfo.hashCode() : 0)) * 31;
        CommonTagInfo commonTagInfo2 = this.subTag;
        int hashCode3 = (((hashCode2 + (commonTagInfo2 != null ? commonTagInfo2.hashCode() : 0)) * 31) + c.a(this.lastSwitchTableTime)) * 31;
        OnlineStatus onlineStatus = this.onlineStatus;
        int hashCode4 = (((((hashCode3 + (onlineStatus != null ? onlineStatus.hashCode() : 0)) * 31) + c.a(this.roomId)) * 31) + this.option) * 31;
        Point point = this.sitLocation;
        return hashCode4 + (point != null ? point.hashCode() : 0);
    }

    /* renamed from: isFlexTable, reason: from getter */
    public final boolean getIsFlexTable() {
        return this.isFlexTable;
    }

    public final void setFixedResource(Resource resource) {
        this.fixedResource = resource;
    }

    public final void setHasLiked(boolean z16) {
        this.hasLiked = z16;
    }

    public final void setLikeNum(long j3) {
        this.likeNum = j3;
    }

    public final void setOnlineStatus(OnlineStatus onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public final void setOption(int i3) {
        this.option = i3;
    }

    public final void setResource(Resource resource) {
        this.resource = resource;
    }

    public final void setSubTag(CommonTagInfo commonTagInfo) {
        this.subTag = commonTagInfo;
    }

    public final void setTable(Table table) {
        this.table = table;
    }

    public String toString() {
        return "SitDownInfo(tableId=" + this.tableId + ", resource=" + this.resource + ", likeNum=" + this.likeNum + ", hasLiked=" + this.hasLiked + ", sitDownStartTime=" + this.sitDownStartTime + ", tag=" + this.tag + ", subTag=" + this.subTag + ", lastSwitchTableTime=" + this.lastSwitchTableTime + ", onlineStatus=" + this.onlineStatus + ", roomId=" + this.roomId + ", option=" + this.option + ", sitLocation=" + this.sitLocation + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SitDownInfo)) {
            return false;
        }
        SitDownInfo sitDownInfo = (SitDownInfo) other;
        return this.tableId == sitDownInfo.tableId && Intrinsics.areEqual(this.resource, sitDownInfo.resource) && this.likeNum == sitDownInfo.likeNum && this.hasLiked == sitDownInfo.hasLiked && this.sitDownStartTime == sitDownInfo.sitDownStartTime && Intrinsics.areEqual(this.tag, sitDownInfo.tag) && Intrinsics.areEqual(this.subTag, sitDownInfo.subTag) && this.lastSwitchTableTime == sitDownInfo.lastSwitchTableTime && Intrinsics.areEqual(this.onlineStatus, sitDownInfo.onlineStatus) && this.roomId == sitDownInfo.roomId && this.option == sitDownInfo.option && Intrinsics.areEqual(this.sitLocation, sitDownInfo.sitLocation);
    }

    public /* synthetic */ SitDownInfo(long j3, Resource resource, long j16, boolean z16, long j17, CommonTagInfo commonTagInfo, CommonTagInfo commonTagInfo2, long j18, OnlineStatus onlineStatus, long j19, int i3, Point point, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, resource, j16, z16, j17, commonTagInfo, commonTagInfo2, j18, (i16 & 256) != 0 ? null : onlineStatus, (i16 & 512) != 0 ? 0L : j19, (i16 & 1024) != 0 ? 0 : i3, point);
    }

    public final SitDownInfo copy(long tableId, Resource resource, long likeNum, boolean hasLiked, long sitDownStartTime, CommonTagInfo tag, CommonTagInfo subTag, long lastSwitchTableTime, OnlineStatus onlineStatus, long roomId, int option, Point sitLocation) {
        Intrinsics.checkNotNullParameter(sitLocation, "sitLocation");
        return new SitDownInfo(tableId, resource, likeNum, hasLiked, sitDownStartTime, tag, subTag, lastSwitchTableTime, onlineStatus, roomId, option, sitLocation);
    }
}
