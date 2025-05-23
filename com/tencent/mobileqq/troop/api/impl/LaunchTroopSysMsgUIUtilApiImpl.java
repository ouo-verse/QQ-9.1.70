package com.tencent.mobileqq.troop.api.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListFragment;
import com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.studymode.api.IStudyModeApi;

/* compiled from: P */
/* loaded from: classes19.dex */
public class LaunchTroopSysMsgUIUtilApiImpl implements ILaunchTroopSysMsgUIUtilApi {
    static IPatchRedirector $redirector_ = null;
    private static final String EXP_GRP_NOTICE_RCMD_PROCESS = "exp_group_notice_recommend_v2";
    private static final String EXP_GRP_NOTICE_RCMD_PROCESS_B = "exp_group_notice_recommend_v2_B";
    private static final String TAG = "LaunchTroopSysMsgUIUtil";

    public LaunchTroopSysMsgUIUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean jumpWithRcmdNotificationPage() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(EXP_GRP_NOTICE_RCMD_PROCESS);
        expEntity.reportExpExposure();
        return expEntity.isExperiment(EXP_GRP_NOTICE_RCMD_PROCESS_B);
    }

    @Override // com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi
    public String getFragmentNameForLaunch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TroopNotificationListFragment.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi
    public void launchTroopNotificationFragment(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            launchTroopNotificationFragment(intent, false, true);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi
    public void launchTroopNotificationWithRcmdFragment(Intent intent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
            QLog.i(TAG, 1, "[launchTroopNotificationWithRcmdFragment] isStudyMode");
            launchTroopNotificationFragment(intent);
            return;
        }
        if (!jumpWithRcmdNotificationPage()) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.i(TAG, 1, "[launchTroopNotificationWithRcmdFragment] jumpNewPage:" + z16);
        if (!z16) {
            launchTroopNotificationFragment(intent);
            return;
        }
        if (AppSetting.t(BaseApplication.getContext())) {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            com.tencent.mobileqq.pad.i.e(BaseApplication.getContext(), bundle, TroopNotificationWithRecommendFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.singleTask).a());
            return;
        }
        QPublicFragmentActivity.b.d(intent, QPublicFragmentActivity.class, TroopNotificationWithRecommendFragment.class);
    }

    @Override // com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi
    public void launchTroopNotificationFragment(Intent intent, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, intent, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (AppSetting.t(BaseApplication.getContext())) {
            Bundle bundle = new Bundle();
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            com.tencent.mobileqq.pad.i.e(BaseApplication.getContext(), bundle, TroopNotificationListFragment.class, new com.tencent.mobileqq.pad.b().e(z16).g(z17).h(LaunchMode.singleTop).a());
            return;
        }
        QPublicFragmentActivity.b.d(intent, QPublicFragmentActivity.class, TroopNotificationListFragment.class);
    }
}
