package com.tencent.android.androidbypass.enhance;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    @IntRange(from = 0, to = 255)
    public static int a(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        return (int) (f16 * 255.0f);
    }
}
