package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class TargetManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final File f114779a;

    /* renamed from: b, reason: collision with root package name */
    final File f114780b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TargetManager(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
            return;
        }
        File file2 = new File(file, "TargetFolder");
        this.f114779a = file2;
        this.f114780b = new File(file2, "tmp");
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException(file2.getAbsolutePath() + "\u5df2\u5b58\u5728\u4e14\u4e0d\u662f\u76ee\u5f55");
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }
}
