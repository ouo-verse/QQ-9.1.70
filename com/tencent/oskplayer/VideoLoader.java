package com.tencent.oskplayer;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoProxy;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface VideoLoader {
    void addHttpErrorListener(String str, VideoProxy.HttpErrorListener httpErrorListener);

    void addHttpRetryLogic(String str, HttpRetryLogic httpRetryLogic);

    void clearCacheByInfo(SegmentVideoInfo segmentVideoInfo);

    double getCachedSizeRate(String str);

    String getUrl(String str);

    void initEnv();

    void removeHttpErrorListener(String str);

    void removeHttpRetryLogic(String str);
}
