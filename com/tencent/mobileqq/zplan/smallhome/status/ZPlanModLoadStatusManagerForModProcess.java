package com.tencent.mobileqq.zplan.smallhome.status;

import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusManagerForModProcess;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/zplan/smallhome/status/a;", "", "action", "e", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "c", "listener", "f", "g", "b", "statusInfo", "d", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanModLoadStatusManagerForModProcess {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ZPlanModLoadStatusInfo statusInfo;

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanModLoadStatusManagerForModProcess f335710a = new ZPlanModLoadStatusManagerForModProcess();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<a> listenerList = new CopyOnWriteArrayList<>();

    ZPlanModLoadStatusManagerForModProcess() {
    }

    private final void e(final Function1<? super a, Unit> action) {
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForModProcess$notifyAllListeners$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                ArrayList arrayList = new ArrayList();
                copyOnWriteArrayList = ZPlanModLoadStatusManagerForModProcess.listenerList;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add((a) it.next());
                }
                Function1<a, Unit> function1 = action;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    function1.invoke((a) it5.next());
                }
                arrayList.clear();
            }
        });
    }

    public final void b() {
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo = statusInfo;
        QLog.i("ZPlanModLoadStatusManagerForModProcess", 1, "clearLoadStatus, cur= " + (zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.printSimpleInfo() : null) + " - " + this);
        statusInfo = null;
        listenerList.clear();
    }

    public final ZPlanModLoadStatusInfo c() {
        if (statusInfo == null) {
            statusInfo = ((sk3.b) i.INSTANCE.a(sk3.b.class)).getCurrentStatusInfo();
        }
        return statusInfo;
    }

    public final void d(final ZPlanModLoadStatusInfo statusInfo2) {
        Intrinsics.checkNotNullParameter(statusInfo2, "statusInfo");
        ZPlanModLoadStatus status = statusInfo2.getStatus();
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo = statusInfo;
        if (status != (zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getStatus() : null)) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2 = statusInfo;
            ZPlanModLoadStatus status2 = zPlanModLoadStatusInfo2 != null ? zPlanModLoadStatusInfo2.getStatus() : null;
            QLog.i("ZPlanModLoadStatusManagerForModProcess", 1, "finalUpdateStatus statusChanged, old= " + status2 + ", new= " + statusInfo2.getStatus());
        }
        statusInfo = statusInfo2;
        e(new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForModProcess$finalUpdateStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.updateStatus(ZPlanModLoadStatusInfo.this);
            }
        });
    }

    public final void f(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i("ZPlanModLoadStatusManagerForModProcess", 1, "registerListener - " + listener);
        CopyOnWriteArrayList<a> copyOnWriteArrayList = listenerList;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void g(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i("ZPlanModLoadStatusManagerForModProcess", 1, "unRegisterListener - " + listener);
        listenerList.remove(listener);
    }
}
