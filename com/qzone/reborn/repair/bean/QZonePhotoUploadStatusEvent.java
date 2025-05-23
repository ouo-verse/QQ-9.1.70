package com.qzone.reborn.repair.bean;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/repair/bean/QZonePhotoUploadStatusEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "cacheKey", "", "state", "", "photoSource", "progress", "(JLjava/lang/String;ILjava/lang/String;I)V", "getCacheKey", "()Ljava/lang/String;", "setCacheKey", "(Ljava/lang/String;)V", "getPhotoSource", "setPhotoSource", HippyQQPagView.FunctionName.GET_PROGRESS, "()I", HippyQQPagView.FunctionName.SET_PROGRESS, "(I)V", "getState", "setState", "getTaskId", "()J", "setTaskId", "(J)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZonePhotoUploadStatusEvent extends SimpleBaseEvent {
    private String cacheKey;
    private String photoSource;
    private int progress;
    private int state;
    private long taskId;

    public QZonePhotoUploadStatusEvent() {
        this(0L, null, 0, null, 0, 31, null);
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final String getPhotoSource() {
        return this.photoSource;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public final void setCacheKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cacheKey = str;
    }

    public final void setPhotoSource(String str) {
        this.photoSource = str;
    }

    public final void setProgress(int i3) {
        this.progress = i3;
    }

    public final void setState(int i3) {
        this.state = i3;
    }

    public final void setTaskId(long j3) {
        this.taskId = j3;
    }

    public /* synthetic */ QZonePhotoUploadStatusEvent(long j3, String str, int i3, String str2, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0L : j3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? null : str2, (i17 & 16) != 0 ? 0 : i16);
    }

    public QZonePhotoUploadStatusEvent(long j3, String cacheKey, int i3, String str, int i16) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.taskId = j3;
        this.cacheKey = cacheKey;
        this.state = i3;
        this.photoSource = str;
        this.progress = i16;
    }
}
