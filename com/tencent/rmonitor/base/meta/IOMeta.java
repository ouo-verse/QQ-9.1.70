package com.tencent.rmonitor.base.meta;

import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0007H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\u009f\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0005H\u00c6\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u00d6\u0003J\t\u0010;\u001a\u00020\u0007H\u00d6\u0001J\t\u0010<\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016\u00a8\u0006="}, d2 = {"Lcom/tencent/rmonitor/base/meta/IOMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "path", "", "fileSize", "", "opCnt", "", "opReadCnt", "opWriteCnt", "bufferSize", "opCostTime", "opType", "opSize", "opReadSize", "opWriteSize", "threadName", "processName", "stack", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "(Ljava/lang/String;JIIIJJIJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getBufferSize", "()J", "getFileSize", "getOpCnt", "()I", "getOpCostTime", "getOpReadCnt", "getOpReadSize", "getOpSize", "getOpType", "getOpWriteCnt", "getOpWriteSize", "getPath", "()Ljava/lang/String;", "getProcessName", "getStack", "getThreadName", "getTimeStamp", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* data */ class IOMeta extends MonitorMeta {
    private final long bufferSize;
    private final long fileSize;
    private final int opCnt;
    private final long opCostTime;
    private final int opReadCnt;
    private final long opReadSize;
    private final long opSize;
    private final int opType;
    private final int opWriteCnt;
    private final long opWriteSize;

    @NotNull
    private final String path;

    @NotNull
    private final String processName;

    @NotNull
    private final String stack;

    @NotNull
    private final String threadName;
    private final long timeStamp;

    public IOMeta(@NotNull String path, long j3, int i3, int i16, int i17, long j16, long j17, int i18, long j18, long j19, long j26, @NotNull String threadName, @NotNull String processName, @NotNull String stack, long j27) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(stack, "stack");
        this.path = path;
        this.fileSize = j3;
        this.opCnt = i3;
        this.opReadCnt = i16;
        this.opWriteCnt = i17;
        this.bufferSize = j16;
        this.opCostTime = j17;
        this.opType = i18;
        this.opSize = j18;
        this.opReadSize = j19;
        this.opWriteSize = j26;
        this.threadName = threadName;
        this.processName = processName;
        this.stack = stack;
        this.timeStamp = j27;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component10, reason: from getter */
    public final long getOpReadSize() {
        return this.opReadSize;
    }

    /* renamed from: component11, reason: from getter */
    public final long getOpWriteSize() {
        return this.opWriteSize;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getThreadName() {
        return this.threadName;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getProcessName() {
        return this.processName;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getStack() {
        return this.stack;
    }

    /* renamed from: component15, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: component2, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component3, reason: from getter */
    public final int getOpCnt() {
        return this.opCnt;
    }

    /* renamed from: component4, reason: from getter */
    public final int getOpReadCnt() {
        return this.opReadCnt;
    }

    /* renamed from: component5, reason: from getter */
    public final int getOpWriteCnt() {
        return this.opWriteCnt;
    }

    /* renamed from: component6, reason: from getter */
    public final long getBufferSize() {
        return this.bufferSize;
    }

    /* renamed from: component7, reason: from getter */
    public final long getOpCostTime() {
        return this.opCostTime;
    }

    /* renamed from: component8, reason: from getter */
    public final int getOpType() {
        return this.opType;
    }

    /* renamed from: component9, reason: from getter */
    public final long getOpSize() {
        return this.opSize;
    }

    @NotNull
    public final IOMeta copy(@NotNull String path, long fileSize, int opCnt, int opReadCnt, int opWriteCnt, long bufferSize, long opCostTime, int opType, long opSize, long opReadSize, long opWriteSize, @NotNull String threadName, @NotNull String processName, @NotNull String stack, long timeStamp) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(stack, "stack");
        return new IOMeta(path, fileSize, opCnt, opReadCnt, opWriteCnt, bufferSize, opCostTime, opType, opSize, opReadSize, opWriteSize, threadName, processName, stack, timeStamp);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        if (this != other) {
            if (other instanceof IOMeta) {
                IOMeta iOMeta = (IOMeta) other;
                if (Intrinsics.areEqual(this.path, iOMeta.path)) {
                    if (this.fileSize == iOMeta.fileSize) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (this.opCnt == iOMeta.opCnt) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            if (this.opReadCnt == iOMeta.opReadCnt) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                if (this.opWriteCnt == iOMeta.opWriteCnt) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (z19) {
                                    if (this.bufferSize == iOMeta.bufferSize) {
                                        z26 = true;
                                    } else {
                                        z26 = false;
                                    }
                                    if (z26) {
                                        if (this.opCostTime == iOMeta.opCostTime) {
                                            z27 = true;
                                        } else {
                                            z27 = false;
                                        }
                                        if (z27) {
                                            if (this.opType == iOMeta.opType) {
                                                z28 = true;
                                            } else {
                                                z28 = false;
                                            }
                                            if (z28) {
                                                if (this.opSize == iOMeta.opSize) {
                                                    z29 = true;
                                                } else {
                                                    z29 = false;
                                                }
                                                if (z29) {
                                                    if (this.opReadSize == iOMeta.opReadSize) {
                                                        z36 = true;
                                                    } else {
                                                        z36 = false;
                                                    }
                                                    if (z36) {
                                                        if (this.opWriteSize == iOMeta.opWriteSize) {
                                                            z37 = true;
                                                        } else {
                                                            z37 = false;
                                                        }
                                                        if (z37 && Intrinsics.areEqual(this.threadName, iOMeta.threadName) && Intrinsics.areEqual(this.processName, iOMeta.processName) && Intrinsics.areEqual(this.stack, iOMeta.stack)) {
                                                            if (this.timeStamp == iOMeta.timeStamp) {
                                                                z38 = true;
                                                            } else {
                                                                z38 = false;
                                                            }
                                                            if (z38) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final long getBufferSize() {
        return this.bufferSize;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getOpCnt() {
        return this.opCnt;
    }

    public final long getOpCostTime() {
        return this.opCostTime;
    }

    public final int getOpReadCnt() {
        return this.opReadCnt;
    }

    public final long getOpReadSize() {
        return this.opReadSize;
    }

    public final long getOpSize() {
        return this.opSize;
    }

    public final int getOpType() {
        return this.opType;
    }

    public final int getOpWriteCnt() {
        return this.opWriteCnt;
    }

    public final long getOpWriteSize() {
        return this.opWriteSize;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getProcessName() {
        return this.processName;
    }

    @NotNull
    public final String getStack() {
        return this.stack;
    }

    @NotNull
    public final String getThreadName() {
        return this.threadName;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.path;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        long j3 = this.fileSize;
        int i19 = ((((((((i3 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.opCnt) * 31) + this.opReadCnt) * 31) + this.opWriteCnt) * 31;
        long j16 = this.bufferSize;
        int i26 = (i19 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.opCostTime;
        int i27 = (((i26 + ((int) (j17 ^ (j17 >>> 32)))) * 31) + this.opType) * 31;
        long j18 = this.opSize;
        int i28 = (i27 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        long j19 = this.opReadSize;
        int i29 = (i28 + ((int) (j19 ^ (j19 >>> 32)))) * 31;
        long j26 = this.opWriteSize;
        int i36 = (i29 + ((int) (j26 ^ (j26 >>> 32)))) * 31;
        String str2 = this.threadName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i37 = (i36 + i16) * 31;
        String str3 = this.processName;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i38 = (i37 + i17) * 31;
        String str4 = this.stack;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        int i39 = (i38 + i18) * 31;
        long j27 = this.timeStamp;
        return i39 + ((int) (j27 ^ (j27 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "IOMeta(path=" + this.path + ", fileSize=" + this.fileSize + ", opCnt=" + this.opCnt + ", opReadCnt=" + this.opReadCnt + ", opWriteCnt=" + this.opWriteCnt + ", bufferSize=" + this.bufferSize + ", opCostTime=" + this.opCostTime + ", opType=" + this.opType + ", opSize=" + this.opSize + ", opReadSize=" + this.opReadSize + ", opWriteSize=" + this.opWriteSize + ", threadName=" + this.threadName + ", processName=" + this.processName + ", stack=" + this.stack + ", timeStamp=" + this.timeStamp + ")";
    }
}
