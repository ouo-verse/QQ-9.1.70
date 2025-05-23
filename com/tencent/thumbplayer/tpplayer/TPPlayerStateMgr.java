package com.tencent.thumbplayer.tpplayer;

import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPPlayerStateToString;
import com.tencent.thumbplayer.common.log.TPLogUtil;

/* loaded from: classes26.dex */
public class TPPlayerStateMgr implements ITPPlayerStateQuerier {
    private int mCurrentState = 0;
    private ITPPlayerListener.IOnStateChangedListener mStateChangedListener;
    private final TPContext mTPContext;

    public TPPlayerStateMgr(TPContext tPContext) {
        this.mTPContext = tPContext;
    }

    public void changeToState(int i3) {
        int i16 = this.mCurrentState;
        if (i16 == i3) {
            return;
        }
        this.mCurrentState = i3;
        TPLogUtil.i(this.mTPContext.getLogTag(), "change state from " + TPPlayerStateToString.getStateName(i16) + " to " + TPPlayerStateToString.getStateName(this.mCurrentState));
        ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener = this.mStateChangedListener;
        if (iOnStateChangedListener != null) {
            iOnStateChangedListener.onStateChanged(null, i16, this.mCurrentState);
        }
    }

    @Override // com.tencent.thumbplayer.tpplayer.ITPPlayerStateQuerier
    public int getCurrentState() {
        return this.mCurrentState;
    }

    @Override // com.tencent.thumbplayer.tpplayer.ITPPlayerStateQuerier
    public boolean isInStates(int... iArr) {
        for (int i3 : iArr) {
            if (this.mCurrentState == i3) {
                return true;
            }
        }
        return false;
    }

    public void setOnStateChangedListener(ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener) {
        this.mStateChangedListener = iOnStateChangedListener;
    }
}
