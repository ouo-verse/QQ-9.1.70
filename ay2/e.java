package ay2;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.SeekBar;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.ag;
import com.tencent.biz.qqcircle.immersive.views.QFSTVKVideoView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.timer.IRFWVideoTimerListener;
import com.tencent.biz.richframework.video.timer.RFWVideoTimerManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.view.QFSTVideoSeekBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import e40.p;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f27310a;

    /* renamed from: b, reason: collision with root package name */
    private View f27311b;

    /* renamed from: c, reason: collision with root package name */
    private QFSTVKVideoView f27312c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<QFSTVKVideoView> f27313d;

    /* renamed from: e, reason: collision with root package name */
    private int f27314e;

    /* renamed from: f, reason: collision with root package name */
    private int f27315f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f27316g;

    /* renamed from: h, reason: collision with root package name */
    private ag f27317h;

    /* renamed from: j, reason: collision with root package name */
    private Handler f27319j;

    /* renamed from: l, reason: collision with root package name */
    private int f27321l;

    /* renamed from: m, reason: collision with root package name */
    private int f27322m;

    /* renamed from: n, reason: collision with root package name */
    private final WeakReference<c> f27323n;

    /* renamed from: o, reason: collision with root package name */
    private k f27324o;

    /* renamed from: p, reason: collision with root package name */
    private k f27325p;

    /* renamed from: q, reason: collision with root package name */
    private k f27326q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f27327r;

    /* renamed from: t, reason: collision with root package name */
    private View f27329t;

    /* renamed from: i, reason: collision with root package name */
    private long f27318i = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f27320k = false;

    /* renamed from: s, reason: collision with root package name */
    private final IRFWVideoTimerListener f27328s = new IRFWVideoTimerListener() { // from class: ay2.a
        @Override // com.tencent.biz.richframework.video.timer.IRFWVideoTimerListener
        public final void onTimerCallback() {
            e.this.G();
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private boolean f27330u = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements QFSTVideoSeekBar.b {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.tvideo.view.QFSTVideoSeekBar.b
        public void onProgressChanged(@Nullable SeekBar seekBar, int i3, boolean z16) {
            if (e.this.f27313d != null && e.this.f27313d.get() != 0) {
                ((QFSTVKVideoView) e.this.f27313d.get()).onProgressChanged(seekBar, i3, z16);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.tvideo.view.QFSTVideoSeekBar.b
        public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
            if (e.this.f27313d != null && e.this.f27313d.get() != 0) {
                ((QFSTVKVideoView) e.this.f27313d.get()).onStartTrackingTouch(seekBar);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.tvideo.view.QFSTVideoSeekBar.b
        public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
            if (e.this.f27313d != null && e.this.f27313d.get() != 0) {
                ((QFSTVKVideoView) e.this.f27313d.get()).onStopTrackingTouch(seekBar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements IRFWPlayerSeekListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f27332d;

        b(String str) {
            this.f27332d = str;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            e.this.o(i3, i16, this.f27332d);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            e.this.p(seekBar, i3, z16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            int progress;
            e.this.q(seekBar);
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onStartTrackingTouch] seek progress: ");
            if (seekBar == null) {
                progress = 0;
            } else {
                progress = seekBar.getProgress();
            }
            sb5.append(progress);
            objArr[0] = sb5.toString();
            RFWLog.d("QFSTVideoSeekbarPresenter", i3, objArr);
            if (seekBar != null) {
                e.this.f27321l = seekBar.getProgress();
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int progress;
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onStopTrackingTouch] seek progress: ");
            if (seekBar == null) {
                progress = 0;
            } else {
                progress = seekBar.getProgress();
            }
            sb5.append(progress);
            objArr[0] = sb5.toString();
            RFWLog.d("QFSTVideoSeekbarPresenter", i3, objArr);
            e.this.r(seekBar);
            if (seekBar != null) {
                e.this.f27322m = seekBar.getProgress();
            }
            e.this.S();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void C(ag agVar);

        String j();

        void n();

        boolean y(int i3, int i16, String str);
    }

    public e(Context context, c cVar, boolean z16) {
        this.f27327r = true;
        this.f27323n = new WeakReference<>(cVar);
        this.f27310a = new WeakReference<>(context);
        this.f27327r = z16;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void B() {
        v().setQFSSeekBarChangeListener(new a());
    }

    private boolean D() {
        WeakReference<Context> weakReference = this.f27310a;
        if (weakReference == null || weakReference.get() == null || 2 != this.f27310a.get().getResources().getConfiguration().orientation) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ISuperPlayer iSuperPlayer) {
        String str = " / " + jy2.h.f411172a.a((int) iSuperPlayer.getDurationMs());
        this.f27324o.l(str);
        this.f27325p.l(str);
        if (v() != null) {
            if (e0()) {
                v().G(1);
                ((j) this.f27324o).y();
            } else {
                a0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(long j3) {
        c0();
        this.f27318i = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.f27318i;
        if (elapsedRealtime - j3 > 500 || j3 == 0) {
            t().post(new Runnable() { // from class: ay2.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.F(elapsedRealtime);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(ValueAnimator valueAnimator) {
        Z(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private void Q() {
        if (!this.f27327r) {
            return;
        }
        int g16 = px2.e.g(R.dimen.dh9);
        if (cy2.b.e().k()) {
            g16 = px2.e.g(R.dimen.dh_);
        }
        Z(g16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        String str;
        Map<String, Object> g16 = gy2.c.g();
        if (this.f27322m > this.f27321l) {
            str = "forward";
        } else {
            str = "backward";
        }
        g16.put("move_type", str);
        g16.put("start_time", Integer.valueOf(this.f27321l));
        g16.put("end_time", Integer.valueOf(this.f27322m));
        VideoReport.setElementParams(u(), g16);
        VideoReport.reportEvent("clck", u(), null);
    }

    private void Y() {
        VideoReport.setElementExposePolicy(u(), ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(u(), ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(u(), "play_bar");
    }

    private void Z(int i3) {
        if (!this.f27327r) {
            return;
        }
        int g16 = i3 - px2.e.g(R.dimen.dh9);
        if (g16 < 0) {
            g16 = 0;
        }
        this.f27329t.setPadding(g16, px2.e.g(R.dimen.dha), g16, 0);
        this.f27326q.j(i3);
    }

    private void b0(boolean z16) {
        int i3;
        if (this.f27329t == null) {
            return;
        }
        int g16 = px2.e.g(R.dimen.dh_);
        int g17 = px2.e.g(R.dimen.dh9);
        if (z16) {
            i3 = g17;
        } else {
            i3 = g16;
        }
        if (!z16) {
            g16 = g17;
        }
        if (this.f27329t.getPaddingLeft() == g16) {
            return;
        }
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        ValueAnimator duration = ValueAnimator.ofInt(i3, g16).setDuration(250L);
        duration.setInterpolator(accelerateDecelerateInterpolator);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ay2.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.H(valueAnimator);
            }
        });
        duration.start();
    }

    private boolean e0() {
        boolean z16;
        int d16 = fy2.b.f400938a.d();
        boolean k3 = qx2.a.c().k();
        if (this.f27326q == this.f27324o) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (d16 > 1 || !k3 || !z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i3, int i16, String str) {
        QLog.d("QFSTVideoSeekbarPresenter", 4, "doOnProgress  mCurrentPosition = " + this.f27314e + " position = " + i16 + " mIsSeekBarTracking = " + this.f27316g);
        if (this.f27314e != i16 && !this.f27316g) {
            WeakReference<c> weakReference = this.f27323n;
            if (weakReference != null && weakReference.get() != null && this.f27323n.get().y(i3, i16, str)) {
                QLog.d("QFSTVideoSeekbarPresenter", 4, "mOnSeekBarPresenterListener.doOnProgress");
            } else {
                this.f27320k = true;
                this.f27314e = i16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(SeekBar seekBar, int i3, boolean z16) {
        this.f27326q.f(i3, z16);
        if (this.f27317h == null) {
            this.f27317h = new ag();
        }
        this.f27317h.d(i3);
        WeakReference<c> weakReference = this.f27323n;
        if (weakReference != null && weakReference.get() != null) {
            this.f27323n.get().C(this.f27317h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(SeekBar seekBar) {
        String str;
        if (seekBar == null) {
            RFWLog.e("QFSTVideoSeekbarPresenter", RFWLog.USR, "[doOnStartSeekBarTrackingTouch] seek view should not is null.");
            return;
        }
        if (this.f27330u) {
            return;
        }
        this.f27316g = true;
        this.f27326q.h();
        WeakReference<c> weakReference = this.f27323n;
        if (weakReference != null && weakReference.get() != null) {
            str = this.f27323n.get().j();
        } else {
            str = "";
        }
        QFSSeekEvent qFSSeekEvent = new QFSSeekEvent(str, true);
        qFSSeekEvent.setStopTrackingTouchProgress(seekBar.getProgress());
        SimpleEventBus.getInstance().dispatchEvent(qFSSeekEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(SeekBar seekBar) {
        String str;
        if (seekBar == null) {
            RFWLog.e("QFSTVideoSeekbarPresenter", RFWLog.USR, "[doOnStopSeekBarTrackingTouch] seek view should not is null.");
            return;
        }
        if (!this.f27312c.getSuperPlayer().isPlaying()) {
            WeakReference<c> weakReference = this.f27323n;
            if (weakReference != null && weakReference.get() != null) {
                this.f27323n.get().n();
            }
            a0();
        }
        this.f27316g = false;
        this.f27326q.i();
        WeakReference<c> weakReference2 = this.f27323n;
        if (weakReference2 != null && weakReference2.get() != null) {
            str = this.f27323n.get().j();
        } else {
            str = "";
        }
        QFSSeekEvent qFSSeekEvent = new QFSSeekEvent(str, false);
        qFSSeekEvent.setStopTrackingTouchProgress(seekBar.getProgress());
        SimpleEventBus.getInstance().dispatchEvent(qFSSeekEvent);
    }

    private QFSTVideoSeekBar u() {
        k kVar = this.f27324o;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    private QFSTVideoSeekBar v() {
        k kVar = this.f27326q;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public void A() {
        this.f27314e = 0;
        this.f27315f = 0;
        if (D()) {
            Q();
        }
    }

    public boolean C(p pVar) {
        return this.f27316g;
    }

    public void I() {
        this.f27316g = false;
    }

    public void J() {
        this.f27330u = true;
        this.f27325p.c();
        this.f27324o.c();
    }

    public void K(RFWFeedSelectInfo rFWFeedSelectInfo) {
        this.f27320k = false;
        k kVar = this.f27326q;
        if (kVar != null) {
            kVar.d();
        }
        if (D()) {
            Q();
        }
        if (v() != null) {
            v().setEnabled(true);
        }
        RFWVideoTimerManager.g().registerTimerListener(this.f27328s);
    }

    public void L(RFWFeedSelectInfo rFWFeedSelectInfo) {
        this.f27317h = null;
        U();
        RFWVideoTimerManager.g().unRegisterTimerListener(this.f27328s);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public void M(@NonNull View view, View view2) {
        this.f27311b = view;
        this.f27312c = (QFSTVKVideoView) view.findViewById(R.id.f74163vi);
        this.f27313d = new WeakReference<>(this.f27312c);
        this.f27324o = new j(view, view.findViewById(R.id.f45671si));
        this.f27325p = new g(view.findViewById(R.id.t_f));
        this.f27326q = this.f27324o;
        B();
        Y();
        this.f27329t = view2;
    }

    public void N() {
        this.f27326q.e();
    }

    public void O(int i3) {
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        b0(z16);
    }

    public void P() {
        this.f27326q.g();
    }

    public void R() {
        v().D();
    }

    public void T() {
        if (v() != null) {
            v().F();
        }
    }

    public void U() {
        this.f27330u = false;
        this.f27325p.k();
        this.f27324o.k();
    }

    public void V(boolean z16) {
        k kVar = this.f27326q;
        if (kVar != null) {
            kVar.m(z16);
        }
    }

    public void W(int i3) {
        this.f27324o.n(i3);
        this.f27325p.n(i3);
    }

    public void X(int i3) {
        v().setProgress(i3);
    }

    public void a0() {
        v().G(0);
    }

    @MainThread
    public void c0() {
        QFSTVKVideoView qFSTVKVideoView = this.f27312c;
        if (qFSTVKVideoView != null && qFSTVKVideoView.getSuperPlayer() != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            jy2.h hVar = jy2.h.f411172a;
            sb5.append(hVar.a((int) this.f27312c.H0()));
            sb5.append("/");
            sb5.append(hVar.a((int) this.f27312c.getSuperPlayer().getDurationMs()));
            this.f27326q.o(sb5.toString());
            if (!this.f27316g) {
                v().setProgress((int) ((((float) (v().u() * this.f27312c.H0())) * 1.0f) / ((float) this.f27312c.getSuperPlayer().getDurationMs())));
            }
        }
    }

    public void d0(MotionEvent motionEvent) {
        if (v() == null) {
            RFWLog.e("QFSTVideoSeekbarPresenter", RFWLog.USR, "[updateSeekBarEvent] seek bar should not be null.");
        } else {
            v().onTouchEvent(motionEvent);
        }
    }

    public void m(RFWPlayerOptions rFWPlayerOptions, String str) {
        rFWPlayerOptions.getListenerSet().addSeekListeners(new b(str));
    }

    public void n(int i3) {
        if (this.f27326q == null) {
            return;
        }
        if (i3 == 2) {
            this.f27326q = this.f27325p;
        } else {
            this.f27326q = this.f27324o;
        }
        B();
    }

    public void s(final ISuperPlayer iSuperPlayer) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ay2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.E(iSuperPlayer);
            }
        });
        this.f27315f = (int) iSuperPlayer.getDurationMs();
    }

    public Handler t() {
        if (this.f27319j == null) {
            this.f27319j = new Handler(Looper.getMainLooper());
        }
        return this.f27319j;
    }

    public QFSTVideoSeekBar w() {
        return v();
    }

    public int x() {
        return this.f27322m;
    }

    public int y() {
        return this.f27315f;
    }

    public boolean z() {
        return this.f27320k;
    }
}
