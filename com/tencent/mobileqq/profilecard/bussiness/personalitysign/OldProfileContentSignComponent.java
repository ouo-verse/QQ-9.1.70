package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.TokenResUtils;

/* loaded from: classes16.dex */
public class OldProfileContentSignComponent extends ProfileContentSignComponent {
    static IPatchRedirector $redirector_;

    public OldProfileContentSignComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent
    public View initViewContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        View inflate = this.mActivity.getLayoutInflater().inflate(R.layout.b0p, (ViewGroup) null);
        inflate.findViewById(R.id.icon).setBackgroundResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_sign, R.drawable.qui_edit));
        return inflate;
    }
}
