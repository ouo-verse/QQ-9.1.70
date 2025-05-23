package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGroupUserInfoRsp;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$QualifyingDegreeInfo;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$UserProfile;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$MDUserProfile;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$QualifyingDegreeInfo;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public class ElegantProfileTroopYuanMengComponent extends BaseProfileTroopMemGameInfoComponent implements View.OnClickListener {
    private static final String APP_ID_YUAN_MENG = "1112198072";
    private static final String DAY_BG_MASK = "#00000000";
    private static final String NIGHT_BG_MASK = "#77000000";
    private static final String TAG = "ElegantProfileTroopYuanMengComponent";
    private com.tencent.mobileqq.gamecenter.data.k authChangedListener;
    private int cardInfoState;
    private boolean isRefreshCardInfo;
    private boolean lastShowFlag;
    private metadream_qgroup_datacard$GetGroupUserInfoRsp mMemberMetaDreamInfo;
    private sgame_skin_wall$MDUserProfile mProfileYuanMengInfo;
    public com.tencent.mobileqq.troop.troopgame.api.b mTroopGameObserver;
    private View recordRootView;
    com.tencent.mobileqq.gamecenter.api.b yuanMengAuthHelperCallback;

    public ElegantProfileTroopYuanMengComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.recordRootView = null;
        this.lastShowFlag = false;
        this.isRefreshCardInfo = true;
        this.mTroopGameObserver = new com.tencent.mobileqq.troop.troopgame.api.b() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopYuanMengComponent.1
            @Override // com.tencent.mobileqq.troop.troopgame.api.b
            protected void onGetTroopMemberMetaDreamCard(boolean z16, String str, String str2, metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp) {
                if (z16 && ((AbsComponent) ElegantProfileTroopYuanMengComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopYuanMengComponent.this).mData).allInOne != null && ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopYuanMengComponent.this).mData).allInOne.uin.equals(String.valueOf(str2))) {
                    ElegantProfileTroopYuanMengComponent.this.mMemberMetaDreamInfo = metadream_qgroup_datacard_getgroupuserinforsp;
                    ElegantProfileTroopYuanMengComponent.this.updateData("onGetTroopMemberMetaDreamCard");
                    return;
                }
                QLog.w(ElegantProfileTroopYuanMengComponent.TAG, 1, "onGetTroopMemberMetaDreamCard fail troop=" + str + ", member=" + str2 + ", mData=" + ((AbsComponent) ElegantProfileTroopYuanMengComponent.this).mData);
            }

            @Override // com.tencent.mobileqq.troop.troopgame.api.b
            protected void onGetTroopMemberYuanMengCard(boolean z16, String str, String str2, sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile) {
                if (z16 && ((AbsComponent) ElegantProfileTroopYuanMengComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopYuanMengComponent.this).mData).allInOne != null && ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopYuanMengComponent.this).mData).allInOne.uin.equals(String.valueOf(str2))) {
                    ElegantProfileTroopYuanMengComponent.this.mProfileYuanMengInfo = sgame_skin_wall_mduserprofile;
                    ElegantProfileTroopYuanMengComponent.this.updateData("onGetTroopMemberYuanMengCard");
                    return;
                }
                QLog.w(ElegantProfileTroopYuanMengComponent.TAG, 1, "onGetTroopMemberYuanMengCard fail troop=" + str + ", member=" + str2 + ", mData=" + ((AbsComponent) ElegantProfileTroopYuanMengComponent.this).mData);
            }
        };
        this.authChangedListener = new com.tencent.mobileqq.gamecenter.data.k() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopYuanMengComponent.2
            @Override // com.tencent.mobileqq.gamecenter.data.k
            public void onAuthRangeChanged(List<com.tencent.mobileqq.gamecenter.data.b> list) {
                if (list == null) {
                    return;
                }
                boolean z16 = false;
                for (com.tencent.mobileqq.gamecenter.data.b bVar : list) {
                    if (bVar.f211987a == 4) {
                        String yuanMengRangeString = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getYuanMengRangeString(MobileQQ.sMobileQQ, bVar.f211988b);
                        HashMap<String, Integer> hashMap = BaseProfileTroopMemGameInfoComponent.GAME_STATE_TO_TEXT_MAP;
                        int intValue = hashMap.containsKey(yuanMengRangeString) ? hashMap.get(yuanMengRangeString).intValue() : 3;
                        if (intValue != ElegantProfileTroopYuanMengComponent.this.cardInfoState) {
                            ElegantProfileTroopYuanMengComponent.this.cardInfoState = intValue;
                            if (ElegantProfileTroopYuanMengComponent.this.isHost()) {
                                z16 = true;
                            }
                        }
                    }
                }
                if (z16) {
                    ElegantProfileTroopYuanMengComponent.this.isRefreshCardInfo = true;
                    ElegantProfileTroopYuanMengComponent.this.updateData("onAuthRangeChanged");
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ElegantProfileTroopYuanMengComponent.TAG, 1, "onAuthRangeChanged cardInfoState=" + ElegantProfileTroopYuanMengComponent.this.cardInfoState + ",bUpdate=" + z16);
                }
            }

            @Override // com.tencent.mobileqq.gamecenter.data.k
            public void onGetRangeUrl(String str, String str2) {
            }
        };
    }

    private List<String> getGameImages() {
        metadream_qgroup_datacard$UserProfile metadream_qgroup_datacard_userprofile;
        sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile = this.mProfileYuanMengInfo;
        if (sgame_skin_wall_mduserprofile != null) {
            List<String> list = sgame_skin_wall_mduserprofile.inner_game_images.get();
            if (list.size() <= 1 || TextUtils.isEmpty(list.get(1))) {
                return null;
            }
            return list;
        }
        metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp = this.mMemberMetaDreamInfo;
        if (metadream_qgroup_datacard_getgroupuserinforsp != null && (metadream_qgroup_datacard_userprofile = metadream_qgroup_datacard_getgroupuserinforsp.user_profile.get()) != null && metadream_qgroup_datacard_userprofile.has()) {
            List<String> list2 = metadream_qgroup_datacard_userprofile.inner_game_images.get();
            if (list2.size() > 1 && !TextUtils.isEmpty(list2.get(1))) {
                return list2;
            }
        }
        return null;
    }

    private boolean getHasRole() {
        sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile = this.mProfileYuanMengInfo;
        if (sgame_skin_wall_mduserprofile != null) {
            return sgame_skin_wall_mduserprofile.has_role.get();
        }
        metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp = this.mMemberMetaDreamInfo;
        return metadream_qgroup_datacard_getgroupuserinforsp != null && metadream_qgroup_datacard_getgroupuserinforsp.switch_err.get() == 0;
    }

    private Pair<String, String> getRank() {
        metadream_qgroup_datacard$UserProfile metadream_qgroup_datacard_userprofile;
        metadream_qgroup_datacard$QualifyingDegreeInfo metadream_qgroup_datacard_qualifyingdegreeinfo;
        sgame_skin_wall$QualifyingDegreeInfo sgame_skin_wall_qualifyingdegreeinfo;
        sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile = this.mProfileYuanMengInfo;
        if (sgame_skin_wall_mduserprofile != null && (sgame_skin_wall_qualifyingdegreeinfo = sgame_skin_wall_mduserprofile.current_qualifying.get()) != null) {
            return new Pair<>(sgame_skin_wall_qualifyingdegreeinfo.qualifying.get(), sgame_skin_wall_qualifyingdegreeinfo.icon_url.get());
        }
        metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp = this.mMemberMetaDreamInfo;
        if (metadream_qgroup_datacard_getgroupuserinforsp == null || (metadream_qgroup_datacard_userprofile = metadream_qgroup_datacard_getgroupuserinforsp.user_profile.get()) == null || !metadream_qgroup_datacard_userprofile.has() || (metadream_qgroup_datacard_qualifyingdegreeinfo = metadream_qgroup_datacard_userprofile.current_qualifying.get()) == null) {
            return null;
        }
        return new Pair<>(metadream_qgroup_datacard_qualifyingdegreeinfo.qualifying.get(), metadream_qgroup_datacard_qualifyingdegreeinfo.icon_url.get());
    }

    private String getRankJumpUrl() {
        String str;
        sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile = this.mProfileYuanMengInfo;
        if (sgame_skin_wall_mduserprofile != null) {
            String str2 = sgame_skin_wall_mduserprofile.jump_url.get();
            return str2 == null ? "" : str2;
        }
        metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp = this.mMemberMetaDreamInfo;
        return (metadream_qgroup_datacard_getgroupuserinforsp == null || (str = metadream_qgroup_datacard_getgroupuserinforsp.jump_url.get()) == null) ? "" : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void hideViewContainer() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            VIEW view = this.mViewContainer;
            if (view != 0) {
                ((View) view).setVisibility(8);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.l
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileTroopYuanMengComponent.this.lambda$hideViewContainer$0();
            }
        });
    }

    private void initPermissionInfo() {
        com.tencent.mobileqq.gamecenter.api.b gameAuthHelper = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getGameAuthHelper(this.mActivity, APP_ID_YUAN_MENG, this.authChangedListener, 1);
        this.yuanMengAuthHelperCallback = gameAuthHelper;
        gameAuthHelper.getAuthFromServer();
    }

    private boolean isCardInfoValid() {
        return !TextUtils.isEmpty(getRankJumpUrl());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isShowSelfCard() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).card != null && this.mApp != null) {
            if (!this.mConfigHelper.isSwitchEnable(16)) {
                QLog.d(TAG, 1, "isShowSelfCard rankCardConfigEnable is off");
                return false;
            }
            if (!isHost()) {
                QLog.i(TAG, 1, "isShowSelfCard isn't host");
                return true;
            }
            int i3 = this.cardInfoState;
            return i3 == 1 || i3 == 2;
        }
        QLog.w(TAG, 1, "isShowSelfCard params invalid");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isTroopGameMDCardEnabled() {
        TroopInfo k3 = ((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin);
        return k3 != null && ((ITroopGameApi) QRoute.api(ITroopGameApi.class)).enableShowGameCard(k3) && k3.isTroopMDGameCardEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$hideViewContainer$0() {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((View) view).setVisibility(8);
        }
    }

    private void layoutGameImage(View view) {
        List<String> gameImages = getGameImages();
        if (gameImages == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.oui);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = imageView.getWidth();
        obtain.mRequestHeight = imageView.getHeight();
        URLDrawable drawable = URLDrawable.getDrawable(gameImages.get(1), obtain);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    private void layoutRankInfo(View view) {
        Pair<String, String> rank = getRank();
        if (rank == null || rank.first == null || rank.second == null) {
            return;
        }
        ((TextView) view.findViewById(R.id.owt)).setText(rank.first);
        ImageView imageView = (ImageView) view.findViewById(R.id.owr);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = imageView.getWidth();
        obtain.mRequestHeight = imageView.getHeight();
        URLDrawable drawable = URLDrawable.getDrawable(rank.second, obtain);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean layoutTitleView(ProfileCardInfo profileCardInfo) {
        View findViewById = ((View) this.mViewContainer).findViewById(R.id.oxl);
        ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.ouy);
        TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.ouk);
        String gender = getGender(profileCardInfo);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            gender = HardCodeUtil.qqStr(R.string.pel);
        }
        String str = gender + this.mActivity.getString(R.string.f160481v5);
        updateItemTheme(null, textView, findViewById, null, imageView);
        if (!getHasRole()) {
            textView.setText(str + this.mActivity.getString(R.string.f160041ty));
            return true;
        }
        textView.setText(this.mActivity.getString(R.string.f160491v6));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean makeOrRefreshGameCardInfoView(ProfileCardInfo profileCardInfo) {
        boolean isShowSelfCard = isShowSelfCard();
        if (isShowSelfCard == this.lastShowFlag) {
            if (!isShowSelfCard) {
                this.isForceHide = true;
            }
            QLog.w(TAG, 2, "makeOrRefreshGameCardInfoView showCardFlag is the same realShowCardFlag=" + isShowSelfCard);
            return false;
        }
        this.lastShowFlag = isShowSelfCard;
        if (this.mActivity != null && profileCardInfo != null && profileCardInfo.allInOne != null && isShowSelfCard && isCardInfoValid()) {
            this.isForceHide = false;
            View view = this.recordRootView;
            if (view != null) {
                view.setVisibility(8);
            }
            ((View) this.mViewContainer).setOnClickListener(this);
            ((View) this.mViewContainer).setTag(getRankJumpUrl());
            ProfileCardDtReportUtil.initElementWithExposure((View) this.mViewContainer, "em_group_fun_party_card");
            if (layoutTitleView(profileCardInfo)) {
                ((View) this.mViewContainer).setVisibility(0);
                QLog.i(TAG, 1, "makeOrRefreshGameCardInfoView no role");
                return true;
            }
            QLog.i(TAG, 1, "makeOrRefreshGameCardInfoView realShowCardFlag=" + isShowSelfCard);
            if (isShowSelfCard) {
                ((View) this.mViewContainer).setVisibility(0);
                showGameRecordView();
            } else {
                ((View) this.mViewContainer).setVisibility(8);
            }
            updateItemTheme(null, (TextView) ((View) this.mViewContainer).findViewById(R.id.ouk), ((View) this.mViewContainer).findViewById(R.id.oxl), null, (ImageView) ((View) this.mViewContainer).findViewById(R.id.ouy));
            return true;
        }
        VIEW view2 = this.mViewContainer;
        if (view2 != 0) {
            ((View) view2).setVisibility(8);
        }
        this.isForceHide = true;
        this.lastShowFlag = false;
        QLog.w(TAG, 2, "makeOrRefreshGameCardInfoView params invalid mProfileYuanMengInfo=" + this.mProfileYuanMengInfo + ",showCardFlag=" + isShowSelfCard + ",mViewContainer=" + this.mViewContainer);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void reportGameCard() {
        String profileCardUin;
        if (this.mData == 0 || !ProfileUtils.isVisible((View) this.mViewContainer) || this.hasReport) {
            return;
        }
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            ProfileCardDtReportUtil.dtReportExpose((View) this.mViewContainer);
        } else {
            boolean equals = this.mApp.getCurrentUin().equals(getProfileCardUin());
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ext4", "8");
            hashMap.put("ext2", String.valueOf(this.cardInfoState));
            if (equals) {
                profileCardUin = "";
            } else {
                profileCardUin = getProfileCardUin();
            }
            hashMap.put("ext29", profileCardUin);
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(APP_ID_YUAN_MENG, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9505", "950501", "915698", "", hashMap);
        }
        this.hasReport = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showGameRecordView() {
        AppInterface appInterface = this.mApp;
        boolean z16 = appInterface != null && ThemeUtil.isInNightMode(appInterface);
        if (this.recordRootView == null) {
            this.recordRootView = ((ViewStub) ((View) this.mViewContainer).findViewById(R.id.oul)).inflate();
        }
        this.recordRootView.setVisibility(0);
        layoutRankViewBg(this.recordRootView, z16);
        layoutRankInfo(this.recordRootView);
        layoutGameInfoTextView(this.recordRootView);
        layoutGameImage(this.recordRootView);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1047;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent
    public String getDataReportElementId() {
        return "em_group_fun_party_card";
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_YUAN_MENG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12, types: [android.view.View, VIEW] */
    @Override // com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent
    public boolean makeOrRefreshEntry(ProfileCardInfo profileCardInfo) {
        boolean isTroopUnitedGameCard = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isTroopUnitedGameCard();
        QLog.d(TAG, 2, "makeOrRefreshEntry isTroopMemberCard=", Boolean.valueOf(((ProfileCardInfo) this.mData).isTroopMemberCard), ", bRefreshGameCard=" + this.bRefreshGameCard, ", isUnitedGameCard=" + isTroopUnitedGameCard);
        if (!((ProfileCardInfo) this.mData).isTroopMemberCard || isTroopUnitedGameCard) {
            return false;
        }
        if (this.mViewContainer == 0) {
            this.mViewContainer = this.mActivity.getLayoutInflater().inflate(R.layout.cyp, (ViewGroup) null);
        }
        if (this.isRefreshCardInfo) {
            requestCardInfo();
            this.isRefreshCardInfo = false;
            hideViewContainer();
            this.isForceHide = true;
            return false;
        }
        this.isForceHide = false;
        return makeOrRefreshGameCardInfoView((ProfileCardInfo) this.mData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            onItemClicked(view, (String) tag);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        this.mApp.addObserver(this.mTroopGameObserver);
        QLog.d(TAG, 1, "onCreate addObserver=" + this.mTroopGameObserver);
        initPermissionInfo();
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        com.tencent.mobileqq.troop.troopgame.api.b bVar;
        QLog.d(TAG, 1, "onDestroy mApp=" + this.mApp + ",removeObserver=" + this.mTroopGameObserver);
        AppInterface appInterface = this.mApp;
        if (appInterface != null && (bVar = this.mTroopGameObserver) != null) {
            appInterface.removeObserver(bVar);
            this.mTroopGameObserver = null;
        }
        super.onDestroy();
    }

    public void onItemClicked(View view, String str) {
        String profileCardUin;
        if (this.mApp != null && !TextUtils.isEmpty(str)) {
            ProfileCardDtReportUtil.dtReportClick(view);
            try {
                if (QAlbumUtil.isNetUrl(str)) {
                    Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str);
                    view.getContext().startActivity(intent);
                } else if (str.startsWith("mqqapi:")) {
                    ax c16 = bi.c((BaseQQAppInterface) this.mApp, view.getContext(), str);
                    if (c16 != null) {
                        c16.b();
                    }
                } else {
                    QLog.e(TAG, 1, "onGameInfoClicked mProfileGameInfo invalid jumpurl:", str);
                }
                boolean equals = this.mApp.getCurrentUin().equals(getProfileCardUin());
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ext4", "20");
                hashMap.put("ext2", String.valueOf(this.cardInfoState));
                if (equals) {
                    profileCardUin = "";
                } else {
                    profileCardUin = getProfileCardUin();
                }
                hashMap.put("ext29", profileCardUin);
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(APP_ID_YUAN_MENG, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9505", "950501", "915699", "", hashMap);
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onGameInfoClicked e:" + th5);
                return;
            }
        }
        QLog.e(TAG, 1, "onGameInfoClicked mProfileGameInfo invalid");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void requestCardInfo() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && ((ProfileCardInfo) data).card != null) {
            if (this.mApp == null) {
                QLog.d(TAG, 2, "requestCardInfo mApp is null");
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(this.mActivity)) {
                QLog.d(TAG, 2, "requestCardInfo network is unavailable");
                return;
            }
            if (StudyModeManager.t()) {
                QLog.d(TAG, 2, "requestCardInfo is studyMode");
                return;
            }
            com.tencent.mobileqq.troop.troopgame.api.a aVar = (com.tencent.mobileqq.troop.troopgame.api.a) this.mApp.getBusinessHandler(BusinessHandlerFactory.TROOP_GAME_HANDLER);
            if (aVar == null) {
                QLog.d(TAG, 2, "requestCardInfo gameHandler is null");
                return;
            }
            DATA data2 = this.mData;
            if (((ProfileCardInfo) data2).isTroopMemberCard) {
                QLog.d(TAG, 2, "requestCardInfo troopUin=", ((ProfileCardInfo) data2).troopUin, ",personUin=" + ((ProfileCardInfo) this.mData).allInOne.uin);
                if (isTroopGameMDCardEnabled()) {
                    DATA data3 = this.mData;
                    aVar.k2(((ProfileCardInfo) data3).troopUin, ((ProfileCardInfo) data3).allInOne.uin);
                    return;
                }
                return;
            }
            if (isHost()) {
                boolean isShowSelfCard = isShowSelfCard();
                QLog.d(TAG, 2, "requestCardInfo myself personUin=", ((ProfileCardInfo) this.mData).allInOne.uin, " isShowCard=", Boolean.valueOf(isShowSelfCard));
                if (isShowSelfCard) {
                    aVar.r2("0", ((ProfileCardInfo) this.mData).allInOne.uin);
                    return;
                }
                return;
            }
            QLog.d(TAG, 2, "requestCardInfo personUin=" + ((ProfileCardInfo) this.mData).allInOne.uin);
            aVar.r2("0", ((ProfileCardInfo) this.mData).allInOne.uin);
            return;
        }
        QLog.w(TAG, 2, "requestCardInfo mData is not ready");
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        this.hasReport = false;
        super.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 0 && ProfileUtils.isVisible((View) this.mViewContainer)) {
            ((View) this.mViewContainer).post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopYuanMengComponent.3
                @Override // java.lang.Runnable
                public void run() {
                    ElegantProfileTroopYuanMengComponent.this.reportGameCard();
                }
            });
        }
    }

    private void layoutGameInfoTextView(View view) {
        metadream_qgroup_datacard$UserProfile metadream_qgroup_datacard_userprofile;
        TextView textView = (TextView) view.findViewById(R.id.oxa);
        TextView textView2 = (TextView) view.findViewById(R.id.ox_);
        TextView textView3 = (TextView) view.findViewById(R.id.ox9);
        TextView textView4 = (TextView) view.findViewById(R.id.ox8);
        sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile = this.mProfileYuanMengInfo;
        if (sgame_skin_wall_mduserprofile != null) {
            textView2.setText(String.valueOf(sgame_skin_wall_mduserprofile.championship_battle_times.get()));
            textView.setText(String.valueOf(this.mProfileYuanMengInfo.total_battle_times.get()));
            textView3.setText(String.valueOf(this.mProfileYuanMengInfo.played_maps.get()));
            textView4.setText(String.valueOf(this.mProfileYuanMengInfo.costume_count.get()));
            return;
        }
        metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp = this.mMemberMetaDreamInfo;
        if (metadream_qgroup_datacard_getgroupuserinforsp == null || (metadream_qgroup_datacard_userprofile = metadream_qgroup_datacard_getgroupuserinforsp.user_profile.get()) == null || !metadream_qgroup_datacard_userprofile.has()) {
            return;
        }
        textView2.setText(String.valueOf(metadream_qgroup_datacard_userprofile.championship_battle_times.get()));
        textView.setText(String.valueOf(metadream_qgroup_datacard_userprofile.total_battle_times.get()));
        textView3.setText(String.valueOf(metadream_qgroup_datacard_userprofile.played_maps.get()));
        textView4.setText(String.valueOf(metadream_qgroup_datacard_userprofile.costume_count.get()));
    }

    private void layoutRankViewBg(View view, boolean z16) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.ouf);
        if (z16) {
            str = NIGHT_BG_MASK;
        } else {
            str = DAY_BG_MASK;
        }
        imageView.setBackgroundColor(Color.parseColor(str));
    }
}
