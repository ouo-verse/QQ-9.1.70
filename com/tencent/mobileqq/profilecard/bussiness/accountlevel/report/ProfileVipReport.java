package com.tencent.mobileqq.profilecard.bussiness.accountlevel.report;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.mobilereport.MobileReportManager;

/* loaded from: classes16.dex */
public class ProfileVipReport {
    static IPatchRedirector $redirector_ = null;
    public static final String B_VIP_ITEM_ID = "bvip_icon";
    public static final String LEVEL_APPID = "bvip_privilege";
    public static final String LEVEL_GUEST_PAGE_ID = "guess_data_card";
    public static final String LEVEL_HOST_PAGE_ID = "my_data_card";
    public static final String LEVEL_ITEM_ID = "qlevel_chtb";
    public static final String LEVEL_MODULE_ID = "level_info";
    public static final String LOVE_YELLOW_ITEM_ID = "qlhz_icon";
    public static final String S_VIP_ITEM_ID = "svip_icon";
    public static final String VIP_ICON_MODULE_ID = "vip_icon";
    public static final String YELLOW_ICON_ITEM_ID = "hz_icon";

    public ProfileVipReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getItemId(int i3) {
        if (i3 != 1) {
            if (i3 != 102) {
                if (i3 != 104) {
                    if (i3 != 113) {
                        return "";
                    }
                    return B_VIP_ITEM_ID;
                }
                return LOVE_YELLOW_ITEM_ID;
            }
            return YELLOW_ICON_ITEM_ID;
        }
        return S_VIP_ITEM_ID;
    }

    public static void reportDiamond(ProfileCardInfo profileCardInfo, int i3, boolean z16) {
        AllInOne allInOne;
        boolean z17;
        String str;
        int i16;
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null) {
            if (allInOne.f260789pa == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            String itemId = getItemId(i3);
            if (TextUtils.isEmpty(itemId)) {
                return;
            }
            MobileReportManager mobileReportManager = MobileReportManager.getInstance();
            if (z17) {
                str = LEVEL_HOST_PAGE_ID;
            } else {
                str = LEVEL_GUEST_PAGE_ID;
            }
            String str2 = str;
            if (z16) {
                i16 = 102;
            } else {
                i16 = 101;
            }
            mobileReportManager.reportAction(itemId, "4", LEVEL_APPID, str2, VIP_ICON_MODULE_ID, i16, 0, System.currentTimeMillis());
        }
    }

    public static void reportDiamondItem(ProfileCardInfo profileCardInfo, boolean z16) {
        AllInOne allInOne;
        boolean z17;
        String str;
        int i3;
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null) {
            if (allInOne.f260789pa == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            MobileReportManager mobileReportManager = MobileReportManager.getInstance();
            if (z17) {
                str = LEVEL_HOST_PAGE_ID;
            } else {
                str = LEVEL_GUEST_PAGE_ID;
            }
            String str2 = str;
            if (z16) {
                i3 = 124;
            } else {
                i3 = 111;
            }
            mobileReportManager.reportAction("", "", LEVEL_APPID, str2, VIP_ICON_MODULE_ID, i3, 0, System.currentTimeMillis());
        }
    }

    public static void reportLevelBadge(ProfileCardInfo profileCardInfo, boolean z16) {
        AllInOne allInOne;
        boolean z17;
        String str;
        int i3;
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null) {
            if (allInOne.f260789pa == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            MobileReportManager mobileReportManager = MobileReportManager.getInstance();
            if (z17) {
                str = LEVEL_HOST_PAGE_ID;
            } else {
                str = LEVEL_GUEST_PAGE_ID;
            }
            String str2 = str;
            if (z16) {
                i3 = 102;
            } else {
                i3 = 101;
            }
            mobileReportManager.reportAction(LEVEL_ITEM_ID, "4", LEVEL_APPID, str2, LEVEL_MODULE_ID, i3, 0, System.currentTimeMillis());
        }
    }

    public static void reportLevelItem(ProfileCardInfo profileCardInfo, boolean z16) {
        AllInOne allInOne;
        boolean z17;
        String str;
        int i3;
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null) {
            if (allInOne.f260789pa == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            MobileReportManager mobileReportManager = MobileReportManager.getInstance();
            if (z17) {
                str = LEVEL_HOST_PAGE_ID;
            } else {
                str = LEVEL_GUEST_PAGE_ID;
            }
            String str2 = str;
            if (z16) {
                i3 = 124;
            } else {
                i3 = 111;
            }
            mobileReportManager.reportAction("", "", LEVEL_APPID, str2, LEVEL_MODULE_ID, i3, 0, System.currentTimeMillis());
        }
    }
}
