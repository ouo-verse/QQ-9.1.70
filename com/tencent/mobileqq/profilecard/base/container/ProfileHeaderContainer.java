package com.tencent.mobileqq.profilecard.base.container;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;

/* loaded from: classes16.dex */
public class ProfileHeaderContainer extends AbsQQProfileContainer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileHeaderContainer";
    private long mCurStyleId;
    private long mCurTemplateVersion;
    private AbsProfileHeaderComponent mHeaderComponent;

    public ProfileHeaderContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    private boolean checkSwitchHeaderComponent(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && (this.mHeaderComponent == null || this.mCurStyleId != profileCardInfo.curUseStyleId || this.mCurTemplateVersion != profileCardInfo.curUseTemplateVersion)) {
            return true;
        }
        return false;
    }

    private void destroyHeaderComponent() {
        if (this.mHeaderComponent != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "destroyHeaderComponent");
            }
            removeComponent(this.mHeaderComponent);
            this.mHeaderComponent.detachFromComponentCenter();
            this.mHeaderComponent = null;
            this.mCurStyleId = 0L;
            this.mCurTemplateVersion = 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initHeaderComponent(ProfileCardInfo profileCardInfo) {
        if (this.mHeaderComponent == null) {
            AbsProfileHeaderComponent absProfileHeaderComponent = (AbsProfileHeaderComponent) ProfileUtils.create(1002, this.mComponentCenter, profileCardInfo, this.mDelegate);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("initHeaderComponent headerComponent=%s", absProfileHeaderComponent));
            }
            this.mHeaderComponent = absProfileHeaderComponent;
            absProfileHeaderComponent.setContainerView((FrameLayout) this.mViewContainer);
            this.mHeaderComponent.attachToComponentCenter();
            addComponent(this.mHeaderComponent);
            this.mCurStyleId = profileCardInfo.curUseStyleId;
            this.mCurTemplateVersion = profileCardInfo.curUseTemplateVersion;
        }
    }

    private void resetHeaderComponent(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo.curUseStyleId != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "resetHeaderComponent");
            }
            profileCardInfo.curUseStyleId = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
            profileCardInfo.curUseTemplateVersion = 0L;
            profileCardInfo.currentTemplate = null;
            initHeaderComponent(profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 102;
    }

    public AbsProfileHeaderComponent getHeaderComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsProfileHeaderComponent) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHeaderComponent;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            destroyHeaderComponent();
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        if (checkSwitchHeaderComponent(profileCardInfo)) {
            destroyHeaderComponent();
            z16 = true;
            try {
                initHeaderComponent(profileCardInfo);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onDataUpdate init header component fail, reset to default.", e16);
                destroyHeaderComponent();
                resetHeaderComponent(profileCardInfo);
                if (!AppSetting.isPublicVersion()) {
                    throw new RuntimeException(e16);
                }
            }
        } else {
            z16 = false;
        }
        return super.lambda$checkValidComponent$3((ProfileHeaderContainer) profileCardInfo) | z16;
    }
}
