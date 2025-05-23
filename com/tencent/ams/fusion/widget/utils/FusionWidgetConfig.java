package com.tencent.ams.fusion.widget.utils;

import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FusionWidgetConfig {
    static IPatchRedirector $redirector_;
    private static AsyncTaskExecutor mAsyncTaskExecutor;
    private static AppForegroundListener sAppForegroundListener;
    private static boolean sEnableAsyncDrawSlideTrack;
    private static boolean sEnableMockSensor;
    private static boolean sEnableNewSlideGestureView;
    private static float sFirstShakeSensorMaxValidValue;
    private static String sMockSensorConfig;
    private static float sOutDensity;
    private static float sOutDensityScale;
    private static float sShakeSensorMaxValidValue;
    private static int sShakeSensorValidStartTime;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AsyncTaskExecutor {
        void execute(Runnable runnable);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sOutDensityScale = 1.0f;
        sShakeSensorValidStartTime = 0;
        sShakeSensorMaxValidValue = 0.0f;
        sFirstShakeSensorMaxValidValue = 0.0f;
        sEnableMockSensor = false;
        sEnableAsyncDrawSlideTrack = false;
        sEnableNewSlideGestureView = false;
    }

    public FusionWidgetConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AppForegroundListener getAppForegroundListener() {
        return sAppForegroundListener;
    }

    public static AsyncTaskExecutor getAsyncTaskExecutor() {
        return mAsyncTaskExecutor;
    }

    public static float getFirstShakeSensorMaxValidValue() {
        return sFirstShakeSensorMaxValidValue;
    }

    public static String getMockSensorConfig() {
        return sMockSensorConfig;
    }

    public static float getOutDensity() {
        return sOutDensity;
    }

    public static float getOutDensityScale() {
        float f16 = sOutDensityScale;
        if (f16 == 0.0f) {
            return 1.0f;
        }
        return f16;
    }

    public static float getShakeSensorMaxValidValue() {
        return sShakeSensorMaxValidValue;
    }

    public static int getShakeSensorValidStartTime() {
        return sShakeSensorValidStartTime;
    }

    public static boolean isEnableAsyncDrawSlideTrack() {
        return sEnableAsyncDrawSlideTrack;
    }

    public static boolean isEnableMockSensor() {
        return sEnableMockSensor;
    }

    public static boolean isEnableNewSlideGestureView() {
        return sEnableNewSlideGestureView;
    }

    public static void setAppForegroundListener(AppForegroundListener appForegroundListener) {
        sAppForegroundListener = appForegroundListener;
    }

    public static void setAsyncTaskExecutor(AsyncTaskExecutor asyncTaskExecutor) {
        mAsyncTaskExecutor = asyncTaskExecutor;
    }

    public static void setEnableAsyncDrawSlideTrack(boolean z16) {
        sEnableAsyncDrawSlideTrack = z16;
    }

    public static void setEnableMockSensor(boolean z16) {
        sEnableMockSensor = z16;
    }

    public static void setEnableNewSlideGestureView(boolean z16) {
        sEnableNewSlideGestureView = z16;
    }

    public static void setFirstShakeSensorMaxValidValue(float f16) {
        sFirstShakeSensorMaxValidValue = f16;
    }

    public static void setLogSupport(AnimatorConfig.LogSupport logSupport) {
        AnimatorConfig.setLogSupport(logSupport);
    }

    public static void setMockSensorConfig(String str) {
        sMockSensorConfig = str;
    }

    public static void setOutDensity(float f16) {
        sOutDensity = f16;
    }

    public static void setOutDensityScale(float f16) {
        sOutDensityScale = f16;
    }

    public static void setShakeSensorMaxValidValue(float f16) {
        sShakeSensorMaxValidValue = f16;
    }

    public static void setShakeSensorValidStartTime(int i3) {
        sShakeSensorValidStartTime = i3;
    }
}
