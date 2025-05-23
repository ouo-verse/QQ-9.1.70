package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DiskStorageManager {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class TouchCallable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final File f236937d;
        final /* synthetic */ DiskStorageManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                DiskStorageManager.a(null, this.f236937d);
            } catch (IOException e16) {
                e16.printStackTrace();
                QLog.d("DiskStorageManager", 2, "IO exception run error in background", e16);
            }
        }
    }

    static /* bridge */ /* synthetic */ void a(DiskStorageManager diskStorageManager, File file) {
        throw null;
    }
}
