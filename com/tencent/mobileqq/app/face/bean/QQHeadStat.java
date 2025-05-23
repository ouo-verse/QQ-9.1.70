package com.tencent.mobileqq.app.face.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQHeadStat {
    static IPatchRedirector $redirector_;
    public long beginDownInfoTime;
    public long beginDownPicTime;
    public long costTime;
    public String downUrl;
    public long endDownInfoTime;
    public long endDownPicTime;
    public int headType;
    public int size;
    private long uin;

    public QQHeadStat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.beginDownInfoTime = 0L;
        this.endDownInfoTime = 0L;
        this.beginDownPicTime = 0L;
        this.endDownPicTime = 0L;
        this.downUrl = "";
    }
}
