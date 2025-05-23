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
public class LyricViewInternalLandscape extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    public LyricViewInternalLandscape(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        boolean z16;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas, i3);
            return;
        }
        if (this.f147205s0) {
            return;
        }
        ArrayList<com.tencent.lyric.data.e> arrayList = this.U.f147056b;
        int size = arrayList.size();
        int i28 = this.f147201o0;
        int i29 = 0;
        if ((i28 - this.f147199m0) % 2 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i28 < 0) {
            i28 = 0;
        }
        if (i28 >= size) {
            i28 = size - 1;
        }
        int i36 = i28;
        if (!arrayList.isEmpty()) {
            int k3 = i3 + k();
            int size2 = arrayList.size() - 1;
            if (this.f147195j0) {
                i29 = this.f147199m0;
                size2 = this.f147200n0;
            }
            int i37 = size2;
            int i38 = i29;
            if (i36 >= i38 && i36 <= i37) {
                com.tencent.lyric.data.e eVar = arrayList.get(i36);
                int i39 = this.H;
                if (!z16) {
                    i17 = (int) ((getWidth() - this.N.measureText(eVar.f147070a)) - k3);
                    i16 = this.f147191h + this.H;
                } else {
                    i16 = i39;
                    i17 = k3;
                }
                if (this.A0 && this.U.f147055a == 2 && !this.M0) {
                    u(eVar, canvas, i17, i16);
                    i18 = i38;
                    i19 = i37;
                } else if (n()) {
                    i18 = i38;
                    i19 = i37;
                    x(eVar, canvas, i17, i16, this.M, this.R, true);
                } else {
                    i18 = i38;
                    i19 = i37;
                    r(eVar, canvas, i17, i16, this.M);
                }
                int i46 = i36 + 1;
                if (i46 >= i18 && i46 <= i19) {
                    com.tencent.lyric.data.e eVar2 = arrayList.get(i46);
                    int i47 = this.H;
                    if (z16) {
                        i27 = (int) ((getWidth() - this.N.measureText(eVar2.f147070a)) - k3);
                        i26 = this.f147191h + this.H;
                    } else {
                        i26 = i47;
                        i27 = k3;
                    }
                    if (this.A0 && this.U.f147055a == 2 && !this.M0) {
                        u(eVar2, canvas, i27, i26);
                    } else if (n()) {
                        x(eVar2, canvas, i27, i26, this.M, this.R, true);
                    } else {
                        r(eVar2, canvas, i27, i26, this.M);
                    }
                }
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, android.view.View
    protected void onMeasure(int i3, int i16) {
        com.tencent.lyric.data.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.f147176b0 == 70 && !this.f147209w0) {
            int k3 = measuredWidth - (k() << 1);
            Log.i("LyricViewLandscape", "onMeasure -> width:" + k3 + ", parentWidth:" + measuredWidth);
            if (k3 <= 0) {
                setMeasuredDimension(measuredWidth, measuredHeight);
                return;
            }
            this.f147208v0 = measuredWidth;
            int i18 = this.f147191h + this.f147193i;
            this.U.f(this.N, k3, false);
            com.tencent.lyric.data.a c16 = h.c(this.U);
            this.U = c16;
            if (this.V != null && c16.v() == this.V.v()) {
                this.V.f(this.N, k3, false);
                this.V = h.c(this.V);
            }
            if (this.N.getTextSize() != this.D) {
                float textSize = this.N.getTextSize();
                int i19 = this.Z0;
                if (textSize < i19) {
                    this.D = i19;
                    this.f147180d = this.Y0;
                } else {
                    this.f147180d = (int) (this.N.getTextSize() - (this.D - this.f147180d));
                    this.D = (int) this.N.getTextSize();
                }
                this.N.setTextSize(this.D);
                this.M.setTextSize(this.f147180d);
                this.Q.setTextSize(this.D);
                this.P.setTextSize(this.D);
                this.R.setTextSize(this.f147180d);
                this.S.setTextSize(this.D);
            }
            if (this.f147195j0) {
                for (int i26 = this.f147199m0; i26 <= this.f147200n0; i26++) {
                    if (this.U.f147056b.get(i26) != null) {
                        i17 += this.U.f147056b.get(i26).e();
                    }
                }
            } else {
                i17 = this.U.q();
            }
            if (this.f147211y0 && (aVar = this.V) != null && aVar.f147056b != null) {
                if (this.f147195j0) {
                    for (int i27 = this.f147199m0; i27 <= this.f147200n0; i27++) {
                        if (i27 < this.V.f147056b.size() && i27 >= 0) {
                            i17 += this.V.f147056b.get(i27).e();
                        }
                    }
                } else {
                    i17 += this.V.q();
                }
            }
            int i28 = i17 * i18;
            this.f147181d0 = i28;
            this.D0 = (measuredHeight / (this.f147193i + this.f147191h)) + 1;
            setMeasuredDimension(measuredWidth, i28 + measuredHeight);
            this.f147209w0 = true;
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public LyricViewInternalLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
