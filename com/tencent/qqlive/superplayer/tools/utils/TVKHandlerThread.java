package com.tencent.qqlive.superplayer.tools.utils;

import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKHandlerThread extends BaseHandlerThread {
    public TVKHandlerThread(String str, int i3) {
        super(str, i3);
        d.d("TVKHandlerThread", "handlerThread create:" + str);
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        d.d("TVKHandlerThread", "handlerThread quit:" + getName());
        return super.quit();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, java.lang.Thread
    public void start() {
        if (!isAlive()) {
            super.start();
        }
        d.d("TVKHandlerThread", "handlerThread start:" + getName());
    }
}
