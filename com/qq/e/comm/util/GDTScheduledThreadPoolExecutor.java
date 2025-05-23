package com.qq.e.comm.util;

import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public class GDTScheduledThreadPoolExecutor extends BaseScheduledThreadPoolExecutor {
    public GDTScheduledThreadPoolExecutor(int i3, int i16, ThreadFactory threadFactory) {
        super(i3, threadFactory);
        setMaximumPoolSize(i16);
    }
}
