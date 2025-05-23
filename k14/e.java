package k14;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

/* compiled from: P */
/* loaded from: classes25.dex */
class e implements g {

    /* renamed from: a, reason: collision with root package name */
    private final MemoryLeakInspector f411416a;

    /* renamed from: b, reason: collision with root package name */
    protected final FragmentManager.FragmentLifecycleCallbacks f411417b = new a();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends FragmentManager.FragmentLifecycleCallbacks {
        a() {
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
            e.this.f411416a.m(fragment, "");
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
            if (fragment.getView() != null) {
                e.this.f411416a.m(fragment.getView(), "");
            }
        }
    }

    public e(MemoryLeakInspector memoryLeakInspector) {
        this.f411416a = memoryLeakInspector;
    }

    @Override // k14.g
    public void a(Activity activity) {
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.f411417b);
        }
    }

    @Override // k14.g
    public boolean b(Activity activity) {
        return com.tencent.rmonitor.common.util.c.b(activity, "androidx.fragment.app.FragmentActivity");
    }

    @Override // k14.g
    public void c(Activity activity) {
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.f411417b, true);
        }
    }
}
