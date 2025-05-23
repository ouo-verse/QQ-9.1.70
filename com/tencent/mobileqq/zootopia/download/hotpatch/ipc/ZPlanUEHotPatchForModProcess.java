package com.tencent.mobileqq.zootopia.download.hotpatch.ipc;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/hotpatch/ipc/ZPlanUEHotPatchForModProcess;", "", "Ltx4/a;", "listener", "", "c", "d", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "engineLoadingListeners", "com/tencent/mobileqq/zootopia/download/hotpatch/ipc/ZPlanUEHotPatchForModProcess$progressListenerProxy$1", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/ipc/ZPlanUEHotPatchForModProcess$progressListenerProxy$1;", "progressListenerProxy", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEHotPatchForModProcess {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanUEHotPatchForModProcess f328061a = new ZPlanUEHotPatchForModProcess();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<tx4.a> engineLoadingListeners = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanUEHotPatchForModProcess$progressListenerProxy$1 progressListenerProxy = new tx4.a() { // from class: com.tencent.mobileqq.zootopia.download.hotpatch.ipc.ZPlanUEHotPatchForModProcess$progressListenerProxy$1
        @Override // tx4.a
        public void Q0(final CommonLoadingData loadingData) {
            Intrinsics.checkNotNullParameter(loadingData, "loadingData");
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.hotpatch.ipc.ZPlanUEHotPatchForModProcess$progressListenerProxy$1$onProgress$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    CopyOnWriteArrayList copyOnWriteArrayList2;
                    int progress = CommonLoadingData.this.getProgress();
                    copyOnWriteArrayList = ZPlanUEHotPatchForModProcess.engineLoadingListeners;
                    QLog.i("ZPlanUEHotPatchForModProcess", 1, "progressListenerProxy#onProgress " + progress + ", " + copyOnWriteArrayList.size());
                    copyOnWriteArrayList2 = ZPlanUEHotPatchForModProcess.engineLoadingListeners;
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((tx4.a) it.next()).Q0(CommonLoadingData.this);
                    }
                }
            });
        }
    };

    ZPlanUEHotPatchForModProcess() {
    }

    public final tx4.a b() {
        return progressListenerProxy;
    }

    public final void c(tx4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<tx4.a> copyOnWriteArrayList = engineLoadingListeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void d(tx4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<tx4.a> copyOnWriteArrayList = engineLoadingListeners;
        if (copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.remove(listener);
        }
    }
}
