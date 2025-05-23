package com.tencent.oskplayer.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.VideoUrlValidator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: classes22.dex */
public class StateMediaPlayer implements IMediaPlayer {
    public static final String LOG_TAG = "StateMediaPlayer";
    protected static final VideoUrlValidator sVideoUrlValidator = new VideoUrlValidator();
    protected IMediaPlayer mInternalMediaPlayer;
    private boolean mIsSurfaceRequired;
    protected StateMediaPlayerInternalState mMediaPlayerState;
    private int mMode;
    private StateChangeListener mStateChangeListener;
    protected boolean mThrowException;
    private final Object mPrepareLock = new Object();
    private boolean mAlreadyStart = false;
    private boolean mHasValidSurface = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.oskplayer.player.StateMediaPlayer$5, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation;

        static {
            int[] iArr = new int[StateMediaPlayerOperation.values().length];
            $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation = iArr;
            try {
                iArr[StateMediaPlayerOperation.OP_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_GETCURRENTPOSITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_GETDURATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_ISPLAYING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_GETVIDEOWIDTH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_GETVIDEOHEIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_SETSURFACE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_SETSURFACE_TEXTURE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_SEEKTO.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_SETVOLUME.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_SETLOOPING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_RESET.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_RELEASE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_GETCURRENTPROXYSEGMENTURL.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[StateMediaPlayerOperation.OP_GETCURRENTSEGMENTURL.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            int[] iArr2 = new int[StateMediaPlayerInternalState.values().length];
            $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState = iArr2;
            try {
                iArr2[StateMediaPlayerInternalState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.PREPARING.ordinal()] = 3;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.PREPARED.ordinal()] = 4;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.ACTIVE_PAUSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.PASSIVE_PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.STOPPED.ordinal()] = 8;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.PLAYBACK_COMPLETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[StateMediaPlayerInternalState.RELEASED.ordinal()] = 11;
            } catch (NoSuchFieldError unused28) {
            }
        }
    }

    /* loaded from: classes22.dex */
    public interface StateChangeListener {
        void onStateChange(int i3, int i16);
    }

    /* loaded from: classes22.dex */
    public enum StateMediaPlayerInternalState {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        ACTIVE_PAUSED,
        PASSIVE_PAUSED,
        STOPPED,
        PLAYBACK_COMPLETED,
        ERROR,
        RELEASED
    }

    /* loaded from: classes22.dex */
    public enum StateMediaPlayerOperation {
        OP_START,
        OP_PAUSE,
        OP_STOP,
        OP_GETCURRENTPOSITION,
        OP_GETDURATION,
        OP_ISPLAYING,
        OP_GETVIDEOWIDTH,
        OP_GETVIDEOHEIGHT,
        OP_SEEKTO,
        OP_SETVOLUME,
        OP_SETLOOPING,
        OP_RESET,
        OP_RELEASE,
        OP_GETCURRENTPROXYSEGMENTURL,
        OP_GETCURRENTSEGMENTURL,
        OP_SETSURFACE,
        OP_SETSURFACE_TEXTURE
    }

