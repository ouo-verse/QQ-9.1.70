package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Process;
import com.tencent.component.utils.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* loaded from: classes7.dex */
public class SingPcmPlayer extends m {

    /* loaded from: classes7.dex */
    private class PlayThread extends BaseThread {
        final /* synthetic */ SingPcmPlayer this$0;

        private void o() {
            throw null;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.i("SingPcmPlayer", getName() + " begin");
            Process.setThreadPriority(-16);
            LogUtil.i("SingPcmPlayer", "run: duration " + SingPcmPlayer.d(null).getDuration());
            o();
            throw null;
        }
    }

    static /* synthetic */ sz0.a d(SingPcmPlayer singPcmPlayer) {
        throw null;
    }
}
