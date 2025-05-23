package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IBatchUploadManagerDelegate {
    void onGetCachedSessions(IBatchUploadManager iBatchUploadManager, ArrayList<BatchUploadSession> arrayList);

    void sessionDidFinishUpload(IBatchUploadManager iBatchUploadManager, BatchUploadSession batchUploadSession);

    void sessionStatusDidUpdate(IBatchUploadManager iBatchUploadManager, BatchUploadSession batchUploadSession, BatchUploadSessionStatus batchUploadSessionStatus);

    void taskDidCancel(IBatchUploadManager iBatchUploadManager, BatchUploadTask batchUploadTask);

    void taskDidError(IBatchUploadManager iBatchUploadManager, BatchUploadTask batchUploadTask);

    void taskDidFinishUpload(IBatchUploadManager iBatchUploadManager, BatchUploadTask batchUploadTask);

    void taskDidStartUpload(IBatchUploadManager iBatchUploadManager, BatchUploadTask batchUploadTask);

    void taskProgressDidUpdate(IBatchUploadManager iBatchUploadManager, BatchUploadTask batchUploadTask, long j3, long j16);

    void taskStatusDidUpdate(IBatchUploadManager iBatchUploadManager, BatchUploadTask batchUploadTask, BatchUploadTaskStatus batchUploadTaskStatus);
}
