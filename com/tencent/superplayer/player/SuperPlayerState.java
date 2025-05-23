package com.tencent.superplayer.player;

import com.tencent.superplayer.player.ISuperPlayerState;
import com.tencent.superplayer.utils.LogUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class SuperPlayerState implements ISuperPlayerState {
    private static final String FILENAME = "SuperPlayerState.java";
    private volatile ISuperPlayerState.OnPlayStateChangeListener mStateListener;
    private String mTAG;
    private volatile int mPreState = 0;
    private volatile int mCurState = 0;
    private final Object mStateLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuperPlayerState(String str) {
        this.mTAG = str + "-" + FILENAME;
    }

    static String getStateStr(int i3) {
        switch (i3) {
            case 0:
                return " IDLE ";
            case 1:
                return " CGIING ";
            case 2:
                return " CGIED ";
            case 3:
                return " PREPARING ";
            case 4:
                return " PREPARED ";
            case 5:
                return " STARTED ";
            case 6:
                return " PAUSED ";
            case 7:
                return " COMPLETE ";
            case 8:
                return " STOPPED ";
            case 9:
                return " ERROR ";
            case 10:
                return " RELEASED ";
            default:
                return " UNKNOW ";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeStateAndNotify(int i3) {
        synchronized (this.mStateLock) {
            int i16 = this.mCurState;
            if (i3 != i16) {
                this.mCurState = i3;
                this.mPreState = i16;
                if (this.mStateListener != null) {
                    this.mStateListener.onStateChange(copy());
                }
                LogUtil.i(this.mTAG, "changeStateAndNotify(), " + getStateStr(i16) + " ==> " + getStateStr(i3));
            }
        }
    }

    SuperPlayerState copy() {
        SuperPlayerState superPlayerState = new SuperPlayerState(this.mTAG);
        superPlayerState.mCurState = this.mCurState;
        superPlayerState.mPreState = this.mPreState;
        return superPlayerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurState() {
        int i3;
        synchronized (this.mStateLock) {
            i3 = this.mCurState;
        }
        return i3;
    }

    int getPreState() {
        int i3;
        synchronized (this.mStateLock) {
            i3 = this.mPreState;
        }
        return i3;
    }

    public String toString() {
        return "SuperPlayerState[ mPreState:" + getStateStr(this.mPreState) + "/nmCurState:" + getStateStr(this.mCurState) + "/n]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePlayerTag(String str) {
        this.mTAG = str + "-" + FILENAME;
    }
}
