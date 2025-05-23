package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.PlayerCallBack;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Formatter;
import java.util.Locale;
import java.util.Set;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes35.dex */
public class IndividualAutoVideoControlView extends FrameLayout {
    public static int U = 5000;
    protected boolean C;
    private boolean D;
    private StringBuilder E;
    private Formatter F;
    private ImageButton G;
    private int H;
    private ImageButton I;
    private int J;
    protected Handler K;
    private int L;
    protected PlayerResources M;
    protected int N;
    private SeekBar.OnSeekBarChangeListener P;
    private View.OnClickListener Q;
    protected View.OnClickListener R;
    protected View.OnClickListener S;
    protected SeekBar.OnSeekBarChangeListener T;

    /* renamed from: d, reason: collision with root package name */
    protected e f279815d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f279816e;

    /* renamed from: f, reason: collision with root package name */
    protected View f279817f;

    /* renamed from: h, reason: collision with root package name */
    protected ProgressBar f279818h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f279819i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f279820m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IndividualAutoVideoControlView.this.g();
            IndividualAutoVideoControlView.this.u(IndividualAutoVideoControlView.U);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IndividualAutoVideoControlView.this.h();
            IndividualAutoVideoControlView.this.u(IndividualAutoVideoControlView.U);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IndividualAutoVideoControlView.this.i();
            IndividualAutoVideoControlView.this.u(IndividualAutoVideoControlView.U);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private int f279824d;

        /* renamed from: e, reason: collision with root package name */
        private int f279825e;

