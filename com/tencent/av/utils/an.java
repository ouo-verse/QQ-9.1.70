package com.tencent.av.utils;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.br;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class an {
    private static boolean a(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (messageRecord.senderuin != null && 1008 == messageRecord.istroop && TroopBarAssistantManager.n().x(qQAppInterface, messageRecord.senderuin, messageRecord.istroop)) {
            return true;
        }
        if (messageRecord.istroop == 1008) {
            String str = messageRecord.extStr;
            if (str == null || (((messageRecord.extLong & 1) == 0 && !str.contains("lockDisplay")) || messageRecord.extStr == null || ((messageRecord.extLong & 1) == 1 && !messageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean b(String str, MessageRecord messageRecord) {
        int i3 = messageRecord.istroop;
        if (1000 != i3 && 1020 != i3) {
            String str2 = messageRecord.senderuin;
            if (str2 != null && str2.equalsIgnoreCase(str) && messageRecord.msgtype != -4008) {
                if (QLog.isColorLevel()) {
                    QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification ,self message");
                }
                return true;
            }
            return false;
        }
        String str3 = messageRecord.frienduin;
        if (str3 != null && str3.equalsIgnoreCase(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification , stranger  self message");
            }
            return true;
        }
        return false;
    }

    private static boolean c(MessageRecord messageRecord) {
        boolean z16;
        boolean z17;
        ComponentName componentName;
        ComponentName componentName2;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) BaseApplicationImpl.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("locking activity:");
                componentName2 = runningTaskInfo.topActivity;
                sb5.append(componentName2.getClassName());
                QLog.d("QavMsgNotificationUtil", 2, sb5.toString());
            }
            componentName = runningTaskInfo.topActivity;
            String className = componentName.getClassName();
            if (className.equals("com.tencent.av.ui.VideoInviteLock") || className.equals("com.tencent.av.gaudio.GaInviteLockActivity") || className.equals("com.tencent.av.ui.AVActivity")) {
                z16 = true;
                if (messageRecord.msgtype != -2016 && messageRecord.istroop == 3000) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z16 && z17) {
                    return true;
                }
                return false;
            }
        }
        z16 = false;
        if (messageRecord.msgtype != -2016) {
        }
        z17 = false;
        if (!z16) {
        }
        return false;
    }

    private static void d(MessageRecord messageRecord, Intent intent) {
        int i3 = messageRecord.msgtype;
        if (i3 != -2016 && i3 != -4008) {
            if (i3 == -2009) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavMsgNotificationUtil", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO");
                }
                intent.putExtra("qav_notify_flag", true);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QavMsgNotificationUtil", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO");
        }
        if (messageRecord.istroop == 3000) {
            if (QLog.isColorLevel()) {
                QLog.e("QavMsgNotificationUtil", 2, "AVNotify:UIN_TYPE_DISCUSSION");
            }
            intent.putExtra("qav_notify_flag", true);
        }
    }

    private static String e(QQAppInterface qQAppInterface, com.tencent.mobileqq.qcall.f fVar, String str, int i3) {
        int v3 = fVar.v();
        if (v3 > 1 && i3 == 1) {
            if (v3 > 100) {
                return str + " (" + qQAppInterface.getApp().getString(R.string.f171147cl0) + ")";
            }
            return str + " (" + v3 + qQAppInterface.getApp().getString(R.string.cir) + ")";
        }
        return str;
    }

    private static void f(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16, Intent intent, boolean z17) {
        int i3;
        if (z16 && (i3 = messageRecord.istroop) != 6000 && i3 != 1009 && !messageRecord.frienduin.equals(AppConstants.RECOMMEND_CONTACT_UIN) && QQUtils.k(qQAppInterface.getApp())) {
            com.tencent.mobileqq.managers.i iVar = (com.tencent.mobileqq.managers.i) qQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
            boolean readValue = SettingCloneUtil.readValue((Context) qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), qQAppInterface.getApp().getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true);
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, String.format("videochatting start lsActivity from appinterface  showInComingMsgForQAV, lockScreenMsgWhenExit[%s]", Boolean.valueOf(readValue)));
            }
            if (readValue) {
                if (z17) {
                    String str = messageRecord.frienduin;
                    int i16 = messageRecord.istroop;
                    iVar.f(qQAppInterface, str, i16, true, com.tencent.mobileqq.managers.d.a(str, i16, intent));
                } else {
                    String str2 = messageRecord.frienduin;
                    int i17 = messageRecord.istroop;
                    iVar.f(qQAppInterface, str2, i17, false, com.tencent.mobileqq.managers.d.a(str2, i17, intent));
                }
            }
        }
    }

    @Nullable
    private static String g(MessageRecord messageRecord, boolean z16, String str, String str2, String str3) {
        int i3 = messageRecord.istroop;
        if (i3 == 1008) {
            str2 = str2 + str3;
        } else if (i3 != 7000) {
            str2 = str2 + str;
        }
        if (!z16) {
            return null;
        }
        return str2;
    }

    private static Bitmap h(QQAppInterface qQAppInterface, int i3, boolean z16, MessageRecord messageRecord, String str) {
        if (i3 != 1) {
            return null;
        }
        if (z16) {
            DiscussionHandler discussionHandler = (DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
            if (discussionHandler == null) {
                return null;
            }
            return discussionHandler.W2(messageRecord.frienduin, true);
        }
        if (AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(messageRecord.frienduin)) {
            return qQAppInterface.getFaceBitmap(str, true);
        }
        int i16 = messageRecord.istroop;
        if (i16 != 1001 && i16 != 10002 && i16 != 1010) {
            return qQAppInterface.getFaceBitmap(messageRecord.frienduin, true);
        }
        return qQAppInterface.getStrangerFaceBitmap(messageRecord.frienduin, 200);
    }

    public static Intent i(QQAppInterface qQAppInterface, Context context, String str, int i3, MessageRecord messageRecord) {
        String R;
        Intent m3;
        String str2;
        Intent intent;
        Intent intent2;
        String string;
        if (String.valueOf(AppConstants.FRIEND_SYSTEM_MSG_UIN).equals(str)) {
            R = context.getString(R.string.huc);
            m3 = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getNewFriendJumpIntent(context);
            m3.putExtra("from", "from_notification");
            m3.putExtra("EntranceId", 1);
        } else {
            if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(str)) {
                R = context.getString(R.string.huc);
                intent = new Intent(context, (Class<?>) QPublicFragmentActivity.class);
                intent.putExtra("public_fragment_class", ((ILaunchTroopSysMsgUIUtilApi) QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).getFragmentNameForLaunch());
            } else {
                if (String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(str)) {
                    intent2 = new Intent(context, (Class<?>) QQBroadcastActivity.class);
                    string = context.getString(R.string.hub);
                } else if (String.valueOf(AppConstants.VOTE_MSG_UIN).equals(str)) {
                    String string2 = context.getString(R.string.huc);
                    Intent intent3 = new Intent(context, (Class<?>) VisitorsActivity.class);
                    intent3.putExtra("votersOnly", true);
                    intent3.putExtra("toUin", Long.valueOf(qQAppInterface.getCurrentAccountUin()));
                    R = string2;
                    m3 = intent3;
                } else {
                    String str3 = AppConstants.DATALINE_PC_UIN;
                    if (String.valueOf(str3).equals(str)) {
                        intent2 = new Intent(context, (Class<?>) LiteActivity.class);
                        intent2.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str3);
                        string = context.getString(R.string.c5f);
                    } else {
                        String str4 = AppConstants.DATALINE_IPAD_UIN;
                        if (String.valueOf(str4).equals(str)) {
                            intent = new Intent(context, (Class<?>) LiteActivity.class);
                            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str4);
                            if (((RegisterProxySvcPackHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                                R = context.getString(R.string.c5g);
                            } else {
                                R = context.getString(R.string.f16272217);
                            }
                        } else {
                            Intent aliasIntent = SplashActivity.getAliasIntent(qQAppInterface.getApp());
                            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                            aliasIntent.putExtra(Conversation.TAB_INDEX, 1);
                            aliasIntent.setFlags(335544320);
                            if (i3 == 7000) {
                                String string3 = context.getString(R.string.hrx);
                                aliasIntent.setClass(context, ((IAssociatedAccountApi) QRoute.api(IAssociatedAccountApi.class)).getAssociatedAccountActivity());
                                aliasIntent.putExtra("subAccount", str);
                                ISubAccountService iSubAccountService = (ISubAccountService) qQAppInterface.getRuntimeService(ISubAccountService.class, "");
                                if (iSubAccountService != null) {
                                    str2 = iSubAccountService.getLatestUinNick(str);
                                } else {
                                    str2 = str;
                                }
                                aliasIntent.putExtra("subAccountLatestNick", str2);
                                aliasIntent.putExtra("finishAIO", true);
                                m3 = aliasIntent;
                                R = string3;
                            } else {
                                if (i3 == 1009) {
                                    R = context.getString(R.string.h3p);
                                } else if (String.valueOf(AppConstants.APP_ASSISTANT_UIN).equals(str)) {
                                    R = context.getString(R.string.f170348p5);
                                } else if (i3 == 1024) {
                                    aliasIntent.setComponent(SplashActivity.getAliasComponent(context));
                                    m3 = BaseAIOUtils.m(aliasIntent, null);
                                    m3.putExtra("chat_subType", 1);
                                    R = com.tencent.mobileqq.utils.ac.R(qQAppInterface, str, i3);
                                } else {
                                    R = com.tencent.mobileqq.utils.ac.R(qQAppInterface, str, i3);
                                }
                                m3 = aliasIntent;
                            }
                            m3.putExtra("uin", str);
                            m3.putExtra("uintype", i3);
                        }
                    }
                }
                String str5 = string;
                m3 = intent2;
                R = str5;
            }
            m3 = intent;
        }
        m3.putExtra("uinname", R);
        return m3;
    }

    private static Intent j(QQAppInterface qQAppInterface, int i3, boolean z16, MessageRecord messageRecord, String str) {
        Intent aliasIntent;
        if (i3 == 1) {
            if (z16) {
                return i(qQAppInterface, qQAppInterface.getApp(), messageRecord.frienduin, messageRecord.istroop, messageRecord);
            }
            int i16 = messageRecord.istroop;
            if (i16 != 1000 && i16 != 1020 && i16 != 1004) {
                return i(qQAppInterface, qQAppInterface.getApp(), messageRecord.frienduin, messageRecord.istroop, messageRecord);
            }
            aliasIntent = SplashActivity.getAliasIntent(qQAppInterface.getApp());
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.putExtra(Conversation.TAB_INDEX, 1);
            aliasIntent.setFlags(335544320);
            aliasIntent.putExtra("uinname", qQAppInterface.getTroopDisscussMemberNick(messageRecord.frienduin, str, messageRecord.istroop, true));
        } else {
            aliasIntent = SplashActivity.getAliasIntent(qQAppInterface.getApp());
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.putExtra(Conversation.TAB_INDEX, 1);
            aliasIntent.setFlags(335544320);
            aliasIntent.putExtra("uinname", qQAppInterface.getApp().getString(R.string.notification_title));
        }
        return aliasIntent;
    }

    private static String k(MessageRecord messageRecord, com.tencent.mobileqq.qcall.f fVar) {
        QCallRecent A;
        String str = messageRecord.senderuin;
        int i3 = messageRecord.msgtype;
        if ((i3 == -2016 || i3 == -4008) && (A = fVar.A(messageRecord.frienduin, messageRecord.istroop)) != null) {
            return A.senderUin;
        }
        return str;
    }

    private static boolean l(MessageRecord messageRecord) {
        int i3 = messageRecord.msgtype;
        if ((i3 == -2016 || i3 == -4008) && messageRecord.istroop == 3000) {
            return true;
        }
        return false;
    }

    public static void m(QQAppInterface qQAppInterface, int i3, boolean z16, boolean z17, MessageRecord messageRecord) {
        if (QLog.isColorLevel()) {
            QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification , size is:" + i3 + ",isOnline is:" + z17);
        }
        if (i3 == 0 || messageRecord == null || b(qQAppInterface.getCurrentAccountUin(), messageRecord) || a(qQAppInterface, messageRecord)) {
            return;
        }
        if (UserguideActivity.G2(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification , showUserGuide");
                return;
            }
            return;
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.onEvent(0, null);
        }
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) qQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        if (c(messageRecord)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavMsgNotificationUtil", 2, "isBackground_Pause:" + qQAppInterface.isBackgroundPause);
            QLog.d("QavMsgNotificationUtil", 2, "isBackground_Stop:" + qQAppInterface.isBackgroundStop);
            QLog.d("QavMsgNotificationUtil", 2, "isScreenLocked:" + inKeyguardRestrictedInputMode);
        }
        if (qQAppInterface.isBackgroundPause || qQAppInterface.isBackgroundStop || inKeyguardRestrictedInputMode) {
            int i16 = messageRecord.istroop;
            if (i16 == 6000 || qQAppInterface.userActiveStatus == 0 || (((i16 == 1001 || i16 == 10002) && messageRecord.msgtype == -3001) || i16 == 1008)) {
                o(qQAppInterface, messageRecord, z16, z17);
            }
        }
    }

    private static void n(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
        com.tencent.mobileqq.qcall.f fVar;
        String str;
        Bitmap d16;
        String str2;
        String str3;
        if (qQAppInterface == null) {
            return;
        }
        boolean a16 = com.tencent.mobileqq.util.az.a(qQAppInterface.getApp().getApplicationContext(), qQAppInterface);
        if (QLog.isColorLevel()) {
            QLog.d("QavMsgNotificationUtil", 2, "showInComingMsg ,isFinished=" + qQAppInterface.isFinished + ", isCanDisturb=" + a16 + ", needTicker=" + z16 + ", message=" + messageRecord);
        }
        if (qQAppInterface.isFinished || !a16 || (fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)) == null) {
            return;
        }
        String k3 = k(messageRecord, fVar);
        int q16 = fVar.q();
        if (q16 == 0) {
            return;
        }
        boolean l3 = l(messageRecord);
        Intent j3 = j(qQAppInterface, q16, l3, messageRecord, k3);
        Bitmap h16 = h(qQAppInterface, q16, l3, messageRecord, k3);
        String str4 = "";
        if (q16 != 1 || !l3) {
            str = "";
        } else {
            str = com.tencent.mobileqq.utils.ac.Q(qQAppInterface, k3, 0);
        }
        j3.putExtra(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, true);
        String stringExtra = j3.getStringExtra("uinname");
        if (stringExtra == null || "".equals(stringExtra)) {
            stringExtra = j3.getStringExtra("uin");
        }
        if (str == null || "".equals(str)) {
            str = k3;
        }
        String y16 = fVar.y(str, l3);
        int i3 = messageRecord.istroop;
        if (i3 != 1008) {
            if (i3 != 1010) {
                if (i3 != 3000) {
                    if (i3 != 7000) {
                        str4 = stringExtra + MsgSummary.STR_COLON;
                    } else {
                        String stringExtra2 = j3.getStringExtra("subAccountLatestNick");
                        if (stringExtra2 != null && stringExtra2.length() != 0) {
                            k3 = stringExtra2;
                        }
                        str4 = stringExtra + "-" + k3 + ":" + y16;
                        str3 = k3 + ":" + y16;
                        h16 = null;
                        str2 = str3;
                        d16 = h16;
                        String g16 = g(messageRecord, z16, y16, str4, str2);
                        String e16 = e(qQAppInterface, fVar, stringExtra, q16);
                        d(messageRecord, j3);
                        f(qQAppInterface, messageRecord, z16, j3, l3);
                        br.f(qQAppInterface, messageRecord, new com.tencent.mobileqq.app.notification.struct.e(j3, g16, e16, str2, d16), "CMD_SHOW_NOTIFIYCATION");
                    }
                } else {
                    str4 = com.tencent.mobileqq.utils.ac.Q(qQAppInterface, k3, 0) + "(" + stringExtra + "):";
                }
                d16 = h16;
                str2 = y16;
                String g162 = g(messageRecord, z16, y16, str4, str2);
                String e162 = e(qQAppInterface, fVar, stringExtra, q16);
                d(messageRecord, j3);
                f(qQAppInterface, messageRecord, z16, j3, l3);
                br.f(qQAppInterface, messageRecord, new com.tencent.mobileqq.app.notification.struct.e(j3, g162, e162, str2, d16), "CMD_SHOW_NOTIFIYCATION");
            }
            if (q16 > 1) {
                str4 = stringExtra + MsgSummary.STR_COLON;
                d16 = h16;
                str2 = y16;
                String g1622 = g(messageRecord, z16, y16, str4, str2);
                String e1622 = e(qQAppInterface, fVar, stringExtra, q16);
                d(messageRecord, j3);
                f(qQAppInterface, messageRecord, z16, j3, l3);
                br.f(qQAppInterface, messageRecord, new com.tencent.mobileqq.app.notification.struct.e(j3, g1622, e1622, str2, d16), "CMD_SHOW_NOTIFIYCATION");
            }
            String j16 = com.tencent.mobileqq.utils.ac.j(qQAppInterface, messageRecord.frienduin);
            str4 = j16 + "(" + stringExtra + "):";
            str3 = j16 + MsgSummary.STR_COLON + y16;
            str2 = str3;
            d16 = h16;
            String g16222 = g(messageRecord, z16, y16, str4, str2);
            String e16222 = e(qQAppInterface, fVar, stringExtra, q16);
            d(messageRecord, j3);
            f(qQAppInterface, messageRecord, z16, j3, l3);
            br.f(qQAppInterface, messageRecord, new com.tencent.mobileqq.app.notification.struct.e(j3, g16222, e16222, str2, d16), "CMD_SHOW_NOTIFIYCATION");
        }
        d16 = cn.d(qQAppInterface.getApp().getResources().getDrawable(R.drawable.icon_recent_public_account));
        PAMessage b16 = com.tencent.mobileqq.activity.aio.ap.b(messageRecord);
        if (b16 != null && !b16.items.isEmpty()) {
            String str5 = b16.items.get(0).title;
            if (b16.items.get(0).cover == null && b16.items.get(0).digestList != null) {
                stringExtra = str5;
                str5 = b16.items.get(0).digestList.get(0);
            }
            str2 = str5;
            String g162222 = g(messageRecord, z16, y16, str4, str2);
            String e162222 = e(qQAppInterface, fVar, stringExtra, q16);
            d(messageRecord, j3);
            f(qQAppInterface, messageRecord, z16, j3, l3);
            br.f(qQAppInterface, messageRecord, new com.tencent.mobileqq.app.notification.struct.e(j3, g162222, e162222, str2, d16), "CMD_SHOW_NOTIFIYCATION");
        }
        str2 = y16;
        String g1622222 = g(messageRecord, z16, y16, str4, str2);
        String e1622222 = e(qQAppInterface, fVar, stringExtra, q16);
        d(messageRecord, j3);
        f(qQAppInterface, messageRecord, z16, j3, l3);
        br.f(qQAppInterface, messageRecord, new com.tencent.mobileqq.app.notification.struct.e(j3, g1622222, e1622222, str2, d16), "CMD_SHOW_NOTIFIYCATION");
    }

    private static void o(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16, boolean z17) {
        boolean z18;
        String str;
        if (qQAppInterface.isShowMsgContent()) {
            n(qQAppInterface, messageRecord, true);
        } else {
            p(qQAppInterface, messageRecord, true);
        }
        if (qQAppInterface.userActiveStatus == 0 && z16) {
            z18 = true;
        } else {
            z18 = false;
        }
        int i3 = messageRecord.istroop;
        if ((i3 == 1001 || i3 == 10002) && messageRecord.msgtype == -3001) {
            z18 = true;
        }
        if (i3 == 1008 && ((((str = messageRecord.extStr) != null && (messageRecord.extLong & 1) == 0 && str.contains("lockDisplay")) || (messageRecord.extStr != null && (messageRecord.extLong & 1) == 1 && messageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))) && z16)) {
            z18 = true;
        }
        if (messageRecord.istroop == 1008 && AppConstants.REMINDER_UIN.equals(messageRecord.senderuin)) {
            z18 = true;
        }
        if (z18) {
            qQAppInterface.vibratorAndAudio(messageRecord, z17, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void p(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
        Intent aliasIntent;
        Intent intent;
        int v3;
        String str;
        Intent i3;
        if (!qQAppInterface.isFinished && com.tencent.mobileqq.util.az.a(qQAppInterface.getApp().getApplicationContext(), qQAppInterface)) {
            com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
            if (fVar == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("notification", 4, String.format("showQavNotificationNoPreview fail 2, message:%s", messageRecord));
                    return;
                }
                return;
            }
            int q16 = fVar.q();
            if (q16 == 0) {
                return;
            }
            if (q16 == 1) {
                int i16 = messageRecord.msgtype;
                if ((i16 == -2016 || i16 == -4008) && messageRecord.istroop == 3000) {
                    i3 = i(qQAppInterface, qQAppInterface.getApp(), messageRecord.frienduin, messageRecord.istroop, messageRecord);
                } else {
                    int i17 = messageRecord.istroop;
                    if (i17 != 1000 && i17 != 1020 && i17 != 1004) {
                        i3 = i(qQAppInterface, qQAppInterface.getApp(), messageRecord.frienduin, messageRecord.istroop, messageRecord);
                    } else {
                        aliasIntent = SplashActivity.getAliasIntent(qQAppInterface.getApp());
                        aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                        aliasIntent.putExtra(Conversation.TAB_INDEX, 1);
                        aliasIntent.setFlags(335544320);
                    }
                }
                intent = i3;
                intent.putExtra(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, true);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(qQAppInterface.getApp().getString(R.string.cl8));
                v3 = fVar.v();
                if (v3 != 0) {
                    return;
                }
                if (v3 > 1000) {
                    stringBuffer.append(qQAppInterface.getApp().getString(R.string.cky));
                } else {
                    stringBuffer.append(v3);
                    stringBuffer.append(qQAppInterface.getApp().getString(R.string.f171148cl1));
                }
                if (z16) {
                    str = stringBuffer.toString();
                } else {
                    str = null;
                }
                String str2 = str;
                int i18 = messageRecord.msgtype;
                if (i18 == -2016) {
                    if (QLog.isColorLevel()) {
                        QLog.e("notification", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO, count:" + q16);
                    }
                    if (messageRecord.istroop == 3000) {
                        if (QLog.isColorLevel()) {
                            QLog.e("notification", 2, "AVNotify:UIN_TYPE_DISCUSSION, count:" + q16);
                        }
                        intent.putExtra("qav_notify_flag", true);
                    }
                } else if (i18 == -2009) {
                    if (QLog.isColorLevel()) {
                        QLog.e("notification", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO, count:" + q16);
                    }
                    intent.putExtra("qav_notify_flag", true);
                }
                br.f(qQAppInterface, messageRecord, new com.tencent.mobileqq.app.notification.struct.e(intent, str2, qQAppInterface.getApp().getResources().getString(R.string.notification_title), stringBuffer.toString(), null), "CMD_SHOW_NOTIFIYCATION");
                return;
            }
            aliasIntent = SplashActivity.getAliasIntent(qQAppInterface.getApp());
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.putExtra(Conversation.TAB_INDEX, 1);
            aliasIntent.setFlags(335544320);
            intent = aliasIntent;
            intent.putExtra(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, true);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(qQAppInterface.getApp().getString(R.string.cl8));
            v3 = fVar.v();
            if (v3 != 0) {
            }
        } else if (QLog.isDevelopLevel()) {
            QLog.d("notification", 4, String.format("showQavNotificationNoPreview fail 1, message:%s", messageRecord));
        }
    }
}
