package com.tencent.mobileqq.qqlive.room.floatview;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.timi.ITimiAnchor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0002J8\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\"\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016R\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/floatview/QQLiveGameRoomService;", "Landroid/app/Service;", "", "anchorName", "", "scene", "Landroid/app/Notification;", "d", "(Ljava/lang/String;Ljava/lang/Integer;)Landroid/app/Notification;", "Landroid/content/Intent;", "c", "title", "content", "icon", "Landroid/graphics/Bitmap;", "largeIcon", "Landroid/app/PendingIntent;", "pendingIntent", "g", "intent", WadlProxyConsts.FLAGS, "startId", "onStartCommand", "Landroid/os/IBinder;", "onBind", "rootIntent", "", "onTaskRemoved", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "mUpdateNotificationRun", "f", "Landroid/app/Notification;", "screenCaptureNotification", "", h.F, "Z", "mIsDestroy", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveGameRoomService extends Service {
    static IPatchRedirector $redirector_;

    @JvmField
    public static final int C;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    @JvmField
    public static final int f271544m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mUpdateNotificationRun;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Notification screenCaptureNotification;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\n\u001a\u00020\bH\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/floatview/QQLiveGameRoomService$a;", "", "", "a", "", "scene", "", "anchorName", "", "b", "c", "NID", "I", "PARAM_ANCHOR_NAME", "Ljava/lang/String;", "PARAM_SCENE", "SCENE_FLOATING_WINDOW", "SCENE_SCREEN_CAPTURE", "TAG", "", "UPDATE_NOTIFICATION_TIME", "J", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.floatview.QQLiveGameRoomService$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        private final boolean a() {
            List<ActivityManager.RunningServiceInfo> runningServices;
            String name = QQLiveGameRoomService.class.getName();
            Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (systemService != null && (systemService instanceof ActivityManager) && (runningServices = ((ActivityManager) systemService).getRunningServices(100)) != null && (!runningServices.isEmpty())) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    ComponentName componentName = runningServiceInfo.service;
                    if (componentName != null && runningServiceInfo.process != null && Intrinsics.areEqual(componentName.getClassName(), name)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @JvmStatic
        public final void b(int scene, @Nullable String anchorName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, scene, (Object) anchorName);
                return;
            }
            Intent intent = new Intent(BaseApplication.context, (Class<?>) QQLiveGameRoomService.class);
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Open_Live|ForegroundService", "startForegroundService", "startForeground");
            if (a()) {
                BaseApplication.context.stopService(intent);
                companion.w("Open_Live|ForegroundService", "startForegroundService", "service is running!");
            } else {
                intent.putExtra("PARAM_ANCHOR_NAME", anchorName);
                intent.putExtra("PARAM_SCENE", scene);
                BaseApplication.context.startService(intent);
            }
        }

        @JvmStatic
        public final void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|ForegroundService", "startForegroundService", "stopService");
            BaseApplication.context.stopService(new Intent(BaseApplication.context, (Class<?>) QQLiveGameRoomService.class));
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24559);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        f271544m = 1;
        C = 2;
    }

    public QQLiveGameRoomService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper());
            this.mUpdateNotificationRun = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.floatview.QQLiveGameRoomService$mUpdateNotificationRun$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveGameRoomService.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Notification notification;
                    Handler handler;
                    Notification notification2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        notification = QQLiveGameRoomService.this.screenCaptureNotification;
                        Unit unit = null;
                        if (notification != null) {
                            AegisLogger.INSTANCE.i("Open_Live|ForegroundService", "mUpdateNotificationRun", "UpdateNotificationRun send GuardManager.EVENT_MSG");
                            GuardManager guardManager = GuardManager.sInstance;
                            if (guardManager != null) {
                                guardManager.onEvent(0, null);
                                unit = Unit.INSTANCE;
                            }
                        }
                        if (unit == null) {
                            QQLiveGameRoomService qQLiveGameRoomService = QQLiveGameRoomService.this;
                            AegisLogger.INSTANCE.w("Open_Live|ForegroundService", "mUpdateNotificationRun", "startForeground");
                            notification2 = qQLiveGameRoomService.screenCaptureNotification;
                            qQLiveGameRoomService.startForeground(NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COMMEN, notification2);
                        }
                        handler = QQLiveGameRoomService.this.mHandler;
                        handler.postDelayed(this, 30000L);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            };
        }
    }

    private final Intent c() {
        Intent intent = new Intent();
        intent.putExtra("fromSource", 6);
        ITimiAnchor iTimiAnchor = (ITimiAnchor) QRoute.api(ITimiAnchor.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return iTimiAnchor.insertJumpDestination(context, intent);
    }

    private final Notification d(String anchorName, Integer scene) {
        String string;
        PendingIntent pendingIntent;
        if (this.mIsDestroy) {
            return null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.f210775j1);
        Intrinsics.checkNotNullExpressionValue(string2, "this.getString(R.string.qqlive_notification_title)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{anchorName}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        int i3 = f271544m;
        if (scene != null && scene.intValue() == i3) {
            string = getString(R.string.f210755iz);
        } else {
            string = getString(R.string.f210765j0);
        }
        String str = string;
        Intrinsics.checkNotNullExpressionValue(str, "if (scene == SCENE_SCREE\u2026tification_obs)\n        }");
        try {
            pendingIntent = PendingIntent.getActivity(this, 0, c(), 201326592);
        } catch (Throwable th5) {
            AegisLogger.INSTANCE.e("Open_Live|ForegroundService", "createScreenCaptureNotification", "pendingIntent create error", th5);
            pendingIntent = null;
        }
        if (pendingIntent == null) {
            return null;
        }
        return g(format, str, R.drawable.b8g, null, pendingIntent);
    }

    @JvmStatic
    public static final void e(int i3, @Nullable String str) {
        INSTANCE.b(i3, str);
    }

    @JvmStatic
    public static final void f() {
        INSTANCE.c();
    }

    private final Notification g(String title, String content, int icon, Bitmap largeIcon, PendingIntent pendingIntent) {
        NotificationCompat.Builder createNotificationCompatBuilder = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
        createNotificationCompatBuilder.setSmallIcon(icon);
        createNotificationCompatBuilder.setContentTitle(title);
        createNotificationCompatBuilder.setContentText(content);
        createNotificationCompatBuilder.setWhen(System.currentTimeMillis());
        createNotificationCompatBuilder.setLargeIcon(largeIcon);
        createNotificationCompatBuilder.setContentIntent(pendingIntent);
        createNotificationCompatBuilder.setPriority(-1);
        createNotificationCompatBuilder.setFullScreenIntent(null, false);
        createNotificationCompatBuilder.setVibrate(null);
        Notification build = createNotificationCompatBuilder.build();
        int i3 = (build.flags | 2 | 32 | 8) & (-5) & (-2);
        build.flags = i3;
        build.visibility = -1;
        build.category = null;
        build.flags = i3 & (-129);
        return build;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            AegisLogger.INSTANCE.i("Open_Live|ForegroundService", "onCreate");
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|ForegroundService", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mIsDestroy = true;
        this.mHandler.removeCallbacksAndMessages(null);
        stopForeground(true);
        TGLiveFloatManager.f377649d.n();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, intent, Integer.valueOf(flags), Integer.valueOf(startId))).intValue();
        }
        super.onStartCommand(intent, flags, startId);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|ForegroundService", "onStartCommand", "start");
        Integer num = null;
        if (intent != null) {
            str = intent.getStringExtra("PARAM_ANCHOR_NAME");
        } else {
            str = null;
        }
        if (intent != null) {
            num = Integer.valueOf(intent.getIntExtra("PARAM_SCENE", f271544m));
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            QQNotificationManager.getInstance();
            Notification d16 = d(str, num);
            this.screenCaptureNotification = d16;
            if (d16 == null) {
                companion.e("Open_Live|ForegroundService", "onStartCommand", "create notification error!");
                return 2;
            }
            try {
                startForeground(NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COMMEN, d16);
                this.mHandler.postDelayed(this.mUpdateNotificationRun, 30000L);
                companion.i("Open_Live|ForegroundService", "onStartCommand", "end");
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Open_Live|ForegroundService", "onStartCommand", "startForegrundService error!", e16);
                return 2;
            }
        } else {
            companion.e("Open_Live|ForegroundService", "onStartCommand", "illegal param");
        }
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent rootIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootIntent);
        } else {
            AegisLogger.INSTANCE.i("Open_Live|ForegroundService", "onTaskRemoved");
            super.onTaskRemoved(rootIntent);
        }
    }
}
