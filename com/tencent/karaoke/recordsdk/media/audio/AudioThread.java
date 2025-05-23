package com.tencent.karaoke.recordsdk.media.audio;

import com.tencent.component.utils.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class AudioThread extends BaseThread {
    protected abstract boolean o();

    protected int p() {
        int q16 = q();
        if (q16 >= 0) {
            q16 = t();
        }
        if (q16 >= 0) {
            q16 = s();
        }
        if (o()) {
            return 1000;
        }
        return q16;
    }

    protected abstract int q();

    protected abstract int r();

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        LogUtil.i("AudioThread", getName() + " begin");
        r();
        do {
        } while (p() != 1000);
        u();
        LogUtil.i("AudioThread", getName() + " end.");
    }

    protected abstract int s();

    protected abstract int t();

    protected abstract int u();
}
