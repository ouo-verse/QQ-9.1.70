package com.tencent.mobileqq.kandian.biz.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.kandian.base.utils.f;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.video.OrientationDetector;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.net.URL;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VideoUIManager implements AbsListView.OnScrollListener, OrientationDetector.b, f62.e, View.OnClickListener, l62.a, VideoPlayManager.b {
    private int[] C;
    private k62.b D;
    private VideoPlayManager E;
    private com.tencent.mobileqq.kandian.glue.video.a F;
    private com.tencent.mobileqq.kandian.biz.video.playfeedback.a G;
    private VideoViewGroup H;
    private URLImageView I;
    private KandianUrlImageView J;
    private RelativeLayout K;
    private ImageView L;
    private TextView M;
    private RelativeLayout N;
    private SeekBar P;
    private ImageView Q;
    private LinearLayout R;
    private SeekBar S;
    private ImageView T;
    private View U;
    private KandianUrlImageView V;
    private TextView W;
    private View X;
    private KandianUrlImageView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f239527a0;

    /* renamed from: b0, reason: collision with root package name */
    private OrientationDetector f239528b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f239529c0;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f239530d;

    /* renamed from: d0, reason: collision with root package name */
    private int f239531d0;

    /* renamed from: e, reason: collision with root package name */
    private ReadInJoyBaseListView f239532e;

    /* renamed from: e0, reason: collision with root package name */
    private int f239533e0;

    /* renamed from: f, reason: collision with root package name */
    private Activity f239534f;

    /* renamed from: f0, reason: collision with root package name */
    protected int f239535f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f239536g0;

    /* renamed from: h, reason: collision with root package name */
    private int f239537h;

    /* renamed from: h0, reason: collision with root package name */
    private RotateAnimation f239538h0;

    /* renamed from: i, reason: collision with root package name */
    private int f239539i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f239540i0;

    /* renamed from: j0, reason: collision with root package name */
    private List<a> f239541j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f239542k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f239543l0;

    /* renamed from: m, reason: collision with root package name */
    private int f239544m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f239545m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f239546n0;

    /* renamed from: o0, reason: collision with root package name */
    private ViewGroup f239547o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f239548p0;

    /* renamed from: q0, reason: collision with root package name */
    private Handler f239549q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f239550r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f239551s0;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface a {
        void a();

        void b(k62.b bVar, k62.b bVar2);
    }

    private void A(k62.b bVar, int i3, Object obj) {
        this.f239549q0.removeMessages(102);
        this.f239549q0.removeMessages(101);
        this.f239549q0.removeMessages(103);
        this.H.removeAllViews();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            i0(1, com.tencent.mobileqq.kandian.base.video.a.d(iArr[0], iArr[1]), HardCodeUtil.qqStr(R.string.v8g));
        }
    }

    private void C(k62.b bVar, int i3, Object obj) {
        if (T()) {
            j0(1);
        }
        if (this.D.f411790v) {
            j0(1);
        }
        this.f239549q0.removeMessages(100);
        this.f239549q0.removeMessages(101);
        this.f239549q0.removeMessages(102);
        this.f239549q0.removeMessages(103);
    }

    private void D(k62.b bVar, int i3, Object obj) {
        ImageView imageView;
        this.f239549q0.removeMessages(103);
        this.f239549q0.sendEmptyMessage(102);
        if (i3 == 2) {
            this.D.f411776h.a().setBackgroundColor(this.f239534f.getResources().getColor(R.color.black));
            I();
            this.f239549q0.removeMessages(100);
            this.f239549q0.sendEmptyMessageDelayed(100, 3000L);
            if (NetworkUtil.isMobileNetWork(this.f239534f) && !this.f239545m0) {
                l0();
                this.f239545m0 = true;
            }
            c0(this.T);
            if (this.D.f411790v && (imageView = this.T) != null) {
                imageView.setVisibility(8);
            }
            n();
            m();
            p();
            return;
        }
        if (i3 == 4) {
            I();
            return;
        }
        if (i3 == 5) {
            if (T() && S()) {
                j0(2);
                this.f239549q0.removeMessages(101);
                this.f239549q0.sendEmptyMessageDelayed(101, 3000L);
            } else {
                if (P()) {
                    G();
                    if (NetworkUtil.isMobileNetWork(this.f239534f)) {
                        l0();
                        return;
                    }
                    return;
                }
                if (this.D.f411790v) {
                    this.L.clearAnimation();
                    this.L.setVisibility(8);
                }
            }
        }
    }

    private void F(k62.b bVar, int i3, Object obj) {
        this.N.setVisibility(8);
        this.f239549q0.removeMessages(103);
        this.f239549q0.sendEmptyMessageDelayed(103, 1200L);
        this.f239549q0.removeMessages(100);
        this.S.setVisibility(8);
        this.T.setVisibility(8);
    }

    private void G() {
        this.G.a();
        this.S.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.M.setVisibility(8);
        this.L.clearAnimation();
        this.L.setVisibility(8);
        this.f239549q0.removeMessages(103);
    }

    private void J() {
        FrameLayout frameLayout = this.f239530d;
        if (frameLayout instanceof RoundAngleFrameLayout) {
            ((RoundAngleFrameLayout) frameLayout).setRadius(0, 0, 0, 0);
        }
    }

    private void K() {
        this.N.setVisibility(8);
        if (Q()) {
            this.S.setVisibility(8);
        } else {
            this.S.setVisibility(0);
        }
    }

    private void L() {
        if (this.f239546n0) {
            return;
        }
        this.f239546n0 = true;
    }

    private void M() {
        this.D.f411774f = this.H;
    }

    private boolean O() {
        View view;
        int i3 = this.f239550r0;
        if (i3 != 1) {
            return i3 == 2 && (view = this.X) != null && view.getVisibility() == 0;
        }
        View view2 = this.U;
        return view2 != null && view2.getVisibility() == 0;
    }

    private boolean P() {
        return this.G.b();
    }

    private boolean R() {
        URLImageView uRLImageView = this.I;
        return uRLImageView != null && uRLImageView.getVisibility() == 0;
    }

    private boolean T() {
        return this.L.getVisibility() == 0;
    }

    public static boolean U(int i3, int i16) {
        if (i3 == 0 || i16 == 0 || i3 > i16) {
            return false;
        }
        return true;
    }

    private void X(boolean z16, k62.b bVar, k62.b bVar2) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.readinjoy.videoVideoUIManager", 2, "onScreenChange   isFullScreen:" + z16 + "  enterPlayParam:" + bVar + "   exitPlayParam:" + bVar2);
        }
        if (z16) {
            com.tencent.mobileqq.kandian.glue.video.a aVar = this.F;
            int b16 = com.tencent.mobileqq.kandian.base.video.a.b(this.f239532e, bVar.f411772d);
            this.f239543l0 = b16;
            aVar.c(bVar, b16);
        } else {
            this.F.e();
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, !z16);
        o();
        List<a> list = this.f239541j0;
        if (list != null) {
            for (a aVar2 : list) {
                if (aVar2 != null) {
                    if (z16) {
                        aVar2.a();
                    } else {
                        aVar2.b(bVar, bVar2);
                    }
                }
            }
        }
    }

    private void b0() {
        this.f239530d.setTranslationY(0.0f);
        K();
        H();
        this.S.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.f239530d.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f239530d.setLayoutParams(layoutParams);
        this.H.a(false);
        this.E.X(0);
        this.f239530d.setBackgroundColor(-16777216);
        l(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        this.J.clearAnimation();
        this.J.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.J.setLayoutParams(layoutParams);
    }

    private void e0(int i3) {
        if (O()) {
            return;
        }
        if (this.f239551s0) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.readinjoy.videoVideoUIManager", 2, "showDownloadBar(): mDownloadBarClicked, just jump.");
                return;
            }
            return;
        }
        if (i3 == 1) {
            g0();
        } else if (i3 == 2) {
            f0();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.videoVideoUIManager", 2, "showDownloadBar(), barStyle:" + i3);
        }
    }

    private void f0() {
        String w3 = w();
        if (!TextUtils.isEmpty(w3)) {
            try {
                this.Y.setImagePlaceHolder(x(this.f239534f, true)).setImage(new URL(w3));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            this.Y.setBackgroundDrawable(x(this.f239534f, true));
        }
        String v3 = v();
        if (!TextUtils.isEmpty(v3)) {
            this.Z.setText(v3);
        }
        this.X.setVisibility(0);
        View view = this.U;
        if (view != null) {
            view.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.videoVideoUIManager", 2, "showDownloadBarComplete(), iconUrl:" + w3 + "\uff0ciconText:" + v3);
        }
        this.J.setVisibility(0);
        this.K.setVisibility(8);
        I();
        this.R.setVisibility(8);
        this.S.setVisibility(8);
        this.N.setVisibility(8);
    }

    private void g0() {
        String w3 = w();
        if (!TextUtils.isEmpty(w3)) {
            try {
                this.V.setImagePlaceHolder(x(this.f239534f, false)).setImage(new URL(w3));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            this.V.setBackgroundDrawable(x(this.f239534f, false));
        }
        String v3 = v();
        if (!TextUtils.isEmpty(v3)) {
            this.W.setText(v3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.videoVideoUIManager", 2, "showDownloadBarPlaying(), iconUrl:" + w3 + "\uff0ciconText:" + v3);
        }
        this.U.setVisibility(0);
    }

    private void i0(final int i3, final String str, final String str2) {
        this.f239549q0.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.video.VideoUIManager.3
            @Override // java.lang.Runnable
            public void run() {
                VideoUIManager.this.K.setVisibility(8);
                VideoUIManager.this.I();
                VideoUIManager.this.R.setVisibility(8);
                VideoUIManager.this.S.setVisibility(8);
                VideoUIManager.this.N.setVisibility(8);
                if (i3 == 1) {
                    VideoUIManager.this.d0();
                }
                VideoUIManager.this.G.c(i3, str, str2);
                if (i3 == 1) {
                    PlayFeedbackHelper.h(VideoUIManager.this.D.a(), 0);
                }
            }
        });
    }

    private void j0(int i3) {
        this.M.getVisibility();
        this.f239549q0.removeMessages(103);
        this.L.clearAnimation();
        if (i3 == 1) {
            this.L.setTag(1);
            T();
            return;
        }
        if (i3 == 2) {
            this.L.setImageDrawable(this.f239534f.getResources().getDrawable(R.drawable.due));
            this.L.setTag(2);
            T();
        } else {
            if (i3 != 3) {
                return;
            }
            this.L.setVisibility(0);
            this.L.startAnimation(this.f239538h0);
            this.L.setImageDrawable(this.f239534f.getResources().getDrawable(R.drawable.dud));
            this.L.setTag(3);
        }
    }

    private void k0() {
        k62.b bVar = this.D;
        if (bVar == null) {
            return;
        }
        FrameLayout frameLayout = this.f239530d;
        if (frameLayout instanceof RoundAngleFrameLayout) {
            ((RoundAngleFrameLayout) frameLayout).setRadius(bVar.C, bVar.D, bVar.E, bVar.F);
        }
    }

    private void l(boolean z16) {
        if (R()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.I.getLayoutParams();
            if (z16) {
                layoutParams.width = x.c(this.f239534f, 91.0f);
                layoutParams.height = x.c(this.f239534f, 28.0f);
                layoutParams.rightMargin = x.c(this.f239534f, 16.0f);
                layoutParams.topMargin = x.c(this.f239534f, 16.0f);
            } else {
                layoutParams.width = x.c(this.f239534f, 78.0f);
                layoutParams.height = x.c(this.f239534f, 24.0f);
                layoutParams.rightMargin = x.c(this.f239534f, 8.0f);
                layoutParams.topMargin = x.c(this.f239534f, 8.0f);
            }
            this.I.setLayoutParams(layoutParams);
        }
    }

    private void o() {
        if (Q()) {
            J();
        } else {
            k0();
        }
    }

    private void p() {
        this.f239527a0.setVisibility(8);
    }

    private void t() {
        this.E.D();
    }

    private String v() {
        return null;
    }

    private String w() {
        return null;
    }

    private void z(k62.b bVar, int i3, Object obj) {
        if (!V(bVar) && this.F.k() && this.D.B) {
            this.F.b(bVar);
            return;
        }
        if (this.f239550r0 == 2) {
            VideoAutoPlayController.sPauseScrollToNextVideo = true;
            e0(2);
            this.f239549q0.removeCallbacksAndMessages(null);
        } else {
            u(false);
            m0();
        }
    }

    public void H() {
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.L.clearAnimation();
        if (!Q() && 7 != this.E.B()) {
            this.S.setVisibility(0);
        } else {
            this.S.setVisibility(8);
        }
        this.P.setEnabled(true);
    }

    public boolean Q() {
        if (this.f239530d.getVisibility() != 0) {
            return false;
        }
        return this.f239529c0;
    }

    public boolean S() {
        RelativeLayout relativeLayout = this.N;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public void W() {
        k62.b bVar;
        if (this.f239530d.getVisibility() != 0 || this.f239529c0 || (bVar = this.D) == null || bVar.f411775g == null) {
            return;
        }
        this.f239532e.getLocationOnScreen(this.C);
        int[] iArr = this.C;
        this.f239544m = iArr[1];
        this.D.f411775g.getLocationOnScreen(iArr);
        if (this.f239530d.getX() != this.D.f411775g.getX() && this.D.f411775g.getX() != 0.0f) {
            com.tencent.mobileqq.businessCard.helpers.b.g(this.f239530d, this.C[0]);
        }
        float f16 = this.C[1] - this.f239544m;
        if (f16 == this.f239530d.getTranslationY()) {
            return;
        }
        com.tencent.mobileqq.businessCard.helpers.b.f(this.f239530d, f16);
    }

    public void Y(k62.b bVar) {
        this.D = bVar;
        if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.videoVideoUIManager", 2, "playVideo(): videoPlayParam=" + bVar);
        }
        k62.b bVar2 = this.D;
        if (bVar2 != null && bVar2.f411790v) {
            q(false);
            this.f239540i0 = false;
        }
        L();
        N();
        M();
        W();
    }

    @Override // f62.e
    public void b(k62.b bVar, o52.c cVar, int i3, int i16, Object obj) {
        k62.b bVar2 = this.D;
        if (bVar2 == null || bVar == null || bVar2 != bVar) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.readinjoy.videoVideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
                return;
            }
            return;
        }
        if (i16 == 0) {
            B(bVar, i3, obj);
            return;
        }
        if (i16 == 1) {
            F(bVar, i3, obj);
            return;
        }
        if (i16 == 2) {
            E(bVar, i3, obj);
            return;
        }
        if (i16 == 3) {
            D(bVar, i3, obj);
            return;
        }
        if (i16 == 4) {
            y(bVar, i3, obj);
            return;
        }
        if (i16 == 5) {
            C(bVar, i3, obj);
        } else if (i16 == 6) {
            A(bVar, i3, obj);
        } else if (i16 == 7) {
            z(bVar, i3, obj);
        }
    }

    public void m0() {
        this.f239530d.setVisibility(8);
        this.f239549q0.removeCallbacksAndMessages(null);
        a0();
    }

    public void n0(AbsListView absListView) {
        int i3;
        if (Q()) {
            return;
        }
        int headerViewsCount = ((ReadInJoyBaseListView) absListView).getHeaderViewsCount();
        int firstVisiblePosition = absListView.getFirstVisiblePosition() - headerViewsCount;
        if (firstVisiblePosition < 0) {
            firstVisiblePosition = 0;
        }
        int lastVisiblePosition = absListView.getLastVisiblePosition() - headerViewsCount;
        VideoPlayManager videoPlayManager = this.E;
        if (videoPlayManager == null || videoPlayManager.D() == null || (i3 = this.E.D().f411772d) < 0) {
            return;
        }
        if (i3 < firstVisiblePosition || i3 > lastVisiblePosition) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.videoVideoUIManager", 2, "triggerVideoRecycleCheck => stop video\uff0cfirstVisblePosi:" + firstVisiblePosition + ",lastVisiblePosi:" + lastVisiblePosition + ",playingPosi:" + i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.videoVideoUIManager", 2, "triggerVideoRecycleCheck => stop video\uff0cplayParam:" + this.E.D());
            }
            this.E.Y(10);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.OrientationDetector.b
    public void onOrientationChanged(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.videoVideoUIManager", 2, "onOrientationChanged=> orientation=" + i3);
        }
        if (i3 == 0) {
            r(0);
            return;
        }
        if (i3 == 1) {
            u(false);
        } else if (i3 == 8) {
            r(8);
        } else {
            if (i3 != 9) {
                return;
            }
            u(false);
        }
    }

    public void q(boolean z16) {
        k62.b bVar;
        OrientationDetector orientationDetector = this.f239528b0;
        if (orientationDetector != null) {
            orientationDetector.k(z16);
        }
        OrientationDetector orientationDetector2 = this.f239528b0;
        if (orientationDetector2 == null || (bVar = this.D) == null || !bVar.f411790v) {
            return;
        }
        orientationDetector2.k(false);
        this.f239540i0 = false;
    }

    public void q0() {
        if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.videoVideoUIManager", 2, "updateVideoViewSize");
        }
        if (this.D == null) {
            return;
        }
        float f16 = ah.f(this.f239534f);
        k62.b bVar = this.D;
        if (bVar.f411790v) {
            int i3 = bVar.f411793y;
            if (i3 > 0) {
                f16 = i3;
            }
        } else {
            f16 = 0.0f;
        }
        float h16 = f.h(bVar.f411780l, bVar.f411781m) * f16;
        if (this.F.k()) {
            this.f239531d0 = (int) f16;
            this.f239533e0 = (int) h16;
            b0();
            return;
        }
        if (this.f239530d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f239530d.getLayoutParams();
            layoutParams.width = (int) f16;
            layoutParams.height = (int) h16;
            layoutParams.gravity = 1;
            this.f239530d.setLayoutParams(layoutParams);
        } else if (this.f239530d.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f239530d.getLayoutParams();
            layoutParams2.width = (int) f16;
            layoutParams2.height = (int) h16;
            layoutParams2.addRule(14);
            this.f239530d.setLayoutParams(layoutParams2);
        }
        this.H.a(true);
        k62.b bVar2 = this.D;
        if (bVar2 != null) {
            this.H.setCustomSize(1.0f, h16 / f16);
        } else {
            this.H.setCustomSize(1.0f, f.h(bVar2.f411780l, bVar2.f411781m));
        }
    }

    public void s(int i3, boolean z16) {
        if (this.f239530d.getVisibility() != 0) {
            return;
        }
        int B = this.E.B();
        if (B != 0 && B != 1 && B != 7 && B != 2 && B != 4) {
            if (this.f239529c0) {
                return;
            }
            this.f239529c0 = true;
            X(true, this.E.D(), null);
            o0(true);
            this.f239542k0 = this.E.H();
            if (z16 && V(this.D)) {
                if (this.f239528b0.k(false)) {
                    this.f239540i0 = true;
                }
            } else if (i3 == 0) {
                this.f239534f.setRequestedOrientation(0);
            } else {
                this.f239534f.setRequestedOrientation(8);
            }
            Window window = this.f239534f.getWindow();
            window.setFlags(1024, 1024);
            if (this.f239530d.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) this.f239530d.getParent();
                this.f239547o0 = viewGroup;
                this.f239548p0 = viewGroup.indexOfChild(this.f239530d);
                this.D.f411776h.b();
                this.f239547o0.removeView(this.f239530d);
                this.D.f411776h.c();
                window.addContentView(this.f239530d, new ViewGroup.LayoutParams(-1, -1));
            }
            this.f239531d0 = this.f239530d.getWidth();
            this.f239533e0 = this.f239530d.getHeight();
            if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.videoVideoUIManager", 2, "FullScreen => mOriginalWidth=" + this.f239531d0 + ", mOriginalHeight=" + this.f239533e0 + ", playState=" + com.tencent.mobileqq.kandian.base.video.a.c(B) + "\uff0cuserClickEnter:" + z16);
            }
            b0();
            this.f239530d.setTranslationY(0.0f);
            t();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.readinjoy.videoVideoUIManager", 2, "innerEnterFullScreen => playState=" + com.tencent.mobileqq.kandian.base.video.a.c(B) + ", illegal state just ignore fullscreen.");
        }
    }

    public void u(boolean z16) {
        if (this.f239530d.getVisibility() == 0 && this.f239529c0) {
            this.f239529c0 = false;
            this.F.d();
            o0(false);
            this.f239534f.setRequestedOrientation(1);
            Window window = this.f239534f.getWindow();
            window.clearFlags(1024);
            window.addFlags(this.f239535f0);
            window.getDecorView().setSystemUiVisibility(this.f239536g0);
            if (this.f239530d.getParent() instanceof ViewGroup) {
                this.D.f411776h.b();
                ((ViewGroup) this.f239530d.getParent()).removeView(this.f239530d);
                this.D.f411776h.c();
                this.f239547o0.addView(this.f239530d, this.f239548p0, new ViewGroup.LayoutParams(-1, -1));
                this.f239547o0 = null;
            }
            H();
            ViewGroup.LayoutParams layoutParams = this.f239530d.getLayoutParams();
            layoutParams.width = this.f239531d0;
            layoutParams.height = this.f239533e0;
            this.f239530d.setLayoutParams(layoutParams);
            this.H.a(true);
            if (this.f239540i0) {
                this.f239528b0.k(true);
            }
            this.E.X(this.f239542k0);
            this.f239530d.setBackgroundColor(0);
            if (this.F.h() != null && (this.F.h() instanceof k62.b)) {
                X(false, (k62.b) this.F.h(), this.D);
            }
            l(false);
            if (z16) {
                Z();
            }
            q0();
            W();
        }
    }

    private void a0() {
        VideoAutoPlayController.sPauseScrollToNextVideo = false;
        this.f239551s0 = false;
        this.f239550r0 = 0;
    }

    public void r(int i3) {
        s(i3, false);
    }

    public static boolean V(k62.b bVar) {
        if (bVar == null) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.w("Q.readinjoy.videoVideoUIManager", 2, "isProtraitVideo return false for videoPlayParam is null.");
            return false;
        }
        return U(bVar.f411780l, bVar.f411781m);
    }

    private void o0(boolean z16) {
        if (z16) {
            this.Q.setImageDrawable(this.f239534f.getResources().getDrawable(R.drawable.d8m));
        } else {
            this.Q.setImageDrawable(this.f239534f.getResources().getDrawable(R.drawable.d8n));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 0) {
            n0(absListView);
        }
    }

    private void B(k62.b bVar, int i3, Object obj) {
        if (i3 == 3) {
            if (Q()) {
                u(false);
            }
            m0();
            return;
        }
        m0();
    }

    private void y(k62.b bVar, int i3, Object obj) {
        if (i3 == 0) {
            this.N.setVisibility(8);
            G();
            j0(3);
            this.S.setVisibility(8);
        } else if (i3 == 3) {
            j0(3);
        }
        this.f239549q0.removeMessages(102);
        this.f239549q0.removeMessages(103);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        int i18;
        int i19 = (i16 + i3) - 1;
        int i26 = this.f239537h;
        if ((i26 != -1 && i26 != i3) || ((i18 = this.f239539i) != -1 && i18 != i19)) {
            n0(absListView);
        }
        this.f239537h = i3;
        this.f239539i = i19;
    }

    private void c0(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        p0(imageView, VideoVolumeControl.getInstance().isMute());
    }

    private static Drawable x(Context context, boolean z16) {
        int c16;
        int c17;
        if (z16) {
            c16 = x.c(context, 12.0f);
            c17 = x.c(context, 60.0f);
        } else {
            c16 = x.c(context, 6.0f);
            c17 = x.c(context, 28.0f);
        }
        return new com.tencent.mobileqq.drawable.c(-2565928, c16, c17, c17);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.biz.video.VideoUIManager$4, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ VideoUIManager this$0;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private void N() {
    }

    private void Z() {
    }

    private void l0() {
    }

    private void m() {
    }

    private void n() {
    }

    @Override // com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.b
    public void a(k62.b bVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void p0(ImageView imageView, boolean z16) {
    }

    @Override // com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.b
    public void c(k62.b bVar, boolean z16) {
    }

    private void E(k62.b bVar, int i3, Object obj) {
    }
}
