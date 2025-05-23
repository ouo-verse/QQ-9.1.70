package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.minorsmode.api.IMinorsModeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetConfirmFragment;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class StudyModeBaseFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    protected LinearLayout C;
    private FragmentActivity D;

    public StudyModeBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = null;
        }
    }

    private void th(StudyModeBaseFragment studyModeBaseFragment) {
        String str;
        if (studyModeBaseFragment instanceof StudyPwdSetFragment) {
            str = "0X800BD40";
        } else if (studyModeBaseFragment instanceof StudyPwdSetConfirmFragment) {
            str = "0X800BD43";
        } else if (((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).isStudyPwdVerifyFragment(studyModeBaseFragment)) {
            str = "0X800BD47";
        } else {
            return;
        }
        String str2 = str;
        ReportController.o(getAppRuntime(), "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        this.C = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView;
        this.D = getActivity();
        qh(layoutInflater, this.C);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (getQBaseActivity() != null) {
            return getQBaseActivity().getAppRuntime();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f169097hr3;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.D != null) {
            th(this);
            uh();
            this.D.finish();
        }
        super.onBackEvent();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (NetworkUtil.isNetworkAvailable()) {
            return true;
        }
        vh(null);
        return false;
    }

    protected abstract void qh(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return ThemeUtil.isNowThemeIsNight(getAppRuntime(), true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sh() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        boolean rh5 = rh();
        LinearLayout linearLayout = this.C;
        if (rh5) {
            i3 = -16777216;
        } else {
            i3 = -1;
        }
        linearLayout.setBackgroundColor(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        FragmentActivity fragmentActivity = this.D;
        if (fragmentActivity != null) {
            fragmentActivity.setResult(0, fragmentActivity.getIntent());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vh(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            QQToast.makeText(BaseApplication.getContext(), 0, getString(R.string.cgc), 0).show();
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
        }
    }
}
