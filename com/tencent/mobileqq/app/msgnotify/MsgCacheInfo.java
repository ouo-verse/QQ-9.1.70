package com.tencent.mobileqq.app.msgnotify;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MsgCacheInfo {
    static IPatchRedirector $redirector_;
    public String friendUin;
    public long msguid;
    public long shmsgseq;
    public int uinType;
    public long uniseq;

    public MsgCacheInfo(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        this.friendUin = str;
        this.uinType = i3;
        this.uniseq = j3;
        this.msguid = j16;
        this.shmsgseq = j17;
    }
}
