package com.tencent.mobileqq.troop.navigatebar.network;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsgCollection;
import com.tencent.mobileqq.troop.navigatebar.f;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends a<List<TroopAioNavMsgCollection>> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f298007d;

    public b(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f298007d = appRuntime;
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.a
    protected boolean b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (i3 != f.f297997b && i3 != f.f297998c) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.a
    protected void c(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("PersonalTroopAioMsgNavServiceObserver", 2, "onError: code = " + i3 + ", msg = " + str);
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.e();
            this.f298007d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.navigatebar.network.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<TroopAioNavMsgCollection> a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, obj);
        }
        try {
            if (!(obj instanceof List)) {
                return null;
            }
            return (List) obj;
        } catch (ClassCastException e16) {
            if (QLog.isColorLevel()) {
                QLog.w("PersonalTroopAioMsgNavServiceObserver", 2, "castData error: ", e16);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.navigatebar.network.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(List<TroopAioNavMsgCollection> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        AppRuntime appRuntime = this.f298007d;
        if (appRuntime == null) {
            return;
        }
        ((ITroopAioMsgNavigateService) appRuntime.getRuntimeService(ITroopAioMsgNavigateService.class, "")).updateTroopNavMsgCollection(list);
    }
}
