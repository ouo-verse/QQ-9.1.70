package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f248784a = "MSF.C.NetExceptionStat";

    /* renamed from: b, reason: collision with root package name */
    private static LinkedBlockingDeque<a> f248785b;

    /* renamed from: c, reason: collision with root package name */
    private static long f248786c;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        b f248787a;

        /* renamed from: b, reason: collision with root package name */
        long f248788b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f248789a;

        /* renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ b[] f248790b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12881);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            b bVar = new b("MessageTimeout", 0);
            f248789a = bVar;
            f248790b = new b[]{bVar};
        }

        b(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static b a(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f248790b.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f248785b = new LinkedBlockingDeque<>(100);
            f248786c = System.currentTimeMillis() - 180000;
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(b bVar) {
        a peek;
        if (!NetConnInfoCenter.isNetSupport()) {
            return;
        }
        if (f248785b.size() >= 100) {
            QLog.d(f248784a, 2, "addNetException NetExceptionEvent count = " + f248785b.size() + "too much drop");
            return;
        }
        a aVar = new a();
        aVar.f248787a = bVar;
        long currentTimeMillis = System.currentTimeMillis();
        aVar.f248788b = currentTimeMillis;
        try {
            f248785b.addLast(aVar);
            QLog.d(f248784a, 2, "addNetException NetExceptionEvent count = " + f248785b.size() + "");
            while (true) {
                try {
                    peek = f248785b.peek();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (peek == null || currentTimeMillis - peek.f248788b < com.tencent.mobileqq.msf.core.x.b.f0()) {
                    break;
                } else {
                    f248785b.removeFirst();
                }
            }
            QLog.d(f248784a, 2, "addNetException after remove expire event NetExceptionEvent count = " + f248785b.size());
            if (currentTimeMillis - f248786c > com.tencent.mobileqq.msf.core.x.b.f0() && f248785b.size() >= com.tencent.mobileqq.msf.core.x.b.e0()) {
                QLog.d(f248784a, 2, "NetExceptionEvent count = " + f248785b.size() + " report to ui now");
                FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), MsfService.getCore().getNextSeq(), "0", BaseConstants.CMD_CONNWEAKNET);
                fromServiceMsg.setMsgSuccess();
                fromServiceMsg.setMsfCommand(MsfCommand.onConnWeakNet);
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                NetConnInfoCenter.msfCore.addRespToQuque(null, fromServiceMsg);
                f248786c = currentTimeMillis;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }
}
