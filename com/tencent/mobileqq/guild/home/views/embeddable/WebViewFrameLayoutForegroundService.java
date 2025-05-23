package com.tencent.mobileqq.guild.home.views.embeddable;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.os.BundleKt;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.remoteweb.IRemoteRenderService;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.vas.api.IVasAppIconStateManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.web.QFSWebForegroundService;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001,\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J<\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010&R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u000b0(j\b\u0012\u0004\u0012\u00020\u000b`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayoutForegroundService;", "Lcom/tencent/mobileqq/remoteweb/IRemoteRenderService;", "Landroid/app/Service;", "service", "", "e", "f", "Landroid/app/Notification;", "d", "Landroid/content/Context;", "context", "", "title", "content", "", "icon", "Landroid/graphics/Bitmap;", "largeIcon", "Landroid/app/PendingIntent;", "pendingIntent", "g", "Landroid/content/Intent;", "intent", WadlProxyConsts.FLAGS, "startId", "onStartCommand", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "Landroid/app/Notification;", "mAudioNotification", "b", "Landroid/app/Service;", "mService", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "mHandler", "", "Z", "mIsDestroy", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mPageIdSets", "com/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayoutForegroundService$mUpdateNotificationRun$1", "Lcom/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayoutForegroundService$mUpdateNotificationRun$1;", "mUpdateNotificationRun", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class WebViewFrameLayoutForegroundService implements IRemoteRenderService {

    /* renamed from: g, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    @Nullable
    private Notification mAudioNotification;

    /* renamed from: b, reason: from kotlin metadata */
    @Nullable
    private Service mService;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean mIsDestroy;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final HashSet<String> mPageIdSets = new HashSet<>();

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final WebViewFrameLayoutForegroundService$mUpdateNotificationRun$1 mUpdateNotificationRun = new Runnable() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.WebViewFrameLayoutForegroundService$mUpdateNotificationRun$1
        @Override // java.lang.Runnable
        public void run() {
            Notification notification;
            Handler handler;
            Service service;
            Notification notification2;
            if (RemoteWebRenderIPCClient.INSTANCE.a().M()) {
                notification = WebViewFrameLayoutForegroundService.this.mAudioNotification;
                if (notification != null) {
                    QLog.d("WebViewFrameLayoutForegroundService", 1, "UpdateNotificationRun startForeground");
                    service = WebViewFrameLayoutForegroundService.this.mService;
                    if (service != null) {
                        notification2 = WebViewFrameLayoutForegroundService.this.mAudioNotification;
                        service.startForeground(NotificationUtil.Constants.NOTIFY_ID_GUILD_MAINFRAME_RENDER, notification2);
                    }
                }
                handler = WebViewFrameLayoutForegroundService.this.mHandler;
                handler.postDelayed(this, 30000L);
                return;
            }
            QLog.e("WebViewFrameLayoutForegroundService", 1, "UpdateNotificationRun error render is empty!");
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!JL\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J(\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0007J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007R\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayoutForegroundService$a;", "", "Landroid/content/Context;", "context", "", "measuredWidth", "measuredHeight", "", "isSupportMultiDisplay", "", "webPageId", "url", "Landroid/view/Surface;", "surface", "Landroid/os/Bundle;", "extraInfo", "", "b", "e", "webpageId", "d", "isVisible", "a", QFSWebForegroundService.EVENT_KILL_NOTIFY_SERVICE, "Ljava/lang/String;", "NOTIFY_ID", "I", "SERVICE_TYPE_NAME", "TAG", "", "UPDATE_NOTIFICATION_TIME", "J", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.embeddable.WebViewFrameLayoutForegroundService$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, Context context, int i3, int i16, boolean z16, String str, String str2, Surface surface, Bundle bundle, int i17, Object obj) {
            Bundle bundle2;
            if ((i17 & 128) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            companion.b(context, i3, i16, z16, str, str2, surface, bundle2);
        }

        public final void a(@NotNull Context context, @NotNull String webPageId, boolean isVisible) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intent intent = new Intent(context, (Class<?>) PreloadWebService.class);
            try {
                intent.putExtra("key_enable_remote_web_render", true);
                intent.putExtra("key_remote_service_type", "GuildWebViewFrameLayout");
                intent.putExtra("key_web_page_id", webPageId);
                if (!isVisible) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                intent.putExtra(QFSWebForegroundService.EVENT_KILL_NOTIFY_SERVICE, z16);
                context.startService(intent);
            } catch (Throwable th5) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("[notifyWebForeground] error happens");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("WebViewFrameLayoutForegroundService", 1, (String) it.next(), th5);
                }
            }
        }

        @JvmStatic
        public final void b(@NotNull Context context, int measuredWidth, int measuredHeight, boolean isSupportMultiDisplay, @NotNull String webPageId, @NotNull String url, @NotNull Surface surface, @Nullable Bundle extraInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(surface, "surface");
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("key_web_view_width", Integer.valueOf(measuredWidth)), TuplesKt.to("key_web_view_height", Integer.valueOf(measuredHeight)), TuplesKt.to("key_enable_multi_display", Boolean.valueOf(isSupportMultiDisplay)), TuplesKt.to("key_remote_service_type", "GuildWebViewFrameLayout"));
            if (extraInfo != null) {
                bundleOf.putAll(extraInfo);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("WebViewFrameLayoutForegroundService", 2, "[startRemoteWebView] webPageId:" + webPageId + ", mUrl: " + url);
            }
            RemoteWebRenderIPCServer.INSTANCE.a().h0(url, surface, webPageId, context, bundleOf);
        }

        @JvmStatic
        public final void d(@NotNull Context context, @NotNull String webpageId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(webpageId, "webpageId");
            Intent intent = new Intent(context, (Class<?>) PreloadWebService.class);
            try {
                intent.putExtra("key_enable_remote_web_render", true);
                intent.putExtra("key_remote_service_type", "GuildWebViewFrameLayout");
                intent.putExtra("key_web_page_id", webpageId);
                intent.putExtra(QFSWebForegroundService.EVENT_KILL_NOTIFY_SERVICE, true);
                context.startService(intent);
            } catch (Throwable th5) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("[stopRemoteWebView] error happens");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("WebViewFrameLayoutForegroundService", 1, (String) it.next(), th5);
                }
            }
        }

        @JvmStatic
        public final void e(int measuredWidth, int measuredHeight, @NotNull String webPageId, @NotNull Surface surface) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(surface, "surface");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("WebViewFrameLayoutForegroundService", 2, "[updateRemoteWebView] webPageId:" + webPageId);
            }
            RemoteWebRenderIPCServer.k0(RemoteWebRenderIPCServer.INSTANCE.a(), webPageId, surface, measuredWidth, measuredHeight, null, 16, null);
        }

        Companion() {
        }
    }

    private final Notification d(Service service) {
        Object obj;
        if (this.mIsDestroy) {
            return null;
        }
        Intent intent = new Intent();
        intent.setComponent(((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).getSplashActivityComponent(service));
        Drawable iconDrawable = service.getResources().getDrawable(R.drawable.oj5);
        Intrinsics.checkNotNullExpressionValue(iconDrawable, "iconDrawable");
        Bitmap bitmap$default = DrawableKt.toBitmap$default(iconDrawable, 0, 0, null, 7, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            obj = Result.m476constructorimpl(PendingIntent.getActivity(service, 0, intent, 201326592));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(obj);
        Object obj2 = obj;
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[createAudioNotification] pendingIntent error");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("WebViewFrameLayoutForegroundService", 1, (String) it.next(), m479exceptionOrNullimpl);
            }
            obj2 = null;
        }
        PendingIntent pendingIntent = (PendingIntent) obj2;
        if (pendingIntent == null) {
            return null;
        }
        return g(service, "\u4f60\u6b63\u5728\u6d4f\u89c8\u817e\u8baf\u9891\u9053", "\u9875\u9762\u6b63\u5728\u8fd0\u884c", R.drawable.b8f, bitmap$default, pendingIntent);
    }

    private final void e(Service service) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("WebViewFrameLayoutForegroundService", 2, "[startForeground] ");
        }
        if (this.mAudioNotification == null) {
            Notification d16 = d(service);
            this.mAudioNotification = d16;
            if (d16 == null) {
                Logger.b bVar = new Logger.b();
                bVar.a().add("[startForeground] error mAudioNotification is null!");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("WebViewFrameLayoutForegroundService", 1, (String) it.next(), null);
                }
            }
        }
        Notification notification = this.mAudioNotification;
        if (notification != null) {
            service.startForeground(NotificationUtil.Constants.NOTIFY_ID_GUILD_MAINFRAME_RENDER, notification);
            this.mHandler.removeCallbacks(this.mUpdateNotificationRun);
            this.mHandler.postDelayed(this.mUpdateNotificationRun, 30000L);
        }
    }

    private final void f(Service service) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("WebViewFrameLayoutForegroundService", 2, "[stopForeground] ");
        }
        service.stopForeground(true);
        this.mHandler.removeCallbacks(this.mUpdateNotificationRun);
    }

    private final Notification g(Context context, String title, String content, int icon, Bitmap largeIcon, PendingIntent pendingIntent) {
        boolean z16;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
        builder.setSmallIcon(icon);
        builder.setContentTitle(title);
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            builder.setContentText(content);
        }
        if (largeIcon != null) {
            builder.setLargeIcon(largeIcon);
        }
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(pendingIntent);
        builder.setPriority(-1);
        builder.setFullScreenIntent(null, false);
        builder.setVibrate(null);
        Notification build = builder.build();
        build.flags = (build.flags | 2 | 32 | 8) & (-5) & (-2) & (-129);
        build.visibility = -1;
        build.category = null;
        Intrinsics.checkNotNullExpressionValue(build, "builder.build().apply {\n\u2026category = null\n        }");
        return build;
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    @Nullable
    public IBinder onBind(@NotNull Service service, @NotNull Intent intent) {
        return IRemoteRenderService.a.a(this, service, intent);
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onDestroy(@NotNull Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("WebViewFrameLayoutForegroundService", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.mIsDestroy = true;
        f(service);
        this.mService = null;
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onLowMemory(@NotNull Service service) {
        IRemoteRenderService.a.b(this, service);
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public int onStartCommand(@NotNull Service service, @NotNull Intent intent, int r122, int startId) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QQNotificationManager.getInstance();
        this.mService = service;
        boolean booleanExtra = intent.getBooleanExtra(QFSWebForegroundService.EVENT_KILL_NOTIFY_SERVICE, false);
        String stringExtra = intent.getStringExtra("key_web_page_id");
        if (stringExtra == null) {
            stringExtra = "NONE";
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("WebViewFrameLayoutForegroundService", 2, "onStartCommand(): webPageId: " + stringExtra + ", kill: " + booleanExtra + " " + intent.getExtras() + " " + r122 + " " + startId + " " + service);
        }
        if (booleanExtra) {
            this.mPageIdSets.remove(stringExtra);
            if (this.mPageIdSets.isEmpty()) {
                if (QLog.isColorLevel()) {
                    logger.d().d("WebViewFrameLayoutForegroundService", 2, "onStartCommand(): webPageId: " + stringExtra + ", removed for foreground!, will stopForeground");
                }
                f(service);
            } else if (QLog.isColorLevel()) {
                logger.d().d("WebViewFrameLayoutForegroundService", 2, "onStartCommand(): webPageId: " + stringExtra + ", removed for foreground!");
            }
            return 2;
        }
        e(service);
        this.mPageIdSets.add(stringExtra);
        QLog.d("WebViewFrameLayoutForegroundService", 1, "onStartCommand: Notification create and startForeground.");
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
}
