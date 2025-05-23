package com.tencent.mobileqq.profilecard.container.bottomcontainer;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.av.utils.bc;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.aio.event.NTPanelEntrance;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.container.AbsQQProfileContainer;
import com.tencent.mobileqq.profilecard.base.container.IProfileBottomContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfileCardForbidAccountHelper;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qqexpand.profilecard.IExpandProfileComponentUtils;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.am;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqnt.aio.helper.ee;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.api.IRelationAIOService;
import com.tencent.tbs.reader.ITbsReader;
import com.tencent.util.QQToastUtil;
import com.tencent.util.k;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.mobileim.structmsg.structmsg$AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgAction;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* loaded from: classes35.dex */
public abstract class BaseProfileBottomContainer extends AbsQQProfileContainer implements IProfileBottomContainer, View.OnClickListener {
    private static final int BTNS_STYLE_ADD = 6;
    private static final int BTNS_STYLE_ADD_CALL = 5;
    private static final int BTNS_STYLE_ADD_CHAT = 3;
    private static final int BTNS_STYLE_ADD_CHAT_CALL = 2;
    public static final int BTNS_STYLE_AGREE_TO_ADD = 13;
    private static final int BTNS_STYLE_CALL = 8;
    private static final int BTNS_STYLE_CHAT = 7;
    public static final int BTNS_STYLE_CHAT_CALL = 4;
    public static final int BTNS_STYLE_EDIT = 1;
    private static final int BTNS_STYLE_NONE = 0;
    private static final int BTNS_STYLE_SAVE = 10;
    private static final int BTNS_STYLE_SAVE_ADD = 11;
    public static final int BTNS_STYLE_TROOP_MEM_SEND_GIFT = 12;
    private static final int BTN_INDEX_BLUE_ONE = 2;
    private static final int BTN_INDEX_EDIT = 1;
    private static final int BTN_INDEX_SEND_OR_ADD = 2;
    private static final int BTN_INDEX_VIP_CARD = 0;
    private static final int BTN_INDEX_WHITE_ONE = 0;
    private static final int BTN_INDEX_WHITE_TWO = 1;
    private static final int BTN_STYLE_BLUE = 2;
    private static final int BTN_STYLE_WHITE = 1;
    private static final String GIVE_BUTTON_URL = "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}";
    private static final int[] HANDLE_UPDATE_BTN_GROUP_INNER_TYPE = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13};
    private static final String KEY_GIVE_GIFT_BUTTON_IN_PROFILE_URL = "give_gift_button_in_profile_url";
    private static final String TAG = "BaseProfileBottomContainer";
    private Dialog addFriendDialog;
    private boolean isBlacklistCache;
    private boolean isCheckBlacklist;
    private boolean isForbidAccount;
    private boolean isInit;
    public LinearLayout mBtnsContainer;
    private boolean mIsFromArkBabyQ;
    private RedTouch mTemplateCardRedTouch;
    private BusinessInfoCheckUpdate.AppInfo mTemplateRedPointInfo;

    /* loaded from: classes35.dex */
    public static class SourceParam {
        int sourceId = BuddySource.DEFAULT;
        int subSourceId = 0;

        public String toString() {
            return "SourceParam{sourceId=" + this.sourceId + ", subSourceId=" + this.subSourceId + '}';
        }
    }

    public BaseProfileBottomContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.isInit = false;
        this.isCheckBlacklist = false;
        this.isBlacklistCache = false;
        this.isForbidAccount = ProfileCardForbidAccountHelper.isForbidBySpecifyTypes(new ArrayList(Collections.singletonList(201)), profileCardInfo != null ? profileCardInfo.card : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addFriendInner() {
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 96 ? ((IExpandProfileComponentUtils) QRoute.api(IExpandProfileComponentUtils.class)).interceptAddFriend(this.mComponentCenter, (ProfileCardInfo) this.mData) : false) {
            return;
        }
        addFriend(this.mQQAppInterface, this.mActivity, (ProfileCardInfo) this.mData, this.addFriendDialog);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean checkBlacklistForbid(final boolean z16, final boolean z17, final boolean z18, final boolean z19) {
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).allInOne == null) {
            return false;
        }
        if (this.isCheckBlacklist) {
            if (this.isBlacklistCache) {
                lambda$checkBlacklistForbid$1(z16, z17, z19);
            } else {
                dismissTipsLayout();
            }
            return this.isBlacklistCache;
        }
        boolean isBlackOrBlackedUin = ((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).isBlackOrBlackedUin(((ProfileCardInfo) this.mData).allInOne.uin, new CheckBlacklistListener() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.g
            @Override // com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener
            public final void onResult(boolean z26) {
                BaseProfileBottomContainer.this.lambda$checkBlacklistForbid$2(z16, z17, z18, z19, z26);
            }
        });
        this.isBlacklistCache = isBlackOrBlackedUin;
        this.isCheckBlacklist = true;
        if (isBlackOrBlackedUin) {
            lambda$checkBlacklistForbid$1(z16, z17, z19);
        } else {
            dismissTipsLayout();
        }
        return this.isBlacklistCache;
    }

    private long checkGetValidNumber(String str, long j3) {
        long a16 = com.tencent.biz.qqstory.utils.f.a(str, j3);
        if (a16 != j3) {
            return a16;
        }
        QQToast.makeText(this.mActivity, R.string.f1359202r, 0).show();
        QLog.e(TAG, 1, "checkAndGetValidNumber invalid param: " + str, new Throwable());
        return j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dismissTipsLayout() {
        View findViewById = ((FrameLayout) this.mViewContainer).findViewById(R.id.tb6);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public static void enterChat(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        int i3;
        AllInOne allInOne = profileCardInfo.allInOne;
        int p16 = ProfileCardUtil.p(allInOne);
        String str = allInOne.preWinUin;
        if (str != null && str.length() > 0 && (i3 = allInOne.preWinType) != 3000 && i3 != 1 && i3 != 2 && i3 != 1033 && i3 != 1034 && i3 != 1044 && i3 != 1045 && allInOne.preWinUin.equals(allInOne.uin) && !isPadSplitMode(qBaseActivity)) {
            Intent intent = new Intent();
            intent.putExtra("finchat", true);
            qBaseActivity.setResult(0, intent);
            qBaseActivity.finish();
            return;
        }
        String str2 = allInOne.uin;
        if (ProfilePAUtils.isPaTypeStrangerInContact(allInOne)) {
            if (allInOne.f260789pa == 53) {
                ContactCard contactCard = profileCardInfo.contactCard;
                if (contactCard == null || TextUtils.isEmpty(contactCard.uin)) {
                    p16 = 1006;
                } else {
                    str2 = profileCardInfo.contactCard.uin;
                    p16 = 0;
                }
            } else {
                str2 = ProfileUtils.getMobileNumberWithNationCode(allInOne);
            }
        }
        enterChat(qQAppInterface, qBaseActivity, profileCardInfo, str2, p16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void enterChatByTroopMember() {
        final Intent intent = new Intent();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("profile_open_aio_force_chat_activity", true)) {
            intent.setComponent(new ComponentName(this.mActivity, (Class<?>) ChatActivity.class));
        } else {
            intent = l.w(this.mActivity, ChatActivity.class.getName());
        }
        BaseAIOUtils.m(intent, null);
        intent.putExtra("uin", ((ProfileCardInfo) this.mData).allInOne.uin);
        intent.putExtra("PREVIOUS_WINDOW", this.mActivity.getClass().getName());
        intent.putExtra("PREVIOUS_UIN", ((ProfileCardInfo) this.mData).allInOne.uin);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin);
        if (!((ProfileCardInfo) this.mData).troopMemberCard.isFriend && !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG)) {
            intent.putExtra("uintype", 1000);
            long checkGetValidNumber = checkGetValidNumber(((ProfileCardInfo) this.mData).troopUin, 0L);
            if (checkGetValidNumber == 0) {
                return;
            }
            intent.putExtra("key_groupUin", checkGetValidNumber);
            long checkGetValidNumber2 = checkGetValidNumber(((ProfileCardInfo) this.mData).allInOne.uin, 0L);
            if (checkGetValidNumber2 == 0) {
                return;
            } else {
                intent.putExtra("key_peerUin", checkGetValidNumber2);
            }
        } else {
            intent.putExtra("uintype", 0);
        }
        ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
        DATA data = this.mData;
        iTroopMemberListRepoApi.fetchTroopMemberName(((ProfileCardInfo) data).troopUin, ((ProfileCardInfo) data).allInOne.uin, TAG, new Function1() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$enterChatByTroopMember$6;
                lambda$enterChatByTroopMember$6 = BaseProfileBottomContainer.this.lambda$enterChatByTroopMember$6(intent, (TroopMemberNickInfo) obj);
                return lambda$enterChatByTroopMember$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void enterChatInner() {
        DATA data = this.mData;
        if (((ProfileCardInfo) data).isTroopMemberCard) {
            QLog.i(TAG, 1, "[enterChatInner] start. isTroopMemberCard");
            enterChatByTroopMember();
        } else if (ProfilePAUtils.isFromExtendFriend(((ProfileCardInfo) data).allInOne)) {
            QLog.i(TAG, 1, "[enterChatInner] start. from extend friend");
            ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).sendMsg(this.mQQAppInterface, ((ProfileCardInfo) this.mData).allInOne, new com.tencent.mobileqq.qqexpand.chat.e() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.5
                @Override // com.tencent.mobileqq.qqexpand.chat.e
                public void enterAio(String str, String str2) {
                    ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).enterAio(((AbsComponent) BaseProfileBottomContainer.this).mActivity, str, str2);
                }

                public void showCampusVerifyDialog(boolean z16, int i3, String str, String str2) {
                    ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).showCampusVerifyDialog(((AbsComponent) BaseProfileBottomContainer.this).mActivity, z16, i3, str, str2);
                }

                @Override // com.tencent.mobileqq.qqexpand.chat.e
                public void showMatchCountDialog() {
                    ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).showMatchCountDialog(((AbsComponent) BaseProfileBottomContainer.this).mActivity);
                }

                @Override // com.tencent.mobileqq.qqexpand.chat.e
                public void showToast(int i3) {
                    if (((AbsComponent) BaseProfileBottomContainer.this).mActivity == null) {
                        QLog.d(BaseProfileBottomContainer.TAG, 1, "showToast() activity is null just return");
                    } else {
                        ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).showToast(((AbsComponent) BaseProfileBottomContainer.this).mActivity, ((AbsComponent) BaseProfileBottomContainer.this).mActivity.getString(i3));
                    }
                }
            });
        } else {
            QLog.i(TAG, 1, "[enterChatInner] start. default");
            enterChat(this.mQQAppInterface, this.mActivity, (ProfileCardInfo) this.mData);
        }
    }

    private static String getCallNickName(ProfileCardInfo profileCardInfo, QQAppInterface qQAppInterface) {
        int p16 = ProfileCardUtil.p(profileCardInfo.allInOne);
        if (p16 == 0) {
            r1 = TextUtils.isEmpty(null) ? profileCardInfo.nameArray[4] : null;
            if (TextUtils.isEmpty(r1)) {
                r1 = profileCardInfo.allInOne.remark;
            }
        } else if (p16 == 1000 || p16 == 1020) {
            r1 = profileCardInfo.nameArray[1];
            if (TextUtils.isEmpty(r1)) {
                r1 = profileCardInfo.allInOne.troopNickName;
            }
        } else if (p16 == 1021) {
            r1 = profileCardInfo.nameArray[2];
            if (TextUtils.isEmpty(r1)) {
                r1 = profileCardInfo.allInOne.circleName;
            }
        } else if (p16 == 1004) {
            AllInOne allInOne = profileCardInfo.allInOne;
            String str = allInOne.troopUin;
            if (str != null) {
                r1 = ac.n(qQAppInterface, str, allInOne.uin);
            }
        } else if (ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne)) {
            r1 = profileCardInfo.nameArray[3];
        }
        if (TextUtils.isEmpty(r1)) {
            r1 = profileCardInfo.nameArray[0];
        }
        return TextUtils.isEmpty(r1) ? profileCardInfo.allInOne.nickname : r1;
    }

    private QUIButton getQUIButton() {
        QUIButton qUIButton = new QUIButton(this.mActivity);
        qUIButton.setSizeType(0);
        qUIButton.setId(R.id.ouc);
        return qUIButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initViews() {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((FrameLayout) view).removeAllViews();
            this.mActivity.getLayoutInflater().inflate(R.layout.h09, (ViewGroup) this.mViewContainer);
            LinearLayout linearLayout = (LinearLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.al_);
            this.mBtnsContainer = linearLayout;
            initBottomBtns(linearLayout);
            ((FrameLayout) this.mViewContainer).setVisibility(8);
            this.mBtnsContainer.setVisibility(8);
            ProfileCardForbidAccountHelper.updateViewGroupEnableState(this.mBtnsContainer, !this.isForbidAccount);
        }
    }

    public static boolean isCanOpenGiftPanelUseRepo() {
        AppRuntime app = VasUtil.getApp();
        if (app == null) {
            QLog.e(TAG, 1, "isCanOpenGiftPanelUseRepo :app is null");
            return false;
        }
        return ((IFeatureRuntimeService) app.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("vas_group_gift_panel", false);
    }

    private boolean isContactChatProhibit(int i3) {
        if (com.tencent.relation.common.config.toggle.c.Y.g(false)) {
            return i3 == 29 || i3 == 31 || i3 == 32 || i3 == 33 || i3 == 34 || i3 == 50 || i3 == 51 || i3 == 53;
        }
        return false;
    }

    private boolean isNeedHandleUpdateBtnGroupInnerDefault(int i3) {
        for (int i16 : HANDLE_UPDATE_BTN_GROUP_INNER_TYPE) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void jumpLaunchAddFriendWithCardInfoAndTroop(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, boolean z16, int i3, int i16, String str) {
        String str2;
        String str3;
        int i17;
        String stringExtra;
        String str4 = null;
        if (3004 == i3 && !TextUtils.isEmpty(profileCardInfo.allInOne.troopUin)) {
            str3 = profileCardInfo.allInOne.troopUin;
        } else if (3005 == i3 && !TextUtils.isEmpty(profileCardInfo.allInOne.discussUin)) {
            str3 = profileCardInfo.allInOne.discussUin;
        } else {
            str2 = null;
            i17 = profileCardInfo.allInOne.f260789pa;
            if (i17 != 71 || i17 == 72) {
                str4 = profileCardInfo.nameArray[2];
            } else if (i17 == 77 || i17 == 82 || i17 == 81 || i17 == 83 || i17 == 84 || i17 == 101 || i17 == 103 || i17 == 102 || i17 == 107 || i17 == 110) {
                str4 = profileCardInfo.nameArray[5];
            }
            String str5 = !TextUtils.isEmpty(str4) ? profileCardInfo.nameArray[0] : str4;
            stringExtra = qBaseActivity.getIntent().getStringExtra("param_return_addr");
            if (stringExtra == null) {
                String name = stringExtra.equals(QidianProfileCardActivity.class.getName()) ? stringExtra : AddContactsActivity.class.getName();
                if (TextUtils.isEmpty(str5)) {
                    str5 = profileCardInfo.profileName.f305805a.f305804b;
                }
                Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(qBaseActivity, 1, profileCardInfo.allInOne.uin, str2, i3, i16, str5, null, name, qBaseActivity.getString(R.string.button_back), null);
                startAddFriend.putExtra(AppConstants.Key.KEY_FROM_BABYQ, z16);
                ProfileActivity.K2(qBaseActivity, startAddFriend, profileCardInfo);
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(qBaseActivity, startAddFriend);
                return;
            }
            Intent startAddFriend2 = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(qBaseActivity, 1, profileCardInfo.allInOne.uin, str2, i3, i16, str5, null, ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass().getName(), qBaseActivity.getString(R.string.button_back), null);
            startAddFriend2.putExtra(AppConstants.Key.KEY_FROM_BABYQ, z16);
            ProfileActivity.K2(qBaseActivity, startAddFriend2, profileCardInfo);
            byte[] byteArray = profileCardInfo.allInOne.extras.getByteArray("recommend_algh_id");
            startAddFriend2.putExtra("algo_id", (byteArray == null || byteArray.length <= 0) ? "" : new String(byteArray, StandardCharsets.UTF_8));
            startAddFriend2.putExtra("profile_uid", profileCardInfo.allInOne.uid);
            if (i3 == 3094) {
                startAddFriend2.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, qBaseActivity.getIntent().getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 2));
                startAddFriend2.removeExtra("param_return_addr");
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(qBaseActivity, startAddFriend2);
                return;
            } else {
                startAddFriend2.putExtra("key_param_age_area", str);
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(qBaseActivity, startAddFriend2, IProfileCardConst.REQUEST_FOR_ADD_FRIEND);
                return;
            }
        }
        str2 = str3;
        i17 = profileCardInfo.allInOne.f260789pa;
        if (i17 != 71) {
        }
        str4 = profileCardInfo.nameArray[2];
        if (!TextUtils.isEmpty(str4)) {
        }
        stringExtra = qBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (stringExtra == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkBlacklistForbid$0(boolean z16, boolean z17, boolean z18, boolean z19) {
        dismissTipsLayout();
        updateBtnGroupByParamCombination(z16, z17, z18, z19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkBlacklistForbid$2(final boolean z16, final boolean z17, final boolean z18, final boolean z19, boolean z26) {
        if (this.isBlacklistCache == z26) {
            return;
        }
        this.isBlacklistCache = z26;
        if (!z26) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.b
                @Override // java.lang.Runnable
                public final void run() {
                    BaseProfileBottomContainer.this.lambda$checkBlacklistForbid$0(z16, z17, z18, z19);
                }
            });
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.c
                @Override // java.lang.Runnable
                public final void run() {
                    BaseProfileBottomContainer.this.lambda$checkBlacklistForbid$1(z16, z17, z19);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Unit lambda$enterChatByTroopMember$6(final Intent intent, TroopMemberNickInfo troopMemberNickInfo) {
        String str;
        final QBaseActivity qBaseActivity = this.mActivity;
        AppInterface appInterface = this.mApp;
        if (qBaseActivity != null && appInterface != null) {
            if (troopMemberNickInfo != null) {
                str = troopMemberNickInfo.getShowName();
            } else {
                str = "";
            }
            QLog.i(TAG, 1, "[enterChatByTroopMember] nickName:" + k.d(str));
            if (TextUtils.isEmpty(str)) {
                str = ((ProfileCardInfo) this.mData).troopMemberCard.nick;
            }
            intent.putExtra("uinname", str);
            intent.putExtra(AppConstants.Key.TROOP_CODE, ((ProfileCardInfo) this.mData).troopUin);
            TroopManager troopManager = (TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null) {
                troopManager.r(((ProfileCardInfo) this.mData).troopUin, new ITroopInfoService.a() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.6
                    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService.a
                    public void onResult(Object obj) {
                        if ((obj instanceof String) && qBaseActivity != null) {
                            intent.putExtra("troop_uin", (String) obj);
                            intent.putExtra(AppConstants.Key.CSPECIAL_FLAG, 0);
                            intent.putExtra("key_from", "3");
                            qBaseActivity.startActivity(intent);
                            return;
                        }
                        QLog.i(BaseProfileBottomContainer.TAG, 1, "[enterChatByTroopMember] onResult  result:" + obj);
                    }
                });
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSaveContactClick$3(String str, int i3) {
        if (this.mActivity == null || TextUtils.isEmpty(str)) {
            return;
        }
        QQToast.makeText(this.mActivity, i3, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$handleSaveContactClick$4() {
        final String qqStr;
        final int i3;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "");
        DATA data = this.mData;
        if (!iPhoneContactService.existContact(((ProfileCardInfo) data).allInOne.contactName, ((ProfileCardInfo) data).allInOne.uin)) {
            DATA data2 = this.mData;
            if (iPhoneContactService.addContactAndUpload(((ProfileCardInfo) data2).allInOne.contactName, ((ProfileCardInfo) data2).allInOne.uin)) {
                qqStr = HardCodeUtil.qqStr(R.string.msq);
                i3 = 2;
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.mtj);
                i3 = 1;
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f172023msg);
            i3 = 0;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseProfileBottomContainer.this.lambda$handleSaveContactClick$3(qqStr, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSaveContactClick$5() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.d
            @Override // java.lang.Runnable
            public final void run() {
                BaseProfileBottomContainer.this.lambda$handleSaveContactClick$4();
            }
        }, 32, null, true);
    }

    private void reportRedPointClicked() {
        BusinessInfoCheckUpdate.AppInfo appInfo = this.mTemplateRedPointInfo;
        if (appInfo == null || appInfo.iNewFlag.get() == 0) {
            return;
        }
        ((RedTouchManager) this.mApp.getManager(QQManagerFactory.MGR_RED_TOUCH)).k0(String.format("%d%s%d", 100100, ".", Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_TEMPLATE_CARD)));
        this.mTemplateRedPointInfo = null;
    }

    private void resetAllBtnGone() {
        int childCount = this.mBtnsContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mBtnsContainer.getChildAt(i3);
            if (childAt != null) {
                childAt.setVisibility(8);
            }
        }
    }

    public static void setSourceParamValue1(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 == 3) {
            sourceParam.sourceId = 3002;
            sourceParam.subSourceId = allInOne.subSourceId;
            return;
        }
        if (i3 == 35) {
            sourceParam.sourceId = 3001;
            sourceParam.subSourceId = 1;
            return;
        }
        if (i3 == 37) {
            sourceParam.sourceId = 3020;
            sourceParam.subSourceId = allInOne.subSourceId;
            return;
        }
        if (i3 == 58) {
            sourceParam.sourceId = 3007;
            sourceParam.subSourceId = 1;
            return;
        }
        if (i3 == 75) {
            sourceParam.sourceId = 3017;
            sourceParam.subSourceId = 1;
        } else if (i3 == 21) {
            sourceParam.sourceId = 3004;
            sourceParam.subSourceId = allInOne.subSourceId;
        } else {
            if (i3 != 22) {
                return;
            }
            sourceParam.sourceId = 3004;
            sourceParam.subSourceId = 3;
        }
    }

    public static void setSourceParamValue2(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 == 25) {
                    sourceParam.sourceId = 3041;
                    sourceParam.subSourceId = 12;
                    return;
                }
                if (i3 == 27) {
                    sourceParam.sourceId = 3041;
                    sourceParam.subSourceId = 11;
                    return;
                }
                if (i3 == 74) {
                    sourceParam.sourceId = 3008;
                    sourceParam.subSourceId = 11;
                    return;
                }
                if (i3 != 77) {
                    if (i3 == 41 || i3 == 42) {
                        sourceParam.sourceId = 3007;
                        sourceParam.subSourceId = 2;
                        return;
                    } else {
                        if (i3 == 46 || i3 == 47) {
                            sourceParam.sourceId = 3005;
                            sourceParam.subSourceId = 1;
                            return;
                        }
                        return;
                    }
                }
            }
            sourceParam.sourceId = 3003;
            return;
        }
        sourceParam.sourceId = 3008;
        sourceParam.subSourceId = 12;
    }

    public static void setSourceParamValue3(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 == 23) {
            sourceParam.sourceId = 3037;
            sourceParam.subSourceId = 1;
            return;
        }
        if (i3 != 24) {
            if (i3 != 31) {
                if (i3 == 32) {
                    sourceParam.sourceId = 3009;
                    return;
                }
                if (i3 != 34) {
                    if (i3 == 120) {
                        sourceParam.sourceId = 3037;
                        sourceParam.subSourceId = 2;
                        return;
                    } else if (i3 == 97) {
                        sourceParam.sourceId = 3095;
                        sourceParam.subSourceId = 1;
                        return;
                    } else {
                        if (i3 != 98) {
                            return;
                        }
                        sourceParam.sourceId = 3096;
                        sourceParam.subSourceId = 1;
                        return;
                    }
                }
            }
            sourceParam.sourceId = 3006;
            sourceParam.subSourceId = 13;
            if (z16) {
                sourceParam.sourceId = 3084;
                sourceParam.subSourceId = 1;
                return;
            }
            return;
        }
        sourceParam.sourceId = 3042;
        sourceParam.subSourceId = 1;
    }

    public static void setSourceParamValue4(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 == 29) {
            sourceParam.sourceId = 3075;
            int i16 = allInOne.subSourceId;
            if (i16 != 16 && i16 != 17) {
                sourceParam.subSourceId = 1;
                return;
            } else {
                sourceParam.sourceId = 3006;
                sourceParam.subSourceId = i16;
                return;
            }
        }
        if (i3 != 56 && i3 != 57) {
            switch (i3) {
                case 50:
                    sourceParam.sourceId = 3006;
                    sourceParam.subSourceId = 1;
                    return;
                case 51:
                    sourceParam.sourceId = 3009;
                    sourceParam.subSourceId = 1;
                    return;
                case 52:
                    sourceParam.sourceId = 3003;
                    sourceParam.subSourceId = 1;
                    return;
                case 53:
                    sourceParam.sourceId = 3068;
                    sourceParam.subSourceId = 1;
                    if (z16) {
                        sourceParam.sourceId = 3084;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        sourceParam.sourceId = 3013;
    }

    public static void setSourceParamValue5(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 == 36) {
            sourceParam.sourceId = 3014;
            sourceParam.subSourceId = 1;
            return;
        }
        if (i3 == 61) {
            sourceParam.sourceId = 3011;
            return;
        }
        if (i3 == 78) {
            sourceParam.sourceId = 3022;
            sourceParam.subSourceId = 1;
            if (z16) {
                sourceParam.sourceId = 3083;
                sourceParam.subSourceId = 1;
                return;
            }
            return;
        }
        if (i3 != 82) {
            switch (i3) {
                case 70:
                    if (allInOne.profileEntryType == 127) {
                        sourceParam.sourceId = 3048;
                    } else {
                        sourceParam.sourceId = 3071;
                    }
                    sourceParam.subSourceId = 1;
                    return;
                case 71:
                case 72:
                    sourceParam.sourceId = 3003;
                    sourceParam.subSourceId = 2;
                    return;
                default:
                    return;
            }
        }
        sourceParam.sourceId = 3045;
        sourceParam.subSourceId = 21;
    }

    public static void setSourceParamValue6(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16, Bundle bundle) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 == 81) {
            sourceParam.sourceId = 3045;
            sourceParam.subSourceId = 23;
            return;
        }
        if (i3 == 107) {
            sourceParam.sourceId = 3045;
            sourceParam.subSourceId = 28;
            return;
        }
        if (i3 == 110) {
            sourceParam.sourceId = 3045;
            sourceParam.subSourceId = bundle != null ? bundle.getInt("tabID", 0) : 0;
            return;
        }
        if (i3 == 83) {
            sourceParam.sourceId = 3045;
            sourceParam.subSourceId = 3;
            if (z16) {
                sourceParam.sourceId = 3083;
                sourceParam.subSourceId = 1;
                return;
            }
            return;
        }
        if (i3 != 84) {
            switch (i3) {
                case 101:
                    sourceParam.sourceId = 3045;
                    sourceParam.subSourceId = 24;
                    return;
                case 102:
                    sourceParam.sourceId = 3045;
                    sourceParam.subSourceId = 25;
                    return;
                case 103:
                    sourceParam.sourceId = 3045;
                    sourceParam.subSourceId = 20;
                    return;
                default:
                    return;
            }
        }
        sourceParam.sourceId = 3045;
        sourceParam.subSourceId = 4;
    }

    public static void setSourceParamValue7(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 == 95) {
            sourceParam.sourceId = 3092;
            sourceParam.subSourceId = 1;
            return;
        }
        if (i3 == 96) {
            sourceParam.sourceId = 3094;
            sourceParam.subSourceId = allInOne.subSourceId;
            return;
        }
        if (i3 == 108) {
            sourceParam.sourceId = 3041;
            sourceParam.subSourceId = 14;
            return;
        }
        if (i3 == 109) {
            sourceParam.sourceId = 3041;
            sourceParam.subSourceId = 15;
            return;
        }
        if (i3 == 111) {
            int i16 = allInOne.profileEntryType;
            if (i16 == 118) {
                sourceParam.sourceId = 3022;
                sourceParam.subSourceId = 3;
                return;
            } else {
                if (i16 == 121) {
                    sourceParam.sourceId = 3022;
                    sourceParam.subSourceId = 2;
                    return;
                }
                return;
            }
        }
        if (i3 != 112) {
            switch (i3) {
                case 104:
                    sourceParam.sourceId = 3072;
                    sourceParam.subSourceId = 11;
                    return;
                case 105:
                    sourceParam.sourceId = 3072;
                    sourceParam.subSourceId = 12;
                    return;
                case 106:
                    sourceParam.sourceId = ITbsReader.READER_EVENT_NIGHT_MODE_CHANGED;
                    sourceParam.subSourceId = 1;
                    return;
                default:
                    return;
            }
        }
        sourceParam.sourceId = 3004;
        sourceParam.subSourceId = 23;
    }

    public static void setSourceParamValue8(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 == 113) {
            sourceParam.sourceId = 3004;
            sourceParam.subSourceId = allInOne.subSourceId;
            return;
        }
        if (i3 != 123) {
            switch (i3) {
                case 115:
                    sourceParam.sourceId = 3050;
                    sourceParam.subSourceId = 1;
                    return;
                case 116:
                    sourceParam.sourceId = 3076;
                    sourceParam.subSourceId = 4;
                    return;
                case 117:
                    sourceParam.sourceId = 3076;
                    sourceParam.subSourceId = 6;
                    return;
                case 118:
                    sourceParam.sourceId = 3047;
                    sourceParam.subSourceId = 2;
                    return;
                default:
                    return;
            }
        }
        sourceParam.sourceId = 3045;
        sourceParam.subSourceId = 53;
    }

    private void updateBtn(View view, int i3, int i16, int i17, int i18) {
        updateBtn(view, i3, this.mActivity.getString(i16), i17, this.mActivity.getString(i18), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateBtnGroup(boolean z16) {
        boolean z17 = true;
        boolean z18 = false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateBtns isNetRet=%s", Boolean.valueOf(z16)));
        }
        DATA data = this.mData;
        int i3 = ((ProfileCardInfo) data).allInOne.f260789pa;
        if (i3 == 0) {
            updateBtnGroupInner(1);
            return;
        }
        if (i3 != 53) {
            boolean isPaTypeCanAddAsFriend = ProfilePAUtils.isPaTypeCanAddAsFriend(((ProfileCardInfo) data).allInOne);
            boolean isPaTypeCanTalk = ProfilePAUtils.isPaTypeCanTalk(((ProfileCardInfo) this.mData).allInOne);
            boolean isPaTypeCanFreeCall = ProfilePAUtils.isPaTypeCanFreeCall(((ProfileCardInfo) this.mData).allInOne);
            DATA data2 = this.mData;
            if (((ProfileCardInfo) data2).allInOne.profileEntryType == 113) {
                isPaTypeCanTalk = false;
                isPaTypeCanFreeCall = false;
            }
            if (Utils.G(((ProfileCardInfo) data2).allInOne.uin)) {
                if (this.mIsFromArkBabyQ) {
                    isPaTypeCanAddAsFriend = false;
                    isPaTypeCanTalk = false;
                    isPaTypeCanFreeCall = false;
                } else {
                    isPaTypeCanFreeCall = false;
                }
            }
            if (ProfilePAUtils.isFromExtendFriend(((ProfileCardInfo) this.mData).allInOne)) {
                DATA data3 = this.mData;
                if (((ProfileCardInfo) data3).allInOne.extendFriendVoiceCode != null && ((ProfileCardInfo) data3).allInOne.extendFriendVoiceCode.length > 0) {
                    isPaTypeCanTalk = true;
                }
            }
            if (!ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne)) {
                isPaTypeCanFreeCall = false;
            }
            if (isContactChatProhibit(((ProfileCardInfo) this.mData).allInOne.f260789pa)) {
                isPaTypeCanTalk = false;
            }
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 28) {
                z17 = false;
                z18 = isPaTypeCanAddAsFriend;
            }
            updateBtnGroupByParamCombination(z18, isPaTypeCanTalk, isPaTypeCanFreeCall, z17);
            return;
        }
        updateBtnGroupFromContact();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: updateBtnGroupBlacklistInner, reason: merged with bridge method [inline-methods] */
    public void lambda$checkBlacklistForbid$1(boolean z16, boolean z17, boolean z18) {
        View findViewById;
        if (this.mBtnsContainer != null && (findViewById = ((FrameLayout) this.mViewContainer).findViewById(R.id.tb6)) != null) {
            String blacklistTipMsg = ((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).getBlacklistTipMsg(((ProfileCardInfo) this.mData).allInOne.uin);
            if (TextUtils.isEmpty(blacklistTipMsg)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                ((TextView) findViewById.findViewById(R.id.tb7)).setText(blacklistTipMsg);
            }
        }
        if (z16 && z17) {
            updateBtnGroupInner(3);
            return;
        }
        if (z16) {
            updateBtnGroupInner(6);
            return;
        }
        if (z17) {
            updateBtnGroupInner(7);
        } else if (z18) {
            updateBtnGroupInner(13);
        } else {
            updateBtnGroupInner(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateBtnGroupByParamCombination(boolean z16, boolean z17, boolean z18, boolean z19) {
        if (checkBlacklistForbid(z16, z17, z18, z19)) {
            return;
        }
        if (z17 && ((ProfileCardInfo) this.mData).isTroopMemberCard) {
            updateBtnGroupInner(12);
            return;
        }
        if (z16 && z17 && z18) {
            updateBtnGroupInner(2);
            return;
        }
        if (z16 && z17) {
            updateBtnGroupInner(3);
            return;
        }
        if (z17 && z18) {
            updateBtnGroupInner(4);
            return;
        }
        if (z16 && z18) {
            updateBtnGroupInner(5);
            return;
        }
        if (z16) {
            updateBtnGroupInner(6);
            return;
        }
        if (z17) {
            updateBtnGroupInner(7);
            return;
        }
        if (z18) {
            updateBtnGroupInner(5);
        } else if (z19) {
            updateBtnGroupInner(13);
        } else {
            updateBtnGroupInner(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateBtnGroupFromContact() {
        DATA data = this.mData;
        if (((ProfileCardInfo) data).contactCard.bindQQ) {
            if (!TextUtils.isEmpty(((ProfileCardInfo) data).contactCard.uin)) {
                if (TextUtils.equals(((ProfileCardInfo) this.mData).contactCard.uin, this.mApp.getCurrentAccountUin())) {
                    updateBtnGroupInner(0);
                    return;
                } else {
                    updateBtnGroupInner(4);
                    return;
                }
            }
            if (((IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(((ProfileCardInfo) this.mData).contactCard.mobileNo) != null) {
                updateBtnGroupInner(((ProfileCardInfo) this.mData).isTroopMemberCard ? 12 : 3);
                return;
            } else {
                updateBtnGroupInner(11);
                return;
            }
        }
        updateBtnGroupInner(10);
    }

    private void updateTemplateRedTouch() {
        AppInterface appInterface;
        if (this.mTemplateCardRedTouch == null || (appInterface = this.mApp) == null) {
            return;
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) appInterface.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.format("%d%s%d", 100100, ".", Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_TEMPLATE_CARD)));
        this.mTemplateRedPointInfo = appInfoByPath;
        this.mTemplateCardRedTouch.parseRedTouch(appInfoByPath);
        iRedTouchManager.onReportRedPointExposure(this.mTemplateRedPointInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IProfileBottomContainer
    public void addFriend() {
        addFriendInner();
    }

    public void dtReport(View view) {
        VideoReport.reportEvent("clck", view, null);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 107;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleAddFriendClick() {
        addFriendInner();
        if (((ProfileCardInfo) this.mData).allInOne.profileEntryType == 119) {
            ReportController.o(this.mApp, "dc01160", "", "", "0X800A410", "0X800A410", 0, 0, "", "", "", "");
        }
        if (Utils.G(((ProfileCardInfo) this.mData).allInOne.uin)) {
            ReportController.o(this.mApp, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
        }
        ProfileCardReport.reportAddFriendClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleChatClick() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null) {
            QLog.i(TAG, 1, "[handleChatClick] start. allInOne:" + ((ProfileCardInfo) this.mData).allInOne);
            if (((ProfileCardInfo) this.mData).allInOne.profileEntryType == 126) {
                QBaseActivity qBaseActivity = this.mActivity;
                DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, qBaseActivity.getString(R.string.vzu), this.mActivity.getString(R.string.bbe), this.mActivity.getString(R.string.vzt), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        dialogInterface.dismiss();
                        BaseProfileBottomContainer.this.enterChatInner();
                        if (((ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData).isTroopMemberCard) {
                            new q(((AbsQQProfileContainer) BaseProfileBottomContainer.this).mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("msg_clk").b(((ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData).troopUin).g();
                        }
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        dialogInterface.dismiss();
                    }
                }).show();
            } else {
                enterChatInner();
                if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
                    new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("msg_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
                }
            }
            ProfileCardReport.reportChatClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
            return;
        }
        QLog.w(TAG, 1, "[handleChatClick] failed. data is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleEditClick() {
        DATA data = this.mData;
        if (((ProfileCardInfo) data).allInOne.f260789pa == 0) {
            ProfileCardUtils.openProfileEdit(this.mQQAppInterface, this.mActivity, (ProfileCardInfo) data);
            ReportController.o(this.mApp, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
            new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("edit_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
            ProfileCardReport.reportProfileEditClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleGivePresentClick() {
        String str;
        IConfigProxy iConfigProxy = VasLongToggle.PROFILECARD_SEND_GIFT;
        if (iConfigProxy.isEnable(false)) {
            String stringData = iConfigProxy.getStringData("");
            if (!TextUtils.isEmpty(stringData)) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(this.mActivity, stringData.replace("{from}", IndividuationUrlHelper.UrlId.CARD_HOME).replace("{friends}", ((ProfileCardInfo) this.mData).allInOne.uin));
                ProfileCardReport.reportGivePresentClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
                return;
            }
        }
        String config = QzoneConfig.getInstance().getConfig("H5Url", KEY_GIVE_GIFT_BUTTON_IN_PROFILE_URL, GIVE_BUTTON_URL);
        if (TextUtils.isEmpty(config)) {
            str = null;
        } else {
            str = config.replace("{to_uin}", ((ProfileCardInfo) this.mData).allInOne.uin + "_" + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(System.currentTimeMillis())));
        }
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.mActivity, str);
        } else {
            Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            this.mActivity.startActivity(intent);
        }
        ProfileCardReport.reportGivePresentClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
    }

    public void handleSaveContactClick() {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.e
            @Override // java.lang.Runnable
            public final void run() {
                BaseProfileBottomContainer.this.lambda$handleSaveContactClick$5();
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.1
            @Override // java.lang.Runnable
            public void run() {
                IPhoneContactService iPhoneContactService = (IPhoneContactService) ((AbsComponent) BaseProfileBottomContainer.this).mApp.getRuntimeService(IPhoneContactService.class, "");
                if (!iPhoneContactService.existContact(((ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData).allInOne.contactName, ((ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData).allInOne.uin)) {
                    if (iPhoneContactService.addContactAndUpload(((ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData).allInOne.contactName, ((ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData).allInOne.uin)) {
                        QQToast.makeText(((AbsComponent) BaseProfileBottomContainer.this).mActivity, 2, HardCodeUtil.qqStr(R.string.msq), 0).show();
                        return;
                    } else {
                        QQToast.makeText(((AbsComponent) BaseProfileBottomContainer.this).mActivity, 1, HardCodeUtil.qqStr(R.string.mtj), 0).show();
                        return;
                    }
                }
                QQToast.makeText(((AbsComponent) BaseProfileBottomContainer.this).mActivity, HardCodeUtil.qqStr(R.string.f172023msg), 0).show();
            }
        };
        DenyRunnable denyRunnable = new DenyRunnable(this.mActivity, new DenyRunnable.b() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.2
            @Override // com.tencent.mobileqq.activity.phone.DenyRunnable.b
            public void onCancel(Context context, boolean z16) {
                if (z16) {
                    QQToast.makeText(((AbsComponent) BaseProfileBottomContainer.this).mActivity, 1, HardCodeUtil.qqStr(R.string.msn), 0).show();
                    return;
                }
                Intent intent = new Intent(((AbsComponent) BaseProfileBottomContainer.this).mActivity, (Class<?>) GuideBindPhoneActivity.class);
                intent.putExtra("fromKeyForContactBind", 5);
                intent.putExtra("key_contact_name", ((ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData).allInOne.contactName);
                intent.putExtra("key_contact_phone", ((ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData).allInOne.uin);
                ((AbsComponent) BaseProfileBottomContainer.this).mActivity.startActivity(intent);
            }
        });
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("profile_save_contact_fix_139370641", true)) {
            PermissionChecker.e(this.mActivity, runnable, denyRunnable);
        } else {
            PermissionChecker.e(this.mActivity, runnable2, denyRunnable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initBottomBtns(LinearLayout linearLayout) {
        Resources resources = this.mActivity.getResources();
        linearLayout.removeAllViews();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158532i4);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f158532i4);
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).allInOne == null || ((ProfileCardInfo) data).allInOne.f260789pa == 33) {
            return;
        }
        if (((ProfileCardInfo) data).allInOne.f260789pa == 0 && !TextUtils.isEmpty(((ProfileCardInfo) data).allInOne.uin)) {
            View qUIButton = getQUIButton();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.mActivity.getResources().getDimensionPixelSize(R.dimen.d9p));
            layoutParams.weight = 1.0f;
            layoutParams.rightMargin = dimensionPixelSize2;
            linearLayout.addView(qUIButton, layoutParams);
            RedTouch applyTo = new RedTouch(this.mActivity, qUIButton).setRightMargin(30.0f).setTopMargin(30.0f).applyTo();
            this.mTemplateCardRedTouch = applyTo;
            if (applyTo != null) {
                updateTemplateRedTouch();
            }
            View qUIButton2 = getQUIButton();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, this.mActivity.getResources().getDimensionPixelSize(R.dimen.d9p));
            layoutParams2.weight = 1.0f;
            layoutParams2.rightMargin = dimensionPixelSize;
            linearLayout.addView(qUIButton2, layoutParams2);
            View qUIButton3 = getQUIButton();
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, this.mActivity.getResources().getDimensionPixelSize(R.dimen.d9p));
            layoutParams3.weight = 1.0f;
            layoutParams3.rightMargin = dimensionPixelSize;
            linearLayout.addView(qUIButton3, layoutParams3);
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 0) {
            View qUIButton4 = getQUIButton();
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, this.mActivity.getResources().getDimensionPixelSize(R.dimen.d9p));
            layoutParams4.weight = 1.0f;
            layoutParams4.rightMargin = dimensionPixelSize2;
            linearLayout.addView(qUIButton4, layoutParams4);
            View qUIButton5 = getQUIButton();
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, this.mActivity.getResources().getDimensionPixelSize(R.dimen.d9p));
            layoutParams5.weight = 1.0f;
            layoutParams5.rightMargin = dimensionPixelSize2;
            linearLayout.addView(qUIButton5, layoutParams5);
            View qUIButton6 = getQUIButton();
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, this.mActivity.getResources().getDimensionPixelSize(R.dimen.d9p));
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = dimensionPixelSize2;
            linearLayout.addView(qUIButton6, layoutParams6);
        }
    }

    public abstract void initDtReport(LinearLayout linearLayout);

    public void initElement(View view, String str) {
        ProfileCardDtReportUtil.initElementWithExposure(view, str);
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsQQProfileContainer, com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mIsFromArkBabyQ = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_ARK_BABYQ, false);
        }
        initViews();
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        Dialog dialog = this.addFriendDialog;
        if (dialog != null && dialog.isShowing()) {
            this.addFriendDialog.dismiss();
            this.addFriendDialog = null;
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        super.onResume();
        updateTemplateRedTouch();
        this.isCheckBlacklist = false;
        this.isBlacklistCache = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateBtnGroupInner(int i3) {
        boolean z16;
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return;
        }
        TroopManager troopManager = (TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        DATA data = this.mData;
        boolean z17 = true;
        if (((ProfileCardInfo) data).isTroopMemberCard && troopManager.V(((ProfileCardInfo) data).troopUin)) {
            TroopInfo B = troopManager.B(((ProfileCardInfo) this.mData).troopUin);
            ProfileTroopMemInfoComponent profileTroopMemInfoComponent = (ProfileTroopMemInfoComponent) this.mComponentCenter.getComponent(1013);
            if (profileTroopMemInfoComponent != null) {
                profileTroopMemInfoComponent.checkAndUpdateTroopInfo(B);
            }
            if (B.isTroopAdmin(((ProfileCardInfo) this.mData).allInOne.uin) || B.isTroopOwner(((ProfileCardInfo) this.mData).allInOne.uin)) {
                z16 = true;
            } else {
                z16 = false;
                z17 = false;
            }
        } else {
            z16 = false;
        }
        resetAllBtnGone();
        handleUpdateBtnGroupInner1(i3, z17, z16);
        handleUpdateBtnGroupInner2(i3, z17, z16);
        handleUpdateBtnGroupInner3(i3, z17, z16);
        if (i3 == 0 || !isNeedHandleUpdateBtnGroupInnerDefault(i3)) {
            z17 = false;
        }
        ((FrameLayout) this.mViewContainer).setVisibility(z17 ? 0 : 8);
        this.mBtnsContainer.setVisibility(z17 ? 0 : 8);
    }

    public static void addFriend(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, Dialog dialog) {
        String str;
        Bundle bundleExtra = qBaseActivity.getIntent().getBundleExtra(IProfileCardConst.KEY_PROFILE_EXTRA);
        boolean z16 = false;
        if (bundleExtra != null && bundleExtra.getBoolean(AppConstants.Key.KEY_FROM_BABYQ, false)) {
            z16 = true;
        }
        SourceParam sourceParam = new SourceParam();
        setSourceParamValue(profileCardInfo, sourceParam, z16, bundleExtra);
        int i3 = sourceParam.sourceId;
        int i16 = sourceParam.subSourceId;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "addFriend, end, sourceParam == " + sourceParam);
        }
        if (i3 == 3045) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(i16), "", "", "");
        }
        if (i3 == 3094) {
            ReportController.r(qQAppInterface, "dc00898", "", profileCardInfo.allInOne.uin, "0X80092E2", "0X80092E2", 0, 0, String.valueOf(i16), ExtendFriendReport.c(), ExtendFriendReport.g(qQAppInterface), ExtendFriendReport.d());
        }
        if (addFriendSourceFromNearby(qQAppInterface, qBaseActivity, profileCardInfo, dialog, i3)) {
            return;
        }
        if (profileCardInfo.card != null) {
            Context applicationContext = qQAppInterface.getApplicationContext();
            Card card = profileCardInfo.card;
            str = ProfileCardUtil.Z(applicationContext, card.shGender, card.age, card.strCountry, card.strProvince, card.strCity);
        } else {
            str = "";
        }
        String str2 = str;
        int i17 = profileCardInfo.allInOne.f260789pa;
        if (i17 != 32 && i17 != 31 && i17 != 51 && i17 != 50 && i17 != 34 && i17 != 36 && i17 != 53 && i17 != 29) {
            jumpLaunchAddFriendWithCardInfoAndTroop(qBaseActivity, profileCardInfo, z16, i3, i16, str2);
        } else {
            jumpLaunchAddFriendWithCardInfo(qBaseActivity, profileCardInfo, i3, i16, str2);
        }
    }

    private void updateBtn(View view, int i3, String str, int i16, String str2, int i17) {
        if (view != null) {
            view.setVisibility(0);
            QUIButton qUIButton = null;
            com.tencent.mobileqq.profile.b bVar = new com.tencent.mobileqq.profile.b(i3, null);
            if (view instanceof QUIButton) {
                qUIButton = (QUIButton) view;
            } else if (view instanceof RedTouch) {
                qUIButton = (QUIButton) ((RedTouch) view).getTarget();
            }
            if (qUIButton == null) {
                return;
            }
            qUIButton.setTag(bVar);
            qUIButton.setOnClickListener(this);
            qUIButton.setContentDescription(str2);
            qUIButton.setText(str);
            qUIButton.setSingleLine();
            qUIButton.setEllipsize(TextUtils.TruncateAt.END);
            qUIButton.setType(i16 != 2 ? 1 : 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleFreeCallClick() {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = ProfileCardUtil.p(((ProfileCardInfo) this.mData).allInOne);
        DATA data = this.mData;
        sessionInfo.f179557e = ((ProfileCardInfo) data).allInOne.uin;
        sessionInfo.f179563i = getCallNickName((ProfileCardInfo) data, this.mQQAppInterface);
        sessionInfo.f179559f = ((ProfileCardInfo) this.mData).allInOne.troopUin;
        bc n06 = bc.n0(this.mActivity);
        n06.addButton(R.string.i3u);
        n06.addButton(R.string.i4e);
        PlusPanelUtils.y(sessionInfo);
        n06.addCancelButton(R.string.cancel);
        n06.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.7
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public void onDismiss() {
                ReportController.o(((AbsComponent) BaseProfileBottomContainer.this).mApp, "CliOper", "", "", "0X8008406", "0X8008406", 0, 0, "", "", "", "");
            }
        });
        n06.setOnButtonClickListener(new AnonymousClass8(new int[]{1, 2, 3}, n06, sessionInfo));
        n06.show();
        ProfileCardReport.reportVideoCallClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((BaseProfileBottomContainer) profileCardInfo);
        updateBtnGroup(profileCardInfo.isNetRet);
        if (!this.isInit) {
            this.isInit = true;
            initDtReport(this.mBtnsContainer);
        }
        boolean isForbidBySpecifyTypes = ProfileCardForbidAccountHelper.isForbidBySpecifyTypes(new ArrayList(Collections.singletonList(201)), profileCardInfo.card);
        this.isForbidAccount = isForbidBySpecifyTypes;
        ProfileCardForbidAccountHelper.updateViewGroupEnableState(this.mBtnsContainer, !isForbidBySpecifyTypes);
        return lambda$checkValidComponent$3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void enterAudioCall(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        String str;
        String mobileNumberWithNationCode;
        String str2;
        ContactCard contactCard;
        String str3;
        String str4;
        int p16 = ProfileCardUtil.p(profileCardInfo.allInOne);
        String callNickName = getCallNickName(profileCardInfo, qQAppInterface);
        if (ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
            str2 = profileCardInfo.allInOne.uin;
            mobileNumberWithNationCode = null;
        } else {
            if (profileCardInfo.allInOne.f260789pa != 53 || (contactCard = profileCardInfo.contactCard) == null || TextUtils.isEmpty(contactCard.uin)) {
                str = null;
            } else {
                str = profileCardInfo.contactCard.uin;
                p16 = 0;
            }
            mobileNumberWithNationCode = ProfileUtils.getMobileNumberWithNationCode(profileCardInfo.allInOne);
            str2 = str;
        }
        if (p16 == 1000) {
            str4 = profileCardInfo.allInOne.troopUin;
        } else if (p16 == 1004) {
            str4 = profileCardInfo.allInOne.discussUin;
        } else {
            str3 = null;
            if (qQAppInterface.getAVNotifyCenter().g(qBaseActivity, 1, p16, str2)) {
                HashMap hashMap = new HashMap();
                hashMap.put("should_believe_only_audio_flag", "true");
                hashMap.put("start_double_rtc_talk_from_source", "3");
                ChatActivityUtils.j0(qQAppInterface, qBaseActivity, p16, str2, callNickName, mobileNumberWithNationCode, true, str3, true, true, null, "from_internal", hashMap);
                return;
            }
            return;
        }
        str3 = str4;
        if (qQAppInterface.getAVNotifyCenter().g(qBaseActivity, 1, p16, str2)) {
        }
    }

    private static boolean isPadSplitMode(QBaseActivity qBaseActivity) {
        return qBaseActivity != null && AppSetting.t(qBaseActivity);
    }

    private static void setSourceParamValue(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16, Bundle bundle) {
        AllInOne allInOne;
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null) {
            int i3 = allInOne.extras.getInt(IProfileCardConst.PARAM_ADD_FRIEND_ID, -1);
            int i16 = profileCardInfo.allInOne.extras.getInt(IProfileCardConst.PARAM_ADD_FRIEND_SUB_ID, -1);
            if (i3 >= 0 && i16 >= 0) {
                sourceParam.sourceId = i3;
                sourceParam.subSourceId = i16;
                return;
            }
        }
        setSourceParamValue1(profileCardInfo, sourceParam, z16);
        setSourceParamValue2(profileCardInfo, sourceParam, z16);
        setSourceParamValue3(profileCardInfo, sourceParam, z16);
        setSourceParamValue4(profileCardInfo, sourceParam, z16);
        setSourceParamValue5(profileCardInfo, sourceParam, z16);
        setSourceParamValue6(profileCardInfo, sourceParam, z16, bundle);
        setSourceParamValue7(profileCardInfo, sourceParam, z16);
        setSourceParamValue8(profileCardInfo, sourceParam, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleAgreeToAddFriendClick() {
        if (!NetworkUtil.isNetSupport(this.mActivity)) {
            QQToastUtil.showQQToast(R.string.f171137ci2);
            return;
        }
        structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey()));
        if (structMsgFromMap != null) {
            int i3 = structMsgFromMap.msg_type.get();
            long j3 = structMsgFromMap.msg_seq.get();
            long j16 = structMsgFromMap.req_uin.get();
            int i16 = structMsgFromMap.f436065msg.sub_type.get();
            int i17 = structMsgFromMap.f436065msg.src_id.get();
            int i18 = structMsgFromMap.f436065msg.sub_src_id.get();
            int i19 = structMsgFromMap.f436065msg.group_msg_type.get();
            List<structmsg$SystemMsgAction> list = structMsgFromMap.f436065msg.actions.get();
            if (list != null && list.size() > 0) {
                structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo = list.get(0).action_info.get();
                structmsg_systemmsgactioninfo.remark.set("");
                structmsg_systemmsgactioninfo.group_id.set(0);
                structmsg$AddFrdSNInfo structmsg_addfrdsninfo = new structmsg$AddFrdSNInfo();
                structmsg_addfrdsninfo.uint32_not_see_dynamic.set(0);
                structmsg_addfrdsninfo.uint32_set_sn.set(0);
                structmsg_systemmsgactioninfo.addFrdSNInfo.set(structmsg_addfrdsninfo);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (!(peekAppRuntime instanceof QQAppInterface)) {
                    QLog.e(TAG, 1, "agree fail, runtime is not QQAppInterface");
                    return;
                } else {
                    ((QQAppInterface) peekAppRuntime).getMsgHandler().m3().r0(i3, j3, j16, i16, i17, i18, i19, structmsg_systemmsgactioninfo, 0, structMsgFromMap, false);
                    return;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("agree, ");
            sb5.append(list != null ? list.size() : -1);
            QLog.d(TAG, 1, sb5.toString());
            return;
        }
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(((ProfileCardInfo) this.mData).allInOne.uin, TAG)) {
            ((FriendListHandler) this.mApp.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).agreeSuspiciousMsg(Long.valueOf(((ProfileCardInfo) this.mData).allInOne.uin).longValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleTroopSendGiftClick() {
        int i3;
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        DATA data = this.mData;
        String s16 = ac.s(qQAppInterface, ((ProfileCardInfo) data).card.uin, ((ProfileCardInfo) data).troopUin, 1, 0);
        HashMap hashMap = new HashMap();
        hashMap.put(LaunchParam.KEY_REF_ID, "biz_src_hdsp_liwu");
        if (isCanOpenGiftPanelUseRepo() && ((ProfileCardInfo) this.mData).isTroopMemberCard) {
            Intent intent = new Intent();
            intent.putExtra("aio_troop_uin", ((ProfileCardInfo) this.mData).troopUin);
            intent.putExtra("member_uin", ((ProfileCardInfo) this.mData).card.uin);
            intent.putExtra("member_display_name", ((ProfileCardInfo) this.mData).card.strNick);
            ee.INSTANCE.e(this.mActivity, ((ProfileCardInfo) this.mData).troopUin, intent, NTPanelEntrance.TROOP_PROFILE_CARD);
        } else {
            QBaseActivity qBaseActivity = this.mActivity;
            DATA data2 = this.mData;
            am.u(qBaseActivity, ((ProfileCardInfo) data2).troopUin, ((ProfileCardInfo) data2).card.uin, s16, "profilecard", this.mQQAppInterface, hashMap);
        }
        ProfileCardReport.reportTroopProfileCardGivePresentClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
        TroopInfo k3 = ((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin);
        if (k3 != null) {
            if (k3.isTroopOwner(this.mApp.getCurrentAccountUin())) {
                i3 = 0;
            } else {
                i3 = k3.isOwnerOrAdmin() ? 1 : 2;
            }
            ReportController.o(this.mApp, "P_CliOper", "Grp_flower", "", "mber_data", "Clk_send", 0, 0, ((ProfileCardInfo) this.mData).troopUin, i3 + "", "", "");
            AppInterface appInterface = this.mApp;
            DATA data3 = this.mData;
            ReportController.o(appInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, ((ProfileCardInfo) data3).troopUin, "4", com.tencent.mobileqq.profile.l.b(com.tencent.mobileqq.profile.l.a(k3, ((ProfileCardInfo) data3).card.uin)), "");
            new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("flower_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
        }
    }

    /* renamed from: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer$8, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass8 implements ActionSheet.OnButtonClickListener {
        final /* synthetic */ SessionInfo val$sessionInfo;
        final /* synthetic */ int[] val$showItems;
        final /* synthetic */ bc val$videoActionSheet;

        AnonymousClass8(int[] iArr, bc bcVar, SessionInfo sessionInfo) {
            this.val$showItems = iArr;
            this.val$videoActionSheet = bcVar;
            this.val$sessionInfo = sessionInfo;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            int i16 = this.val$showItems[i3];
            if (QLog.isColorLevel()) {
                QLog.d(BaseProfileBottomContainer.TAG, 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.val$showItems) + ",which = " + i3 + ",item = " + i16);
            }
            this.val$videoActionSheet.dismiss();
            if (i16 == 1) {
                if (((AbsComponent) BaseProfileBottomContainer.this).mActivity != null && !((AbsComponent) BaseProfileBottomContainer.this).mActivity.isFinishing()) {
                    BaseProfileBottomContainer.enterAudioCall(((AbsQQProfileContainer) BaseProfileBottomContainer.this).mQQAppInterface, ((AbsComponent) BaseProfileBottomContainer.this).mActivity, (ProfileCardInfo) ((AbsComponent) BaseProfileBottomContainer.this).mData);
                }
                ReportController.o(((AbsComponent) BaseProfileBottomContainer.this).mApp, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
                return;
            }
            if (i16 == 2) {
                HashMap hashMap = new HashMap();
                hashMap.put("start_double_rtc_talk_from_source", "3");
                PlusPanelUtils.h(((AbsQQProfileContainer) BaseProfileBottomContainer.this).mQQAppInterface, ((AbsComponent) BaseProfileBottomContainer.this).mActivity, this.val$sessionInfo, false, null, hashMap);
                ReportController.o(((AbsComponent) BaseProfileBottomContainer.this).mApp, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
                return;
            }
            if (i16 != 3) {
                return;
            }
            final HashMap hashMap2 = new HashMap();
            hashMap2.put("inviteScene", "2");
            ReportController.o(((AbsComponent) BaseProfileBottomContainer.this).mApp, "dc00898", "", "", "0X800C433", "0X800C433", 0, 0, "2", "", "", "");
            if (AVAvatarResMgr.v().k()) {
                ReportController.o(((AbsComponent) BaseProfileBottomContainer.this).mApp, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, "1", "", "", "");
                PlusPanelUtils.h(((AbsQQProfileContainer) BaseProfileBottomContainer.this).mQQAppInterface, ((AbsComponent) BaseProfileBottomContainer.this).mActivity, this.val$sessionInfo, true, null, hashMap2);
            } else {
                AVAvatarResMgr.v().F(new AVAvatarResMgr.c() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.8.1
                    @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.c
                    public void onRequestFinish(final boolean z16) {
                        QLog.i(BaseProfileBottomContainer.TAG, 1, "requestCDNServerUseState.onRequestFinish. isCDNOverload: " + z16);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.8.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z16) {
                                    QQToast.makeText(((AbsComponent) BaseProfileBottomContainer.this).mActivity, R.string.f1786837b, 0).show();
                                    return;
                                }
                                ReportController.o(((AbsComponent) BaseProfileBottomContainer.this).mApp, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, "1", "", "", "");
                                QQAppInterface qQAppInterface = ((AbsQQProfileContainer) BaseProfileBottomContainer.this).mQQAppInterface;
                                QBaseActivity qBaseActivity = ((AbsComponent) BaseProfileBottomContainer.this).mActivity;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                PlusPanelUtils.h(qQAppInterface, qBaseActivity, AnonymousClass8.this.val$sessionInfo, true, null, hashMap2);
                            }
                        });
                    }
                }, 3000);
            }
        }
    }

    private static void jumpLaunchAddFriendWithCardInfo(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, int i3, int i16, String str) {
        String str2;
        ProfileContactInfo cardContactInfo = ProfileUtils.getCardContactInfo(profileCardInfo.allInOne);
        if (cardContactInfo == null || (str2 = cardContactInfo.phoneNumber) == null || str2.length() <= 0) {
            return;
        }
        String str3 = cardContactInfo.phoneNationalCode + cardContactInfo.phoneNumber;
        String str4 = cardContactInfo.phoneName;
        if (TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(profileCardInfo.nameArray[3])) {
                str4 = profileCardInfo.nameArray[3];
            } else if (!TextUtils.isEmpty(profileCardInfo.nameArray[0])) {
                str4 = profileCardInfo.nameArray[0];
            } else if (!TextUtils.isEmpty(profileCardInfo.profileName.f305805a.f305804b)) {
                str4 = profileCardInfo.profileName.f305805a.f305804b;
            }
        }
        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(qBaseActivity, 2, str3, null, i3, i16, str4, null, ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass().getName(), qBaseActivity.getString(R.string.button_back), null);
        startAddFriend.putExtra("param_return_profilecard_pa", profileCardInfo.allInOne.f260789pa);
        startAddFriend.putExtra("key_param_age_area", str);
        ProfileActivity.K2(qBaseActivity, startAddFriend, profileCardInfo);
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(qBaseActivity, startAddFriend);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleTemplateClickForDiy(View view, com.tencent.mobileqq.profile.b bVar) {
        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E3B", 2, 0, "", "", "", "");
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        handleTemplateClick(view, bVar);
    }

    private static boolean addFriendSourceFromNearby(final QQAppInterface qQAppInterface, final QBaseActivity qBaseActivity, final ProfileCardInfo profileCardInfo, Dialog dialog, int i3) {
        if (i3 != 3007 || LBSHandler.D2(qQAppInterface, profileCardInfo.allInOne.uin)) {
            return false;
        }
        if (dialog == null) {
            dialog = LBSHandler.N2(qBaseActivity, qBaseActivity.getString(R.string.cgk), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    BaseProfileBottomContainer.enterChat(QQAppInterface.this, qBaseActivity, profileCardInfo);
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            });
        }
        if (dialog.isShowing() || qBaseActivity.isFinishing()) {
            return true;
        }
        dialog.show();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleUpdateBtnGroupInner1(int i3, boolean z16, boolean z17) {
        if (i3 != 1) {
            return;
        }
        DATA data = this.mData;
        if (((ProfileCardInfo) data).isTroopMemberCard) {
            if (((ProfileCardInfo) data).allInOne.f260789pa == 0) {
                updateBtn(this.mBtnsContainer.getChildAt(0), 23, R.string.f171194d20, 1, R.string.f170793ac4);
            }
        } else {
            String stringDataSet = VasToggle.VIP_PERSONAL_CARD_CONFIG.getStringDataSet("personal_card_button", this.mActivity.getString(R.string.f171194d20));
            updateBtn(this.mBtnsContainer.getChildAt(0), 23, stringDataSet, 1, stringDataSet, 0);
        }
        updateBtn(this.mBtnsContainer.getChildAt(1), 81, R.string.buf, 1, R.string.aav);
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.mApp.getCurrentUin()), TAG);
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0 && !isFriend) {
            updateBtn(this.mBtnsContainer.getChildAt(2), 7, R.string.btk, 2, R.string.aai);
        } else {
            updateBtn(this.mBtnsContainer.getChildAt(2), 8, R.string.heh, 2, R.string.acj);
        }
    }

    private static void ntPrepareContactStrangerTempChat(int i3, String str, String str2) {
        if (i3 != 1006) {
            return;
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QLog.d(TAG, 1, "ntPrepareContactStrangerTempChat appInterface is null");
        } else if (((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getMsgService() == null) {
            QLog.d(TAG, 1, "ntPrepareContactStrangerTempChat  msgService is null");
        } else {
            ((IRelationAIOService) QRoute.api(IRelationAIOService.class)).ntPrepareContactStrangerTempChat(appInterface, str, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleUpdateBtnGroupInner3(int i3, boolean z16, boolean z17) {
        switch (i3) {
            case 8:
                updateBtn(this.mBtnsContainer.getChildAt(0), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
                return;
            case 9:
            default:
                return;
            case 10:
                updateBtn(this.mBtnsContainer.getChildAt(0), 59, R.string.bvw, 1, R.string.bvw);
                return;
            case 11:
                updateBtn(this.mBtnsContainer.getChildAt(0), 59, R.string.bvw, 1, R.string.bvw);
                updateBtn(this.mBtnsContainer.getChildAt(2), 7, R.string.btk, 2, R.string.aai);
                return;
            case 12:
                if (ProfilePAUtils.isPaTypeCanAddAsFriend(((ProfileCardInfo) this.mData).allInOne)) {
                    updateBtn(this.mBtnsContainer.getChildAt(0), 7, R.string.btk, 1, R.string.aai);
                } else {
                    updateBtn(this.mBtnsContainer.getChildAt(0), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
                }
                if (!z17 && !StudyModeManager.t()) {
                    updateBtn(this.mBtnsContainer.getChildAt(1), 77, R.string.fgn, 1, R.string.fgn);
                }
                updateBtn(this.mBtnsContainer.getChildAt(2), 8, R.string.heh, 2, R.string.acj);
                return;
            case 13:
                updateBtn(this.mBtnsContainer.getChildAt(2), 115, R.string.igg, 2, R.string.igg);
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleTemplateClick(View view, com.tencent.mobileqq.profile.b bVar) {
        String str;
        View findViewById = view.findViewById(R.id.khb);
        Object parent = view.getParent();
        if (parent instanceof View) {
            findViewById = ((View) parent).findViewById(R.id.khb);
        }
        if (findViewById != null) {
            r1 = findViewById.getVisibility() == 0 ? 0 : 1;
            findViewById.setVisibility(8);
        }
        int i3 = r1;
        reportRedPointClicked();
        if (bVar.f260135a == 92) {
            str = "profileType=custom";
        } else {
            str = "";
        }
        ProfileCardUtil.F(this.mActivity, this.mApp.getCurrentAccountUin(), "inside.myCardButton", i3, 3, 1, str, true, 41);
        ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X8006681", 0, 0, "", "", "", "");
        ReportController.o(this.mApp, "dc00898", "", "", "0X8007EB5", "0X8007EB5", 0, 0, "", "", "", "");
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        DATA data = this.mData;
        if (((ProfileCardInfo) data).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC || ((ProfileCardInfo) data).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) {
            VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkcard_owner", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo) this.mData).card.lCurrentBgId), String.valueOf(((ProfileCardInfo) this.mData).card.lCurrentStyleId));
        }
        ProfileCardReport.reportTemplateClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
    }

    private void handleUpdateBtnGroupInner2(int i3, boolean z16, boolean z17) {
        switch (i3) {
            case 2:
                updateBtn(this.mBtnsContainer.getChildAt(0), 7, R.string.btk, 1, R.string.aai);
                updateBtn(this.mBtnsContainer.getChildAt(1), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
                updateBtn(this.mBtnsContainer.getChildAt(2), 8, R.string.heh, 2, R.string.acj);
                return;
            case 3:
                updateBtn(this.mBtnsContainer.getChildAt(0), 7, R.string.btk, 1, R.string.aai);
                updateBtn(this.mBtnsContainer.getChildAt(2), 8, R.string.heh, 2, R.string.acj);
                return;
            case 4:
                updateBtn(this.mBtnsContainer.getChildAt(0), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
                if (!z17 && !StudyModeManager.t()) {
                    updateBtn(this.mBtnsContainer.getChildAt(1), 95, R.string.fgn, 1, R.string.fgn);
                    ReportController.o(this.mApp, "", "", "", "0X800A1C4", "0X800A1C4", 0, 0, "", "", "", "");
                }
                updateBtn(this.mBtnsContainer.getChildAt(2), 8, R.string.heh, 2, R.string.acj);
                return;
            case 5:
                updateBtn(this.mBtnsContainer.getChildAt(0), 7, R.string.btk, 1, R.string.aai);
                updateBtn(this.mBtnsContainer.getChildAt(1), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording(), 0);
                return;
            case 6:
                updateBtn(this.mBtnsContainer.getChildAt(2), 7, R.string.btk, 2, R.string.aai);
                return;
            case 7:
                updateBtn(this.mBtnsContainer.getChildAt(2), 8, R.string.heh, 2, R.string.acj);
                return;
            default:
                return;
        }
    }

    private static void enterChat(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, String str, int i3) {
        Intent intent = new Intent();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("profile_open_aio_force_chat_activity", true)) {
            intent.setComponent(new ComponentName(qBaseActivity, (Class<?>) ChatActivity.class));
        } else {
            intent = l.w(qBaseActivity, ChatActivity.class.getName());
        }
        BaseAIOUtils.m(intent, null);
        intent.putExtra("PREVIOUS_WINDOW", ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass().getName());
        intent.putExtra("PREVIOUS_UIN", profileCardInfo.allInOne.uin);
        if (qBaseActivity.getIntent().getExtras() != null) {
            intent.putExtra(AppConstants.Key.CSPECIAL_FLAG, qBaseActivity.getIntent().getExtras().getInt(AppConstants.Key.CSPECIAL_FLAG));
        }
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra("aio_msg_source", 3);
        int i16 = profileCardInfo.allInOne.chatEntrance;
        if (i16 != 0) {
            intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, i16);
        }
        String callNickName = getCallNickName(profileCardInfo, qQAppInterface);
        intent.putExtra("uinname", callNickName == null ? "" : callNickName);
        ntPrepareContactStrangerTempChat(i3, callNickName != null ? callNickName : "", str);
        if (!TextUtils.isEmpty(profileCardInfo.allInOne.troopUin)) {
            intent.putExtra("troop_uin", profileCardInfo.allInOne.troopUin);
        } else if (!TextUtils.isEmpty(profileCardInfo.allInOne.discussUin)) {
            intent.putExtra("troop_uin", profileCardInfo.allInOne.discussUin);
        }
        if (!TextUtils.isEmpty(profileCardInfo.allInOne.troopCode)) {
            intent.putExtra(AppConstants.Key.TROOP_CODE, profileCardInfo.allInOne.troopCode);
        }
        if (i3 == 1009) {
            intent.putExtra(AppConstants.Key.KYE_RICH_STATUS_SIG, profileCardInfo.allInOne.chatCookie);
        }
        if (i3 == 1001) {
            intent.putExtra(AppConstants.Key.KYE_RICH_ACCOST_SIG, profileCardInfo.allInOne.chatCookie);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", Utils.U(profileCardInfo.allInOne.uin), Utils.U(callNickName), Utils.e(profileCardInfo.allInOne.chatCookie)));
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(profileCardInfo.allInOne.uin), TAG);
        if (friendsSimpleInfoWithUid != null && (CrmUtils.s(friendsSimpleInfoWithUid.e().byteValue()) || QidianManager.O(friendsSimpleInfoWithUid.e().byteValue()))) {
            intent.putExtra("chat_subType", 1);
        }
        intent.putExtra("hidden_aio_msg_source", 2);
        ProfileCardUtils.enterNTAio(qBaseActivity, intent, str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
