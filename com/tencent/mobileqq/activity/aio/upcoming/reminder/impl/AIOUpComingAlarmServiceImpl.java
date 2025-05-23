package com.tencent.mobileqq.activity.aio.upcoming.reminder.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.aio.upcoming.reminder.AIOUpComingAlarmReceiver;
import com.tencent.mobileqq.activity.aio.upcoming.reminder.IAIOUpComingAlarmService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001dj\b\u0012\u0004\u0012\u00020\u0002`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/upcoming/reminder/impl/AIOUpComingAlarmServiceImpl;", "Lcom/tencent/mobileqq/activity/aio/upcoming/reminder/IAIOUpComingAlarmService;", "", "requestCode", "", "removeRequestCode", "cancelAlarm", "Landroid/content/Context;", "context", "registerAlarmBroadcastReceiver", "unregisterAlarmBroadcastReceiver", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "time", "Lcom/tencent/mobileqq/colornote/data/ColorNote;", "colorNote", "setAlarm", "", QCircleLpReportDc010001.KEY_SUBTYPE, "notifyAlarm", "", "mIsRegistered", "Z", "Lcom/tencent/mobileqq/activity/aio/upcoming/reminder/AIOUpComingAlarmReceiver;", "mReceiver", "Lcom/tencent/mobileqq/activity/aio/upcoming/reminder/AIOUpComingAlarmReceiver;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mRequestMap", "Ljava/util/HashSet;", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOUpComingAlarmServiceImpl implements IAIOUpComingAlarmService {

    @NotNull
    public static final String KEY_COLOR_NOTE = "key_color_note";

    @NotNull
    public static final String NOTIFICATION_ALARM_ACTION = "aio_upcoming_alarm";

    @NotNull
    private static final String TAG = "AIOUpComingAlarmServiceImpl";
    private boolean mIsRegistered;

    @NotNull
    private final AIOUpComingAlarmReceiver mReceiver = new AIOUpComingAlarmReceiver();

    @NotNull
    private final HashSet<Integer> mRequestMap = new HashSet<>();

    private final void registerAlarmBroadcastReceiver(Context context) {
        if (this.mIsRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        try {
            intentFilter.addAction(NOTIFICATION_ALARM_ACTION);
            context.registerReceiver(this.mReceiver, intentFilter);
            this.mIsRegistered = true;
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[registerAlarmBroadcastReceiver]: " + th5);
        }
    }

    private final void removeRequestCode(int requestCode) {
        if (this.mRequestMap.contains(Integer.valueOf(requestCode))) {
            this.mRequestMap.remove(Integer.valueOf(requestCode));
            QLog.i(TAG, 1, "[removeRequestCode]: requestCode is " + requestCode);
        }
    }

    private final void unregisterAlarmBroadcastReceiver(Context context) {
        if (!this.mIsRegistered) {
            return;
        }
        try {
            Iterator<T> it = this.mRequestMap.iterator();
            while (it.hasNext()) {
                cancelAlarm(((Number) it.next()).intValue());
            }
            this.mRequestMap.clear();
            context.unregisterReceiver(this.mReceiver);
            this.mIsRegistered = false;
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[unregisterAlarmBroadcastReceiver]: " + th5);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.upcoming.reminder.IAIOUpComingAlarmService
    public void cancelAlarm(@NotNull ColorNote colorNote) {
        Unit unit;
        Intrinsics.checkNotNullParameter(colorNote, "colorNote");
        String subType = colorNote.getSubType();
        if (subType != null) {
            int hashCode = subType.hashCode();
            cancelAlarm(hashCode);
            removeRequestCode(hashCode);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i(TAG, 1, "[cancleAlarm]: subType is null");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.upcoming.reminder.IAIOUpComingAlarmService
    public void notifyAlarm(@NotNull String subType) {
        Intrinsics.checkNotNullParameter(subType, "subType");
        removeRequestCode(subType.hashCode());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        registerAlarmBroadcastReceiver(context);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        unregisterAlarmBroadcastReceiver(context);
    }

    @Override // com.tencent.mobileqq.activity.aio.upcoming.reminder.IAIOUpComingAlarmService
    public void setAlarm(long time, @NotNull ColorNote colorNote) {
        Intrinsics.checkNotNullParameter(colorNote, "colorNote");
        try {
            if (time > NetConnInfoCenter.getServerTimeMillis()) {
                Intent intent = new Intent();
                int hashCode = colorNote.getSubType().hashCode();
                intent.setAction(NOTIFICATION_ALARM_ACTION);
                intent.putExtra("key_color_note", colorNote.mSubType);
                PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.context, hashCode, intent, 67108864);
                AlarmManager alarmManager = (AlarmManager) BaseApplication.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                if (alarmManager != null) {
                    alarmManager.setExactAndAllowWhileIdle(0, time, broadcast);
                    if (!this.mRequestMap.contains(Integer.valueOf(hashCode))) {
                        this.mRequestMap.add(Integer.valueOf(hashCode));
                    }
                    QLog.i(TAG, 1, "[setAlarm]: time is " + time + ", requestCode is " + hashCode);
                    return;
                }
                return;
            }
            QLog.i(TAG, 1, "[setAlarm]: time less than currentTime");
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[setAlarm]: " + th5);
        }
    }

    private final void cancelAlarm(int requestCode) {
        try {
            Intent intent = new Intent();
            intent.setAction(NOTIFICATION_ALARM_ACTION);
            PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.context, requestCode, intent, 67108864);
            AlarmManager alarmManager = (AlarmManager) BaseApplication.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.cancel(broadcast);
                QLog.i(TAG, 1, "[cancelAlarm]: requestCode is " + requestCode);
            }
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[cancelAlarm]: " + th5);
        }
    }
}
