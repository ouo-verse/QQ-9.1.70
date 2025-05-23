package com.tencent.fastertextview.util;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.widget.FasterTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static Layout.Alignment a(int i3) {
        int i16 = i3 & 8388615;
        if (i16 != 1) {
            if (i16 != 3) {
                if (i16 != 5) {
                    if (i16 != 8388613) {
                        return Layout.Alignment.ALIGN_NORMAL;
                    }
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return d();
            }
            return c();
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private static Typeface b(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return Typeface.MONOSPACE;
            }
            return Typeface.SERIF;
        }
        return Typeface.SANS_SERIF;
    }

    private static Layout.Alignment c() {
        Layout.Alignment[] values = Layout.Alignment.values();
        if (values.length == 5) {
            return values[3];
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    private static Layout.Alignment d() {
        Layout.Alignment[] values = Layout.Alignment.values();
        if (values.length == 5) {
            return values[4];
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public static Layout.Alignment e(int i3, int i16, int i17) {
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            return Layout.Alignment.ALIGN_NORMAL;
                        }
                        if (i17 == 1) {
                            return c();
                        }
                        return d();
                    }
                    if (i17 == 1) {
                        return d();
                    }
                    return c();
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return a(i16);
    }

    private static void f(FasterTextView fasterTextView, Typeface typeface, int i3, int i16) {
        boolean z16;
        Typeface create;
        if (i16 < 0) {
            fasterTextView.setTypeface(typeface, i3);
            return;
        }
        if (Build.VERSION.SDK_INT <= 27) {
            fasterTextView.setTypeface(typeface, i3);
            return;
        }
        int min = Math.min(1000, i16);
        if ((i3 & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        create = Typeface.create(typeface, min, z16);
        fasterTextView.setTypeface(create);
    }

    public static void g(FasterTextView fasterTextView, int i3, String str, int i16, int i17, int i18) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Typeface b16;
        boolean z26 = false;
        if (str != null) {
            f(fasterTextView, Typeface.create(str, 0), i17, i18);
            return;
        }
        int i19 = i3 & 4095;
        if (i19 == 129) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i19 == 225) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (i19 == 18) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z16 && !z17 && !z18) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (z19 || i19 == 129) {
            z26 = true;
        }
        if (z26) {
            b16 = Typeface.MONOSPACE;
        } else {
            b16 = b(i16);
        }
        f(fasterTextView, b16, i17, i18);
    }
}
