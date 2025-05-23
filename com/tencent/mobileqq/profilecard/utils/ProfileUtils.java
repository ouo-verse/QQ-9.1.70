package com.tencent.mobileqq.profilecard.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileComponentApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileUtils {
    static IPatchRedirector $redirector_ = null;
    static final long CLICK_INTERVAL_MS = 500;
    private static final String TAG = "ProfileUtils";

    public ProfileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AbsProfileComponent create(int i3, IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate) {
        return ((IProfileComponentApi) QRoute.api(IProfileComponentApi.class)).create(i3, iComponentCenter, profileCardInfo, iProfileActivityDelegate);
    }

    public static String formatPraiseNum(int i3) {
        if (i3 >= 1 && i3 < 10000) {
            return String.valueOf(i3);
        }
        if (i3 >= 10000 && i3 < 100000000) {
            if (i3 % 10000 < 500) {
                return (i3 / 10000) + "\u4e07";
            }
            return ((Math.round(((i3 * 1.0f) / 10000.0f) * 10.0f) * 1.0f) / 10.0f) + "\u4e07";
        }
        if (i3 >= 100000000) {
            if (i3 % 100000000 < 5000000) {
                return (i3 / 100000000) + "\u4ebf";
            }
            return ((Math.round(((i3 * 1.0f) / 1.0E8f) * 10.0f) * 1.0f) / 10.0f) + "\u4ebf";
        }
        return "";
    }

    public static ProfileContactInfo getCardContactInfo(AllInOne allInOne) {
        ArrayList<ProfileContactInfo> arrayList;
        if (allInOne != null && (arrayList = allInOne.contactArray) != null && !arrayList.isEmpty()) {
            return allInOne.contactArray.get(0);
        }
        return null;
    }

    public static long getControl(AllInOne allInOne, boolean z16) {
        long j3;
        if (ProfilePAUtils.isPaTypeShowAccount(allInOne)) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        long j16 = j3 | 4 | 65536;
        if (ProfilePAUtils.isPaTypeHasUin(allInOne)) {
            j16 |= 8;
        }
        long j17 = j16 | 512 | 16 | 32 | 1024 | 2048;
        if (z16 && ProfilePAUtils.isPaTypeFriend(allInOne)) {
            return j17 | 8192;
        }
        return j17;
    }

    public static Intent getIntent(Context context, AllInOne allInOne) {
        return ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntent(context, allInOne);
    }

    public static String getMobileNumberWithNationCode(AllInOne allInOne) {
        String str;
        ProfileContactInfo cardContactInfo = getCardContactInfo(allInOne);
        if (cardContactInfo != null) {
            str = cardContactInfo.phoneNationalCode + cardContactInfo.phoneNumber;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return allInOne.uin;
        }
        return str;
    }

    public static long getTroopCode(AppInterface appInterface, AllInOne allInOne) {
        String str;
        try {
            if (appInterface != null && allInOne != null) {
                if (!TextUtils.isEmpty(allInOne.troopCode)) {
                    str = allInOne.troopCode;
                } else if (!TextUtils.isEmpty(allInOne.troopUin)) {
                    str = ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(allInOne.troopUin);
                }
                return Long.parseLong(str);
            }
            return Long.parseLong(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getTroopCode fail.", e16);
            return 0L;
        }
        str = "0";
    }

    public static boolean isFriend(AppInterface appInterface, String str) {
        return ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFriend(str);
    }

    public static boolean isValidClick(long j3, long j16) {
        if (Math.abs(j16 - j3) > 1500) {
            return true;
        }
        return false;
    }

    public static boolean isVisible(View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.intersect(new Rect(0, 0, ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight()));
    }

    public static void openProfileCard(Context context, AllInOne allInOne) {
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).openProfileCard(context, allInOne);
    }

    public static void openProfileCardForResult(Activity activity, AllInOne allInOne, int i3) {
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).openProfileCardForResult(activity, allInOne, i3);
    }

    public static void setViewClickInterval(View view) {
        if (view == null) {
            return;
        }
        view.setClickable(false);
        view.postDelayed(new Runnable(view) { // from class: com.tencent.mobileqq.profilecard.utils.ProfileUtils.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View val$view;

            {
                this.val$view = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                View view2 = this.val$view;
                if (view2 != null) {
                    view2.setClickable(true);
                }
            }
        }, 500L);
    }

    public static void openProfileCard(Context context, AllInOne allInOne, boolean z16) {
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).openProfileCard(context, allInOne, z16);
    }
}
