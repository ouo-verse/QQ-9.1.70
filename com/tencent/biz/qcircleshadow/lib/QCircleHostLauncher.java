package com.tencent.biz.qcircleshadow.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQTeenModeApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostLauncher {
    private static final String TAG = "QCircleHostLauncher";

    public static void doJumpAction(Context context, String str) {
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, str);
    }

    public static void forwardToMoodSelectLocation(Context context, String str, int i3, Bundle bundle) {
        QZoneHelper.forwardToMoodSelectLocation(context, str, i3, bundle);
    }

    public static Intent handleQCircleHybirdActivityIntent(Context context, String str, Intent intent, int i3) {
        return QCircleServiceImpl.getQQService().handleQCircleHybirdActivityIntent(context, str, intent, i3);
    }

    public static Intent handleTVideoAdHybirdActivityIntent(Context context, String str, Intent intent) {
        return QCircleServiceImpl.getQQService().handleTVideoAdHybirdActivityIntent(context, str, intent);
    }

    public static void isCameraResReady() {
        ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady();
    }

    public static void launchChannelPage(Context context, String str, boolean z16) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (z16) {
                activity.finish();
                activity.overridePendingTransition(0, R.anim.f154895t0);
            }
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openGuildByShareUrl(activity, str, "BUSINESS_QCIRCLE");
            return;
        }
        QLog.e(TAG, 1, "[launchChannelPage] -> !(hostContext instanceof Activity)");
    }

    public static void launchForwardGuildListFragment(Activity activity, Intent intent) {
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, 0);
    }

    public static void launchTeenModePage(Context context) {
        ((IQQTeenModeApi) QRoute.api(IQQTeenModeApi.class)).jumpToTeenModePage(context);
    }

    public static void preCameraEssentialRes() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher.1
            @Override // java.lang.Runnable
            public void run() {
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchAllEssentialBundles();
            }
        }, 16, null, false);
    }

    public static void reportDC02880(int i3, int i16, String str, String str2, String str3) {
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(2, 2, null, str2);
        lpReportInfo_dc02880.reserves6 = str3;
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, false, true);
    }

    public static void requestAd(Context context, VasRewardAdParams vasRewardAdParams, VasRewardAdCallback vasRewardAdCallback) {
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).requestAd((Activity) context, vasRewardAdParams, vasRewardAdCallback);
    }

    public static void setNewSsoAndRestartApp(String str) {
        QCircleServiceImpl.getQQService().setNewSsoAndRestartApp(str);
    }

    public static void startAddFriend(Context context, String str, String str2, boolean z16, boolean z17) {
        startAddFriend(context, 3, str, str2, z16, z17);
    }

    public static void startNewFriendList(Context context) {
        context.startActivity(((INewFriendApi) QRoute.api(INewFriendApi.class)).getStartNewFriendMoreSysMsgActivityIntent(context, 0));
    }

    public static void startProfileCardActivity(Context context, String str) {
        int i3;
        if (str.equals(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount())) {
            i3 = 0;
        } else {
            boolean isFriend = QCircleCommonUtil.isFriend(str);
            QLog.d(TAG, 1, "[startProfileCardActivity] uin=" + str + ", isFriend=" + isFriend);
            if (isFriend) {
                i3 = 1;
            } else {
                i3 = 115;
            }
        }
        IProfileCardApi iProfileCardApi = (IProfileCardApi) QRoute.api(IProfileCardApi.class);
        AllInOne allInOne = new AllInOne(str, i3);
        allInOne.profileEntryType = 128;
        allInOne.sourceID = 3050;
        allInOne.subSourceId = 1;
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 4);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 41);
        iProfileCardApi.openProfileCard(context, allInOne);
    }

    public static void startWithPublicFragmentActivity(Context context, Intent intent, Class cls) {
        QPublicFragmentActivity.start(context, intent, cls);
    }

    public static void startAddFriend(Context context, int i3, String str, String str2, boolean z16, boolean z17) {
        IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
        Intent startAddFriend = iAddFriendApi.startAddFriend(context, 1, String.valueOf(str), "", 3050, i3, str2, null, null, null, null);
        startAddFriend.putExtra("qcircle_isfollow", z16);
        startAddFriend.putExtra("key_qcircle_stick", z17);
        iAddFriendApi.launchAddFriend(context, startAddFriend);
    }

    public static void startAddFriend(Context context, String str, String str2, boolean z16, boolean z17, byte[] bArr) {
        IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
        Intent startAddFriend = iAddFriendApi.startAddFriend(context, 1, String.valueOf(str), "", 3050, 3, str2, bArr);
        startAddFriend.putExtra("qcircle_isfollow", z16);
        startAddFriend.putExtra("key_qcircle_stick", z17);
        iAddFriendApi.launchAddFriend(context, startAddFriend);
    }
}
