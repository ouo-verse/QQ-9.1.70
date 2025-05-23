package com.tencent.mobileqq.profilecard.api.impl;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileComponentApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiConfig;
import com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class ProfileComponentApiImpl implements IProfileComponentApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileComponentApiImpl";
    private final SparseArray<Class<? extends AbsProfileComponent>> profileComponentArray;

    public ProfileComponentApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.profileComponentArray = new SparseArray<>();
        }
    }

    private boolean checkEnableVasComponent(IProfileActivityDelegate iProfileActivityDelegate) {
        IProfileCardMultiConfig multiConfig = getMultiConfig(iProfileActivityDelegate);
        if (multiConfig != null && !multiConfig.enableVasComponent()) {
            return false;
        }
        return true;
    }

    private AbsProfileComponent createInner(int i3, IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate) {
        AbsProfileComponent absProfileComponent;
        if (checkEnableVasComponent(iProfileActivityDelegate)) {
            absProfileComponent = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).createVasProfileComponent(i3, iComponentCenter, profileCardInfo);
        } else {
            absProfileComponent = null;
        }
        String str = "create from base component factory, ";
        if (absProfileComponent == null) {
            try {
                absProfileComponent = this.profileComponentArray.get(i3).getConstructor(IComponentCenter.class, ProfileCardInfo.class).newInstance(iComponentCenter, profileCardInfo);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "create component fail.", e16);
            }
            str = "create from base component factory, " + String.format(" component=%s", absProfileComponent);
        }
        if (QLog.isDevelopLevel()) {
            QLog.iAsync(TAG, 4, str);
        }
        if (absProfileComponent != null) {
            absProfileComponent.setProfileActivityDelegate(iProfileActivityDelegate);
        }
        return absProfileComponent;
    }

    private ArrayList<Class<? extends IProfileComponentCollector>> getInjectCollectorClasses(IProfileActivityDelegate iProfileActivityDelegate) {
        IProfileCardMultiConfig multiConfig = getMultiConfig(iProfileActivityDelegate);
        if (multiConfig == null) {
            return null;
        }
        return multiConfig.getInjectCollectorClasses();
    }

    private IProfileCardMultiConfig getMultiConfig(IProfileActivityDelegate iProfileActivityDelegate) {
        IProfileCardMultiConfig iProfileCardMultiConfig;
        if (iProfileActivityDelegate != null && iProfileActivityDelegate.getProfileCardMultiple() != null) {
            iProfileCardMultiConfig = iProfileActivityDelegate.getProfileCardMultiple().getMultiConfig();
        } else {
            iProfileCardMultiConfig = null;
        }
        if (iProfileCardMultiConfig == null) {
            IProfileCardMultiConfig versionConfig = ProfileCardVersion.V_OLD.getVersionConfig();
            QLog.d(TAG, 1, String.format("injectCollectorClasses is empty.", Integer.valueOf(this.profileComponentArray.size())));
            return versionConfig;
        }
        return iProfileCardMultiConfig;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileComponentApi
    public AbsProfileComponent create(int i3, IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsProfileComponent) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), iComponentCenter, profileCardInfo, iProfileActivityDelegate);
        }
        return createInner(i3, iComponentCenter, profileCardInfo, iProfileActivityDelegate);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileComponentApi
    public void initProfileComponentArray(IProfileActivityDelegate iProfileActivityDelegate) {
        IProfileComponentCollector iProfileComponentCollector;
        SparseArray<Class<? extends AbsProfileComponent>> collect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iProfileActivityDelegate);
            return;
        }
        if (iProfileActivityDelegate == null) {
            QLog.e(TAG, 1, "initProfileComponentArray: profileDelegate is null");
            return;
        }
        ArrayList<Class<? extends IProfileComponentCollector>> injectCollectorClasses = getInjectCollectorClasses(iProfileActivityDelegate);
        if (bl.b(injectCollectorClasses)) {
            QLog.e(TAG, 1, "initProfileComponentArray: injectCollectorClasses is empty.");
            return;
        }
        this.profileComponentArray.clear();
        Iterator<Class<? extends IProfileComponentCollector>> it = injectCollectorClasses.iterator();
        while (true) {
            if (it.hasNext()) {
                try {
                    iProfileComponentCollector = it.next().getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "initProfileComponentMap create collector fail.", e16);
                    iProfileComponentCollector = null;
                }
                if (iProfileComponentCollector != null && (collect = iProfileComponentCollector.collect()) != null && collect.size() > 0) {
                    int size = collect.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        int keyAt = collect.keyAt(i3);
                        this.profileComponentArray.put(keyAt, collect.get(keyAt));
                    }
                }
            } else {
                QLog.i(TAG, 1, String.format("initProfileComponentArray size=%s", Integer.valueOf(this.profileComponentArray.size())));
                return;
            }
        }
    }
}
