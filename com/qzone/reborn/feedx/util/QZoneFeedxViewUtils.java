package com.qzone.reborn.feedx.util;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.qzone.util.ar;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxViewUtils {
    public static int b(Context context) {
        return ImmersiveUtils.getStatusBarHeight(context) + ef.d.b(50);
    }

    public static int e(Context context) {
        return ImmersiveUtils.getStatusBarHeight(context) + ef.d.b(50);
    }

    public static int f(QZoneBlankStateView qZoneBlankStateView) {
        int k3 = ar.k();
        if (qZoneBlankStateView == null) {
            return k3;
        }
        return (k3 - ((int) (ar.l() * 0.74666667f))) - ar.d(92.0f);
    }

    public static void a(final View view, final int i3, final int i16, final int i17, final int i18) {
        if (view == null || !(view.getParent() instanceof View)) {
            return;
        }
        ((View) view.getParent()).post(new Runnable() { // from class: com.qzone.reborn.feedx.util.QZoneFeedxViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view.setEnabled(true);
                view.getHitRect(rect);
                rect.top -= i3;
                rect.bottom += i16;
                rect.left -= i17;
                rect.right += i18;
                if (QLog.isColorLevel()) {
                    QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom + " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
                }
                TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                if (view.getParent() instanceof View) {
                    ((View) view.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    public static int c() {
        return ef.d.b(34);
    }

    public static int d() {
        return ef.d.b(48);
    }

    public static int g(Context context, boolean z16) {
        int M0;
        if (z16) {
            M0 = com.qzone.reborn.configx.g.f53821a.b().N0();
        } else {
            M0 = com.qzone.reborn.configx.g.f53821a.b().M0();
        }
        return pl.a.f426446a.l(context) - ImmersiveUtils.dpToPx(M0);
    }

    public static boolean h(View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.bottom > 0 && rect.right > 0 && rect.top < displayMetrics.heightPixels && rect.left < displayMetrics.widthPixels;
    }

    public static boolean i(Context context) {
        if (context == null) {
            return false;
        }
        return (((FontSettingManager.getFontLevel() > 18.0f ? 1 : (FontSettingManager.getFontLevel() == 18.0f ? 0 : -1)) >= 0) || ((ar.j() > ((float) com.qzone.reborn.configx.g.f53821a.k().o()) ? 1 : (ar.j() == ((float) com.qzone.reborn.configx.g.f53821a.k().o()) ? 0 : -1)) > 0)) && !QZoneApiProxy.needShowQzoneFrame(context, MobileQQ.sMobileQQ.peekAppRuntime());
    }

    public static void j(CellTextView cellTextView, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        if (superFontInfo == null) {
            cellTextView.setShadowLayer(0, 0, 0, 0);
            cellTextView.setTextColorAnimation(null, 0);
            cellTextView.setGradientColor(null, null, null);
            return;
        }
        if ((superFontInfo.lSparkleFlag & 1) != 0) {
            cellTextView.setTextColor(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strTextColor));
        }
        if ((superFontInfo.lSparkleFlag & 2) != 0) {
            cellTextView.setShadowLayer(com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowBlurRadius), com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowOffsetX), com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowOffsetY), QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strShadowColor));
        } else {
            cellTextView.setShadowLayer(0, 0, 0, 0);
        }
        if ((superFontInfo.lSparkleFlag & 8) != 0 && (arrayList3 = superFontInfo.vecTextColorAnimation) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(superFontInfo.vecTextColorAnimation.size());
            int size = superFontInfo.vecTextColorAnimation.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecTextColorAnimation.get(i3))));
            }
            cellTextView.setTextColorAnimation(arrayList4, superFontInfo.iTextColorSpanTime * (size - 1));
        } else {
            cellTextView.setTextColorAnimation(null, 0);
        }
        if ((superFontInfo.lSparkleFlag & 4) != 0 && (arrayList = superFontInfo.vecGradientColor) != null && arrayList.size() >= 2 && (arrayList2 = superFontInfo.vecGradientPosition) != null && arrayList2.size() >= 2) {
            int size2 = superFontInfo.vecGradientColor.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecGradientColor.get(i16));
            }
            int size3 = superFontInfo.vecGradientPosition.size();
            float[] fArr = new float[size3];
            for (int i17 = 0; i17 < size3; i17++) {
                fArr[i17] = superFontInfo.vecGradientPosition.get(i17).floatValue();
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            int i18 = superFontInfo.iGradientDirection;
            if (i18 != 0) {
                if (i18 == 1) {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                } else if (i18 == 2) {
                    orientation = GradientDrawable.Orientation.TL_BR;
                } else if (i18 == 3) {
                    orientation = GradientDrawable.Orientation.BL_TR;
                }
            }
            cellTextView.setGradientColor(iArr, fArr, orientation);
            return;
        }
        cellTextView.setGradientColor(null, null, null);
    }
}
