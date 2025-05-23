package com.tencent.now.od.ui.game.meleegame.widget.scorebar.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.now.app.misc.ui.UIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zn3.c;
import zn3.d;
import zn3.e;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ScoreBar extends ConstraintLayout {
    private d C;
    private long D;
    private long E;
    private long F;
    private float G;
    private ViewTreeObserver.OnGlobalLayoutListener H;
    private c I;

    /* renamed from: d, reason: collision with root package name */
    private RoundCornerImageView f338588d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f338589e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f338590f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f338591h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f338592i;

    /* renamed from: m, reason: collision with root package name */
    private Logger f338593m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ScoreBar scoreBar = ScoreBar.this;
            scoreBar.M0(scoreBar.D, ScoreBar.this.E);
            ScoreBar.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements c {
        b() {
        }

        @Override // zn3.c
        public void a(float f16) {
            ScoreBar.this.f338593m.info("updateWidth>>>> " + f16);
            ScoreBar.this.N0(f16);
        }

        @Override // zn3.c
        public void b(long j3, long j16) {
            ScoreBar.this.f338593m.info("onUpdateProgress >>>> " + j3 + ", " + j16);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - ScoreBar.this.F > 100) {
                ScoreBar.this.F = elapsedRealtime;
                ScoreBar.this.f338590f.setText(String.valueOf(j3));
                ScoreBar.this.f338591h.setText(String.valueOf(j16));
            }
        }

        @Override // zn3.c
        public void onAnimationEnd() {
            ScoreBar.this.f338590f.setText(String.valueOf(ScoreBar.this.D));
            ScoreBar.this.f338591h.setText(String.valueOf(ScoreBar.this.E));
        }
    }

    public ScoreBar(Context context) {
        super(context);
        this.f338593m = LoggerFactory.getLogger("ScoreBar");
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0.0f;
        this.H = new a();
        this.I = new b();
        L0();
    }

    private boolean I0() {
        if (this.f338592i.getVisibility() != 0) {
            this.f338593m.error("Cursor invisible, do not update.");
            return false;
        }
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            return true;
        }
        this.f338593m.error("Invalid w/h, width: " + getMeasuredWidth() + ", height: " + getMeasuredHeight());
        return false;
    }

    private void J0(int i3, long j3, long j16) {
        float K0 = K0(j3);
        float K02 = K0(j16);
        e a16 = bo3.a.a(i3, j3, j16, K0, K02);
        this.f338593m.info("\u66f4\u65b0\u79ef\u5206\u6761\uff1a" + a16 + ", leftReserve: " + K0 + ", rightReserve: " + K02);
        this.C.b((float) this.f338588d.getWidth(), a16.f452820c);
        this.C.c(j3, j16);
        this.C.d();
    }

    private float K0(long j3) {
        return (this.G * String.valueOf(j3).length()) + UIUtil.b(getContext(), 34.0f);
    }

    private void L0() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dzw, this);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.f80224aw);
        this.f338588d = roundCornerImageView;
        vn3.a.b(roundCornerImageView, pn3.a.f426507d);
        RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) inflate.findViewById(R.id.f80234ax);
        this.f338589e = roundCornerImageView2;
        vn3.a.b(roundCornerImageView2, pn3.a.f426509e);
        vn3.a.b((ImageView) inflate.findViewById(R.id.f80214av), pn3.a.f426511f);
        this.f338592i = (ImageView) inflate.findViewById(R.id.f80244ay);
        this.f338590f = (TextView) inflate.findViewById(R.id.f80294b3);
        this.f338591h = (TextView) inflate.findViewById(R.id.f80304b4);
        com.tencent.od.common.util.a.a(this.f338590f);
        com.tencent.od.common.util.a.a(this.f338591h);
        this.G = bo3.a.b(getContext(), 13);
        this.C = new d(this.I);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.H);
        getViewTreeObserver().addOnGlobalLayoutListener(this.H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(float f16) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f338588d.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) f16;
        this.f338588d.setLayoutParams(layoutParams);
    }

    public void H0() {
        this.f338592i.setVisibility(0);
        M0(this.D, this.E);
    }

    public void M0(long j3, long j16) {
        this.D = j3;
        this.E = j16;
        if (I0()) {
            J0(getMeasuredWidth(), j3, this.E);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.C.a();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.H);
    }

    public ScoreBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338593m = LoggerFactory.getLogger("ScoreBar");
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0.0f;
        this.H = new a();
        this.I = new b();
        L0();
    }

    public ScoreBar(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338593m = LoggerFactory.getLogger("ScoreBar");
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0.0f;
        this.H = new a();
        this.I = new b();
        L0();
    }
}
