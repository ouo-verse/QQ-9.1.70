package com.tencent.qqnt.notification.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopnotification.repo.TroopNotificationListRepo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.k;
import com.tencent.qqnt.inner.observer.TroopNotificationChangedDispatcher;
import com.tencent.qqnt.notification.f;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class TroopNotificationInnerServiceImpl$updateFirstPageCache$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopNotificationInnerServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopNotificationInnerServiceImpl$updateFirstPageCache$1(TroopNotificationInnerServiceImpl troopNotificationInnerServiceImpl) {
        super(0);
        this.this$0 = troopNotificationInnerServiceImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopNotificationInnerServiceImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final TroopNotificationInnerServiceImpl this$0) {
        com.tencent.qqnt.notification.c cVar;
        TroopNotificationListRepo listRepo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cVar = this$0.firstPageCacheInfo;
        cVar.b();
        listRepo = this$0.getListRepo();
        listRepo.o(null, new Function1<Map<Integer, ? extends List<f>>, Unit>() { // from class: com.tencent.qqnt.notification.impl.TroopNotificationInnerServiceImpl$updateFirstPageCache$1$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationInnerServiceImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends List<f>> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Map<Integer, ? extends List<f>> notificationMap) {
                k kVar;
                TroopNotificationChangedDispatcher dispatcher;
                com.tencent.qqnt.notification.c cVar2;
                com.tencent.qqnt.notification.c cVar3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) notificationMap);
                    return;
                }
                Intrinsics.checkNotNullParameter(notificationMap, "notificationMap");
                TroopNotificationInnerServiceImpl troopNotificationInnerServiceImpl = TroopNotificationInnerServiceImpl.this;
                for (Map.Entry<Integer, ? extends List<f>> entry : notificationMap.entrySet()) {
                    cVar3 = troopNotificationInnerServiceImpl.firstPageCacheInfo;
                    cVar3.a(entry.getKey().intValue(), entry.getValue());
                }
                if (QLog.isColorLevel()) {
                    cVar2 = TroopNotificationInnerServiceImpl.this.firstPageCacheInfo;
                    QLog.d("TroopNotificationInnerServiceImpl", 2, "updateFirstPageCache: finish cache refresh, " + cVar2);
                }
                kVar = TroopNotificationInnerServiceImpl.this.sequentialTaskControl;
                kVar.e();
                dispatcher = TroopNotificationInnerServiceImpl.this.getDispatcher();
                dispatcher.g();
            }
        });
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            final TroopNotificationInnerServiceImpl troopNotificationInnerServiceImpl = this.this$0;
            bg.k(new Runnable() { // from class: com.tencent.qqnt.notification.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    TroopNotificationInnerServiceImpl$updateFirstPageCache$1.b(TroopNotificationInnerServiceImpl.this);
                }
            });
        }
    }
}
