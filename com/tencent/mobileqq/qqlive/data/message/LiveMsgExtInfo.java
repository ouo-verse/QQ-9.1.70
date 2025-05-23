package com.tencent.mobileqq.qqlive.data.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveMsgExtInfo {
    static IPatchRedirector $redirector_;
    public MsgSpeed msgSpeed;
    public int msgType;
    public long msgUid;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class MsgSpeed {
        private static final /* synthetic */ MsgSpeed[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final MsgSpeed CONST;
        public static final MsgSpeed NON_CONST;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56696);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            MsgSpeed msgSpeed = new MsgSpeed("CONST", 0);
            CONST = msgSpeed;
            MsgSpeed msgSpeed2 = new MsgSpeed("NON_CONST", 1);
            NON_CONST = msgSpeed2;
            $VALUES = new MsgSpeed[]{msgSpeed, msgSpeed2};
        }

        MsgSpeed(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static MsgSpeed valueOf(String str) {
            return (MsgSpeed) Enum.valueOf(MsgSpeed.class, str);
        }

        public static MsgSpeed[] values() {
            return (MsgSpeed[]) $VALUES.clone();
        }
    }

    public LiveMsgExtInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MsgExtInfo{msgType=" + this.msgType + ", msgUid=" + this.msgUid + ", msgSpeed=" + this.msgSpeed + '}';
    }
}
