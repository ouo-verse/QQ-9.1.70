package com.tencent.mobileqq.util;

import android.view.SurfaceView;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cs {
    public static void a(SurfaceView surfaceView, int i3, int i16, int i17, int i18) {
        if (surfaceView == null) {
            QLog.e("SurfaceViewUtil", 2, "SurfaceViewUtil resetLayoutParams error: surfaceView==null");
            return;
        }
        if (i16 > 0 && i3 > 0 && i17 > 0 && i18 > 0) {
            float f16 = i16;
            float f17 = i3;
            if (f16 / f17 > i18 / i17) {
                int i19 = (int) ((f16 - ((int) ((f17 * r8) / r7))) / 2.0f);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, i19, 0, i19);
                surfaceView.setLayoutParams(layoutParams);
                return;
            }
            int i26 = (int) ((f17 - ((int) ((f16 * r7) / r8))) / 2.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.setMargins(i26, 0, i26, 0);
            surfaceView.setLayoutParams(layoutParams2);
            return;
        }
        QLog.e("SurfaceViewUtil", 2, "SurfaceViewUtil resetLayoutParams error: width height <= 0");
    }
}
