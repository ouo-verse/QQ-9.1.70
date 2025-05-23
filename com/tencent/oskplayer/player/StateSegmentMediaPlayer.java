package com.tencent.oskplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.player.StateMediaPlayer;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.IOException;

/* loaded from: classes22.dex */
public class StateSegmentMediaPlayer extends StateMediaPlayer implements ISegmentMediaPlayer {
    public StateSegmentMediaPlayer(ISegmentMediaPlayer iSegmentMediaPlayer, boolean z16) {
        super(iSegmentMediaPlayer, z16);
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentProxySegmentUrl() throws IllegalStateException {
        if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPROXYSEGMENTURL)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "call getCurrentProxySegmentUrl in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call getCurrentProxySegmentUrl in illegalState " + getMediaPlayerState() + this);
            }
        }
        return ((ISegmentMediaPlayer) this.mInternalMediaPlayer).getCurrentProxySegmentUrl();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public String getCurrentSegmentUrl() throws IllegalStateException {
        if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTSEGMENTURL)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "call getCurrentSegmentUrl in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call getCurrentSegmentUrl in illegalState " + getMediaPlayerState() + this);
            }
        }
        return ((ISegmentMediaPlayer) this.mInternalMediaPlayer).getCurrentSegmentUrl();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public int getSegmentCount() throws IllegalStateException {
        StateMediaPlayer.StateMediaPlayerInternalState stateMediaPlayerInternalState = this.mMediaPlayerState;
        if (stateMediaPlayerInternalState == StateMediaPlayer.StateMediaPlayerInternalState.RELEASED || stateMediaPlayerInternalState == StateMediaPlayer.StateMediaPlayerInternalState.IDLE) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "call getSegmentCount in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call getSegmentCount in illegalState " + getMediaPlayerState() + this);
            }
        }
        return ((ISegmentMediaPlayer) this.mInternalMediaPlayer).getSegmentCount();
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo) throws IOException {
        if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
            }
        }
        if (!StateMediaPlayer.sVideoUrlValidator.isValid(streamInfo)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "VideoUrlValidationError " + streamInfo + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("VideoUrlValidationError " + streamInfo + this);
            }
        }
        ((ISegmentMediaPlayer) this.mInternalMediaPlayer).setDataSource(streamInfo);
    }

    @Override // com.tencent.oskplayer.player.StateMediaPlayer
    public ISegmentMediaPlayer getInternalMediaPlayer() {
        return (ISegmentMediaPlayer) this.mInternalMediaPlayer;
    }

    @Override // com.tencent.oskplayer.player.ISegmentMediaPlayer
    public void setDataSource(SegmentVideoInfo.StreamInfo streamInfo, int i3) throws IOException {
        if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
            }
        }
        if (!StateMediaPlayer.sVideoUrlValidator.isValid(streamInfo)) {
            if (!this.mThrowException) {
                PlayerUtils.log(5, StateMediaPlayer.LOG_TAG, "VideoUrlValidationError " + streamInfo + this + "\n: stack\n" + PlayerUtils.getStackTrace());
            } else {
                throw new StateMediaPlayerException("VideoUrlValidationError " + streamInfo + this);
            }
        }
        ((ISegmentMediaPlayer) this.mInternalMediaPlayer).setDataSource(streamInfo, i3);
    }
}
