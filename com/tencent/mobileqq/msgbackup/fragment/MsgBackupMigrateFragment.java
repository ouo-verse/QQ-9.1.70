package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.qui.quisecnavbar.e;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msgbackup.util.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.c;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupMigrateFragment extends MsgBackupBaseFragment {
    static IPatchRedirector $redirector_;

    public MsgBackupMigrateFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void Gh() {
        View view;
        boolean z16;
        View view2;
        if (!needBlur() || this.quiSecNavBar == null || (view = ((QIphoneTitleBarFragment) this).mContentView) == null) {
            return;
        }
        boolean z17 = false;
        ((QIphoneTitleBarFragment) this).mContentView.setPadding(0, e.b(view.getContext()), 0, 0);
        if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (c.f363628c.b(BaseApplication.context) && z16) {
            z17 = true;
        }
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (z17) {
            view2 = ((QIphoneTitleBarFragment) this).mContentView;
        } else {
            view2 = null;
        }
        qUISecNavBar.setBlur(z17, view2);
        if (!z16) {
            return;
        }
        if (z17) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable @android.support.annotation.Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
        } else {
            super.doOnCreateView(layoutInflater, viewGroup, bundle);
            Gh();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 10012) {
            boolean z16 = true;
            if (message.arg1 != 1) {
                z16 = false;
            }
            Button button = this.J;
            if (button != null) {
                button.setEnabled(z16);
            }
            if (!z16) {
                if (this.L != null && !isDetached()) {
                    this.L.setTextColor(getResources().getColor(R.color.amk));
                    this.L.setText(getActivity().getString(R.string.ijg));
                }
                if (this.M != null && !isDetached()) {
                    this.M.setText(getActivity().getString(R.string.ik8));
                }
            } else {
                if (this.L != null && !isDetached()) {
                    this.L.setTextColor(getResources().getColor(R.color.skin_black));
                    this.L.setText(getActivity().getString(R.string.ijh));
                }
                if (this.M != null && !isDetached()) {
                    this.M.setText(getActivity().getString(R.string.ik9));
                }
            }
        }
        return super.handleMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void initListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.initListener();
            this.J.setOnClickListener(this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        d.f("0X800A242", 1);
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ls9) {
            QPublicFragmentActivity.startForResult(getActivity(), (Class<? extends QPublicBaseFragment>) MsgBackupSelectionFragment.class, 1000);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupMigrateFragment", 2, "migrate_btn onclick");
            }
            d.e("0X800A230");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroyView();
        Runnable runnable = this.f251170b0;
        if (runnable != null) {
            this.X.removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onDetach();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.rh();
        this.J.setEnabled(true);
        this.J.setText(R.string.iis);
        if (AppSetting.f99565y) {
            this.J.setContentDescription(getString(R.string.iis));
        }
        this.L.setText(getActivity().getString(R.string.ijh));
        this.F.setVisibility(0);
        this.X.post(this.f251170b0);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.xh();
            setTitle(getActivity().getString(R.string.ijj));
        }
    }
}
