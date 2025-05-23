package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSMessageQuickThankEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "launch", "", "(I)V", "getLaunch", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QFSMessageQuickThankEvent extends SimpleBaseEvent {
    private final int launch;

    public QFSMessageQuickThankEvent(int i3) {
        this.launch = i3;
    }

    public static /* synthetic */ QFSMessageQuickThankEvent copy$default(QFSMessageQuickThankEvent qFSMessageQuickThankEvent, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = qFSMessageQuickThankEvent.launch;
        }
        return qFSMessageQuickThankEvent.copy(i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLaunch() {
        return this.launch;
    }

    @NotNull
    public final QFSMessageQuickThankEvent copy(int launch) {
        return new QFSMessageQuickThankEvent(launch);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof QFSMessageQuickThankEvent) && this.launch == ((QFSMessageQuickThankEvent) other).launch) {
            return true;
        }
        return false;
    }

    public final int getLaunch() {
        return this.launch;
    }

    public int hashCode() {
        return this.launch;
    }

    @NotNull
    public String toString() {
        return "QFSMessageQuickThankEvent(launch=" + this.launch + ")";
    }
}
