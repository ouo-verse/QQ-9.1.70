package com.tencent.ttpic.baseutils.thread;

import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum HandlerThreadManager {
    INSTANCE;

    private static final String PREFIX = "HTM_";
    public static int THREAD_DESTROY_TIME_OUT_MILLS = 5000;
    private Map<String, HandlerThread> map = new HashMap();

    HandlerThreadManager() {
    }

    public static HandlerThreadManager getInstance() {
        return INSTANCE;
    }

    public synchronized void destroy() {
        Iterator<HandlerThread> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().quit();
        }
        this.map.clear();
    }

    public synchronized void destroyHandlerThread(HandlerThreadTag handlerThreadTag) {
        destroyHandlerThread(handlerThreadTag.name());
    }

    public synchronized HandlerThread getHandlerThread(HandlerThreadTag handlerThreadTag) {
        return getHandlerThread(handlerThreadTag.name());
    }

    public synchronized HandlerThread getHandlerThread(String str) {
        HandlerThread handlerThread;
        handlerThread = this.map.get(str);
        if (handlerThread == null || !handlerThread.isAlive()) {
            handlerThread = new BaseHandlerThread(PREFIX + str, 10);
            handlerThread.start();
            this.map.put(str, handlerThread);
        }
        return handlerThread;
    }

    public synchronized void destroyHandlerThread(String str) {
        if (str == null) {
            return;
        }
        HandlerThread handlerThread = this.map.get(str);
        if (handlerThread == null) {
            return;
        }
        this.map.remove(str);
        if (ApiHelper.hasJellyBeanMR2()) {
            handlerThread.quitSafely();
        } else {
            handlerThread.quit();
        }
    }
}
