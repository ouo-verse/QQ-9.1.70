package com.tencent.state.library.focus.data;

import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/library/focus/data/FocusGroupItem;", "Lcom/tencent/state/library/focus/data/FocusBaseItem;", "leftItem", "Lcom/tencent/state/library/focus/data/FocusItem;", "rightItem", "(Lcom/tencent/state/library/focus/data/FocusItem;Lcom/tencent/state/library/focus/data/FocusItem;)V", "getFocusItem", "uin", "", "getLeftAvatar", "getRightAvatar", "getSingleItem", "isSingleUser", "", "switchTable", "roomId", "", "tableId", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusGroupItem extends FocusBaseItem {
    private FocusItem leftItem;
    private FocusItem rightItem;

    public FocusGroupItem(FocusItem leftItem, FocusItem rightItem) {
        Intrinsics.checkNotNullParameter(leftItem, "leftItem");
        Intrinsics.checkNotNullParameter(rightItem, "rightItem");
        this.leftItem = leftItem;
        this.rightItem = rightItem;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    public FocusItem getFocusItem(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        User user = this.leftItem.getUser();
        if (Intrinsics.areEqual(user != null ? user.getUin() : null, uin)) {
            return this.leftItem;
        }
        User user2 = this.rightItem.getUser();
        if (Intrinsics.areEqual(user2 != null ? user2.getUin() : null, uin)) {
            return this.rightItem;
        }
        return null;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    /* renamed from: getLeftAvatar, reason: from getter */
    public FocusItem getLeftItem() {
        return this.leftItem;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    /* renamed from: getRightAvatar, reason: from getter */
    public FocusItem getRightItem() {
        return this.rightItem;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    public FocusItem getSingleItem() {
        if (this.leftItem.getUser() == null) {
            return this.rightItem;
        }
        return this.leftItem;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    public boolean isSingleUser() {
        return this.leftItem.getUser() == null || this.rightItem.getUser() == null;
    }

    public final boolean switchTable(long roomId, long tableId, User user) {
        FocusItem focusItem;
        FocusItem focusItem2;
        User user2;
        Intrinsics.checkNotNullParameter(user, "user");
        if (this.leftItem.getRoomId() != roomId) {
            return false;
        }
        String str = null;
        if (this.leftItem.getTable().getId() == tableId) {
            focusItem = this.leftItem;
        } else {
            focusItem = this.rightItem.getTable().getId() == tableId ? this.rightItem : null;
            if (focusItem == null) {
                return false;
            }
        }
        if (focusItem.getUser() != null) {
            return false;
        }
        Table neighbor = focusItem.getTable().getNeighbor();
        if (neighbor != null && (user2 = neighbor.getUser()) != null) {
            str = user2.getUin();
        }
        if (Intrinsics.areEqual(str, user.getUin())) {
            return false;
        }
        if (Intrinsics.areEqual(focusItem, this.leftItem)) {
            focusItem2 = this.rightItem;
        } else {
            focusItem2 = this.leftItem;
        }
        focusItem.setUser(user);
        Table neighbor2 = focusItem.getTable().getNeighbor();
        if (neighbor2 != null) {
            neighbor2.setUser(focusItem2.getUser());
        }
        Table neighbor3 = focusItem2.getTable().getNeighbor();
        if (neighbor3 == null) {
            return true;
        }
        neighbor3.setUser(user);
        return true;
    }

    public String toString() {
        return "FocusGroupItem(leftItem=" + this.leftItem + ", rightItem=" + this.rightItem + ')';
    }
}
