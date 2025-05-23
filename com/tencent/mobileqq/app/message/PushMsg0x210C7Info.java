package com.tencent.mobileqq.app.message;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

/* loaded from: classes11.dex */
public class PushMsg0x210C7Info {
    static IPatchRedirector $redirector_;
    public static final HashSet<PushMsg0x210C7Info> PLAYING_MAP;
    public long fromUin;
    public long msgSeq;
    public int msgTime;
    public int msgType;
    public long msgUid;
    public boolean onlinePush;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            PLAYING_MAP = new HashSet<>();
        }
    }

    public PushMsg0x210C7Info(long j3, long j16, long j17, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.fromUin = j3;
        this.msgSeq = j16;
        this.msgUid = j17;
        this.msgType = i3;
        this.msgTime = i16;
        this.onlinePush = z16;
    }

    public static boolean hasPushedMsg(PushMsg0x210C7Info pushMsg0x210C7Info) {
        boolean z16;
        HashSet<PushMsg0x210C7Info> hashSet = PLAYING_MAP;
        if (hashSet.contains(pushMsg0x210C7Info)) {
            z16 = true;
        } else {
            hashSet.add(pushMsg0x210C7Info);
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PushMsg0x210_c7Info", 2, "hasPushedMsg hasMsg=" + z16);
        }
        return z16;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PushMsg0x210_c7Info{fromUin:" + this.fromUin + ", msgSeq:" + this.msgSeq + ", msgTime:" + this.msgTime + ", onlinePush:" + this.onlinePush + ", }";
    }
}
