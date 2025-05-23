package com.tencent.mobileqq.profilecard.base.container;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.tencent.mobileqq.activity.SplashActivity;
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
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardBubbleUtil;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qqexpand.profilecard.IExpandProfileComponentUtils;
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
import com.tencent.mobileqq.troopgift.GiftPanelControllerWithGiftRepo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqnt.aio.helper.ee;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.tbs.reader.ITbsReader;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes16.dex */
public class ProfileBottomContainer extends AbsQQProfileContainer implements IProfileBottomContainer, View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final int BTNS_STYLE_ADD = 6;
    private static final int BTNS_STYLE_ADD_CALL = 5;
    private static final int BTNS_STYLE_ADD_CHAT = 3;
    private static final int BTNS_STYLE_ADD_CHAT_CALL = 2;
    private static final int BTNS_STYLE_CALL = 8;
    private static final int BTNS_STYLE_CHAT = 7;
    private static final int BTNS_STYLE_CHAT_CALL = 4;
    private static final int BTNS_STYLE_EDIT = 1;
    private static final int BTNS_STYLE_NONE = 0;
    private static final int BTNS_STYLE_SAVE = 10;
    private static final int BTNS_STYLE_SAVE_ADD = 11;
    private static final int BTNS_STYLE_TROOP_MEM_SEND_GIFT = 12;
    private static final int BTN_INDEX_BLUE_ONE = 4;
    private static final int BTN_INDEX_EDIT = 1;
    private static final int BTN_INDEX_ICON = 0;
    private static final int BTN_INDEX_SEND_OR_ADD = 2;
    private static final int BTN_INDEX_VIP_CARD = 0;
    private static final int BTN_INDEX_WHITE_ONE = 1;
    private static final int BTN_INDEX_WHITE_THREE = 3;
    private static final int BTN_INDEX_WHITE_TWO = 2;
    private static final int BTN_STYLE_BLUE = 2;
    private static final int BTN_STYLE_WHITE = 1;
    private static final int CLICK_INTERVAL = 800;
    private static final String DTREPORT_KEY_PROFILE_ADD = "em_profile_addfriend";
    private static final String DTREPORT_KEY_PROFILE_MSG = "em_profile_send";
    private static final String GIVE_BUTTON_URL = "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}";
    private static final int[] HANDLE_UPDATE_BTN_GROUP_INNER_TYPE;
    private static final String KEY_GIVE_GIFT_BUTTON_IN_PROFILE_URL = "give_gift_button_in_profile_url";
    private static final String TAG = "ProfileBottomContainer";
    private Dialog addFriendDialog;
    private boolean isBlacklistCache;
    private boolean isCheckBlacklist;
    private boolean isInit;
    private long lastClickTime;
    private LinearLayout mBtnsContainer;
    private boolean mIsFromArkBabyQ;
    private RedTouch mTemplateCardRedTouch;
    private BusinessInfoCheckUpdate.AppInfo mTemplateRedPointInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer$8, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass8 implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ SessionInfo val$sessionInfo;
        final /* synthetic */ int[] val$showItems;
        final /* synthetic */ bc val$videoActionSheet;

        AnonymousClass8(int[] iArr, bc bcVar, SessionInfo sessionInfo) {
            this.val$showItems = iArr;
            this.val$videoActionSheet = bcVar;
            this.val$sessionInfo = sessionInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileBottomContainer.this, iArr, bcVar, sessionInfo);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            int i16 = this.val$showItems[i3];
            if (QLog.isColorLevel()) {
                QLog.d(ProfileBottomContainer.TAG, 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.val$showItems) + ",which = " + i3 + ",item = " + i16);
            }
            this.val$videoActionSheet.dismiss();
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("inviteScene", "2");
                        ReportController.o(((AbsComponent) ProfileBottomContainer.this).mApp, "dc00898", "", "", "0X800C433", "0X800C433", 0, 0, "2", "", "", "");
                        if (AVAvatarResMgr.v().k()) {
                            ReportController.o(((AbsComponent) ProfileBottomContainer.this).mApp, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, "1", "", "", "");
                            ProfileBottomContainer profileBottomContainer = ProfileBottomContainer.this;
                            PlusPanelUtils.h(profileBottomContainer.mQQAppInterface, ((AbsComponent) profileBottomContainer).mActivity, this.val$sessionInfo, true, null, hashMap);
                            return;
                        }
                        AVAvatarResMgr.v().F(new AVAvatarResMgr.c(hashMap) { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.8.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Map val$extraInfo;

                            {
                                this.val$extraInfo = hashMap;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, (Object) hashMap);
                                }
                            }

                            @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.c
                            public void onRequestFinish(boolean z16) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                                    return;
                                }
                                QLog.i(ProfileBottomContainer.TAG, 1, "requestCDNServerUseState.onRequestFinish. isCDNOverload: " + z16);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable(z16) { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.8.1.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ boolean val$isCDNOverload;

                                    {
                                        this.val$isCDNOverload = z16;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z16));
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        if (this.val$isCDNOverload) {
                                            QQToast.makeText(((AbsComponent) ProfileBottomContainer.this).mActivity, R.string.f1786837b, 0).show();
                                            return;
                                        }
                                        ReportController.o(((AbsComponent) ProfileBottomContainer.this).mApp, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, "1", "", "", "");
                                        ProfileBottomContainer profileBottomContainer2 = ProfileBottomContainer.this;
                                        QQAppInterface qQAppInterface = profileBottomContainer2.mQQAppInterface;
                                        QBaseActivity qBaseActivity = ((AbsComponent) profileBottomContainer2).mActivity;
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        PlusPanelUtils.h(qQAppInterface, qBaseActivity, AnonymousClass8.this.val$sessionInfo, true, null, anonymousClass1.val$extraInfo);
                                    }
                                });
                            }
                        }, 3000);
                        return;
                    }
                    return;
                }
                if (((AbsComponent) ProfileBottomContainer.this).mActivity != null && !((AbsComponent) ProfileBottomContainer.this).mActivity.isFinishing()) {
                    ProfileBottomContainer profileBottomContainer2 = ProfileBottomContainer.this;
                    PlusPanelUtils.h(profileBottomContainer2.mQQAppInterface, ((AbsComponent) profileBottomContainer2).mActivity, this.val$sessionInfo, false, null, null);
                }
                ReportController.o(((AbsComponent) ProfileBottomContainer.this).mApp, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
                return;
            }
            ProfileBottomContainer profileBottomContainer3 = ProfileBottomContainer.this;
            ProfileBottomContainer.enterAudioCall(profileBottomContainer3.mQQAppInterface, ((AbsComponent) profileBottomContainer3).mActivity, (ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData, true);
            ReportController.o(((AbsComponent) ProfileBottomContainer.this).mApp, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
        }
    }

    /* loaded from: classes16.dex */
    public static class SourceParam {
        static IPatchRedirector $redirector_;
        int sourceId;
        int subSourceId;

        public SourceParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.sourceId = BuddySource.DEFAULT;
                this.subSourceId = 0;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "SourceParam{sourceId=" + this.sourceId + ", subSourceId=" + this.subSourceId + '}';
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73968);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            HANDLE_UPDATE_BTN_GROUP_INNER_TYPE = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12};
        }
    }

    public ProfileBottomContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.isInit = false;
        this.isCheckBlacklist = false;
        this.isBlacklistCache = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addFriendInner() {
        boolean z16;
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 96) {
            z16 = ((IExpandProfileComponentUtils) QRoute.api(IExpandProfileComponentUtils.class)).interceptAddFriend(this.mComponentCenter, (ProfileCardInfo) this.mData);
        } else {
            z16 = false;
        }
        if (!z16) {
            addFriend(this.mQQAppInterface, this.mActivity, (ProfileCardInfo) this.mData, this.addFriendDialog);
        }
    }

    private static boolean addFriendSourceFromNearby(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, Dialog dialog, int i3) {
        if (i3 == 3007 && !LBSHandler.D2(qQAppInterface, profileCardInfo.allInOne.uin)) {
            if (dialog == null) {
                dialog = LBSHandler.N2(qBaseActivity, qBaseActivity.getString(R.string.cgk), new DialogInterface.OnClickListener(qBaseActivity, profileCardInfo) { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.9
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ QBaseActivity val$activity;
                    final /* synthetic */ ProfileCardInfo val$cardInfo;

                    {
                        this.val$activity = qBaseActivity;
                        this.val$cardInfo = profileCardInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, qBaseActivity, profileCardInfo);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                            return;
                        }
                        ProfileBottomContainer.enterChat(QQAppInterface.this, this.val$activity, this.val$cardInfo);
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.10
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                        } else if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                    }
                });
            }
            if (!dialog.isShowing() && !qBaseActivity.isFinishing()) {
                dialog.show();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean checkBlacklistForbid(final boolean z16, final boolean z17, final boolean z18) {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null) {
            if (this.isCheckBlacklist) {
                if (this.isBlacklistCache) {
                    lambda$checkBlacklistForbid$1(z16, z17);
                } else {
                    dismissTipsLayout();
                }
                return this.isBlacklistCache;
            }
            boolean isBlackOrBlackedUin = ((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).isBlackOrBlackedUin(((ProfileCardInfo) this.mData).allInOne.uin, new CheckBlacklistListener() { // from class: com.tencent.mobileqq.profilecard.base.container.j
                @Override // com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener
                public final void onResult(boolean z19) {
                    ProfileBottomContainer.this.lambda$checkBlacklistForbid$2(z16, z17, z18, z19);
                }
            });
            this.isBlacklistCache = isBlackOrBlackedUin;
            this.isCheckBlacklist = true;
            if (isBlackOrBlackedUin) {
                lambda$checkBlacklistForbid$1(z16, z17);
            } else {
                dismissTipsLayout();
            }
            return this.isBlacklistCache;
        }
        return false;
    }

    private long checkGetValidNumber(String str, long j3) {
        long a16 = com.tencent.biz.qqstory.utils.f.a(str, j3);
        if (a16 == j3) {
            QQToast.makeText(this.mActivity, R.string.f1359202r, 0).show();
            QLog.e(TAG, 1, "checkAndGetValidNumber invalid param: " + str, new Throwable());
            return j3;
        }
        return a16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dismissTipsLayout() {
        View findViewById = ((FrameLayout) this.mViewContainer).findViewById(R.id.tb6);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public static void enterAudioCall(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        enterAudioCall(qQAppInterface, qBaseActivity, profileCardInfo, false);
    }

    public static void enterChat(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        int i3;
        AllInOne allInOne = profileCardInfo.allInOne;
        int p16 = ProfileCardUtil.p(allInOne);
        String str = allInOne.preWinUin;
        if (str != null && str.length() > 0 && (i3 = allInOne.preWinType) != 3000 && i3 != 1 && i3 != 2 && i3 != 1033 && i3 != 1034 && i3 != 1044 && i3 != 1045 && allInOne.preWinUin.equals(allInOne.uin)) {
            if (isPadOnAddFriendFinished(qBaseActivity)) {
                return;
            }
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
        final Intent w3 = l.w(this.mActivity, SplashActivity.getAliasName());
        BaseAIOUtils.m(w3, null);
        w3.putExtra("uin", ((ProfileCardInfo) this.mData).allInOne.uin);
        w3.putExtra("PREVIOUS_WINDOW", this.mActivity.getClass().getName());
        w3.putExtra("PREVIOUS_UIN", ((ProfileCardInfo) this.mData).allInOne.uin);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin);
        if (!((ProfileCardInfo) this.mData).troopMemberCard.isFriend && !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG)) {
            w3.putExtra("uintype", 1000);
            long checkGetValidNumber = checkGetValidNumber(((ProfileCardInfo) this.mData).troopUin, 0L);
            if (checkGetValidNumber == 0) {
                return;
            }
            w3.putExtra("key_groupUin", checkGetValidNumber);
            long checkGetValidNumber2 = checkGetValidNumber(((ProfileCardInfo) this.mData).allInOne.uin, 0L);
            if (checkGetValidNumber2 == 0) {
                return;
            } else {
                w3.putExtra("key_peerUin", checkGetValidNumber2);
            }
        } else {
            w3.putExtra("uintype", 0);
        }
        ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
        DATA data = this.mData;
        iTroopMemberListRepoApi.fetchTroopMemberName(((ProfileCardInfo) data).troopUin, ((ProfileCardInfo) data).allInOne.uin, TAG, new Function1() { // from class: com.tencent.mobileqq.profilecard.base.container.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$enterChatByTroopMember$3;
                lambda$enterChatByTroopMember$3 = ProfileBottomContainer.this.lambda$enterChatByTroopMember$3(w3, (TroopMemberNickInfo) obj);
                return lambda$enterChatByTroopMember$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void enterChatInner() {
        DATA data = this.mData;
        if (((ProfileCardInfo) data).isTroopMemberCard) {
            enterChatByTroopMember();
        } else if (ProfilePAUtils.isFromExtendFriend(((ProfileCardInfo) data).allInOne)) {
            ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).sendMsg(this.mQQAppInterface, ((ProfileCardInfo) this.mData).allInOne, new com.tencent.mobileqq.qqexpand.chat.e() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileBottomContainer.this);
                    }
                }

                @Override // com.tencent.mobileqq.qqexpand.chat.e
                public void enterAio(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
                    } else {
                        ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).enterAio(((AbsComponent) ProfileBottomContainer.this).mActivity, str, str2);
                    }
                }

                public void showCampusVerifyDialog(boolean z16, int i3, String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2);
                    } else {
                        ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).showCampusVerifyDialog(((AbsComponent) ProfileBottomContainer.this).mActivity, z16, i3, str, str2);
                    }
                }

                @Override // com.tencent.mobileqq.qqexpand.chat.e
                public void showMatchCountDialog() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else {
                        ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).showMatchCountDialog(((AbsComponent) ProfileBottomContainer.this).mActivity);
                    }
                }

                @Override // com.tencent.mobileqq.qqexpand.chat.e
                public void showToast(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, i3);
                    } else if (((AbsComponent) ProfileBottomContainer.this).mActivity == null) {
                        QLog.d(ProfileBottomContainer.TAG, 1, "showToast() activity is null just return");
                    } else {
                        ((IExpandMsgSendHelper) QRoute.api(IExpandMsgSendHelper.class)).showToast(((AbsComponent) ProfileBottomContainer.this).mActivity, ((AbsComponent) ProfileBottomContainer.this).mActivity.getString(i3));
                    }
                }
            });
        } else {
            enterChat(this.mQQAppInterface, this.mActivity, (ProfileCardInfo) this.mData);
        }
    }

    private static String getCallNickName(ProfileCardInfo profileCardInfo, QQAppInterface qQAppInterface) {
        int p16 = ProfileCardUtil.p(profileCardInfo.allInOne);
        String str = null;
        if (p16 == 0) {
            if (TextUtils.isEmpty(null)) {
                str = profileCardInfo.nameArray[4];
            }
            if (TextUtils.isEmpty(str)) {
                str = profileCardInfo.allInOne.remark;
            }
        } else if (p16 != 1000 && p16 != 1020) {
            if (p16 == 1021) {
                str = profileCardInfo.nameArray[2];
                if (TextUtils.isEmpty(str)) {
                    str = profileCardInfo.allInOne.circleName;
                }
            } else if (p16 == 1004) {
                AllInOne allInOne = profileCardInfo.allInOne;
                String str2 = allInOne.troopUin;
                if (str2 != null) {
                    str = ac.n(qQAppInterface, str2, allInOne.uin);
                }
            } else if (ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne)) {
                str = profileCardInfo.nameArray[3];
            }
        } else {
            str = profileCardInfo.nameArray[1];
            if (TextUtils.isEmpty(str)) {
                str = profileCardInfo.allInOne.troopNickName;
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = profileCardInfo.nameArray[0];
        }
        if (TextUtils.isEmpty(str)) {
            return profileCardInfo.allInOne.nickname;
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleAddFriendClick() {
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
    private void handleChatClick() {
        if (((ProfileCardInfo) this.mData).allInOne.profileEntryType == 126) {
            QBaseActivity qBaseActivity = this.mActivity;
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, qBaseActivity.getString(R.string.vzu), this.mActivity.getString(R.string.bbe), this.mActivity.getString(R.string.vzt), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileBottomContainer.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    dialogInterface.dismiss();
                    ProfileBottomContainer.this.enterChatInner();
                    if (((ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData).isTroopMemberCard) {
                        new q(ProfileBottomContainer.this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("msg_clk").b(((ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData).troopUin).g();
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileBottomContainer.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        dialogInterface.dismiss();
                    }
                }
            }).show();
        } else {
            enterChatInner();
            if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
                new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("msg_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
            }
        }
        ProfileCardReport.reportChatClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleEditClick() {
        int i3;
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            Bundle bundle = new Bundle();
            IProfileCardFeatureApi.ProfileCardEmptyStatus profieEmptyStatus = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getProfieEmptyStatus((ProfileCardInfo) this.mData);
            bundle.putBoolean(IProfileCardConst.PROFILE_JUMP_WITH_BUBBLE, ((ProfileCardInfo) this.mData).hasShowedEditBubble);
            if (profieEmptyStatus == IProfileCardFeatureApi.ProfileCardEmptyStatus.PHOTO_EMPTY) {
                i3 = 1;
            } else if (profieEmptyStatus == IProfileCardFeatureApi.ProfileCardEmptyStatus.LABEL_EMPTY) {
                i3 = 2;
            } else if (profieEmptyStatus == IProfileCardFeatureApi.ProfileCardEmptyStatus.BOTH_EMPTY) {
                i3 = 3;
            } else {
                i3 = 0;
            }
            bundle.putInt(IProfileCardConst.PROFILE_JUMP_WITH_ITEM_EMPTY, i3);
            int photoWallPicNum = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getPhotoWallPicNum((ProfileCardInfo) this.mData);
            if (photoWallPicNum != -1) {
                bundle.putInt(IProfileCardConst.PROFILE_JUMP_WITH_PHOTO_NUM, photoWallPicNum);
            }
            ProfileCardUtils.openProfileEditWithData(this.mQQAppInterface, this.mActivity, (ProfileCardInfo) this.mData, bundle);
            ReportController.o(this.mApp, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
            new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("edit_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
            ProfileCardReport.reportProfileEditClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleFreeCallClick() {
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
        n06.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileBottomContainer.this);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public void onDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ReportController.o(((AbsComponent) ProfileBottomContainer.this).mApp, "CliOper", "", "", "0X8008406", "0X8008406", 0, 0, "", "", "", "");
                }
            }
        });
        n06.setOnButtonClickListener(new AnonymousClass8(new int[]{1, 2, 3}, n06, sessionInfo));
        n06.show();
        ProfileCardReport.reportVideoCallClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleGivePresentClick() {
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
        if (!TextUtils.isEmpty(config)) {
            str = config.replace("{to_uin}", ((ProfileCardInfo) this.mData).allInOne.uin + "_" + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(System.currentTimeMillis())));
        } else {
            str = null;
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

    private void handleSaveContactClick() {
        PermissionChecker.e(this.mActivity, new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileBottomContainer.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IPhoneContactService iPhoneContactService = (IPhoneContactService) ((AbsComponent) ProfileBottomContainer.this).mApp.getRuntimeService(IPhoneContactService.class, "");
                if (!iPhoneContactService.existContact(((ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData).allInOne.contactName, ((ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData).allInOne.uin)) {
                    if (iPhoneContactService.addContactAndUpload(((ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData).allInOne.contactName, ((ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData).allInOne.uin)) {
                        QQToast.makeText(((AbsComponent) ProfileBottomContainer.this).mActivity, 2, HardCodeUtil.qqStr(R.string.msq), 0).show();
                        return;
                    } else {
                        QQToast.makeText(((AbsComponent) ProfileBottomContainer.this).mActivity, 1, HardCodeUtil.qqStr(R.string.mtj), 0).show();
                        return;
                    }
                }
                QQToast.makeText(((AbsComponent) ProfileBottomContainer.this).mActivity, HardCodeUtil.qqStr(R.string.f172023msg), 0).show();
            }
        }, new DenyRunnable(this.mActivity, new DenyRunnable.b() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileBottomContainer.this);
                }
            }

            @Override // com.tencent.mobileqq.activity.phone.DenyRunnable.b
            public void onCancel(Context context, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
                    return;
                }
                if (z16) {
                    QQToast.makeText(((AbsComponent) ProfileBottomContainer.this).mActivity, 1, HardCodeUtil.qqStr(R.string.msn), 0).show();
                    return;
                }
                Intent intent = new Intent(((AbsComponent) ProfileBottomContainer.this).mActivity, (Class<?>) GuideBindPhoneActivity.class);
                intent.putExtra("fromKeyForContactBind", 5);
                intent.putExtra("key_contact_name", ((ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData).allInOne.contactName);
                intent.putExtra("key_contact_phone", ((ProfileCardInfo) ((AbsComponent) ProfileBottomContainer.this).mData).allInOne.uin);
                ((AbsComponent) ProfileBottomContainer.this).mActivity.startActivity(intent);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleTemplateClick(View view, com.tencent.mobileqq.profile.b bVar) {
        String str;
        View findViewById = view.findViewById(R.id.khb);
        Object parent = view.getParent();
        if (parent instanceof View) {
            findViewById = ((View) parent).findViewById(R.id.khb);
        }
        int i3 = 1;
        if (findViewById != null) {
            if (findViewById.getVisibility() == 0) {
                i3 = 0;
            }
            findViewById.setVisibility(8);
        }
        int i16 = i3;
        reportRedPointClicked();
        if (bVar.f260135a == 92) {
            str = "profileType=custom";
        } else {
            str = "";
        }
        ProfileCardUtil.F(this.mActivity, this.mApp.getCurrentAccountUin(), "inside.myCardButton", i16, 3, 1, str, true, 41);
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

    /* JADX WARN: Multi-variable type inference failed */
    private void handleTemplateClickForDiy(View view, com.tencent.mobileqq.profile.b bVar) {
        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E3B", 2, 0, "", "", "", "");
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        handleTemplateClick(view, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleTroopSendGiftClick() {
        int i3;
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        DATA data = this.mData;
        String s16 = ac.s(qQAppInterface, ((ProfileCardInfo) data).card.uin, ((ProfileCardInfo) data).troopUin, 1, 0);
        HashMap hashMap = new HashMap();
        hashMap.put(LaunchParam.KEY_REF_ID, "biz_src_hdsp_liwu");
        if (GiftPanelControllerWithGiftRepo.F() && ((ProfileCardInfo) this.mData).isTroopMemberCard) {
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
            } else if (k3.isOwnerOrAdmin()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(this.mApp, "P_CliOper", "Grp_flower", "", "mber_data", "Clk_send", 0, 0, ((ProfileCardInfo) this.mData).troopUin, i3 + "", "", "");
            AppInterface appInterface = this.mApp;
            DATA data3 = this.mData;
            ReportController.o(appInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, ((ProfileCardInfo) data3).troopUin, "4", com.tencent.mobileqq.profile.l.b(com.tencent.mobileqq.profile.l.a(k3, ((ProfileCardInfo) data3).card.uin)), "");
            new q(this.mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("flower_clk").b(((ProfileCardInfo) this.mData).troopUin).g();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleUpdateBtnGroupInner1(int i3, boolean z16, boolean z17) {
        if (i3 == 1) {
            DATA data = this.mData;
            if (((ProfileCardInfo) data).isTroopMemberCard) {
                if (((ProfileCardInfo) data).allInOne.f260789pa == 0) {
                    updateBtn(this.mBtnsContainer.getChildAt(0), 23, R.string.f171194d20, 1, R.string.f170793ac4);
                }
                updateBtn(this.mBtnsContainer.getChildAt(1), 81, R.string.buf, 1, R.string.aav);
            } else if (dr.e(this.mQQAppInterface)) {
                updateBtn(this.mBtnsContainer.getChildAt(0), 92, R.string.f171195d21, 1, R.string.f171195d21);
                updateBtn(this.mBtnsContainer.getChildAt(1), 81, R.string.buf, 1, R.string.aav);
            } else {
                updateBtn(this.mBtnsContainer.getChildAt(0), 23, R.string.f171194d20, 1, R.string.f170793ac4);
                updateBtn(this.mBtnsContainer.getChildAt(1), 81, R.string.buf, 1, R.string.aav);
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin);
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0 && !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG)) {
                updateBtn(this.mBtnsContainer.getChildAt(2), 7, R.string.btk, 2, R.string.aai);
            } else {
                updateBtn(this.mBtnsContainer.getChildAt(2), 8, R.string.heh, 2, R.string.acj);
            }
        }
    }

    private void handleUpdateBtnGroupInner2(int i3, boolean z16, boolean z17) {
        switch (i3) {
            case 2:
                updateBtn(this.mBtnsContainer.getChildAt(1), 7, R.string.btk, 1, R.string.aai);
                updateBtn(this.mBtnsContainer.getChildAt(2), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording());
                updateBtn(this.mBtnsContainer.getChildAt(4), 8, R.string.heh, 2, R.string.acj);
                return;
            case 3:
                updateBtn(this.mBtnsContainer.getChildAt(1), 7, R.string.btk, 1, R.string.aai);
                updateBtn(this.mBtnsContainer.getChildAt(4), 8, R.string.heh, 2, R.string.acj);
                return;
            case 4:
                updateBtn(this.mBtnsContainer.getChildAt(1), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording());
                if (!z17 && !StudyModeManager.t()) {
                    updateBtn(this.mBtnsContainer.getChildAt(2), 95, R.string.fgn, 1, R.string.fgn);
                    ReportController.o(this.mApp, "", "", "", "0X800A1C4", "0X800A1C4", 0, 0, "", "", "", "");
                }
                updateBtn(this.mBtnsContainer.getChildAt(4), 8, R.string.heh, 2, R.string.acj);
                return;
            case 5:
                updateBtn(this.mBtnsContainer.getChildAt(1), 7, R.string.btk, 1, R.string.aai);
                updateBtn(this.mBtnsContainer.getChildAt(2), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording());
                return;
            case 6:
                updateBtn(this.mBtnsContainer.getChildAt(4), 7, R.string.btk, 2, R.string.aai);
                return;
            case 7:
                updateBtn(this.mBtnsContainer.getChildAt(4), 8, R.string.heh, 2, R.string.acj);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleUpdateBtnGroupInner3(int i3, boolean z16, boolean z17) {
        switch (i3) {
            case 8:
                updateBtn(this.mBtnsContainer.getChildAt(1), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording());
                return;
            case 9:
            default:
                return;
            case 10:
                updateBtn(this.mBtnsContainer.getChildAt(1), 59, R.string.bvw, 1, R.string.bvw);
                return;
            case 11:
                updateBtn(this.mBtnsContainer.getChildAt(1), 59, R.string.bvw, 1, R.string.bvw);
                updateBtn(this.mBtnsContainer.getChildAt(4), 7, R.string.btk, 2, R.string.aai);
                return;
            case 12:
                if (ProfilePAUtils.isPaTypeCanAddAsFriend(((ProfileCardInfo) this.mData).allInOne)) {
                    updateBtn(this.mBtnsContainer.getChildAt(1), 7, R.string.btk, 1, R.string.aai);
                } else {
                    updateBtn(this.mBtnsContainer.getChildAt(1), 20, this.mConfigHelper.getVoiceBtnWording(), 1, this.mConfigHelper.getVoiceBtnWording());
                }
                if (!z17 && !StudyModeManager.t()) {
                    updateBtn(this.mBtnsContainer.getChildAt(2), 77, R.string.fgn, 1, R.string.fgn);
                }
                updateBtn(this.mBtnsContainer.getChildAt(4), 8, R.string.heh, 2, R.string.acj);
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initBottomBtns(LinearLayout linearLayout) {
        Resources resources = this.mActivity.getResources();
        LayoutInflater layoutInflater = this.mActivity.getLayoutInflater();
        linearLayout.removeAllViews();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d9o);
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && ((ProfileCardInfo) data).allInOne.f260789pa != 33) {
            if (((ProfileCardInfo) data).allInOne.f260789pa == 0 && !TextUtils.isEmpty(((ProfileCardInfo) data).allInOne.uin)) {
                View inflate = layoutInflater.inflate(R.layout.bej, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                layoutParams.rightMargin = dimensionPixelSize;
                linearLayout.addView(inflate, layoutParams);
                RedTouch applyTo = new RedTouch(this.mActivity, inflate).setRightMargin(30.0f).setTopMargin(30.0f).applyTo();
                this.mTemplateCardRedTouch = applyTo;
                if (applyTo != null) {
                    updateTemplateRedTouch();
                }
                View inflate2 = layoutInflater.inflate(R.layout.bej, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                layoutParams2.rightMargin = dimensionPixelSize;
                linearLayout.addView(inflate2, layoutParams2);
                View inflate3 = layoutInflater.inflate(R.layout.azh, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
                layoutParams3.weight = 1.0f;
                layoutParams3.rightMargin = dimensionPixelSize;
                linearLayout.addView(inflate3, layoutParams3);
            }
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 0) {
                View inflate4 = layoutInflater.inflate(R.layout.azt, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.rightMargin = dimensionPixelSize;
                linearLayout.addView(inflate4, layoutParams4);
                View inflate5 = layoutInflater.inflate(R.layout.f168850b13, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2);
                layoutParams5.weight = 1.0f;
                layoutParams5.rightMargin = dimensionPixelSize;
                linearLayout.addView(inflate5, layoutParams5);
                View inflate6 = layoutInflater.inflate(R.layout.f168850b13, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2);
                layoutParams6.weight = 1.0f;
                layoutParams6.rightMargin = dimensionPixelSize;
                linearLayout.addView(inflate6, layoutParams6);
                View inflate7 = layoutInflater.inflate(R.layout.f168850b13, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
                layoutParams7.weight = 1.0f;
                layoutParams7.rightMargin = dimensionPixelSize;
                linearLayout.addView(inflate7, layoutParams7);
                View inflate8 = layoutInflater.inflate(R.layout.azh, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
                layoutParams8.weight = 1.0f;
                layoutParams8.rightMargin = dimensionPixelSize;
                linearLayout.addView(inflate8, layoutParams8);
            }
        }
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
        }
    }

    private boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime < 800) {
            return true;
        }
        this.lastClickTime = currentTimeMillis;
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

    private static boolean isPadOnAddFriendFinished(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && AppSetting.t(qBaseActivity)) {
            qBaseActivity.onKeyDown(4, new KeyEvent(4, 4));
            qBaseActivity.onKeyDown(4, new KeyEvent(4, 4));
            return true;
        }
        return false;
    }

    private static void jumpLaunchAddFriendWithCardInfo(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, int i3, int i16, String str) {
        String str2;
        ProfileContactInfo cardContactInfo = ProfileUtils.getCardContactInfo(profileCardInfo.allInOne);
        if (cardContactInfo != null && (str2 = cardContactInfo.phoneNumber) != null && str2.length() > 0) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void jumpLaunchAddFriendWithCardInfoAndTroop(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, boolean z16, int i3, int i16, String str) {
        String str2;
        String str3;
        int i17;
        String str4;
        String stringExtra;
        String str5;
        String str6 = null;
        if (3004 == i3 && !TextUtils.isEmpty(profileCardInfo.allInOne.troopUin)) {
            str3 = profileCardInfo.allInOne.troopUin;
        } else if (3005 == i3 && !TextUtils.isEmpty(profileCardInfo.allInOne.discussUin)) {
            str3 = profileCardInfo.allInOne.discussUin;
        } else {
            str2 = null;
            i17 = profileCardInfo.allInOne.f260789pa;
            if (i17 == 71 && i17 != 72) {
                if (i17 == 77 || i17 == 82 || i17 == 81 || i17 == 83 || i17 == 84 || i17 == 101 || i17 == 103 || i17 == 102 || i17 == 107 || i17 == 110) {
                    str6 = profileCardInfo.nameArray[5];
                }
            } else {
                str6 = profileCardInfo.nameArray[2];
            }
            if (!TextUtils.isEmpty(str6)) {
                str4 = profileCardInfo.nameArray[0];
            } else {
                str4 = str6;
            }
            stringExtra = qBaseActivity.getIntent().getStringExtra("param_return_addr");
            if (stringExtra == null) {
                String name = AddContactsActivity.class.getName();
                if (stringExtra.equals(QidianProfileCardActivity.class.getName())) {
                    str5 = stringExtra;
                } else {
                    str5 = name;
                }
                if (TextUtils.isEmpty(str4)) {
                    str4 = profileCardInfo.profileName.f305805a.f305804b;
                }
                Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(qBaseActivity, 1, profileCardInfo.allInOne.uin, str2, i3, i16, str4, null, str5, qBaseActivity.getString(R.string.button_back), null);
                startAddFriend.putExtra(AppConstants.Key.KEY_FROM_BABYQ, z16);
                ProfileActivity.K2(qBaseActivity, startAddFriend, profileCardInfo);
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(qBaseActivity, startAddFriend);
                return;
            }
            Intent startAddFriend2 = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(qBaseActivity, 1, profileCardInfo.allInOne.uin, str2, i3, i16, str4, null, ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass().getName(), qBaseActivity.getString(R.string.button_back), null);
            startAddFriend2.putExtra(AppConstants.Key.KEY_FROM_BABYQ, z16);
            ProfileActivity.K2(qBaseActivity, startAddFriend2, profileCardInfo);
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
        if (i17 == 71) {
        }
        str6 = profileCardInfo.nameArray[2];
        if (!TextUtils.isEmpty(str6)) {
        }
        stringExtra = qBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (stringExtra == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkBlacklistForbid$0(boolean z16, boolean z17, boolean z18) {
        dismissTipsLayout();
        updateBtnGroupByParamCombination(z16, z17, z18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkBlacklistForbid$2(final boolean z16, final boolean z17, final boolean z18, boolean z19) {
        if (this.isBlacklistCache == z19) {
            return;
        }
        this.isBlacklistCache = z19;
        if (!z19) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.h
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileBottomContainer.this.lambda$checkBlacklistForbid$0(z16, z17, z18);
                }
            });
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.i
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileBottomContainer.this.lambda$checkBlacklistForbid$1(z16, z17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Unit lambda$enterChatByTroopMember$3(Intent intent, TroopMemberNickInfo troopMemberNickInfo) {
        String str;
        AppInterface appInterface = this.mApp;
        QBaseActivity qBaseActivity = this.mActivity;
        if (appInterface != null && qBaseActivity != null) {
            if (troopMemberNickInfo != null) {
                str = troopMemberNickInfo.getShowName();
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = ((ProfileCardInfo) this.mData).troopMemberCard.nick;
            }
            intent.putExtra("uinname", str);
            intent.putExtra(AppConstants.Key.TROOP_CODE, ((ProfileCardInfo) this.mData).troopUin);
            TroopManager troopManager = (TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null) {
                troopManager.r(((ProfileCardInfo) this.mData).troopUin, new ITroopInfoService.a(qBaseActivity, intent) { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.6
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Activity val$activity;
                    final /* synthetic */ Intent val$intent;

                    {
                        this.val$activity = qBaseActivity;
                        this.val$intent = intent;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ProfileBottomContainer.this, qBaseActivity, intent);
                        }
                    }

                    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService.a
                    public void onResult(Object obj) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, obj);
                            return;
                        }
                        if ((obj instanceof String) && this.val$activity != null) {
                            this.val$intent.putExtra("troop_uin", (String) obj);
                            this.val$intent.putExtra(AppConstants.Key.CSPECIAL_FLAG, 0);
                            this.val$intent.putExtra("key_from", "3");
                            this.val$activity.startActivity(this.val$intent);
                        }
                    }
                });
            }
        }
        return null;
    }

    @SuppressLint({"DefaultLocale"})
    private void reportRedPointClicked() {
        BusinessInfoCheckUpdate.AppInfo appInfo = this.mTemplateRedPointInfo;
        if (appInfo != null && appInfo.iNewFlag.get() != 0) {
            ((RedTouchManager) this.mApp.getManager(QQManagerFactory.MGR_RED_TOUCH)).k0(String.format("%d%s%d", 100100, ".", Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_TEMPLATE_CARD)));
            this.mTemplateRedPointInfo = null;
        }
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
        if (i3 != 3) {
            if (i3 != 35) {
                if (i3 != 37) {
                    if (i3 != 58) {
                        if (i3 != 75) {
                            if (i3 != 21) {
                                if (i3 == 22) {
                                    sourceParam.sourceId = 3004;
                                    sourceParam.subSourceId = 3;
                                    return;
                                }
                                return;
                            }
                            sourceParam.sourceId = 3004;
                            sourceParam.subSourceId = allInOne.subSourceId;
                            return;
                        }
                        sourceParam.sourceId = 3017;
                        sourceParam.subSourceId = 1;
                        return;
                    }
                    sourceParam.sourceId = 3007;
                    sourceParam.subSourceId = 1;
                    return;
                }
                sourceParam.sourceId = 3020;
                sourceParam.subSourceId = allInOne.subSourceId;
                return;
            }
            sourceParam.sourceId = 3001;
            sourceParam.subSourceId = 1;
            return;
        }
        sourceParam.sourceId = 3002;
        sourceParam.subSourceId = allInOne.subSourceId;
    }

    public static void setSourceParamValue2(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 25) {
                    if (i3 != 27) {
                        if (i3 != 74) {
                            if (i3 != 77) {
                                if (i3 != 41 && i3 != 42) {
                                    if (i3 == 46 || i3 == 47) {
                                        sourceParam.sourceId = 3005;
                                        sourceParam.subSourceId = 1;
                                        return;
                                    }
                                    return;
                                }
                                sourceParam.sourceId = 3007;
                                sourceParam.subSourceId = 2;
                                return;
                            }
                        } else {
                            sourceParam.sourceId = 3008;
                            sourceParam.subSourceId = 11;
                            return;
                        }
                    } else {
                        sourceParam.sourceId = 3041;
                        sourceParam.subSourceId = 11;
                        return;
                    }
                } else {
                    sourceParam.sourceId = 3041;
                    sourceParam.subSourceId = 12;
                    return;
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
        if (i3 != 23) {
            if (i3 != 24) {
                if (i3 != 31) {
                    if (i3 != 32) {
                        if (i3 != 34) {
                            if (i3 != 120) {
                                if (i3 != 97) {
                                    if (i3 == 98) {
                                        sourceParam.sourceId = 3096;
                                        sourceParam.subSourceId = 1;
                                        return;
                                    }
                                    return;
                                }
                                sourceParam.sourceId = 3095;
                                sourceParam.subSourceId = 1;
                                return;
                            }
                            sourceParam.sourceId = 3037;
                            sourceParam.subSourceId = 2;
                            return;
                        }
                    } else {
                        sourceParam.sourceId = 3009;
                        return;
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
            return;
        }
        sourceParam.sourceId = 3037;
        sourceParam.subSourceId = 1;
    }

    public static void setSourceParamValue4(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 != 29) {
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
            return;
        }
        sourceParam.sourceId = 3075;
        int i16 = allInOne.subSourceId;
        if (i16 != 16 && i16 != 17) {
            sourceParam.subSourceId = 1;
        } else {
            sourceParam.sourceId = 3006;
            sourceParam.subSourceId = i16;
        }
    }

    public static void setSourceParamValue5(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 != 36) {
            if (i3 != 61) {
                if (i3 != 78) {
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
                    return;
                }
                sourceParam.sourceId = 3022;
                sourceParam.subSourceId = 1;
                if (z16) {
                    sourceParam.sourceId = 3083;
                    sourceParam.subSourceId = 1;
                    return;
                }
                return;
            }
            sourceParam.sourceId = 3011;
            return;
        }
        sourceParam.sourceId = 3014;
        sourceParam.subSourceId = 1;
    }

    public static void setSourceParamValue6(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16, Bundle bundle) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 != 81) {
            if (i3 != 107) {
                if (i3 != 110) {
                    if (i3 != 83) {
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
                        return;
                    }
                    sourceParam.sourceId = 3045;
                    sourceParam.subSourceId = 3;
                    if (z16) {
                        sourceParam.sourceId = 3083;
                        sourceParam.subSourceId = 1;
                        return;
                    }
                    return;
                }
                sourceParam.sourceId = 3045;
                int i16 = 0;
                if (bundle != null) {
                    i16 = bundle.getInt("tabID", 0);
                }
                sourceParam.subSourceId = i16;
                return;
            }
            sourceParam.sourceId = 3045;
            sourceParam.subSourceId = 28;
            return;
        }
        sourceParam.sourceId = 3045;
        sourceParam.subSourceId = 23;
    }

    public static void setSourceParamValue7(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 != 95) {
            if (i3 != 96) {
                if (i3 != 108) {
                    if (i3 != 109) {
                        if (i3 != 111) {
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
                            return;
                        }
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
                    sourceParam.sourceId = 3041;
                    sourceParam.subSourceId = 15;
                    return;
                }
                sourceParam.sourceId = 3041;
                sourceParam.subSourceId = 14;
                return;
            }
            sourceParam.sourceId = 3094;
            sourceParam.subSourceId = allInOne.subSourceId;
            return;
        }
        sourceParam.sourceId = 3092;
        sourceParam.subSourceId = 1;
    }

    public static void setSourceParamValue8(ProfileCardInfo profileCardInfo, SourceParam sourceParam, boolean z16) {
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        if (i3 != 113) {
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
            return;
        }
        sourceParam.sourceId = 3004;
        sourceParam.subSourceId = allInOne.subSourceId;
    }

    private void updateBtn(View view, int i3, int i16, int i17, int i18) {
        updateBtn(view, i3, this.mActivity.getString(i16), i17, this.mActivity.getString(i18));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009c, code lost:
    
        if (((com.tencent.mobileqq.profilecard.data.ProfileCardInfo) r4).allInOne.extendFriendVoiceCode.length > 0) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateBtnGroup(boolean z16) {
        boolean z17 = true;
        boolean z18 = false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateBtns isNetRet=%s", Boolean.valueOf(z16)));
        }
        DATA data = this.mData;
        if (((ProfileCardInfo) data).allInOne.f260789pa == 0) {
            updateBtnGroupInner(1);
            return;
        }
        if (((ProfileCardInfo) data).allInOne.f260789pa == 53) {
            updateBtnGroupFromContact();
            return;
        }
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
            if (((ProfileCardInfo) data3).allInOne.extendFriendVoiceCode != null) {
            }
        }
        z17 = isPaTypeCanTalk;
        if (ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne)) {
            z18 = isPaTypeCanFreeCall;
        }
        updateBtnGroupByParamCombination(isPaTypeCanAddAsFriend, z17, z18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: updateBtnGroupBlacklistInner, reason: merged with bridge method [inline-methods] */
    public void lambda$checkBlacklistForbid$1(boolean z16, boolean z17) {
        View findViewById;
        if (this.mBtnsContainer != null && (findViewById = ((FrameLayout) this.mViewContainer).findViewById(R.id.tb6)) != null) {
            String blacklistTipMsg = ((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).getBlacklistTipMsg(((ProfileCardInfo) this.mData).allInOne.uin);
            if (TextUtils.isEmpty(blacklistTipMsg)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                ((TextView) findViewById.findViewById(R.id.tb7)).setText(blacklistTipMsg);
                ImageView imageView = (ImageView) findViewById.findViewById(R.id.tb5);
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setColorFilter(findViewById.getResources().getColor(R.color.qui_common_feedback_error), PorterDuff.Mode.SRC_ATOP);
                    imageView.setBackgroundDrawable(drawable);
                }
            }
        }
        if (z16 && z17) {
            updateBtnGroupInner(3);
            return;
        }
        if (z16) {
            updateBtnGroupInner(6);
        } else if (z17) {
            updateBtnGroupInner(7);
        } else {
            updateBtnGroupInner(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateBtnGroupByParamCombination(boolean z16, boolean z17, boolean z18) {
        if (checkBlacklistForbid(z16, z17, z18)) {
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
        } else if (z18) {
            updateBtnGroupInner(5);
        } else {
            updateBtnGroupInner(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateBtnGroupFromContact() {
        int i3;
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
                if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
                    i3 = 12;
                } else {
                    i3 = 2;
                }
                updateBtnGroupInner(i3);
                return;
            }
            updateBtnGroupInner(11);
            return;
        }
        updateBtnGroupInner(10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateBtnGroupInner(int i3) {
        boolean z16;
        int i16;
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return;
        }
        TroopManager troopManager = (TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        DATA data = this.mData;
        boolean z17 = true;
        int i17 = 0;
        if (((ProfileCardInfo) data).isTroopMemberCard && troopManager.V(((ProfileCardInfo) data).troopUin)) {
            TroopInfo B = troopManager.B(((ProfileCardInfo) this.mData).troopUin);
            ProfileTroopMemInfoComponent profileTroopMemInfoComponent = (ProfileTroopMemInfoComponent) this.mComponentCenter.getComponent(1013);
            if (profileTroopMemInfoComponent != null) {
                profileTroopMemInfoComponent.checkAndUpdateTroopInfo(B);
            }
            if (!B.isTroopAdmin(((ProfileCardInfo) this.mData).allInOne.uin) && !B.isTroopOwner(((ProfileCardInfo) this.mData).allInOne.uin)) {
                z16 = false;
                z17 = false;
            } else {
                z16 = true;
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
        FrameLayout frameLayout = (FrameLayout) this.mViewContainer;
        if (z17) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        frameLayout.setVisibility(i16);
        LinearLayout linearLayout = this.mBtnsContainer;
        if (!z17) {
            i17 = 8;
        }
        linearLayout.setVisibility(i17);
    }

    @SuppressLint({"DefaultLocale"})
    private void updateTemplateRedTouch() {
        if (this.mTemplateCardRedTouch != null) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) this.mApp.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.format("%d%s%d", 100100, ".", Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_TEMPLATE_CARD)));
            this.mTemplateRedPointInfo = appInfoByPath;
            this.mTemplateCardRedTouch.parseRedTouch(appInfoByPath);
            iRedTouchManager.onReportRedPointExposure(this.mTemplateRedPointInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IProfileBottomContainer
    public void addFriend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            addFriendInner();
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void dtReport(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            VideoReport.reportEvent("clck", view, null);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 107;
    }

    public void initDtReport(LinearLayout linearLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) linearLayout);
            return;
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Button button = (Button) linearLayout.getChildAt(i3).findViewById(R.id.txt);
            if (button != null && button.getTag() != null && !TextUtils.isEmpty(button.getText().toString())) {
                int i16 = ((com.tencent.mobileqq.profile.b) button.getTag()).f260135a;
                if (i16 == 8) {
                    initElement(button, "em_profile_send");
                } else if (i16 == 7) {
                    initElement(button, "em_profile_addfriend");
                }
            }
        }
    }

    public void initElement(View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view, (Object) str);
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else if (view.getTag() instanceof com.tencent.mobileqq.profile.b) {
            com.tencent.mobileqq.profile.b bVar = (com.tencent.mobileqq.profile.b) view.getTag();
            int i3 = bVar.f260135a;
            if (i3 != 7) {
                if (i3 != 8) {
                    if (i3 != 20) {
                        if (i3 != 23) {
                            if (i3 != 59) {
                                if (i3 != 77) {
                                    if (i3 != 81) {
                                        if (i3 != 92) {
                                            if (i3 == 95) {
                                                handleGivePresentClick();
                                            }
                                        } else if (!isFastClick()) {
                                            handleTemplateClickForDiy(view, bVar);
                                        }
                                    } else {
                                        handleEditClick();
                                    }
                                } else {
                                    handleTroopSendGiftClick();
                                }
                            } else {
                                handleSaveContactClick();
                            }
                        } else if (!isFastClick()) {
                            handleTemplateClick(view, bVar);
                        }
                    } else {
                        handleFreeCallClick();
                    }
                } else {
                    dtReport(view);
                    handleChatClick();
                }
            } else {
                dtReport(view);
                handleAddFriendClick();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsQQProfileContainer, com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mIsFromArkBabyQ = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_ARK_BABYQ, false);
        }
        initViews();
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Dialog dialog = this.addFriendDialog;
        if (dialog != null && dialog.isShowing()) {
            this.addFriendDialog.dismiss();
            this.addFriendDialog = null;
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onPause();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        updateTemplateRedTouch();
        this.isCheckBlacklist = false;
        this.isBlacklistCache = false;
    }

    public static void addFriend(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, Dialog dialog) {
        String str;
        Bundle bundleExtra = qBaseActivity.getIntent().getBundleExtra(IProfileCardConst.KEY_PROFILE_EXTRA);
        boolean z16 = false;
        if (bundleExtra != null && bundleExtra.getBoolean(AppConstants.Key.KEY_FROM_BABYQ, false)) {
            z16 = true;
        }
        SourceParam sourceParam = new SourceParam();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "addFriend, begin, sourceParam == " + sourceParam);
        }
        setSourceParamValue1(profileCardInfo, sourceParam, z16);
        setSourceParamValue2(profileCardInfo, sourceParam, z16);
        setSourceParamValue3(profileCardInfo, sourceParam, z16);
        setSourceParamValue4(profileCardInfo, sourceParam, z16);
        setSourceParamValue5(profileCardInfo, sourceParam, z16);
        setSourceParamValue6(profileCardInfo, sourceParam, z16, bundleExtra);
        setSourceParamValue7(profileCardInfo, sourceParam, z16);
        setSourceParamValue8(profileCardInfo, sourceParam, z16);
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void enterAudioCall(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, boolean z16) {
        String str;
        String mobileNumberWithNationCode;
        ContactCard contactCard;
        String str2;
        String str3;
        int p16 = ProfileCardUtil.p(profileCardInfo.allInOne);
        String callNickName = getCallNickName(profileCardInfo, qQAppInterface);
        if (ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
            str = profileCardInfo.allInOne.uin;
            mobileNumberWithNationCode = null;
        } else {
            if (profileCardInfo.allInOne.f260789pa != 53 || (contactCard = profileCardInfo.contactCard) == null || TextUtils.isEmpty(contactCard.uin)) {
                str = null;
            } else {
                str = profileCardInfo.contactCard.uin;
                p16 = 0;
            }
            mobileNumberWithNationCode = ProfileUtils.getMobileNumberWithNationCode(profileCardInfo.allInOne);
        }
        if (p16 == 1000) {
            str3 = profileCardInfo.allInOne.troopUin;
        } else if (p16 == 1004) {
            str3 = profileCardInfo.allInOne.discussUin;
        } else {
            str2 = null;
            if (qQAppInterface.getAVNotifyCenter().g(qBaseActivity, 1, p16, str)) {
                if (qBaseActivity == null || qBaseActivity.isFinishing()) {
                    QLog.e(TAG, 1, "enterAudioCall fail, activity is not running");
                    return;
                } else {
                    if (z16) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("should_believe_only_audio_flag", "true");
                        ChatActivityUtils.j0(qQAppInterface, qBaseActivity, p16, str, callNickName, mobileNumberWithNationCode, true, str2, true, true, null, "from_internal", hashMap);
                        return;
                    }
                    ChatActivityUtils.h0(qQAppInterface, qBaseActivity, p16, str, callNickName, mobileNumberWithNationCode, true, str2, true, true, null, "from_internal");
                    return;
                }
            }
            return;
        }
        str2 = str3;
        if (qQAppInterface.getAVNotifyCenter().g(qBaseActivity, 1, p16, str)) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateBtn(View view, int i3, String str, int i16, String str2) {
        if (view != null) {
            view.setVisibility(0);
            com.tencent.mobileqq.profile.b bVar = new com.tencent.mobileqq.profile.b(i3, null);
            QUIButton qUIButton = (QUIButton) view.findViewById(R.id.txt);
            qUIButton.setTag(bVar);
            qUIButton.setOnClickListener(this);
            qUIButton.setContentDescription(str2);
            qUIButton.setText(str);
            qUIButton.setSingleLine();
            qUIButton.setEllipsize(TextUtils.TruncateAt.END);
            qUIButton.setType(i16 != 2 ? 1 : 0);
            if (i3 == 81) {
                ProfileCardBubbleUtil.showEditProfileTips(this.mActivity, view, (ProfileCardInfo) this.mData);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileBottomContainer) profileCardInfo);
        updateBtnGroup(profileCardInfo.isNetRet);
        if (!this.isInit) {
            this.isInit = true;
            initDtReport(this.mBtnsContainer);
        }
        return lambda$checkValidComponent$3;
    }

    private static void enterChat(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, String str, int i3) {
        Intent w3;
        boolean booleanExtra = qBaseActivity.getIntent() != null ? qBaseActivity.getIntent().getBooleanExtra(AppConstants.Key.KEY_NEED_TRACK_BACK, false) : false;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("profile_open_aio_force_chat_activity", true)) {
            booleanExtra = true;
        }
        if (booleanExtra) {
            w3 = new Intent(qBaseActivity, (Class<?>) ChatActivity.class);
        } else {
            w3 = l.w(qBaseActivity, SplashActivity.getAliasName());
        }
        BaseAIOUtils.m(w3, null);
        w3.putExtra("PREVIOUS_WINDOW", ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass().getName());
        w3.putExtra("PREVIOUS_UIN", profileCardInfo.allInOne.uin);
        if (qBaseActivity.getIntent().getExtras() != null) {
            w3.putExtra(AppConstants.Key.CSPECIAL_FLAG, qBaseActivity.getIntent().getExtras().getInt(AppConstants.Key.CSPECIAL_FLAG));
        }
        w3.putExtra("uin", str);
        w3.putExtra("uintype", i3);
        w3.putExtra("aio_msg_source", 3);
        if (i3 == 0 && com.tencent.imcore.message.report.a.d()) {
            w3.putExtra("enter_from_for_preload", "2");
        }
        int i16 = profileCardInfo.allInOne.chatEntrance;
        if (i16 != 0) {
            w3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, i16);
        }
        String callNickName = getCallNickName(profileCardInfo, qQAppInterface);
        w3.putExtra("uinname", callNickName == null ? "" : callNickName);
        if (!TextUtils.isEmpty(profileCardInfo.allInOne.troopUin)) {
            w3.putExtra("troop_uin", profileCardInfo.allInOne.troopUin);
        } else if (!TextUtils.isEmpty(profileCardInfo.allInOne.discussUin)) {
            w3.putExtra("troop_uin", profileCardInfo.allInOne.discussUin);
        }
        if (!TextUtils.isEmpty(profileCardInfo.allInOne.troopCode)) {
            w3.putExtra(AppConstants.Key.TROOP_CODE, profileCardInfo.allInOne.troopCode);
        }
        if (i3 == 1009) {
            w3.putExtra(AppConstants.Key.KYE_RICH_STATUS_SIG, profileCardInfo.allInOne.chatCookie);
        }
        if (i3 == 1001) {
            w3.putExtra(AppConstants.Key.KYE_RICH_ACCOST_SIG, profileCardInfo.allInOne.chatCookie);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", Utils.U(profileCardInfo.allInOne.uin), Utils.U(callNickName), Utils.e(profileCardInfo.allInOne.chatCookie)));
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(profileCardInfo.allInOne.uin), TAG);
        if (friendsSimpleInfoWithUid != null && (CrmUtils.s(friendsSimpleInfoWithUid.e().byteValue()) || QidianManager.O(friendsSimpleInfoWithUid.e().byteValue()))) {
            w3.putExtra("chat_subType", 1);
        }
        w3.putExtra("hidden_aio_msg_source", 2);
        ProfileCardUtils.enterNTAio(qBaseActivity, w3, str);
    }
}
