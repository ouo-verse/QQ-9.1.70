package com.tencent.richframework.argus;

import androidx.fragment.app.Argus;
import com.tencent.richframework.argus.node.NodePO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b5\u00106Ji\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010!\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010*\u001a\u0004\b\f\u0010+\"\u0004\b,\u0010-R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00067"}, d2 = {"Lcom/tencent/richframework/argus/PagePerformanceDataInfo;", "", "", "fromPageInfo", "newPageInfo", "Landroidx/fragment/app/Argus$MergeResult;", "mergeResult", "", "firstDrawTime", "startMonitorTime", "stopMonitorTime", "", "isDeadlineUpdate", "recyclerViewFirstItemAttachWindowTime", "Lcom/tencent/richframework/argus/node/NodePO;", "recyclerView", "copy", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getFromPageInfo", "()Ljava/lang/String;", "getNewPageInfo", "setNewPageInfo", "(Ljava/lang/String;)V", "Landroidx/fragment/app/Argus$MergeResult;", "getMergeResult", "()Landroidx/fragment/app/Argus$MergeResult;", "setMergeResult", "(Landroidx/fragment/app/Argus$MergeResult;)V", "J", "getFirstDrawTime", "()J", "setFirstDrawTime", "(J)V", "getStartMonitorTime", "setStartMonitorTime", "getStopMonitorTime", "setStopMonitorTime", "Z", "()Z", "setDeadlineUpdate", "(Z)V", "getRecyclerViewFirstItemAttachWindowTime", "setRecyclerViewFirstItemAttachWindowTime", "Lcom/tencent/richframework/argus/node/NodePO;", "getRecyclerView", "()Lcom/tencent/richframework/argus/node/NodePO;", "setRecyclerView", "(Lcom/tencent/richframework/argus/node/NodePO;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/fragment/app/Argus$MergeResult;JJJZJLcom/tencent/richframework/argus/node/NodePO;)V", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class PagePerformanceDataInfo {
    private long firstDrawTime;

    @Nullable
    private final String fromPageInfo;
    private boolean isDeadlineUpdate;

    @NotNull
    private Argus.MergeResult mergeResult;

    @Nullable
    private String newPageInfo;

    @Nullable
    private NodePO recyclerView;
    private long recyclerViewFirstItemAttachWindowTime;
    private long startMonitorTime;
    private long stopMonitorTime;

    public PagePerformanceDataInfo(@Nullable String str, @Nullable String str2, @NotNull Argus.MergeResult mergeResult, long j3, long j16, long j17, boolean z16, long j18, @Nullable NodePO nodePO) {
        Intrinsics.checkNotNullParameter(mergeResult, "mergeResult");
        this.fromPageInfo = str;
        this.newPageInfo = str2;
        this.mergeResult = mergeResult;
        this.firstDrawTime = j3;
        this.startMonitorTime = j16;
        this.stopMonitorTime = j17;
        this.isDeadlineUpdate = z16;
        this.recyclerViewFirstItemAttachWindowTime = j18;
        this.recyclerView = nodePO;
    }

    public static /* synthetic */ PagePerformanceDataInfo copy$default(PagePerformanceDataInfo pagePerformanceDataInfo, String str, String str2, Argus.MergeResult mergeResult, long j3, long j16, long j17, boolean z16, long j18, NodePO nodePO, int i3, Object obj) {
        String str3;
        String str4;
        Argus.MergeResult mergeResult2;
        long j19;
        long j26;
        long j27;
        boolean z17;
        long j28;
        NodePO nodePO2;
        if ((i3 & 1) != 0) {
            str3 = pagePerformanceDataInfo.fromPageInfo;
        } else {
            str3 = str;
        }
        if ((i3 & 2) != 0) {
            str4 = pagePerformanceDataInfo.newPageInfo;
        } else {
            str4 = str2;
        }
        if ((i3 & 4) != 0) {
            mergeResult2 = pagePerformanceDataInfo.mergeResult;
        } else {
            mergeResult2 = mergeResult;
        }
        if ((i3 & 8) != 0) {
            j19 = pagePerformanceDataInfo.firstDrawTime;
        } else {
            j19 = j3;
        }
        if ((i3 & 16) != 0) {
            j26 = pagePerformanceDataInfo.startMonitorTime;
        } else {
            j26 = j16;
        }
        if ((i3 & 32) != 0) {
            j27 = pagePerformanceDataInfo.stopMonitorTime;
        } else {
            j27 = j17;
        }
        if ((i3 & 64) != 0) {
            z17 = pagePerformanceDataInfo.isDeadlineUpdate;
        } else {
            z17 = z16;
        }
        if ((i3 & 128) != 0) {
            j28 = pagePerformanceDataInfo.recyclerViewFirstItemAttachWindowTime;
        } else {
            j28 = j18;
        }
        if ((i3 & 256) != 0) {
            nodePO2 = pagePerformanceDataInfo.recyclerView;
        } else {
            nodePO2 = nodePO;
        }
        return pagePerformanceDataInfo.copy(str3, str4, mergeResult2, j19, j26, j27, z17, j28, nodePO2);
    }

    @NotNull
    public final PagePerformanceDataInfo copy(@Nullable String fromPageInfo, @Nullable String newPageInfo, @NotNull Argus.MergeResult mergeResult, long firstDrawTime, long startMonitorTime, long stopMonitorTime, boolean isDeadlineUpdate, long recyclerViewFirstItemAttachWindowTime, @Nullable NodePO recyclerView) {
        Intrinsics.checkNotNullParameter(mergeResult, "mergeResult");
        return new PagePerformanceDataInfo(fromPageInfo, newPageInfo, mergeResult, firstDrawTime, startMonitorTime, stopMonitorTime, isDeadlineUpdate, recyclerViewFirstItemAttachWindowTime, recyclerView);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PagePerformanceDataInfo) {
                PagePerformanceDataInfo pagePerformanceDataInfo = (PagePerformanceDataInfo) other;
                if (!Intrinsics.areEqual(this.fromPageInfo, pagePerformanceDataInfo.fromPageInfo) || !Intrinsics.areEqual(this.newPageInfo, pagePerformanceDataInfo.newPageInfo) || !Intrinsics.areEqual(this.mergeResult, pagePerformanceDataInfo.mergeResult) || this.firstDrawTime != pagePerformanceDataInfo.firstDrawTime || this.startMonitorTime != pagePerformanceDataInfo.startMonitorTime || this.stopMonitorTime != pagePerformanceDataInfo.stopMonitorTime || this.isDeadlineUpdate != pagePerformanceDataInfo.isDeadlineUpdate || this.recyclerViewFirstItemAttachWindowTime != pagePerformanceDataInfo.recyclerViewFirstItemAttachWindowTime || !Intrinsics.areEqual(this.recyclerView, pagePerformanceDataInfo.recyclerView)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getFromPageInfo() {
        return this.fromPageInfo;
    }

    @NotNull
    public final Argus.MergeResult getMergeResult() {
        return this.mergeResult;
    }

    @Nullable
    public final String getNewPageInfo() {
        return this.newPageInfo;
    }

    @Nullable
    public final NodePO getRecyclerView() {
        return this.recyclerView;
    }

    public final long getRecyclerViewFirstItemAttachWindowTime() {
        return this.recyclerViewFirstItemAttachWindowTime;
    }

    public final long getStartMonitorTime() {
        return this.startMonitorTime;
    }

    public final long getStopMonitorTime() {
        return this.stopMonitorTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.fromPageInfo;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.newPageInfo;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        Argus.MergeResult mergeResult = this.mergeResult;
        if (mergeResult != null) {
            i17 = mergeResult.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        long j3 = this.firstDrawTime;
        int i28 = (i27 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.startMonitorTime;
        int i29 = (i28 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.stopMonitorTime;
        int i36 = (i29 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        boolean z16 = this.isDeadlineUpdate;
        int i37 = z16;
        if (z16 != 0) {
            i37 = 1;
        }
        int i38 = (i36 + i37) * 31;
        long j18 = this.recyclerViewFirstItemAttachWindowTime;
        int i39 = (i38 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        NodePO nodePO = this.recyclerView;
        if (nodePO != null) {
            i18 = nodePO.hashCode();
        }
        return i39 + i18;
    }

    /* renamed from: isDeadlineUpdate, reason: from getter */
    public final boolean getIsDeadlineUpdate() {
        return this.isDeadlineUpdate;
    }

    public final void setDeadlineUpdate(boolean z16) {
        this.isDeadlineUpdate = z16;
    }

    public final void setNewPageInfo(@Nullable String str) {
        this.newPageInfo = str;
    }

    public final void setRecyclerView(@Nullable NodePO nodePO) {
        this.recyclerView = nodePO;
    }

    public final void setRecyclerViewFirstItemAttachWindowTime(long j3) {
        this.recyclerViewFirstItemAttachWindowTime = j3;
    }

    public final void setStartMonitorTime(long j3) {
        this.startMonitorTime = j3;
    }

    public final void setStopMonitorTime(long j3) {
        this.stopMonitorTime = j3;
    }

    @NotNull
    public String toString() {
        return "PagePerformanceDataInfo(fromPageInfo=" + this.fromPageInfo + ", newPageInfo=" + this.newPageInfo + ", mergeResult=" + this.mergeResult + ", firstDrawTime=" + this.firstDrawTime + ", startMonitorTime=" + this.startMonitorTime + ", stopMonitorTime=" + this.stopMonitorTime + ", isDeadlineUpdate=" + this.isDeadlineUpdate + ", recyclerViewFirstItemAttachWindowTime=" + this.recyclerViewFirstItemAttachWindowTime + ", recyclerView=" + this.recyclerView + ")";
    }

    public /* synthetic */ PagePerformanceDataInfo(String str, String str2, Argus.MergeResult mergeResult, long j3, long j16, long j17, boolean z16, long j18, NodePO nodePO, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, mergeResult, j3, j16, (i3 & 32) != 0 ? 0L : j17, (i3 & 64) != 0 ? false : z16, (i3 & 128) != 0 ? 0L : j18, (i3 & 256) != 0 ? null : nodePO);
    }
}
