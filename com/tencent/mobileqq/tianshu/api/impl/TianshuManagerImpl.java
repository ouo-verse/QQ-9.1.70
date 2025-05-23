package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.splashad.l;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TianshuManagerImpl implements ITianshuManager {
    static IPatchRedirector $redirector_;

    public TianshuManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianshuManager
    public boolean isBizExecuted(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (i3 != 1) {
            return false;
        }
        return l.l();
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianshuManager
    public void report(TianShuReportData tianShuReportData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tianShuReportData);
        } else {
            TianShuManager.getInstance().report(tianShuReportData);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianshuManager
    public void requestAdv(List<TianShuAdPosItemData> list, TianShuGetAdvCallback tianShuGetAdvCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) tianShuGetAdvCallback);
        } else {
            TianShuManager.getInstance().requestAdv(list, tianShuGetAdvCallback);
        }
    }
}