    public StateMediaPlayer(IMediaPlayer iMediaPlayer, boolean z16) {
        this.mThrowException = false;
        this.mInternalMediaPlayer = iMediaPlayer;
        if (!setMediaPlayerState(StateMediaPlayerInternalState.IDLE)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "StateMediaPlayer constructor setMediaPlayerState IDLE error " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new IllegalStateException("StateMediaPlayer constructor setMediaPlayerState IDLE error " + getMediaPlayerState() + this);
            }
        }
        this.mThrowException = z16;
        this.mMode = 3;
        initMode();
    }

    private void initMode() {
        boolean z16 = true;
        if ((this.mMode & 1) != 1) {
            z16 = false;
        }
        this.mIsSurfaceRequired = z16;
    }

    public synchronized boolean checkState(StateMediaPlayerOperation stateMediaPlayerOperation) {
        PlayerUtils.log(2, LOG_TAG, this + " > checkState operation=" + stateMediaPlayerOperation + ", currentState=" + this.mMediaPlayerState);
        switch (AnonymousClass5.$SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[stateMediaPlayerOperation.ordinal()]) {
            case 1:
                StateMediaPlayerInternalState stateMediaPlayerInternalState = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                break;
            case 2:
                StateMediaPlayerInternalState stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState2 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState2 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState2 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                break;
            case 3:
                StateMediaPlayerInternalState stateMediaPlayerInternalState3 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState3 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState3 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState3 != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState3 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState3 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState3 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                break;
            case 4:
            case 5:
                StateMediaPlayerInternalState stateMediaPlayerInternalState4 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                break;
            case 6:
                StateMediaPlayerInternalState stateMediaPlayerInternalState5 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                break;
            case 7:
            case 8:
                StateMediaPlayerInternalState stateMediaPlayerInternalState6 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                break;
            case 9:
            case 10:
                StateMediaPlayerInternalState stateMediaPlayerInternalState7 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.INITIALIZED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.PASSIVE_PAUSED) {
                    return false;
                }
                break;
            case 11:
                StateMediaPlayerInternalState stateMediaPlayerInternalState8 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState8 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState8 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState8 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState8 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState8 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                break;
            case 12:
            case 13:
                StateMediaPlayerInternalState stateMediaPlayerInternalState9 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState9 != StateMediaPlayerInternalState.IDLE && stateMediaPlayerInternalState9 != StateMediaPlayerInternalState.INITIALIZED && stateMediaPlayerInternalState9 != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState9 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState9 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState9 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState9 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState9 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                break;
            case 14:
                StateMediaPlayerInternalState stateMediaPlayerInternalState10 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState10 == StateMediaPlayerInternalState.PREPARING || stateMediaPlayerInternalState10 == StateMediaPlayerInternalState.IDLE) {
                    return false;
                }
                break;
            case 15:
                StateMediaPlayerInternalState stateMediaPlayerInternalState11 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState11 == StateMediaPlayerInternalState.PREPARING || stateMediaPlayerInternalState11 == StateMediaPlayerInternalState.RELEASED) {
                    return false;
                }
                break;
            case 16:
            case 17:
                StateMediaPlayerInternalState stateMediaPlayerInternalState12 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState12 == StateMediaPlayerInternalState.RELEASED || stateMediaPlayerInternalState12 == StateMediaPlayerInternalState.IDLE) {
                    return false;
                }
                break;
        }
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() throws IllegalStateException {
        if (!checkState(StateMediaPlayerOperation.OP_GETCURRENTPOSITION)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call getCurrentPosition in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call getCurrentPosition in illegalState " + getMediaPlayerState() + this);
            }
        }
        return this.mInternalMediaPlayer.getCurrentPosition();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() throws IllegalStateException {
        StateMediaPlayerInternalState stateMediaPlayerInternalState = this.mMediaPlayerState;
        if (stateMediaPlayerInternalState != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call getDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call getDataSource in illegalState " + getMediaPlayerState());
            }
        }
        return this.mInternalMediaPlayer.getDataSource();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() throws IllegalStateException {
        if (!checkState(StateMediaPlayerOperation.OP_GETDURATION)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call getDuration in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call getDuration in illegalState " + getMediaPlayerState() + this);
            }
        }
        return this.mInternalMediaPlayer.getDuration();
    }

    public IMediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        return this.mInternalMediaPlayer.getMediaInfo();
    }

    public synchronized StateMediaPlayerInternalState getMediaPlayerState() {
        return this.mMediaPlayerState;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getScore() {
        return this.mInternalMediaPlayer.getScore();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return this.mInternalMediaPlayer.getTrackInfo();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() throws IllegalStateException {
        if (!checkState(StateMediaPlayerOperation.OP_GETVIDEOHEIGHT)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call getVideoHeight in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call getVideoHeight in illegalState " + getMediaPlayerState() + this);
            }
        }
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mInternalMediaPlayer.getVideoSarDen();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mInternalMediaPlayer.getVideoSarNum();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() throws IllegalStateException {
        if (!checkState(StateMediaPlayerOperation.OP_GETVIDEOWIDTH)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call getVideoWidth in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call getVideoWidth in illegalState " + getMediaPlayerState() + this);
            }
        }
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    public boolean isInIdleState() {
        if (getMediaPlayerState() == StateMediaPlayerInternalState.IDLE) {
            return true;
        }
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    public boolean isPaused() {
        if (getMediaPlayerState() == StateMediaPlayerInternalState.ACTIVE_PAUSED) {
            return true;
        }
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return this.mInternalMediaPlayer.isPlayable();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() throws IllegalStateException {
        if (!checkState(StateMediaPlayerOperation.OP_ISPLAYING)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call isPlaying in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call isPlaying in illegalState " + getMediaPlayerState() + this);
            }
        }
        return this.mInternalMediaPlayer.isPlaying();
    }

    public void markValidSurface() {
        this.mHasValidSurface = true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException, IMediaPlayer.InternalOperationException {
        try {
            this.mInternalMediaPlayer.pause();
            if (!setMediaPlayerState(StateMediaPlayerInternalState.ACTIVE_PAUSED)) {
                if (!this.mThrowException) {
                    PlayerUtils.log(5, LOG_TAG, "call pause in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
                    return;
                }
                throw new StateMediaPlayerException("call pause in illegalState " + getMediaPlayerState() + this);
            }
        } catch (IMediaPlayer.InternalOperationException e16) {
            PlayerUtils.log(4, LOG_TAG, "caught " + e16);
            throw e16;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        if (!setMediaPlayerState(StateMediaPlayerInternalState.PREPARING)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call prepareAsync in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call prepareAsync in illegalState " + getMediaPlayerState() + this);
            }
        }
        try {
            synchronized (this.mPrepareLock) {
                this.mInternalMediaPlayer.prepareAsync();
            }
        } catch (IllegalStateException e16) {
            PlayerUtils.log(5, LOG_TAG, "crappy mediaplayer prepareAsync should work, but its not work as expected " + this + PlayerUtils.getPrintableStackTrace(e16));
            setMediaPlayerState(StateMediaPlayerInternalState.ERROR);
            throw e16;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        if (!setMediaPlayerState(StateMediaPlayerInternalState.RELEASED)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call release in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call release in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() throws IllegalStateException {
        if (!setMediaPlayerState(StateMediaPlayerInternalState.IDLE)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call reset in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call reset in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j3) throws IllegalStateException {
        if (!checkState(StateMediaPlayerOperation.OP_SEEKTO)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call seekTo in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call seekTo in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.seekTo(j3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
        StateMediaPlayerInternalState stateMediaPlayerInternalState = this.mMediaPlayerState;
        if (stateMediaPlayerInternalState != StateMediaPlayerInternalState.IDLE && stateMediaPlayerInternalState != StateMediaPlayerInternalState.INITIALIZED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call setAudioStreamType in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setAudioStreamType in illegalState " + getMediaPlayerState());
            }
        }
        this.mInternalMediaPlayer.setAudioStreamType(i3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (!setMediaPlayerState(StateMediaPlayerInternalState.INITIALIZED)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mInternalMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z16) {
        this.mInternalMediaPlayer.setKeepInBackground(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z16) {
        this.mInternalMediaPlayer.setLogEnabled(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z16) {
        if (!checkState(StateMediaPlayerOperation.OP_SETLOOPING)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call setLooping in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setLooping in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.setLooping(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0012. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00af A[Catch: all -> 0x00dd, TryCatch #0 {, blocks: (B:3:0x0001, B:9:0x000a, B:13:0x0017, B:15:0x001d, B:19:0x0023, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0039, B:33:0x003f, B:35:0x0045, B:37:0x0049, B:41:0x004f, B:43:0x0055, B:45:0x0059, B:47:0x005d, B:51:0x0063, B:53:0x0069, B:55:0x006d, B:57:0x0071, B:59:0x0075, B:63:0x007b, B:67:0x0083, B:69:0x0089, B:73:0x008f, B:77:0x0097, B:81:0x009f, B:84:0x00a9, B:86:0x00af, B:87:0x00b6, B:91:0x00a5), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a5 A[Catch: all -> 0x00dd, TryCatch #0 {, blocks: (B:3:0x0001, B:9:0x000a, B:13:0x0017, B:15:0x001d, B:19:0x0023, B:21:0x0029, B:23:0x002d, B:25:0x0031, B:27:0x0035, B:29:0x0039, B:33:0x003f, B:35:0x0045, B:37:0x0049, B:41:0x004f, B:43:0x0055, B:45:0x0059, B:47:0x005d, B:51:0x0063, B:53:0x0069, B:55:0x006d, B:57:0x0071, B:59:0x0075, B:63:0x007b, B:67:0x0083, B:69:0x0089, B:73:0x008f, B:77:0x0097, B:81:0x009f, B:84:0x00a9, B:86:0x00af, B:87:0x00b6, B:91:0x00a5), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean setMediaPlayerState(StateMediaPlayerInternalState stateMediaPlayerInternalState) {
        StateMediaPlayerInternalState stateMediaPlayerInternalState2;
        int ordinal;
        StateChangeListener stateChangeListener;
        if (this.mMediaPlayerState == StateMediaPlayerInternalState.RELEASED) {
            return false;
        }
        switch (AnonymousClass5.$SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[stateMediaPlayerInternalState.ordinal()]) {
            case 1:
                if (this.mMediaPlayerState == StateMediaPlayerInternalState.PREPARING) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                    ordinal = -1;
                } else {
                    ordinal = stateMediaPlayerInternalState2.ordinal();
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                    stateChangeListener.onStateChange(ordinal, stateMediaPlayerInternalState.ordinal());
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 2:
                if (this.mMediaPlayerState != StateMediaPlayerInternalState.IDLE) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 3:
                StateMediaPlayerInternalState stateMediaPlayerInternalState3 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState3 != StateMediaPlayerInternalState.INITIALIZED && stateMediaPlayerInternalState3 != StateMediaPlayerInternalState.STOPPED) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 4:
                if (this.mMediaPlayerState != StateMediaPlayerInternalState.PREPARING) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 5:
                StateMediaPlayerInternalState stateMediaPlayerInternalState4 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState4 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 6:
                StateMediaPlayerInternalState stateMediaPlayerInternalState5 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState5 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 7:
                StateMediaPlayerInternalState stateMediaPlayerInternalState6 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState6 != StateMediaPlayerInternalState.STARTED) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 8:
                StateMediaPlayerInternalState stateMediaPlayerInternalState7 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState7 != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 9:
                StateMediaPlayerInternalState stateMediaPlayerInternalState8 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState8 != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState8 != StateMediaPlayerInternalState.ERROR) {
                    return false;
                }
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            case 10:
            case 11:
                stateMediaPlayerInternalState2 = this.mMediaPlayerState;
                if (stateMediaPlayerInternalState2 != null) {
                }
                this.mMediaPlayerState = stateMediaPlayerInternalState;
                stateChangeListener = this.mStateChangeListener;
                if (stateChangeListener != null) {
                }
                PlayerUtils.log(4, LOG_TAG, "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
                return true;
            default:
                return false;
        }
    }

    public void setMode(int i3) {
        this.mMode = i3;
        IMediaPlayer iMediaPlayer = this.mInternalMediaPlayer;
        if (iMediaPlayer instanceof SegmentMediaPlayer) {
            ((SegmentMediaPlayer) iMediaPlayer).setPlayMode(i3);
        }
        initMode();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        this.mInternalMediaPlayer.setNextMediaPlayer(iMediaPlayer);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(final IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mInternalMediaPlayer.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() { // from class: com.tencent.oskplayer.player.StateMediaPlayer.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                if (!StateMediaPlayer.this.setMediaPlayerState(StateMediaPlayerInternalState.PLAYBACK_COMPLETED)) {
                    if (!StateMediaPlayer.this.mThrowException) {
                        PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "setMediaPlayerState to PLAYBACK_COMPLETED in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this + "\n: stack\n" + PlayerUtils.getStackTrace());
                    } else {
                        throw new StateMediaPlayerException("setMediaPlayerState to PLAYBACK_COMPLETED in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this);
                    }
                }
                IMediaPlayer.OnCompletionListener onCompletionListener2 = onCompletionListener;
                if (onCompletionListener2 != null) {
                    onCompletionListener2.onCompletion(iMediaPlayer);
                }
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(final IMediaPlayer.OnErrorListener onErrorListener) {
        this.mInternalMediaPlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.tencent.oskplayer.player.StateMediaPlayer.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i3, int i16) {
                if (!StateMediaPlayer.this.setMediaPlayerState(StateMediaPlayerInternalState.ERROR)) {
                    if (!StateMediaPlayer.this.mThrowException) {
                        PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "setMediaPlayerState to ERROR in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this + "\n: stack\n" + PlayerUtils.getStackTrace());
                    } else {
                        throw new StateMediaPlayerException("setMediaPlayerState to ERROR in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this);
                    }
                }
                IMediaPlayer.OnErrorListener onErrorListener2 = onErrorListener;
                if (onErrorListener2 != null) {
                    return onErrorListener2.onError(iMediaPlayer, i3, i16);
                }
                return false;
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(final IMediaPlayer.OnInfoListener onInfoListener) {
        this.mInternalMediaPlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: com.tencent.oskplayer.player.StateMediaPlayer.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i3, int i16) {
                if (i3 == 701) {
                    if (StateMediaPlayer.this.mAlreadyStart && !StateMediaPlayer.this.setMediaPlayerState(StateMediaPlayerInternalState.PASSIVE_PAUSED)) {
                        if (!StateMediaPlayer.this.mThrowException) {
                            PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "setMediaPlayerState to PASSIVE_PAUSED in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this + "\n: stack\n" + PlayerUtils.getStackTrace());
                        } else {
                            throw new StateMediaPlayerException("setMediaPlayerState to PASSIVE_PAUSED in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this);
                        }
                    }
                } else if (i3 == 3) {
                    if (StateMediaPlayer.this.mIsSurfaceRequired && !StateMediaPlayer.this.mHasValidSurface) {
                        if (!StateMediaPlayer.this.mThrowException) {
                            PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "VIDEO_RENDERING_START start without a valid surface " + StateMediaPlayer.this.getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
                        } else {
                            throw new StateMediaPlayerException("VIDEO_RENDERING_START start without a valid surface " + StateMediaPlayer.this.getMediaPlayerState() + this);
                        }
                    }
                    if (!StateMediaPlayer.this.setMediaPlayerState(StateMediaPlayerInternalState.STARTED)) {
                        if (!StateMediaPlayer.this.mThrowException) {
                            PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "setMediaPlayerState to STARTED in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this + "\n: stack\n" + PlayerUtils.getStackTrace());
                        } else {
                            throw new StateMediaPlayerException("setMediaPlayerState to STARTED in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this);
                        }
                    }
                    StateMediaPlayer.this.mAlreadyStart = true;
                }
                IMediaPlayer.OnInfoListener onInfoListener2 = onInfoListener;
                if (onInfoListener2 != null) {
                    return onInfoListener2.onInfo(iMediaPlayer, i3, i16);
                }
                return false;
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener onLoopStartListener) {
        this.mInternalMediaPlayer.setOnLoopStartListener(onLoopStartListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(final IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mInternalMediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: com.tencent.oskplayer.player.StateMediaPlayer.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                if (!StateMediaPlayer.this.setMediaPlayerState(StateMediaPlayerInternalState.PREPARED)) {
                    if (!StateMediaPlayer.this.mThrowException) {
                        PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "setMediaPlayerState to PREPARED in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this + "\n: stack\n" + PlayerUtils.getStackTrace());
                    } else {
                        throw new StateMediaPlayerException("setMediaPlayerState to PREPARED in illegalState " + StateMediaPlayer.this.getMediaPlayerState() + StateMediaPlayer.this);
                    }
                }
                IMediaPlayer.OnPreparedListener onPreparedListener2 = onPreparedListener;
                if (onPreparedListener2 != null) {
                    onPreparedListener2.onPrepared(iMediaPlayer);
                }
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mInternalMediaPlayer.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        StateMediaPlayerInternalState stateMediaPlayerInternalState = this.mMediaPlayerState;
        if (stateMediaPlayerInternalState != StateMediaPlayerInternalState.IDLE && stateMediaPlayerInternalState != StateMediaPlayerInternalState.INITIALIZED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PREPARED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.STARTED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.ACTIVE_PAUSED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PASSIVE_PAUSED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.STOPPED && stateMediaPlayerInternalState != StateMediaPlayerInternalState.PLAYBACK_COMPLETED) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call setOnTimedTextListener in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setOnTimedTextListener in illegalState " + getMediaPlayerState());
            }
        }
        this.mInternalMediaPlayer.setOnTimedTextListener(onTimedTextListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        this.mInternalMediaPlayer.setSeekParameters(seekParameters);
    }

    public void setStateChangeListener(StateChangeListener stateChangeListener) {
        this.mStateChangeListener = stateChangeListener;
    }

    public void setStrictMode(boolean z16) {
        this.mThrowException = z16;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        boolean z16;
        PlayerUtils.log(4, LOG_TAG, "setSurface " + this);
        if (surface != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mHasValidSurface = z16;
        this.mInternalMediaPlayer.setSurface(surface);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f16, float f17) throws IllegalStateException {
        if (!checkState(StateMediaPlayerOperation.OP_SETVOLUME)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call setVolume in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setVolume in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.setVolume(f16, f17);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i3) {
        this.mInternalMediaPlayer.setWakeMode(context, i3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException, IMediaPlayer.InternalOperationException {
        if (this.mIsSurfaceRequired && !this.mHasValidSurface) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call start without a valid surface " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call start without a valid surface " + getMediaPlayerState() + this);
            }
        }
        try {
            this.mInternalMediaPlayer.start();
            if (!setMediaPlayerState(StateMediaPlayerInternalState.STARTED)) {
                if (!this.mThrowException) {
                    PlayerUtils.log(5, LOG_TAG, "call start in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
                } else {
                    throw new StateMediaPlayerException("call start in illegalState " + getMediaPlayerState() + this);
                }
            }
            this.mAlreadyStart = true;
        } catch (IMediaPlayer.InternalOperationException e16) {
            PlayerUtils.log(4, LOG_TAG, "caught " + e16);
            throw e16;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        if (!setMediaPlayerState(StateMediaPlayerInternalState.STOPPED)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call stop in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call stop in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.stop();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (!setMediaPlayerState(StateMediaPlayerInternalState.INITIALIZED)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        if (!setMediaPlayerState(StateMediaPlayerInternalState.INITIALIZED)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
            }
        }
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (!setMediaPlayerState(StateMediaPlayerInternalState.INITIALIZED)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
            }
        }
        if (!sVideoUrlValidator.isValid(str)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, LOG_TAG, "VideoUrlValidationError " + str + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("VideoUrlValidationError " + str + this);
            }
        }
        this.mInternalMediaPlayer.setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws UnsupportedOperationException {
        this.mInternalMediaPlayer.setDataSource(iMediaDataSource);
    }
}
