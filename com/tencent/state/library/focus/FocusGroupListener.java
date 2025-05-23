package com.tencent.state.library.focus;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.ClickType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/library/focus/FocusGroupListener;", "Lcom/tencent/state/library/focus/FocusBaseListener;", "clearUnReadCache", "", "uin", "", "doFuncBtnClick", "type", "Lcom/tencent/state/library/focus/view/ClickType;", "isPublicChatEnabled", "", "onCallMateClick", "onChatBoxClicked", "v", "Landroid/view/View;", "nick", "onEmptyTableClicked", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface FocusGroupListener extends FocusBaseListener {
    void clearUnReadCache(String uin);

    void doFuncBtnClick(ClickType type);

    boolean isPublicChatEnabled();

    void onCallMateClick();

    void onChatBoxClicked(View v3, String uin, String nick);

    void onEmptyTableClicked(int type, FocusItem item);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onChatBoxClicked$default(FocusGroupListener focusGroupListener, View view, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = null;
                }
                focusGroupListener.onChatBoxClicked(view, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onChatBoxClicked");
        }
    }
}
