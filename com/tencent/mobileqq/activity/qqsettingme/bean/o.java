package com.tencent.mobileqq.activity.qqsettingme.bean;

import MQQ.PayRuleCfg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public BusinessInfoCheckUpdate.AppInfo f184935a;

    /* renamed from: b, reason: collision with root package name */
    public String f184936b;

    /* renamed from: c, reason: collision with root package name */
    public String f184937c;

    /* renamed from: d, reason: collision with root package name */
    public PayRuleCfg f184938d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f184939e;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184935a = new BusinessInfoCheckUpdate.AppInfo();
            this.f184936b = "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1";
        }
    }
}
