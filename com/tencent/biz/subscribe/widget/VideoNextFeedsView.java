package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VideoNextFeedsView extends FrameLayout {
    private boolean C;
    private int D;
    private int E;
    private int F;
    private int G;
    private CertifiedAccountMeta$StFeed H;
    private View I;
    private Timer J;
    private int K;
    private List<CertifiedAccountMeta$StFeed> L;
    private int M;
    private a N;
    private CircleProgress P;
    private TextView Q;
    private int R;

    /* renamed from: d, reason: collision with root package name */
    private final String f96457d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f96458e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f96459f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f96460h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f96461i;

    /* renamed from: m, reason: collision with root package name */
    private int f96462m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z16);
    }

    public VideoNextFeedsView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Timer timer = this.J;
        if (timer != null) {
            timer.cancel();
            this.J = null;
            this.K = 5;
        }
    }

    private void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167711er, (ViewGroup) null);
        this.I = inflate;
        addView(inflate);
        this.f96459f = (ImageView) this.I.findViewById(R.id.dwi);
        this.f96461i = (TextView) this.I.findViewById(R.id.k9r);
        this.f96460h = (TextView) this.I.findViewById(R.id.k9s);
        this.Q = (TextView) this.I.findViewById(R.id.k6v);
        this.f96458e = (ImageView) this.I.findViewById(R.id.dwj);
        CircleProgress circleProgress = (CircleProgress) this.I.findViewById(R.id.bbe);
        this.P = circleProgress;
        circleProgress.setBgAndProgressColor(30, Color.parseColor(TipsElementData.DEFAULT_COLOR), 100, Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.P.setStrokeWidth(UIUtils.b(getContext(), 1.0f));
        setVisibility(8);
    }

    private boolean l() {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        float f16;
        if (this.L == null) {
            return false;
        }
        while (true) {
            if (this.M < this.L.size()) {
                certifiedAccountMeta$StFeed = this.L.get(this.M);
                if (certifiedAccountMeta$StFeed != null && d.h(certifiedAccountMeta$StFeed.type.get())) {
                    break;
                }
                this.M++;
            } else {
                certifiedAccountMeta$StFeed = null;
                break;
            }
        }
        if (certifiedAccountMeta$StFeed == null) {
            QZLog.e("VideoNextFeedsView", "playNextData():no more feed can play!");
            return false;
        }
        ImageView imageView = this.f96459f;
        String str = certifiedAccountMeta$StFeed.poster.icon.get();
        int b16 = UIUtils.b(getContext(), this.f96462m);
        int b17 = UIUtils.b(getContext(), this.f96462m);
        Context context = getContext();
        if (this.C) {
            f16 = 10.0f;
        } else {
            f16 = 9.0f;
        }
        UIUtils.q(imageView, str, b16, b17, UIUtils.b(context, f16), BaseImageUtil.getDefaultFaceDrawable(), null);
        UIUtils.t(this.f96458e, certifiedAccountMeta$StFeed.cover.url.get(), this.F, this.G, getResources().getDrawable(R.drawable.b9s), null);
        this.f96461i.setText(certifiedAccountMeta$StFeed.title.get());
        this.f96460h.setText(certifiedAccountMeta$StFeed.poster.nick.get());
        this.H = certifiedAccountMeta$StFeed;
        this.M++;
        return true;
    }

    public CertifiedAccountMeta$StFeed h() {
        return this.H;
    }

    public void i() {
        if (getHandler() != null) {
            getHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.VideoNextFeedsView.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoNextFeedsView.this.setVisibility(8);
                    VideoNextFeedsView.this.g();
                }
            });
        }
    }

    public void k(boolean z16) {
        if (z16) {
            this.R = this.K;
            g();
        } else {
            o();
            this.R = 0;
        }
    }

    public void m() {
        a aVar = this.N;
        if (aVar != null) {
            aVar.a(l());
        }
    }

    public boolean n() {
        if (l()) {
            o();
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }

    public void o() {
        g();
        int i3 = this.R;
        if (i3 != 0) {
            this.K = i3;
        }
        BaseTimer baseTimer = new BaseTimer();
        this.J = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.biz.subscribe.widget.VideoNextFeedsView.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (VideoNextFeedsView.this.K <= 0) {
                    VideoNextFeedsView.this.g();
                    VideoNextFeedsView.this.i();
                    if (VideoNextFeedsView.this.N != null) {
                        VideoNextFeedsView.this.N.a(true);
                        return;
                    }
                    return;
                }
                if (VideoNextFeedsView.this.getHandler() != null) {
                    VideoNextFeedsView.this.getHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.VideoNextFeedsView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoNextFeedsView.this.Q != null && VideoNextFeedsView.this.P != null) {
                                VideoNextFeedsView.this.P.setProgress(100.0f - ((VideoNextFeedsView.this.K * 100.0f) / 5.0f));
                                VideoNextFeedsView.this.Q.setText(String.valueOf(VideoNextFeedsView.this.K));
                            }
                        }
                    });
                }
                VideoNextFeedsView.this.K--;
            }
        }, 0L, 1000L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
        g();
    }

    public void setData(List<CertifiedAccountMeta$StFeed> list) {
        this.M = 0;
        this.L = list;
    }

    public void setOnCounterListener(a aVar) {
        this.N = aVar;
    }

    public void setUIState(boolean z16, boolean z17) {
        int screenWidth;
        float f16;
        int i3;
        float f17;
        float f18;
        float f19;
        float f26;
        if (z17) {
            screenWidth = ImmersiveUtils.dpToPx(400.0f);
        } else {
            screenWidth = (int) (ImmersiveUtils.getScreenWidth() * 0.88d);
        }
        this.C = z16;
        if (z16) {
            f16 = 14.0f;
        } else {
            f16 = 8.0f;
        }
        int dpToPx = ImmersiveUtils.dpToPx(f16);
        if (!z16) {
            screenWidth = ImmersiveUtils.dpToPx(331.0f);
        }
        this.D = screenWidth;
        if (z16) {
            i3 = ImmersiveUtils.dpToPx(135.0f);
        } else {
            i3 = -2;
        }
        this.E = i3;
        if (z16) {
            f17 = 133.0f;
        } else {
            f17 = 75.0f;
        }
        this.F = ImmersiveUtils.dpToPx(f17);
        if (z16) {
            f18 = 103.0f;
        } else {
            f18 = 59.0f;
        }
        this.G = ImmersiveUtils.dpToPx(f18);
        if (z16) {
            f19 = 20.0f;
        } else {
            f19 = 18.0f;
        }
        this.f96462m = ImmersiveUtils.dpToPx(f19);
        if (z16) {
            f26 = 30.0f;
        } else {
            f26 = 10.0f;
        }
        int dpToPx2 = ImmersiveUtils.dpToPx(f26);
        this.I.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        getLayoutParams().width = this.D;
        getLayoutParams().height = this.E;
        this.f96459f.getLayoutParams().width = this.f96462m;
        this.f96459f.getLayoutParams().height = this.f96462m;
        this.f96458e.getLayoutParams().width = this.F;
        this.f96458e.getLayoutParams().height = this.G;
        this.f96461i.setPadding(0, 0, dpToPx2, 0);
        requestLayout();
    }

    public VideoNextFeedsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoNextFeedsView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f96457d = "VideoNextFeedsView";
        this.f96462m = UIUtils.b(getContext(), 18.0f);
        this.C = false;
        this.D = UIUtils.b(getContext(), 331.0f);
        this.E = UIUtils.b(getContext(), 75.0f);
        this.K = 5;
        this.M = 0;
        j();
    }
}
