package com.tencent.state.square.message.box;

import com.tencent.state.square.api.SquareBaseMessageRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/message/box/IMsgBoxViewDirector;", "", "enableNewMsgBubble", "", "enable", "", "flag", "Lcom/tencent/state/square/message/box/MsgBoxOperateFlag;", "hideMsgListPanel", "hideNewMsgBubble", "isShowingMsgBubble", "isShowingMsgListPanel", "showMsgListPanel", "showNewMsgBubble", "data", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IMsgBoxViewDirector {
    void enableNewMsgBubble(boolean enable, MsgBoxOperateFlag flag);

    void hideMsgListPanel(MsgBoxOperateFlag flag);

    void hideNewMsgBubble(MsgBoxOperateFlag flag);

    boolean isShowingMsgBubble();

    boolean isShowingMsgListPanel();

    void showMsgListPanel(MsgBoxOperateFlag flag);

    void showNewMsgBubble(SquareBaseMessageRecord data, MsgBoxOperateFlag flag);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void enableNewMsgBubble$default(IMsgBoxViewDirector iMsgBoxViewDirector, boolean z16, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxViewDirector.enableNewMsgBubble(z16, msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableNewMsgBubble");
        }

        public static /* synthetic */ void hideMsgListPanel$default(IMsgBoxViewDirector iMsgBoxViewDirector, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxViewDirector.hideMsgListPanel(msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideMsgListPanel");
        }

        public static /* synthetic */ void hideNewMsgBubble$default(IMsgBoxViewDirector iMsgBoxViewDirector, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxViewDirector.hideNewMsgBubble(msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideNewMsgBubble");
        }

        public static /* synthetic */ void showMsgListPanel$default(IMsgBoxViewDirector iMsgBoxViewDirector, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxViewDirector.showMsgListPanel(msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMsgListPanel");
        }

        public static /* synthetic */ void showNewMsgBubble$default(IMsgBoxViewDirector iMsgBoxViewDirector, SquareBaseMessageRecord squareBaseMessageRecord, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxViewDirector.showNewMsgBubble(squareBaseMessageRecord, msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNewMsgBubble");
        }
    }
}
