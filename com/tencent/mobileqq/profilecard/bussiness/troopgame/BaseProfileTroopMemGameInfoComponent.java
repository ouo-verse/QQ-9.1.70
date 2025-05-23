package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.PrivacyTextUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes35.dex */
public abstract class BaseProfileTroopMemGameInfoComponent extends AbsQQProfileContentComponent implements AbsListView.OnScrollListener {
    public static final int FLAG_SHOW_RECORD = 1;
    public static final int FLAG_SHOW_SKIN = 2;
    protected static final HashMap<String, Integer> GAME_STATE_TO_TEXT_MAP = new LinkedHashMap<String, Integer>() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent.1
        {
            put(PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL, 1);
            put("\u4ec5\u81ea\u5df1\u53ef\u89c1", 2);
            put(PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL_NOT, 3);
        }
    };
    private static final String TAG = "BaseProfileTroopMemGameInfoComponent";
    protected boolean bRefreshGameCard;
    private String genderHe;
    public boolean hasReport;
    private boolean isInitDtReport;
    public Handler mHandler;
    public boolean mHasScrollToTroopMemGame;
    public boolean mScrollToTroopMemGame;
    protected int showGameCardFlag;

    public BaseProfileTroopMemGameInfoComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.genderHe = "\u4ed6";
        this.hasReport = false;
        this.isInitDtReport = false;
        this.bRefreshGameCard = true;
    }

    private void scrollToTroopMemGame() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent.2
                @Override // java.lang.Runnable
                public void run() {
                    int top;
                    if (((AbsComponent) BaseProfileTroopMemGameInfoComponent.this).mViewContainer == null || (top = ((View) ((AbsComponent) BaseProfileTroopMemGameInfoComponent.this).mViewContainer).getTop()) < 0 || ((AbsProfileComponent) BaseProfileTroopMemGameInfoComponent.this).mDelegate == null) {
                        return;
                    }
                    ((AbsProfileComponent) BaseProfileTroopMemGameInfoComponent.this).mDelegate.scrollToMoreInfoView(top);
                }
            }, 1000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void checkAndUpdateTroopInfo(TroopInfo troopInfo) {
        AllInOne allInOne = ((ProfileCardInfo) this.mData).allInOne;
        if (allInOne == null || troopInfo == null || !ProfilePAUtils.isFromTroopMemberCard(allInOne.f260789pa) || !TextUtils.isEmpty(allInOne.troopUin)) {
            return;
        }
        String str = troopInfo.troopcode;
        allInOne.troopUin = str;
        String str2 = troopInfo.troopuin;
        allInOne.troopCode = str2;
        QLog.i(TAG, 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", str2, str));
    }

    public String getDataReportElementId() {
        return ProfileCardDtReportUtil.DT_REPORT_GAME;
    }

    public String getGender(ProfileCardInfo profileCardInfo) {
        Card card;
        String string;
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null) {
            return this.genderHe;
        }
        String string2 = qBaseActivity.getString(R.string.f207375_u);
        if (profileCardInfo == null || (card = profileCardInfo.card) == null) {
            return string2;
        }
        if (card.shGender == 1) {
            string = this.mActivity.getString(R.string.f207365_t);
        } else {
            string = this.mActivity.getString(R.string.f207375_u);
        }
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getProfileCardUin() {
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).allInOne == null || ((ProfileCardInfo) data).allInOne.uin == null) {
            return null;
        }
        return ((ProfileCardInfo) data).allInOne.uin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHost() {
        return this.mApp.getCurrentUin().equals(getProfileCardUin());
    }

    public abstract boolean makeOrRefreshEntry(ProfileCardInfo profileCardInfo);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        AppInterface appInterface;
        super.onCreate(qBaseActivity, bundle);
        if (this.mActivity != null && (appInterface = this.mApp) != null) {
            checkAndUpdateTroopInfo(((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin));
            this.hasReport = false;
            IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
            if (iProfileActivityDelegate != null) {
                iProfileActivityDelegate.addProfileScrollListener(this);
            }
            Intent intent = this.mActivity.getIntent();
            if (intent != null) {
                this.mScrollToTroopMemGame = intent.getBooleanExtra("profile_scroll_to_wangzhe", false);
            }
            this.mHandler = new Handler(Looper.getMainLooper());
            return;
        }
        QLog.d(TAG, 1, "onCreate: mActivity == null || mApp == null");
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.removeProfileScrollListener(this);
            this.mDelegate = null;
        }
        this.bRefreshGameCard = true;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateData(String str) {
        QLog.d(TAG, 2, "updateData from" + str);
        if (this.mDelegate != null) {
            lambda$checkValidComponent$3((ProfileCardInfo) this.mData);
        }
        if (!this.mScrollToTroopMemGame || this.mHasScrollToTroopMemGame) {
            return;
        }
        this.mHasScrollToTroopMemGame = true;
        scrollToTroopMemGame();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        super.lambda$checkValidComponent$3((BaseProfileTroopMemGameInfoComponent) profileCardInfo);
        if (makeOrRefreshEntry((ProfileCardInfo) this.mData) && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) view, getDataReportElementId());
        }
        return true;
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
    }
}
