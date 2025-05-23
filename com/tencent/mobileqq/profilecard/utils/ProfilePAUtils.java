package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfilePAUtils {
    static IPatchRedirector $redirector_;

    public ProfilePAUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isFromDiscussion(int i3) {
        if (i3 != 45 && i3 != 46 && i3 != 47) {
            return false;
        }
        return true;
    }

    public static boolean isFromExtendFriend(AllInOne allInOne) {
        if (allInOne == null || allInOne.f260789pa != 96) {
            return false;
        }
        return true;
    }

    public static boolean isFromGuild(int i3) {
        return false;
    }

    public static boolean isFromTroopMemberCard(int i3) {
        if (i3 != 20 && i3 != 21 && i3 != 22) {
            return false;
        }
        return true;
    }

    public static boolean isFromWholePeopleVote(AllInOne allInOne) {
        if (allInOne == null || allInOne.f260789pa != 95) {
            return false;
        }
        return true;
    }

    public static boolean isNotShowPresent(AllInOne allInOne) {
        int i3 = allInOne.f260789pa;
        if (i3 != 22 && i3 != 23 && i3 != 24 && i3 != 120) {
            return false;
        }
        return true;
    }

    public static boolean isPaTypeCanAddAsFriend(AllInOne allInOne) {
        int i3 = allInOne.f260789pa;
        if (i3 == 0 || i3 == 33 || i3 == 28 || i3 == 108 || isPaTypeFriend(allInOne) || allInOne.f260789pa == 80) {
            return false;
        }
        return true;
    }

    public static boolean isPaTypeCanFreeCall(AllInOne allInOne) {
        if (isPaTypeFriend(allInOne)) {
            return true;
        }
        int i3 = allInOne.f260789pa;
        if (i3 == 29) {
            return false;
        }
        if (i3 != 21 && i3 != 22 && i3 != 46 && i3 != 47) {
            if (i3 == 31) {
                if (allInOne.sourceID != 3001) {
                    return true;
                }
                return false;
            }
            if (i3 == 34 || i3 == 50 || i3 == 71 || i3 == 72 || i3 == 80) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean isPaTypeCanTalk(AllInOne allInOne) {
        if (isPaTypeFriend(allInOne) || isPaTypeTempTalk(allInOne)) {
            return true;
        }
        int i3 = allInOne.f260789pa;
        if (i3 == 29) {
            return false;
        }
        if (i3 != 41 && i3 != 21 && i3 != 58) {
            if (i3 == 3) {
                if (allInOne.chatAbility != 0) {
                    return true;
                }
                return false;
            }
            if (i3 == 31) {
                if (allInOne.sourceID != 3001) {
                    return true;
                }
                return false;
            }
            if (i3 == 34 || i3 == 50 || i3 == 46 || i3 == 56 || i3 == 71 || i3 == 70) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean isPaTypeFriend(AllInOne allInOne) {
        int i3 = allInOne.f260789pa;
        if (i3 == 30 || i3 == 40 || i3 == 20 || i3 == 1 || i3 == 60 || i3 == 55 || i3 == 45 || i3 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPaTypeHasUin(AllInOne allInOne) {
        if (isPaTypeStrangerInContact(allInOne)) {
            return false;
        }
        return true;
    }

    public static boolean isPaTypeShowAccount(AllInOne allInOne) {
        int i3;
        if (isPaTypeStrangerInContact(allInOne) || (i3 = allInOne.f260789pa) == 41 || i3 == 42 || i3 == 86 || i3 == 4 || i3 == 52 || i3 == 56 || i3 == 57 || i3 == 71 || i3 == 72 || i3 == 58 || i3 == 80) {
            return false;
        }
        return true;
    }

    public static boolean isPaTypeStrangerInContact(AllInOne allInOne) {
        if (allInOne != null) {
            int i3 = allInOne.f260789pa;
            if (i3 == 33 || i3 == 32 || i3 == 31 || i3 == 34 || i3 == 50 || i3 == 51 || i3 == 53 || i3 == 29 || i3 == 36) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isPaTypeTempTalk(AllInOne allInOne) {
        int i3 = allInOne.f260789pa;
        if (i3 != 22 && i3 != 42 && i3 != 2 && i3 != 34 && i3 != 47 && i3 != 57 && i3 != 72 && i3 != 27 && i3 != 74 && i3 != 86) {
            return false;
        }
        return true;
    }
}
