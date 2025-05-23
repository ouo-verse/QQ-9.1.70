package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ap;
import com.tencent.mobileqq.activity.aio.tips.e;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import cooperation.qzone.QZoneHelper;
import ed1.b;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class RecentItemPublicAccountChatMsgData extends RecentItemChatMsgData {
    static IPatchRedirector $redirector_;
    private boolean isNewKandian;
    public String mReportKeyBytesOacMsgxtend;

    public RecentItemPublicAccountChatMsgData(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
            return;
        }
        this.mReportKeyBytesOacMsgxtend = "";
        boolean equals = TextUtils.equals(recentUser.uin, AppConstants.NEW_KANDIAN_UIN);
        this.isNewKandian = equals;
        if (equals) {
            this.mUnreadFlag = 2;
        }
    }

    private void P(AbsStructMsg absStructMsg, Context context) {
        if (absStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.suh)) || absStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.sun)) || absStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.sue)) || absStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.suq)) || absStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.sut)) || absStructMsg.mOrangeWord.equalsIgnoreCase(String.format(context.getString(R.string.f171313dz1), Integer.valueOf(this.mUnreadNum)))) {
            this.mMsgExtroInfo = "";
        }
    }

    private void Q(QQAppInterface qQAppInterface, Message message) {
        String str;
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) qQAppInterface.getRuntimeService(IGameMsgBoxManager.class, "");
        if ("2747277822".equals(this.mUser.uin) && iGameMsgManagerService != null && iGameMsgManagerService.isInited()) {
            GameCenterSessionInfo lastSessionInfoExceptDelSession = iGameMsgManagerService.getLastSessionInfoExceptDelSession();
            if (lastSessionInfoExceptDelSession != null) {
                str = lastSessionInfoExceptDelSession.m();
            } else {
                str = "-1";
            }
            if (b.c(iGameMsgManagerService, iGameMsgBoxManager, str, qQAppInterface, this.msgSummary, this)) {
                return;
            }
            b.a(qQAppInterface, message, this.msgSummary, this);
        }
    }

    private void R(Message message) {
        if (message != null && message.getMessageText() != null) {
            this.mDisplayTime = message.time;
        } else {
            this.mDisplayTime = this.mUser.lastmsgtime;
        }
    }

    public static PublicAccountInfo T(QQAppInterface qQAppInterface, IPublicAccountDataManager iPublicAccountDataManager, String str) {
        if (iPublicAccountDataManager != null) {
            return (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str);
        }
        return null;
    }

    private void U(Message message) {
        JSONObject jSONObject;
        if (message != null && (jSONObject = message.mExJsonObject) != null) {
            this.mReportKeyBytesOacMsgxtend = jSONObject.optString(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND, null);
        }
    }

    private void V(QQAppInterface qQAppInterface, Message message, PublicAccountInfo publicAccountInfo, IPublicAccountDataManager iPublicAccountDataManager) {
        if (publicAccountInfo == null && iPublicAccountDataManager != null) {
            IPublicAccountDetail findAccountDetailInfo = iPublicAccountDataManager.findAccountDetailInfo(this.mUser.uin);
            if (findAccountDetailInfo != null) {
                this.mTitleName = findAccountDetailInfo.getName();
            }
            if (this.isNewKandian) {
                this.mTitleName = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(qQAppInterface, qQAppInterface.getApp());
            }
        }
        if (publicAccountInfo != null) {
            this.mTitleName = publicAccountInfo.name;
            this.mAuthenIconId = 0;
        } else {
            this.mAuthenIconId = 0;
        }
    }

    private void X(QQAppInterface qQAppInterface) {
        if (!this.isNewKandian && ServiceAccountFolderManager.k(qQAppInterface, this.mUser.uin)) {
            ConversationFacade conversationFacade = qQAppInterface.getConversationFacade();
            RecentUser recentUser = this.mUser;
            int F = conversationFacade.F(recentUser.uin, recentUser.getType());
            if (this.mUnreadNum > 0) {
                if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.mUser.uin)) {
                    if (F > 0) {
                        this.mUnreadNum = 1;
                        this.mUnreadFlag = 2;
                        return;
                    } else {
                        this.mUnreadFlag = 1;
                        return;
                    }
                }
                if (!AppConstants.KANDIAN_DAILY_UIN.equals(this.mUser.uin) && !AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(this.mUser.uin)) {
                    int i3 = this.mUnreadNum;
                    if (i3 == 1 && F > 0) {
                        this.mUnreadFlag = 2;
                        return;
                    } else {
                        if (F > 0) {
                            this.mUnreadNum = i3 - 1;
                            this.mUnreadFlag = 1;
                            return;
                        }
                        return;
                    }
                }
                if (F > 0) {
                    this.mUnreadFlag = 2;
                } else {
                    this.mUnreadFlag = 1;
                }
            }
        }
    }

    private void Y(Message message) {
        if (message != null && "2909288299".equals(this.mUser.uin) && this.mUnreadNum > 0) {
            String extInfoFromExtStr = message.getExtInfoFromExtStr("news_has_report");
            if (TextUtils.isEmpty(extInfoFromExtStr) || !"1".equals(extInfoFromExtStr)) {
                message.saveExtInfoToExtStr("news_has_report", "1");
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentItemPublicAccountChatMsgData.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AppRuntime appRuntime;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                        if (application != null) {
                            appRuntime = application.peekAppRuntime();
                        } else {
                            appRuntime = null;
                        }
                        ReportController.o(appRuntime, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8007054", "0X8007054", 0, 0, "", "", "", "");
                    }
                }, 10000L);
            }
        }
    }

    private void Z(QQAppInterface qQAppInterface, Message message) {
        boolean z16;
        if (this.mUnreadNum > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        SpannableString b16 = a23.a.b(qQAppInterface, message, z16);
        if (b16 != null) {
            this.msgSummary.strContent = b16;
        }
        e.a b17 = e.b(qQAppInterface, this.mUser.uin);
        if (b17 != null && b17.f180127n == message.uniseq && b17.a()) {
            ThreadManagerV2.post(new Runnable(qQAppInterface, b17) { // from class: com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f185394d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ e.a f185395e;

                {
                    this.f185394d = qQAppInterface;
                    this.f185395e = b17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, RecentItemPublicAccountChatMsgData.this, qQAppInterface, b17);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        e.d(this.f185394d, RecentItemPublicAccountChatMsgData.this.mUser.uin, this.f185395e, null);
                    }
                }
            }, 2, null, false);
        }
    }

    private boolean a0(QQAppInterface qQAppInterface, Context context, Message message, QQMessageFacade qQMessageFacade, int i3) {
        ArrayList<PAMessage.Item> arrayList;
        if (i3 != -3006 && i3 != -5004) {
            buildMessageBody(message, this.mUser.getType(), qQAppInterface, context, this.msgSummary);
            if (i3 == -2025 && this.mUnreadNum > 0 && ServiceAccountFolderManager.k(qQAppInterface, this.mUser.uin)) {
                this.mExtraInfoColor = -881592;
                this.mMsgExtroInfo = message.f203106msg;
                this.msgSummary.strContent = "";
            } else {
                this.mMsgExtroInfo = "";
                this.mExtraInfoColor = 0;
                if (this.isNewKandian) {
                    if (b0(qQAppInterface, context, qQMessageFacade)) {
                        return true;
                    }
                } else if (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.mUser.uin) && !AppConstants.KANDIAN_DAILY_UIN.equals(this.mUser.uin) && !AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(this.mUser.uin)) {
                    if (AppConstants.VALUE.UIN_QZONE.equals(this.mUser.uin) && QZoneHelper.enableQZoneContextBox(qQAppInterface)) {
                        c0(message);
                    } else {
                        Z(qQAppInterface, message);
                    }
                } else {
                    d0(context, message);
                }
            }
        } else {
            this.msgSummary.strContent = "";
            PAMessage b16 = ap.b(message);
            if (b16 != null && (arrayList = b16.items) != null && arrayList.size() != 0) {
                String str = b16.items.get(0).title;
                if (b16.items.get(0).cover == null && b16.items.get(0).digestList != null) {
                    str = str + MsgSummary.STR_COLON + b16.items.get(0).digestList.get(0);
                }
                this.msgSummary.strContent = str;
            } else {
                buildMessageBody(message, this.mUser.getType(), qQAppInterface, context, this.msgSummary);
            }
        }
        com.tencent.mobileqq.activity.recent.config.recent.a.a(this);
        return false;
    }

    private boolean b0(QQAppInterface qQAppInterface, Context context, QQMessageFacade qQMessageFacade) {
        AbsStructMsg absStructMsg;
        RecentUser recentUser = this.mUser;
        MessageRecord x16 = qQMessageFacade.x1(recentUser.uin, recentUser.getType());
        if (x16 != null && (x16 instanceof MessageForStructing)) {
            MessageForStructing messageForStructing = (MessageForStructing) x16;
            if (messageForStructing.structingMsg == null) {
                messageForStructing.parse();
            }
            if (this.mUnreadNum > 0 && (absStructMsg = messageForStructing.structingMsg) != null && !TextUtils.isEmpty(absStructMsg.mOrangeWord)) {
                if (messageForStructing.structingMsg.mOrangeWord.length() >= 8) {
                    this.mMsgExtroInfo = "[" + messageForStructing.structingMsg.mOrangeWord.substring(0, 8) + "]";
                } else {
                    this.mMsgExtroInfo = "[" + messageForStructing.structingMsg.mOrangeWord + "]";
                }
                P(messageForStructing.structingMsg, context);
                this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
            }
        }
        com.tencent.mobileqq.activity.recent.config.recent.a.a(this);
        return false;
    }

    private void c0(Message message) {
        String extInfoFromExtStr = message.getExtInfoFromExtStr("qzone_msg_box_promot");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            this.msgSummary.strContent = extInfoFromExtStr;
        }
    }

    private void d0(Context context, Message message) {
        MessageForStructing messageForStructing;
        AbsStructMsg absStructMsg;
        MessageRecord messageRecord = message.lastMsg;
        if (messageRecord instanceof MessageForStructing) {
            messageForStructing = (MessageForStructing) messageRecord;
            if (!messageForStructing.mIsParsed) {
                messageForStructing.parse();
            }
        } else if (message.msgtype == -2011) {
            messageForStructing = new MessageForStructing();
            messageForStructing.msgData = message.msgData;
            messageForStructing.parse();
            message.lastMsg = messageForStructing;
        } else {
            messageForStructing = null;
        }
        if (messageForStructing != null && (absStructMsg = messageForStructing.structingMsg) != null) {
            MsgSummary msgSummary = this.msgSummary;
            msgSummary.strContent = absStructMsg.mMsgBrief;
            msgSummary.suffix = "";
            if (!TextUtils.isEmpty(absStructMsg.mOrangeWord) && this.mUnreadNum > 0) {
                this.mMsgExtroInfo = "[" + messageForStructing.structingMsg.mOrangeWord + "]";
                P(messageForStructing.structingMsg, context);
                this.mExtraInfoColor = -881592;
            }
        }
    }

    private void e0() {
        if (AppConstants.WEISHI_UIN.equals(this.mUser.uin)) {
            ((IWeiShiReportUtil) QRoute.api(IWeiShiReportUtil.class)).reportMsgExposure(this, 9);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
    protected void N(QQAppInterface qQAppInterface, Context context, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, context, message);
            return;
        }
        if (message != null && a0(qQAppInterface, context, message, qQAppInterface.getMessageFacade(), message.msgtype)) {
            return;
        }
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        V(qQAppInterface, message, T(qQAppInterface, iPublicAccountDataManager, this.mUser.uin), iPublicAccountDataManager);
        R(message);
        Q(qQAppInterface, message);
        X(qQAppInterface);
        U(message);
        e0();
        ((IWSManager) QRoute.api(IWSManager.class)).preloadData();
        W();
        Y(message);
        com.tencent.mobileqq.activity.recent.config.recent.a.a(this);
    }

    public Message S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Message) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f185392msg;
    }

    private void W() {
    }
}
