package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Process;
import com.tencent.component.utils.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* loaded from: classes7.dex */
public class StreamPlayer extends m {

    /* loaded from: classes7.dex */
    private class PlayThread extends BaseThread {
        final /* synthetic */ StreamPlayer this$0;

        private void o() {
            throw null;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.i("StreamPlayer", getName() + " begin");
            Process.setThreadPriority(-16);
            LogUtil.i("StreamPlayer", "run: duration " + StreamPlayer.d(null).getDuration());
            o();
            throw null;
        }
    }

    static /* synthetic */ sz0.a d(StreamPlayer streamPlayer) {
        throw null;
    }
}
