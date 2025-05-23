package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.part.base.AVNetConnectInfoPart;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ba;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmallScreenVideoControlUI implements Animation.AnimationListener {
    protected Resources C;
    protected WeakReference<Context> D;
    public VideoAppInterface E;
    protected ControlUIObserver F;
    boolean J;

    /* renamed from: d, reason: collision with root package name */
    SmallScreenService f74529d;

    /* renamed from: e, reason: collision with root package name */
    protected int f74530e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f74531f = false;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f74532h = false;

    /* renamed from: i, reason: collision with root package name */
    String f74533i = null;

    /* renamed from: m, reason: collision with root package name */
    TimmerRunnable f74534m = null;
    protected TextView G = null;
    View[] H = new View[2];
    String I = TraeConstants.VIDEO_CALL_CONFIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class TimmerRunnable implements Runnable {
        TimmerRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.h0() != null) {
                SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoControlUI.this;
                if (smallScreenVideoControlUI.J || !smallScreenVideoControlUI.f74531f) {
                    return;
                }
                long K = r.h0().K();
                SmallScreenVideoControlUI smallScreenVideoControlUI2 = SmallScreenVideoControlUI.this;
                if (smallScreenVideoControlUI2.f74533i == null || K != 0) {
                    smallScreenVideoControlUI2.f74533i = ba.formatTime(K);
                    SmallScreenVideoControlUI smallScreenVideoControlUI3 = SmallScreenVideoControlUI.this;
                    TextView textView = smallScreenVideoControlUI3.G;
                    if (textView != null && !smallScreenVideoControlUI3.f74532h) {
                        textView.setContentDescription(ba.getTimeDesc(smallScreenVideoControlUI3.f74533i));
                        SmallScreenVideoControlUI smallScreenVideoControlUI4 = SmallScreenVideoControlUI.this;
                        smallScreenVideoControlUI4.G.setText(smallScreenVideoControlUI4.f74533i);
                    }
                }
                SmallScreenVideoControlUI.this.E.M().postDelayed(this, 1000L);
            }
        }
    }

    public SmallScreenVideoControlUI(VideoAppInterface videoAppInterface, SmallScreenService smallScreenService, ControlUIObserver controlUIObserver) {
        this.C = null;
        this.D = null;
        this.J = false;
        this.f74529d = smallScreenService;
        this.E = videoAppInterface;
        this.D = new WeakReference<>(this.f74529d);
        Resources resources = this.f74529d.getResources();
        this.C = resources;
        if (resources == null) {
            QLog.d("SmallScreenVideoControlUI", 1, "mRes is null. exit video progress");
            QQToast.makeText(smallScreenService.getApplicationContext(), smallScreenService.getString(R.string.ico) + " 0x03", 0).show();
            smallScreenService.stopSelf();
            return;
        }
        this.J = false;
        if (r.h0() != null && !this.J) {
            this.F = controlUIObserver;
            return;
        }
        QLog.d("SmallScreenVideoControlUI", 1, "VideoController.getInstance() is null. exit video progress");
        QQToast.makeText(smallScreenService.getApplicationContext(), this.C.getString(R.string.ico) + " 0x04", 0).show();
        smallScreenService.stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        SmallScreenService smallScreenService = this.f74529d;
        if (smallScreenService == null) {
            return;
        }
        SmallScreenRelativeLayout B = smallScreenService.B(1);
        SmallScreenRelativeLayout B2 = this.f74529d.B(0);
        if (B2 != null) {
            this.G = (TextView) B2.findViewById(R.id.rbx);
            this.H[1] = B2.findViewById(R.id.rbc);
            QLog.d("SmallScreenVideoControlUI", 1, "initUI audioToastView");
        }
        if (B != null) {
            this.H[0] = B.findViewById(R.id.rbc);
            QLog.d("SmallScreenVideoControlUI", 1, "initUI videoToastView");
        }
    }

    public int b(int i3) {
        VideoUtil.n(this.E, i3);
        return 0;
    }

    public void c(int i3) {
        QLog.d("SmallScreenVideoControlUI", 1, "onClose type = " + i3);
        if (n.e().f().w()) {
            u(i3);
            y();
            return;
        }
        if (i3 != 25 && i3 != 56) {
            if (i3 == 2 && r.h0().h() && n.e().f().x()) {
                u(65);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenVideoControlUI.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioUtil.l(R.raw.f169423v, 1, null);
                    }
                }, 16, null, false);
            }
        } else {
            u(i3);
        }
        w();
    }

    public void e(boolean z16) {
        QLog.d("SmallScreenVideoControlUI", 1, "onCreate");
        this.f74530e = 1;
        a();
    }

    public void f(long j3) {
        QLog.w("SmallScreenVideoControlUI", 1, "onDestroy, mUIState[" + this.f74530e + "->6], seq[" + j3 + "]");
        this.f74530e = 6;
        y();
        VideoAppInterface videoAppInterface = this.E;
        if (videoAppInterface != null) {
            videoAppInterface.M().removeCallbacks(this.f74534m);
            this.E = null;
        }
        this.C = null;
        this.D = null;
        this.J = true;
        this.H = null;
        this.f74534m = null;
        this.F = null;
        this.G = null;
    }

    public void l() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoControlUI", 2, "onPauseAudio");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.H == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            View[] viewArr = this.H;
            if (i3 >= viewArr.length) {
                return;
            }
            View view = viewArr[i3];
            if (view != null) {
                view.setVisibility(8);
            }
            i3++;
        }
    }

    public void p() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoControlUI", 2, "onResumeAudio");
        }
    }

    protected void t(int i3) {
        throw null;
    }

    void u(int i3) {
        int F9 = AVNetConnectInfoPart.F9(n.e().f(), i3);
        if (i3 == 3) {
            F9 = R.string.f1783936j;
        }
        t(F9);
    }

    public void v(int i3) {
        if (n.e().f().N) {
            return;
        }
        boolean z16 = n.e().f().O;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        if (this.H == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoControlUI", 2, "setScreenDarken");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(100L);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(6);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(this);
        int i3 = 0;
        while (true) {
            View[] viewArr = this.H;
            if (i3 >= viewArr.length) {
                return;
            }
            View view = viewArr[i3];
            if (view != null) {
                view.setVisibility(0);
                this.H[i3].startAnimation(alphaAnimation);
            }
            i3++;
        }
    }

    public void x() {
        if (this.f74531f) {
            return;
        }
        int i3 = this.f74530e;
        if ((i3 < 2 || i3 > 4) && !n.e().f().z()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoControlUI", 2, "startTimer");
        }
        this.f74531f = true;
        if (this.f74534m == null) {
            this.f74534m = new TimmerRunnable();
        }
        this.E.M().postDelayed(this.f74534m, 0L);
    }

    public void y() {
        if (this.f74531f) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoControlUI", 2, "stopTimer");
            }
            this.f74531f = false;
            if (this.f74534m != null) {
                VideoAppInterface videoAppInterface = this.E;
                if (videoAppInterface != null) {
                    videoAppInterface.M().removeCallbacks(this.f74534m);
                }
                this.f74534m = null;
            }
        }
    }

    public void k() {
        this.f74530e = 4;
    }

    public void o() {
        this.f74530e = 3;
    }

    public void r() {
        this.f74530e = 2;
    }

    public void s() {
        QLog.d("SmallScreenVideoControlUI", 1, DKHippyEvent.EVENT_STOP);
        this.f74530e = 5;
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3) {
        u(65);
        AudioUtil.l(R.raw.f169423v, 1, new a());
        w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
        }
    }

    public void i(boolean z16) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    public void d() {
    }

    public void j() {
    }

    public void q() {
    }

    public void h(String str, String str2) {
    }

    public void m(String str, boolean z16) {
    }

    public void n(boolean z16, boolean z17) {
    }
}
