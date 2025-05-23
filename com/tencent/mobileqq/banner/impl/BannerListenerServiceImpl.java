package com.tencent.mobileqq.banner.impl;

import com.tencent.mobileqq.banner.IBannerListenerService;
import com.tencent.mobileqq.banner.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BannerListenerServiceImpl implements IBannerListenerService {
    static IPatchRedirector $redirector_;
    private List<c> bannerListenerList;

    public BannerListenerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.IBannerListenerService
    public synchronized void addBannerListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            if (cVar == null) {
                return;
            }
            if (!this.bannerListenerList.contains(cVar)) {
                this.bannerListenerList.add(cVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.banner.IBannerListenerService
    public synchronized void notifyBannerDismiss(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        Iterator<c> it = this.bannerListenerList.iterator();
        while (it.hasNext()) {
            it.next().b(i3);
        }
    }

    @Override // com.tencent.mobileqq.banner.IBannerListenerService
    public synchronized void notifyBannerShow(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        Iterator<c> it = this.bannerListenerList.iterator();
        while (it.hasNext()) {
            it.next().a(i3);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.bannerListenerList = new ArrayList();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.bannerListenerList.clear();
        }
    }

    @Override // com.tencent.mobileqq.banner.IBannerListenerService
    public synchronized void removeBannerListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.bannerListenerList.remove(cVar);
        }
    }
}
