package com.tencent.mobileqq.Doraemon.impl;

import android.os.Bundle;
import com.tencent.biz.qqstory.base.StoryBoss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.IDoraemonApi;
import com.tencent.mobileqq.miniapp.d;
import com.tencent.mobileqq.miniapp.e;
import com.tencent.mobileqq.miniapp.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Bosses;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DoraemonApiImpl implements IDoraemonApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DoraemonApiImpl";

    public DoraemonApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonApi
    public void bindService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.biz.troop.b.A().p();
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonApi
    public d getAppInfo(String str, int i3, int i16, boolean z16, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? g.m().j(str, i3, i16, z16, eVar) : (d) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), eVar);
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonApi
    public Bundle getUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return com.tencent.mobileqq.Doraemon.impl.commonModule.d.g();
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonApi
    public void initBosses() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            Bosses.initWithBoss(BaseApplicationImpl.getApplication(), new StoryBoss(BaseApplicationImpl.getApplication()));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initBosses error!", th5);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonApi
    public boolean isLogin(com.tencent.mobileqq.Doraemon.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) eVar)).booleanValue();
        }
        if (eVar instanceof com.tencent.mobileqq.Doraemon.impl.commonModule.d) {
            return ((com.tencent.mobileqq.Doraemon.impl.commonModule.d) eVar).h();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonApi
    public void putAppInfo(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        } else {
            g.m().r(dVar);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonApi
    public void unbindService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            com.tencent.biz.troop.b.A().q();
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonApi
    public d getAppInfo(String str, int i3, int i16, boolean z16, e eVar, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? g.m().k(str, i3, i16, z16, eVar, i17) : (d) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), eVar, Integer.valueOf(i17));
    }
}
