package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;
import mqq.app.MobileQQ;

@Deprecated
/* loaded from: classes9.dex */
public abstract class ProfileActivity extends BaseActivity implements AppConstants {
    static IPatchRedirector $redirector_;

    public ProfileActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void F2(Activity activity, String str, Intent intent) {
        Intent intent2;
        if (activity == null || TextUtils.isEmpty(str) || intent == null || (intent2 = activity.getIntent()) == null) {
            return;
        }
        int intExtra = intent2.getIntExtra("param_return_profilecard_pa", 19);
        AllInOne allInOne = new AllInOne(str, intExtra);
        if (ProfilePAUtils.isFromDiscussion(intExtra)) {
            allInOne.discussUin = intent2.getStringExtra("param_return_profilecard_discuss_uin");
        }
        if (ProfilePAUtils.isFromTroopMemberCard(intExtra)) {
            allInOne.troopUin = intent2.getStringExtra("param_return_profilecard_group_uin");
            intent.putExtra("troopUin", intent2.getStringExtra("param_return_profilecard_troop_uin"));
        }
        allInOne.subSourceId = intent2.getIntExtra("param_return_profilecard_subsourceid", 0);
        intent.putExtra("flc_extra_param", intent2.getBundleExtra("flc_extra_param"));
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        if (QLog.isColorLevel()) {
            QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "initProfileIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s, subSourceId:%s, extra:%s]", Integer.valueOf(intExtra), Utils.U(str), allInOne.troopUin, allInOne.discussUin, intent2.getStringExtra("param_return_profilecard_troop_uin"), Integer.valueOf(allInOne.subSourceId), intent2.getBundleExtra("flc_extra_param")));
        }
    }

    public static void G2(Activity activity, AllInOne allInOne, int i3) {
        if (activity != null) {
            try {
                Intent intent = ProfileUtils.getIntent(activity, allInOne);
                intent.putExtra(IProfileCardConst.KEY_FROM_EXTENDS_FRIENDS, true);
                intent.putExtra(IProfileCardConst.KEY_FROM_EXTENDS_FRIENDS_LIMIT_CHAT, false);
                intent.addFlags(536870912);
                activity.startActivityForResult(intent, i3);
            } catch (Exception e16) {
                QLog.e("ProfileActivity", 1, "openProfileCardForResultFromExtendFriend fail.", e16);
            }
        }
    }

    public static void H2(Context context, AllInOne allInOne, Bundle bundle) {
        if (context != null) {
            try {
                Intent intent = ProfileUtils.getIntent(context, allInOne);
                intent.addFlags(536870912);
                intent.addFlags(268435456);
                if (bundle != null) {
                    intent.putExtra(IProfileCardConst.KEY_PROFILE_EXTRA, bundle);
                }
                context.startActivity(intent);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("ProfileActivity", 2, e16.toString());
                }
            }
        }
    }

    private static void I2(Context context, AllInOne allInOne, Bundle bundle) {
        com.tencent.mobileqq.pad.i.e(context, ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardBundle(context, allInOne, bundle), ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardFragmentClass(), new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.singleTop).a());
    }

    public static void J2(Context context, AllInOne allInOne, Bundle bundle) {
        if (context == null) {
            return;
        }
        if (AppSetting.t(context) && bundle != null && !bundle.getBoolean(AppConstants.Key.KEY_BLOCK_SPLIT, false) && (context instanceof com.tencent.mobileqq.pad.l)) {
            I2(context, allInOne, bundle);
            return;
        }
        try {
            if (com.tencent.mobileqq.troop.utils.k.l(MobileQQ.sMobileQQ.peekAppRuntime(), allInOne.uin)) {
                com.tencent.mobileqq.troop.utils.k.o(context, "", allInOne.uin);
                return;
            }
            Intent intent = ProfileUtils.getIntent(context, allInOne);
            if (bundle != null && bundle.getBoolean("single_top", false)) {
                intent.addFlags(67108864);
            } else {
                intent.addFlags(536870912);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (bundle != null && bundle.getBoolean(AppConstants.Key.KEY_NEED_TRACK_BACK, false)) {
                intent.putExtra(AppConstants.Key.KEY_NEED_TRACK_BACK, true);
            }
            if (bundle != null) {
                intent.putExtra(IProfileCardConst.KEY_PROFILE_EXTRA, bundle);
            }
            context.startActivity(intent);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ProfileActivity", 2, e16.toString());
            }
        }
    }

    public static void K2(Activity activity, Intent intent, ProfileCardInfo profileCardInfo) {
        Intent intent2;
        if (activity == null || intent == null || profileCardInfo == null || profileCardInfo.allInOne == null || (intent2 = activity.getIntent()) == null) {
            return;
        }
        intent.putExtra("param_return_profilecard_pa", profileCardInfo.allInOne.f260789pa);
        intent.putExtra("param_return_profilecard_subsourceid", profileCardInfo.allInOne.subSourceId);
        if (ProfilePAUtils.isFromDiscussion(profileCardInfo.allInOne.f260789pa)) {
            intent.putExtra("param_return_profilecard_discuss_uin", profileCardInfo.allInOne.discussUin);
        }
        if (ProfilePAUtils.isFromTroopMemberCard(profileCardInfo.allInOne.f260789pa)) {
            intent.putExtra("param_return_profilecard_group_uin", profileCardInfo.allInOne.troopUin);
        }
        if (profileCardInfo.isTroopMemberCard) {
            intent.putExtra("param_return_profilecard_troop_uin", profileCardInfo.troopUin);
        }
        intent.putExtra("flc_extra_param", intent2.getBundleExtra("flc_extra_param"));
        if (QLog.isColorLevel()) {
            Locale locale = Locale.getDefault();
            AllInOne allInOne = profileCardInfo.allInOne;
            QLog.i("addFriendTag", 2, String.format(locale, "updateIntent  [pa: %s, uin:%s, troopUin:%s, discussUin:%s, troop:%s,  subSourceId:%s, extra:%s]", Integer.valueOf(profileCardInfo.allInOne.f260789pa), Utils.U(profileCardInfo.allInOne.uin), allInOne.troopUin, allInOne.discussUin, profileCardInfo.troopUin, Integer.valueOf(allInOne.subSourceId), intent2.getBundleExtra("flc_extra_param")));
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
