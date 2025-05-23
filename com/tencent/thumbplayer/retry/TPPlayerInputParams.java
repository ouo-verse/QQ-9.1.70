package com.tencent.thumbplayer.retry;

import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public class TPPlayerInputParams {
    public static final int SET_LOOPBACK_METHOD_TYPE_LOOPBACK = 0;
    public static final int SET_LOOPBACK_METHOD_TYPE_LOOPBACK_WITH_POSITION_MS = 1;
    private static final String TAG = "TPPlayerInputParams";
    private String mAudioNormalizeVolumeParams;
    private float mAudioVolume;
    private boolean mIsAudioMute;
    private LoopbackArguments mLoopbackArguments;
    private ITPMediaAsset mMediaAsset;
    private float mPlaySpeedRatio;

    @Nullable
    private SelectProgramAsyncArguments mSelectProgramAsyncArguments;
    private Object mSurfaceObj;
    private List<SubtitleArguments> mSubtitleArgumentList = new ArrayList();
    private List<AudioTrackArguments> mAudioTrackArgumentList = new ArrayList();
    private List<TPOptionalParam<?>> mOptionalParamList = new ArrayList();
    private final List<Object> mSelectAndDeselectTrackArgumentList = new ArrayList();

    /* loaded from: classes26.dex */
    public static class AudioTrackArguments {
        private ITPMediaAsset mMediaAsset;
        private String mName;

        public ITPMediaAsset getMediaAsset() {
            return this.mMediaAsset;
        }

        public String getName() {
            return this.mName;
        }

        public void setMediaAsset(ITPMediaAsset iTPMediaAsset) {
            this.mMediaAsset = iTPMediaAsset;
        }

        public void setName(String str) {
            this.mName = str;
        }
    }

    /* loaded from: classes26.dex */
    public static class DeselectTrackAsyncArguments {
        private int mMediaType;
        private String mTrackName;
        private long mUniqueID;

        public int getMediaType() {
            return this.mMediaType;
        }

        public String getTrackName() {
            return this.mTrackName;
        }

        public long getUniqueID() {
            return this.mUniqueID;
        }

        public void setMediaType(int i3) {
            this.mMediaType = i3;
        }

        public void setTrackName(String str) {
            this.mTrackName = str;
        }

        public void setUniqueID(long j3) {
            this.mUniqueID = j3;
        }

        public String toString() {
            return "DeselectTrackAsyncArguments{mMediaType=" + this.mMediaType + ", mTrackName='" + this.mTrackName + ", mUniqueID=" + this.mUniqueID + "}";
        }
    }

    /* loaded from: classes26.dex */
    public static class LoopbackArguments {
        private long mEndPositionMs;
        private boolean mIsLoopback;
        private int mLoopbackMethodType = 0;
        private long mStartPositionMs;

        public long getEndPositionMs() {
            return this.mEndPositionMs;
        }

        public int getLoopbackMethodType() {
            return this.mLoopbackMethodType;
        }

        public long getStartPositionMs() {
            return this.mStartPositionMs;
        }

        public boolean isLoopback() {
            return this.mIsLoopback;
        }

        public void setEndPositionMs(long j3) {
            this.mEndPositionMs = j3;
        }

        public void setLoopback(boolean z16) {
            this.mIsLoopback = z16;
        }

        public void setLoopbackMethodType(int i3) {
            this.mLoopbackMethodType = i3;
        }

        public void setStartPositionMs(long j3) {
            this.mStartPositionMs = j3;
        }
    }

    /* loaded from: classes26.dex */
    public static class SelectProgramAsyncArguments {
        private long mOpaque;
        private int mProgramIndex;

        public long getOpaque() {
            return this.mOpaque;
        }

        public int getProgramIndex() {
            return this.mProgramIndex;
        }

        public void setOpaque(long j3) {
            this.mOpaque = j3;
        }

        public void setProgramIndex(int i3) {
            this.mProgramIndex = i3;
        }
    }

    /* loaded from: classes26.dex */
    public static class SelectTrackAsyncArguments {
        private int mMediaType;
        private String mTrackName;
        private long mUniqueID;

        public int getMediaType() {
            return this.mMediaType;
        }

        public String getTrackName() {
            return this.mTrackName;
        }

        public long getUniqueID() {
            return this.mUniqueID;
        }

        public void setMediaType(int i3) {
            this.mMediaType = i3;
        }

        public void setTrackName(String str) {
            this.mTrackName = str;
        }

        public void setUniqueID(long j3) {
            this.mUniqueID = j3;
        }

        public String toString() {
            return "SelectTrackAsyncArguments{mMediaType=" + this.mMediaType + ", mTrackName='" + this.mTrackName + ", mUniqueID=" + this.mUniqueID + "}";
        }
    }

    /* loaded from: classes26.dex */
    public static class SubtitleArguments {
        private ITPMediaAsset mMediaAsset;
        private String mName;

        public ITPMediaAsset getMediaAsset() {
            return this.mMediaAsset;
        }

        public String getName() {
            return this.mName;
        }

        public void setMediaAsset(ITPMediaAsset iTPMediaAsset) {
            this.mMediaAsset = iTPMediaAsset;
        }

        public void setName(String str) {
            this.mName = str;
        }
    }

    public TPPlayerInputParams() {
        onReset();
    }

    @Nullable
    public String getAudioNormalizeVolumeParams() {
        return this.mAudioNormalizeVolumeParams;
    }

    @NonNull
    public List<AudioTrackArguments> getAudioTrackArgumentList() {
        return this.mAudioTrackArgumentList;
    }

    public float getAudioVolume() {
        return this.mAudioVolume;
    }

    @Nullable
    public LoopbackArguments getLoopbackArguments() {
        return this.mLoopbackArguments;
    }

    @Nullable
    public ITPMediaAsset getMediaAsset() {
        return this.mMediaAsset;
    }

    @Nullable
    public TPOptionalParam<?> getOptionalParam(@NonNull String str) {
        for (TPOptionalParam<?> tPOptionalParam : this.mOptionalParamList) {
            if (tPOptionalParam.getKey().equals(str)) {
                return tPOptionalParam;
            }
        }
        return null;
    }

    @NonNull
    public List<TPOptionalParam<?>> getOptionalParamList() {
        return this.mOptionalParamList;
    }

    public float getPlaySpeedRatio() {
        return this.mPlaySpeedRatio;
    }

    public List<Object> getSelectAndDeselectTrackArgumentList() {
        return this.mSelectAndDeselectTrackArgumentList;
    }

    @Nullable
    public SelectProgramAsyncArguments getSelectProgramAsyncArguments() {
        return this.mSelectProgramAsyncArguments;
    }

    @NonNull
    public List<SubtitleArguments> getSubtitleArgumentList() {
        return this.mSubtitleArgumentList;
    }

    @Nullable
    public Object getSurfaceObj() {
        return this.mSurfaceObj;
    }

    public boolean isAudioMute() {
        return this.mIsAudioMute;
    }

    public void onAddAudioTrackSource(ITPMediaAsset iTPMediaAsset, String str) {
        AudioTrackArguments audioTrackArguments = new AudioTrackArguments();
        audioTrackArguments.setMediaAsset(iTPMediaAsset);
        audioTrackArguments.setName(str);
        this.mAudioTrackArgumentList.add(audioTrackArguments);
    }

    public void onAddOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) {
        this.mOptionalParamList.add(tPOptionalParam);
    }

    public void onAddSubtitleTrackSource(ITPMediaAsset iTPMediaAsset, String str) {
        SubtitleArguments subtitleArguments = new SubtitleArguments();
        subtitleArguments.setMediaAsset(iTPMediaAsset);
        subtitleArguments.setName(str);
        this.mSubtitleArgumentList.add(subtitleArguments);
    }

    public void onDeselectTrackAsync(int i3, String str, long j3) {
        DeselectTrackAsyncArguments deselectTrackAsyncArguments = new DeselectTrackAsyncArguments();
        deselectTrackAsyncArguments.setMediaType(i3);
        deselectTrackAsyncArguments.setTrackName(str);
        deselectTrackAsyncArguments.setUniqueID(j3);
        this.mSelectAndDeselectTrackArgumentList.add(deselectTrackAsyncArguments);
    }

    public void onRelease() {
        onReset();
    }

    public void onRemoveAudioTrack(String str) {
        Iterator<AudioTrackArguments> it = this.mAudioTrackArgumentList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().getName(), str)) {
                it.remove();
                return;
            }
        }
    }

    public void onRemoveSubtitleTrack(String str) {
        Iterator<SubtitleArguments> it = this.mSubtitleArgumentList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().getName(), str)) {
                it.remove();
                return;
            }
        }
    }

    public void onReset() {
        this.mSubtitleArgumentList.clear();
        this.mAudioTrackArgumentList.clear();
        this.mSelectAndDeselectTrackArgumentList.clear();
        this.mIsAudioMute = false;
        this.mAudioVolume = 1.0f;
        this.mAudioNormalizeVolumeParams = null;
        this.mPlaySpeedRatio = 1.0f;
        this.mSurfaceObj = null;
        this.mOptionalParamList.clear();
        this.mMediaAsset = null;
        this.mLoopbackArguments = null;
        this.mSelectProgramAsyncArguments = null;
    }

    public void onSelectProgramAsync(int i3, long j3) {
        if (this.mSelectProgramAsyncArguments == null) {
            this.mSelectProgramAsyncArguments = new SelectProgramAsyncArguments();
        }
        this.mSelectProgramAsyncArguments.setProgramIndex(i3);
        this.mSelectProgramAsyncArguments.setOpaque(j3);
    }

    public void onSelectTrackAsync(int i3, String str, long j3) {
        SelectTrackAsyncArguments selectTrackAsyncArguments = new SelectTrackAsyncArguments();
        selectTrackAsyncArguments.setMediaType(i3);
        selectTrackAsyncArguments.setTrackName(str);
        selectTrackAsyncArguments.setUniqueID(j3);
        this.mSelectAndDeselectTrackArgumentList.add(selectTrackAsyncArguments);
    }

    public void onSetAudioMute(boolean z16) {
        this.mIsAudioMute = z16;
    }

    public void onSetAudioNormalizeVolumeParams(String str) {
        this.mAudioNormalizeVolumeParams = str;
    }

    public void onSetAudioVolume(float f16) {
        this.mAudioVolume = f16;
    }

    public void onSetDataSource(ITPMediaAsset iTPMediaAsset) {
        this.mMediaAsset = iTPMediaAsset;
    }

    public void onSetLoopback(boolean z16, long j3, long j16) {
        if (this.mLoopbackArguments == null) {
            this.mLoopbackArguments = new LoopbackArguments();
        }
        this.mLoopbackArguments.setLoopback(z16);
        this.mLoopbackArguments.setStartPositionMs(j3);
        this.mLoopbackArguments.setEndPositionMs(j16);
    }

    public void onSetPlaySpeedRatio(float f16) {
        this.mPlaySpeedRatio = f16;
    }

    public void onSetSurface(Surface surface) {
        this.mSurfaceObj = surface;
    }

    public void onSetSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceObj = surfaceHolder;
    }

    public void onSwitchDataSource(ITPMediaAsset iTPMediaAsset, long j3) {
        this.mMediaAsset = iTPMediaAsset;
    }

    public void onSwitchDataSource(ITPMediaAsset iTPMediaAsset, int i3, long j3) {
        this.mMediaAsset = iTPMediaAsset;
    }
}
