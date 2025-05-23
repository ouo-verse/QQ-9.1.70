package com.qzone.reborn.qzmoment.view.blur;

import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c {
    public static void a(View view, int i3) {
        if (view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(i3);
        view.startAnimation(alphaAnimation);
    }

    public static void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            RFWThreadManager.getUIHandler().post(runnable);
        }
    }

    public static boolean b(int... iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == 0) {
                return true;
            }
        }
        return false;
    }
}
