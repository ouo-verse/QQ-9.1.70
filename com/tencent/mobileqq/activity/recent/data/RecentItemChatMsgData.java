package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation$NotParcel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.nthiddenchat.b;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentItemChatMsgData extends RecentItemChatMsgBaseData {
    static IPatchRedirector $redirector_ = null;
    private static final String IS_LAST_RECEIPT = "lastIsReceipt";
    private static final String IS_SIGN_MSG = "IS_SIGN_MSG";
    private static final String IS_SPECIAL_CARE_FRIEND = "isSpecialCareFriend";
    private static final String TAG = "RecentItemChatMsgData";

    @ParcelAnnotation$NotParcel
    private static ArrayList<Integer> sC2CLikeUINType;
    public int haloState;
    public int mBubbleID;
    public String mQimIconUrl;
    public int mQimOnline;

    /* renamed from: msg, reason: collision with root package name */
    @ParcelAnnotation$NotParcel
    protected Message f185392msg;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69251);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            sC2CLikeUINType = new ArrayList<Integer>(32) { // from class: com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData.1
                static IPatchRedirector $redirector_;

                {
                    super(r4);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, r4);
                        return;
                    }
                    add(0);
                    add(1000);
                    add(1020);
                    add(1003);
                    add(1005);
                    add(1004);
                    add(1022);
                    add(1023);
                    add(1024);
                    add(1025);
                    add(Integer.valueOf(AppConstants.VALUE.UIN_TYPE_DINGDONG_MSG_SESSION));
                    add(10004);
                    add(10005);
                    add(1044);
                    add(1045);
                    add(10007);
                    add(10008);
                    add(10010);
                }
            };
        }
    }

    public RecentItemChatMsgData(RecentUser recentUser) {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        }
    }

    private void A(QQAppInterface qQAppInterface, Context context) {
        Message message = this.f185392msg;
        if (message != null && message.msgtype == -1034) {
            if (com.tencent.mobileqq.activity.recent.config.recent.a.d()) {
                com.tencent.mobileqq.activity.recent.config.recent.a.c(this);
                return;
            }
            MessageForRichState messageForRichState = new MessageForRichState();
            messageForRichState.f203106msg = this.f185392msg.f203106msg;
            messageForRichState.mIsParsed = false;
            messageForRichState.parse();
            if (qQAppInterface.getMsgCache().x0(this.f185392msg.frienduin) < messageForRichState.time) {
                this.mMsgExtroInfo = HardCodeUtil.qqStr(R.string.sup);
                this.mExtraInfoColor = context.getResources().getColor(R.color.skin_gray2_theme_version2);
            } else {
                this.mMsgExtroInfo = HardCodeUtil.qqStr(R.string.suo);
                this.mExtraInfoColor = context.getResources().getColor(R.color.skin_gray2);
            }
            g(IS_SIGN_MSG, true);
        }
    }

    private void B(QQAppInterface qQAppInterface, Context context) {
        if (this.mUser.getType() != 0) {
            l();
            this.mTitleName = ac.g(qQAppInterface, this.mUser.uin, true);
            buildMessageBody(this.f185392msg, this.mUser.getType(), qQAppInterface, context, this.msgSummary);
        }
    }

    private void C(Context context) {
        String str;
        Message message = this.f185392msg;
        if (message != null && message.msgtype == -2025) {
            if (this.mUnreadNum > 0) {
                String string = context.getString(R.string.bpq);
                String str2 = this.f185392msg.f203106msg;
                if (!TextUtils.isEmpty(str2) && str2.startsWith(string)) {
                    this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
                    if (TextUtils.isEmpty(this.mMsgExtroInfo)) {
                        str = string;
                    } else {
                        str = ((Object) this.mMsgExtroInfo) + string;
                    }
                    this.mMsgExtroInfo = str;
                    this.msgSummary.strContent = str2.replace(string, "");
                    com.tencent.mobileqq.activity.recent.config.recent.a.b(this);
                    return;
                }
                return;
            }
            this.mMsgExtroInfo = "";
        }
    }

    private void D(Context context) {
        Message message;
        boolean a16 = a(IS_LAST_RECEIPT, false);
        if (a16 && this.mUnreadNum > 0) {
            Object obj = this.mUser.f203116msg;
            if ((obj instanceof MessageRecord) && !((MessageRecord) obj).isread) {
                this.msgSummary.suffix = "";
            }
        }
        if (!a16) {
            Object obj2 = this.mUser.f203116msg;
            if ((obj2 instanceof MessageForStructing) && (message = this.f185392msg) != null && message.msgtype != -1034) {
                MessageForStructing messageForStructing = (MessageForStructing) obj2;
                if (!messageForStructing.isread && messageForStructing.structingMsg.mMsgServiceID == 107) {
                    r(context, message, messageForStructing);
                }
            }
        }
    }

    private void E() {
        Message message;
        String str;
        if (AppConstants.VOTE_MSG_UIN.equals(this.mUser.uin) && (message = this.f185392msg) != null && (str = message.f203106msg) != null) {
            this.msgSummary.strContent = str;
        }
    }

    private void F(QQAppInterface qQAppInterface, Context context) {
        if (this.mUser.getType() == 0 && ((INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class)).isNewFriend(this.mUser.uin)) {
            this.mMsgExtroInfo = context.getString(R.string.f170792m0);
            this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
            com.tencent.mobileqq.activity.recent.config.recent.a.b(this);
        }
    }

    private void G(QQAppInterface qQAppInterface, Context context) {
        boolean A = MessageNotificationSettingManager.l(qQAppInterface).A(this.mUser.uin);
        g(IS_SPECIAL_CARE_FRIEND, A);
        if (this.mUnreadNum > 0 && A) {
            this.mMsgExtroInfo = context.getString(R.string.g95);
            this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
            com.tencent.mobileqq.activity.recent.config.recent.a.b(this);
        }
    }

    private void H(QQAppInterface qQAppInterface) {
        com.tencent.mobileqq.activity.recent.msgbox.tempchat.a tempChatPlugin = ((ITempChatPluginManager) qQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(getRecentUserType());
        if (tempChatPlugin != null) {
            this.mTitleName = tempChatPlugin.c(getRecentUserUin());
        }
    }

    private void J() {
        this.mTitleName = HardCodeUtil.qqStr(R.string.sur);
        this.msgSummary.strContent = "\u53ef\u8fde\u63a5ArkIDE\u8fdb\u884c\u771f\u673a\u8c03\u8bd5";
        this.mUnreadNum = 0;
    }

    private void K(QQAppInterface qQAppInterface, Context context) {
        B(qQAppInterface, context);
        G(qQAppInterface, context);
        F(qQAppInterface, context);
        z(qQAppInterface, context);
        u(qQAppInterface, context);
        v(qQAppInterface, context);
        D(context);
        A(qQAppInterface, context);
        w(context);
        E();
        x(context);
        C(context);
        y(qQAppInterface);
        H(qQAppInterface);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if (r8.msgData != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void L(QQAppInterface qQAppInterface, Context context) {
        this.mTitleName = ac.g(qQAppInterface, this.mUser.uin, true);
        buildMessageBody(this.f185392msg, this.mUser.getType(), qQAppInterface, context, this.msgSummary);
        Message message = this.f185392msg;
        if (message != null) {
            if (message.getMessageText() == null) {
                Message message2 = this.f185392msg;
                if (message2.msgtype == -2011) {
                }
            }
            this.mDisplayTime = this.f185392msg.time;
            return;
        }
        this.mDisplayTime = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        if (r8.msgData != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void M(QQAppInterface qQAppInterface, Context context) {
        PhoneContact phoneContact;
        String m06 = ac.m0(qQAppInterface, this.mUser.uin);
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null) {
            phoneContact = iPhoneContactService.queryContactByCodeNumber(this.mUser.uin);
        } else {
            phoneContact = null;
        }
        if (phoneContact != null) {
            this.mTitleName = phoneContact.name;
        } else if (m06 != null) {
            this.mTitleName = ac.g(qQAppInterface, m06, true);
        } else {
            this.mTitleName = this.mUser.uin;
        }
        buildMessageBody(this.f185392msg, this.mUser.getType(), qQAppInterface, context, this.msgSummary);
        Message message = this.f185392msg;
        if (message != null) {
            if (message.getMessageText() == null) {
                Message message2 = this.f185392msg;
                if (message2.msgtype == -2011) {
                }
            }
            this.mDisplayTime = this.f185392msg.time;
            return;
        }
        this.mDisplayTime = 0L;
    }

    private void O(QQAppInterface qQAppInterface, Context context, Message message) {
        List<MessageRecord> list;
        MessageRecord messageRecord;
        String str;
        IRecommendTroopService iRecommendTroopService;
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        this.mTitleName = context.getString(R.string.f171314e00);
        if (messageFacade != null) {
            list = messageFacade.Q(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
        } else {
            list = null;
        }
        String str2 = "";
        if (list != null && list.size() > 0 && (str = (messageRecord = list.get(list.size() - 1)).f203106msg) != null) {
            int i3 = messageRecord.msgtype;
            if (i3 == -1033) {
                str2 = HardCodeUtil.qqStr(R.string.su7) + str;
            } else if (i3 == -1030) {
                str2 = HardCodeUtil.qqStr(R.string.su_) + "";
            } else if (i3 == -1039) {
                IRecommendTroopService iRecommendTroopService2 = (IRecommendTroopService) qQAppInterface.getRuntimeService(IRecommendTroopService.class, "");
                if (iRecommendTroopService2 != null) {
                    str2 = context.getResources().getString(R.string.f171315e02) + iRecommendTroopService2.getLastMessage();
                }
            } else if (i3 == -1040 && (iRecommendTroopService = (IRecommendTroopService) qQAppInterface.getRuntimeService(IRecommendTroopService.class, "")) != null) {
                str2 = iRecommendTroopService.getLastMessage();
            }
        }
        this.msgSummary.strContent = str2;
        if (message != null && message.getMessageText() != null) {
            this.mDisplayTime = message.time;
        } else {
            this.mDisplayTime = 0L;
        }
    }

    private void m(QQAppInterface qQAppInterface, Context context) {
        int type = this.mUser.getType();
        if (sC2CLikeUINType.contains(Integer.valueOf(type))) {
            K(qQAppInterface, context);
            return;
        }
        if (type != 1006) {
            if (type != 1008) {
                if (type != 1021) {
                    if (type != 1031) {
                        if (type == 4000) {
                            O(qQAppInterface, context, this.f185392msg);
                            return;
                        }
                        return;
                    }
                    J();
                    return;
                }
                L(qQAppInterface, context);
                return;
            }
            N(qQAppInterface, context, this.f185392msg);
            return;
        }
        M(qQAppInterface, context);
    }

    private void n(QQAppInterface qQAppInterface) {
        if (this.mUnreadNum > 0) {
            this.mBubbleID = ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getBubbleIdFromMessageRecord(this.f185392msg);
        } else {
            this.mBubbleID = 0;
        }
    }

    private void o() {
        boolean z16;
        int type = this.mUser.getType();
        try {
            if (type != 0 && type != 1000 && type != 1021 && type != 10004 && type != 10008 && type != 10010) {
                switch (type) {
                    case 1004:
                    case 1005:
                    case 1006:
                        break;
                    default:
                        z16 = false;
                        break;
                }
                g(RecentItemChatMsgBaseData.IS_ENABLE_UNREAD_STATE, z16);
                return;
            }
            g(RecentItemChatMsgBaseData.IS_ENABLE_UNREAD_STATE, z16);
            return;
        } catch (Exception e16) {
            QLog.i(TAG, 1, "handleBusinessUnreadMenu", e16);
            return;
        }
        z16 = true;
    }

    private void p(QQAppInterface qQAppInterface, Context context) {
        Message message = this.f185392msg;
        if (message != null) {
            f.c l3 = f.l(qQAppInterface, message.frienduin, message.istroop, this.mUnreadNum, message);
            this.mUnreadNum += l3.a();
            if (l3.a() > 0) {
                this.mMsgExtroInfo = l3.b();
                this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
            }
        }
    }

    private void q(QQAppInterface qQAppInterface, Context context) {
        if (t(this.f185392msg)) {
            if (com.tencent.mobileqq.activity.recent.config.recent.a.d()) {
                com.tencent.mobileqq.activity.recent.config.recent.a.c(this);
                return;
            }
            FeedsManager feedsManager = (FeedsManager) qQAppInterface.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER);
            String summary = feedsManager.getSummary(getRecentUserUin());
            if (!TextUtils.isEmpty(summary)) {
                this.msgSummary.strContent = summary;
                this.mMsgExtroInfo = HardCodeUtil.qqStr(R.string.su5);
                this.mExtraInfoColor = context.getResources().getColor(R.color.skin_gray2_theme_version2);
                if (!FeedsManager.isShowStatus(getRecentUserUin())) {
                    FeedsManager.showStatus(getRecentUserUin());
                }
                feedsManager.reportExposeStatus(getRecentUserUin());
                return;
            }
            FeedsManager.hideStatus(getRecentUserUin());
        }
    }

    private void r(Context context, Message message, MessageForStructing messageForStructing) {
        if (com.tencent.mobileqq.activity.recent.config.recent.a.d()) {
            com.tencent.mobileqq.activity.recent.config.recent.a.c(this);
            return;
        }
        String str = messageForStructing.structingMsg.mMsgBrief;
        String string = context.getString(R.string.f171480f83);
        if (!messageForStructing.isread && !TextUtils.isEmpty(str)) {
            this.mMsgExtroInfo = string;
        } else {
            this.mMsgExtroInfo = "";
        }
        message.f203106msg = str;
        this.mExtraInfoColor = context.getResources().getColor(R.color.ahc);
    }

    private void s(QQAppInterface qQAppInterface, Context context) {
        FeedsManager.hideStatus(getRecentUserUin());
        if (this.msgSummary.bShowDraft && a(IS_SIGN_MSG, false)) {
            this.msgSummary.strContent = "";
            this.mMsgExtroInfo = "";
        } else {
            q(qQAppInterface, context);
        }
    }

    private boolean t(Message message) {
        if (this.mUser.getType() == 0 && TextUtils.isEmpty(this.mMsgExtroInfo) && getUnreadNum() <= 0 && this.mStatus == 0) {
            MsgSummary msgSummary = this.msgSummary;
            if (msgSummary.nState == 0 && ((message == null || message.msgtype != -5040) && msgSummary.suffix == null && msgSummary.strPrefix == null)) {
                return true;
            }
        }
        return false;
    }

    private void u(QQAppInterface qQAppInterface, Context context) {
        if (AppConstants.QQBROADCAST_MSG_UIN.equals(this.mUser.uin)) {
            this.mTitleName = context.getString(R.string.hub);
            return;
        }
        if (AppConstants.VOTE_MSG_UIN.equals(this.mUser.uin)) {
            this.mTitleName = context.getString(R.string.f173190hw4);
            return;
        }
        if (this.mUser.getType() == 1000) {
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null) {
                String G = troopManager.G(this.mUser.troopUin);
                RecentUser recentUser = this.mUser;
                this.mTitleName = ac.j0(qQAppInterface, recentUser.uin, G, recentUser.troopUin, true, null);
                return;
            }
            return;
        }
        if (this.mUser.getType() == 1004) {
            RecentUser recentUser2 = this.mUser;
            String n3 = ac.n(qQAppInterface, recentUser2.troopUin, recentUser2.uin);
            this.mTitleName = n3;
            if (n3 != null && n3.equals(this.mUser.uin)) {
                this.mTitleName = ac.g(qQAppInterface, this.mUser.uin, true);
                return;
            }
            return;
        }
        if (this.mUser.getType() == 10007 && !AppConstants.GAME_MSG_BOX_UIN.equals(this.mUser.uin)) {
            this.mTitleName = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(this.mUser.uin, qQAppInterface);
            return;
        }
        if (h.o() && h.k(this.mUser.uin)) {
            String g16 = ac.g(qQAppInterface, this.mUser.uin, true);
            this.mTitleName = g16;
            if (g16 != null && g16.equals(this.mUser.uin)) {
                this.mTitleName = context.getString(R.string.f187533u9);
                return;
            }
            return;
        }
        this.mTitleName = ac.g(qQAppInterface, this.mUser.uin, true);
    }

    private void v(QQAppInterface qQAppInterface, Context context) {
        this.mUnreadFlag = 1;
        if (FriendsStatusUtil.k(this.mUser.uin, qQAppInterface)) {
            this.mUnreadFlag = 3;
        }
        RecentUser recentUser = this.mUser;
        boolean h16 = b.h(recentUser.uin, recentUser.getType(), qQAppInterface);
        if (h16 && !com.tencent.mobileqq.app.hiddenchat.b.b(qQAppInterface.getCurrentUin(), context)) {
            this.mUnreadFlag = 0;
        } else if (h16) {
            this.mUnreadFlag = 3;
        }
    }

    private void w(Context context) {
        Message message = this.f185392msg;
        if (message != null && message.msgtype == -2074) {
            MessageForAIOStoryVideo messageForAIOStoryVideo = new MessageForAIOStoryVideo();
            messageForAIOStoryVideo.f203106msg = this.f185392msg.f203106msg;
            messageForAIOStoryVideo.mIsParsed = false;
            messageForAIOStoryVideo.parse();
            this.mMsgExtroInfo = HardCodeUtil.qqStr(R.string.f172621su1);
            this.mExtraInfoColor = context.getResources().getColor(R.color.skin_gray2);
        }
    }

    private void x(Context context) {
        Message message = this.f185392msg;
        if (message != null && message.msgtype == -2040) {
            MessageForApproval messageForApproval = new MessageForApproval();
            messageForApproval.msgData = this.f185392msg.msgData;
            this.msgSummary.strContent = messageForApproval.getFullTitle();
        }
        Message message2 = this.f185392msg;
        if (message2 != null && message2.msgtype == -2041) {
            String string = context.getString(R.string.f170422q2);
            String string2 = context.getString(R.string.f170421pz);
            this.msgSummary.strContent = string + " " + string2;
        }
    }

    private void y(QQAppInterface qQAppInterface) {
        if (this.mUser.getType() == 1024 && !QidianManager.P(qQAppInterface, this.mUser.uin)) {
            this.mAuthenIconId = CrmUtils.p(qQAppInterface, this.mUser.uin);
        }
        if (Utils.G(this.mUser.uin)) {
            this.mAuthenIconId = R.drawable.br7;
        }
    }

    private void z(QQAppInterface qQAppInterface, Context context) {
        Message message = this.f185392msg;
        if (message != null) {
            if (message.getMessageText() == null) {
                Message message2 = this.f185392msg;
                if (message2.msgData == null && (message2.msgtype != -2011 || this.mUser.getType() != 0)) {
                    return;
                }
            }
            this.mDisplayTime = this.f185392msg.time;
            if (this.mDisplayTime == 0) {
                this.mDisplayTime = this.mUser.opTime;
            }
            QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
            if (this.f185392msg.msgtype == -2011) {
                long j3 = qQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + qQAppInterface.getCurrentAccountUin(), 0).getLong("uid" + this.f185392msg.frienduin, 0L);
                RecentUser recentUser = this.mUser;
                MessageRecord x16 = messageFacade.x1(recentUser.uin, recentUser.getType());
                if (x16 != null && (x16 instanceof MessageForStructing)) {
                    MessageForStructing messageForStructing = (MessageForStructing) x16;
                    if (messageForStructing.structingMsg == null) {
                        messageForStructing.parse();
                    }
                    AbsStructMsg absStructMsg = messageForStructing.structingMsg;
                    if (absStructMsg != null) {
                        if (j3 == this.f185392msg.msgUid && absStructMsg.mMsgServiceID == 76) {
                            String str = absStructMsg.mMsgBrief;
                            String string = context.getString(R.string.esv);
                            if (!x16.isread && !TextUtils.isEmpty(str) && str.startsWith(string)) {
                                this.mMsgExtroInfo = string;
                                this.f185392msg.f203106msg = str.substring(string.length());
                            } else {
                                this.mMsgExtroInfo = "";
                                this.f185392msg.f203106msg = str;
                            }
                            this.mExtraInfoColor = context.getResources().getColor(R.color.skin_gray2_theme_version2);
                            buildMessageBody(this.f185392msg, this.mUser.getType(), qQAppInterface, context, this.msgSummary);
                            return;
                        }
                        if (absStructMsg.mMsgServiceID == 107 && !a(IS_SPECIAL_CARE_FRIEND, false)) {
                            r(context, this.f185392msg, messageForStructing);
                            this.mUser.f203116msg = messageForStructing;
                            g(IS_LAST_RECEIPT, true);
                            buildMessageBody(this.f185392msg, this.mUser.getType(), qQAppInterface, context, this.msgSummary);
                        }
                    }
                }
            }
        }
    }

    public void I(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        if (qQAppInterface != null && context != null) {
            super.update(qQAppInterface, context);
            this.f185392msg = null;
            Message message = this.mLastMessage;
            if (message instanceof Message) {
                this.f185392msg = message;
            }
            p(qQAppInterface, context);
            o();
            m(qQAppInterface, context);
            s(qQAppInterface, context);
            n(qQAppInterface);
            extraUpdate(qQAppInterface, context, this.msgSummary);
            processUnReadNum(context.getResources().getColor(R.color.skin_gray2_theme_version2), 99);
        }
    }

    protected void N(QQAppInterface qQAppInterface, Context context, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, context, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void processUnReadNum(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
                return;
            }
            super.processUnReadNum(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgBaseData, com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public final void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) context);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            I((QQAppInterface) baseQQAppInterface, context);
        }
    }
}
