package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Process;
import com.tencent.component.utils.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* loaded from: classes7.dex */
public class KaraM4aPlayerV2 extends m {

    /* loaded from: classes7.dex */
    private class PlayThread extends BaseThread {
        final /* synthetic */ KaraM4aPlayerV2 this$0;

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.i("KaraM4aPlayerV2", getName() + " begin");
            System.currentTimeMillis();
            Process.setThreadPriority(-16);
            KaraM4aPlayerV2.d(null).getDuration();
            System.currentTimeMillis();
            throw null;
        }
    }

    static /* synthetic */ sz0.a d(KaraM4aPlayerV2 karaM4aPlayerV2) {
        throw null;
    }
}