        d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            if (IndividualAutoVideoControlView.this.P != null) {
                IndividualAutoVideoControlView.this.P.onProgressChanged(seekBar, i3, z16);
            }
            if (IndividualAutoVideoControlView.this.f279815d == null) {
                return;
            }
            int progress = seekBar.getProgress();
            this.f279825e = progress;
            if (progress >= this.f279824d) {
                if (!IndividualAutoVideoControlView.this.f279815d.canSeekForward()) {
                    return;
                }
            } else if (!IndividualAutoVideoControlView.this.f279815d.canSeekBackward()) {
                return;
            }
            if (z16) {
                int duration = IndividualAutoVideoControlView.this.f279815d.getDuration();
                if (duration > 0) {
                    IndividualAutoVideoControlView.this.N = duration;
                }
                long j3 = (duration * i3) / 1000;
                if (IndividualAutoVideoControlView.this.f279820m != null) {
                    IndividualAutoVideoControlView.this.f279820m.setText(IndividualAutoVideoControlView.this.f279815d.time2str((int) j3));
                }
                Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
                if (callbacks != null) {
                    for (PlayerCallBack playerCallBack : callbacks) {
                        if (playerCallBack != null) {
                            playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_ON_SEEK, null, null);
                        }
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (IndividualAutoVideoControlView.this.P != null) {
                IndividualAutoVideoControlView.this.P.onStartTrackingTouch(seekBar);
            }
            this.f279824d = seekBar.getProgress();
            if (PlayerConfig.g().getVideoReporter() != null) {
                e eVar = IndividualAutoVideoControlView.this.f279815d;
                if (eVar != null) {
                    PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(PlayerUtils.getVideoUuidFromVideoUrl(eVar.getVideoUriWithUuid()), IndividualAutoVideoControlView.this.f279815d.getCurrentPosition(), IndividualAutoVideoControlView.this.f279815d.isPlaying());
                } else {
                    PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(null, -1L, false);
                }
            }
            Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
            if (callbacks != null) {
                for (PlayerCallBack playerCallBack : callbacks) {
                    playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_START_SEEK, null, null);
                }
            }
            IndividualAutoVideoControlView.this.u(3600000);
            IndividualAutoVideoControlView.this.D = true;
            IndividualAutoVideoControlView.this.K.removeMessages(2);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00c0  */
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onStopTrackingTouch(SeekBar seekBar) {
            int duration;
            int progress;
            long j3;
            Set<PlayerCallBack> callbacks;
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            if (IndividualAutoVideoControlView.this.P != null) {
                IndividualAutoVideoControlView.this.P.onStopTrackingTouch(seekBar);
            }
            IndividualAutoVideoControlView.this.D = false;
            if (this.f279825e >= this.f279824d) {
                if (!IndividualAutoVideoControlView.this.f279815d.canSeekForward()) {
                    IndividualAutoVideoControlView.this.f279818h.setProgress(this.f279824d);
                    PlayerUtils.log(5, "IndividualAutoVideoControlView", "seekforward is not possible");
                }
                duration = IndividualAutoVideoControlView.this.f279815d.getDuration();
                if (duration > 0) {
                    IndividualAutoVideoControlView.this.N = duration;
                }
                progress = seekBar.getProgress();
                if (PlayerConfig.g().getVideoReporter() != null && seekBar.getMax() > 0) {
                    PlayerConfig.g().getVideoReporter().progressBarSeekingEnd(PlayerUtils.getVideoUuidFromVideoUrl(IndividualAutoVideoControlView.this.f279815d.getVideoUriWithUuid()), (duration * progress) / seekBar.getMax());
                }
                if (progress == seekBar.getMax()) {
                    j3 = (duration * progress) / 1000;
                } else if (duration > 0) {
                    j3 = duration + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
                    int max = (int) ((((float) j3) / duration) * seekBar.getMax());
                    ProgressBar progressBar = IndividualAutoVideoControlView.this.f279818h;
                    if (progressBar != null) {
                        progressBar.setProgress(max);
                    }
                } else {
                    j3 = duration;
                }
                if (IndividualAutoVideoControlView.this.L < 0 && j3 >= IndividualAutoVideoControlView.this.L) {
                    IndividualAutoVideoControlView.this.f279815d.seekTo(0);
                    IndividualAutoVideoControlView.this.f279815d.pause();
                } else {
                    int i3 = (int) j3;
                    IndividualAutoVideoControlView.this.f279815d.seekTo(i3);
                    if (IndividualAutoVideoControlView.this.f279820m != null) {
                        IndividualAutoVideoControlView.this.f279820m.setText(IndividualAutoVideoControlView.this.f279815d.time2str(i3));
                    }
                }
                IndividualAutoVideoControlView.this.r();
                IndividualAutoVideoControlView.this.x();
                IndividualAutoVideoControlView.this.u(IndividualAutoVideoControlView.U);
                IndividualAutoVideoControlView.this.K.removeMessages(2);
                IndividualAutoVideoControlView.this.K.sendEmptyMessage(2);
                callbacks = PlayerConfig.g().getCallbacks();
                if (callbacks != null) {
                    for (PlayerCallBack playerCallBack : callbacks) {
                        playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_STOP_SEEK, null, null);
                    }
                }
            } else {
                if (!IndividualAutoVideoControlView.this.f279815d.canSeekBackward()) {
                    IndividualAutoVideoControlView.this.f279818h.setProgress(this.f279824d);
                    PlayerUtils.log(5, "IndividualAutoVideoControlView", "seekbackward is not possible");
                }
                duration = IndividualAutoVideoControlView.this.f279815d.getDuration();
                if (duration > 0) {
                }
                progress = seekBar.getProgress();
                if (PlayerConfig.g().getVideoReporter() != null) {
                    PlayerConfig.g().getVideoReporter().progressBarSeekingEnd(PlayerUtils.getVideoUuidFromVideoUrl(IndividualAutoVideoControlView.this.f279815d.getVideoUriWithUuid()), (duration * progress) / seekBar.getMax());
                }
                if (progress == seekBar.getMax()) {
                }
                if (IndividualAutoVideoControlView.this.L < 0) {
                }
                int i36 = (int) j3;
                IndividualAutoVideoControlView.this.f279815d.seekTo(i36);
                if (IndividualAutoVideoControlView.this.f279820m != null) {
                }
                IndividualAutoVideoControlView.this.r();
                IndividualAutoVideoControlView.this.x();
                IndividualAutoVideoControlView.this.u(IndividualAutoVideoControlView.U);
                IndividualAutoVideoControlView.this.K.removeMessages(2);
                IndividualAutoVideoControlView.this.K.sendEmptyMessage(2);
                callbacks = PlayerConfig.g().getCallbacks();
                if (callbacks != null) {
                }
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface e {
        boolean canPausePlay();

        boolean canSeekBackward();

        boolean canSeekForward();

        boolean enableToggleFullScreen();

        boolean enableToggleLandscape();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        String getVideoUriWithUuid();

        void hideTopBar();

        boolean isFullScreen();

        boolean isLandscape();

        boolean isLoading();

        boolean isPlayComplete();

        boolean isPlaying();

        void pause();

        void seekTo(int i3);

        void start();

        String time2str(int i3);

        void toggleFullScreen();

        void toggleLandscape();

        void updatePlayPauseButton();
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private static class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<IndividualAutoVideoControlView> f279827a;

        f(IndividualAutoVideoControlView individualAutoVideoControlView) {
            this.f279827a = new WeakReference<>(individualAutoVideoControlView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            int s16;
            IndividualAutoVideoControlView individualAutoVideoControlView = this.f279827a.get();
            if (individualAutoVideoControlView == null || (eVar = individualAutoVideoControlView.f279815d) == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                individualAutoVideoControlView.k();
                individualAutoVideoControlView.f279815d.hideTopBar();
                return;
            }
            if (i3 != 2) {
                return;
            }
            if (!eVar.isPlayComplete()) {
                s16 = individualAutoVideoControlView.r();
            } else {
                int duration = individualAutoVideoControlView.f279815d.getDuration();
                if (duration > 0) {
                    individualAutoVideoControlView.N = duration;
                }
                s16 = individualAutoVideoControlView.s(duration);
            }
            if (individualAutoVideoControlView.D || !individualAutoVideoControlView.C) {
                return;
            }
            sendMessageDelayed(obtainMessage(2), 1000 - (s16 % 1000));
        }
    }

    public IndividualAutoVideoControlView(Context context, PlayerResources playerResources) {
        super(context);
        this.K = new f(this);
        this.L = -1;
        this.Q = new a();
        this.R = new b();
        this.S = new c();
        this.T = new d();
        this.f279816e = context;
        this.M = playerResources;
    }

    private boolean j() {
        if (!Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU)) {
            return false;
        }
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception unused) {
            String str = Build.DEVICE;
            if (str.equals("mx2")) {
                return true;
            }
            if (!str.equals("mx")) {
                str.equals("m9");
            }
            return false;
        }
    }

    private boolean n() {
        return DeviceInfoMonitor.getModel().equals("Lenovo A788T");
    }

    protected void f() {
        e eVar = this.f279815d;
        if (eVar == null) {
            return;
        }
        try {
            if (this.G != null && !eVar.enableToggleFullScreen()) {
                this.G.setVisibility(8);
            }
            if (this.I == null || this.f279815d.enableToggleLandscape()) {
                return;
            }
            this.I.setVisibility(8);
        } catch (IncompatibleClassChangeError unused) {
        }
    }

    public void g() {
        e eVar = this.f279815d;
        if (eVar != null && eVar.canPausePlay()) {
            if (this.f279815d.isPlayComplete()) {
                this.f279815d.seekTo(0);
                this.f279815d.start();
            } else if (this.f279815d.isPlaying()) {
                this.f279815d.pause();
            } else {
                this.f279815d.start();
            }
            x();
            t();
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f279817f;
    }

    public void h() {
        e eVar = this.f279815d;
        if (eVar == null) {
            return;
        }
        eVar.toggleFullScreen();
    }

    protected void i() {
        e eVar = this.f279815d;
        if (eVar == null) {
            return;
        }
        eVar.toggleLandscape();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(View view) {
        ImageButton imageButton = (ImageButton) view.findViewById(this.M.getViewId(555));
        this.G = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(this.R);
            if (j() || n()) {
                this.G.setVisibility(8);
            }
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(this.M.getViewId(PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON));
        this.I = imageButton2;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this.S);
        }
        ProgressBar progressBar = (ProgressBar) view.findViewById(this.M.getViewId(PlayerResources.ViewId.CONTROLLER_PROGRESS));
        this.f279818h = progressBar;
        if (progressBar != null) {
            if (progressBar instanceof SeekBar) {
                ((SeekBar) progressBar).setOnSeekBarChangeListener(this.T);
            }
            this.f279818h.setMax(1000);
        }
        this.f279819i = (TextView) view.findViewById(this.M.getViewId(PlayerResources.ViewId.PLAYER_DURATION));
        this.f279820m = (TextView) view.findViewById(this.M.getViewId(PlayerResources.ViewId.CURRUNT_TIME));
        this.E = new StringBuilder();
        this.F = new Formatter(this.E, Locale.getDefault());
        this.f279820m.setAlpha(0.8f);
    }

    public void m() {
        removeAllViews();
        addView(q(), new FrameLayout.LayoutParams(-1, -1));
    }

    public boolean o() {
        e eVar = this.f279815d;
        if (eVar == null) {
            return false;
        }
        return eVar.canPausePlay();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View view = this.f279817f;
        if (view != null) {
            l(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        u(U);
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        u(U);
        return false;
    }

    public boolean p() {
        return this.C;
    }

    protected View q() {
        View inflate = ((LayoutInflater) this.f279816e.getSystemService("layout_inflater")).inflate(this.M.getLayoutId(8), (ViewGroup) null);
        this.f279817f = inflate;
        l(inflate);
        return this.f279817f;
    }

    public int s(int i3) {
        e eVar = this.f279815d;
        if (eVar != null && !this.D && !eVar.isLoading()) {
            if (i3 == -1) {
                i3 = this.f279815d.getCurrentPosition();
            }
            int duration = this.f279815d.getDuration();
            if (duration > 0) {
                this.N = duration;
            }
            if (duration > 0 && i3 > duration) {
                i3 = duration;
            }
            int i16 = this.L;
            r1 = (i16 < 0 || i3 < i16) ? i3 : 0;
            ProgressBar progressBar = this.f279818h;
            if (progressBar != null) {
                if (duration > 0) {
                    progressBar.setProgress((int) ((r1 * 1000) / duration));
                }
                this.f279818h.setSecondaryProgress(this.f279815d.getBufferPercentage() * 10);
            }
            if (this.f279819i != null) {
                this.f279819i.setText(this.f279815d.time2str(duration));
            }
            TextView textView = this.f279820m;
            if (textView != null) {
                textView.setText(this.f279815d.time2str(r1));
            }
            x();
        }
        return r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        ProgressBar progressBar = this.f279818h;
        if (progressBar != null) {
            progressBar.setEnabled(z16);
        }
        f();
        super.setEnabled(z16);
    }

    public void setMediaPlayer(e eVar) {
        this.f279815d = eVar;
        x();
        v();
        w();
    }

    public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.P = onSeekBarChangeListener;
    }

    public void setSeekBarrier(int i3) {
        this.L = i3;
    }

    public void u(int i3) {
        if (!this.C) {
            r();
            f();
            this.C = true;
        }
        x();
        v();
        w();
        this.K.removeMessages(2);
        this.K.sendEmptyMessage(2);
        Message obtainMessage = this.K.obtainMessage(1);
        this.K.removeMessages(1);
        if (i3 != 0) {
            this.K.sendMessageDelayed(obtainMessage, i3);
        }
    }

    public void v() {
        e eVar;
        if (this.f279817f == null || this.G == null || (eVar = this.f279815d) == null) {
            return;
        }
        if (eVar.isFullScreen()) {
            if (this.H != 1098) {
                this.G.setImageResource(this.M.getDrawableId(1098));
                this.H = 1098;
                return;
            }
            return;
        }
        if (this.H != 1099) {
            this.G.setImageResource(this.M.getDrawableId(1099));
            this.H = 1099;
        }
    }

    public void w() {
        e eVar;
        if (this.f279817f == null || this.I == null || (eVar = this.f279815d) == null) {
            return;
        }
        if (eVar.isLandscape()) {
            if (this.J != 1097) {
                this.I.setImageResource(this.M.getDrawableId(1097));
                this.J = 1097;
                return;
            }
            return;
        }
        if (this.J != 1096) {
            this.I.setImageResource(this.M.getDrawableId(1096));
            this.J = 1096;
        }
    }

    public void x() {
        e eVar;
        if (this.f279817f == null || (eVar = this.f279815d) == null) {
            return;
        }
        eVar.updatePlayPauseButton();
    }

    public void k() {
        setVisibility(4);
        this.C = false;
    }

    public int r() {
        return s(-1);
    }

    public void t() {
        setVisibility(0);
        u(0);
    }
}
