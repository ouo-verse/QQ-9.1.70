package com.tencent.hippy.qq.adapter;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mtt.hippy.adapter.device.DefaultDeviceAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQDeviceAdapter extends DefaultDeviceAdapter {
    public static final String TAG = "HippyQQDeviceAdapter";

    private double getNavigationBarHeight(Context context, double d16) {
        String str = Build.BRAND;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[getNavigationBarHeight], srcValue" + d16);
        }
        if ("OPPO".equalsIgnoreCase(str)) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
            int i3 = point.y + statusBarHeight;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, ",display:" + point.y + ",real:" + point2.y + ",statusBar:" + statusBarHeight + ",visualH:" + i3);
            }
            int i16 = point.y;
            int i17 = point2.y;
            if (i16 == i17 || i3 >= i17) {
                return 0.0d;
            }
        }
        return d16;
    }

    private void setFontCustomMetrics(HippyMap hippyMap) {
        DisplayMetrics displayMetrics = FontSettingManager.customMetrics;
        hippyMap.pushDouble("scale", displayMetrics.density);
        hippyMap.pushDouble("fontScale", displayMetrics.scaledDensity);
        hippyMap.pushDouble("densityDpi", displayMetrics.densityDpi);
    }

    @Override // com.tencent.mtt.hippy.adapter.device.DefaultDeviceAdapter, com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter
    public void reviseDimensionIfNeed(Context context, HippyMap hippyMap, boolean z16, boolean z17) {
        if (hippyMap != null) {
            try {
                HippyMap map = hippyMap.getMap("screenPhysicalPixels");
                if (map == null) {
                    return;
                }
                double d16 = map.getDouble("navigationBarHeight");
                double navigationBarHeight = getNavigationBarHeight(context, d16);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "navigBarValue:" + d16 + ",newNavigBarValue:" + navigationBarHeight);
                }
                if (d16 != navigationBarHeight) {
                    map.pushDouble("navigationBarHeight", navigationBarHeight);
                }
                setFontCustomMetrics(map);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }
}
