package com.tencent.mobileqq.fts.data.troop;

import com.tencent.mobileqq.fts.v1.FTSOptSync;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FTSNewTroopSync extends FTSOptSync {
    static IPatchRedirector $redirector_;
    public long mMemberUin;
    public long mTroopUin;

    public FTSNewTroopSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("mOpt=");
        stringBuffer.append(this.mOpt);
        stringBuffer.append(" mTroopUin=");
        stringBuffer.append(this.mTroopUin);
        stringBuffer.append(" mMemberUin=");
        stringBuffer.append(this.mMemberUin);
        return stringBuffer.toString();
    }

    public FTSTroopSync transTroopSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FTSTroopSync) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new FTSTroopSync(this.mOpt, this.mTroopUin, this.mMemberUin);
    }

    public FTSNewTroopSync(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.mOpt = i3;
            this.mTroopUin = j3;
        }
    }

    public FTSNewTroopSync(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.mOpt = i3;
        this.mTroopUin = j3;
        this.mMemberUin = j16;
    }
}
