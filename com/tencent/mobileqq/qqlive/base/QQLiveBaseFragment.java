package com.tencent.mobileqq.qqlive.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.component.core.event.EventCenter;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveBaseFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    protected IQQLiveSDK C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements IQQLiveLoginCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveBaseFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                QQLiveBaseFragment.this.rh(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(LoginInfo loginInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginInfo);
            } else {
                QQLiveBaseFragment.this.sh();
            }
        }
    }

    public QQLiveBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        if (getQBaseActivity() != null) {
            intent = getQBaseActivity().getIntent();
        } else {
            intent = null;
        }
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        companion.f(companion.a(intent));
        super.onCreate(bundle);
        qh();
        xl3.a.b(getContext());
        EventCenter.init();
    }

    public IQQLiveSDK ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IQQLiveSDK) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.C;
    }

    protected void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (getQBaseActivity().getAppRuntime() == null) {
                QLog.e("QQLiveBaseFragment", 1, "the app runtime is null");
                return;
            }
            IQQLiveSDK c16 = com.tencent.mobileqq.qqlive.base.sdk.a.c(getQBaseActivity().getAppRuntime());
            this.C = c16;
            com.tencent.mobileqq.qqlive.base.sdk.a.b(c16, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rh(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStatusBarImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (getQBaseActivity() == null) {
            QLog.e("QQLiveBaseFragment", 1, "setStatusBarImmersive qBaseActivity is null");
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
    }

    protected void sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }
}
