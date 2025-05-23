package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Process;
import com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder;

/* compiled from: P */
@Deprecated
/* loaded from: classes7.dex */
public class SabinRecorder extends AbstractKaraRecorder {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class SabinRecordThread extends AbstractKaraRecorder.RecordThread {
        final /* synthetic */ SabinRecorder this$0;

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            throw null;
        }
    }
}
