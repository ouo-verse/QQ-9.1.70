package com.tencent.mobileqq.profilecard.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.base.container.ProfileBgContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileFgContainer;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoHeaderComponent;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoV2Component;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousComponent;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileEmptyAnonymousComponent;
import com.tencent.mobileqq.profilecard.bussiness.contact.ProfileContactComponent;
import com.tencent.mobileqq.profilecard.bussiness.guide.ProfileGuideComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileComponentCollector implements IProfileComponentCollector, IProfileComponentConst {
    static IPatchRedirector $redirector_;

    public ProfileComponentCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector
    public SparseArray<Class<? extends AbsProfileComponent>> collect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SparseArray) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SparseArray<Class<? extends AbsProfileComponent>> sparseArray = new SparseArray<>();
        sparseArray.put(103, ProfileContentContainer.class);
        sparseArray.put(104, ProfileBgContainer.class);
        sparseArray.put(105, ProfileFgContainer.class);
        sparseArray.put(1029, ProfileGuideComponent.class);
        sparseArray.put(1026, ProfileAnonymousComponent.class);
        sparseArray.put(1039, ProfileEmptyAnonymousComponent.class);
        sparseArray.put(1023, ProfileAccountInfoV2Component.class);
        sparseArray.put(1024, ProfileAccountInfoHeaderComponent.class);
        sparseArray.put(1030, ProfileContactComponent.class);
        return sparseArray;
    }
}
