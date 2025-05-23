package com.tencent.mobileqq.profilecard.component.head;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes35.dex */
public abstract class BaseProfileHeaderComponent extends AbsProfileHeaderComponent {
    private static final long COVER_CLICK_DELAY_TIME = 1000;
    private static final String TAG = "ProfileHeaderBaseComponent";
    private static long coverLastClickTime;
    private boolean mIsFromArkBabyQ;
    private PullToZoomHeaderListView mListView;
    private FriendProfilePhotoHelper mPhotoHelper;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public static abstract class ActionSheetItem {
        public int buttonStrId;

        public ActionSheetItem(int i3) {
            this.buttonStrId = i3;
        }

        public abstract void onClick();
    }

    public BaseProfileHeaderComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    private void destroyProfilePhotoHelper() {
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.c();
            this.mPhotoHelper = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleProfileCoverClick() {
        if (!ProfilePAUtils.isPaTypeHasUin(((ProfileCardInfo) this.mData).allInOne) || this.mApp == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - coverLastClickTime < 1000) {
            return;
        }
        coverLastClickTime = currentTimeMillis;
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
                previewProfileCover(true);
            } else {
                showProfileCoverActionSheet();
            }
        } else {
            previewProfileCover(false);
        }
        ReportController.o(this.mApp, "dc00898", "", "", "0X800A889", "0X800A889", ((ProfileCardInfo) this.mData).allInOne.f260789pa != 0 ? 2 : 1, 0, "", "", "", "");
    }

    private void initProfilePhotoHelper() {
        if (this.mPhotoHelper == null) {
            this.mPhotoHelper = new FriendProfilePhotoHelper(this.mActivity, new FriendProfilePhotoHelper.b() { // from class: com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.1
                @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
                public void notifyUser(int i3, int i16) {
                    QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show();
                }

                @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
                public void onUploadResult(byte[] bArr) {
                    if (bArr != null) {
                        if (((AbsComponent) BaseProfileHeaderComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) BaseProfileHeaderComponent.this).mData).card != null) {
                            if (((ProfileCardInfo) ((AbsComponent) BaseProfileHeaderComponent.this).mData).card.checkCoverUrl(bArr)) {
                                ((ProfileCardInfo) ((AbsComponent) BaseProfileHeaderComponent.this).mData).card.updateCoverData(bArr);
                            }
                            if (((AbsProfileHeaderComponent) BaseProfileHeaderComponent.this).mHeaderView instanceof ProfileBaseView) {
                                ((ProfileBaseView) ((AbsProfileHeaderComponent) BaseProfileHeaderComponent.this).mHeaderView).onUpdate((ProfileCardInfo) ((AbsComponent) BaseProfileHeaderComponent.this).mData, false);
                            }
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ((FriendsManager) ((AbsComponent) BaseProfileHeaderComponent.this).mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).p0(((ProfileCardInfo) ((AbsComponent) BaseProfileHeaderComponent.this).mData).card);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }, 32, null, false);
                        }
                    } else {
                        ((AbsProfileComponent) BaseProfileHeaderComponent.this).mDelegate.requestUpdateCard();
                    }
                    ReportController.o(((AbsComponent) BaseProfileHeaderComponent.this).mApp, "dc00898", "", "", "0X8007EC2", "0X8007EC2", 0, 0, "", "", "", "");
                }

                @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
                public void updateCover(byte[] bArr) {
                    if (bArr != null) {
                        ((ProfileCardInfo) ((AbsComponent) BaseProfileHeaderComponent.this).mData).card.updateCoverData(bArr);
                        if (((AbsProfileHeaderComponent) BaseProfileHeaderComponent.this).mHeaderView instanceof ProfileBaseView) {
                            ((AbsProfileHeaderComponent) BaseProfileHeaderComponent.this).mHeaderView.onUpdate((ProfileCardInfo) ((AbsComponent) BaseProfileHeaderComponent.this).mData, false);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void previewProfileCover(boolean z16) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.mHeaderView.mCoverUrl);
        int i3 = this.mHeaderView.mCoverTimeStamp == 0 ? ((ProfileCardInfo) this.mData).card.defaultCardId : 0;
        Intent intent = new Intent(this.mActivity, (Class<?>) CardPicGalleryActivity.class);
        intent.putExtra("extra_mode", 2);
        intent.putExtra("is_from_mine_profile", z16);
        intent.putStringArrayListExtra("business_card_pics", arrayList);
        intent.putExtra("default_card_id", i3);
        if (TextUtils.isEmpty(this.mHeaderView.mCoverUrl)) {
            intent.putExtra("extra_default", R.drawable.f2v);
        }
        this.mActivity.startActivity(intent);
        this.mActivity.overridePendingTransition(R.anim.f155038he, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportProfileCoverActionSheetItemClick(int i3) {
        ReportController.o(this.mApp, "dc00898", "", "", "0X800A88A", "0X800A88A", i3, 0, "", "", "", "");
    }

    private void showProfileCoverActionSheet() {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mActivity, null);
        final ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.mHeaderView.mCoverUrl)) {
            arrayList.add(new ActionSheetItem(R.string.f171031co4) { // from class: com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.2
                @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.ActionSheetItem
                public void onClick() {
                    BaseProfileHeaderComponent.this.previewProfileCover(true);
                    BaseProfileHeaderComponent.this.reportProfileCoverActionSheetItemClick(1);
                }
            });
        }
        arrayList.add(new ActionSheetItem(R.string.f171029bu1) { // from class: com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.3
            @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.ActionSheetItem
            public void onClick() {
                if (((AbsComponent) BaseProfileHeaderComponent.this).mApp == null) {
                    QLog.e(BaseProfileHeaderComponent.TAG, 1, "gotoBusinessCardMall fail, mApp is null");
                    return;
                }
                ProfileCardUtil.E(((AbsComponent) BaseProfileHeaderComponent.this).mActivity, ((AbsComponent) BaseProfileHeaderComponent.this).mApp.getCurrentAccountUin(), "inside.myCardButton", 1, 3, 1, "", true);
                ReportController.o(((AbsComponent) BaseProfileHeaderComponent.this).mApp, "CliOper", "", "", "card_mall", "0X8004DBF", 0, 0, "", "", "", "");
                VasWebviewUtil.reportCommercialDrainage(((AbsComponent) BaseProfileHeaderComponent.this).mApp.getCurrentAccountUin(), "defaultcard", "click_card_mine", "", 1, 0, 0, "", "", "");
                BaseProfileHeaderComponent.this.reportProfileCoverActionSheetItemClick(2);
            }
        });
        arrayList.add(new ActionSheetItem(R.string.btz) { // from class: com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.4
            @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.ActionSheetItem
            public void onClick() {
                BaseProfileHeaderComponent.this.enterCustomCover();
                if (((AbsComponent) BaseProfileHeaderComponent.this).mApp != null) {
                    VasWebviewUtil.reportCommercialDrainage(((AbsComponent) BaseProfileHeaderComponent.this).mApp.getCurrentAccountUin(), "defaultcard", "click_customized", "", 1, 0, 0, "", "", "");
                }
                BaseProfileHeaderComponent.this.reportProfileCoverActionSheetItemClick(3);
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            actionSheet.addButton(((ActionSheetItem) it.next()).buttonStrId);
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent.5
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                ((ActionSheetItem) arrayList.get(i3)).onClick();
                actionSheet.superDismiss();
            }
        });
        try {
            actionSheet.show();
        } catch (Exception e16) {
            QLog.e(TAG, 2, "showProfileCoverActionSheet fail.", e16);
        }
    }

    public void enterCustomCover() {
        boolean z16 = this.mHeaderView.mCoverTimeStamp == 0;
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.h(z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1002;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent
    protected void initHeaderView() {
        if (this.mHeaderView == null) {
            resetHeaderView(initProfileBaseView());
        }
    }

    protected abstract ProfileBaseView initProfileBaseView();

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        FriendProfilePhotoHelper friendProfilePhotoHelper;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1024 && (friendProfilePhotoHelper = this.mPhotoHelper) != null) {
            friendProfilePhotoHelper.j(i16, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getTag() instanceof b) {
            int i3 = ((b) view.getTag()).f260135a;
            if (i3 == 17) {
                handleProfileCoverClick();
                return;
            }
            if (i3 == 105) {
                DATA data = this.mData;
                Card card = ((ProfileCardInfo) data).card;
                if (card != null && card.isForbidAccount) {
                    QLog.i(TAG, 1, "qid onClick but forbidAccount");
                    return;
                } else {
                    VipQidHelper.jumpQidSetInfoPage(this.mActivity, (ProfileCardInfo) data);
                    return;
                }
            }
            if (i3 == 115) {
                MobileReportManager.getInstance().reportAction(SearchConstants.PLATFORM, "data_card", "vip_medal", "", "" + ((ProfileCardInfo) this.mData).card.vipMedalId, "62", 102, 0);
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.mActivity, ((ProfileCardInfo) this.mData).card.vipMedalJumpUrl);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        Intent intent = qBaseActivity.getIntent();
        if (intent != null) {
            this.mIsFromArkBabyQ = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_ARK_BABYQ, false);
        }
        super.onCreate(qBaseActivity, bundle);
        initProfilePhotoHelper();
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        destroyProfilePhotoHelper();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onNewIntent(Intent intent) {
        FriendProfilePhotoHelper friendProfilePhotoHelper;
        super.onNewIntent(intent);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0 || (friendProfilePhotoHelper = this.mPhotoHelper) == null) {
            return;
        }
        friendProfilePhotoHelper.f(intent, stringArrayListExtra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void resetHeaderView(ProfileBaseView profileBaseView) {
        profileBaseView.setProfileArgs(this.mListView, this.mIsFromArkBabyQ);
        profileBaseView.setClickListener(this);
        IComponentCenter componentCenter = getComponentCenter();
        if (componentCenter != null) {
            profileBaseView.setViewLoader(componentCenter.getViewLoader());
        }
        profileBaseView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
        this.mHeaderView = profileBaseView;
        ((FrameLayout) this.mViewContainer).removeAllViews();
        ((FrameLayout) this.mViewContainer).addView(this.mHeaderView);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent
    public void setProfileActivityDelegate(IProfileActivityDelegate iProfileActivityDelegate) {
        super.setProfileActivityDelegate(iProfileActivityDelegate);
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null) {
            this.mListView = iProfileActivityDelegate2.getListView();
        }
    }
}
