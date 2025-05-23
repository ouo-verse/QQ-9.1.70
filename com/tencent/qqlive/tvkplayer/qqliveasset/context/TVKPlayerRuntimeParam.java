package com.tencent.qqlive.tvkplayer.qqliveasset.context;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKAudioTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKSubtitleTrackVinfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes23.dex */
public class TVKPlayerRuntimeParam {
    public static final long INVALID_SEEK_POSITION = -1;

    @TVKResetField(resetStage = 1)
    private volatile long mDownloadSpeedKBps;

    @TVKResetField(resetStage = 1)
    private long mElapsedRealTimeOnGetCgiPlaybackUrlMs;

    @TVKResetField(resetStage = 1)
    private int mErrorRetryCount;

    @TVKResetField(resetStage = 1)
    private boolean mIsBackground;

    @TVKResetField(resetStage = 1)
    private volatile long mLastPositionMs;

    @TVKResetField(resetStage = 1)
    private boolean mLiveBackPlay;

    @TVKResetField(resetStage = 1)
    private long mLiveStartPlayTimeMs;

    @TVKResetField(resetStage = 1)
    private ITPMediaAsset mMediaAsset;

    @TVKResetField(resetStage = 1)
    private int mMediaFormat;

    @TVKResetField(resetStage = 1)
    private volatile TVKNetVideoInfo mNetVideoInfo;

    @TVKResetField(resetStage = 1)
    private long mSkipEndPositionMs;

    @TVKResetField(resetStage = 1)
    private long mStartPositionMs;

    @TVKResetField(resetStage = 1)
    private String mStreamDumpInfo;

    @TVKResetField(resetStage = 1)
    private ITVKAsset mTVKAsset;

    @TVKResetField(resetStage = 1)
    private long mVideoDurationMs;

    @TVKResetField(resetStage = 1)
    private int mVideoHeight;

    @TVKResetField(resetStage = 1)
    private int mVideoRotation;

    @TVKResetField(resetStage = 1)
    private int mVideoWidth;

    @TVKResetField(resetStage = 1)
    private final List<TVKTrackInfo> mToBeRemovedVinfoTrackForTPPlayerList = new CopyOnWriteArrayList();

    @TVKResetField(resetStage = 1)
    private volatile boolean mShouldUpdateSimulatedLiveParams = false;

    @TVKResetField(defaultInt = 1, resetStage = 1)
    private int mSeekMode = 1;

    @TVKResetField(defaultLong = -1, resetStage = 1)
    private long mSeekPositionMs = -1;

    @TVKResetField(resetStage = 1)
    private boolean mIsAvsSeparateDolbyAudioTrackSwitching = false;

    @TVKResetField(resetStage = 1)
    private boolean mIsQuickPlayWithOfflineResource = false;

    @TVKResetField(defaultBoolean = false, resetStage = 1)
    private boolean mDisableDataTransport = false;

    @NonNull
    @TVKResetField(resetStage = 1)
    private final List<TVKTrackInfo> mTrackInfoList = new CopyOnWriteArrayList();

    private void resetField(Field field, TVKResetField tVKResetField) {
        try {
            field.setAccessible(true);
            if (field.getType() == Integer.TYPE) {
                field.set(this, Integer.valueOf(tVKResetField.defaultInt()));
            } else if (field.getType() == Long.TYPE) {
                field.set(this, Long.valueOf(tVKResetField.defaultLong()));
            } else if (field.getType() == Boolean.TYPE) {
                field.set(this, Boolean.valueOf(tVKResetField.defaultBoolean()));
            } else if (field.getType() == Float.TYPE) {
                field.set(this, Float.valueOf(tVKResetField.defaultFloat()));
            } else if (field.getType() == Double.TYPE) {
                field.set(this, Double.valueOf(tVKResetField.defaultDouble()));
            } else if (field.getType() == String.class) {
                field.set(this, tVKResetField.defaultString());
            } else if (field.getType() == List.class && field.get(this) != null) {
                ((List) field.get(this)).clear();
            } else {
                field.set(this, null);
            }
        } catch (IllegalAccessException e16) {
            TVKLogUtil.e("TVKPlayer-RuntimeParam", e16);
        }
    }

