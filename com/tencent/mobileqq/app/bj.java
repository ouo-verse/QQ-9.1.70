package com.tencent.mobileqq.app;

import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bj implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface {
    static IPatchRedirector $redirector_;

    public bj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
    public List<String> getRedPointPaths(AppRuntime appRuntime) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        if (appRuntime instanceof QQAppInterface) {
            ILebaHelperService iLebaHelperService = (ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI);
            if (iLebaHelperService != null && iLebaHelperService.isTableModel(appRuntime)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("150000");
                arrayList.add("150000.150100");
                return arrayList;
            }
            return null;
        }
        return null;
    }
}
