package com.tencent.state.library.focus.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/library/focus/data/FocusBaseItem;", "", "()V", "getFocusItem", "Lcom/tencent/state/library/focus/data/FocusItem;", "uin", "", "getLeftAvatar", "getRightAvatar", "getSingleItem", "isSingleUser", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class FocusBaseItem {
    public abstract FocusItem getFocusItem(String uin);

    public abstract FocusItem getLeftAvatar();

    public abstract FocusItem getRightAvatar();

    public abstract FocusItem getSingleItem();

    public abstract boolean isSingleUser();
}
