package k14;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.RequiresApi;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c implements g {

    /* renamed from: a, reason: collision with root package name */
    private final MemoryLeakInspector f411411a;

    /* renamed from: b, reason: collision with root package name */
    @RequiresApi(26)
    private final FragmentManager.FragmentLifecycleCallbacks f411412b = new a();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends FragmentManager.FragmentLifecycleCallbacks {
        a() {
        }

        @Override // android.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
            c.this.f411411a.m(fragment, "");
        }

        @Override // android.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
            if (fragment.getView() != null) {
                c.this.f411411a.m(fragment.getView(), "");
            }
        }
    }

    public c(MemoryLeakInspector memoryLeakInspector) {
        this.f411411a = memoryLeakInspector;
    }

    @Override // k14.g
    @RequiresApi(26)
    public void a(Activity activity) {
        if (activity != null) {
            activity.getFragmentManager().unregisterFragmentLifecycleCallbacks(this.f411412b);
        }
    }

    @Override // k14.g
    public boolean b(Activity activity) {
        return AndroidVersion.isOverO();
    }

    @Override // k14.g
    @RequiresApi(26)
    public void c(Activity activity) {
        if (activity != null) {
            activity.getFragmentManager().registerFragmentLifecycleCallbacks(this.f411412b, true);
        }
    }
}
