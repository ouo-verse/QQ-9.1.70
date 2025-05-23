package com.tencent.mobileqq.profilecard.component.content.photowall;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileCardPhotoWallData;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public abstract class ProfileBasePhotoWallComponent extends AbsProfileContentComponent implements View.OnClickListener, PhotoWallView.PhotoWallUpdaterListener {
    private static final String TAG = "ProfileBasePhotoWallComponent";
    private boolean isInitDtReport;
    private Handler mHandler;
    private boolean mHasScrollToPhotoWall;
    private PhotoWallObserver mPhotoWallObserver;
    private boolean mScrollToPhotoWall;

    public ProfileBasePhotoWallComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.isInitDtReport = false;
        this.mPhotoWallObserver = new PhotoWallObserver() { // from class: com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent.1
            @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver
            protected void onDelQZonePhotoWall(boolean z16, String str) {
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileBasePhotoWallComponent.TAG, 2, String.format("onDelQZonePhotoWall isSuc=%s uin=%s", Boolean.valueOf(z16), str));
                }
                ProfileBasePhotoWallComponent.this.handleDelQZonePhotoWall(z16);
            }

            @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver
            protected void onGetQZonePhotoWall(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar, String str2) {
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileBasePhotoWallComponent.TAG, 2, String.format("onGetQZonePhotoWall isSuc=%s uin=%s", Boolean.valueOf(z16), str2));
                }
                ProfileBasePhotoWallComponent.this.handleGetQZonePhotoWall(z16, str, mobile_sub_get_photo_wall_rspVar, str2);
                if (ProfileBasePhotoWallComponent.this.mScrollToPhotoWall && !ProfileBasePhotoWallComponent.this.mHasScrollToPhotoWall) {
                    ProfileBasePhotoWallComponent.this.mHasScrollToPhotoWall = true;
                    ProfileBasePhotoWallComponent.this.scrollToPhotoWall();
                }
                ProfileBasePhotoWallComponent.this.onUpdatePhotoWall(mobile_sub_get_photo_wall_rspVar != null ? mobile_sub_get_photo_wall_rspVar.total_pic : 0);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void freshQZonePhotoWall() {
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            ((PhotoWallHandler) appInterface.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(((ProfileCardInfo) this.mData).allInOne.uin, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleGetQZonePhotoWall(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar, String str2) {
        if (((ProfileCardInfo) this.mData).allInOne.uin.equals(str2)) {
            VIEW view = this.mViewContainer;
            if (view != 0) {
                ((PhotoWallView) ((ProfileCardFavorShowView) view).getViewInContainer(0)).onGetQZonePhotoWall(z16, str, mobile_sub_get_photo_wall_rspVar);
            }
            IComponent component = this.mComponentCenter.getComponent(1002);
            if (component instanceof IProfileHeaderContainer) {
                ((IProfileHeaderContainer) component).onGetQZoneCover(z16, str2, mobile_sub_get_photo_wall_rspVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPhotoWall() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.content.photowall.ProfileBasePhotoWallComponent.2
                @Override // java.lang.Runnable
                public void run() {
                    int top;
                    if (((AbsComponent) ProfileBasePhotoWallComponent.this).mViewContainer == null || (top = ((View) ((AbsComponent) ProfileBasePhotoWallComponent.this).mViewContainer).getTop()) < 0 || ((AbsProfileComponent) ProfileBasePhotoWallComponent.this).mDelegate == null) {
                        return;
                    }
                    ((AbsProfileComponent) ProfileBasePhotoWallComponent.this).mDelegate.scrollToMoreInfoView(top);
                }
            }, 1000L);
        }
    }

    private void updateAddProfileComponent() {
        IComponent component;
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter == null || (component = iComponentCenter.getComponent(1038)) == null) {
            return;
        }
        component.lambda$checkValidComponent$3(this.mData);
    }

    protected abstract ProfileCardFavorShowView createFavorShowView();

    protected abstract PhotoWallView createPhotoWallView();

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1009;
    }

    protected abstract String getHeaderTitle();

    protected abstract ProfileCardFavorShowView getPhotoWallDiyView();

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_PHOTO_WALL;
    }

    protected abstract void handleDiyPhotoWallUpdate();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
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
                    PhotoWallView createPhotoWallView = createPhotoWallView();
                    ProfileCardFavorShowView createFavorShowView = createFavorShowView();
                    createFavorShowView.setTitle(getHeaderTitle());
                    createFavorShowView.setVisibility(8);
                    createFavorShowView.addView(createPhotoWallView);
                    view = createFavorShowView;
                }
                this.mViewContainer = view;
            } else {
                z18 = false;
            }
            ProfileCardFavorShowView profileCardFavorShowView = (ProfileCardFavorShowView) this.mViewContainer;
            PhotoWallView photoWallView = (PhotoWallView) profileCardFavorShowView.getViewInContainer(0);
            photoWallView.setPhotoWallUpdaterListener(this);
            photoWallView.setNightModel();
            profileCardFavorShowView.mTitleBar.setTag(new b(85, photoWallView));
            profileCardFavorShowView.mTitleBar.setOnClickListener(this);
            updateItemTheme(profileCardFavorShowView.mTitleBar, profileCardFavorShowView.mTitleText, null, profileCardFavorShowView.mArrowImage);
            updateItemTheme(photoWallView.mEmptyTitle, photoWallView.mEmptyInfo);
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

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 100) {
            freshQZonePhotoWall();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onClick(View view) {
        ProfileCardDtReportUtil.dtReportClick((View) this.mViewContainer);
        if (view.getTag() instanceof b) {
            b bVar = (b) view.getTag();
            if (bVar.f260135a == 85) {
                Object obj = bVar.f260136b;
                if (obj instanceof PhotoWallView) {
                    ((PhotoWallView) obj).peformClickMoreText();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mScrollToPhotoWall = intent.getBooleanExtra(IProfileCardConst.PROFILE_SCROLL_TO_PHOTO_WALL, false);
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mApp.addObserver(this.mPhotoWallObserver);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        this.mApp.removeObserver(this.mPhotoWallObserver);
        super.onDestroy();
    }

    public void onUpdatePhotoWall(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onUpdatePhotoWall size=%s", Integer.valueOf(i3)));
        }
        if (this.mViewContainer == 0 || this.mData == 0) {
            return;
        }
        updatePhotoWallContainer(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileBasePhotoWallComponent) profileCardInfo);
        DATA data = this.mData;
        boolean makeOrRefreshPhotoWall = lambda$checkValidComponent$3 | makeOrRefreshPhotoWall(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
        if (makeOrRefreshPhotoWall && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) view, ProfileCardDtReportUtil.DT_REPORT_PICTURE);
        }
        return makeOrRefreshPhotoWall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDelQZonePhotoWall(boolean z16) {
        if (z16) {
            QQToast.makeText(BaseApplication.getContext(), 2, MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.x5z), 0).show();
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.f169710x60), 0).show();
        }
        freshQZonePhotoWall();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updatePhotoWallContainer(int i3) {
        ((ProfileCardInfo) this.mData).putBusinessInfo(new ProfileCardPhotoWallData(i3));
        updateAddProfileComponent();
        if (this.mViewContainer == 0) {
            QLog.e(TAG, 1, "updatePhotoWallContainer fail, mViewContainer is null");
            return;
        }
        boolean z16 = ((ProfileCardInfo) this.mData).allInOne.f260789pa == 0;
        boolean isOwnerProfileCardEmptyItemFoldEnable = ProfileCardFeatureSwitch.INSTANCE.isOwnerProfileCardEmptyItemFoldEnable();
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_IS_EMPTY, Integer.valueOf(i3 == 0 ? 1 : 2));
        VideoReport.setElementParams(this.mViewContainer, hashMap);
        if (z16 || i3 > 0) {
            if (z16 && isOwnerProfileCardEmptyItemFoldEnable && i3 == 0) {
                ((View) this.mViewContainer).setVisibility(8);
            } else {
                ((View) this.mViewContainer).setVisibility(0);
            }
            if (z16) {
                ReportController.o(this.mApp, "dc00898", "", "", "0X8007EBC", "0X8007EBC", i3 > 0 ? 1 : 2, 0, "", "", "", "");
            } else {
                ReportController.o(this.mApp, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
            }
        }
    }
}
