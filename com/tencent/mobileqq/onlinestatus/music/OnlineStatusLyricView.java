package com.tencent.mobileqq.onlinestatus.music;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.aio.title.ad;
import com.tencent.mobileqq.lyric.data.d;
import com.tencent.mobileqq.lyric.data.f;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.e;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusLyricView extends TextView implements t.a, Handler.Callback, e.a, ad {
    public String C;
    private a D;
    private volatile boolean E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    private f J;
    private Paint.Align K;
    private int L;
    private f M;
    private int N;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private long V;

    /* renamed from: d, reason: collision with root package name */
    private t f256050d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f256051e;

    /* renamed from: f, reason: collision with root package name */
    protected Handler f256052f;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.lyric.data.b f256053h;

    /* renamed from: i, reason: collision with root package name */
    public c f256054i;

    /* renamed from: m, reason: collision with root package name */
    public String f256055m;

    public OnlineStatusLyricView(Context context) {
        super(context);
        this.E = false;
        this.K = Paint.Align.CENTER;
        this.M = null;
        this.N = 0;
        this.P = 0;
        this.Q = true;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        if (r2 < 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(d dVar) {
        boolean z16;
        long N = (int) (this.V - (this.f256054i.N() - NetConnInfoCenter.getServerTimeMillis()));
        long j3 = dVar.f243149b;
        long j16 = dVar.f243150c;
        int i3 = 0;
        if (N > j3 + j16) {
            return false;
        }
        int n3 = n(dVar.d().get(0));
        int measuredWidth = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        if (n3 > measuredWidth) {
            int i16 = this.I;
            int i17 = ((int) ((((float) (N - j3)) / ((float) j16)) * n3)) - ((int) (i16 + (measuredWidth * 0.5f)));
            int i18 = i16 + i17;
            z16 = true;
            if (i17 >= 0) {
                if (i17 > 0) {
                    int i19 = n3 - measuredWidth;
                    if (i18 > i19) {
                        i3 = i19;
                    }
                    i3 = i18;
                } else {
                    i3 = i16;
                }
            }
        } else {
            z16 = false;
        }
        this.I = i3;
        return z16;
    }

    private boolean c() {
        if (!this.U) {
            return true;
        }
        c cVar = this.f256054i;
        if (cVar == null) {
            return false;
        }
        String V = cVar.V();
        if (TextUtils.isEmpty(V)) {
            return false;
        }
        if (TextUtils.equals(V, this.f256055m) && !p()) {
            return true;
        }
        return false;
    }

    private void f() {
        this.f256051e = false;
        this.f256052f.removeMessages(0);
        this.f256052f.sendEmptyMessage(0);
    }

    private int i() {
        return (int) (((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - ((int) (r0.descent - r0.ascent))) * 0.5f) - getPaint().getFontMetrics().ascent);
    }

    private d j(int i3) {
        long j3;
        long N;
        if (i3 > 0) {
            j3 = this.V;
            N = i3;
        } else {
            j3 = this.V;
            N = this.f256054i.N() - NetConnInfoCenter.getServerTimeMillis();
        }
        int c16 = this.f256053h.c((int) (j3 - N));
        ArrayList<d> arrayList = this.f256053h.f243142b;
        int size = arrayList.size();
        if (c16 < 0) {
            c16 = 0;
        }
        if (c16 >= size) {
            c16 = size - 1;
        }
        d dVar = arrayList.get(c16);
        if (dVar.d().isEmpty()) {
            if (this.G != 0) {
                h();
            }
            QLog.d("OnlineStatusLyricView", 1, "getUILyricLineList empty");
            return null;
        }
        return dVar;
    }

    private int k(f fVar) {
        Paint.Align align = this.K;
        if (align == Paint.Align.LEFT) {
            return 0;
        }
        if (align == Paint.Align.RIGHT) {
            return m(fVar) * 2;
        }
        return m(fVar);
    }

    private e l() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return (e) ((IOnlineStatusManagerService) peekAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(e.class);
    }

    private int m(f fVar) {
        x(fVar);
        return this.N;
    }

    private int n(f fVar) {
        x(fVar);
        return this.P;
    }

    @SuppressLint({"WrongCall"})
    private void r(Canvas canvas) {
        f fVar;
        this.F = false;
        if (o()) {
            if (this.S) {
                super.onDraw(canvas);
                return;
            }
            if (this.J == null || !getText().toString().equals(this.J.f243159a)) {
                this.J = g(getText().toString());
            }
            fVar = this.J;
            this.I = 0;
        } else if (this.E) {
            fVar = this.J;
            if (fVar == null) {
                d j3 = j(this.f256054i.a0());
                if (j3 != null && !j3.d().isEmpty()) {
                    fVar = j3.d().get(0);
                } else {
                    return;
                }
            }
        } else {
            d j16 = j(-1);
            if (j16 != null && !j16.d().isEmpty()) {
                f fVar2 = j16.d().get(0);
                this.F = b(j16);
                fVar = fVar2;
            } else {
                return;
            }
        }
        if (fVar != null) {
            s(canvas, fVar);
        }
    }

    private void s(Canvas canvas, f fVar) {
        int measureText;
        if (TextUtils.isEmpty(getText().toString())) {
            return;
        }
        this.J = fVar;
        canvas.save();
        TextPaint paint = getPaint();
        canvas.clipRect(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
        int paddingLeft = getPaddingLeft() + k(fVar);
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables[0] != null) {
            int paddingTop = getPaddingTop() + ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - compoundDrawables[0].getBounds().height()) / 2);
            Rect rect = new Rect(0, 0, compoundDrawables[0].getBounds().width(), compoundDrawables[0].getBounds().height());
            rect.offset(paddingLeft, paddingTop);
            compoundDrawables[0].setBounds(rect);
            compoundDrawables[0].draw(canvas);
        }
        if (compoundDrawables[2] != null) {
            int paddingTop2 = getPaddingTop() + ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - compoundDrawables[2].getBounds().height()) / 2);
            Rect rect2 = new Rect(0, 0, compoundDrawables[2].getBounds().width(), compoundDrawables[2].getBounds().height());
            int compoundPaddingLeft = paddingLeft + getCompoundPaddingLeft();
            if (fVar != null) {
                measureText = compoundPaddingLeft + ((int) (paint.measureText(fVar.f243159a) + 0.5d));
            } else {
                measureText = (int) (compoundPaddingLeft + paint.measureText(getText().toString()) + 0.5d);
            }
            rect2.offset(Math.min(measureText + ViewUtils.dip2px(2.0f), getMeasuredWidth() - getCompoundPaddingRight()), paddingTop2);
            compoundDrawables[2].setBounds(rect2);
            compoundDrawables[2].draw(canvas);
        }
        canvas.restore();
        canvas.save();
        canvas.clipRect(getCompoundPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getCompoundPaddingRight(), getMeasuredHeight() - getPaddingBottom());
        int k3 = (k(fVar) + getCompoundPaddingLeft()) - this.I;
        if (this.H == 0) {
            this.H = i();
        }
        int paddingTop3 = this.H + getPaddingTop();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getCurrentTextColor());
        if (fVar != null) {
            canvas.drawText(fVar.f243159a, k3, paddingTop3, paint);
        }
        canvas.restore();
    }

    private void t() {
        e l3;
        if (!this.T && (l3 = l()) != null) {
            l3.t(this);
            this.T = true;
        }
    }

    private void v() {
        Handler handler = this.f256052f;
        if (handler != null) {
            handler.removeMessages(0);
        }
        a aVar = this.D;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void w() {
        e l3;
        if (this.T && (l3 = l()) != null) {
            l3.q(this);
            this.T = false;
        }
    }

    private void x(f fVar) {
        int i3;
        int i16;
        if (this.M == fVar) {
            return;
        }
        this.M = fVar;
        if (fVar == null) {
            return;
        }
        int measureText = (int) (getPaint().measureText(fVar.f243159a) + 0.5d);
        Drawable[] compoundDrawables = getCompoundDrawables();
        int i17 = 0;
        Drawable drawable = compoundDrawables[0];
        if (drawable != null) {
            i3 = drawable.getBounds().width() + getCompoundDrawablePadding();
        } else {
            i3 = 0;
        }
        if (QQTheme.isNowSimpleUI() && compoundDrawables[0] == null && compoundDrawables[2] != null) {
            i3 = getCompoundPaddingRight() + ViewUtils.dip2px(4.0f);
        }
        if (!this.R) {
            Drawable drawable2 = compoundDrawables[2];
            if (drawable2 == null) {
                i16 = 0;
            } else {
                i16 = drawable2.getBounds().width() + getCompoundDrawablePadding();
            }
        } else {
            i16 = i3;
        }
        if (!QQTheme.isNowSimpleUI() || !this.Q) {
            i17 = Math.max((((getMeasuredWidth() - measureText) - i3) - i16) / 2, 0);
        }
        this.N = i17;
        this.P = i3 + measureText;
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.e.a
    public void a(String str) {
        Handler handler;
        c cVar;
        if ((TextUtils.equals(str, this.f256055m) || ((cVar = this.f256054i) != null && TextUtils.equals(str, cVar.V()))) && (handler = this.f256052f) != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public boolean d() {
        if (this.f256053h != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        t tVar = this.f256050d;
        if (tVar != null) {
            tVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public void e() {
        this.f256051e = true;
        this.f256052f.removeCallbacksAndMessages(null);
        w();
    }

    public f g(String str) {
        return new f(str, 0, 0, 0, 0, null);
    }

    public void h() {
        ArrayList<d> arrayList = this.f256053h.f243142b;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.f243151d.clear();
                next.f243151d.add(g(next.f243148a));
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        int i16 = message.what;
        if (i16 != 0) {
            if (i16 == 1) {
                this.f256052f.removeMessages(1);
                requestLayout();
            }
        } else {
            this.f256052f.removeMessages(0);
            if (!this.E && !this.f256051e) {
                if (this.F) {
                    i3 = 200;
                } else {
                    i3 = 500;
                }
                this.f256052f.sendEmptyMessageDelayed(0, i3);
            }
            invalidate();
        }
        return false;
    }

    public boolean o() {
        boolean z16;
        com.tencent.mobileqq.lyric.data.b bVar;
        ArrayList<d> arrayList;
        ArrayList<d> arrayList2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        c cVar = this.f256054i;
        com.tencent.mobileqq.lyric.data.b bVar2 = null;
        if (cVar != null && !TextUtils.isEmpty(cVar.Z())) {
            if (!TextUtils.equals(this.f256054i.V(), this.f256055m)) {
                this.f256053h = null;
                this.f256055m = this.f256054i.V();
                if (QLog.isDevelopLevel()) {
                    QLog.d("OnlineStatusLyricView", 1, "mNTOnlineStatusData songId has changed");
                }
            } else if (System.currentTimeMillis() > this.f256054i.N()) {
                this.f256053h = null;
                v();
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusLyricView", 2, "mNTOnlineStatusData song is deprecated");
                }
                return true;
            }
            if (this.f256054i.a0() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.E = z16;
            com.tencent.mobileqq.lyric.data.b bVar3 = this.f256053h;
            if (bVar3 == null || (arrayList2 = bVar3.f243142b) == null || arrayList2.isEmpty()) {
                e eVar = (e) ((IOnlineStatusManagerService) peekAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(e.class);
                if (eVar != null) {
                    bVar2 = eVar.j(this.f256054i.V());
                }
                this.f256053h = bVar2;
                if (bVar2 != null && bVar2.f243142b != null) {
                    bVar2.k();
                    this.f256052f.sendEmptyMessage(1);
                    long M = this.f256054i.M();
                    this.V = M;
                    if (M <= 0 && (bVar = this.f256053h) != null && (arrayList = bVar.f243142b) != null && !arrayList.isEmpty()) {
                        ArrayList<d> arrayList3 = this.f256053h.f243142b;
                        this.V = arrayList3.get(arrayList3.size() - 1).f243149b + 30000;
                    }
                    a aVar = this.D;
                    if (aVar != null) {
                        aVar.b();
                    }
                    QLog.d("OnlineStatusLyricView", 1, "mLyric reset");
                }
            }
            return p();
        }
        this.f256053h = null;
        v();
        return true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        t tVar = this.f256050d;
        if (tVar != null) {
            tVar.b(canvas);
        } else {
            r(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (getMeasuredWidth() != this.G) {
            this.G = getMeasuredWidth();
            if (this.f256053h != null) {
                h();
            }
            u();
        }
        f();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        int compoundPaddingRight;
        int min;
        Drawable[] compoundDrawables = getCompoundDrawables();
        int i17 = 0;
        if (d() && c()) {
            min = this.L;
        } else {
            if (this.S) {
                super.onMeasure(i3, i16);
                return;
            }
            getPaint().setTextSize(getTextSize());
            int measureText = (int) (r6.measureText(getText().toString()) + 0.5d);
            int i18 = 2;
            if (compoundDrawables[0] != null && compoundDrawables[2] == null) {
                int compoundPaddingLeft = getCompoundPaddingLeft();
                if (!this.R) {
                    i18 = 1;
                }
                compoundPaddingRight = compoundPaddingLeft * i18;
            } else if (compoundDrawables[2] != null) {
                compoundPaddingRight = (ViewUtils.dip2px(4.0f) + getCompoundPaddingRight()) * 2;
            } else {
                measureText += getCompoundPaddingLeft();
                compoundPaddingRight = getCompoundPaddingRight();
            }
            min = Math.min(measureText + compoundPaddingRight, this.L);
        }
        Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
        int i19 = fontMetricsInt.descent - fontMetricsInt.ascent;
        Drawable drawable = compoundDrawables[0];
        if (drawable != null) {
            i17 = drawable.getBounds().height();
        }
        setMeasuredDimension(min, Math.max(i17, i19) + getPaddingTop() + getPaddingBottom());
    }

    public boolean p() {
        ArrayList<d> arrayList;
        com.tencent.mobileqq.lyric.data.b bVar = this.f256053h;
        if (bVar != null && (arrayList = bVar.f243142b) != null && !arrayList.isEmpty()) {
            return false;
        }
        return true;
    }

    public void q() {
        this.L = Utils.n(200.0f, getResources());
        this.f256052f = new Handler(Looper.getMainLooper(), this);
    }

    public void setCheckLyricLegalOnMeasure(boolean z16) {
        this.U = z16;
    }

    @Override // com.tencent.mobileqq.aio.title.ad
    public void setFriendSession(Object obj, String str) {
        if (obj instanceof c) {
            this.f256054i = (c) obj;
            this.C = str;
            t();
        }
        Object[] objArr = new Object[2];
        boolean z16 = false;
        objArr[0] = "setFriendSession, onlineStatusInfoIsNull:";
        if (obj == null) {
            z16 = true;
        }
        objArr[1] = Boolean.valueOf(z16);
        QLog.d("OnlineStatusLyricView", 1, objArr);
    }

    public void setIgnoreOffsetXWhenSimpleUI(boolean z16) {
        this.Q = z16;
    }

    public void setLyricStateListener(a aVar) {
        this.D = aVar;
    }

    public void setMaxTextWidth(int i3) {
        this.L = i3;
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(t tVar) {
        t tVar2 = this.f256050d;
        if (tVar2 != null) {
            tVar2.c(null);
        }
        this.f256050d = tVar;
        if (tVar != null) {
            tVar.c(this);
        }
        invalidate();
    }

    public void setOnlyLyricsAlignCenter(boolean z16) {
        this.R = z16;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        String charSequence2 = getText().toString();
        super.setText(charSequence, bufferType);
        if (charSequence == null || !charSequence2.equals(charSequence.toString())) {
            String str = this.C;
            if (str != null && !str.equals(charSequence)) {
                QLog.d("OnlineStatusLyricView", 1, "setText, mSongStatusName:", this.C);
                this.C = null;
                this.f256054i = null;
                this.f256053h = null;
            }
            Handler handler = this.f256052f;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        }
    }

    public void setTextAlign(Paint.Align align) {
        this.K = align;
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        getPaint().setColor(i3);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f16) {
        super.setTextSize(i3, f16);
        this.f256052f.sendEmptyMessage(1);
    }

    public void setUseDefaultTextViewWhenNoLyrics(boolean z16) {
        this.S = z16;
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superDrawMosaic(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superOnDrawMosaic(Canvas canvas) {
        r(canvas);
    }

    public void u() {
        this.H = 0;
        this.J = null;
        this.I = 0;
    }

    public OnlineStatusLyricView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = false;
        this.K = Paint.Align.CENTER;
        this.M = null;
        this.N = 0;
        this.P = 0;
        this.Q = true;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        q();
    }

    public OnlineStatusLyricView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = false;
        this.K = Paint.Align.CENTER;
        this.M = null;
        this.N = 0;
        this.P = 0;
        this.Q = true;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        q();
    }
}
