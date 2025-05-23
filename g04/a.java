package g04;

import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.f;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends f {

    /* renamed from: d, reason: collision with root package name */
    private final long f401049d;

    /* renamed from: e, reason: collision with root package name */
    private final long f401050e;

    /* renamed from: f, reason: collision with root package name */
    private long f401051f;

    public a(long j3, long j16, long j17) {
        this.f401051f = j3;
        this.f401049d = j16;
        this.f401050e = j17;
    }

    public long e() {
        return this.f401051f;
    }

    public void f() {
        LifecycleCallback.r(this);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
    public void onBackground() {
        this.f401051f = this.f401050e;
    }

    @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
    public void onForeground() {
        this.f401051f = this.f401049d;
    }

    public void stop() {
        LifecycleCallback.s(this);
    }
}
