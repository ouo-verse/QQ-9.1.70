package com.tencent.richframework.compat.immersive;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.richframework.compat.RFWOSUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\t\u001a\u00020\u0002H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/compat/immersive/AutoImmersiveConfig;", "", "", "isEnableAutoStatusBarTextColor", "isEnableAdjustNavigationBar", "isIgnoreAdjustNavigationBar", "isOpenFrequencyControl", "", "getLightThreshold", "isOpenNavigationBarImmersive", "<init>", "()V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class AutoImmersiveConfig {

    @NotNull
    public static final AutoImmersiveConfig INSTANCE = new AutoImmersiveConfig();

    AutoImmersiveConfig() {
    }

    @JvmStatic
    public static final float getLightThreshold() {
        String configValue = RFWConfig.getConfigValue("AUTO_ADJUST_OPEN_SWITCH", "70");
        try {
            if (TextUtils.isEmpty(configValue)) {
                return 0.7f;
            }
            return Integer.parseInt(configValue) / 100.0f;
        } catch (NumberFormatException unused) {
            RFWLog.e("RFWAutoImmersiveConfig", RFWLog.USR, "getLightThreshold is fail, value = ", configValue);
            return 0.7f;
        }
    }

    @JvmStatic
    public static final boolean isEnableAdjustNavigationBar() {
        if (Build.VERSION.SDK_INT >= 26 && !INSTANCE.isIgnoreAdjustNavigationBar()) {
            return RFWConfig.getConfigValue("AUTO_ADJUST_NAVIGATION_BAR", true);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isEnableAutoStatusBarTextColor() {
        if (!RFWApplication.isPublicVersion() || RFWConfig.getConfigValue("AUTO_ADJUST_STATUS_BAR_TEXT_COLOR", true)) {
            return true;
        }
        return false;
    }

    private final boolean isIgnoreAdjustNavigationBar() {
        if (Build.VERSION.SDK_INT == 30 && RFWOSUtils.isMIUI()) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean isOpenFrequencyControl() {
        return RFWConfig.getConfigValue("FREQUENCY_CONTROL_CAN_LAN_SWITCH", true);
    }

    @JvmStatic
    public static final boolean isOpenNavigationBarImmersive() {
        return RFWConfig.getConfigValue("open_navigation_bar_immersive_switch", true);
    }
}
