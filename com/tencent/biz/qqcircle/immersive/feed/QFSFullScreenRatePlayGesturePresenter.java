package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.media.QUICombinationSeekBar;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSFullScreenRatePlayGesturePresenter extends dr implements SeekBar.OnSeekBarChangeListener {
    private QFSRatePlayGestureDetectorView N;
    private boolean P;
    private FrameLayout Q;
    private ImageView R;
    private ImageView S;
    private TextView T;
    private LinearLayout U;
    private QFSPagAnimView V;
    private ValueAnimator W;
    private Runnable X;
    private QUICombinationSeekBar Y;
    private ImageView Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (QFSFullScreenRatePlayGesturePresenter.this.R != null) {
                QFSFullScreenRatePlayGesturePresenter.this.R.setAlpha(floatValue);
            }
            if (QFSFullScreenRatePlayGesturePresenter.this.S != null) {
                QFSFullScreenRatePlayGesturePresenter.this.S.setAlpha(1.0f - floatValue);
            }
        }
    }

    private void A1(boolean z16) {
        String str;
        String str2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193474_a) + "\uff0c";
        if (z16) {
            str = str2 + com.tencent.biz.qqcircle.utils.h.a(R.string.f193594_m);
        } else {
            str = str2 + com.tencent.biz.qqcircle.utils.h.a(R.string.f193604_n);
        }
        G1(str);
    }

    private void B1() {
        this.X = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenRatePlayGesturePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                QFSFullScreenRatePlayGesturePresenter.this.x1();
            }
        };
    }

    private void C1() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.8f, 0.2f).setDuration(500L);
        this.W = duration;
        duration.addUpdateListener(new a());
        this.W.setRepeatCount(-1);
        this.W.setRepeatMode(2);
    }

    private void D1() {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.j(true));
    }

    private void E1() {
        this.W.start();
    }

    private void F1() {
        if (!this.L && com.tencent.biz.qqcircle.utils.cb.f92739a) {
            LinearLayout linearLayout = this.U;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            this.V.M("https://downV6.qq.com/video_story/qcircle/pag/qfs_full_screen_scroll_down.pag");
            x0().removeCallbacks(this.X);
            x0().postDelayed(this.X, 4000L);
            com.tencent.biz.qqcircle.utils.cb.f92739a = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G1(String str) {
        FrameLayout frameLayout = this.Q;
        if (frameLayout == null) {
            return;
        }
        com.tencent.biz.qqcircle.utils.cb.e(frameLayout, (FeedCloudMeta$StFeed) this.f85017h, 2.0f, r0());
        this.Q.setVisibility(0);
        this.T.setText(str);
    }

    private void H1() {
        this.W.cancel();
    }

    private void w1(boolean z16) {
        int b16;
        QFSRatePlayGestureDetectorView qFSRatePlayGestureDetectorView = this.N;
        if (qFSRatePlayGestureDetectorView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) qFSRatePlayGestureDetectorView.getLayoutParams();
        if (z16) {
            b16 = 0;
        } else {
            b16 = com.tencent.qqnt.base.utils.c.f353052a.b(85);
        }
        layoutParams.setMargins(0, 0, 0, b16);
        this.N.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        LinearLayout linearLayout = this.U;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            this.V.V();
        }
        x0().removeCallbacks(this.X);
    }

    private void y1() {
        FrameLayout frameLayout = this.Q;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    private void z1(com.tencent.biz.qqcircle.immersive.feed.event.j jVar) {
        w1(jVar.b());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.j) {
            z1((com.tencent.biz.qqcircle.immersive.feed.event.j) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView.b
    public void D(View view, boolean z16) {
        super.D(view, z16);
        if (!q1()) {
            return;
        }
        if (this.L) {
            A1(z16);
        } else if (z16) {
            G1(com.tencent.biz.qqcircle.utils.h.a(R.string.f193474_a));
        } else {
            G1(com.tencent.biz.qqcircle.utils.h.a(R.string.f193464__));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View inflate = ((ViewStub) view.findViewById(R.id.f25940c7)).inflate();
        QFSRatePlayGestureDetectorView qFSRatePlayGestureDetectorView = (QFSRatePlayGestureDetectorView) inflate.findViewById(R.id.f42481jw);
        this.N = qFSRatePlayGestureDetectorView;
        qFSRatePlayGestureDetectorView.setYOrientationChangeListener(this);
        this.N.setLongPressListener(this);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.f490421m);
        this.Q = frameLayout;
        com.tencent.biz.qqcircle.immersive.utils.bk.d(frameLayout, 18);
        this.R = (ImageView) inflate.findViewById(R.id.v76);
        this.S = (ImageView) inflate.findViewById(R.id.f81704ew);
        this.T = (TextView) inflate.findViewById(R.id.f490721p);
        this.U = (LinearLayout) inflate.findViewById(R.id.f490321l);
        this.V = (QFSPagAnimView) inflate.findViewById(R.id.f490621o);
        QUICombinationSeekBar qUICombinationSeekBar = (QUICombinationSeekBar) view.findViewById(R.id.f42691kg);
        this.Y = qUICombinationSeekBar;
        qUICombinationSeekBar.b(this);
        this.Z = this.Y.c();
        C1();
        B1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        QUICombinationSeekBar qUICombinationSeekBar = this.Y;
        if (qUICombinationSeekBar == null) {
            return;
        }
        qUICombinationSeekBar.g(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        y1();
        x1();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        QFSRatePlayGestureDetectorView qFSRatePlayGestureDetectorView = this.N;
        if (qFSRatePlayGestureDetectorView == null) {
            return;
        }
        qFSRatePlayGestureDetectorView.setVisibility(8);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        QFSRatePlayGestureDetectorView qFSRatePlayGestureDetectorView = this.N;
        if (qFSRatePlayGestureDetectorView != null) {
            qFSRatePlayGestureDetectorView.setVisibility(0);
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView.a
    public void q(View view) {
        super.q(view);
        H1();
        y1();
        x1();
        if (this.P) {
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.j(false));
        }
        QUICombinationSeekBar qUICombinationSeekBar = this.Y;
        if (qUICombinationSeekBar != null) {
            qUICombinationSeekBar.setEnabled(true);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView.a
    public void w(View view) {
        boolean z16;
        String a16;
        super.w(view);
        View findViewById = this.C.findViewById(R.id.f42721kj);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.P = z16;
        QLog.d("QFSFullScreenPlayRateGuestPresenter", 1, "recover screen:" + this.P);
        D1();
        if (this.L) {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193474_a) + "\uff0c" + com.tencent.biz.qqcircle.utils.h.a(R.string.f193594_m);
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193474_a);
        }
        G1(a16);
        E1();
        F1();
        ImageView imageView = this.Z;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ntn);
        }
        QUICombinationSeekBar qUICombinationSeekBar = this.Y;
        if (qUICombinationSeekBar != null) {
            qUICombinationSeekBar.h(true);
            this.Y.setEnabled(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFullScreenPlayRateGuestPresenter";
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
    }
}
