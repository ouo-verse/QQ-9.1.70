package com.tencent.mobileqq.qqnt.videoplay.player;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/PlayState;", "", "(Ljava/lang/String;I)V", "isBuffering", "", "isIdle", "isInPlaying", "isPaused", "isPlayCompleted", "isPlayError", "isPlayStarted", "isPreparing", "isReleased", "isSDKInited", "STATE_IDLE", "STATE_SDK_INITED", "STATE_PREPARING", "STATE_PLAYING", "STATE_BUFFERING", "STATE_PAUSE", "STATE_ERROR", "STATE_COMPLETE", "STATE_RELEASED", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class PlayState {
    private static final /* synthetic */ PlayState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PlayState STATE_BUFFERING;
    public static final PlayState STATE_COMPLETE;
    public static final PlayState STATE_ERROR;
    public static final PlayState STATE_IDLE;
    public static final PlayState STATE_PAUSE;
    public static final PlayState STATE_PLAYING;
    public static final PlayState STATE_PREPARING;
    public static final PlayState STATE_RELEASED;
    public static final PlayState STATE_SDK_INITED;

    private static final /* synthetic */ PlayState[] $values() {
        return new PlayState[]{STATE_IDLE, STATE_SDK_INITED, STATE_PREPARING, STATE_PLAYING, STATE_BUFFERING, STATE_PAUSE, STATE_ERROR, STATE_COMPLETE, STATE_RELEASED};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39588);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        STATE_IDLE = new PlayState("STATE_IDLE", 0);
        STATE_SDK_INITED = new PlayState("STATE_SDK_INITED", 1);
        STATE_PREPARING = new PlayState("STATE_PREPARING", 2);
        STATE_PLAYING = new PlayState("STATE_PLAYING", 3);
        STATE_BUFFERING = new PlayState("STATE_BUFFERING", 4);
        STATE_PAUSE = new PlayState("STATE_PAUSE", 5);
        STATE_ERROR = new PlayState("STATE_ERROR", 6);
        STATE_COMPLETE = new PlayState("STATE_COMPLETE", 7);
        STATE_RELEASED = new PlayState("STATE_RELEASED", 8);
        $VALUES = $values();
    }

    PlayState(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static PlayState valueOf(String str) {
        return (PlayState) Enum.valueOf(PlayState.class, str);
    }

    public static PlayState[] values() {
        return (PlayState[]) $VALUES.clone();
    }

    public final boolean isBuffering() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this == STATE_BUFFERING) {
            return true;
        }
        return false;
    }

    public final boolean isIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this == STATE_IDLE) {
            return true;
        }
        return false;
    }

    public final boolean isInPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this == STATE_PLAYING) {
            return true;
        }
        return false;
    }

    public final boolean isPaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this == STATE_PAUSE) {
            return true;
        }
        return false;
    }

    public final boolean isPlayCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this == STATE_COMPLETE) {
            return true;
        }
        return false;
    }

    public final boolean isPlayError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this == STATE_ERROR) {
            return true;
        }
        return false;
    }

    public final boolean isPlayStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this != STATE_PREPARING && this != STATE_BUFFERING && this != STATE_PLAYING) {
            return false;
        }
        return true;
    }

    public final boolean isPreparing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this != STATE_PREPARING && this != STATE_BUFFERING) {
            return false;
        }
        return true;
    }

    public final boolean isReleased() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this == STATE_RELEASED) {
            return true;
        }
        return false;
    }

    public final boolean isSDKInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this == STATE_SDK_INITED) {
            return true;
        }
        return false;
    }
}
