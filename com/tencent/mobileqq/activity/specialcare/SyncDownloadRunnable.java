package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SyncDownloadRunnable implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.vip.g f186547d;

    /* renamed from: e, reason: collision with root package name */
    public int f186548e;

    /* renamed from: f, reason: collision with root package name */
    private File f186549f;

    /* renamed from: h, reason: collision with root package name */
    private String f186550h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<IQvipSpecialSoundManager> f186551i;

    public SyncDownloadRunnable(com.tencent.mobileqq.vip.g gVar, File file, String str, IQvipSpecialSoundManager iQvipSpecialSoundManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, gVar, file, str, iQvipSpecialSoundManager);
            return;
        }
        this.f186547d = gVar;
        this.f186549f = file;
        this.f186550h = str;
        this.f186548e = -1;
        this.f186551i = new WeakReference<>(iQvipSpecialSoundManager);
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f186548e = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).specialSoundDownload(this.f186547d);
        if (QLog.isColorLevel()) {
            QLog.d("SyncDownloadRunnable", 2, "[SyncDownloadRunnable]:resultCode=" + this.f186548e);
        }
        WeakReference<IQvipSpecialSoundManager> weakReference = this.f186551i;
        if (weakReference != null && weakReference.get() != null) {
            this.f186551i.get().onSpecialSoundConfigDownloaded(this.f186548e, this.f186549f, this.f186550h);
        }
    }
}
