package com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;
import tencent.im.msg.nt_im_msg_body$PubGroup;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopmemberinfo/c;", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "Lcom/tencent/mobileqq/nt/msgpush/troop/processor/a;", "troopBusinessData", "", "c", "b", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "convertResultData", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class c implements f {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(com.tencent.mobileqq.nt.msgpush.troop.processor.a troopBusinessData) {
        nt_im_msg_body$PubGroup f16 = troopBusinessData.f();
        if (f16 != null) {
            f16.has();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        if (r1 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c(com.tencent.mobileqq.nt.msgpush.troop.processor.a troopBusinessData) {
        boolean z16;
        AppInterface appInterface;
        TroopManager troopManager;
        AppInterface appInterface2;
        IRuntimeService iRuntimeService;
        boolean z17;
        nt_im_msg_body$GeneralFlags b16 = troopBusinessData.b();
        if (b16 != null) {
            TroopInfo troopInfo = null;
            if (b16.has() && b16.uint64_group_rank_seq.has()) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface2 = (AppInterface) peekAppRuntime;
                } else {
                    appInterface2 = null;
                }
                if (appInterface2 != null) {
                    iRuntimeService = appInterface2.getRuntimeService(IConversationFacade.class, "");
                } else {
                    iRuntimeService = null;
                }
                IConversationFacade iConversationFacade = (IConversationFacade) iRuntimeService;
                z16 = true;
                if (iConversationFacade != null && iConversationFacade.isSyncMsgFinish()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z16 = false;
            if (!z16) {
                b16 = null;
            }
            if (b16 != null) {
                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime2 instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime2;
                } else {
                    appInterface = null;
                }
                if (appInterface == null) {
                    return;
                }
                Manager manager = appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (manager instanceof TroopManager) {
                    troopManager = (TroopManager) manager;
                } else {
                    troopManager = null;
                }
                if (troopManager != null) {
                    troopInfo = troopManager.k(troopBusinessData.e());
                }
                if (troopInfo == null) {
                    return;
                }
                if (b16.uint64_group_rank_seq.get() > troopInfo.dwGroupLevelSeq || !troopInfo.isLevelMapInited()) {
                    ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).fetchTroopLevelInfo(troopBusinessData.e(), false);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.f
    public void a(@NotNull com.tencent.mobileqq.nt.msgpush.factory.a convertResultData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) convertResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(convertResultData, "convertResultData");
        com.tencent.mobileqq.nt.msgpush.troop.processor.a b16 = convertResultData.b();
        if (b16 == null) {
            return;
        }
        c(b16);
        b(b16);
    }
}
