package com.tencent.could.huiyansdk.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CustomerTokenEntity {
    static IPatchRedirector $redirector_;
    private long createTime;
    private String faceIdToken;
    private boolean isSuccess;

    public CustomerTokenEntity(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), str);
            return;
        }
        this.createTime = -1L;
        this.isSuccess = z16;
        this.faceIdToken = str;
        this.createTime = System.currentTimeMillis();
    }

    public long getCreateTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.createTime;
    }

    public String getFaceIdToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.faceIdToken;
    }

    public boolean isSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSuccess;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.isSuccess = false;
        this.faceIdToken = "";
        this.createTime = -1L;
    }

    public void updateTokenEntity(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
            return;
        }
        this.isSuccess = z16;
        this.faceIdToken = str;
        this.createTime = System.currentTimeMillis();
    }
}
