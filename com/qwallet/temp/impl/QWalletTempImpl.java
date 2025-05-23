package com.qwallet.temp.impl;

import Wallet.AcsMsg;
import Wallet.PfaFriendRqt;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.activateFriend.y;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.i;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.cl;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.openapi.sdk.f;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.o;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ak;
import com.tencent.mobileqq.widget.ba;
import com.tencent.qphone.base.util.QLog;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.oidb.cmd0x857.TroopTips0x857$GoldMsgTipsElem;
import tencent.im.oidb.cmd0x857.TroopTips0x857$NotifyMsgBody;
import tk2.GoldMsgTipsElemBean;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QWalletTempImpl implements IQWalletTemp {
    private static final String TAG = "QWalletTempImpl";
    private ar mFriendListObserver;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d4.a f41763d;

        a(d4.a aVar) {
            this.f41763d = aVar;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            this.f41763d.loaded(str, i3);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            this.f41763d.progress(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends ar {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d4.b f41765d;

        b(d4.b bVar) {
            this.f41765d = bVar;
        }

        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendInfo(String str, boolean z16) {
            this.f41765d.a(str, z16);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void addAndSendMessage(AppRuntime appRuntime, MessageRecord messageRecord, BaseMessageObserver baseMessageObserver) {
        if ((appRuntime instanceof QQAppInterface) && (baseMessageObserver instanceof bs)) {
            ((QQAppInterface) appRuntime).getMessageFacade().a(messageRecord, baseMessageObserver);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void addQBaseActivityObserver(QBaseActivity qBaseActivity, d4.b bVar) {
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            b bVar2 = new b(bVar);
            this.mFriendListObserver = bVar2;
            ((AppInterface) appRuntime).addObserver(bVar2);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void checkUpByBusinessId(String str, AppRuntime appRuntime, boolean z16, d4.a aVar) {
        HtmlOffline.j(str, appRuntime, z16, new a(aVar));
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public MessageRecord createMsgRecordByMsgType(int i3) {
        return q.d(i3);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public Dialog createNewUpgradeYYBInstalledDialog(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        return ak.d(context, str, str2, str3, onClickListener, str4, onClickListener2);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public Animation createRotate3dAnimation(float f16, float f17, float f18, float f19, float f26, boolean z16) {
        return new ba(f16, f17, f18, f19, f26, z16);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void decodePBMsgElemsRichMsg(Object obj, List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        if (obj instanceof o) {
            ((o) obj).m(list, list2, sb5, msg_comm_msg, cVar);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void decodePBMsgElemsText(Object obj, List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        if (obj instanceof o) {
            ((o) obj).n(list, list2, sb5, msg_comm_msg, cVar);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getAppInfoFromHistory() {
        String str = "getAppInfoFromHistory: ";
        try {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            if (application != null) {
                for (int size = application.appActivities.size() - 1; size >= 0; size--) {
                    WeakReference<AppActivity> weakReference = application.appActivities.get(size);
                    if (weakReference != null) {
                        AppActivity appActivity = weakReference.get();
                        if (appActivity instanceof QQBrowserActivity) {
                            String appInfoFromHistory = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getAppInfoFromHistory(((QQBrowserActivity) appActivity).getHostWebView());
                            if (TextUtils.isEmpty(appInfoFromHistory)) {
                                continue;
                            } else {
                                try {
                                    return URLDecoder.decode(appInfoFromHistory, "UTF-8");
                                } catch (UnsupportedEncodingException e16) {
                                    QLog.e(TAG, 1, str, e16);
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable th5) {
            QLog.e(TAG, 1, str, th5);
            return "";
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getCJ2021AvGamePreloadModuleName() {
        return "2022_cjavgame";
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public View getChatXListViewFromChatFragment(QBaseActivity qBaseActivity) {
        a61.c cVar;
        if (!(qBaseActivity instanceof BaseActivity)) {
            return null;
        }
        BaseActivity baseActivity = (BaseActivity) qBaseActivity;
        if (baseActivity.getChatFragment() == null || (cVar = baseActivity.getChatFragment().C) == null) {
            return null;
        }
        return cVar.f25584i;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getConfig(BaseQQAppInterface baseQQAppInterface, String str) {
        BridgeHelper b16 = BridgeHelper.b(baseQQAppInterface.getApp(), baseQQAppInterface.getCurrentAccountUin());
        if (b16 == null) {
            return null;
        }
        return b16.a(str);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getConfigPath() {
        return ConditionSearchManager.t();
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getDiscussMemberName(BaseQQAppInterface baseQQAppInterface, String str, String str2) {
        return ((n) baseQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).l(str, str2).getDiscussionMemberName();
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public int getDiscussionMemberNum(AppRuntime appRuntime, String str) {
        return ((n) appRuntime.getManager(QQManagerFactory.DISCUSSION_MANAGER)).q(str);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public long getFreeSpace(String str) {
        return er2.a.b(str);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public int getGetRecentListType() {
        return 5;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getGroupNicknameByType(AppInterface appInterface, int i3, String str) {
        if (appInterface instanceof QQAppInterface) {
            try {
                if (i3 == 0) {
                    return ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str).troopname;
                }
                if (i3 == 1) {
                    return new n((QQAppInterface) appInterface).h(str).discussionName;
                }
                return "";
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getGroupNicknameByType: ", e16);
                return "";
            }
        }
        return "";
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public int getInnerDnsCFTDomain() {
        return 1011;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public boolean getJumpLock(Context context, String str) {
        return BaseGesturePWDUtil.getJumpLock(context, str);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public ChatMessage getMessageByMID(String str) {
        return com.tencent.mobileqq.activity.aio.item.b.l(str);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getPrefActivateFriends() {
        return QQConstants.PREF_ACTIVATE_FRIENDS;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public Class<? extends Activity> getQQLSUnlockActivityClazz() {
        return QQLSUnlockActivity.class;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getQQNotifyHelperKey(AcsMsg acsMsg) {
        return y.e(acsMsg);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public BusinessObserver getQWalletAuthObserver(Handler handler) {
        return new cl(handler);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getRedPacket2024PreloadModuleName() {
        return "2024_preload_res";
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public String getRedPacket2025PreloadModuleName() {
        return "2025_preload_res";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qwallet.temp.IQWalletTemp
    public int getReportConstantRes(String str) {
        boolean z16;
        str.hashCode();
        switch (str.hashCode()) {
            case -1553871847:
                if (str.equals("RESULT_RES_PRELOAD_SUCC")) {
                    z16 = false;
                    break;
                }
                z16 = -1;
                break;
            case -509700974:
                if (str.equals("RESULT_RES_PRELOAD_FAIL_DOWNLOAD")) {
                    z16 = true;
                    break;
                }
                z16 = -1;
                break;
            case 668698653:
                if (str.equals("RESULT_RES_PRELOAD_FAIL_MD5_CHECK")) {
                    z16 = 2;
                    break;
                }
                z16 = -1;
                break;
            default:
                z16 = -1;
                break;
        }
        switch (z16) {
            case false:
                return 0;
            case true:
                return 1;
            case true:
                return 2;
            default:
                new IllegalArgumentException("constName is illegal\uff01");
                return -1;
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public View getViewByPosition(View view, ChatMessage chatMessage) {
        return a91.c.a(chatMessage, (ChatXListView) view);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public boolean isResultOk(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public boolean isScreenLocked(Context context) {
        return QQUtils.k(context);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public boolean isSplashNotExist() {
        return SplashActivity.sWeakInstance == null || SplashActivity.sWeakInstance.get() == null;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public boolean isTempConv(int i3) {
        return i.a(i3);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public boolean isUpdateNetUnavailable(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public boolean isUpdateOk(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public Bundle newPay(AppInterface appInterface, Activity activity, ResultReceiver resultReceiver, int i3, Bundle bundle) {
        return PayBridgeActivity.newPay(appInterface, activity, resultReceiver, i3, bundle);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public g newQWalletArkNotifyTemp(IQWalletTemp.a aVar) {
        return new com.qwallet.temp.impl.b(aVar);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void onPayMsgRsp(int i3, String str, String str2) {
        OpenApiManager.getInstance().onPayMsgRsp(new f(i3, "ResultCode.RESULT_OK".equals(str) ? 0 : -1000, str2));
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void panelReport(AppRuntime appRuntime, String str, int i3) {
        l61.a.b(appRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) appRuntime : null, str, i3);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public GoldMsgTipsElemBean parseGoldMsgPush(byte[] bArr) {
        try {
            TroopTips0x857$GoldMsgTipsElem troopTips0x857$GoldMsgTipsElem = new TroopTips0x857$NotifyMsgBody().mergeFrom(bArr).opt_msg_goldtips;
            return new GoldMsgTipsElemBean(troopTips0x857$GoldMsgTipsElem.billno.get(), troopTips0x857$GoldMsgTipsElem.action.get(), troopTips0x857$GoldMsgTipsElem.type.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 1, "parseAndSaveGoldMsgPush: ", e16);
            return null;
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void removeQBaseActivityObserver(QBaseActivity qBaseActivity, d4.b bVar) {
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            ((AppInterface) appRuntime).removeObserver(this.mFriendListObserver);
            this.mFriendListObserver = null;
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void reportDeviceCantPlayBackground(String str) {
        ChatBackgroundManager.w(str);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void reportResPreload(kl2.a aVar, String str, String str2, int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportResPreload(aVar, str, str2, i3);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void reportResRealTimeDownload(String str, String str2, int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportResRealTimeDownload(str, str2, i3);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void sendGetRecentList(BaseQQAppInterface baseQQAppInterface, PfaFriendRqt pfaFriendRqt) {
        ((QWalletAuthHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).F2(pfaFriendRqt);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void sendMessage(AppRuntime appRuntime, Context context, Object obj, String str, ArrayList<AtTroopMemberInfo> arrayList) {
        if ((appRuntime instanceof QQAppInterface) && (obj instanceof SessionInfo)) {
            ChatActivityFacade.L0((QQAppInterface) appRuntime, context, (SessionInfo) obj, str, arrayList);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void showQQCustomDialogWithInputAndChoose(Activity activity, String str, DialogInterface.OnClickListener onClickListener) {
        Bundle extras = activity.getIntent().getExtras();
        QQCustomDialogWtihInputAndChoose l3 = ak.l(activity, str, extras.getString("choose_friend_content"), extras.getString("choose_friend_subcontent"), ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getTopayTips(activity), null, onClickListener, onClickListener, 36, false);
        com.tencent.mobileqq.qwallet.c.e("friendpay.selectpage.windowshow", "", "", "", "");
        TextView titleTextView = l3.getTitleTextView();
        if (titleTextView != null) {
            titleTextView.setSingleLine(false);
            titleTextView.setMaxLines(2);
            titleTextView.setEllipsize(TextUtils.TruncateAt.END);
            titleTextView.setGravity(3);
        }
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void startForwardActivity(Context context, Intent intent) {
        ForwardBaseOption.startForwardActivity(context, intent);
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void startBirthdayHbSuccessFragment(Context context, Intent intent) {
    }

    @Override // com.qwallet.temp.IQWalletTemp
    public void reset() {
    }
}
