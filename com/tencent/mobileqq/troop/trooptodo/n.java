package com.tencent.mobileqq.troop.trooptodo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static d f301816a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f301817b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65115);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301817b = false;
        }
    }

    public static void a(AIOMsgItem aIOMsgItem) {
        if (aIOMsgItem.getMsgSeq() <= 0) {
            QQToast.makeText(BaseApplication.getContext(), R.string.zlo, 0).show();
        } else {
            ((TroopToDoHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(TroopToDoHandler.class.getName())).F2(aIOMsgItem.getMsgRecord().getPeerUin(), aIOMsgItem.getMsgSeq(), s.g(aIOMsgItem.getMsgRecord().getMsgRandom()));
        }
    }

    public static void b() {
        f301816a = null;
    }

    public static boolean c() {
        return f301817b;
    }

    public static boolean d(AppRuntime appRuntime, long j3) {
        boolean isTroopAdmin = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(appRuntime, Long.toString(j3), appRuntime.getCurrentUin());
        boolean b16 = com.tencent.mobileqq.troop.util.a.b(appRuntime, Long.toString(j3), appRuntime.getCurrentUin());
        if (!isTroopAdmin && !b16) {
            return false;
        }
        return true;
    }

    public static boolean e(String str) {
        if (new com.tencent.mobileqq.troop.todo.config.a().a(str)) {
            return true;
        }
        return false;
    }

    public static boolean f(String str) {
        if (str.isEmpty()) {
            return false;
        }
        if (!"com.tencent.mannounce".equals(str) && !"com.tencent.announce.lua".equals(str) && !"com.tencent.qzone.albumShare".equals(str) && !"com.tencent.groupphoto".equals(str) && !"com.tencent.weishi.ark".equals(str) && !str.contains("com.tencent.miniapp") && !e(str)) {
            return false;
        }
        return true;
    }

    public static boolean g(MsgRecord msgRecord) {
        d dVar = f301816a;
        if (dVar == null) {
            return false;
        }
        long j3 = dVar.c().f301780a;
        long j16 = f301816a.c().f301781b;
        if (msgRecord.getPeerUin() != j3 || msgRecord.getMsgSeq() != j16) {
            return false;
        }
        return true;
    }

    public static void h(AIOMsgItem aIOMsgItem) {
        ((TroopToDoHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(TroopToDoHandler.class.getName())).K2(aIOMsgItem.getMsgRecord().getPeerUin(), aIOMsgItem.getMsgSeq(), s.g(aIOMsgItem.getMsgRecord().getMsgRandom()));
    }

    public static void i(d dVar) {
        f301816a = dVar;
    }

    public static void j(boolean z16) {
        f301817b = z16;
    }
}
