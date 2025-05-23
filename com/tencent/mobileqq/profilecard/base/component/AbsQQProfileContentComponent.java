package com.tencent.mobileqq.profilecard.base.component;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public abstract class AbsQQProfileContentComponent extends AbsProfileContentComponent {
    static IPatchRedirector $redirector_ = null;
    public static final String QQ_PROFILE_CARD_PERFORMANCE_OPTIMISATION_SWITCH = "qq_profilecard_performance_optimisation_switch";

    @Deprecated
    protected QQAppInterface mQQAppInterface;

    public AbsQQProfileContentComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public abstract String getProfileContentKey();

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
            this.mQQAppInterface = (QQAppInterface) this.mApp;
        }
    }
}
