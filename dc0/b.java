package dc0;

import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tedger.outapi.delegate.e;
import com.tencent.tedger.outapi.delegate.f;
import hc0.m;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final f f393529a;

    /* renamed from: c, reason: collision with root package name */
    protected c f393531c = new c(this);

    /* renamed from: b, reason: collision with root package name */
    private final m f393530b = new m();

    public b(f fVar) {
        this.f393529a = fVar;
    }

    public void a(Runnable runnable) {
        RFWThreadManager.getInstance().execOnSubThread(runnable);
    }

    public ec0.a b() {
        return this.f393530b;
    }

    public c c() {
        return this.f393531c;
    }

    public e d() {
        return this.f393529a.getLogDelegate();
    }
}
