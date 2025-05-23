package com.tencent.mobileqq.guild.media.core.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.image.URLDrawable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.media.core.data.b;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.guild.window.d;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class AudioForegroundService extends Service {

    /* renamed from: d, reason: collision with root package name */
    protected String f228730d = "QGMC.AudioForegroundService";

    /* renamed from: e, reason: collision with root package name */
    private boolean f228731e = false;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f228732f = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f228733h = new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.service.AudioForegroundService.1
        @Override // java.lang.Runnable
        public void run() {
            if (GuardManager.sInstance != null) {
                QLog.d(AudioForegroundService.this.f228730d, 4, "UpdateNotificationRun send GuardManager.EVENT_MSG");
                GuardManager.sInstance.onEvent(0, null);
            }
            AudioForegroundService.this.f228732f.postDelayed(AudioForegroundService.this.f228733h, 30000L);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private Notification f228734i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IGProGuildInfo f228735d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IGProChannelInfo f228736e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Drawable f228737f;

        a(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, Drawable drawable) {
            this.f228735d = iGProGuildInfo;
            this.f228736e = iGProChannelInfo;
            this.f228737f = drawable;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.i(AudioForegroundService.this.f228730d, 1, "URLDrawable.onLoadCanceled:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.i(AudioForegroundService.this.f228730d, 1, "URLDrawable.onLoadFialed:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            QLog.i(AudioForegroundService.this.f228730d, 1, "URLDrawable.onLoadProgressed:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i(AudioForegroundService.this.f228730d, 1, "URLDrawable.onLoadSuccessed:");
            AudioForegroundService audioForegroundService = AudioForegroundService.this;
            audioForegroundService.f228734i = audioForegroundService.g(this.f228735d, this.f228736e, this.f228737f);
            if (AudioForegroundService.this.f228734i != null) {
                QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                AudioForegroundService audioForegroundService2 = AudioForegroundService.this;
                qQNotificationManager.notify(audioForegroundService2.f228730d, NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, audioForegroundService2.f228734i);
            }
        }
    }

    private Intent f(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
        int i3 = GuildMainFrameConstants.f227278v;
        Bundle bundle = new Bundle();
        bundle.putString("guildId", iGProGuildInfo.getGuildID());
        bundle.putString("channelId", iGProChannelInfo.getChannelUin());
        Intent intent = new Intent();
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setGuildTabIntent(this, intent);
        intent.putExtra("goto_guildtab_actiontype", i3);
        intent.putExtra("goto_guildtab_actionextra", bundle);
        intent.putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, true);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Notification g(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, Drawable drawable) {
        PendingIntent pendingIntent;
        if (this.f228731e) {
            return null;
        }
        String str = iGProGuildInfo.getGuildName() + APLogFileUtil.SEPARATOR_LOG + iGProChannelInfo.getChannelName();
        String string = getString(R.string.f1514617r);
        int g16 = tp1.a.g();
        if (drawable == null) {
            drawable = h(iGProGuildInfo, iGProChannelInfo);
        }
        Bitmap a16 = d.a(drawable);
        try {
            pendingIntent = PendingIntent.getActivity(this, 0, f(iGProGuildInfo, iGProChannelInfo), 201326592);
        } catch (Throwable th5) {
            QLog.e(this.f228730d, 1, "PendingIntent getActivity error!", th5);
            pendingIntent = null;
        }
        if (pendingIntent == null) {
            return null;
        }
        return i(str, string, g16, a16, pendingIntent);
    }

    private Drawable h(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return BaseApplication.getContext().getDrawable(R.drawable.guild_logo_icon);
        }
        Drawable avatarDrawable = ((IQQGuildAvatarApi) peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(iGProGuildInfo.getAvatarUrl(0), ViewUtils.dip2px(64.0f), ViewUtils.dip2px(64.0f), "audio_notify");
        if (avatarDrawable instanceof URLDrawable) {
            ((URLDrawable) avatarDrawable).setURLDrawableListener(new a(iGProGuildInfo, iGProChannelInfo, avatarDrawable));
        }
        return avatarDrawable;
    }

    private Notification i(String str, String str2, int i3, Bitmap bitmap, PendingIntent pendingIntent) {
        NotificationCompat.Builder createNotificationCompatBuilder = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
        createNotificationCompatBuilder.setSmallIcon(i3);
        createNotificationCompatBuilder.setContentTitle(str);
        createNotificationCompatBuilder.setContentText(str2);
        createNotificationCompatBuilder.setWhen(System.currentTimeMillis());
        createNotificationCompatBuilder.setLargeIcon(bitmap);
        createNotificationCompatBuilder.setContentIntent(pendingIntent);
        createNotificationCompatBuilder.setPriority(-1);
        createNotificationCompatBuilder.setFullScreenIntent(null, false);
        createNotificationCompatBuilder.setVibrate(null);
        Notification build = createNotificationCompatBuilder.build();
        int i16 = (build.flags | 2 | 32 | 8) & (-5) & (-2);
        build.flags = i16;
        build.visibility = -1;
        build.category = null;
        build.flags = i16 & (-129);
        return build;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        QLog.i(this.f228730d, 1, "onDestroy:");
        this.f228731e = true;
        this.f228732f.removeCallbacksAndMessages(null);
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        QLog.i(this.f228730d, 1, " onLowMemory");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        QLog.i(this.f228730d, 1, "onStartCommand: flag[" + i3 + "] startId[" + i16 + "]");
        super.onStartCommand(intent, i3, i16);
        IGProGuildInfo iGProGuildInfo = (IGProGuildInfo) intent.getSerializableExtra("guildInfo");
        IGProChannelInfo iGProChannelInfo = (IGProChannelInfo) intent.getSerializableExtra("channelInfo");
        if (iGProGuildInfo != null && iGProChannelInfo != null) {
            QQNotificationManager.getInstance();
            Notification g16 = g(iGProGuildInfo, iGProChannelInfo, null);
            this.f228734i = g16;
            if (g16 == null) {
                QLog.e(this.f228730d, 1, "onStartCommand: mAudioNotification is null!");
                return 2;
            }
            try {
                startForeground(NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, g16);
                this.f228732f.postDelayed(this.f228733h, 30000L);
                QLog.i(this.f228730d, 1, "onStartCommand: Notification create and startForeground.");
            } catch (Exception e16) {
                QLog.e(this.f228730d, 1, "try startForeground failed: " + e16.getMessage());
                return 2;
            }
        } else {
            QLog.e(this.f228730d, 1, "onStartCommand: " + iGProGuildInfo + ", " + iGProChannelInfo);
        }
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (!TextUtils.isEmpty(intent.getDataString())) {
            QLog.i(this.f228730d, 1, "onTaskRemoved: error. uri[" + intent.getDataString() + "]");
            super.onTaskRemoved(intent);
            return;
        }
        boolean h16 = GuildFloatWindowManager.f236656d.h();
        if (!h16) {
            stopForeground(true);
            stopSelf();
            j.a().D(null, "onTaskRemoved");
            b.g();
        }
        QLog.i(this.f228730d, 1, "onTaskRemoved: assistantMode=" + h16);
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        QLog.i(this.f228730d, 1, " onTrimMemory: " + i3);
    }
}
