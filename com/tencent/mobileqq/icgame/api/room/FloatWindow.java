package com.tencent.mobileqq.icgame.api.room;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/room/FloatWindow;", "Ljava/io/Serializable;", "()V", "floatStatus", "", "floatUserIdentify", "floatRoomId", "", "(IIJ)V", "getFloatRoomId", "()J", "setFloatRoomId", "(J)V", "getFloatStatus", "()I", "setFloatStatus", "(I)V", "getFloatUserIdentify", "setFloatUserIdentify", "toString", "", "Companion", "ic-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class FloatWindow implements Serializable {
    public static final int STATUS_DESTROY = 2;
    public static final int STATUS_HIDE = 0;
    public static final int STATUS_SHOW = 1;
    public static final int USER_IDENTIFY_ANCHOR = 1;
    public static final int USER_IDENTIFY_AUDIENCE = 0;
    private long floatRoomId;
    private int floatStatus;
    private int floatUserIdentify;

    public FloatWindow() {
        this.floatStatus = -1;
        this.floatUserIdentify = -1;
        this.floatRoomId = -1L;
    }

    public final long getFloatRoomId() {
        return this.floatRoomId;
    }

    public final int getFloatStatus() {
        return this.floatStatus;
    }

    public final int getFloatUserIdentify() {
        return this.floatUserIdentify;
    }

    public final void setFloatRoomId(long j3) {
        this.floatRoomId = j3;
    }

    public final void setFloatStatus(int i3) {
        this.floatStatus = i3;
    }

    public final void setFloatUserIdentify(int i3) {
        this.floatUserIdentify = i3;
    }

    @NotNull
    public String toString() {
        return "FloatWindow(floatStatus=" + this.floatStatus + ", floatUserIdentify=" + this.floatUserIdentify + ", floatRoomId=" + this.floatRoomId + ')';
    }

    public FloatWindow(int i3, int i16, long j3) {
        this.floatStatus = i3;
        this.floatUserIdentify = i16;
        this.floatRoomId = j3;
    }
}
