package com.tencent.qqlive.tvkplayer.qqliveasset.state;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* loaded from: classes23.dex */
public class TVKPlayerState implements ITVKPlayerState {
    private static final String TAG = "TVKPlayer[TVKPlayerState.class]";
    private ITVKPlayerState.STATE mCurState;
    private OnStateChangeListener mListener;
    private ITVKPlayerState.STATE mPreState;

    /* loaded from: classes23.dex */
    public interface OnStateChangeListener {
        void onStateChange(ITVKPlayerState iTVKPlayerState);
    }

    public TVKPlayerState() {
        ITVKPlayerState.STATE state = ITVKPlayerState.STATE.IDLE;
        this.mCurState = state;
        this.mPreState = state;
    }

    private void printStateChange() {
        TVKLogUtil.i(TAG, "state change \uff1astate[ cur : " + this.mCurState.name() + " , pre : " + this.mPreState.name() + "(changed) ]");
    }

    public void changeState(ITVKPlayerState.STATE state) {
        TVKPlayerState tVKPlayerState;
        OnStateChangeListener onStateChangeListener;
        synchronized (this) {
            ITVKPlayerState.STATE state2 = this.mCurState;
            if (state2 != state) {
                this.mPreState = state2;
                this.mCurState = state;
                printStateChange();
                tVKPlayerState = copy();
            } else {
                tVKPlayerState = null;
            }
        }
        if (tVKPlayerState != null && (onStateChangeListener = this.mListener) != null) {
            onStateChangeListener.onStateChange(tVKPlayerState);
        }
    }

    public synchronized TVKPlayerState copy() {
        TVKPlayerState tVKPlayerState;
        tVKPlayerState = new TVKPlayerState();
        tVKPlayerState.mCurState = this.mCurState;
        tVKPlayerState.mPreState = this.mPreState;
        return tVKPlayerState;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState
    public synchronized boolean is(ITVKPlayerState.STATE... stateArr) {
        for (ITVKPlayerState.STATE state : stateArr) {
            if (this.mCurState == state) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean less(ITVKPlayerState.STATE state) {
        boolean z16;
        if (this.mCurState.ordinal() < state.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState
    public synchronized ITVKPlayerState.STATE preState() {
        return this.mPreState;
    }

    public synchronized void setStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mListener = onStateChangeListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState
    public synchronized ITVKPlayerState.STATE state() {
        return this.mCurState;
    }

    @NonNull
    public synchronized String toString() {
        return "state[ cur : " + this.mCurState.name() + " , pre : " + this.mPreState.name() + " ]";
    }

    public TVKPlayerState(@NonNull OnStateChangeListener onStateChangeListener) {
        this();
        setStateChangeListener(onStateChangeListener);
    }
}
