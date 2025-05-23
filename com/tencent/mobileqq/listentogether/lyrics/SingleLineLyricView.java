package com.tencent.mobileqq.listentogether.lyrics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.lyric.data.f;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SingleLineLyricView extends TextView implements c, Handler.Callback {
    private int C;
    protected Handler D;
    protected int E;
    private volatile boolean F;
    private int G;
    private int H;
    Paint.Align I;
    private int J;
    private int K;
    private boolean L;
    private int M;
    private SparseArray<f> N;
    private WeakReference<e> P;

    /* renamed from: d, reason: collision with root package name */
    protected volatile long f241043d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f241044e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f241045f;

    /* renamed from: h, reason: collision with root package name */
    private f f241046h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.lyric.data.b f241047i;

    /* renamed from: m, reason: collision with root package name */
    private String f241048m;

    public SingleLineLyricView(Context context) {
        super(context);
        this.f241044e = 0;
        this.f241045f = 0;
        this.C = 1;
        this.F = true;
        this.I = Paint.Align.CENTER;
        this.N = new SparseArray<>(4);
        h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0045, code lost:
    
        if (r2 < 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(com.tencent.mobileqq.lyric.data.d dVar) {
        boolean z16;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f241043d;
        long j3 = dVar.f243149b;
        long j16 = dVar.f243150c;
        int i3 = 0;
        if (elapsedRealtime > j3 + j16) {
            return false;
        }
        int i16 = dVar.d().get(0).f243162d;
        int measuredWidth = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        if (i16 > measuredWidth) {
            int i17 = this.K;
            int i18 = ((int) ((((float) (elapsedRealtime - j3)) / ((float) j16)) * i16)) - ((int) (i17 + (measuredWidth * 0.5f)));
            int i19 = i17 + i18;
            z16 = true;
            if (i18 >= 0) {
                if (i18 > 0) {
                    int i26 = i16 - measuredWidth;
                    if (i19 > i26) {
                        i3 = i26;
                    }
                    i3 = i19;
                } else {
                    i3 = i17;
                }
            }
        } else {
            z16 = false;
        }
        this.K = i3;
        return z16;
    }

    private void c() {
        this.D.removeMessages(0);
        this.D.sendEmptyMessage(0);
    }

    private int d() {
        return (int) (((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - ((int) (r0.descent - r0.ascent))) * 0.5f) - getPaint().getFontMetrics().ascent);
    }

    private int e(f fVar) {
        Paint.Align align = this.I;
        if (align == Paint.Align.LEFT) {
            return 0;
        }
        if (align == Paint.Align.RIGHT) {
            return fVar.f243160b * 2;
        }
        return fVar.f243160b;
    }

    private boolean g() {
        ArrayList<com.tencent.mobileqq.lyric.data.d> arrayList;
        com.tencent.mobileqq.lyric.data.b bVar = this.f241047i;
        return bVar == null || (arrayList = bVar.f243142b) == null || arrayList.isEmpty() || this.C != 2;
    }

    private void h() {
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
        }
        this.G = BaseAIOUtils.f(1.0f, getResources());
        this.D = new Handler(Looper.getMainLooper(), this);
    }

    private void i() {
        this.N.clear();
        TextPaint paint = getPaint();
        for (int i3 = 1; i3 <= 4; i3++) {
            int measureText = (int) (paint.measureText(r4) + 0.5d);
            this.N.put(i3, new f(f(i3), 0, 0, measureText, measureText, null));
        }
    }

    private void j(Canvas canvas, f fVar) {
        this.f241046h = fVar;
        canvas.save();
        canvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()), getPaddingTop() + ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom())));
        int paddingLeft = (getPaddingLeft() - this.K) + e(fVar);
        if (this.J == 0) {
            this.J = d();
        }
        int paddingTop = this.J + getPaddingTop();
        TextPaint paint = getPaint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(this.G);
        int currentTextColor = getCurrentTextColor();
        paint.setColor(this.H);
        float f16 = paddingLeft;
        float f17 = paddingTop;
        canvas.drawText(fVar.f243159a, f16, f17, paint);
        paint.setColor(currentTextColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(fVar.f243159a, f16, f17, paint);
        canvas.restore();
        setContentDescription(fVar.f243159a);
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public String a() {
        return this.f241048m;
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public int getState() {
        return this.C;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        int paddingLeft;
        int i3;
        int i16 = this.C;
        if (i16 != 2 && this.N.get(i16) != null) {
            paddingLeft = this.N.get(this.C).f243162d + getPaddingLeft();
            i3 = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft() + getPaddingRight();
            i3 = this.M;
        }
        return paddingLeft + i3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            this.D.removeMessages(0);
            if (!this.F && !g()) {
                this.D.sendEmptyMessageDelayed(0, this.L ? 200L : 500L);
            }
            if (!g() || this.f241046h == null) {
                invalidate();
            }
        } else if (i3 == 1) {
            this.D.removeMessages(1);
            requestLayout();
        } else if (i3 == 2) {
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE", new Object[0]));
            }
            this.D.removeMessages(2);
            WeakReference<e> weakReference = this.P;
            e eVar = weakReference == null ? null : weakReference.get();
            if (eVar != null) {
                eVar.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public boolean isPlaying() {
        return !this.F;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.E != getMeasuredWidth()) {
            this.E = getMeasuredWidth();
            this.D.removeMessages(2);
            this.D.sendEmptyMessageDelayed(2, 300L);
            if (this.f241047i != null) {
                this.f241047i.f(getPaint(), getPaint(), (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft(), true, false);
            }
            this.J = 0;
            this.f241046h = null;
            this.K = 0;
            c();
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.Lyric", 2, String.format("onLayout w=%d", Integer.valueOf(getMeasuredWidth())));
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(getSuggestedMinimumWidth(), View.getDefaultSize(getSuggestedMinimumHeight(), i16));
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public synchronized void pause() {
        this.F = true;
        c();
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public void seek(int i3) {
        this.f241043d = SystemClock.elapsedRealtime() - i3;
        c();
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public void setAlign(Paint.Align align) {
        if (this.I != align) {
            this.I = align;
            c();
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public void setLineMaxWidth(int i3) {
        this.M = i3;
        requestLayout();
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public void setSongId(String str) {
        this.f241048m = str;
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public void setStrokeColor(int i3) {
        this.H = i3;
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public void setStrokeWidth(int i3) {
        this.G = i3;
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        getPaint().setColor(i3);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f16) {
        super.setTextSize(i3, f16);
        i();
        this.E = -1;
        this.D.sendEmptyMessage(1);
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public synchronized void start() {
        this.F = false;
        c();
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public synchronized void stop() {
        this.F = true;
        c();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        f fVar;
        this.L = false;
        if (g()) {
            fVar = this.N.get(this.C);
            this.K = 0;
        } else if (this.F) {
            fVar = this.f241046h;
        } else {
            int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f241043d);
            this.f241044e = elapsedRealtime;
            int c16 = this.f241047i.c(elapsedRealtime);
            ArrayList<com.tencent.mobileqq.lyric.data.d> arrayList = this.f241047i.f243142b;
            int size = arrayList.size();
            if (c16 < 0) {
                c16 = 0;
            }
            if (c16 >= size) {
                c16 = size - 1;
            }
            this.f241045f = c16;
            com.tencent.mobileqq.lyric.data.d dVar = arrayList.get(c16);
            if (dVar.d().isEmpty()) {
                return;
            }
            f fVar2 = dVar.d().get(0);
            this.L = b(dVar);
            fVar = fVar2;
        }
        if (fVar != null) {
            j(canvas, fVar);
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public void setLyric(com.tencent.mobileqq.lyric.data.b bVar, int i3) {
        if (bVar != null) {
            com.tencent.mobileqq.lyric.data.b bVar2 = new com.tencent.mobileqq.lyric.data.b(2, 0, null);
            bVar2.a(bVar);
            this.f241047i = bVar2;
        } else {
            this.f241047i = null;
        }
        this.C = i3;
        this.E = -1;
        this.f241046h = null;
        this.D.sendEmptyMessage(1);
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.c
    public void setOnSizeChangeListener(e eVar) {
        if (eVar == null) {
            this.P = null;
        } else {
            this.P = new WeakReference<>(eVar);
        }
    }

    public SingleLineLyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f241044e = 0;
        this.f241045f = 0;
        this.C = 1;
        this.F = true;
        this.I = Paint.Align.CENTER;
        this.N = new SparseArray<>(4);
        h();
    }

    private String f(int i3) {
        if (i3 == 1) {
            return HardCodeUtil.qqStr(R.string.tkv);
        }
        if (i3 == 2) {
            return "";
        }
        if (i3 == 3) {
            return HardCodeUtil.qqStr(R.string.tku);
        }
        if (i3 != 4) {
            return HardCodeUtil.qqStr(R.string.tks);
        }
        return HardCodeUtil.qqStr(R.string.tkt);
    }

    public SingleLineLyricView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f241044e = 0;
        this.f241045f = 0;
        this.C = 1;
        this.F = true;
        this.I = Paint.Align.CENTER;
        this.N = new SparseArray<>(4);
        h();
    }
}
