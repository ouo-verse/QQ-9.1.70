package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class AbsComponent<VIEW, DATA> implements IComponent<VIEW, DATA> {
    static IPatchRedirector $redirector_ = null;
    private static final boolean LOG_ENABLE = false;
    private static final String TAG = "AbsComponent";
    protected boolean isForceHide;
    protected QBaseActivity mActivity;
    protected AppInterface mApp;
    protected SparseArray<IComponent<? extends View, DATA>> mChildComponent;
    protected IComponentCenter mComponentCenter;
    protected AbsProfileContainer<VIEW> mComponentContainer;
    protected DATA mData;
    private boolean mIsComponentContentEmpty;
    private boolean mIsNeedForceRefresh;
    protected VIEW mViewContainer;

    public AbsComponent(IComponentCenter iComponentCenter, DATA data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) data);
            return;
        }
        this.mIsComponentContentEmpty = false;
        this.mIsNeedForceRefresh = false;
        this.isForceHide = false;
        this.mComponentCenter = iComponentCenter;
        this.mData = data;
        this.mChildComponent = new SparseArray<>();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void addComponent(IComponent<? extends View, DATA> iComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iComponent);
        } else {
            this.mChildComponent.put(iComponent.getComponentType(), iComponent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void attachToComponentCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.addComponent(this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void changeEmptyAndRefreshStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
            return;
        }
        if (this.mIsComponentContentEmpty != z16) {
            this.mIsNeedForceRefresh = true;
        } else {
            this.mIsNeedForceRefresh = false;
        }
        this.mIsComponentContentEmpty = z16;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void containerInvalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        AbsProfileContainer<VIEW> absProfileContainer = this.mComponentContainer;
        if (absProfileContainer == null) {
            return;
        }
        absProfileContainer.containerInvalidate();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void detachFromComponentCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.removeComponent(this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public IComponent<? extends View, DATA> getComponent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IComponent) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return this.mChildComponent.get(i3);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public IComponentCenter getComponentCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IComponentCenter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mComponentCenter;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public VIEW getContainerView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (VIEW) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mViewContainer;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean isComponentContentEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.mIsComponentContentEmpty;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean isNeedForceRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.mIsNeedForceRefresh;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public boolean onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return false;
    }

    public void onBlacklistConfigureChange(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        VIEW view = this.mViewContainer;
        if (view instanceof View) {
            View view2 = (View) view;
            if (z16 || this.isForceHide) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            this.mActivity = qBaseActivity;
            this.mApp = (AppInterface) qBaseActivity.getAppRuntime();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean onDataUpdate(DATA data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) data)).booleanValue();
        }
        this.mData = data;
        int size = this.mChildComponent.size();
        boolean z16 = false;
        for (int i3 = 0; i3 < size; i3++) {
            IComponent<? extends View, DATA> valueAt = this.mChildComponent.valueAt(i3);
            if (valueAt != null) {
                z16 |= valueAt.onDataUpdate(data);
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.mActivity = null;
            this.mApp = null;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void removeComponent(IComponent<? extends View, DATA> iComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iComponent);
        } else {
            this.mChildComponent.remove(iComponent.getComponentType());
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void setComponentContainer(AbsProfileContainer<VIEW> absProfileContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) absProfileContainer);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void setContainerView(VIEW view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.mViewContainer = view;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return String.format("Component@%s{componentType=%s componentName=%s}", Integer.valueOf(hashCode()), Integer.valueOf(getComponentType()), getComponentName());
    }
}
