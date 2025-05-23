package com.tencent.mobileqq.profilecard.component.troop;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.QQGuildMemberCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopMemberCardApi;
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
import com.tencent.util.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes35.dex */
public class ElegantProfileTroopMemInfoComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    private static final String TAG = "ElegantProfileTroopMemInfoComponent";
    private boolean hadInitRecentSaid;
    private boolean hadInitRecentSaidFromMsg;
    private boolean hasTroopMemberLastChatUpdate;
    protected com.tencent.mobileqq.troop.troopmanager.api.b mTroopManagerBizObserver;
    protected com.tencent.mobileqq.troop.api.observer.e mTroopObserver;
    private View mTroopView;
    private boolean shouldRequestMemberInfo;
    protected com.tencent.mobileqq.troop.onlinepush.api.b troopOnlinePushObserver;

    /* loaded from: classes35.dex */
    private static class TroopProfilePluginCallback implements at2.a {
        ProfileCardInfo cardInfo;
        WeakReference<ElegantProfileTroopMemInfoComponent> memInfoComp;

        TroopProfilePluginCallback(WeakReference<ElegantProfileTroopMemInfoComponent> weakReference, ProfileCardInfo profileCardInfo) {
            this.memInfoComp = weakReference;
            this.cardInfo = profileCardInfo;
        }

        @Override // at2.a
        public void onInstallFinish(int i3) {
            WeakReference<ElegantProfileTroopMemInfoComponent> weakReference;
            ElegantProfileTroopMemInfoComponent elegantProfileTroopMemInfoComponent;
            if (QLog.isColorLevel()) {
                QLog.d(ElegantProfileTroopMemInfoComponent.TAG, 2, "TroopProfilePluginCallback, onInstallFinish. code = " + i3);
            }
            if (i3 != 0 || (weakReference = this.memInfoComp) == null || (elegantProfileTroopMemInfoComponent = weakReference.get()) == null) {
                return;
            }
            elegantProfileTroopMemInfoComponent.onPluginInstallFinish(this.cardInfo);
        }
    }

    public ElegantProfileTroopMemInfoComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.hasTroopMemberLastChatUpdate = false;
        this.shouldRequestMemberInfo = false;
        this.hadInitRecentSaid = false;
        this.mTroopObserver = new com.tencent.mobileqq.troop.api.observer.e() { // from class: com.tencent.mobileqq.profilecard.component.troop.ElegantProfileTroopMemInfoComponent.1
            @Override // com.tencent.mobileqq.troop.api.observer.e
            protected void onGetTroopMemberCard(boolean z16, Object obj) {
                try {
                    if (((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mActivity.isFinishing()) {
                        QLog.d(ElegantProfileTroopMemInfoComponent.TAG, 1, "onGetTroopMemberCard return because is finished!");
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: isSuccess " + z16);
                    }
                    if (z16) {
                        TroopManager troopManager = (TroopManager) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mApp.getManager(QQManagerFactory.TROOP_MANAGER);
                        Object[] objArr = (Object[]) obj;
                        long longValue = ((Long) objArr[0]).longValue();
                        ((Integer) objArr[1]).intValue();
                        TroopMemberCard troopMemberCard = (TroopMemberCard) objArr[2];
                        if (((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopUin != null) {
                            if (longValue != Long.parseLong(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopUin)) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + longValue + "!=" + ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopUin);
                                    return;
                                }
                                return;
                            }
                            if (troopMemberCard != null) {
                                if (((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).allInOne != null) {
                                    long j3 = troopMemberCard.memberUin;
                                    if (j3 != Long.parseLong(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).allInOne.uin)) {
                                        if (QLog.isColorLevel()) {
                                            QLog.i(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + j3 + "!=" + ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).allInOne.uin);
                                            return;
                                        }
                                        return;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.i(ElegantProfileTroopMemInfoComponent.TAG, 2, "updateParams: uint32_result:" + troopMemberCard.result + " memberRole:" + troopMemberCard.memberRole);
                                    }
                                    ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopMemberCard = troopMemberCard;
                                    ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopShowMoreBtn = true;
                                    if (troopMemberCard.result == 260 && troopMemberCard.memberRole == 0) {
                                        QQToast.makeText(((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mActivity, 1, HardCodeUtil.qqStr(R.string.msz), 0).show();
                                        ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopMemberCard = troopMemberCard;
                                        if (!troopManager.V(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopUin)) {
                                            ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).isTroopMemberCard = false;
                                            ElegantProfileTroopMemInfoComponent.this.updateTroopUI();
                                            return;
                                        } else {
                                            ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopShowMoreBtn = false;
                                            return;
                                        }
                                    }
                                    if (troopMemberCard.titleId == 0) {
                                        ElegantProfileTroopMemInfoComponent.this.fetchTroopMemberTitleId(troopMemberCard);
                                        return;
                                    }
                                    ElegantProfileTroopMemInfoComponent.this.updateTroopUI();
                                    if (QLog.isColorLevel()) {
                                        QLog.d(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: updateCardInfo");
                                        return;
                                    }
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.allinone == null");
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: cardInfo==null");
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard: mData or mData.troopUin is null");
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetTroopMemberCard:" + e16.toString());
                    }
                }
            }

            @Override // com.tencent.mobileqq.troop.api.observer.e
            protected void onGetTroopMemberCardInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList) {
                ElegantProfileTroopMemInfoComponent.this.hadInitRecentSaid = false;
                ElegantProfileTroopMemInfoComponent elegantProfileTroopMemInfoComponent = ElegantProfileTroopMemInfoComponent.this;
                elegantProfileTroopMemInfoComponent.initRecentSaidItem((ProfileCardInfo) ((AbsComponent) elegantProfileTroopMemInfoComponent).mData);
            }

            @Override // com.tencent.mobileqq.troop.api.observer.e
            protected void onTroopRankTitleUpdate(String str, String str2, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d(ElegantProfileTroopMemInfoComponent.TAG, 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", str, str2, Integer.valueOf(i3)));
                }
                if (((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData == null || !((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).isTroopMemberCard || ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopMemberCard == null || ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).allInOne == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopUin) || !str2.equals(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).allInOne.uin)) {
                    return;
                }
                ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopMemberCard.titleId = i3;
                ElegantProfileTroopMemInfoComponent.this.updateHeader();
            }
        };
        this.troopOnlinePushObserver = new com.tencent.mobileqq.troop.onlinepush.api.b() { // from class: com.tencent.mobileqq.profilecard.component.troop.ElegantProfileTroopMemInfoComponent.2
            @Override // com.tencent.mobileqq.troop.onlinepush.api.b
            protected void onTroopRankSwitchUpdate(String str, boolean z16) {
                if (QLog.isColorLevel()) {
                    QLog.d(ElegantProfileTroopMemInfoComponent.TAG, 2, String.format("onTroopRankTitleUpdate, troopUin: %s,switchOpen: %s", str, Boolean.valueOf(z16)));
                }
                if (((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData == null || !((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).isTroopMemberCard || ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopMemberCard == null || ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).allInOne == null || TextUtils.isEmpty(str) || !str.equals(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopUin)) {
                    return;
                }
                ElegantProfileTroopMemInfoComponent.this.updateHeader();
            }
        };
        this.mTroopManagerBizObserver = new com.tencent.mobileqq.troop.troopmanager.api.b() { // from class: com.tencent.mobileqq.profilecard.component.troop.ElegantProfileTroopMemInfoComponent.3
            @Override // com.tencent.mobileqq.troop.troopmanager.api.b
            protected void onGetGolbalTroopLevel(boolean z16, long j3, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d(ElegantProfileTroopMemInfoComponent.TAG, 2, "onGetGlobalTroopLevel isSuccess = " + z16 + ", uin = " + j3 + ", level = " + i3);
                }
                if (((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData != null && !((TroopManager) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mApp.getManager(QQManagerFactory.TROOP_MANAGER)).V(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopUin) && z16 && j3 == Long.parseLong(((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).allInOne.uin)) {
                    ((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).troopGlamourLevel = i3;
                    if (((ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData).allInOne != null) {
                        ElegantProfileTroopMemInfoComponent.this.updateTroopUI();
                    }
                }
            }
        };
        this.hadInitRecentSaidFromMsg = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addTroopView(View view) {
        if (view != null) {
            try {
                if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "addTroopView");
                    }
                    ((ViewGroup) this.mViewContainer).addView(view);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "addTroopView fail.", e16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void destroyViewContainer() {
        if (this.mViewContainer != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.mViewContainer);
            }
            ((ViewGroup) this.mViewContainer).removeAllViews();
        }
        this.mViewContainer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void fetchTroopMemberTitleId(final TroopMemberCard troopMemberCard) {
        ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
        DATA data = this.mData;
        iTroopMemberListRepoApi.fetchTroopMemberInfo(((ProfileCardInfo) data).troopUin, ((ProfileCardInfo) data).allInOne.uin, false, null, TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.profilecard.component.troop.c
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                ElegantProfileTroopMemInfoComponent.this.lambda$fetchTroopMemberTitleId$1(troopMemberCard, troopMemberInfo);
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
        QRoute.createNavigator(this.mActivity, "/base/chathistory/main").withInt("nt_chat_history_chatType", 2).withString("frameKey", ((IChatHistoryApi) QRoute.api(IChatHistoryApi.class)).getTroopMemberHistoryFragmentClassName()).withStringList("key_troop_member_uids", new ArrayList<String>(uidFromUin) { // from class: com.tencent.mobileqq.profilecard.component.troop.ElegantProfileTroopMemInfoComponent.6
            final /* synthetic */ String val$uid;

            {
                this.val$uid = uidFromUin;
                add(uidFromUin);
            }
        }).withString("nt_chat_history_peerId", ((ProfileCardInfo) this.mData).troopUin).withString("key_troop_member_nick", str).request();
    }

    private static String getRecentChat(Context context, ProfileCardInfo profileCardInfo) {
        if (!TextUtils.isEmpty(profileCardInfo.troopRecentSaid)) {
            return profileCardInfo.troopRecentSaid;
        }
        return context.getString(R.string.x5s);
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

    private void initTroopView(ProfileCardInfo profileCardInfo) {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null) {
            return;
        }
        if (this.mTroopView == null) {
            this.mTroopView = qBaseActivity.getLayoutInflater().inflate(R.layout.f167372cz1, (ViewGroup) null);
        }
        updateTroopView(this.mTroopView, profileCardInfo);
        if (isVasCard(profileCardInfo)) {
            updateItemTheme(this.mTroopView, null, null, null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.LinearLayout, android.view.View, VIEW] */
    private void initViewContainer() {
        if (this.mViewContainer == 0) {
            ?? linearLayout = new LinearLayout(this.mActivity);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.mViewContainer = linearLayout;
        }
    }

    private boolean isJoinTimeShow(ProfileCardInfo profileCardInfo) {
        return (profileCardInfo.isTroopMemberCard && profileCardInfo.troopMemberCard != null) || (profileCardInfo.isQQGuildCard && profileCardInfo.guildMemberCard != null);
    }

    private boolean isRecentChatShow(ProfileCardInfo profileCardInfo) {
        return profileCardInfo.isTroopMemberCard;
    }

    private boolean isTroopCharmLevelShow(ProfileCardInfo profileCardInfo) {
        return profileCardInfo.isTroopMemberCard && profileCardInfo.troopGlamourLevel >= 0 && !((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).V(profileCardInfo.troopUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTroopMemberTitleId$0(TroopMemberInfo troopMemberInfo, TroopMemberCard troopMemberCard) {
        if (this.mActivity == null) {
            return;
        }
        if (troopMemberInfo != null) {
            troopMemberCard.titleId = troopMemberInfo.titleId;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetchTroopMemberTitleId: server realLevel==0, useLocal=" + troopMemberCard.titleId);
        }
        updateTroopUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTroopMemberTitleId$1(final TroopMemberCard troopMemberCard, final TroopMemberInfo troopMemberInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.troop.f
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileTroopMemInfoComponent.this.lambda$fetchTroopMemberTitleId$0(troopMemberInfo, troopMemberCard);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRecentSaidItem$2(ProfileCardInfo profileCardInfo, int i3, String str, ArrayList arrayList) {
        if (i3 == 0 && arrayList != null && arrayList.size() != 0 && arrayList.get(0) != null) {
            long msgTime = ((QueriedMsgInfo) arrayList.get(0)).getMsgRecord().getMsgTime();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[initRecentSaidItem] queryMsgsAndAbstractsWithFilter success, lastMsgTime=" + msgTime);
            }
            updateTroopMemberLastChatUI(profileCardInfo, msgTime);
            return;
        }
        QLog.e(TAG, 1, "[initRecentSaidItem] queryMsgsAndAbstractsWithFilter fail, errCode=" + i3 + ", errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onPluginInstallFinish$6(ProfileCardInfo profileCardInfo) {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null || qBaseActivity.isFinishing()) {
            return;
        }
        if (profileCardInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onPluginInstallFinish, updateRecentSaidView.");
            }
            updateTroopView(this.mTroopView, profileCardInfo);
        }
        lambda$checkValidComponent$3((ProfileCardInfo) this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTroopMemberLastChatUI$5(ProfileCardInfo profileCardInfo) {
        View view;
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null || qBaseActivity.isFinishing() || (view = this.mTroopView) == null) {
            return;
        }
        updateTroopView(view, profileCardInfo);
    }

    private boolean makeOrRefreshTroopMemInfoEntry(ProfileCardInfo profileCardInfo) {
        if (!makeOrRefreshTroopView(profileCardInfo)) {
            destroyViewContainer();
            return false;
        }
        initViewContainer();
        addTroopView(this.mTroopView);
        updateDiyProfileStyle();
        return true;
    }

    private boolean makeOrRefreshTroopView(ProfileCardInfo profileCardInfo) {
        if (!profileCardInfo.isTroopMemberCard) {
            View view = this.mTroopView;
            if (view == null) {
                return false;
            }
            view.setVisibility(8);
            return false;
        }
        initTroopView(profileCardInfo);
        initRecentSaidItem(profileCardInfo);
        ReportController.o(this.mApp, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(profileCardInfo.troopGlamourLevel), "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPluginInstallFinish(final ProfileCardInfo profileCardInfo) {
        if (this.mTroopView == null || this.mActivity == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.troop.g
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileTroopMemInfoComponent.this.lambda$onPluginInstallFinish$6(profileCardInfo);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateDiyProfileStyle() {
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy()) {
            diyMoreInfoManager.updateTroopMemInfoForDeepDiy((View) this.mViewContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateHeader() {
        AbsProfileHeaderComponent absProfileHeaderComponent = (AbsProfileHeaderComponent) this.mComponentCenter.getComponent(1002);
        if (absProfileHeaderComponent != null) {
            absProfileHeaderComponent.lambda$checkValidComponent$3((ProfileCardInfo) this.mData);
        }
    }

    private synchronized void updateTroopMemberLastChatUI(final ProfileCardInfo profileCardInfo, long j3) {
        if (this.hasTroopMemberLastChatUpdate) {
            return;
        }
        String str = HardCodeUtil.qqStr(R.string.f169713x63) + TroopNewGuidePopWindow.f0(j3, true, false, true);
        if (!TextUtils.isEmpty(str)) {
            profileCardInfo.troopRecentSaid = str;
        }
        if (this.mActivity == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.troop.a
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileTroopMemInfoComponent.this.lambda$updateTroopMemberLastChatUI$5(profileCardInfo);
            }
        });
        this.hasTroopMemberLastChatUpdate = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateTroopUI() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateTroopUI");
        }
        lambda$checkValidComponent$3((ProfileCardInfo) this.mData);
    }

    private void updateTroopView(View view, ProfileCardInfo profileCardInfo) {
        Context context = view.getContext();
        if (context == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.oxq);
        TextView textView2 = (TextView) view.findViewById(R.id.oxr);
        View findViewById = view.findViewById(R.id.oxp);
        String troopMemeJoinTime = getTroopMemeJoinTime(context, profileCardInfo);
        String recentChat = getRecentChat(context, profileCardInfo);
        TroopMemberNewLevelView troopMemberNewLevelView = (TroopMemberNewLevelView) view.findViewById(R.id.oxs);
        if (TextUtils.isEmpty(troopMemeJoinTime) && TextUtils.isEmpty(recentChat) && !isTroopCharmLevelShow(profileCardInfo)) {
            this.mTroopView.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(troopMemeJoinTime)) {
            findViewById.setVisibility(8);
        } else {
            textView.setText(troopMemeJoinTime);
            textView.setContentDescription(troopMemeJoinTime);
            textView2.setText(recentChat);
            textView2.setContentDescription(recentChat);
            findViewById.setVisibility(0);
        }
        if (!isRecentChatShow(profileCardInfo)) {
            textView2.setOnClickListener(null);
        } else {
            textView2.setOnClickListener(this);
        }
        updateTroopMemberNewLevelView(this.mApp, profileCardInfo, troopMemberNewLevelView);
        view.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1013;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_TROOP_MEM_INFO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.oxs) {
            handleCharmLevelClick();
        } else if (id5 == R.id.oxr) {
            handleRecentSaidClick();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        this.mActivity.addObserver(this.mTroopObserver);
        this.mActivity.addObserver(this.troopOnlinePushObserver);
        this.mActivity.addObserver(this.mTroopManagerBizObserver);
        init();
        TroopInfo k3 = ((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin);
        ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).checkAndUpdateTroopInfo(k3, ((ProfileCardInfo) this.mData).allInOne);
        if (k3 == null || !k3.isGameBind()) {
            return;
        }
        eu.g("Grp_game", "Mber_data", "mdata_exp", 0, 0, k3.troopuin);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null) {
            qBaseActivity.removeObserver(this.mTroopObserver);
            this.mActivity.removeObserver(this.troopOnlinePushObserver);
            this.mActivity.removeObserver(this.mTroopManagerBizObserver);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStart() {
        super.onStart();
        if (this.shouldRequestMemberInfo) {
            requestTroopMemberInfo();
            this.shouldRequestMemberInfo = false;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStop() {
        super.onStop();
        this.shouldRequestMemberInfo = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void requestTroopMemberInfo() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && ((ProfileCardInfo) data).isTroopMemberCard) {
            QLog.i(TAG, 1, "requestTroopMemberInfo is called");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.troop.ElegantProfileTroopMemInfoComponent.4
                @Override // java.lang.Runnable
                public void run() {
                    ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).requestTroopMemberInfo(((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mApp, (ProfileCardInfo) ((AbsComponent) ElegantProfileTroopMemInfoComponent.this).mData, ElegantProfileTroopMemInfoComponent.TAG);
                }
            }, 16, null, true);
        } else {
            QLog.i(TAG, 1, "[requestTroopMemberInfo] is not troop member card");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        return super.lambda$checkValidComponent$3((ElegantProfileTroopMemInfoComponent) profileCardInfo) | makeOrRefreshTroopMemInfoEntry((ProfileCardInfo) this.mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleCharmLevelClick() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null) {
            QBaseActivity qBaseActivity = this.mActivity;
            String str = ((ProfileCardInfo) data).troopUin;
            String str2 = ((ProfileCardInfo) data).allInOne.uin;
            if (qBaseActivity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", this.mApp.getCurrentUin());
                bundle.putBoolean("portraitOnly", true);
                bundle.putBoolean("hide_more_button", true);
                bundle.putBoolean("hide_operation_bar", true);
                bundle.putBoolean("isShowAd", false);
                ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).openTroopIdentityWearPage(qBaseActivity, str, str2, bundle);
                ReportController.o(this.mApp, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, ((ProfileCardInfo) this.mData).troopUin, "", "", "");
                new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("grade_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
                ProfileCardReport.reportTroopLevelClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
                return;
            }
            QLog.i(TAG, 1, "[handleCharmLevelClick] context = " + qBaseActivity + ", troopUin = " + str + ", uin = " + str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleCharmLevelClick, mData == null || mData.allinone == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRecentSaidItem$4(final ProfileCardInfo profileCardInfo, TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo != null) {
            final long j3 = troopMemberInfo.last_active_time;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initRecentSaidItem: lastMsgTime=" + j3);
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.troop.b
                @Override // java.lang.Runnable
                public final void run() {
                    ElegantProfileTroopMemInfoComponent.this.lambda$initRecentSaidItem$3(j3, profileCardInfo);
                }
            });
        }
    }

    private static boolean isCurYearJoin(long j3) {
        return Integer.parseInt(DateFormat.format(DateUtil.DATE_FORMAT_YEAR, j3 * 1000).toString()) == Integer.parseInt(DateFormat.format(DateUtil.DATE_FORMAT_YEAR, System.currentTimeMillis()).toString());
    }

    private static String getTroopMemeJoinTime(Context context, ProfileCardInfo profileCardInfo) {
        String string;
        TroopInfo troopInfoFromCache;
        TroopMemberCard troopMemberCard = profileCardInfo.troopMemberCard;
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
                    str = DateFormat.format(context.getString(R.string.x4n), 1000 * j3).toString();
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
                        if (isCurYearJoin(j16)) {
                            string = context.getString(R.string.x4l);
                        } else {
                            string = context.getString(R.string.x4m);
                        }
                        str = DateFormat.format(string, 1000 * j16).toString();
                    } catch (Exception unused2) {
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, String.format("makeOrRefreshTroopMemJoinTime, timeStamp: %s, joinTime: %s", Long.valueOf(j16), str));
                    }
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void initRecentSaidItem(final ProfileCardInfo profileCardInfo) {
        if (this.mApp == null) {
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105730", true)) {
            if (this.hadInitRecentSaidFromMsg) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "[initRecentSaidItem] hadInitRecentSaidFromMsg:" + this.hadInitRecentSaidFromMsg);
                    return;
                }
                return;
            }
            this.hadInitRecentSaidFromMsg = true;
            w msgService = ((IKernelService) this.mApp.getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService == null) {
                QLog.e(TAG, 1, "[initRecentSaidItem] msgService is null");
                return;
            } else {
                msgService.queryMsgsAndAbstractsWithFilter(0L, 0L, 0L, new QueryMsgsParams(new ChatInfo(2, profileCardInfo.troopUin), new ArrayList(), new ArrayList<String>(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin)) { // from class: com.tencent.mobileqq.profilecard.component.troop.ElegantProfileTroopMemInfoComponent.5
                    final /* synthetic */ String val$uid;

                    {
                        this.val$uid = r2;
                        add(r2);
                    }
                }, 0L, 0L, 1, false, false), new IQueryMsgsAndAbstractsWithFilterCallback() { // from class: com.tencent.mobileqq.profilecard.component.troop.d
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryMsgsAndAbstractsWithFilterCallback
                    public final void onResult(int i3, String str, ArrayList arrayList) {
                        ElegantProfileTroopMemInfoComponent.this.lambda$initRecentSaidItem$2(profileCardInfo, i3, str, arrayList);
                    }
                });
                return;
            }
        }
        if (this.hadInitRecentSaid) {
            return;
        }
        this.hadInitRecentSaid = true;
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(profileCardInfo.troopUin, ((ProfileCardInfo) this.mData).allInOne.uin, false, this.mActivity, TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.profilecard.component.troop.e
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                ElegantProfileTroopMemInfoComponent.this.lambda$initRecentSaidItem$4(profileCardInfo, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRecentSaidItem$3(long j3, ProfileCardInfo profileCardInfo) {
        if (j3 > 0) {
            updateTroopMemberLastChatUI(profileCardInfo, j3);
        }
    }

    private void updateTroopMemberNewLevelView(AppInterface appInterface, ProfileCardInfo profileCardInfo, TroopMemberNewLevelView troopMemberNewLevelView) {
        if (appInterface == null || profileCardInfo == null || troopMemberNewLevelView == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "call updateTroopMemberNewLevelView troopUin : " + profileCardInfo.troopUin);
        }
        TroopManager troopManager = (TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo B = troopManager != null ? troopManager.B(profileCardInfo.troopUin) : null;
        if (B == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateTroopMemberNewLevelView troopInfo is null. troopUin : " + profileCardInfo.troopUin);
                return;
            }
            return;
        }
        int i3 = profileCardInfo.troopMemberCard.realLevel;
        ITroopMemberLevelUtilsApi iTroopMemberLevelUtilsApi = (ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class);
        String str = profileCardInfo.allInOne.uin;
        TroopMemberCard troopMemberCard = profileCardInfo.troopMemberCard;
        com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = iTroopMemberLevelUtilsApi.getTroopMemberRankItem(B, str, i3, troopMemberCard.titleId, troopMemberCard.mUniqueTitle, troopMemberCard.honorRichTag);
        if (troopMemberRankItem != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "troopMemberRankItem :troopUin : " + k.d(profileCardInfo.troopUin));
            }
            troopMemberNewLevelView.setTroopMemberNewLevel(troopMemberRankItem);
            troopMemberNewLevelView.setOnClickListener(this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateTroopMemberNewLevelView failed - troopUin : " + profileCardInfo.troopUin);
        }
    }
}
