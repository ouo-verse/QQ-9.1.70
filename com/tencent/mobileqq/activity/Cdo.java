package com.tencent.mobileqq.activity;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* renamed from: com.tencent.mobileqq.activity.do, reason: invalid class name */
/* loaded from: classes9.dex */
public class Cdo {
    static IPatchRedirector $redirector_;

    public static Rect a(Rect rect, Rect rect2) {
        return new Rect(Math.min(rect.left, rect2.left), Math.min(rect.top, rect2.top), Math.max(rect.right, rect2.right), Math.max(rect.bottom, rect2.bottom));
    }

    public static Rect b(int i3, int i16, int i17, int i18) {
        boolean z16;
        char c16;
        int i19 = (i16 * i17) / i3;
        float f16 = 1.0f;
        if (i3 >= i17) {
            if (i18 >= i19) {
                f16 = i17 / i3;
                i16 = (int) (i16 * f16);
                i3 = i17;
                z16 = false;
                c16 = 17;
            } else {
                float f17 = i18;
                if (1.5f * f17 >= i19 && i19 > i18) {
                    f16 = f17 / i16;
                    i3 = (int) (i3 * f16);
                    i16 = i18;
                    z16 = false;
                    c16 = 17;
                } else {
                    if (i19 > i18 * 1.5d) {
                        f16 = i17 / i3;
                        i3 = i17;
                        i16 = i18;
                        c16 = '0';
                        z16 = false;
                    }
                    i3 = 0;
                    i16 = 0;
                    z16 = false;
                    c16 = 17;
                }
            }
        } else {
            if (i16 >= i18) {
                if (i16 > i18) {
                    float f18 = i16;
                    float f19 = i18;
                    if (f18 < f19 * 1.5f) {
                        f16 = f19 / f18;
                        i3 = (int) (i3 * f16);
                        i16 = i18;
                    }
                }
                if (i16 > i18 * 1.5f) {
                    z16 = true;
                    i16 = i18;
                    c16 = '0';
                }
                i3 = 0;
                i16 = 0;
                z16 = false;
                c16 = 17;
            }
            z16 = false;
            c16 = 17;
        }
        Rect rect = new Rect(0, 0, i3, i16);
        if (c16 == 17) {
            rect.offset((i17 - i3) / 2, (i18 - i16) / 2);
        } else if (c16 == '0' && z16) {
            rect.offset(((int) (i17 - (i3 * f16))) / 2, 0);
        }
        return rect;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if (r13 < (r15 * 1.5f)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (r13 <= (r15 * 1.5f)) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Rect c(int i3, int i16, int i17, int i18) {
        int i19;
        int i26 = (i16 * i17) / i3;
        char c16 = '0';
        if (i3 >= i17) {
            if (i18 < i26) {
                float f16 = i18;
                if ((1.5f * f16 < i26 || i26 <= i18) && i26 > i18 * 1.5d) {
                    i18 = (int) (f16 / (i17 / i3));
                    i19 = i3;
                }
            }
            i19 = 0;
            i18 = 0;
            c16 = 17;
        } else {
            if (i16 >= i18) {
                if (i16 > i18) {
                }
            }
            i19 = 0;
            i18 = 0;
            c16 = 17;
        }
        if (c16 != 17) {
            i3 = i19;
            i16 = i18;
        }
        return new Rect(0, 0, i3, i16);
    }

    public static Rect d(int i3, int i16, int i17, int i18) {
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        float f16 = (i3 * 1.0f) / i16;
        if (i3 < i16) {
            rect.right = i17;
            rect.bottom = (int) ((i17 * 1.0f) / f16);
        } else if (i3 >= i16) {
            rect.bottom = i18;
            rect.right = (int) (i18 * f16);
        }
        return rect;
    }

    public static float e(int i3, int i16) {
        float f16 = i3;
        if (f16 <= 641.0f && i16 <= 641.0f) {
            return 1.0f;
        }
        return Math.min(641.0f / f16, 641.0f / i16);
    }

    public static void f(Rect rect, float f16) {
        rect.left = (int) (rect.left * f16);
        rect.right = (int) (rect.right * f16);
        rect.top = (int) (rect.top * f16);
        rect.bottom = (int) (f16 * rect.bottom);
    }
}
