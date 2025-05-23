package com.tencent.gdtad.views.video;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.statistics.GdtImpressionReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.volume.VolumeChangeObserver;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqvideoplatform.api.PlatformInfo;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVideoCommonView extends RelativeLayout implements View.OnClickListener, ISuperPlayer.OnVideoPreparedListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnTVideoNetInfoListener {
    private ImageView A0;
    private SeekBar B0;
    private long C;
    private SeekBar C0;
    private int D;
    private LinearLayout D0;
    private boolean E;
    private TextView E0;
    private int F;
    private TextView F0;
    private boolean G;
    private ImageView G0;
    private boolean H;
    private boolean H0;
    public boolean I;
    private View I0;
    private int J;
    private AudioManager J0;
    private boolean K;
    private VolumeChangeObserver K0;
    private boolean L;
    private d L0;
    private volatile boolean M;
    private long M0;

    @NonNull
    public String N;

    @NonNull
    private Runnable N0;

    @NonNull
    private Runnable O0;
    private ImageView P;

    @NonNull
    private Runnable P0;
    private RelativeLayout Q;

    @NonNull
    private INetInfoHandler Q0;
    private int R;
    private boolean R0;
    private int S;
    private g S0;
    private int T;
    private boolean U;
    private TextView V;
    private View W;

    /* renamed from: a0, reason: collision with root package name */
    private View f109642a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f109643b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f109644c0;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private ISuperPlayer f109645d;

    /* renamed from: d0, reason: collision with root package name */
    private int f109646d0;

    /* renamed from: e, reason: collision with root package name */
    private int f109647e;

    /* renamed from: e0, reason: collision with root package name */
    private int f109648e0;

    /* renamed from: f, reason: collision with root package name */
    private long f109649f;

    /* renamed from: f0, reason: collision with root package name */
    private int f109650f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f109651g0;

    /* renamed from: h, reason: collision with root package name */
    private Context f109652h;

    /* renamed from: h0, reason: collision with root package name */
    private View f109653h0;

    /* renamed from: i, reason: collision with root package name */
    private Handler f109654i;

    /* renamed from: i0, reason: collision with root package name */
    private Button f109655i0;

    /* renamed from: j0, reason: collision with root package name */
    private Button f109656j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f109657k0;

    /* renamed from: l0, reason: collision with root package name */
    private ImageView f109658l0;

    /* renamed from: m, reason: collision with root package name */
    private GdtVideoData f109659m;

    /* renamed from: m0, reason: collision with root package name */
    private int f109660m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f109661n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f109662o0;

    /* renamed from: p0, reason: collision with root package name */
    private f f109663p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f109664q0;

    /* renamed from: r0, reason: collision with root package name */
    private View f109665r0;

    /* renamed from: s0, reason: collision with root package name */
    private final GdtImpressionReporter.GdtVideoReportInfo f109666s0;

    /* renamed from: t0, reason: collision with root package name */
    @Nullable
    private GdtVideoReportListenerImp f109667t0;

    /* renamed from: u0, reason: collision with root package name */
    @NonNull
    private ArrayList<h> f109668u0;

    /* renamed from: v0, reason: collision with root package name */
    private ResizeURLImageView f109669v0;

    /* renamed from: w0, reason: collision with root package name */
    private ISPlayerVideoView f109670w0;

    /* renamed from: x0, reason: collision with root package name */
    private View f109671x0;

    /* renamed from: y0, reason: collision with root package name */
    private View f109672y0;

    /* renamed from: z0, reason: collision with root package name */
    private ImageView f109673z0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetMobile2None()");
            GdtVideoCommonView.this.F = 0;
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetMobile2Wifi() ssid=" + str);
            GdtVideoCommonView.this.F = 1;
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetNone2Mobile() apn=" + str + " onNetWifi2None " + GdtVideoCommonView.this.K);
            GdtVideoCommonView.this.F = 2;
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetNone2Wifi() ssid=" + str);
            GdtVideoCommonView.this.F = 1;
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetWifi2Mobile() apn=" + str);
            GdtVideoCommonView.this.F = 2;
            GdtVideoCommonView gdtVideoCommonView = GdtVideoCommonView.this;
            if (gdtVideoCommonView.I && gdtVideoCommonView.d0()) {
                GdtVideoCommonView.this.o0();
                GdtVideoCommonView.this.f109654i.post(GdtVideoCommonView.this.N0);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetWifi2None()");
            GdtVideoCommonView.this.K = true;
            GdtVideoCommonView.this.F = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements VolumeChangeObserver.VolumeChangeListener {
        b() {
        }

        @Override // com.tencent.gdtad.volume.VolumeChangeObserver.VolumeChangeListener
        public void onVolumeChanged(Object... objArr) {
            GdtVideoCommonView.this.U();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c implements ISuperPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<GdtVideoCommonView> f109679d;

        public c(WeakReference<GdtVideoCommonView> weakReference) {
            this.f109679d = weakReference;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            GdtVideoCommonView gdtVideoCommonView;
            WeakReference<GdtVideoCommonView> weakReference = this.f109679d;
            if (weakReference != null) {
                gdtVideoCommonView = weakReference.get();
            } else {
                gdtVideoCommonView = null;
            }
            if (gdtVideoCommonView == null) {
                QLog.i("GdtVideoCommonView", 1, "onCompletion");
                return;
            }
            QLog.i("GdtVideoCommonView", 1, "weakView onCompletion" + gdtVideoCommonView.f109647e);
            gdtVideoCommonView.f109647e = 7;
            gdtVideoCommonView.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, @NonNull Intent intent) {
            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction()) && intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 1) {
                    QLog.i("GdtVideoCommonView", 1, "ACTION_HEADSET_PLUG HEADSET on");
                    return;
                }
                if (intExtra == 0) {
                    QLog.i("GdtVideoCommonView", 1, "ACTION_HEADSET_PLUG HEADSET off " + GdtVideoCommonView.this.I);
                    GdtVideoCommonView gdtVideoCommonView = GdtVideoCommonView.this;
                    if (gdtVideoCommonView.I) {
                        gdtVideoCommonView.o0();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, @NonNull Intent intent) {
            boolean z16 = true;
            if (GdtVideoCommonView.this.f109664q0) {
                GdtVideoCommonView.this.f109664q0 = false;
                QLog.i("GdtVideoCommonView", 1, "SilentModeReceiver first auto called! so skip!");
                return;
            }
            if (GdtVideoCommonView.this.J0 != null && "android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(intent.getAction()) && GdtVideoCommonView.this.f109645d != null) {
                int ringerMode = GdtVideoCommonView.this.J0.getRingerMode();
                int streamVolume = SystemMethodProxy.getStreamVolume(GdtVideoCommonView.this.J0, 3);
                QLog.i("GdtVideoCommonView", 1, "system context mode: " + ringerMode);
                if (ringerMode != 2) {
                    GdtVideoCommonView gdtVideoCommonView = GdtVideoCommonView.this;
                    gdtVideoCommonView.f109662o0 = true;
                    gdtVideoCommonView.H0 = false;
                    GdtVideoCommonView.this.f109645d.setOutputMute(true);
                } else {
                    GdtVideoCommonView gdtVideoCommonView2 = GdtVideoCommonView.this;
                    gdtVideoCommonView2.f109662o0 = false;
                    if (streamVolume > 0) {
                        gdtVideoCommonView2.H0 = true;
                    }
                    GdtVideoCommonView.this.f109645d.setOutputMute(!GdtVideoCommonView.this.H0);
                    z16 = true ^ GdtVideoCommonView.this.H0;
                }
                GdtVideoCommonView gdtVideoCommonView3 = GdtVideoCommonView.this;
                gdtVideoCommonView3.w0(streamVolume, gdtVideoCommonView3.I, false, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface g {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface h {
        void a(GdtVideoCommonView gdtVideoCommonView);

        void b(GdtVideoCommonView gdtVideoCommonView);

        void c(GdtVideoCommonView gdtVideoCommonView);

        void d(View view);

        void e(GdtVideoCommonView gdtVideoCommonView);
    }

    public GdtVideoCommonView(Context context) {
        super(context);
        this.f109649f = -1L;
        this.C = 0L;
        this.D = 10000;
        this.F = 0;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = -1;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = "0";
        this.U = false;
        this.f109643b0 = 0L;
        this.f109644c0 = false;
        this.f109660m0 = -16777216;
        this.f109662o0 = false;
        this.f109664q0 = true;
        this.f109666s0 = new GdtImpressionReporter.GdtVideoReportInfo();
        this.f109668u0 = new ArrayList<>();
        this.H0 = true;
        this.M0 = -1L;
        this.N0 = new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.7
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("GdtVideoCommonView", 1, "showTisJob " + GdtVideoCommonView.this.f109644c0);
                if (!GdtVideoCommonView.this.f109644c0) {
                    GdtVideoCommonView.this.f109644c0 = true;
                    GdtVideoCommonView.this.f109673z0.setVisibility(8);
                    GdtVideoCommonView.this.A0.setVisibility(8);
                    GdtVideoCommonView.this.f109642a0.setVisibility(0);
                    GdtVideoCommonView.this.G0.setVisibility(0);
                    if (GdtVideoCommonView.this.f109643b0 > 0) {
                        GdtVideoCommonView.this.V.setText(String.format(GdtVideoCommonView.this.f109652h.getString(R.string.f170026db), FileUtils.getFileSize(GdtVideoCommonView.this.f109643b0)));
                        GdtVideoCommonView.this.V.setVisibility(0);
                        GdtVideoCommonView.this.W.setVisibility(8);
                        return;
                    }
                    GdtVideoCommonView.this.V.setVisibility(8);
                    GdtVideoCommonView.this.W.setVisibility(0);
                }
            }
        };
        this.O0 = new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.8
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (GdtVideoCommonView.this.d0()) {
                    long currentPositionMs = GdtVideoCommonView.this.f109645d.getCurrentPositionMs();
                    if (currentPositionMs != 0) {
                        if (GdtVideoCommonView.this.f109649f > 0) {
                            i3 = (int) (((GdtVideoCommonView.this.D * currentPositionMs) / GdtVideoCommonView.this.f109649f) + 0.5d);
                        } else {
                            i3 = 0;
                        }
                        if (currentPositionMs < 0) {
                            currentPositionMs = 0;
                        }
                        if (!GdtVideoCommonView.this.E) {
                            GdtVideoCommonView.this.B0.setProgress(i3);
                            GdtVideoCommonView.this.C0.setProgress(i3);
                            GdtVideoCommonView.this.F0.setText(GdtUIUtils.getTotalTimeStr(currentPositionMs));
                        }
                    }
                    GdtVideoCommonView.this.f109654i.postDelayed(this, 50L);
                }
            }
        };
        this.P0 = new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.9
            @Override // java.lang.Runnable
            public void run() {
                if (GdtVideoCommonView.this.f109647e == 5) {
                    GdtVideoCommonView.this.C0.setVisibility(0);
                    GdtVideoCommonView.this.D0.setVisibility(8);
                    GdtVideoCommonView.this.A0.setVisibility(8);
                }
                GdtVideoCommonView.this.R();
            }
        };
        this.Q0 = new a();
        this.R0 = false;
        this.f109652h = context;
        this.f109654i = new Handler(Looper.getMainLooper());
        View.inflate(context, R.layout.f167996oi, this);
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        ISuperPlayer iSuperPlayer = this.f109645d;
        if (iSuperPlayer == null) {
            QLog.i("GdtVideoCommonView", 1, "checkIsCompleted return mVideoPlayer == null");
            return;
        }
        long currentPositionMs = iSuperPlayer.getCurrentPositionMs();
        GdtVideoData gdtVideoData = this.f109659m;
        if (gdtVideoData != null && gdtVideoData.isLoop() && this.I) {
            if (Math.abs(this.f109659m.getDurationMillis() - currentPositionMs) < 1000) {
                if (!this.R0) {
                    f0();
                }
                this.R0 = true;
            } else {
                this.R0 = false;
            }
            this.f109654i.postDelayed(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.12
                @Override // java.lang.Runnable
                public void run() {
                    GdtVideoCommonView.this.O();
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f109654i.post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.6
                @Override // java.lang.Runnable
                public void run() {
                    GdtVideoCommonView.this.Q();
                }
            });
            return;
        }
        QLog.i("GdtVideoCommonView", 1, "doStartPlay " + this.N);
        if (this.f109645d == null) {
            QLog.i("GdtVideoCommonView", 1, "doStartPlay return mVideoPlayer == null");
            return;
        }
        if (this.f109662o0) {
            QLog.i("GdtVideoCommonView", 1, "doStartPlay isSilentMode is true");
            this.H0 = false;
        }
        this.f109645d.setOutputMute(!this.H0);
        this.f109645d.start();
        this.f109647e = 5;
        updateView();
        w0(SystemMethodProxy.getStreamVolume(this.J0, 3), true, false, !this.H0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (this.f109661n0) {
            this.C0.setVisibility(8);
            this.B0.setVisibility(8);
            this.D0.setVisibility(8);
            this.A0.setVisibility(8);
            findViewById(R.id.lqb).setVisibility(8);
            this.G0.setVisibility(8);
            this.f109673z0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        Handler handler = this.f109654i;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.11
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    int streamVolume = SystemMethodProxy.getStreamVolume(GdtVideoCommonView.this.J0, 3);
                    if (GdtVideoCommonView.this.f109645d != null) {
                        boolean z17 = false;
                        if (streamVolume <= 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        ISuperPlayer iSuperPlayer = GdtVideoCommonView.this.f109645d;
                        if (streamVolume <= 0) {
                            z17 = true;
                        }
                        iSuperPlayer.setOutputMute(z17);
                    } else {
                        z16 = true;
                    }
                    GdtVideoCommonView gdtVideoCommonView = GdtVideoCommonView.this;
                    gdtVideoCommonView.w0(streamVolume, gdtVideoCommonView.I, true, z16);
                }
            });
        }
    }

    private void V() {
        this.f109642a0.setVisibility(8);
    }

    private void X() {
        boolean z16;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && !(runtime instanceof QQAppInterface) && !AppSetting.f99565y) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) this.f109652h.getSystemService("accessibility");
                boolean isEnabled = accessibilityManager.isEnabled();
                boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
                if (isEnabled && isTouchExplorationEnabled) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AppSetting.f99565y = z16;
            } catch (Throwable th5) {
                QLog.e("GdtVideoCommonView", 1, "initAppSettingInOntherProcess", th5);
            }
        }
    }

    private void Y(Context context) {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            Z(context);
        } else {
            b0(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(Context context) {
        QLog.i("GdtVideoCommonView", 1, "initVideo " + this.N);
        this.f109647e = 2;
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
        this.f109670w0 = createPlayerVideoView;
        if (createPlayerVideoView != null) {
            setBackgroundColor(this.f109660m0);
            this.f109665r0.setBackgroundColor(this.f109660m0);
            Object obj = this.f109670w0;
            if (obj instanceof View) {
                View view = (View) obj;
                view.setBackgroundColor(this.f109660m0);
                view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                addView(view, 0);
            } else {
                QLog.i("GdtVideoCommonView", 1, "!mVideoView instanceof View)");
            }
            ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 110, this.f109670w0);
            this.f109645d = createMediaPlayer;
            if (createMediaPlayer == null) {
                QLog.i("GdtVideoCommonView", 1, "initVideo return mVideoPlayer == null");
                return;
            }
            createMediaPlayer.setOnVideoPreparedListener(this);
            this.f109645d.setOnCompletionListener(new c(new WeakReference(this)));
            this.f109645d.setOnTVideoNetInfoUpdateListener(this);
            this.f109645d.setOnErrorListener(this);
            x0();
            QLog.i("GdtVideoCommonView", 1, "initVideo isSilentMode = " + this.f109662o0 + ", isVolumOpen = " + this.H0);
            if (this.f109662o0) {
                this.H0 = false;
            }
            this.f109645d.setOutputMute(!this.H0);
            w0(SystemMethodProxy.getStreamVolume(this.J0, 3), true, false, !this.H0);
            q0(this.C);
        }
    }

    private void a0() {
        if (NetworkUtil.isWifiEnabled(this.f109652h)) {
            this.F = 1;
        } else if (NetworkUtil.isNetSupport(this.f109652h)) {
            this.F = 2;
        }
        QLog.i("GdtVideoCommonView", 1, "netType " + this.F);
        this.f109669v0 = (ResizeURLImageView) findViewById(R.id.csj);
        this.f109671x0 = findViewById(R.id.efs);
        this.f109672y0 = findViewById(R.id.c2a);
        this.I0 = findViewById(R.id.csm);
        this.D0 = (LinearLayout) findViewById(R.id.csf);
        this.A0 = (ImageView) findViewById(R.id.csd);
        this.f109673z0 = (ImageView) findViewById(R.id.cse);
        this.F0 = (TextView) findViewById(R.id.g1m);
        this.B0 = (SeekBar) findViewById(R.id.ilh);
        this.C0 = (SeekBar) findViewById(R.id.ilj);
        this.B0.setMax(this.D);
        this.C0.setMax(this.D);
        this.E0 = (TextView) findViewById(R.id.jut);
        int dp2px = GdtUIUtils.dp2px(5.0f, getResources());
        ImageView imageView = (ImageView) findViewById(R.id.csl);
        this.G0 = imageView;
        GdtUIUtils.expandViewTouchDelegate(imageView, dp2px, dp2px, dp2px, dp2px);
        ImageView imageView2 = (ImageView) findViewById(R.id.csk);
        this.P = imageView2;
        GdtUIUtils.expandViewTouchDelegate(imageView2, dp2px, dp2px, dp2px, dp2px);
        this.P.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.close);
        this.Q = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f109642a0 = findViewById(R.id.csi);
        TextView textView = (TextView) findViewById(R.id.csg);
        this.V = textView;
        textView.setOnClickListener(this);
        View findViewById = findViewById(R.id.csh);
        this.W = findViewById;
        findViewById.setOnClickListener(this);
        this.A0.setOnClickListener(this);
        this.I0.setOnClickListener(this);
        this.G0.setOnClickListener(this);
        this.B0.setOnSeekBarChangeListener(this);
        this.f109672y0.setOnClickListener(this);
        this.f109673z0.setOnClickListener(this);
        this.J0 = (AudioManager) getContext().getSystemService("audio");
        ((Activity) this.f109652h).setVolumeControlStream(3);
        VolumeChangeObserver volumeChangeObserver = new VolumeChangeObserver(this.f109652h);
        this.K0 = volumeChangeObserver;
        volumeChangeObserver.registerReceiver();
        this.K0.setListener(new b());
        AppNetConnInfo.registerConnectionChangeReceiver(this.f109652h.getApplicationContext(), this.Q0);
        this.L0 = new d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        this.f109652h.registerReceiver(this.L0, intentFilter);
        this.f109663p0 = new f();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.media.RINGER_MODE_CHANGED");
        this.f109652h.registerReceiver(this.f109663p0, intentFilter2);
        this.f109653h0 = findViewById(R.id.f164382vp);
        this.f109655i0 = (Button) findViewById(R.id.crw);
        this.f109656j0 = (Button) findViewById(R.id.cru);
        this.f109657k0 = (TextView) findViewById(R.id.crx);
        this.f109658l0 = (ImageView) findViewById(R.id.crv);
        this.f109655i0.setOnClickListener(this);
        this.f109656j0.setOnClickListener(this);
        this.f109665r0 = findViewById(R.id.f1175971v);
        W();
    }

    private void b0(final Context context) {
        this.f109647e = 1;
        try {
            QLog.i("VideoGdtGdtVideoCommonView", 1, "installSDK");
            QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new SDKInitListener() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.3
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    QLog.i("VideoGdtGdtVideoCommonView", 1, "onSDKInited " + z16);
                    if (z16) {
                        GdtVideoCommonView.this.f109654i.post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                GdtVideoCommonView.this.Z(context);
                            }
                        });
                    }
                }
            });
        } catch (Throwable th5) {
            QLog.e("VideoGdtGdtVideoCommonView", 1, "installSDK", th5);
        }
    }

    private void e0(boolean z16) {
        QLog.i("GdtVideoCommonView", 1, "letsShowOff " + z16 + " " + this.N + " mVideoState " + this.f109647e);
        if (this.f109647e != 5) {
            return;
        }
        this.f109654i.removeCallbacks(this.P0);
        if (z16) {
            this.C0.setVisibility(4);
            this.D0.setVisibility(0);
            this.A0.setVisibility(0);
            this.f109654i.postDelayed(this.P0, 2000L);
        } else {
            this.C0.setVisibility(0);
            this.D0.setVisibility(8);
            this.A0.setVisibility(8);
        }
        R();
    }

    private void f0() {
        GdtVideoReportListenerImp gdtVideoReportListenerImp = this.f109667t0;
        if (gdtVideoReportListenerImp != null) {
            gdtVideoReportListenerImp.onCompleted(this.f109659m, this.f109666s0);
        }
        Iterator<h> it = this.f109668u0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        s0(false);
    }

    private void g0() {
        GdtVideoReportListenerImp gdtVideoReportListenerImp = this.f109667t0;
        if (gdtVideoReportListenerImp != null) {
            gdtVideoReportListenerImp.onError(this.f109659m, this.f109645d.getCurrentPositionMs(), this.f109666s0);
        }
        s0(false);
    }

    private void i0() {
        GdtVideoReportListenerImp gdtVideoReportListenerImp = this.f109667t0;
        if (gdtVideoReportListenerImp != null) {
            int i3 = this.J;
            if (i3 > 0) {
                gdtVideoReportListenerImp.onStarted(this.f109659m, i3);
                this.J = -1;
            } else {
                ISuperPlayer iSuperPlayer = this.f109645d;
                if (iSuperPlayer == null) {
                    QLog.i("GdtVideoCommonView", 1, "notifyStarted return mVideoPlayer == null");
                    return;
                }
                gdtVideoReportListenerImp.onStarted(this.f109659m, iSuperPlayer.getCurrentPositionMs());
            }
            O();
        }
        Iterator<h> it = this.f109668u0.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    private void j0() {
        ISuperPlayer iSuperPlayer;
        GdtVideoReportListenerImp gdtVideoReportListenerImp = this.f109667t0;
        if (gdtVideoReportListenerImp != null && (iSuperPlayer = this.f109645d) != null) {
            gdtVideoReportListenerImp.onStopped(this.f109659m, iSuperPlayer.getCurrentPositionMs(), this.f109666s0);
        }
        Iterator<h> it = this.f109668u0.iterator();
        while (it.hasNext()) {
            it.next().e(this);
        }
        s0(false);
    }

    private void k0(View view) {
        Iterator<h> it = this.f109668u0.iterator();
        while (it.hasNext()) {
            it.next().d(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        if (d0()) {
            QLog.i("GdtVideoCommonView", 1, "pauseVideoInternal " + this.N);
            this.f109645d.pause();
            this.f109647e = 6;
            this.f109654i.removeCallbacksAndMessages(null);
            updateView();
        } else {
            QLog.i("GdtVideoCommonView", 1, "pauseVideoInternal return " + this.N);
        }
        s0(false);
    }

    private void q0(long j3) {
        SuperPlayerVideoInfo createVideoInfoForTVideo;
        QLog.i("GdtVideoCommonView", 1, "playVideo startElapsed -->" + j3 + "|" + this.f109647e + " " + this.N);
        ISuperPlayer iSuperPlayer = this.f109645d;
        if (iSuperPlayer != null && !iSuperPlayer.isPlaying() && this.f109647e != 3) {
            this.f109647e = 3;
            String tencent_video_id = this.f109659m.getAd().getTencent_video_id();
            String url = this.f109659m.getUrl();
            StringBuffer stringBuffer = new StringBuffer("playVideo url=");
            stringBuffer.append(url);
            stringBuffer.append(",vid=");
            stringBuffer.append(tencent_video_id);
            QLog.i("GdtVideoCommonView", 1, stringBuffer.toString());
            if (!TextUtils.isEmpty(url)) {
                createVideoInfoForTVideo = SuperPlayerFactory.createVideoInfoForUrl(url, 104, tencent_video_id, (String) null);
            } else if (!TextUtils.isEmpty(tencent_video_id)) {
                createVideoInfoForTVideo = SuperPlayerFactory.createVideoInfoForTVideo(PlatformInfo.ID_GDTAD, tencent_video_id);
            } else {
                return;
            }
            this.f109645d.reset();
            x0();
            this.f109645d.openMediaPlayer(this.f109652h, createVideoInfoForTVideo, j3);
            if (this.f109647e == 8) {
                QLog.i("GdtVideoCommonView", 1, "playVideo STATE_ERROR return -->" + j3);
                return;
            }
            updateView();
        }
    }

    private void s0(boolean z16) {
        if (z16) {
            QLog.i("GdtVideoCommonView", 1, "[requestSystemAudioFocus] gain is called!");
            this.J0.requestAudioFocus(null, 3, 2);
        } else {
            QLog.i("GdtVideoCommonView", 1, "[requestSystemAudioFocus] release is called!");
            this.J0.abandonAudioFocus(null);
        }
    }

    private void t0() {
        QLog.i("GdtVideoCommonView", 1, "resumeVideByNet netType " + this.F + " " + this.N);
        int i3 = this.F;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    if (this.G) {
                        Q();
                        return;
                    } else {
                        this.f109654i.removeCallbacks(this.N0);
                        this.f109654i.postDelayed(this.N0, 500L);
                        return;
                    }
                }
                return;
            }
            Q();
            return;
        }
        com.tencent.mobileqq.filemanager.util.d.e(R.string.f170027dc);
        this.f109647e = 8;
        this.f109666s0.setErrorType(2);
        updateView();
    }

    private void v0() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i3, boolean z16, boolean z17, boolean z18) {
        if (z16 && this.f109645d != null) {
            QLog.i("GdtVideoCommonView", 1, "setStateOfMediaSound volume =" + i3 + " viewReusmed " + z16 + " isFromVolumeChanged " + z17 + " isSilentMode = " + this.f109662o0 + ", isVolumOpen = " + this.H0 + ", hasNotifyCompleted = " + this.R0 + "\uff0cisOutputMute = " + z18);
            if (i3 > 0) {
                if (z18 && !z17) {
                    this.H0 = false;
                    this.G0.setBackgroundResource(R.drawable.cra);
                } else {
                    this.G0.setBackgroundResource(R.drawable.crb);
                    this.H0 = true;
                    if (AppSetting.f99565y) {
                        this.G0.setContentDescription(HardCodeUtil.qqStr(R.string.n1m));
                    }
                }
            } else {
                this.G0.setBackgroundResource(R.drawable.cra);
                this.H0 = false;
                if (AppSetting.f99565y) {
                    this.G0.setContentDescription(HardCodeUtil.qqStr(R.string.n1t));
                }
            }
            int i16 = this.f109647e;
            if (i16 != 6 && i16 != 8 && i16 != 7) {
                s0(this.H0);
            }
            R();
        }
    }

    private void x0() {
        GdtVideoData gdtVideoData = this.f109659m;
        if (gdtVideoData != null && this.f109645d != null) {
            if (gdtVideoData.isLoop()) {
                this.f109645d.setLoopback(true);
            } else {
                this.f109645d.setLoopback(false);
            }
            QLog.i("GdtVideoCommonView", 1, "setVideoPlayByData dataLoop=" + this.f109659m.isLoop() + ",videoLoop = " + this.f109645d.isLoopBack());
            return;
        }
        QLog.i("GdtVideoCommonView", 1, "setVideoPlayByData failed");
    }

    private void y0() {
        GdtAd gdtAd;
        if (this.f109653h0.getVisibility() == 0 && this.f109659m != null) {
            QLog.i("GdtVideoCommonView", 1, "updateDownloadBtnLable " + this.N);
            if (this.f109659m.getAd() instanceof GdtAd) {
                gdtAd = this.f109659m.getAd();
            } else {
                gdtAd = null;
            }
            if (gdtAd == null) {
                QLog.i("GdtVideoCommonView", 1, "updateDownloadBtnLable gdtAd == null " + this.N);
                return;
            }
            if (gdtAd.isAppProductType()) {
                if (PackageUtil.isAppInstalled(this.f109652h, gdtAd.getAppPackageName())) {
                    this.f109656j0.setText(HardCodeUtil.qqStr(R.string.n1r));
                    return;
                } else if (com.tencent.gdtad.util.g.a(this.f109652h, gdtAd.getAppPackageName())) {
                    this.f109656j0.setText(HardCodeUtil.qqStr(R.string.n1j));
                    return;
                } else {
                    this.f109656j0.setText(HardCodeUtil.qqStr(R.string.n1n));
                    return;
                }
            }
            this.f109656j0.setText(HardCodeUtil.qqStr(R.string.n1u));
        }
    }

    private void z0() {
        GdtVideoData gdtVideoData;
        if (!c0() && (gdtVideoData = this.f109659m) != null && !gdtVideoData.isLoop() && this.f109659m.getAd().getProductType() != 19) {
            this.f109671x0.setVisibility(8);
            this.f109672y0.setVisibility(8);
            this.A0.setVisibility(8);
            this.D0.setVisibility(4);
            this.G0.setVisibility(4);
            this.f109673z0.setVisibility(8);
            V();
            this.f109669v0.setVisibility(0);
            this.f109665r0.setVisibility(0);
            this.f109653h0.setVisibility(0);
            y0();
        } else {
            this.f109653h0.setVisibility(8);
            this.f109671x0.setVisibility(8);
            this.f109672y0.setVisibility(8);
            this.A0.setVisibility(8);
            this.G0.setVisibility(4);
            V();
            GdtVideoData gdtVideoData2 = this.f109659m;
            if (gdtVideoData2 != null && gdtVideoData2.getPlayScene() == 7 && this.f109645d != null) {
                p0();
            } else {
                this.f109669v0.setVisibility(0);
                this.f109673z0.setVisibility(0);
            }
        }
        R();
    }

    public void N(h hVar) {
        if (!this.f109668u0.contains(hVar)) {
            this.f109668u0.add(hVar);
        }
    }

    public void P(int i3, boolean z16, boolean z17) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" doResumeVideo " + i3);
        sb5.append(" isViewResume " + z16);
        sb5.append(" stopPlayByUser " + z17);
        sb5.append(" mVideoState " + this.f109647e + " " + this.N);
        QLog.i("GdtVideoCommonView", 1, sb5.toString());
        if (!z17 && z16) {
            int i16 = this.f109647e;
            if (i16 == 4 || i16 == 6) {
                t0();
            }
        }
    }

    public long S() {
        ISuperPlayer iSuperPlayer = this.f109645d;
        if (iSuperPlayer == null) {
            return 0L;
        }
        return iSuperPlayer.getCurrentPositionMs();
    }

    @NonNull
    public GdtImpressionReporter.GdtVideoReportInfo T() {
        return this.f109666s0;
    }

    public void W() {
        X();
        if (AppSetting.f99565y) {
            this.f109673z0.setContentDescription(HardCodeUtil.qqStr(R.string.n1v));
            this.B0.setContentDescription(HardCodeUtil.qqStr(R.string.n1w));
        }
    }

    public boolean c0() {
        return this.U;
    }

    public boolean d0() {
        if (this.f109645d != null && this.f109647e == 5) {
            return true;
        }
        return false;
    }

    public void l0() {
        f fVar;
        d dVar;
        QLog.i("GdtVideoCommonView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        r0();
        this.f109654i.removeCallbacksAndMessages(null);
        VolumeChangeObserver volumeChangeObserver = this.K0;
        if (volumeChangeObserver != null) {
            volumeChangeObserver.unregisterReceiver();
        }
        INetInfoHandler iNetInfoHandler = this.Q0;
        if (iNetInfoHandler != null) {
            AppNetConnInfo.unregisterNetInfoHandler(iNetInfoHandler);
        }
        Context context = this.f109652h;
        if (context != null && (dVar = this.L0) != null) {
            context.unregisterReceiver(dVar);
        }
        Context context2 = this.f109652h;
        if (context2 != null && (fVar = this.f109663p0) != null) {
            context2.unregisterReceiver(fVar);
        }
        if (this.f109667t0 != null) {
            this.f109667t0 = null;
        }
    }

    public void m0() {
        this.H = true;
        o0();
    }

    public void n0() {
        QLog.i("GdtVideoCommonView", 1, "pauseVideo " + this.N);
        this.I = false;
        o0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.M0 < 350) {
            QLog.i("GdtVideoCommonView", 1, "onClick too fast not allowed  " + this.N);
        } else {
            this.M0 = currentTimeMillis;
            int id5 = view.getId();
            boolean z16 = false;
            if (id5 == R.id.csm) {
                if (this.A0.getVisibility() == 0) {
                    z16 = true;
                }
                e0(!z16);
                k0(view);
            } else if (id5 == R.id.cse) {
                QLog.i("GdtVideoCommonView", 1, "onClick  gdt_video_center_play mVideoState " + this.f109647e + " " + this.N);
                p0();
            } else if (id5 == R.id.csd) {
                QLog.i("GdtVideoCommonView", 1, "onClick  gdt_video_center_pause mVideoState " + this.f109647e + " " + this.N);
                this.f109666s0.setFinishType(1);
                m0();
            } else if (id5 == R.id.csl) {
                ISuperPlayer iSuperPlayer = this.f109645d;
                if (iSuperPlayer == null) {
                    QLog.i("GdtVideoCommonView", 1, "gdt_video_volume_switch click return mVideoPlayer == null");
                } else if (iSuperPlayer.isOutputMute()) {
                    this.f109645d.setOutputMute(false);
                    w0(1, true, false, false);
                } else {
                    this.f109645d.setOutputMute(true);
                    w0(0, true, false, true);
                }
            } else if (id5 == R.id.c2a) {
                q0(this.C);
            } else if (id5 == R.id.csk) {
                g gVar = this.S0;
                if (gVar != null) {
                    if (this.U) {
                        gVar.b();
                    } else {
                        gVar.a();
                    }
                }
            } else if (id5 != R.id.csg && id5 != R.id.csh) {
                if (id5 == R.id.close) {
                    QLog.i("GdtVideoCommonView", 1, "onClick  closeBtn exitFullScreen " + this.U + " " + this.N);
                    if (this.U) {
                        g gVar2 = this.S0;
                        if (gVar2 != null) {
                            gVar2.b();
                        }
                    } else {
                        Context context = this.f109652h;
                        if (context != null) {
                            Activity activity = (Activity) context;
                            activity.finish();
                            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        }
                    }
                } else if (id5 == R.id.crw) {
                    QLog.i("GdtVideoCommonView", 1, "click playagain mVideoState " + this.f109647e + " " + this.N);
                    this.f109653h0.setVisibility(8);
                    p0();
                } else if (id5 == R.id.cru) {
                    QLog.i("GdtVideoCommonView", 1, "click download mVideoState " + this.f109647e + " " + this.N);
                    Context context2 = this.f109652h;
                    if (context2 != null && (context2 instanceof Activity)) {
                        GdtHandler.Params params = new GdtHandler.Params();
                        params.processId = 7;
                        params.activity = new WeakReference<>((Activity) context2);
                        params.f108486ad = this.f109659m.getAd();
                        params.reportForClick = false;
                        params.appAutoDownload = true;
                        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                    }
                }
            } else {
                p0();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        this.f109647e = 7;
        updateView();
        QLog.i("GdtVideoCommonView", 1, "onCompletion" + this.f109647e);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        QLog.i("GdtVideoCommonView", 1, "onError errorType " + i16 + " errorCode " + i17 + " extraInfo " + str);
        this.f109647e = 8;
        this.f109666s0.setErrorTypeFromSP(i16, i17);
        QQToast.makeText(this.f109652h, HardCodeUtil.qqStr(R.string.n1k), 0).show();
        updateView();
        return false;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (z16) {
            this.E = true;
            this.F0.setText(GdtUIUtils.getTotalTimeStr((i3 * this.f109649f) / this.D));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        QLog.i("GdtVideoCommonView", 1, "onStartTrackingTouch " + this.f109647e);
        this.f109654i.removeCallbacksAndMessages(null);
        this.E = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NonNull SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch " + this.f109647e);
        this.E = false;
        this.J = (int) ((((long) seekBar.getProgress()) * this.f109649f) / ((long) this.D));
        v0();
        int i3 = this.f109647e;
        if (i3 >= 4 && i3 <= 6) {
            ISuperPlayer iSuperPlayer = this.f109645d;
            if (iSuperPlayer == null) {
                QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch return mVideoPlayer == null");
            } else if (i3 != 6 && i3 != 5 && i3 != 4) {
                QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch no answer " + this.f109647e);
            } else {
                if (i3 == 4 || i3 == 6) {
                    iSuperPlayer.start();
                }
                this.f109645d.seekTo(this.J);
                this.f109647e = 5;
                updateView();
            }
        } else {
            q0(this.J);
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
    public void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer, @Nullable TVideoNetInfo tVideoNetInfo) {
        if (tVideoNetInfo == null) {
            QLog.i("GdtVideoCommonView", 1, "onTVideoNetInfoUpdate netInfo == null");
            return;
        }
        this.f109643b0 = tVideoNetInfo.getVideoSize();
        QLog.i("GdtVideoCommonView", 1, "onTVideoNetInfoUpdate size:" + this.f109643b0 + " hasShowTips " + this.f109644c0);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        ISuperPlayer iSuperPlayer2;
        QLog.i("GdtVideoCommonView", 1, "onVideoPrepared " + this.f109647e + " isViewResume " + this.I + " " + this.N);
        if (this.f109649f < 0 && (iSuperPlayer2 = this.f109645d) != null) {
            this.f109649f = iSuperPlayer2.getDurationMs();
            if (this.f109659m.getDurationMillis() <= 0) {
                this.f109659m.setDurationMillis(this.f109649f);
            }
            if (this.f109649f < 1000 && !this.M) {
                this.M = true;
                QLog.i("GdtVideoCommonView", 1, "Video error for reason:<1s ");
                if (this.f109667t0 != null) {
                    this.f109666s0.setErrorType(3);
                    this.f109667t0.onError(this.f109659m, this.f109645d.getCurrentPositionMs(), this.f109666s0);
                }
            }
            this.f109654i.post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.4
                @Override // java.lang.Runnable
                public void run() {
                    GdtVideoCommonView.this.E0.setText(GdtUIUtils.getTotalTimeStr(GdtVideoCommonView.this.f109649f));
                }
            });
        }
        this.f109654i.post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onVideoPrepared] is resumeRunnable in main thread:");
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i("GdtVideoCommonView", 1, sb5.toString());
                int i3 = GdtVideoCommonView.this.f109647e;
                if (i3 == 3 || i3 == 5) {
                    GdtVideoCommonView.this.f109647e = 4;
                    GdtVideoCommonView gdtVideoCommonView = GdtVideoCommonView.this;
                    gdtVideoCommonView.P(3, gdtVideoCommonView.I, gdtVideoCommonView.H);
                }
            }
        });
        Iterator<h> it = this.f109668u0.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public void p0() {
        this.H = false;
        this.G = true;
        v0();
        int i3 = this.f109647e;
        if (i3 != 6 && i3 != 4) {
            q0(this.C);
        } else {
            P(2, this.I, false);
        }
    }

    public void r0() {
        QLog.i("GdtVideoCommonView", 1, "releaseMediaPlayer");
        ISuperPlayer iSuperPlayer = this.f109645d;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
            this.f109645d.release();
            this.f109645d = null;
        }
    }

    public void setData(@NonNull GdtVideoData gdtVideoData) {
        int i3;
        boolean z16;
        this.f109659m = gdtVideoData;
        this.G = gdtVideoData.isDirectPlay();
        this.f109660m0 = gdtVideoData.getVideoDefaultBackgroundColor();
        this.f109661n0 = gdtVideoData.isForceNotShowControllerView();
        if (!this.G && this.F != 1) {
            i3 = 12;
        } else {
            i3 = 11;
        }
        this.f109666s0.setPlayType(i3);
        this.C = gdtVideoData.getStartPositionMillis();
        this.H0 = gdtVideoData.isVolumOpen();
        if (this.J0.getRingerMode() != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f109662o0 = z16;
        Y(this.f109652h);
        if (!TextUtils.isEmpty(gdtVideoData.getCoverUrl())) {
            try {
                this.f109669v0.setImage(new URL(gdtVideoData.getCoverUrl()));
            } catch (Exception e16) {
                QLog.e("GdtVideoCommonView", 1, "getCoverUrl", e16);
            }
        }
        String advertiser_corporate_logo = this.f109659m.getAd().getAdvertiser_corporate_logo();
        String advertiser_corporate_image_name = this.f109659m.getAd().getAdvertiser_corporate_image_name();
        if (!TextUtils.isEmpty(advertiser_corporate_logo)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Resources resources = getResources();
            obtain.mLoadingDrawable = resources.getDrawable(R.drawable.aee);
            obtain.mFailedDrawable = resources.getDrawable(R.drawable.aee);
            URLDrawable drawable = URLDrawable.getDrawable(advertiser_corporate_logo, obtain);
            int f16 = BaseAIOUtils.f(55.0f, resources);
            drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(f16, f16, GdtUIUtils.getOffsetByBaseline(21, 750, GdtUIUtils.getMinScreenSize(this.f109652h))));
            drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306324d);
            this.f109658l0.setImageDrawable(drawable);
        }
        if (!TextUtils.isEmpty(advertiser_corporate_image_name)) {
            this.f109657k0.setText(advertiser_corporate_image_name);
        }
        if (gdtVideoData.needReport()) {
            this.f109667t0 = new GdtVideoReportListenerImp(this.f109659m.getPlayScene());
        }
        R();
    }

    public void setGdtVideoFcIcon(int i3) {
        this.P.setImageDrawable(getResources().getDrawable(i3));
    }

    public void setOnVideoFullScreen(g gVar) {
        this.S0 = gVar;
    }

    public void setisFullScreen(boolean z16, int i3) {
        if (this.U != z16) {
            this.U = z16;
            if (z16) {
                Activity activity = (Activity) getContext();
                Window window = activity.getWindow();
                window.setFlags(1024, 1024);
                activity.setRequestedOrientation(0);
                View decorView = window.getDecorView();
                this.T = decorView.getSystemUiVisibility();
                decorView.setSystemUiVisibility(3846);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                this.R = layoutParams.width;
                this.S = layoutParams.height;
                int[] portraitScreenSize = GdtUIUtils.getPortraitScreenSize(activity);
                int i16 = portraitScreenSize[0];
                layoutParams.width = portraitScreenSize[1];
                layoutParams.height = i16;
                setLayoutParams(layoutParams);
                setGdtVideoFcIcon(R.drawable.d8m);
                setGdtVideoCloseIcon(i3);
                ViewParent parent = getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    this.f109646d0 = viewGroup.getPaddingTop();
                    this.f109648e0 = viewGroup.getPaddingBottom();
                    this.f109650f0 = viewGroup.getPaddingLeft();
                    this.f109651g0 = viewGroup.getPaddingRight();
                    viewGroup.setPadding(0, 0, 0, 0);
                    return;
                }
                return;
            }
            Activity activity2 = (Activity) getContext();
            activity2.getWindow().setFlags(1024, 8);
            activity2.setRequestedOrientation(1);
            activity2.getWindow().getDecorView().setSystemUiVisibility(this.T);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            layoutParams2.width = this.R;
            layoutParams2.height = this.S;
            ViewParent parent2 = getParent();
            if (parent2 != null && (parent2 instanceof ViewGroup)) {
                ((ViewGroup) parent2).setPadding(this.f109650f0, this.f109646d0, this.f109651g0, this.f109648e0);
            }
            setLayoutParams(layoutParams2);
            setGdtVideoFcIcon(R.drawable.d8n);
            setGdtVideoCloseIcon(8);
        }
    }

    public void u0() {
        QLog.i("GdtVideoCommonView", 1, "resumeVideo " + this.N);
        v0();
        P(1, this.I, this.H);
        if (this.U) {
            ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(3846);
        }
        y0();
    }

    public void updateView() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f109654i.post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.2
                @Override // java.lang.Runnable
                public void run() {
                    GdtVideoCommonView.this.updateView();
                }
            });
            return;
        }
        QLog.i("GdtVideoCommonView", 1, "updateView " + this.f109647e + " " + this.N);
        if (AppSetting.f99565y) {
            this.A0.setContentDescription(HardCodeUtil.qqStr(R.string.n1o));
        }
        this.f109665r0.setVisibility(8);
        int i3 = this.f109647e;
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 7) {
                        if (i3 != 8) {
                            this.f109653h0.setVisibility(8);
                            this.f109671x0.setVisibility(8);
                            this.f109672y0.setVisibility(8);
                            this.f109669v0.setVisibility(0);
                            this.f109673z0.setVisibility(8);
                            this.A0.setVisibility(0);
                            this.G0.setVisibility(4);
                            V();
                        } else {
                            this.f109653h0.setVisibility(8);
                            this.f109671x0.setVisibility(8);
                            this.f109672y0.setVisibility(0);
                            this.f109669v0.setVisibility(8);
                            this.f109673z0.setVisibility(8);
                            this.A0.setVisibility(8);
                            this.G0.setVisibility(0);
                            V();
                            g0();
                        }
                    } else {
                        z0();
                        f0();
                    }
                } else {
                    this.f109653h0.setVisibility(8);
                    this.f109671x0.setVisibility(8);
                    this.f109672y0.setVisibility(8);
                    if (this.H) {
                        this.f109669v0.setVisibility(8);
                    } else {
                        Context context = this.f109652h;
                        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                            this.f109669v0.setVisibility(0);
                        }
                    }
                    this.A0.setVisibility(8);
                    this.C0.setVisibility(4);
                    this.D0.setVisibility(4);
                    this.G0.setVisibility(4);
                    this.f109673z0.setVisibility(0);
                    V();
                    j0();
                }
            } else {
                this.f109653h0.setVisibility(8);
                this.H = false;
                this.f109671x0.setVisibility(8);
                this.f109672y0.setVisibility(8);
                this.f109669v0.setVisibility(8);
                this.f109673z0.setVisibility(8);
                this.G0.setVisibility(0);
                V();
                e0(false);
                this.f109654i.post(this.O0);
                i0();
            }
        } else {
            this.f109653h0.setVisibility(8);
            this.f109671x0.setVisibility(8);
            this.f109672y0.setVisibility(8);
            this.f109669v0.setVisibility(0);
            this.f109673z0.setVisibility(0);
            this.A0.setVisibility(8);
            this.G0.setVisibility(0);
            V();
        }
        R();
    }

    public void setGdtVideoCloseIcon(int i3) {
    }

    public void setLoadListener(e eVar) {
    }

    public GdtVideoCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f109649f = -1L;
        this.C = 0L;
        this.D = 10000;
        this.F = 0;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = -1;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = "0";
        this.U = false;
        this.f109643b0 = 0L;
        this.f109644c0 = false;
        this.f109660m0 = -16777216;
        this.f109662o0 = false;
        this.f109664q0 = true;
        this.f109666s0 = new GdtImpressionReporter.GdtVideoReportInfo();
        this.f109668u0 = new ArrayList<>();
        this.H0 = true;
        this.M0 = -1L;
        this.N0 = new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.7
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("GdtVideoCommonView", 1, "showTisJob " + GdtVideoCommonView.this.f109644c0);
                if (!GdtVideoCommonView.this.f109644c0) {
                    GdtVideoCommonView.this.f109644c0 = true;
                    GdtVideoCommonView.this.f109673z0.setVisibility(8);
                    GdtVideoCommonView.this.A0.setVisibility(8);
                    GdtVideoCommonView.this.f109642a0.setVisibility(0);
                    GdtVideoCommonView.this.G0.setVisibility(0);
                    if (GdtVideoCommonView.this.f109643b0 > 0) {
                        GdtVideoCommonView.this.V.setText(String.format(GdtVideoCommonView.this.f109652h.getString(R.string.f170026db), FileUtils.getFileSize(GdtVideoCommonView.this.f109643b0)));
                        GdtVideoCommonView.this.V.setVisibility(0);
                        GdtVideoCommonView.this.W.setVisibility(8);
                        return;
                    }
                    GdtVideoCommonView.this.V.setVisibility(8);
                    GdtVideoCommonView.this.W.setVisibility(0);
                }
            }
        };
        this.O0 = new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.8
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (GdtVideoCommonView.this.d0()) {
                    long currentPositionMs = GdtVideoCommonView.this.f109645d.getCurrentPositionMs();
                    if (currentPositionMs != 0) {
                        if (GdtVideoCommonView.this.f109649f > 0) {
                            i3 = (int) (((GdtVideoCommonView.this.D * currentPositionMs) / GdtVideoCommonView.this.f109649f) + 0.5d);
                        } else {
                            i3 = 0;
                        }
                        if (currentPositionMs < 0) {
                            currentPositionMs = 0;
                        }
                        if (!GdtVideoCommonView.this.E) {
                            GdtVideoCommonView.this.B0.setProgress(i3);
                            GdtVideoCommonView.this.C0.setProgress(i3);
                            GdtVideoCommonView.this.F0.setText(GdtUIUtils.getTotalTimeStr(currentPositionMs));
                        }
                    }
                    GdtVideoCommonView.this.f109654i.postDelayed(this, 50L);
                }
            }
        };
        this.P0 = new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoCommonView.9
            @Override // java.lang.Runnable
            public void run() {
                if (GdtVideoCommonView.this.f109647e == 5) {
                    GdtVideoCommonView.this.C0.setVisibility(0);
                    GdtVideoCommonView.this.D0.setVisibility(8);
                    GdtVideoCommonView.this.A0.setVisibility(8);
                }
                GdtVideoCommonView.this.R();
            }
        };
        this.Q0 = new a();
        this.R0 = false;
        this.f109652h = context;
        this.f109654i = new Handler(Looper.getMainLooper());
        View.inflate(context, R.layout.f167996oi, this);
        a0();
    }
}
