package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.notify.api.IGuildNotify;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bq {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final QQAppInterface f195411a;

    /* renamed from: b, reason: collision with root package name */
    private final int f195412b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f195413c;

    public bq(QQAppInterface qQAppInterface, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f195411a = qQAppInterface;
        this.f195412b = i3;
        this.f195413c = z17;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[9];
            objArr[0] = "MessageNotifiableChecker ";
            objArr[1] = "size is:";
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = " isRunBackground:";
            objArr[4] = Boolean.valueOf(qQAppInterface.isBackgroundPause || qQAppInterface.isBackgroundStop);
            objArr[5] = " needSoundVibrationsTip: ";
            objArr[6] = Boolean.valueOf(z16);
            objArr[7] = " isOnline: ";
            objArr[8] = Boolean.valueOf(z17);
            QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, objArr);
        }
    }

    private boolean A(Message message) {
        if (p61.a.e(message) || ((ITempMsgBoxManager) this.f195411a.getRuntimeService(ITempMsgBoxManager.class, "")).isBelongToFilterBox(message.frienduin, message.istroop) || TextUtils.equals(message.frienduin, AppConstants.TROOP_SUSPICIOUS_MSG_UIN)) {
            return true;
        }
        int i3 = message.istroop;
        if (10007 == i3) {
            return !((IGameMsgBoxManager) this.f195411a.getRuntimeService(IGameMsgBoxManager.class)).isGameInGameBox(this.f195411a, message.frienduin);
        }
        if (i3 == 10014) {
            if (message.extObj instanceof MsgRecord) {
                return !((IGuildNotify) this.f195411a.getRuntimeService(IGuildNotify.class, "")).canNotifyByLogic((MsgRecord) message.extObj);
            }
            return !((IGuildNotify) this.f195411a.getRuntimeService(IGuildNotify.class, "")).canNotify(message.frienduin, message.extObj);
        }
        if (v(message)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(QQAppInterface qQAppInterface, Message message) {
        ComponentName componentName;
        ComponentName componentName2;
        BaseApplication app = qQAppInterface.getApp();
        boolean a16 = com.tencent.mobileqq.util.az.a(app.getApplicationContext(), qQAppInterface);
        boolean k3 = FriendsStatusUtil.k(message.frienduin, qQAppInterface);
        boolean h16 = com.tencent.mobileqq.app.nthiddenchat.b.h(message.frienduin, message.istroop, qQAppInterface);
        boolean l3 = com.tencent.mobileqq.message.newmsg.a.d(qQAppInterface).l(message);
        boolean c16 = com.tencent.mobileqq.util.az.c(app.getApplicationContext(), qQAppInterface);
        if (QLog.isColorLevel()) {
            QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "currentAppSettingStateNeedNotification, isFinished=" + qQAppInterface.isFinished + ", isCanDisturb=" + a16 + ", newMsgNotificationEnabled=" + l3 + ", message=" + message);
        }
        if (qQAppInterface.isFinished || !a16 || k3 || h16 || !l3 || c16) {
            return false;
        }
        if (Utils.G(message.frienduin)) {
            BaseApplication context = BaseApplication.getContext();
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("BabyQ topActivity packageName: ");
                    componentName2 = runningTasks.get(0).topActivity;
                    sb5.append(componentName2.getPackageName());
                    QLog.d(QQAppInterface.TAG, 2, sb5.toString());
                }
                String packageName = context.getPackageName();
                componentName = runningTasks.get(0).topActivity;
                if (packageName.equals(componentName.getPackageName())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean i(Message message) {
        if (1036 == message.istroop) {
            return true;
        }
        return false;
    }

    private boolean j(Message message) {
        if (TextUtils.equals(message.getExtInfoFromExtStr(AppConstants.Key.KEY_MSG_IN_CONVESATION_BOX), AppConstants.Key.KEY_MSG_IN_CONVESATION_BOX)) {
            if (QLog.isColorLevel()) {
                QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show message InMsgBox");
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean k(Message message) {
        return com.tencent.imcore.message.ao.w(message.senderuin);
    }

    private boolean m(Message message) {
        if (((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).isExtendMatchChatMsg(message) && ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).checkInterceptMatchMessage(this.f195411a, message)) {
            if (QLog.isColorLevel()) {
                QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "isNeedForbidExtendFriendChatMessage return true for match chat");
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean n(Message message) {
        if (1046 != message.istroop) {
            return false;
        }
        return ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).isNeedForbidNotification();
    }

    private boolean s(Message message) {
        if (1008 == message.istroop && message.senderuin != null && TroopBarAssistantManager.n().x(this.f195411a, message.senderuin, message.istroop)) {
            return true;
        }
        return false;
    }

    private boolean t(Message message) {
        boolean z16;
        boolean z17;
        if (message.istroop == 1008) {
            String str = message.extStr;
            if (str != null && ((message.extLong & 1) != 0 || str.contains("lockDisplay"))) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (message.extStr != null && ((message.extLong & 1) != 1 || message.getExtInfoFromExtStr("lockDisplay").equals("true"))) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z16 || z17) {
                if (this.f195411a.isLogin()) {
                    ((IAppBadgeService) this.f195411a.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
                }
                return true;
            }
        }
        return false;
    }

    private boolean v(MessageRecord messageRecord) {
        if (messageRecord != null && messageRecord.istroop == 10019) {
            return true;
        }
        return false;
    }

    private boolean w(Message message) {
        if (message.msgtype == -2058) {
            return true;
        }
        return false;
    }

    private boolean x(Message message) {
        if (this.f195411a.isTroopMark(message) && !message.needNotification() && !((ITroopGuildMsgApi) QRoute.api(ITroopGuildMsgApi.class)).isTroopGuildPushMsg(message)) {
            if (QLog.isColorLevel()) {
                QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , isTroopMark");
                return true;
            }
            return true;
        }
        return false;
    }

    boolean B(Message message) {
        ForegroundNotifyManager b16 = ForegroundNotifyManager.b(this.f195411a);
        if (b16 == null || b16.t()) {
            return true;
        }
        if (!b16.C(message.istroop) || !b16.B(message.frienduin)) {
            return false;
        }
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 1, "[foreground] [process] subProcFgPushEnabled: invoked. ", " isSubProcessBackgroundStop: ", Boolean.FALSE);
        return b16.D();
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.onEvent(0, null);
        }
    }

    public boolean D(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.istroop;
        if (i3 == 9002) {
            byte[] bArr = message.msgData;
            if (bArr != null && bArr.length > 0) {
                ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) this.f195411a.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
                if (!TextUtils.equals("true", message.getExtInfoFromExtStr("key_msg_need_notify")) && !activateFriendsManager.N(message.msgData)) {
                    return true;
                }
                if (activateFriendsManager.M(message.msgData)) {
                    message.counter += this.f195412b;
                }
            } else {
                message.counter += this.f195412b;
            }
        } else if (i3 != 7220 && !AppConstants.KANDIAN_DAILY_UIN.equals(message.frienduin)) {
            if (message.istroop == 10014) {
                message.counter = this.f195412b;
            } else if (!AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(message.frienduin) && !AppConstants.MAYKNOW_RECOMMEND_UIN.equals(message.frienduin)) {
                message.counter += this.f195412b;
            } else {
                message.counter = this.f195412b;
            }
        } else {
            message.counter = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, " [updateMessageCounter] message.counter" + message.counter);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Message message) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) this.f195411a.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        this.f195411a.unitTestLog("inKeyguardRestrictedInputMode", new Object[0]);
        QQAppInterface qQAppInterface = this.f195411a;
        if (!qQAppInterface.isBackgroundPause && !qQAppInterface.isBackgroundStop && !inKeyguardRestrictedInputMode) {
            z16 = false;
        } else {
            z16 = true;
        }
        ForegroundNotifyManager b16 = ForegroundNotifyManager.b(qQAppInterface);
        if (b16 != null && b16.t()) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean y16 = this.f195411a.messageNotifiableChecker.y(message);
        boolean B = this.f195411a.messageNotifiableChecker.B(message);
        boolean h16 = this.f195411a.messageNotifiableChecker.h(message);
        if (h16 && (!z16 || !z17)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16) {
            QQAppInterface qQAppInterface2 = this.f195411a;
            if ((qQAppInterface2.userActiveStatus == 0 || y16) && B && !((IGuildNotify) qQAppInterface2.getRuntimeService(IGuildNotify.class)).shieldNotifyMainBackground(message, false)) {
                z19 = true;
                if (z18 && !z19) {
                    z26 = false;
                } else {
                    z26 = true;
                }
                QLog.d("[NotificationRebuild] MessageNotifiableChecker", 1, "[notification] [foreground] [state] currentDeviceStateNeedNotification:", " needNotification: ", Boolean.valueOf(z26), " foregroundMessagePushEnabled: ", Boolean.valueOf(z18), " isForegroundPushEnabled: ", Boolean.valueOf(h16), " mainProcessBackground: ", Boolean.valueOf(z16), " subProcessBackgroundStop: ", Boolean.valueOf(z17), " mainProcBackgroundPushEnabled: ", Boolean.valueOf(z19), " mainProcessBackground: ", Boolean.valueOf(z16), " subProcFgPushEnabled: ", Boolean.valueOf(B), " needNotificationMessage: ", Boolean.valueOf(y16), " userActiveStatus: ", Integer.valueOf(this.f195411a.userActiveStatus));
                return z26;
            }
        }
        z19 = false;
        if (z18) {
        }
        z26 = true;
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 1, "[notification] [foreground] [state] currentDeviceStateNeedNotification:", " needNotification: ", Boolean.valueOf(z26), " foregroundMessagePushEnabled: ", Boolean.valueOf(z18), " isForegroundPushEnabled: ", Boolean.valueOf(h16), " mainProcessBackground: ", Boolean.valueOf(z16), " subProcessBackgroundStop: ", Boolean.valueOf(z17), " mainProcBackgroundPushEnabled: ", Boolean.valueOf(z19), " mainProcessBackground: ", Boolean.valueOf(z16), " subProcFgPushEnabled: ", Boolean.valueOf(B), " needNotificationMessage: ", Boolean.valueOf(y16), " userActiveStatus: ", Integer.valueOf(this.f195411a.userActiveStatus));
        return z26;
    }

    public void c(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) message);
            return;
        }
        int i3 = message.istroop;
        if ((i3 == 1001 || i3 == 10002) && message.msgtype == -3001) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            OpenAppClient.c(BaseApplication.context, message.action);
        }
    }

    public Intent d(Message message, Intent intent) {
        boolean z16;
        Intent intent2 = intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message, (Object) intent2);
        }
        ForegroundNotifyManager b16 = ForegroundNotifyManager.b(this.f195411a);
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) BaseApplication.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        boolean d16 = com.tencent.mobileqq.notification.modularize.e.d(this.f195411a);
        if (!d16 && !inKeyguardRestrictedInputMode) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (b16 != null && h(message) && !z16) {
            if (message.istroop != 10014 && !((ITroopGuildMsgApi) QRoute.api(ITroopGuildMsgApi.class)).isTroopGuildPushMsg(message)) {
                String stringExtra = intent2.getStringExtra("key_chat_name");
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = com.tencent.mobileqq.utils.ac.R(this.f195411a, message.frienduin, message.istroop);
                }
                String str = stringExtra;
                intent2 = ((IFeatureRuntimeService) this.f195411a.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("android_msg_notification_broadcast", true) ? b16.c(message.istroop, message.frienduin, str, 28, message.uniseq) : b16.g(message.istroop, message.frienduin, str, 28);
            }
            com.tencent.mobileqq.onlinestatus.bv.b("0X800AFCD", b16.a(message.istroop));
        }
        if (QLog.isColorLevel()) {
            QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "getMiniAioIntentIfNeed: invoked. ", " appBackgroundOrLocked: ", Boolean.valueOf(z16), " isScreenLocked: ", Boolean.valueOf(inKeyguardRestrictedInputMode), " app.isBackgroundStop: ", Boolean.valueOf(this.f195411a.isBackgroundStop), " isAppBackground: ", Boolean.valueOf(d16), " foregroundNotifyManager: ", b16);
        }
        return intent2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public QQMessageFacade e() {
        if (this.f195412b == 0) {
            return null;
        }
        return this.f195411a.getMessageFacade();
    }

    boolean f(Message message) {
        if (FriendsStatusUtil.k(message.frienduin, this.f195411a) || com.tencent.mobileqq.app.nthiddenchat.b.h(message.frienduin, message.istroop, this.f195411a)) {
            return true;
        }
        if (UserguideActivity.G2(this.f195411a.getApp(), this.f195411a.getCurrentAccountUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , showUserGuide");
            }
            return true;
        }
        if (((INewFriendApi) QRoute.api(INewFriendApi.class)).isSuspiciousSysMsg(message)) {
            if (QLog.isColorLevel()) {
                QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , isSuspiciousSysMsg");
            }
            if (this.f195411a.isLogin()) {
                ((IAppBadgeService) this.f195411a.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            }
            return true;
        }
        return false;
    }

    boolean g() {
        if (((IOnlineStatusService) this.f195411a.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus() == AppRuntime.Status.dnd) {
            if (QLog.isColorLevel()) {
                QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, online status is dnd");
            }
            ((IAppBadgeService) this.f195411a.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            return true;
        }
        return false;
    }

    boolean h(Message message) {
        ForegroundNotifyManager b16 = ForegroundNotifyManager.b(this.f195411a);
        if (b16 != null && b16.n(message)) {
            return true;
        }
        return false;
    }

    boolean l(Message message) {
        if (message.istroop == 1001) {
            return true;
        }
        return false;
    }

    public boolean o(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.istroop;
        if (i3 != 6000 && (((i3 != 1001 && i3 != 10002) || message.msgtype != -3001) && i3 != 1008 && i3 != 9002)) {
            return false;
        }
        return true;
    }

    public boolean p(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        if (message.istroop == 10014) {
            return true;
        }
        return false;
    }

    public boolean q(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.msgtype;
        if (i3 != -1013 && i3 != -2030 && i3 != -1047 && i3 != -1019 && i3 != -1018) {
            return false;
        }
        return true;
    }

    public boolean r(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.istroop;
        if (i3 != 6000 && this.f195411a.userActiveStatus != 0 && ((i3 != 1001 && i3 != 10002) || message.msgtype != -3001)) {
            return false;
        }
        return true;
    }

    boolean u(Message message) {
        int i3 = message.istroop;
        if (1000 != i3 && 1020 != i3) {
            String str = message.senderuin;
            if (str != null && str.equalsIgnoreCase(this.f195411a.getCurrentAccountUin())) {
                if (QLog.isColorLevel()) {
                    QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage ,self message");
                }
                return true;
            }
            return false;
        }
        String str2 = message.frienduin;
        if (str2 != null && str2.equalsIgnoreCase(this.f195411a.getCurrentAccountUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , stranger  self message");
            }
            return true;
        }
        return false;
    }

    boolean y(Message message) {
        int i3 = message.istroop;
        if (i3 != 6000 && (((i3 != 1001 && i3 != 10002) || message.msgtype != -3001) && i3 != 1008 && i3 != 9002 && i3 != 7225)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z(QQMessageFacade qQMessageFacade, Message message) {
        if (message == null || u(message) || x(message) || i(message) || s(message) || k(message) || w(message) || t(message) || m(message) || j(message) || g() || f(message) || l(message) || n(message) || A(message)) {
            return true;
        }
        return false;
    }
}
