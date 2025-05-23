package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopMemGameInfoComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.RoundRectImageView;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public class ElegantProfileTroopMemGameInfoComponent extends BaseProfileTroopMemGameInfoComponent implements View.OnClickListener {
    private static final String ADTAG_BASE = "basic_namecard";
    private static final String ADTAG_JICHU = "jichu_personalcard";
    private static final String COMM_BG_URL = "https://img.gamecenter.qq.com/xgame/gm/1675150779056_1bf6336eb94725606f979d0bd0c31d0e.png";
    private static final String DAY_BG_MASK = "#00000000";
    private static final String GAME_CARD_COMM_BG_NAME = "king_new_bg2.png";
    private static final String GAME_MEMBER_GAME_CARD_BG_NAME_ELEGANT = "king_new_bg1.png";
    private static final String GAME_SKIN_LEVE_ICON_NAME = "game_collectlevel_%d.png";
    private static final String GLORY_OF_KINGS = "1104466820";
    private static final int HERO_NUMBER = 3;
    private static final String LIGHT_TEXT_COLOR = "#80ffffff";
    private static final int MAX_DIGITS = 2;
    private static final int MAX_GRADE_LEVEL = 8;
    private static final String NIGHT_BG_MASK = "#77000000";
    private static final String NIGHT_TEXT_COLOR = "#98989F";
    private static final String RANK_BG_URL = "https://downv6.qq.com/extendfriend/king_of_honor.png";
    private static final float REQUEST_BG_RADIUS = 4.0f;
    private static final int REQUEST_HERO_RADIUS = 16;
    private static final float REQUEST_HERO_WIDTH = 20.0f;
    private static final String TAG = "EProfileTroopMemGameInfoComponent";
    private static final int TEXT_SIZE = 10;
    private View allInOneRootView;
    private com.tencent.mobileqq.gamecenter.data.k authChangedListener;
    com.tencent.mobileqq.gamecenter.api.b gameAuthHelperCallback;
    private boolean hasReportExposure;
    private int lastShowFlag;
    private ProfileGameInfo mProfileGameInfo;
    public com.tencent.mobileqq.troop.troopgame.api.b mTroopGameObserver;
    private TroopMemberInfo mTroopMemberInfo;
    private View recordRootView;
    private View skinRootView;
    private int wzCardInfoState;
    private int wzSkinInfoState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopMemGameInfoComponent$2, reason: invalid class name */
    /* loaded from: classes35.dex */
    public class AnonymousClass2 extends com.tencent.mobileqq.troop.troopgame.api.b {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onGetTroopMemberGameCard$0(TroopMemberInfo troopMemberInfo) {
            ElegantProfileTroopMemGameInfoComponent.this.mTroopMemberInfo = troopMemberInfo;
            ElegantProfileTroopMemGameInfoComponent.this.updateData("onGetTroopMemberGameCard");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onGetTroopMemberGameCard$1(final TroopMemberInfo troopMemberInfo) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.j
                @Override // java.lang.Runnable
                public final void run() {
                    ElegantProfileTroopMemGameInfoComponent.AnonymousClass2.this.lambda$onGetTroopMemberGameCard$0(troopMemberInfo);
                }
            });
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onGetTroopMemberGameCard(boolean z16, String str, String str2, ProfileGameInfo profileGameInfo) {
            QLog.d(ElegantProfileTroopMemGameInfoComponent.TAG, 1, "onGetTroopMemberGameCard isSuccess=" + z16 + ", info=" + profileGameInfo);
            if (!z16 || ((AbsComponent) ElegantProfileTroopMemGameInfoComponent.this).mData == null || ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemGameInfoComponent.this).mData).allInOne == null || !((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemGameInfoComponent.this).mData).allInOne.uin.equals(String.valueOf(str2))) {
                return;
            }
            ElegantProfileTroopMemGameInfoComponent.this.mProfileGameInfo = profileGameInfo;
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfoWithExtInfo(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemGameInfoComponent.this).mData).troopUin, ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemGameInfoComponent.this).mData).allInOne.uin, false, ((AbsComponent) ElegantProfileTroopMemGameInfoComponent.this).mActivity, ElegantProfileTroopMemGameInfoComponent.TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.k
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    ElegantProfileTroopMemGameInfoComponent.AnonymousClass2.this.lambda$onGetTroopMemberGameCard$1(troopMemberInfo);
                }
            });
        }
    }

    public ElegantProfileTroopMemGameInfoComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.recordRootView = null;
        this.skinRootView = null;
        this.allInOneRootView = null;
        this.lastShowFlag = 0;
        this.hasReportExposure = false;
        this.authChangedListener = new com.tencent.mobileqq.gamecenter.data.k() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopMemGameInfoComponent.1
            @Override // com.tencent.mobileqq.gamecenter.data.k
            public void onAuthRangeChanged(List<com.tencent.mobileqq.gamecenter.data.b> list) {
                if (list == null) {
                    return;
                }
                boolean z16 = false;
                for (com.tencent.mobileqq.gamecenter.data.b bVar : list) {
                    String rangeString = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getRangeString(MobileQQ.sMobileQQ, bVar.f211988b);
                    int i3 = bVar.f211987a;
                    if (i3 == 4 || i3 == 3) {
                        HashMap<String, Integer> hashMap = BaseProfileTroopMemGameInfoComponent.GAME_STATE_TO_TEXT_MAP;
                        int intValue = hashMap.containsKey(rangeString) ? hashMap.get(rangeString).intValue() : 1;
                        int i16 = bVar.f211987a;
                        if (i16 == 4) {
                            if (intValue != ElegantProfileTroopMemGameInfoComponent.this.wzCardInfoState) {
                                ElegantProfileTroopMemGameInfoComponent.this.wzCardInfoState = intValue;
                                if (ElegantProfileTroopMemGameInfoComponent.this.isHost()) {
                                    z16 = true;
                                }
                            }
                        } else if (i16 == 3 && intValue != ElegantProfileTroopMemGameInfoComponent.this.wzSkinInfoState) {
                            ElegantProfileTroopMemGameInfoComponent.this.wzSkinInfoState = intValue;
                            if (ElegantProfileTroopMemGameInfoComponent.this.isHost()) {
                                z16 = true;
                            }
                        }
                    }
                }
                if (z16) {
                    ElegantProfileTroopMemGameInfoComponent elegantProfileTroopMemGameInfoComponent = ElegantProfileTroopMemGameInfoComponent.this;
                    elegantProfileTroopMemGameInfoComponent.bRefreshGameCard = true;
                    elegantProfileTroopMemGameInfoComponent.updateData("onAuthRangeChanged");
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ElegantProfileTroopMemGameInfoComponent.TAG, 1, "onAuthRangeChanged wzCardInfoState=" + ElegantProfileTroopMemGameInfoComponent.this.wzCardInfoState + ",wzSkinInfoState=" + ElegantProfileTroopMemGameInfoComponent.this.wzSkinInfoState + ",bUpdate=" + z16);
                }
            }

            @Override // com.tencent.mobileqq.gamecenter.data.k
            public void onGetRangeUrl(String str, String str2) {
            }
        };
        this.mTroopGameObserver = new AnonymousClass2();
    }

    private String getElegantMemberGameCardBgImagePath(String str) {
        String troopGameCardResDownloadPath = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
        if (TextUtils.isEmpty(troopGameCardResDownloadPath)) {
            return null;
        }
        return troopGameCardResDownloadPath + str;
    }

    private String getRankJumpUrl() {
        ProfileGameInfo profileGameInfo = this.mProfileGameInfo;
        if (profileGameInfo != null && profileGameInfo.validRankJumpParams()) {
            StringBuilder sb5 = new StringBuilder("https://speed.gamecenter.qq.com/pushgame/v1/game-profile/sgame?_wv=134&_wwv=2&source=4");
            if (!TextUtils.isEmpty(this.mProfileGameInfo.encrptOpenId)) {
                sb5.append("&uid=");
                sb5.append(this.mProfileGameInfo.encrptOpenId);
            }
            if (!TextUtils.isEmpty(this.mProfileGameInfo.partition)) {
                sb5.append("&partition=");
                sb5.append(this.mProfileGameInfo.partition);
            }
            if (!TextUtils.isEmpty(this.mProfileGameInfo.platid)) {
                sb5.append("&platID=");
                sb5.append(this.mProfileGameInfo.platid);
            }
            if (!TextUtils.isEmpty(this.mProfileGameInfo.area)) {
                sb5.append("&area=");
                sb5.append(this.mProfileGameInfo.area);
            }
            return sb5.toString();
        }
        return "";
    }

    private String getSkinJumpUrl(String str) {
        if (this.mProfileGameInfo == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder("https://static.gamecenter.qq.com/xgame/gc-assets/pages/open-hippy.html?bundleName=QQGameCenterSgameSkins");
        sb5.append("&adTag=");
        sb5.append(str);
        sb5.append("&partition=");
        sb5.append(this.mProfileGameInfo.skinPartition);
        if (!TextUtils.isEmpty(this.mProfileGameInfo.skinRoleId)) {
            sb5.append("&roleid=");
            sb5.append(this.mProfileGameInfo.skinRoleId);
        }
        return sb5.toString();
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
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.h
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileTroopMemGameInfoComponent.this.lambda$hideViewContainer$1();
            }
        });
    }

    private void initWzPermissionInfo() {
        com.tencent.mobileqq.gamecenter.api.b gameAuthHelper = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getGameAuthHelper(this.mActivity, "1104466820", this.authChangedListener);
        this.gameAuthHelperCallback = gameAuthHelper;
        gameAuthHelper.getAuthFromServer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isTroopGameHOKCardEnabled() {
        TroopInfo k3 = ((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin);
        return k3 != null && ((ITroopGameApi) QRoute.api(ITroopGameApi.class)).enableShowGameCard(k3) && k3.isTroopHOKGameCardEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$hideViewContainer$1() {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((View) view).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$requestGameCardSwitch$0(Boolean bool) {
        onGetGameCardSwitch(bool.booleanValue());
        return null;
    }

    private void layoutAvatarListView(View view) {
        int size = this.mProfileGameInfo.bestHeroList.size();
        ArrayList arrayList = new ArrayList(3);
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.f778245e);
        RoundRectImageView roundRectImageView2 = (RoundRectImageView) view.findViewById(R.id.f778345f);
        RoundRectImageView roundRectImageView3 = (RoundRectImageView) view.findViewById(R.id.f778445g);
        roundRectImageView.setCornerRadiusAndMode(16, 1);
        roundRectImageView2.setCornerRadiusAndMode(16, 1);
        roundRectImageView3.setCornerRadiusAndMode(16, 1);
        arrayList.add(roundRectImageView);
        arrayList.add(roundRectImageView2);
        arrayList.add(roundRectImageView3);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (i3 >= size) {
                ((RoundRectImageView) arrayList.get(i3)).setVisibility(8);
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = ViewUtils.dpToPx(20.0f);
                obtain.mRequestHeight = ViewUtils.dpToPx(20.0f);
                URLDrawable drawable = URLDrawable.getDrawable(this.mProfileGameInfo.bestHeroList.get(i3).heroIcon, obtain);
                if (drawable != null) {
                    drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(obtain.mRequestWidth, obtain.mRequestHeight, 16));
                    ((RoundRectImageView) arrayList.get(i3)).setImageDrawable(drawable);
                }
                ((RoundRectImageView) arrayList.get(i3)).setVisibility(0);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean layoutTitleView(ProfileCardInfo profileCardInfo) {
        View findViewById = ((View) this.mViewContainer).findViewById(R.id.joy);
        ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.dcv);
        TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.crc);
        String gender = getGender(profileCardInfo);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            gender = HardCodeUtil.qqStr(R.string.pel);
        }
        String str = gender + this.mActivity.getString(R.string.f160471v4);
        updateItemTheme(null, textView, findViewById, null, imageView);
        ProfileGameInfo profileGameInfo = this.mProfileGameInfo;
        if (profileGameInfo != null && !profileGameInfo.isEmpty()) {
            textView.setText(this.mActivity.getString(R.string.f160051tz));
            return false;
        }
        if (profileCardInfo.allInOne.f260789pa != 0) {
            return true;
        }
        textView.setText(str + this.mActivity.getString(R.string.f160041ty));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean makeOrRefreshGameCardInfoView(ProfileCardInfo profileCardInfo) {
        ProfileGameInfo profileGameInfo;
        int showCardFlag = getShowCardFlag();
        QLog.w(TAG, 1, "makeOrRefreshGameCardInfoView showCardFlag=" + showCardFlag);
        if ((showCardFlag & 1) == 1 && !validFlagData(1)) {
            showCardFlag &= -2;
        }
        if ((showCardFlag & 2) == 2 && !validFlagData(2)) {
            showCardFlag &= -3;
        }
        if (showCardFlag == this.lastShowFlag) {
            if (showCardFlag == 0) {
                this.isForceHide = true;
            }
            QLog.w(TAG, 2, "makeOrRefreshGameCardInfoView showCardFlag is the same realShowCardFlag=" + showCardFlag);
            return false;
        }
        this.lastShowFlag = showCardFlag;
        if (this.mActivity != null && profileCardInfo != null && profileCardInfo.allInOne != null && showCardFlag != 0 && (profileGameInfo = this.mProfileGameInfo) != null && !profileGameInfo.isEmpty()) {
            this.isForceHide = false;
            View view = this.recordRootView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.skinRootView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.allInOneRootView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            if (layoutTitleView(profileCardInfo)) {
                return true;
            }
            boolean z16 = (showCardFlag & 1) == 1;
            boolean z17 = (showCardFlag & 2) == 2;
            ITroopGameCardService iTroopGameCardService = (ITroopGameCardService) this.mApp.getRuntimeService(ITroopGameCardService.class, "");
            boolean isNewCardEnable = iTroopGameCardService != null ? iTroopGameCardService.isNewCardEnable() : false;
            QLog.i(TAG, 1, "makeOrRefreshGameCardInfoView realShowCardFlag=" + showCardFlag + ",isNewCardEnable=" + isNewCardEnable + ",showRecord=" + z16 + ",showSkin=" + z17);
            if (isNewCardEnable) {
                ((View) this.mViewContainer).setVisibility(0);
                if (z16 && z17) {
                    showGameAllInOneView();
                    ((View) this.mViewContainer).setTag(getRankJumpUrl());
                } else if (z16) {
                    showGameRecordView();
                    ((View) this.mViewContainer).setTag(getRankJumpUrl());
                } else if (z17) {
                    showGameSkinView();
                    ((View) this.mViewContainer).setTag(getSkinJumpUrl(ADTAG_JICHU));
                }
            } else if (z16) {
                ((View) this.mViewContainer).setVisibility(0);
                showGameRecordView();
                ((View) this.mViewContainer).setTag(getRankJumpUrl());
            } else {
                ((View) this.mViewContainer).setVisibility(8);
            }
            ((View) this.mViewContainer).setOnClickListener(this);
            return true;
        }
        VIEW view4 = this.mViewContainer;
        if (view4 != 0) {
            ((View) view4).setVisibility(8);
        }
        this.isForceHide = true;
        this.lastShowFlag = 0;
        QLog.w(TAG, 2, "makeOrRefreshGameCardInfoView params invalid mProfileGameInfo=" + this.mProfileGameInfo + ",showCardFlag=" + showCardFlag + ",mViewContainer=" + this.mViewContainer);
        return false;
    }

    private int memberGameCardFlag() {
        TroopMemberInfoExt troopMemberInfoExt;
        TroopMemberInfo troopMemberInfo = this.mTroopMemberInfo;
        if (troopMemberInfo == null || (troopMemberInfoExt = troopMemberInfo.extInfo) == null) {
            return 0;
        }
        long j3 = troopMemberInfoExt.flagEx3;
        int i3 = (1 & j3) == 0 ? 1 : 0;
        return (j3 & 2) == 0 ? i3 | 2 : i3;
    }

    private void reportExposure() {
        String str;
        AppInterface appInterface = this.mApp;
        if (appInterface == null || this.hasReportExposure) {
            return;
        }
        boolean equals = appInterface.getCurrentUin().equals(getProfileCardUin());
        IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
        if (equals) {
            str = "1";
        } else {
            str = "2";
        }
        iGameMsgHelperApi.reportForGameMsg("1104466820", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "8939", "893907", "208848", "", "", "8", str);
        this.hasReportExposure = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void reportGameCard() {
        DATA data = this.mData;
        if (data != 0 && !((ProfileCardInfo) data).isTroopMemberCard && ProfileUtils.isVisible((View) this.mViewContainer) && !this.hasReport) {
            ReportController.o(this.mApp, "dc00898", "", "", "0X800B5EF", "0X800B5EF", 0, 0, "0", "0", "", "");
            this.hasReport = true;
        }
        reportExposure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void requestGameCardSwitch() {
        AppInterface appInterface;
        if (NetworkUtil.isNetworkAvailable(this.mActivity) && (appInterface = this.mApp) != null) {
            TroopInfo k3 = ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin);
            checkAndUpdateTroopInfo(k3);
            if (k3 != null) {
                QLog.d(TAG, 2, "requestTroopMemberInfo getMemberGameCardSwitch");
                ITroopMemberExtInfoRepoApi iTroopMemberExtInfoRepoApi = (ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class);
                DATA data = this.mData;
                iTroopMemberExtInfoRepoApi.fetchTroopMemberGameInfo(((ProfileCardInfo) data).troopUin, ((ProfileCardInfo) data).allInOne.uin, this.mActivity, new Function1() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$requestGameCardSwitch$0;
                        lambda$requestGameCardSwitch$0 = ElegantProfileTroopMemGameInfoComponent.this.lambda$requestGameCardSwitch$0((Boolean) obj);
                        return lambda$requestGameCardSwitch$0;
                    }
                });
                return;
            }
            QLog.w(TAG, 2, "requestTroopMemberInfo getTroopMemberCardInfo troopInfo null");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("requestTroopMemberInfo isNetworkAvailable = false, mApp is null: ");
        sb5.append(this.mApp == null);
        QLog.d(TAG, 2, sb5.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int selfGameCardFlag() {
        DATA data = this.mData;
        boolean z16 = false;
        if (data != 0 && ((ProfileCardInfo) data).card != null && this.mApp != null) {
            boolean isSwitchEnable = this.mConfigHelper.isSwitchEnable(14);
            boolean isSwitchEnable2 = this.mConfigHelper.isSwitchEnable(15);
            if (!isSwitchEnable && !isSwitchEnable2) {
                QLog.d(TAG, 1, "selfGameCardFlag rankCardConfigEnable and skinCardConfigEnable is off");
                return 0;
            }
            if (!isHost()) {
                QLog.i(TAG, 1, "selfGameCardFlag not host");
                return 3;
            }
            QLog.i(TAG, 1, "selfGameCardFlag isHost");
            int i3 = this.wzCardInfoState;
            int i16 = (i3 == 1 || (i3 == 2 && isHost())) ? 1 : 0;
            int i17 = this.wzSkinInfoState;
            if (i17 == 1 || (i17 == 2 && isHost())) {
                z16 = true;
            }
            return z16 ? i16 | 2 : i16;
        }
        QLog.w(TAG, 1, "selfGameCardFlag params invalid");
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showGameAllInOneView() {
        AppInterface appInterface = this.mApp;
        boolean z16 = appInterface != null && ThemeUtil.isInNightMode(appInterface);
        if (this.allInOneRootView == null) {
            this.allInOneRootView = ((ViewStub) ((View) this.mViewContainer).findViewById(R.id.vhr)).inflate();
        }
        this.allInOneRootView.setVisibility(0);
        RoundRectImageView updateLayoutBackgroud = updateLayoutBackgroud(this.allInOneRootView, R.id.f85874q5, 16);
        if (updateLayoutBackgroud != null) {
            updateLayoutBackgroud.setOnClickListener(this);
            updateLayoutBackgroud.setTag(getSkinJumpUrl(ADTAG_JICHU));
        }
        RoundRectImageView updateLayoutBackgroud2 = updateLayoutBackgroud(this.allInOneRootView, R.id.f70173kq, 16);
        if (updateLayoutBackgroud2 != null) {
            updateLayoutBackgroud2.setOnClickListener(this);
            updateLayoutBackgroud2.setTag(getRankJumpUrl());
        }
        updateGradeIconView(this.allInOneRootView);
        updateRecordCountView(this.allInOneRootView, z16);
        updateSkinCountView(this.allInOneRootView);
        updateSkinIconView(this.allInOneRootView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showGameRecordView() {
        AppInterface appInterface = this.mApp;
        boolean z16 = appInterface != null && ThemeUtil.isInNightMode(appInterface);
        if (this.recordRootView == null) {
            this.recordRootView = ((ViewStub) ((View) this.mViewContainer).findViewById(R.id.vjt)).inflate();
        }
        this.recordRootView.setVisibility(0);
        layoutRankViewBg(this.recordRootView, z16);
        updateGradeIconView(this.recordRootView);
        updateRecordCountView(this.recordRootView, z16);
        layoutGameInfoTextView(this.recordRootView, z16);
        try {
            layoutAvatarListView(this.recordRootView);
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "showGameRecordView exception", th5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showGameSkinView() {
        if (this.skinRootView == null) {
            this.skinRootView = ((ViewStub) ((View) this.mViewContainer).findViewById(R.id.vjx)).inflate();
        }
        this.skinRootView.setVisibility(0);
        ((TextView) ((View) this.mViewContainer).findViewById(R.id.crc)).setText(this.mActivity.getString(R.string.f160311uo));
        TextView textView = (TextView) this.skinRootView.findViewById(R.id.f85804py);
        TextView textView2 = (TextView) this.skinRootView.findViewById(R.id.f85824q0);
        TextView textView3 = (TextView) this.skinRootView.findViewById(R.id.f85814pz);
        textView.setText(String.valueOf(this.mProfileGameInfo.currSkinCount));
        textView2.setText("/" + this.mProfileGameInfo.skinTotal);
        textView3.setText(String.valueOf(this.mProfileGameInfo.skinPrice));
        layoutSkinListView(this.skinRootView);
    }

    private RoundRectImageView updateLayoutBackgroud(View view, int i3, int i16) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(i3);
        if (roundRectImageView == null) {
            return null;
        }
        roundRectImageView.setCornerRadiusAndMode(i16, 1);
        Bitmap imageBitmap = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(getElegantMemberGameCardBgImagePath(GAME_CARD_COMM_BG_NAME));
        if (imageBitmap != null) {
            roundRectImageView.setImageBitmap(imageBitmap);
        } else {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = roundRectImageView.getWidth();
            obtain.mRequestHeight = roundRectImageView.getHeight();
            URLDrawable drawable = URLDrawable.getDrawable(COMM_BG_URL, obtain);
            if (drawable != null) {
                roundRectImageView.setBackground(drawable);
            }
        }
        return roundRectImageView;
    }

    private boolean validFlagData(int i3) {
        if (this.mProfileGameInfo == null) {
            return false;
        }
        if (i3 == 1) {
            return !r0.isRankEmpty();
        }
        if (i3 == 2) {
            return !r0.isSkinEmpty();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1028;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_TROOP_GAME_INFO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getShowCardFlag() {
        int i3 = 0;
        if (this.mData == 0) {
            return 0;
        }
        if (StudyModeManager.t()) {
            QLog.d(TAG, 2, "getShowCardFlag is study mode");
            return 0;
        }
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            if (isTroopGameHOKCardEnabled()) {
                i3 = memberGameCardFlag();
            }
        } else {
            i3 = selfGameCardFlag();
        }
        QLog.d(TAG, 2, "getShowCardFlag showFlag = " + i3);
        return i3;
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
            this.mViewContainer = this.mActivity.getLayoutInflater().inflate(R.layout.e6p, (ViewGroup) null);
        }
        if (this.bRefreshGameCard) {
            requestGameCardInfo();
            this.bRefreshGameCard = false;
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
            onGameInfoClicked(view, (String) tag);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        this.mApp.addObserver(this.mTroopGameObserver);
        QLog.d(TAG, 1, "onCreate addObserver=" + this.mTroopGameObserver);
        initWzPermissionInfo();
        reportExposure();
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
        com.tencent.mobileqq.gamecenter.api.b bVar2 = this.gameAuthHelperCallback;
        if (bVar2 != null) {
            bVar2.onDestroy();
            this.gameAuthHelperCallback = null;
        }
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onGetGameCardSwitch(boolean z16) {
        DATA data;
        QLog.d(TAG, 1, "onGetMemberGameCardSwitch.isSuccess = " + z16);
        if (!z16 || (data = this.mData) == 0 || ((ProfileCardInfo) data).allInOne == null) {
            return;
        }
        requestGameCardInfo(((ProfileCardInfo) data).troopUin, ((ProfileCardInfo) data).allInOne.uin);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void requestGameCardInfo() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && ((ProfileCardInfo) data).card != null) {
            if (StudyModeManager.t()) {
                QLog.d(TAG, 2, "requestGameCardInfo is studyMode");
                return;
            }
            if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
                boolean isTroopGameHOKCardEnabled = isTroopGameHOKCardEnabled();
                QLog.d(TAG, 2, "requestGameCardInfo isTroopGameHOKCardEnabled=" + isTroopGameHOKCardEnabled);
                if (isTroopGameHOKCardEnabled) {
                    requestGameCardSwitch();
                    return;
                }
                return;
            }
            int selfGameCardFlag = selfGameCardFlag();
            if (selfGameCardFlag != 0) {
                requestGameCardInfo("0", ((ProfileCardInfo) this.mData).allInOne.uin);
            }
            QLog.d(TAG, 2, "requestGameCardInfo.showFlag = " + selfGameCardFlag + ", isHost = " + isHost());
            return;
        }
        QLog.w(TAG, 2, "requestGameCardInfo mData is not ready");
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        this.hasReport = false;
        super.onResume();
    }

    private void layoutSkinListView(View view) {
        int dpToPx = ViewUtils.dpToPx(4.0f);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.vjw);
        linearLayout.removeAllViews();
        updateLayoutBackgroud(view, R.id.f85884q6, dpToPx);
        if (this.mProfileGameInfo.skinGroupList.size() > 0) {
            try {
                LayoutInflater layoutInflater = this.mActivity.getLayoutInflater();
                Iterator<ProfileGameInfo.SkinGroupInfo> it = this.mProfileGameInfo.skinGroupList.iterator();
                while (it.hasNext()) {
                    ProfileGameInfo.SkinGroupInfo next = it.next();
                    View inflate = layoutInflater.inflate(R.layout.e6s, (ViewGroup) linearLayout, false);
                    ((TextView) inflate.findViewById(R.id.f86064qn)).setText(next.skinName + "\n" + next.skinCount + "/" + next.skinTotal);
                    inflate.setOnClickListener(this);
                    inflate.setTag(getSkinJumpUrl(ADTAG_BASE));
                    linearLayout.addView(inflate);
                    RoundRectImageView roundRectImageView = (RoundRectImageView) inflate.findViewById(R.id.f85964qd);
                    roundRectImageView.setCornerRadiusAndMode(dpToPx, 1);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestWidth = roundRectImageView.getWidth();
                    obtain.mRequestHeight = roundRectImageView.getHeight();
                    URLDrawable drawable = URLDrawable.getDrawable(next.skinPic, obtain);
                    if (drawable != null) {
                        roundRectImageView.setImageDrawable(drawable);
                    }
                }
                View inflate2 = layoutInflater.inflate(R.layout.e6t, (ViewGroup) linearLayout, false);
                inflate2.setOnClickListener(this);
                inflate2.setTag(getSkinJumpUrl(ADTAG_JICHU));
                linearLayout.addView(inflate2);
            } catch (Throwable th5) {
                QLog.e(TAG, 2, "layoutSkinListView exception", th5);
            }
        }
    }

    private void onGameInfoClicked(View view, String str) {
        String str2;
        if (this.mProfileGameInfo != null && this.mApp != null && !TextUtils.isEmpty(str)) {
            ProfileCardDtReportUtil.dtReportClick(view);
            if (!((IGameMsgManagerService) this.mApp.getRuntimeService(IGameMsgManagerService.class, "")).isJumpGameProfileCard()) {
                QLog.e(TAG, 1, "onGameInfoClicked isJumpGameProfileCard is off");
                return;
            }
            try {
                Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str);
                view.getContext().startActivity(intent);
                boolean equals = this.mApp.getCurrentUin().equals(getProfileCardUin());
                IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
                if (equals) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                iGameMsgHelperApi.reportForGameMsg("1104466820", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "8939", "893907", "208848", "", str, "20", str2);
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onGameInfoClicked e:" + th5);
                return;
            }
        }
        QLog.e(TAG, 1, "onGameInfoClicked mProfileGameInfo invalid");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 0 && ProfileUtils.isVisible((View) this.mViewContainer)) {
            ((View) this.mViewContainer).post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopMemGameInfoComponent.3
                @Override // java.lang.Runnable
                public void run() {
                    ElegantProfileTroopMemGameInfoComponent.this.reportGameCard();
                }
            });
        }
    }

    private void layoutGameInfoTextView(View view, boolean z16) {
        String str;
        String str2;
        TextView textView = (TextView) view.findViewById(R.id.f165382vr4);
        String occupationTypeText = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getOccupationTypeText(this.mProfileGameInfo.bestOccupation);
        if (!TextUtils.isEmpty(occupationTypeText)) {
            textView.setText(occupationTypeText);
        }
        ((TextView) view.findViewById(R.id.zlj)).setText(String.valueOf(this.mProfileGameInfo.mvpTotal));
        TextView textView2 = (TextView) view.findViewById(R.id.zli);
        TextView textView3 = (TextView) view.findViewById(R.id.f165381vr3);
        TextView textView4 = (TextView) view.findViewById(R.id.f165380vr2);
        String str3 = NIGHT_TEXT_COLOR;
        if (z16) {
            str = NIGHT_TEXT_COLOR;
        } else {
            str = LIGHT_TEXT_COLOR;
        }
        textView2.setTextColor(Color.parseColor(str));
        if (z16) {
            str2 = NIGHT_TEXT_COLOR;
        } else {
            str2 = LIGHT_TEXT_COLOR;
        }
        textView3.setTextColor(Color.parseColor(str2));
        if (!z16) {
            str3 = LIGHT_TEXT_COLOR;
        }
        textView4.setTextColor(Color.parseColor(str3));
    }

    private void layoutRankViewBg(View view, boolean z16) {
        URLDrawable uRLDrawable;
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.vic);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.vie);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.vid);
        String elegantMemberGameCardBgImagePath = getElegantMemberGameCardBgImagePath(GAME_CARD_COMM_BG_NAME);
        String elegantMemberGameCardBgImagePath2 = getElegantMemberGameCardBgImagePath(GAME_MEMBER_GAME_CARD_BG_NAME_ELEGANT);
        Bitmap imageBitmap = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(elegantMemberGameCardBgImagePath);
        Bitmap imageBitmap2 = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(elegantMemberGameCardBgImagePath2);
        if (imageBitmap != null && imageBitmap2 != null) {
            imageView.setImageBitmap(imageBitmap);
            imageView2.setImageBitmap(imageBitmap2);
        } else {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = imageView.getWidth();
            obtain.mRequestHeight = imageView.getHeight();
            try {
                uRLDrawable = URLDrawable.getDrawable(RANK_BG_URL, obtain);
            } catch (Exception e16) {
                QLog.e(TAG, 2, "layoutCardViewBg exception", e16);
                uRLDrawable = null;
            }
            if (uRLDrawable != null) {
                imageView.setBackground(uRLDrawable);
            }
        }
        if (z16) {
            str = NIGHT_BG_MASK;
        } else {
            str = DAY_BG_MASK;
        }
        imageView3.setBackgroundColor(Color.parseColor(str));
    }

    private void updateGradeIconView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f70373l_);
        if (imageView != null && this.mProfileGameInfo.mGrade / 100000 < 8) {
            Bitmap imageBitmap = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeNumberIconPathById(this.mProfileGameInfo.mGrade));
            if (imageBitmap != null) {
                imageView.setImageBitmap(imageBitmap);
            }
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.hva);
        if (imageView2 != null) {
            Bitmap imageBitmap2 = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeIconPathById(this.mProfileGameInfo.mGrade));
            if (imageBitmap2 != null) {
                imageView2.setImageBitmap(imageBitmap2);
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.f70443lg);
        if (textView != null) {
            String gradeDescById = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getGradeDescById(this.mProfileGameInfo.mGrade);
            if (TextUtils.isEmpty(gradeDescById)) {
                return;
            }
            textView.setText(gradeDescById);
            view.setContentDescription(this.mActivity.getString(R.string.f1637123v) + gradeDescById);
        }
    }

    private void updateRecordCountView(View view, boolean z16) {
        String str;
        ((TextView) view.findViewById(R.id.f100505so)).setText(String.valueOf(this.mProfileGameInfo.gamesTotal));
        TextView textView = (TextView) view.findViewById(R.id.f124757k8);
        try {
            NumberFormat percentInstance = NumberFormat.getPercentInstance();
            percentInstance.setMaximumFractionDigits(2);
            String format = percentInstance.format(this.mProfileGameInfo.seasonWinRate);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(ViewUtils.dpToPx(10.0f)), format.length() - 1, format.length(), 17);
            textView.setText(spannableStringBuilder);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        TextView textView2 = (TextView) view.findViewById(R.id.f100495sn);
        TextView textView3 = (TextView) view.findViewById(R.id.f124747k7);
        String str2 = NIGHT_TEXT_COLOR;
        if (z16) {
            str = NIGHT_TEXT_COLOR;
        } else {
            str = LIGHT_TEXT_COLOR;
        }
        textView2.setTextColor(Color.parseColor(str));
        if (!z16) {
            str2 = LIGHT_TEXT_COLOR;
        }
        textView3.setTextColor(Color.parseColor(str2));
    }

    private void updateSkinCountView(View view) {
        ((TextView) view.findViewById(R.id.f74843xc)).setText(getSkinHonorText(this.mProfileGameInfo.skinHonor));
        ((TextView) view.findViewById(R.id.f100545ss)).setText(this.mProfileGameInfo.currSkinCount + "/" + this.mProfileGameInfo.skinTotal);
    }

    private void updateSkinIconView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f85904q8);
        Bitmap imageBitmap = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(getElegantMemberGameCardBgImagePath(String.format(GAME_SKIN_LEVE_ICON_NAME, Integer.valueOf(this.mProfileGameInfo.skinHonor))));
        if (imageBitmap != null) {
            imageView.setImageBitmap(imageBitmap);
            return;
        }
        if (TextUtils.isEmpty(this.mProfileGameInfo.skinHonorIcon)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = imageView.getWidth();
        obtain.mRequestHeight = imageView.getHeight();
        URLDrawable drawable = URLDrawable.getDrawable(this.mProfileGameInfo.skinHonorIcon, obtain);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    private void requestGameCardInfo(String str, String str2) {
        AppInterface appInterface;
        if (NetworkUtil.isNetworkAvailable(this.mActivity) && (appInterface = this.mApp) != null) {
            com.tencent.mobileqq.troop.troopgame.api.a aVar = (com.tencent.mobileqq.troop.troopgame.api.a) appInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_GAME_HANDLER);
            if (aVar != null) {
                QLog.d(TAG, 2, "requestGameCardInfo.getTroopMemberGameCard troopUin=" + str + ",personUin=" + str2);
                aVar.s2(String.valueOf(str), String.valueOf(str2));
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("requestGameCardInfo isNetworkAvailable = false, mApp is null: ");
        sb5.append(this.mApp == null);
        QLog.d(TAG, 2, sb5.toString());
    }

    private String getSkinHonorText(int i3) {
        if (i3 == 1) {
            return this.mActivity.getString(R.string.f160371uu);
        }
        if (i3 == 2) {
            return this.mActivity.getString(R.string.f160351us);
        }
        if (i3 == 3) {
            return this.mActivity.getString(R.string.f160361ut);
        }
        if (i3 == 4) {
            return this.mActivity.getString(R.string.f160321up);
        }
        if (i3 != 5) {
            return this.mActivity.getString(R.string.f160381uv);
        }
        return this.mActivity.getString(R.string.f160331uq);
    }
}
