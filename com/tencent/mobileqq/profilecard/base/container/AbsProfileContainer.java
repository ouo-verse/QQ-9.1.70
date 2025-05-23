package com.tencent.mobileqq.profilecard.base.container;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes16.dex */
public abstract class AbsProfileContainer<VIEW> extends AbsProfileComponent<VIEW> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AbsProfileContainer";

    public AbsProfileContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void destroyChildComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        List<Integer> childComponentTypeList = getChildComponentTypeList();
        if (childComponentTypeList != null) {
            Iterator<Integer> it = childComponentTypeList.iterator();
            while (it.hasNext()) {
                try {
                    IComponent component = getComponent(it.next().intValue());
                    if (component != null) {
                        removeComponent(component);
                        component.detachFromComponentCenter();
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "destroyChildComponent fail.", e16);
                }
            }
        }
    }

    protected List<Integer> getChildComponentTypeList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    protected View getChildComponentViewContainer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void initChildComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        List<Integer> childComponentTypeList = getChildComponentTypeList();
        if (childComponentTypeList != null) {
            Iterator<Integer> it = childComponentTypeList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                try {
                    View childComponentViewContainer = getChildComponentViewContainer(intValue);
                    AbsProfileComponent create = ProfileUtils.create(intValue, this.mComponentCenter, (ProfileCardInfo) this.mData, this.mDelegate);
                    if (create != null) {
                        create.setContainerView(childComponentViewContainer);
                        create.setComponentContainer(this);
                        create.attachToComponentCenter();
                        addComponent(create);
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "initChildComponent fail.", e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
            initChildComponent();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            destroyChildComponent();
            super.onDestroy();
        }
    }
}
