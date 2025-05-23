package com.tencent.ams.adcore.mma.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Company {
    static IPatchRedirector $redirector_;
    public Config config;
    public Domain domain;
    public int encryptType;
    public String equalizer;
    public String name;
    public String separator;
    public Signature signature;
    public Switch sswitch;
    public boolean timeStampUseSecond;

    public Company() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.encryptType = 0;
        }
    }
}
