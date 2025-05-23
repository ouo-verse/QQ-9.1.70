package com.qzone.reborn.albumx.common.bean;

import com.qzone.proxy.feedcomponent.model.n;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "hasRunningTask", "b", "hasWaitRunningTask", "", "c", "J", "()J", "lastBeginTime", "d", "I", "()I", "taskSize", "<init>", "(ZZJI)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.reborn.albumx.common.bean.j, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class CommonTransmitBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasRunningTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasWaitRunningTask;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long lastBeginTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int taskSize;

    public CommonTransmitBean(boolean z16, boolean z17, long j3, int i3) {
        this.hasRunningTask = z16;
        this.hasWaitRunningTask = z17;
        this.lastBeginTime = j3;
        this.taskSize = i3;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasRunningTask() {
        return this.hasRunningTask;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasWaitRunningTask() {
        return this.hasWaitRunningTask;
    }

    /* renamed from: c, reason: from getter */
    public final long getLastBeginTime() {
        return this.lastBeginTime;
    }

    /* renamed from: d, reason: from getter */
    public final int getTaskSize() {
        return this.taskSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.hasRunningTask;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.hasWaitRunningTask;
        return ((((i3 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + n.a(this.lastBeginTime)) * 31) + this.taskSize;
    }

    public String toString() {
        return "CommonTransmitBean(hasRunningTask=" + this.hasRunningTask + ", hasWaitRunningTask=" + this.hasWaitRunningTask + ", lastBeginTime=" + this.lastBeginTime + ", taskSize=" + this.taskSize + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonTransmitBean)) {
            return false;
        }
        CommonTransmitBean commonTransmitBean = (CommonTransmitBean) other;
        return this.hasRunningTask == commonTransmitBean.hasRunningTask && this.hasWaitRunningTask == commonTransmitBean.hasWaitRunningTask && this.lastBeginTime == commonTransmitBean.lastBeginTime && this.taskSize == commonTransmitBean.taskSize;
    }
}
