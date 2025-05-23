package com.tencent.state.view;

import android.widget.LinearLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J$\u0010\u0011\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/view/IDetailBubbleMainContainer;", "", "clearText", "", "getAddViewLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "getTextString", "", "getTrulyText", "init", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "setFocus", NodeProps.FOCUSABLE, "", "showChangeStatusView", "showCommonView", "showEditedView", "draftText", "needIcon", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updateStatusIcon", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IDetailBubbleMainContainer {
    void clearText();

    LinearLayout.LayoutParams getAddViewLayoutParams();

    String getTextString();

    String getTrulyText();

    void init(OnlineStatus onlineStatus);

    void setFocus(boolean focusable);

    void showChangeStatusView(OnlineStatus onlineStatus);

    void showCommonView(OnlineStatus onlineStatus);

    void showEditedView(OnlineStatus onlineStatus, String draftText, boolean needIcon);

    void updateBubbleSkin(SquareBubbleInfo bubbleInfo);

    void updateStatusIcon(OnlineStatus onlineStatus);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static String getTrulyText(IDetailBubbleMainContainer iDetailBubbleMainContainer) {
            return null;
        }

        public static void updateStatusIcon(IDetailBubbleMainContainer iDetailBubbleMainContainer, OnlineStatus onlineStatus) {
            Intrinsics.checkNotNullParameter(onlineStatus, "onlineStatus");
        }

        public static void clearText(IDetailBubbleMainContainer iDetailBubbleMainContainer) {
        }

        public static void init(IDetailBubbleMainContainer iDetailBubbleMainContainer, OnlineStatus onlineStatus) {
        }

        public static void setFocus(IDetailBubbleMainContainer iDetailBubbleMainContainer, boolean z16) {
        }

        public static void showChangeStatusView(IDetailBubbleMainContainer iDetailBubbleMainContainer, OnlineStatus onlineStatus) {
        }

        public static void showEditedView(IDetailBubbleMainContainer iDetailBubbleMainContainer, OnlineStatus onlineStatus, String str, boolean z16) {
        }
    }
}
