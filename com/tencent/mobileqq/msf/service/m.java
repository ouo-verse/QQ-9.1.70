package com.tencent.mobileqq.msf.service;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m extends BaseThread {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f250968c = "MSF.S.RespHandler";

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f250969a;

    /* renamed from: b, reason: collision with root package name */
    MsfCore f250970b;

    public m(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
        } else {
            this.f250969a = true;
            this.f250970b = msfCore;
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        com.tencent.mobileqq.msf.core.c0.j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        while (this.f250969a) {
            try {
                MsfMessagePair take = this.f250970b.getMsfMessagePairs().take();
                if (take != null) {
                    ToServiceMsg toServiceMsg = take.toServiceMsg;
                    if (toServiceMsg != null) {
                        String b16 = n.b(toServiceMsg);
                        if (!"LongConn.OffPicUp".equals(take.toServiceMsg.getServiceCmd()) && !"ImgStore.GroupPicUp".equals(take.toServiceMsg.getServiceCmd())) {
                            QLog.d(f250968c, 1, b16 + " add resp to queue:" + take.toServiceMsg.getRequestSsoSeq() + " from:" + take.fromServiceMsg);
                            if (b16 == null && BaseConstants.CMD_MSG_PBSENDMSG.equals(take.toServiceMsg.getServiceCmd()) && ((BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) && (jVar = MsfCore.sCore.statReporter) != null)) {
                                jVar.b(take.toServiceMsg, take.fromServiceMsg);
                            }
                            e.b(b16, take.toServiceMsg, take.fromServiceMsg);
                        }
                        QLog.d(f250968c, 1, "recv " + b16 + " req:" + take.toServiceMsg.getStringForLog() + "resp:" + take.fromServiceMsg.getStringForLog());
                        e.b(b16, take.toServiceMsg, take.fromServiceMsg);
                    } else if (take.fromServiceMsg != null) {
                        String str = take.sendProcess;
                        if (TextUtils.isEmpty(str)) {
                            str = n.b(take.fromServiceMsg);
                        }
                        QLog.d(f250968c, 1, str + " add push to queue: from:" + take.fromServiceMsg);
                        e.b(str, take.toServiceMsg, take.fromServiceMsg);
                    }
                }
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }
}
