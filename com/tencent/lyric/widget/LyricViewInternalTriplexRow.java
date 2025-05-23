package com.tencent.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewInternalTriplexRow extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    protected volatile boolean f147255h1;

    public LyricViewInternalTriplexRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.N0 = 2;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f147174a0.computeScrollOffset() && this.f147255h1) {
            scrollTo(this.f147174a0.getCurrX(), this.f147174a0.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        int e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas, i3);
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
            int size2 = arrayList.size() - 1;
            if (this.f147195j0) {
                i17 = this.f147199m0;
                size2 = this.f147200n0;
                if (i16 < i17) {
                    i16 = i17;
                }
            }
            if (i16 >= i17 && i16 <= size2) {
                int i18 = this.H;
                int i19 = this.f147191h + this.f147193i;
                int i26 = i18;
                while (i17 <= size2) {
                    com.tencent.lyric.data.e eVar = arrayList.get(i17);
                    if (i17 <= i16 && this.f147202p0 != 0) {
                        if (this.A0 && this.U.f147055a == 2 && !this.M0) {
                            u(eVar, canvas, k3, i26);
                            e16 = eVar.e();
                        } else {
                            t(eVar, canvas, k3, i26, true);
                            e16 = eVar.e();
                        }
                    } else {
                        t(eVar, canvas, k3, i26, false);
                        e16 = eVar.e();
                    }
                    i26 += e16 * i19;
                    i17++;
                }
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (!this.f147205s0 && measuredWidth > 0) {
            if (this.f147176b0 == 70) {
                if (this.f147208v0 == measuredWidth && this.f147209w0) {
                    setMeasuredDimension(measuredWidth, this.f147181d0 + measuredHeight);
                } else {
                    this.f147208v0 = measuredWidth;
                    int k3 = measuredWidth - (k() << 1);
                    this.f147184e0 = k3;
                    com.tencent.lyric.data.a aVar = this.U;
                    if (aVar.f147055a == 1) {
                        aVar.j(this.N, this.M, k3, true, false, true);
                    } else if (this.J) {
                        if (this.f147195j0) {
                            this.U.e(this.N, this.M, this.f147184e0, false, true, true, 2, this.f147199m0, this.f147200n0);
                        } else {
                            this.U.k(this.N, this.M, this.f147184e0, false, true, true, 2);
                        }
                    } else {
                        aVar.j(this.N, this.M, k3, true, false, true);
                    }
                    float textSize = this.N.getTextSize();
                    if (textSize < this.D) {
                        this.S.setTextSize(textSize);
                        this.Q.setTextSize(textSize);
                        this.P.setTextSize(textSize);
                    }
                    if (textSize < this.M.getTextSize()) {
                        this.M.setTextSize(textSize);
                    }
                    this.f147209w0 = true;
                }
                int i18 = this.f147191h + this.f147193i;
                if (this.f147195j0) {
                    if (this.f147200n0 >= this.U.f147056b.size()) {
                        Log.e("LyricViewInternalTR", "onMeasure -> mSongEndLine error");
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
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
