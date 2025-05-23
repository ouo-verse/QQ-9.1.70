package com.tencent.state.library.focus.data;

import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/library/focus/data/FocusItem;", "", "table", "Lcom/tencent/state/template/data/Table;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "roomId", "", "(Lcom/tencent/state/template/data/Table;Lcom/tencent/state/template/data/User;J)V", "getRoomId", "()J", "getTable", "()Lcom/tencent/state/template/data/Table;", "getUser", "()Lcom/tencent/state/template/data/User;", "setUser", "(Lcom/tencent/state/template/data/User;)V", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusItem {
    private final long roomId;
    private final Table table;
    private User user;

    public FocusItem(Table table, User user, long j3) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.user = user;
        this.roomId = j3;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public Table getTable() {
        return this.table;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "FocusItem(user=" + getUser() + ", roomId=" + getRoomId() + ')';
    }

    public /* synthetic */ FocusItem(Table table, User user, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(table, (i3 & 2) != 0 ? null : user, j3);
    }
}
