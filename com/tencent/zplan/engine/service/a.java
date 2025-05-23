package com.tencent.zplan.engine.service;

import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/engine/service/a;", "", "Ltx4/a;", "listener", "", "c", "d", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "engineLoadingListeners", "com/tencent/zplan/engine/service/a$a", "Lcom/tencent/zplan/engine/service/a$a;", "progressListener", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final C10060a progressListener;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f385627c = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<tx4.a> engineLoadingListeners = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/engine/service/a$a", "Ltx4/a;", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "", "Q0", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.engine.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10060a implements tx4.a {
        C10060a() {
        }

        @Override // tx4.a
        public void Q0(@NotNull CommonLoadingData loadingData) {
            Intrinsics.checkNotNullParameter(loadingData, "loadingData");
            Iterator it = a.a(a.f385627c).iterator();
            while (it.hasNext()) {
                ((tx4.a) it.next()).Q0(loadingData);
            }
        }
    }

    static {
        C10060a c10060a = new C10060a();
        progressListener = c10060a;
        com.tencent.zplan.luabridge.plugins.a.f385727e.a(c10060a);
    }

    a() {
    }

    public static final /* synthetic */ CopyOnWriteArrayList a(a aVar) {
        return engineLoadingListeners;
    }

    public final void b(@NotNull CommonLoadingData loadingData) {
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        progressListener.Q0(loadingData);
    }

    public final void c(@NotNull tx4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<tx4.a> copyOnWriteArrayList = engineLoadingListeners;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
        }
    }

    public final void d(@NotNull tx4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<tx4.a> copyOnWriteArrayList = engineLoadingListeners;
        if (copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.remove(listener);
        }
    }
}
