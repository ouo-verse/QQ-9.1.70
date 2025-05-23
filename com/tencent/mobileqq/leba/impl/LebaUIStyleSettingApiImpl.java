package com.tencent.mobileqq.leba.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.ILebaUIStyleSettingApi;
import com.tencent.mobileqq.leba.core.f;
import com.tencent.mobileqq.leba.fragment.QZoneModeSettingFragment;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaUIStyleSettingApiImpl implements ILebaUIStyleSettingApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LebaUIStyleSettingApiImpl";

    public LebaUIStyleSettingApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void openStyleSettingInPad(Activity activity) {
        i.e(activity, new Bundle(), QZoneModeSettingFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
    }

    @Override // com.tencent.mobileqq.leba.ILebaUIStyleSettingApi
    public boolean checkModeSupportQzoneFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        int e16 = LebaPluginLogic.e();
        if (e16 != 0 && e16 != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.leba.ILebaUIStyleSettingApi
    public int getLebaStyleUserSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int p16 = f.p(MobileQQ.sMobileQQ.peekAppRuntime(), LebaPluginLogic.e());
        QLog.d(TAG, 4, "getLebaStyleUserSetting: " + p16);
        return p16;
    }

    @Override // com.tencent.mobileqq.leba.ILebaUIStyleSettingApi
    public void openStyleSetting(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity);
            return;
        }
        if (qBaseActivity == null) {
            return;
        }
        if (AppSetting.t(qBaseActivity.getActivity())) {
            openStyleSettingInPad(qBaseActivity.getActivity());
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicTransFragmentActivity.start(qBaseActivity, intent, QZoneModeSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.leba.ILebaUIStyleSettingApi
    public void setFrameFragment(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) frameFragment);
        } else {
            com.tencent.mobileqq.leba.controller.a.f240329a.c(frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaUIStyleSettingApi
    public void setLebaStyleUserSetting(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (!f.a(i3) || getLebaStyleUserSetting() == i3) {
            return;
        }
        int e16 = LebaPluginLogic.e();
        AtomicBoolean atomicBoolean = LebaPluginLogic.f240659b.get(Integer.valueOf(e16));
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        LebaPluginLogic.A(e16, i3);
        LebaPluginLogic.B(peekAppRuntime, e16, i3);
    }

    @Override // com.tencent.mobileqq.leba.ILebaUIStyleSettingApi
    public void setNeedShowQZoneFrame(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            com.tencent.mobileqq.leba.controller.a.f240329a.d(z16);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaUIStyleSettingApi
    public void setQZoneFrameClass(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            com.tencent.mobileqq.leba.controller.a.f240329a.e(str);
        }
    }
}
