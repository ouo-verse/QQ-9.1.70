package com.tencent.gamecenter.wadl.util;

import com.tencent.gamecenter.wadl.sdk.downloader.IThreadPool;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class k implements IThreadPool {
    @Override // com.tencent.gamecenter.wadl.sdk.downloader.IThreadPool
    public ThreadPoolExecutor getThreadPool(String str, int i3, int i16, int i17, int i18) {
        ThreadPoolParams threadPoolParams = new ThreadPoolParams();
        threadPoolParams.poolThreadName = str;
        threadPoolParams.corePoolsize = i3;
        threadPoolParams.maxPooolSize = i16;
        threadPoolParams.keepAliveTime = i18;
        threadPoolParams.queue = new LinkedBlockingQueue(i17);
        return (ThreadPoolExecutor) ThreadManagerV2.newFreeThreadPool(threadPoolParams);
    }
}
