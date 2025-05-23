package j14;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.f;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends c {

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.rmonitor.common.lifecycle.b f409138b;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends f {
        a() {
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onDestroy(@NonNull Activity activity) {
            b.this.d(activity);
        }
    }

    public b(MemoryLeakInspector memoryLeakInspector) {
        super(memoryLeakInspector);
        this.f409138b = new a();
    }

    @Override // i14.c
    public boolean a() {
        LifecycleCallback.r(this.f409138b);
        return true;
    }

    @Override // i14.c
    public void b() {
        LifecycleCallback.s(this.f409138b);
    }

    @Override // i14.b, i14.c
    public boolean c() {
        return AndroidVersion.isOverIceScreamSandwich();
    }
}
