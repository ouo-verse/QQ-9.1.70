package com.tencent.mobileqq.profilecard.component.head;

import android.os.Bundle;
import android.view.View;
import androidx.arch.core.util.Function;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.utils.VasSvipPrivilegeAnimateHelper;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView;
import com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView;
import com.tencent.mobileqq.profilecard.view.head.ElegantContactsProfileHeadView;
import com.tencent.mobileqq.profilecard.view.head.ElegantQQProfileHeadView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes35.dex */
public class ElegantProfileHeaderComponent extends BaseProfileHeaderComponent {
    private static final String TAG = "ElegantProfileHeaderComponent";
    private Map<Integer, Function<ProfileCardInfo, ProfileBaseView>> actionMappings;

    public ElegantProfileHeaderComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        HashMap hashMap = new HashMap();
        this.actionMappings = hashMap;
        hashMap.put(0, new Function<ProfileCardInfo, ProfileBaseView>() { // from class: com.tencent.mobileqq.profilecard.component.head.ElegantProfileHeaderComponent.1
            @Override // androidx.arch.core.util.Function
            public ProfileBaseView apply(ProfileCardInfo profileCardInfo2) {
                return new ElegantContactsProfileHeadView(((AbsComponent) ElegantProfileHeaderComponent.this).mActivity, profileCardInfo2, ((AbsProfileComponent) ElegantProfileHeaderComponent.this).mDelegate);
            }
        });
        this.actionMappings.put(1, new Function<ProfileCardInfo, ProfileBaseView>() { // from class: com.tencent.mobileqq.profilecard.component.head.ElegantProfileHeaderComponent.2
            @Override // androidx.arch.core.util.Function
            public ProfileBaseView apply(ProfileCardInfo profileCardInfo2) {
                return new ElegantQQProfileHeadView(((AbsComponent) ElegantProfileHeaderComponent.this).mActivity, profileCardInfo2, ((AbsProfileComponent) ElegantProfileHeaderComponent.this).mDelegate);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent
    protected ProfileBaseView initProfileBaseView() {
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).allInOne == null) {
            return null;
        }
        ProfileBaseView apply = this.actionMappings.get(Integer.valueOf(!ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) data).allInOne) ? 1 : 0)).apply((ProfileCardInfo) this.mData);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null && (apply instanceof AbsQCircleProfileHeaderView)) {
            ((AbsQCircleProfileHeaderView) apply).mIsShowQCircleCover = iProfileActivityDelegate.isShowQCircleCover();
        }
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null && (apply instanceof AbsZPlanProfileHeaderView)) {
            ((AbsZPlanProfileHeaderView) apply).mIsShowZplanCover = iProfileActivityDelegate2.getIsShowZplanCover();
        }
        return apply;
    }

    @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getTag() instanceof b) {
            int i3 = ((b) view.getTag()).f260135a;
            if (i3 == 1 || i3 == 10 || i3 == 17 || i3 == 88 || i3 == 105) {
                dtReport(view);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            ProfileCardDtReportUtil.initElementWithExposure(absProfileHeaderView.getChildView("map_key_face"), ProfileCardDtReportUtil.DT_REPORT_AVATAR);
            ProfileCardDtReportUtil.initElementWithExposure(this.mHeaderView.getChildView("map_key_like"), ProfileCardDtReportUtil.DT_REPORT_LIKE);
            ProfileCardDtReportUtil.initElementWithExposure(this.mHeaderView.getChildView("map_key_profile_nick_name"), ProfileCardDtReportUtil.DT_REPORT_NAME);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3(profileCardInfo);
        View childView = this.mHeaderView.getChildView("map_key_face");
        if (childView != null) {
            VasSvipPrivilegeAnimateHelper.addSvipPrivilegeAnimateView(childView);
        }
        return lambda$checkValidComponent$3;
    }
}
