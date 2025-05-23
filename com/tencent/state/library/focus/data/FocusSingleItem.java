package com.tencent.state.library.focus.data;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.template.data.User;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/library/focus/data/FocusSingleItem;", "Lcom/tencent/state/library/focus/data/FocusBaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "(Lcom/tencent/state/library/focus/data/FocusItem;)V", "getFocusItem", "uin", "", "getLeftAvatar", "getRightAvatar", "getSingleItem", "isSingleUser", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusSingleItem extends FocusBaseItem {
    private final FocusItem item;

    public FocusSingleItem(FocusItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    public FocusItem getFocusItem(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        User user = this.item.getUser();
        if (Intrinsics.areEqual(uin, user != null ? user.getUin() : null)) {
            return this.item;
        }
        return null;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    /* renamed from: getLeftAvatar, reason: from getter */
    public FocusItem getItem() {
        return this.item;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    /* renamed from: getRightAvatar */
    public FocusItem getRightItem() {
        return this.item;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    public FocusItem getSingleItem() {
        return this.item;
    }

    @Override // com.tencent.state.library.focus.data.FocusBaseItem
    public boolean isSingleUser() {
        return true;
    }
}
