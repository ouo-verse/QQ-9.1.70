package com.tencent.qqlive.tvkplayer.qqliveasset.context;

import android.os.Looper;
import android.util.Pair;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKDontFuckingProguard;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@TVKDontFuckingProguard
/* loaded from: classes23.dex */
public class TVKPlayerInputParam {

    @TVKResetField(resetStage = 1)
    private Integer mAdaptiveMode;

    @TVKResetField(resetStage = 0)
    private Looper mCallbackLooper;

    @TVKResetField(defaultFloat = 0.0f, resetStage = 1)
    private float mDisplayViewOffsetX;

    @TVKResetField(defaultFloat = 0.0f, resetStage = 1)
    private float mDisplayViewOffsetY;

    @TVKResetField(resetStage = 1)
    private Pair<Float, Float> mDisplayViewScaleAnchor;

    @TVKResetField(resetStage = 0)
    private ITVKDrawableContainer mDrawableContainer;

    @TVKResetField(resetStage = 1)
    private boolean mEnableBackgroundPlay;

    @TVKResetField(resetStage = 1)
    private String mFlowId;

    @TVKResetField(resetStage = 1)
    private boolean mIsAudioProcessorConnected;

    @TVKResetField(resetStage = 1)
    private boolean mIsLoopback;

    @TVKResetField(resetStage = 1)
    private boolean mIsVideoProcessorConnected;

    @TVKResetField(resetStage = 1)
    private long mLiveBackPlayTimeSec;

    @TVKResetField(resetStage = 1)
    private long mLoopEndPositionMs;

    @TVKResetField(resetStage = 1)
    private long mLoopStartPositionMs;

    @TVKResetField(resetStage = 1)
    private boolean mOutputMute;

    @TVKResetField(resetStage = 1)
    private TVKPlayerVideoInfo mPlayerVideoInfo;

    @TVKResetField(resetStage = 0)
    private ITVKVideoViewPrivate mPlayerView;

    @TVKResetField(resetStage = 1)
    private TVKUserInfo mUserInfo;

    @TVKResetField(resetStage = 0)
    private Looper mWorkThreadLooper;

    @TVKResetField(defaultFloat = 1.0f, resetStage = 1)
    private float mDisplayViewScale = 1.0f;

    @TVKResetField(defaultInt = 0, resetStage = 1)
    private int mViewXYaxis = 0;

    @TVKResetField(defaultInt = 0, resetStage = 1)
    private int mViewAlignment = 0;

    @TVKResetField(defaultFloat = 1.0f, resetStage = 1)
    private float mSpeedRatio = 1.0f;

    @TVKResetField(defaultString = "", resetStage = 1)
    private String mDefinition = "";

    @TVKResetField(defaultBoolean = false, resetStage = 1)
    private boolean mIsAdaptiveDefinition = false;

    @TVKResetField(defaultString = "", resetStage = 1)
    private String mCurAudioTrack = "";

    @TVKResetField(defaultString = "", resetStage = 1)
    private String mCurSubtitleTrack = "";

    @TVKResetField(defaultFloat = 1.0f, resetStage = 1)
    private float mAudioGainRatio = 1.0f;

