package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.quic.internal.LoadSoImp;
import com.tencent.mobileqq.transfile.quic.internal.QuicEngineImp;
import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QuicEngineFactory {
    static IPatchRedirector $redirector_;
    private static volatile IQuicEngine sQuicEngine;

    public QuicEngineFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean checkSoDownloaded() {
        if (FileUtils.fileExists(Utils.getAndromedaSoPath()) && FileUtils.fileExists(Utils.getQuicEngineSoPath())) {
            return true;
        }
        return false;
    }

    public static IQuicEngine createEngine() {
        if (Utils.checkIfCPUx86()) {
            QLog.e("quic", 4, "the phone cpu is x86");
            return null;
        }
        if (sQuicEngine == null) {
            synchronized (QuicEngineFactory.class) {
                if (sQuicEngine == null) {
                    sQuicEngine = new QuicEngineImp(new LoadSoImp());
                }
            }
        }
        return sQuicEngine;
    }
}
