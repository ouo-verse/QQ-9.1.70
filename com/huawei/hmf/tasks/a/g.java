package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.FragmentManager;
import android.util.Log;
import com.huawei.hmf.tasks.ExecuteResult;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class g extends ReportFragment {

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<g>> f36561b = new WeakHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final List<WeakReference<ExecuteResult<?>>> f36562a = new ArrayList();

    private static g a(Activity activity) {
        g gVar;
        WeakHashMap<Activity, WeakReference<g>> weakHashMap = f36561b;
        WeakReference<g> weakReference = weakHashMap.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            g gVar2 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar2 == null) {
                try {
                    gVar = a(fragmentManager);
                } catch (ClassCastException e16) {
                    e = e16;
                    gVar = gVar2;
                    Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                    return gVar;
                }
            } else {
                gVar = gVar2;
            }
        } catch (ClassCastException e17) {
            e = e17;
            gVar = null;
        }
        try {
            weakHashMap.put(activity, new WeakReference<>(gVar));
        } catch (ClassCastException e18) {
            e = e18;
            Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
            return gVar;
        }
        return gVar;
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.f36562a) {
            Iterator<WeakReference<ExecuteResult<?>>> it = this.f36562a.iterator();
            while (it.hasNext()) {
                ExecuteResult<?> executeResult = it.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f36562a.clear();
        }
    }

    private static g a(FragmentManager fragmentManager) {
        g gVar = null;
        try {
            g gVar2 = new g();
            try {
                fragmentManager.beginTransaction().add(gVar2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                return gVar2;
            } catch (Exception e16) {
                e = e16;
                gVar = gVar2;
                Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
                return gVar;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        g a16 = a(activity);
        if (a16 != null) {
            synchronized (a16.f36562a) {
                a16.f36562a.add(new WeakReference<>(executeResult));
            }
        }
    }
}
