package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ImportantMsgInfo extends ShortcutBarInfo {
    static IPatchRedirector $redirector_;
    private long msgSeq;
    private long msgTime;
    private String sendUin;

    public ImportantMsgInfo() {
        super(0L, "", "", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.msgSeq = 0L;
            this.sendUin = "";
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo
    public long getMsgSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.msgSeq;
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 1;
    }

    public String getSendUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.sendUin;
    }

    public void setMsgSeq(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.msgSeq = j3;
        }
    }

    public void setMsgTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.msgTime = j3;
        }
    }

    public void setSendUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.sendUin = str;
        }
    }

    public ImportantMsgInfo(long j3, long j16, String str, String str2, String str3, long j17, int i3) {
        super(j17, str, str2, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, str3, Long.valueOf(j17), Integer.valueOf(i3));
            return;
        }
        this.msgSeq = j16;
        this.sendUin = str3;
        this.msgTime = j3;
    }
}
