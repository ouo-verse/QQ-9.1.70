package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/event/QFSSpringFestivalPartStateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isInit", "", "instanceHashCode", "", "(ZI)V", "getInstanceHashCode", "()I", "()Z", "toString", "", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QFSSpringFestivalPartStateEvent extends SimpleBaseEvent {
    private final int instanceHashCode;
    private final boolean isInit;

    public QFSSpringFestivalPartStateEvent(boolean z16, int i3) {
        this.isInit = z16;
        this.instanceHashCode = i3;
    }

    public final int getInstanceHashCode() {
        return this.instanceHashCode;
    }

    /* renamed from: isInit, reason: from getter */
    public final boolean getIsInit() {
        return this.isInit;
    }

    @NotNull
    public String toString() {
        return "QFSSpringFestivalPartStateEvent(isInit=" + this.isInit + ", instanceHashCode=" + this.instanceHashCode + ')';
    }
}
