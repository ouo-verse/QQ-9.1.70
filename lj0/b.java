package lj0;

import android.os.Process;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Llj0/b;", "", "", "c", "", "b", "d", "a", "Z", "isExit", "isStarted", "", "I", "lastPssSize", "", "J", "lastHeapSize", "", "e", "Ljava/lang/String;", "tag", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isExit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isStarted;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int lastPssSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastHeapSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String tag;

    public b(String str) {
        this.tag = str;
    }

    private final boolean c() {
        return wg0.a.b() && !this.isExit;
    }

    public final void a() {
        if (c() && this.isStarted) {
            System.gc();
            a aVar = a.f414855a;
            int totalPss = aVar.d(Process.myPid()).getTotalPss();
            long c16 = aVar.c();
            int i3 = totalPss - this.lastPssSize;
            long j3 = (c16 - this.lastHeapSize) / 1024;
            cg0.a.b(this.tag, "ECPageMemoryMonitor: delPssSize=" + i3 + "KB, delHeapSize=" + j3 + "KB");
            this.isStarted = false;
        }
    }

    public final void d() {
        if (!c() || this.isStarted) {
            return;
        }
        this.isStarted = true;
        System.gc();
        a aVar = a.f414855a;
        this.lastPssSize = aVar.d(Process.myPid()).getTotalPss();
        this.lastHeapSize = aVar.c();
    }

    public final void b() {
        this.isExit = false;
    }
}
