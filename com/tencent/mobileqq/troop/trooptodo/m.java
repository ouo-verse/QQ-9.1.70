package com.tencent.mobileqq.troop.trooptodo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f301812a;

        /* renamed from: b, reason: collision with root package name */
        public int f301813b;

        /* renamed from: c, reason: collision with root package name */
        public String f301814c;

        /* renamed from: d, reason: collision with root package name */
        public long f301815d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f301812a = -1;
            this.f301813b = 0;
            this.f301814c = "";
            this.f301815d = -1L;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "ReportData{memberType=" + this.f301812a + ", arkMessageType=" + this.f301813b + ", arkAppId='" + this.f301814c + "'}";
        }
    }

    public static String a(AIOMsgItem aIOMsgItem) {
        com.tencent.qqnt.msg.data.a parseArkModel;
        if (com.tencent.mobileqq.aio.utils.d.u(aIOMsgItem.getMsgRecord()) && (parseArkModel = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).parseArkModel(aIOMsgItem)) != null && parseArkModel.b() != null) {
            return parseArkModel.b();
        }
        return "";
    }

    public static int b(AIOMsgItem aIOMsgItem) {
        int msgType = aIOMsgItem.getMsgRecord().getMsgType();
        if (!com.tencent.mobileqq.aio.utils.d.Z(aIOMsgItem) && msgType != 9) {
            if (com.tencent.mobileqq.aio.utils.d.E(aIOMsgItem)) {
                return 2;
            }
            if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
                return 3;
            }
            if (com.tencent.mobileqq.aio.utils.d.x(aIOMsgItem)) {
                return 4;
            }
            if (com.tencent.mobileqq.aio.utils.d.u(aIOMsgItem.getMsgRecord())) {
                String a16 = a(aIOMsgItem);
                if (!"com.tencent.mannounce".equals(a16) && !"com.tencent.announce.lua".equals(a16)) {
                    if (!"com.tencent.qzone.albumShare".equals(a16) && !"com.tencent.groupphoto".equals(a16)) {
                        if (a16.contains("com.tencent.miniapp")) {
                            return 7;
                        }
                        if ("com.tencent.structmsg".equals(a16)) {
                            return 9;
                        }
                        return 10;
                    }
                    return 5;
                }
                return 6;
            }
            return 10;
        }
        return 1;
    }

    public static int c(AppInterface appInterface, long j3) {
        boolean b16 = com.tencent.mobileqq.troop.util.a.b(appInterface, Long.toString(j3), appInterface.getCurrentUin());
        boolean isTroopAdmin = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(appInterface, Long.toString(j3), appInterface.getCurrentUin());
        if (b16) {
            return 1;
        }
        if (isTroopAdmin) {
            return 2;
        }
        return 3;
    }

    public static void d(String str, AIOMsgItem aIOMsgItem) {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        int c16 = c(appInterface, aIOMsgItem.getMsgRecord().getPeerUin());
        int b16 = b(aIOMsgItem);
        ReportController.o(appInterface, "dc00898", "", "", str, str, 0, 0, String.valueOf(c16), String.valueOf(b16), a(aIOMsgItem), "");
    }
}
