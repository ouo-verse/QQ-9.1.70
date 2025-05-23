package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileGameView;

/* loaded from: classes16.dex */
public class VasProfileHeaderGameComponent extends AbsVasProfileHeaderComponent {
    private static final String TAG = "VasProfileHeaderGameComponent";

    public VasProfileHeaderGameComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
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
            VasProfileGameView vasProfileGameView = new VasProfileGameView(this.mActivity, (ProfileCardInfo) this.mData);
            vasProfileGameView.setClickListener(this);
            vasProfileGameView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
            this.mHeaderView = vasProfileGameView;
            ((FrameLayout) this.mViewContainer).removeAllViews();
            ((FrameLayout) this.mViewContainer).addView(this.mHeaderView);
        }
    }
}
