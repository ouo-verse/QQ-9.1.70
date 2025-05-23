package com.tencent.mobileqq.wink.editor.music.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.music.lyric.i;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkMusicWaveView extends View implements i.c {
    private float C;
    private float D;
    private float E;
    private Paint F;
    private boolean G;
    private boolean H;
    private i.b I;
    private a J;
    private String K;
    private boolean L;
    private boolean M;
    private int N;
    private int P;
    private boolean Q;
    private boolean R;

    /* renamed from: d, reason: collision with root package name */
    private i f320846d;

    /* renamed from: e, reason: collision with root package name */
    private float f320847e;

    /* renamed from: f, reason: collision with root package name */
    private float f320848f;

    /* renamed from: h, reason: collision with root package name */
    private int f320849h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f320850i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f320851m;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void onIndicatorDragged(int i3);
    }

    public WinkMusicWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 0.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = new Paint();
        this.G = false;
        this.H = false;
        this.L = true;
        this.M = false;
        this.N = 0;
        this.P = 0;
        this.Q = true;
        this.R = false;
        this.f320849h = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void d() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private void n(MotionEvent motionEvent) {
        if (this.f320850i) {
            this.f320846d.s(motionEvent);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.i.c
    public Context a() {
        return getContext();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.i.c
    public Context b() {
        return getContext();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.i.c
    public void c() {
        invalidate();
    }

    public int e(int i3) {
        float f16;
        i iVar = this.f320846d;
        if (iVar != null) {
            int l3 = iVar.l();
            this.N = l3;
            if (l3 <= this.f320846d.p() - this.f320846d.k() && this.N >= this.f320846d.k()) {
                f16 = ((i3 * 1.0f) / (this.f320846d.p() - (this.f320846d.k() * 2))) * (this.N - this.f320846d.k());
                return (int) f16;
            }
        }
        f16 = 0.0f;
        return (int) f16;
    }

    public void f(String str, String str2, int i3, int i16, boolean z16, int i17, int i18, boolean z17) {
        i iVar;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.equals(this.K) && !z17) {
            return;
        }
        this.K = str2;
        i iVar2 = new i(this, str, str2, i3, i16, ViewUtils.dip2px(18.0f), z16, i17, i18);
        this.f320846d = iVar2;
        iVar2.w(this.R);
        this.F.setAntiAlias(true);
        this.G = true;
        if (!z16 && (iVar = this.f320846d) != null) {
            this.N = iVar.l();
            this.P = this.f320846d.m();
        }
        requestLayout();
    }

    public void g(String str, String str2, int i3, int i16, boolean z16, int i17, int i18, boolean z17, boolean z18) {
        this.Q = z17;
        f(str, str2, i3, i16, z16, i17, i18, z18);
    }

    public boolean h() {
        return this.M;
    }

    boolean i() {
        return this.f320851m;
    }

    public boolean j() {
        return this.L;
    }

    void k() {
        this.f320851m = true;
    }

    void l() {
        this.f320851m = false;
    }

    public void m(int i3) {
        i iVar = this.f320846d;
        if (iVar != null) {
            iVar.t(i3);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i iVar = this.f320846d;
        if (iVar == null) {
            return;
        }
        iVar.i(canvas, this.L);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f320846d == null) {
            setMeasuredDimension(0, 0);
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i3), this.f320846d.o());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i iVar;
        if (!isEnabled() || this.f320846d == null || !j()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.M = false;
                        if (i()) {
                            l();
                            n(motionEvent);
                            setPressed(false);
                        }
                        invalidate();
                    }
                } else {
                    i iVar2 = this.f320846d;
                    if (iVar2 != null) {
                        int l3 = iVar2.l();
                        this.N = l3;
                        if (this.M && (iVar = this.f320846d) != null && l3 >= iVar.k() && motionEvent.getX() >= this.f320846d.k() && motionEvent.getX() <= this.f320846d.p()) {
                            int x16 = (int) motionEvent.getX();
                            this.N = x16;
                            this.f320846d.v(x16);
                            this.f320846d.y(this.N);
                            invalidate();
                        }
                    }
                    if (i()) {
                        n(motionEvent);
                    } else if (Math.abs(motionEvent.getX() - this.f320847e) > this.f320849h) {
                        setPressed(true);
                        invalidate();
                        k();
                        n(motionEvent);
                        d();
                    }
                }
            } else if (this.M) {
                this.M = false;
                a aVar = this.J;
                if (aVar != null) {
                    aVar.onIndicatorDragged(this.f320846d.l());
                }
            } else {
                if (i()) {
                    n(motionEvent);
                    l();
                    setPressed(false);
                    this.H = true;
                } else {
                    k();
                    n(motionEvent);
                    l();
                }
                this.M = false;
                invalidate();
            }
        } else {
            this.f320847e = motionEvent.getX();
            this.f320848f = motionEvent.getY();
            i iVar3 = this.f320846d;
            if (iVar3 != null) {
                int l16 = iVar3.l();
                this.N = l16;
                if (this.Q && l16 >= this.f320846d.k()) {
                    float f16 = this.f320847e;
                    int i3 = this.N;
                    int i16 = this.P;
                    if (f16 >= (i3 - (i16 / 2)) - 70 && f16 <= i3 + (i16 / 2) + 70) {
                        this.M = true;
                    }
                }
                this.f320850i = this.f320846d.q(this.f320847e, this.f320848f);
            }
            if (!this.f320850i) {
                return super.onTouchEvent(motionEvent);
            }
            setPressed(true);
            invalidate();
            k();
            n(motionEvent);
            d();
        }
        return this.f320850i;
    }

    public void setCurrentPosition(int i3, int i16) {
        i iVar = this.f320846d;
        if (iVar != null) {
            iVar.u(i3, i16);
        }
    }

    public void setDragIndicatorListener(a aVar) {
        this.J = aVar;
    }

    public void setEnableTrimMusic(boolean z16) {
        this.L = z16;
    }

    public void setIndicatorIndex(int i3) {
        if (this.f320846d != null && r0.j() - this.f320846d.n() > 0.01d) {
            this.f320846d.v((int) (this.f320846d.k() + ((((i3 - this.f320846d.n()) * 1.0f) / (this.f320846d.j() - this.f320846d.n())) * (this.f320846d.p() - (this.f320846d.k() * 2)))));
        }
    }

    public void setIndicatorIndexByVideo(int i3, int i16) {
        if (this.f320846d != null && r0.j() - this.f320846d.n() > 0.01d) {
            int k3 = (int) (this.f320846d.k() + (((i3 * 1.0f) / i16) * (this.f320846d.p() - (this.f320846d.k() * 2))));
            this.f320846d.v(k3);
            this.f320846d.y(k3);
        }
    }

    public void setIsPinjieWithOneMusic(boolean z16) {
        this.R = z16;
    }

    public void setOnMusicMoveListener(i.b bVar) {
        this.I = bVar;
        i iVar = this.f320846d;
        if (iVar != null) {
            iVar.x(bVar);
        }
    }
}
