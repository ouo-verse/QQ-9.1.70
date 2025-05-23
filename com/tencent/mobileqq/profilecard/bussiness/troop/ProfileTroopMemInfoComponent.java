package com.tencent.mobileqq.profilecard.bussiness.troop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.QQGuildMemberCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.utils.ar;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IQueryMsgsAndAbstractsWithFilterCallback;
import com.tencent.qqnt.kernel.nativeinterface.QueriedMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.TokenResUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileTroopMemInfoComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileTroopMemInfoComponent";
    private boolean gameImfoPrepared;
    private boolean hadInitRecentSaid;
    private boolean hadInitRecentSaidFromMsg;
    private View mCharmLevelView;
    private View mGameInfoView;
    private View mJoinTimeView;
    private View mRecentSaidView;
    protected com.tencent.mobileqq.troop.troopmanager.api.b mTroopManagerBizObserver;
    protected com.tencent.mobileqq.troop.api.observer.e mTroopObserver;
    protected com.tencent.mobileqq.troop.onlinepush.api.b troopOnlinePushObserver;

    /* loaded from: classes16.dex */
    private static class TroopProfilePluginCallback implements at2.a {
        static IPatchRedirector $redirector_;
        ProfileCardInfo cardInfo;
        WeakReference<ProfileTroopMemInfoComponent> memInfoComp;

        TroopProfilePluginCallback(WeakReference<ProfileTroopMemInfoComponent> weakReference, ProfileCardInfo profileCardInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference, (Object) profileCardInfo);
            } else {
                this.memInfoComp = weakReference;
                this.cardInfo = profileCardInfo;
            }
        }

        @Override // at2.a
        public void onInstallFinish(int i3) {
            WeakReference<ProfileTroopMemInfoComponent> weakReference;
            ProfileTroopMemInfoComponent profileTroopMemInfoComponent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ProfileTroopMemInfoComponent.TAG, 2, "TroopProfilePluginCallback, onInstallFinish. code = " + i3);
            }
            if (i3 == 0 && (weakReference = this.memInfoComp) != null && (profileTroopMemInfoComponent = weakReference.get()) != null) {
                profileTroopMemInfoComponent.onPluginInstallFinish(this.cardInfo);
            }
        }
    }

    public ProfileTroopMemInfoComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.gameImfoPrepared = false;
        this.hadInitRecentSaid = false;
        this.mTroopObserver = new com.tencent.mobileqq.troop.api.observer.e() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileTroopMemInfoComponent.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.api.observer.e
            protected void onGetTroopMemberCard(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                try {
                    if (((AbsComponent) ProfileTroopMemInfoComponent.this).mActivity.isFinishing()) {
                        QLog.d(ProfileTroopMemInfoComponent.TAG, 1, "onGetTroopMemberCard return because is finished!");
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(ProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: isSuccess " + z16);
                    }
                    if (z16) {
                        TroopManager troopManager = (TroopManager) ((AbsComponent) ProfileTroopMemInfoComponent.this).mApp.getManager(QQManagerFactory.TROOP_MANAGER);
                        Object[] objArr = (Object[]) obj;
                        long longValue = ((Long) objArr[0]).longValue();
                        ((Integer) objArr[1]).intValue();
                        TroopMemberCard troopMemberCard = (TroopMemberCard) objArr[2];
                        if (((AbsComponent) ProfileTroopMemInfoComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopUin != null) {
                            if (longValue != Long.parseLong(((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopUin)) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(ProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + longValue + "!=" + ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopUin);
                                    return;
                                }
                                return;
                            }
                            if (troopMemberCard == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(ProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: cardInfo==null");
                                    return;
                                }
                                return;
                            }
                            if (((AbsComponent) ProfileTroopMemInfoComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).allInOne != null) {
                                long j3 = troopMemberCard.memberUin;
                                if (j3 != Long.parseLong(((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).allInOne.uin)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i(ProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + j3 + "!=" + ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).allInOne.uin);
                                        return;
                                    }
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i(ProfileTroopMemInfoComponent.TAG, 2, "updateParams: uint32_result:" + troopMemberCard.result + " memberRole:" + troopMemberCard.memberRole);
                                }
                                ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopMemberCard = troopMemberCard;
                                ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopShowMoreBtn = true;
                                if (troopMemberCard.result == 260 && troopMemberCard.memberRole == 0) {
                                    QQToast.makeText(((AbsComponent) ProfileTroopMemInfoComponent.this).mActivity, 1, HardCodeUtil.qqStr(R.string.msz), 0).show();
                                    ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopMemberCard = troopMemberCard;
                                    if (!troopManager.V(((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopUin)) {
                                        ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).isTroopMemberCard = false;
                                        ProfileTroopMemInfoComponent.this.updateTroopUI();
                                        return;
                                    } else {
                                        ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopShowMoreBtn = false;
                                        return;
                                    }
                                }
                                if (troopMemberCard.titleId == 0) {
                                    ProfileTroopMemInfoComponent.this.fetchTroopMemberTitleId(troopMemberCard);
                                    return;
                                }
                                ProfileTroopMemInfoComponent.this.updateTroopUI();
                                if (QLog.isColorLevel()) {
                                    QLog.d(ProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: updateCardInfo");
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(ProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.allinone == null");
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(ProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: mData or mData.troopUin is null");
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(ProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard:" + e16.toString());
                    }
                }
            }

            @Override // com.tencent.mobileqq.troop.api.observer.e
            protected void onTroopRankTitleUpdate(String str, String str2, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, str, str2, Integer.valueOf(i3));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileTroopMemInfoComponent.TAG, 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", str, str2, Integer.valueOf(i3)));
                }
                if (((AbsComponent) ProfileTroopMemInfoComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).isTroopMemberCard && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopMemberCard != null && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).allInOne != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopUin) && str2.equals(((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).allInOne.uin)) {
                    ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopMemberCard.titleId = i3;
                    ProfileTroopMemInfoComponent.this.updateHeader();
                }
            }
        };
        this.troopOnlinePushObserver = new com.tencent.mobileqq.troop.onlinepush.api.b() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileTroopMemInfoComponent.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.onlinepush.api.b
            protected void onTroopRankSwitchUpdate(String str, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, str, Boolean.valueOf(z16));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileTroopMemInfoComponent.TAG, 2, String.format("onTroopRankTitleUpdate, troopUin: %s,switchOpen: %s", str, Boolean.valueOf(z16)));
                }
                if (((AbsComponent) ProfileTroopMemInfoComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).isTroopMemberCard && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopMemberCard != null && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).allInOne != null && !TextUtils.isEmpty(str) && str.equals(((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopUin)) {
                    ProfileTroopMemInfoComponent.this.updateHeader();
                }
            }
        };
        this.mTroopManagerBizObserver = new com.tencent.mobileqq.troop.troopmanager.api.b() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileTroopMemInfoComponent.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.troopmanager.api.b
            protected void onGetGolbalTroopLevel(boolean z16, long j3, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileTroopMemInfoComponent.TAG, 2, "onGetGolbalTroopLevel isSuccess = " + z16 + ", uin = " + j3 + ", level = " + i3);
                }
                if (((AbsComponent) ProfileTroopMemInfoComponent.this).mData != null && !((TroopManager) ((AbsComponent) ProfileTroopMemInfoComponent.this).mApp.getManager(QQManagerFactory.TROOP_MANAGER)).V(((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopUin) && z16 && j3 == Long.parseLong(((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).allInOne.uin)) {
                    ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).troopGlamourLevel = i3;
                    if (((AbsComponent) ProfileTroopMemInfoComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ProfileTroopMemInfoComponent.this).mData).allInOne != null) {
                        ProfileTroopMemInfoComponent.this.updateTroopUI();
                    }
                }
            }
        };
        this.hadInitRecentSaidFromMsg = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addCharmLevelView() {
        try {
            View view = this.mCharmLevelView;
            if (view != null) {
                if (view.getParent() != null && (this.mCharmLevelView.getParent() instanceof ViewGroup)) {
                    ViewParent parent = this.mCharmLevelView.getParent();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "remove mCharmLevelView. view=%s viewParent=%s", this.mCharmLevelView, parent);
                    }
                    ((ViewGroup) parent).removeView(this.mCharmLevelView);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "add mCharmLevelView :");
                }
                ((ViewGroup) this.mViewContainer).addView(this.mCharmLevelView);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "update mCharmLevelView fail.", e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addGameInfoView() {
        try {
            View view = this.mGameInfoView;
            if (view != null) {
                if (view.getParent() != null && (this.mGameInfoView.getParent() instanceof ViewGroup)) {
                    ViewParent parent = this.mGameInfoView.getParent();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "remove mGameInfoView. view=%s viewParent=%s", this.mGameInfoView, parent);
                    }
                    ((ViewGroup) parent).removeView(this.mGameInfoView);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "add mGameInfoView :");
                }
                ((ViewGroup) this.mViewContainer).addView(this.mGameInfoView);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "update mGameInfoView fail.", e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addJoinTimeView() {
        try {
            View view = this.mJoinTimeView;
            if (view != null) {
                if (view.getParent() != null && (this.mJoinTimeView.getParent() instanceof ViewGroup)) {
                    ViewParent parent = this.mJoinTimeView.getParent();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "remove mJoinTimeView. view=%s viewParent=%s", this.mJoinTimeView, parent);
                    }
                    ((ViewGroup) parent).removeView(this.mJoinTimeView);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "add mJoinTimeView :");
                }
                ((ViewGroup) this.mViewContainer).addView(this.mJoinTimeView);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "update mJoinTimeView fail.", e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addRecentSaidView() {
        try {
            View view = this.mRecentSaidView;
            if (view != null) {
                if (view.getParent() != null && (this.mRecentSaidView.getParent() instanceof ViewGroup)) {
                    ViewParent parent = this.mRecentSaidView.getParent();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "remove mRecentSaidView. view=%s viewParent=%s", this.mRecentSaidView, parent);
                    }
                    ((ViewGroup) parent).removeView(this.mRecentSaidView);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "add mRecentSaidView :");
                }
                ((ViewGroup) this.mViewContainer).addView(this.mRecentSaidView);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "update mRecentSaidView fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void fetchTroopMemberTitleId(final TroopMemberCard troopMemberCard) {
        ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
        DATA data = this.mData;
        iTroopMemberListRepoApi.fetchTroopMemberInfo(((ProfileCardInfo) data).troopUin, ((ProfileCardInfo) data).allInOne.uin, false, null, TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.e
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                ProfileTroopMemInfoComponent.this.lambda$fetchTroopMemberTitleId$1(troopMemberCard, troopMemberInfo);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void forwardNTTroopMemberChatHistory() {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin);
        DATA data = this.mData;
        String str = ((ProfileCardInfo) data).card.strNick;
        if (!TextUtils.isEmpty(((ProfileCardInfo) data).allInOne.troopNickName)) {
            str = ((ProfileCardInfo) this.mData).allInOne.troopNickName;
        } else if (!TextUtils.isEmpty(((ProfileCardInfo) this.mData).card.strReMark)) {
            str = ((ProfileCardInfo) this.mData).card.strReMark;
        }
        QRoute.createNavigator(this.mActivity, "/base/chathistory/main").withInt("nt_chat_history_chatType", 2).withString("frameKey", ((IChatHistoryApi) QRoute.api(IChatHistoryApi.class)).getTroopMemberHistoryFragmentClassName()).withStringList("key_troop_member_uids", new ArrayList<String>(uidFromUin) { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$uid;

            {
                this.val$uid = uidFromUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileTroopMemInfoComponent.this, (Object) uidFromUin);
                } else {
                    add(uidFromUin);
                }
            }
        }).withString("nt_chat_history_peerId", ((ProfileCardInfo) this.mData).troopUin).withString("key_troop_member_nick", str).request();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleCharmLevelClick() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null) {
            ITroopLinkApi iTroopLinkApi = (ITroopLinkApi) QRoute.api(ITroopLinkApi.class);
            String a16 = ar.a();
            if (this.mData != 0 && ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(((ProfileCardInfo) this.mData).troopUin) && ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).hasNewGroupMemberLevelJumpUrl()) {
                a16 = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getNewGroupMemberLevelJumpUrl();
            }
            ITroopLinkApi.a aVar = new ITroopLinkApi.a();
            aVar.f300493c = "31";
            DATA data2 = this.mData;
            aVar.f300492b = ((ProfileCardInfo) data2).allInOne.uin;
            aVar.f300491a = ((ProfileCardInfo) data2).troopUin;
            String replaceParams = iTroopLinkApi.replaceParams(a16, aVar);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleCharmLevelClick, url:" + replaceParams);
            }
            Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", replaceParams);
            intent.putExtra("uin", this.mApp.getCurrentUin());
            intent.putExtra("portraitOnly", true);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("isShowAd", false);
            this.mActivity.startActivity(intent);
            ReportController.o(this.mApp, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, ((ProfileCardInfo) this.mData).troopUin, "", "", "");
            new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("grade_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
            ProfileCardReport.reportTroopLevelClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleCharmLevelClick, mData == null || mData.allinone == null");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleGameInfoClick() {
        TroopMemberCard.MemberGameInfo memberGameInfo;
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).troopMemberCard != null && (memberGameInfo = ((ProfileCardInfo) data).troopMemberCard.mMemberGameInfo) != null) {
            String str = memberGameInfo.gameUrl;
            Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            this.mActivity.startActivity(intent);
            eu.g("Grp_game", "Mber_data", "game_clk", 0, 0, ((ProfileCardInfo) this.mData).troopUin, memberGameInfo.gameName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleRecentSaidClick() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && this.mActivity != null) {
            forwardNTTroopMemberChatHistory();
            if (this.mApp != null) {
                new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("recent_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
                ReportController.o(this.mApp, "CliOper", "", "", "0X800A596", "0X800A596", 2, 0, "", "", "", "");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleRecentSaidClick, mData == null || mData.allinone == null || mActivity == null");
        }
    }

    private void init() {
        requestTroopMemberInfo();
    }

    private void initRecentSaidItem(ProfileCardInfo profileCardInfo) {
        ThreadManagerV2.post(new Runnable(profileCardInfo) { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ ProfileCardInfo val$cardInfo;

            {
                this.val$cardInfo = profileCardInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileTroopMemInfoComponent.this, (Object) profileCardInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ProfileTroopMemInfoComponent profileTroopMemInfoComponent = ProfileTroopMemInfoComponent.this;
                    profileTroopMemInfoComponent.updateRecentSaidView(profileTroopMemInfoComponent.mRecentSaidView, this.val$cardInfo, ProfileTroopMemInfoComponent.this);
                }
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTroopMemberTitleId$0(TroopMemberCard troopMemberCard, TroopMemberInfo troopMemberInfo) {
        troopMemberCard.titleId = troopMemberInfo.titleId;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetchTroopMemberTitleId: server realLevel==0, useLocal=" + troopMemberCard.titleId);
        }
        updateTroopUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTroopMemberTitleId$1(final TroopMemberCard troopMemberCard, final TroopMemberInfo troopMemberInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.d
            @Override // java.lang.Runnable
            public final void run() {
                ProfileTroopMemInfoComponent.this.lambda$fetchTroopMemberTitleId$0(troopMemberCard, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPluginInstallFinish$6(ProfileCardInfo profileCardInfo) {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (profileCardInfo != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onPluginInstallFinish, updateRecentSaidView.");
                }
                updateRecentSaidView(this.mRecentSaidView, profileCardInfo, this);
            }
            IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
            if (iProfileActivityDelegate != null) {
                iProfileActivityDelegate.notifyCardUpdate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRecentSaidView$2(View view, ProfileCardInfo profileCardInfo, View.OnClickListener onClickListener, int i3, String str, ArrayList arrayList) {
        if (i3 == 0 && arrayList != null && arrayList.size() != 0 && arrayList.get(0) != null) {
            long msgTime = ((QueriedMsgInfo) arrayList.get(0)).getMsgRecord().getMsgTime();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[updateRecentSaidView ] queryMsgsAndAbstractsWithFilter success, lastMsgTime=" + msgTime);
            }
            updateTroopMemberLastChatUI(view, profileCardInfo, msgTime, onClickListener);
            return;
        }
        QLog.e(TAG, 1, "[updateRecentSaidView] queryMsgsAndAbstractsWithFilter fail, errCode=" + i3 + ", errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRecentSaidView$3(long j3, View view, ProfileCardInfo profileCardInfo, View.OnClickListener onClickListener) {
        if (j3 > 0) {
            updateTroopMemberLastChatUI(view, profileCardInfo, j3, onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRecentSaidView$4(final View view, final ProfileCardInfo profileCardInfo, final View.OnClickListener onClickListener, TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo != null) {
            final long j3 = troopMemberInfo.last_active_time;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateRecentSaidView: lastMsgTime=" + j3);
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.f
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileTroopMemInfoComponent.this.lambda$updateRecentSaidView$3(j3, view, profileCardInfo, onClickListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTroopMemberLastChatUI$5(View view, ProfileCardInfo profileCardInfo, View.OnClickListener onClickListener) {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && view != null) {
            updateTroopView(view, profileCardInfo, onClickListener);
        }
    }

    private boolean makeOrRefreshGameTroopInfoView(ProfileCardInfo profileCardInfo) {
        TroopMemberCard troopMemberCard;
        TroopMemberCard.MemberGameInfo memberGameInfo;
        boolean z16;
        boolean z17 = true;
        if (profileCardInfo.isTroopMemberCard && (troopMemberCard = profileCardInfo.troopMemberCard) != null && (memberGameInfo = troopMemberCard.mMemberGameInfo) != null && !TextUtils.isEmpty(memberGameInfo.gameName)) {
            if (this.mGameInfoView == null) {
                this.mGameInfoView = this.mActivity.getLayoutInflater().inflate(R.layout.b0b, (ViewGroup) null);
                z16 = true;
            } else {
                z16 = false;
            }
            TextView textView = (TextView) this.mGameInfoView.findViewById(R.id.cr_);
            TextView textView2 = (TextView) this.mGameInfoView.findViewById(R.id.crb);
            textView2.setBackgroundDrawable(com.tencent.mobileqq.troop.utils.a.a(this.mActivity.getResources(), Color.parseColor("#3094cf")));
            ImageView imageView = (ImageView) this.mGameInfoView.findViewById(R.id.hva);
            TextView textView3 = (TextView) this.mGameInfoView.findViewById(R.id.crc);
            TextView textView4 = (TextView) this.mGameInfoView.findViewById(R.id.crd);
            ImageView imageView2 = (ImageView) this.mGameInfoView.findViewById(R.id.f164472yw);
            TroopMemberCard.MemberGameInfo memberGameInfo2 = profileCardInfo.troopMemberCard.mMemberGameInfo;
            if (memberGameInfo2 != null) {
                textView.setText(memberGameInfo2.gameName);
                ArrayList<String> arrayList = memberGameInfo2.descInfo;
                if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(memberGameInfo2.descInfo.get(0))) {
                    textView3.setVisibility(0);
                    textView3.setText(memberGameInfo2.descInfo.get(0));
                }
                ArrayList<String> arrayList2 = memberGameInfo2.descInfo;
                if (arrayList2 != null && arrayList2.size() > 1 && !TextUtils.isEmpty(memberGameInfo2.descInfo.get(1))) {
                    textView4.setVisibility(0);
                    textView4.setText(memberGameInfo2.descInfo.get(1));
                }
                try {
                    int f16 = BaseAIOUtils.f(18.0f, this.mActivity.getResources());
                    int f17 = BaseAIOUtils.f(18.0f, this.mActivity.getResources());
                    if (!TextUtils.isEmpty(memberGameInfo2.levelIcon)) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestHeight = f16;
                        obtain.mRequestWidth = f17;
                        imageView.setImageDrawable(URLDrawable.getDrawable(memberGameInfo2.levelIcon, obtain));
                    }
                    if (!TextUtils.isEmpty(memberGameInfo2.levelName)) {
                        textView2.setVisibility(0);
                        textView2.setText(memberGameInfo2.levelName);
                        float f18 = BaseAIOUtils.f(2.0f, this.mActivity.getResources());
                        int f19 = BaseAIOUtils.f(4.0f, this.mActivity.getResources());
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setCornerRadius(f18);
                        textView2.setPadding(f19, 0, f19, 0);
                        if (!TextUtils.isEmpty(memberGameInfo2.gameBackGroundColor)) {
                            gradientDrawable.setColor(Color.parseColor(memberGameInfo2.gameBackGroundColor));
                        } else {
                            gradientDrawable.setColor(Color.parseColor("#FFBA26"));
                        }
                        textView2.setBackgroundDrawable(gradientDrawable);
                    }
                    if (!TextUtils.isEmpty(memberGameInfo2.gameFontColor)) {
                        textView2.setTextColor(Color.parseColor(memberGameInfo2.gameFontColor));
                    }
                    this.gameImfoPrepared = true;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "makeOrRefreshGameTroopInfoView. Showing game info.");
                    }
                    eu.g("Grp_game", "Mber_data", "game_exp", 0, 0, profileCardInfo.troopUin, memberGameInfo2.gameName);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LevelUtil.PROFILE_CARD_TAG, 2, e16.toString());
                    }
                }
            }
            this.mGameInfoView.setTag(new com.tencent.mobileqq.profile.b(83, null));
            this.mGameInfoView.setOnClickListener(this);
            this.mGameInfoView.setVisibility(0);
            updateItemTheme(this.mGameInfoView, textView, textView3, imageView2);
            updateItemTheme(this.mGameInfoView, textView2, textView4, imageView2);
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "makeOrRefreshGameTroopInfoView. Not showing game info.");
        }
        View view = this.mGameInfoView;
        if (view == null) {
            z17 = false;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        return z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v23, types: [android.widget.LinearLayout, android.view.View, VIEW] */
    private boolean makeOrRefreshTroopMemInfoEntry(ProfileCardInfo profileCardInfo) {
        View view;
        View view2;
        View view3;
        boolean z16;
        boolean z17;
        boolean makeOrRefreshTroopMemJoinTime = makeOrRefreshTroopMemJoinTime((ProfileCardInfo) this.mData) | false | makeOrRefreshTroopMemCharmLevelInfo((ProfileCardInfo) this.mData) | makeOrRefreshTroopMemRecentSaidEntry((ProfileCardInfo) this.mData) | makeOrRefreshGameTroopInfoView((ProfileCardInfo) this.mData);
        View view4 = this.mJoinTimeView;
        if ((view4 != null && view4.getVisibility() == 0) || (((view = this.mCharmLevelView) != null && view.getVisibility() == 0) || (((view2 = this.mRecentSaidView) != null && view2.getVisibility() == 0) || ((view3 = this.mGameInfoView) != null && view3.getVisibility() == 0)))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (makeOrRefreshTroopMemJoinTime) {
            if (this.mViewContainer == 0) {
                ?? linearLayout = new LinearLayout(this.mActivity);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.mViewContainer = linearLayout;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mViewContainer removeAllViews before show. mViewContainer=%s", this.mViewContainer);
            }
            ((ViewGroup) this.mViewContainer).removeAllViews();
            if (!ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy() && ((View) this.mViewContainer).getParent() != null && (((View) this.mViewContainer).getParent() instanceof ViewGroup)) {
                ((ViewGroup) ((View) this.mViewContainer).getParent()).removeView((View) this.mViewContainer);
            }
            addJoinTimeView();
            addCharmLevelView();
            addRecentSaidView();
            addGameInfoView();
        }
        if (!z16) {
            VIEW view5 = this.mViewContainer;
            if (view5 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            makeOrRefreshTroopMemJoinTime |= z17;
            if (view5 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.mViewContainer);
                }
                ((ViewGroup) this.mViewContainer).removeAllViews();
            }
            this.mViewContainer = null;
        }
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy()) {
            diyMoreInfoManager.updateTroopMemInfoForDeepDiy((View) this.mViewContainer);
        }
        return makeOrRefreshTroopMemJoinTime;
    }

    private boolean makeOrRefreshTroopMemJoinTime(ProfileCardInfo profileCardInfo) {
        TroopMemberCard troopMemberCard;
        TroopInfo troopInfoFromCache;
        boolean z16 = true;
        if ((!profileCardInfo.isTroopMemberCard && !profileCardInfo.isQQGuildCard) || ((troopMemberCard = profileCardInfo.troopMemberCard) == null && profileCardInfo.guildMemberCard == null)) {
            View view = this.mJoinTimeView;
            if (view == null) {
                z16 = false;
            }
            if (view != null) {
                view.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("makeOrRefreshTroopMemJoinTime, Not showing mem join time", new Object[0]));
            }
            return z16;
        }
        String str = "";
        if (troopMemberCard != null) {
            long j3 = troopMemberCard.joinTime;
            if (j3 <= 0 || j3 == 1) {
                if (bg.f() != null) {
                    long longAccountUin = bg.f().getLongAccountUin();
                    if (longAccountUin > 0 && profileCardInfo.troopMemberCard.memberUin == longAccountUin && (troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(longAccountUin))) != null) {
                        j3 = troopInfoFromCache.dwCmdUinJoinTime;
                    }
                }
                j3 = 0;
            }
            if (j3 > 0 && j3 != 1) {
                try {
                    str = DateFormat.format(this.mActivity.getString(R.string.bwn), 1000 * j3).toString();
                } catch (Exception unused) {
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("makeOrRefreshTroopMemJoinTime, timeStamp: %s, joinTime: %s", Long.valueOf(j3), str));
            }
        } else {
            QQGuildMemberCard qQGuildMemberCard = profileCardInfo.guildMemberCard;
            if (qQGuildMemberCard != null) {
                long j16 = qQGuildMemberCard.joinTime;
                if (j16 > 0) {
                    try {
                        str = DateFormat.format(this.mActivity.getString(R.string.f160421uz), 1000 * j16).toString();
                    } catch (Exception unused2) {
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, String.format("makeOrRefreshTroopMemJoinTime, timeStamp: %s, joinTime: %s", Long.valueOf(j16), str));
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            View view2 = this.mJoinTimeView;
            if (view2 == null) {
                z16 = false;
            }
            if (view2 != null) {
                view2.setVisibility(8);
            }
            return z16;
        }
        if (this.mJoinTimeView == null) {
            View inflate = this.mActivity.getLayoutInflater().inflate(R.layout.c1r, (ViewGroup) null);
            this.mJoinTimeView = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
            imageView.setImageResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_group, R.drawable.qui_group));
            imageView.clearColorFilter();
        } else {
            z16 = false;
        }
        TextView textView = (TextView) this.mJoinTimeView.findViewById(R.id.dq6);
        ImageView imageView2 = (ImageView) this.mJoinTimeView.findViewById(R.id.f164472yw);
        imageView2.setVisibility(8);
        textView.setText(str);
        this.mJoinTimeView.setVisibility(0);
        QLog.d(TAG, 2, "makeOrRefreshTroopMemJoinTime 05");
        updateItemTheme(this.mJoinTimeView, textView, null, imageView2);
        return z16;
    }

    private boolean makeOrRefreshTroopMemRecentSaidEntry(ProfileCardInfo profileCardInfo) {
        boolean z16 = true;
        if (!profileCardInfo.isTroopMemberCard) {
            View view = this.mRecentSaidView;
            if (view == null) {
                z16 = false;
            }
            if (view != null) {
                view.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "makeOrRefreshTroopMemRecentSaidEntry, isTroopMemberCard = false. Not showing recent said.");
            }
            return z16;
        }
        if (this.mRecentSaidView == null) {
            View inflate = this.mActivity.getLayoutInflater().inflate(R.layout.c1r, (ViewGroup) null);
            this.mRecentSaidView = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
            imageView.setImageResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_speak, R.drawable.qui_message_record));
            imageView.clearColorFilter();
        } else {
            z16 = false;
        }
        TextView textView = (TextView) this.mRecentSaidView.findViewById(R.id.dq6);
        ImageView imageView2 = (ImageView) this.mRecentSaidView.findViewById(R.id.f164472yw);
        this.mRecentSaidView.setTag(new com.tencent.mobileqq.profile.b(78, null));
        this.mRecentSaidView.setOnClickListener(this);
        updateItemTheme(this.mRecentSaidView, textView, null, imageView2);
        updateRecentSaidView(this.mRecentSaidView, profileCardInfo, this);
        initRecentSaidItem(profileCardInfo);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPluginInstallFinish(final ProfileCardInfo profileCardInfo) {
        if (this.mRecentSaidView == null || this.mActivity == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.a
            @Override // java.lang.Runnable
            public final void run() {
                ProfileTroopMemInfoComponent.this.lambda$onPluginInstallFinish$6(profileCardInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateHeader() {
        AbsProfileHeaderComponent absProfileHeaderComponent = (AbsProfileHeaderComponent) this.mComponentCenter.getComponent(1002);
        if (absProfileHeaderComponent != null) {
            absProfileHeaderComponent.lambda$checkValidComponent$3((ProfileCardInfo) this.mData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateRecentSaidView(final View view, final ProfileCardInfo profileCardInfo, final View.OnClickListener onClickListener) {
        if (this.mApp == null) {
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105730", true)) {
            if (this.hadInitRecentSaidFromMsg) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "[updateRecentSaidView] hadInitRecentSaidFromMsg:" + this.hadInitRecentSaidFromMsg);
                    return;
                }
                return;
            }
            this.hadInitRecentSaidFromMsg = true;
            w msgService = ((IKernelService) this.mApp.getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService == null) {
                return;
            }
            msgService.queryMsgsAndAbstractsWithFilter(0L, 0L, 0L, new QueryMsgsParams(new ChatInfo(2, profileCardInfo.troopUin), new ArrayList(), new ArrayList<String>(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin)) { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$uid;

                {
                    this.val$uid = r5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileTroopMemInfoComponent.this, (Object) r5);
                    } else {
                        add(r5);
                    }
                }
            }, 0L, 0L, 1, false, false), new IQueryMsgsAndAbstractsWithFilterCallback() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryMsgsAndAbstractsWithFilterCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    ProfileTroopMemInfoComponent.this.lambda$updateRecentSaidView$2(view, profileCardInfo, onClickListener, i3, str, arrayList);
                }
            });
            return;
        }
        if (this.hadInitRecentSaid) {
            return;
        }
        this.hadInitRecentSaid = true;
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(profileCardInfo.troopUin, ((ProfileCardInfo) this.mData).allInOne.uin, false, this.mActivity, TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.c
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                ProfileTroopMemInfoComponent.this.lambda$updateRecentSaidView$4(view, profileCardInfo, onClickListener, troopMemberInfo);
            }
        });
    }

    private void updateTroopMemberLastChatUI(final View view, final ProfileCardInfo profileCardInfo, long j3, final View.OnClickListener onClickListener) {
        String str = HardCodeUtil.qqStr(R.string.pds) + TroopNewGuidePopWindow.f0(j3, true, false, true);
        if (!TextUtils.isEmpty(str)) {
            profileCardInfo.troopRecentSaid = str;
        }
        if (this.mActivity == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.g
            @Override // java.lang.Runnable
            public final void run() {
                ProfileTroopMemInfoComponent.this.lambda$updateTroopMemberLastChatUI$5(view, profileCardInfo, onClickListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTroopUI() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateTroopUI");
        }
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.notifyCardUpdate();
        }
    }

    private void updateTroopView(View view, ProfileCardInfo profileCardInfo, View.OnClickListener onClickListener) {
        view.setVisibility(0);
        Context context = view.getContext();
        TextView textView = (TextView) view.findViewById(R.id.dq6);
        ImageView imageView = (ImageView) view.findViewById(R.id.f164472yw);
        if (!TextUtils.isEmpty(profileCardInfo.troopRecentSaid)) {
            textView.setText(profileCardInfo.troopRecentSaid);
            textView.setContentDescription(profileCardInfo.troopRecentSaid);
            imageView.setVisibility(0);
            view.setOnClickListener(onClickListener);
            return;
        }
        textView.setText(context.getString(R.string.f171402er2));
        textView.setContentDescription(context.getString(R.string.f171402er2));
        imageView.setVisibility(0);
        view.setOnClickListener(onClickListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void checkAndUpdateTroopInfo(TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopInfo);
            return;
        }
        AllInOne allInOne = ((ProfileCardInfo) this.mData).allInOne;
        if (allInOne != null && troopInfo != null && ProfilePAUtils.isFromTroopMemberCard(allInOne.f260789pa) && TextUtils.isEmpty(allInOne.troopUin)) {
            allInOne.troopUin = troopInfo.troopcode;
            allInOne.troopCode = troopInfo.troopuin;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", troopInfo.troopuin, troopInfo.troopcode));
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 1013;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_TROOP_MEM_INFO;
    }

    public boolean makeOrRefreshTroopMemCharmLevelInfo(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        TroopManager troopManager = (TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
        boolean z16 = true;
        if (profileCardInfo.isTroopMemberCard && profileCardInfo.troopGlamourLevel >= 0 && !troopManager.V(profileCardInfo.troopUin)) {
            QBaseActivity qBaseActivity = this.mActivity;
            if (qBaseActivity == null) {
                return false;
            }
            if (this.mCharmLevelView == null) {
                View inflate = qBaseActivity.getLayoutInflater().inflate(R.layout.c1r, (ViewGroup) null);
                this.mCharmLevelView = inflate;
                ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
                imageView.setImageResource(R.drawable.qq_profilecard_item_charm);
                imageView.clearColorFilter();
            } else {
                z16 = false;
            }
            TextView textView = (TextView) this.mCharmLevelView.findViewById(R.id.dq6);
            ImageView imageView2 = (ImageView) this.mCharmLevelView.findViewById(R.id.f164472yw);
            textView.setText(this.mActivity.getString(R.string.f160461v3));
            this.mCharmLevelView.setTag(new com.tencent.mobileqq.profile.b(80, null));
            this.mCharmLevelView.setOnClickListener(this);
            updateItemTheme(this.mCharmLevelView, textView, null, imageView2);
            ReportController.o(this.mApp, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(profileCardInfo.troopGlamourLevel), "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "makeOrRefreshTroopMemCharmLevelInfo, showing charm level.");
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "makeOrRefreshTroopMemCharmLevelInfo, cardInfo.isTroopMemberCard: " + profileCardInfo.isTroopMemberCard + ", cardInfo.glamourLevel: " + profileCardInfo.troopGlamourLevel + " isQidianPrivateTroop");
        }
        View view = this.mCharmLevelView;
        if (view == null) {
            z16 = false;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        return z16;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view.getTag() instanceof com.tencent.mobileqq.profile.b) {
            int i3 = ((com.tencent.mobileqq.profile.b) view.getTag()).f260135a;
            if (i3 == 78) {
                handleRecentSaidClick();
            } else if (i3 == 80) {
                handleCharmLevelClick();
            } else if (i3 == 83) {
                handleGameInfoClick();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        this.mActivity.addObserver(this.mTroopObserver);
        this.mActivity.addObserver(this.troopOnlinePushObserver);
        this.mActivity.addObserver(this.mTroopManagerBizObserver);
        init();
        TroopInfo k3 = ((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin);
        checkAndUpdateTroopInfo(k3);
        if (k3 != null && k3.isGameBind()) {
            eu.g("Grp_game", "Mber_data", "mdata_exp", 0, 0, k3.troopuin);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null) {
            qBaseActivity.removeObserver(this.mTroopObserver);
            this.mActivity.removeObserver(this.troopOnlinePushObserver);
            this.mActivity.removeObserver(this.mTroopManagerBizObserver);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onResume();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void requestTroopMemberInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        DATA data = this.mData;
        if (data == 0 || !((ProfileCardInfo) data).isTroopMemberCard || ((ProfileCardInfo) data).allInOne == null || !NetworkUtil.isNetworkAvailable(this.mActivity)) {
            return;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(((ProfileCardInfo) this.mData).allInOne.uin);
            TroopManager troopManager = (TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
            com.tencent.mobileqq.troop.troopmanager.api.a aVar = (com.tencent.mobileqq.troop.troopmanager.api.a) ((QQAppInterface) this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
            com.tencent.mobileqq.troop.api.handler.e eVar = (com.tencent.mobileqq.troop.api.handler.e) ((QQAppInterface) this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
            TroopInfo k3 = troopManager.k(((ProfileCardInfo) this.mData).troopUin);
            checkAndUpdateTroopInfo(k3);
            if (k3 != null && eVar != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "requestTroopMemberInfo.getTroopMemberCardInfo");
                }
                eVar.i1(((ProfileCardInfo) this.mData).troopUin, k3.troopcode, arrayList);
                eVar.f2(Long.parseLong(((ProfileCardInfo) this.mData).troopUin), Long.parseLong(((ProfileCardInfo) this.mData).allInOne.uin));
                if (!troopManager.V(((ProfileCardInfo) this.mData).troopUin)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "requestTroopMemberInfo.requestGlobalTroopLevel");
                    }
                    aVar.R(Long.parseLong(((ProfileCardInfo) this.mData).allInOne.uin));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "requestTroopMemberInfo.getTroopMemberCardInfo troopInfo null");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "loadTroopMemberCard:" + e16.toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? super.lambda$checkValidComponent$3((ProfileTroopMemInfoComponent) profileCardInfo) | makeOrRefreshTroopMemInfoEntry((ProfileCardInfo) this.mData) : ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) profileCardInfo)).booleanValue();
    }
}
