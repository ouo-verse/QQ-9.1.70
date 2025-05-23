package com.qzone.reborn.albumx.common.viewmodel;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\n\u0010\b\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0019\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/a;", "", "", "toString", "", "a", "I", "getTaskId", "()I", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "b", "getTotalCount", "totalCount", "", "c", "J", "startTimeStamp", "d", "f", "(I)V", "successCount", "e", "failCount", "", "()Z", "isFinish", "isAllSuccess", "<init>", "(IIJII)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int totalCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long startTimeStamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int successCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int failCount;

    public a(int i3, int i16, long j3, int i17, int i18) {
        this.taskId = i3;
        this.totalCount = i16;
        this.startTimeStamp = j3;
        this.successCount = i17;
        this.failCount = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getFailCount() {
        return this.failCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getSuccessCount() {
        return this.successCount;
    }

    public final boolean c() {
        return this.totalCount == this.successCount;
    }

    public final boolean d() {
        return this.totalCount == this.successCount + this.failCount;
    }

    public final void e(int i3) {
        this.failCount = i3;
    }

    public final void f(int i3) {
        this.successCount = i3;
    }

    public String toString() {
        return "BatchDownloadInfo{ id: " + this.taskId + ", total: " + this.totalCount + ", startTime: " + this.startTimeStamp + ", success: " + this.successCount + ", fail: " + this.failCount + " }";
    }

    public /* synthetic */ a(int i3, int i16, long j3, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, j3, (i19 & 8) != 0 ? 0 : i17, (i19 & 16) != 0 ? 0 : i18);
    }
}
