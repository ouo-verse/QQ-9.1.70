package com.tencent.mobileqq.profilecard.container;

import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.container.BaseBgContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ElegantBgContainer extends BaseBgContainer {
    private static final String TAG = "ElegantBgContainer";
    private ProfileCardInfo mCardInfo;

    public ElegantBgContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.mCardInfo = profileCardInfo;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer
    protected List<Integer> getChildComponentTypeList() {
        ArrayList arrayList = new ArrayList();
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null && (iProfileActivityDelegate.getIsShowZplanCover() || this.mDelegate.isShowVasCustomBgCover())) {
            arrayList.add(1003);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseBgContainer, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        return TAG;
    }
}
