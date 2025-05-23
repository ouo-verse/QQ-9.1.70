package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoSession {
    private static final long INVALID_PLAY_TIME = -1;
    private String contentId;
    private int contentType;
    private Map<String, Object> curPage;
    private boolean isBizReady;
    private long playEndPosition;
    private int playEndReason;
    private int playStartReason;
    private long playStartTime;
    private int playType;
    private long playedTime;
    private Map<String, Object> startParams;
    private long startPosition;
    private long videoEndTime;
    private VideoBaseEntity videoEntity;
    private int videoPlayerObject;
    private long videoStartTime;
    private Map<String, Object> customParamsMap = new ConcurrentHashMap();
    private ActionRecorder actionRecorder = new ActionRecorder();
    private final a playHistory = new a();

    public VideoSession(@NonNull VideoEntity videoEntity, @NonNull int i3) {
        this.videoEntity = videoEntity;
        this.contentId = videoEntity.getContentId();
        this.contentType = videoEntity.getContentType();
        this.customParamsMap.putAll(videoEntity.getVideoCustomParams());
        this.isBizReady = videoEntity.isBizReady();
        this.videoPlayerObject = i3;
    }

    public void bizReady() {
        this.isBizReady = true;
    }

    public void bufferEnd() {
        this.playStartTime = SystemClock.elapsedRealtime();
    }

    public synchronized void bufferStart() {
        if (this.playStartTime == -1) {
            return;
        }
        this.playedTime += SystemClock.elapsedRealtime() - this.playStartTime;
        this.playStartTime = -1L;
    }

    public synchronized void end(long j3, int i3) {
        if (this.playStartTime != -1) {
            this.playedTime += SystemClock.elapsedRealtime() - this.playStartTime;
            this.playStartTime = -1L;
        }
        this.playEndPosition = j3;
        this.playEndReason = i3;
        this.videoEndTime = System.currentTimeMillis();
        this.actionRecorder.end(j3);
        VideoPlayRecorder.dealSumPlayDuration(this);
        VideoPlayRecorder.playEnd(this);
    }

    public String getContentId() {
        return this.contentId;
    }

    public int getContentType() {
        return this.contentType;
    }

    public Map<String, Object> getCurPage() {
        return this.curPage;
    }

    public Map<String, Object> getCustomParams() {
        return this.customParamsMap;
    }

    public long getEndPosition() {
        return this.playEndPosition;
    }

    public String getIdentifier() {
        return this.videoEntity.getIdentifier();
    }

    public int getPageId() {
        return this.videoEntity.getPageId();
    }

    public String getPlayEndReason() {
        return String.valueOf(this.playEndReason);
    }

    public a getPlayHistory() {
        this.playHistory.e(getEndPosition());
        this.playHistory.f(getPageId());
        this.playHistory.d(getContentId());
        return this.playHistory;
    }

    public String getPlayedTime() {
        return String.valueOf(this.playedTime);
    }

    public String getSeekRecord() {
        return this.actionRecorder.getSeekRecord();
    }

    public String getSpeedRatioRecord() {
        return this.actionRecorder.getSpeedRatioRecord();
    }

    public Map<String, Object> getStartParams() {
        return this.startParams;
    }

    public String getStartPlayReason() {
        return String.valueOf(this.playStartReason);
    }

    public String getStartPlayType() {
        return String.valueOf(this.playType);
    }

    public long getStartPosition() {
        return this.startPosition;
    }

    public String getVideoDuration() {
        return String.valueOf(this.videoEntity.getVideoDuration());
    }

    public long getVideoEndTime() {
        return this.videoEndTime;
    }

    public int getVideoPlayerObject() {
        return this.videoPlayerObject;
    }

    public long getVideoStartTime() {
        return this.videoStartTime;
    }

    public View getVideoView() {
        return this.videoEntity.getVideoView();
    }

    public boolean hasStashStart() {
        if (this.startParams != null) {
            return true;
        }
        return false;
    }

    public boolean isBizReady() {
        return this.isBizReady;
    }

    public boolean isIgnoreReport() {
        return this.videoEntity.isIgnoreReport;
    }

    public void seekTo(long j3, long j16) {
        this.actionRecorder.seekTo(j3, j16);
    }

    public void setContentType(int i3) {
        this.contentType = i3;
    }

    public void setCurPage(Map<String, Object> map) {
        this.curPage = map;
    }

    public void setPlayedTime(long j3) {
        this.playedTime = j3;
    }

    public void setStartParams(Map<String, Object> map) {
        this.startParams = map;
    }

    public void setStartPosition(long j3) {
        this.startPosition = j3;
    }

    public void setVideoEndTime(long j3) {
        this.videoEndTime = j3;
    }

    public void setVideoStartTime(long j3) {
        this.videoStartTime = j3;
    }

    public void speedRatioPlay(float f16, long j3) {
        this.actionRecorder.speedRatioPlay(f16, j3);
        VideoPlayRecorder.speedRatioPlay(this, f16, j3);
    }

    public synchronized void stagingEnd(long j3, int i3) {
        if (this.playStartTime != -1) {
            this.playedTime += SystemClock.elapsedRealtime() - this.playStartTime;
            this.playStartTime = SystemClock.elapsedRealtime();
        }
        this.playEndPosition = j3;
        this.playEndReason = i3;
        this.videoEndTime = System.currentTimeMillis();
        VideoPlayRecorder.stagingEnd(this);
        this.playHistory.e(this.playEndPosition);
    }

    public void start(int i3, long j3, int i16, float f16) {
        this.playStartReason = i3;
        this.startPosition = j3;
        this.playStartTime = SystemClock.elapsedRealtime();
        this.playedTime = 0L;
        this.playType = i16;
        this.videoStartTime = System.currentTimeMillis();
        this.actionRecorder.start(j3, f16);
        VideoPlayRecorder.dealVideoIndex(this);
        VideoPlayRecorder.playStart(this, f16);
    }

    public void updateVideoEntity(VideoBaseEntity videoBaseEntity) {
        this.videoEntity = videoBaseEntity;
        this.customParamsMap.putAll(videoBaseEntity.getVideoCustomParams());
        this.contentType = videoBaseEntity.getContentType();
        this.playHistory.f(videoBaseEntity.pageId);
    }
}
