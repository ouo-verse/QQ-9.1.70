package com.tencent.component.media.gif;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class GifRenderingExecutor extends BaseScheduledThreadPoolExecutor {
    private static volatile GifRenderingExecutor instance;

    GifRenderingExecutor() {
        super(2, new ThreadPoolExecutor.DiscardPolicy());
        setMaximumPoolSize(ImageManagerEnv.g().getMaxGifRenderThreadNum());
    }

    public static GifRenderingExecutor getInstance() {
        if (instance == null) {
            synchronized (GifRenderingExecutor.class) {
                if (instance == null) {
                    instance = new GifRenderingExecutor();
                }
            }
        }
        return instance;
    }
}
