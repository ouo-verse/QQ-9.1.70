package com.tencent.mobileqq.profilecard.base.container;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseContentContainer extends AbsProfileContainer<ProfileContentView> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "BaseContentContainer";
    private boolean isBlackListForbid;
    private boolean isCheckBlackList;
    protected ProfileContentView.IContainerDividerCreator mContainerDividerCreator;
    protected ProfileContentView.IDividerCreator mDividerCreator;

    public BaseContentContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.isBlackListForbid = false;
        this.isCheckBlackList = false;
        initComponentDividerCreator();
        initContainerDividerCreator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkBlackListOnResume(final ProfileCardInfo profileCardInfo) {
        boolean isBlackOrBlackedUin = ((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).isBlackOrBlackedUin(((ProfileCardInfo) this.mData).allInOne.uin, new CheckBlacklistListener() { // from class: com.tencent.mobileqq.profilecard.base.container.f
            @Override // com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener
            public final void onResult(boolean z16) {
                BaseContentContainer.this.lambda$checkBlackListOnResume$1(profileCardInfo, z16);
            }
        });
        if (isBlackOrBlackedUin == this.isBlackListForbid) {
            return;
        }
        this.isBlackListForbid = isBlackOrBlackedUin;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "checkBlackListOnResume, isBlackList=" + isBlackOrBlackedUin);
        }
        lambda$checkBlackListOnResume$0(profileCardInfo);
    }

    private boolean checkContentValidBlackList(AbsProfileContentComponent absProfileContentComponent) {
        String profileContentKey = absProfileContentComponent.getProfileContentKey();
        for (String str : IProfileContentKey.KEY_MAP_BLACKLIST) {
            if (TextUtils.equals(profileContentKey, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkBlackListOnResume$1(final ProfileCardInfo profileCardInfo, boolean z16) {
        if (z16 != this.isBlackListForbid) {
            this.isBlackListForbid = z16;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "checkBlackListOnResume, isBlackList=" + z16);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseContentContainer.this.lambda$checkBlackListOnResume$0(profileCardInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkValidComponent$2(AbsProfileContentComponent absProfileContentComponent, boolean z16) {
        absProfileContentComponent.onBlacklistConfigureChange(!z16, this.isBlackListForbid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkValidComponent$4(final AbsProfileContentComponent absProfileContentComponent, final ProfileCardInfo profileCardInfo, boolean z16) {
        final boolean z17;
        if (this.isBlackListForbid != z16) {
            this.isBlackListForbid = z16;
            if (absProfileContentComponent != null) {
                if (z16) {
                    z17 = checkContentValidBlackList(absProfileContentComponent);
                } else {
                    z17 = true;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseContentContainer.this.lambda$checkValidComponent$2(absProfileContentComponent, z17);
                    }
                });
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.e
                @Override // java.lang.Runnable
                public final void run() {
                    BaseContentContainer.this.lambda$checkValidComponent$3(profileCardInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkValidComponent$5(AbsProfileContentComponent absProfileContentComponent, boolean z16) {
        absProfileContentComponent.onBlacklistConfigureChange(!z16, this.isBlackListForbid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onDataUpdateWrap, reason: merged with bridge method [inline-methods] */
    public void lambda$checkBlackListOnResume$0(ProfileCardInfo profileCardInfo) {
        try {
            onDataUpdate(profileCardInfo);
        } catch (Exception e16) {
            QLog.iAsync(TAG, 1, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkValidComponent(final AbsProfileContentComponent absProfileContentComponent, final ProfileCardInfo profileCardInfo) {
        final boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) absProfileContentComponent, (Object) profileCardInfo)).booleanValue();
        }
        if (profileCardInfo.isTroopMemberCard && ((ITroopInfoService) this.mApp.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(profileCardInfo.troopUin)) {
            String profileContentKey = absProfileContentComponent.getProfileContentKey();
            z16 = false;
            for (String str : IProfileContentKey.KEY_MAP_QIDIAN_PRIVATE_TROOP) {
                if (!TextUtils.equals(profileContentKey, str)) {
                }
            }
            if (!this.isCheckBlackList) {
                this.isBlackListForbid = ((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).isBlackOrBlackedUin(profileCardInfo.allInOne.uin, new CheckBlacklistListener() { // from class: com.tencent.mobileqq.profilecard.base.container.b
                    @Override // com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener
                    public final void onResult(boolean z17) {
                        BaseContentContainer.this.lambda$checkValidComponent$4(absProfileContentComponent, profileCardInfo, z17);
                    }
                });
            }
            this.isCheckBlackList = true;
            if (this.isBlackListForbid) {
                z16 = checkContentValidBlackList(absProfileContentComponent);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.c
                @Override // java.lang.Runnable
                public final void run() {
                    BaseContentContainer.this.lambda$checkValidComponent$5(absProfileContentComponent, z16);
                }
            });
            return z16;
        }
        z16 = true;
        if (!this.isCheckBlackList) {
        }
        this.isCheckBlackList = true;
        if (this.isBlackListForbid) {
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseContentContainer.this.lambda$checkValidComponent$5(absProfileContentComponent, z16);
            }
        });
        return z16;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void containerInvalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            updateViewContainer();
        }
    }

    protected boolean enableDivider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
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
        return 103;
    }

    protected String[] getDividerMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return IProfileContentKey.KEY_MAP_HAS_TOP_DIVIDER;
    }

    protected List<String[]> getKeyMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return IProfileContentKey.COMPONENT_ADD_LIST_NORMAL;
    }

    protected abstract void initComponentDividerCreator();

    protected abstract void initContainerDividerCreator();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onResume();
            checkBlackListOnResume((ProfileCardInfo) this.mData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateComponentData(AbsProfileContentComponent absProfileContentComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) absProfileContentComponent);
        } else {
            if (absProfileContentComponent == null) {
                return;
            }
            absProfileContentComponent.onDataUpdate((ProfileCardInfo) this.mData);
            updateMoreInfoMap(absProfileContentComponent.getProfileContentKey(), absProfileContentComponent.getContainerView());
            updateViewContainer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateMoreInfoMap(String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) view);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, View> moreInfoMap = ((ProfileContentView) this.mViewContainer).getMoreInfoMap();
        if (view == null) {
            moreInfoMap.remove(str);
        } else {
            moreInfoMap.put(str, view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void updateViewContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ((ProfileContentView) this.mViewContainer).setKeyMap(getKeyMap());
        ((ProfileContentView) this.mViewContainer).setEnableDivider(enableDivider());
        ((ProfileContentView) this.mViewContainer).setDividerMap(getDividerMap());
        ((ProfileContentView) this.mViewContainer).setDividerCreator(this.mDividerCreator);
        ((ProfileContentView) this.mViewContainer).setContainerDividerCreator(this.mContainerDividerCreator);
        ((ProfileContentView) this.mViewContainer).rebuildProfileContent((ProfileCardInfo) this.mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean onDataUpdate(ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onDateUpdate this=%s", this));
        }
        this.mData = profileCardInfo;
        int size = this.mChildComponent.size();
        boolean z17 = false;
        for (int i3 = 0; i3 < size; i3++) {
            AbsProfileContentComponent absProfileContentComponent = (AbsProfileContentComponent) this.mChildComponent.valueAt(i3);
            if (absProfileContentComponent != null && checkValidComponent(absProfileContentComponent, (ProfileCardInfo) this.mData)) {
                try {
                    z16 = absProfileContentComponent.onDataUpdate(profileCardInfo);
                } catch (Exception e16) {
                    QLog.iAsync(TAG, 1, "onDataUpdate fail.", e16);
                    z16 = false;
                }
                String profileContentKey = absProfileContentComponent.getProfileContentKey();
                View containerView = absProfileContentComponent.getContainerView();
                if (containerView != null) {
                    containerView.getParent();
                }
                boolean z18 = z16 || absProfileContentComponent.isNeedForceRefresh();
                if (z18) {
                    updateMoreInfoMap(profileContentKey, containerView);
                }
                z17 |= z18;
            }
        }
        if (z17) {
            updateViewContainer();
        }
        return z17;
    }
}
