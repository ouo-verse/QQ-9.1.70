package com.tencent.mobileqq.activity.qqsettingme.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public BusinessInfoCheckUpdate.AppInfo f184924a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f184925b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f184926c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f184927d;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
