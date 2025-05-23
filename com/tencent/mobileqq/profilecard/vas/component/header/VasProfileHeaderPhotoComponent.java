package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView;

/* loaded from: classes16.dex */
public class VasProfileHeaderPhotoComponent extends AbsVasProfileHeaderComponent {
    private static final String TAG = "VasProfileHeaderPhotoComponent";

    public VasProfileHeaderPhotoComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
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
            VasProfilePhotoView vasProfilePhotoView = new VasProfilePhotoView(this.mActivity, (ProfileCardInfo) this.mData);
            vasProfilePhotoView.setClickListener(this);
            vasProfilePhotoView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
            this.mDelegate.getListView().setMotionEventInterceptor(vasProfilePhotoView);
            this.mHeaderView = vasProfilePhotoView;
            ((FrameLayout) this.mViewContainer).removeAllViews();
            ((FrameLayout) this.mViewContainer).addView(this.mHeaderView);
        }
    }
}