    @TVKResetField(resetStage = 1)
    private final List<TPOptionalParam<?>> mInitOptionalParamList = new ArrayList();

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
            TVKLogUtil.e("TVKPlayer-InputParam", e16);
        }
    }

    public void addInitParamToList(TPOptionalParam<?> tPOptionalParam) {
        this.mInitOptionalParamList.add(tPOptionalParam);
    }

    public void clear(int i3) {
        for (Field field : getClass().getDeclaredFields()) {
            TVKResetField tVKResetField = (TVKResetField) field.getAnnotation(TVKResetField.class);
            if (tVKResetField != null && tVKResetField.resetStage() == i3) {
                resetField(field, tVKResetField);
            }
        }
    }

    public Integer getAdaptiveMode() {
        return this.mAdaptiveMode;
    }

    public float getAudioVolume() {
        return this.mAudioGainRatio;
    }

    public Looper getCallbackLooper() {
        return this.mCallbackLooper;
    }

    public String getCurAudioTrack() {
        return this.mCurAudioTrack;
    }

    public String getCurSubtitleTrack() {
        return this.mCurSubtitleTrack;
    }

    public String getDefinition() {
        return this.mDefinition;
    }

    public float getDisplayViewOffsetX() {
        return this.mDisplayViewOffsetX;
    }

    public float getDisplayViewOffsetY() {
        return this.mDisplayViewOffsetY;
    }

    public float getDisplayViewScale() {
        return this.mDisplayViewScale;
    }

    public Pair<Float, Float> getDisplayViewScaleAnchor() {
        return this.mDisplayViewScaleAnchor;
    }

    public ITVKDrawableContainer getDrawableContainer() {
        return this.mDrawableContainer;
    }

    public String getFlowId() {
        return this.mFlowId;
    }

    public List<TPOptionalParam<?>> getInitOptionalParamList() {
        return this.mInitOptionalParamList;
    }

    public long getLiveBackPlayTimeSec() {
        return this.mLiveBackPlayTimeSec;
    }

    public long getLoopEndPositionMs() {
        return this.mLoopEndPositionMs;
    }

    public long getLoopStartPositionMs() {
        return this.mLoopStartPositionMs;
    }

    public TVKPlayerVideoInfo getPlayerVideoInfo() {
        return this.mPlayerVideoInfo;
    }

    public ITVKVideoViewPrivate getPlayerView() {
        return this.mPlayerView;
    }

    public float getSpeedRatio() {
        return this.mSpeedRatio;
    }

    public TVKUserInfo getUserInfo() {
        return this.mUserInfo;
    }

    public int getViewAlignment() {
        return this.mViewAlignment;
    }

    public int getViewXYaxis() {
        return this.mViewXYaxis;
    }

    public Looper getWorkThreadLooper() {
        return this.mWorkThreadLooper;
    }

    public boolean isAdaptiveDefinition() {
        return this.mIsAdaptiveDefinition;
    }

    public boolean isAudioProcessorConnected() {
        return this.mIsAudioProcessorConnected;
    }

    public boolean isEnableBackgroundPlay() {
        return this.mEnableBackgroundPlay;
    }

    public boolean isLoopback() {
        return this.mIsLoopback;
    }

    public boolean isOutputMute() {
        return this.mOutputMute;
    }

    public boolean isVideoProcessorConnected() {
        return this.mIsVideoProcessorConnected;
    }

    public void setAdaptiveDefinition(boolean z16) {
        this.mIsAdaptiveDefinition = z16;
    }

    public void setAdaptiveMode(Integer num) {
        this.mAdaptiveMode = num;
    }

    public void setAudioGainRatio(float f16) {
        this.mAudioGainRatio = f16;
    }

    public void setAudioProcessorConnected(boolean z16) {
        this.mIsAudioProcessorConnected = z16;
    }

    public void setCallbackLooper(Looper looper) {
        this.mCallbackLooper = looper;
    }

    public void setCurAudioTrack(String str) {
        this.mCurAudioTrack = str;
    }

    public void setCurSubtitleTrack(String str) {
        this.mCurSubtitleTrack = str;
    }

    public void setDefinition(String str) {
        this.mDefinition = str;
    }

    public void setDisplayViewOffsetX(float f16) {
        this.mDisplayViewOffsetX = f16;
    }

    public void setDisplayViewOffsetY(float f16) {
        this.mDisplayViewOffsetY = f16;
    }

    public void setDisplayViewScale(float f16) {
        this.mDisplayViewScale = f16;
    }

    public void setDisplayViewScaleAnchor(Pair<Float, Float> pair) {
        this.mDisplayViewScaleAnchor = pair;
    }

    public void setDrawableContainer(ITVKDrawableContainer iTVKDrawableContainer) {
        this.mDrawableContainer = iTVKDrawableContainer;
    }

    public void setEnableBackgroundPlay(boolean z16) {
        this.mEnableBackgroundPlay = z16;
    }

    public void setFlowId(String str) {
        this.mFlowId = str;
    }

    public void setLiveBackPlayTimeSec(long j3) {
        this.mLiveBackPlayTimeSec = j3;
    }

    public void setLoopEndPositionMs(long j3) {
        this.mLoopEndPositionMs = j3;
    }

    public void setLoopStartPositionMs(long j3) {
        this.mLoopStartPositionMs = j3;
    }

    public void setLoopback(boolean z16) {
        this.mIsLoopback = z16;
    }

    public void setOutputMute(boolean z16) {
        this.mOutputMute = z16;
    }

    public void setPlayerVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mPlayerVideoInfo = tVKPlayerVideoInfo;
    }

    public void setPlayerView(ITVKVideoViewPrivate iTVKVideoViewPrivate) {
        this.mPlayerView = iTVKVideoViewPrivate;
    }

    public void setSpeedRatio(float f16) {
        this.mSpeedRatio = f16;
    }

    public void setUserInfo(TVKUserInfo tVKUserInfo) {
        this.mUserInfo = tVKUserInfo;
    }

    public void setVideoProcessorConnected(boolean z16) {
        this.mIsVideoProcessorConnected = z16;
    }

    public void setViewAlignment(int i3) {
        this.mViewAlignment = i3;
    }

    public void setViewXYaxis(int i3) {
        this.mViewXYaxis = i3;
    }

    public void setWorkThreadLooper(Looper looper) {
        this.mWorkThreadLooper = looper;
    }

    public void setLoopback(boolean z16, long j3, long j16) {
        this.mIsLoopback = z16;
        this.mLoopStartPositionMs = j3;
        this.mLoopEndPositionMs = j16;
    }
}
