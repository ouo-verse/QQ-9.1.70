package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoReportFlowInfo {
    private boolean isLoopEnd;
    private long loopStartPositionMs;
    private float playSpeedRatio = 1.0f;
    private int playerObject;
    private long startPosition;
    private VideoSession videoSession;
    private volatile int videoState;

    public long getLoopStartPositionMs() {
        return this.loopStartPositionMs;
    }

    public float getPlaySpeedRatio() {
        return this.playSpeedRatio;
    }

    public int getPlayerObject() {
        return this.playerObject;
    }

    public long getStartPosition() {
        return this.startPosition;
    }

    public VideoSession getVideoSession() {
        return this.videoSession;
    }

    public int getVideoState() {
        return this.videoState;
    }

    public boolean isLoopEnd() {
        return this.isLoopEnd;
    }

    public void setLoopEnd(boolean z16) {
        this.isLoopEnd = z16;
    }

    public void setLoopStartPositionMs(long j3) {
        this.loopStartPositionMs = j3;
    }

    public void setPlaySpeedRatio(float f16) {
        this.playSpeedRatio = f16;
    }

    public void setPlayerObject(int i3) {
        this.playerObject = i3;
    }

    public void setStartPosition(long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        this.startPosition = j3;
    }

    public void setVideoSession(VideoSession videoSession) {
        this.videoSession = videoSession;
    }

    public void setVideoState(int i3) {
        this.videoState = i3;
    }
}
