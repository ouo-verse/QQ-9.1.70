package com.tencent.mobileqq.qzoneplayer.video;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.player.CachedMediaPlayer;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManagerUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.PlayerCallBack;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.model.VideoInfo;
import com.tencent.oskplayer.player.ISegmentMediaPlayer;
import com.tencent.oskplayer.player.StateMediaPlayer;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.ThreadUtils;
import com.tencent.oskplayer.util.VideoSpeedReport;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BaseVideoManager {

    /* renamed from: i, reason: collision with root package name */
    private static volatile BaseVideoManager f279597i;

    /* renamed from: a, reason: collision with root package name */
    String f279606a;

    /* renamed from: b, reason: collision with root package name */
    ManagerHandler f279607b;

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferences f279609d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f279610e;
    public static final boolean belowICE_CREAM = false;

    /* renamed from: j, reason: collision with root package name */
    public static HashSet<String> f279598j = new HashSet<>();

    /* renamed from: k, reason: collision with root package name */
    public static HashSet<String> f279599k = new HashSet<>();

    /* renamed from: l, reason: collision with root package name */
    private static HashMap<Integer, Integer> f279600l = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    public static List<Double> f279601m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public static List<Double> f279602n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    private static j f279603o = new j();

    /* renamed from: p, reason: collision with root package name */
    public static int f279604p = 10000;

    /* renamed from: q, reason: collision with root package name */
    private static AtomicInteger f279605q = new AtomicInteger(20000);

    /* renamed from: c, reason: collision with root package name */
    private int f279608c = 0;

    /* renamed from: f, reason: collision with root package name */
    private c f279611f = new c();

    /* renamed from: g, reason: collision with root package name */
    private int f279612g = 0;

    /* renamed from: h, reason: collision with root package name */
    private PlayerCallBack f279613h = new a();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface VideoPlayInfoListener {
        void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder);

        void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder);

        void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder);

        void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder);

        void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder);

        void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements IMediaPlayer.OnPreparedListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnLoopStartListener, VideoProxy.HttpErrorListener, AudioManager.OnAudioFocusChangeListener {
        b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            ManagerHandler managerHandler;
            PlayerUtils.log(3, BaseVideoManager.this.f279606a, "onAudioFocusChange " + i3);
            ManagerHandler managerHandler2 = BaseVideoManager.this.f279607b;
            if (managerHandler2 != null && !managerHandler2.P1()) {
                PlayerUtils.log(3, BaseVideoManager.this.f279606a, "ignore onAudioFocusChange " + i3);
                return;
            }
            if (i3 == -2) {
                ManagerHandler managerHandler3 = BaseVideoManager.this.f279607b;
                if (managerHandler3 == null || !managerHandler3.X0()) {
                    return;
                }
                BaseVideoManager.this.pauseVideo();
                return;
            }
            if (i3 == 1) {
                ManagerHandler managerHandler4 = BaseVideoManager.this.f279607b;
                if (managerHandler4 == null || managerHandler4.N() != 3) {
                    return;
                }
                BaseVideoManager.this.F();
                return;
            }
            if (i3 == -1 && (managerHandler = BaseVideoManager.this.f279607b) != null && managerHandler.X0()) {
                BaseVideoManager.this.pauseVideo();
            }
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i3) {
            String currentProxySegmentUrl;
            String videoUuidFromVideoUrl;
            if (iMediaPlayer instanceof ISegmentMediaPlayer) {
                currentProxySegmentUrl = ((ISegmentMediaPlayer) iMediaPlayer).getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            } else {
                currentProxySegmentUrl = BaseVideoManager.this.f279607b.A().d().getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            }
            PlayerUtils.log(4, BaseVideoManager.this.f279606a, "onBufferingUpdate " + currentProxySegmentUrl + " percent=" + i3);
            ManagerHandler managerHandler = BaseVideoManager.this.f279607b;
            if (managerHandler != null) {
                managerHandler.obtainMessage(36, i3, 0, videoUuidFromVideoUrl).sendToTarget();
            }
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            String currentProxySegmentUrl;
            String videoUuidFromVideoUrl;
            ManagerHandler managerHandler;
            if (iMediaPlayer instanceof ISegmentMediaPlayer) {
                currentProxySegmentUrl = ((ISegmentMediaPlayer) iMediaPlayer).getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            } else {
                currentProxySegmentUrl = BaseVideoManager.this.f279607b.A().d().getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            }
            PlayerUtils.log(4, BaseVideoManager.this.f279606a, "onCompletion " + currentProxySegmentUrl);
            if (iMediaPlayer.isLooping() || (managerHandler = BaseVideoManager.this.f279607b) == null) {
                return;
            }
            managerHandler.obtainMessage(35, videoUuidFromVideoUrl).sendToTarget();
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i3, int i16) {
            String currentProxySegmentUrl;
            String videoUuidFromVideoUrl;
            if (iMediaPlayer instanceof ISegmentMediaPlayer) {
                currentProxySegmentUrl = ((ISegmentMediaPlayer) iMediaPlayer).getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            } else {
                currentProxySegmentUrl = BaseVideoManager.this.f279607b.A().d().getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            }
            PlayerUtils.log(4, BaseVideoManager.this.f279606a, "onError " + currentProxySegmentUrl + " what=" + i3 + " extra=" + i16);
            ManagerHandler managerHandler = BaseVideoManager.this.f279607b;
            if (managerHandler == null) {
                return false;
            }
            managerHandler.obtainMessage(30, i3, i16, videoUuidFromVideoUrl).sendToTarget();
            return false;
        }

        @Override // com.tencent.oskplayer.proxy.VideoProxy.HttpErrorListener
        public void onHttpError(String str, String str2, int i3, Map<String, Object> map, Map<String, List<String>> map2, int i16, long j3, long j16) {
            if (BaseVideoManager.this.f279607b != null) {
                com.tencent.mobileqq.qzoneplayer.video.c cVar = new com.tencent.mobileqq.qzoneplayer.video.c();
                cVar.f279972a = str;
                cVar.f279973b = Integer.valueOf(i3);
                cVar.f279974c = Long.valueOf(j3);
                cVar.f279975d = Long.valueOf(j16);
                BaseVideoManager.this.f279607b.obtainMessage(70, cVar).sendToTarget();
            }
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i3, int i16) {
            String currentProxySegmentUrl;
            String videoUuidFromVideoUrl;
            if (iMediaPlayer instanceof ISegmentMediaPlayer) {
                currentProxySegmentUrl = ((ISegmentMediaPlayer) iMediaPlayer).getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            } else {
                currentProxySegmentUrl = BaseVideoManager.this.f279607b.A().d().getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            }
            PlayerUtils.log(4, BaseVideoManager.this.f279606a, "onInfo " + currentProxySegmentUrl + " what=" + i3 + " extra=" + i16);
            ManagerHandler managerHandler = BaseVideoManager.this.f279607b;
            if (managerHandler == null) {
                return false;
            }
            managerHandler.obtainMessage(37, i3, i16, videoUuidFromVideoUrl).sendToTarget();
            return false;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener
        public void onLoopStart(IMediaPlayer iMediaPlayer) {
            String currentProxySegmentUrl;
            String videoUuidFromVideoUrl;
            if (iMediaPlayer instanceof ISegmentMediaPlayer) {
                currentProxySegmentUrl = ((ISegmentMediaPlayer) iMediaPlayer).getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            } else {
                currentProxySegmentUrl = BaseVideoManager.this.f279607b.A().d().getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            }
            PlayerUtils.log(4, BaseVideoManager.this.f279606a, "onPrepared " + currentProxySegmentUrl);
            ManagerHandler managerHandler = BaseVideoManager.this.f279607b;
            if (managerHandler != null) {
                managerHandler.obtainMessage(38, videoUuidFromVideoUrl).sendToTarget();
            }
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            String currentProxySegmentUrl;
            String videoUuidFromVideoUrl;
            if (iMediaPlayer instanceof ISegmentMediaPlayer) {
                currentProxySegmentUrl = ((ISegmentMediaPlayer) iMediaPlayer).getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            } else {
                currentProxySegmentUrl = BaseVideoManager.this.f279607b.A().d().getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            }
            PlayerUtils.log(4, BaseVideoManager.this.f279606a, "onPrepared " + currentProxySegmentUrl);
            ManagerHandler managerHandler = BaseVideoManager.this.f279607b;
            if (managerHandler != null) {
                managerHandler.obtainMessage(34, videoUuidFromVideoUrl).sendToTarget();
            }
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            String currentProxySegmentUrl;
            String videoUuidFromVideoUrl;
            if (iMediaPlayer instanceof ISegmentMediaPlayer) {
                currentProxySegmentUrl = ((ISegmentMediaPlayer) iMediaPlayer).getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            } else {
                currentProxySegmentUrl = BaseVideoManager.this.f279607b.A().d().getCurrentProxySegmentUrl();
                videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
            }
            PlayerUtils.log(4, BaseVideoManager.this.f279606a, "onSeekComplete " + currentProxySegmentUrl);
            ManagerHandler managerHandler = BaseVideoManager.this.f279607b;
            if (managerHandler != null) {
                managerHandler.obtainMessage(33, videoUuidFromVideoUrl).sendToTarget();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements Callable<Integer> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() throws Exception {
            try {
                return Integer.valueOf((int) BaseVideoManager.this.f279607b.A().d().getCurrentPosition());
            } catch (IllegalStateException | NullPointerException unused) {
                return 0;
            }
        }
    }

    BaseVideoManager(String str) {
        this.f279610e = -2L;
        this.f279606a = "BaseVideoManager@" + str + "@" + f279605q.incrementAndGet();
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc != null) {
            feedVideoExternalFunc.getVideoLoader().initEnv();
            FeedVideoEnv.externalFunc.initAutoVideoSetting(FeedVideoEnv.getApplicationContext());
            HandlerThread realTimeThread = FeedVideoEnv.externalFunc.getRealTimeThread();
            ManagerHandler managerHandler = new ManagerHandler(realTimeThread.getLooper(), this.f279606a, realTimeThread, new b());
            this.f279607b = managerHandler;
            managerHandler.obtainMessage(5).sendToTarget();
            PlayerConfig.g().registerCallback(this.f279613h);
            SharedPreferences sharedPreferences = PlayerConfig.g().getAppContext().getSharedPreferences("BaseVideoManager.pref_name_video_hide_play_tip_stamp", 0);
            this.f279609d = sharedPreferences;
            this.f279610e = sharedPreferences.getLong("BaseVideoManager.key_current_store_stamp", -1L);
            d();
            p();
            return;
        }
        throw new IllegalStateException("FeedVideoEnv.externalFunc is null! pid=" + Process.myPid());
    }

    private void G(BaseVideoCover.CoverWarnType coverWarnType) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(26, coverWarnType).sendToTarget();
        }
    }

    private void H(BaseVideoCover.CoverWarnType coverWarnType, long j3) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.removeMessages(26);
            this.f279607b.sendMessageDelayed(this.f279607b.obtainMessage(26, coverWarnType), j3);
        }
    }

    private void d() {
        if (this.f279610e == -2) {
            this.f279610e = this.f279609d.getLong("BaseVideoManager.key_current_store_stamp", -1L);
        }
        if (this.f279610e > 0) {
            int wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoNetworkTipsInVisibleTime", 43200000);
            long currentTimeMillis = System.currentTimeMillis() - this.f279610e;
            if (currentTimeMillis > 0 && currentTimeMillis < wnsConfig) {
                setIsNeedPlayTip(false);
            } else {
                setIsNeedPlayTip(true);
            }
        }
    }

    private boolean e() {
        BaseVideo a16 = this.f279607b.f279829b.a();
        if (this.f279607b.f279829b == null || a16 == null || !a16.needShowLightTip()) {
            return false;
        }
        if (a16.hasShowLightTip) {
            return true;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.2
            @Override // java.lang.Runnable
            public void run() {
                BaseVideo a17 = BaseVideoManager.this.f279607b.f279829b.a();
                if (a17 != null) {
                    a17.showLightTipTimeText();
                }
            }
        });
        return true;
    }

    public static BaseVideoManager getFeedVideoManager() {
        if (f279597i == null) {
            synchronized (BaseVideoManager.class) {
                if (f279597i == null) {
                    f279597i = new BaseVideoManager("FeedVideoManager");
                }
            }
        }
        return f279597i;
    }

    private void o() {
        String wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreloadPercent", "25|50");
        String wnsConfig2 = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreloadBuffer", "8|5");
        if (TextUtils.isEmpty(wnsConfig) || TextUtils.isEmpty(wnsConfig2)) {
            return;
        }
        String[] split = wnsConfig.split("\\|");
        String[] split2 = wnsConfig2.split("\\|");
        if (split.length <= 0 || split.length != split2.length) {
            return;
        }
        for (int i3 = 0; i3 < split.length; i3++) {
            f279601m.add(i3, Double.valueOf(split[i3]));
            f279602n.add(i3, Double.valueOf(Double.valueOf(split2[i3]).doubleValue() * 1000.0d));
        }
    }

    private void p() {
        q();
        o();
    }

    private void q() {
        String[] split;
        String wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreloadDuration", "7|5|3");
        int i3 = 7000;
        int i16 = 5000;
        int i17 = 3000;
        if (!TextUtils.isEmpty(wnsConfig) && (split = wnsConfig.split("\\|")) != null && split.length >= 3) {
            try {
                int intValue = Integer.valueOf(split[0]).intValue() * 1000;
                int intValue2 = Integer.valueOf(split[1]).intValue() * 1000;
                i17 = Integer.valueOf(split[2]).intValue() * 1000;
                i3 = intValue;
                i16 = intValue2;
            } catch (Exception unused) {
                PlayerUtils.log(4, this.f279606a, "initPreloadDurationConfig error");
            }
        }
        f279600l.put(0, Integer.valueOf(i3));
        f279600l.put(1, Integer.valueOf(i16));
        f279600l.put(2, Integer.valueOf(i17));
        f279604p = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreladShortDuration", 10000);
    }

    public static boolean t(BaseVideo baseVideo) {
        if (z(baseVideo)) {
            int[] iArr = new int[2];
            baseVideo.getLocationOnScreen(iArr);
            return iArr[1] + (baseVideo.getMeasuredHeight() / 2) >= FeedVideoEnv.DEFAULT_TITLEBAR_HEIGHT;
        }
        return y(baseVideo);
    }

    private boolean w(int i3) {
        return !FeedVideoEnv.isModelInHLSBlackList(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(BaseVideo baseVideo) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler == null || !managerHandler.Z0(baseVideo)) {
            return;
        }
        PlayerUtils.log(4, this.f279606a, this + " notifySurfaceDestroy " + baseVideo);
        this.f279607b.obtainMessage(3, baseVideo).sendToTarget();
    }

    public void E(long j3) {
        CachedMediaPlayer A = this.f279607b.A();
        if (A != null && A.d() != null) {
            if (!A.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_PAUSE)) {
                PlayerUtils.log(5, this.f279606a, "not pauseable 1");
                return;
            }
            ManagerHandler managerHandler = this.f279607b;
            if (managerHandler != null) {
                managerHandler.removeMessages(22);
                if (j3 > 0) {
                    this.f279607b.sendEmptyMessageDelayed(22, j3);
                    return;
                } else {
                    this.f279607b.obtainMessage(22).sendToTarget();
                    return;
                }
            }
            return;
        }
        PlayerUtils.log(5, this.f279606a, "not pauseable 0");
    }

    public void F() {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.removeMessages(20);
            ManagerHandler managerHandler2 = this.f279607b;
            managerHandler2.sendMessageDelayed(managerHandler2.obtainMessage(20), 200L);
        }
    }

    public void I(float f16) {
        PlayerUtils.log(4, this.f279606a, "setPlayRate rate=" + f16);
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(27, Float.valueOf(f16)).sendToTarget();
        }
    }

    public void J(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "stop".equalsIgnoreCase(str2) || "pause".equalsIgnoreCase(str2) || "resume".equalsIgnoreCase(str2) || "buffer".equalsIgnoreCase(str2)) {
            return;
        }
        "error".equalsIgnoreCase(str2);
    }

    public void b(BaseVideo baseVideo) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(61, baseVideo).sendToTarget();
        }
    }

    public void enableAutoVideoSound() {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(24, 2, 0).sendToTarget();
            return;
        }
        PlayerUtils.log(4, this.f279606a, this + " enableAutoVideoSound manager handler should not null.");
    }

    public void f() {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(24, 3, 0).sendToTarget();
            return;
        }
        PlayerUtils.log(4, this.f279606a, this + " disableAutoVideoSound manager handler should not null.");
    }

    public void g() {
        this.f279607b.removeMessages(82);
        this.f279607b.sendEmptyMessageDelayed(82, FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoNetworkTipsInVisibleTime", 43200000));
    }

    public String i() {
        CachedMediaPlayer A = this.f279607b.A();
        if (A == null || A.d() == null) {
            return null;
        }
        return A.d().getCurrentProxySegmentUrl();
    }

    public boolean isCurSoundOpened() {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            return managerHandler.X0();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        e eVar;
        BaseVideo a16;
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler == null || (eVar = managerHandler.f279829b) == null || (a16 = eVar.a()) == null || a16.getVideoPlayInfo() == null || a16.getVideoPlayInfo().segmentVideoInfo == null) {
            return null;
        }
        return a16.getVideoPlayInfo().segmentVideoInfo.getDefaultUrl();
    }

    public String k() {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            return managerHandler.v();
        }
        return null;
    }

    public SharedPreferences l() {
        return this.f279609d;
    }

    public long m(String str) {
        VideoPlayInfoHolder videoProgressRecord;
        if (TextUtils.isEmpty(str) || (videoProgressRecord = AutoVideoProgressRecorder.getInstance().getVideoProgressRecord(str)) == null) {
            return 0L;
        }
        return videoProgressRecord.currentPositionMills;
    }

    public BaseVideoManagerUtils.ChangeSurfaceResult n(BaseVideoManagerUtils.ChangeSurfaceHolder changeSurfaceHolder, int i3, int i16) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler == null) {
            PlayerUtils.log(6, this.f279606a, "handleSwitchSurface mManagerHandler is null");
            return changeSurfaceHolder.changeSurfaceResult;
        }
        if (managerHandler.A() != null) {
            if (changeSurfaceHolder.oldSurface == null) {
                return changeSurfaceHolder.changeSurfaceResult;
            }
            if (changeSurfaceHolder.newSurface.getState() != 3) {
                changeSurfaceHolder.newSurface.updateWithoutDelay(false);
                this.f279607b.removeMessages(81);
                this.f279607b.sendEmptyMessageDelayed(81, 3000L);
            }
            this.f279607b.removeMessages(60);
            if (i16 > 0) {
                ManagerHandler managerHandler2 = this.f279607b;
                managerHandler2.sendMessageDelayed(managerHandler2.obtainMessage(60, i3, 0, changeSurfaceHolder), i16);
            } else {
                ManagerHandler managerHandler3 = this.f279607b;
                managerHandler3.sendMessage(managerHandler3.obtainMessage(60, i3, 0, changeSurfaceHolder));
            }
            BaseVideoManagerUtils.ChangeSurfaceResult changeSurfaceResult = changeSurfaceHolder.changeSurfaceResult;
            changeSurfaceResult.willChangeSurfaceHappen = true;
            return changeSurfaceResult;
        }
        PlayerUtils.log(4, this.f279606a, "handleSwitchSurface mPlayer is null");
        return changeSurfaceHolder.changeSurfaceResult;
    }

    public void notifyVideoPlayInfoUpdate() {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.removeMessages(42);
            this.f279607b.obtainMessage(42, null).sendToTarget();
        }
    }

    public void onListIdleSingleVideo(List<? extends BaseVideo> list) {
        onListIdleSingleVideo(list, false);
    }

    public void onNetworkChange(boolean z16) {
        ManagerHandler managerHandler;
        ManagerHandler managerHandler2;
        ManagerHandler managerHandler3;
        ManagerHandler managerHandler4;
        PlayerUtils.log(4, this.f279606a, "onNetworkChange isConnected:" + z16);
        if (z16 && FeedVideoEnv.isWifiConnected()) {
            com.tencent.mobileqq.qzoneplayer.videosource.b.b().e(true);
        } else {
            com.tencent.mobileqq.qzoneplayer.videosource.b.b().e(false);
        }
        PlayerConfig.g().setIPStackType(FeedVideoEnv.externalFunc.getIPStackType());
        s.g().l(z16);
        ManagerHandler managerHandler5 = this.f279607b;
        if (managerHandler5 != null && managerHandler5.k1()) {
            if (z16 && FeedVideoEnv.isWifiConnected()) {
                F();
                return;
            } else {
                if (z16 && FeedVideoEnv.isMobileConnected()) {
                    pauseVideo();
                    return;
                }
                return;
            }
        }
        if (z16 && FeedVideoEnv.isWifiConnected()) {
            ManagerHandler managerHandler6 = this.f279607b;
            if (managerHandler6 != null) {
                managerHandler6.removeMessages(80);
                G(BaseVideoCover.CoverWarnType.DEFAULT);
            }
            this.f279608c = 2;
            return;
        }
        if (!z16 && !FeedVideoEnv.isMobileConnected()) {
            if (this.f279607b.a1() && (managerHandler4 = this.f279607b) != null && managerHandler4.N() == 1) {
                this.f279608c = 1;
                if (e()) {
                    return;
                }
                if (FeedVideoEnv.externalFunc.getRunningEnv() != FeedVideoEnv.RunningEnv.DULI) {
                    pauseVideo();
                    G(BaseVideoCover.CoverWarnType.NETWORK_DISCONNECT);
                    return;
                } else {
                    long wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoNetworkTipsDelayPauseVideo", 3000);
                    E(wnsConfig);
                    H(BaseVideoCover.CoverWarnType.NETWORK_DISCONNECT, wnsConfig);
                    return;
                }
            }
            return;
        }
        if (this.f279607b.a1() && (managerHandler2 = this.f279607b) != null && managerHandler2.N() == 1) {
            if (this.f279608c == 1 && (managerHandler3 = this.f279607b) != null) {
                managerHandler3.removeMessages(22);
            }
            this.f279608c = 3;
            if (e()) {
                return;
            }
            this.f279607b.removeMessages(80);
            this.f279607b.sendEmptyMessageDelayed(80, FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoNetworkTipsDelayShowTime", 5000));
            return;
        }
        if (this.f279607b.a1() && (managerHandler = this.f279607b) != null && managerHandler.N() == 3) {
            if (this.f279608c == 1) {
                F();
            }
            this.f279608c = 3;
            if (e()) {
                return;
            }
            this.f279607b.removeMessages(80);
            this.f279607b.sendEmptyMessageDelayed(80, FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoNetworkTipsDelayShowTime", 5000));
        }
    }

    public void progressBarSeekingBegin() {
        CachedMediaPlayer A = this.f279607b.A();
        if (PlayerConfig.g().getVideoReporter() != null) {
            if (A != null && A.d() != null) {
                PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(PlayerUtils.getVideoUuidFromVideoUrl(A.d().getCurrentProxySegmentUrl()), A.d().getCurrentPosition(), A.d().isPlaying());
            } else {
                PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(null, -1L, false);
            }
        }
    }

    public void progressBarSeekingEnd(float f16, float f17) {
        CachedMediaPlayer A = this.f279607b.A();
        if (A == null || A.d() == null || PlayerConfig.g().getVideoReporter() == null || f17 <= 0.0f) {
            return;
        }
        PlayerConfig.g().getVideoReporter().progressBarSeekingEnd(PlayerUtils.getVideoUuidFromVideoUrl(A.d().getCurrentSegmentUrl()), (((float) A.d().getDuration()) * f16) / f17);
    }

    public boolean r() {
        ManagerHandler managerHandler = this.f279607b;
        return managerHandler != null && managerHandler.N() == 1;
    }

    public void removeVideoView(BaseVideo baseVideo) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler == null || !managerHandler.Z0(baseVideo)) {
            return;
        }
        PlayerUtils.log(4, this.f279606a, this + " removeVideoView " + baseVideo);
        this.f279607b.R1("removeVideoView", null);
        this.f279607b.obtainMessage(1, baseVideo).sendToTarget();
    }

    public void schedulePreload(VideoPlayInfo videoPlayInfo) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(102, videoPlayInfo).sendToTarget();
        }
    }

    @Deprecated
    public void seekVideoReal(int i3) {
        PlayerUtils.log(4, this.f279606a, "seekVideoReal pos=" + i3);
        CachedMediaPlayer A = this.f279607b.A();
        if (A != null && !A.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SEEKTO)) {
            PlayerUtils.log(5, this.f279606a, "not seekable");
            return;
        }
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(25, i3, 0).sendToTarget();
        }
    }

    public void seekVideoRealManual(int i3) {
        this.f279607b.removeMessages(50);
        seekVideoReal(i3);
    }

    public void setIsNeedPlayTip(boolean z16) {
        this.f279607b.M1(z16);
    }

    public void setLooping(boolean z16) {
        PlayerUtils.log(4, this.f279606a, "setLooping isLooping=" + z16);
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(28, Boolean.valueOf(z16)).sendToTarget();
        }
    }

    public void setVerticalCustomeClickWhen4G(boolean z16) {
        ManagerHandler.S = z16;
    }

    public void setVideoPlayInfoListener(VideoPlayInfoListener videoPlayInfoListener) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.N1(videoPlayInfoListener);
        }
    }

    public void startVideoReal() {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.obtainMessage(23).sendToTarget();
        }
    }

    @Deprecated
    public void stopVideo(BaseVideo baseVideo) {
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.R1("stopVideo", null);
            this.f279607b.obtainMessage(15, baseVideo).sendToTarget();
        }
    }

    public String toString() {
        return super.toString() + "@" + this.f279606a;
    }

    public boolean u(BaseVideo baseVideo) {
        ManagerHandler managerHandler = this.f279607b;
        return managerHandler != null && managerHandler.Z0(baseVideo);
    }

    public Object getDuration() {
        try {
            CachedMediaPlayer A = this.f279607b.A();
            if (A == null || A.d() == null || !A.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETDURATION)) {
                return null;
            }
            return Integer.valueOf((int) A.d().getDuration());
        } catch (Exception unused) {
            return null;
        }
    }

    public Object h() {
        try {
            CachedMediaPlayer A = this.f279607b.A();
            if (A == null || A.d() == null || !A.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPOSITION)) {
                return null;
            }
            if (PlayerUtils.isOnMainThread()) {
                FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
                if (feedVideoExternalFunc != null && feedVideoExternalFunc.isDebugVersion()) {
                    PlayerUtils.log(5, this.f279606a, "call getCurrentPosition on mainthread " + PlayerUtils.getStackTrace());
                }
                try {
                    return ThreadUtils.submitTask(this.f279611f, 100, true, "getCurrentPosition", this.f279606a);
                } catch (OutOfMemoryError unused) {
                    return null;
                }
            }
            return Integer.valueOf((int) A.d().getCurrentPosition());
        } catch (Exception unused2) {
            return null;
        }
    }

    public void onListIdleSingleVideo(List<? extends BaseVideo> list, boolean z16) {
        ManagerHandler managerHandler;
        if (list == null) {
            return;
        }
        VideoSpeedReport.g().reportStart();
        VideoSpeedReport.ReportType.removeVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY);
        VideoSpeedReport.ReportPoint reportPoint = VideoSpeedReport.POINT_VIDEO_LIST_IDLE;
        VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint);
        VideoSpeedReport.g().start(reportPoint);
        VideoSpeedReport.ReportPoint reportPoint2 = VideoSpeedReport.POINT_VIDEO_VISIBLE;
        VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint2);
        VideoSpeedReport.g().start(reportPoint2);
        if (belowICE_CREAM || FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED || (managerHandler = this.f279607b) == null) {
            return;
        }
        d J = managerHandler.J(list, z16);
        if (J.c()) {
            PlayerUtils.log(5, this.f279606a, "play aborted");
        } else {
            if (!c(J.f279980b)) {
                PlayerUtils.log(5, this.f279606a, "play aborted Hls Support problem");
                return;
            }
            this.f279607b.R1("onListIdleSingleVideo", J.f279980b);
            this.f279607b.removeMessages(10);
            this.f279607b.obtainMessage(10, J.f279980b).sendToTarget();
        }
    }

    public static boolean A(BaseVideo baseVideo) {
        return baseVideo != null && baseVideo.isPartlyOnScreen();
    }

    public static boolean y(BaseVideo baseVideo) {
        return baseVideo != null && baseVideo.isAllOnScreen();
    }

    public void pauseVideo() {
        E(0L);
    }

    private boolean s(BaseVideo baseVideo) {
        SegmentVideoInfo.StreamInfo streamInfo;
        return (baseVideo == null || baseVideo.getVideoPlayInfo() == null || baseVideo.getVideoPlayInfo().segmentVideoInfo == null || (streamInfo = baseVideo.getVideoPlayInfo().segmentVideoInfo.getStreamInfo(0)) == null || !PlayerUtils.isHLSStream(streamInfo.getSegment(0).url)) ? false : true;
    }

    private boolean x(BaseVideo baseVideo) {
        SegmentVideoInfo.StreamInfo streamInfo;
        if (baseVideo == null || baseVideo.getVideoPlayInfo() == null || baseVideo.getVideoPlayInfo().segmentVideoInfo == null || (streamInfo = baseVideo.getVideoPlayInfo().segmentVideoInfo.getStreamInfo(0)) == null || !PlayerUtils.isHLSStream(streamInfo.getSegment(0).url)) {
            return false;
        }
        return w(streamInfo.isHLSLive ? 1 : 2);
    }

    public void C(BaseVideo baseVideo) {
        ManagerHandler managerHandler;
        if (baseVideo == null) {
            return;
        }
        VideoSpeedReport.g().reportStart();
        VideoSpeedReport.ReportType.removeVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY);
        VideoSpeedReport.ReportPoint reportPoint = VideoSpeedReport.POINT_VIDEO_LIST_IDLE;
        VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint);
        VideoSpeedReport.g().start(reportPoint);
        VideoSpeedReport.ReportPoint reportPoint2 = VideoSpeedReport.POINT_VIDEO_VISIBLE;
        VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint2);
        VideoSpeedReport.g().start(reportPoint2);
        if (belowICE_CREAM || FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED || (managerHandler = this.f279607b) == null) {
            return;
        }
        d H = managerHandler.H(baseVideo);
        if (!H.c() && c(H.f279980b)) {
            this.f279607b.R1("onFullScreenIdle", H.f279980b);
            this.f279607b.removeMessages(10);
            this.f279607b.obtainMessage(10, H.f279980b).sendToTarget();
        }
    }

    public void D(List<? extends BaseVideo> list) {
        ManagerHandler managerHandler;
        if (list == null) {
            return;
        }
        VideoSpeedReport.g().reportStart();
        VideoSpeedReport.ReportType.removeVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY);
        VideoSpeedReport.ReportPoint reportPoint = VideoSpeedReport.POINT_VIDEO_LIST_IDLE;
        VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint);
        VideoSpeedReport.g().start(reportPoint);
        VideoSpeedReport.ReportPoint reportPoint2 = VideoSpeedReport.POINT_VIDEO_VISIBLE;
        VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint2);
        VideoSpeedReport.g().start(reportPoint2);
        if (belowICE_CREAM || FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED || (managerHandler = this.f279607b) == null) {
            return;
        }
        d I = managerHandler.I(list);
        if (!I.c() && c(I.f279980b)) {
            if (I.f279980b == null && TextUtils.equals(k(), "BannerAutoVideoView")) {
                return;
            }
            this.f279607b.R1("onListIdle", I.f279980b);
            this.f279607b.removeMessages(10);
            this.f279607b.obtainMessage(10, I.f279980b).sendToTarget();
        }
    }

    @Deprecated
    public void startVideo(BaseVideo baseVideo) {
        if (baseVideo == null) {
            return;
        }
        if (!baseVideo.isHardwareAccelerated()) {
            PlayerUtils.log(5, this.f279606a, "startVideo videoNeedPlay " + baseVideo + " is hardware accelerated? " + baseVideo.isHardwareAccelerated());
            return;
        }
        PlayerUtils.log(4, this.f279606a, "startVideo");
        baseVideo.startLayout();
        ManagerHandler managerHandler = this.f279607b;
        if (managerHandler != null) {
            managerHandler.R1("startVideo", baseVideo);
            if (!c(baseVideo)) {
                return;
            }
            this.f279607b.removeMessages(14);
            this.f279607b.obtainMessage(14, baseVideo).sendToTarget();
        } else {
            PlayerUtils.log(6, this.f279606a, "startVideo mManagerHandler == null !");
        }
        if (baseVideo.getVideoPlayInfo() == null || !FeedVideoEnv.externalFunc.isFreeTraffic() || FeedVideoEnv.isWifiConnected()) {
            return;
        }
        if (baseVideo.getVideoPlayInfo().isLiveVideo) {
            FeedVideoEnv.externalFunc.reportToLp00064(LpReportInfoConfig.ACTION_TYPE_DAWANG, 2, 1);
        } else {
            FeedVideoEnv.externalFunc.reportToLp00064(LpReportInfoConfig.ACTION_TYPE_DAWANG, 2, 2);
        }
    }

    public void switchVideoStream(BaseVideo baseVideo, int i3) {
        VideoPlayInfo videoPlayInfo;
        SegmentVideoInfo segmentVideoInfo;
        ManagerHandler managerHandler;
        if (baseVideo == null || (videoPlayInfo = baseVideo.getVideoPlayInfo()) == null || (segmentVideoInfo = videoPlayInfo.segmentVideoInfo) == null) {
            return;
        }
        segmentVideoInfo.setCurrentStreamType(i3);
        SegmentVideoInfo.StreamInfo streamInfo = videoPlayInfo.segmentVideoInfo.getStreamInfo(i3);
        if (streamInfo == null || (managerHandler = this.f279607b) == null) {
            return;
        }
        managerHandler.R1("switchVideoStream", null);
        this.f279607b.removeMessages(21);
        this.f279607b.obtainMessage(21, streamInfo).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(BaseVideo baseVideo) {
        ManagerHandler managerHandler;
        e eVar;
        WeakReference<BaseVideo> weakReference;
        return (baseVideo == null || (managerHandler = this.f279607b) == null || (eVar = managerHandler.f279829b) == null || (weakReference = eVar.f279983c) == null || weakReference.get() == null || weakReference.get() != baseVideo) ? false : true;
    }

    private boolean c(BaseVideo baseVideo) {
        if (baseVideo == null || !s(baseVideo) || x(baseVideo)) {
            return true;
        }
        PlayerUtils.log(5, this.f279606a, "hls playback is not supported");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean z(BaseVideo baseVideo) {
        if (baseVideo == null) {
            return false;
        }
        return baseVideo instanceof CoverAutoVideo;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends PlayerCallBack {
        a() {
        }

        @Override // com.tencent.oskplayer.model.PlayerCallBack
        public void onMediaEvent(PlayerCallBack playerCallBack, int i3, String str, VideoInfo videoInfo) {
            if (playerCallBack != BaseVideoManager.this.f279613h) {
                return;
            }
            if (i3 == PlayerCallBack.EVENT_PLAY_ERROR) {
                if (!PlayerUtils.isNetworkAvailable()) {
                    FeedVideoEnv.externalFunc.showToast("\u89c6\u9891\u64ad\u653e\u5931\u8d25\uff0c\u7f51\u7edc\u65e0\u8fde\u63a5");
                    return;
                } else {
                    if (str.contains("MEDIA_ERROR_MALFORMED")) {
                        FeedVideoEnv.externalFunc.showToast("\u62b1\u6b49\uff0c\u89c6\u9891\u64ad\u653e\u65f6\u53d1\u751f\u9519\u8bef");
                        return;
                    }
                    return;
                }
            }
            if (i3 == PlayerCallBack.EVENT_PLAY_PREPARE_TIMEOUT) {
                if (!PlayerUtils.isNetworkAvailable()) {
                    FeedVideoEnv.externalFunc.showToast("\u89c6\u9891\u64ad\u653e\u5931\u8d25\uff0c\u7f51\u7edc\u65e0\u8fde\u63a5");
                } else {
                    FeedVideoEnv.externalFunc.showToast("\u52a0\u8f7d\u89c6\u9891\u8d85\u65f6");
                }
            }
        }

        @Override // com.tencent.oskplayer.model.PlayerCallBack
        public void onCacheRead(PlayerCallBack playerCallBack, long j3, long j16) {
        }

        @Override // com.tencent.oskplayer.model.PlayerCallBack
        public void onHttpDownloadError(PlayerCallBack playerCallBack, String str, String str2, int i3, String str3, Map<String, List<String>> map, int i16, long j3, long j16) {
        }
    }
}
