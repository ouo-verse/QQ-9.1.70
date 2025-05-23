package com.tencent.mobileqq.minigame.manager;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/minigame/manager/MiniGamePkgExceptionInfo;", "", "appId", "", "crashCount", "", "updateTime", "", "exceptionFilePath", "zipCreateTime", "(Ljava/lang/String;IJLjava/lang/String;J)V", "getAppId", "()Ljava/lang/String;", "getCrashCount", "()I", "setCrashCount", "(I)V", "getExceptionFilePath", "setExceptionFilePath", "(Ljava/lang/String;)V", "getUpdateTime", "()J", "setUpdateTime", "(J)V", "getZipCreateTime", "setZipCreateTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class MiniGamePkgExceptionInfo {
    private final String appId;
    private int crashCount;
    private String exceptionFilePath;
    private long updateTime;
    private long zipCreateTime;

    public MiniGamePkgExceptionInfo(String appId, int i3, long j3, String exceptionFilePath, long j16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(exceptionFilePath, "exceptionFilePath");
        this.appId = appId;
        this.crashCount = i3;
        this.updateTime = j3;
        this.exceptionFilePath = exceptionFilePath;
        this.zipCreateTime = j16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCrashCount() {
        return this.crashCount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExceptionFilePath() {
        return this.exceptionFilePath;
    }

    /* renamed from: component5, reason: from getter */
    public final long getZipCreateTime() {
        return this.zipCreateTime;
    }

    public final MiniGamePkgExceptionInfo copy(String appId, int crashCount, long updateTime, String exceptionFilePath, long zipCreateTime) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(exceptionFilePath, "exceptionFilePath");
        return new MiniGamePkgExceptionInfo(appId, crashCount, updateTime, exceptionFilePath, zipCreateTime);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getCrashCount() {
        return this.crashCount;
    }

    public final String getExceptionFilePath() {
        return this.exceptionFilePath;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final long getZipCreateTime() {
        return this.zipCreateTime;
    }

    public int hashCode() {
        return (((((((this.appId.hashCode() * 31) + this.crashCount) * 31) + com.tencent.mobileqq.mini.appbrand.utils.f.a(this.updateTime)) * 31) + this.exceptionFilePath.hashCode()) * 31) + com.tencent.mobileqq.mini.appbrand.utils.f.a(this.zipCreateTime);
    }

    public final void setCrashCount(int i3) {
        this.crashCount = i3;
    }

    public final void setExceptionFilePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.exceptionFilePath = str;
    }

    public final void setUpdateTime(long j3) {
        this.updateTime = j3;
    }

    public final void setZipCreateTime(long j3) {
        this.zipCreateTime = j3;
    }

    public String toString() {
        return "MiniGamePkgExceptionInfo(appId=" + this.appId + ", crashCount=" + this.crashCount + ", updateTime=" + this.updateTime + ", exceptionFilePath=" + this.exceptionFilePath + ", zipCreateTime=" + this.zipCreateTime + ")";
    }

    public /* synthetic */ MiniGamePkgExceptionInfo(String str, int i3, long j3, String str2, long j16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) != 0 ? "" : str2, (i16 & 16) == 0 ? j16 : 0L);
    }

    public static /* synthetic */ MiniGamePkgExceptionInfo copy$default(MiniGamePkgExceptionInfo miniGamePkgExceptionInfo, String str, int i3, long j3, String str2, long j16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = miniGamePkgExceptionInfo.appId;
        }
        if ((i16 & 2) != 0) {
            i3 = miniGamePkgExceptionInfo.crashCount;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            j3 = miniGamePkgExceptionInfo.updateTime;
        }
        long j17 = j3;
        if ((i16 & 8) != 0) {
            str2 = miniGamePkgExceptionInfo.exceptionFilePath;
        }
        String str3 = str2;
        if ((i16 & 16) != 0) {
            j16 = miniGamePkgExceptionInfo.zipCreateTime;
        }
        return miniGamePkgExceptionInfo.copy(str, i17, j17, str3, j16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniGamePkgExceptionInfo)) {
            return false;
        }
        MiniGamePkgExceptionInfo miniGamePkgExceptionInfo = (MiniGamePkgExceptionInfo) other;
        return Intrinsics.areEqual(this.appId, miniGamePkgExceptionInfo.appId) && this.crashCount == miniGamePkgExceptionInfo.crashCount && this.updateTime == miniGamePkgExceptionInfo.updateTime && Intrinsics.areEqual(this.exceptionFilePath, miniGamePkgExceptionInfo.exceptionFilePath) && this.zipCreateTime == miniGamePkgExceptionInfo.zipCreateTime;
    }
}
