package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AlarmManagerCompat {
    AlarmManagerCompat() {
    }

    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long j3, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j3, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i3, long j3, @NonNull PendingIntent pendingIntent) {
        alarmManager.setAndAllowWhileIdle(i3, j3, pendingIntent);
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int i3, long j3, @NonNull PendingIntent pendingIntent) {
        alarmManager.setExact(i3, j3, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i3, long j3, @NonNull PendingIntent pendingIntent) {
        alarmManager.setExactAndAllowWhileIdle(i3, j3, pendingIntent);
    }
}
