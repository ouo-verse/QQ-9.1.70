package com.tencent.ditto.widget.text;

import android.annotation.TargetApi;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StaticLayoutWithMaxLines {
    private static final boolean DEG = false;
    private static final String TAG = "StaticLayoutWithMaxLines";
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_FIRST_STRONG_LTR = "FIRSTSTRONG_LTR";
    private static Constructor<StaticLayout> sConstructor;
    private static Object[] sConstructorArgs;
    private static boolean sInitialized;
    private static Object sTextDirection;

    public static synchronized StaticLayout create(CharSequence charSequence, int i3, int i16, TextPaint textPaint, int i17, Layout.Alignment alignment, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i18, int i19) {
        synchronized (StaticLayoutWithMaxLines.class) {
            try {
                try {
                    try {
                        try {
                            return StaticLayout.Builder.obtain(charSequence, i3, i16, textPaint, i17).setAlignment(alignment).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(f17, f16).setIncludePad(z16).setEllipsizedWidth(i18).setEllipsize(truncateAt).setMaxLines(i19).build();
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            return new StaticLayout(charSequence, textPaint, i17, alignment, f16, f17, z16);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        e.printStackTrace();
                        return new StaticLayout(charSequence, textPaint, i17, alignment, f16, f17, z16);
                    }
                } catch (Exception e18) {
                    e = e18;
                    e.printStackTrace();
                    return new StaticLayout(charSequence, textPaint, i17, alignment, f16, f17, z16);
                }
            } catch (Exception e19) {
                e = e19;
            }
        }
    }

    @TargetApi(18)
    public static synchronized void ensureInitialized() {
        synchronized (StaticLayoutWithMaxLines.class) {
            if (sInitialized) {
                return;
            }
            try {
                try {
                    try {
                        sTextDirection = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        Class cls = Integer.TYPE;
                        Class cls2 = Float.TYPE;
                        Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                        sConstructor = declaredConstructor;
                        declaredConstructor.setAccessible(true);
                        sConstructorArgs = new Object[13];
                    } catch (ClassNotFoundException e16) {
                        Log.e(TAG, "TextDirectionHeuristic class not found.", e16);
                    } catch (IllegalAccessException e17) {
                        Log.e(TAG, "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", e17);
                    }
                } catch (NoSuchFieldException e18) {
                    Log.e(TAG, "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", e18);
                } catch (NoSuchMethodException e19) {
                    Log.e(TAG, "StaticLayout constructor with max lines not found.", e19);
                }
            } finally {
            }
        }
    }

    public static boolean isSupported() {
        ensureInitialized();
        if (sConstructor != null) {
            return true;
        }
        return false;
    }
}
