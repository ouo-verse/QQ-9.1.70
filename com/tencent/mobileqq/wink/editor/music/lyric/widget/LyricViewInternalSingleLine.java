package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;
import d73.e;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LyricViewInternalSingleLine extends LyricViewInternalBase {
    protected volatile boolean F0;

    public LyricViewInternalSingleLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void v(int i3, int i16) {
        int finalX;
        Log.d("LyricViewInternalSL", "scrollToXPos() xoffset => " + i3 + ",time => " + i16, new Exception());
        if (this.F0 && (finalX = i3 - this.T.getFinalX()) != 0) {
            Scroller scroller = this.T;
            scroller.startScroll(scroller.getFinalX(), this.T.getFinalY(), finalX, 0, i16);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.T.computeScrollOffset() && this.F0) {
            scrollTo(this.T.getCurrX(), this.T.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase, com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public void e(int i3, int i16) {
        if (this.f321057h0 != i3) {
            this.F0 = false;
            scrollTo(0, 0);
            this.T.setFinalX(0);
        }
        super.e(i3, i16);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase
    protected void g(Canvas canvas, int i3) {
        int i16;
        int i17;
        if (this.f321061k0) {
            return;
        }
        ArrayList<e> arrayList = this.R.f393162b;
        int size = arrayList.size();
        int i18 = this.f321057h0;
        if (i18 < 0) {
            i18 = 0;
        }
        if (i18 >= size) {
            i18 = size - 1;
        }
        if (!arrayList.isEmpty()) {
            int i19 = i3 + i();
            int size2 = arrayList.size() - 1;
            if (this.f321048c0) {
                i17 = this.f321054f0;
                i16 = this.f321055g0;
            } else {
                i16 = size2;
                i17 = 0;
            }
            if (i18 >= i17 && i18 <= i16) {
                e eVar = arrayList.get(i18);
                if (this.f321069r0 && this.R.f393161a == 2 && !this.A0) {
                    n(eVar, canvas, i19, 0);
                    return;
                }
                if (this.R.f393161a == 1) {
                    int measureText = (int) this.f321049d.measureText(eVar.f393180a);
                    if (measureText > this.f321047b0 + (i() >> 1) && this.f321047b0 != -1) {
                        if (!this.F0) {
                            this.F0 = true;
                            v(measureText - this.f321047b0, (int) eVar.f393182c);
                        }
                    } else {
                        int i26 = this.f321047b0;
                        if (measureText > i26) {
                            i19 -= (measureText - i26) >> 1;
                        }
                    }
                }
                int i27 = i19;
                boolean z16 = this.f321075x0;
                if (z16) {
                    o(eVar, canvas, i27, 0, this.f321049d, this.f321058i, z16);
                } else {
                    m(eVar, canvas, i27, 0, this.f321049d);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase, android.view.View
    protected void onMeasure(int i3, int i16) {
        int j3;
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.f321061k0) {
            setMeasuredDimension(measuredWidth, measuredHeight);
            return;
        }
        if (this.U == 70) {
            if (this.f321064m0 == measuredWidth && this.f321065n0) {
                setMeasuredDimension(measuredWidth, this.f321046a0 + measuredHeight);
            } else {
                this.f321064m0 = measuredWidth;
                int i17 = measuredWidth - (i() << 1);
                this.f321047b0 = i17;
                d73.b bVar = this.R;
                if (bVar.f393161a == 1) {
                    bVar.g(this.f321051e, this.f321049d, i17, true);
                } else {
                    bVar.f(this.f321051e, this.f321049d, i17);
                }
                d73.b bVar2 = this.R;
                if (bVar2.f393161a == 2) {
                    s(d.a(bVar2), null);
                    this.R.f(this.f321051e, this.f321049d, i17);
                }
                this.f321065n0 = true;
            }
            int i18 = this.I + this.J;
            if (this.f321048c0) {
                if (this.f321055g0 >= this.R.f393162b.size()) {
                    Log.e("LyricViewInternalSL", "onMeasure -> mSongEndLine error");
                    this.f321055g0 = this.R.l() - 1;
                }
                j3 = 0;
                for (int i19 = this.f321054f0; i19 <= this.f321055g0; i19++) {
                    if (this.R.f393162b.get(i19) != null) {
                        j3 += this.R.f393162b.get(i19).c();
                    }
                    if (this.f321067p0 && this.S != null && this.R.l() == this.S.l() && this.S.f393162b.get(i19) != null) {
                        j3 += this.R.f393162b.get(i19).c();
                    }
                }
            } else {
                j3 = this.R.j();
                if (this.f321067p0 && this.S != null && this.R.l() == this.S.l()) {
                    j3 += this.S.j();
                }
            }
            int i26 = j3 * i18;
            this.f321046a0 = i26;
            setMeasuredDimension(measuredWidth, i26 + measuredHeight);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase
    public void u() {
    }
}
