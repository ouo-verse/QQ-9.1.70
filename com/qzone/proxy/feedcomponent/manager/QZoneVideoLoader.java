package com.qzone.proxy.feedcomponent.manager;

import NS_MOBILE_VIDEO.UrlInput;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.manager.j;
import com.qzone.proxy.feedcomponent.model.u;
import com.qzone.proxy.feedcomponent.ui.m;
import com.qzone.video.service.QZoneVideoCheckService;
import com.qzone.video.service.QZoneVideoReportService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qzoneplayer.player.LogProxy;
import com.tencent.mobileqq.qzoneplayer.report.VideoReporter;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.api.ILog;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.VideoLoader;
import com.tencent.oskplayer.contrib.decprobe.DecoderProbe;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProcessUtils;
import cooperation.qzone.util.QZLog;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;
import s8.l;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneVideoLoader implements NetworkState.NetworkStateListener, VideoLoader, IObserver.background {
    private static volatile QZoneVideoLoader D;
    private static ConcurrentHashMap<String, u> E = new ConcurrentHashMap<>();
    public static int F = 600000;
    public static int G = 100;

    /* renamed from: e, reason: collision with root package name */
    private c f50170e;

    /* renamed from: d, reason: collision with root package name */
    private Context f50169d = BaseApplication.getContext();

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f50171f = new BaseHandlerThread("Qzone_video_loader_thread");

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f50172h = new ConcurrentHashMap<>(8, 0.75f, 2);

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f50173i = false;

    /* renamed from: m, reason: collision with root package name */
    private final BitSet f50174m = new BitSet(16);
    private VideoProxy.OnConnectionChangeListener C = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ChangeVkeyRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private CountDownLatch f50178d;

        /* renamed from: e, reason: collision with root package name */
        private String f50179e;

        /* renamed from: f, reason: collision with root package name */
        private String f50180f;

        /* renamed from: h, reason: collision with root package name */
        private Handler f50181h;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a extends l {
            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SmartParcelable dataFromBudle;
                if (message.what != 1000110) {
                    return;
                }
                Bundle data = message.getData();
                QZoneResult qZoneResult = (data == null || (dataFromBudle = ParcelableWrapper.getDataFromBudle(data, "result")) == null || !(dataFromBudle instanceof QZoneResult)) ? null : (QZoneResult) dataFromBudle;
                if (qZoneResult == null) {
                    QZLog.e("QZoneVideoLoader", "change vkey time out. url=" + ((String) message.obj));
                    ChangeVkeyRunnable.this.f50181h.removeMessages(1000110, message.obj);
                    ChangeVkeyRunnable.this.f50180f = null;
                } else {
                    ChangeVkeyRunnable.this.f50181h.removeMessages(1000110, message.obj);
                    String string = ((Bundle) qZoneResult.getData()).getString("retryUrl");
                    if (qZoneResult.getSucceed()) {
                        ChangeVkeyRunnable.this.f50180f = string;
                        QZLog.i("QZoneVideoLoader", 1, "change vkey success. originRrl=" + ChangeVkeyRunnable.this.f50179e + " retryUrl=" + ChangeVkeyRunnable.this.f50180f);
                        if (!TextUtils.isEmpty(ChangeVkeyRunnable.this.f50180f)) {
                            String videoKey = QZoneVideoLoader.this.n().getVideoKey(ChangeVkeyRunnable.this.f50179e);
                            if (!TextUtils.isEmpty(videoKey)) {
                                QZoneVideoLoader.this.f50172h.put(videoKey, ChangeVkeyRunnable.this.f50180f);
                            }
                        }
                    } else {
                        QZLog.e("QZoneVideoLoader", "change vkey failed. url=" + ChangeVkeyRunnable.this.f50179e);
                        ChangeVkeyRunnable.this.f50180f = null;
                    }
                }
                ChangeVkeyRunnable.this.f50178d.countDown();
            }
        }

        public ChangeVkeyRunnable(String str, CountDownLatch countDownLatch) {
            this.f50181h = new a(QZoneVideoLoader.this.f50171f.getLooper());
            this.f50178d = countDownLatch;
            this.f50179e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            QZoneVideoCheckService.get().changeVideoVkey(this.f50179e, this.f50181h);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements SDKInitListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f50183d;

        /* compiled from: P */
        /* renamed from: com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0425a implements ILog {
            C0425a() {
            }

            @Override // com.tencent.mobileqq.videoplatform.api.ILog
            public void e(String str, int i3, String str2) {
                QZLog.e(str, str2);
            }

            @Override // com.tencent.mobileqq.videoplatform.api.ILog
            public boolean isColorLevel() {
                return true;
            }

            @Override // com.tencent.mobileqq.videoplatform.api.ILog
            public void d(String str, int i3, String str2) {
                QZLog.i(str, 1, str2);
            }

            @Override // com.tencent.mobileqq.videoplatform.api.ILog
            public void e(String str, int i3, String str2, Throwable th5) {
                QZLog.e(str, str2, th5);
            }

            @Override // com.tencent.mobileqq.videoplatform.api.ILog
            public void i(String str, int i3, String str2) {
                QZLog.i(str, 1, str2);
            }

            @Override // com.tencent.mobileqq.videoplatform.api.ILog
            public void v(String str, int i3, String str2) {
                QZLog.i(str, 1, str2);
            }

            @Override // com.tencent.mobileqq.videoplatform.api.ILog
            public void w(String str, int i3, String str2) {
                QZLog.w(str, 1, str2);
            }
        }

        a(long j3) {
            this.f50183d = j3;
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            boolean z17 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_SUPER_PLAYER_INJECT_FULL_LOG, 1) == 1;
            QZLog.d("QZoneVideoLoader", 1, "[initVideoSDK] on super player inited=" + z16 + ", cost=" + (System.currentTimeMillis() - this.f50183d) + ", process=" + MobileQQ.sProcessId + ", injectLog=" + z17);
            if (z16 && z17 && 2 == MobileQQ.sProcessId) {
                LogUtil.setLogImp(new C0425a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements HttpRetryLogic {
        public c() {
        }

        @Override // com.tencent.oskplayer.proxy.HttpRetryLogic
        public synchronized String getRetryUrl(String str, int i3, int i16, Map<String, List<String>> map) {
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc;
            String substring;
            String h16;
            int i17;
            String substring2;
            String substring3;
            String substring4;
            QZLog.i("RetryUrl", 1, "start retry url, originUrl=" + str + " retrycount = " + i3);
            String str2 = null;
            if (!TextUtils.isEmpty(str) && (str.contains(".m3u8") || str.contains(".ts"))) {
                return null;
            }
            if (i3 >= 100) {
                return null;
            }
            if (TextUtils.isEmpty(str) || !str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return null;
            }
            int i18 = 0;
            String substring5 = str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
            if (i16 == 403) {
                if (!TextUtils.isEmpty(substring5) && substring5.toLowerCase().contains("video.tc.qq.com")) {
                    int indexOf = str.indexOf("video.tc.qq.com");
                    if (indexOf > 0 && str.length() > (i17 = indexOf + 16) && (substring2 = str.substring(i17)) != null && substring2.contains(".")) {
                        String substring6 = substring2.substring(0, substring2.indexOf("."));
                        if (substring2.length() > substring2.indexOf(".") + 1 && (substring3 = substring2.substring(substring2.indexOf(".") + 1)) != null && substring3.length() > substring3.indexOf(".") + 1 && (substring4 = substring3.substring(substring3.indexOf(".") + 1)) != null && substring4.length() > substring4.indexOf(".")) {
                            try {
                                i18 = Integer.parseInt(substring4.substring(0, substring4.indexOf(".")));
                                if (QZLog.isDevelopLevel()) {
                                    QZLog.d("RetryUrl", 4, "request segment = " + i18);
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                        h16 = QZoneVideoLoader.this.h(str, substring6, i18, 8000);
                        str2 = h16;
                    }
                } else if (!TextUtils.isEmpty(substring5) && substring5.toLowerCase().contains("qzvv.video.qq.com")) {
                    if (str.contains("vid=") && str.length() > str.indexOf("vid=") + 4 && (substring = str.substring(str.indexOf("vid=") + 4)) != null && substring.length() > substring.indexOf(ContainerUtils.FIELD_DELIMITER)) {
                        h16 = QZoneVideoLoader.this.h(str, substring.substring(0, substring.indexOf(ContainerUtils.FIELD_DELIMITER)), 0, 8000);
                        str2 = h16;
                    }
                } else if (!TextUtils.isEmpty(substring5)) {
                    String lowerCase = substring5.toLowerCase();
                    List<String> normalVideoPathList = PlayerConfig.g().getNormalVideoPathList();
                    if (normalVideoPathList != null) {
                        Iterator<String> it = normalVideoPathList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (!TextUtils.isEmpty(next) && lowerCase.contains(next)) {
                                str2 = QZoneVideoLoader.this.i(str, 8000);
                                break;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str2) && (feedVideoExternalFunc = FeedVideoEnv.externalFunc) != null && feedVideoExternalFunc.isUgcOnCloudUrl(lowerCase)) {
                        str2 = QZoneVideoLoader.this.i(str, 8000);
                    }
                }
            }
            QZLog.i("RetryUrl", 1, "end retry url, originUrl=" + str + "retryUrl=" + str2 + " retrycount = " + i3);
            return str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements com.tencent.mobileqq.qzoneplayer.video.i {

        /* renamed from: a, reason: collision with root package name */
        public String f50187a;

        /* renamed from: b, reason: collision with root package name */
        public String f50188b;

        /* renamed from: c, reason: collision with root package name */
        public String f50189c;

        /* renamed from: d, reason: collision with root package name */
        public int f50190d;

        /* renamed from: e, reason: collision with root package name */
        public CountDownLatch f50191e;

        public d(String str, String str2, int i3, CountDownLatch countDownLatch) {
            this.f50187a = str;
            this.f50189c = str2;
            this.f50190d = i3;
            this.f50191e = countDownLatch;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
        @Override // com.tencent.mobileqq.qzoneplayer.video.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(String str, boolean z16, SegmentVideoInfo.StreamInfo streamInfo, String[] strArr, boolean z17, int i3, boolean z18) {
            ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
            if (z16 && streamInfo != null && (arrayList = streamInfo.segmentInfos) != null && arrayList.size() > 0) {
                if (this.f50190d > 0) {
                    int size = streamInfo.segmentInfos.size();
                    int i16 = this.f50190d;
                    if (size >= i16) {
                        this.f50188b = streamInfo.segmentInfos.get(i16 - 1).url;
                        if (QZLog.isColorLevel()) {
                            QZLog.i("RetryUrl", 2, "response segment url successed ");
                        }
                    }
                }
                this.f50188b = streamInfo.segmentInfos.get(0).url;
                if (QZLog.isColorLevel()) {
                }
            } else if (QZLog.isColorLevel()) {
                QZLog.i("RetryUrl", 2, "response segment url is failed");
            }
            CountDownLatch countDownLatch = this.f50191e;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.i
        public void a(String str, boolean z16, String str2, int i3, int i16) {
            if (z16 && !TextUtils.isEmpty(str2)) {
                this.f50188b = str2;
            }
            CountDownLatch countDownLatch = this.f50191e;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    QZoneVideoLoader() {
        this.f50171f.start();
        NetworkState.addListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(final String str, final String str2, int i3, int i16) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final d dVar = new d(str, str2, i3, countDownLatch);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader.2
            @Override // java.lang.Runnable
            public void run() {
                com.qzone.adapter.feedcomponent.i.H().z0(str, str2, null, null, dVar);
            }
        });
        try {
            if (countDownLatch.await(i16, TimeUnit.MILLISECONDS)) {
                return dVar.f50188b;
            }
            return null;
        } catch (InterruptedException unused) {
            QZLog.i("QZoneVideoLoader", 1, "change vkey interrupted. url=" + str);
            Thread.currentThread().interrupt();
            return dVar.f50188b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(String str, int i3) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ChangeVkeyRunnable changeVkeyRunnable = new ChangeVkeyRunnable(str, countDownLatch);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(changeVkeyRunnable);
        try {
            if (countDownLatch.await(i3, TimeUnit.MILLISECONDS)) {
                return changeVkeyRunnable.f50180f;
            }
            QZLog.e("QZoneVideoLoader", "change vkey time out. url=" + str);
            return null;
        } catch (InterruptedException unused) {
            QZLog.i("QZoneVideoLoader", 1, "change vkey interrupted. url=" + str);
            Thread.currentThread().interrupt();
            return changeVkeyRunnable.f50180f;
        }
    }

    public static QZoneVideoLoader l() {
        if (D == null) {
            synchronized (QZoneVideoLoader.class) {
                if (D == null) {
                    D = new QZoneVideoLoader();
                }
            }
        }
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoManager n() {
        q();
        return VideoManager.getInstance();
    }

    public static void p() {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            return;
        }
        QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new a(System.currentTimeMillis()));
    }

    private void q() {
        if (VideoManager.hasInit()) {
            return;
        }
        PlayerUtils.log(4, "QZoneVideoLoader", "initEnv initVideoManager success");
        VideoManager.init(BaseApplication.getContext());
        VideoManager.getInstance().setDataSourceBuilder(com.tencent.mobileqq.qzoneplayer.videosource.b.b());
    }

    public static void r() {
        if (PlayerConfig.hasInit()) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            PlayerConfig.init(context);
            PlayerConfig.g().setLogger(new i());
            FeedVideoEnv.init(new s8.i(), new m(), new s8.h());
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.proxy.feedcomponent.manager.h
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneVideoLoader.p();
                }
            }, QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_SUPER_PLAYER_INIT_DELAY_TIME, 5000));
            return;
        }
        throw new RuntimeException("BaseApplicationImpl ctx is null");
    }

    public static boolean s() {
        if (!(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_SUPER_PLAYER_ENABLED, 1) == 1)) {
            QZLog.i("QZoneVideoLoader", 1, "[isSuperPlayerEnabled] not enabled");
            return false;
        }
        if (!(QQVideoPlaySDKManager.isSDKReady() && QQVideoPlaySDKManager.isSoLoadSucess())) {
            QZLog.i("QZoneVideoLoader", 1, "[isSuperPlayerEnabled] not ready");
            return false;
        }
        String[] split = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_SUPER_PLAYER_UIN_POSTFIX, "0,1,2,3,4,5,6,7,8,9").split(",");
        String uinString = LoginData.getInstance().getUinString();
        for (String str : split) {
            if (uinString.endsWith(str)) {
                QZLog.i("QZoneVideoLoader", 1, "[isSuperPlayerEnabled] user greyed");
                return true;
            }
        }
        QZLog.i("QZoneVideoLoader", 1, "[isSuperPlayerEnabled] not greyed");
        return false;
    }

    public static void t() {
        l().k();
    }

    private j u() {
        j a16 = g.a();
        if (a16 != null) {
            if (!TextUtils.isEmpty(a16.f50221b)) {
                System.setProperty("http.proxyHost", a16.f50221b);
            }
            if (!TextUtils.isEmpty(a16.f50222c)) {
                System.setProperty("http.proxyPort", a16.f50222c);
            }
            if (!TextUtils.isEmpty(a16.f50223d)) {
                System.setProperty("http.nonProxyHosts", a16.f50223d);
            }
            if (!TextUtils.isEmpty(a16.f50224e)) {
                System.setProperty("https.proxyHost", a16.f50224e);
            }
            if (!TextUtils.isEmpty(a16.f50225f)) {
                System.setProperty("https.proxyPort", a16.f50225f);
            }
            if (!TextUtils.isEmpty(a16.f50226g)) {
                System.setProperty("https.nonProxyHosts", a16.f50226g);
            }
        }
        return a16;
    }

    @Override // com.tencent.oskplayer.VideoLoader
    public void addHttpErrorListener(String str, VideoProxy.HttpErrorListener httpErrorListener) {
        n().addHttpErrorListener(str, httpErrorListener);
    }

    @Override // com.tencent.oskplayer.VideoLoader
    public void addHttpRetryLogic(String str, HttpRetryLogic httpRetryLogic) {
        n().addHttpRetryLogic(str, httpRetryLogic);
    }

    @Override // com.tencent.oskplayer.VideoLoader
    public void clearCacheByInfo(SegmentVideoInfo segmentVideoInfo) {
        n().clearCacheByInfo(segmentVideoInfo);
    }

    public void f(String str) {
        n().addHttpRetryLogic(str, m());
    }

    @Override // com.tencent.oskplayer.VideoLoader
    public double getCachedSizeRate(String str) {
        return n().getCachedSizeRate(str);
    }

    @Override // com.tencent.oskplayer.VideoLoader
    public String getUrl(String str) {
        String videoKey = n().getVideoKey(str);
        String str2 = !TextUtils.isEmpty(videoKey) ? this.f50172h.get(videoKey) : null;
        VideoManager n3 = n();
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        return n3.getUrl(str);
    }

    @Override // com.tencent.oskplayer.VideoLoader
    public void initEnv() {
        PlayerUtils.log(4, "QZoneVideoLoader", "initEnv start");
        q();
    }

    public u j(String str, com.tencent.mobileqq.qzoneplayer.video.u uVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (E.containsKey(str)) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QZoneVideoLoader", 4, "[QZ_Video]cache hit illegal record = " + str);
            }
            return E.get(str);
        }
        UrlInput urlInput = new UrlInput(0, str);
        ArrayList<UrlInput> arrayList = new ArrayList<>();
        arrayList.add(urlInput);
        QZoneVideoCheckService.get().check(arrayList, uVar);
        return null;
    }

    public HttpRetryLogic m() {
        if (this.f50170e == null) {
            this.f50170e = new c();
        }
        return this.f50170e;
    }

    public String o(String str) {
        if (!VideoManager.hasInit()) {
            VideoManager.init(this.f50169d);
        }
        return n().getUrl(str, null, "1");
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        if ("Feed".equals(event.source.getName()) && event.what == 20) {
            EventCenter.getInstance().removeObserver(this);
        }
    }

    @Override // com.tencent.oskplayer.VideoLoader
    public void removeHttpErrorListener(String str) {
        n().removeHttpErrorListener(str);
    }

    @Override // com.tencent.oskplayer.VideoLoader
    public void removeHttpRetryLogic(String str) {
        n().removeHttpRetryLogic(str);
    }

    private void k() {
        String[] split;
        String[] split2;
        if (this.f50173i) {
            return;
        }
        PlayerUtils.log(4, "QZoneVideoLoader", "configVideoSDK");
        EventCenter.getInstance().addObserver(this, 3, "Feed", 20);
        PlayerConfig.g().setVideoKeyGenerator(new vl2.c());
        ExoMediaPlayer.setLogger(new LogProxy(PlayerConfig.g().getLogger()));
        OskSupport.init(PlayerConfig.g().getAppContext(), new com.tencent.oskplayer.util.LogProxy(PlayerConfig.g().getLogger()), PlayerConfig.g().getNativeLibLoader());
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_ENABLE_PROXY, 1);
        int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_ENABLE_CACHE, 1);
        F = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_ILLEGAL_CACHE_DURATION, 600000);
        PlayerConfig.g().setCacheMaxBytes(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_MAX_CACHE_SIZE, 536870912));
        PlayerConfig.g().setVideoReporter(new VideoReporter(QZoneVideoReportService.l(), QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_VIDEO_NEXT_PLAYID_TIME_STAMP, 1) * 1000));
        PlayerConfig.g().setOnConnectionChangeListener(this.C);
        int config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_LOW_SPEED_SECONDS, 8);
        int config4 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_LOW_SPEED_RATES, 20);
        String config5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_CONTENT_TYPE, "");
        String config6 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TC_PATH_TYPE, "video.tc.qq.com|vkp.tc.qq.com");
        String config7 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_NORMAL_PATH_TYPE, QzoneConfig.DEFAULT_VIDEO_HOST_ENABLE_HTTPDNSSERVICE);
        String config8 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HOST_ENABLE_HTTPDNSSERVICE, QzoneConfig.DEFAULT_VIDEO_HOST_ENABLE_HTTPDNSSERVICE);
        String config9 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HOST_ENABLE_HTTPDNSSERVICE_PREPENDIP, QzoneConfig.DEFAULT_VIDEO_HOST_ENABLE_HTTPDNSSERVICE);
        int config10 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_SAFE_URL_TIMEOUT, 8);
        int config11 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_CACHE_PROVIDER, 1);
        int config12 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_VKEY_TIMEOUT, 10);
        int config13 = QzoneConfig.getInstance().getConfig("VideoSDKSetting", "videoErrorRetryCount", 3);
        String config14 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_HERO_VIDEO_AVAILABLE_CHECK, QzoneConfig.SECONDARY_HERO_VIDEO_AVAILABLE_DEFAULT);
        String config15 = QzoneConfig.getInstance().getConfig("VideoSDKSetting", "VideoExo2QLoadControlConfig", ExoMediaPlayer.DEFAULT_LC_SAMPLE_CONFIG);
        String config16 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_DEFAULT_DATASOURCE_TYPE, "-1");
        String config17 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_WEISHI_PATH_TYPE, "video.qzone.qq.com|sv.qzone.qq.com|v.qqstory.qq.com|v.weishi.qq.com");
        boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_ENABLE_WEISHI_DIRECT_IP, 1) == 1;
        QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_HERO_VIDEO_HVC_HWDEC_MODE, QzoneConfig.DEFAULT_HERO_VIDEO_HVC_HWDEC_MODE);
        PlayerConfig.g().setHeroPlayerSetInfo(new ArrayList(Arrays.asList(config14, ProcessUtils.getCurProcessName(this.f50169d))));
        PlayerConfig.g().setEnableProxy(config > 0);
        PlayerConfig.g().setEnableCache(config2 > 0);
        PlayerConfig.g().setCacheProvider(config11);
        PlayerConfig.g().setVideoEnableLowSpeedSeconds(config3);
        PlayerConfig.g().setVideoEnableLowSpeedRates(config4);
        PlayerConfig.g().setSafeUrlTimeOut(config10);
        PlayerConfig.g().setVideoVkeyTimeOut(config12);
        PlayerConfig.g().setDataSourceMaxRetryCount(config13);
        PlayerConfig.g().setFloatVideoCompleteType(8);
        PlayerConfig.g().setIsDebugVersion(FeedVideoEnv.externalFunc.isDebugVersion());
        PlayerConfig.g().setQLoadControlConfig(config15);
        PlayerConfig.g().setDNSService(new SmartHttpDnsService());
        PlayerConfig.g().setHostEnableHttpDNSService(config8);
        PlayerConfig.g().setHostEnableHttpDNSServicePrependIp(config9);
        PlayerConfig.g().setEnableWeishiDirectIp(z16);
        PlayerConfig.g().setIPStackType(FeedVideoEnv.externalFunc.getIPStackType());
        PlayerConfig.g().setDefaultDataSourceType(config16);
        j u16 = u();
        PlayerUtils.log(4, "QZoneVideoLoader", "qzvideoipv6 config " + u16);
        if (u16 != null) {
            vl2.a.a().c(u16.f50220a);
            j.a[] aVarArr = u16.f50227h;
            if (aVarArr != null && aVarArr.length > 0) {
                j.a aVar = aVarArr[0];
                throw null;
            }
            s8.h.f433439b = u16.f50228i;
            s8.h.f433440c = u16.f50229j;
        }
        String videoPlayCacheDir = CacheManager.getVideoPlayCacheDir();
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneVideoLoader", 4, "cacheDir=" + videoPlayCacheDir);
        }
        PlayerConfig.g().setCacheDir(videoPlayCacheDir);
        if (!TextUtils.isEmpty(config5) && (split2 = config5.split("\\|")) != null && split2.length > 0) {
            PlayerConfig.g().setContentTypeList(Arrays.asList(split2));
        }
        if (!TextUtils.isEmpty(config6) && (split = config6.split("\\|")) != null && split.length > 0) {
            PlayerConfig.g().setTcVideoPathList(Arrays.asList(split));
        }
        if (!TextUtils.isEmpty(config7)) {
            String[] split3 = config7.split("\\|");
            if (split3.length > 0) {
                PlayerConfig.g().setNormalVideoPathList(Arrays.asList(split3));
            }
        }
        if (!TextUtils.isEmpty(config17)) {
            String[] split4 = config17.split("\\|");
            if (split4.length > 0) {
                PlayerConfig.g().setWeiShiVideoPathList(Arrays.asList(split4));
            }
        }
        this.f50173i = true;
    }

    public void g(ArrayList<u> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, u>> it = E.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Map.Entry<String, u> next = it.next();
            if (currentTimeMillis - next.getValue().c().longValue() > F) {
                it.remove();
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("QZoneVideoLoader", 4, "expired illegal record = " + next.getKey());
                }
            }
            i3++;
            if (i3 > G) {
                it.remove();
                i3--;
            }
        }
        Iterator<u> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            u next2 = it5.next();
            String d16 = next2.d();
            if (!E.containsKey(d16)) {
                u uVar = new u();
                uVar.h(next2.d());
                uVar.e(next2.a());
                uVar.f(next2.b());
                uVar.g(Long.valueOf(currentTimeMillis));
                E.put(d16, uVar);
            } else {
                E.get(d16).g(Long.valueOf(currentTimeMillis));
                E.get(d16).e(next2.a());
                E.get(d16).f(next2.b());
            }
        }
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (!z16 || FeedVideoEnv.externalFunc == null) {
            return;
        }
        PlayerConfig.g().setIPStackType(FeedVideoEnv.externalFunc.getIPStackType());
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements VideoProxy.OnConnectionChangeListener {
        b() {
        }

        @Override // com.tencent.oskplayer.proxy.VideoProxy.OnConnectionChangeListener
        public void onConnectionChange(boolean z16, InputStream inputStream, OutputStream outputStream) {
            if (z16) {
                if (inputStream != null) {
                    BaseApplication.addServerSocket(inputStream.toString());
                }
                if (outputStream != null) {
                    BaseApplication.addServerSocket(outputStream.toString());
                    return;
                }
                return;
            }
            if (inputStream != null) {
                BaseApplication.removeServerSocket(inputStream.toString());
            }
            if (outputStream != null) {
                BaseApplication.removeServerSocket(outputStream.toString());
            }
        }
    }

    public void v(boolean z16) {
        if (z16) {
            this.f50174m.set(0);
            PlayerUtils.log(4, DecoderProbe.LOG_TAG, "DecoderProbe disabled");
        } else {
            this.f50174m.clear(0);
        }
    }

    public void w(boolean z16) {
        if (z16) {
            this.f50174m.set(1);
        } else {
            this.f50174m.clear(1);
        }
    }
}
