package com.tencent.state.template.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/template/event/GlobalMeFocusStartSquareEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "type", "Lcom/tencent/state/template/event/FocusType;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "tableId", "", "(Lcom/tencent/state/template/event/FocusType;Lcom/tencent/state/template/data/User;J)V", "getTableId", "()J", "getType", "()Lcom/tencent/state/template/event/FocusType;", "getUser", "()Lcom/tencent/state/template/data/User;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class GlobalMeFocusStartSquareEvent extends SimpleBaseEvent {
    private final long tableId;
    private final FocusType type;
    private final User user;

    public GlobalMeFocusStartSquareEvent(FocusType type, User user, long j3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(user, "user");
        this.type = type;
        this.user = user;
        this.tableId = j3;
    }

    public final long getTableId() {
        return this.tableId;
    }

    public final FocusType getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }
}
