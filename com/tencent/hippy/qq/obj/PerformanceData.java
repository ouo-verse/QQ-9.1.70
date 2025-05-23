package com.tencent.hippy.qq.obj;

import com.tencent.mtt.hippy.common.HippyMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\b\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/tencent/hippy/qq/obj/PerformanceData;", "", "()V", "dataLoadEndTime", "", "getDataLoadEndTime", "()J", "setDataLoadEndTime", "(J)V", "dataLoadStartTime", "getDataLoadStartTime", "setDataLoadStartTime", "decodeEndTime", "getDecodeEndTime", "setDecodeEndTime", "downLoadEndTime", "getDownLoadEndTime", "setDownLoadEndTime", "downLoadStartTime", "getDownLoadStartTime", "setDownLoadStartTime", "isUsedCache", "", "()Z", "getData", "Lcom/tencent/mtt/hippy/common/HippyMap;", "recordDataLoadEndTime", "", "recordDataLoadStartTime", "recordDecodeEndTime", "recordDownLoadEndTime", "recordDownLoadStartTime", "reset", "toString", "", "Companion", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class PerformanceData {

    @NotNull
    private static final String TAG = "PerformanceData";
    private long dataLoadEndTime;
    private long dataLoadStartTime;
    private long decodeEndTime;
    private long downLoadEndTime;
    private long downLoadStartTime;

    @NotNull
    public final HippyMap getData() {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushBoolean("isUsedCache", isUsedCache());
        hippyMap.pushLong("dataLoadStartTime", this.dataLoadStartTime);
        hippyMap.pushLong("downLoadStartTime", this.downLoadStartTime);
        hippyMap.pushLong("downLoadEndTime", this.downLoadEndTime);
        hippyMap.pushLong("decodeEndTime", this.decodeEndTime);
        hippyMap.pushLong("dataLoadEndTime", this.dataLoadEndTime);
        return hippyMap;
    }

    public final long getDataLoadEndTime() {
        return this.dataLoadEndTime;
    }

    public final long getDataLoadStartTime() {
        return this.dataLoadStartTime;
    }

    public final long getDecodeEndTime() {
        return this.decodeEndTime;
    }

    public final long getDownLoadEndTime() {
        return this.downLoadEndTime;
    }

    public final long getDownLoadStartTime() {
        return this.downLoadStartTime;
    }

    public final boolean isUsedCache() {
        if (this.downLoadStartTime == 0) {
            return true;
        }
        return false;
    }

    public final void recordDataLoadEndTime() {
        this.dataLoadEndTime = System.currentTimeMillis();
    }

    public final void recordDataLoadStartTime() {
        reset();
        this.dataLoadStartTime = System.currentTimeMillis();
    }

    public final void recordDecodeEndTime() {
        this.decodeEndTime = System.currentTimeMillis();
    }

    public final void recordDownLoadEndTime() {
        if (this.downLoadStartTime > 0) {
            this.downLoadEndTime = System.currentTimeMillis();
        }
    }

    public final void recordDownLoadStartTime() {
        this.downLoadStartTime = System.currentTimeMillis();
    }

    public final void reset() {
        this.dataLoadStartTime = 0L;
        this.downLoadStartTime = 0L;
        this.downLoadEndTime = 0L;
        this.dataLoadEndTime = 0L;
    }

    public final void setDataLoadEndTime(long j3) {
        this.dataLoadEndTime = j3;
    }

    public final void setDataLoadStartTime(long j3) {
        this.dataLoadStartTime = j3;
    }

    public final void setDecodeEndTime(long j3) {
        this.decodeEndTime = j3;
    }

    public final void setDownLoadEndTime(long j3) {
        this.downLoadEndTime = j3;
    }

    public final void setDownLoadStartTime(long j3) {
        this.downLoadStartTime = j3;
    }

    @NotNull
    public String toString() {
        return "PerformanceData(isUsedCache=" + isUsedCache() + ", dataLoadStartTime=" + this.dataLoadStartTime + ", downLoadStartTime=" + this.downLoadStartTime + ", downLoadEndTime=" + this.downLoadEndTime + ", dataLoadEndTime=" + this.dataLoadEndTime + ", decodeEndTime=" + this.decodeEndTime + ",  downloadCost=" + (this.downLoadEndTime - this.downLoadStartTime) + ", dataLoadCost=" + (this.dataLoadEndTime - this.dataLoadStartTime) + ", ThreadChangeCost=" + (this.dataLoadEndTime - this.decodeEndTime) + ')';
    }
}
