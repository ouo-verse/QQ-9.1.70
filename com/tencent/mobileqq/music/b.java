package com.tencent.mobileqq.music;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private a f251877a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.music.d
    public void a(AppService appService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appService);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteQQPlayerCallback", 2, "[onCreate]");
        }
        this.f251877a = new a(appService.getBaseContext());
    }

    @Override // com.tencent.mobileqq.music.d
    public void b(AppService appService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appService);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteQQPlayerCallback", 2, "[onDestroy]");
        }
        this.f251877a.c();
        this.f251877a = null;
    }
}
