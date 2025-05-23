package com.tencent.mobileqq.troop.troopownertask;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskRefreshUIEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isOwner", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
final class TroopOwnerTaskTipsBar$onReceiveEvent$1$1 extends Lambda implements Function1<Boolean, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopOwnerTaskRefreshUIEvent $event;
    final /* synthetic */ String $troopUin;
    final /* synthetic */ TroopOwnerTaskTipsBar this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopOwnerTaskTipsBar$onReceiveEvent$1$1(TroopOwnerTaskTipsBar troopOwnerTaskTipsBar, String str, TroopOwnerTaskRefreshUIEvent troopOwnerTaskRefreshUIEvent) {
        super(1);
        this.this$0 = troopOwnerTaskTipsBar;
        this.$troopUin = str;
        this.$event = troopOwnerTaskRefreshUIEvent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopOwnerTaskTipsBar, str, troopOwnerTaskRefreshUIEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopOwnerTaskTipsBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().unRegisterReceiver(this$0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16) {
            this.this$0.L(this.$troopUin, this.$event.getTroopOwnerTask(), this.$event.getTroopOwnerMsg());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskTipsBar", 2, "onAIOEvent: onReceiveEvent not troop owner");
        }
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final TroopOwnerTaskTipsBar troopOwnerTaskTipsBar = this.this$0;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopownertask.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopOwnerTaskTipsBar$onReceiveEvent$1$1.b(TroopOwnerTaskTipsBar.this);
            }
        });
    }
}
