package com.tencent.qqlive.tvkplayer.tools.utils;

import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHandlerThread extends BaseHandlerThread {
    public static final String TAG = "TVKPlayer[TVKHandlerThread]";

    public TVKHandlerThread(String str) {
        super(str);
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        TVKLogUtil.i(TAG, "handlerThread quit:" + getName());
        return super.quit();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, java.lang.Thread
    public void start() {
        if (!isAlive()) {
            super.start();
        }
        TVKLogUtil.i(TAG, "handlerThread start:" + getName());
    }

    public TVKHandlerThread(String str, int i3) {
        super(str, i3);
        TVKLogUtil.i(TAG, "handlerThread create:" + str);
    }
}
