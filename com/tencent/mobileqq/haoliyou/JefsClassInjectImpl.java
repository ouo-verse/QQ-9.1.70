package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.bigbrother.a;
import com.tencent.mobileqq.bigbrother.c;
import com.tencent.mobileqq.download.unite.core.InstallMonitor;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.e;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JefsClassInjectImpl implements IJefsClassInjectInterface {
    static IPatchRedirector $redirector_;

    public JefsClassInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.haoliyou.IJefsClassInjectInterface
    public boolean isUserAllow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return PrivacyPolicyHelper.isUserAllow();
    }

    @Override // com.tencent.mobileqq.haoliyou.IJefsClassInjectInterface
    public void monitorInstallIntent(String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) intent);
        } else {
            InstallMonitor.e().f(str, intent);
        }
    }

    @Override // com.tencent.mobileqq.haoliyou.IJefsClassInjectInterface
    public void openThirdApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            e.a();
        }
    }

    @Override // com.tencent.mobileqq.haoliyou.IJefsClassInjectInterface
    public void sendCheckDownloadReq(Context context, String str, String str2, String str3, String str4, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, str, str2, str3, str4, aVar);
        } else {
            CheckForwardManager.sendCheckDownloadReq(context, str, str2, str3, str4, aVar);
        }
    }

    @Override // com.tencent.mobileqq.haoliyou.IJefsClassInjectInterface
    public void thirdAppIntercept(Context context, String str, String str2, String str3, String str4, String str5, List<ResolveInfo> list, String str6, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, str2, str3, str4, str5, list, str6, cVar);
        } else {
            CheckForwardManager.thirdAppIntercept(context, str, str2, str3, str4, str5, list, str6, cVar);
        }
    }
}
