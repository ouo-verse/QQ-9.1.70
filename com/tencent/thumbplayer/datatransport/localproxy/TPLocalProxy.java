package com.tencent.thumbplayer.datatransport.localproxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMultiMediaAsset;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.localproxy.ITPLocalProxy;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportCapability;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportTaskParamBuilder;
import java.util.ArrayList;

/* loaded from: classes26.dex */
public class TPLocalProxy implements ITPLocalProxy {
    private static final int INVALID_TASK_ID = -1;

    @NonNull
    private final ITPDataTransportTaskMgr mDataTransportTaskMgr;
    private int mTaskId = -1;

    public TPLocalProxy() throws UnsupportedOperationException {
        ITPDataTransportTaskMgr taskMgr = TPDataTransportMgr.getTaskMgr();
        this.mDataTransportTaskMgr = taskMgr;
        if (taskMgr != null) {
        } else {
            throw new UnsupportedOperationException("TPDataTransportMgr getTaskMgr failed");
        }
    }

    @Override // com.tencent.thumbplayer.api.localproxy.ITPLocalProxy
    public String buildProxyUrl(@NonNull ITPMediaAsset iTPMediaAsset, @Nullable ITPLocalProxy.LocalProxyListener localProxyListener) throws IllegalStateException, IllegalArgumentException {
        if (this.mTaskId == -1) {
            if (!(iTPMediaAsset instanceof ITPMultiMediaAsset)) {
                if (TPDataTransportCapability.isMediaAssetSupported(iTPMediaAsset)) {
                    ArrayList<TPDataTransportTaskParam> buildDataTransportTaskParam = TPDataTransportTaskParamBuilder.buildDataTransportTaskParam(iTPMediaAsset);
                    if (buildDataTransportTaskParam != null && !buildDataTransportTaskParam.isEmpty()) {
                        int createTask = this.mDataTransportTaskMgr.createTask(buildDataTransportTaskParam.get(0), new InnerTaskListener(localProxyListener));
                        this.mTaskId = createTask;
                        if (createTask >= 0) {
                            return this.mDataTransportTaskMgr.getProxyUrl(createTask, 1);
                        }
                        throw new IllegalArgumentException("create task failed, local proxy url couldn't be obtained. current mediaAsset is=" + iTPMediaAsset);
                    }
                    throw new IllegalArgumentException("mediaAsset is invalid, buildDataTransportTaskParam return null, current mediaAsset=" + iTPMediaAsset);
                }
                throw new IllegalArgumentException("not support current mediaAsset:" + iTPMediaAsset);
            }
            throw new IllegalArgumentException("not support ITPMultiMediaAsset");
        }
        throw new IllegalStateException("not allow to buildProxyUrl more than once");
    }

    @Override // com.tencent.thumbplayer.api.localproxy.ITPLocalProxy
    public void release() {
        this.mDataTransportTaskMgr.stopTask(this.mTaskId);
        this.mTaskId = -1;
    }

    /* loaded from: classes26.dex */
    private static class InnerTaskListener implements ITPDataTransportTaskMgr.TaskListener {
        private final ITPLocalProxy.LocalProxyListener mLocalProxyListener;

        public InnerTaskListener(ITPLocalProxy.LocalProxyListener localProxyListener) {
            this.mLocalProxyListener = localProxyListener;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        public long getCurrentPlayOffset(int i3) {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        public long getCurrentPosition(int i3) {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        public long getPlayerBufferLength(int i3) {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        public long getRemainTimeBeforePlayMs(int i3) {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        public void onDownloadError(int i3, int i16, int i17, String str) {
            if (this.mLocalProxyListener == null) {
                return;
            }
            this.mLocalProxyListener.onDownloadError(new TPError(6000, i17));
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        public void onDownloadFinished(int i3) {
            ITPLocalProxy.LocalProxyListener localProxyListener = this.mLocalProxyListener;
            if (localProxyListener == null) {
                return;
            }
            localProxyListener.onDownloadSuccess();
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
            if (this.mLocalProxyListener == null) {
                return;
            }
            TPDownloadProgressInfo tPDownloadProgressInfo = new TPDownloadProgressInfo();
            tPDownloadProgressInfo.setAvailablePositionMs(i16);
            tPDownloadProgressInfo.setDownloadSpeedbps(i17 * 1024 * 8);
            tPDownloadProgressInfo.setDownloadBytes(j3);
            tPDownloadProgressInfo.setFileTotalBytes(j16);
            tPDownloadProgressInfo.setExtraInfo(str);
            this.mLocalProxyListener.onDownloadProgressUpdate(tPDownloadProgressInfo);
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr.TaskListener
        public void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
        }
    }
}
