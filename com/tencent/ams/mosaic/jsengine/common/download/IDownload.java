package com.tencent.ams.mosaic.jsengine.common.download;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface IDownload {
    boolean cancel();

    int getDownloadStatus();

    float getDownloadedProgress();

    boolean isRunning();

    boolean pause();

    boolean resume();

    boolean start();
}
