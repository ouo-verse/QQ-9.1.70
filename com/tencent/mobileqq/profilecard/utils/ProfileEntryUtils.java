package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileEntryUtils {
    static IPatchRedirector $redirector_;

    public ProfileEntryUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getIdentityFlag(AllInOne allInOne) {
        if (allInOne.f260789pa == 0) {
            return 2;
        }
        if (ProfilePAUtils.isPaTypeFriend(allInOne)) {
            return 0;
        }
        return 1;
    }

    public static int getProfileEntryType(int i3) {
        if (i3 != 1) {
            if (i3 < 4 || i3 > 21) {
                if ((i3 < 30 || i3 > 37) && i3 != 57 && i3 != 59) {
                    if (i3 < 60 || i3 > 61) {
                        if ((i3 < 64 || i3 > 68) && i3 != 84) {
                            if ((i3 < 87 || i3 > 88) && i3 != 98 && i3 != 129) {
                                return 999;
                            }
                            return i3;
                        }
                        return i3;
                    }
                    return i3;
                }
                return i3;
            }
            return i3;
        }
        return i3;
    }

    public static boolean isFromDating(int i3) {
        switch (i3) {
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                return true;
            case 12:
            case 14:
            case 16:
            default:
                return false;
        }
    }

    public static boolean isFromFreshNews(int i3) {
        if (i3 != 32 && i3 != 34 && i3 != 35) {
            return false;
        }
        return true;
    }

    public static boolean isFromHotChat(int i3) {
        if (i3 != 20 && i3 != 31 && i3 != 33) {
            return false;
        }
        return true;
    }
}
