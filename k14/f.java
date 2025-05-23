package k14;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f extends i14.b {

    /* renamed from: b, reason: collision with root package name */
    private final List<g> f411419b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.rmonitor.common.lifecycle.b f411420c;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends com.tencent.rmonitor.common.lifecycle.f {
        a() {
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onCreate(@NonNull Activity activity) {
            for (g gVar : f.this.f411419b) {
                if (gVar.b(activity)) {
                    gVar.c(activity);
                }
            }
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onDestroy(@NotNull Activity activity) {
            Iterator it = f.this.f411419b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(activity);
            }
        }
    }

    public f(MemoryLeakInspector memoryLeakInspector) {
        this(memoryLeakInspector, f(memoryLeakInspector));
    }

    protected static g e(String str, MemoryLeakInspector memoryLeakInspector) {
        g eVar;
        try {
            if ("AndroidOFragmentWatcher".equals(str)) {
                eVar = new c(memoryLeakInspector);
            } else if ("AndroidV4FragmentWatcher".equals(str)) {
                eVar = new d(memoryLeakInspector);
            } else {
                if (!"AndroidXFragmentWatcher".equals(str)) {
                    return null;
                }
                eVar = new e(memoryLeakInspector);
            }
            return eVar;
        } catch (Throwable th5) {
            Logger.f365497g.i("RMonitor_memory_FragmentWatcher", th5.toString());
            return null;
        }
    }

    protected static List<g> f(MemoryLeakInspector memoryLeakInspector) {
        String[] strArr;
        if (AndroidVersion.isOverO()) {
            strArr = new String[]{"AndroidV4FragmentWatcher", "AndroidXFragmentWatcher", "AndroidOFragmentWatcher"};
        } else {
            strArr = new String[]{"AndroidV4FragmentWatcher", "AndroidXFragmentWatcher"};
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            g e16 = e(str, memoryLeakInspector);
            if (e16 != null) {
                arrayList.add(e16);
            }
        }
        return arrayList;
    }

    @Override // i14.c
    public boolean a() {
        LifecycleCallback.r(this.f411420c);
        return true;
    }

    @Override // i14.c
    public void b() {
        LifecycleCallback.s(this.f411420c);
    }

    @Override // i14.b, i14.c
    public boolean c() {
        return e14.a.e().d();
    }

    public f(MemoryLeakInspector memoryLeakInspector, List<g> list) {
        super(memoryLeakInspector);
        this.f411420c = new a();
        this.f411419b = list;
    }
}
