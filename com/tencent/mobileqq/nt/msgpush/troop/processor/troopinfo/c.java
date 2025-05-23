package com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.nt_im_msg_body$ExtraInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopinfo/c;", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "convertResultData", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class c implements f {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.f
    public void a(@NotNull com.tencent.mobileqq.nt.msgpush.factory.a convertResultData) {
        nt_im_msg_body$ExtraInfo a16;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        GroupMsgMask troopMask;
        GroupMsgMask newMask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) convertResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(convertResultData, "convertResultData");
        com.tencent.mobileqq.nt.msgpush.troop.processor.a b16 = convertResultData.b();
        if (b16 != null && (a16 = b16.a()) != null && a16.has() && a16.uint32_new_group_flag.has()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IConversationFacade.class, "");
            } else {
                iRuntimeService = null;
            }
            IConversationFacade iConversationFacade = (IConversationFacade) iRuntimeService;
            if (iConversationFacade != null && (troopMask = iConversationFacade.getTroopMask(b16.e())) != (newMask = TroopInfo.convertTroopMask(a16.uint32_new_group_flag.get()))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMsgFilterProcessor", 2, "process: oldMask=" + troopMask + ", newMask=" + newMask);
                }
                if (newMask != GroupMsgMask.UNSPECIFIED) {
                    ITroopOperationRepoApi iTroopOperationRepoApi = (ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class);
                    String e16 = b16.e();
                    Intrinsics.checkNotNullExpressionValue(newMask, "newMask");
                    iTroopOperationRepoApi.setGroupMsgMask(e16, newMask, null, null);
                }
            }
        }
    }
}
