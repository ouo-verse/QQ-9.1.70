package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import d73.e;
import d73.f;
import d73.g;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LyricViewInternalDetail extends LyricViewInternalBase {
    public LyricViewInternalDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int w(int i3) {
        int i16;
        d73.b bVar = this.R;
        int i17 = 0;
        if (bVar != null && !bVar.k()) {
            int l3 = this.R.l() - 1;
            if (this.f321048c0) {
                i16 = this.f321054f0;
                l3 = this.f321055g0;
            } else {
                i16 = 0;
            }
            while (true) {
                if (i16 > l3) {
                    break;
                }
                int c16 = this.R.f393162b.get(i16).c();
                int i18 = this.I * c16;
                int i19 = this.J;
                i17 += i18 + ((c16 - 1) * i19) + i19;
                if (i3 < i17) {
                    l3 = i16;
                    break;
                }
                i16++;
            }
            ms.a.a("LyricViewInternalDetail", "computeHilightWhileScrolling() y => " + i3 + ",position => " + l3);
            return l3;
        }
        Log.e("LyricViewInternalDetail", "computeHilightWhileScrolling -> mLineLyric == null");
        return 0;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase, com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public int a(int i3) {
        super.a(i3);
        int w3 = w(i3);
        postInvalidate();
        return w3;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase, com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public int b(int i3) {
        super.b(i3);
        int w3 = w(i3);
        postInvalidate();
        return w3;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase, com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public int f() {
        int i3;
        int i16;
        int i17 = 0;
        if (this.U != 70) {
            return 0;
        }
        int i18 = this.I + this.J;
        ArrayList<e> arrayList = this.R.f393162b;
        if (arrayList == null) {
            return 0;
        }
        int size = arrayList.size() - 1;
        if (this.f321048c0) {
            i16 = this.f321054f0;
            i3 = this.f321055g0;
        } else {
            i3 = size;
            i16 = 0;
        }
        while (i16 < i3) {
            i17 += arrayList.get(i16).c();
            i16++;
        }
        int i19 = this.f321072u0;
        int i26 = this.f321071t0;
        if (i26 > 0 && i26 < i19) {
            i19 = i26;
        }
        return this.Q + (i18 * (i17 - ((int) (i19 * 0.3f))));
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase
    protected void g(Canvas canvas, int i3) {
        int c16;
        int i16 = this.I;
        int i17 = i16 + this.J;
        this.Q = (((int) (this.f321072u0 * 0.3f)) * i17) + (i16 / 2);
        ArrayList<e> arrayList = this.R.f393162b;
        int size = arrayList.size();
        int i18 = this.f321057h0;
        if (i18 < 0) {
            i18 = 0;
        }
        if (i18 >= size) {
            i18 = size - 1;
        }
        int i19 = i18;
        if (!arrayList.isEmpty()) {
            int i26 = i3 + i();
            int i27 = size - 1;
            int i28 = this.Q;
            for (int i29 = 0; i29 <= i27; i29++) {
                e eVar = arrayList.get(i29);
                if (i29 == i19) {
                    if (this.f321069r0 && this.R.f393161a == 2 && !this.A0) {
                        n(eVar, canvas, i26, i28);
                        c16 = eVar.c();
                    } else {
                        l(eVar, canvas, i26, i28, true);
                        c16 = eVar.c();
                    }
                } else {
                    m(eVar, canvas, i26, i28, this.f321049d);
                    c16 = eVar.c();
                }
                i28 += c16 * i17;
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase
    public void j(c cVar) {
        super.j(cVar);
        this.f321066o0 = (this.I + this.J) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0137 A[Catch: StringIndexOutOfBoundsException -> 0x015f, all -> 0x01f3, TryCatch #3 {StringIndexOutOfBoundsException -> 0x015f, blocks: (B:69:0x0128, B:59:0x0137, B:61:0x0141, B:67:0x0150), top: B:68:0x0128, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void n(e eVar, Canvas canvas, int i3, int i16) {
        ArrayList<g> arrayList;
        int i17;
        int i18;
        int i19;
        Paint paint;
        int i26;
        int i27;
        float f16;
        float f17;
        float measureText;
        float measureText2;
        int i28;
        d73.a aVar;
        f fVar;
        ArrayList<g> d16 = eVar.d();
        int size = d16.size();
        int i29 = this.f321059i0;
        Paint paint2 = this.f321051e;
        if (this.f321070s0 && (fVar = eVar.f393184e) != null) {
            paint2.setColor(fVar.f393189c);
        }
        int i36 = i16;
        int i37 = 0;
        while (i37 < size) {
            g gVar = d16.get(i37);
            ArrayList<d73.a> arrayList2 = gVar.f393196f;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList<d73.a> arrayList3 = gVar.f393196f;
                int size2 = arrayList3.size();
                int length = gVar.f393191a.length();
                if (i37 == 0) {
                    i26 = this.J;
                } else {
                    i26 = this.J + this.K;
                }
                int i38 = i26;
                if (this.f321075x0) {
                    i27 = length;
                    gVar.b(canvas, i3, i36 + i38, this.f321063m, true);
                } else {
                    i27 = length;
                }
                long j3 = i29;
                if (gVar.d() <= j3 && gVar.c() >= j3) {
                    int i39 = 0;
                    int i46 = 0;
                    d73.a aVar2 = null;
                    while (i39 < size2) {
                        aVar2 = arrayList3.get(i39);
                        if (i39 < size2 - 1) {
                            aVar = arrayList3.get(i39 + 1);
                            i28 = i39;
                        } else {
                            i28 = i39;
                            aVar = null;
                        }
                        long j16 = aVar2.f393157a;
                        if (j16 <= j3 && aVar != null) {
                            i17 = size;
                            i18 = i29;
                            if (aVar.f393157a > j3) {
                                f16 = ((float) (j3 - j16)) / ((float) aVar2.f393158b);
                                f17 = f16;
                                i46 = i28;
                                break;
                            }
                        } else {
                            i17 = size;
                            i18 = i29;
                        }
                        if (j16 <= j3) {
                            long j17 = aVar2.f393158b;
                            if (j16 + j17 >= j3) {
                                f16 = ((float) (j3 - j16)) / ((float) j17);
                                f17 = f16;
                                i46 = i28;
                                break;
                            }
                        }
                        i39 = i28 + 1;
                        i46 = i28;
                        size = i17;
                        i29 = i18;
                    }
                    i17 = size;
                    i18 = i29;
                    f16 = 0.0f;
                    f17 = 0.0f;
                    if (aVar2 != null) {
                        float f18 = i3;
                        if (i46 != 0) {
                            int i47 = i46 - 1;
                            try {
                                if (i27 >= arrayList3.get(i47).f393160d) {
                                    arrayList = d16;
                                    try {
                                        measureText2 = this.f321051e.measureText(gVar.f393191a.substring(0, arrayList3.get(i47).f393160d));
                                    } catch (StringIndexOutOfBoundsException unused) {
                                        measureText2 = this.f321051e.measureText(gVar.f393191a.substring(0, i27));
                                        f18 += measureText2;
                                        float f19 = f18;
                                        if (i46 != size2 - 1) {
                                        }
                                        float[] fArr = {f16, f17};
                                        i19 = i37;
                                        paint = paint2;
                                        gVar.e(canvas, i3, i36 + i38, this.f321053f, paint2, this.f321056h, i46, measureText, f19, new int[]{paint2.getColor(), this.f321053f.getColor()}, fArr);
                                        i36 += i38 + this.L;
                                        i37 = i19 + 1;
                                        d16 = arrayList;
                                        size = i17;
                                        i29 = i18;
                                        paint2 = paint;
                                    }
                                } else {
                                    arrayList = d16;
                                    measureText2 = this.f321051e.measureText(gVar.f393191a.substring(0, i27));
                                }
                            } catch (StringIndexOutOfBoundsException unused2) {
                                arrayList = d16;
                            }
                            f18 += measureText2;
                        } else {
                            arrayList = d16;
                        }
                        float f192 = f18;
                        if (i46 != size2 - 1) {
                            try {
                                measureText = this.f321056h.measureText(gVar.f393191a.substring(aVar2.f393159c, i27));
                            } catch (StringIndexOutOfBoundsException unused3) {
                                measureText = this.f321056h.measureText(gVar.f393191a.substring(0, i27));
                            }
                        } else {
                            int length2 = gVar.f393191a.length();
                            int i48 = aVar2.f393160d;
                            if (length2 >= i48) {
                                measureText = this.f321056h.measureText(gVar.f393191a.substring(aVar2.f393159c, i48));
                            } else {
                                measureText = this.f321056h.measureText(gVar.f393191a.substring(aVar2.f393159c, i27));
                            }
                        }
                        float[] fArr2 = {f16, f17};
                        i19 = i37;
                        paint = paint2;
                        gVar.e(canvas, i3, i36 + i38, this.f321053f, paint2, this.f321056h, i46, measureText, f192, new int[]{paint2.getColor(), this.f321053f.getColor()}, fArr2);
                    } else {
                        arrayList = d16;
                        i19 = i37;
                        paint = paint2;
                    }
                } else {
                    arrayList = d16;
                    i17 = size;
                    i18 = i29;
                    i19 = i37;
                    paint = paint2;
                    if (gVar.c() < j3) {
                        gVar.f(canvas, i3, i36 + i38, paint, true);
                    } else {
                        gVar.f(canvas, i3, i36 + i38, this.f321053f, true);
                    }
                }
                i36 += i38 + this.L;
                i37 = i19 + 1;
                d16 = arrayList;
                size = i17;
                i29 = i18;
                paint2 = paint;
            }
            arrayList = d16;
            i17 = size;
            i18 = i29;
            i19 = i37;
            paint = paint2;
            i37 = i19 + 1;
            d16 = arrayList;
            size = i17;
            i29 = i18;
            paint2 = paint;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewInternalBase
    public void u() {
        int i3;
        if (this.U != 70) {
            return;
        }
        int i16 = this.I + this.J;
        int i17 = this.f321057h0;
        ArrayList<e> arrayList = this.R.f393162b;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        if (this.f321048c0) {
            i3 = this.f321054f0;
            size = this.f321055g0;
        } else {
            i3 = 0;
        }
        if (i17 > size) {
            return;
        }
        int i18 = 0;
        while (i3 < i17) {
            i18 += arrayList.get(i3).c();
            i3++;
        }
        int i19 = this.f321072u0;
        int i26 = this.f321071t0;
        if (i26 > 0 && i26 < i19) {
            i19 = i26;
        }
        this.f321060j0 = this.Q + (i16 * ((i18 - ((int) (i19 * 0.3f))) + 1));
        if (this.f321060j0 < 0) {
            this.f321060j0 = 0;
        }
    }

    public long v(float f16) {
        int i3;
        int i16 = ((int) f16) - this.Q;
        d73.b bVar = this.R;
        if (bVar != null && !bVar.k()) {
            int l3 = this.R.l() - 1;
            int i17 = 0;
            if (this.f321048c0) {
                i3 = this.f321054f0;
                l3 = this.f321055g0;
            } else {
                i3 = 0;
            }
            while (true) {
                if (i3 > l3) {
                    break;
                }
                int c16 = this.R.f393162b.get(i3).c();
                int i18 = this.I * c16;
                int i19 = this.J;
                i17 += i18 + ((c16 - 1) * i19) + i19;
                if (i16 < i17) {
                    l3 = i3;
                    break;
                }
                i3++;
            }
            ms.a.a("LyricViewInternalDetail", "computeClickPosition() y => " + f16 + ",position => " + l3);
            return this.R.f393162b.get(l3).f393181b;
        }
        Log.e("LyricViewInternalDetail", "computeClickPosition -> mLineLyric == null");
        return 0L;
    }

    public int x() {
        return this.Q;
    }
}
