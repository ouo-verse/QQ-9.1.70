package com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 -2\u00020\u0001:\u0002\u000f\u0010B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001f\u0010\u0016\u001a\u00060\u0011R\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/AlarmExecutorImpl;", "Lfu2/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/AlarmExecutorImpl$b;", "task", DomainData.DOMAIN_NAME, "", "i", h.F, "Ljava/lang/Runnable;", "runnable", "", "time", "a", "b", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "Lkotlin/Lazy;", "k", "()Landroid/os/PowerManager$WakeLock;", "wakeLock", "Landroid/app/AlarmManager;", "Landroid/app/AlarmManager;", "alarmManager", "Landroid/content/BroadcastReceiver;", "c", "Landroid/content/BroadcastReceiver;", "alarmReceiver", "d", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/AlarmExecutorImpl$b;", "currTask", "", "e", "Ljava/lang/String;", "timerId", "f", "weakLockTag", "Landroid/app/Application;", "j", "()Landroid/app/Application;", "context", "<init>", "()V", "g", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class AlarmExecutorImpl implements fu2.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy wakeLock;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AlarmManager alarmManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BroadcastReceiver alarmReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile b currTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String timerId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String weakLockTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/AlarmExecutorImpl$b;", "", "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "c", "()Ljava/lang/Runnable;", "runnable", "Landroid/app/PendingIntent;", "b", "Landroid/app/PendingIntent;", "()Landroid/app/PendingIntent;", "intent", "", "J", "()J", "runTime", "<init>", "(Ljava/lang/Runnable;Landroid/app/PendingIntent;J)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Runnable runnable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PendingIntent intent;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long runTime;

        public b(@NotNull Runnable runnable, @NotNull PendingIntent intent, long j3) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.runnable = runnable;
            this.intent = intent;
            this.runTime = j3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final PendingIntent getIntent() {
            return this.intent;
        }

        /* renamed from: b, reason: from getter */
        public final long getRunTime() {
            return this.runTime;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Runnable getRunnable() {
            return this.runnable;
        }
    }

    public AlarmExecutorImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PowerManager.WakeLock>() { // from class: com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl.AlarmExecutorImpl$wakeLock$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PowerManager.WakeLock invoke() {
                Application j3;
                String str;
                j3 = AlarmExecutorImpl.this.j();
                Object systemService = j3.getSystemService("power");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                str = AlarmExecutorImpl.this.weakLockTag;
                return ((PowerManager) systemService).newWakeLock(1, str);
            }
        });
        this.wakeLock = lazy;
        Object systemService = j().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        this.alarmManager = (AlarmManager) systemService;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl.AlarmExecutorImpl$alarmReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String str;
                String str2;
                if (intent != null) {
                    str = intent.getAction();
                } else {
                    str = null;
                }
                str2 = AlarmExecutorImpl.this.timerId;
                if (Intrinsics.areEqual(str, str2)) {
                    QLog.i("AlarmExecutorImpl", 1, "alarmReceiver onReceive");
                    AlarmExecutorImpl.this.l();
                    AlarmExecutorImpl.this.h();
                }
            }
        };
        this.alarmReceiver = broadcastReceiver;
        String str = j().getPackageName() + "LoginRefreshAlarm";
        this.timerId = str;
        this.weakLockTag = j().getPackageName() + ".LoginWakeLock";
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        try {
            j().registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.i("AlarmExecutorImpl", 1, "registerReceiver exception: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        try {
            k().setReferenceCounted(false);
            if (k().isHeld()) {
                k().release();
            }
            k().acquire(12000L);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final int i() {
        if (Build.VERSION.SDK_INT > 23) {
            return 201326592;
        }
        return 134217728;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Application j() {
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        return application;
    }

    private final PowerManager.WakeLock k() {
        Object value = this.wakeLock.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-wakeLock>(...)");
        return (PowerManager.WakeLock) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        synchronized (this) {
            b bVar = this.currTask;
            if (bVar != null) {
                bVar.getRunnable().run();
            }
            this.currTask = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void m() {
        synchronized (this) {
            b bVar = this.currTask;
            if (bVar != null) {
                QLog.d("AlarmExecutorImpl", 1, "internalTryCancel: do cancel alarm");
                this.alarmManager.cancel(bVar.getIntent());
            }
            this.currTask = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void n(b task) {
        try {
            this.alarmManager.set(1, task.getRunTime(), task.getIntent());
        } catch (IllegalStateException e16) {
            QLog.i("AlarmExecutorImpl", 1, "setAlarm exception: " + e16.getMessage());
        }
    }

    @Override // fu2.d
    public void a(@NotNull Runnable runnable, long time) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        synchronized (this) {
            QLog.i("AlarmExecutorImpl", 1, "runAtTime: " + time);
            m();
            PendingIntent intent = PendingIntent.getBroadcast(j(), 1, new Intent(this.timerId), i());
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            b bVar = new b(runnable, intent, time);
            n(bVar);
            this.currTask = bVar;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // fu2.d
    public void b(@NotNull Runnable runnable) {
        Runnable runnable2;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        synchronized (this) {
            QLog.i("AlarmExecutorImpl", 1, "cancel");
            b bVar = this.currTask;
            if (bVar != null) {
                runnable2 = bVar.getRunnable();
            } else {
                runnable2 = null;
            }
            if (Intrinsics.areEqual(runnable, runnable2)) {
                m();
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
