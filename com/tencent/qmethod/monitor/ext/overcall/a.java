package com.tencent.qmethod.monitor.ext.overcall;

import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/overcall/a;", "", "", "a", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "b", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Z", "enable", "c", "init", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "callTime", "", "e", "Ljava/lang/String;", "focusAPI", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean init;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final String focusAPI;

    /* renamed from: f, reason: collision with root package name */
    public static final a f343661f = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Object lock = new Object();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static AtomicInteger callTime = new AtomicInteger(0);

    static {
        Object random;
        random = CollectionsKt___CollectionsKt.random(OverCallMonitor.f343654b.b(), Random.INSTANCE);
        String str = (String) random;
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            o.a("OverCallLimit", "focus api = " + str);
        }
        focusAPI = str;
    }

    a() {
    }

    private final boolean a() {
        if (init) {
            return enable;
        }
        b bVar = b.f343662a;
        if (bVar.b() == 0) {
            synchronized (lock) {
                if (bVar.b() == 0) {
                    enable = true;
                }
                init = true;
                Unit unit = Unit.INSTANCE;
            }
            if (!init || !enable) {
                return false;
            }
            return true;
        }
        init = true;
        return false;
    }

    public final boolean b(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        if ((!Intrinsics.areEqual(focusAPI, reportStrategy.f343965b)) || !SampleHelper.f343779l.q().get() || !a() || callTime.incrementAndGet() < 2) {
            return false;
        }
        reportStrategy.f343987x = callTime.get();
        return true;
    }
}
