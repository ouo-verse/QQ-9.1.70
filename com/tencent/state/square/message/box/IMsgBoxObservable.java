package com.tencent.state.square.message.box;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/message/box/IMsgBoxObservable;", "", "pauseObserve", "", "flag", "Lcom/tencent/state/square/message/box/MsgBoxOperateFlag;", "resumeObserve", "startObserve", "stopObserve", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IMsgBoxObservable {
    void pauseObserve(MsgBoxOperateFlag flag);

    void resumeObserve(MsgBoxOperateFlag flag);

    void startObserve(MsgBoxOperateFlag flag);

    void stopObserve(MsgBoxOperateFlag flag);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void pauseObserve$default(IMsgBoxObservable iMsgBoxObservable, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxObservable.pauseObserve(msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pauseObserve");
        }

        public static /* synthetic */ void resumeObserve$default(IMsgBoxObservable iMsgBoxObservable, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxObservable.resumeObserve(msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeObserve");
        }

        public static /* synthetic */ void startObserve$default(IMsgBoxObservable iMsgBoxObservable, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxObservable.startObserve(msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startObserve");
        }

        public static /* synthetic */ void stopObserve$default(IMsgBoxObservable iMsgBoxObservable, MsgBoxOperateFlag msgBoxOperateFlag, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    msgBoxOperateFlag = MsgBoxOperateFlag.UNKNOWN;
                }
                iMsgBoxObservable.stopObserve(msgBoxOperateFlag);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopObserve");
        }
    }
}
