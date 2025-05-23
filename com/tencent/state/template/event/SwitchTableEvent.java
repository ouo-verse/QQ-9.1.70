package com.tencent.state.template.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/template/event/SwitchTableEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "roomId", "", "tableId", "fromFocusFragment", "", "(Lcom/tencent/state/template/data/User;JJZ)V", "getFromFocusFragment", "()Z", "getRoomId", "()J", "getTableId", "getUser", "()Lcom/tencent/state/template/data/User;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SwitchTableEvent extends SimpleBaseEvent {
    private final boolean fromFocusFragment;
    private final long roomId;
    private final long tableId;
    private final User user;

    public SwitchTableEvent(User user, long j3, long j16, boolean z16) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.user = user;
        this.roomId = j3;
        this.tableId = j16;
        this.fromFocusFragment = z16;
    }

    public final boolean getFromFocusFragment() {
        return this.fromFocusFragment;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getTableId() {
        return this.tableId;
    }

    public final User getUser() {
        return this.user;
    }
}
