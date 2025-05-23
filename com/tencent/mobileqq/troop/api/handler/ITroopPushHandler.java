package com.tencent.mobileqq.troop.api.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes19.dex */
public interface ITroopPushHandler {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes19.dex */
    public static final class PushType {
        private static final /* synthetic */ PushType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PushType OFFLINE;
        public static final PushType ONLINE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42001);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            PushType pushType = new PushType("ONLINE", 0);
            ONLINE = pushType;
            PushType pushType2 = new PushType("OFFLINE", 1);
            OFFLINE = pushType2;
            $VALUES = new PushType[]{pushType, pushType2};
        }

        PushType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static PushType valueOf(String str) {
            return (PushType) Enum.valueOf(PushType.class, str);
        }

        public static PushType[] values() {
            return (PushType[]) $VALUES.clone();
        }
    }

    void I1(String str, int i3);

    void L1(String str, boolean z16);

    void Y1(String str, int i3, int i16);
}
