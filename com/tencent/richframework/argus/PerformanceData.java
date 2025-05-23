package com.tencent.richframework.argus;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.richframework.argus.node.NodePO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/richframework/argus/PerformanceData;", "", "", "toString", "", "hashCode", "other", "", "equals", "screenRefreshRate", "I", "getScreenRefreshRate", "()I", "Lcom/tencent/richframework/argus/node/NodePO;", "blockNodeInfo", "Lcom/tencent/richframework/argus/node/NodePO;", "getBlockNodeInfo", "()Lcom/tencent/richframework/argus/node/NodePO;", "setBlockNodeInfo", "(Lcom/tencent/richframework/argus/node/NodePO;)V", "", "", "fps", "Ljava/util/List;", "getFps", "()Ljava/util/List;", "smoothRate", UserInfo.SEX_FEMALE, "getSmoothRate", "()F", "setSmoothRate", "(F)V", "", "monitorDuration", "J", "getMonitorDuration", "()J", "setMonitorDuration", "(J)V", "<init>", "(ILcom/tencent/richframework/argus/node/NodePO;Ljava/util/List;FJ)V", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class PerformanceData {

    @Nullable
    private NodePO blockNodeInfo;

    @NotNull
    private final List<Float> fps;
    private long monitorDuration;
    private final int screenRefreshRate;
    private float smoothRate;

    public PerformanceData(int i3, @Nullable NodePO nodePO, @NotNull List<Float> fps, float f16, long j3) {
        Intrinsics.checkNotNullParameter(fps, "fps");
        this.screenRefreshRate = i3;
        this.blockNodeInfo = nodePO;
        this.fps = fps;
        this.smoothRate = f16;
        this.monitorDuration = j3;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PerformanceData) {
                PerformanceData performanceData = (PerformanceData) other;
                if (this.screenRefreshRate != performanceData.screenRefreshRate || !Intrinsics.areEqual(this.blockNodeInfo, performanceData.blockNodeInfo) || !Intrinsics.areEqual(this.fps, performanceData.fps) || Float.compare(this.smoothRate, performanceData.smoothRate) != 0 || this.monitorDuration != performanceData.monitorDuration) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<Float> getFps() {
        return this.fps;
    }

    public int hashCode() {
        int i3;
        int i16 = this.screenRefreshRate * 31;
        NodePO nodePO = this.blockNodeInfo;
        int i17 = 0;
        if (nodePO != null) {
            i3 = nodePO.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        List<Float> list = this.fps;
        if (list != null) {
            i17 = list.hashCode();
        }
        int floatToIntBits = (((i18 + i17) * 31) + Float.floatToIntBits(this.smoothRate)) * 31;
        long j3 = this.monitorDuration;
        return floatToIntBits + ((int) (j3 ^ (j3 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "PerformanceData(screenRefreshRate=" + this.screenRefreshRate + ", blockNodeInfo=" + this.blockNodeInfo + ", fps=" + this.fps + ", smoothRate=" + this.smoothRate + ", monitorDuration=" + this.monitorDuration + ")";
    }
}
