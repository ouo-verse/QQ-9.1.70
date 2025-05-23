package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActionLivenessHelper {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ActionType {
        private static final /* synthetic */ ActionType[] $VALUES;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14244);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                $VALUES = new ActionType[0];
            }
        }

        ActionType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ActionType valueOf(String str) {
            return (ActionType) Enum.valueOf(ActionType.class, str);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }
    }

    public ActionLivenessHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String makeActionStr(String[] strArr) {
        String str = "";
        for (int i3 = 0; i3 < strArr.length; i3++) {
            int parseInt = Integer.parseInt(strArr[i3]);
            if (parseInt != 0 && parseInt != 1) {
                if (parseInt != 2) {
                    if (parseInt != 3) {
                        if (parseInt != 4) {
                            if (parseInt == 5) {
                                str = str + "silence";
                            }
                        } else {
                            str = str + "shake";
                        }
                    } else {
                        str = str + "node";
                    }
                } else {
                    str = str + "mouth";
                }
            } else {
                str = str + "blink";
            }
            if (i3 != strArr.length - 1) {
                str = str + ",";
            }
        }
        return str;
    }
}
