package com.tencent.av.ui.beauty;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BeautySeekView extends RelativeLayout {
    private static final int M = 2131239155;
    private static final int N = 2131239156;
    private int C;
    private Handler D;
    private c E;
    public boolean F;
    private String G;
    private int H;
    private boolean I;
    private int J;
    Runnable K;
    SeekBar.OnSeekBarChangeListener L;

    /* renamed from: d, reason: collision with root package name */
    private TextView f75426d;

    /* renamed from: e, reason: collision with root package name */
    private SeekBar f75427e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f75428f;

    /* renamed from: h, reason: collision with root package name */
    private View f75429h;

    /* renamed from: i, reason: collision with root package name */
    private int f75430i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f75431m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BeautySeekView beautySeekView = BeautySeekView.this;
            if (beautySeekView.F && beautySeekView.f75427e != null && BeautySeekView.this.f75427e.getWidth() > 0) {
                BeautySeekView beautySeekView2 = BeautySeekView.this;
                beautySeekView2.F = false;
                beautySeekView2.o(beautySeekView2.f75427e.getProgress());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            if (BeautySeekView.this.f75430i != i3) {
                BeautySeekView.this.o(i3);
                if (z16 && BeautySeekView.this.f75427e != null) {
                    BeautySeekView.this.f75427e.setContentDescription(i3 + "%");
                }
                BeautySeekView.this.f75430i = i3;
                BeautySeekView beautySeekView = BeautySeekView.this;
                beautySeekView.j(beautySeekView.f75430i);
            }
            if (BeautySeekView.this.E != null) {
                BeautySeekView.this.E.a(BeautySeekView.this.G, 2, i3);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            BeautySeekView.this.D.removeCallbacks(BeautySeekView.this.K);
            BeautySeekView.this.f75428f.setVisibility(0);
            if (BeautySeekView.this.E != null) {
                BeautySeekView.this.E.a(BeautySeekView.this.G, 1, BeautySeekView.this.f75430i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            BeautySeekView.this.D.postDelayed(BeautySeekView.this.K, 300L);
            if (BeautySeekView.this.E != null) {
                BeautySeekView.this.E.a(BeautySeekView.this.G, 3, BeautySeekView.this.f75430i);
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {
        void a(String str, int i3, int i16);
    }

    public BeautySeekView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3) {
        int i16;
        if (this.f75427e == null) {
            return;
        }
        View view = this.f75429h;
        if (view != null) {
            if (i3 > this.H) {
                i16 = N;
            } else {
                i16 = M;
            }
            view.setBackgroundResource(i16);
        }
        if (i3 == 0) {
            this.f75431m = getResources().getDrawable(R.drawable.d9u);
        } else if (i3 <= 30) {
            this.f75431m = getResources().getDrawable(R.drawable.d9w);
        } else if (i3 <= 60) {
            this.f75431m = getResources().getDrawable(R.drawable.d9x);
        } else {
            this.f75431m = getResources().getDrawable(R.drawable.d9v);
        }
        this.f75427e.setThumb(this.f75431m);
    }

    private void k(Context context) {
        this.D = new Handler(Looper.getMainLooper());
        View inflate = View.inflate(context, R.layout.c9x, this);
        View findViewById = inflate.findViewById(R.id.m1_);
        this.f75429h = findViewById;
        findViewById.setBackgroundResource(R.drawable.he5);
        this.f75427e = (SeekBar) inflate.findViewById(R.id.gaj);
        this.f75426d = (TextView) inflate.findViewById(R.id.gai);
        this.f75428f = (TextView) inflate.findViewById(R.id.gak);
        this.f75431m = getResources().getDrawable(R.drawable.d9y);
        this.f75428f.setVisibility(4);
        SeekBar seekBar = this.f75427e;
        if (seekBar != null) {
            seekBar.setMax(100);
            this.f75427e.setOnSeekBarChangeListener(this.L);
            this.f75427e.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
        this.C = BaseAIOUtils.f(24.0f, getResources());
        if (e.e(0) == 1 && this.f75427e != null) {
            setBackgroundColor(-270080262);
            this.f75428f.setBackgroundColor(-16777216);
            this.f75427e.setBackgroundColor(-536871168);
            setBackgroundColor(536870656);
        }
    }

    private void n() {
        SeekBar seekBar = this.f75427e;
        if (seekBar == null) {
            return;
        }
        this.J = seekBar.getMeasuredWidth();
        int paddingLeft = this.f75427e.getPaddingLeft();
        int paddingRight = this.f75427e.getPaddingRight();
        int left = this.f75427e.getLeft();
        int i3 = left + paddingLeft + ((int) ((this.H / 100.0f) * ((this.J - paddingLeft) - paddingRight)));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f75429h.getLayoutParams();
        marginLayoutParams.leftMargin = i3;
        this.f75429h.setLayoutParams(marginLayoutParams);
        if (QLog.isDevelopLevel()) {
            QLog.i("BeautySeekView", 4, String.format("updateMarker, pl: %s, pr: %s, w: %s, ml: %s, m: %s, left: %s, flag: %s", Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight), Integer.valueOf(this.J), Integer.valueOf(left), Integer.valueOf(this.H), Integer.valueOf(i3), Boolean.valueOf(this.I)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i3) {
        String str;
        if (this.f75427e == null) {
            return;
        }
        if (this.H == 50) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3 - 50);
            sb5.append("%");
            str = sb5.toString();
        } else {
            str = i3 + "%";
        }
        this.f75428f.setText(str);
        int width = this.f75428f.getWidth();
        int width2 = (this.f75427e.getWidth() - this.f75427e.getPaddingLeft()) - this.f75427e.getPaddingRight();
        int paddingLeft = ((RelativeLayout.LayoutParams) this.f75427e.getLayoutParams()).leftMargin + this.f75427e.getPaddingLeft();
        float abs = (i3 * 1.0f) / Math.abs(this.f75427e.getMax());
        ((RelativeLayout.LayoutParams) this.f75428f.getLayoutParams()).leftMargin = ((int) (((width2 * abs) + ((0.5f - abs) * this.f75431m.getIntrinsicWidth())) - (width / 2.0f))) + paddingLeft;
        if (QLog.isColorLevel()) {
            QLog.w("BeautySeekView", 2, "updateTip, progress[" + i3 + "], seekBarLeft[" + paddingLeft + "], tipWidth[" + width + "], thumbWidth[" + this.C + "], seekWidth[" + width2 + "]");
        }
        this.f75428f.requestLayout();
    }

    public void l(String str, String str2, int i3, int i16) {
        this.G = str2;
        TextView textView = this.f75426d;
        if (textView != null) {
            textView.setText(str);
        }
        if (this.H != i16) {
            this.H = i16;
            this.I = true;
            n();
        }
        m(i3);
    }

    public void m(int i3) {
        SeekBar seekBar = this.f75427e;
        if (seekBar != null) {
            seekBar.setProgress(i3);
        }
        j(i3);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        SeekBar seekBar;
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.I && (seekBar = this.f75427e) != null && seekBar.getMeasuredWidth() != this.J) {
            this.I = false;
            n();
        }
    }

    public void setBeautySeekActionListener(c cVar) {
        this.E = cVar;
    }

    public void setMarginRight(int i3) {
        SeekBar seekBar = this.f75427e;
        if (seekBar != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) seekBar.getLayoutParams();
            if (QLog.isDevelopLevel()) {
                QLog.i("BeautySeekView", 4, "setMarginRight pre[" + marginLayoutParams.leftMargin + "], cur[" + i3 + "]");
            }
            marginLayoutParams.rightMargin = i3;
            this.f75427e.setLayoutParams(marginLayoutParams);
            this.I = true;
        }
    }

    public BeautySeekView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BeautySeekView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75426d = null;
        this.f75427e = null;
        this.f75429h = null;
        this.f75430i = 0;
        this.C = 0;
        this.E = null;
        this.F = false;
        this.H = 0;
        this.I = true;
        this.J = 0;
        this.K = new Runnable() { // from class: com.tencent.av.ui.beauty.BeautySeekView.2
            @Override // java.lang.Runnable
            public void run() {
                BeautySeekView.this.f75428f.setVisibility(4);
            }
        };
        this.L = new b();
        k(context);
    }
}
