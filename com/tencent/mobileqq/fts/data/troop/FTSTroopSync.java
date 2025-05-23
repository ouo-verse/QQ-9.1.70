package com.tencent.mobileqq.fts.data.troop;

import com.tencent.mobileqq.fts.v1.FTSOptSync;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes12.dex */
public class FTSTroopSync extends FTSOptSync {
    static IPatchRedirector $redirector_ = null;
    public static final int OPT_CHECK_TIME_STAMP = 5;
    public static final int OPT_GET_MEMBER_LIST = 1;
    public static final int OPT_KICK_OUT_MEMBER = 2;
    public static final int OPT_MODIFY_MEMBER_CARD = 3;
    public static final int OPT_MODIFY_MEMBER_CARD_WITH_INFO = 6;
    public static final int OPT_QUIT_TROOP = 4;
    public String callFrom;
    public String friendNick;
    public long mMemberUin;
    public long mTroopUin;
    public String memberUid;
    public String troopNick;

    public FTSTroopSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String debugPrintStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "mOpt:" + this.mOpt + ",mTroopUin:" + this.mTroopUin + ",mMemberUin:" + this.mMemberUin + ",from:" + this.callFrom + ",friendNick:" + this.friendNick + ",troopNick:" + this.troopNick + ",memberUid:" + this.memberUid;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
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

    public FTSTroopSync(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.mOpt = i3;
            this.mTroopUin = j3;
        }
    }

    public FTSTroopSync(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.mOpt = i3;
        this.mTroopUin = j3;
        this.mMemberUin = j16;
    }

    public FTSTroopSync(int i3, long j3, long j16, String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str, str2, str3, str4);
            return;
        }
        this.mOpt = i3;
        this.mTroopUin = j3;
        this.mMemberUin = j16;
        this.friendNick = str;
        this.troopNick = str2;
        this.memberUid = str3;
        this.callFrom = str4;
    }
}
