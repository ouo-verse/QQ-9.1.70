package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FlexboxLayout extends ViewGroup implements a {

    @Nullable
    private Drawable C;

    @Nullable
    private Drawable D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int[] I;
    private SparseIntArray J;
    private c K;
    private List<b> L;
    private c.b M;

    /* renamed from: d, reason: collision with root package name */
    private int f33091d;

    /* renamed from: e, reason: collision with root package name */
    private int f33092e;

    /* renamed from: f, reason: collision with root package name */
    private int f33093f;

    /* renamed from: h, reason: collision with root package name */
    private int f33094h;

    /* renamed from: i, reason: collision with root package name */
    private int f33095i;

    /* renamed from: m, reason: collision with root package name */
    private int f33096m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DividerMode {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private boolean A(int i3) {
        if (i3 < 0 || i3 >= this.L.size()) {
            return false;
        }
        for (int i16 = i3 + 1; i16 < this.L.size(); i16++) {
            if (this.L.get(i16).c() > 0) {
                return false;
            }
        }
        if (q()) {
            if ((this.E & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.F & 4) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B(boolean z16, int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18;
        int i19;
        int i26;
        int i27;
        int i28;
        char c16;
        float f19;
        int i29;
        char c17;
        int i36;
        LayoutParams layoutParams;
        float f26;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i37 = i17 - i3;
        int paddingBottom = (i18 - i16) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.L.size();
        int i38 = 0;
        while (i38 < size) {
            b bVar = this.L.get(i38);
            if (z(i38)) {
                int i39 = this.G;
                paddingBottom -= i39;
                paddingTop += i39;
            }
            int i46 = this.f33093f;
            char c18 = 4;
            int i47 = 1;
            if (i46 != 0) {
                if (i46 != 1) {
                    if (i46 != 2) {
                        if (i46 != 3) {
                            if (i46 != 4) {
                                if (i46 == 5) {
                                    if (bVar.c() != 0) {
                                        f18 = (i37 - bVar.f33139e) / (r7 + 1);
                                    } else {
                                        f18 = 0.0f;
                                    }
                                    f16 = paddingLeft + f18;
                                    f17 = (i37 - paddingRight) - f18;
                                } else {
                                    throw new IllegalStateException("Invalid justifyContent is set: " + this.f33093f);
                                }
                            } else {
                                int c19 = bVar.c();
                                if (c19 != 0) {
                                    f18 = (i37 - bVar.f33139e) / c19;
                                } else {
                                    f18 = 0.0f;
                                }
                                float f27 = f18 / 2.0f;
                                f16 = paddingLeft + f27;
                                f17 = (i37 - paddingRight) - f27;
                            }
                        } else {
                            f16 = paddingLeft;
                            int c26 = bVar.c();
                            if (c26 != 1) {
                                f26 = c26 - 1;
                            } else {
                                f26 = 1.0f;
                            }
                            f18 = (i37 - bVar.f33139e) / f26;
                            f17 = i37 - paddingRight;
                        }
                        float max = Math.max(f18, 0.0f);
                        i19 = 0;
                        while (i19 < bVar.f33142h) {
                            int i48 = bVar.f33149o + i19;
                            View x16 = x(i48);
                            if (x16 != null) {
                                if (x16.getVisibility() == 8) {
                                    i26 = paddingLeft;
                                    i27 = i47;
                                    i28 = i19;
                                    c16 = 4;
                                } else {
                                    LayoutParams layoutParams2 = (LayoutParams) x16.getLayoutParams();
                                    float f28 = f16 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                                    float f29 = f17 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                                    if (y(i48, i19)) {
                                        int i49 = this.H;
                                        float f36 = i49;
                                        f28 += f36;
                                        i29 = i49;
                                        f19 = f29 - f36;
                                    } else {
                                        f19 = f29;
                                        i29 = 0;
                                    }
                                    if (i19 == bVar.f33142h - i47) {
                                        c17 = 4;
                                        if ((this.F & 4) > 0) {
                                            i36 = this.H;
                                            if (this.f33092e != 2) {
                                                if (z16) {
                                                    i27 = i47;
                                                    i28 = i19;
                                                    i26 = paddingLeft;
                                                    layoutParams = layoutParams2;
                                                    c16 = c17;
                                                    this.K.Q(x16, bVar, Math.round(f19) - x16.getMeasuredWidth(), paddingBottom - x16.getMeasuredHeight(), Math.round(f19), paddingBottom);
                                                } else {
                                                    i26 = paddingLeft;
                                                    i27 = i47;
                                                    i28 = i19;
                                                    layoutParams = layoutParams2;
                                                    c16 = c17;
                                                    this.K.Q(x16, bVar, Math.round(f28), paddingBottom - x16.getMeasuredHeight(), Math.round(f28) + x16.getMeasuredWidth(), paddingBottom);
                                                }
                                            } else {
                                                i26 = paddingLeft;
                                                i27 = i47;
                                                i28 = i19;
                                                layoutParams = layoutParams2;
                                                c16 = c17;
                                                if (z16) {
                                                    this.K.Q(x16, bVar, Math.round(f19) - x16.getMeasuredWidth(), paddingTop, Math.round(f19), paddingTop + x16.getMeasuredHeight());
                                                } else {
                                                    this.K.Q(x16, bVar, Math.round(f28), paddingTop, Math.round(f28) + x16.getMeasuredWidth(), paddingTop + x16.getMeasuredHeight());
                                                }
                                            }
                                            f16 = f28 + x16.getMeasuredWidth() + max + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                                            float measuredWidth = f19 - ((x16.getMeasuredWidth() + max) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                                            if (!z16) {
                                                bVar.d(x16, i36, 0, i29, 0);
                                            } else {
                                                bVar.d(x16, i29, 0, i36, 0);
                                            }
                                            f17 = measuredWidth;
                                        }
                                    } else {
                                        c17 = 4;
                                    }
                                    i36 = 0;
                                    if (this.f33092e != 2) {
                                    }
                                    f16 = f28 + x16.getMeasuredWidth() + max + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                                    float measuredWidth2 = f19 - ((x16.getMeasuredWidth() + max) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                                    if (!z16) {
                                    }
                                    f17 = measuredWidth2;
                                }
                            } else {
                                i26 = paddingLeft;
                                i27 = i47;
                                i28 = i19;
                                c16 = c18;
                            }
                            i19 = i28 + 1;
                            paddingLeft = i26;
                            i47 = i27;
                            c18 = c16;
                        }
                        int i56 = paddingLeft;
                        int i57 = bVar.f33141g;
                        paddingTop += i57;
                        paddingBottom -= i57;
                        i38++;
                        paddingLeft = i56;
                    } else {
                        int i58 = bVar.f33139e;
                        f16 = paddingLeft + ((i37 - i58) / 2.0f);
                        f17 = (i37 - paddingRight) - ((i37 - i58) / 2.0f);
                    }
                } else {
                    int i59 = bVar.f33139e;
                    f17 = i59 - paddingLeft;
                    f16 = (i37 - i59) + paddingRight;
                }
            } else {
                f16 = paddingLeft;
                f17 = i37 - paddingRight;
            }
            f18 = 0.0f;
            float max2 = Math.max(f18, 0.0f);
            i19 = 0;
            while (i19 < bVar.f33142h) {
            }
            int i562 = paddingLeft;
            int i572 = bVar.f33141g;
            paddingTop += i572;
            paddingBottom -= i572;
            i38++;
            paddingLeft = i562;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void C(boolean z16, boolean z17, int i3, int i16, int i17, int i18) {
        float f16;
        int i19;
        float f17;
        float f18;
        int i26;
        int i27;
        boolean z18;
        char c16;
        float f19;
        float f26;
        int i28;
        char c17;
        int i29;
        LayoutParams layoutParams;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i36 = i18 - i16;
        int i37 = (i17 - i3) - paddingRight;
        int size = this.L.size();
        for (int i38 = 0; i38 < size; i38++) {
            b bVar = this.L.get(i38);
            if (z(i38)) {
                int i39 = this.H;
                paddingLeft += i39;
                i37 -= i39;
            }
            int i46 = this.f33093f;
            char c18 = 4;
            boolean z19 = true;
            if (i46 != 0) {
                if (i46 != 1) {
                    if (i46 != 2) {
                        if (i46 != 3) {
                            if (i46 != 4) {
                                if (i46 == 5) {
                                    if (bVar.c() != 0) {
                                        f18 = (i36 - bVar.f33139e) / (r10 + 1);
                                    } else {
                                        f18 = 0.0f;
                                    }
                                    f16 = paddingTop + f18;
                                    f17 = (i36 - paddingBottom) - f18;
                                } else {
                                    throw new IllegalStateException("Invalid justifyContent is set: " + this.f33093f);
                                }
                            } else {
                                int c19 = bVar.c();
                                if (c19 != 0) {
                                    f18 = (i36 - bVar.f33139e) / c19;
                                } else {
                                    f18 = 0.0f;
                                }
                                float f27 = f18 / 2.0f;
                                f16 = paddingTop + f27;
                                f17 = (i36 - paddingBottom) - f27;
                            }
                        } else {
                            f16 = paddingTop;
                            int c26 = bVar.c();
                            f18 = (i36 - bVar.f33139e) / (c26 != 1 ? c26 - 1 : 1.0f);
                            f17 = i36 - paddingBottom;
                        }
                        float max = Math.max(f18, 0.0f);
                        i26 = 0;
                        while (i26 < bVar.f33142h) {
                            int i47 = bVar.f33149o + i26;
                            View x16 = x(i47);
                            if (x16 != null) {
                                if (x16.getVisibility() == 8) {
                                    i27 = i26;
                                    z18 = true;
                                    c16 = 4;
                                } else {
                                    LayoutParams layoutParams2 = (LayoutParams) x16.getLayoutParams();
                                    float f28 = f16 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                                    float f29 = f17 - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                                    if (y(i47, i26)) {
                                        int i48 = this.G;
                                        float f36 = i48;
                                        f19 = f28 + f36;
                                        i28 = i48;
                                        f26 = f29 - f36;
                                    } else {
                                        f19 = f28;
                                        f26 = f29;
                                        i28 = 0;
                                    }
                                    if (i26 == bVar.f33142h - 1) {
                                        c17 = 4;
                                        if ((this.E & 4) > 0) {
                                            i29 = this.G;
                                            if (!z16) {
                                                if (z17) {
                                                    i27 = i26;
                                                    z18 = true;
                                                    layoutParams = layoutParams2;
                                                    c16 = c17;
                                                    this.K.R(x16, bVar, true, i37 - x16.getMeasuredWidth(), Math.round(f26) - x16.getMeasuredHeight(), i37, Math.round(f26));
                                                } else {
                                                    i27 = i26;
                                                    z18 = true;
                                                    layoutParams = layoutParams2;
                                                    c16 = c17;
                                                    this.K.R(x16, bVar, true, i37 - x16.getMeasuredWidth(), Math.round(f19), i37, Math.round(f19) + x16.getMeasuredHeight());
                                                }
                                            } else {
                                                i27 = i26;
                                                z18 = true;
                                                layoutParams = layoutParams2;
                                                c16 = c17;
                                                if (z17) {
                                                    this.K.R(x16, bVar, false, paddingLeft, Math.round(f26) - x16.getMeasuredHeight(), paddingLeft + x16.getMeasuredWidth(), Math.round(f26));
                                                } else {
                                                    this.K.R(x16, bVar, false, paddingLeft, Math.round(f19), paddingLeft + x16.getMeasuredWidth(), Math.round(f19) + x16.getMeasuredHeight());
                                                }
                                            }
                                            LayoutParams layoutParams3 = layoutParams;
                                            float measuredHeight = f19 + x16.getMeasuredHeight() + max + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                                            float measuredHeight2 = f26 - ((x16.getMeasuredHeight() + max) + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin);
                                            if (!z17) {
                                                bVar.d(x16, 0, i29, 0, i28);
                                            } else {
                                                bVar.d(x16, 0, i28, 0, i29);
                                            }
                                            f16 = measuredHeight;
                                            f17 = measuredHeight2;
                                        }
                                    } else {
                                        c17 = 4;
                                    }
                                    i29 = 0;
                                    if (!z16) {
                                    }
                                    LayoutParams layoutParams32 = layoutParams;
                                    float measuredHeight3 = f19 + x16.getMeasuredHeight() + max + ((ViewGroup.MarginLayoutParams) layoutParams32).bottomMargin;
                                    float measuredHeight22 = f26 - ((x16.getMeasuredHeight() + max) + ((ViewGroup.MarginLayoutParams) layoutParams32).topMargin);
                                    if (!z17) {
                                    }
                                    f16 = measuredHeight3;
                                    f17 = measuredHeight22;
                                }
                            } else {
                                i27 = i26;
                                z18 = z19;
                                c16 = c18;
                            }
                            i26 = i27 + 1;
                            z19 = z18;
                            c18 = c16;
                        }
                        int i49 = bVar.f33141g;
                        paddingLeft += i49;
                        i37 -= i49;
                    } else {
                        int i56 = bVar.f33139e;
                        f17 = (i36 - paddingBottom) - ((i36 - i56) / 2.0f);
                        f16 = paddingTop + ((i36 - i56) / 2.0f);
                        f18 = 0.0f;
                        float max2 = Math.max(f18, 0.0f);
                        i26 = 0;
                        while (i26 < bVar.f33142h) {
                        }
                        int i492 = bVar.f33141g;
                        paddingLeft += i492;
                        i37 -= i492;
                    }
                } else {
                    int i57 = bVar.f33139e;
                    f16 = (i36 - i57) + paddingBottom;
                    i19 = i57 - paddingTop;
                }
            } else {
                f16 = paddingTop;
                i19 = i36 - paddingBottom;
            }
            f17 = i19;
            f18 = 0.0f;
            float max22 = Math.max(f18, 0.0f);
            i26 = 0;
            while (i26 < bVar.f33142h) {
            }
            int i4922 = bVar.f33141g;
            paddingLeft += i4922;
            i37 -= i4922;
        }
    }

    private void D(int i3, int i16) {
        this.L.clear();
        this.M.a();
        this.K.c(this.M, i3, i16);
        this.L = this.M.f33158a;
        this.K.p(i3, i16);
        if (this.f33094h == 3) {
            for (b bVar : this.L) {
                int i17 = Integer.MIN_VALUE;
                for (int i18 = 0; i18 < bVar.f33142h; i18++) {
                    View x16 = x(bVar.f33149o + i18);
                    if (x16 != null && x16.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) x16.getLayoutParams();
                        if (this.f33092e != 2) {
                            i17 = Math.max(i17, x16.getMeasuredHeight() + Math.max(bVar.f33146l - x16.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        } else {
                            i17 = Math.max(i17, x16.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((bVar.f33146l - x16.getMeasuredHeight()) + x16.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                        }
                    }
                }
                bVar.f33141g = i17;
            }
        }
        this.K.o(i3, i16, getPaddingTop() + getPaddingBottom());
        this.K.X();
        F(this.f33091d, i3, i16, this.M.f33159b);
    }

    private void E(int i3, int i16) {
        this.L.clear();
        this.M.a();
        this.K.f(this.M, i3, i16);
        this.L = this.M.f33158a;
        this.K.p(i3, i16);
        this.K.o(i3, i16, getPaddingLeft() + getPaddingRight());
        this.K.X();
        F(this.f33091d, i3, i16, this.M.f33159b);
    }

    private void F(int i3, int i16, int i17, int i18) {
        int h16;
        int b16;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        int mode2 = View.MeasureSpec.getMode(i17);
        int size2 = View.MeasureSpec.getSize(i17);
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i3);
            }
            h16 = b();
            b16 = h() + getPaddingLeft() + getPaddingRight();
        } else {
            h16 = h() + getPaddingTop() + getPaddingBottom();
            b16 = b();
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    if (size < b16) {
                        i18 = View.combineMeasuredStates(i18, 16777216);
                    }
                    resolveSizeAndState = View.resolveSizeAndState(size, i16, i18);
                } else {
                    throw new IllegalStateException("Unknown width mode is set: " + mode);
                }
            } else {
                resolveSizeAndState = View.resolveSizeAndState(b16, i16, i18);
            }
        } else {
            if (size < b16) {
                i18 = View.combineMeasuredStates(i18, 16777216);
            } else {
                size = b16;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i16, i18);
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 0) {
                if (mode2 == 1073741824) {
                    if (size2 < h16) {
                        i18 = View.combineMeasuredStates(i18, 256);
                    }
                    resolveSizeAndState2 = View.resolveSizeAndState(size2, i17, i18);
                } else {
                    throw new IllegalStateException("Unknown height mode is set: " + mode2);
                }
            } else {
                resolveSizeAndState2 = View.resolveSizeAndState(h16, i17, i18);
            }
        } else {
            if (size2 < h16) {
                i18 = View.combineMeasuredStates(i18, 256);
            } else {
                size2 = h16;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i17, i18);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    private void G() {
        if (this.C == null && this.D == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean a(int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            if (this.L.get(i16).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean r(int i3, int i16) {
        for (int i17 = 1; i17 <= i16; i17++) {
            View x16 = x(i3 - i17);
            if (x16 != null && x16.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void s(Canvas canvas, boolean z16, boolean z17) {
        int i3;
        int i16;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.L.size();
        for (int i17 = 0; i17 < size; i17++) {
            b bVar = this.L.get(i17);
            for (int i18 = 0; i18 < bVar.f33142h; i18++) {
                int i19 = bVar.f33149o + i18;
                View x16 = x(i19);
                if (x16 != null && x16.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) x16.getLayoutParams();
                    if (y(i19, i18)) {
                        if (z16) {
                            left = x16.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            left = (x16.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.H;
                        }
                        v(canvas, left, bVar.f33136b, bVar.f33141g);
                    }
                    if (i18 == bVar.f33142h - 1 && (this.F & 4) > 0) {
                        if (z16) {
                            right = (x16.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.H;
                        } else {
                            right = x16.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        v(canvas, right, bVar.f33136b, bVar.f33141g);
                    }
                }
            }
            if (z(i17)) {
                if (z17) {
                    i16 = bVar.f33138d;
                } else {
                    i16 = bVar.f33136b - this.G;
                }
                u(canvas, paddingLeft, i16, max);
            }
            if (A(i17) && (this.E & 4) > 0) {
                if (z17) {
                    i3 = bVar.f33136b - this.G;
                } else {
                    i3 = bVar.f33138d;
                }
                u(canvas, paddingLeft, i3, max);
            }
        }
    }

    private void t(Canvas canvas, boolean z16, boolean z17) {
        int i3;
        int i16;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.L.size();
        for (int i17 = 0; i17 < size; i17++) {
            b bVar = this.L.get(i17);
            for (int i18 = 0; i18 < bVar.f33142h; i18++) {
                int i19 = bVar.f33149o + i18;
                View x16 = x(i19);
                if (x16 != null && x16.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) x16.getLayoutParams();
                    if (y(i19, i18)) {
                        if (z17) {
                            top = x16.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            top = (x16.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.G;
                        }
                        u(canvas, bVar.f33135a, top, bVar.f33141g);
                    }
                    if (i18 == bVar.f33142h - 1 && (this.E & 4) > 0) {
                        if (z17) {
                            bottom = (x16.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.G;
                        } else {
                            bottom = x16.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        u(canvas, bVar.f33135a, bottom, bVar.f33141g);
                    }
                }
            }
            if (z(i17)) {
                if (z16) {
                    i16 = bVar.f33137c;
                } else {
                    i16 = bVar.f33135a - this.H;
                }
                v(canvas, i16, paddingTop, max);
            }
            if (A(i17) && (this.F & 4) > 0) {
                if (z16) {
                    i3 = bVar.f33135a - this.H;
                } else {
                    i3 = bVar.f33137c;
                }
                v(canvas, i3, paddingTop, max);
            }
        }
    }

    private void u(Canvas canvas, int i3, int i16, int i17) {
        Drawable drawable = this.C;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i3, i16, i17 + i3, this.G + i16);
        this.C.draw(canvas);
    }

    private void v(Canvas canvas, int i3, int i16, int i17) {
        Drawable drawable = this.D;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i3, i16, this.H + i3, i17 + i16);
        this.D.draw(canvas);
    }

    private boolean y(int i3, int i16) {
        if (r(i3, i16)) {
            if (q()) {
                if ((this.F & 1) == 0) {
                    return false;
                }
                return true;
            }
            if ((this.E & 1) == 0) {
                return false;
            }
            return true;
        }
        if (q()) {
            if ((this.F & 2) == 0) {
                return false;
            }
            return true;
        }
        if ((this.E & 2) == 0) {
            return false;
        }
        return true;
    }

    private boolean z(int i3) {
        if (i3 < 0 || i3 >= this.L.size()) {
            return false;
        }
        if (a(i3)) {
            if (q()) {
                if ((this.E & 1) == 0) {
                    return false;
                }
                return true;
            }
            if ((this.F & 1) == 0) {
                return false;
            }
            return true;
        }
        if (q()) {
            if ((this.E & 2) == 0) {
                return false;
            }
            return true;
        }
        if ((this.F & 2) == 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (this.J == null) {
            this.J = new SparseIntArray(getChildCount());
        }
        this.I = this.K.n(view, i3, layoutParams, this.J);
        super.addView(view, i3, layoutParams);
    }

    @Override // com.google.android.flexbox.a
    public int b() {
        Iterator<b> it = this.L.iterator();
        int i3 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i3 = Math.max(i3, it.next().f33139e);
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public int c() {
        return getChildCount();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.a
    public int d() {
        return this.f33096m;
    }

    @Override // com.google.android.flexbox.a
    public void e(b bVar) {
        if (q()) {
            if ((this.F & 4) > 0) {
                int i3 = bVar.f33139e;
                int i16 = this.H;
                bVar.f33139e = i3 + i16;
                bVar.f33140f += i16;
                return;
            }
            return;
        }
        if ((this.E & 4) > 0) {
            int i17 = bVar.f33139e;
            int i18 = this.G;
            bVar.f33139e = i17 + i18;
            bVar.f33140f += i18;
        }
    }

    @Override // com.google.android.flexbox.a
    public View f(int i3) {
        return getChildAt(i3);
    }

    @Override // com.google.android.flexbox.a
    public int g() {
        return this.f33092e;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.f33095i;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f33094h;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f33091d;
    }

    @Override // com.google.android.flexbox.a
    public int h() {
        int i3;
        int i16;
        int size = this.L.size();
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            b bVar = this.L.get(i18);
            if (z(i18)) {
                if (q()) {
                    i16 = this.G;
                } else {
                    i16 = this.H;
                }
                i17 += i16;
            }
            if (A(i18)) {
                if (q()) {
                    i3 = this.G;
                } else {
                    i3 = this.H;
                }
                i17 += i3;
            }
            i17 += bVar.f33141g;
        }
        return i17;
    }

    @Override // com.google.android.flexbox.a
    public List<b> i() {
        return this.L;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view, int i3, int i16) {
        int i17;
        int i18 = 0;
        if (q()) {
            if (y(i3, i16)) {
                i18 = 0 + this.H;
            }
            if ((this.F & 4) > 0) {
                i17 = this.H;
            } else {
                return i18;
            }
        } else {
            if (y(i3, i16)) {
                i18 = 0 + this.G;
            }
            if ((this.E & 4) > 0) {
                i17 = this.G;
            } else {
                return i18;
            }
        }
        return i18 + i17;
    }

    @Override // com.google.android.flexbox.a
    public void l(View view, int i3, int i16, b bVar) {
        if (y(i3, i16)) {
            if (q()) {
                int i17 = bVar.f33139e;
                int i18 = this.H;
                bVar.f33139e = i17 + i18;
                bVar.f33140f += i18;
                return;
            }
            int i19 = bVar.f33139e;
            int i26 = this.G;
            bVar.f33139e = i19 + i26;
            bVar.f33140f += i26;
        }
    }

    @Override // com.google.android.flexbox.a
    public int m(int i3, int i16, int i17) {
        return ViewGroup.getChildMeasureSpec(i3, i16, i17);
    }

    @Override // com.google.android.flexbox.a
    public View n(int i3) {
        return x(i3);
    }

    @Override // com.google.android.flexbox.a
    public int o(int i3, int i16, int i17) {
        return ViewGroup.getChildMeasureSpec(i3, i16, i17);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z16;
        boolean z17;
        if (this.D == null && this.C == null) {
            return;
        }
        if (this.E == 0 && this.F == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i3 = this.f33091d;
        boolean z18 = false;
        boolean z19 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (layoutDirection == 1) {
                            z18 = true;
                        }
                        if (this.f33092e == 2) {
                            z18 = !z18;
                        }
                        t(canvas, z18, true);
                        return;
                    }
                    return;
                }
                if (layoutDirection != 1) {
                    z19 = false;
                }
                if (this.f33092e == 2) {
                    z19 = !z19;
                }
                t(canvas, z19, false);
                return;
            }
            if (layoutDirection != 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (this.f33092e == 2) {
                z18 = true;
            }
            s(canvas, z17, z18);
            return;
        }
        if (layoutDirection == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f33092e == 2) {
            z18 = true;
        }
        s(canvas, z16, z18);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i19 = this.f33091d;
        boolean z27 = false;
        if (i19 != 0) {
            if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 == 3) {
                        if (layoutDirection == 1) {
                            z27 = true;
                        }
                        if (this.f33092e == 2) {
                            z26 = !z27;
                        } else {
                            z26 = z27;
                        }
                        C(z26, true, i3, i16, i17, i18);
                        return;
                    }
                    throw new IllegalStateException("Invalid flex direction is set: " + this.f33091d);
                }
                if (layoutDirection == 1) {
                    z27 = true;
                }
                if (this.f33092e == 2) {
                    z19 = !z27;
                } else {
                    z19 = z27;
                }
                C(z19, false, i3, i16, i17, i18);
                return;
            }
            if (layoutDirection != 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            B(z18, i3, i16, i17, i18);
            return;
        }
        if (layoutDirection == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        B(z17, i3, i16, i17, i18);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.J == null) {
            this.J = new SparseIntArray(getChildCount());
        }
        if (this.K.O(this.J)) {
            this.I = this.K.m(this.J);
        }
        int i17 = this.f33091d;
        if (i17 != 0 && i17 != 1) {
            if (i17 != 2 && i17 != 3) {
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f33091d);
            }
            E(i3, i16);
            return;
        }
        D(i3, i16);
    }

    @Override // com.google.android.flexbox.a
    public boolean q() {
        int i3 = this.f33091d;
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }

    public void setAlignContent(int i3) {
        if (this.f33095i != i3) {
            this.f33095i = i3;
            requestLayout();
        }
    }

    public void setAlignItems(int i3) {
        if (this.f33094h != i3) {
            this.f33094h = i3;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.C) {
            return;
        }
        this.C = drawable;
        if (drawable != null) {
            this.G = drawable.getIntrinsicHeight();
        } else {
            this.G = 0;
        }
        G();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.D) {
            return;
        }
        this.D = drawable;
        if (drawable != null) {
            this.H = drawable.getIntrinsicWidth();
        } else {
            this.H = 0;
        }
        G();
        requestLayout();
    }

    public void setFlexDirection(int i3) {
        if (this.f33091d != i3) {
            this.f33091d = i3;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.L = list;
    }

    public void setFlexWrap(int i3) {
        if (this.f33092e != i3) {
            this.f33092e = i3;
            requestLayout();
        }
    }

    public void setJustifyContent(int i3) {
        if (this.f33093f != i3) {
            this.f33093f = i3;
            requestLayout();
        }
    }

    public void setMaxLine(int i3) {
        if (this.f33096m != i3) {
            this.f33096m = i3;
            requestLayout();
        }
    }

    public void setShowDivider(int i3) {
        setShowDividerVertical(i3);
        setShowDividerHorizontal(i3);
    }

    public void setShowDividerHorizontal(int i3) {
        if (i3 != this.E) {
            this.E = i3;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i3) {
        if (i3 != this.F) {
            this.F = i3;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public View x(int i3) {
        if (i3 >= 0) {
            int[] iArr = this.I;
            if (i3 < iArr.length) {
                return getChildAt(iArr[i3]);
            }
            return null;
        }
        return null;
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f33096m = -1;
        this.K = new c(this);
        this.L = new ArrayList();
        this.M = new c.b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f33163b, i3, 0);
        this.f33091d = obtainStyledAttributes.getInt(d.f33169h, 0);
        this.f33092e = obtainStyledAttributes.getInt(d.f33170i, 0);
        this.f33093f = obtainStyledAttributes.getInt(d.f33171j, 0);
        this.f33094h = obtainStyledAttributes.getInt(d.f33165d, 0);
        this.f33095i = obtainStyledAttributes.getInt(d.f33164c, 0);
        this.f33096m = obtainStyledAttributes.getInt(d.f33172k, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(d.f33166e);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(d.f33167f);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(d.f33168g);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i16 = obtainStyledAttributes.getInt(d.f33173l, 0);
        if (i16 != 0) {
            this.F = i16;
            this.E = i16;
        }
        int i17 = obtainStyledAttributes.getInt(d.f33175n, 0);
        if (i17 != 0) {
            this.F = i17;
        }
        int i18 = obtainStyledAttributes.getInt(d.f33174m, 0);
        if (i18 != 0) {
            this.E = i18;
        }
        obtainStyledAttributes.recycle();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int C;
        private int D;
        private int E;
        private boolean F;

        /* renamed from: d, reason: collision with root package name */
        private int f33097d;

        /* renamed from: e, reason: collision with root package name */
        private float f33098e;

        /* renamed from: f, reason: collision with root package name */
        private float f33099f;

        /* renamed from: h, reason: collision with root package name */
        private int f33100h;

        /* renamed from: i, reason: collision with root package name */
        private float f33101i;

        /* renamed from: m, reason: collision with root package name */
        private int f33102m;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<LayoutParams> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i3) {
                return new LayoutParams[i3];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f33097d = 1;
            this.f33098e = 0.0f;
            this.f33099f = 1.0f;
            this.f33100h = -1;
            this.f33101i = -1.0f;
            this.f33102m = -1;
            this.C = -1;
            this.D = 16777215;
            this.E = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f33176o);
            this.f33097d = obtainStyledAttributes.getInt(d.f33185x, 1);
            this.f33098e = obtainStyledAttributes.getFloat(d.f33179r, 0.0f);
            this.f33099f = obtainStyledAttributes.getFloat(d.f33180s, 1.0f);
            this.f33100h = obtainStyledAttributes.getInt(d.f33177p, -1);
            this.f33101i = obtainStyledAttributes.getFraction(d.f33178q, 1, 1, -1.0f);
            this.f33102m = obtainStyledAttributes.getDimensionPixelSize(d.f33184w, -1);
            this.C = obtainStyledAttributes.getDimensionPixelSize(d.f33183v, -1);
            this.D = obtainStyledAttributes.getDimensionPixelSize(d.f33182u, 16777215);
            this.E = obtainStyledAttributes.getDimensionPixelSize(d.f33181t, 16777215);
            this.F = obtainStyledAttributes.getBoolean(d.f33186y, false);
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        public float O() {
            return this.f33101i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void U(int i3) {
            this.C = i3;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void W(int i3) {
            this.f33102m = i3;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean Y() {
            return this.F;
        }

        public void a(float f16) {
            this.f33098e = f16;
        }

        public void b(float f16) {
            this.f33099f = f16;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.f33100h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.f33098e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.f33099f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.E;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.D;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.C;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.f33102m;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f33097d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f33097d);
            parcel.writeFloat(this.f33098e);
            parcel.writeFloat(this.f33099f);
            parcel.writeInt(this.f33100h);
            parcel.writeFloat(this.f33101i);
            parcel.writeInt(this.f33102m);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
            parcel.writeInt(this.E);
            parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f33097d = 1;
            this.f33098e = 0.0f;
            this.f33099f = 1.0f;
            this.f33100h = -1;
            this.f33101i = -1.0f;
            this.f33102m = -1;
            this.C = -1;
            this.D = 16777215;
            this.E = 16777215;
            this.f33097d = layoutParams.f33097d;
            this.f33098e = layoutParams.f33098e;
            this.f33099f = layoutParams.f33099f;
            this.f33100h = layoutParams.f33100h;
            this.f33101i = layoutParams.f33101i;
            this.f33102m = layoutParams.f33102m;
            this.C = layoutParams.C;
            this.D = layoutParams.D;
            this.E = layoutParams.E;
            this.F = layoutParams.F;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f33097d = 1;
            this.f33098e = 0.0f;
            this.f33099f = 1.0f;
            this.f33100h = -1;
            this.f33101i = -1.0f;
            this.f33102m = -1;
            this.C = -1;
            this.D = 16777215;
            this.E = 16777215;
        }

        public LayoutParams(int i3, int i16) {
            super(new ViewGroup.LayoutParams(i3, i16));
            this.f33097d = 1;
            this.f33098e = 0.0f;
            this.f33099f = 1.0f;
            this.f33100h = -1;
            this.f33101i = -1.0f;
            this.f33102m = -1;
            this.C = -1;
            this.D = 16777215;
            this.E = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f33097d = 1;
            this.f33098e = 0.0f;
            this.f33099f = 1.0f;
            this.f33100h = -1;
            this.f33101i = -1.0f;
            this.f33102m = -1;
            this.C = -1;
            this.D = 16777215;
            this.E = 16777215;
        }

        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            this.f33097d = 1;
            this.f33098e = 0.0f;
            this.f33099f = 1.0f;
            this.f33100h = -1;
            this.f33101i = -1.0f;
            this.f33102m = -1;
            this.C = -1;
            this.D = 16777215;
            this.E = 16777215;
            this.f33097d = parcel.readInt();
            this.f33098e = parcel.readFloat();
            this.f33099f = parcel.readFloat();
            this.f33100h = parcel.readInt();
            this.f33101i = parcel.readFloat();
            this.f33102m = parcel.readInt();
            this.C = parcel.readInt();
            this.D = parcel.readInt();
            this.E = parcel.readInt();
            this.F = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    @Override // com.google.android.flexbox.a
    public void p(int i3, View view) {
    }
}
