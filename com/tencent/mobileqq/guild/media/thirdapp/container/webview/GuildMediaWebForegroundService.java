package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

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
import android.support.v4.app.NotificationCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.remoteweb.IRemoteRenderService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0007*\u0001,\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b0\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J(\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebForegroundService;", "Lcom/tencent/mobileqq/remoteweb/IRemoteRenderService;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Landroid/content/Intent;", "f", "Landroid/graphics/drawable/Drawable;", "icon", "Landroid/app/Notification;", "g", tl.h.F, "", "title", "content", "", "Landroid/graphics/Bitmap;", "largeIcon", "Landroid/app/PendingIntent;", "pendingIntent", "i", "Landroid/app/Service;", "service", "intent", WadlProxyConsts.FLAGS, "startId", "onStartCommand", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "Landroid/app/Notification;", "mAudioNotification", "b", "Landroid/app/Service;", "mService", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "mHandler", "", "d", "Z", "mIsDestroy", "com/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebForegroundService$mUpdateNotificationRun$1", "e", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebForegroundService$mUpdateNotificationRun$1;", "mUpdateNotificationRun", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaWebForegroundService implements IRemoteRenderService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Notification mAudioNotification;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Service mService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsDestroy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaWebForegroundService$mUpdateNotificationRun$1 mUpdateNotificationRun = new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebForegroundService$mUpdateNotificationRun$1
        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            Service service;
            if (GuildMediaWebForegroundService.this.mAudioNotification != null) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 2, "UpdateNotificationRun startForeground.");
                }
                service = GuildMediaWebForegroundService.this.mService;
                if (service != null) {
                    service.startForeground(NotificationUtil.Constants.NOTIFY_ID_GUILD_WEB_RENDER, GuildMediaWebForegroundService.this.mAudioNotification);
                }
            }
            if (GuardManager.sInstance != null) {
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 2, "UpdateNotificationRun send GuardManager.EVENT_MSG");
                }
                GuardManager.sInstance.onEvent(0, null);
            }
            handler = GuildMediaWebForegroundService.this.mHandler;
            handler.postDelayed(this, 30000L);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebForegroundService$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IGProGuildInfo f229486e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IGProChannelInfo f229487f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Drawable f229488h;

        b(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, Drawable drawable) {
            this.f229486e = iGProGuildInfo;
            this.f229487f = iGProChannelInfo;
            this.f229488h = drawable;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 1, "URLDrawable.onLoadCanceled:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 1, "URLDrawable.onLoadFialed:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 1, "URLDrawable.onLoadProgressed:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 1, "URLDrawable.onLoadSuccessed:");
            GuildMediaWebForegroundService guildMediaWebForegroundService = GuildMediaWebForegroundService.this;
            guildMediaWebForegroundService.mAudioNotification = guildMediaWebForegroundService.g(this.f229486e, this.f229487f, this.f229488h);
            if (GuildMediaWebForegroundService.this.mAudioNotification != null) {
                QQNotificationManager.getInstance().notify("QGMC.MediaThirdApp.GuildMediaWebForegroundService", NotificationUtil.Constants.NOTIFY_ID_GUILD_WEB_RENDER, GuildMediaWebForegroundService.this.mAudioNotification);
            }
        }
    }

    private final Intent f(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        int i3 = GuildMainFrameConstants.f227278v;
        Bundle bundle = new Bundle();
        bundle.putString("guildId", guildInfo.getGuildID());
        bundle.putString("channelId", channelInfo.getChannelUin());
        Intent intent = new Intent();
        intent.putExtra("goto_guildtab_actiontype", i3);
        intent.putExtra("goto_guildtab_actionextra", bundle);
        intent.putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, true);
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setGuildTabIntent(this.mService, intent);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Notification g(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo, Drawable icon) {
        String str;
        PendingIntent pendingIntent;
        if (this.mIsDestroy) {
            return null;
        }
        String str2 = guildInfo.getGuildName() + APLogFileUtil.SEPARATOR_LOG + channelInfo.getChannelName();
        Service service = this.mService;
        if (service != null) {
            str = service.getString(R.string.f1514717s);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str3 = str;
        int g16 = tp1.a.g();
        if (icon == null) {
            icon = h(guildInfo, channelInfo);
        }
        Bitmap largeIcon = com.tencent.mobileqq.guild.window.d.a(icon);
        Intent f16 = f(guildInfo, channelInfo);
        try {
            Context context = this.mService;
            if (context == null) {
                context = BaseApplication.getContext();
            }
            pendingIntent = PendingIntent.getActivity(context, 0, f16, 201326592);
        } catch (Throwable th5) {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 1, "[createAudioNotification] pendingIntent error " + th5);
            pendingIntent = null;
        }
        if (pendingIntent == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(largeIcon, "largeIcon");
        return i(str2, str3, g16, largeIcon, pendingIntent);
    }

    private final Drawable h(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        URLDrawable uRLDrawable;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String avatarUrl = guildInfo.getAvatarUrl(0);
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026va, ProcessConstant.MAIN)");
        int dip2px = ViewUtils.dip2px(64.0f);
        Drawable avatarDrawable = ((IQQGuildAvatarApi) runtimeService).getAvatarDrawable(avatarUrl, dip2px, dip2px, "remote_render_notify");
        if (avatarDrawable instanceof URLDrawable) {
            uRLDrawable = (URLDrawable) avatarDrawable;
        } else {
            uRLDrawable = null;
        }
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(new b(guildInfo, channelInfo, avatarDrawable));
        }
        return avatarDrawable;
    }

    private final Notification i(String title, String content, int icon, Bitmap largeIcon, PendingIntent pendingIntent) {
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

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    @Nullable
    public IBinder onBind(@NotNull Service service, @NotNull Intent intent) {
        return IRemoteRenderService.a.a(this, service, intent);
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onDestroy(@NotNull Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 1, "onDestroy:");
        this.mIsDestroy = true;
        this.mHandler.removeCallbacksAndMessages(null);
        service.stopForeground(true);
        this.mService = null;
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public void onLowMemory(@NotNull Service service) {
        IRemoteRenderService.a.b(this, service);
    }

    @Override // com.tencent.mobileqq.remoteweb.IRemoteRenderService
    public int onStartCommand(@NotNull Service service, @NotNull Intent intent, int flags, int startId) {
        IGProGuildInfo iGProGuildInfo;
        IGProChannelInfo iGProChannelInfo;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("guildInfo");
        if (serializableExtra instanceof IGProGuildInfo) {
            iGProGuildInfo = (IGProGuildInfo) serializableExtra;
        } else {
            iGProGuildInfo = null;
        }
        if (iGProGuildInfo == null) {
            return 2;
        }
        Serializable serializableExtra2 = intent.getSerializableExtra("channelInfo");
        if (serializableExtra2 instanceof IGProChannelInfo) {
            iGProChannelInfo = (IGProChannelInfo) serializableExtra2;
        } else {
            iGProChannelInfo = null;
        }
        if (iGProChannelInfo == null) {
            return 2;
        }
        QQNotificationManager.getInstance();
        this.mService = service;
        Notification g16 = g(iGProGuildInfo, iGProChannelInfo, null);
        this.mAudioNotification = g16;
        if (g16 == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[onStartCommand] error mAudioNotification is null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 1, (String) it.next(), null);
            }
            return 2;
        }
        service.startForeground(NotificationUtil.Constants.NOTIFY_ID_GUILD_WEB_RENDER, g16);
        this.mHandler.postDelayed(this.mUpdateNotificationRun, 30000L);
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebForegroundService", 1, "onStartCommand: Notification create and startForeground.");
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
