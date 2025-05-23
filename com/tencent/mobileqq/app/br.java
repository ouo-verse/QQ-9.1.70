package com.tencent.mobileqq.app;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.report.model.PushReportData;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import com.tencent.troopguild.report.api.ITroopGuildDtReportApi;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class br {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final QQAppInterface f195414a;

    public br(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195414a = qQAppInterface;
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgRecord msgRecord, Intent intent) {
        int i3;
        PushReportData pushReportData = new PushReportData(msgRecord);
        if (d(qQAppInterface)) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        pushReportData.setAppStatus(i3);
        pushReportData.setAction("receive");
        intent.putExtra(PushReportData.GUILD_NOTIFY_REPORT, (Parcelable) pushReportData);
        ((com.tencent.mobileqq.guild.report.g) qQAppInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildReportHandlerName())).L0(pushReportData);
    }

    private static void c(QQAppInterface qQAppInterface, Object obj, Intent intent) {
        PushReportData pushReportData;
        int i3;
        if (obj instanceof PushReportData) {
            pushReportData = (PushReportData) obj;
        } else if (obj instanceof Bundle) {
            pushReportData = (PushReportData) ((Bundle) obj).getParcelable(PushReportData.GUILD_NOTIFY_REPORT);
        } else {
            pushReportData = null;
        }
        if (pushReportData == null) {
            return;
        }
        if (d(qQAppInterface)) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        pushReportData.setAppStatus(i3);
        pushReportData.setAction("receive");
        intent.putExtra(PushReportData.GUILD_NOTIFY_REPORT, (Parcelable) pushReportData);
        ((com.tencent.mobileqq.guild.report.g) qQAppInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildReportHandlerName())).L0(pushReportData);
    }

    private static boolean d(QQAppInterface qQAppInterface) {
        boolean z16;
        boolean z17;
        boolean z18;
        KeyguardManager keyguardManager = (KeyguardManager) qQAppInterface.getApp().getApplicationContext().getSystemService("keyguard");
        if (keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!qQAppInterface.isBackgroundPause && !qQAppInterface.isBackgroundStop && !z16) {
            z17 = false;
        } else {
            z17 = true;
        }
        ForegroundNotifyManager b16 = ForegroundNotifyManager.b(qQAppInterface);
        if (b16 != null && b16.t()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 && z18) {
            return true;
        }
        return false;
    }

    public static void e(QQAppInterface qQAppInterface, Message message, boolean z16, com.tencent.mobileqq.app.notification.struct.e eVar) {
        int i3;
        boolean readValue;
        Intent b16 = eVar.b();
        if (z16 && (i3 = message.istroop) != 6000 && i3 != 1009 && !message.frienduin.equals(AppConstants.RECOMMEND_CONTACT_UIN)) {
            if (QQUtils.k(qQAppInterface.getApp())) {
                com.tencent.mobileqq.managers.i iVar = (com.tencent.mobileqq.managers.i) qQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
                if (NotifyPushSettingFragment.qi()) {
                    readValue = false;
                } else {
                    readValue = SettingCloneUtil.readValue((Context) qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), qQAppInterface.getApp().getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true);
                }
                boolean h16 = MessageNotificationSettingManager.l(qQAppInterface).h(message.frienduin, message.istroop, null);
                if (readValue && h16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "videochatting start lsActivity notificationContentTitle appinterface  buildNotificationElement");
                    }
                    iVar.g(qQAppInterface, message, false, com.tencent.mobileqq.managers.d.a(message.frienduin, message.istroop, b16));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, "screen unlock");
            }
        }
    }

    public static void f(QQAppInterface qQAppInterface, @NonNull MessageRecord messageRecord, com.tencent.mobileqq.app.notification.struct.e eVar, String str) {
        String f16 = eVar.f();
        Bitmap e16 = eVar.e();
        String c16 = eVar.c();
        String d16 = eVar.d();
        Intent b16 = eVar.b();
        int i3 = 1;
        QLog.d("[NotificationRebuild] MessageNotificationGenerator", 1, "showNotificationElementOfMessage. cmd=" + str + ", ticker=" + com.tencent.mobileqq.util.aw.a(f16) + ",msgShow:" + com.tencent.mobileqq.util.aw.a(d16) + ", bitmap=" + e16);
        String[] strArr = {f16, c16, d16};
        if (e16 == null) {
            e16 = com.tencent.mobileqq.util.j.g(qQAppInterface.getApp().getResources(), R.drawable.icon);
        }
        if (e16 != null) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", qQAppInterface.getCurrentAccountUin(), str);
            toServiceMsg.extraData.putStringArray("cmds", strArr);
            b16.putExtra(QQNotificationManager.PARAM_FROMUIN, messageRecord.senderuin);
            b16.putExtra("KEY_FRIEND_UIN", messageRecord.frienduin);
            b16.putExtra(QQNotificationManager.PARAM_UINTYPE, messageRecord.istroop);
            b16.putExtra(AppConstants.Key.MSG_UNISEQ, messageRecord.uniseq);
            b16.putExtra(AppConstants.Key.COLUMN_MSG_TYPE, messageRecord.msgtype);
            int i16 = messageRecord.istroop;
            if (i16 == 10014) {
                Object obj = messageRecord.extObj;
                if (obj instanceof MsgRecord) {
                    b(qQAppInterface, (MsgRecord) obj, b16);
                } else {
                    c(qQAppInterface, obj, b16);
                }
            } else if (i16 == 1) {
                boolean z16 = messageRecord instanceof Message;
                if (z16) {
                    Message message = (Message) messageRecord;
                    if (((ITroopGuildMsgApi) QRoute.api(ITroopGuildMsgApi.class)).isTroopGuildPushMsg(message)) {
                        ITroopGuildMsgApi iTroopGuildMsgApi = (ITroopGuildMsgApi) QRoute.api(ITroopGuildMsgApi.class);
                        if (d(qQAppInterface)) {
                            i3 = 2;
                        }
                        iTroopGuildMsgApi.setPushPlace(message, i3);
                        ((ITroopGuildDtReportApi) QRoute.api(ITroopGuildDtReportApi.class)).reportMsgPushExposure(message);
                    }
                }
                if (z16 && messageRecord.msgtype == -2016) {
                    h(messageRecord.frienduin);
                }
            }
            toServiceMsg.extraData.putParcelable("intent", b16);
            toServiceMsg.extraData.putParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP, e16);
            qQAppInterface.mqqService.j(toServiceMsg);
        }
    }

    private static void h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", str);
        hashMap.put(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, 1);
        VideoReport.reportEvent("ev_group_live_push_imp", hashMap);
    }

    com.tencent.mobileqq.app.notification.struct.e a(Message message, boolean z16) {
        return new com.tencent.mobileqq.app.notification.struct.f(this.f195414a, message, z16).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(QQAppInterface qQAppInterface, Message message, boolean z16) {
        com.tencent.mobileqq.app.notification.struct.e a16 = a(message, z16);
        if (a16 == null) {
            QLog.d("[NotificationRebuild] MessageNotificationGenerator", 1, "[build] showNotificationOfMessage: invoked. [\u4e2d\u65ad\u53d1\u901a\u77e5\u6d41\u7a0b\uff0c\u65e0\u6cd5\u6784\u9020\u51fa\u901a\u77e5\u5b9e\u4f53\uff0c\u539f\u56e0\u53ef\u80fd\u662f\u53cd\u5c04\u5931\u8d25]", " notificationElement: null ");
        } else {
            e(qQAppInterface, message, z16, a16);
            f(qQAppInterface, message, a16, "CMD_SHOW_NOTIFIYCATION");
        }
    }
}
