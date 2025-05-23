package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Process;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder;

/* compiled from: P */
/* loaded from: classes7.dex */
public class BasicKaraRecorder extends AbstractKaraRecorder {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class SimpleRecordThread extends AbstractKaraRecorder.RecordThread {
        final /* synthetic */ BasicKaraRecorder this$0;

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.i("SimpleKaraRecorder.SimpleRecordThread", getName() + " begin");
            Process.setThreadPriority(-19);
            throw null;
        }
    }
}
