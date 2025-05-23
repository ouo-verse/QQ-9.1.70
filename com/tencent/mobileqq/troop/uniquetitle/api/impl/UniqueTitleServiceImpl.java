package com.tencent.mobileqq.troop.uniquetitle.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UniqueTitleServiceImpl implements IUniqueTitleService {
    static IPatchRedirector $redirector_ = null;
    protected static final String OLDEST_UNIQUE_TITLE_EXPIRE_TIME = "oldestUniqueTitleExpireTime";
    public static final String TAG = "UniqueTitleServiceImpl";
    protected AppRuntime mApp;

    public UniqueTitleServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService
    public long getOldestUniqueTitleExpireTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).longValue();
        }
        return this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + "_" + str, 0).getLong(OLDEST_UNIQUE_TITLE_EXPIRE_TIME, 0L);
    }

    @Override // com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService
    public int getUniqueTitleNewFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + "_troopManager", 0).getInt(IUniqueTitleService.UNIQUE_TITLE_NEW_FLAG, 0);
    }

    @Override // com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService
    public boolean hasUniqueTitleExpireNotified(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + "_" + str, 0).getBoolean(str2, false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService
    public void setOldestUniqueTitleExpireTime(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Long.valueOf(j3));
            return;
        }
        this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + "_" + str, 0).edit().putLong(OLDEST_UNIQUE_TITLE_EXPIRE_TIME, j3).commit();
    }

    @Override // com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService
    public void setUniqueTitleExpireNotified(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + "_" + str, 0).edit().putBoolean(str2, z16).commit();
    }

    @Override // com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService
    public void setUniqueTitleNewFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + "_troopManager", 0).edit().putInt(IUniqueTitleService.UNIQUE_TITLE_NEW_FLAG, i3).commit();
    }
}
