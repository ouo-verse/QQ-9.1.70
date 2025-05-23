package com.tencent.mobileqq.profilecard.component.content.photowall;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.view.content.photowall.ElegantFavorShowView;
import com.tencent.mobileqq.profilecard.view.content.photowall.ElegantPhotoWallView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public class ElegantPhotoWallComponent extends ProfileBasePhotoWallComponent {
    private static final String TAG = "ElegantPhotoWallComponent";
    private int mReceivePhotoSize;
    private PhotoWallView photoWallView;
    private boolean shouldGone;

    public ElegantPhotoWallComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.mReceivePhotoSize = -1;
        this.photoWallView = null;
        this.shouldGone = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updatePhotoWallForBlacklistChanged(int i3) {
        if (this.mViewContainer == 0 || this.mData == 0) {
            return;
        }
        boolean isOwnerProfileCardEmptyItemFoldEnable = ProfileCardFeatureSwitch.INSTANCE.isOwnerProfileCardEmptyItemFoldEnable();
        boolean z16 = ((ProfileCardInfo) this.mData).allInOne.f260789pa == 0;
        if (z16 || i3 > 0) {
            if (z16 && isOwnerProfileCardEmptyItemFoldEnable && i3 == 0) {
                ((View) this.mViewContainer).setVisibility(8);
            } else {
                ((View) this.mViewContainer).setVisibility(0);
            }
        }
        VIEW view = this.mViewContainer;
        if (view instanceof ElegantFavorShowView) {
            if (z16 && i3 == 0) {
                ((ElegantFavorShowView) view).mGuideTipsContainer.setVisibility(0);
            } else {
                ((ElegantFavorShowView) view).mGuideTipsContainer.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected ProfileCardFavorShowView createFavorShowView() {
        return new ElegantFavorShowView(this.mActivity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected PhotoWallView createPhotoWallView() {
        if (this.mComponentCenter != null) {
            return new ElegantPhotoWallView(this.mActivity, this.mApp, ((ProfileCardInfo) this.mData).allInOne.uin, this.mComponentCenter.getViewLoader());
        }
        return new ElegantPhotoWallView(this.mActivity, this.mApp, ((ProfileCardInfo) this.mData).allInOne.uin);
    }

    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected ProfileCardFavorShowView getPhotoWallDiyView() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d3  */
    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean makeOrRefreshPhotoWall(Card card, boolean z16) {
        IComponent component = this.mComponentCenter.getComponent(1002);
        boolean z17 = false;
        boolean hasPhotoWall = component instanceof IProfileHeaderContainer ? ((IProfileHeaderContainer) component).hasPhotoWall() : false;
        boolean isPaTypeStrangerInContact = ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) this.mData).allInOne);
        boolean G = Utils.G(((ProfileCardInfo) this.mData).allInOne.uin);
        IProfileConfig iProfileConfig = this.mConfigHelper;
        boolean z18 = true;
        boolean z19 = (iProfileConfig == null || iProfileConfig.isSwitchEnable(2)) ? false : true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshPhotoWall photoWallInHeader=%s strangerInContact=%s isBabyQ=%s configDisable=%s", Boolean.valueOf(hasPhotoWall), Boolean.valueOf(isPaTypeStrangerInContact), Boolean.valueOf(G), Boolean.valueOf(z19)));
        }
        if (!hasPhotoWall && !isPaTypeStrangerInContact && !G && !z19) {
            if (this.mViewContainer == 0) {
                ProfileCardFavorShowView photoWallDiyView = getPhotoWallDiyView();
                VIEW view = photoWallDiyView;
                if (photoWallDiyView == null) {
                    this.photoWallView = createPhotoWallView();
                    ProfileCardFavorShowView createFavorShowView = createFavorShowView();
                    createFavorShowView.setTitle(getHeaderTitle());
                    createFavorShowView.setVisibility(8);
                    createFavorShowView.addView(this.photoWallView);
                    view = createFavorShowView;
                }
                this.mViewContainer = view;
            } else {
                z18 = false;
            }
            VIEW view2 = this.mViewContainer;
            if (!(view2 instanceof ProfileCardFavorShowView)) {
                return z18;
            }
            ProfileCardFavorShowView profileCardFavorShowView = (ProfileCardFavorShowView) view2;
            PhotoWallView photoWallView = (PhotoWallView) profileCardFavorShowView.getViewInContainer(0);
            this.photoWallView = photoWallView;
            photoWallView.setPhotoWallUpdaterListener(this);
            this.photoWallView.setNightModel();
            b bVar = new b(85, this.photoWallView);
            profileCardFavorShowView.mTitleBar.setTag(bVar);
            profileCardFavorShowView.setOnClickListener(this);
            profileCardFavorShowView.setTag(bVar);
        } else {
            if (this.mViewContainer != 0) {
                this.mViewContainer = null;
            }
            if (z17) {
                handleDiyPhotoWallUpdate();
            }
            return z17;
        }
        z17 = z18;
        if (z17) {
        }
        return z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent
    public void onBlacklistConfigureChange(boolean z16, boolean z17) {
        VIEW view = this.mViewContainer;
        if (view == 0) {
            return;
        }
        boolean z18 = z16 || this.isForceHide;
        this.shouldGone = z18;
        if (z18) {
            ((View) view).setVisibility(8);
        } else {
            int i3 = this.mReceivePhotoSize;
            if (i3 != -1) {
                updatePhotoWallForBlacklistChanged(i3);
            }
        }
        PhotoWallView photoWallView = this.photoWallView;
        if (photoWallView != null) {
            photoWallView.setBlockState(this.shouldGone);
        }
        QLog.i(TAG, 1, "onBlacklistConfigureChange " + z16 + " " + z17);
    }

    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        ProfileCardDtReportUtil.dtReportClick(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent, com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView.PhotoWallUpdaterListener
    public void onUpdatePhotoWall(int i3) {
        this.mReceivePhotoSize = i3;
        super.onUpdatePhotoWall(i3);
        VIEW view = this.mViewContainer;
        if (view != 0 && (view instanceof ElegantFavorShowView)) {
            boolean z16 = ((ProfileCardInfo) this.mData).allInOne.f260789pa == 0;
            if (z16 && i3 == 0 && !this.shouldGone) {
                ((ElegantFavorShowView) view).mGuideTipsContainer.setVisibility(0);
            } else {
                ((ElegantFavorShowView) view).mGuideTipsContainer.setVisibility(8);
            }
            QLog.i(TAG, 1, "isHost " + z16 + " size " + i3 + " shouldGone " + this.shouldGone);
        }
        QLog.i(TAG, 1, "mViewContainer " + this.mViewContainer);
    }

    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected String getHeaderTitle() {
        return HardCodeUtil.qqStr(R.string.x5p);
    }

    @Override // com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent
    protected void handleDiyPhotoWallUpdate() {
    }
}
