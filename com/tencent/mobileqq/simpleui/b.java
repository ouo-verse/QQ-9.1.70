package com.tencent.mobileqq.simpleui;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    protected static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static SystemBarCompact b(SystemBarCompact systemBarCompact, Activity activity, boolean z16, boolean z17) {
        if (activity == null || ImmersiveUtils.isSupporImmersive() == 0 || !c()) {
            return null;
        }
        int simpleUiBgColor = SimpleUIUtil.getSimpleUiBgColor();
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            a(activity);
            ImmersiveUtils.clearCoverForStatus(activity.getWindow(), true);
            SystemBarCompact systemBarCompact2 = new SystemBarCompact(activity, !z16, simpleUiBgColor);
            systemBarCompact2.init();
            ImmersiveUtils.setStatusTextColor(z17, activity.getWindow());
            return systemBarCompact2;
        }
        int i3 = 0;
        if (systemBarCompact == null) {
            a(activity);
            ImmersiveUtils.clearCoverForStatus(activity.getWindow(), true);
            if (z17) {
                i3 = SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M;
            }
            SystemBarCompact systemBarCompact3 = new SystemBarCompact(activity, true, i3);
            systemBarCompact3.init();
            return systemBarCompact3;
        }
        if (z17) {
            i3 = SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M;
        }
        systemBarCompact.setStatusBarColor(i3);
        return systemBarCompact;
    }

    public static final boolean c() {
        if (SimpleUIUtil.getSimpleUISwitch() && !QQTheme.isNowThemeIsNightForQzone() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SIMPLEUI, true)) {
            return true;
        }
        return false;
    }
}
