package com.tencent.lyric.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewInternalScore extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    protected final Paint f147246h1;

    /* renamed from: i1, reason: collision with root package name */
    protected final Paint f147247i1;

    /* renamed from: j1, reason: collision with root package name */
    protected final Paint f147248j1;

    /* renamed from: k1, reason: collision with root package name */
    protected final Paint f147249k1;

    /* renamed from: l1, reason: collision with root package name */
    private int[] f147250l1;

    /* renamed from: m1, reason: collision with root package name */
    protected int f147251m1;

    /* renamed from: n1, reason: collision with root package name */
    protected int f147252n1;

    /* renamed from: o1, reason: collision with root package name */
    protected int f147253o1;

    public LyricViewInternalScore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f147246h1 = new Paint();
        this.f147247i1 = new Paint();
        this.f147248j1 = new Paint();
        this.f147249k1 = new Paint();
        this.f147251m1 = -825760;
        this.f147252n1 = -825760;
        this.f147253o1 = -825760;
    }

    public static int E(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    protected void F(Canvas canvas, int i3, int i16, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
            return;
        }
        int[] iArr = this.f147250l1;
        if (iArr != null && i16 < iArr.length && i16 >= 0) {
            int right = (int) (getRight() - (this.M.getTextSize() * 2.0f));
            int i17 = this.f147250l1[i16];
            if (i17 < 60) {
                this.f147246h1.setColor(this.f147251m1);
            } else if (i17 < 80) {
                this.f147246h1.setColor(this.f147252n1);
            } else {
                this.f147246h1.setColor(this.f147253o1);
            }
            this.f147246h1.setAlpha((int) (f16 * 255.0f));
            if (this.f147250l1[i16] < 0) {
                canvas.drawText("--", right, i3, this.f147246h1);
                return;
            }
            canvas.drawText(Integer.toString(this.f147250l1[i16]) + "'", right, i3, this.f147246h1);
        }
    }

    protected void G(Canvas canvas, int i3, int i16, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint);
        } else {
            int i17 = ((int) this.U.f147056b.get(i16).f147071b) / 1000;
            canvas.drawText(String.format("%02d:%02d", Integer.valueOf(i17 / 60), Integer.valueOf(i17 % 60)), E(this.f147189g0, 8.0f), i3, paint);
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int b(int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        super.b(i3);
        com.tencent.lyric.data.a aVar = this.U;
        int i18 = 0;
        if (aVar != null && !aVar.t()) {
            int i19 = this.f147193i;
            int i26 = (i3 + i19) / (this.f147191h + i19);
            Log.i("LyricViewInternalScore", "onScrollStop -> display lyric number\uff1a" + i26);
            int size = this.U.f147056b.size() + (-1);
            if (this.f147195j0) {
                i17 = this.f147199m0;
                i16 = this.f147200n0;
            } else {
                i16 = size;
                i17 = 0;
            }
            try {
                i18 = h.a(this.U, null, i26, i17, i16);
            } catch (RuntimeException e16) {
                Log.e("LyricViewInternalScore", e16.toString());
            }
            Log.i("LyricViewInternalScore", "onScrollStop -> calculate lineNo\uff1a" + i18);
            return i18;
        }
        Log.w("LyricViewInternalScore", "onScrollStop -> scroll without lyric");
        return 0;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void f() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f147176b0 != 70) {
            return;
        }
        int i16 = this.f147191h + this.f147193i;
        int i17 = this.f147201o0;
        ArrayList<com.tencent.lyric.data.e> arrayList = this.U.f147056b;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        int i18 = 0;
        if (this.f147195j0) {
            i3 = this.f147199m0;
            size = this.f147200n0;
        } else {
            i3 = 0;
        }
        if (i17 > size) {
            Log.e("LyricViewInternalScore", "updateCurrentTop -> displayLine is bigger than lyric end line");
            return;
        }
        while (i3 < i17) {
            i18 += arrayList.get(i3).e();
            i3++;
        }
        this.f147203q0 = (this.H + (i16 * (i18 - 3))) - this.f147193i;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        int i16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas, i3);
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int i17 = this.f147191h + this.f147193i;
        this.H = (view.getMeasuredHeight() / 2) + this.f147191h + this.f147193i;
        ArrayList<com.tencent.lyric.data.e> arrayList = this.U.f147056b;
        int size = arrayList.size();
        int i18 = this.f147201o0;
        int i19 = 0;
        if (i18 < 0) {
            i18 = 0;
        }
        if (i18 >= size) {
            i18 = size - 1;
        }
        int i26 = i18;
        if (!arrayList.isEmpty()) {
            int k3 = i3 + k();
            int i27 = this.H;
            int size2 = arrayList.size() - 1;
            if (this.f147195j0) {
                i19 = this.f147199m0;
                size2 = this.f147200n0;
            }
            int i28 = size2;
            int i29 = i27;
            int i36 = i19;
            while (i36 <= i28) {
                com.tencent.lyric.data.e eVar = arrayList.get(i36);
                if (this.f147207u0) {
                    G(canvas, this.f147193i + i29, i36, this.f147247i1);
                    i16 = i36;
                    r(eVar, canvas, k3, i29, this.f147247i1);
                    F(canvas, this.f147193i + i29, i16, 0.5f);
                    z16 = true;
                } else {
                    i16 = i36;
                    int abs = Math.abs(i16 - i26);
                    if (abs != 0) {
                        if (abs != 1) {
                            if (abs != 2) {
                                G(canvas, this.f147193i + i29, i16, this.f147249k1);
                                z16 = true;
                                r(eVar, canvas, k3, i29, this.f147249k1);
                                F(canvas, this.f147193i + i29, i16, 0.1f);
                            } else {
                                z16 = true;
                                G(canvas, this.f147193i + i29, i16, this.f147248j1);
                                r(eVar, canvas, k3, i29, this.f147248j1);
                                F(canvas, this.f147193i + i29, i16, 0.2f);
                            }
                        } else {
                            z16 = true;
                            G(canvas, this.f147193i + i29, i16, this.f147247i1);
                            r(eVar, canvas, k3, i29, this.f147247i1);
                            F(canvas, this.f147193i + i29, i16, 0.5f);
                        }
                    } else {
                        z16 = true;
                        Bitmap bitmap = this.f147187f0;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            canvas.drawBitmap(this.f147187f0, 0.0f, ((this.f147191h / 2) + i29) - E(this.f147189g0, 5.0f), this.N);
                        }
                        G(canvas, this.f147193i + i29, i16, this.N);
                        t(eVar, canvas, k3, i29, true);
                        F(canvas, this.f147193i + i29, i16, 1.0f);
                    }
                }
                i29 += eVar.e() * i17;
                i36 = i16 + 1;
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    public void l(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        super.l(dVar);
        this.f147247i1.setAntiAlias(true);
        this.f147247i1.setTextSize(this.f147180d);
        this.f147247i1.setColor(this.f147183e);
        this.f147247i1.setAlpha(127);
        this.f147248j1.setAntiAlias(true);
        this.f147248j1.setTextSize(this.f147180d);
        this.f147248j1.setColor(this.f147183e);
        this.f147248j1.setAlpha(51);
        this.f147249k1.setAntiAlias(true);
        this.f147249k1.setTextSize(this.f147180d);
        this.f147249k1.setColor(this.f147183e);
        this.f147249k1.setAlpha(25);
        this.f147246h1.setAntiAlias(true);
        this.f147246h1.setTextSize(this.f147180d);
        this.f147178c0 = ((int) this.f147247i1.measureText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT)) + E(this.f147189g0, 12.0f);
    }

    public void setIndicator(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bitmap);
        } else {
            this.f147187f0 = bitmap;
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    public void setOrdinaryTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        super.setOrdinaryTextColor(i3);
        this.f147247i1.setColor(this.f147183e);
        this.f147248j1.setColor(this.f147183e);
        this.f147249k1.setColor(this.f147183e);
        invalidate();
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    public void setOrdinaryTextSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f147180d = i3;
        float f16 = i3;
        this.M.setTextSize(f16);
        this.R.setTextSize(f16);
        this.f147247i1.setTextSize(f16);
        this.f147248j1.setTextSize(f16);
        this.f147249k1.setTextSize(f16);
        this.f147246h1.setTextSize(f16);
        invalidate();
    }

    public void setScore(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iArr);
        } else {
            this.f147250l1 = iArr;
        }
    }
}
