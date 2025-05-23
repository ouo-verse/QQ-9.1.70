package com.tencent.biz.subscribe.framework;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.sender.util.EventControlUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.e;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;
import qqcircle.QQCircleReport$SingleDcData;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseVideoView extends BaseWidgetView implements ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, NetworkManager.NetStatusListener, SimpleEventReceiver, Handler.Callback, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener {

    /* renamed from: t0, reason: collision with root package name */
    protected static long f96100t0;
    private boolean E;
    private Handler F;
    private ISPlayerVideoView G;
    private final int H;
    protected boolean I;
    protected boolean J;
    private long K;
    private int L;
    private long M;
    private long N;
    private long P;
    private long Q;
    private long R;
    protected boolean S;
    private volatile Timer T;
    private long U;
    protected URLImageView V;
    private List<Pair<Long, Long>> W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f96102a0;

    /* renamed from: b0, reason: collision with root package name */
    private ISuperPlayer f96103b0;

    /* renamed from: c0, reason: collision with root package name */
    private SuperPlayerVideoInfo f96104c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f96105d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f96106e0;

    /* renamed from: f0, reason: collision with root package name */
    protected b f96107f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f96108g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f96109h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f96110i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f96111j0;

    /* renamed from: k0, reason: collision with root package name */
    private long f96112k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f96113l0;

    /* renamed from: m0, reason: collision with root package name */
    private String f96114m0;

    /* renamed from: n0, reason: collision with root package name */
    private ArrayList<QQCircleReport$SingleDcData> f96115n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f96116o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f96117p0;

    /* renamed from: q0, reason: collision with root package name */
    private long f96118q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f96119r0;

    /* renamed from: s0, reason: collision with root package name */
    public static String f96099s0 = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("key_sp_is_support_hevc", "");

    /* renamed from: u0, reason: collision with root package name */
    private static final String f96101u0 = BaseApplication.getContext().getExternalCacheDir() + "/superplayer/170303102";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class TimeUpdateTimerTask extends TimerTask {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<BaseVideoView> f96124d;

        TimeUpdateTimerTask(BaseVideoView baseVideoView) {
            this.f96124d = new WeakReference<>(baseVideoView);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BaseVideoView baseVideoView;
            WeakReference<BaseVideoView> weakReference = this.f96124d;
            if (weakReference != null && (baseVideoView = weakReference.get()) != null) {
                baseVideoView.f0();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements EventControlUtils.OnDebounceListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SeekBar f96125a;

        a(SeekBar seekBar) {
            this.f96125a = seekBar;
        }

        @Override // com.tencent.richframework.sender.util.EventControlUtils.OnDebounceListener
        public void onExecute() {
            Message obtain = Message.obtain();
            obtain.what = -1001;
            obtain.arg1 = this.f96125a.getProgress();
            obtain.arg2 = (int) BaseVideoView.this.H().getDurationMs();
            obtain.obj = Boolean.FALSE;
            if (BaseVideoView.this.P()) {
                BaseVideoView.this.c0(this.f96125a.getProgress());
            }
            BaseVideoView.this.j().sendMessage(obtain);
        }
    }

    public BaseVideoView(@NonNull Context context) {
        this(context, null);
    }

    private long B() {
        return this.f96118q0;
    }

    private static String D(String str, String str2) {
        try {
            String str3 = Uri.parse(str).getPathSegments().get(0);
            if (str3.contains(".mp4")) {
                return str3.substring(0, str3.indexOf(".mp4"));
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    private long I() {
        long j3 = 0;
        for (Pair<Long, Long> pair : this.W) {
            j3 += ((Long) pair.second).longValue() - ((Long) pair.first).longValue();
        }
        return j3;
    }

    private void J(TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo) {
        this.f96113l0 = tPCDNURLInfo.cdnIp;
        this.f96114m0 = tPCDNURLInfo.uIp;
    }

    private void K(TPDownloadProgressInfo tPDownloadProgressInfo) {
        Q(tPDownloadProgressInfo.getExtraInfo());
    }

    private void L() {
        if (F() != null) {
            F().setOnSeekBarChangeListener(this);
        }
    }

    private static boolean O(String str) {
        if (str == null) {
            return false;
        }
        try {
            for (String str2 : ((String) VSConfigManager.c().e("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|")) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private void Q(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("hitDownloaded")) {
                boolean z16 = true;
                if (jSONObject.getInt("hitDownloaded") != 1) {
                    z16 = false;
                }
                this.f96111j0 = z16;
            }
            if (jSONObject.has("localCacheSize")) {
                this.f96112k0 = jSONObject.getLong("localCacheSize");
            }
            if (jSONObject.has("httpAvgSpeedKB")) {
                this.f96118q0 = jSONObject.getLong("httpAvgSpeedKB");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void Z() {
        H().reset();
        H().setLoopback(this.f96108g0);
        H().updatePlayerVideoView(this.G);
        H().setOutputMute(this.f96109h0);
    }

    private void w(long j3, long j16) {
        if (N()) {
            return;
        }
        for (Pair<Long, Long> pair : this.W) {
            if (((Long) pair.first).longValue() <= j3 && ((Long) pair.second).longValue() >= j16) {
                QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained [start=" + j3 + ", end=" + j16 + "]");
                return;
            }
        }
        Iterator<Pair<Long, Long>> it = this.W.iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            if (j3 <= ((Long) next.first).longValue() && j16 >= ((Long) next.second).longValue()) {
                QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: remove [start=" + next.first + ", end=" + next.second + "]");
                it.remove();
            }
        }
        for (Pair<Long, Long> pair2 : this.W) {
            if (j3 >= ((Long) pair2.first).longValue() && j3 <= ((Long) pair2.second).longValue()) {
                j3 = ((Long) pair2.second).longValue();
            }
            if (j16 >= ((Long) pair2.first).longValue() && j16 <= ((Long) pair2.second).longValue()) {
                j16 = ((Long) pair2.first).longValue();
            }
        }
        if (j3 >= 0 && j3 <= j16) {
            QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + j3 + ", end=" + j16 + "]");
            this.W.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
            return;
        }
        QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + j3 + ", end=" + j16 + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        URLImageView uRLImageView;
        if (H() != null && !this.f96105d0) {
            addView((View) this.G, 0, new FrameLayout.LayoutParams(-1, -1));
            if (!this.f96106e0 && (uRLImageView = this.V) != null) {
                addView(uRLImageView);
            }
            this.f96105d0 = true;
        }
    }

    public static SuperPlayerVideoInfo y(String str, String str2) {
        if (!StringUtil.isEmpty(str) && (str2 == null || O(str2))) {
            return SuperPlayerFactory.createVideoInfoForTVideo(30301, str);
        }
        if (!StringUtil.isEmpty(str2)) {
            String D = D(str2, str);
            QLog.i("BaseVideoView", 1, "createSuperVideoInfo fileId:" + D);
            return SuperPlayerFactory.createVideoInfoForUrl(str2, 101, D, "");
        }
        return null;
    }

    private void z() {
        this.f96119r0 = true;
        if (B() == 0) {
            this.f96111j0 = true;
        } else {
            f96100t0 = this.f96118q0;
        }
        QLog.d("BaseVideoView", 1, String.format("DownloadComplete  DownLoadSpeed:%d kb/s", Long.valueOf(B())));
    }

    protected void A() {
        URLImageView uRLImageView = this.V;
        if (uRLImageView != null) {
            uRLImageView.setVisibility(8);
        }
    }

    public long C() {
        return this.K;
    }

    public ISPlayerVideoView E() {
        return this.G;
    }

    public abstract SeekBar F();

    public int G() {
        return this.L;
    }

    public ISuperPlayer H() {
        boolean z16;
        if (this.f96103b0 == null) {
            if (VideoPlaySDKManager.getInstance().isSDKReady()) {
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                this.G = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
                ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 102, this.G);
                this.f96103b0 = createMediaPlayer;
                createMediaPlayer.setOnVideoPreparedListener(this);
                this.f96103b0.setOnErrorListener(this);
                this.f96103b0.setOnInfoListener(this);
                this.f96103b0.setOnCompletionListener(this);
                this.f96103b0.setOnSeekCompleteListener(this);
                this.f96103b0.setOnInfoListener(this);
                if (from.isAccessible()) {
                    boolean z17 = !from.decodeString("key_sp_is_detect_hevc", "").equals("");
                    this.f96116o0 = z17;
                    if (!z17) {
                        try {
                            if (e.d(172, 102).getMaxLumaSamples() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            f96099s0 = String.valueOf(z16);
                        } catch (Exception e16) {
                            QLog.e("BaseVideoView", 1, "getThumbPlayerVCodecTypeMaxCapability() error,", e16);
                        }
                        from.encodeString("key_sp_is_detect_hevc", "1");
                        from.encodeString("key_sp_is_support_hevc", f96099s0);
                        from.commitAsync();
                        QLog.i("BaseVideoView", 1, "this phone is support hevc");
                    }
                }
            } else {
                QLog.w("BaseVideoView", 1, "SuperPlayer is not installed");
            }
        }
        return this.f96103b0;
    }

    public void M() {
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new SDKInitListener() { // from class: com.tencent.biz.subscribe.framework.BaseVideoView.1
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    BaseVideoView.this.j().post(new Runnable() { // from class: com.tencent.biz.subscribe.framework.BaseVideoView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseVideoView.this.x();
                            if (BaseVideoView.this.f96104c0 != null && !BaseVideoView.this.f96117p0) {
                                BaseVideoView.this.U();
                            }
                        }
                    });
                }
            });
        } else {
            H();
        }
    }

    protected boolean N() {
        QLog.w("BaseVideoView", 1, "biz has cancel perf report");
        return false;
    }

    protected boolean P() {
        return false;
    }

    public void R() {
        if (H() != null && H().isPlaying()) {
            H().pause();
            this.I = true;
            w(this.R, H().getCurrentPositionMs());
            W(System.currentTimeMillis() - this.P, I());
            this.U = System.currentTimeMillis();
        }
    }

    public void S() {
        if (this.T != null) {
            this.T.cancel();
            this.T.purge();
        }
        this.T = new BaseTimer();
        this.T.schedule(new TimeUpdateTimerTask(this), 0L, 33L);
    }

    public void T() {
        this.f96102a0 = true;
        if (H() != null) {
            H().stop();
            H().release();
        }
        this.I = false;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        NetworkManager.unregistNetStatusListener(this);
        if (F() != null) {
            F().setProgress(0);
            F().setOnSeekBarChangeListener(null);
        }
        if (this.T != null) {
            this.T.cancel();
        }
        this.V = null;
        j().removeCallbacksAndMessages(null);
    }

    public void U() {
        if (H() != null) {
            H().stop();
            this.I = false;
            SuperPlayerVideoInfo superPlayerVideoInfo = this.f96104c0;
            if (superPlayerVideoInfo != null) {
                setVideoPath(superPlayerVideoInfo.getVid(), this.f96104c0.getPlayUrl(), 0);
            }
        }
    }

    protected abstract void V(int i3, int i16, long j3, long j16);

    protected abstract void W(long j3, long j16);

    protected abstract void X(long j3, long j16);

    protected abstract void Y();

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void a(Context context, int i3) {
        L();
    }

    protected void a0() {
        URLImageView uRLImageView = this.V;
        if (uRLImageView != null) {
            uRLImageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public void b(Context context, int i3) {
        super.b(context, i3);
        this.f96105d0 = false;
        M();
        URLImageView uRLImageView = new URLImageView(getContext());
        this.V = uRLImageView;
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.V.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        x();
        NetworkManager.registNetStatusListener(this);
    }

    protected void b0() {
        if (H() != null && H().isPlaying()) {
            e0();
        }
        this.f96111j0 = false;
        this.f96104c0 = null;
        this.E = false;
        this.K = 0L;
        this.L = 0;
        this.M = 0L;
        this.f96110i0 = "0";
        this.f96119r0 = false;
        this.f96118q0 = 0L;
        this.f96112k0 = 0L;
        this.f96113l0 = null;
        this.f96114m0 = null;
        if (this.T != null) {
            this.T.cancel();
        }
        j().removeCallbacksAndMessages(null);
        j().post(new Runnable() { // from class: com.tencent.biz.subscribe.framework.BaseVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoView.this.a0();
            }
        });
    }

    public void c0(long j3) {
        try {
            if (H() != null) {
                long durationMs = H().getDurationMs();
                long j16 = 0;
                if (j3 > durationMs && durationMs != 0) {
                    QLog.d("BaseVideoView", 1, "seek over position=" + j3 + "duration=" + durationMs);
                    j3 = durationMs;
                }
                if (j3 < 0) {
                    QLog.d("BaseVideoView", 1, "seek invalid position=" + j3 + "duration=" + H().getDurationMs());
                } else {
                    j16 = j3;
                }
                H().seekTo((int) j16, 3);
                QLog.d("BaseVideoView", 1, "seek position=" + j16 + "duration=" + H().getDurationMs());
                this.E = true;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void d0() {
        if (H() != null && !H().isPlaying()) {
            setInterrupt(false);
            if (this.I && this.U > 0) {
                this.P += System.currentTimeMillis() - this.U;
                this.U = 0L;
            } else if (!this.f96102a0) {
                w(this.R, H().getDurationMs());
            }
            if (!this.I && this.f96102a0) {
                this.P = System.currentTimeMillis();
                this.R = H().getCurrentPositionMs();
            }
            H().start();
            this.I = false;
            this.f96102a0 = false;
            S();
            Y();
        }
    }

    public void e0() {
        this.f96102a0 = true;
        if (H() != null) {
            H().stop();
        }
        this.I = false;
        if (this.T != null) {
            this.T.cancel();
            this.T = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void f0() {
        if (H() != null) {
            final double currentPositionMs = H().getCurrentPositionMs();
            final float durationMs = (float) H().getDurationMs();
            if (this.S || currentPositionMs == 0.0d || this.I) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = -1001;
            obtain.arg1 = (int) currentPositionMs;
            obtain.arg2 = (int) durationMs;
            obtain.obj = Boolean.TRUE;
            j().sendMessage(obtain);
            j().post(new Runnable() { // from class: com.tencent.biz.subscribe.framework.BaseVideoView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BaseVideoView.this.F() != null) {
                        if (durationMs == 0.0f) {
                            BaseVideoView.this.F().setProgress(0);
                        } else {
                            BaseVideoView.this.F().setProgress((int) (BaseVideoView.this.F().getMax() * (currentPositionMs / durationMs)));
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return null;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public Handler j() {
        if (this.F == null) {
            this.F = new Handler(Looper.getMainLooper(), this);
        }
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f96117p0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getHandler().removeCallbacksAndMessages(null);
        this.f96117p0 = true;
        T();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        QLog.e("BaseVideoView", 1, String.format("module:%d, errorType:%d, errorCode:%d, extraInfo:%s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str));
        V(i17, i3, 0L, 0L);
        if (String.valueOf(i17).startsWith("140") || String.valueOf(i17).startsWith("160")) {
            this.f96110i0 = String.valueOf(i17);
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        String obj2;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = com.tencent.biz.subscribe.framework.a.a(i3);
        String str = "";
        if (obj == null) {
            obj2 = "";
        } else {
            obj2 = obj.toString();
        }
        objArr[2] = obj2;
        SuperPlayerVideoInfo superPlayerVideoInfo = this.f96104c0;
        if (superPlayerVideoInfo != null) {
            str = superPlayerVideoInfo.getPlayUrl();
        }
        objArr[3] = str;
        QLog.i("BaseVideoView", 1, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", objArr));
        if (i3 != 105) {
            if (i3 != 201) {
                if (i3 != 204) {
                    if (i3 != 207) {
                        if (i3 != 112) {
                            if (i3 == 113 && !this.E) {
                                this.L++;
                                this.M += System.currentTimeMillis() - this.K;
                                g0(this.f96104c0);
                                QLog.i("BaseVideoView", 1, String.format("PLAYER_INFO_BUFFERING_END mSecondBufferCount:%d, mSecondBufferTime:%d", Integer.valueOf(this.L), Long.valueOf(this.M)));
                            }
                        } else {
                            this.K = System.currentTimeMillis();
                        }
                    } else if (obj instanceof TPDownloadProgressInfo) {
                        K((TPDownloadProgressInfo) obj);
                    }
                } else if (obj instanceof TPPlayerMsg.TPCDNURLInfo) {
                    TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) obj;
                    J(tPCDNURLInfo);
                    QLog.i("BaseVideoView", 1, String.format("hashCode:%d,TPPlayerMsg.TPCDNURLInfo:cdnIp:%s, errStr:%s, ip:%s, url:%s", Integer.valueOf(hashCode()), tPCDNURLInfo.cdnIp, tPCDNURLInfo.errorStr, tPCDNURLInfo.uIp, tPCDNURLInfo.url));
                }
            } else {
                z();
            }
        } else {
            j().post(new Runnable() { // from class: com.tencent.biz.subscribe.framework.BaseVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    BaseVideoView.this.A();
                }
            });
        }
        return false;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (this.S) {
            EventControlUtils.throttlingDelay("setSeekBar", 100L, new a(seekBar));
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        this.E = false;
        if (this.Q > 0) {
            this.P += System.currentTimeMillis() - this.Q;
            this.Q = 0L;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.S = true;
        this.Q = System.currentTimeMillis();
        long currentTimeMillis = System.currentTimeMillis() - this.P;
        if (H() != null) {
            w(this.R, H().getCurrentPositionMs());
            X(currentTimeMillis, I());
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        if (H() != null) {
            int progress = (int) ((seekBar.getProgress() / (seekBar.getMax() * 1.0f)) * ((float) H().getDurationMs()));
            long j3 = progress;
            this.R = j3;
            QLog.d("BaseVideoView", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", Integer.valueOf(seekBar.getProgress()), Integer.valueOf(progress)));
            c0(j3);
        }
        this.S = false;
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        j().post(new Runnable() { // from class: com.tencent.biz.subscribe.framework.BaseVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if (BaseVideoView.this.G != null) {
                    BaseVideoView.this.G.setXYaxis(0);
                }
                if (BaseVideoView.this.F() != null) {
                    BaseVideoView.this.F().setMax((int) BaseVideoView.this.H().getDurationMs());
                }
            }
        });
    }

    public void setBaseVideoViewListenerSets(b bVar) {
        this.f96107f0 = bVar;
    }

    public void setInterrupt(boolean z16) {
        this.J = z16;
    }

    public void setLoopBack(boolean z16) {
        this.f96108g0 = z16;
        if (H() != null) {
            H().setLoopback(z16);
        }
    }

    public void setOutPutMute(boolean z16) {
        this.f96109h0 = z16;
        if (H() != null) {
            H().setOutputMute(z16);
        }
    }

    public void setVideoCover(URLImageView uRLImageView) {
        if (uRLImageView != null) {
            URLImageView uRLImageView2 = this.V;
            if (uRLImageView2 != null) {
                removeView(uRLImageView2);
            }
            this.f96106e0 = true;
            this.V = uRLImageView;
        }
    }

    public void setVideoPath(String str, String str2, int i3) {
        QLog.i("BaseVideoView", 1, "set Final VideoPath success");
        b0();
        this.f96104c0 = y(str, str2);
        if (H() != null && this.f96104c0 != null) {
            Z();
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            obtain.accurateSeekOnOpen = true;
            H().openMediaPlayer(getContext(), this.f96104c0, i3, obtain);
            this.N = System.currentTimeMillis();
        }
    }

    public BaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = 1;
        this.W = new LinkedList();
        this.f96102a0 = true;
        this.f96110i0 = "0";
        this.f96115n0 = new ArrayList<>();
        this.f96116o0 = false;
    }

    protected void g0(SuperPlayerVideoInfo superPlayerVideoInfo) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    @Override // com.tencent.component.network.NetworkManager.NetStatusListener
    public void onNetworkChanged(String str, String str2) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
    }
}
