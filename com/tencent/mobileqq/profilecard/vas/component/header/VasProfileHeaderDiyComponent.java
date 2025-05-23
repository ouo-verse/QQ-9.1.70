package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView;

/* loaded from: classes16.dex */
public class VasProfileHeaderDiyComponent extends AbsVasProfileHeaderComponent {
    private static final String TAG = "VasProfileHeaderDiyComponent";

    public VasProfileHeaderDiyComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent
    protected void initHeaderView() {
        if (this.mHeaderView == null) {
            VasProfileQVipDiyView vasProfileQVipDiyView = new VasProfileQVipDiyView(this.mActivity, (ProfileCardInfo) this.mData);
            vasProfileQVipDiyView.setProfileArgs(this.mRootView);
            vasProfileQVipDiyView.setClickListener(this);
            vasProfileQVipDiyView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
            vasProfileQVipDiyView.initDiyTemplate();
            this.mHeaderView = vasProfileQVipDiyView;
            ((FrameLayout) this.mViewContainer).removeAllViews();
            ((FrameLayout) this.mViewContainer).addView(this.mHeaderView);
        }
    }
}
