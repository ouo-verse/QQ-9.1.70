package com.tencent.thumbplayer.retry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPPlayerRuntimeParams {
    private static final int INVALID_INDEX = -1;
    public static final int SEEK_TO_ASYNC_METHOD_TYPE_MODE_OPAQUE = 1;
    public static final int SEEK_TO_ASYNC_METHOD_TYPE_OPAQUE = 0;
    public static final int SWITCH_DATA_SOURCE_AND_SELECT_TRACK_ASYNC_METHOD_TYPE_OPAQUE = 2;
    public static final int SWITCH_DATA_SOURCE_ASYNC_METHOD_TYPE_MODE_OPAQUE = 1;
    public static final int SWITCH_DATA_SOURCE_ASYNC_METHOD_TYPE_OPAQUE = 0;
    private long mAvailablePositionMs;
    private long mCurrentPositionMs;
    private long mDurationMs;
    private int mHeight;
    private boolean mIsRetrying;
    private boolean mIsUseRetryPlayerCore;
    private int mPlayerCoreType;
    private TPError mTPError;
    private int mWidth;
    private boolean mEnableReusePlayer = true;
    private final List<Long> mSelectOrDeselectTrackUniqueIDList = new ArrayList();
    private final Set<Integer> mNotifiedOnceInfoIDs = new HashSet();
    private final PendingInvokeArgumentsDuringRetry mPendingInvokeArgumentsDuringRetry = new PendingInvokeArgumentsDuringRetry();

    /* loaded from: classes26.dex */
    public static class PendingInvokeArgumentsDuringRetry {

        @Nullable
        private SeekArguments mSeekArguments;
        private final List<Long> mSelectAndDeselectTrackUniqueIDList = new ArrayList();

        @Nullable
        private SwitchedDataSourceArguments mSwitchedDataSourceArguments;

        public PendingInvokeArgumentsDuringRetry() {
            reset();
        }

        @Nullable
        public SeekArguments getSeekArguments() {
            return this.mSeekArguments;
        }

        @NonNull
        public List<Long> getSelectAndDeselectTrackRecordList() {
            return Collections.unmodifiableList(this.mSelectAndDeselectTrackUniqueIDList);
        }

        @Nullable
        public SwitchedDataSourceArguments getSwitchedDataSourceArguments() {
            return this.mSwitchedDataSourceArguments;
        }

        public void reset() {
            this.mSeekArguments = null;
            this.mSwitchedDataSourceArguments = null;
            this.mSelectAndDeselectTrackUniqueIDList.clear();
        }

        public void setSeekArguments(@Nullable SeekArguments seekArguments) {
            this.mSeekArguments = seekArguments;
        }

        public void setSwitchedDataSourceArguments(@Nullable SwitchedDataSourceArguments switchedDataSourceArguments) {
            this.mSwitchedDataSourceArguments = switchedDataSourceArguments;
        }
    }

    /* loaded from: classes26.dex */
    public static class SeekArguments {
        private int mSeekMode;
        private long mSeekPositionMs;
        private int mSeekToAsyncMethodType = 0;
        private long mUniqueID;

        public int getSeekMode() {
            return this.mSeekMode;
        }

        public long getSeekPositionMs() {
            return this.mSeekPositionMs;
        }

        public int getSeekToAsyncMethodType() {
            return this.mSeekToAsyncMethodType;
        }

        public long getUniqueID() {
            return this.mUniqueID;
        }

        public void setSeekMode(int i3) {
            this.mSeekMode = i3;
        }

        public void setSeekPositionMs(long j3) {
            this.mSeekPositionMs = j3;
        }

        public void setSeekToAsyncMethodType(int i3) {
            this.mSeekToAsyncMethodType = i3;
        }

        public void setUniqueID(long j3) {
            this.mUniqueID = j3;
        }

        public String toString() {
            return "SeekArguments{mSeekToAsyncMethodType=" + this.mSeekToAsyncMethodType + ", mSeekPositionMs=" + this.mSeekPositionMs + ", mSeekMode=" + this.mSeekMode + ", mUniqueID=" + this.mUniqueID + "}";
        }
    }

    /* loaded from: classes26.dex */
    public static class SwitchedDataSourceArguments {
        private ITPMediaAsset mMediaAsset;
        private int mMode;
        private int mSwitchDataSourceAsyncMethodType = 0;
        private String[] mTracksName;
        private long mUniqueID;

        @NonNull
        public ITPMediaAsset getMediaAsset() {
            return this.mMediaAsset;
        }

        public int getMode() {
            return this.mMode;
        }

        public int getSwitchDataSourceAsyncMethodType() {
            return this.mSwitchDataSourceAsyncMethodType;
        }

        public String[] getTracksName() {
            return this.mTracksName;
        }

        public long getUniqueID() {
            return this.mUniqueID;
        }

        public void setMediaAsset(@NonNull ITPMediaAsset iTPMediaAsset) {
            this.mMediaAsset = iTPMediaAsset;
        }

        public void setMode(int i3) {
            this.mMode = i3;
        }

        public void setSwitchDataSourceAsyncMethodType(int i3) {
            this.mSwitchDataSourceAsyncMethodType = i3;
        }

        public void setTracksName(String[] strArr) {
            this.mTracksName = strArr;
        }

        public void setUniqueID(long j3) {
            this.mUniqueID = j3;
        }

        public String toString() {
            return "SwitchedDataSourceArguments{mSwitchDataSourceAsyncMethodType=" + this.mSwitchDataSourceAsyncMethodType + ", mMediaAsset=" + this.mMediaAsset + ", mMode=" + this.mMode + ", mUniqueID=" + this.mUniqueID + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TPPlayerRuntimeParams() {
        onReset();
    }

    public void addDeselectTrackRecord(long j3) {
        this.mSelectOrDeselectTrackUniqueIDList.add(Long.valueOf(j3));
        this.mPendingInvokeArgumentsDuringRetry.mSelectAndDeselectTrackUniqueIDList.add(Long.valueOf(j3));
    }

    public void addNotifiedOnceInfoID(int i3) {
        this.mNotifiedOnceInfoIDs.add(Integer.valueOf(i3));
    }

    public void addSelectTrackRecord(long j3) {
        this.mSelectOrDeselectTrackUniqueIDList.add(Long.valueOf(j3));
        this.mPendingInvokeArgumentsDuringRetry.mSelectAndDeselectTrackUniqueIDList.add(Long.valueOf(j3));
    }

    public boolean findSelectOrDeselectTrackRecordWithUniqueID(long j3) {
        return findSelectOrDeselectTrackRecordWithUniqueID(j3, this.mSelectOrDeselectTrackUniqueIDList) != -1;
    }

    public long getAvailablePositionMs() {
        return this.mAvailablePositionMs;
    }

    public long getCurrentPositionMs() {
        return this.mCurrentPositionMs;
    }

    public long getDurationMs() {
        return this.mDurationMs;
    }

    public TPError getError() {
        return this.mTPError;
    }

    public int getHeight() {
        return this.mHeight;
    }

    @NonNull
    public PendingInvokeArgumentsDuringRetry getPendingInvokeArgumentsDuringRetry() {
        return this.mPendingInvokeArgumentsDuringRetry;
    }

    public int getPlayerCoreType() {
        return this.mPlayerCoreType;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isEnableReusePlayer() {
        return this.mEnableReusePlayer;
    }

    public boolean isOnceInfoIDNotified(int i3) {
        return this.mNotifiedOnceInfoIDs.contains(Integer.valueOf(i3));
    }

    public boolean isRetrying() {
        return this.mIsRetrying;
    }

    public boolean isUseRetryPlayerCore() {
        return this.mIsUseRetryPlayerCore;
    }

    public void onRelease() {
        onReset();
    }

    public void onReset() {
        this.mIsRetrying = false;
        this.mEnableReusePlayer = true;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDurationMs = 0L;
        this.mCurrentPositionMs = 0L;
        this.mAvailablePositionMs = 0L;
        this.mNotifiedOnceInfoIDs.clear();
        this.mPlayerCoreType = 0;
        this.mSelectOrDeselectTrackUniqueIDList.clear();
        this.mPendingInvokeArgumentsDuringRetry.reset();
        this.mIsUseRetryPlayerCore = false;
        this.mTPError = null;
    }

    public void onRetryFinished() {
        this.mTPError = null;
        this.mIsRetrying = false;
        this.mPendingInvokeArgumentsDuringRetry.reset();
    }

    public void onSeekComplete(long j3) {
        if (this.mPendingInvokeArgumentsDuringRetry.getSeekArguments() != null && this.mPendingInvokeArgumentsDuringRetry.getSeekArguments().getUniqueID() == j3) {
            this.mPendingInvokeArgumentsDuringRetry.setSeekArguments(null);
        }
    }

    public void onSeekToAsync(long j3, long j16) {
        SeekArguments seekArguments = new SeekArguments();
        seekArguments.setSeekToAsyncMethodType(0);
        seekArguments.setSeekPositionMs(j3);
        seekArguments.setUniqueID(j16);
        this.mPendingInvokeArgumentsDuringRetry.setSeekArguments(seekArguments);
    }

    public void onStop() {
        this.mTPError = null;
        this.mIsRetrying = false;
        this.mNotifiedOnceInfoIDs.clear();
        this.mPendingInvokeArgumentsDuringRetry.reset();
    }

    public void onSwitchDataSource(ITPMediaAsset iTPMediaAsset, long j3) {
        SwitchedDataSourceArguments switchedDataSourceArguments = new SwitchedDataSourceArguments();
        switchedDataSourceArguments.setSwitchDataSourceAsyncMethodType(0);
        switchedDataSourceArguments.setMediaAsset(iTPMediaAsset);
        switchedDataSourceArguments.setUniqueID(j3);
        this.mPendingInvokeArgumentsDuringRetry.setSwitchedDataSourceArguments(switchedDataSourceArguments);
    }

    public void onSwitchDataSourceAndSelectTrack(ITPMediaAsset iTPMediaAsset, int i3, String[] strArr, long j3) {
        SwitchedDataSourceArguments switchedDataSourceArguments = new SwitchedDataSourceArguments();
        switchedDataSourceArguments.setSwitchDataSourceAsyncMethodType(2);
        switchedDataSourceArguments.setMediaAsset(iTPMediaAsset);
        switchedDataSourceArguments.setMode(i3);
        switchedDataSourceArguments.setTracksName(strArr);
        switchedDataSourceArguments.setUniqueID(j3);
        this.mPendingInvokeArgumentsDuringRetry.setSwitchedDataSourceArguments(switchedDataSourceArguments);
    }

    public void onSwitchDatasourceComplete(long j3) {
        if (this.mPendingInvokeArgumentsDuringRetry.getSwitchedDataSourceArguments() != null && this.mPendingInvokeArgumentsDuringRetry.getSwitchedDataSourceArguments().getUniqueID() == j3) {
            this.mPendingInvokeArgumentsDuringRetry.setSwitchedDataSourceArguments(null);
        }
    }

    public void removeSelectOrDeselectTrackRecord(long j3) {
        int findSelectOrDeselectTrackRecordWithUniqueID = findSelectOrDeselectTrackRecordWithUniqueID(j3, this.mSelectOrDeselectTrackUniqueIDList);
        if (findSelectOrDeselectTrackRecordWithUniqueID != -1) {
            this.mSelectOrDeselectTrackUniqueIDList.remove(findSelectOrDeselectTrackRecordWithUniqueID);
        }
        int findSelectOrDeselectTrackRecordWithUniqueID2 = findSelectOrDeselectTrackRecordWithUniqueID(j3, this.mPendingInvokeArgumentsDuringRetry.mSelectAndDeselectTrackUniqueIDList);
        if (findSelectOrDeselectTrackRecordWithUniqueID2 != -1) {
            this.mPendingInvokeArgumentsDuringRetry.mSelectAndDeselectTrackUniqueIDList.remove(findSelectOrDeselectTrackRecordWithUniqueID2);
        }
    }

    public void setAvailablePositionMs(long j3) {
        this.mAvailablePositionMs = j3;
    }

    public void setCurrentPositionMs(long j3) {
        this.mCurrentPositionMs = j3;
    }

    public void setDurationMs(long j3) {
        this.mDurationMs = j3;
    }

    public void setEnableReusePlayer(boolean z16) {
        this.mEnableReusePlayer = z16;
    }

    public void setError(TPError tPError) {
        this.mTPError = tPError;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
    }

    public void setPlayerCoreType(int i3) {
        this.mPlayerCoreType = i3;
    }

    public void setRetrying(boolean z16) {
        this.mIsRetrying = z16;
    }

    public void setUseRetryPlayerCore(boolean z16) {
        this.mIsUseRetryPlayerCore = z16;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
    }

    private int findSelectOrDeselectTrackRecordWithUniqueID(long j3, List<Long> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).longValue() == j3) {
                return i3;
            }
        }
        return -1;
    }

    public void onSeekToAsync(long j3, int i3, long j16) {
        SeekArguments seekArguments = new SeekArguments();
        seekArguments.setSeekToAsyncMethodType(1);
        seekArguments.setSeekPositionMs(j3);
        seekArguments.setSeekMode(i3);
        seekArguments.setUniqueID(j16);
        this.mPendingInvokeArgumentsDuringRetry.setSeekArguments(seekArguments);
    }

    public void onSwitchDataSource(ITPMediaAsset iTPMediaAsset, int i3, long j3) {
        SwitchedDataSourceArguments switchedDataSourceArguments = new SwitchedDataSourceArguments();
        switchedDataSourceArguments.setSwitchDataSourceAsyncMethodType(1);
        switchedDataSourceArguments.setMediaAsset(iTPMediaAsset);
        switchedDataSourceArguments.setMode(i3);
        switchedDataSourceArguments.setUniqueID(j3);
        this.mPendingInvokeArgumentsDuringRetry.setSwitchedDataSourceArguments(switchedDataSourceArguments);
    }
}
