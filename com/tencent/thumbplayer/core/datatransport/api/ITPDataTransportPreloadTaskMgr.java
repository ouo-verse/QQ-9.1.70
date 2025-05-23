package com.tencent.thumbplayer.core.datatransport.api;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;

/* loaded from: classes26.dex */
public interface ITPDataTransportPreloadTaskMgr {

    /* loaded from: classes26.dex */
    public interface PreloadTaskListener {
        void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str);

        void onPrepareError(int i3, int i16, int i17, String str);

        void onPrepareFinished(int i3);
    }

    int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, PreloadTaskListener preloadTaskListener);

    void setPreloadTaskOptionalConfigParam(int i3, String str, String str2);

    void stopPreloadTask(int i3);
}
