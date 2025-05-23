package com.tencent.mobileqq.notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes8.dex */
public class TransparentNotificationFragment extends PublicBaseFragment {
    static IPatchRedirector $redirector_;

    public TransparentNotificationFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.initWindowStyleAndAnimation(activity);
            activity.getWindow().setSoftInputMode(3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            inflate = (View) iPatchRedirector.redirect((short) 6, this, layoutInflater, viewGroup, bundle);
        } else {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            inflate = layoutInflater.inflate(R.layout.ffp, (ViewGroup) null);
            QQAppInterface qQAppInterface = getBaseActivity().app;
            Intent intent = getBaseActivity().getIntent();
            boolean t16 = ForegroundNotifyManager.b(qQAppInterface).t();
            if (qQAppInterface.isBackgroundStop && t16) {
                z16 = true;
            } else {
                z16 = false;
            }
            String stringExtra = intent.getStringExtra("uin");
            int intExtra = intent.getIntExtra("uintype", 0);
            String stringExtra2 = intent.getStringExtra("uinname");
            intent.getIntExtra(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, 0);
            if (QLog.isColorLevel()) {
                QLog.d("TransparentNotificationFragment", 2, "onCreateView: invoked. ", " appBackground: ", Boolean.valueOf(z16), " app.isBackgroundStop: ", Boolean.valueOf(qQAppInterface.isBackgroundStop), " subProcessBackgroundStop: ", Boolean.valueOf(t16), " uin: ", stringExtra, " uinName: ", stringExtra2);
            }
            if (z16) {
                Intent aliasIntent = SplashActivity.getAliasIntent(qQAppInterface.getApp());
                aliasIntent.putExtra("uin", stringExtra);
                aliasIntent.putExtra("uintype", intExtra);
                aliasIntent.putExtra("uinname", stringExtra2);
                Intent m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
                m3.setAction("com.tencent.mobileqq.action.CHAT");
                getBaseActivity().startActivity(m3);
                getBaseActivity().finish();
            } else {
                l.Z(getBaseActivity(), stringExtra, intExtra, stringExtra2, new Bundle(), 0);
                getBaseActivity().finish();
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }
}
