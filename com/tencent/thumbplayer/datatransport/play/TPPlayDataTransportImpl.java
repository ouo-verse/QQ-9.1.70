package com.tencent.thumbplayer.datatransport.play;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.asset.TPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadSwitchProxy;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes26.dex */
public class TPPlayDataTransportImpl implements ITPPlayDataTransport {
    private static final long THREAD_TIME_OUT_MS = 500;
    private final ITPDataTransportTaskMgr mDataTransport;
    private boolean mIsUseProxyAuthentication;
    private ITPPlayDataTransportListener mListener;
    public HashMap<String, TPOptionalParam<?>> mOptionalParams;
    private final TPContext mTPContext;
    private final ITPDataTransportTaskMgr.TaskListener mTaskListener;
    private final Deque<TPPlayDataTransportTask> mTaskQueue = new LinkedBlockingDeque();

    /* loaded from: classes26.dex */
    private class DataTransportTaskListener implements ITPDataTransportTaskMgr.TaskListener {
        DataTransportTaskListener() {
        }

        private void handleUpdateNextClip() {
            ITPSimulatedLiveMediaAsset.ITPSimulatedLiveListener simulatedLiveListener;
            if (!(TPPlayDataTransportImpl.this.mainTask().decoratedMediaAsset() instanceof TPSimulatedLiveMediaAsset) || (simulatedLiveListener = ((TPSimulatedLiveMediaAsset) TPPlayDataTransportImpl.this.mainTask().decoratedMediaAsset()).getSimulatedLiveListener()) == null) {
                return;
            }
            simulatedLiveListener.onNextAssetRequired((ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest) new TPThreadSwitchProxy(TPPlayDataTransportImpl.this.mainTask(), TPPlayDataTransportImpl.this.mTPContext.getWorkerLooper(), 500L).getProxyInstance());
        }

