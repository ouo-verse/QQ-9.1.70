package com.tencent.mobileqq.troop.troopnotification.push;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.troop.troopnotification.push.msg_content.MsgContentPB$MsgContent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.push.MsgNotification;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import msf.msgcomm.nt_msg_common$Msg;

@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0013\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/push/TroopNotification0x210PushHandler;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/troop/troopnotification/push/msg_content/MsgContentPB$MsgContent;", RemoteMessageConst.MessageBody.MSG_CONTENT, "", "c", "f", "", "b", "d", "", "data", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "notifiedIds", "com/tencent/mobileqq/troop/troopnotification/push/TroopNotification0x210PushHandler$qqAccountLogoutReceiver$1", "Lcom/tencent/mobileqq/troop/troopnotification/push/TroopNotification0x210PushHandler$qqAccountLogoutReceiver$1;", "qqAccountLogoutReceiver", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopNotification0x210PushHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final TroopNotification0x210PushHandler f300681a = new TroopNotification0x210PushHandler();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<Integer> notifiedIds = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final TroopNotification0x210PushHandler$qqAccountLogoutReceiver$1 qqAccountLogoutReceiver;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.troop.troopnotification.push.TroopNotification0x210PushHandler$qqAccountLogoutReceiver$1, android.content.BroadcastReceiver] */
    static {
        ?? r06 = new BroadcastReceiver() { // from class: com.tencent.mobileqq.troop.troopnotification.push.TroopNotification0x210PushHandler$qqAccountLogoutReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                copyOnWriteArrayList = TroopNotification0x210PushHandler.notifiedIds;
                for (Integer id5 : copyOnWriteArrayList) {
                    QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(id5, "id");
                    qQNotificationManager.cancel("TroopNotification0x210PushHandler", id5.intValue());
                }
                copyOnWriteArrayList2 = TroopNotification0x210PushHandler.notifiedIds;
                copyOnWriteArrayList2.clear();
            }
        };
        qqAccountLogoutReceiver = r06;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
        BaseApplication.context.registerReceiver(r06, intentFilter);
    }

    TroopNotification0x210PushHandler() {
    }

    private final boolean b(QQAppInterface app) {
        if (!QQNotificationManager.getInstance().areNotificationsEnabled(app.getApplication())) {
            QLog.i("TroopNotification0x210PushHandler", 1, "[canShowNotification] false, notification disable");
            return false;
        }
        if (!d(app)) {
            return true;
        }
        QLog.i("TroopNotification0x210PushHandler", 1, "canShowNotification false, inNotDisturb");
        return false;
    }

    private final void c(QQAppInterface app, MsgContentPB$MsgContent msgContent) {
        if (b(app)) {
            f(app, msgContent);
        }
    }

    private final boolean d(QQAppInterface app) {
        boolean c16 = FriendsStatusUtil.c(BaseApplication.context);
        IRuntimeService runtimeService = app.getRuntimeService(IOnlineStatusService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026tatusService::class.java)");
        return c16 || (((IOnlineStatusService) runtimeService).getOnlineStatus() == AppRuntime.Status.dnd);
    }

    private final void f(QQAppInterface app, MsgContentPB$MsgContent msgContent) {
        String str;
        String stringUtf8 = msgContent.jump_schema.get().toStringUtf8();
        BaseApplication baseApplication = BaseApplication.context;
        try {
            str = Uri.parse(stringUtf8).buildUpon().build().toString();
        } catch (Exception e16) {
            QLog.e("TroopNotification0x210PushHandler", 1, "[showNotification] append param failed, url = " + stringUtf8, e16);
            str = stringUtf8;
        }
        QLog.i("TroopNotification0x210PushHandler", 1, "[showNotification] originSchema = " + stringUtf8 + " targetUrl = " + str);
        Intent intent = new Intent();
        intent.putExtra("type", 2);
        Intent clickIntent = MsgNotification.getClickIntent(baseApplication);
        clickIntent.putExtra("realIntent", intent);
        clickIntent.putExtra("pushschema", str);
        Notification build = new NotificationCompat.Builder(BaseApplication.context, QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.b8g).setContentTitle(msgContent.title.get().toStringUtf8()).setContentText(msgContent.summary.get().toStringUtf8()).setWhen(System.currentTimeMillis()).setPriority(1).setContentIntent(MsgNotification.getPendingIntent(baseApplication, NotificationUtil.Constants.NOTIFY_ID_TROOP_NOTIFICATION_PUSH, clickIntent)).setAutoCancel(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(BaseApplication.\u2026rue)\n            .build()");
        QQNotificationManager.getInstance().notify("TroopNotification0x210PushHandler", NotificationUtil.Constants.NOTIFY_ID_TROOP_NOTIFICATION_PUSH, build);
        app.vibratorAndAudio();
        notifiedIds.addIfAbsent(Integer.valueOf(msgContent.hashCode()));
    }

    public final void e(QQAppInterface app, byte[] data) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(data, "data");
        nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
        MsgContentPB$MsgContent msgContentPB$MsgContent = new MsgContentPB$MsgContent();
        try {
            nt_msg_common_msg.mergeFrom(data);
            msgContentPB$MsgContent.mergeFrom(nt_msg_common_msg.body.msg_content.get().toByteArray());
        } catch (Exception e16) {
            QLog.e("TroopNotification0x210PushHandler", 1, "[onReceive] parse data error, e = " + e16);
        }
        c(app, msgContentPB$MsgContent);
    }
}
