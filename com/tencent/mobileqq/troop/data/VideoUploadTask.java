package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VideoUploadTask implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static String f294881f;

    /* renamed from: h, reason: collision with root package name */
    private static String f294882h;

    /* renamed from: d, reason: collision with root package name */
    protected l f294883d;

    /* renamed from: e, reason: collision with root package name */
    protected AtomicBoolean f294884e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f294881f = null;
            f294882h = null;
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f294884e.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        System.currentTimeMillis();
        this.f294884e.set(false);
        if (this.f294883d == null) {
            this.f294884e.set(true);
            if (QLog.isColorLevel()) {
                QLog.d("TroopBar", 2, "VideoUploadTask mCallback is null!!!");
                return;
            }
            return;
        }
        this.f294884e.set(true);
        this.f294883d.a(-1L);
        if (QLog.isColorLevel()) {
            QLog.d("TroopBar", 2, "VideoUploadTask entity is null !!!");
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f294884e.set(true);
        }
    }
}
