package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bm implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f195410a;

    public bm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f195410a = new ArrayList();
        }
    }

    @Override // com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
    public List<String> getRedPointPaths(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        if ((appRuntime instanceof QQAppInterface) && !this.f195410a.isEmpty()) {
            return this.f195410a;
        }
        return null;
    }
}
