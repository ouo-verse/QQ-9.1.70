package j14;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.memory.leakdetect.ActivityLeakSolution;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

/* compiled from: P */
/* loaded from: classes25.dex */
abstract class c extends i14.b {
    public c(MemoryLeakInspector memoryLeakInspector) {
        super(memoryLeakInspector);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@NonNull Activity activity) {
        ActivityLeakSolution.fixInputMethodManagerLeak(activity);
        ActivityLeakSolution.fixAudioManagerLeak(activity);
        try {
            this.f407037a.m(activity, "");
        } catch (Exception e16) {
            Logger.f365497g.c("RMonitor_MemoryLeak_BaseActivityWatcher", e16);
        }
    }
}
