package com.tencent.luggage.wxa.ab;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import java.lang.reflect.Constructor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Constructor f121035a;

    /* renamed from: b, reason: collision with root package name */
    public static Object f121036b;

    public static synchronized Object a() {
        synchronized (a.class) {
            Object obj = f121036b;
            if (obj != null) {
                return obj;
            }
            try {
                try {
                    TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    f121036b = textDirectionHeuristic;
                    return textDirectionHeuristic;
                } catch (ClassNotFoundException e16) {
                    e = e16;
                    w.a("StaticTextView.StaticLayoutWithMaxLines", e, "TextDirectionHeuristic class not found.", new Object[0]);
                    w.f("StaticTextView.StaticLayoutWithMaxLines", "#tryGetTextDirection fail, error: " + e.getMessage());
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e17) {
                    e = e17;
                    w.a("StaticTextView.StaticLayoutWithMaxLines", e, "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", new Object[0]);
                    w.f("StaticTextView.StaticLayoutWithMaxLines", "#tryGetTextDirection fail, error: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            } catch (NoSuchFieldException e18) {
                e = e18;
                w.a("StaticTextView.StaticLayoutWithMaxLines", e, "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", new Object[0]);
                w.f("StaticTextView.StaticLayoutWithMaxLines", "#tryGetTextDirection fail, error: " + e.getMessage());
                throw new RuntimeException(e);
            } catch (Throwable th5) {
                e = th5;
                w.a("StaticTextView.StaticLayoutWithMaxLines", e, "Other error.", new Object[0]);
                w.f("StaticTextView.StaticLayoutWithMaxLines", "#tryGetTextDirection fail, error: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static synchronized Constructor c() {
        synchronized (a.class) {
            Constructor constructor = f121035a;
            if (constructor != null) {
                return constructor;
            }
            if (b()) {
                return null;
            }
            try {
                try {
                    Class cls = Integer.TYPE;
                    Class cls2 = Float.TYPE;
                    Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                    f121035a = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                    th = null;
                } catch (ClassNotFoundException e16) {
                    th = e16;
                    w.a("StaticTextView.StaticLayoutWithMaxLines", th, "TextDirectionHeuristic class not found.", new Object[0]);
                } catch (NoSuchMethodException e17) {
                    th = e17;
                    w.a("StaticTextView.StaticLayoutWithMaxLines", th, "StaticLayout constructor with max lines not found.", new Object[0]);
                }
            } catch (Throwable th5) {
                th = th5;
                w.a("StaticTextView.StaticLayoutWithMaxLines", th, "Other error.", new Object[0]);
            }
            if (th != null) {
                w.f("StaticTextView.StaticLayoutWithMaxLines", "create StaticLayout constructor fail: " + th.getMessage());
                w.f("StaticTextView.StaticLayoutWithMaxLines", "use builtin StaticLayout.Builder as fallback!");
                return null;
            }
            return f121035a;
        }
    }

    public static synchronized StaticLayout b(CharSequence charSequence, int i3, int i16, TextPaint textPaint, int i17, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i18, int i19) {
        synchronized (a.class) {
            try {
                Object a16 = a();
                Constructor c16 = c();
                if (c16 == null) {
                    return a(charSequence, i3, i16, textPaint, i17, alignment, (TextDirectionHeuristic) a16, f16, f17, z16, truncateAt, i18, i19);
                }
                return (StaticLayout) c16.newInstance(charSequence, Integer.valueOf(i3), Integer.valueOf(i16), textPaint, Integer.valueOf(i17), alignment, textDirectionHeuristic, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), truncateAt, Integer.valueOf(i18), Integer.valueOf(i19));
            } catch (Exception e16) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e16.getCause());
            }
        }
    }

    public static StaticLayout a(CharSequence charSequence, int i3, int i16, TextPaint textPaint, int i17, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i18, int i19) {
        return StaticLayout.Builder.obtain(charSequence, i3, i16, textPaint, i17).setAlignment(alignment).setTextDirection(textDirectionHeuristic).setLineSpacing(f17, f16).setIncludePad(z16).setEllipsizedWidth(i18).setEllipsize(truncateAt).setMaxLines(i19).build();
    }

    public static synchronized StaticLayout a(CharSequence charSequence, int i3, int i16, TextPaint textPaint, int i17, Layout.Alignment alignment, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i18, int i19) {
        synchronized (a.class) {
            try {
                Object a16 = a();
                Constructor c16 = c();
                if (c16 == null) {
                    return a(charSequence, i3, i16, textPaint, i17, alignment, (TextDirectionHeuristic) a16, f16, f17, z16, truncateAt, i18, i19);
                }
                return (StaticLayout) c16.newInstance(charSequence, Integer.valueOf(i3), Integer.valueOf(i16), textPaint, Integer.valueOf(i17), alignment, a16, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), truncateAt, Integer.valueOf(i18), Integer.valueOf(i19));
            } catch (Exception e16) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e16.getCause());
            }
        }
    }
}
