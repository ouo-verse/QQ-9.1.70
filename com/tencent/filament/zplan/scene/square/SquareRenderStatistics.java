package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\t\u0010 \u001a\u00020\u001fH\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010\u00a8\u0006!"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareRenderStatistics;", "", "bootTimeCost", "", "bootDownloadedFromNet", "", "loadSoCost", "firstFrameCost", "(JZJJ)V", "getBootDownloadedFromNet", "()Z", "setBootDownloadedFromNet", "(Z)V", "getBootTimeCost", "()J", "setBootTimeCost", "(J)V", "getFirstFrameCost", "setFirstFrameCost", "getLoadSoCost", "setLoadSoCost", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toJson", "", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class SquareRenderStatistics {
    private boolean bootDownloadedFromNet;
    private long bootTimeCost;
    private long firstFrameCost;
    private long loadSoCost;

    public SquareRenderStatistics() {
        this(0L, false, 0L, 0L, 15, null);
    }

    public static /* synthetic */ SquareRenderStatistics copy$default(SquareRenderStatistics squareRenderStatistics, long j3, boolean z16, long j16, long j17, int i3, Object obj) {
        long j18;
        boolean z17;
        long j19;
        long j26;
        if ((i3 & 1) != 0) {
            j18 = squareRenderStatistics.bootTimeCost;
        } else {
            j18 = j3;
        }
        if ((i3 & 2) != 0) {
            z17 = squareRenderStatistics.bootDownloadedFromNet;
        } else {
            z17 = z16;
        }
        if ((i3 & 4) != 0) {
            j19 = squareRenderStatistics.loadSoCost;
        } else {
            j19 = j16;
        }
        if ((i3 & 8) != 0) {
            j26 = squareRenderStatistics.firstFrameCost;
        } else {
            j26 = j17;
        }
        return squareRenderStatistics.copy(j18, z17, j19, j26);
    }

    /* renamed from: component1, reason: from getter */
    public final long getBootTimeCost() {
        return this.bootTimeCost;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getBootDownloadedFromNet() {
        return this.bootDownloadedFromNet;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLoadSoCost() {
        return this.loadSoCost;
    }

    /* renamed from: component4, reason: from getter */
    public final long getFirstFrameCost() {
        return this.firstFrameCost;
    }

    @NotNull
    public final SquareRenderStatistics copy(long bootTimeCost, boolean bootDownloadedFromNet, long loadSoCost, long firstFrameCost) {
        return new SquareRenderStatistics(bootTimeCost, bootDownloadedFromNet, loadSoCost, firstFrameCost);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareRenderStatistics) {
                SquareRenderStatistics squareRenderStatistics = (SquareRenderStatistics) other;
                if (this.bootTimeCost != squareRenderStatistics.bootTimeCost || this.bootDownloadedFromNet != squareRenderStatistics.bootDownloadedFromNet || this.loadSoCost != squareRenderStatistics.loadSoCost || this.firstFrameCost != squareRenderStatistics.firstFrameCost) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean getBootDownloadedFromNet() {
        return this.bootDownloadedFromNet;
    }

    public final long getBootTimeCost() {
        return this.bootTimeCost;
    }

    public final long getFirstFrameCost() {
        return this.firstFrameCost;
    }

    public final long getLoadSoCost() {
        return this.loadSoCost;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j3 = this.bootTimeCost;
        int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        boolean z16 = this.bootDownloadedFromNet;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        long j16 = this.loadSoCost;
        int i17 = (((i3 + i16) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.firstFrameCost;
        return i17 + ((int) ((j17 >>> 32) ^ j17));
    }

    public final void setBootDownloadedFromNet(boolean z16) {
        this.bootDownloadedFromNet = z16;
    }

    public final void setBootTimeCost(long j3) {
        this.bootTimeCost = j3;
    }

    public final void setFirstFrameCost(long j3) {
        this.firstFrameCost = j3;
    }

    public final void setLoadSoCost(long j3) {
        this.loadSoCost = j3;
    }

    @Nullable
    public final String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @NotNull
    public String toString() {
        return "SquareRenderStatistics(bootTimeCost=" + this.bootTimeCost + ", bootDownloadedFromNet=" + this.bootDownloadedFromNet + ", loadSoCost=" + this.loadSoCost + ", firstFrameCost=" + this.firstFrameCost + ")";
    }

    public SquareRenderStatistics(long j3, boolean z16, long j16, long j17) {
        this.bootTimeCost = j3;
        this.bootDownloadedFromNet = z16;
        this.loadSoCost = j16;
        this.firstFrameCost = j17;
    }

    public /* synthetic */ SquareRenderStatistics(long j3, boolean z16, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? 0L : j16, (i3 & 8) != 0 ? 0L : j17);
    }
}
