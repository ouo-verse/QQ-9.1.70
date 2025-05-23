package com.tencent.biz.qrcode.logindev.pclock;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.qrcode.activity.UnlockPCQuickVerifyActivity;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qrcode/logindev/pclock/b;", "", "Lcom/tencent/biz/qrcode/logindev/pclock/f;", "devInfo", "", "e", "b", "c", "", "Z", "d", "()Z", "setCancelNotification", "(Z)V", "cancelNotification", "Lcom/tencent/biz/qrcode/logindev/pclock/f;", "mUnlockPCDevInfo", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mNotificationRunnable", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean cancelNotification;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static UnlockPCPushModel mUnlockPCDevInfo;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f94950a = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Runnable mNotificationRunnable = new Runnable() { // from class: com.tencent.biz.qrcode.logindev.pclock.a
        @Override // java.lang.Runnable
        public final void run() {
            b.f();
        }
    };

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        if (QLog.isColorLevel()) {
            QLog.i("DevLock", 2, "notification runnable run.");
        }
        f94950a.b();
    }

    public final void b() {
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (qQNotificationManager != null) {
            try {
                ThreadManager.getUIHandler().removeCallbacks(mNotificationRunnable);
                qQNotificationManager.cancel("LockPCStatusManager", NotificationUtil.Constants.NOTIFY_ID_UNLOCK_PC_PUSH);
                cancelNotification = false;
            } catch (Throwable unused) {
                QLog.e("LockPCStatusManager", 1, "cancelUnlockPCNotification failed");
            }
            mUnlockPCDevInfo = null;
        }
    }

    public final void c() {
        if (mUnlockPCDevInfo == null) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Intent intent = new Intent();
        intent.setClass(context, UnlockPCQuickVerifyActivity.class);
        UnlockPCPushModel unlockPCPushModel = mUnlockPCDevInfo;
        Intrinsics.checkNotNull(unlockPCPushModel);
        intent.putExtra("instanceId", unlockPCPushModel.getInstanceId());
        UnlockPCPushModel unlockPCPushModel2 = mUnlockPCDevInfo;
        Intrinsics.checkNotNull(unlockPCPushModel2);
        intent.putExtra("deviceName", unlockPCPushModel2.getDevName());
        UnlockPCPushModel unlockPCPushModel3 = mUnlockPCDevInfo;
        Intrinsics.checkNotNull(unlockPCPushModel3);
        intent.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, unlockPCPushModel3.getPlatformId());
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        context.startActivity(intent);
        mUnlockPCDevInfo = null;
    }

    public final boolean d() {
        return cancelNotification;
    }

    public final void e(@NotNull UnlockPCPushModel devInfo) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(devInfo, "devInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (!qQAppInterface.isBackgroundPause && !qQAppInterface.isBackgroundStop) {
            z16 = false;
        } else {
            z16 = true;
        }
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (z16) {
            int platformId = devInfo.getPlatformId();
            if (platformId != 1024) {
                if (platformId != 1029) {
                    if (platformId != 1031) {
                        if (platformId != 1035) {
                            str = "\u7535\u8111";
                        } else {
                            str = "Harmony";
                        }
                    } else {
                        str = "Linux";
                    }
                } else {
                    str = Global.TRACKING_MAC;
                }
            } else {
                str = "Windows";
            }
            Bitmap g16 = j.g(context.getResources(), R.drawable.qfile_dataline_pc_recent);
            NotificationCompat.Builder when = new NotificationCompat.Builder(context).setContentTitle("QQ").setContentText("\u89e3\u9501\u4f60\u7684 " + str + " QQ").setAutoCancel(true).setSmallIcon(R.drawable.qfile_dataline_pc_recent).setWhen(System.currentTimeMillis());
            Intrinsics.checkNotNullExpressionValue(when, "Builder(ctx)\n           \u2026stem.currentTimeMillis())");
            if (g16 != null) {
                when.setLargeIcon(g16);
            } else {
                when.setLargeIcon(j.g(context.getResources(), R.drawable.qfile_dataline_pc_recent));
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.setClass(context, UnlockPCQuickVerifyActivity.class);
            intent.putExtra("instanceId", devInfo.getInstanceId());
            intent.putExtra("deviceName", devInfo.getDevName());
            intent.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, devInfo.getPlatformId());
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, NotificationUtil.Constants.NOTIFY_ID_UNLOCK_PC_PUSH);
            when.setContentIntent(PendingIntent.getActivity(context, 0, intent, 201326592));
            if (Build.VERSION.SDK_INT >= 26) {
                when.setChannelId(QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
            }
            Notification build = when.build();
            Intrinsics.checkNotNullExpressionValue(build, "nb.build()");
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            if (qQNotificationManager == null) {
                return;
            }
            qQNotificationManager.cancel("LockPCStatusManager", NotificationUtil.Constants.NOTIFY_ID_UNLOCK_PC_PUSH);
            cancelNotification = true;
            qQNotificationManager.notify("LockPCStatusManager", NotificationUtil.Constants.NOTIFY_ID_UNLOCK_PC_PUSH, build);
            mUnlockPCDevInfo = devInfo;
            ThreadManager.getUIHandler().removeCallbacks(mNotificationRunnable);
            ThreadManager.getUIHandler().postDelayed(mNotificationRunnable, 120000L);
            return;
        }
        Intent intent2 = new Intent();
        intent2.setClass(context, UnlockPCQuickVerifyActivity.class);
        intent2.putExtra("instanceId", devInfo.getInstanceId());
        intent2.putExtra("deviceName", devInfo.getDevName());
        intent2.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, devInfo.getPlatformId());
        intent2.addFlags(268435456);
        intent2.addFlags(67108864);
        context.startActivity(intent2);
    }
}