    public void addTrackInfo(TVKTrackInfo tVKTrackInfo) {
        this.mTrackInfoList.add(tVKTrackInfo);
    }

    public void clear(int i3) {
        for (Field field : getClass().getDeclaredFields()) {
            TVKResetField tVKResetField = (TVKResetField) field.getAnnotation(TVKResetField.class);
            if (tVKResetField != null && tVKResetField.resetStage() == i3) {
                resetField(field, tVKResetField);
            }
        }
    }

    public boolean disableDataTransport() {
        return this.mDisableDataTransport;
    }

    public long getDownloadSpeedKBps() {
        return this.mDownloadSpeedKBps;
    }

    public long getElapsedRealTimeOnGetCgiPlaybackUrlMs() {
        return this.mElapsedRealTimeOnGetCgiPlaybackUrlMs;
    }

    public int getErrorRetryCount() {
        return this.mErrorRetryCount;
    }

    public long getLastPositionMs() {
        return this.mLastPositionMs;
    }

    public long getLiveStartPlayTimeMs() {
        return this.mLiveStartPlayTimeMs;
    }

    public int getMediaFormat() {
        return this.mMediaFormat;
    }

    public TVKNetVideoInfo getNetVideoInfo() {
        return this.mNetVideoInfo;
    }

    public int getSeekMode() {
        return this.mSeekMode;
    }

    public long getSeekPositionMs() {
        return this.mSeekPositionMs;
    }

    public long getSkipEndPositionMs() {
        return this.mSkipEndPositionMs;
    }

    public long getStartPositionMs() {
        return this.mStartPositionMs;
    }

    @NonNull
    public String getStreamDumpInfo() {
        return this.mStreamDumpInfo;
    }

    public ITPMediaAsset getTPMediaAsset() {
        return this.mMediaAsset;
    }

    public ITVKAsset getTVKAsset() {
        return this.mTVKAsset;
    }

    public List<TVKTrackInfo> getToBeRemovedVinfoTrackForTPPlayerList() {
        return this.mToBeRemovedVinfoTrackForTPPlayerList;
    }

    @NonNull
    public List<TVKTrackInfo> getTrackInfoList() {
        return this.mTrackInfoList;
    }

