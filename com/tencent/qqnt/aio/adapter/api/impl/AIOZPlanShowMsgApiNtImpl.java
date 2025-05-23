package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOZPlanShowMsgApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOZPlanShowMsgApi;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "onMsgClick", "onPlayAction", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "onEnterAIO", "onExitAIO", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOZPlanShowMsgApiNtImpl implements IAIOZPlanShowMsgApi {
    static IPatchRedirector $redirector_;

    public AIOZPlanShowMsgApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi
    public void onEnterAIO(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioContext);
        } else {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            QLog.i("AIOZPlanShowMsgApiNtImpl", 1, "onEnterAIO");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi
    public void onExitAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.i("AIOZPlanShowMsgApiNtImpl", 1, "onExitAIO");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi
    public void onMsgClick(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        } else {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            QLog.i("AIOZPlanShowMsgApiNtImpl", 1, "onMsgClick");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi
    public void onPlayAction(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
        } else {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            QLog.i("AIOZPlanShowMsgApiNtImpl", 1, "onPlayAction");
        }
    }
}
