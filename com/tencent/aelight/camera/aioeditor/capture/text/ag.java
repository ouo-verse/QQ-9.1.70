package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import java.lang.reflect.Constructor;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ag {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f66970a;

    /* renamed from: b, reason: collision with root package name */
    private static Constructor<StaticLayout> f66971b;

    /* renamed from: c, reason: collision with root package name */
    private static Object[] f66972c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f66973d;

    public static synchronized StaticLayout a(CharSequence charSequence, int i3, int i16, TextPaint textPaint, int i17, Layout.Alignment alignment, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i18, int i19) {
        synchronized (ag.class) {
            if (AppSetting.m() > 28) {
                return StaticLayout.Builder.obtain(charSequence, i3, i16, textPaint, i17).setAlignment(alignment).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(f17, f16).setIncludePad(z16).setEllipsizedWidth(i18).setEllipsize(truncateAt).setMaxLines(i19).build();
            }
            b();
            try {
                Object[] objArr = f66972c;
                objArr[0] = charSequence;
                objArr[1] = Integer.valueOf(i3);
                f66972c[2] = Integer.valueOf(i16);
                Object[] objArr2 = f66972c;
                objArr2[3] = textPaint;
                objArr2[4] = Integer.valueOf(i17);
                Object[] objArr3 = f66972c;
                objArr3[5] = alignment;
                objArr3[6] = f66973d;
                objArr3[7] = Float.valueOf(f16);
                f66972c[8] = Float.valueOf(f17);
                f66972c[9] = Boolean.valueOf(z16);
                Object[] objArr4 = f66972c;
                objArr4[10] = truncateAt;
                objArr4[11] = Integer.valueOf(i18);
                f66972c[12] = Integer.valueOf(i19);
                return f66971b.newInstance(f66972c);
            } catch (Exception e16) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e16);
            }
        }
    }

    public static synchronized void b() {
        synchronized (ag.class) {
            if (f66970a) {
                return;
            }
            try {
                try {
                    try {
                        f66973d = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        Class cls = Integer.TYPE;
                        Class cls2 = Float.TYPE;
                        Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                        f66971b = declaredConstructor;
                        declaredConstructor.setAccessible(true);
                        f66972c = new Object[13];
                    } catch (ClassNotFoundException e16) {
                        Log.e("StaticLayoutWithMaxLines", "TextDirectionHeuristic class not found.", e16);
                    } catch (NoSuchMethodException e17) {
                        Log.e("StaticLayoutWithMaxLines", "StaticLayout constructor with max lines not found.", e17);
                    }
                } catch (IllegalAccessException e18) {
                    Log.e("StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", e18);
                } catch (NoSuchFieldException e19) {
                    Log.e("StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", e19);
                }
            } finally {
                f66970a = true;
            }
        }
    }
}
