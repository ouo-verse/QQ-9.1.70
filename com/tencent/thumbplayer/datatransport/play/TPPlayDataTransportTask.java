package com.tencent.thumbplayer.datatransport.play;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.asset.TPDrmMediaAsset;
import com.tencent.thumbplayer.asset.TPMediaAsset;
import com.tencent.thumbplayer.asset.TPMultiMediaAsset;
import com.tencent.thumbplayer.asset.TPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import com.tencent.thumbplayer.common.TPCryptoUtil;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadSwitchProxy;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportCapability;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportMediaAssetDecorator;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportMediaAssetDecoratorNonProxy;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportTaskParamBuilder;
import com.tencent.thumbplayer.datatransport.resourceloader.TPRespondDataTransportResourceLoader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class TPPlayDataTransportTask implements ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest {
    private static final AtomicInteger BASE_TASK_ID = new AtomicInteger(0);
    private static final int INVALID_ID = -1;
    public static final int TASK_TYPE_EXTERNAL_AUDIO_TRACK = 2;
    public static final int TASK_TYPE_EXTERNAL_SUBTITLE_TRACK = 1;
    public static final int TASK_TYPE_MASTER_TRACK = 0;
    private ITPDataTransportTaskMgr mDataTransport;
    private ITPMediaAsset mDecoratedMediaAsset;
    private String mDecoratedMediaAssetOpaque;
    private boolean mIsUseProxyAuthentication;
    private ITPMediaAsset mMediaAsset;
    private String mOriginalMediaAssetOpaque;
    private ITPDataTransportTaskMgr.TaskListener mTaskListener;
    private int mType = 0;
    private boolean mIsMainTask = false;
    private boolean mIsPendingTask = false;
    private boolean mIsRemuxing = false;
    private final int mTaskId = BASE_TASK_ID.incrementAndGet();
    private int mTransportId = -1;
    private boolean mIsUseDataTransport = true;
    private boolean mIsSwitchingDataSourceByteAlignWhenNextRequest = false;
    private long mSwitchDataSourceOpaque = -1;
    private TPDownloadProgressInfo mProgressInfo = new TPDownloadProgressInfo();
    private String mTag = "TPPlayDataTransportTask";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface Type {
    }

    TPPlayDataTransportTask() {
    }

    @Nullable
    private static String assetOpaque(ITPMediaAsset iTPMediaAsset) {
        if (!(iTPMediaAsset instanceof TPMediaAsset)) {
            return null;
        }
        return ((TPMediaAsset) iTPMediaAsset).getParam(ITPMediaAsset.TP_ASSET_PARAM_KEY_STRING_OPAQUE, null);
    }

    public static TPPlayDataTransportTask buildDummyTask(@NonNull ITPDataTransportTaskMgr iTPDataTransportTaskMgr) {
        TPPlayDataTransportTask tPPlayDataTransportTask = new TPPlayDataTransportTask();
        tPPlayDataTransportTask.mDataTransport = iTPDataTransportTaskMgr;
        tPPlayDataTransportTask.mTag = "TPPlayDataTransportTask_DummyTask";
        TPLogUtil.i("TPPlayDataTransportTask_DummyTask", "create, dummy task");
        return tPPlayDataTransportTask;
    }

    public static TPPlayDataTransportTask buildTask(int i3, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPDataTransportTaskMgr iTPDataTransportTaskMgr, @NonNull ITPDataTransportTaskMgr.TaskListener taskListener, boolean z16, @NonNull String str) {
        TPPlayDataTransportTask tPPlayDataTransportTask = new TPPlayDataTransportTask();
        tPPlayDataTransportTask.mTag = str;
        tPPlayDataTransportTask.mType = i3;
        tPPlayDataTransportTask.mMediaAsset = iTPMediaAsset;
        tPPlayDataTransportTask.mOriginalMediaAssetOpaque = assetOpaque(iTPMediaAsset);
        tPPlayDataTransportTask.mDataTransport = TPDataTransportMgr.getTaskMgr();
        tPPlayDataTransportTask.mTaskListener = taskListener;
        tPPlayDataTransportTask.mIsUseProxyAuthentication = z16;
        TPLogUtil.i(tPPlayDataTransportTask.mTag, "create, task, " + tPPlayDataTransportTask.toString());
        return tPPlayDataTransportTask;
    }

    @Nullable
    private boolean startAudioRemuxTask(ITPMediaAsset iTPMediaAsset, ITPMediaAsset iTPMediaAsset2) {
        String str;
        if (this.mIsUseProxyAuthentication) {
            str = TPCryptoUtil.generateHttpVerificationCode();
            iTPMediaAsset.setParam("dl_param_authentication_token_key", str);
        } else {
            str = "";
        }
        ArrayList<TPDataTransportTaskParam> buildDataTransportRemuxTaskParam = TPDataTransportTaskParamBuilder.buildDataTransportRemuxTaskParam(iTPMediaAsset, iTPMediaAsset2);
        if (buildDataTransportRemuxTaskParam != null && !buildDataTransportRemuxTaskParam.isEmpty()) {
            int createMultiTask = this.mDataTransport.createMultiTask(buildDataTransportRemuxTaskParam, this.mTaskListener);
            if (createMultiTask <= 0) {
                TPLogUtil.w(this.mTag, "create multi_url task failed, coz transport id invalid,");
                return false;
            }
            TPLogUtil.i(this.mTag, "start remux task: " + createMultiTask);
            tryConnectResourceLoader(createMultiTask, iTPMediaAsset);
            tryConnectResourceLoader(createMultiTask, iTPMediaAsset2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mDataTransport.getProxyUrl(createMultiTask, 0));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.mDataTransport.getProxyUrl(createMultiTask, 1));
            ITPMediaAsset decorateMediaAsset = TPDataTransportMediaAssetDecorator.decorateMediaAsset(iTPMediaAsset2, arrayList, arrayList2, String.valueOf(this.mTaskId), str);
            if (decorateMediaAsset == null) {
                TPLogUtil.w(this.mTag, "create url task failed, coz decorate url task failed");
                return false;
            }
            this.mTransportId = createMultiTask;
            this.mDecoratedMediaAsset = decorateMediaAsset;
            this.mDecoratedMediaAssetOpaque = assetOpaque(decorateMediaAsset);
            this.mIsRemuxing = true;
            return true;
        }
        TPLogUtil.w(this.mTag, "create remux task failed, coz params is nil or empty");
        return false;
    }

    private boolean startMultiMediaAssetTask(TPMultiMediaAsset tPMultiMediaAsset) {
        String str;
        TPLogUtil.i(this.mTag, "startMultiMediaAssetTask");
        if (this.mIsUseProxyAuthentication) {
            str = TPCryptoUtil.generateHttpVerificationCode();
            tPMultiMediaAsset.setParam("dl_param_authentication_token_key", str);
        } else {
            str = "";
        }
        ArrayList<TPDataTransportTaskParam> buildDataTransportTaskParam = TPDataTransportTaskParamBuilder.buildDataTransportTaskParam(tPMultiMediaAsset);
        if (buildDataTransportTaskParam != null && !buildDataTransportTaskParam.isEmpty()) {
            int createMultiTask = this.mDataTransport.createMultiTask(buildDataTransportTaskParam, this.mTaskListener);
            if (createMultiTask <= 0) {
                TPLogUtil.w(this.mTag, "create multi_url task failed, coz transport id invalid, change to non proxy task");
                return startNonProxyAssetTask(tPMultiMediaAsset);
            }
            Iterator<Pair<ITPMediaAsset, Long>> it = tPMultiMediaAsset.getAssetAndClipDurationMsPairList().iterator();
            while (it.hasNext()) {
                tryConnectResourceLoader(createMultiTask, it.next().first);
            }
            ITPMediaAsset decorateMediaAsset = TPDataTransportMediaAssetDecorator.decorateMediaAsset(tPMultiMediaAsset, this.mDataTransport.getMultiProxyUrlList(createMultiTask, 0), this.mDataTransport.getMultiProxyUrlList(createMultiTask, 1), String.valueOf(this.mTaskId), str);
            if (decorateMediaAsset == null) {
                this.mDataTransport.stopTask(createMultiTask);
                TPLogUtil.w(this.mTag, "create multi_url task failed, coz decorate media asset failed, change to non proxy task");
                return startNonProxyAssetTask(tPMultiMediaAsset);
            }
            this.mTransportId = createMultiTask;
            this.mDecoratedMediaAsset = decorateMediaAsset;
            this.mDecoratedMediaAssetOpaque = assetOpaque(decorateMediaAsset);
            return true;
        }
        TPLogUtil.w(this.mTag, "create multi_url task failed, coz params is nil or empty, change to non proxy task");
        return startNonProxyAssetTask(tPMultiMediaAsset);
    }

    private boolean startNonProxyAssetTask(ITPMediaAsset iTPMediaAsset) {
        ITPMediaAsset decorateMediaAsset = TPDataTransportMediaAssetDecoratorNonProxy.decorateMediaAsset(iTPMediaAsset);
        if (decorateMediaAsset == null) {
            TPLogUtil.w(this.mTag, "create non proxy task failed, coz decorate media asset failed");
            return false;
        }
        this.mTransportId = -1;
        this.mDecoratedMediaAsset = decorateMediaAsset;
        this.mDecoratedMediaAssetOpaque = assetOpaque(decorateMediaAsset);
        this.mIsUseDataTransport = false;
        return true;
    }

    private boolean startSimulatedLiveMediaAssetTask(TPSimulatedLiveMediaAsset tPSimulatedLiveMediaAsset) {
        tPSimulatedLiveMediaAsset.getStartAsset().setParam("task_file_type", String.valueOf(4));
        if (!startUrlMediaAssetTask((TPUrlMediaAsset) tPSimulatedLiveMediaAsset.getStartAsset())) {
            return false;
        }
        tPSimulatedLiveMediaAsset.setStartAsset(this.mDecoratedMediaAsset);
        this.mDecoratedMediaAsset = tPSimulatedLiveMediaAsset;
        this.mDecoratedMediaAssetOpaque = assetOpaque(tPSimulatedLiveMediaAsset);
        return true;
    }

    private boolean startUrlMediaAssetTask(TPUrlMediaAsset tPUrlMediaAsset) {
        String str;
        if (this.mIsUseProxyAuthentication) {
            str = TPCryptoUtil.generateHttpVerificationCode();
            tPUrlMediaAsset.setParam("dl_param_authentication_token_key", str);
        } else {
            str = "";
        }
        ArrayList<TPDataTransportTaskParam> buildDataTransportTaskParam = TPDataTransportTaskParamBuilder.buildDataTransportTaskParam(tPUrlMediaAsset);
        if (buildDataTransportTaskParam != null && !buildDataTransportTaskParam.isEmpty()) {
            int createTask = this.mDataTransport.createTask(buildDataTransportTaskParam.get(0), this.mTaskListener);
            if (createTask <= 0) {
                TPLogUtil.w(this.mTag, "create url task failed, coz transportId invalid, change to non proxy task");
                return startNonProxyAssetTask(tPUrlMediaAsset);
            }
            tryConnectResourceLoader(createTask, tPUrlMediaAsset);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mDataTransport.getProxyUrl(createTask, 0));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.mDataTransport.getProxyUrl(createTask, 1));
            ITPMediaAsset decorateMediaAsset = TPDataTransportMediaAssetDecorator.decorateMediaAsset(tPUrlMediaAsset, arrayList, arrayList2, String.valueOf(this.mTaskId), str);
            if (decorateMediaAsset == null) {
                TPLogUtil.w(this.mTag, "create url task failed, coz decorate url task failed, change to non proxy task");
                this.mDataTransport.stopTask(createTask);
                return startNonProxyAssetTask(tPUrlMediaAsset);
            }
            this.mTransportId = createTask;
            this.mDecoratedMediaAsset = decorateMediaAsset;
            this.mDecoratedMediaAssetOpaque = assetOpaque(decorateMediaAsset);
            return true;
        }
        TPLogUtil.w(this.mTag, "create url task failed, coz params is nil or empty, change to non proxy task");
        return startNonProxyAssetTask(tPUrlMediaAsset);
    }

    private String taskTypeString() {
        int i3 = this.mType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return "unknown_task";
                }
                return "audio_task";
            }
            return "subtitle_task";
        }
        return "av_task";
    }

    private void tryConnectResourceLoader(int i3, ITPMediaAsset iTPMediaAsset) {
        if (iTPMediaAsset instanceof TPMediaAsset) {
            TPMediaAsset tPMediaAsset = (TPMediaAsset) iTPMediaAsset;
            if (tPMediaAsset.getResourceLoader() != null) {
                this.mDataTransport.setTaskResourceLoaderListener(i3, new TPRespondDataTransportResourceLoader(tPMediaAsset.getResourceLoader()));
            }
        }
    }

    public void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) {
        String str;
        if (!TPOptionalID.OPTIONAL_ID_GLOBAL_BOOL_ENABLE_ADAPTIVE_SWITCH_DEF.equals(tPOptionalParam.getKey()) && !TPOptionalID.OPTIONAL_ID_GLOBAL_BOOL_ENABLE_SUGGESTED_BITRATE_CALLBACK.equals(tPOptionalParam.getKey())) {
            String key = tPOptionalParam.getKey();
            String valueOf = String.valueOf(tPOptionalParam.getValue());
            TPLogUtil.i(this.mTag, "addOptionalParam, task : task_id = " + this.mTaskId + ", transport_id = " + this.mTransportId + ", optional param key = " + key + ", optional param value = " + valueOf);
            this.mDataTransport.setTaskOptionalConfigParam(this.mTransportId, key, valueOf);
            return;
        }
        if (((Boolean) tPOptionalParam.getValue()).booleanValue()) {
            str = "1";
        } else {
            str = "0";
        }
        this.mDataTransport.setTaskOptionalConfigParam(this.mTransportId, TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_DYNAMIC_SWITCH, str);
    }

    public void addOptionalParams(@NonNull Collection<TPOptionalParam<?>> collection) {
        Iterator<TPOptionalParam<?>> it = collection.iterator();
        while (it.hasNext()) {
            addOptionalParam(it.next());
        }
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public void appendMediaAsset(ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException {
        if (iTPMediaAsset instanceof TPUrlMediaAsset) {
            iTPMediaAsset.setParam("dl_param_play_clip_no", "2");
            iTPMediaAsset.setParam("task_file_type", String.valueOf(4));
            updateMediaAsset(iTPMediaAsset);
            return;
        }
        throw new IllegalArgumentException("append media asset type error");
    }

    public long availablePositionMs() {
        return this.mProgressInfo.getAvailablePositionMs();
    }

    public ITPMediaAsset decoratedMediaAsset() {
        return this.mDecoratedMediaAsset;
    }

    @Nullable
    public String decoratedMediaAssetOpaque() {
        return this.mDecoratedMediaAssetOpaque;
    }

    public float downloadedPercentage() {
        if (this.mProgressInfo.getFileTotalBytes() == 0) {
            return 0.0f;
        }
        return (((float) this.mProgressInfo.getDownloadBytes()) * 1.0f) / ((float) this.mProgressInfo.getFileTotalBytes());
    }

    public String getErrorCode() {
        return this.mDataTransport.getTaskErrorCode(this.mTransportId);
    }

    public long getSwitchDataSourceOpaque() {
        return this.mSwitchDataSourceOpaque;
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public int getTransportId() {
        return this.mTransportId;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isMainTask() {
        return this.mIsMainTask;
    }

    public boolean isPendingTask() {
        return this.mIsPendingTask;
    }

    public boolean isRemuxing() {
        return this.mIsRemuxing;
    }

    public boolean isSwitchingDataSourceByteAlignWhenNextRequest() {
        return this.mIsSwitchingDataSourceByteAlignWhenNextRequest;
    }

    public boolean isUseDataTransport() {
        return this.mIsUseDataTransport;
    }

    public ITPMediaAsset mediaAsset() {
        return this.mMediaAsset;
    }

    @Nullable
    public String originalMediaAssetOpaque() {
        return this.mOriginalMediaAssetOpaque;
    }

    public void pause() {
        TPLogUtil.i(this.mTag, "pause, task : id = " + this.mTaskId + ", transport_id = " + this.mTransportId);
        this.mDataTransport.pauseTask(this.mTransportId);
    }

    public void resume() {
        TPLogUtil.i(this.mTag, "resume, task : id = " + this.mTaskId + ", transport_id = " + this.mTransportId);
        this.mDataTransport.resumeTask(this.mTransportId);
    }

    public void setIsMainTask(boolean z16) {
        if (this.mType != 0) {
            return;
        }
        this.mIsMainTask = z16;
    }

    public void setIsPendingTask(boolean z16) {
        this.mIsPendingTask = z16;
    }

    public void setIsSwitchingDataSourceByteAlignWhenNextRequest(boolean z16) {
        this.mIsSwitchingDataSourceByteAlignWhenNextRequest = z16;
    }

    public void setSwitchDataSourceOpaque(long j3) {
        this.mSwitchDataSourceOpaque = j3;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public boolean start() {
        ITPMediaAsset iTPMediaAsset = this.mMediaAsset;
        if (iTPMediaAsset != null && iTPMediaAsset.isValid()) {
            if (!TPDataTransportCapability.isMediaAssetSupported(this.mMediaAsset)) {
                return startNonProxyAssetTask(this.mMediaAsset);
            }
            ITPMediaAsset iTPMediaAsset2 = this.mMediaAsset;
            if (iTPMediaAsset2 instanceof TPSimulatedLiveMediaAsset) {
                return startSimulatedLiveMediaAssetTask((TPSimulatedLiveMediaAsset) iTPMediaAsset2);
            }
            if (iTPMediaAsset2 instanceof TPDrmMediaAsset) {
                return startUrlMediaAssetTask((TPDrmMediaAsset) iTPMediaAsset2);
            }
            if (iTPMediaAsset2 instanceof TPUrlMediaAsset) {
                return startUrlMediaAssetTask((TPUrlMediaAsset) iTPMediaAsset2);
            }
            if (iTPMediaAsset2 instanceof TPMultiMediaAsset) {
                return startMultiMediaAssetTask((TPMultiMediaAsset) iTPMediaAsset2);
            }
            return startNonProxyAssetTask(iTPMediaAsset2);
        }
        TPLogUtil.e(this.mTag, "start task failed, coz mediaAsset is nil or invalid");
        return false;
    }

    public boolean startWithExternalAudioRemuxing(ITPMediaAsset iTPMediaAsset) {
        if (this.mType != 0) {
            return false;
        }
        return startAudioRemuxTask(this.mMediaAsset, iTPMediaAsset);
    }

    public void stop() {
        TPLogUtil.i(this.mTag, "stop, task : id = " + this.mTaskId + ", transport_id = " + this.mTransportId);
        this.mDataTransport.stopTask(this.mTransportId);
    }

    public String toString() {
        if (this.mTransportId == -1 && this.mMediaAsset == null) {
            return "Task{ dummy_task }";
        }
        return "Task :\n{taskType=" + taskTypeString() + ", taskId=" + this.mTaskId + ", isUseDataTransport=" + this.mIsUseDataTransport + ", transportId=" + this.mTransportId + ", isMainTask=" + this.mIsMainTask + ", isPendingTask =" + this.mIsPendingTask + ", isUseProxyAuthentication=" + this.mIsUseProxyAuthentication + ", originalMediaAssetOpaque=" + this.mOriginalMediaAssetOpaque + ", decoratedMediaAssetOpaque=" + this.mDecoratedMediaAssetOpaque + ", mediaAsset=" + this.mDecoratedMediaAsset + " }";
    }

    public void updateMediaAsset(@NonNull ITPMediaAsset iTPMediaAsset) {
        ArrayList<TPDataTransportTaskParam> buildDataTransportTaskParam = TPDataTransportTaskParamBuilder.buildDataTransportTaskParam(iTPMediaAsset);
        if (buildDataTransportTaskParam != null && !buildDataTransportTaskParam.isEmpty()) {
            TPLogUtil.i(this.mTag, "updateMediaAsset, task : task_id = " + this.mTaskId + ", transport_id = " + this.mTransportId + ", asset = " + iTPMediaAsset);
            this.mMediaAsset = iTPMediaAsset;
            this.mDataTransport.updateRunningTaskParam(this.mTransportId, buildDataTransportTaskParam);
            return;
        }
        TPLogUtil.w(this.mTag, "updateMediaAsset, task : task_id = " + this.mTaskId + ", transport_id = " + this.mTransportId + ", failed, params is empty");
    }

    public void updateProgressInfo(TPDownloadProgressInfo tPDownloadProgressInfo) {
        this.mProgressInfo = tPDownloadProgressInfo;
    }
}
