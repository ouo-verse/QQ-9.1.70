package com.tencent.mobileqq.gamecenter.logic;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.appwidget.GameCenterAppWidgetProviderV2;
import com.tencent.mobileqq.gamecenter.data.q;
import com.tencent.mobileqq.gamecenter.data.r;
import com.tencent.mobileqq.gamecenter.protocols.f;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$BattlepassWidget;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$NewWidget;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class WidgetConfigLogicHandler {

    /* renamed from: a, reason: collision with root package name */
    private final f f212139a;

    /* renamed from: b, reason: collision with root package name */
    private File f212140b;

    /* renamed from: c, reason: collision with root package name */
    private Timer f212141c;

    /* renamed from: d, reason: collision with root package name */
    private q f212142d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f212143e = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.logic.b
        @Override // java.lang.Runnable
        public final void run() {
            WidgetConfigLogicHandler.this.e();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private final Handler f212144f = new Handler(ThreadManagerV2.getQQCommonThreadLooper());

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f212145g = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.logic.c
        @Override // java.lang.Runnable
        public final void run() {
            WidgetConfigLogicHandler.this.u();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f212146a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f212147b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f212148c;

        a(File file, q qVar, int i3) {
            this.f212146a = file;
            this.f212147b = qVar;
            this.f212148c = i3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            super.onDone(gVar);
            if (3 == gVar.i()) {
                QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "file path:" + this.f212146a.getAbsolutePath());
                WidgetConfigLogicHandler.this.t(this.f212146a.getAbsolutePath(), this.f212147b, this.f212148c);
                return;
            }
            QLog.w("GCWidget.WidgetConfigLogicHandler", 1, "download img failed~");
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(g gVar) {
            return super.onStart(gVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f212150a;

        b(File file) {
            this.f212150a = file;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            super.onDone(gVar);
            if (3 == gVar.i()) {
                QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[downloadAndUpdateUiV2] file path:" + this.f212150a.getAbsolutePath());
                WidgetConfigLogicHandler.this.i();
                return;
            }
            QLog.w("GCWidget.WidgetConfigLogicHandler", 1, "download img failed~");
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(g gVar) {
            return super.onStart(gVar);
        }
    }

    public WidgetConfigLogicHandler() {
        n();
        this.f212139a = new f();
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[WidgetConfigLogicHandler]");
    }

    private void A(QQWidgetSvr$BattlepassWidget qQWidgetSvr$BattlepassWidget) {
        q g16 = r.g(qQWidgetSvr$BattlepassWidget);
        if (g16 != null) {
            l(g16);
        } else {
            f(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!r.a(this.f212142d)) {
            QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[cacheAndSendUpdateBroadcastV2] cache widget info error");
            return;
        }
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[cacheAndSendUpdateBroadcastV2] start sending broadcast,process:" + MobileQQ.sMobileQQ.getQQProcessName());
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        Intent intent = new Intent();
        intent.setAction("tencent.notify.appwidget.GAME_CENTER_UPDATE_V2");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        applicationContext.sendBroadcast(intent);
    }

    private void k(q qVar) {
        if (qVar == null) {
            QLog.w("GCWidget.WidgetConfigLogicHandler", 1, "[downloadFileV2], param is invalid.");
            return;
        }
        q.i promotionAd = qVar.getPromotionAd();
        if (promotionAd != null) {
            p(promotionAd.getPic(), qVar, 0);
        }
        q.g gift = qVar.getGift();
        if (gift != null) {
            p(gift.getIcon(), qVar, 1);
        }
        q.e cloudGame = qVar.getCloudGame();
        if (cloudGame != null) {
            p(cloudGame.getIcon(), qVar, 2);
        }
    }

    private void l(q qVar) {
        if (qVar == null) {
            QLog.w("GCWidget.WidgetConfigLogicHandler", 1, "[downloadFileV3], param is invalid.");
            return;
        }
        q.a battlePassBottom = qVar.getBattlePassBottom();
        if (battlePassBottom != null) {
            p(battlePassBottom.getIconUrl(), qVar, 5);
        }
        q.b batterPassProgress = qVar.getBatterPassProgress();
        if (batterPassProgress != null) {
            p(batterPassProgress.getLevelIconUrl(), qVar, 4);
        }
    }

    private void n() {
        File cacheDir;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = MobileQQ.sMobileQQ.getCacheDir();
        }
        File file = new File(cacheDir, "widgetImg");
        this.f212140b = file;
        if (!file.exists() || !this.f212140b.isDirectory()) {
            this.f212140b.mkdirs();
        }
    }

    private void p(String str, q qVar, int i3) {
        if (!TextUtils.isEmpty(str) && qVar != null) {
            String Crc64String = Utils.Crc64String(str);
            QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[handleImgDownloadV2] fileName:" + Crc64String + ",url:" + str + ",type:" + i3);
            File file = new File(this.f212140b, Crc64String);
            if (file.exists()) {
                QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "file Exists~" + file.getAbsolutePath());
                t(file.getAbsolutePath(), qVar, i3);
                return;
            }
            a aVar = new a(file, qVar, i3);
            h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
            g gVar = new g(str, file);
            if (downloader != null) {
                downloader.startDownload(gVar, aVar, null);
                return;
            }
            return;
        }
        QLog.w("GCWidget.WidgetConfigLogicHandler", 1, "[handleImgDownloadV2]] url is empty,type:" + i3);
    }

    public static boolean r() {
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        int[] appWidgetIds = AppWidgetManager.getInstance(applicationContext).getAppWidgetIds(new ComponentName(applicationContext, (Class<?>) GameCenterAppWidgetProviderV2.class));
        if (appWidgetIds != null && appWidgetIds.length > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t(String str, q qVar, int i3) {
        q.b batterPassProgress;
        try {
            if (i3 == 0) {
                q.i promotionAd = qVar.getPromotionAd();
                if (promotionAd != null) {
                    promotionAd.h(str);
                }
            } else if (i3 == 1) {
                q.g gift = qVar.getGift();
                if (gift != null) {
                    gift.k(str);
                }
            } else if (i3 == 2) {
                q.e cloudGame = qVar.getCloudGame();
                if (cloudGame != null) {
                    cloudGame.h(str);
                }
            } else if (i3 == 5) {
                q.a battlePassBottom = qVar.getBattlePassBottom();
                if (battlePassBottom != null) {
                    battlePassBottom.i(str);
                }
            } else if (i3 == 4 && (batterPassProgress = qVar.getBatterPassProgress()) != null) {
                batterPassProgress.h(str);
            }
            f(qVar);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (!s()) {
            return;
        }
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[startFetchV2] when time up");
        u();
    }

    public synchronized void f(q qVar) {
        if (!r()) {
            QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[cacheWidgetInfoAndNotifyUpdateV2] not has widget");
            return;
        }
        this.f212142d = qVar;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f212143e);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f212143e, 500L);
    }

    public void g() {
        try {
            if (this.f212140b.exists()) {
                FileUtils.deleteFilesInDirectory(this.f212140b.getAbsolutePath());
            }
        } catch (Throwable th5) {
            QLog.e("GCWidget.WidgetConfigLogicHandler", 1, "clearCache error:", th5);
        }
    }

    public void h() {
        r.b();
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("GCWidget.WidgetConfigLogicHandler", 1, "[downloadAndUpdateUiV2] url is empty");
            return;
        }
        String Crc64String = Utils.Crc64String(str);
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[downloadAndUpdateUiV2] fileName:" + Crc64String + ",url:" + str);
        File file = new File(this.f212140b, Crc64String);
        if (file.exists()) {
            QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "file Exists~" + file.getAbsolutePath());
            i();
            return;
        }
        b bVar = new b(file);
        h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
        g gVar = new g(str, file);
        if (downloader != null) {
            downloader.startDownload(gVar, bVar, null);
        }
    }

    public void m() {
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[fetchEncryptedUinFromSvrV2]");
        this.f212139a.g();
    }

    public String o(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new File(this.f212140b, Utils.Crc64String(str)).getAbsolutePath();
        }
        return "";
    }

    public void q(long j3) {
        boolean hasWidgetV2 = ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).hasWidgetV2();
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[handleWidgetUpdatePush] nextPullTs=" + j3 + ", hasWidget=" + hasWidgetV2);
        if (!hasWidgetV2) {
            return;
        }
        u();
        if (j3 > 0) {
            this.f212144f.removeCallbacks(this.f212145g);
            this.f212144f.postDelayed(this.f212145g, j3 * 1000);
        }
    }

    public boolean s() {
        boolean z16;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long c16 = r.c();
        if (c16 != -1 && serverTimeMillis < 1000 * c16) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GCWidget.WidgetConfigLogicHandler", 2, "[isPullConfigTimeUpV2] curTime:" + serverTimeMillis + ",nextPullTs:" + c16 + ",isPullConfigTimeUp:" + z16);
        }
        return true;
    }

    public void u() {
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[requestRightNowV2]");
        this.f212139a.i(0);
    }

    public void v(int i3) {
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[requestRightNowV2]");
        this.f212139a.i(i3);
    }

    public synchronized void x() {
        Timer timer = this.f212141c;
        if (timer != null) {
            timer.cancel();
        }
        this.f212141c = new BaseTimer();
        this.f212141c.schedule(new TimerTask() { // from class: com.tencent.mobileqq.gamecenter.logic.WidgetConfigLogicHandler.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    if (((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).hasWidgetV2()) {
                        WidgetConfigLogicHandler.this.w();
                    }
                } catch (Throwable th5) {
                    QLog.e("GCWidget.WidgetConfigLogicHandler", 1, "[startTimer], th:" + th5);
                }
            }
        }, 0L, 120000L);
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "Timer is started~~");
    }

    public void y(QQWidgetSvr$NewWidget qQWidgetSvr$NewWidget) {
        q f16 = r.f(qQWidgetSvr$NewWidget);
        if (f16 != null) {
            k(f16);
        } else {
            f(null);
        }
    }

    public void z(int i3, QQWidgetSvr$BattlepassWidget qQWidgetSvr$BattlepassWidget, QQWidgetSvr$NewWidget qQWidgetSvr$NewWidget, long j3) {
        QLog.i("GCWidget.WidgetConfigLogicHandler", 1, "[updateWidgetConfigV3], type:" + i3 + ",nextPullTs:" + j3);
        r.e(j3);
        if (i3 == 0) {
            y(qQWidgetSvr$NewWidget);
        } else if (i3 == 1) {
            A(qQWidgetSvr$BattlepassWidget);
        }
    }
}
