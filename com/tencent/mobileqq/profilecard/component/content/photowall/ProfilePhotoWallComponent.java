package com.tencent.mobileqq.profilecard.component.content.photowall;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;

/* loaded from: classes35.dex */
public class ProfilePhotoWallComponent extends ProfileBasePhotoWallComponent {
    public ProfilePhotoWallComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected ProfileCardFavorShowView createFavorShowView() {
        return new ProfileCardFavorShowView(this.mActivity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected PhotoWallView createPhotoWallView() {
        return new PhotoWallView(this.mActivity, this.mApp, ((ProfileCardInfo) this.mData).allInOne.uin);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected ProfileCardFavorShowView getPhotoWallDiyView() {
        return (ProfileCardFavorShowView) ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).getPhotoWallDiyView((ProfileCardInfo) this.mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected void handleDiyPhotoWallUpdate() {
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
            diyMoreInfoManager.updatePhotoWallForDeepDiy((View) this.mViewContainer);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected String getHeaderTitle() {
        return HardCodeUtil.qqStr(R.string.f169714x64);
    }
}
