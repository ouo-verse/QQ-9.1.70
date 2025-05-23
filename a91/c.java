package a91;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.activity.aio.s;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    public static View a(ChatMessage chatMessage, ChatXListView chatXListView) {
        if (chatMessage == null || chatXListView == null) {
            return null;
        }
        int b16 = ((s) ((HeaderViewListAdapter) chatXListView.getAdapter()).getWrappedAdapter()).b(chatMessage) + chatXListView.getHeaderViewsCount();
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.DEL_MSG, 2, "pos is:" + b16);
        }
        if (b16 < 0) {
            return null;
        }
        return chatXListView.getChildAt(b16 - chatXListView.getFirstVisiblePosition());
    }

    public static Rect b(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
