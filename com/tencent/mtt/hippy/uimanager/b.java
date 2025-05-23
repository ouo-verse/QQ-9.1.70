package com.tencent.mtt.hippy.uimanager;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    final HippyEngineContext f337667a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<View> f337668b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray<View> f337669c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, a> f337670d = new ConcurrentHashMap();

    public b(HippyEngineContext hippyEngineContext) {
        this.f337667a = hippyEngineContext;
    }

    public int a() {
        return this.f337669c.size();
    }

    public int b(int i3) {
        return this.f337669c.keyAt(i3);
    }

    public View c(int i3) {
        return this.f337669c.get(i3);
    }

    public void d(int i3) {
        this.f337668b.remove(i3);
    }

    public void e(int i3) {
        this.f337669c.remove(i3);
    }

    public View a(int i3) {
        View view = this.f337668b.get(i3);
        return view == null ? this.f337669c.get(i3) : view;
    }

    public HippyViewController b(String str) {
        try {
            return this.f337670d.get(str).f337665a;
        } catch (Throwable unused) {
            if (this.f337667a == null) {
                return null;
            }
            this.f337667a.getGlobalConfigs().getExceptionHandler().handleNativeException(new RuntimeException("getViewController: error className=" + str), true);
            return null;
        }
    }

    public a a(String str) {
        return this.f337670d.get(str);
    }

    public void a(View view) {
        this.f337668b.put(view.getId(), view);
    }

    public void a(HippyRootView hippyRootView) {
        this.f337669c.put(hippyRootView.getId(), hippyRootView);
    }

    public void a(String str, a aVar) {
        this.f337670d.put(str, aVar);
    }
}