        private boolean isMainTaskCallback(int i3) {
            if (TPPlayDataTransportImpl.this.mainTask().getTransportId() == i3) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        @TPThreadSwitchProxy.ThreadSwitch
        public long getCurrentPlayOffset(int i3) {
            return TPPlayDataTransportImpl.this.mListener.onGetCurrentPlayOffsetByte();
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        @TPThreadSwitchProxy.ThreadSwitch
        public long getCurrentPosition(int i3) {
            return TPPlayDataTransportImpl.this.mListener.onGetCurrentPositionMs();
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        @TPThreadSwitchProxy.ThreadSwitch
        public long getPlayerBufferLength(int i3) {
            return TPPlayDataTransportImpl.this.mListener.onGetPlayerBufferLengthMs();
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        @TPThreadSwitchProxy.ThreadSwitch
        public long getRemainTimeBeforePlayMs(int i3) {
            return TPPlayDataTransportImpl.this.mListener.onGetRemainTimeBeforePlayMs();
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        @TPThreadSwitchProxy.ThreadSwitch
        public void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
            if (!isMainTaskCallback(i3)) {
                return;
            }
            if (i16 == 1) {
                TPPlayDataTransportImpl.this.mListener.onMediaAssetExpire();
                return;
            }
            if (i16 == 9) {
                TPPlayDataTransportImpl.this.mListener.onNeedReconnectDueToM3u8DataUpdate();
                return;
            }
            if (i16 == 12) {
                TPPlayDataTransportImpl.this.mListener.onNeedReconnectDueToMediaDataInvalid();
                return;
            }
            if (i16 == 2) {
                TPPlayDataTransportImpl.this.mListener.onSuggestedBitrateChanged(((Integer) tPDataTransportMessageInfo.obj3).intValue());
                return;
            }
            if (i16 == 21) {
                handleUpdateNextClip();
                return;
            }
            if (i16 == 14 && TPPlayDataTransportImpl.this.mainTask().isSwitchingDataSourceByteAlignWhenNextRequest()) {
                TPPlayDataTransportImpl.this.mListener.onSwitchDataSourceComplete(TPPlayDataTransportImpl.this.mainTask().getSwitchDataSourceOpaque());
                TPPlayDataTransportImpl.this.mainTask().setIsSwitchingDataSourceByteAlignWhenNextRequest(false);
                TPPlayDataTransportImpl.this.mainTask().setSwitchDataSourceOpaque(-1L);
            }
            TPPlayDataTransportImpl.this.mListener.onInfo(i16, tPDataTransportMessageInfo);
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        @TPThreadSwitchProxy.ThreadSwitch
        public void onDownloadError(int i3, int i16, int i17, String str) {
            if (!isMainTaskCallback(i3)) {
                return;
            }
            TPPlayDataTransportImpl.this.mListener.onError(new TPError(6000, i17));
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        @TPThreadSwitchProxy.ThreadSwitch
        public void onDownloadFinished(int i3) {
            if (!isMainTaskCallback(i3)) {
                return;
            }
            TPPlayDataTransportImpl.this.mListener.onDownloadFinished();
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        @TPThreadSwitchProxy.ThreadSwitch
        public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
            if (!isMainTaskCallback(i3)) {
                return;
            }
            TPDownloadProgressInfo tPDownloadProgressInfo = new TPDownloadProgressInfo();
            tPDownloadProgressInfo.setAvailablePositionMs(i16);
            tPDownloadProgressInfo.setDownloadSpeedbps(i17 * 1024 * 8);
            tPDownloadProgressInfo.setDownloadBytes(j3);
            tPDownloadProgressInfo.setFileTotalBytes(j16);
            tPDownloadProgressInfo.setExtraInfo(str);
            TPPlayDataTransportImpl.this.mainTask().updateProgressInfo(tPDownloadProgressInfo);
            TPPlayDataTransportImpl.this.mListener.onProgressUpdate(tPDownloadProgressInfo);
        }
    }

    public TPPlayDataTransportImpl(TPContext tPContext, ITPDataTransportTaskMgr iTPDataTransportTaskMgr) {
        this.mOptionalParams = new HashMap<>();
        this.mTPContext = tPContext;
        this.mDataTransport = iTPDataTransportTaskMgr;
        this.mTaskListener = (ITPDataTransportTaskMgr.TaskListener) new TPThreadSwitchProxy(new DataTransportTaskListener(), tPContext.getWorkerLooper(), 500L).getProxyInstance();
        this.mOptionalParams = new HashMap<>();
        TPLogUtil.i(getTag(), "create play data transport impl");
    }

    private void addTaskToQueue(TPPlayDataTransportTask tPPlayDataTransportTask) {
        if (!tPPlayDataTransportTask.isMainTask()) {
            this.mTaskQueue.offer(tPPlayDataTransportTask);
            return;
        }
        for (TPPlayDataTransportTask tPPlayDataTransportTask2 : this.mTaskQueue) {
            if (tPPlayDataTransportTask2.isMainTask()) {
                tPPlayDataTransportTask2.setIsMainTask(false);
            }
        }
        this.mTaskQueue.offer(tPPlayDataTransportTask);
    }

    private String getTag() {
        return this.mTPContext.getLogTag() + "_" + ITPPlayDataTransport.TAG + "_impl";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public TPPlayDataTransportTask mainTask() {
        for (TPPlayDataTransportTask tPPlayDataTransportTask : this.mTaskQueue) {
            if (tPPlayDataTransportTask != null && tPPlayDataTransportTask.isMainTask()) {
                return tPPlayDataTransportTask;
            }
        }
        return TPPlayDataTransportTask.buildDummyTask(this.mDataTransport);
    }

    private void setPlayerEvent(int i3) {
        TPOptionalParam<String> buildString = TPOptionalParam.buildString(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_PLAYER_EVENT, String.valueOf(i3));
        this.mOptionalParams.put(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_PLAYER_EVENT, buildString);
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            it.next().addOptionalParam(buildString);
        }
    }

    private void setPlayerState(int i3) {
        TPOptionalParam<String> buildString = TPOptionalParam.buildString(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_PLAYER_STATE, String.valueOf(i3));
        this.mOptionalParams.put(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_PLAYER_STATE, buildString);
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            it.next().addOptionalParam(buildString);
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) {
        if (TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_USE_PROXY_AUTHENTICATION.equals(tPOptionalParam.getKey())) {
            this.mIsUseProxyAuthentication = ((Boolean) tPOptionalParam.getValue()).booleanValue();
            return;
        }
        this.mOptionalParams.put(tPOptionalParam.getKey(), tPOptionalParam);
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            it.next().addOptionalParam(tPOptionalParam);
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public long getAvailablePositionMs() {
        return mainTask().availablePositionMs();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public float getDownloadPercentage() {
        return mainTask().downloadedPercentage();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public TPError getError() {
        for (TPPlayDataTransportTask tPPlayDataTransportTask : this.mTaskQueue) {
            String errorCode = tPPlayDataTransportTask.getErrorCode();
            if (tPPlayDataTransportTask.isUseDataTransport() && tPPlayDataTransportTask.getType() != 1 && !TextUtils.isEmpty(errorCode)) {
                return new TPError(6000, Integer.parseInt(errorCode));
            }
        }
        return null;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public boolean isUseDataTransportForCurrentPlayTask() {
        return mainTask().isUseDataTransport();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onBufferingEnd() {
        setPlayerEvent(3);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onBufferingStart() {
        setPlayerEvent(2);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onPlayerStateChanged(int i3) {
        if (i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                if (i3 != 5 && i3 != 8) {
                    if (i3 == 9) {
                        setPlayerState(1);
                        return;
                    }
                    return;
                }
                setPlayerState(2);
                return;
            }
            setPlayerState(0);
            return;
        }
        setPlayerState(3);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSeek() {
        setPlayerEvent(0);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSeekComplete() {
        setPlayerEvent(1);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSwitchDataSourceComplete(int i3) {
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            TPPlayDataTransportTask next = it.next();
            if (next.isPendingTask() && next.getTaskId() < i3) {
                next.stop();
                it.remove();
            }
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void pause() {
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void release() {
        stop();
        this.mListener = null;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void resume() {
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            it.next().resume();
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void setPlayDataTransportListener(ITPPlayDataTransportListener iTPPlayDataTransportListener) {
        this.mListener = iTPPlayDataTransportListener;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void setPlaySpeedRatio(float f16) {
        TPOptionalParam<String> buildString = TPOptionalParam.buildString("taskinfo_speed_ratio", String.valueOf(f16));
        this.mOptionalParams.put("taskinfo_speed_ratio", buildString);
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            it.next().addOptionalParam(buildString);
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset start(@NonNull ITPMediaAsset iTPMediaAsset) {
        TPPlayDataTransportTask buildTask = TPPlayDataTransportTask.buildTask(0, iTPMediaAsset, this.mDataTransport, this.mTaskListener, this.mIsUseProxyAuthentication, getTag());
        if (!buildTask.start()) {
            TPLogUtil.e(getTag(), "start play data transport task failed , " + buildTask);
            return null;
        }
        buildTask.setIsMainTask(true);
        TPLogUtil.i(getTag(), "start play data task, " + buildTask);
        buildTask.addOptionalParams(this.mOptionalParams.values());
        addTaskToQueue(buildTask);
        return buildTask.decoratedMediaAsset();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset startAudioTrack(@NonNull ITPMediaAsset iTPMediaAsset) {
        TPPlayDataTransportTask buildTask = TPPlayDataTransportTask.buildTask(2, iTPMediaAsset, this.mDataTransport, this.mTaskListener, this.mIsUseProxyAuthentication, getTag());
        if (!buildTask.start()) {
            TPLogUtil.e(getTag(), "start audio track play data transport task failed : \n" + buildTask);
            return null;
        }
        buildTask.addOptionalParams(this.mOptionalParams.values());
        TPLogUtil.i(getTag(), "start audio play data task, " + buildTask);
        addTaskToQueue(buildTask);
        return buildTask.decoratedMediaAsset();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer
    @Nullable
    public ITPMediaAsset startRemuxing(@NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPMediaAsset iTPMediaAsset2) {
        TPPlayDataTransportTask buildTask = TPPlayDataTransportTask.buildTask(0, iTPMediaAsset, this.mDataTransport, this.mTaskListener, this.mIsUseProxyAuthentication, getTag());
        if (!buildTask.startWithExternalAudioRemuxing(iTPMediaAsset2)) {
            return null;
        }
        buildTask.setIsMainTask(true);
        TPLogUtil.i(getTag(), "start play remuxing task, " + buildTask);
        buildTask.addOptionalParams(this.mOptionalParams.values());
        addTaskToQueue(buildTask);
        return buildTask.decoratedMediaAsset();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset startSubtitleTrack(@NonNull ITPMediaAsset iTPMediaAsset) {
        TPPlayDataTransportTask buildTask = TPPlayDataTransportTask.buildTask(1, iTPMediaAsset, this.mDataTransport, this.mTaskListener, this.mIsUseProxyAuthentication, getTag());
        if (!buildTask.start()) {
            TPLogUtil.e(getTag(), "start subtitle track play data transport task failed : \n" + buildTask);
            return null;
        }
        TPLogUtil.i(getTag(), "start subtitle play data task, " + buildTask);
        buildTask.addOptionalParams(this.mOptionalParams.values());
        addTaskToQueue(buildTask);
        return buildTask.decoratedMediaAsset();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void stop() {
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.mTaskQueue.clear();
        this.mOptionalParams.clear();
        this.mIsUseProxyAuthentication = false;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer
    public void stopRemuxing() {
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            TPPlayDataTransportTask next = it.next();
            if (next.isRemuxing()) {
                next.stop();
                it.remove();
            }
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPPlayDataTransport.SwitchTaskInfo switchDataSource(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) {
        if (i3 == 4) {
            mainTask().setIsSwitchingDataSourceByteAlignWhenNextRequest(true);
            mainTask().setSwitchDataSourceOpaque(j3);
            for (TPPlayDataTransportTask tPPlayDataTransportTask : this.mTaskQueue) {
                if (tPPlayDataTransportTask.getType() == 0) {
                    tPPlayDataTransportTask.updateMediaAsset(iTPMediaAsset);
                }
            }
            return new ITPPlayDataTransport.SwitchTaskInfo(mainTask().getTaskId(), mainTask().decoratedMediaAsset(), false, i3);
        }
        TPPlayDataTransportTask buildTask = TPPlayDataTransportTask.buildTask(0, iTPMediaAsset, this.mDataTransport, this.mTaskListener, this.mIsUseProxyAuthentication, getTag());
        if (!buildTask.start()) {
            TPLogUtil.e(getTag(), "start switch play data transport task failed, " + buildTask);
            return null;
        }
        for (TPPlayDataTransportTask tPPlayDataTransportTask2 : this.mTaskQueue) {
            if (tPPlayDataTransportTask2.getType() == 0) {
                tPPlayDataTransportTask2.setIsPendingTask(true);
            }
        }
        buildTask.addOptionalParams(this.mOptionalParams.values());
        buildTask.setIsMainTask(true);
        addTaskToQueue(buildTask);
        TPLogUtil.i(getTag(), "start switch data task, " + buildTask);
        return new ITPPlayDataTransport.SwitchTaskInfo(buildTask.getTaskId(), buildTask.decoratedMediaAsset(), true, i3);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void updateDataSource(@NonNull ITPMediaAsset iTPMediaAsset) {
        mainTask().updateMediaAsset(iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public TPError getError(@Nullable String str) {
        TPPlayDataTransportTask tPPlayDataTransportTask;
        Iterator<TPPlayDataTransportTask> it = this.mTaskQueue.iterator();
        while (true) {
            if (!it.hasNext()) {
                tPPlayDataTransportTask = null;
                break;
            }
            tPPlayDataTransportTask = it.next();
            if (tPPlayDataTransportTask.isUseDataTransport() && ((!TextUtils.isEmpty(str) && Objects.equals(tPPlayDataTransportTask.decoratedMediaAssetOpaque(), str)) || (TextUtils.isEmpty(str) && !TextUtils.isEmpty(tPPlayDataTransportTask.getErrorCode()) && tPPlayDataTransportTask.getType() != 1))) {
                break;
            }
        }
        if (tPPlayDataTransportTask == null) {
            TPLogUtil.i(getTag(), "find error with asset opaque: " + str + ", no error task found");
            return null;
        }
        String errorCode = tPPlayDataTransportTask.getErrorCode();
        if (TextUtils.isEmpty(errorCode)) {
            TPLogUtil.i(getTag(), "find error with asset opaque: " + str + ", original asset opaque :" + tPPlayDataTransportTask.originalMediaAssetOpaque() + ", transport id : " + tPPlayDataTransportTask.getTransportId() + ", but no error");
            return null;
        }
        try {
            int parseInt = Integer.parseInt(errorCode);
            TPError tPError = new TPError(6000, parseInt);
            tPError.addExtraParam(TPError.TP_ERRPR_EXTRA_PARAM_STRING_ASSET_OPAQUE, tPPlayDataTransportTask.originalMediaAssetOpaque());
            TPLogUtil.i(getTag(), "find error with asset opaque: " + str + ", original asset opaque :" + tPPlayDataTransportTask.originalMediaAssetOpaque() + ", transport id : " + tPPlayDataTransportTask.getTransportId() + ", error code: " + parseInt);
            return tPError;
        } catch (NumberFormatException unused) {
            TPLogUtil.w(getTag(), "find error with asset opaque: " + str + ", original asset opaque :" + tPPlayDataTransportTask.originalMediaAssetOpaque() + ", transport id : " + tPPlayDataTransportTask.getTransportId() + ", but error code illegal");
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void reset() {
    }
}
