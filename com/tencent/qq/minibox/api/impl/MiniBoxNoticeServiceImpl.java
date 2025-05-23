package com.tencent.qq.minibox.api.impl;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.biz.service.WadlJsBridgeService;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.img.ImageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxNoticeService;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qq.minibox.api.impl.MiniBoxNoticeServiceImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us3.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u001b\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001a\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u001c\u0010&\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0017J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010%\u001a\u00020$H\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00105R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00060<j\b\u0012\u0004\u0012\u00020\u0006`=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006Q"}, d2 = {"Lcom/tencent/qq/minibox/api/impl/MiniBoxNoticeServiceImpl;", "Lnl0/a;", "Landroid/os/Handler$Callback;", "Lcom/tencent/qq/minibox/api/IMiniBoxNoticeService;", "", "hideBanner", "Lcom/tencent/qq/minibox/api/data/MiniBoxNoticeInfo;", "nextNoticeInfo", "showBanner", "checkNotice", "noticeInfo", "showNotification", "Landroid/graphics/Bitmap;", "largeIcon", "doNotificationNotify", "loadGameNoticeInfos", "", "appId", "getByAppId", "info", "saveData", "removeData", "Landroid/app/PendingIntent;", "createNotificationIntent", PushClientConstants.TAG_PKG_NAME, "", "businessId", "onTaskDeleted", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "onTaskComplete", "addGameWaitingNotice", "onTaskInstall", "checkBannerFromResume", "Landroid/view/View;", "banner", "Landroid/os/Message;", "msg", "updateMiniBoxBar", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "handleMessage", "Lcom/tencent/mobileqq/persistence/EntityManager;", "mEntityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "", "mLastRefreshTime", "J", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mCheckBannerPosted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mInit", "mCurrentBanner", "Lcom/tencent/qq/minibox/api/data/MiniBoxNoticeInfo;", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "miniboxNotices", "Ljava/util/ArrayList;", "isBannerEnable", "Z", "isNotificationEnable", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "rwlock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getRwlock", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "setRwlock", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;)V", "Ljava/lang/Runnable;", "mCheckBanner", "Ljava/lang/Runnable;", "<init>", "()V", "Companion", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxNoticeServiceImpl implements nl0.a, Handler.Callback, IMiniBoxNoticeService {
    public static final long CHECK_MIN_GAP = 60000;

    @NotNull
    public static final String KEY_BANNERENABLE = "bannerEnable";

    @NotNull
    public static final String KEY_NOTIFICATIONENABLE = "notificationEnable";

    @NotNull
    public static final String TAG = "MiniBoxNoticeServiceImpl";

    @NotNull
    public static final String VALUE_SWITCH_OPEN = "1";
    public static final int WHAT_CLICK_BANNER = 2;
    public static final int WHAT_CLOSE_BANNER = 1;
    private static boolean isClearedKV = false;
    private static final int typeDelete = 2;
    private static final int typeInstall = 1;

    @Nullable
    private MiniBoxNoticeInfo mCurrentBanner;

    @Nullable
    private EntityManager mEntityManager;
    private long mLastRefreshTime;

    @NotNull
    private final AtomicBoolean mCheckBannerPosted = new AtomicBoolean(false);

    @NotNull
    private final AtomicBoolean mInit = new AtomicBoolean(false);

    @NotNull
    private Handler mHandler = new Handler(Looper.getMainLooper(), this);

    @NotNull
    private final ArrayList<MiniBoxNoticeInfo> miniboxNotices = new ArrayList<>();
    private boolean isBannerEnable = true;
    private boolean isNotificationEnable = true;

    @NotNull
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    @NotNull
    private final Runnable mCheckBanner = new Runnable() { // from class: com.tencent.qq.minibox.api.impl.i
        @Override // java.lang.Runnable
        public final void run() {
            MiniBoxNoticeServiceImpl.mCheckBanner$lambda$0(MiniBoxNoticeServiceImpl.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qq/minibox/api/impl/MiniBoxNoticeServiceImpl$b", "Lqp3/b;", "", "key", "path", "localUrl", "", "b", "url", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements qp3.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniBoxNoticeInfo f344509b;

        b(MiniBoxNoticeInfo miniBoxNoticeInfo) {
            this.f344509b = miniBoxNoticeInfo;
        }

        @Override // qp3.b
        public void a(@Nullable String key, @Nullable String path, @Nullable String url) {
            QLog.d(MiniBoxNoticeServiceImpl.TAG, 2, "download app icon fail");
            try {
                Bitmap bitmap = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.qfile_file_ufdownload);
                MiniBoxNoticeServiceImpl miniBoxNoticeServiceImpl = MiniBoxNoticeServiceImpl.this;
                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                miniBoxNoticeServiceImpl.doNotificationNotify(bitmap, this.f344509b);
            } catch (Throwable th5) {
                QLog.e(MiniBoxNoticeServiceImpl.TAG, 1, "imgDownloadError err", th5);
            }
        }

        @Override // qp3.b
        public void b(@Nullable String key, @Nullable String path, @Nullable String localUrl) {
            QLog.d(MiniBoxNoticeServiceImpl.TAG, 2, "download app icon succ");
            try {
                Bitmap bitmap = BitmapFactory.decodeFile(localUrl);
                MiniBoxNoticeServiceImpl miniBoxNoticeServiceImpl = MiniBoxNoticeServiceImpl.this;
                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                miniBoxNoticeServiceImpl.doNotificationNotify(bitmap, this.f344509b);
            } catch (Throwable th5) {
                QLog.e(MiniBoxNoticeServiceImpl.TAG, 1, "imgDownloaded err", th5);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qq/minibox/api/impl/MiniBoxNoticeServiceImpl$c", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements URLDrawable.URLDrawableListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qui.noticebar.d f344511e;

        c(com.tencent.biz.qui.noticebar.d dVar) {
            this.f344511e = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(com.tencent.biz.qui.noticebar.d bar, URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(bar, "$bar");
            Intrinsics.checkNotNullParameter(urlDrawable, "$urlDrawable");
            bar.setIcon(urlDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull final URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            try {
                QLog.d(MiniBoxNoticeServiceImpl.TAG, 1, "onLoadSuccessed urlDrawable=" + urlDrawable);
                Handler handler = MiniBoxNoticeServiceImpl.this.mHandler;
                final com.tencent.biz.qui.noticebar.d dVar = this.f344511e;
                handler.post(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniBoxNoticeServiceImpl.c.b(com.tencent.biz.qui.noticebar.d.this, urlDrawable);
                    }
                });
            } catch (Throwable th5) {
                QLog.d(MiniBoxNoticeServiceImpl.TAG, 1, "setURLDrawableListener err:", th5);
            }
        }
    }

    private final void checkNotice() {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d(TAG, 1, "checkBanner now=" + currentTimeMillis + ",mLastRefreshTime=" + this.mLastRefreshTime + ",size=" + this.miniboxNotices.size());
        if (currentTimeMillis - this.mLastRefreshTime < 60000) {
            QLog.w(TAG, 1, "checkBanner time limit!");
            return;
        }
        this.mLastRefreshTime = currentTimeMillis;
        if (!this.mInit.getAndSet(true)) {
            loadGameNoticeInfos();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = this.rwlock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i16 = 0;
        if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
            i3 = reentrantReadWriteLock.getReadHoldCount();
        } else {
            i3 = 0;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            Unit unit = null;
            MiniBoxNoticeInfo miniBoxNoticeInfo = null;
            for (MiniBoxNoticeInfo miniBoxNoticeInfo2 : this.miniboxNotices) {
                miniBoxNoticeInfo2.updateTipsInfo();
                int i18 = miniBoxNoticeInfo2.notifyStatus;
                if (i18 != 1) {
                    if (i18 != 2) {
                        if (i18 == 3) {
                            showNotification(miniBoxNoticeInfo2);
                            removeData(miniBoxNoticeInfo2);
                            this.miniboxNotices.remove(miniBoxNoticeInfo2);
                        }
                    } else {
                        if (miniBoxNoticeInfo != null && miniBoxNoticeInfo.startTime >= miniBoxNoticeInfo2.startTime) {
                        }
                        miniBoxNoticeInfo = miniBoxNoticeInfo2;
                    }
                } else if (miniBoxNoticeInfo2.endTime - miniBoxNoticeInfo2.startTime < 1) {
                    showNotification(miniBoxNoticeInfo2);
                    miniBoxNoticeInfo2.endTime = System.currentTimeMillis();
                } else {
                    QLog.d(TAG, 4, "min5 notift showed");
                }
            }
            Unit unit2 = Unit.INSTANCE;
            if (miniBoxNoticeInfo != null) {
                Intrinsics.checkNotNull(miniBoxNoticeInfo);
                showBanner(miniBoxNoticeInfo);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.d(TAG, 1, "getting no banner to show");
                hideBanner();
            }
        } finally {
            while (i16 < i3) {
                readLock.lock();
                i16++;
            }
            writeLock.unlock();
        }
    }

    private final PendingIntent createNotificationIntent(String appId) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) WadlJsBridgeService.class);
        int currentTimeMillis = (int) (System.currentTimeMillis() & 268435455);
        intent.putExtra("action_name", 104);
        intent.putExtra("id", appId);
        PendingIntent service = PendingIntent.getService(MobileQQ.sMobileQQ, currentTimeMillis, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(service, "getService(MobileQQ.sMob\u2026equestCode, intent, flag)");
        return service;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doNotificationNotify(Bitmap largeIcon, MiniBoxNoticeInfo noticeInfo) {
        QLog.d(TAG, 1, "-->showNotify");
        NotificationCompat.Builder contentText = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_SHOW_BADGE).setSmallIcon(R.drawable.qfile_file_ufdownload).setLargeIcon(largeIcon).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(noticeInfo.appName).setContentText(noticeInfo.title);
        String str = noticeInfo.appId;
        Intrinsics.checkNotNullExpressionValue(str, "noticeInfo.appId");
        Notification build = contentText.setContentIntent(createNotificationIntent(str)).build();
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_MINIBOX_PUSH);
            qQNotificationManager.notify(TAG, NotificationUtil.Constants.NOTIFY_ID_MINIBOX_PUSH, build);
        }
    }

    private final MiniBoxNoticeInfo getByAppId(String appId) {
        ReentrantReadWriteLock.ReadLock readLock = this.rwlock.readLock();
        readLock.lock();
        try {
            Iterator<MiniBoxNoticeInfo> it = this.miniboxNotices.iterator();
            while (it.hasNext()) {
                MiniBoxNoticeInfo next = it.next();
                if (!TextUtils.isEmpty(next.appId) && Intrinsics.areEqual(next.appId, appId)) {
                    QLog.d(TAG, 1, "getByAppId appId=" + appId + ",noticeInfo=" + next);
                    return next;
                }
            }
            Unit unit = Unit.INSTANCE;
            readLock.unlock();
            return null;
        } finally {
            readLock.unlock();
        }
    }

    private final void hideBanner() {
        QLog.d(TAG, 1, "hideBanner mCurrentBanner=" + this.mCurrentBanner);
        if (this.mCurrentBanner != null) {
            Message message = new Message();
            message.what = 1134072;
            BannerManager.l().O(com.tencent.mobileqq.banner.d.L, 0, message);
            this.mCurrentBanner = null;
        }
    }

    /* JADX WARN: Finally extract failed */
    private final void loadGameNoticeInfos() {
        List<? extends Entity> list;
        int i3;
        try {
            EntityManager entityManager = this.mEntityManager;
            if (entityManager != null) {
                list = entityManager.query(MiniBoxNoticeInfo.class);
            } else {
                list = null;
            }
            ArrayList arrayList = (ArrayList) list;
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "infos.iterator()");
            while (arrayList.iterator().hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                MiniBoxNoticeInfo miniBoxNoticeInfo = (MiniBoxNoticeInfo) next;
                if (!miniBoxNoticeInfo.isValid()) {
                    it.remove();
                } else {
                    miniBoxNoticeInfo.updateTipsInfo();
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock = this.rwlock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i16 = 0;
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i3 = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < i3; i17++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                this.miniboxNotices.addAll(arrayList);
                while (i16 < i3) {
                    readLock.lock();
                    i16++;
                }
                writeLock.unlock();
                QLog.d(TAG, 1, "loadGameNoticeInfos size=" + arrayList.size() + ", cache size=" + this.miniboxNotices.size());
            } catch (Throwable th5) {
                while (i16 < i3) {
                    readLock.lock();
                    i16++;
                }
                writeLock.unlock();
                throw th5;
            }
        } catch (Throwable th6) {
            QLog.e(TAG, 1, "loadGameNoticeInfos exception", th6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCheckBanner$lambda$0(MiniBoxNoticeServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.checkNotice();
            this$0.mCheckBannerPosted.set(false);
        } catch (Throwable th5) {
            this$0.hideBanner();
            QLog.e(TAG, 1, "mCheckBanner err", th5);
        }
    }

    private final void removeData(MiniBoxNoticeInfo info) {
        QLog.d(TAG, 1, "remove Info:" + info);
        EntityManager entityManager = this.mEntityManager;
        if (entityManager != null) {
            entityManager.remove(info);
        }
    }

    private final void saveData(MiniBoxNoticeInfo info) {
        QLog.d(TAG, 2, "save Info:" + info);
        EntityManager entityManager = this.mEntityManager;
        if (entityManager != null) {
            entityManager.persist(info);
        }
    }

    private final void showBanner(MiniBoxNoticeInfo nextNoticeInfo) {
        String str;
        if (!this.isBannerEnable) {
            QLog.d(TAG, 4, "isBannerEnable:" + this.isBannerEnable);
            return;
        }
        boolean z16 = true;
        if (Intrinsics.areEqual(nextNoticeInfo, this.mCurrentBanner)) {
            QLog.w(TAG, 1, "mCurrentBanner not changed, mCurrentBanner=" + this.mCurrentBanner);
            return;
        }
        Object clone = nextNoticeInfo.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo");
        this.mCurrentBanner = (MiniBoxNoticeInfo) clone;
        QLog.d(TAG, 1, "showBanner mCurrentBanner=" + this.mCurrentBanner);
        Bundle bundle = new Bundle();
        MiniBoxNoticeInfo miniBoxNoticeInfo = this.mCurrentBanner;
        Intrinsics.checkNotNull(miniBoxNoticeInfo);
        bundle.putString("appid", miniBoxNoticeInfo.appId);
        MiniBoxNoticeInfo miniBoxNoticeInfo2 = this.mCurrentBanner;
        Intrinsics.checkNotNull(miniBoxNoticeInfo2);
        bundle.putString("tips", miniBoxNoticeInfo2.title);
        MiniBoxNoticeInfo miniBoxNoticeInfo3 = this.mCurrentBanner;
        if (miniBoxNoticeInfo3 != null) {
            str = miniBoxNoticeInfo3.iconUrl;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            bundle.putString(MiniBoxNoticeInfo.KEY_ICON_URL, str);
        }
        Message message = new Message();
        message.what = 1134071;
        message.obj = bundle;
        BannerManager.l().O(com.tencent.mobileqq.banner.d.L, 2, message);
    }

    private final void showNotification(MiniBoxNoticeInfo noticeInfo) {
        if (!this.isNotificationEnable) {
            QLog.d(TAG, 4, "isnotificationEnable:" + this.isBannerEnable);
            return;
        }
        ImageCache.c("app", noticeInfo.iconUrl, new b(noticeInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMiniBoxBar$lambda$8(MiniBoxNoticeServiceImpl this$0, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Handler handler = this$0.mHandler;
        Intrinsics.checkNotNull(handler);
        Message obtainMessage = handler.obtainMessage(2);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "mHandler!!.obtainMessage(WHAT_CLICK_BANNER)");
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMiniBoxBar$lambda$9(MiniBoxNoticeServiceImpl this$0, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Handler handler = this$0.mHandler;
        Intrinsics.checkNotNull(handler);
        Message obtainMessage = handler.obtainMessage(1);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "mHandler!!.obtainMessage(WHAT_CLOSE_BANNER)");
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxNoticeService
    public void addGameWaitingNotice(@NotNull MiniBoxNoticeInfo noticeInfo) {
        int i3;
        Intrinsics.checkNotNullParameter(noticeInfo, "noticeInfo");
        ReentrantReadWriteLock reentrantReadWriteLock = this.rwlock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i16 = 0;
        if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
            i3 = reentrantReadWriteLock.getReadHoldCount();
        } else {
            i3 = 0;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.miniboxNotices.add(noticeInfo);
        } finally {
            while (i16 < i3) {
                readLock.lock();
                i16++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxNoticeService
    public void checkBannerFromResume() {
        QLog.d(TAG, 4, "checkBannerFromResume mCheckBannerPosted=" + this.mCheckBannerPosted);
        if (!this.mCheckBannerPosted.getAndSet(true)) {
            ThreadManagerV2.excute(this.mCheckBanner, 16, null, true);
        }
        if (!isClearedKV) {
            m.f439991a.e();
            isClearedKV = true;
        }
    }

    @NotNull
    public final ReentrantReadWriteLock getRwlock() {
        return this.rwlock;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(TAG, 1, "handleMessage msg=" + msg2.what + ",appid=" + msg2.obj);
        int i3 = msg2.what;
        if (i3 != 1) {
            if (i3 == 2) {
                hideBanner();
                Object obj = msg2.obj;
                if (obj instanceof String) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) obj;
                    MiniBoxNoticeInfo byAppId = getByAppId(str);
                    if (byAppId != null) {
                        removeData(byAppId);
                        if (byAppId.bannerType == 0) {
                            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(BaseApplication.getContext(), str, "", "", 0, null);
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        hideBanner();
        Object obj2 = msg2.obj;
        if (obj2 instanceof String) {
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            MiniBoxNoticeInfo byAppId2 = getByAppId((String) obj2);
            if (byAppId2 != null) {
                removeData(byAppId2);
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        boolean z16;
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        QLog.d(TAG, 1, "onCreate appRuntime=" + appRuntime);
        this.mEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        GameCenterReceiver.registerReceiver();
        GameCenterReceiver.addListener(this);
        Map<String, String> toggleParams = ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).getToggleParams("minibox_notice_switch");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "params size:" + toggleParams.size());
        }
        String str = toggleParams.get(KEY_BANNERENABLE);
        boolean z17 = false;
        if (str != null) {
            z16 = Intrinsics.areEqual(str, "1");
        } else {
            z16 = false;
        }
        this.isBannerEnable = z16;
        String str2 = toggleParams.get(KEY_NOTIFICATIONENABLE);
        if (str2 != null) {
            z17 = Intrinsics.areEqual(str2, "1");
        }
        this.isNotificationEnable = z17;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        MiniBoxNoticeInfo miniBoxNoticeInfo = this.mCurrentBanner;
        if (miniBoxNoticeInfo != null) {
            removeData(miniBoxNoticeInfo);
        }
        GameCenterReceiver.removeListener(this);
        this.mHandler.removeCallbacksAndMessages(null);
        hideBanner();
        this.mInit.set(false);
    }

    @Override // nl0.a
    public void onTaskComplete(@Nullable WadlResult wadlResult, int businessId) {
        int i3;
        Object obj;
        QLog.d(TAG, 1, "onTaskComplete businessId=" + businessId + ",wadlResult=" + wadlResult);
        if (businessId == 3 && wadlResult != null) {
            ReentrantReadWriteLock reentrantReadWriteLock = this.rwlock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i16 = 0;
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i3 = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < i3; i17++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                Iterator<T> it = this.miniboxNotices.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((MiniBoxNoticeInfo) obj).appId, wadlResult.wadlParams.appId)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                MiniBoxNoticeInfo miniBoxNoticeInfo = (MiniBoxNoticeInfo) obj;
                if (miniBoxNoticeInfo != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 4, "find notifyInfo:" + miniBoxNoticeInfo);
                    }
                    miniBoxNoticeInfo.updateMiniBoxNoticeInfo(wadlResult);
                    saveData(miniBoxNoticeInfo);
                } else {
                    MiniBoxNoticeInfo miniBoxNoticeInfo2 = new MiniBoxNoticeInfo(wadlResult);
                    this.miniboxNotices.add(miniBoxNoticeInfo2);
                    saveData(miniBoxNoticeInfo2);
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                while (i16 < i3) {
                    readLock.lock();
                    i16++;
                }
                writeLock.unlock();
            }
        }
    }

    @Override // nl0.a
    public void onTaskDeleted(@Nullable String appId, @Nullable String pkgName, int businessId) {
        int i3;
        Object obj;
        boolean z16 = true;
        QLog.d(TAG, 1, "onTaskDeleted businessId=" + businessId + ",appId=" + appId);
        if (businessId == 3) {
            int i16 = 0;
            if (appId != null && appId.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                ReentrantReadWriteLock reentrantReadWriteLock = this.rwlock;
                ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
                if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                    i3 = reentrantReadWriteLock.getReadHoldCount();
                } else {
                    i3 = 0;
                }
                for (int i17 = 0; i17 < i3; i17++) {
                    readLock.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    Iterator<T> it = this.miniboxNotices.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(((MiniBoxNoticeInfo) obj).appId, appId)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    MiniBoxNoticeInfo miniBoxNoticeInfo = (MiniBoxNoticeInfo) obj;
                    if (miniBoxNoticeInfo != null) {
                        this.miniboxNotices.remove(miniBoxNoticeInfo);
                        removeData(miniBoxNoticeInfo);
                        if (Intrinsics.areEqual(miniBoxNoticeInfo, this.mCurrentBanner)) {
                            hideBanner();
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } finally {
                    while (i16 < i3) {
                        readLock.lock();
                        i16++;
                    }
                    writeLock.unlock();
                }
            }
        }
    }

    public final void setRwlock(@NotNull ReentrantReadWriteLock reentrantReadWriteLock) {
        Intrinsics.checkNotNullParameter(reentrantReadWriteLock, "<set-?>");
        this.rwlock = reentrantReadWriteLock;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxNoticeService
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void updateMiniBoxBar(@Nullable View banner, @Nullable Message msg2) {
        if (msg2 == null) {
            QLog.d(TAG, 1, "updateGameCenterBar msg is null");
            return;
        }
        int i3 = msg2.what;
        if (i3 != 1134071 && i3 != 1134072) {
            QLog.d(TAG, 1, "updateMiniBoxBar msg.what=" + msg2.what);
            return;
        }
        if (banner == null) {
            return;
        }
        QLog.d(TAG, 1, "updateMiniBoxBar msg.what=" + msg2.what + ",msg.obj = " + msg2.obj);
        if (msg2.what == 1134072) {
            banner.setVisibility(8);
            return;
        }
        com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.INSTANCE.a().d(banner);
        if (d16 == null) {
            return;
        }
        d16.setIcon(BaseApplication.getContext().getResources().getDrawable(R.drawable.c47, null));
        banner.setVisibility(0);
        Object obj = msg2.obj;
        if (obj instanceof Bundle) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.os.Bundle");
            Bundle bundle = (Bundle) obj;
            final String string = bundle.getString("appid");
            String string2 = bundle.getString("tips");
            String string3 = bundle.getString(MiniBoxNoticeInfo.KEY_ICON_URL);
            QLog.d(TAG, 1, "updateGameCenterBar  appid=" + string + ",tips= " + string2 + ",iconURL= " + string3);
            d16.c(new View.OnClickListener() { // from class: com.tencent.qq.minibox.api.impl.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniBoxNoticeServiceImpl.updateMiniBoxBar$lambda$8(MiniBoxNoticeServiceImpl.this, string, view);
                }
            });
            d16.k(new View.OnClickListener() { // from class: com.tencent.qq.minibox.api.impl.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniBoxNoticeServiceImpl.updateMiniBoxBar$lambda$9(MiniBoxNoticeServiceImpl.this, string, view);
                }
            });
            d16.setMsg(string2);
            if (!TextUtils.isEmpty(string3)) {
                URLDrawable drawable = URLDrawable.getDrawable(string3, URLDrawable.URLDrawableOptions.obtain());
                QLog.d(TAG, 1, "urlDrawable status=" + drawable.getStatus());
                if (drawable.getStatus() == 1) {
                    d16.setIcon(drawable);
                } else {
                    drawable.setURLDrawableListener(new c(d16));
                    drawable.startDownload();
                }
            }
        }
    }

    @Override // nl0.a
    public void onTaskInstall(@Nullable WadlResult wadlResult, int businessId) {
    }
}