    public long getVideoDurationMs() {
        return this.mVideoDurationMs;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoRotation() {
        return this.mVideoRotation;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void increaseErrorRetryCount() {
        this.mErrorRetryCount++;
    }

    public boolean isAvsSeparateDolbyAudioTrackSwitching() {
        return this.mIsAvsSeparateDolbyAudioTrackSwitching;
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public boolean isDolbyVision() {
        if (this.mNetVideoInfo == null || this.mNetVideoInfo.getCurDefinition() == null) {
            return false;
        }
        TVKNetVideoInfo.DefnInfo curDefinition = this.mNetVideoInfo.getCurDefinition();
        if (!TVKDefinitionType.DEFINITION_TYPE_DOLBYVISION.equals(curDefinition.getDefn()) || curDefinition.getVideoCodec() != 4) {
            return false;
        }
        return true;
    }

    public boolean isLiveBackPlay() {
        return this.mLiveBackPlay;
    }

    public boolean isNeedSDREnhance() {
        if (this.mNetVideoInfo == null || this.mNetVideoInfo.getCurDefinition() == null) {
            return false;
        }
        TVKNetVideoInfo.DefnInfo curDefinition = this.mNetVideoInfo.getCurDefinition();
        if (!"hdr10".equals(curDefinition.getDefn()) || 3 == curDefinition.getVideoCodec() || curDefinition.getHdr10EnHance() != 1) {
            return false;
        }
        return true;
    }

    public boolean isNeedSuperResolution() {
        if (this.mNetVideoInfo == null || this.mNetVideoInfo.getCurDefinition() == null || this.mNetVideoInfo.getCurDefinition().getSuperResolution() <= 0) {
            return false;
        }
        return true;
    }

    public boolean isPreview() {
        if (this.mNetVideoInfo == null) {
            return false;
        }
        return this.mNetVideoInfo.isPreview();
    }

    public boolean isQuickPlayWithOfflineResource() {
        return this.mIsQuickPlayWithOfflineResource;
    }

    public void removeAllCgiReturnTrackInfoByTrackType(int i3) {
        for (TVKTrackInfo tVKTrackInfo : this.mTrackInfoList) {
            if (tVKTrackInfo.getTrackType() == i3 && ((tVKTrackInfo instanceof TVKAudioTrackVinfo) || (tVKTrackInfo instanceof TVKSubtitleTrackVinfo))) {
                this.mTrackInfoList.remove(tVKTrackInfo);
                this.mToBeRemovedVinfoTrackForTPPlayerList.add(tVKTrackInfo);
            }
        }
    }

    public void setAvsSeparateDolbyAudioTrackSwitching(boolean z16) {
        this.mIsAvsSeparateDolbyAudioTrackSwitching = z16;
    }

    public void setBackground(boolean z16) {
        this.mIsBackground = z16;
    }

    public void setDownloadSpeedKBps(long j3) {
        this.mDownloadSpeedKBps = j3;
    }

    public void setElapsedRealTimeOnGetCgiPlaybackUrlMs(long j3) {
        this.mElapsedRealTimeOnGetCgiPlaybackUrlMs = j3;
    }

    public void setLastPositionMs(long j3) {
        this.mLastPositionMs = j3;
    }

    public void setLiveBackPlay(boolean z16) {
        this.mLiveBackPlay = z16;
    }

    public void setLiveStartPlayTimeMs(long j3) {
        this.mLiveStartPlayTimeMs = j3;
    }

    public void setMediaFormat(int i3) {
        this.mMediaFormat = i3;
    }

    public void setNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        this.mNetVideoInfo = tVKNetVideoInfo;
    }

    public void setQuickPlayWithOfflineResource(boolean z16) {
        this.mIsQuickPlayWithOfflineResource = z16;
    }

    public void setSeekMode(int i3) {
        this.mSeekMode = i3;
    }

    public void setSeekPositionMs(long j3) {
        this.mSeekPositionMs = j3;
    }

    public void setShouldUpdateSimulatedLiveParams(boolean z16) {
        this.mShouldUpdateSimulatedLiveParams = z16;
    }

    public void setSkipEndPositionMs(long j3) {
        this.mSkipEndPositionMs = j3;
    }

    public void setStartPositionMs(long j3) {
        this.mStartPositionMs = j3;
    }

    public void setStreamDumpInfo(String str) {
        this.mStreamDumpInfo = str;
    }

    public void setTPMediaAsset(ITPMediaAsset iTPMediaAsset) {
        this.mMediaAsset = iTPMediaAsset;
    }

    public void setTVKAsset(ITVKAsset iTVKAsset) {
        this.mTVKAsset = iTVKAsset;
    }

    public void setVideoDurationMs(long j3) {
        this.mVideoDurationMs = j3;
    }

    public void setVideoRotation(int i3) {
        this.mVideoRotation = i3;
    }

    public void setVideoWidthAndHeight(int i3, int i16) {
        this.mVideoWidth = i3;
        this.mVideoHeight = i16;
    }

    public boolean shouldUpdateSimulatedLiveParams() {
        return this.mShouldUpdateSimulatedLiveParams;
    }

    public void disableDataTransport(boolean z16) {
        this.mDisableDataTransport = z16;
    }
}
