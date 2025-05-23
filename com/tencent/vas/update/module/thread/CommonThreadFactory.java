package com.tencent.vas.update.module.thread;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CommonThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private static final String TAG = "VasUpdate_ThreadFactory";
    private final String mNamePrefix;
    private final AtomicInteger mTheadNumber = new AtomicInteger(1);
    private final ThreadGroup mGroup = new ThreadGroup(VasUpdateConstants.BUSINESS_VAS_UPDATE_SYSTEM);

    public CommonThreadFactory(String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pool-");
        sb5.append(POOL_NUMBER.getAndIncrement());
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "-" + str;
        }
        sb5.append(str2);
        sb5.append("-thread-");
        this.mNamePrefix = sb5.toString();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        BaseThread baseThread = new BaseThread(this.mGroup, runnable, this.mNamePrefix + this.mTheadNumber.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        if (baseThread.getPriority() != 1) {
            baseThread.setPriority(1);
        }
        VasUpdateWrapper.getLog().d(TAG, "new thread: " + baseThread.getName() + ", id: " + baseThread.getId() + " is created.");
        return baseThread;
    }
}
