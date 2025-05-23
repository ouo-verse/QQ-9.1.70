package f14;

import android.support.annotation.NonNull;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.plugin.listener.IMemoryCeilingListener;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.memory.ceil.MemoryCeilingMonitor;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f397701a = "";

    /* renamed from: b, reason: collision with root package name */
    private IMemoryCeilingListener f397702b = null;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final ArrayList<String> f397703c = new ArrayList<>(20);

    /* renamed from: d, reason: collision with root package name */
    private final a f397704d;

    public b(a aVar) {
        this.f397704d = aVar;
    }

    private boolean a(long j3) {
        if (!PluginController.f365404b.d(BuglyMonitorName.MEMORY_JAVA_CEILING)) {
            Logger.f365497g.i("RMonitor_MemoryCeiling_Trigger", "memory ceiling don't dump for event sample ratio");
            return false;
        }
        IMemoryCeilingListener b16 = i04.a.memoryCeilingListener.b();
        this.f397702b = b16;
        if (b16 != null && !b16.onLowMemory(j3)) {
            Logger.f365497g.i("RMonitor_MemoryCeiling_Trigger", "memory ceiling don't dump for user's onLowMemory call back");
            return false;
        }
        String f16 = com.tencent.rmonitor.common.lifecycle.a.f();
        this.f397701a = f16;
        if (this.f397703c.contains(f16)) {
            Logger.f365497g.i("RMonitor_MemoryCeiling_Trigger", "memory ceiling don't dump for scene that has dumped");
            return false;
        }
        return true;
    }

    public void b(long j3) {
        if (MemoryCeilingMonitor.G || a(j3)) {
            Logger.f365497g.d("RMonitor_MemoryCeiling_Trigger", "dump hprof in scene:", this.f397701a);
            this.f397703c.add(this.f397701a);
            DumpResult b16 = e14.b.b("LowMemory", "LowMemory", true, false, this.f397702b, e14.a.c().b(), e14.a.c().f365315m);
            if (b16.success) {
                this.f397704d.a(b16, "onLowMemory");
            }
        }
    }
}
