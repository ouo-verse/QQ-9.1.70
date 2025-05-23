package com.tencent.mobileqq.profilecard.vas.component.header;

import SummaryCardTaf.SSummaryCardRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;

/* loaded from: classes16.dex */
public abstract class AbsVasProfileHeaderComponent extends AbsProfileHeaderComponent {
    private static final int SET_STYLE_AND_BGW_AIT_TIME = 30000;
    private static final String TAG = "AbsVasProfileHeaderComponent";
    private static final int UI_MSG_SAVE_CARD_RESULT = 13;
    private Runnable mDismissRunnable;
    private DialogInterface.OnClickListener mLeftButtonClickListener;
    private String mMyCoverType;
    private QQCustomDialog mOpenVipServicePromptDialog;
    private DialogInterface.OnClickListener mRightButtonClickListener;
    private CardObserver mSetCardObserver;
    private QQProgressDialog mSettingDialog;
    private int needType;

    public AbsVasProfileHeaderComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.mMyCoverType = null;
        this.mDismissRunnable = new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.1
            @Override // java.lang.Runnable
            public void run() {
                AbsVasProfileHeaderComponent.this.dismissDialog();
            }
        };
        this.needType = 0;
        this.mOpenVipServicePromptDialog = null;
        this.mRightButtonClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (AbsVasProfileHeaderComponent.this.needType == 1) {
                    ff.R(((AbsComponent) AbsVasProfileHeaderComponent.this).mActivity, 1, ProfileCardUtil.o(3));
                } else if (AbsVasProfileHeaderComponent.this.needType == 2) {
                    ff.Q(((AbsComponent) AbsVasProfileHeaderComponent.this).mActivity, 1, ProfileCardUtil.o(6));
                } else if (AbsVasProfileHeaderComponent.this.needType == 3) {
                    ff.b(((AbsComponent) AbsVasProfileHeaderComponent.this).mActivity, true, 12, false, ProfileCardUtil.o(6));
                } else if (AbsVasProfileHeaderComponent.this.needType == 4) {
                    VasH5PayUtil.openH5Pay((Context) ((AbsComponent) AbsVasProfileHeaderComponent.this).mActivity, ProfileCardUtil.o(6), "SVHHZLH", 0, false, false);
                }
                AbsVasProfileHeaderComponent.this.cancelOpenVipPromptDialog();
            }
        };
        this.mLeftButtonClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                AbsVasProfileHeaderComponent.this.cancelOpenVipPromptDialog();
            }
        };
        this.mSetCardObserver = new CardObserver() { // from class: com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4
            @Override // com.tencent.mobileqq.app.CardObserver
            public void onSetCardTemplateReturn(boolean z16, Object obj) {
                try {
                    if (!((AbsComponent) AbsVasProfileHeaderComponent.this).mActivity.isFinishing()) {
                        ((AbsProfileHeaderComponent) AbsVasProfileHeaderComponent.this).mUIHandler.removeCallbacks(AbsVasProfileHeaderComponent.this.mDismissRunnable);
                        AbsVasProfileHeaderComponent.this.dismissDialog();
                        if (z16 && obj != null) {
                            if (obj instanceof Card) {
                                final Card card = (Card) obj;
                                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        WeakReferenceHandler weakReferenceHandler = ((AbsProfileHeaderComponent) AbsVasProfileHeaderComponent.this).mUIHandler;
                                        if (weakReferenceHandler == null) {
                                            return;
                                        }
                                        AbsVasProfileHeaderComponent absVasProfileHeaderComponent = AbsVasProfileHeaderComponent.this;
                                        Card card2 = card;
                                        weakReferenceHandler.sendMessage(weakReferenceHandler.obtainMessage(13, Boolean.valueOf(absVasProfileHeaderComponent.saveCardId2DB((int) card2.lCurrentStyleId, (int) card2.lCurrentBgId, card2.backgroundUrl, (int) card2.backgroundColor, card2.templateRet, card2.diyComplicatedInfo, card2.cardId))));
                                    }
                                }, 5, null, true);
                            } else if (obj instanceof Pair) {
                                SSummaryCardRsp sSummaryCardRsp = (SSummaryCardRsp) ((Pair) obj).second;
                                if (TextUtils.isEmpty(sSummaryCardRsp.strActiveCardUrl)) {
                                    AbsVasProfileHeaderComponent.this.enterPersonalityCardMall("CLICK_HEADER_BG");
                                } else {
                                    ProfileCardUtil.H(((AbsComponent) AbsVasProfileHeaderComponent.this).mActivity, sSummaryCardRsp.bgid, sSummaryCardRsp.strActiveCardUrl);
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private void addAnimationListener(final String str, final ActionSheet actionSheet) {
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.5
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (((AbsComponent) AbsVasProfileHeaderComponent.this).mApp == null) {
                    return;
                }
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ReportController.o(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", ff.h(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp, ((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getCurrentAccountUin()));
                            if (((ProfileCardInfo) ((AbsComponent) AbsVasProfileHeaderComponent.this).mData).isTroopMemberCard) {
                                VasWebviewUtil.reportCommercialDrainage(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getCurrentAccountUin(), "group_card", "click_cancel", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                            }
                        }
                    } else {
                        ReportController.o(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", ff.h(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp, ((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getCurrentAccountUin()));
                        AbsVasProfileHeaderComponent.this.enterPersonalityCardMall(str);
                    }
                } else {
                    ReportController.o(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", ff.h(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp, ((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getCurrentAccountUin()));
                    if (((ProfileCardInfo) ((AbsComponent) AbsVasProfileHeaderComponent.this).mData).isTroopMemberCard) {
                        VasWebviewUtil.reportCommercialDrainage(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getCurrentAccountUin(), "group_card", "click_setresult", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                    }
                    if (((ProfileCardInfo) ((AbsComponent) AbsVasProfileHeaderComponent.this).mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC || ((ProfileCardInfo) ((AbsComponent) AbsVasProfileHeaderComponent.this).mData).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) {
                        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_setmy", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo) ((AbsComponent) AbsVasProfileHeaderComponent.this).mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo) ((AbsComponent) AbsVasProfileHeaderComponent.this).mData).card.lCurrentStyleId));
                    }
                    AbsVasProfileHeaderComponent.this.handleDiyBackground(str);
                }
                actionSheet.superDismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        QQProgressDialog qQProgressDialog = this.mSettingDialog;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.mSettingDialog.dismiss();
            } catch (Exception unused) {
            }
        }
        this.mSettingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void enterPersonalityCardMall(String str) {
        String str2;
        String str3;
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        DATA data = this.mData;
        if (((ProfileCardInfo) data).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC || ((ProfileCardInfo) data).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) {
            VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_morecard", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo) this.mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo) this.mData).card.lCurrentStyleId));
        }
        String myCoverType = getMyCoverType();
        if (myCoverType != null && myCoverType.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM)) {
            str2 = "oldCustom=1";
        } else {
            str2 = "";
        }
        String str4 = str2;
        QBaseActivity qBaseActivity = this.mActivity;
        String currentAccountUin = this.mApp.getCurrentAccountUin();
        if (str.equals("CLICK_HEADER_BG")) {
            str3 = "inside.friendCardBackground";
        } else {
            str3 = "inside.blackBar";
        }
        ProfileCardUtil.F(qBaseActivity, currentAccountUin, str3, 1, 1, 1, str4, false, 42);
    }

    private String getMyCoverType() {
        if (!TextUtils.isEmpty(this.mMyCoverType)) {
            return this.mMyCoverType;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.6
            @Override // java.lang.Runnable
            public void run() {
                QZoneCover qZoneCover;
                Card r16 = ((FriendsManager) ((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getCurrentAccountUin());
                if (r16 == null) {
                    AbsVasProfileHeaderComponent.this.mMyCoverType = "-1";
                } else if (r16.lCurrentStyleId == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID && (qZoneCover = (QZoneCover) DBMethodProxy.find(((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) QZoneCover.class, ((AbsComponent) AbsVasProfileHeaderComponent.this).mApp.getCurrentAccountUin())) != null) {
                    AbsVasProfileHeaderComponent.this.mMyCoverType = qZoneCover.type;
                }
                AbsVasProfileHeaderComponent.this.mMyCoverType = "-1";
            }
        }, 8, null, true);
        return "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:
    
        if (((com.tencent.mobileqq.profilecard.data.ProfileCardInfo) r0).card.dynamicCardFlag != 1) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleDiyBackground(String str) {
        DATA data = this.mData;
        if (((ProfileCardInfo) data).card.lCurrentBgId != 160 && ((ProfileCardInfo) data).card.lCurrentBgId != 1600) {
            if (ProfileCardUtil.Q(((ProfileCardInfo) data).card.getBgTypeArray())) {
                DATA data2 = this.mData;
                if (((ProfileCardInfo) data2).card.cardType != 2) {
                }
            }
            if (ProfileTemplateApi.isDiyTemplateStyleID(((ProfileCardInfo) this.mData).card.lCurrentStyleId)) {
                dr.d(((ProfileCardInfo) this.mData).card, this.mQQAppInterface, this.mActivity);
                ReportController.o(this.mApp, "dc00898", "", "", "qvip", "0X8009E3A", 2, 0, "", "", "", "");
                return;
            } else {
                DATA data3 = this.mData;
                setStyleAndBg(((ProfileCardInfo) data3).card.lCurrentStyleId, ((ProfileCardInfo) data3).card.lCurrentBgId, ((ProfileCardInfo) data3).card.backgroundColor, ((ProfileCardInfo) data3).card.strExtInfo);
                ReportController.o(this.mApp, "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
                return;
            }
        }
        enterPersonalityCardMall(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleJueBanClick() {
        QBaseActivity qBaseActivity = this.mActivity;
        DATA data = this.mData;
        ProfileCardUtil.H(qBaseActivity, ((ProfileCardInfo) data).card.lCurrentBgId, ((ProfileCardInfo) data).card.strActiveUrl);
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "0", "", "", "");
        } else {
            ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "1", "", "", "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleTemplateHeaderClick(String str) {
        AppInterface appInterface;
        if ((this.mHeaderView instanceof ProfileBaseView) || (appInterface = this.mApp) == null) {
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (((ProfileCardInfo) this.mData).allInOne.uin.equals(currentAccountUin)) {
            ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X8004435", 0, 0, Long.toString(((ProfileCardInfo) this.mData).card.lCurrentBgId), "", "", ff.h(this.mApp, currentAccountUin));
            ownerTemplateHeaderClick(currentAccountUin);
            return;
        }
        visitorTemplateHeaderClick(str, currentAccountUin);
        ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X80047F0", 0, 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(((ProfileCardInfo) this.mData).allInOne)), Long.toString(((ProfileCardInfo) this.mData).card.lCurrentBgId), "", ff.h(this.mApp, currentAccountUin));
        String string = this.mActivity.getString(R.string.g3u);
        ReportController.o(this.mApp, "dc00898", "", "", "", "0X800A4C0", 0, 0, "", "", "", "");
        ActionSheet create = ActionSheet.create(this.mActivity);
        create.addButton(R.string.g8z, 1);
        create.addButton(string, 1);
        create.addButton(R.string.cancel, 1);
        addAnimationListener(str, create);
        try {
            create.show();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void ownerTemplateHeaderClick(String str) {
        int i3;
        DATA data = this.mData;
        if (((ProfileCardInfo) data).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC || ((ProfileCardInfo) data).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) {
            VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_owner", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo) this.mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo) this.mData).card.lCurrentStyleId));
        }
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            String currentAccountUin = this.mApp.getCurrentAccountUin();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            sb5.append(i3);
            VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "group_card", "click_cover", "", 0, 0, 0, "", "", sb5.toString(), "", "", "", "", 0, 0, 0, 0);
        }
        ProfileCardUtil.F(this.mActivity, str, "inside.myCardBackground", 1, 0, 1, "", true, 40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveCardId2DB(long j3, int i3, String str, int i16, int i17, String str2, long j16) {
        FriendsManager friendsManager = (FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card r16 = friendsManager.r(this.mActivity.getAppRuntime().getCurrentAccountUin());
        if (r16 == null || j3 < 0) {
            return false;
        }
        r16.lCurrentStyleId = j3;
        r16.lCurrentBgId = i3;
        r16.strCurrentBgUrl = str;
        r16.backgroundColor = i16;
        r16.templateRet = i17;
        r16.cardId = j16;
        if (TextUtils.isEmpty(r16.diyComplicatedInfo)) {
            r16.diyComplicatedInfo = str2;
        }
        if (!friendsManager.p0(r16)) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "save card in db failed ");
            }
            return false;
        }
        return true;
    }

    private void setStyleAndBg(long j3, long j16, long j17, String str) {
        dismissDialog();
        showProgressDialog();
        ProfileCardUtil.v0(this.mQQAppInterface, j3, j16, null, j17, str);
        this.mUIHandler.postDelayed(this.mDismissRunnable, 30000L);
    }

    private void showOpenVipPromptDialog() {
        String string;
        String qqStr;
        if (!this.mActivity.isFinishing()) {
            cancelOpenVipPromptDialog();
            int i3 = this.needType;
            if (i3 == 1) {
                string = this.mActivity.getString(R.string.d2n);
                qqStr = HardCodeUtil.qqStr(R.string.mti);
            } else if (i3 == 2) {
                string = this.mActivity.getString(R.string.d2f);
                qqStr = HardCodeUtil.qqStr(R.string.mto);
            } else if (i3 == 3) {
                string = this.mActivity.getString(R.string.f171492fd3);
                qqStr = HardCodeUtil.qqStr(R.string.msw);
            } else if (i3 == 4) {
                string = this.mActivity.getString(R.string.i1h);
                qqStr = "\u5f00\u901aQQ\u5927\u4f1a\u5458\u5373\u53ef\u4f7f\u7528\u8be5\u540d\u7247";
            } else {
                string = this.mActivity.getString(R.string.d2f);
                qqStr = HardCodeUtil.qqStr(R.string.mts);
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.mActivity, 0, string, qqStr, R.string.d2d, R.string.d2e, this.mRightButtonClickListener, this.mLeftButtonClickListener);
            this.mOpenVipServicePromptDialog = createCustomDialog;
            createCustomDialog.show();
        }
    }

    private void showProgressDialog() {
        try {
            if (!this.mActivity.isFinishing()) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this.mActivity);
                this.mSettingDialog = qQProgressDialog;
                qQProgressDialog.setCancelable(false);
                this.mSettingDialog.setMessage(R.string.d3y);
                this.mSettingDialog.show();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void visitorTemplateHeaderClick(String str, String str2) {
        if ("CLICK_HEADER_BG".equals(str)) {
            AppInterface appInterface = this.mApp;
            ReportController.o(appInterface, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "1", "", "", ff.h(appInterface, str2));
            DATA data = this.mData;
            if (((ProfileCardInfo) data).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC || ((ProfileCardInfo) data).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) {
                VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_visitor", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo) this.mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo) this.mData).card.lCurrentStyleId));
                return;
            }
            return;
        }
        if ("CLICK_BANNER".equals(str)) {
            AppInterface appInterface2 = this.mApp;
            ReportController.o(appInterface2, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "2", "", "", ff.h(appInterface2, str2));
        }
    }

    protected void cancelOpenVipPromptDialog() {
        QQCustomDialog qQCustomDialog = this.mOpenVipServicePromptDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.mOpenVipServicePromptDialog = null;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public final int getComponentType() {
        return 1002;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent
    public void handleSubMessage(Message message) {
        super.handleSubMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent
    public void handleUIMessage(Message message) {
        super.handleUIMessage(message);
        if (message.what == 13) {
            if (((Boolean) message.obj).booleanValue()) {
                if (this.mApp == null) {
                    return;
                }
                AllInOne allInOne = new AllInOne(this.mApp.getCurrentAccountUin(), 0);
                allInOne.nickname = this.mApp.getCurrentNickname();
                allInOne.lastActivity = 1;
                allInOne.profileEntryType = 5;
                DATA data = this.mData;
                if (data != 0 && !((ProfileCardInfo) data).allInOne.uin.equals(this.mApp.getCurrentAccountUin())) {
                    ProfileUtils.openProfileCard(this.mActivity, allInOne);
                    return;
                }
                return;
            }
            QQToast.makeText(this.mActivity.getApplicationContext(), R.string.d3z, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer
    public boolean hasPhotoWall() {
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        if (view.getTag() instanceof b) {
            b bVar = (b) view.getTag();
            int i3 = bVar.f260135a;
            if (i3 != 29) {
                if (i3 != 34) {
                    if (i3 != 105) {
                        if (i3 == 115) {
                            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.mActivity, ((ProfileCardInfo) this.mData).card.vipMedalJumpUrl);
                        }
                    } else {
                        VipQidHelper.jumpQidSetInfoPage(this.mActivity, (ProfileCardInfo) this.mData);
                    }
                } else {
                    handleJueBanClick();
                }
            } else {
                Object obj = bVar.f260136b;
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = "CLICK_HEADER_BG";
                }
                handleTemplateHeaderClick(str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((FrameLayout) view).setOnClickListener(null);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        super.onResume();
        this.mApp.addObserver(this.mSetCardObserver);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStop() {
        super.onStop();
        this.mApp.removeObserver(this.mSetCardObserver);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public void setContainerView(FrameLayout frameLayout) {
        super.setContainerView((AbsVasProfileHeaderComponent) frameLayout);
        frameLayout.setTag(new b(29, null));
        frameLayout.setOnClickListener(this);
    }
}
