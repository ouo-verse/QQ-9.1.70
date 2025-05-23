package cooperation.qqcircle.utils.web;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.remoteweb.IRemoteRenderService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0010\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001dH\u0016J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eJ2\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020)H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011\u00a8\u0006+"}, d2 = {"Lcooperation/qqcircle/utils/web/QFSWebForegroundService;", "Lcom/tencent/mobileqq/remoteweb/IRemoteRenderService;", "()V", "mAudioNotification", "Landroid/app/Notification;", "mHandler", "Landroid/os/Handler;", "mIsDestroy", "", "mPageIdSets", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mService", "Landroid/app/Service;", "mUpdateNotificationRun", "cooperation/qqcircle/utils/web/QFSWebForegroundService$mUpdateNotificationRun$1", "Lcooperation/qqcircle/utils/web/QFSWebForegroundService$mUpdateNotificationRun$1;", "checkPageListAndStopServices", "", "service", "createAudioNotification", "icon", "Landroid/graphics/drawable/Drawable;", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onStartCommand", "", "intent", "Landroid/content/Intent;", WadlProxyConsts.FLAGS, "startId", "startForeground", "stopForeground", "useDefaultStyle", "title", "content", "largeIcon", "pendingIntent", "Landroid/app/PendingIntent;", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class QFSWebForegroundService implements IRemoteRenderService {

    @NotNull
    public static final String EVENT_KILL_NOTIFY_SERVICE = "EVENT_KILL_NOTIFY_SERVICE";

    @NotNull
    public static final String EVENT_SHOW_NOTIFY_SERVICE = "EVENT_SHOW_NOTIFY_SERVICE";
    private static final int NID = 3000536;

    @NotNull
    private static final String NOTIFICATION_ICON_CACHE_KEY = "remote_render_notify";

    @NotNull
    public static final String REMOTE_SERVICE_TYPE_MEDIA_WEB = "qcircle";

    @NotNull
    private static final String TAG = "QFSWebForegroundService";
    private static final long UPDATE_NOTIFICATION_TIME = 30000;

    @Nullable
    private Notification mAudioNotification;
    private boolean mIsDestroy;

    @Nullable
    private Service mService;

    @NotNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @NotNull
    private final HashSet<String> mPageIdSets = new HashSet<>();

    @NotNull
    private final QFSWebForegroundService$mUpdateNotificationRun$1 mUpdateNotificationRun = new Runnable() { // from class: cooperation.qqcircle.utils.web.QFSWebForegroundService$mUpdateNotificationRun$1
        @Override // java.lang.Runnable
        public void run() {
            Notification notification;
            Handler handler;
            Service service;
            Notification notification2;
            notification = QFSWebForegroundService.this.mAudioNotification;
            if (notification != null) {
                QLog.d("QFSWebForegroundService", 1, "UpdateNotificationRun startForeground");
                service = QFSWebForegroundService.this.mService;
                if (service != null) {
                    notification2 = QFSWebForegroundService.this.mAudioNotification;
                    service.startForeground(NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COMMEN, notification2);
                }
            }
            handler = QFSWebForegroundService.this.mHandler;
            handler.postDelayed(this, 30000L);
        }
    };

    private final void checkPageListAndStopServices(Service service) {
        if (this.mPageIdSets.isEmpty()) {
            RFWLog.d(TAG, RFWLog.USR, "checkPageListAndStopServices pageList is empty");
            stopForeground(service);
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "checkPageListAndStopServices pageList is not empty\uff0csize:" + this.mPageIdSets.size());
    }

    private final Notification createAudioNotification(Service service, Drawable icon) {
        PendingIntent pendingIntent;
        if (this.mIsDestroy) {
            return null;
        }
        String string = service.getResources().getString(R.string.f1905642f);
        Intrinsics.checkNotNullExpressionValue(string, "service.resources.getStr\u2026foreground_service_title)");
        String string2 = service.getResources().getString(R.string.f1905542e);
        Intrinsics.checkNotNullExpressionValue(string2, "service.resources.getStr\u2026_foreground_service_desc)");
        if (icon == null) {
            icon = service.getResources().getDrawable(R.drawable.qui_tab_new_btm_small_world_default_pressed);
        }
        Intrinsics.checkNotNull(icon);
        Bitmap drawableToBitmap = drawableToBitmap(icon);
        try {
            pendingIntent = PendingIntent.getActivity(service, 0, new Intent(), 201326592);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[createAudioNotification] pendingIntent error " + th5);
            pendingIntent = null;
        }
        if (pendingIntent == null) {
            return null;
        }
        return useDefaultStyle(string, string2, R.drawable.qui_tab_new_btm_small_world_default_pressed, drawableToBitmap, pendingIntent);
    }

    private final Notification useDefaultStyle(String title, String content, int icon, Bitmap largeIcon, PendingIntent pendingIntent) {
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
        Notification notification = createNotificationCompatBuilder.build();
        notification.flags = (notification.flags | 2 | 32 | 8) & (-5) & (-2) & (-129);
        notification.visibility = -1;
        notification.category = null;
        Intrinsics.checkNotNullExpressionValue(notification, "notification");
        return notification;
    }

    @Nullable
    public final Bitmap drawableToBitmap(@NotNull Drawable drawable) {
        Bitmap.Config config;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    @Nullable
    public IBinder onBind(@NotNull Service service, @NotNull Intent intent) {
        return IRemoteRenderService.a.a(this, service, intent);
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onDestroy(@NotNull Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mIsDestroy = true;
        stopForeground(service);
        this.mService = null;
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onLowMemory(@NotNull Service service) {
        IRemoteRenderService.a.b(this, service);
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public int onStartCommand(@NotNull Service service, @NotNull Intent intent, int flags, int startId) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QQNotificationManager.getInstance();
        this.mService = service;
        String stringExtra = intent.getStringExtra("key_web_page_id");
        if (stringExtra == null) {
            RFWLog.d(TAG, RFWLog.USR, "onStartCommand(): webPageId: is null");
            checkPageListAndStopServices(service);
            return 2;
        }
        if (intent.getBooleanExtra(EVENT_KILL_NOTIFY_SERVICE, false)) {
            this.mPageIdSets.remove(stringExtra);
            RFWLog.d(TAG, RFWLog.USR, "onStartCommand(): webPageId: " + stringExtra + ", removed for foreground!, will stopForeground");
            checkPageListAndStopServices(service);
            return 2;
        }
        if (intent.getBooleanExtra(EVENT_SHOW_NOTIFY_SERVICE, false)) {
            this.mPageIdSets.add(stringExtra);
            startForeground(service);
            QLog.d(TAG, 1, "onStartCommand: Notification create and startForeground.webId:" + stringExtra);
            return 2;
        }
        checkPageListAndStopServices(service);
        return 2;
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onTaskRemoved(@NotNull Service service, @Nullable Intent intent) {
        IRemoteRenderService.a.c(this, service, intent);
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onTrimMemory(@NotNull Service service, int i3) {
        IRemoteRenderService.a.d(this, service, i3);
    }

    public final void startForeground(@NotNull Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        QLog.d(TAG, 1, "[startForeground] ");
        if (this.mAudioNotification == null) {
            Notification createAudioNotification = createAudioNotification(service, null);
            this.mAudioNotification = createAudioNotification;
            if (createAudioNotification == null) {
                QLog.e(TAG, 1, "[startForeground] error mAudioNotification is null!");
            }
        }
        Notification notification = this.mAudioNotification;
        if (notification != null) {
            service.startForeground(3000536, notification);
            this.mHandler.removeCallbacks(this.mUpdateNotificationRun);
            this.mHandler.postDelayed(this.mUpdateNotificationRun, 30000L);
        }
    }

    public final void stopForeground(@NotNull Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        QLog.d(TAG, 1, "[stopForeground] ");
        service.stopForeground(true);
        this.mHandler.removeCallbacks(this.mUpdateNotificationRun);
    }
}
