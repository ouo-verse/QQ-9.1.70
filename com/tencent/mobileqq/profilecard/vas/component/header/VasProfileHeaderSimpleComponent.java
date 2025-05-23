package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView;

/* loaded from: classes16.dex */
public class VasProfileHeaderSimpleComponent extends AbsVasProfileHeaderComponent {
    private static final String TAG = "VasProfileHeaderSimpleComponent";

    public VasProfileHeaderSimpleComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer
    public boolean hasPhotoWall() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent
    protected void initHeaderView() {
        if (this.mHeaderView == null) {
            boolean booleanExtra = this.mActivity.getIntent().getBooleanExtra(IProfileCardConst.KEY_FROM_EXTENDS_FRIENDS, false);
            VasProfileSimpleView vasProfileSimpleView = new VasProfileSimpleView(this.mActivity, (ProfileCardInfo) this.mData);
            vasProfileSimpleView.setFromExtendFriend(booleanExtra);
            vasProfileSimpleView.setClickListener(this);
            vasProfileSimpleView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
            this.mHeaderView = vasProfileSimpleView;
            ((FrameLayout) this.mViewContainer).removeAllViews();
            ((FrameLayout) this.mViewContainer).addView(this.mHeaderView);
        }
    }
}
