package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AychWriter extends BaseThread {
    static IPatchRedirector $redirector_;
    private String content;
    private String dirPath;
    private String filePath;

    public AychWriter(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.content = str;
        this.filePath = str2;
        this.dirPath = str3;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        System.out.println("\u5f00\u59cb\u6267\u884crun()");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            LogWriter.getLogWriter(this.filePath, this.dirPath).log(this.content);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        LogWriter.logWriter = null;
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println("\u603b\u6d88\u8017\u65f6\u95f4\uff1a" + (currentTimeMillis2 - currentTimeMillis));
    }
}
