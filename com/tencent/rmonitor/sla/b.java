package com.tencent.rmonitor.sla;

import com.tencent.rmonitor.base.db.table.AttaEventTable;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u0014\u0010\n\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/rmonitor/sla/b;", "", "Lcom/tencent/rmonitor/sla/c;", "attaEvent", "", "d", "", "list", "b", "", "a", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLocalDataReported", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f365843b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isLocalDataReported = new AtomicBoolean(false);

    b() {
    }

    public final int a(@NotNull List<AttaEvent> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        int d16 = AttaEventTable.INSTANCE.a().d(list);
        Logger.f365497g.d("RMonitor_sla_AttaDBManager", "deleteDataInDB count:" + d16);
        return d16;
    }

    public final void b(@NotNull List<AttaEvent> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        Logger.f365497g.d("RMonitor_sla_AttaDBManager", "batchSaveData size:" + list.size());
        if (!isLocalDataReported.get()) {
            c();
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            AttaEventTable.INSTANCE.a().i((AttaEvent) it.next());
        }
    }

    public final void c() {
        if (!isLocalDataReported.compareAndSet(false, true)) {
            Logger.f365497g.d("RMonitor_sla_AttaDBManager", "already report local data");
            return;
        }
        List<AttaEvent> h16 = AttaEventTable.h(AttaEventTable.INSTANCE.a(), null, null, null, false, null, null, null, "30", 127, null);
        Logger.f365497g.d("RMonitor_sla_AttaDBManager", "reportLocalData , size:" + h16.size());
        if (!h16.isEmpty() && AttaEventReporter.INSTANCE.a().e(h16, false)) {
            a(h16);
        }
    }

    public final void d(@NotNull AttaEvent attaEvent) {
        Intrinsics.checkParameterIsNotNull(attaEvent, "attaEvent");
        Logger.f365497g.d("RMonitor_sla_AttaDBManager", "saveData eventCode:" + attaEvent.getEventCode());
        if (!isLocalDataReported.get()) {
            c();
        }
        AttaEventTable.INSTANCE.a().i(attaEvent);
    }
}
