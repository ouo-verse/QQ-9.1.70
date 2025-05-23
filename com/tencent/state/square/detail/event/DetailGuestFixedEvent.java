package com.tencent.state.square.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/detail/event/DetailGuestFixedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "uin", "", QCircleDaTongConstant.ElementParamValue.FIXED, "", "(Ljava/lang/String;Z)V", "getFixed", "()Z", "getUin", "()Ljava/lang/String;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailGuestFixedEvent extends SimpleBaseEvent {
    private final boolean fixed;
    private final String uin;

    public DetailGuestFixedEvent(String uin, boolean z16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.fixed = z16;
    }

    public final boolean getFixed() {
        return this.fixed;
    }

    public final String getUin() {
        return this.uin;
    }
}
