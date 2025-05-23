package com.tencent.mobileqq.profilecard.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profilecard.api.IProfileGuideApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.state.data.SquareJSConst;

/* loaded from: classes16.dex */
public class ProfileGuideApiImpl implements IProfileGuideApi {
    static IPatchRedirector $redirector_;

    public ProfileGuideApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGuideApi
    public void jumpLabelEdit(IComponentCenter iComponentCenter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iComponentCenter);
            return;
        }
        IComponent component = iComponentCenter.getComponent(1010);
        if (component instanceof ProfilePersonalityLabelComponent) {
            Object containerView = component.getContainerView();
            if (containerView instanceof ProfileCardFavorShowView) {
                View viewInContainer = ((ProfileCardFavorShowView) containerView).getViewInContainer(0);
                if (viewInContainer instanceof PersonalityLabelBoard) {
                    ((PersonalityLabelBoard) viewInContainer).g(false);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGuideApi
    public void jumpPhotoEdit(Activity activity, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, str, Boolean.valueOf(z16));
        } else {
            PhotoWallView.jumpToPhotoWall(activity, str, z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGuideApi
    public void jumpProfileEdit(AppInterface appInterface, Activity activity, ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, activity, profileCardInfo);
        } else {
            ProfileCardUtils.openProfileEdit(appInterface, activity, profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGuideApi
    public void jumpProfileEditWithData(AppInterface appInterface, Activity activity, ProfileCardInfo profileCardInfo, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, activity, profileCardInfo, bundle);
        } else {
            ProfileCardUtils.openProfileEditWithData(appInterface, activity, profileCardInfo, bundle);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGuideApi
    public void jumpSignEdit(Activity activity, ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) profileCardInfo);
            return;
        }
        RichStatus richStatus = RichStatusUtils.INSTANCE.getRichStatus(profileCardInfo.card);
        Intent intent = new Intent();
        intent.putExtra(SquareJSConst.Params.PARAMS_RICH_STATUS, richStatus);
        intent.putExtra("public_fragment_class", "com.tencent.mobileqq.signature.SignTextEditFragment");
        intent.setClass(activity, QPublicFragmentActivity.class);
        activity.startActivityForResult(intent, -1);
    }
}
