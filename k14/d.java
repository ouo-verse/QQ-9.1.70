package k14;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private final MemoryLeakInspector f411414a;

    /* renamed from: b, reason: collision with root package name */
    private final FragmentManager.FragmentLifecycleCallbacks f411415b = new FragmentManager.FragmentLifecycleCallbacks() { // from class: k14.AndroidV4FragmentWatcher$1
    };

    public d(MemoryLeakInspector memoryLeakInspector) {
        this.f411414a = memoryLeakInspector;
    }

    @Override // k14.g
    public void a(Activity activity) {
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.f411415b);
        }
    }

    @Override // k14.g
    public boolean b(Activity activity) {
        return com.tencent.rmonitor.common.util.c.b(activity, "android.support.v4.app.FragmentActivity");
    }

    @Override // k14.g
    public void c(Activity activity) {
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.f411415b, true);
        }
    }
}
