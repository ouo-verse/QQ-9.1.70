package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.Cdo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class dq implements Cdo.a {

    /* renamed from: b, reason: collision with root package name */
    protected Context f388621b;

    /* renamed from: a, reason: collision with root package name */
    private PendingIntent f388620a = null;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f388622c = 0;

    public dq(Context context) {
        this.f388621b = null;
        this.f388621b = context;
    }

    @Override // com.xiaomi.push.Cdo.a
    public void a(boolean z16) {
        long b16 = com.xiaomi.push.service.as.c(this.f388621b).b();
        if (z16 || this.f388622c != 0) {
            if (z16) {
                a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z16 || this.f388622c == 0) {
                this.f388622c = elapsedRealtime + (b16 - (elapsedRealtime % b16));
            } else if (this.f388622c <= elapsedRealtime) {
                this.f388622c += b16;
                if (this.f388622c < elapsedRealtime) {
                    this.f388622c = elapsedRealtime + b16;
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.r.f389788o);
            intent.setPackage(this.f388621b.getPackageName());
            b(intent, this.f388622c);
        }
    }

    public void b(Intent intent, long j3) {
        AlarmManager alarmManager = (AlarmManager) this.f388621b.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            this.f388620a = PendingIntent.getBroadcast(this.f388621b, 0, intent, 33554432);
        } else {
            this.f388620a = PendingIntent.getBroadcast(this.f388621b, 0, intent, 0);
        }
        if (i3 >= 31 && !hz.j(this.f388621b)) {
            alarmManager.set(2, j3, this.f388620a);
        } else {
            y.e(alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j3), this.f388620a);
        }
        jz4.c.z("[Alarm] register timer " + j3);
    }

    @Override // com.xiaomi.push.Cdo.a
    public void a() {
        if (this.f388620a != null) {
            try {
                ((AlarmManager) this.f388621b.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f388620a);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                this.f388620a = null;
                jz4.c.z("[Alarm] unregister timer");
                this.f388622c = 0L;
                throw th5;
            }
            this.f388620a = null;
            jz4.c.z("[Alarm] unregister timer");
            this.f388622c = 0L;
        }
        this.f388622c = 0L;
    }

    @Override // com.xiaomi.push.Cdo.a
    /* renamed from: a */
    public boolean mo301a() {
        return this.f388622c != 0;
    }
}
