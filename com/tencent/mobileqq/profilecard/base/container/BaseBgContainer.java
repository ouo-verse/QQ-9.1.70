package com.tencent.mobileqq.profilecard.base.container;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseBgContainer extends AbsProfileContainer<FrameLayout> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "BaseBgContainer";
    private String mCurBgUrl;
    private long mCurStyleId;
    private boolean mIsCurrentShowVasCustomBgCover;
    private boolean mIsCurrentShowZplanCover;

    public BaseBgContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.mIsCurrentShowZplanCover = false;
            this.mIsCurrentShowVasCustomBgCover = false;
        }
    }

    private boolean checkReloadChildComponent(ProfileCardInfo profileCardInfo) {
        String str;
        boolean z16 = false;
        if (profileCardInfo == null) {
            return false;
        }
        if (this.mCurStyleId != profileCardInfo.curUseStyleId) {
            z16 = true;
        }
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null && (this.mIsCurrentShowZplanCover != iProfileActivityDelegate.getIsShowZplanCover() || this.mIsCurrentShowVasCustomBgCover != this.mDelegate.isShowVasCustomBgCover())) {
            this.mIsCurrentShowZplanCover = this.mDelegate.getIsShowZplanCover();
            this.mIsCurrentShowVasCustomBgCover = this.mDelegate.isShowVasCustomBgCover();
            z16 = true;
        }
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null && iProfileActivityDelegate2.isForceRefreshDiyProfile()) {
            Card card = profileCardInfo.card;
            if (card != null) {
                str = card.backgroundUrl;
            } else {
                str = "";
            }
            if (profileCardInfo.curUseStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE && !TextUtils.equals(this.mCurBgUrl, str)) {
                return true;
            }
            return z16;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer
    public void destroyChildComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.destroyChildComponent();
            this.mCurStyleId = 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer
    protected View getChildComponentViewContainer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return (View) this.mViewContainer;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 104;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer
    public void initChildComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.initChildComponent();
        DATA data = this.mData;
        this.mCurStyleId = ((ProfileCardInfo) data).curUseStyleId;
        if (((ProfileCardInfo) data).card != null) {
            this.mCurBgUrl = ((ProfileCardInfo) data).card.backgroundUrl;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean onDataUpdate(ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        if (checkReloadChildComponent(profileCardInfo)) {
            destroyChildComponent();
            initChildComponent();
            z16 = true;
        } else {
            z16 = false;
        }
        return super.onDataUpdate((BaseBgContainer) profileCardInfo) | z16;
    }
}
