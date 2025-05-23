package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qzoneplayer.player.CachedMediaPlayer;
import com.tencent.mobileqq.qzoneplayer.player.SimpleMediaPlayerCache;
import com.tencent.mobileqq.qzoneplayer.report.VideoReporter;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManagerUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.PlayerCallBack;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.model.VideoDecoderType;
import com.tencent.oskplayer.player.FFSegmentMediaPlayer;
import com.tencent.oskplayer.player.GLTextureMediaPlayer;
import com.tencent.oskplayer.player.IExo2MediaPlayer;
import com.tencent.oskplayer.player.ISegmentMediaPlayer;
import com.tencent.oskplayer.player.StateMediaPlayer;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.proxy.VideoRequestManager;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.report.VideoResultCode;
import com.tencent.oskplayer.service.DNSService;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.ThreadUtils;
import com.tencent.oskplayer.util.VideoSpeedReport;
import com.tencent.oskplayer.util.VideoUrlValidator;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;
import zl2.b;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ManagerHandler extends Handler {
    public static boolean S = false;
    private static com.tencent.mobileqq.qzoneplayer.video.j T = new com.tencent.mobileqq.qzoneplayer.video.j();
    private static String U = "@lovelybone";
    private volatile boolean A;
    private BaseVideoManager.b B;
    private boolean C;
    private VideoUrlValidator D;
    zl2.a E;
    private int F;
    private Pair<String, Boolean> G;
    private volatile boolean H;
    CachedMediaPlayer I;
    Map<String, String> J;
    private boolean K;
    private Object L;
    m M;
    private String N;
    private boolean O;
    private int P;
    private int Q;
    private BaseVideoManager.VideoPlayInfoListener R;

    /* renamed from: a, reason: collision with root package name */
    private String f279828a;

    /* renamed from: b, reason: collision with root package name */
    final com.tencent.mobileqq.qzoneplayer.video.e f279829b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.qzoneplayer.player.b f279830c;

    /* renamed from: d, reason: collision with root package name */
    private int f279831d;

    /* renamed from: e, reason: collision with root package name */
    private int f279832e;

    /* renamed from: f, reason: collision with root package name */
    private int f279833f;

    /* renamed from: g, reason: collision with root package name */
    private int f279834g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<VideoPlayInfo> f279835h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f279836i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f279837j;

    /* renamed from: k, reason: collision with root package name */
    private String f279838k;

    /* renamed from: l, reason: collision with root package name */
    private int f279839l;

    /* renamed from: m, reason: collision with root package name */
    private int f279840m;

    /* renamed from: n, reason: collision with root package name */
    private int f279841n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f279842o;

    /* renamed from: p, reason: collision with root package name */
    private int f279843p;

    /* renamed from: q, reason: collision with root package name */
    private long f279844q;

    /* renamed from: r, reason: collision with root package name */
    private int f279845r;

    /* renamed from: s, reason: collision with root package name */
    private int f279846s;

    /* renamed from: t, reason: collision with root package name */
    private int f279847t;

    /* renamed from: u, reason: collision with root package name */
    private WeakReference<BaseVideoManager.VideoPlayInfoListener> f279848u;

    /* renamed from: v, reason: collision with root package name */
    private String f279849v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f279850w;

    /* renamed from: x, reason: collision with root package name */
    private String f279851x;

    /* renamed from: y, reason: collision with root package name */
    private HandlerThread f279852y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f279853z;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler$4, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f279862d;
        final /* synthetic */ ManagerHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (FFSegmentMediaPlayer.isSupported()) {
                FFSegmentMediaPlayer fFSegmentMediaPlayer = new FFSegmentMediaPlayer();
                int score = fFSegmentMediaPlayer.getScore();
                if (PlayerConfig.g().getVideoReporter() != null) {
                    PlayerConfig.g().getVideoReporter().reportVideoDecodeScore(score);
                    PreferenceManager.getDefaultGlobalPreference(PlayerConfig.g().getAppContext()).edit().putInt("h265_decode_score_reported_" + this.f279862d, 1).commit();
                }
                fFSegmentMediaPlayer.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements IMediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseVideo f279869d;

        a(BaseVideo baseVideo) {
            this.f279869d = baseVideo;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i3, int i16) {
            this.f279869d.onVideoSizeChanged(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Exception f279871a;

        b(Exception exc) {
            this.f279871a = exc;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.k
        public void a() {
            if (FeedVideoEnv.externalFunc.isDebugVersion()) {
                FeedVideoEnv.externalFunc.showToast("\u62b1\u6b49\uff0c\u89c6\u9891\u64ad\u653e\u51fa\u9519\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5" + this.f279871a);
            }
            com.tencent.mobileqq.qzoneplayer.video.e eVar = ManagerHandler.this.f279829b;
            eVar.f279988h = false;
            eVar.f279986f = 0;
            eVar.d(null);
            ManagerHandler.this.f279829b.f279992l = true;
            PlayerUtils.log(6, ManagerHandler.this.f279828a + ManagerHandler.U, "hasStarted=false pos 4,mPlayingVideo==null,positon:4");
            if (PlayerConfig.g().getVideoReporter() != null) {
                int i3 = this.f279871a instanceof UnsupportedOperationException ? VideoResultCode.ERROR_PLAY_START_UNSUPPORTED_DATASOURCE : VideoResultCode.ERROR_PLAY_START_IO_EXCEPTION_BASE;
                IVideoReporter videoReporter = PlayerConfig.g().getVideoReporter();
                String str = ManagerHandler.this.f279829b.f279985e;
                ManagerHandler managerHandler = ManagerHandler.this;
                videoReporter.failPlayVideo(str, i3, 0L, managerHandler.f279829b.f279994n, managerHandler.C());
            }
            VideoRequestManager L = ManagerHandler.this.L();
            if (L != null) {
                L.cancelVideoRequestByUuid(ManagerHandler.this.f279829b.f279985e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements k {
        c() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.k
        public void a() {
            ManagerHandler.this.m1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class d implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SegmentVideoInfo.StreamInfo f279874a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseVideo f279875b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f279876c;

        d(SegmentVideoInfo.StreamInfo streamInfo, BaseVideo baseVideo, boolean z16) {
            this.f279874a = streamInfo;
            this.f279875b = baseVideo;
            this.f279876c = z16;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.k
        public void a() {
            ManagerHandler.this.v1(this.f279874a, this.f279875b, this.f279876c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class e implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f279878a;

        e(k kVar) {
            this.f279878a = kVar;
        }

        @Override // zl2.b.a
        public void a(CachedMediaPlayer cachedMediaPlayer) {
            ManagerHandler.this.I = cachedMediaPlayer;
            ISegmentMediaPlayer internalMediaPlayer = (cachedMediaPlayer == null || cachedMediaPlayer.d() == null) ? null : ManagerHandler.this.I.d().getInternalMediaPlayer();
            PlayerUtils.log(4, ManagerHandler.this.f279828a, "[initMediaPlayer] real player=" + internalMediaPlayer);
            com.tencent.mobileqq.qzoneplayer.video.e eVar = ManagerHandler.this.f279829b;
            if (eVar != null && eVar.a() != null) {
                ManagerHandler.this.f279829b.a().hideHudView();
            }
            ManagerHandler.this.removeMessages(150);
            k kVar = this.f279878a;
            if (kVar != null) {
                kVar.a();
            } else {
                PlayerUtils.log(4, ManagerHandler.this.f279828a, "[initMediaPlayer] callback == null.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class f implements BaseVideoManager.VideoPlayInfoListener {
        f() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (ManagerHandler.this.f279829b.a() != null && ManagerHandler.this.f279829b.a().getVideoPlayInfoListener() != null) {
                ManagerHandler.this.f279829b.a().getVideoPlayInfoListener().onVideoPlayComplete(videoPlayInfoHolder);
            }
            ManagerHandler.this.J1(true);
            if (ManagerHandler.this.f279848u == null || ManagerHandler.this.f279848u.get() == null) {
                return;
            }
            ((BaseVideoManager.VideoPlayInfoListener) ManagerHandler.this.f279848u.get()).onVideoPlayComplete(videoPlayInfoHolder);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (ManagerHandler.this.f279829b.a() != null && ManagerHandler.this.f279829b.a().getVideoPlayInfoListener() != null) {
                ManagerHandler.this.f279829b.a().getVideoPlayInfoListener().onVideoPlayError(videoPlayInfoHolder);
            }
            ManagerHandler.this.J1(false);
            if (ManagerHandler.this.f279848u == null || ManagerHandler.this.f279848u.get() == null) {
                return;
            }
            ((BaseVideoManager.VideoPlayInfoListener) ManagerHandler.this.f279848u.get()).onVideoPlayError(videoPlayInfoHolder);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (ManagerHandler.this.f279829b.a() != null && ManagerHandler.this.f279829b.a().getVideoPlayInfoListener() != null) {
                ManagerHandler.this.f279829b.a().getVideoPlayInfoListener().onVideoPlayPause(videoPlayInfoHolder);
            }
            if (ManagerHandler.this.f279848u == null || ManagerHandler.this.f279848u.get() == null) {
                return;
            }
            ((BaseVideoManager.VideoPlayInfoListener) ManagerHandler.this.f279848u.get()).onVideoPlayPause(videoPlayInfoHolder);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
            ArrayList<com.tencent.component.utils.Pair<Integer, Integer>> arrayList;
            int intValue;
            long j3 = videoPlayInfoHolder.currentPositionMills;
            videoPlayInfoHolder.currentPositionMillsOrigStream = j3;
            int i3 = 0;
            videoPlayInfoHolder.isLightspot = false;
            if (ManagerHandler.this.f279829b.a() != null && ManagerHandler.this.f279829b.a().getVideoPlayInfo() != null && (arrayList = ManagerHandler.this.f279829b.a().getVideoPlayInfo().lightSpotInfo) != null && arrayList.size() > 0) {
                Iterator<com.tencent.component.utils.Pair<Integer, Integer>> it = arrayList.iterator();
                int i16 = -1;
                int i17 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.component.utils.Pair<Integer, Integer> next = it.next();
                    if (((Integer) next.first).intValue() >= i16 && (intValue = ((Integer) next.second).intValue() - ((Integer) next.first).intValue()) > 0) {
                        i3 += intValue;
                        if (j3 <= i3 * 1000) {
                            videoPlayInfoHolder.isLightspot = true;
                            videoPlayInfoHolder.currentPositionMillsOrigStream = ((((Integer) next.first).intValue() * 1000) + j3) - ((i3 - intValue) * 1000);
                            PlayerUtils.log(3, ManagerHandler.this.f279828a, "lightSpot current in slice " + i17 + ", positionInOrigStream=" + videoPlayInfoHolder.currentPositionMillsOrigStream);
                            break;
                        }
                        i16 = ((Integer) next.second).intValue();
                        i17++;
                    }
                }
            }
            if (ManagerHandler.this.f279829b.a() != null && ManagerHandler.this.f279829b.a().getVideoPlayInfoListener() != null) {
                ManagerHandler.this.f279829b.a().getVideoPlayInfoListener().onVideoPlayProgressUpdate(videoPlayInfoHolder);
            }
            if (ManagerHandler.this.f279848u != null && ManagerHandler.this.f279848u.get() != null) {
                ((BaseVideoManager.VideoPlayInfoListener) ManagerHandler.this.f279848u.get()).onVideoPlayProgressUpdate(videoPlayInfoHolder);
            }
            ManagerHandler.this.J1(true);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (ManagerHandler.this.f279829b.a() != null && ManagerHandler.this.f279829b.a().getVideoPlayInfoListener() != null) {
                ManagerHandler.this.f279829b.a().getVideoPlayInfoListener().onVideoPlayStart(videoPlayInfoHolder);
            }
            ManagerHandler.this.J1(true);
            if (ManagerHandler.this.f279848u == null || ManagerHandler.this.f279848u.get() == null) {
                return;
            }
            ((BaseVideoManager.VideoPlayInfoListener) ManagerHandler.this.f279848u.get()).onVideoPlayStart(videoPlayInfoHolder);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (ManagerHandler.this.f279829b.a() != null && ManagerHandler.this.f279829b.a().getVideoPlayInfoListener() != null) {
                ManagerHandler.this.f279829b.a().getVideoPlayInfoListener().onVideoPlayStop(videoPlayInfoHolder);
            }
            if (ManagerHandler.this.f279848u == null || ManagerHandler.this.f279848u.get() == null) {
                return;
            }
            ((BaseVideoManager.VideoPlayInfoListener) ManagerHandler.this.f279848u.get()).onVideoPlayStop(videoPlayInfoHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f279881a;

        static {
            int[] iArr = new int[CachedMediaPlayer.PrepareState.values().length];
            f279881a = iArr;
            try {
                iArr[CachedMediaPlayer.PrepareState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f279881a[CachedMediaPlayer.PrepareState.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f279881a[CachedMediaPlayer.PrepareState.PREPARED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class h implements IMediaPlayer.OnVideoSizeChangedListener {
        h() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i3, int i16) {
            if (ManagerHandler.this.f279829b.a() != null) {
                ManagerHandler.this.f279829b.a().onVideoSizeChanged(i3, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class j implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseVideo f279884a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f279885b;

        j(BaseVideo baseVideo, String str) {
            this.f279884a = baseVideo;
            this.f279885b = str;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.k
        public void a() {
            Handler handler = this.f279884a.mHandler;
            if (handler != null) {
                handler.obtainMessage(5, null).sendToTarget();
                ManagerHandler.this.R.onVideoPlayStop(ManagerHandler.this.f279829b.f279984d);
            }
            ManagerHandler.this.z1(this.f279885b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface k {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class l implements Callable<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        private final IMediaPlayer f279887d;

        public l(IMediaPlayer iMediaPlayer) {
            this.f279887d = iMediaPlayer;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                this.f279887d.release();
            } catch (NullPointerException unused) {
            } catch (Exception e16) {
                PlayerUtils.log(5, ManagerHandler.this.f279828a, PlayerUtils.getPrintableStackTrace(e16));
                return Boolean.FALSE;
            }
            PlayerUtils.log(4, ManagerHandler.this.f279828a, "media player released success");
            return Boolean.TRUE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class m {

        /* renamed from: a, reason: collision with root package name */
        int f279889a;

        /* renamed from: b, reason: collision with root package name */
        int f279890b;

        /* renamed from: c, reason: collision with root package name */
        public int f279891c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<VideoRequest> f279892d;

        /* renamed from: e, reason: collision with root package name */
        int f279893e = 0;

        /* renamed from: f, reason: collision with root package name */
        int f279894f = 0;

        public m() {
        }

        public void a() {
            this.f279889a = 0;
            this.f279890b = 0;
            this.f279891c = -1;
            ArrayList<VideoRequest> arrayList = this.f279892d;
            if (arrayList == null) {
                this.f279892d = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            String wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayDownloadThreshold", "0,0");
            PlayerUtils.log(4, ManagerHandler.this.f279828a, "updateVideoview threshHoldConfig=" + wnsConfig);
            if (!TextUtils.isEmpty(wnsConfig)) {
                try {
                    String[] split = wnsConfig.split(",");
                    this.f279893e = Integer.valueOf(split[0]).intValue();
                    this.f279894f = Integer.valueOf(split[1]).intValue();
                } catch (Exception e16) {
                    PlayerUtils.log(6, ManagerHandler.this.f279828a, "updateVideoview parse thresholdError " + PlayerUtils.getPrintableStackTrace(e16));
                    this.f279893e = 0;
                    this.f279894f = 0;
                }
            }
            PlayerUtils.log(4, ManagerHandler.this.f279828a, "updateVideoview DownloadSecThreshold=" + this.f279893e + ",upadteVideoView DownloadBytesThreshold=" + this.f279894f);
        }
    }

    public ManagerHandler(Looper looper, String str, HandlerThread handlerThread, BaseVideoManager.b bVar) {
        super(looper);
        this.f279828a = "ManagerHandler";
        this.f279831d = 80;
        this.f279832e = 15;
        this.f279833f = 0;
        this.f279834g = 0;
        this.f279836i = false;
        this.f279837j = false;
        this.f279838k = "1:9";
        this.f279839l = 1048576;
        this.f279840m = 8000;
        this.f279841n = 3;
        this.f279842o = false;
        this.f279843p = 0;
        this.f279844q = 0L;
        this.f279845r = 3000;
        this.f279846s = 5000;
        this.f279847t = 1;
        this.C = true;
        this.D = null;
        this.F = 0;
        this.H = true;
        this.J = new HashMap();
        this.K = true;
        this.L = null;
        this.R = new f();
        this.f279829b = new com.tencent.mobileqq.qzoneplayer.video.e();
        this.f279830c = new SimpleMediaPlayerCache(FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPoolTargetCount", 2));
        this.f279835h = new ArrayList<>();
        this.f279828a = str + "@" + this.f279828a;
        this.f279852y = handlerThread;
        this.B = bVar;
        V0();
        this.f279845r = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "VideoCheckSurfaeAvailableTimeout", 3000);
        this.f279846s = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "minVideoDurationAllowSeek", 5000);
        this.f279847t = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "minVideoErrorRetryCount", 1);
        T0();
        R0();
        W0();
    }

    private void A0() {
        String str;
        PlayerUtils.log(4, this.f279828a, "-------------------- handleShowNetworkTips.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (this.f279829b.a() != null) {
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            if (eVar.f279986f != 1) {
                return;
            }
            eVar.a().getVideoPlayInfo().isNotRecordProgress = false;
            VideoPlayInfoHolder videoPlayInfoHolder = (VideoPlayInfoHolder) this.f279829b.c().second;
            if (videoPlayInfoHolder != null) {
                if (!TextUtils.isEmpty(this.f279829b.a().getRecordVideoId())) {
                    str = this.f279829b.a().getRecordVideoId();
                } else {
                    str = this.f279829b.a().getVideoPlayInfo().videoId;
                }
                if (!this.f279829b.a().getVideoPlayInfo().isNotRecordProgress) {
                    AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(str, videoPlayInfoHolder);
                }
            }
            R1("stopVideo", null);
            obtainMessage(15, this.f279829b.a()).sendToTarget();
            final BaseVideo a16 = this.f279829b.a();
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.18
                @Override // java.lang.Runnable
                public void run() {
                    a16.videoUIPause(BaseVideoCover.CoverWarnType.NETWORK_CHANGE);
                }
            });
        }
    }

    private void A1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        VideoManager.getInstance().removeUuidErrorListener(str);
    }

    private void B0() {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleSimpleStartVideo.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            if (!this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_START)) {
                PlayerUtils.log(5, this.f279828a, "-------------------- handleSimpleStartVideo start video failed");
                return;
            }
            try {
                CachedMediaPlayer cachedMediaPlayer2 = this.I;
                if (cachedMediaPlayer2 != null) {
                    cachedMediaPlayer2.d().start();
                }
                com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
                eVar.f279990j = true;
                eVar.f279986f = 1;
                a(200);
                return;
            } catch (IllegalStateException e16) {
                PlayerUtils.log(6, this.f279828a, "error! startVideoReal:" + PlayerUtils.getPrintableStackTrace(e16));
                return;
            } catch (IMediaPlayer.InternalOperationException e17) {
                PlayerUtils.log(6, this.f279828a, "error! handleSimpleStartVideo:" + PlayerUtils.getPrintableStackTrace(e17));
                return;
            }
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleSimpleStartVideo] mPlayer == null || mPlayer.get() == null.");
    }

    private void C0(BaseVideo baseVideo) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleStartVideo. video=" + PlayerUtils.toString(baseVideo) + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (this.f279829b.a() == baseVideo && this.f279829b.f279986f == 1) {
            PlayerUtils.log(4, this.f279828a, "handleStartVideo. video already playing. video=" + PlayerUtils.toString(baseVideo));
            return;
        }
        if (baseVideo != null && baseVideo.getVideoPlayInfo() == null) {
            PlayerUtils.log(4, this.f279828a, "handleStartVideo. no videoplayinfo");
            return;
        }
        F0(this.f279829b.a(), false, 1, -1);
        this.f279829b.d(baseVideo);
        removeMessages(1);
        if (baseVideo != null) {
            baseVideo.isFirstPlay = baseVideo.getVideoPlayInfo().isFeedFirst;
            baseVideo.isAutoPlay = false;
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            eVar.f279986f = 2;
            eVar.f279988h = false;
            baseVideo.setShowCoverImage(true);
            baseVideo.setState(2);
            baseVideo.startLoadingLight();
            PlayerUtils.log(4, this.f279828a, "startLoadingLight " + baseVideo);
            T1(null);
            if (this.f279829b.a() == null) {
                PlayerUtils.log(6, this.f279828a, "handleStartVideo playing video is null");
                return;
            }
            if (this.f279829b.f279991k == null) {
                PlayerUtils.log(6, this.f279828a, "handleStartVideo mStreamInfo is null");
                return;
            }
            FeedVideoEnv.externalFunc.reportClick("353", "2", null);
            if (this.f279829b.f279991k != null) {
                com.tencent.mobileqq.qzoneplayer.video.c cVar = new com.tencent.mobileqq.qzoneplayer.video.c();
                cVar.f279972a = this.f279829b.f279991k;
                cVar.f279973b = baseVideo;
                cVar.f279977f = true;
                cVar.f279976e = 0;
                sendMessage(obtainMessage(13, cVar));
            }
            H1(baseVideo.getVideoPlayInfo());
            return;
        }
        this.f279829b.f279986f = 0;
    }

    private void C1(BaseVideo baseVideo, boolean z16, boolean z17) {
        long duration;
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            if (baseVideo instanceof FeedAutoVideoFullCanvas) {
                FeedAutoVideoFullCanvas feedAutoVideoFullCanvas = (FeedAutoVideoFullCanvas) baseVideo;
                VideoPlayInfo videoPlayInfo = baseVideo.getVideoPlayInfo();
                if (videoPlayInfo != null) {
                    try {
                        boolean z18 = this.f279829b.f279984d.isNeverPlayed;
                        if (videoPlayInfo.g()) {
                            long j3 = this.f279829b.f279984d.hadPlayedRounds;
                            if (j3 > 1 || (j3 == 1 && !z16)) {
                                z18 = false;
                            }
                        }
                        boolean z19 = z18;
                        boolean z26 = z16 || z17;
                        if (!z16 && !z26) {
                            duration = this.I.d().getCurrentPosition();
                            FeedVideoEnv.externalFunc.reportCanvasVideoPlay(feedAutoVideoFullCanvas.f279707i0, (int) this.f279829b.f279984d.startPlayingPositionMills, (int) duration, z26, z19, videoPlayInfo.isGdtVideoPlaySuccess, o(videoPlayInfo.videoPlayScene), videoPlayInfo.feedReportCookie, baseVideo.feedPosition);
                            return;
                        }
                        duration = this.I.d().getDuration();
                        FeedVideoEnv.externalFunc.reportCanvasVideoPlay(feedAutoVideoFullCanvas.f279707i0, (int) this.f279829b.f279984d.startPlayingPositionMills, (int) duration, z26, z19, videoPlayInfo.isGdtVideoPlaySuccess, o(videoPlayInfo.videoPlayScene), videoPlayInfo.feedReportCookie, baseVideo.feedPosition);
                        return;
                    } catch (IllegalStateException e16) {
                        PlayerUtils.log(2, this.f279828a + U, "report canvas adv report  getCurrentPosition 2 " + e16.toString());
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[reportCanvasAdvPlay] mPlayer == null || mPlayer.get() == null.");
    }

    private SegmentVideoInfo.StreamInfo D(VideoPlayInfo videoPlayInfo) {
        SegmentVideoInfo.StreamInfo streamInfo;
        if (videoPlayInfo.orgwebsite == 1) {
            String defaultUrl = videoPlayInfo.segmentVideoInfo.getDefaultUrl();
            PlayerUtils.log(4, this.f279828a, "mpCache handlePreloadNextVideo: getSafeUrl oldUrl=" + defaultUrl);
            PlayerUtils.log(4, this.f279828a, "NoLock getSafeUrlOriginUrl=" + defaultUrl);
            com.tencent.mobileqq.qzoneplayer.video.l h16 = s.g().h(defaultUrl, false);
            if (h16 == null || h16.f280001a != SafeUrlState.URL_STATE_SUCCESS) {
                return null;
            }
            streamInfo = new SegmentVideoInfo.StreamInfo();
            streamInfo.streamType = 0;
            streamInfo.segmentInfos = h16.f280002b;
            streamInfo.mSafeUrlKey = h16.f280008h;
            PlayerUtils.log(4, this.f279828a, "mpCache handlePreloadNextVideo: mSafeUrlKey=" + streamInfo.mSafeUrlKey + ",\n streamInfo.segmentInfos=" + streamInfo);
        } else {
            streamInfo = null;
        }
        if (streamInfo != null) {
            return streamInfo;
        }
        if (videoPlayInfo.segmentVideoInfo == null) {
            return null;
        }
        SegmentVideoInfo.StreamInfo d16 = yl2.c.e().g(FeedVideoEnv.getNetworkType()).d(videoPlayInfo.segmentVideoInfo);
        return d16 != null ? d16 : videoPlayInfo.segmentVideoInfo.getStreamInfo(0);
    }

    private void D0() {
        PlayerUtils.log(4, this.f279828a, "handleStopTimer");
        if (this.f279829b.a() != null && this.f279829b.a().mHandler != null) {
            this.f279829b.a().mHandler.obtainMessage(4, null).sendToTarget();
        }
        removeMessages(40);
    }

    private void D1() {
        String str;
        String str2;
        try {
            String currentSegmentUrl = this.I.d().getCurrentSegmentUrl();
            long cachedBytesFromStart = VideoManager.getInstance().getCachedBytesFromStart(currentSegmentUrl);
            boolean z16 = cachedBytesFromStart > 0;
            String currentProxySegmentUrl = this.I.d().getCurrentProxySegmentUrl();
            if (currentProxySegmentUrl != null && currentSegmentUrl != null) {
                String videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
                if (!TextUtils.isEmpty(videoUuidFromVideoUrl) && PlayerConfig.g().getVideoReporter() != null) {
                    BaseVideo a16 = this.f279829b.a();
                    if (a16 != null) {
                        PlayerConfig.g().getVideoReporter().setExtraData(videoUuidFromVideoUrl, "ExtraDataKeyVideoActivity", a16.getVideoPlayInfo().videoRefer);
                    }
                    PlayerConfig.g().getVideoReporter().reportPreloadOccured(videoUuidFromVideoUrl, z16);
                    HashMap<String, Object> hashMap = new HashMap<>();
                    if (z16) {
                        str = "play_cache";
                    } else {
                        str = "play_no_cache";
                    }
                    hashMap.put("status", str);
                    if (a16 != null && a16.getVideoPlayInfo() != null && "vertical".equalsIgnoreCase(a16.getVideoPlayInfo().videoRefer)) {
                        if (z16) {
                            str2 = "v_play_cache";
                        } else {
                            str2 = "v_play_no_cache";
                        }
                        hashMap.put("status_vertical", str2);
                    }
                    FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PRELOAD, hashMap);
                }
            }
            this.f279829b.f279998r = cachedBytesFromStart;
            PlayerUtils.log(4, "", "preload_log \u5f53\u524d\u64ad\u653e url=" + currentSegmentUrl);
        } catch (Exception unused) {
            PlayerUtils.log(6, this.f279828a, "reportPreload failed");
        }
    }

    private void E0(BaseVideo baseVideo) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleStopVideo video=" + PlayerUtils.toString(baseVideo));
        D0();
        F0(baseVideo, false, 1, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void E1(BaseVideo baseVideo, String str) {
        Uri uri;
        String str2;
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            VideoSpeedReport.g().end(VideoSpeedReport.POINT_VIDEO_PREPARE_ASYNC);
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().bufferingEnd(str, true);
                if (baseVideo.getVideoPlayInfo() != null) {
                    PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoSource", baseVideo.getVideoPlayInfo().videoSource);
                    PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoActivity", baseVideo.getVideoPlayInfo().videoRefer);
                    String currentSegmentUrl = this.I.d().getCurrentSegmentUrl();
                    String str3 = null;
                    try {
                        uri = Uri.parse(currentSegmentUrl);
                        try {
                            str2 = uri.getHost();
                        } catch (Exception unused) {
                            str2 = null;
                        }
                    } catch (Exception unused2) {
                        uri = null;
                        str2 = null;
                    }
                    try {
                        str3 = uri.getPath();
                    } catch (Exception unused3) {
                        PlayerUtils.log(5, this.f279828a, "gethost failed surl=" + currentSegmentUrl);
                        if (uri != null) {
                            if (!PlayerUtils.isIPV4Address(str2)) {
                            }
                        }
                        PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyPlayerType", Integer.valueOf(this.I.g()));
                        if (this.I.d().getInternalMediaPlayer() instanceof IExo2MediaPlayer) {
                        }
                        FeedVideoEnv.externalFunc.reportVideoSuccessRate(true, K(baseVideo, 0, 0));
                        return;
                    }
                    if (uri != null && str2 != null && str3 != null) {
                        if (!PlayerUtils.isIPV4Address(str2)) {
                            PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoServerIp", str2);
                            if (str3.startsWith("/")) {
                                str3 = str3.substring(1);
                            }
                            int indexOf = str3.indexOf("/");
                            if (indexOf != -1) {
                                PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoHost", str3.substring(0, indexOf));
                            } else {
                                PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoHost", "none");
                            }
                        } else {
                            PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoHost", str2);
                        }
                    }
                    PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyPlayerType", Integer.valueOf(this.I.g()));
                    if (this.I.d().getInternalMediaPlayer() instanceof IExo2MediaPlayer) {
                        PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoDecoderName", ((IExo2MediaPlayer) this.I.d().getInternalMediaPlayer()).getVideoDecoderName());
                    }
                }
            }
            FeedVideoEnv.externalFunc.reportVideoSuccessRate(true, K(baseVideo, 0, 0));
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[reportPrepared] mPlayer == null || mPlayer.get() == null.");
    }

    private void F0(BaseVideo baseVideo, boolean z16, int i3, int i16) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            n();
            PlayerUtils.log(4, this.f279828a, "-------------------- handleStopVideo. video=" + PlayerUtils.toString(baseVideo) + " isCompletion=" + z16 + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            if (baseVideo == null) {
                PlayerUtils.log(4, this.f279828a, "handleStopVideo: videoNeedStop is null");
                return;
            }
            removeMessages(101);
            removeMessages(13);
            if (!z16) {
                if (i3 != 1 && i16 >= 0) {
                    baseVideo.videoUIStop(i3, i16);
                } else {
                    baseVideo.videoUIStop();
                }
            }
            D0();
            BaseVideoManagerUtils.setGlobalChangeSurfaceHolder(null);
            removeMessages(50, baseVideo);
            baseVideo.resetGLTextureView();
            try {
                this.I.d().setSurface(null);
            } catch (Exception e16) {
                PlayerUtils.log(4, this.f279828a, "setSurface failed " + e16);
            }
            if (this.f279829b.f279988h) {
                String videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(this.I.d().getCurrentProxySegmentUrl());
                if (PlayerConfig.g().getVideoReporter() != null) {
                    PlayerUtils.log(2, this.f279828a + U, "handleStopVideo getCurrentPosition");
                    if (!TextUtils.isEmpty(videoUuidFromVideoUrl)) {
                        CachedMediaPlayer cachedMediaPlayer2 = this.I;
                        if (cachedMediaPlayer2 != null && cachedMediaPlayer2.d() != null && this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPOSITION)) {
                            CachedMediaPlayer cachedMediaPlayer3 = this.I;
                            PlayerConfig.g().getVideoReporter().stopPlayVideo(videoUuidFromVideoUrl, cachedMediaPlayer3 != null ? cachedMediaPlayer3.d().getCurrentPosition() : 0L, this.f279829b.f279994n);
                        } else {
                            PlayerConfig.g().getVideoReporter().stopPlayVideo(videoUuidFromVideoUrl, 0L, 0);
                        }
                    }
                }
                removeMessages(41);
                removeMessages(81);
                if (baseVideo.getVideoPlayInfo() != null && baseVideo.getVideoPlayInfo().isCanvasAdvVideo) {
                    baseVideo.getVideoPlayInfo().isFeedFirstComplete = true;
                    PlayerUtils.log(2, this.f279828a + U, "handleStopVideo getCurrentPosition 2");
                    C1(baseVideo, false, z16);
                }
                if ((baseVideo.getVideoPlayInfo() != null && ((baseVideo.getVideoPlayInfo().k() || ((this.f279829b.a() instanceof WindowPlayVideo) && baseVideo.getVideoPlayInfo().e())) && (!(this.f279829b.a() instanceof FeedAutoVideoFull) || this.f279829b.a().getVideoPlayInfo() == null || this.f279829b.a().getVideoPlayInfo().isForceAdvReport))) || (baseVideo.getVideoPlayInfo() != null && baseVideo.getVideoPlayInfo().needAdvReport)) {
                    VideoPlayInfo videoPlayInfo = baseVideo.getVideoPlayInfo();
                    videoPlayInfo.isFeedFirstComplete = true;
                    PlayerUtils.log(2, this.f279828a + U, "handleStopVideo getCurrentPosition 2");
                    B1(baseVideo, false, z16);
                    if (BaseVideoManager.f279599k == null) {
                        BaseVideoManager.f279599k = new HashSet<>();
                    }
                    BaseVideoManager.f279599k.add(videoPlayInfo.feedKey);
                }
                CachedMediaPlayer cachedMediaPlayer4 = this.I;
                if (cachedMediaPlayer4 != null && cachedMediaPlayer4.d() != null && this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPOSITION) && this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTSEGMENTURL)) {
                    r0(baseVideo, z16, true);
                }
                PlayerUtils.log(2, this.f279828a + U, "mPlayer release");
                if (!TextUtils.isEmpty(videoUuidFromVideoUrl)) {
                    A1(videoUuidFromVideoUrl);
                    com.tencent.mobileqq.qzoneplayer.videosource.b.b().stopPlay(videoUuidFromVideoUrl);
                }
                CachedMediaPlayer cachedMediaPlayer5 = this.I;
                if (cachedMediaPlayer5 != null && cachedMediaPlayer5.d() != null && this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_STOP)) {
                    this.I.d().stop();
                }
                CachedMediaPlayer cachedMediaPlayer6 = this.I;
                if (cachedMediaPlayer6 != null && cachedMediaPlayer6.d() != null && this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RESET) && this.f279843p == 0) {
                    this.I.d().reset();
                }
                a0(new j(baseVideo, videoUuidFromVideoUrl));
                return;
            }
            z1("");
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleStopVideo] mPlayer == null || mPlayer.get() == null.");
    }

    private int G() {
        ArrayList<VideoRequest> videoRequestByUuid;
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            if (TextUtils.isEmpty(E()) || L() == null || (videoRequestByUuid = L().getVideoRequestByUuid(E())) == null || videoRequestByUuid.size() <= 0) {
                return -1;
            }
            Iterator<VideoRequest> it = videoRequestByUuid.iterator();
            while (it.hasNext()) {
                VideoRequest next = it.next();
                if (next.getTotalLength() != -1) {
                    Integer valueOf = Integer.valueOf((int) this.I.d().getDuration());
                    if (valueOf == null || valueOf.intValue() == 0) {
                        return -1;
                    }
                    int intValue = valueOf.intValue();
                    long totalLength = next.getTotalLength();
                    PlayerUtils.log(4, this.f279828a, "handleUpdateVideoView videoTotalBytes=" + totalLength);
                    return ((int) ((totalLength * 8) / intValue)) * 1000;
                }
            }
            return -1;
        }
        PlayerUtils.log(4, this.f279828a, "[getVideoBitrate] mPlayer == null || mPlayer.get() == null.");
        return -1;
    }

    private void G0(SegmentVideoInfo.StreamInfo streamInfo) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleSwitchStream.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        F0(this.f279829b.a(), false, 1, -1);
        if (streamInfo == null || this.f279829b.a() == null) {
            return;
        }
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        eVar.f279986f = 2;
        eVar.a().setShowCoverImage(false);
        this.f279829b.a().setState(2);
        this.f279829b.a().startLoadingLight();
        PlayerUtils.log(4, this.f279828a, "startLoadingLight " + this.f279829b.a());
        T1(streamInfo);
        if (this.f279829b.a() == null) {
            PlayerUtils.log(6, this.f279828a, "handleSwitchStream playing video is null");
            return;
        }
        if (this.f279829b.f279991k == null) {
            PlayerUtils.log(6, this.f279828a, "handleSwitchStream mStreamInfo is null");
            return;
        }
        com.tencent.mobileqq.qzoneplayer.video.c cVar = new com.tencent.mobileqq.qzoneplayer.video.c();
        com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
        cVar.f279972a = eVar2.f279991k;
        cVar.f279973b = eVar2.a();
        cVar.f279977f = true;
        cVar.f279976e = 0;
        sendMessage(obtainMessage(13, cVar));
    }

    private void H0(BaseVideo baseVideo, boolean z16, boolean z17) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleSwitchToPlayingState. video=" + PlayerUtils.toString(baseVideo) + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            if (baseVideo == null) {
                return;
            }
            removeMessages(41);
            Q1();
            baseVideo.setState(3);
            baseVideo.updateWithoutDelay(z16);
            int currentPosition = (int) this.I.d().getCurrentPosition();
            PlayerUtils.log(4, this.f279828a, "-------------------- handleSwitchToPlayingState. fix seek startPlayPosition  startPlayingPostion=" + currentPosition);
            if (currentPosition > 100) {
                long j3 = currentPosition;
                VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
                if (j3 < videoPlayInfoHolder.startPlayingPositionMills) {
                    videoPlayInfoHolder.startPlayingPositionMills = j3;
                }
            }
            sendEmptyMessageDelayed(81, 3000L);
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().realPlayVideo(this.f279829b.b(), z17);
                return;
            }
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleSwitchToPlayingState] mPlayer == null || mPlayer.get() == null.");
    }

    private void I0(BaseVideo baseVideo) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            if (this.f279829b.a() != baseVideo || baseVideo == null) {
                return;
            }
            PlayerUtils.log(4, this.f279828a, "-------------------- handleTimeOut. video=" + PlayerUtils.toString(baseVideo) + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            String videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(this.I.d().getCurrentProxySegmentUrl());
            if (PlayerConfig.g().getVideoReporter() != null) {
                if (PlayerUtils.isNetworkAvailable()) {
                    DNSService dNSService = PlayerConfig.g().getDNSService();
                    if (dNSService != null) {
                        if (!dNSService.isNetReachable()) {
                            PlayerConfig.g().getVideoReporter().failPlayVideo(videoUuidFromVideoUrl, -1000, PlayerUtils.getDownloadRetCode(9L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE), u(), C());
                        } else {
                            PlayerConfig.g().getVideoReporter().failPlayVideo(videoUuidFromVideoUrl, VideoResultCode.ERROR_PLAY_START_TIME_OUT_BASE, 0L, this.f279829b.f279994n, C());
                        }
                    } else {
                        PlayerConfig.g().getVideoReporter().failPlayVideo(videoUuidFromVideoUrl, VideoResultCode.ERROR_PLAY_START_TIME_OUT_BASE, 0L, this.f279829b.f279994n, C());
                    }
                } else {
                    PlayerConfig.g().getVideoReporter().failPlayVideo(videoUuidFromVideoUrl, -1000, PlayerUtils.getDownloadRetCode(9L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE), u(), C());
                }
            }
            L().cancelVideoRequestByUuid(videoUuidFromVideoUrl);
            PlayerUtils.log(6, this.f279828a, "\u52a0\u8f7d\u89c6\u9891\u8d85\u65f6 " + baseVideo.getSegmentVideoInfo().getDefaultUrl());
            if (this.f279829b.a().isBaseVideoCoverWrapperNotNull()) {
                this.f279829b.a().mVideoCoverWrapper.setLoadFailedText(FeedVideoEnv.feedResources.getString(1370));
            } else if (this.f279829b.a().isVideoCoverNotNull()) {
                this.f279829b.a().mVideoCover.loadFailedTextId = 1370;
            }
            this.f279829b.a().setState(6);
            this.f279829b.a().stop();
            FeedVideoEnv.externalFunc.getVideoLoader().clearCacheByInfo(this.f279829b.a().getSegmentVideoInfo());
            PlayerUtils.log(4, this.f279828a, "handleTimeOut remove video cache first segment source url" + this.I.d().getCurrentSegmentUrl());
            p0(false, true);
            Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
            if (callbacks != null) {
                for (PlayerCallBack playerCallBack : callbacks) {
                    playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_PLAY_PREPARE_TIMEOUT, "time out", null);
                }
                return;
            }
            return;
        }
        PlayerUtils.log(4, this.f279828a, "[handleTimeOut] mPlayer == null || mPlayer.get() == null.");
    }

    private void I1() {
        m mVar = new m();
        this.M = mVar;
        mVar.a();
    }

    private void J0() {
        BaseVideo a16 = this.f279829b.a();
        if (a16 == null) {
            return;
        }
        a16.clearHudText();
        if (a16.getVideoPlayInfo() != null) {
            String str = a16.getVideoPlayInfo().triggerHud;
        }
        int i3 = 0;
        for (Map.Entry<Integer, String[]> entry : this.I.j(this.f279829b.b(), this.f279829b.f279991k).entrySet()) {
            a16.updateHudText(entry.getKey().intValue(), entry.getValue()[0], entry.getValue()[1], true);
            if (i3 <= entry.getKey().intValue()) {
                i3 = entry.getKey().intValue();
            }
        }
        a16.updateHudText(i3 + 1, "\u63a8\u8350\u7b97\u6cd5", a16.getVideoPlayInfo().triggerHud, true);
        this.f279829b.a().refreshHudText();
        removeMessages(150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1(boolean z16) {
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        if (eVar == null || eVar.a() == null || this.f279829b.a().getVideoPlayInfo() == null || !this.f279829b.a().getVideoPlayInfo().isGdtAd) {
            return;
        }
        this.f279829b.a().getVideoPlayInfo().isGdtVideoPlaySuccess = z16;
    }

    private String K(BaseVideo baseVideo, int i3, int i16) {
        String defaultUrl;
        JSONObject jSONObject = new JSONObject();
        if (baseVideo != null) {
            try {
            } catch (JSONException e16) {
                PlayerUtils.log(5, this.f279828a, "getVideoReportDetail error:" + PlayerUtils.getPrintableStackTrace(e16));
            }
            if (baseVideo.getSegmentVideoInfo() != null) {
                defaultUrl = baseVideo.getSegmentVideoInfo().getDefaultUrl();
                jSONObject.put("video_url", defaultUrl);
                jSONObject.put("what", i3);
                jSONObject.put("extra", i16);
                jSONObject.put("videoadvstatus", F(baseVideo));
                return jSONObject.toString();
            }
        }
        defaultUrl = "";
        jSONObject.put("video_url", defaultUrl);
        jSONObject.put("what", i3);
        jSONObject.put("extra", i16);
        jSONObject.put("videoadvstatus", F(baseVideo));
        return jSONObject.toString();
    }

    private void K0(int i3) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "handleUpdateSound soundOperation " + i3);
            if (!this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME)) {
                PlayerUtils.log(4, this.f279828a, "handleUpdateSound deferred action");
                sendMessageDelayed(obtainMessage(24, i3, 0), 200L);
                return;
            }
            if (b1()) {
                PlayerUtils.log(4, this.f279828a, "handleUpdateSound mediaplayer is error");
                return;
            }
            if (i3 == 2) {
                this.f279850w = true;
            } else if (i3 == 3) {
                this.f279850w = false;
            } else {
                if (i3 != 4) {
                    PlayerUtils.log(6, this.f279828a, "handleUpdateSound invalid soundOperation " + i3);
                    return;
                }
                this.f279850w = !this.f279850w;
            }
            if (!this.f279850w) {
                this.I.d().setVolume(0.0f, 0.0f);
                PlayerUtils.log(4, this.f279828a, "michalliu6 player setvolume 0f,0f");
                ((AudioManager) FeedVideoEnv.getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.B);
                return;
            }
            this.I.d().setVolume(1.0f, 1.0f);
            PlayerUtils.log(4, this.f279828a, "michalliu6 player setvolume 1f,1f");
            AudioManager audioManager = (AudioManager) FeedVideoEnv.getApplicationContext().getSystemService("audio");
            int streamMaxVolume = (int) (audioManager.getStreamMaxVolume(3) * 0.7d);
            if (SystemMethodProxy.getStreamVolume(audioManager, 3) > streamMaxVolume) {
                try {
                    audioManager.setStreamVolume(3, streamMaxVolume, 0);
                } catch (Exception e16) {
                    PlayerUtils.log(5, this.f279828a, "-------------------- failed setStreamVolume", e16);
                }
            }
            audioManager.requestAudioFocus(this.B, 3, 1);
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleUpdateSound] mPlayer == null || mPlayer.get() == null.");
    }

    private void K1(CachedMediaPlayer cachedMediaPlayer, BaseVideo baseVideo, SegmentVideoInfo.StreamInfo streamInfo, int i3, boolean z16) {
        try {
            int i16 = g.f279881a[cachedMediaPlayer.f().ordinal()];
            if (i16 == 1) {
                cachedMediaPlayer.d().setDataSource(streamInfo, i3);
                if (z16) {
                    D1();
                    t1();
                    return;
                }
                return;
            }
            if (i16 != 2) {
                if (i16 != 3) {
                    PlayerUtils.log(6, this.f279828a, "mpCache impossible state to handle setDataSource");
                    return;
                } else {
                    PlayerUtils.log(4, this.f279828a, "mpCache skip setdatasource already prepared :)");
                    return;
                }
            }
            IOException b16 = cachedMediaPlayer.b();
            if (b16 == null) {
                return;
            }
            PlayerUtils.log(4, this.f279828a, "mpCache throw cached setdatasource exception");
            throw b16;
        } catch (Exception e16) {
            x0(baseVideo, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoRequestManager L() {
        try {
            return VideoManager.getInstance().getVideoRequestManager();
        } catch (IllegalStateException e16) {
            PlayerUtils.log(6, this.f279828a, "requestManager Init Error" + PlayerUtils.getPrintableStackTrace(e16));
            return null;
        }
    }

    private void L0(com.tencent.mobileqq.qzoneplayer.video.e eVar) {
        VideoPlayInfoHolder videoPlayInfoHolder;
        PlayerUtils.log(4, this.f279828a, "-------------------- handleUpdatePlayInfoHolder playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (eVar == null || TextUtils.isEmpty(eVar.f279985e) || !eVar.f279985e.equals(this.f279829b.f279985e) || (videoPlayInfoHolder = eVar.f279984d) == null) {
            return;
        }
        this.f279829b.f279984d = VideoPlayInfoHolder.shallowCopy(videoPlayInfoHolder);
    }

    private int M() {
        if (TextUtils.isEmpty(E())) {
            return -2;
        }
        ArrayList<VideoRequest> videoRequestByUuid = L().getVideoRequestByUuid(E());
        if (videoRequestByUuid == null || videoRequestByUuid.size() <= 0) {
            return -1;
        }
        Iterator<VideoRequest> it = videoRequestByUuid.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getSentBytes();
        }
        return i3;
    }

    private void M0(BaseVideo baseVideo, int i3) {
        PlayerUtils.log(4, this.f279828a, "start handleUpdateVideoView seekPosExpected=" + i3);
        m mVar = this.M;
        int i16 = -1;
        if (mVar.f279891c == -1) {
            mVar.f279891c = G();
            int x16 = x();
            m mVar2 = this.M;
            int i17 = ((i3 / 1000) * mVar2.f279891c) / 8;
            mVar2.f279890b = Math.max(0, x16 - i17);
            PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView videoBitrate=" + this.M.f279891c + ", downloadedBytesLength=" + x16 + ", seekPositionDownloadedBytes=" + i17 + ", extraBytesAlreadyDownloaded=" + this.M.f279890b);
        }
        int M = M();
        PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView checking downloaded bytes currentVideoSentBytes=" + M + ",extraBytesAlreadyDownloaded=" + this.M.f279890b);
        if (M != -1 && M != -2) {
            int i18 = this.M.f279894f;
            PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView default downloadBytesThreshold " + i18);
            m mVar3 = this.M;
            int i19 = mVar3.f279891c;
            if (i19 != -1) {
                i18 = (i19 * mVar3.f279893e) / 8;
                PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView adjust downloadBytesThreshold to " + i18);
            }
            int i26 = M + this.M.f279890b;
            if (i26 < i18) {
                PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView wait download bytes to be enough to play current " + i26);
                removeMessages(50, baseVideo);
                sendMessageDelayed(Message.obtain(this, 50, i3, 0, baseVideo), 100L);
                return;
            }
        } else {
            PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView skip videoDownloadedBytes check");
        }
        PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView checking seek position seekPosExpected " + i3);
        if (i3 > 0) {
            boolean isPlaying = this.I.d().isPlaying();
            PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView wait seek complete event mediaplayer isSeeking=" + this.A + ", isPlaying=" + isPlaying);
            if (isPlaying) {
                try {
                    this.I.d().pause();
                } catch (IMediaPlayer.InternalOperationException e16) {
                    PlayerUtils.log(6, this.f279828a + U, e16.toString());
                }
            } else if (this.A) {
                PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView wait seek complete event");
                removeMessages(50, baseVideo);
                sendMessageDelayed(Message.obtain(this, 50, i3, 0, baseVideo), 200L);
                return;
            }
            if (this.f279829b.f279986f != 1) {
                PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView video has stopped, video_state=" + this.f279829b.f279986f);
                return;
            }
            Integer valueOf = Integer.valueOf((int) this.I.d().getCurrentPosition());
            int intValue = valueOf != null ? valueOf.intValue() : 0;
            Integer valueOf2 = Integer.valueOf((int) this.I.d().getDuration());
            if (valueOf2 != null && valueOf2.intValue() != 0) {
                i16 = valueOf2.intValue();
            }
            if (i16 <= 0) {
                PlayerUtils.log(5, this.f279828a + U, "handleUpdateVideoView getDuration failed");
            } else if (i3 > i16) {
                PlayerUtils.log(6, this.f279828a + U, "handleUpdateVideoView seekPosExpected(" + i3 + ")>duration(" + i16 + ")");
            }
            if (intValue > 0 && i16 > 0 && i3 <= i16) {
                PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView seekTo currentPositionMills real:" + intValue);
                int i27 = (intValue - i3) - 200;
                PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView seekTo currentPositionMills seekdiff:" + i27);
                if (i27 < 0) {
                    int abs = Math.abs(i27);
                    if (abs < 0) {
                        PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView seekTo currentPositionMills wait:" + abs + " to update videoview");
                        removeMessages(50, baseVideo);
                        sendMessageDelayed(Message.obtain(this, 50, i3, 0, baseVideo), (long) Math.max(100, abs));
                        return;
                    }
                    PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView seekdiff + " + abs + " is too much, skipped");
                }
            } else {
                m mVar4 = this.M;
                int i28 = mVar4.f279889a;
                if (i28 < 2) {
                    mVar4.f279889a = i28 + 1;
                    PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView wait reach updateVideoViewCurrentPositionIsZeroThreshold 2, current " + this.M.f279889a);
                    removeMessages(50, baseVideo);
                    sendMessageDelayed(Message.obtain(this, 50, i3, 0, baseVideo), 200L);
                    return;
                }
                PlayerUtils.log(5, this.f279828a + U, "handleUpdateVideoView accurate seek is skipped ");
            }
        }
        PlayerUtils.log(4, this.f279828a + U, "handleUpdateVideoView start play");
        H0(baseVideo, true, true);
        this.f279829b.f279996p = System.currentTimeMillis();
        VideoSpeedReport.g().end(VideoSpeedReport.POINT_VIDEO_VISIBLE);
        VideoSpeedReport.g().end(VideoSpeedReport.POINT_UPDATE_VIDEOVIEW);
        VideoSpeedReport.ReportType videoReportType = VideoSpeedReport.ReportType.getVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY);
        VideoSpeedReport.g().setReportType(videoReportType);
        VideoSpeedReport.g().reportEnd(videoReportType);
        this.f279829b.f279984d._livePlayStartTimestamp = System.currentTimeMillis();
        VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
        videoPlayInfoHolder.livePlayDurationMills = 0L;
        videoPlayInfoHolder._livePlayStalledDurationMills = 0L;
        if (baseVideo != null && baseVideo.getVideoPlayInfo() != null) {
            this.f279829b.f279984d.videoId = baseVideo.getVideoPlayInfo().videoId;
        }
        this.R.onVideoPlayStart(this.f279829b.f279984d);
        baseVideo.checkIlleaglVideo();
    }

    private int O() {
        return yl2.c.e().i();
    }

    private void O0(final BaseVideoCover.CoverWarnType coverWarnType) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleVideoCoverWarnType.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        final BaseVideo a16 = this.f279829b.a();
        if (a16 != null) {
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.15
                @Override // java.lang.Runnable
                public void run() {
                    a16.videoUIPause(coverWarnType);
                }
            });
        } else {
            PlayerUtils.log(5, this.f279828a, "error remove video cache, playingVideo is null");
        }
    }

    private int P() {
        return yl2.c.e().j();
    }

    private void P0() {
        CachedMediaPlayer cachedMediaPlayer;
        if (this.f279829b.a() == null || this.f279829b.a().getVideoPlayInfo() == null || (cachedMediaPlayer = this.I) == null || cachedMediaPlayer.d() == null || !this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETLOOPING)) {
            return;
        }
        PlayerUtils.log(4, this.f279828a, "handleVideoPlayInfoUpdate: circlePlay " + this.f279829b.a().getVideoPlayInfo().g());
        this.I.d().setLooping(this.f279829b.a().getVideoPlayInfo().g());
    }

    private void Q0(SegmentVideoInfo.StreamInfo streamInfo, BaseVideo baseVideo, boolean z16) {
        this.f279829b.f279988h = false;
        com.tencent.mobileqq.qzoneplayer.video.c cVar = new com.tencent.mobileqq.qzoneplayer.video.c();
        cVar.f279972a = streamInfo;
        cVar.f279973b = baseVideo;
        cVar.f279977f = z16;
        int i3 = cVar.f279976e + 30;
        cVar.f279976e = i3;
        if (i3 > this.f279845r) {
            p0(false, false);
        } else {
            sendMessageDelayed(obtainMessage(13, cVar), 30L);
        }
    }

    private void R() {
        DescTextView descTextView;
        PlayerUtils.log(4, this.f279828a, "-------------------- handleBlurTimeView.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        final BaseVideo a16 = this.f279829b.a();
        if (a16 == null || a16.getState() == 1 || (descTextView = a16.mTimeview) == null || descTextView.getVisibility() == 8) {
            return;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.19
            @Override // java.lang.Runnable
            public void run() {
                DescTextView descTextView2;
                DescTextView descTextView3;
                BaseVideo baseVideo = a16;
                if (baseVideo != null && (descTextView3 = baseVideo.mTimeview) != null) {
                    descTextView3.setTextColor(Color.argb(205, 255, 255, 255));
                }
                BaseVideo baseVideo2 = a16;
                if (baseVideo2 == null || (descTextView2 = baseVideo2.mPlayCountView) == null) {
                    return;
                }
                descTextView2.setTextColor(Color.argb(205, 255, 255, 255));
            }
        });
    }

    private void R0() {
        int wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "VideoEnableHeroPlayer", 1);
        PlayerUtils.log(4, this.f279828a, "initHeroMediaPlayerConfig enableHeroPlayer=" + wnsConfig);
        if (wnsConfig == 0) {
            PlayerUtils.log(4, this.f279828a, "VideoEnableHeroPlayer=" + wnsConfig);
            FFSegmentMediaPlayer.disable();
            return;
        }
        int wnsConfig2 = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "VideoSupportHeroPlayer", 1);
        PlayerUtils.log(4, this.f279828a, "initHeroMediaPlayerConfig supportHeroPlayer=" + wnsConfig2);
        if (wnsConfig2 == 0) {
            PlayerUtils.log(4, this.f279828a, "VideoSupportHeroPlayer=" + wnsConfig);
            FFSegmentMediaPlayer.disable();
            return;
        }
        String wnsConfig3 = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "VideoVersionListDisableHeroPlayer", "");
        PlayerUtils.log(4, this.f279828a, "disableHeroPlayerVersionList disableHeroPlayerVersionList=" + wnsConfig3);
        if (TextUtils.isEmpty(wnsConfig3)) {
            return;
        }
        try {
            String[] split = wnsConfig3.split(";");
            if (split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && Integer.parseInt(str) == Build.VERSION.SDK_INT) {
                        FFSegmentMediaPlayer.disable();
                        return;
                    }
                }
            }
        } catch (Exception unused) {
            PlayerUtils.log(4, this.f279828a, "libForbiddenVersion get failed");
        }
    }

    private void S(String str) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleBufferingEnd. uuid=" + str + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            PlayerUtils.log(4, this.f279828a, "=============== BufferingEnd activeVideoRequest ===============");
            u1();
            PlayerUtils.log(4, this.f279828a, "============== End BufferingEnd activeVideoRequest ================");
            if (!TextUtils.isEmpty(str) && !str.equals(this.f279829b.f279985e)) {
                PlayerUtils.log(5, this.f279828a, "handleBufferingEnd: not current playing video. uuid=" + str + " playing uuid=" + this.f279829b.f279985e);
                return;
            }
            if (this.f279829b.f279986f == 2) {
                if (!this.I.d().isPaused()) {
                    H0(this.f279829b.a(), false, false);
                } else {
                    PlayerUtils.log(4, this.f279828a, "handleBufferingEnd mediaplayer is paused");
                    if (this.f279829b.a() != null) {
                        removeMessages(41);
                        this.f279829b.a().setState(5);
                        this.f279829b.a().updateWithoutDelay(false);
                        int currentPosition = (int) this.I.d().getCurrentPosition();
                        PlayerUtils.log(4, this.f279828a, "-------------------- handleBufferingEnd. fix seek startPlayPosition  startPlayingPostion=" + currentPosition);
                        if (currentPosition > 100) {
                            long j3 = currentPosition;
                            VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
                            if (j3 < videoPlayInfoHolder.startPlayingPositionMills) {
                                videoPlayInfoHolder.startPlayingPositionMills = j3;
                            }
                        }
                    }
                }
            }
            if (this.f279829b.f279987g) {
                if (PlayerConfig.g().getVideoReporter() != null) {
                    PlayerConfig.g().getVideoReporter().bufferingEnd(str, false);
                }
                this.f279829b.f279987g = false;
            }
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            eVar.f279990j = true;
            eVar.f279986f = 1;
            if (hasMessages(40)) {
                return;
            }
            a(200);
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleBufferingEnd] mPlayer == null || mPlayer.get() == null.");
    }

    private void S0(k kVar) {
        com.tencent.mobileqq.qzoneplayer.video.e eVar;
        if (this.f279843p == 0) {
            this.I = null;
        } else {
            this.f279830c.a(this.I);
        }
        zl2.a aVar = this.E;
        if (aVar != null && (eVar = this.f279829b) != null) {
            aVar.i(eVar.f279991k, new e(kVar));
        } else {
            PlayerUtils.log(4, this.f279828a, "[initMediaPlayer] headStreamInfoParser == null || managerState == null.");
        }
    }

    private void S1() {
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        if (eVar.f279986f == 2) {
            eVar.f279984d._livePlayStalledDurationMills += 1000;
            PlayerUtils.log(3, this.f279828a, "livePlayDuration=" + this.f279829b.f279984d.livePlayDurationMills + ",_livePlayStalledDuration=" + this.f279829b.f279984d._livePlayStalledDurationMills);
        }
        VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
        long currentTimeMillis = System.currentTimeMillis();
        VideoPlayInfoHolder videoPlayInfoHolder2 = this.f279829b.f279984d;
        videoPlayInfoHolder.livePlayDurationMills = Math.max(0L, (currentTimeMillis - videoPlayInfoHolder2._livePlayStartTimestamp) - videoPlayInfoHolder2._livePlayStalledDurationMills);
        PlayerUtils.log(3, this.f279828a, "livePlayDuration=" + this.f279829b.f279984d.livePlayDurationMills);
    }

    private void T(String str) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleBufferingStart. uuid=" + str + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            PlayerUtils.log(4, this.f279828a, "=============== BufferingStart activeVideoRequest ===============");
            u1();
            PlayerUtils.log(4, this.f279828a, "============== End BufferingStart activeVideoRequest ================");
            if (!TextUtils.isEmpty(str) && !str.equals(this.f279829b.f279985e)) {
                PlayerUtils.log(5, this.f279828a, "handleBufferingStart: not current playing video. uuid=" + str + " playing uuid=" + this.f279829b.f279985e);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f279829b.f279996p;
            PlayerUtils.log(4, this.f279828a, "handleBufferingStart: realPlayStartTimestamp diff=" + currentTimeMillis + ",realPlayStartTimestamp=" + this.f279829b.f279996p);
            if (this.f279829b.a() instanceof FeedAutoVideoFullLivePlayBack) {
                currentTimeMillis = Math.max(3001L, currentTimeMillis);
            }
            if (this.f279829b.a() == null || this.f279829b.f279986f == 2 || this.I == null || hasMessages(50)) {
                return;
            }
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            if (eVar.f279996p == 0 || currentTimeMillis <= 3000) {
                return;
            }
            eVar.f279987g = true;
            PlayerUtils.log(4, this.f279828a, "handleBufferingStart: realPlayStartTimestamp diff caculated");
            removeMessages(50, this.f279829b.a());
            PlayerUtils.log(4, this.f279828a + U, "MEDIA_INFO_BUFFERING_START startLoadingLight mediaplayer is playing = " + this.I.d().isPlaying());
            com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
            eVar2.f279986f = 2;
            eVar2.a().setShowCoverImage(false);
            this.f279829b.a().setState(2);
            this.f279829b.a().startLoadingLight();
            Pair<String, Boolean> pair = this.G;
            if (pair != null && ((String) pair.first).equals(this.f279829b.b()) && j1() && !h1()) {
                n1(this.f279829b.f279985e);
            }
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().bufferingBegin(str, false);
            }
            removeMessages(41);
            sendMessageDelayed(obtainMessage(41, this.f279829b.a()), 60000L);
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleBufferingStart] mPlayer == null || mPlayer.get() == null.");
    }

    private void T0() {
        this.C = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "VideoEnableUrlValidation", 1) == 1;
        this.f279843p = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "VideoIsAsyncReleasePreMP", 1);
        int wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoabstopdownloadopen", 0);
        this.f279843p = wnsConfig;
        this.F = wnsConfig;
    }

    private void T1(SegmentVideoInfo.StreamInfo streamInfo) {
        SegmentVideoInfo.StreamInfo streamInfo2;
        String str;
        PlayerUtils.log(4, this.f279828a, "handleUpdateStreamInfo.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (this.f279829b.a() == null || this.f279829b.a().mVideoPlayInfo.orgwebsite != 1 || this.f279829b.a().getVideoPlayInfo() == null || this.f279829b.a().getVideoPlayInfo().segmentVideoInfo == null) {
            streamInfo2 = null;
        } else {
            this.f279849v = this.f279829b.a().getVideoPlayInfo().segmentVideoInfo.getDefaultUrl();
            PlayerUtils.log(4, this.f279828a, "safeUrlLockDebug AllowLock getSafeUrlOriginUrl=" + this.f279849v);
            com.tencent.mobileqq.qzoneplayer.video.l h16 = s.g().h(this.f279849v, true);
            PlayerUtils.log(4, this.f279828a, "safeUrlLockDebug safeUrlResult back url=" + this.f279849v + ", result=" + h16.f280001a);
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().setExtraData("IgnoreVideoUUID", "ExtraDataKeyPlayUrl", this.f279849v);
            }
            streamInfo2 = u0(h16);
        }
        if (streamInfo2 != null) {
            PlayerUtils.log(4, this.f279828a, "use safeUrlStreamInfo");
            streamInfo = streamInfo2;
        } else if (streamInfo != null) {
            PlayerUtils.log(4, this.f279828a, "use backupStreamInfo");
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().setExtraData("IgnoreVideoUUID", "ExtraDataKeyPlayUrl", streamInfo.getUrl());
            }
        } else if (this.f279829b.a() != null) {
            streamInfo = this.f279829b.a().getH265StreamInfo();
            if (streamInfo == null) {
                streamInfo = this.f279829b.a().getStreamInfo();
            }
            if (PlayerConfig.g().getVideoReporter() != null) {
                IVideoReporter videoReporter = PlayerConfig.g().getVideoReporter();
                if (streamInfo != null) {
                    str = streamInfo.getUrl();
                } else {
                    str = "";
                }
                videoReporter.setExtraData("IgnoreVideoUUID", "ExtraDataKeyPlayUrl", str);
            }
            String str2 = this.f279828a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("preload_log use defaultStreamInfo, streamType = ");
            sb5.append(streamInfo != null ? streamInfo.streamType : -1);
            PlayerUtils.log(4, str2, sb5.toString());
        } else {
            this.f279829b.f279991k = null;
            return;
        }
        this.f279829b.f279991k = streamInfo;
        Q(streamInfo);
        if (this.f279829b.f279991k != null) {
            PlayerUtils.log(4, this.f279828a, "preload_log after handle streamType\uff1a" + this.f279829b.f279991k.streamType + JefsClass.INDEX_URL + this.f279829b.f279991k.getUrl());
        }
    }

    private void U(final BaseVideo baseVideo) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleChangePlayerSurfaceToFeed. video=" + PlayerUtils.toString(baseVideo) + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null && this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETSURFACE) && this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETSURFACE_TEXTURE)) {
            this.f279829b.d(baseVideo);
            ThreadUtils.submitTaskCatchAll(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.17
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ManagerHandler.this.I.d().getInternalMediaPlayer() instanceof GLTextureMediaPlayer) {
                            ((GLTextureMediaPlayer) ManagerHandler.this.I.d().getInternalMediaPlayer()).setSurfaceTexture(baseVideo.getSurfaceTexture(), ((Integer) baseVideo.getVideoSurfaceSize().first).intValue(), ((Integer) baseVideo.getVideoSurfaceSize().second).intValue());
                            baseVideo.setSurfaceTextureListener(((GLTextureMediaPlayer) ManagerHandler.this.I.d().getInternalMediaPlayer()).getSurfaceTextureListener());
                        } else {
                            ManagerHandler.this.I.d().setSurface(baseVideo.getSurface());
                        }
                    } catch (Exception e16) {
                        PlayerUtils.log(5, ManagerHandler.this.f279828a, "changePlayerSurface failed " + PlayerUtils.getPrintableStackTrace(e16));
                    }
                }
            }, 500, false, "changePlayerSurface");
            if (this.f279829b.a().getVideoPlayInfo() != null) {
                this.I.d().setLooping(this.f279829b.a().getVideoPlayInfo().g());
            }
            K0(3);
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            if (eVar.f279986f == 3 && eVar.a().getState() == 3) {
                this.f279829b.a().startIndicatePause();
                return;
            }
            return;
        }
        PlayerUtils.log(4, this.f279828a, "handleChangePlayerSurfaceToOtherSurface OP_SETSURFACE is not allowed");
    }

    private void U0() {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            this.I.d().setWakeMode(FeedVideoEnv.getApplicationContext(), 10);
            this.I.d().setOnVideoSizeChangedListener(new h());
            this.I.d().setOnPreparedListener(this.B);
            this.I.d().setOnBufferingUpdateListener(this.B);
            this.I.d().setOnErrorListener(this.B);
            this.I.d().setOnCompletionListener(this.B);
            this.I.d().setOnInfoListener(this.B);
            this.I.d().setOnSeekCompleteListener(this.B);
            this.f279829b.f279992l = false;
            return;
        }
        PlayerUtils.log(5, this.f279828a, "[initPlayerListener] mPlayer == null || mPlayer.get() == null");
    }

    private void U1(String str, BaseVideo baseVideo, int i3) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            if (PlayerConfig.g().getVideoReporter() != null) {
                Integer valueOf = Integer.valueOf((int) this.I.d().getDuration());
                if (valueOf != null && valueOf.intValue() != 0) {
                    PlayerConfig.g().getVideoReporter().setVideoDurationAndStartPlayPosition(str, valueOf.intValue(), i3);
                    return;
                } else {
                    if (baseVideo == null || baseVideo.getVideoPlayInfo() == null) {
                        return;
                    }
                    PlayerConfig.g().getVideoReporter().setVideoDurationAndStartPlayPosition(str, baseVideo.getVideoPlayInfo().videoTime, i3);
                    return;
                }
            }
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[videoPlayReport] mPlayer == null || mPlayer.get() == null.");
    }

    private void V(BaseVideoManagerUtils.ChangeSurfaceHolder changeSurfaceHolder) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleChangePlayerSurfaceToOther.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            PlayerUtils.getVideoUuidFromVideoUrl(this.I.d().getCurrentProxySegmentUrl());
            if (this.I.d().getVideoHeight() != 0 && this.I.d().getVideoWidth() != 0) {
                changeSurfaceHolder.newSurface.onVideoSizeChanged(this.I.d().getVideoWidth(), this.I.d().getVideoHeight());
            }
            this.I.d().setLooping(false);
            this.f279829b.d(changeSurfaceHolder.newSurface);
            if (this.I.d().getInternalMediaPlayer() instanceof GLTextureMediaPlayer) {
                if (changeSurfaceHolder.newSurface.getSurfaceTexture() == null) {
                    ((GLTextureMediaPlayer) this.I.d().getInternalMediaPlayer()).setSurface(changeSurfaceHolder.newSurface.getSurface());
                } else {
                    try {
                        ((GLTextureMediaPlayer) this.I.d().getInternalMediaPlayer()).setSurfaceTexture(changeSurfaceHolder.newSurface.getSurfaceTexture(), changeSurfaceHolder.newSurface.getVideoSurfaceSize() != null ? ((Integer) changeSurfaceHolder.newSurface.getVideoSurfaceSize().first).intValue() : 480, changeSurfaceHolder.newSurface.getVideoSurfaceSize() != null ? ((Integer) changeSurfaceHolder.newSurface.getVideoSurfaceSize().second).intValue() : 480);
                        changeSurfaceHolder.newSurface.setSurfaceTextureListener(((GLTextureMediaPlayer) this.I.d().getInternalMediaPlayer()).getSurfaceTextureListener());
                    } catch (TimeoutException e16) {
                        PlayerUtils.log(6, this.f279828a, "setSurfaceTexture TimeoutException " + PlayerUtils.getPrintableStackTrace(e16));
                    }
                }
                changeSurfaceHolder.newSurface.setSurfaceTextureListener(((GLTextureMediaPlayer) this.I.d().getInternalMediaPlayer()).getSurfaceTextureListener());
                return;
            }
            this.I.d().setSurface(changeSurfaceHolder.newSurface.getSurface());
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleChangePlayerSurfaceToOther] mPlayer == null || mPlayer.get() == null.");
    }

    private void W0() {
        this.E = new zl2.a();
    }

    private boolean Y0() {
        int networkType = FeedVideoEnv.externalFunc.getNetworkType(PlayerConfig.g().getAppContext());
        for (String str : this.f279838k.split(":")) {
            if (String.valueOf(networkType).equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void Z() {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleFloatShowNetworkTips.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        this.H = true;
        PlayerUtils.log(4, this.f279828a, "handleFloatShowNetworkTips is true");
    }

    private void a(int i3) {
        this.f279851x = "";
        removeMessages(40);
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 40;
        sendMessageDelayed(obtainMessage, i3);
    }

    private void a0(k kVar) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleInitMediaPlayer. playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && this.f279843p == 0) {
            try {
                Object submitTaskCatchAll = ThreadUtils.submitTaskCatchAll(new l(cachedMediaPlayer.d()), 500, false, "PlayerReleaseCallable", this.f279828a);
                if (submitTaskCatchAll != null && !((Boolean) submitTaskCatchAll).booleanValue()) {
                    PlayerUtils.log(5, this.f279828a, "media player released fail");
                }
            } catch (OutOfMemoryError unused) {
                CachedMediaPlayer cachedMediaPlayer2 = this.I;
                if (cachedMediaPlayer2 != null && cachedMediaPlayer2.d() != null) {
                    this.I.d().release();
                }
                PlayerUtils.log(5, this.f279828a, "oom media player released");
            }
        }
        y1();
        S0(kVar);
        U0();
    }

    private void b0(String str) {
        D0();
        final String shownTimeFromNumeric = FeedVideoEnv.getShownTimeFromNumeric(0L);
        this.f279851x = shownTimeFromNumeric;
        final BaseVideo a16 = this.f279829b.a();
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.16
            @Override // java.lang.Runnable
            public void run() {
                DescTextView descTextView;
                BaseVideo baseVideo = a16;
                if (baseVideo == null || (descTextView = baseVideo.mTimeview) == null) {
                    return;
                }
                descTextView.setText(shownTimeFromNumeric);
            }
        });
        a(1000);
        if (PlayerConfig.g().getVideoReporter() != null) {
            PlayerConfig.g().getVideoReporter().loopPlayVideo(str);
        }
    }

    private void c0(String str, int i3, int i16) {
        if (PlayerConfig.g().getVideoReporter() != null) {
            PlayerConfig.g().getVideoReporter().mediaPlayerOnInfo(str, i3, i16);
        }
        if (i3 == 3) {
            PlayerUtils.log(4, this.f279828a + U, "MEDIA_INFO_VIDEO_RENDERING_START");
            this.G = new Pair<>(str, Boolean.FALSE);
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().reportFirstRender(this.f279829b.b());
                return;
            }
            return;
        }
        if (i3 != 200) {
            switch (i3) {
                case 701:
                    if (e1()) {
                        PlayerUtils.log(4, this.f279828a + U, "MEDIA_INFO_BUFFERING_START");
                        if (hasMessages(50)) {
                            return;
                        }
                        obtainMessage(31, str).sendToTarget();
                        return;
                    }
                    return;
                case 702:
                    PlayerUtils.log(4, this.f279828a + U, "MEDIA_INFO_BUFFERING_END");
                    removeMessages(41);
                    obtainMessage(32, str).sendToTarget();
                    return;
                case 703:
                    PlayerUtils.log(4, this.f279828a + U, "MEDIA_INFO_NETWORK_BANDWIDTH " + i16 + "kbps");
                    return;
                default:
                    return;
            }
        }
        PlayerUtils.log(4, this.f279828a + U, "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK");
    }

    private void d0(BaseVideo baseVideo, SegmentVideoInfo.StreamInfo streamInfo, int i3, boolean z16) {
        com.tencent.mobileqq.qzoneplayer.video.c cVar = new com.tencent.mobileqq.qzoneplayer.video.c();
        cVar.f279972a = this.I;
        cVar.f279973b = baseVideo;
        cVar.f279974c = streamInfo;
        cVar.f279976e = i3;
        cVar.f279977f = z16;
        if (z16) {
            D1();
            t1();
            cVar.f279977f = false;
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().bufferingBegin(this.f279829b.f279985e, true);
            }
        }
        PlayerUtils.log(3, this.f279828a, "mpCache wait preload prepared " + this.I);
        sendMessageDelayed(obtainMessage(101, cVar), 200L);
    }

    private boolean d1() {
        if (!this.f279837j) {
            return false;
        }
        if (FeedVideoEnv.externalFunc.isFreeTraffic()) {
            return true;
        }
        return S;
    }

    private void e0(String str, int i3) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleOnBufferingUpdate. uuid=" + str + " percent=" + i3 + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (!TextUtils.isEmpty(str) && !str.equals(this.f279829b.f279985e)) {
            PlayerUtils.log(5, this.f279828a, "handleOnBufferingUpdate: not current playing video. uuid=" + str + " playing uuid=" + this.f279829b.f279985e);
            return;
        }
        if (this.f279829b.a() != null) {
            this.f279829b.a().onVideoBufferingUpdate(i3);
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            eVar.f279994n = i3;
            eVar.f279984d.bufferedPercent = i3;
            if (i3 >= this.f279834g && !this.K && c1() && s1()) {
                PlayerUtils.log(4, this.f279828a, "mpCache current video buffer percent > " + this.f279834g + " preloadPasterVideoAdv");
                return;
            }
            if (this.K || !c1()) {
                return;
            }
            VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
            if (q1(videoPlayInfoHolder.totalDurationMills, i3, videoPlayInfoHolder.currentPositionMills)) {
                r1(false);
            }
        }
    }

    private void f0(String str) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleOnCompletion. uuid=" + str + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (PlayerConfig.g().getVideoReporter() != null) {
            PlayerConfig.g().getVideoReporter().completePlayVideo(str);
        }
        L().cancelVideoRequestByUuid(str);
        if (!TextUtils.isEmpty(str) && !str.equals(this.f279829b.f279985e)) {
            PlayerUtils.log(5, this.f279828a, "handleOnCompletion: not current playing video. uuid=" + str + " playing uuid=" + this.f279829b.f279985e);
            return;
        }
        if (this.f279829b.a() == null) {
            return;
        }
        VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
        this.R.onVideoPlayComplete(videoPlayInfoHolder);
        if (this.f279829b.a().mHandler != null) {
            this.f279829b.a().mHandler.sendEmptyMessage(23);
        }
        if (this.f279829b.a().getVideoPlayInfo() != null && l1(this.f279829b.a()) && !(this.f279829b.a() instanceof FeedAutoVideoFull)) {
            this.f279829b.a().complete();
            if (this.f279829b.a().getVideoPlayInfo().k() && !TextUtils.isEmpty(this.f279829b.a().getVideoPlayInfo().feedKey)) {
                BaseVideoManager.f279598j.add(this.f279829b.a().getVideoPlayInfo().feedKey);
            }
        } else if (!(this.f279829b.a() instanceof FullScreenFeedAutoVideoFull) && this.f279829b.a().getVideoPlayInfo() != null && (((this.f279829b.a() instanceof FeedAutoVideoFull) || this.f279829b.a().getVideoPlayInfo().videoFeedType == 2) && !this.f279829b.a().getVideoPlayInfo().e())) {
            this.f279829b.a().recommendComplete();
        } else {
            this.f279829b.a().stop();
        }
        VideoPlayInfoHolder videoPlayInfoHolder2 = this.f279829b.f279984d;
        videoPlayInfoHolder2.currentPositionMills = videoPlayInfoHolder.totalDurationMills;
        videoPlayInfoHolder2.currentPositionSec = (int) Math.round((videoPlayInfoHolder.currentPositionMills * 1.0d) / 1000.0d);
        this.R.onVideoPlayProgressUpdate(videoPlayInfoHolder);
        yl2.c.e().c();
        p0(true, false);
    }

    private boolean g1() {
        return this.f279829b.f279997q > 0;
    }

    private boolean h1() {
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        if (eVar == null || eVar.a() == null) {
            return false;
        }
        return this.f279829b.a().isSpecialVideo();
    }

    private void i0(String str) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleOnSeekComplete. uuid=" + str + ", downloadedBytes=" + M() + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            PlayerUtils.log(4, this.f279828a, "handleUpdateVideoView isSeeking=false");
            this.A = false;
            if (!TextUtils.isEmpty(str) && !str.equals(this.f279829b.f279985e)) {
                PlayerUtils.log(5, this.f279828a, "handleOnSeekComplete: not current playing video. uuid=" + str + " playing uuid=" + this.f279829b.f279985e);
                return;
            }
            if (this.f279829b.a() != null) {
                if (!hasMessages(50)) {
                    if (this.f279829b.a().getState() != 3 && this.f279829b.a().getState() != 5) {
                        if (!this.I.d().isPaused()) {
                            H0(this.f279829b.a(), false, false);
                        } else {
                            PlayerUtils.log(4, this.f279828a, "handleBufferingEnd mediaplayer is paused");
                            if (this.f279829b.a() != null) {
                                removeMessages(41);
                                this.f279829b.a().setState(5);
                                int currentPosition = (int) this.I.d().getCurrentPosition();
                                PlayerUtils.log(4, this.f279828a, "-------------------- handleBufferingEnd. fix seek startPlayPosition  startPlayingPostion=" + currentPosition);
                                if (currentPosition > 100) {
                                    long j3 = currentPosition;
                                    VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
                                    if (j3 < videoPlayInfoHolder.startPlayingPositionMills) {
                                        videoPlayInfoHolder.startPlayingPositionMills = j3;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    PlayerUtils.log(4, this.f279828a, "has pending MSG_UPDATE_VIDEOVIEW_LOOP message");
                }
                a(200);
                return;
            }
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleOnSeekComplete] mPlayer == null || mPlayer.get() == null.");
    }

    private void j0() {
        String str;
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handlePauseVideo.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            if (!this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_PAUSE)) {
                PlayerUtils.log(5, this.f279828a, "impossile to pause at this moment");
                return;
            }
            if (this.f279829b.a() != null) {
                com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
                if (eVar.f279989i && eVar.f279988h && eVar.f279990j) {
                    try {
                        this.I.d().pause();
                        com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
                        eVar2.f279986f = 3;
                        eVar2.a().startIndicatePause();
                        if (PlayerConfig.g().getVideoReporter() != null) {
                            PlayerConfig.g().getVideoReporter().addVideoPlayTimeRange(PlayerUtils.getVideoUuidFromVideoUrl(this.I.d().getCurrentProxySegmentUrl()), this.I.d().getCurrentPosition());
                        }
                        VideoPlayInfoHolder videoPlayInfoHolder = (VideoPlayInfoHolder) this.f279829b.c().second;
                        if (videoPlayInfoHolder != null) {
                            if (!TextUtils.isEmpty(this.f279829b.a().getRecordVideoId())) {
                                str = this.f279829b.a().getRecordVideoId();
                            } else {
                                str = this.f279829b.a().getVideoPlayInfo().videoId;
                            }
                            if (!this.f279829b.a().getVideoPlayInfo().isNotRecordProgress) {
                                AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(str, videoPlayInfoHolder);
                                PlayerUtils.log(3, this.f279828a, "recordProgress handlePauseVideo videoId:" + str + " recordProgress handlePauseVideo currentPositionMills:" + videoPlayInfoHolder.currentPositionMills);
                            } else {
                                PlayerUtils.log(3, this.f279828a, "recordProgress handlePauseVideo progress not recorded");
                            }
                        }
                        this.R.onVideoPlayPause(this.f279829b.f279984d);
                        return;
                    } catch (IllegalStateException e16) {
                        PlayerUtils.log(6, this.f279828a, "error! handlePauseVideo: " + PlayerUtils.getPrintableStackTrace(e16));
                        return;
                    } catch (IMediaPlayer.InternalOperationException e17) {
                        PlayerUtils.log(6, this.f279828a, "error! handlePauseVideo: " + PlayerUtils.getPrintableStackTrace(e17));
                        return;
                    }
                }
                return;
            }
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handlePauseVideo] mPlayer == null || mPlayer.get() == null.");
    }

    private boolean j1() {
        return yl2.c.e().l();
    }

    private void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        VideoManager.getInstance().addUuidErrorListener(str, this.B);
    }

    private void k0(BaseVideo baseVideo) {
        VideoPlayInfoHolder videoProgressRecord;
        PlayerUtils.log(4, this.f279828a, "-------------------- handlePlayCurrentVideo request playVideo" + baseVideo);
        r.b().a(true);
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        eVar.f279997q = 0;
        eVar.f279983c = new WeakReference<>(baseVideo);
        BaseVideo a16 = this.f279829b.a();
        if (a16 != null && a16 != baseVideo) {
            a16.setShowCoverImage(true);
            F0(a16, false, 1, -1);
            a16.videoUIStop();
            this.f279829b.d(null);
            PlayerUtils.log(4, this.f279828a + U, "handlePlayCurrentVideo cleanup old playingvideo finish, mPlayingVideo==null,positon:11");
        } else if (a16 == baseVideo) {
            PlayerUtils.log(4, this.f279828a, "handlePlayCurrentVideo Same playingVideo");
            return;
        }
        if (baseVideo != null && baseVideo.getVideoPlayInfo() != null) {
            boolean k3 = baseVideo.getVideoPlayInfo().k();
            String str = baseVideo.getVideoPlayInfo().feedKey;
            if (k3 && !TextUtils.isEmpty(str) && (videoProgressRecord = AutoVideoProgressRecorder.getInstance().getVideoProgressRecord(str)) != null && !videoProgressRecord.isNeverPlayed) {
                return;
            }
        }
        if (baseVideo != null) {
            if (baseVideo.getVideoPlayInfo() != null) {
                PlayerUtils.log(4, this.f279828a, "switch playingVideo to " + baseVideo);
                this.f279829b.d(baseVideo);
                this.f279829b.a().setRecordVideoId(this.f279829b.a().getVideoPlayInfo().videoId);
                O1(baseVideo);
                baseVideo.startLayout();
                removeMessages(1);
                m1(false);
                return;
            }
            PlayerUtils.log(4, this.f279828a, "playingVideo VideoPlayInfo is null");
            return;
        }
        PlayerUtils.log(4, this.f279828a, "videoNeedPlay is null");
    }

    private void l() {
        yl2.c.e().a(FeedVideoEnv.getNetworkType(), true);
        this.O = true;
        this.Q = 0;
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        if (eVar == null || eVar.a() == null || this.f279829b.a().getVideoPlayInfo() == null || this.f279829b.a().getVideoPlayInfo().segmentVideoInfo == null || this.f279829b.a().getVideoPlayInfo().cookie == null) {
            return;
        }
        int currentStreamType = this.f279829b.a().getVideoPlayInfo().segmentVideoInfo.getCurrentStreamType();
        String str = this.f279829b.a().getVideoPlayInfo().cookie.get(1);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PlayerConfig.g().getVideoReporter().reportDecreaseRate(str, currentStreamType == 0 ? 750 : currentStreamType);
        PlayerUtils.log(4, "[VideoRate]", "report ugcKey:" + str + "\r\ncur_rate:" + currentStreamType);
    }

    private void l0(SegmentVideoInfo.StreamInfo streamInfo, BaseVideo baseVideo, boolean z16) {
        if (BaseVideoManager.belowICE_CREAM && FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
            PlayerUtils.log(6, this.f279828a + U, "handlePlayVideo:belowICE_CREAM and CLOSE_HARDWARE_ACCELERATED");
            return;
        }
        if (streamInfo == null) {
            PlayerUtils.log(6, this.f279828a + U, "handlePlayVideo:StreamInfo info == null");
            return;
        }
        if (baseVideo == null) {
            PlayerUtils.log(6, this.f279828a + U, "handlePlayVideo:playingVideo == null");
            return;
        }
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        if (eVar.f279988h && eVar.a() == baseVideo) {
            PlayerUtils.log(5, this.f279828a + U, "hasStarted: " + this.f279829b.f279988h + ", video is playing already!");
            return;
        }
        if (!baseVideo.isSurfaceAvailable()) {
            Q0(streamInfo, baseVideo, z16);
            return;
        }
        if (this.f279829b.f279988h) {
            PlayerUtils.log(6, this.f279828a + U, "mPlayingVideo==null,positon:6");
            a0(null);
            com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
            eVar2.f279986f = 0;
            eVar2.f279988h = false;
        }
        a0(new d(streamInfo, baseVideo, z16));
    }

    private boolean l1(BaseVideo baseVideo) {
        return baseVideo.isNeedShowEndCover();
    }

    private void m() {
        if (this.f279829b.a() != null) {
            F0(this.f279829b.a(), false, 1, -1);
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().completePlayVideo("IgnoreVideoUUID");
            }
            this.f279829b.d(null);
            PlayerUtils.log(6, this.f279828a + U, "mPlayingVideo==null,positon:7");
        }
        this.f279829b.f279986f = 0;
    }

    private void m0(BaseVideo baseVideo, Exception exc) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            boolean z16 = exc instanceof IllegalStateException;
            if ((z16 || (exc instanceof GLTextureMediaPlayer.GLTextureTimeoutException)) && this.f279829b.f279997q < this.f279847t) {
                PlayerUtils.log(4, this.f279828a, "prepareAsync error retrying count=" + this.f279829b.f279997q + "," + this.f279847t + ",e=" + exc);
                com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
                eVar.f279997q = eVar.f279997q + 1;
                eVar.a().reconfigureSurface();
                baseVideo.videoUIStop();
                a0(new c());
                return;
            }
            if (PlayerConfig.g().getVideoReporter() != null) {
                String videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(this.I.d().getCurrentProxySegmentUrl());
                if (z16) {
                    PlayerConfig.g().getVideoReporter().failPlayVideo(videoUuidFromVideoUrl, VideoResultCode.ERROR_PLAY_START_ILLEGAL_STATE_EXCEPTION_BASE, 0L, this.f279829b.f279994n, C());
                } else if (exc instanceof IllegalArgumentException) {
                    PlayerConfig.g().getVideoReporter().failPlayVideo(videoUuidFromVideoUrl, VideoResultCode.ERROR_PLAY_START_ILLEGAL_ARGUMENT_EXCEPTION_BASE, 0L, this.f279829b.f279994n, C());
                } else if (exc instanceof GLTextureMediaPlayer.GLTextureTimeoutException) {
                    PlayerConfig.g().getVideoReporter().failPlayVideo(videoUuidFromVideoUrl, VideoResultCode.ERROR_PLAY_START_SET_SURFACE_TIMEOUT_BASE, 0L, this.f279829b.f279994n, C());
                } else {
                    PlayerConfig.g().getVideoReporter().failPlayVideo(videoUuidFromVideoUrl, VideoResultCode.ERROR_PLAY_START_OTHER_EXCEPTION_BASE, 0L, this.f279829b.f279994n, C());
                }
                if (L() != null) {
                    L().cancelVideoRequestByUuid(videoUuidFromVideoUrl);
                }
            }
            FeedVideoEnv.externalFunc.reportVideoSuccessRate(false, K(baseVideo, 2220002, 0));
            PlayerUtils.log(6, this.f279828a, "Play Video Exception, handlePlayVideo:" + PlayerUtils.getPrintableStackTrace(exc));
            if (FeedVideoEnv.externalFunc.isDebugVersion()) {
                FeedVideoEnv.externalFunc.showToast("\u62b1\u6b49\uff0c\u89c6\u9891\u64ad\u653e\u51fa\u9519\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            }
            baseVideo.videoUIStop();
            a0(null);
            FeedVideoEnv.externalFunc.getVideoLoader().clearCacheByInfo(baseVideo.getSegmentVideoInfo());
            com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
            eVar2.f279988h = false;
            eVar2.f279986f = 0;
            eVar2.d(null);
            this.f279829b.f279992l = true;
            PlayerUtils.log(6, this.f279828a + U, "hasStarted=false pos 5,mPlayingVideo==null,positon:5");
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handlePlayerPrepareException] mPlayer == null || mPlayer.get() == null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(boolean z16) {
        PlayerUtils.log(4, this.f279828a, "onIdle");
        BaseVideo a16 = this.f279829b.a();
        if (a16 != null) {
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            eVar.f279986f = 2;
            eVar.f279988h = false;
            a16.setState(2);
            a16.setShowCoverImage(a16.getVideoPlayInfo().showCoverImage);
            a16.startLoadingLight();
            PlayerUtils.log(4, this.f279828a, "startLoadingLight " + a16);
            if (!z16) {
                T1(null);
            }
            if (this.f279829b.a() == null) {
                PlayerUtils.log(6, this.f279828a, "onIdle playing video is null");
                return;
            }
            if (this.f279829b.f279991k == null) {
                PlayerUtils.log(6, this.f279828a, "onIdle mStreamInfo is null");
                return;
            }
            a16.preparedVideoView();
            a16.isAutoPlay = true;
            a16.isFirstPlay = true;
            FeedVideoEnv.externalFunc.reportClick("353", "1", null);
            com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
            if (eVar2.f279991k != null) {
                com.tencent.mobileqq.qzoneplayer.video.c cVar = new com.tencent.mobileqq.qzoneplayer.video.c();
                cVar.f279972a = this.f279829b.f279991k;
                cVar.f279973b = a16;
                cVar.f279977f = false;
                cVar.f279976e = 0;
                sendMessage(obtainMessage(13, cVar));
                return;
            }
            eVar2.d(null);
            PlayerUtils.log(6, this.f279828a, "STREAM is null, mPlayingVideo==null,positon:21");
            return;
        }
        this.f279829b.d(null);
        PlayerUtils.log(6, this.f279828a + U, "mPlayingVideo==null,positon:2");
    }

    private void n() {
        PlayerUtils.log(4, this.f279828a, "cleanMediaPlayerMessages");
        removeMessages(30);
        removeMessages(31);
        removeMessages(32);
        removeMessages(33);
        removeMessages(34);
        removeMessages(35);
        removeMessages(36);
        removeMessages(37);
        y1();
        removeMessages(26);
        removeMessages(60);
        removeMessages(61);
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer == null || cachedMediaPlayer.d() == null) {
            return;
        }
        PlayerUtils.log(4, this.f279828a, "cleanMediaPlayerMessages clean mediaplayer callbacks");
        this.I.d().setOnPreparedListener(null);
        this.I.d().setOnBufferingUpdateListener(null);
        this.I.d().setOnErrorListener(null);
        this.I.d().setOnCompletionListener(null);
        this.I.d().setOnInfoListener(null);
        this.I.d().setOnSeekCompleteListener(null);
        this.I.d().setOnVideoSizeChangedListener(null);
    }

    private void n0(BaseVideo baseVideo) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handlePlayingVideoSurfaceDestroyed sender " + baseVideo + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (g1() || this.f279829b.a() != baseVideo) {
            return;
        }
        p0(false, false);
    }

    private void n1(String str) {
        PlayerUtils.log(4, "[VideoRate]", "uuid:" + this.f279829b.b() + " second buffering ...");
        String str2 = this.N;
        if (str2 == null || !str.equals(str2)) {
            this.O = false;
            this.P = 0;
            this.N = str;
        }
        if (this.O) {
            return;
        }
        this.P++;
        PlayerUtils.log(4, "[VideoRate]", "stuckTimes++, M= " + this.P);
        Pair<String, Boolean> pair = this.G;
        if (pair != null && !((Boolean) pair.second).booleanValue()) {
            this.G = new Pair<>(str, Boolean.TRUE);
            this.Q++;
            PlayerUtils.log(4, "[VideoRate]", "totalStuckVideoNum++, N= " + this.Q);
        }
        if (this.P >= O() || this.Q >= P()) {
            l();
        }
    }

    private int o(String str) {
        if ("1".equals(str)) {
            return 1;
        }
        if ("4".equals(str)) {
            return 2;
        }
        if ("5".equals(str)) {
            return 3;
        }
        if ("11".equals(str)) {
            return 4;
        }
        if ("3".equals(str)) {
            return 5;
        }
        if ("6".equals(str)) {
            return 6;
        }
        if ("7".equals(str)) {
            return 7;
        }
        if ("8".equals(str)) {
            return 8;
        }
        return "12".equals(str) ? 11 : -1;
    }

    private void o0() {
        VideoPlayInfo videoPlayInfo;
        PlayerUtils.log(4, this.f279828a, "mpCache handlePreloadNextVideo");
        ArrayList arrayList = new ArrayList();
        ArrayList<VideoPlayInfo> arrayList2 = new ArrayList<>();
        if (this.f279829b.a() != null && (videoPlayInfo = this.f279829b.a().getVideoPlayInfo()) != null) {
            PlayerUtils.log(4, this.f279828a, "mpCache handlePreloadNextVideo currently playing , mPos=" + videoPlayInfo.itemPosition + ",videoid=" + videoPlayInfo.videoId + JefsClass.INDEX_URL + videoPlayInfo.segmentVideoInfo.getDefaultUrl());
            int size = this.f279835h.size();
            boolean z16 = false;
            for (int i3 = 0; i3 < size; i3++) {
                VideoPlayInfo videoPlayInfo2 = this.f279835h.get(i3);
                if (z16) {
                    if (arrayList2.size() >= this.f279841n) {
                        break;
                    } else {
                        arrayList2.add(videoPlayInfo2);
                    }
                } else {
                    if (videoPlayInfo2.equals(videoPlayInfo)) {
                        z16 = true;
                    }
                    arrayList.add(videoPlayInfo2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            this.K = true;
            s(arrayList2);
            this.f279835h.removeAll(arrayList);
            return;
        }
        PlayerUtils.log(4, this.f279828a, "mpCache handlePreloadNextVideo nothing to preload");
    }

    private void p(BaseVideo baseVideo, VideoPlayInfoHolder videoPlayInfoHolder) {
        if (baseVideo.getVideoPlayInfo() != null) {
            if (baseVideo.getVideoPlayInfo().e() || baseVideo.getVideoPlayInfo().needAdvReport) {
                if (videoPlayInfoHolder != null) {
                    VideoPlayInfoHolder videoPlayInfoHolder2 = this.f279829b.f279984d;
                    videoPlayInfoHolder2.startPlayingPositionMills = videoPlayInfoHolder.currentPositionMills;
                    videoPlayInfoHolder2.isNeverPlayed = videoPlayInfoHolder.isNeverPlayed;
                    videoPlayInfoHolder2.hadPlayedRounds = videoPlayInfoHolder.hadPlayedRounds;
                    videoPlayInfoHolder2.lastValidPositionMills = videoPlayInfoHolder.lastValidPositionMills;
                    return;
                }
                VideoPlayInfoHolder videoPlayInfoHolder3 = this.f279829b.f279984d;
                videoPlayInfoHolder3.startPlayingPositionMills = 0L;
                videoPlayInfoHolder3.isNeverPlayed = true;
                videoPlayInfoHolder3.hadPlayedRounds = 0L;
                videoPlayInfoHolder3.lastValidPositionMills = 0L;
            }
        }
    }

    private void p0(boolean z16, boolean z17) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleRecyclePlayingVideo playingVideo=" + PlayerUtils.toString(this.f279829b.a()) + ",isCompletion" + z16);
        F0(this.f279829b.a(), z16, z17 ? 6 : 1, z17 ? 1371 : -1);
        this.f279829b.d(null);
        PlayerUtils.log(6, this.f279828a + U, "mPlayingVideo==null,positon:1");
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        eVar.f279986f = 0;
        eVar.f279991k = null;
        PlayerUtils.log(5, this.f279828a + U, "mStreamInfo==null,positon:1");
    }

    private void q0() {
        Boolean bool;
        Integer valueOf;
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleRefreshTime.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            final BaseVideo a16 = this.f279829b.a();
            CachedMediaPlayer cachedMediaPlayer2 = this.I;
            SegmentVideoInfo.StreamInfo streamInfo = this.f279829b.f279991k;
            if (streamInfo != null && streamInfo.isHLSLive) {
                S1();
                this.R.onVideoPlayProgressUpdate(this.f279829b.f279984d);
                Message obtainMessage = obtainMessage();
                obtainMessage.what = 40;
                sendMessageDelayed(obtainMessage, 1000L);
                return;
            }
            if (cachedMediaPlayer2.h()) {
                PlayerUtils.log(4, this.f279828a, "player is recyled");
                return;
            }
            if (a16 != null) {
                if (a16.getState() == 1) {
                    PlayerUtils.log(4, this.f279828a, "video.state == STATE_STOP");
                    return;
                }
                if (a16.mTimeview != null) {
                    if (a16.needShowTimeView()) {
                        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.6
                            @Override // java.lang.Runnable
                            public void run() {
                                DescTextView descTextView;
                                BaseVideo baseVideo = a16;
                                if (baseVideo == null || (descTextView = baseVideo.mTimeview) == null) {
                                    return;
                                }
                                descTextView.setVisibility(0);
                            }
                        });
                    } else {
                        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.7
                            @Override // java.lang.Runnable
                            public void run() {
                                DescTextView descTextView;
                                BaseVideo baseVideo = a16;
                                if (baseVideo != null && (descTextView = baseVideo.mTimeview) != null) {
                                    descTextView.setVisibility(8);
                                }
                                DescTextView descTextView2 = a16.mPlayCountView;
                                if (descTextView2 != null) {
                                    descTextView2.setVisibility(8);
                                }
                            }
                        });
                    }
                }
                long j3 = this.f279829b.a().getVideoPlayInfo() == null ? 0L : this.f279829b.a().getVideoPlayInfo().videoTime;
                if (this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_ISPLAYING)) {
                    bool = Boolean.valueOf(this.I.d().isPlaying());
                } else {
                    bool = Boolean.FALSE;
                }
                if (bool != null && bool.booleanValue()) {
                    if (this.f279829b.a().getVideoPlayInfo() != null) {
                        SegmentVideoInfo.StreamInfo streamInfo2 = this.f279829b.f279991k;
                        if (streamInfo2 == null) {
                            return;
                        }
                        if (!streamInfo2.isVideoTimeCanBeTrust && (valueOf = Integer.valueOf((int) this.I.d().getDuration())) != null && valueOf.intValue() != 0) {
                            j3 = valueOf.intValue();
                            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
                            SegmentVideoInfo.StreamInfo streamInfo3 = eVar.f279991k;
                            if (streamInfo3 != null) {
                                streamInfo3.isVideoTimeCanBeTrust = true;
                            }
                            eVar.a().getVideoPlayInfo().videoTimeOrg = this.f279829b.a().getVideoPlayInfo().videoTime;
                            this.f279829b.a().getVideoPlayInfo().videoTime = j3;
                            this.f279829b.a().getVideoPlayInfo().validVideoTime = j3;
                        }
                    }
                    r0(this.f279829b.a(), false, false);
                    VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
                    videoPlayInfoHolder.totalDurationMills = j3;
                    videoPlayInfoHolder.totalDurationSec = (int) Math.round((j3 * 1.0d) / 1000.0d);
                    this.R.onVideoPlayProgressUpdate(this.f279829b.f279984d);
                    w1(this.f279829b.a());
                    DescTextView descTextView = a16.mTimeview;
                    if (descTextView != null && descTextView.getVisibility() != 8) {
                        long j16 = this.f279829b.f279984d.totalDurationMills - ((int) r1.currentPositionMills);
                        final String shownTimeFromNumeric = FeedVideoEnv.getShownTimeFromNumeric(j16);
                        if (j16 < 0) {
                            shownTimeFromNumeric = FeedVideoEnv.getShownTimeFromNumeric(0L);
                        } else if (!TextUtils.isEmpty(this.f279851x) && this.f279851x.equals(shownTimeFromNumeric)) {
                            shownTimeFromNumeric = FeedVideoEnv.getShownTimeFromNumeric(Math.max(0L, j16 - 500));
                        } else if (j16 == 0) {
                            final String shownTimeFromNumeric2 = FeedVideoEnv.getShownTimeFromNumeric(this.f279829b.f279984d.totalDurationMills);
                            this.f279851x = shownTimeFromNumeric2;
                            PlayerUtils.log(3, this.f279828a, "remain mills = " + j16 + ",timetext=" + shownTimeFromNumeric);
                            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    DescTextView descTextView2;
                                    BaseVideo baseVideo = a16;
                                    if (baseVideo == null || (descTextView2 = baseVideo.mTimeview) == null) {
                                        return;
                                    }
                                    descTextView2.setText(shownTimeFromNumeric2);
                                }
                            });
                            Message obtainMessage2 = obtainMessage();
                            obtainMessage2.what = 40;
                            sendMessageDelayed(obtainMessage2, 1000L);
                            return;
                        }
                        this.f279851x = shownTimeFromNumeric;
                        PlayerUtils.log(3, this.f279828a, "remain mills = " + j16 + ",timetext=" + shownTimeFromNumeric);
                        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.9
                            @Override // java.lang.Runnable
                            public void run() {
                                DescTextView descTextView2;
                                BaseVideo baseVideo = a16;
                                if (baseVideo == null || (descTextView2 = baseVideo.mTimeview) == null) {
                                    return;
                                }
                                descTextView2.setText(shownTimeFromNumeric);
                            }
                        });
                        long j17 = this.f279829b.f279984d.currentPositionMills;
                        if (j17 <= 4000 && j17 >= 3000) {
                            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.ManagerHandler.10
                                @Override // java.lang.Runnable
                                public void run() {
                                    t.d(a16.mTimeview, 0.5f);
                                    t.d(a16.mPlayCountView, 0.5f);
                                    t.d(a16.mSoundLinesLayout, 0.5f);
                                }
                            });
                        }
                    }
                    Message obtainMessage3 = obtainMessage();
                    obtainMessage3.what = 40;
                    sendMessageDelayed(obtainMessage3, 1000L);
                    return;
                }
                PlayerUtils.log(4, this.f279828a, "get isPlaying time out or false");
                return;
            }
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleRefreshTime] mPlayer == null || mPlayer.get() == null.");
    }

    private void r(VideoPlayInfo videoPlayInfo) {
        SegmentVideoInfo.StreamInfo D = D(videoPlayInfo);
        if (D != null && D.getSegment(0) != null) {
            SegmentVideoInfo.SegmentInfo segment = D.getSegment(0);
            String str = segment.url;
            CachedMediaPlayer cachedMediaPlayer = this.I;
            if (cachedMediaPlayer != null && cachedMediaPlayer.g() == 6) {
                if (segment.duration > 0) {
                    com.tencent.mobileqq.qzoneplayer.player.d.b().d(D, segment.duration, this.f279840m);
                    return;
                } else {
                    com.tencent.mobileqq.qzoneplayer.player.d.b().c(D, this.f279839l);
                    return;
                }
            }
            VideoManager.getInstance().preload(str, this.f279839l, segment.duration, this.f279840m, videoPlayInfo.isVerticalVideo, T);
            PlayerUtils.log(4, this.f279828a, "preload_log \u9884\u52a0\u8f7d doPreloadNextVideoData preload segmentUrl=" + str);
            return;
        }
        PlayerUtils.log(5, this.f279828a, "doPreloadNextVideoData getStreamsToPreload returns null");
    }

    private void s0() {
        this.f279829b.f279995o = true;
        removeCallbacksAndMessages(null);
        removeMessages(10);
        removeMessages(13);
        removeMessages(14);
        removeMessages(15);
        y1();
        removeMessages(26);
        n();
        removeMessages(40);
        removeMessages(41);
        removeMessages(50);
        removeMessages(60);
        removeMessages(61);
        removeMessages(70);
        removeMessages(80);
        removeMessages(82);
        removeMessages(81);
        removeMessages(90);
        removeMessages(100);
        removeMessages(101);
        removeMessages(102);
        removeMessages(103);
        removeMessages(200);
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null && this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RELEASE)) {
            this.I.d().release();
        }
        this.f279830c.release();
        this.f279852y.quit();
    }

    private void t0() {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleResumeVideo. playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        if (eVar.f279986f != 3) {
            PlayerUtils.log(4, this.f279828a, "video_state=" + this.f279829b.f279986f);
            return;
        }
        if (eVar.a() != null && this.f279829b.a().getState() == 5) {
            com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
            eVar2.f279986f = 1;
            removeMessages(50, eVar2.a());
            com.tencent.mobileqq.qzoneplayer.video.e eVar3 = this.f279829b;
            if (eVar3.f279989i) {
                removeMessages(41);
                this.f279829b.a().isTimeViewVisible(true);
                B0();
                if (this.f279829b.a() != null) {
                    this.f279829b.a().setState(3);
                    this.f279829b.a().updateWithoutDelay(false);
                }
                sendEmptyMessageDelayed(81, 3000L);
                return;
            }
            eVar3.a().setState(2);
            this.f279829b.a().startLoadingLight();
            this.f279829b.f279986f = 1;
            return;
        }
        PlayerUtils.log(4, this.f279828a, "playingVideo is null or not paused.");
    }

    private void t1() {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            String currentProxySegmentUrl = this.I.d().getCurrentProxySegmentUrl();
            if (currentProxySegmentUrl != null) {
                String videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(currentProxySegmentUrl);
                this.f279829b.f279985e = videoUuidFromVideoUrl;
                if (!TextUtils.isEmpty(videoUuidFromVideoUrl)) {
                    PlayerUtils.log(4, this.f279828a, "video datasource uuid=" + videoUuidFromVideoUrl);
                    k(videoUuidFromVideoUrl);
                } else {
                    PlayerUtils.log(5, this.f279828a, "video datasource uuid is null");
                }
                if (PlayerConfig.g().getVideoReporter() != null) {
                    PlayerConfig.g().getVideoReporter().setVideoUuid(videoUuidFromVideoUrl);
                    PlayerConfig.g().getVideoReporter().setVideoResolution(videoUuidFromVideoUrl, this.f279829b.a().getVideoPlayInfo().width, this.f279829b.a().getVideoPlayInfo().height);
                    com.tencent.mobileqq.qzoneplayer.videosource.b.b().setRemainTime(videoUuidFromVideoUrl, 1);
                    SegmentVideoInfo.StreamInfo streamInfo = this.f279829b.f279991k;
                    boolean z16 = streamInfo != null && (streamInfo.getDecoderTypeSuggest() == VideoDecoderType.DecoderType.H265_HW || this.f279829b.f279991k.getDecoderTypeSuggest() == VideoDecoderType.DecoderType.H265_SW);
                    SegmentVideoInfo.StreamInfo streamInfo2 = this.f279829b.f279991k;
                    boolean z17 = streamInfo2 != null && streamInfo2.getCount() > 0 && PlayerUtils.isHLSStream(this.f279829b.f279991k.getSegment(0).url);
                    if (z16) {
                        if (this.f279829b.f279991k.getCount() > 0) {
                            PlayerConfig.g().getVideoReporter().setExtraData(videoUuidFromVideoUrl, "ExtraDataKeyH265StreamInfo", this.f279829b.f279991k.getSegment(0).url);
                        }
                    } else if (z17) {
                        if (this.f279829b.f279991k.getCount() > 0) {
                            PlayerConfig.g().getVideoReporter().setExtraData(videoUuidFromVideoUrl, "ExtraDataKeyHLSStreamInfo", this.f279829b.f279991k.getSegment(0).url);
                        }
                    } else {
                        SegmentVideoInfo.StreamInfo streamInfo3 = this.f279829b.f279991k;
                        if (streamInfo3 != null && streamInfo3.getCount() > 0) {
                            PlayerConfig.g().getVideoReporter().setExtraData(videoUuidFromVideoUrl, "ExtraDataKeyOtherStreamInfo", this.f279829b.f279991k.getSegment(0).url);
                        } else {
                            PlayerConfig.g().getVideoReporter().setExtraData(videoUuidFromVideoUrl, "ExtraDataKeyNoStreamInfo", "");
                        }
                    }
                    PlayerConfig.g().getVideoReporter().setExtraData(videoUuidFromVideoUrl, "ExtraDataKeyVideoRate", String.valueOf(w()));
                    return;
                }
                return;
            }
            PlayerUtils.log(5, this.f279828a, "videoUri is null");
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[prepareVideoReport] mPlayer == null || mPlayer.get() == null.");
    }

    private void u1() {
        ArrayList<VideoRequest> activeVideoRequest = L().getActiveVideoRequest();
        if (activeVideoRequest == null || activeVideoRequest.size() <= 0) {
            return;
        }
        Iterator<VideoRequest> it = activeVideoRequest.iterator();
        while (it.hasNext()) {
            PlayerUtils.log(4, this.f279828a, it.next().getSpeedInfo());
        }
    }

    private void v0(VideoPlayInfo videoPlayInfo) {
        long j3;
        long j16;
        VideoPlayInfoHolder videoPlayInfoHolder;
        if (!c1()) {
            PlayerUtils.log(4, this.f279828a, "handleSchedulePreloadInfo preload has disabled");
            return;
        }
        if (videoPlayInfo.videoId != null) {
            if (this.f279835h.contains(videoPlayInfo)) {
                Iterator<VideoPlayInfo> it = this.f279835h.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(videoPlayInfo)) {
                        it.remove();
                    }
                }
            }
            this.f279835h.add(videoPlayInfo);
            if (FeedVideoEnv.externalFunc.isDebugVersion()) {
                StringBuilder sb5 = new StringBuilder();
                if (this.f279835h.contains(videoPlayInfo)) {
                    Iterator<VideoPlayInfo> it5 = this.f279835h.iterator();
                    while (it5.hasNext()) {
                        sb5.append("->" + it5.next().itemPosition);
                    }
                }
                PlayerUtils.log(4, this.f279828a, "mpCache preloadQueueDetail " + ((Object) sb5));
            }
            PlayerUtils.log(4, this.f279828a, "mpCache schedulePreload vid=" + videoPlayInfo.videoId + " mPreloadMediaPlayerQueue.size " + this.f279835h.size());
            int u16 = u();
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            if (eVar == null || (videoPlayInfoHolder = eVar.f279984d) == null) {
                j3 = 0;
                j16 = 0;
            } else {
                long j17 = videoPlayInfoHolder.totalDurationMills;
                j3 = videoPlayInfoHolder.currentPositionMills;
                j16 = j17;
            }
            if (u16 > this.f279834g && !this.K && c1() && s1()) {
                PlayerUtils.log(4, this.f279828a, "mpCache current video buffer percent" + u16 + " > " + this.f279834g + " preloadPasterVideoAdv");
                return;
            }
            if (!this.K && c1() && q1(j16, u16, j3)) {
                r1(true);
                return;
            }
            PlayerUtils.log(4, this.f279828a, "mpCache currentBufferingPercent " + u16);
            return;
        }
        PlayerUtils.log(4, this.f279828a, "mpCache schedulePreload videoPlayInfo is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(SegmentVideoInfo.StreamInfo streamInfo, BaseVideo baseVideo, boolean z16) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(5, this.f279828a, "surface is ready!");
            if (baseVideo.getVideoPlayInfo() == null) {
                PlayerUtils.log(6, this.f279828a, "handlePlayVideo:autoVideo.mVideoPlayInfo is null");
                return;
            }
            int y16 = !baseVideo.getVideoPlayInfo().isNotRecordProgress ? y(baseVideo.getVideoPlayInfo().videoId) : 0;
            if (baseVideo.getSegmentVideoInfo() != null && baseVideo.getSegmentVideoInfo().isValid()) {
                if (this.f279829b.a() != null) {
                    com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
                    if (eVar.f279986f != 2 && eVar.a().getState() != 2) {
                        com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
                        eVar2.f279986f = 2;
                        eVar2.a().setShowCoverImage(true);
                        this.f279829b.a().setState(2);
                        this.f279829b.a().startLoadingLight();
                    }
                }
                this.f279829b.f279984d = new VideoPlayInfoHolder();
                com.tencent.mobileqq.qzoneplayer.video.e eVar3 = this.f279829b;
                eVar3.f279984d.livePlayDurationMills = 0L;
                eVar3.f279989i = false;
                eVar3.f279990j = false;
                G1(streamInfo, baseVideo, z16);
                if (this.C && !t.a(streamInfo)) {
                    baseVideo.videoUIStop();
                    com.tencent.mobileqq.qzoneplayer.video.e eVar4 = this.f279829b;
                    eVar4.f279986f = 0;
                    eVar4.d(null);
                    PlayerUtils.log(6, this.f279828a + U, "hasStarted=false pos 5,mPlayingVideo==null,positon:51");
                }
                this.K = false;
                sendMessageDelayed(obtainMessage(41, baseVideo), 60000L);
                PlayerUtils.log(4, this.f279828a, "handlePlayVideo. \n playingVideo=" + PlayerUtils.toString(this.f279829b.a()) + "\n seekPos=" + y16);
                baseVideo.setTimeMap(streamInfo);
                com.tencent.mobileqq.qzoneplayer.video.c cVar = new com.tencent.mobileqq.qzoneplayer.video.c();
                cVar.f279972a = this.I;
                cVar.f279973b = baseVideo;
                cVar.f279974c = streamInfo;
                cVar.f279976e = y16;
                cVar.f279977f = true;
                removeMessages(101);
                sendMessage(obtainMessage(101, cVar));
                return;
            }
            PlayerUtils.log(6, this.f279828a, "autoVideo.segmentVideoInfo is invalid");
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[readyPlay] mPlayer == null || mPlayer.get() == null.");
    }

    private int w() {
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        if (eVar == null || eVar.a() == null || this.f279829b.a().getVideoPlayInfo() == null || this.f279829b.a().getVideoPlayInfo().segmentVideoInfo == null || this.f279829b.a().getVideoPlayInfo().segmentVideoInfo.getCurrentStreamInfo() == null) {
            return 0;
        }
        return this.f279829b.a().getVideoPlayInfo().segmentVideoInfo.getCurrentStreamInfo().streamType;
    }

    private void w0(int i3) {
        if (this.f279829b.a() == null) {
            return;
        }
        if (!this.f279829b.a().getVideoPlayInfo().allowSeek) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleSeek. disabled seekPos=" + i3);
            this.f279829b.a().setState(3);
            return;
        }
        PlayerUtils.log(4, this.f279828a, "-------------------- handleSeek. seekPos=" + i3);
        this.A = true;
        this.I.d().seekTo((long) i3);
    }

    private void w1(BaseVideo baseVideo) {
        if (FeedVideoEnv.externalFunc.isDebugVersion()) {
            CachedMediaPlayer cachedMediaPlayer = this.I;
            if (cachedMediaPlayer != null && (cachedMediaPlayer.d().getInternalMediaPlayer() instanceof com.tencent.mobileqq.qzoneplayer.player.c)) {
                int hudOrderBySubject = baseVideo.getHudOrderBySubject("\u771f\u5b9e\u7801\u7387");
                com.tencent.mobileqq.qzoneplayer.player.c cVar = (com.tencent.mobileqq.qzoneplayer.player.c) this.I.d().getInternalMediaPlayer();
                baseVideo.updateHudText(hudOrderBySubject, "\u771f\u5b9e\u7801\u7387", ((cVar.y() / 8) / 1024) + "KBps", true);
                baseVideo.updateHudText(baseVideo.getHudOrderBySubject("\u4e0b\u8f7d\u901f\u5ea6"), "\u4e0b\u8f7d\u901f\u5ea6", cVar.v() + "KBps", true);
                return;
            }
            int hudOrderBySubject2 = baseVideo.getHudOrderBySubject("\u4e0b\u8f7dID");
            if (hudOrderBySubject2 != -1) {
                String b16 = this.f279829b.b();
                baseVideo.updateHudText(hudOrderBySubject2, "\u4e0b\u8f7dID", b16 + ">" + UuidPlayIdMap.getPlayIdListByUuid(b16), true);
            }
            int hudOrderBySubject3 = baseVideo.getHudOrderBySubject("\u5e26\u5bbd\u4f30\u8ba1");
            if (hudOrderBySubject3 != -1) {
                baseVideo.updateHudText(hudOrderBySubject3, "\u5e26\u5bbd\u4f30\u8ba1", OskFile.byteCountToDisplaySize(VideoManager.getInstance().getDownloadBitrate() / 8) + "", true);
            }
            int hudOrderBySubject4 = baseVideo.getHudOrderBySubject("\u771f\u5b9e\u7801\u7387");
            if (hudOrderBySubject4 != -1) {
                m mVar = this.M;
                if (mVar != null && mVar.f279891c == -1) {
                    mVar.f279891c = G();
                }
                baseVideo.updateHudText(hudOrderBySubject4, "\u771f\u5b9e\u7801\u7387", t(this.M == null ? 0L : r1.f279891c), true);
            }
            baseVideo.refreshHudText();
        }
    }

    private int x() {
        int i3 = 0;
        if (!TextUtils.isEmpty(E())) {
            ArrayList<VideoRequest> videoRequestByUuid = L().getVideoRequestByUuid(E());
            if (videoRequestByUuid != null && videoRequestByUuid.size() > 0) {
                Iterator<VideoRequest> it = videoRequestByUuid.iterator();
                while (it.hasNext()) {
                    VideoRequest next = it.next();
                    if (!this.M.f279892d.contains(next)) {
                        this.M.f279892d.add(next);
                    }
                }
            }
            Iterator<VideoRequest> it5 = this.M.f279892d.iterator();
            while (it5.hasNext()) {
                i3 += it5.next().getDownloadedBytes();
            }
        }
        return i3;
    }

    private void x0(BaseVideo baseVideo, Exception exc) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            FeedVideoEnv.externalFunc.reportVideoSuccessRate(false, K(baseVideo, 2220001, 0));
            PlayerUtils.log(6, this.f279828a, "Play Video IOException:" + PlayerUtils.getPrintableStackTrace(exc));
            FeedVideoEnv.externalFunc.getVideoLoader().clearCacheByInfo(baseVideo.getSegmentVideoInfo());
            PlayerUtils.log(6, this.f279828a, "Play Video IOException, remove video cache first segment source url" + this.I.d().getCurrentSegmentUrl());
            baseVideo.videoUIStop();
            a0(new b(exc));
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleSetDataSourceException] mPlayer == null || mPlayer.get() == null.");
    }

    private void x1(BaseVideo baseVideo) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            this.I.d().setOnLoopStartListener(this.B);
            this.I.d().setOnPreparedListener(this.B);
            this.I.d().setOnBufferingUpdateListener(this.B);
            this.I.d().setOnErrorListener(this.B);
            this.I.d().setOnCompletionListener(this.B);
            this.I.d().setOnInfoListener(this.B);
            this.I.d().setOnSeekCompleteListener(this.B);
            this.I.d().setWakeMode(FeedVideoEnv.getApplicationContext(), 10);
            Pair<Integer, Integer> e16 = this.I.e();
            if (e16 != null) {
                baseVideo.onVideoSizeChanged(((Integer) e16.first).intValue(), ((Integer) e16.second).intValue());
                return;
            } else {
                this.I.d().setOnVideoSizeChangedListener(new a(baseVideo));
                return;
            }
        }
        PlayerUtils.log(2, this.f279828a + U, "[registerMediaPlayerListeners] mPlayer == null || mPlayer.get() == null.");
    }

    private int y(String str) {
        int i3;
        VideoPlayInfoHolder videoProgressRecord = AutoVideoProgressRecorder.getInstance().getVideoProgressRecord(str);
        if (videoProgressRecord != null) {
            long j3 = videoProgressRecord.currentPositionMills;
            if (j3 > 0 && j3 <= videoProgressRecord.totalDurationMills) {
                i3 = (int) j3;
                PlayerUtils.log(4, this.f279828a, "getLastVideoPlayPos videoId=" + str + ", seekPosExpected=" + i3);
                return i3;
            }
        }
        i3 = 0;
        PlayerUtils.log(4, this.f279828a, "getLastVideoPlayPos videoId=" + str + ", seekPosExpected=" + i3);
        return i3;
    }

    private void y0(boolean z16) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer == null || cachedMediaPlayer.d() == null || !this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETLOOPING)) {
            return;
        }
        PlayerUtils.log(4, this.f279828a, "handleSetLooping: " + z16);
        this.I.d().setLooping(z16);
    }

    private void z0(float f16) {
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer == null || cachedMediaPlayer.d() == null || this.I.g() != 4) {
            return;
        }
        ((IExo2MediaPlayer) this.I.d().getInternalMediaPlayer()).setRate(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(String str) {
        com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
        eVar.f279986f = 0;
        eVar.f279988h = false;
        eVar.f279989i = false;
        PlayerUtils.log(4, this.f279828a, "hasStarted=false pos 1");
        ((AudioManager) FeedVideoEnv.getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.B);
        if (!TextUtils.isEmpty(str) && L() != null) {
            L().cancelVideoRequestByUuid(str);
        }
        removeMessages(30);
        removeMessages(37);
        removeMessages(31);
        removeMessages(32);
        removeMessages(36);
        removeMessages(35);
        removeMessages(34);
        removeMessages(33);
    }

    public CachedMediaPlayer A() {
        return this.I;
    }

    String C() {
        if ((this.f279829b.a() != null && this.f279829b.a().getVideoPlayInfo() != null && this.f279829b.a().getVideoPlayInfo().videoFeedsType == 1) || TextUtils.equals(v(), "BannerAutoVideoView")) {
            return IVideoReporter.SALT_LIVEVIDEO;
        }
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc == null || feedVideoExternalFunc.getRunningEnv() != FeedVideoEnv.RunningEnv.JIEHE_LIVE) {
            return null;
        }
        return IVideoReporter.SALT_LIVEVIDEO;
    }

    public String E() {
        return this.f279829b.b();
    }

    public com.tencent.mobileqq.qzoneplayer.video.d H(BaseVideo baseVideo) {
        PlayerUtils.log(4, this.f279828a, "-------------------- handleOnFullScreenIdle. playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (baseVideo != null && baseVideo.getState() == 0) {
            baseVideo = null;
        }
        if (baseVideo != null && baseVideo.getVideoPlayInfo() != null && baseVideo.getVideoPlayInfo().isInvalidState()) {
            PlayerUtils.log(4, this.f279828a, "videoNeedPlay InvalidState");
            return com.tencent.mobileqq.qzoneplayer.video.d.a();
        }
        if (baseVideo != null && !baseVideo.isHardwareAccelerated()) {
            PlayerUtils.log(5, this.f279828a, "videoNeedPlay " + baseVideo + " is hardware accelerated? " + baseVideo.isHardwareAccelerated());
            return com.tencent.mobileqq.qzoneplayer.video.d.a();
        }
        removeMessages(41);
        return com.tencent.mobileqq.qzoneplayer.video.d.b(baseVideo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00be, code lost:
    
        if (com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.y(r7) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e2, code lost:
    
        if (com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.y(r3) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f2, code lost:
    
        if (com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.y(r7) == false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mobileqq.qzoneplayer.video.d I(List<? extends BaseVideo> list) {
        BaseVideo baseVideo;
        PlayerUtils.log(4, this.f279828a, "-------------------- handleOnListIdle.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        int size = list.size();
        BaseVideo baseVideo2 = null;
        if (size <= 0) {
            this.f279829b.f279991k = null;
            PlayerUtils.log(6, this.f279828a + U, "mStreamInfo==null,positon:3");
            this.f279829b.f279986f = 0;
        } else {
            BaseVideo baseVideo3 = list.get(size - 1);
            if (size <= 2 && BaseVideoManager.z(baseVideo3)) {
                baseVideo = N0(list);
            } else if (size % 2 != 0) {
                baseVideo = list.get(size / 2);
                if (this.f279829b.a() != null) {
                }
            } else {
                int i3 = size / 2;
                BaseVideo baseVideo4 = list.get(i3 - 1);
                baseVideo = list.get(i3);
                if (this.f279829b.a() != null && baseVideo4 == this.f279829b.a()) {
                    if (!BaseVideoManager.A(baseVideo4) || BaseVideoManager.y(baseVideo)) {
                    }
                    baseVideo = baseVideo4;
                } else if (this.f279829b.a() != null && baseVideo == this.f279829b.a()) {
                    if (!BaseVideoManager.A(baseVideo) || BaseVideoManager.y(baseVideo4)) {
                    }
                } else {
                    baseVideo = B(baseVideo4, baseVideo);
                    if (baseVideo != null) {
                    }
                }
            }
            if (!k1() && !(baseVideo instanceof WindowPlayVideo)) {
                PlayerUtils.log(4, this.f279828a, "atWindowPlayMode");
                return com.tencent.mobileqq.qzoneplayer.video.d.a();
            }
            if (baseVideo == null && this.f279829b.a() == baseVideo) {
                PlayerUtils.log(4, this.f279828a, "videoNeedPlay SameVideoObject");
                return com.tencent.mobileqq.qzoneplayer.video.d.a();
            }
            if (baseVideo == null && !baseVideo.isHardwareAccelerated()) {
                PlayerUtils.log(5, this.f279828a, "videoNeedPlay " + baseVideo + " is hardware accelerated? " + baseVideo.isHardwareAccelerated());
                return com.tencent.mobileqq.qzoneplayer.video.d.a();
            }
            PlayerUtils.log(4, this.f279828a, "onListIdle managerState.mPlayingVideo=" + this.f279829b.a() + ",videoNeedPlay=" + baseVideo);
            if (i1(baseVideo)) {
                baseVideo2 = baseVideo;
            } else {
                PlayerUtils.log(5, this.f279828a, "isVideoFeedNotNeedPlay is true! videoNeedPlay is null");
            }
            return com.tencent.mobileqq.qzoneplayer.video.d.b(baseVideo2);
        }
        baseVideo = null;
        if (!k1()) {
        }
        if (baseVideo == null) {
        }
        if (baseVideo == null) {
        }
        PlayerUtils.log(4, this.f279828a, "onListIdle managerState.mPlayingVideo=" + this.f279829b.a() + ",videoNeedPlay=" + baseVideo);
        if (i1(baseVideo)) {
        }
        return com.tencent.mobileqq.qzoneplayer.video.d.b(baseVideo2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.mobileqq.qzoneplayer.video.d J(List<? extends BaseVideo> list, boolean z16) {
        BaseVideo baseVideo;
        PlayerUtils.log(4, this.f279828a, "-------------------- handleOnListIdleSingleVideo.current playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (list.size() <= 0) {
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            baseVideo = null;
            eVar.f279991k = null;
            eVar.f279986f = 0;
            PlayerUtils.log(6, this.f279828a + U, "mStreamInfo==null,positon:4");
        } else {
            baseVideo = list.get(0);
        }
        if (baseVideo != null && baseVideo.getState() == 0) {
            PlayerUtils.log(4, this.f279828a, "videoNeedPlay " + baseVideo + ",state=" + baseVideo.getState() + ", recycled");
            return com.tencent.mobileqq.qzoneplayer.video.d.a();
        }
        if (k1() && !(baseVideo instanceof WindowPlayVideo)) {
            PlayerUtils.log(4, this.f279828a, "atWindowPlayMode");
            return com.tencent.mobileqq.qzoneplayer.video.d.a();
        }
        if (baseVideo != null && this.f279829b.a() == baseVideo) {
            PlayerUtils.log(4, this.f279828a, "videoNeedPlay SameVideoObject videoNeedPlay=" + baseVideo);
            return com.tencent.mobileqq.qzoneplayer.video.d.a();
        }
        if (baseVideo != null && !baseVideo.isHardwareAccelerated() && !z16) {
            PlayerUtils.log(5, this.f279828a, "videoNeedPlay " + baseVideo + " is hardware accelerated? " + baseVideo.isHardwareAccelerated());
            return com.tencent.mobileqq.qzoneplayer.video.d.a();
        }
        if (baseVideo != null && baseVideo.getVideoPlayInfo() != null && baseVideo.getVideoPlayInfo().isInvalidState()) {
            PlayerUtils.log(6, this.f279828a, "videoNeedPlay InvalidState");
            return com.tencent.mobileqq.qzoneplayer.video.d.a();
        }
        removeMessages(41);
        return com.tencent.mobileqq.qzoneplayer.video.d.b(baseVideo);
    }

    public void M1(boolean z16) {
        this.H = z16;
    }

    public int N() {
        return this.f279829b.f279986f;
    }

    public void N1(BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener) {
        this.f279848u = new WeakReference<>(videoPlayInfoListener);
    }

    public boolean P1() {
        if (this.f279829b.a() != null) {
            return this.f279829b.a().shouldResponseToAudioFocusChange();
        }
        return true;
    }

    public void R1(String str, BaseVideo baseVideo) {
        VideoPlayInfo videoPlayInfo;
        SegmentVideoInfo segmentVideoInfo;
        PlayerUtils.log(4, this.f279828a, "tryUnlockGetSafeUrl safeUrlLockDebug entry=" + str);
        if (baseVideo != null && (videoPlayInfo = baseVideo.getVideoPlayInfo()) != null && videoPlayInfo.orgwebsite == 1 && (segmentVideoInfo = videoPlayInfo.segmentVideoInfo) != null && segmentVideoInfo.getDefaultUrl() != null) {
            PlayerUtils.log(4, this.f279828a, "tryUnlockGetSafeUrl safeUrlLockDebug entry=" + str + ", url=" + videoPlayInfo.segmentVideoInfo.getDefaultUrl());
            if (videoPlayInfo.segmentVideoInfo.getDefaultUrl().equals(this.f279849v)) {
                PlayerUtils.log(4, this.f279828a, "tryUnlockGetSafeUrl  safeUrlLockDebug should not unlock entry=" + str + ", CurrentGetSafeUrlOriginUrl=" + this.f279849v);
                return;
            }
        }
        if (TextUtils.isEmpty(this.f279849v)) {
            return;
        }
        PlayerUtils.log(4, this.f279828a, "tryUnlockGetSafeUrl  safeUrlLockDebug  entry=" + str + ", try unlock url=" + this.f279849v);
        s.g().f(this.f279849v);
    }

    public boolean X0() {
        return this.f279850w;
    }

    public boolean Z0(BaseVideo baseVideo) {
        return this.f279829b.a() == baseVideo;
    }

    public boolean a1() {
        return this.H;
    }

    public boolean b1() {
        return this.f279829b.f279992l;
    }

    public boolean c1() {
        return !this.f279836i && (Y0() || d1());
    }

    public boolean e1() {
        return this.f279829b.f279989i;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (f1()) {
            PlayerUtils.log(5, this.f279828a, "-------------------- mManagerHandler refuse to accept message, already released msg.what=" + message.what);
        } else {
            PlayerUtils.log(4, this.f279828a, "-------------------- mManagerHandler msg.what=" + message.what);
        }
        int i3 = message.what;
        if (i3 == 1) {
            p0(false, false);
            return;
        }
        if (i3 == 3) {
            n0((BaseVideo) message.obj);
            return;
        }
        if (i3 == 5) {
            a0(null);
            return;
        }
        if (i3 == 10) {
            k0((BaseVideo) message.obj);
            return;
        }
        if (i3 == 50) {
            M0((BaseVideo) message.obj, message.arg1);
            return;
        }
        if (i3 == 70) {
            com.tencent.mobileqq.qzoneplayer.video.c cVar = (com.tencent.mobileqq.qzoneplayer.video.c) message.obj;
            Y((String) cVar.f279972a, ((Integer) cVar.f279973b).intValue(), ((Long) cVar.f279974c).longValue(), ((Long) cVar.f279975d).longValue());
            return;
        }
        if (i3 == 90) {
            L0((com.tencent.mobileqq.qzoneplayer.video.e) message.obj);
            return;
        }
        if (i3 == 150) {
            J0();
            return;
        }
        if (i3 == 200) {
            s0();
            return;
        }
        if (i3 == 60) {
            W((BaseVideoManagerUtils.ChangeSurfaceHolder) message.obj, message.arg1);
            return;
        }
        if (i3 != 61) {
            switch (i3) {
                case 13:
                    com.tencent.mobileqq.qzoneplayer.video.c cVar2 = (com.tencent.mobileqq.qzoneplayer.video.c) message.obj;
                    l0((SegmentVideoInfo.StreamInfo) cVar2.f279972a, (BaseVideo) cVar2.f279973b, cVar2.f279977f);
                    return;
                case 14:
                    C0((BaseVideo) message.obj);
                    return;
                case 15:
                    E0((BaseVideo) message.obj);
                    return;
                default:
                    switch (i3) {
                        case 20:
                            t0();
                            return;
                        case 21:
                            G0((SegmentVideoInfo.StreamInfo) message.obj);
                            return;
                        case 22:
                            j0();
                            return;
                        case 23:
                            B0();
                            return;
                        case 24:
                            K0(message.arg1);
                            return;
                        case 25:
                            w0(message.arg1);
                            return;
                        case 26:
                            O0((BaseVideoCover.CoverWarnType) message.obj);
                            return;
                        case 27:
                            z0(((Float) message.obj).floatValue());
                            return;
                        case 28:
                            y0(((Boolean) message.obj).booleanValue());
                            return;
                        default:
                            switch (i3) {
                                case 30:
                                    g0((String) message.obj, message.arg1, message.arg2);
                                    return;
                                case 31:
                                    T((String) message.obj);
                                    return;
                                case 32:
                                    S((String) message.obj);
                                    return;
                                case 33:
                                    i0((String) message.obj);
                                    return;
                                case 34:
                                    h0((String) message.obj);
                                    return;
                                case 35:
                                    f0((String) message.obj);
                                    return;
                                case 36:
                                    e0((String) message.obj, message.arg1);
                                    return;
                                case 37:
                                    c0((String) message.obj, message.arg1, message.arg2);
                                    return;
                                case 38:
                                    b0((String) message.obj);
                                    return;
                                default:
                                    switch (i3) {
                                        case 40:
                                            q0();
                                            return;
                                        case 41:
                                            I0((BaseVideo) message.obj);
                                            return;
                                        case 42:
                                            P0();
                                            return;
                                        default:
                                            switch (i3) {
                                                case 80:
                                                    A0();
                                                    return;
                                                case 81:
                                                    R();
                                                    return;
                                                case 82:
                                                    Z();
                                                    return;
                                                default:
                                                    switch (i3) {
                                                        case 100:
                                                            o0();
                                                            return;
                                                        case 101:
                                                            com.tencent.mobileqq.qzoneplayer.video.c cVar3 = (com.tencent.mobileqq.qzoneplayer.video.c) message.obj;
                                                            X((CachedMediaPlayer) cVar3.f279972a, (BaseVideo) cVar3.f279973b, (SegmentVideoInfo.StreamInfo) cVar3.f279974c, cVar3.f279976e, cVar3.f279977f);
                                                            return;
                                                        case 102:
                                                            v0((VideoPlayInfo) message.obj);
                                                            return;
                                                        case 103:
                                                            q((VideoPlayInfo) message.obj);
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        U((BaseVideo) message.obj);
    }

    public boolean k1() {
        return this.f279829b.f279993m;
    }

    public void q(VideoPlayInfo videoPlayInfo) {
        r(videoPlayInfo);
    }

    public boolean s1() {
        VideoPlayInfo videoPlayInfo;
        boolean z16;
        Iterator<VideoPlayInfo> it = this.f279835h.iterator();
        while (true) {
            if (!it.hasNext()) {
                videoPlayInfo = null;
                z16 = false;
                break;
            }
            videoPlayInfo = it.next();
            if (videoPlayInfo.isPasterVideoAdv) {
                PlayerUtils.log(4, this.f279828a, "mpCache preloadPasterVideoAdv currently playing ,videoid=" + videoPlayInfo.videoId + JefsClass.INDEX_URL + videoPlayInfo.segmentVideoInfo.getDefaultUrl());
                r(videoPlayInfo);
                z16 = true;
                break;
            }
        }
        if (this.f279835h.isEmpty() || !z16 || videoPlayInfo == null) {
            return false;
        }
        this.f279835h.remove(videoPlayInfo);
        return true;
    }

    public int u() {
        return this.f279829b.f279994n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String v() {
        BaseVideo a16 = this.f279829b.a();
        if (a16 != null) {
            return a16.getClass().getSimpleName();
        }
        return null;
    }

    private static BaseVideo B(BaseVideo baseVideo, BaseVideo baseVideo2) {
        int[] iArr = new int[2];
        baseVideo.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        baseVideo2.getLocationOnScreen(iArr2);
        int screenHeight = (FeedVideoEnv.getScreenHeight() / 2) - 240;
        if (Math.abs(iArr[1] - screenHeight) > Math.abs(iArr2[1] - screenHeight)) {
            int i3 = iArr2[1];
            if (i3 >= 0 && i3 + (FeedVideoEnv.dp75 * 2) <= FeedVideoEnv.getScreenHeight()) {
                return baseVideo2;
            }
        } else {
            int i16 = iArr[1];
            if (i16 >= 0 && i16 + (FeedVideoEnv.dp75 * 2) <= FeedVideoEnv.getScreenHeight()) {
                return baseVideo;
            }
        }
        return null;
    }

    private void Q1() {
        K0(3);
        B0();
    }

    private void V0() {
        this.f279836i = true;
        String wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreloadConfig", "1,1:9");
        if (!TextUtils.isEmpty(wnsConfig)) {
            String[] split = wnsConfig.split(",");
            if (split.length >= 2) {
                this.f279838k = split[1];
                this.f279836i = Integer.parseInt(split[0]) == 0;
            }
        }
        this.f279837j = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreloadWhenFreeTrafficAnd4G", 1) == 1;
        String wnsConfig2 = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreloadTriggerConfig", "30,10,0,0");
        if (!TextUtils.isEmpty(wnsConfig2)) {
            String[] split2 = wnsConfig2.split(",");
            if (split2.length >= 4) {
                try {
                    this.f279831d = Integer.parseInt(split2[0]);
                    this.f279832e = Integer.parseInt(split2[1]);
                    this.f279834g = Integer.parseInt(split2[2]);
                    this.f279833f = Integer.parseInt(split2[3]);
                } catch (NumberFormatException unused) {
                    PlayerUtils.log(6, this.f279828a, "parsedPreloadConfig error " + wnsConfig2);
                }
            }
        }
        String wnsConfig3 = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreloadSizeConfig", "1048576,8000");
        if (!TextUtils.isEmpty(wnsConfig3)) {
            String[] split3 = wnsConfig3.split(",");
            if (split3.length >= 2) {
                try {
                    this.f279839l = Integer.valueOf(split3[0]).intValue();
                    this.f279840m = Integer.valueOf(split3[1]).intValue();
                } catch (NumberFormatException unused2) {
                    PlayerUtils.log(6, this.f279828a, "parsedPreloadMaxSizeConfig error " + wnsConfig3);
                }
            }
        }
        this.f279841n = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerPreloadCountConfig", 3);
        String wnsConfig4 = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoPlayerExtPreloadConfig", "1,1,5000");
        if (!TextUtils.isEmpty(wnsConfig4)) {
            String[] split4 = wnsConfig4.split(",");
            if (split4.length >= 3) {
                try {
                    r.b().c(Integer.valueOf(split4[0]).intValue() > 0, Integer.valueOf(split4[1]).intValue(), Integer.valueOf(split4[2]).intValue());
                } catch (NumberFormatException unused3) {
                    PlayerUtils.log(6, this.f279828a, "parsedPreloadMaxSizeConfig error " + wnsConfig3);
                }
            }
        }
        PlayerUtils.log(4, this.f279828a, "initPreloadConfig mPreloadNextVideoDisabled=" + this.f279836i + ",mPreloadBufferingPercentThreshold=" + this.f279831d + ",mPreloadRemainingTimeThreshold=" + this.f279832e + ",mPreloadVideoAdvBufferingPercent=" + this.f279834g + ",mPreloadVideoAdvRemainingTime=" + this.f279833f + ",mPreloadMaxSize=" + this.f279839l + ",mPreloadMs=" + this.f279840m);
    }

    private void W(BaseVideoManagerUtils.ChangeSurfaceHolder changeSurfaceHolder, int i3) {
        this.K = false;
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer == null || cachedMediaPlayer.d() == null || !this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETSURFACE) || !this.I.d().checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETSURFACE_TEXTURE)) {
            PlayerUtils.log(4, this.f279828a, "handleChangePlayerSurfaceToOtherSurface OP_SETSURFACE is not allowed");
            return;
        }
        if (i3 > 5000) {
            F0(changeSurfaceHolder.newSurface, false, 1, -1);
            this.f279829b.d(null);
            PlayerUtils.log(6, this.f279828a + U, "mPlayingVideo==null,positon:20");
            return;
        }
        if (!changeSurfaceHolder.newSurface.isSurfaceAvailable()) {
            changeSurfaceHolder.newSurface.startLayout();
            removeMessages(60, changeSurfaceHolder);
            sendMessageDelayed(Message.obtain(this, 60, i3 + 50, 0, changeSurfaceHolder), 50);
        } else {
            changeSurfaceHolder.changeSurfaceResult.isChangeSurfaceOccurred = true;
            if (hasMessages(40)) {
                a(200);
            }
            V(changeSurfaceHolder);
        }
    }

    private int F(BaseVideo baseVideo) {
        if (baseVideo == null || baseVideo.getVideoPlayInfo() == null) {
            return 3;
        }
        return baseVideo.getVideoPlayInfo().k() ? 1 : 0;
    }

    private void F1(long j3, long j16, long j17) {
        String str;
        if (PlayerConfig.g().getVideoReporter() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(AdMetricTag.RESPONSE_CODE, Long.valueOf(j17));
            hashMap.put("subRetCode", Long.valueOf(j3));
            hashMap.put("message", "(" + j17 + "," + j3 + ")");
            PlayerConfig.g().getVideoReporter().downloadResult("IgnoreVideoUUID", j16, hashMap);
            if (this.f279829b.a().getSegmentVideoInfo() != null && !TextUtils.isEmpty(this.f279829b.a().getSegmentVideoInfo().getDefaultUrl())) {
                str = this.f279829b.a().getSegmentVideoInfo().getDefaultUrl();
            } else {
                str = "";
            }
            PlayerConfig.g().getVideoReporter().startPlayVideo("", str, 0L, 0L, this.f279829b.a().isAutoPlay, "", 0, false, false, 0, false);
            if (PlayerUtils.isNetworkAvailable()) {
                DNSService dNSService = PlayerConfig.g().getDNSService();
                if (dNSService != null) {
                    if (!dNSService.isNetReachable()) {
                        PlayerConfig.g().getVideoReporter().failPlayVideo("IgnoreVideoUUID", -1000, PlayerUtils.getDownloadRetCode(9L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE), u(), C());
                        return;
                    } else {
                        PlayerConfig.g().getVideoReporter().failPlayVideo("IgnoreVideoUUID", -1100, j16, 0, C());
                        return;
                    }
                }
                PlayerConfig.g().getVideoReporter().failPlayVideo("IgnoreVideoUUID", -1100, j16, 0, C());
                return;
            }
            PlayerConfig.g().getVideoReporter().failPlayVideo("IgnoreVideoUUID", -1000, PlayerUtils.getDownloadRetCode(9L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE), u(), C());
        }
    }

    private void L1(q qVar) {
        int i3;
        if (qVar != null) {
            int i16 = qVar.f280019a;
            this.f279853z = i16 > 0 && (i3 = qVar.f280020b) > 0 && i16 != i3;
        }
    }

    private void O1(BaseVideo baseVideo) {
        Context context;
        int i3;
        if (baseVideo == null || baseVideo.getVideoPlayInfo() == null || baseVideo.getVideoPlayInfo().videoPlayInfoHolder == null || (context = baseVideo.getContext()) == null) {
            return;
        }
        String obj = context.toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        if (obj.contains(BaseVideo.VIDEO_PALY_SCENE_CONTEXT_FEED_DETAIL_STR) || obj.contains(BaseVideo.VIDEO_PALY_SCENE_CONTEXT_FEED_DETAIL_STR_QZONE) || obj.contains(BaseVideo.VIDEO_PALY_SCENE_CONTEXT_FEED_DETAIL_STR_QZONE_2)) {
            i3 = 2;
        } else if (obj.contains(BaseVideo.VIDEO_PALY_SCENE_CONTEXT_RECOMMEND_STR)) {
            i3 = 3;
        } else {
            i3 = (obj.contains(BaseVideo.VIDEO_PALY_SCENE_CONTEXT_FEED_STR) || obj.contains(BaseVideo.VIDEO_PALY_SCENE_CONTEXT_FEED_STR_QZONE)) ? 1 : 0;
        }
        if (baseVideo.getVideoPlayInfo() == null || TextUtils.isEmpty(baseVideo.getVideoPlayInfo().videoId) || i3 <= 0) {
            return;
        }
        String str = baseVideo.getVideoPlayInfo().videoId;
        q playVideoSceneRecord = AutoVideoProgressRecorder.getInstance().getPlayVideoSceneRecord(str);
        if (playVideoSceneRecord == null) {
            playVideoSceneRecord = new q();
        }
        playVideoSceneRecord.f280020b = playVideoSceneRecord.f280019a;
        playVideoSceneRecord.f280019a = i3;
        if (!baseVideo.getVideoPlayInfo().isNotRecordProgress) {
            AutoVideoProgressRecorder.getInstance().putPlayVideoSceneRecord(str, playVideoSceneRecord);
        }
        L1(playVideoSceneRecord);
    }

    private void Q(SegmentVideoInfo.StreamInfo streamInfo) {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (streamInfo == null || (arrayList = streamInfo.segmentInfos) == null) {
            return;
        }
        try {
            Iterator<SegmentVideoInfo.SegmentInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                SegmentVideoInfo.SegmentInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.url) && this.f279829b.a() != null) {
                    if (com.tencent.mobileqq.qzoneplayer.videosource.a.d().b(this.f279829b)) {
                        com.tencent.mobileqq.qzoneplayer.videosource.a.d().f(next.url, this.f279829b.a().getHttpRetryLogic());
                    } else {
                        FeedVideoEnv.externalFunc.getVideoLoader().addHttpRetryLogic(next.url, this.f279829b.a().getHttpRetryLogic());
                    }
                }
            }
        } catch (Exception e16) {
            PlayerUtils.log(6, this.f279828a, "handleAddVideoManagerListener exception: " + PlayerUtils.getPrintableStackTrace(e16));
        }
    }

    private void y1() {
        removeMessages(20);
        removeMessages(21);
        removeMessages(22);
        removeMessages(23);
        removeMessages(24);
        removeMessages(25);
    }

    public boolean f1() {
        return hasMessages(200) || this.f279829b.f279995o;
    }

    private void H1(VideoPlayInfo videoPlayInfo) {
        if (videoPlayInfo == null) {
            return;
        }
        String str = "2";
        String str2 = "1";
        if (videoPlayInfo.orgwebsite == 1) {
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
            if (videoPlayInfo.f()) {
                str = "1";
            }
            feedVideoExternalFunc.reportClick("37", "1", str, true);
            return;
        }
        if (videoPlayInfo.recomtype == 1) {
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc2 = FeedVideoEnv.externalFunc;
            if (!videoPlayInfo.f()) {
                str2 = "2";
            }
            feedVideoExternalFunc2.reportClick("37", "2", str2, true);
        }
    }

    private void X(CachedMediaPlayer cachedMediaPlayer, BaseVideo baseVideo, SegmentVideoInfo.StreamInfo streamInfo, int i3, boolean z16) {
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            if (cachedMediaPlayer.f() == CachedMediaPlayer.PrepareState.PREPARING) {
                d0(baseVideo, streamInfo, i3, z16);
                return;
            }
            PlayerUtils.log(4, this.f279828a, "PrepareState state here state " + cachedMediaPlayer.f());
            this.f279829b.f279992l = false;
            x1(baseVideo);
            this.f279829b.f279988h = true;
            if (cachedMediaPlayer.g() != 2) {
                PlayerUtils.log(4, this.f279828a, "islooping " + baseVideo.getVideoPlayInfo().g());
                cachedMediaPlayer.d().setLooping(baseVideo.getVideoPlayInfo().g());
            }
            if (baseVideo.getVideoPlayInfo() != null && !baseVideo.getVideoPlayInfo().isAdvMicro && i3 > 0) {
                PlayerUtils.log(4, this.f279828a, "handleCheckPlayVideo seekTo currentPositionMills expected:" + i3);
            }
            this.f279829b.f279994n = 0;
            PlayerUtils.log(4, this.f279828a, "setDataSource " + streamInfo.toString() + ", seekPosExpected=" + i3);
            VideoSpeedReport.g().end(VideoSpeedReport.POINT_VIDEO_LIST_IDLE);
            K1(cachedMediaPlayer, baseVideo, streamInfo, i3, z16);
            cachedMediaPlayer.d().setSurface(baseVideo.getSurface());
            cachedMediaPlayer.d().setScreenOnWhilePlaying(true);
            this.f279829b.f279986f = 1;
            this.A = false;
            PlayerUtils.log(4, this.f279828a, "handlePlayVideo:is in wifi.");
            removeMessages(50, baseVideo);
            PlayerUtils.log(4, this.f279828a, "handlePlayVideo:start prepareAsync.");
            VideoSpeedReport.ReportPoint reportPoint = VideoSpeedReport.POINT_VIDEO_PREPARE_ASYNC;
            VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint);
            VideoSpeedReport.g().start(reportPoint);
            if (z16 && PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().bufferingBegin(this.f279829b.f279985e, true);
            }
            try {
                int i16 = g.f279881a[cachedMediaPlayer.f().ordinal()];
                if (i16 == 1) {
                    cachedMediaPlayer.d().prepareAsync();
                    PlayerUtils.log(4, "[VideoRate]", "current video rate:" + streamInfo.streamType);
                } else if (i16 == 2) {
                    Exception a16 = cachedMediaPlayer.a();
                    if (a16 != null) {
                        PlayerUtils.log(4, this.f279828a, "mpCache throw cached other prepare exception");
                        throw a16;
                    }
                } else if (i16 != 3) {
                    PlayerUtils.log(6, this.f279828a, "mpCache impossible state to handle prepareAsync");
                } else {
                    PlayerUtils.log(4, this.f279828a, "mpCache skip to call prepareAsync, already prepared :)");
                    h0(this.f279829b.f279985e);
                }
            } catch (Exception e16) {
                m0(baseVideo, e16);
            }
            if (this.f279829b.f279997q > 0) {
                PlayerUtils.log(4, this.f279828a, "\u64ad\u653e\u5931\u8d25\u540e\u91cd\u8bd5\u6210\u529f");
                return;
            }
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleCheckPlayVideo] mPlayer == null || mPlayer.get() == null.");
    }

    private boolean i1(BaseVideo baseVideo) {
        if (baseVideo == null || (baseVideo.getVideoPlayInfo() != null && baseVideo.getVideoPlayInfo().isAdvMicro)) {
            return false;
        }
        if (baseVideo.getVideoPlayInfo() != null && baseVideo.getVideoPlayInfo().k() && !baseVideo.getVideoPlayInfo().g()) {
            PlayerUtils.log(5, this.f279828a, "isVideoFeedNotNeedPlay : isVideoAdv && isCircle && isFeedFirstComplete is" + baseVideo.getVideoPlayInfo().isFeedFirstComplete);
            return baseVideo.getVideoPlayInfo().isFeedFirstComplete;
        }
        if (baseVideo.getVideoPlayInfo() != null && baseVideo.getVideoPlayInfo().isInvalidState()) {
            PlayerUtils.log(5, this.f279828a, "isVideoFeedNotNeedPlay : isInvalidState");
            return true;
        }
        return false;
    }

    private boolean o1(BaseVideo baseVideo, long j3) {
        if (baseVideo != null && baseVideo.getVideoPlayInfo() != null) {
            int i3 = baseVideo.getVideoPlayInfo().playPositionA;
            int i16 = baseVideo.getVideoPlayInfo().playPositionB;
            CachedMediaPlayer cachedMediaPlayer = this.I;
            if (cachedMediaPlayer == null || i3 >= i16 || i16 > this.f279829b.f279984d.totalDurationSec || i3 < 0 || i16 <= 0 || j3 <= i16 * 1000) {
                return false;
            }
            cachedMediaPlayer.d().seekTo(i3 * 1000);
            try {
                this.I.d().start();
            } catch (IMediaPlayer.InternalOperationException e16) {
                e16.printStackTrace();
            }
            if (this.f279829b.f279988h && this.F > 0) {
                String videoUuidFromVideoUrl = PlayerUtils.getVideoUuidFromVideoUrl(this.I.d().getCurrentProxySegmentUrl());
                if (!TextUtils.isEmpty(videoUuidFromVideoUrl)) {
                    A1(videoUuidFromVideoUrl);
                    com.tencent.mobileqq.qzoneplayer.videosource.b.b().stopPlay(videoUuidFromVideoUrl);
                }
            }
            return true;
        }
        PlayerUtils.log(4, this.f279828a, "playDurationSuccess exception!videoview or videoplayinfo == null!");
        return true;
    }

    private void p1(VideoPlayInfo videoPlayInfo) {
        int i3;
        if (videoPlayInfo != null && videoPlayInfo.coverUrl != null) {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.extraProcessor = videoPlayInfo.processor;
            PictureUrl pictureUrl = videoPlayInfo.coverUrl;
            int z16 = z(videoPlayInfo);
            if (pictureUrl != null && (videoPlayInfo.width == 0 || videoPlayInfo.height == 0)) {
                int i16 = pictureUrl.width;
                if (i16 != 0 && (i3 = pictureUrl.height) != 0) {
                    obtain.clipWidth = i16;
                    obtain.clipHeight = i3;
                } else {
                    obtain.clipWidth = z16;
                    obtain.clipHeight = z16;
                }
            } else {
                obtain.clipWidth = videoPlayInfo.width;
                obtain.clipHeight = videoPlayInfo.height;
            }
            obtain.preferQuality = false;
            obtain.priority = false;
            obtain.extraProcessor = videoPlayInfo.processor;
            if (!TextUtils.isEmpty(videoPlayInfo.coverUrl.url)) {
                PlayerUtils.log(4, this.f279828a, "preloadcover url=" + videoPlayInfo.coverUrl.url + "[" + obtain.clipWidth + "," + obtain.clipHeight + "]");
                ImageLoader.getInstance(null).loadImage(videoPlayInfo.coverUrl.url, new i(), obtain);
                return;
            }
            PlayerUtils.log(4, this.f279828a, "preload_log preloadcover cover url is empty");
            return;
        }
        PlayerUtils.log(4, this.f279828a, "preload_log videoInfo is empty");
    }

    private void s(ArrayList<VideoPlayInfo> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            int i3 = this.f279841n;
            if (size > i3) {
                size = i3;
            }
            for (int i16 = 0; i16 < size; i16++) {
                VideoPlayInfo videoPlayInfo = arrayList.get(i16);
                SegmentVideoInfo.StreamInfo D = D(videoPlayInfo);
                if (D != null) {
                    r(videoPlayInfo);
                    if (videoPlayInfo.isVerticalVideo) {
                        p1(videoPlayInfo);
                    }
                    PlayerUtils.log(4, this.f279828a, "mpCachepreloadTriggered=true preload_log handlePreloadNextVideo preload next playing \u9884\u52a0\u8f7d\u7801\u7387\uff1a" + D.streamType + ", mPos=" + videoPlayInfo.itemPosition + ", url=" + videoPlayInfo.segmentVideoInfo.getDefaultUrl());
                } else {
                    PlayerUtils.log(5, this.f279828a, "doPreloadNextVideoData getStreamsToPreload returns null");
                }
            }
            return;
        }
        PlayerUtils.log(5, this.f279828a, "doPreloadNextVideoData nextVideoPlayInfoList is empty");
    }

    private void G1(SegmentVideoInfo.StreamInfo streamInfo, BaseVideo baseVideo, boolean z16) {
        String str;
        if (PlayerConfig.g().getVideoReporter() != null) {
            VideoPlaybackReportInfo videoPlaybackReportInfo = new VideoPlaybackReportInfo();
            videoPlaybackReportInfo.f279932e = baseVideo.isAutoPlay;
            videoPlaybackReportInfo.f279934f = false;
            videoPlaybackReportInfo.f279935h = "1";
            videoPlaybackReportInfo.f279936i = "1";
            videoPlaybackReportInfo.F = "1";
            if (baseVideo.getVideoPlayInfo() != null) {
                videoPlaybackReportInfo.f279933e0 = baseVideo.getVideoPlayInfo().shield321VVReport;
                if (!TextUtils.isEmpty(baseVideo.getVideoPlayInfo().videoId)) {
                    videoPlaybackReportInfo.f279930d = baseVideo.getVideoPlayInfo().videoId;
                } else {
                    videoPlaybackReportInfo.f279930d = VideoPlaybackReportInfo.a(baseVideo.getSegmentVideoInfo().getDefaultUrl());
                }
                videoPlaybackReportInfo.f279937m = String.valueOf(baseVideo.getVideoPlayInfo().videoTime);
                videoPlaybackReportInfo.C = String.valueOf(baseVideo.getVideoPlayInfo().originVideoSize / 1024);
                videoPlaybackReportInfo.D = String.valueOf(baseVideo.getVideoPlayInfo().width);
                videoPlaybackReportInfo.E = String.valueOf(baseVideo.getVideoPlayInfo().height);
                videoPlaybackReportInfo.G = String.valueOf(baseVideo.getVideoPlayInfo().authorUin);
                videoPlaybackReportInfo.H = String.valueOf(baseVideo.getVideoPlayInfo().reposterUin);
                videoPlaybackReportInfo.J = String.valueOf(baseVideo.getVideoPlayInfo().writeFrom);
                videoPlaybackReportInfo.I = baseVideo.getVideoPlayInfo().cellId;
                videoPlaybackReportInfo.L = baseVideo.getVideoPlayInfo().j();
                if (!TextUtils.isEmpty(baseVideo.getVideoPlayInfo().videoPlayScene)) {
                    videoPlaybackReportInfo.f279935h = baseVideo.getVideoPlayInfo().videoPlayScene;
                } else if (baseVideo.getVideoPlayInfo().videoFeedType == 2) {
                    videoPlaybackReportInfo.f279935h = "3";
                }
                if (baseVideo instanceof WindowPlayVideo) {
                    videoPlaybackReportInfo.f279935h = "11";
                } else if (baseVideo instanceof FullScreenFeedAutoVideoFull) {
                    videoPlaybackReportInfo.f279935h = "8";
                } else if (baseVideo instanceof FeedAutoVideoFullCanvas) {
                    videoPlaybackReportInfo.f279935h = "6";
                }
                if (baseVideo.getVideoPlayInfo().isInFullScreenPlay) {
                    videoPlaybackReportInfo.f279935h = "25";
                    baseVideo.getVideoPlayInfo().isInFullScreenPlay = false;
                }
                if (!TextUtils.isEmpty(baseVideo.getVideoPlayInfo().videoSource)) {
                    videoPlaybackReportInfo.f279936i = baseVideo.getVideoPlayInfo().videoSource;
                }
                if (!TextUtils.isEmpty(baseVideo.getVideoPlayInfo().videoReportInfo)) {
                    videoPlaybackReportInfo.F = baseVideo.getVideoPlayInfo().videoReportInfo;
                }
                if (baseVideo.getVideoPlayInfo().h()) {
                    videoPlaybackReportInfo.M = true;
                    videoPlaybackReportInfo.N = baseVideo.getVideoPlayInfo().isMiniVideo;
                    videoPlaybackReportInfo.f279932e = baseVideo.getVideoPlayInfo().isAutoPlay;
                    videoPlaybackReportInfo.P = String.valueOf(baseVideo.getVideoPlayInfo().launcherUin);
                    videoPlaybackReportInfo.Q = baseVideo.getVideoPlayInfo().enterLivePagePosition;
                    videoPlaybackReportInfo.R = String.valueOf(baseVideo.getVideoPlayInfo().playId);
                    videoPlaybackReportInfo.S = String.valueOf(baseVideo.getVideoPlayInfo().feedsUrl);
                    videoPlaybackReportInfo.T = String.valueOf(baseVideo.getVideoPlayInfo().repostUin);
                    videoPlaybackReportInfo.U = String.valueOf(baseVideo.getVideoPlayInfo().videoPlaySource);
                    videoPlaybackReportInfo.V = String.valueOf(baseVideo.getVideoPlayInfo().liveUserType);
                    videoPlaybackReportInfo.W = String.valueOf(baseVideo.getVideoPlayInfo().liveState);
                    videoPlaybackReportInfo.X = String.valueOf(baseVideo.getVideoPlayInfo().livePage);
                    videoPlaybackReportInfo.Y = String.valueOf(baseVideo.getVideoPlayInfo().liveSource);
                    videoPlaybackReportInfo.f279936i = String.valueOf(baseVideo.getVideoPlayInfo().videoSource);
                    videoPlaybackReportInfo.Z = String.valueOf(baseVideo.getVideoPlayInfo().seq);
                    videoPlaybackReportInfo.f279927a0 = baseVideo.getVideoPlayInfo().s_vid;
                    videoPlaybackReportInfo.f279928b0 = baseVideo.getVideoPlayInfo().videoFeedsType;
                }
                if (baseVideo.getVideoPlayInfo().i()) {
                    videoPlaybackReportInfo.f279929c0 = String.valueOf(baseVideo.getVideoPlayInfo().liveVideoPreviewRoomState);
                }
            }
            SegmentVideoInfo.SegmentInfo segment = streamInfo.getSegment(0);
            String str2 = segment != null ? segment.url : null;
            if (baseVideo.getVideoPlayInfo() != null) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = baseVideo.getSegmentVideoInfo().getDefaultUrl();
                }
                String str3 = str2;
                VideoPlayInfoHolder videoProgressRecord = AutoVideoProgressRecorder.getInstance().getVideoProgressRecord(baseVideo.getVideoPlayInfo().videoId);
                long j3 = videoProgressRecord != null ? videoProgressRecord.currentPositionMills : 0L;
                if (baseVideo.getVideoPlayInfo().isAdFeeds) {
                    str = baseVideo.getVideoPlayInfo().feedKey;
                } else {
                    str = baseVideo.getVideoPlayInfo().videoId;
                }
                String str4 = str;
                PlayerConfig.g().getVideoReporter().prepareReportForDc00321(videoPlaybackReportInfo);
                if (videoPlaybackReportInfo.M) {
                    PlayerConfig.g().getVideoReporter().startPlayVideo(str4, str3, baseVideo.getVideoPlayInfo().videoTime, j3, baseVideo.isAutoPlay, baseVideo.getVideoPlayInfo().videoId, baseVideo.getVideoPlayInfo().feedsAppId, z16, this.f279853z, baseVideo.getVideoPlayInfo().liveAppid, false);
                } else {
                    PlayerConfig.g().getVideoReporter().startPlayVideo(str4, str3, baseVideo.getVideoPlayInfo().videoTime, j3, baseVideo.isAutoPlay, baseVideo.getVideoPlayInfo().videoId, baseVideo.getVideoPlayInfo().feedsAppId, z16, this.f279853z, 0, false);
                }
                PlayerConfig.g().getVideoReporter().addVideoVisibilityEvent(baseVideo.getVideoPlayInfo().videoFloatReportParam);
                PlayerConfig.g().getVideoReporter().addVideoVisibilityEvent(baseVideo.getVideoPlayInfo().videoFeedsReportParam);
                this.f279853z = false;
                if (baseVideo.getVideoPlayInfo().adv_pos >= 0) {
                    PlayerConfig.g().getVideoReporter().prepareAdvVideoReportInfo("IgnoreVideoUUID", baseVideo.getVideoPlayInfo().adv_pos);
                    return;
                }
                return;
            }
            PlayerConfig.g().getVideoReporter().startPlayVideo("", str2, 0L, 0L, baseVideo.isAutoPlay, "", 0, false, false, 0, false);
            PlayerConfig.g().getVideoReporter().prepareReportForDc00321(videoPlaybackReportInfo);
        }
    }

    private BaseVideo N0(List<? extends BaseVideo> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size != 1 && size != 2) {
            return null;
        }
        BaseVideo baseVideo = list.get(size - 1);
        if (!BaseVideoManager.z(baseVideo)) {
            return null;
        }
        if (size == 1) {
            if (!BaseVideoManager.t(baseVideo)) {
                return null;
            }
        } else {
            BaseVideo baseVideo2 = list.get(0);
            if (!BaseVideoManager.y(baseVideo2)) {
                if (!BaseVideoManager.t(baseVideo)) {
                    if (this.f279829b.a() != baseVideo2 || !BaseVideoManager.A(baseVideo2)) {
                        return null;
                    }
                }
            }
            return baseVideo2;
        }
        return baseVideo;
    }

    private void Y(String str, int i3, long j3, long j16) {
        if (TextUtils.isEmpty(str)) {
            PlayerUtils.log(5, this.f279828a, "handleDownloadError uuid is null");
            return;
        }
        if (UuidPlayIdMap.isUuidDeleted(str)) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleDownloadError. uuid=" + str + ", already stopped");
            return;
        }
        if (!str.equals(this.f279829b.f279985e)) {
            PlayerUtils.log(5, this.f279828a, "handleDownloadError: not current playing video. uuid=" + str + " playing uuid=" + this.f279829b.f279985e);
            return;
        }
        PlayerUtils.log(4, this.f279828a, "-------------------- handleDownloadError. uuid=" + PlayerUtils.toString(str) + " responseCode=" + i3 + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        if (this.f279829b.a() != null) {
            boolean z16 = (i3 == 16 || i3 == 17) ? false : true;
            if (z16 && FeedVideoEnv.externalFunc.isDebugVersion()) {
                FeedVideoEnv.externalFunc.showToast("\u7f51\u7edc\u5f02\u5e38: responseCode=" + i3);
            }
            VideoPlayInfoHolder videoPlayInfoHolder = this.f279829b.f279984d;
            videoPlayInfoHolder.errorType = 1L;
            videoPlayInfoHolder.errorDetail = "uuid=" + str + ",responseCode=" + i3 + ",retCode=" + j3 + ",subCode=" + j16;
            this.R.onVideoPlayError(this.f279829b.f279984d);
            if (PlayerConfig.g().getVideoReporter() != null) {
                if (z16) {
                    if (PlayerUtils.isNetworkAvailable()) {
                        DNSService dNSService = PlayerConfig.g().getDNSService();
                        if (dNSService != null) {
                            if (!dNSService.isNetReachable()) {
                                PlayerConfig.g().getVideoReporter().failPlayVideo(str, -1000, PlayerUtils.getDownloadRetCode(9L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE), u(), C());
                            } else {
                                PlayerConfig.g().getVideoReporter().failPlayVideo(str, -1000, j3, u(), C());
                            }
                        } else {
                            PlayerConfig.g().getVideoReporter().failPlayVideo(str, -1000, j3, u(), C());
                        }
                    } else {
                        PlayerConfig.g().getVideoReporter().failPlayVideo(str, -1000, PlayerUtils.getDownloadRetCode(9L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE), u(), C());
                    }
                } else {
                    PlayerConfig.g().getVideoReporter().stopPlayVideo(str, 0L, 0);
                }
            }
            FeedVideoEnv.externalFunc.reportVideoSuccessRate(false, K(this.f279829b.a(), i3, 0));
            if (z16) {
                this.f279829b.a().videoUIStop(7, 1372);
            } else {
                this.f279829b.a().videoUIStop();
            }
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            eVar.f279986f = 0;
            F0(eVar.a(), false, z16 ? 7 : 1, 1372);
            this.f279829b.d(null);
            PlayerUtils.log(6, this.f279828a + U, "mPlayingVideo==null,positon:10");
        }
    }

    private void h0(String str) {
        BaseVideo baseVideo;
        int i3;
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            if (eVar == null) {
                PlayerUtils.log(6, this.f279828a + U, "[handleOnPrepared] managerState == null, prepared fail.");
                return;
            }
            BaseVideo a16 = eVar.a();
            if (a16 == null) {
                PlayerUtils.log(6, this.f279828a + U, "[handleOnPrepared] playingVideo == null, prepared fail.");
                return;
            }
            this.f279829b.f279996p = 0L;
            try {
                E1(a16, str);
            } catch (Throwable th5) {
                PlayerUtils.log(6, this.f279828a + U, "[handleOnPrepared] error: ", th5);
            }
            PlayerUtils.log(4, this.f279828a, "-------------------- handleOnPrepared. uuid=" + str + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            if (!TextUtils.isEmpty(str) && !str.equals(this.f279829b.f279985e)) {
                PlayerUtils.log(5, this.f279828a, "handleOnPrepared: not current playing video. uuid=" + str + " playing uuid=" + this.f279829b.f279985e);
                return;
            }
            if (this.I.d().getInternalMediaPlayer() instanceof MediaPlayerProxy) {
                if (((MediaPlayerProxy) this.I.d().getInternalMediaPlayer()).getInternalMediaPlayer() instanceof FFSegmentMediaPlayer) {
                    sendEmptyMessageDelayed(150, 1000L);
                }
            } else if (this.I.d().getInternalMediaPlayer() instanceof IExo2MediaPlayer) {
                sendEmptyMessageDelayed(150, 1000L);
            } else if (this.I.d().getInternalMediaPlayer() instanceof com.tencent.mobileqq.qzoneplayer.player.c) {
                sendEmptyMessageDelayed(150, 1000L);
            }
            com.tencent.mobileqq.qzoneplayer.video.e eVar2 = this.f279829b;
            if (eVar2.f279986f == 1) {
                eVar2.f279989i = true;
                eVar2.f279987g = false;
                VideoSpeedReport.ReportPoint reportPoint = VideoSpeedReport.POINT_UPDATE_VIDEOVIEW;
                VideoSpeedReport.ReportType.addToVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY, reportPoint);
                VideoSpeedReport.g().start(reportPoint);
                FeedVideoEnv.externalFunc.notifyVideoStart();
                VideoPlayInfoHolder videoProgressRecord = AutoVideoProgressRecorder.getInstance().getVideoProgressRecord(a16.getVideoPlayInfo().videoId);
                if (a16.getVideoPlayInfo() == null || videoProgressRecord == null || a16.getVideoPlayInfo().isAdvMicro || a16.getVideoPlayInfo().isNotRecordProgress) {
                    baseVideo = a16;
                    i3 = 0;
                } else {
                    long duration = this.I.d().getDuration();
                    long min = Math.min(duration, videoProgressRecord.totalDurationMills);
                    videoProgressRecord.totalDurationMills = min;
                    long max = Math.max(0L, min - 1500);
                    i3 = Math.max(0, (int) videoProgressRecord.currentPositionMills);
                    if (max == 0) {
                        PlayerUtils.log(4, this.f279828a, "maxSeekAllowPosition is 0, seek disabled");
                        i3 = 0;
                    }
                    if (duration < this.f279846s) {
                        PlayerUtils.log(4, this.f279828a, "videoDuration < MinVideoDurationAllowSeek" + this.f279846s + ", seek disabled");
                        i3 = 0;
                    }
                    if (i3 < 1500) {
                        PlayerUtils.log(4, this.f279828a, "seekPosExpected=" + i3 + " < minSeekThreshold 1500, seek disabled");
                        i3 = 0;
                    }
                    if (i3 > max) {
                        PlayerUtils.log(4, this.f279828a, "videoDuration > maxSeekAllowPosition" + max + ", seek disabled");
                        i3 = 0;
                    }
                    PlayerUtils.log(4, this.f279828a, "handleOnPrepared ,totalDurationMills=" + videoProgressRecord.totalDurationMills + ",currentPositionMills=" + videoProgressRecord.currentPositionMills + ",maxSeekAllowPosition=" + max + ",seekPosExpected=" + i3);
                    if (i3 > 0) {
                        PlayerUtils.log(4, this.f279828a, "handleOnPrepared seekTo currentPositionMills expected:" + i3);
                        I1();
                        p(a16, videoProgressRecord);
                        U1(str, a16, i3);
                        if (PlayerConfig.g().getVideoReporter() != null) {
                            PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeySeekPosExpected", Integer.valueOf(i3));
                        }
                        try {
                            if (!(this.I.d().getInternalMediaPlayer() instanceof IExo2MediaPlayer) && !(this.I.d().getInternalMediaPlayer() instanceof com.tencent.mobileqq.qzoneplayer.player.c)) {
                                this.I.d().start();
                            }
                            PlayerUtils.log(4, this.f279828a, "handleOnPrepared MSG_MPOP_SEEK");
                            if (this.I.d().getInternalMediaPlayer() instanceof com.tencent.mobileqq.qzoneplayer.player.c) {
                                obtainMessage(25, i3, 0).sendToTarget();
                            } else {
                                sendMessageDelayed(obtainMessage(25, i3, 0), 500);
                            }
                            obtainMessage(50, i3, 0, a16).sendToTarget();
                            return;
                        } catch (IMediaPlayer.InternalOperationException e16) {
                            PlayerUtils.log(6, this.f279828a, "error! handlePauseVideo: " + PlayerUtils.getPrintableStackTrace(e16));
                            return;
                        }
                    }
                    baseVideo = a16;
                    if (videoProgressRecord.currentPositionMills != 0) {
                        PlayerUtils.log(6, this.f279828a, "illegal VideoPlayInfo videoId:" + baseVideo.getVideoPlayInfo().videoId + ",currentPositonMills:" + videoProgressRecord.currentPositionMills + ",totalDurationMills:" + videoProgressRecord.totalDurationMills);
                    }
                    p(baseVideo, videoProgressRecord);
                }
                U1(str, baseVideo, i3);
                I1();
                if (PlayerConfig.g().getVideoReporter() != null) {
                    PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeySeekPosExpected", Integer.valueOf(i3));
                }
                obtainMessage(50, i3, 0, baseVideo).sendToTarget();
                return;
            }
            return;
        }
        PlayerUtils.log(2, this.f279828a + U, "[handleOnPrepared] mPlayer == null || mPlayer.get() == null.");
    }

    private SegmentVideoInfo.StreamInfo u0(com.tencent.mobileqq.qzoneplayer.video.l lVar) {
        long downloadRetCode;
        if (lVar != null) {
            SafeUrlState safeUrlState = lVar.f280001a;
            if (safeUrlState == SafeUrlState.URL_STATE_SUCCESS) {
                PlayerUtils.log(4, this.f279828a, "handleSafeUrlResult URL_STATE_SUCCESS");
                SegmentVideoInfo.StreamInfo streamInfo = new SegmentVideoInfo.StreamInfo();
                streamInfo.segmentInfos = lVar.f280002b;
                streamInfo.mSafeUrlKey = lVar.f280008h;
                if (lVar.f280006f) {
                    this.f279829b.a().mIsVip = true;
                    this.f279829b.a().getVideoPlayInfo().videoTime = lVar.f280005e;
                } else {
                    this.f279829b.a().hideValidTimeText();
                }
                if (this.f279829b.a().mIsVip && !(this.f279829b.a() instanceof FeedAutoVideoFull)) {
                    this.f279829b.a().setValidTime(lVar.f280005e);
                } else {
                    this.f279829b.a().hideValidTimeText();
                    this.f279829b.a().setValidTime(0);
                }
                if (lVar.f280009i) {
                    this.f279829b.a().setStreamInfo(streamInfo, 4);
                }
                return streamInfo;
            }
            if (safeUrlState == SafeUrlState.URL_STATE_TIMEOUT) {
                PlayerUtils.log(4, this.f279828a, "handleSafeUrlResult URL_STATE_TIMEOUT");
                this.f279829b.a().setState(6);
                long j3 = lVar.f280003c + VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                if (!FeedVideoEnv.externalFunc.isNetworkAvailable(PlayerConfig.g().getAppContext())) {
                    downloadRetCode = PlayerUtils.getDownloadRetCode(15L, j3);
                    FeedVideoEnv.externalFunc.showToast("\u5f53\u524d\u65e0\u7f51\u7edc\uff0c\u83b7\u53d6\u89c6\u9891\u94fe\u63a5\u5931\u8d25");
                } else {
                    downloadRetCode = PlayerUtils.getDownloadRetCode(8L, j3);
                    FeedVideoEnv.externalFunc.showToast("\u83b7\u53d6\u89c6\u9891\u94fe\u63a5\u8d85\u65f6");
                }
                F1(j3, downloadRetCode, PlayerUtils.getDownloadResponseCode(downloadRetCode, j3));
                m();
                return null;
            }
            if (safeUrlState == SafeUrlState.URL_STATE_FAIL) {
                PlayerUtils.log(5, this.f279828a, "handleSafeUrlResult URL_STATE_FAIL");
                this.f279829b.a().setState(6);
                if (!this.f279829b.a().isBaseVideoCoverWrapperNotNull() && !this.f279829b.a().isVideoCoverNotNull()) {
                    PlayerUtils.log(5, this.f279828a, "handleSafeUrlResult mVideoCover is null");
                    m();
                } else {
                    int i3 = lVar.f280003c;
                    if (i3 == 80) {
                        FeedVideoEnv.externalFunc.showToast("\u4f60\u6240\u5728\u7684\u5730\u533a\u6682\u4e0d\u652f\u6301\u64ad\u653e\u8be5\u89c6\u9891");
                    } else if (i3 == 62) {
                        FeedVideoEnv.externalFunc.showToast("\u56e0\u7248\u6743\u9650\u5236\uff0c\u8be5\u89c6\u9891\u5df2\u4e0b\u67b6");
                    } else {
                        FeedVideoEnv.externalFunc.showToast("\u89c6\u9891\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    }
                    int i16 = lVar.f280004d;
                    if (i16 == 0) {
                        i16 = lVar.f280003c;
                    }
                    long j16 = i16 + VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                    long downloadRetCode2 = PlayerUtils.getDownloadRetCode(8L, j16);
                    F1(j16, downloadRetCode2, PlayerUtils.getDownloadResponseCode(downloadRetCode2, j16));
                    m();
                }
            } else if (safeUrlState == SafeUrlState.URL_STATE_INTERRUPT) {
                PlayerUtils.log(5, this.f279828a, "handleSafeUrlResult URL_STATE_INTERRUPT");
                m();
            } else {
                PlayerUtils.log(6, this.f279828a, "handleSafeUrlResult unknown SafeUrlState " + lVar.f280001a);
                m();
            }
        } else {
            PlayerUtils.log(6, this.f279828a, "handleSafeUrlResult safeUrlResult is null");
            m();
        }
        return null;
    }

    private int z(VideoPlayInfo videoPlayInfo) {
        int i3;
        boolean z16 = false;
        if (videoPlayInfo == null) {
            return 0;
        }
        if (TextUtils.isEmpty(videoPlayInfo.getDisplayRemark()) && FeedVideoEnv.externalFunc.isPicBigMode()) {
            z16 = true;
        }
        if (z16) {
            i3 = FeedVideoEnv.SCREEN_WIDTH;
        } else {
            i3 = FeedVideoEnv.DEFAULT_WIDTH;
        }
        int i16 = videoPlayInfo.coverMaxWidth;
        return i16 == 0 ? i3 : i16;
    }

    public void r1(boolean z16) {
        if (z16) {
            sendEmptyMessage(100);
        } else if (System.currentTimeMillis() - this.f279844q > 2000) {
            sendEmptyMessage(100);
            this.f279844q = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077 A[Catch: IllegalStateException -> 0x00b2, TryCatch #0 {IllegalStateException -> 0x00b2, blocks: (B:14:0x0020, B:17:0x0025, B:19:0x0032, B:33:0x0054, B:34:0x0069, B:37:0x0077, B:39:0x007c, B:42:0x008d, B:44:0x0086, B:45:0x0098, B:48:0x00a9, B:50:0x00a2, B:51:0x005f), top: B:13:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B1(BaseVideo baseVideo, boolean z16, boolean z17) {
        VideoPlayInfo videoPlayInfo;
        boolean z18;
        long duration;
        int i3;
        if (baseVideo == null) {
            return;
        }
        if (((baseVideo instanceof FeedAutoVideoFull) && baseVideo.getVideoPlayInfo() != null && !baseVideo.getVideoPlayInfo().isForceAdvReport) || (videoPlayInfo = baseVideo.getVideoPlayInfo()) == null) {
            return;
        }
        try {
            if (videoPlayInfo.isAdvMicro) {
                return;
            }
            boolean z19 = this.f279829b.f279984d.isNeverPlayed;
            if (videoPlayInfo.g()) {
                long j3 = this.f279829b.f279984d.hadPlayedRounds;
                if (j3 > 1 || (j3 == 1 && !z16)) {
                    z19 = false;
                }
            }
            boolean z26 = z19;
            if (!z16 && !z17) {
                z18 = false;
                if (!z16 && !z18) {
                    duration = this.I.d().getCurrentPosition();
                    i3 = (int) duration;
                    int i16 = (int) this.f279829b.f279984d.startPlayingPositionMills;
                    if (i3 >= 10) {
                        return;
                    }
                    if (videoPlayInfo.isGdtAdClicked) {
                        FeedVideoEnv.externalFunc.reportVideoPlay(i16, i3, z18, z26, videoPlayInfo.isGdtVideoPlaySuccess, baseVideo instanceof WindowPlayVideo ? 4 : o(videoPlayInfo.videoPlayScene), videoPlayInfo.cookie, baseVideo.feedPosition, 2);
                        videoPlayInfo.isGdtAdClicked = false;
                        return;
                    } else {
                        FeedVideoEnv.externalFunc.reportVideoPlay(i16, i3, z18, z26, videoPlayInfo.isGdtVideoPlaySuccess, baseVideo instanceof WindowPlayVideo ? 4 : o(videoPlayInfo.videoPlayScene), videoPlayInfo.cookie, baseVideo.feedPosition, 3);
                        return;
                    }
                }
                duration = this.I.d().getDuration();
                i3 = (int) duration;
                int i162 = (int) this.f279829b.f279984d.startPlayingPositionMills;
                if (i3 >= 10) {
                }
            }
            z18 = true;
            if (!z16) {
                duration = this.I.d().getCurrentPosition();
                i3 = (int) duration;
                int i1622 = (int) this.f279829b.f279984d.startPlayingPositionMills;
                if (i3 >= 10) {
                }
            }
            duration = this.I.d().getDuration();
            i3 = (int) duration;
            int i16222 = (int) this.f279829b.f279984d.startPlayingPositionMills;
            if (i3 >= 10) {
            }
        } catch (IllegalStateException e16) {
            PlayerUtils.log(2, this.f279828a + U, "report adv report  getCurrentPosition 2 " + e16.toString());
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0179 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x023f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r0(BaseVideo baseVideo, boolean z16, boolean z17) {
        boolean z18;
        VideoPlayInfo videoPlayInfo;
        long j3;
        VideoPlayInfo videoPlayInfo2;
        VideoPlayInfoHolder videoPlayInfoHolder;
        String str;
        long j16;
        long j17;
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            PlayerUtils.log(4, this.f279828a, "-------------------- handleRefreshVideoPlayInfoHolderProgress. video=" + PlayerUtils.toString(baseVideo) + " isCompletion=" + z16 + " playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
            long currentPosition = !this.f279829b.f279992l ? this.I.d().getCurrentPosition() : 0L;
            VideoPlayInfoHolder videoPlayInfoHolder2 = this.f279829b.f279984d;
            long j18 = videoPlayInfoHolder2.currentPositionMills;
            if (j18 == 0 || (videoPlayInfoHolder2.lastValidPositionMills == 0 && currentPosition == 0)) {
                z18 = false;
            } else {
                videoPlayInfoHolder2.lastValidPositionMills = j18;
                z18 = true;
            }
            videoPlayInfoHolder2.currentPositionMills = currentPosition;
            videoPlayInfoHolder2.currentPositionSec = (int) Math.round((currentPosition * 1.0d) / 1000.0d);
            if (this.f279829b.a() != null && !TextUtils.isEmpty(this.I.d().getCurrentSegmentUrl())) {
                VideoPlayInfoHolder videoPlayInfoHolder3 = this.f279829b.f279984d;
                int i3 = (int) (((videoPlayInfoHolder3.totalDurationSec * r0.f279994n) / 100) - videoPlayInfoHolder3.currentPositionSec);
                int i16 = i3 > 0 ? i3 : 0;
                if (this.I.d().getSegmentCount() > 1) {
                    com.tencent.mobileqq.qzoneplayer.videosource.b.b().setRemainTime(this.f279829b.b(), 1);
                } else if (this.I.g() == 2) {
                    com.tencent.mobileqq.qzoneplayer.videosource.b.b().setRemainTime(this.f279829b.b(), 1);
                } else {
                    com.tencent.mobileqq.qzoneplayer.videosource.b.b().setRemainTime(this.f279829b.b(), i16);
                }
                if (i16 > this.f279833f && !this.K && c1() && s1()) {
                    PlayerUtils.log(3, this.f279828a, "mpCache current remainTime " + i16 + " > " + this.f279833f + " preload pasterVideoAdv");
                } else {
                    if (!this.K && c1()) {
                        VideoPlayInfoHolder videoPlayInfoHolder4 = this.f279829b.f279984d;
                        if (q1(videoPlayInfoHolder4.totalDurationMills, videoPlayInfoHolder4.bufferedPercent, videoPlayInfoHolder4.currentPositionMills)) {
                            r1(false);
                            if (baseVideo == null || o1(baseVideo, currentPosition)) {
                                return;
                            }
                            if (currentPosition == 0 && z18) {
                                VideoPlayInfoHolder videoPlayInfoHolder5 = this.f279829b.f279984d;
                                videoPlayInfoHolder5.currentPositionMills = videoPlayInfoHolder5.lastValidPositionMills;
                                videoPlayInfoHolder5.currentPositionSec = (int) Math.round((r3 * 1.0d) / 1000.0d);
                            }
                            videoPlayInfo = baseVideo.getVideoPlayInfo();
                            if (videoPlayInfo != null && videoPlayInfo.k() && videoPlayInfo.g() && currentPosition != 0) {
                                j17 = this.f279829b.f279984d.lastValidPositionMills;
                                if (j17 != 0 && currentPosition < j17) {
                                    j3 = currentPosition;
                                    if (Math.abs(currentPosition - j17) > videoPlayInfo.videoTime / 2) {
                                        VideoPlayInfoHolder videoPlayInfoHolder6 = this.f279829b.f279984d;
                                        long j19 = videoPlayInfoHolder6.hadPlayedRounds + 1;
                                        videoPlayInfoHolder6.hadPlayedRounds = j19;
                                        if (j19 <= 20) {
                                            B1(baseVideo, true, z16);
                                        }
                                        VideoPlayInfoHolder videoPlayInfoHolder7 = this.f279829b.f279984d;
                                        videoPlayInfoHolder7.startPlayingPositionMills = 0L;
                                        videoPlayInfoHolder7.isNeverPlayed = false;
                                    }
                                    videoPlayInfo2 = baseVideo.getVideoPlayInfo();
                                    if (videoPlayInfo2 != null && videoPlayInfo2.isCanvasAdvVideo && videoPlayInfo2.g() && currentPosition != 0) {
                                        j16 = this.f279829b.f279984d.lastValidPositionMills;
                                        if (j16 != 0 && j3 < j16 && Math.abs(j3 - j16) > videoPlayInfo2.videoTime / 2) {
                                            this.f279829b.f279984d.hadPlayedRounds++;
                                            C1(baseVideo, true, z16);
                                            VideoPlayInfoHolder videoPlayInfoHolder8 = this.f279829b.f279984d;
                                            videoPlayInfoHolder8.startPlayingPositionMills = 0L;
                                            videoPlayInfoHolder8.isNeverPlayed = false;
                                        }
                                    }
                                    if (videoPlayInfo != null || (videoPlayInfoHolder = this.f279829b.f279984d) == null) {
                                        return;
                                    }
                                    if (!TextUtils.isEmpty(baseVideo.getRecordVideoId())) {
                                        str = baseVideo.getRecordVideoId();
                                    } else {
                                        str = videoPlayInfo.videoId;
                                    }
                                    if (!z16) {
                                        if (videoPlayInfoHolder.currentPositionMills == 0) {
                                            return;
                                        }
                                        if (!videoPlayInfo.isNotRecordProgress) {
                                            AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(str, videoPlayInfoHolder);
                                            PlayerUtils.log(3, this.f279828a, "recordProgress refreshcurrentPositionMills,videoId:" + videoPlayInfo.videoId + " currentPositionMills:" + videoPlayInfoHolder.currentPositionMills);
                                            return;
                                        }
                                        PlayerUtils.log(3, this.f279828a, "recordProgress refreshcurrentPositionMills,videoId:" + str + ", progress not recorded");
                                        return;
                                    }
                                    videoPlayInfoHolder.currentPositionMills = 0L;
                                    videoPlayInfoHolder.hadPlayedRounds = 0L;
                                    videoPlayInfoHolder.currentPositionSec = 0L;
                                    videoPlayInfoHolder.isNeverPlayed = false;
                                    if (!videoPlayInfo.isNotRecordProgress) {
                                        AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(str, videoPlayInfoHolder);
                                        PlayerUtils.log(3, this.f279828a, "recordProgress refreshcurrentPositionMills,videoId:" + str + " currentPositionMills:" + videoPlayInfoHolder.currentPositionMills + " state=complete");
                                        return;
                                    }
                                    PlayerUtils.log(3, this.f279828a, "recordProgress refreshcurrentPositionMills,videoId:" + str + ", progress not recorded");
                                    return;
                                }
                            }
                            j3 = currentPosition;
                            videoPlayInfo2 = baseVideo.getVideoPlayInfo();
                            if (videoPlayInfo2 != null) {
                                j16 = this.f279829b.f279984d.lastValidPositionMills;
                                if (j16 != 0) {
                                    this.f279829b.f279984d.hadPlayedRounds++;
                                    C1(baseVideo, true, z16);
                                    VideoPlayInfoHolder videoPlayInfoHolder82 = this.f279829b.f279984d;
                                    videoPlayInfoHolder82.startPlayingPositionMills = 0L;
                                    videoPlayInfoHolder82.isNeverPlayed = false;
                                }
                            }
                            if (videoPlayInfo != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    PlayerUtils.log(2, this.f279828a, "mpCache current remainTime=" + i16);
                    if (baseVideo == null) {
                        return;
                    }
                    if (currentPosition == 0) {
                        VideoPlayInfoHolder videoPlayInfoHolder52 = this.f279829b.f279984d;
                        videoPlayInfoHolder52.currentPositionMills = videoPlayInfoHolder52.lastValidPositionMills;
                        videoPlayInfoHolder52.currentPositionSec = (int) Math.round((r3 * 1.0d) / 1000.0d);
                    }
                    videoPlayInfo = baseVideo.getVideoPlayInfo();
                    if (videoPlayInfo != null) {
                        j17 = this.f279829b.f279984d.lastValidPositionMills;
                        if (j17 != 0) {
                            j3 = currentPosition;
                            if (Math.abs(currentPosition - j17) > videoPlayInfo.videoTime / 2) {
                            }
                            videoPlayInfo2 = baseVideo.getVideoPlayInfo();
                            if (videoPlayInfo2 != null) {
                            }
                            if (videoPlayInfo != null) {
                            }
                        }
                    }
                    j3 = currentPosition;
                    videoPlayInfo2 = baseVideo.getVideoPlayInfo();
                    if (videoPlayInfo2 != null) {
                    }
                    if (videoPlayInfo != null) {
                    }
                }
            }
            if (baseVideo == null) {
            }
        } else {
            PlayerUtils.log(2, this.f279828a + U, "[handleRefreshVideoPlayInfoHolderProgress] mPlayer == null || mPlayer.get() == null.");
        }
    }

    private String t(long j3) {
        if (j3 != -1) {
            return (j3 / 1000) + "kbps";
        }
        return j3 + "";
    }

    private boolean q1(long j3, int i3, long j16) {
        if ((j3 < BaseVideoManager.f279604p || BaseVideoManager.f279601m.isEmpty() || BaseVideoManager.f279602n.isEmpty()) && i3 > 50) {
            PlayerUtils.log(4, this.f279828a, "preloadEnableWhenBufferingOrProgress videoDuration = " + j3 + ", bufferPercent = " + i3 + ", currentPlayProgress = " + j16);
            return true;
        }
        long j17 = ((i3 * j3) / 100) - j16;
        if (j17 <= 0) {
            j17 = 0;
        }
        for (int i16 = 0; i16 < BaseVideoManager.f279601m.size(); i16++) {
            if (i3 > BaseVideoManager.f279601m.get(i16).doubleValue() && j17 > BaseVideoManager.f279602n.get(i16).doubleValue()) {
                PlayerUtils.log(4, this.f279828a, "preloadEnableWhenBufferingOrProgress videoDuration = " + j3 + ", bufferPercent = " + i3 + ", currentPlayProgress = " + j16 + ", remainTime = " + j17);
                return true;
            }
        }
        return false;
    }

    private void g0(String str, int i3, int i16) {
        String str2;
        String str3;
        if (i3 == 1 && !e1()) {
            PlayerUtils.log(4, this.f279828a, "prepare is aborted");
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().completePlayVideo(str);
            }
            if (L() != null) {
                L().cancelVideoRequestByUuid(str);
                return;
            }
            return;
        }
        PlayerUtils.log(4, this.f279828a, "-------------------- handleOnError.  playingVideo=" + PlayerUtils.toString(this.f279829b.a()));
        CachedMediaPlayer cachedMediaPlayer = this.I;
        if (cachedMediaPlayer != null && cachedMediaPlayer.d() != null) {
            if (i3 == -4001 || i3 == -4002 || i3 == -4003) {
                PlayerUtils.log(4, this.f279828a, "mediacodec init error temporary disable exoplayer");
                zl2.b.d(false);
                PlayerUtils.log(4, this.f279828a, "update Exo2Config mOskExo2Enabled=" + zl2.b.b());
            }
            if (i3 == -4003) {
                com.tencent.mobileqq.qzoneplayer.player.a.c().f(true);
            }
            if (i3 == -4002) {
                PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoDecoderErrType", VideoReporter.DecoderErrType.ILLEGAL_STATE);
            } else if (i3 == -4003) {
                PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoDecoderErrType", VideoReporter.DecoderErrType.INIT);
            } else if (i3 == -4999) {
                PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyVideoDecoderErrType", VideoReporter.DecoderErrType.UNKNOWN);
            }
            com.tencent.mobileqq.qzoneplayer.video.e eVar = this.f279829b;
            eVar.f279992l = true;
            VideoPlayInfoHolder videoPlayInfoHolder = eVar.f279984d;
            videoPlayInfoHolder.errorType = 0L;
            videoPlayInfoHolder.errorDetail = "uuid=" + str + ",what=" + i3 + ",extra=" + i16;
            this.R.onVideoPlayError(this.f279829b.f279984d);
            if (PlayerConfig.g().getVideoReporter() != null) {
                if (PlayerUtils.isNetworkAvailable()) {
                    DNSService dNSService = PlayerConfig.g().getDNSService();
                    if (dNSService != null) {
                        if (!dNSService.isNetReachable()) {
                            PlayerConfig.g().getVideoReporter().failPlayVideo(str, -1000, PlayerUtils.getDownloadRetCode(9L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE), u(), C());
                        } else {
                            PlayerConfig.g().getVideoReporter().failPlayVideo(str, i3, i16, this.f279829b.f279994n, C());
                        }
                    } else {
                        PlayerConfig.g().getVideoReporter().failPlayVideo(str, i3, i16, this.f279829b.f279994n, C());
                    }
                } else {
                    PlayerConfig.g().getVideoReporter().failPlayVideo(str, -1000, PlayerUtils.getDownloadRetCode(9L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE), u(), C());
                }
            }
            if (L() != null) {
                L().cancelVideoRequestByUuid(str);
            }
            if (!TextUtils.isEmpty(str) && !str.equals(this.f279829b.f279985e)) {
                PlayerUtils.log(5, this.f279828a, String.format("handleOnError: uuid not match, uuid=%s, managerState.uuid=%s", str, this.f279829b.f279985e));
                return;
            }
            BaseVideo a16 = this.f279829b.a();
            String str4 = this.f279828a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MediaPlayer onError remove video cache first segment source url");
            if (a16 != null) {
                str2 = this.I.d().getCurrentSegmentUrl();
            } else {
                str2 = "error:playingvideo is null!";
            }
            sb5.append(str2);
            PlayerUtils.log(4, str4, sb5.toString());
            if (a16 != null) {
                FeedVideoEnv.externalFunc.getVideoLoader().clearCacheByInfo(a16.getSegmentVideoInfo());
            } else {
                PlayerUtils.log(5, this.f279828a, "error remove video cache, playingVideo is null");
            }
            String K = K(a16, i3, i16);
            PlayerUtils.log(6, this.f279828a, "xx,onError:" + i3 + ",extra" + i16 + ",detail=" + K);
            FeedVideoEnv.externalFunc.reportVideoSuccessRate(false, K);
            p0(false, true);
            String str5 = "!";
            if (i3 == 1) {
                str3 = "MEDIA_ERROR_UNKNOWN";
            } else if (i3 != 100) {
                str3 = "!";
            } else {
                str3 = "MEDIA_ERROR_SERVER_DIED";
            }
            if (i16 == -1010) {
                str5 = "MEDIA_ERROR_UNSUPPORTED";
            } else if (i16 == -1007) {
                str5 = "MEDIA_ERROR_MALFORMED";
            } else if (i16 == -1004) {
                str5 = "MEDIA_ERROR_IO";
            } else if (i16 == -110) {
                str5 = "MEDIA_ERROR_TIMED_OUT";
            }
            String format = String.format("what:%d,%s extra:%d,%s", Integer.valueOf(i3), str3, Integer.valueOf(i16), str5);
            PlayerUtils.log(4, this.f279828a, "onErrorListener " + format);
            Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
            if (callbacks != null) {
                for (PlayerCallBack playerCallBack : callbacks) {
                    playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_PLAY_ERROR, format, null);
                }
            }
            if (FeedVideoEnv.externalFunc.isDebugVersion()) {
                FeedVideoEnv.externalFunc.showToast(format);
                return;
            }
            return;
        }
        PlayerUtils.log(5, this.f279828a, "handleOnError: mPlayer == null || mPlayer.get() == null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class i implements ImageLoader.ImageLoadListener {
        i() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            PlayerUtils.log(4, ManagerHandler.this.f279828a, "preload_log preloadcover cancel url=" + str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            PlayerUtils.log(4, ManagerHandler.this.f279828a, "preload_log preloadcover failed url=" + str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            PlayerUtils.log(4, ManagerHandler.this.f279828a, "preload_log preloadcover success url=" + str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
