package com.tencent.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewInternalSingleLine extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    protected volatile boolean f147254h1;

    public LyricViewInternalSingleLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    private void E(int i3, int i16) {
        int finalX;
        if (this.f147254h1 && (finalX = i3 - this.f147174a0.getFinalX()) != 0) {
            Scroller scroller = this.f147174a0;
            scroller.startScroll(scroller.getFinalX(), this.f147174a0.getFinalY(), finalX, 0, i16);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f147174a0.computeScrollOffset() && this.f147254h1) {
            scrollTo(this.f147174a0.getCurrX(), this.f147174a0.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void e(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.f147201o0 != i3) {
            this.f147254h1 = false;
            scrollTo(0, 0);
            this.f147174a0.setFinalX(0);
        }
        super.e(i3, i16);
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas, i3);
            return;
        }
        if (this.f147205s0) {
            return;
        }
        ArrayList<com.tencent.lyric.data.e> arrayList = this.U.f147056b;
        int size = arrayList.size();
        int i16 = this.f147201o0;
        int i17 = 0;
        if (i16 < 0) {
            i16 = 0;
        }
        if (i16 >= size) {
            i16 = size - 1;
        }
        if (!arrayList.isEmpty()) {
            int k3 = i3 + k();
            int i18 = this.H;
            int size2 = arrayList.size() - 1;
            if (this.f147195j0) {
                i17 = this.f147199m0;
                size2 = this.f147200n0;
            }
            if (i16 >= i17 && i16 <= size2) {
                com.tencent.lyric.data.e eVar = arrayList.get(i16);
                if (this.A0 && this.U.f147055a == 2 && !this.M0) {
                    u(eVar, canvas, k3, i18);
                    return;
                }
                if (this.U.f147055a == 1) {
                    int measureText = (int) this.M.measureText(eVar.f147070a);
                    if (measureText > this.f147184e0 + (k() >> 1)) {
                        if (!this.f147254h1) {
                            this.f147254h1 = true;
                            E(measureText - this.f147184e0, (int) eVar.f147072c);
                        }
                    } else {
                        int i19 = this.f147184e0;
                        if (measureText > i19) {
                            k3 -= (measureText - i19) >> 1;
                        }
                    }
                }
                int i26 = k3;
                if (n()) {
                    x(eVar, canvas, i26, i18, this.M, this.R, true);
                } else {
                    r(eVar, canvas, i26, i18, this.M);
                }
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Log.d("LyricViewInternalSL", "onMeasure -> parentWidth:" + measuredWidth + ", parentHeight:" + measuredHeight);
        if (this.f147205s0) {
            setMeasuredDimension(measuredWidth, measuredHeight);
            return;
        }
        if (this.f147176b0 == 70) {
            if (this.f147208v0 == measuredWidth && this.f147209w0) {
                setMeasuredDimension(measuredWidth, this.f147181d0 + measuredHeight);
            } else {
                this.f147208v0 = measuredWidth;
                int k3 = measuredWidth - (k() << 1);
                this.f147184e0 = k3;
                com.tencent.lyric.data.a aVar = this.U;
                if (aVar.f147055a == 1) {
                    aVar.i(this.N, this.M, k3, true);
                } else {
                    aVar.h(this.N, this.M, k3);
                }
                com.tencent.lyric.data.a aVar2 = this.U;
                if (aVar2.f147055a == 2) {
                    C(h.b(aVar2), null);
                    this.U.h(this.N, this.M, k3);
                }
                this.f147209w0 = true;
            }
            int i18 = this.f147191h + this.f147193i;
            if (this.f147195j0) {
                if (this.f147200n0 >= this.U.f147056b.size()) {
                    Log.e("LyricViewInternalSL", "onMeasure -> mSongEndLine error");
                    this.f147200n0 = this.U.v() - 1;
                }
                for (int i19 = this.f147199m0; i19 <= this.f147200n0; i19++) {
                    if (this.U.f147056b.get(i19) != null) {
                        i17 += this.U.f147056b.get(i19).e();
                    }
                    if (this.f147211y0 && this.V != null && this.U.v() == this.V.v() && this.V.f147056b.get(i19) != null) {
                        i17 += this.U.f147056b.get(i19).e();
                    }
                }
            } else {
                i17 = this.U.q();
                if (this.f147211y0 && this.V != null && this.U.v() == this.V.v()) {
                    i17 += this.V.q();
                }
            }
            int i26 = i17 * i18;
            this.f147181d0 = i26;
            setMeasuredDimension(measuredWidth, i26 + measuredHeight);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
