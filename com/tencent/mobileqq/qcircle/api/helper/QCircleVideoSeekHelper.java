package com.tencent.mobileqq.qcircle.api.helper;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.b;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qcircle.cooperation.config.debug.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.util.AppSetting;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleVideoSeekHelper {
    private static final String TAG = "QCircleVideoSeekHelper";

    public static QCircleSeekAreaFrameLayout addSeekView(View view, int i3) {
        if (!(view instanceof FrameLayout)) {
            QLog.d(TAG, 1, "[addSeekView] current view not is frame layout, end flow.");
            return null;
        }
        if (i3 == 0) {
            i3 = ViewUtils.dip2px(50.0f);
        }
        FrameLayout frameLayout = (FrameLayout) view;
        QCircleSeekAreaFrameLayout findSeekArea = findSeekArea(view);
        if (findSeekArea != null) {
            findSeekArea.setVisibility(0);
            setSeekBarTestBackGround(findSeekArea);
            SimpleEventBus.getInstance().registerReceiver(findSeekArea);
            QLog.d(TAG, 1, "seek area hasAdd alder");
            return findSeekArea;
        }
        QCircleSeekAreaFrameLayout qCircleSeekAreaFrameLayout = new QCircleSeekAreaFrameLayout(view.getContext());
        qCircleSeekAreaFrameLayout.setId(R.id.f33020vb);
        setSeekBarTestBackGround(qCircleSeekAreaFrameLayout);
        SimpleEventBus.getInstance().registerReceiver(qCircleSeekAreaFrameLayout);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (i3 * 3) / 2);
        layoutParams.gravity = 80;
        try {
            frameLayout.addView(qCircleSeekAreaFrameLayout, layoutParams);
            b.f276860a.a(qCircleSeekAreaFrameLayout, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        } catch (Throwable th5) {
            if (!AppSetting.isDebugVersion()) {
                QLog.e(TAG, 1, "error: ", th5);
            } else {
                throw th5;
            }
        }
        return qCircleSeekAreaFrameLayout;
    }

    private static QCircleSeekAreaFrameLayout findSeekArea(View view) {
        if (!(view instanceof FrameLayout)) {
            return null;
        }
        return (QCircleSeekAreaFrameLayout) ((FrameLayout) view).findViewById(R.id.f33020vb);
    }

    public static void removeSeekArea(View view) {
        QCircleSeekAreaFrameLayout findSeekArea = findSeekArea(view);
        if (findSeekArea == null) {
            return;
        }
        findSeekArea.setVisibility(8);
        findSeekArea.setPreClickListener(null);
        SimpleEventBus.getInstance().registerReceiver(findSeekArea);
    }

    private static void setSeekBarTestBackGround(QCircleSeekAreaFrameLayout qCircleSeekAreaFrameLayout) {
        if (c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_SEEK_BAR_SHOW, 0)) {
            qCircleSeekAreaFrameLayout.setBackgroundColor(Color.parseColor("#33eb4e3d"));
        } else {
            qCircleSeekAreaFrameLayout.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        }
    }
}
