package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.RangeSelectBar;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import cooperation.peak.PeakConstants;
import fd0.a;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ScrollFrameSelectBar extends FrameLayout implements RangeSelectBar.a, TrimTextureVideoView.b, a.f {
    public static int T = 15;
    public static int U = 15;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private b K;
    private TrimTextureVideoView L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private int S;

    /* renamed from: d, reason: collision with root package name */
    private int f94429d;

    /* renamed from: e, reason: collision with root package name */
    private HorizontalListView f94430e;

    /* renamed from: f, reason: collision with root package name */
    private RangeSelectBar f94431f;

    /* renamed from: h, reason: collision with root package name */
    private ProgressPointer f94432h;

    /* renamed from: i, reason: collision with root package name */
    private kd0.a f94433i;

    /* renamed from: m, reason: collision with root package name */
    private kd0.b f94434m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements HorizontalListView.OnScrollStateChangedListener {
        a() {
        }

        @Override // com.tencent.widget.HorizontalListView.OnScrollStateChangedListener
        public void onScrollStateChanged(int i3) {
            c.b("Q.qqstory.frameWidget.ScrollFrameSelectBar", "onScrollStateChanged:%s", Integer.valueOf(i3));
            switch (i3) {
                case 4097:
                    ScrollFrameSelectBar.this.o();
                    return;
                case 4098:
                case 4099:
                    if (ScrollFrameSelectBar.this.L.isPlaying()) {
                        ScrollFrameSelectBar.this.L.s();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a0(int i3, int i16);

        void n(int i3, int i16);
    }

    public ScrollFrameSelectBar(Context context) {
        super(context);
        this.f94429d = 1000;
        this.J = 20000;
        this.M = 1000;
        this.N = 0;
        this.P = 1000 * 10;
        m();
    }

    @TargetApi(10)
    private void m() {
        this.D = UIUtils.m(getContext());
        this.E = UIUtils.b(getContext(), T);
        this.F = UIUtils.b(getContext(), U);
        LayoutInflater.from(getContext()).inflate(R.layout.f169079bx2, this);
        HorizontalListView horizontalListView = (HorizontalListView) findViewById(R.id.iic);
        this.f94430e = horizontalListView;
        horizontalListView.setOverScrollMode(2);
        this.f94431f = (RangeSelectBar) findViewById(R.id.iid);
        this.f94432h = (ProgressPointer) findViewById(R.id.gwp);
        this.f94431f.setRangeChangeListener(this);
        this.G = this.f94430e.getPaddingLeft();
        this.H = this.f94430e.getPaddingRight();
        this.I = ((FrameLayout.LayoutParams) this.f94430e.getLayoutParams()).rightMargin;
        this.f94430e.setOnScrollStateChangedListener(new a());
        if ("tribe".equals(((Activity) getContext()).getIntent().getStringExtra(PeakConstants.VIDEO_REFER))) {
            this.M = AECameraConstants.VIDEO_DURATION_FOR_TRIBE / 10;
        }
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.b
    public void a() {
        if (this.L != null) {
            this.f94432h.setRange(this.f94431f.c(), this.f94431f.a(), this.P - this.L.o());
        }
        this.f94432h.c();
    }

    @Override // com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.RangeSelectBar.a
    public void b(int i3, int i16) {
        o();
    }

    @Override // com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.RangeSelectBar.a
    public void c() {
        n();
    }

    @Override // fd0.a.f
    public void d(fd0.a aVar) {
        this.f94432h.b();
    }

    public void f(String str, int i3, int i16, int i17, boolean z16, boolean z17, int i18) {
        int ceil;
        float f16;
        int i19 = getResources().getDisplayMetrics().widthPixels;
        int i26 = getResources().getDisplayMetrics().heightPixels;
        int i27 = this.R;
        this.Q = i3;
        int i28 = 10;
        if (z17) {
            if (i3 > 60000) {
                this.M = 6000;
                ceil = (int) Math.ceil((i3 * 1.0f) / 6000);
                f16 = (this.Q * 1.0f) / this.M;
            } else {
                this.M = (int) Math.ceil((i3 * 1.0f) / 10.0f);
                f16 = 10;
                this.F = 0;
                ceil = 10;
            }
        } else {
            if ("tribe".equals(((Activity) getContext()).getIntent().getStringExtra(PeakConstants.VIDEO_REFER))) {
                this.M = AECameraConstants.VIDEO_DURATION_FOR_TRIBE / 10;
            } else {
                this.M = this.J / 10;
            }
            ceil = (int) Math.ceil((this.Q * 1.0f) / this.M);
            float f17 = (this.Q * 1.0f) / this.M;
            if (ceil <= 10) {
                this.M = (int) Math.ceil((r8 * 1.0f) / ceil);
            }
            f16 = f17;
        }
        int i29 = ((i27 - this.E) - this.F) / 10;
        this.C = i29;
        int i36 = (int) ((i17 / i16) * i29);
        int a16 = (int) (i29 * com.tencent.biz.qqstory.takevideo.a.a(getResources()));
        this.f94433i = new kd0.a(getContext(), ceil, this.C, a16);
        kd0.b bVar = new kd0.b("frame_loader", this.C, i36, z16);
        this.f94434m = bVar;
        bVar.j(str, i3, this.M);
        this.f94433i.c(this.f94434m);
        if (ceil <= 10) {
            i28 = ceil;
        }
        ((FrameLayout.LayoutParams) this.f94430e.getLayoutParams()).rightMargin = ((i27 - this.E) - this.F) - (i28 * this.C);
        this.f94430e.setAdapter((ListAdapter) this.f94433i);
        if (f16 > 10.0f) {
            f16 = 10.0f;
        }
        if (a16 <= 0) {
            a16 = 100;
        }
        this.f94431f.setFrameSize(a16, this.C, this.M, f16, this.f94429d);
        this.f94432h.setFrameSize(a16, this.C);
        this.f94431f.setVisibility(0);
        o();
    }

    public void g(int i3, int i16, int i17, long j3, long j16) {
        if (i16 >= 0 && i17 > 0 && i3 >= 0) {
            this.f94430e.scrollBy2(i3);
            this.f94431f.setStartIndex(i16);
            this.f94431f.setEndIndex(i17);
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.frameWidget.ScrollFrameSelectBar", 2, "changeSelectBarState rememberUI startIndex : " + i16 + " endIndex : " + i17 + " scrollX : " + i3);
                return;
            }
            return;
        }
        if (j16 < 20 && j3 > j16) {
            int b16 = (int) (((((float) j3) / this.M) * this.C) + this.f94431f.b());
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.frameWidget.ScrollFrameSelectBar", 2, "changeSelectBarState startTime : " + j16 + " endIndex : " + b16 + " endTime : " + j3);
            }
            this.f94430e.scrollBy2(0);
            this.f94431f.setStartIndex(0);
            this.f94431f.setEndIndex(b16);
        }
    }

    @TargetApi(10)
    public void h() {
        kd0.a aVar = this.f94433i;
        if (aVar != null) {
            aVar.b();
        }
        kd0.b bVar = this.f94434m;
        if (bVar != null) {
            bVar.g();
        }
    }

    public int i() {
        return this.f94431f.a();
    }

    public int j() {
        View childAt = this.f94430e.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (-(childAt.getLeft() - this.G)) + (this.f94430e.getFirstVisiblePosition() * childAt.getWidth());
    }

    public int[] k() {
        View childAt = this.f94430e.getChildAt(0);
        if (childAt == null) {
            return null;
        }
        int firstVisiblePosition = this.f94430e.getFirstVisiblePosition();
        int left = childAt.getLeft() - this.G;
        float c16 = this.f94431f.c();
        float a16 = this.f94431f.a();
        float f16 = this.M;
        float f17 = -left;
        float f18 = firstVisiblePosition * f16;
        int width = (int) (((f17 / childAt.getWidth()) * f16) + f18 + (((c16 - this.f94431f.b()) / this.C) * f16));
        int width2 = (int) (((f17 / childAt.getWidth()) * f16) + f18 + (((a16 - this.f94431f.b()) / this.C) * f16));
        int i3 = width2 - width;
        int i16 = this.f94429d;
        if (i3 < i16) {
            if (width >= i16) {
                width = width2 - i16;
            } else {
                width2 = width + i16;
            }
        }
        return new int[]{width, width2};
    }

    public int l() {
        return this.f94431f.c();
    }

    public void n() {
        b bVar;
        int[] k3 = k();
        if (k3 != null && k3.length >= 2 && (bVar = this.K) != null) {
            bVar.a0(k3[0], k3[1]);
        }
    }

    public void o() {
        int[] k3 = k();
        if (k3 != null && k3.length >= 2) {
            this.N = k3[0];
            this.P = k3[1];
            if (this.L.isPlaying()) {
                this.L.s();
            }
            this.L.setPlayRange(this.N, this.P);
            this.L.t(true);
            b bVar = this.K;
            if (bVar != null) {
                bVar.n(this.N, this.P);
            }
            this.f94432h.setRange(this.f94431f.c(), this.f94431f.a(), this.P - this.L.o());
            this.f94432h.c();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.R = View.MeasureSpec.getSize(i3);
        this.S = View.MeasureSpec.getSize(i16);
    }

    public void setLocalVideoView(TrimTextureVideoView trimTextureVideoView) {
        this.L = trimTextureVideoView;
        trimTextureVideoView.setOnRecyclePlayListener(this);
        trimTextureVideoView.setOnSeekCompleteListener(this);
    }

    public void setMaxVideoDuration(int i3) {
        this.J = i3;
    }

    public void setMinDuration(int i3) {
        this.f94429d = i3;
    }

    public void setOnRangeValueChangeListener(b bVar) {
        this.K = bVar;
    }

    public ScrollFrameSelectBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94429d = 1000;
        this.J = 20000;
        this.M = 1000;
        this.N = 0;
        this.P = 1000 * 10;
        m();
    }

    public ScrollFrameSelectBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94429d = 1000;
        this.J = 20000;
        this.M = 1000;
        this.N = 0;
        this.P = 1000 * 10;
        m();
    }
}
