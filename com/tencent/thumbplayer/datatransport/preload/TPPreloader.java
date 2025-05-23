package com.tencent.thumbplayer.datatransport.preload;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.preload.ITPPreloader;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportCapability;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportTaskParamBuilder;
import java.util.ArrayList;

/* loaded from: classes26.dex */
public class TPPreloader implements ITPPreloader {

    @NonNull
    private final ITPDataTransportPreloadTaskMgr mDataTransportPreloader;
    private final ITPDataTransportPreloadTaskMgr.PreloadTaskListener mDataTransportPreloaderListener = new ITPDataTransportPreloadTaskMgr.PreloadTaskListener() { // from class: com.tencent.thumbplayer.datatransport.preload.TPPreloader.1
        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr.PreloadTaskListener
        public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
            if (TPPreloader.this.mListener != null) {
                TPDownloadProgressInfo tPDownloadProgressInfo = new TPDownloadProgressInfo();
                tPDownloadProgressInfo.setAvailablePositionMs(i16);
                tPDownloadProgressInfo.setDownloadSpeedbps(i17 * 1024 * 8);
                tPDownloadProgressInfo.setDownloadBytes(j3);
                tPDownloadProgressInfo.setFileTotalBytes(j16);
                tPDownloadProgressInfo.setExtraInfo(str);
                TPPreloader.this.mListener.onPreloadProgressUpdate(i3, tPDownloadProgressInfo);
            }
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr.PreloadTaskListener
        public void onPrepareError(int i3, int i16, int i17, String str) {
            if (TPPreloader.this.mListener != null) {
                TPPreloader.this.mListener.onPreloadError(i3, new TPError(6000, i17));
            }
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr.PreloadTaskListener
        public void onPrepareFinished(int i3) {
            if (TPPreloader.this.mListener != null) {
                TPPreloader.this.mListener.onPreloadSuccess(i3);
            }
        }
    };
    private ITPPreloader.ITPPreloadListener mListener;

    public TPPreloader() throws UnsupportedOperationException {
        ITPDataTransportPreloadTaskMgr preloadTaskMgr = TPDataTransportMgr.getPreloadTaskMgr();
        this.mDataTransportPreloader = preloadTaskMgr;
        if (preloadTaskMgr != null) {
        } else {
            throw new UnsupportedOperationException("TPDataTransportMgr getPreloadTaskMgr failed");
        }
    }

    private int startPreloadImpl(ITPMediaAsset iTPMediaAsset) {
        ArrayList<TPDataTransportTaskParam> buildDataTransportTaskParam;
        if (!TPDataTransportCapability.isMediaAssetSupported(iTPMediaAsset) || (buildDataTransportTaskParam = TPDataTransportTaskParamBuilder.buildDataTransportTaskParam(iTPMediaAsset)) == null || buildDataTransportTaskParam.isEmpty()) {
            return -1;
        }
        if (buildDataTransportTaskParam.size() == 1) {
            int createPreloadTask = this.mDataTransportPreloader.createPreloadTask(buildDataTransportTaskParam.get(0), this.mDataTransportPreloaderListener);
            if (createPreloadTask <= 0) {
                return -1;
            }
            return createPreloadTask;
        }
        int createPreloadTask2 = this.mDataTransportPreloader.createPreloadTask(buildDataTransportTaskParam.get(0), this.mDataTransportPreloaderListener);
        if (createPreloadTask2 <= 0) {
            return -1;
        }
        return createPreloadTask2;
    }

    @Override // com.tencent.thumbplayer.api.preload.ITPPreloader
    public void setPreloadListener(@NonNull ITPPreloader.ITPPreloadListener iTPPreloadListener) {
        this.mListener = iTPPreloadListener;
    }

    @Override // com.tencent.thumbplayer.api.preload.ITPPreloader
    public int start(@NonNull ITPMediaAsset iTPMediaAsset) {
        return startPreloadImpl(iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.api.preload.ITPPreloader
    public void stop(int i3) {
        this.mDataTransportPreloader.stopPreloadTask(i3);
    }
}
