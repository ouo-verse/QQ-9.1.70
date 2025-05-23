package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView;

/* loaded from: classes16.dex */
public class VasProfileHeaderWZRYComponent extends AbsVasProfileHeaderComponent {
    private static final String TAG = "VasProfileHeaderWZRYComponent";

    public VasProfileHeaderWZRYComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
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
            VasProfileWZRYView vasProfileWZRYView = new VasProfileWZRYView(this.mActivity, (ProfileCardInfo) this.mData);
            vasProfileWZRYView.setClickListener(this);
            vasProfileWZRYView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
            this.mHeaderView = vasProfileWZRYView;
            ((FrameLayout) this.mViewContainer).removeAllViews();
            ((FrameLayout) this.mViewContainer).addView(this.mHeaderView);
        }
    }
}
