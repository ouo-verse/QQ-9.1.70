package com.tencent.qqlive.tvkplayer.qqliveasset.state;

/* loaded from: classes23.dex */
public interface ITVKPlayerState {

    /* loaded from: classes23.dex */
    public enum STATE {
        IDLE,
        CGING,
        CGIED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        COMPLETE,
        STOPPED,
        ERROR,
        RELEASED
    }

    boolean is(STATE... stateArr);

    STATE preState();

    STATE state();
}
