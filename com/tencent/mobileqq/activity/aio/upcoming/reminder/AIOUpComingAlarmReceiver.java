package com.tencent.mobileqq.activity.aio.upcoming.reminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.upcoming.reminder.impl.AIOUpComingAlarmServiceImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import z61.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/upcoming/reminder/AIOUpComingAlarmReceiver;", "Landroid/content/BroadcastReceiver;", "", QCircleLpReportDc010001.KEY_SUBTYPE, "", "a", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOUpComingAlarmReceiver extends BroadcastReceiver {
    private final void a(String subType) {
        d dVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("AIOUpComingAlarmReceiver", 1, "[notifyUpComing]: app is null");
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER);
        if (manager instanceof d) {
            dVar = (d) manager;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            dVar.k(subType);
        }
        ((IAIOUpComingAlarmService) peekAppRuntime.getRuntimeService(IAIOUpComingAlarmService.class, "")).notifyAlarm(subType);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOUpComingAlarmReceiver", 4, "[onReceive]: action is " + intent.getAction());
        }
        String action = intent.getAction();
        if (action != null) {
            z16 = action.equals(AIOUpComingAlarmServiceImpl.NOTIFICATION_ALARM_ACTION);
        } else {
            z16 = false;
        }
        if (z16) {
            String stringExtra = intent.getStringExtra("key_color_note");
            QLog.i("AIOUpComingAlarmReceiver", 1, "[onReceive]: colorNote is " + stringExtra);
            if (stringExtra != null) {
                a(stringExtra);
            } else {
                QLog.i("AIOUpComingAlarmReceiver", 1, "[onReceive]: colorNote is null");
            }
        }
    }
}
