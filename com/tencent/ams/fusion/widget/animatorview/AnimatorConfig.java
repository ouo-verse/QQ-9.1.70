package com.tencent.ams.fusion.widget.animatorview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AnimatorConfig {
    static IPatchRedirector $redirector_;
    private static boolean sEnableHardware;
    private static boolean sIsGrayModeOn;
    private static LogSupport sLogSupport;
    private static int sMaxFrameRate;
    private static boolean sRebuildRenderOnceSurfaceDestroyed;
    private static boolean sRunOnOldRenderer;

    @RendererVersion
    private static int sRunRendererVersion;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface LogSupport {
        void d(String str, String str2);

        void e(String str, String str2, Throwable th5);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface RendererVersion {
        public static final int V1 = 1;
        public static final int V2 = 2;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sRunOnOldRenderer = false;
        sEnableHardware = false;
        sIsGrayModeOn = false;
        sRebuildRenderOnceSurfaceDestroyed = false;
        sRunRendererVersion = 1;
    }

    public AnimatorConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static LogSupport getLogSupport() {
        return sLogSupport;
    }

    public static int getMaxFrameRate() {
        return sMaxFrameRate;
    }

    public static int getRunRendererVersion() {
        return sRunRendererVersion;
    }

    public static boolean isEnableHardware() {
        return sEnableHardware;
    }

    public static boolean isGrayModeOn() {
        return sIsGrayModeOn;
    }

    public static boolean isRebuildRenderOnceSurfaceDestroyed() {
        return sRebuildRenderOnceSurfaceDestroyed;
    }

    public static boolean isRunOnOldRenderer() {
        return sRunOnOldRenderer;
    }

    public static void setEnableHardware(boolean z16) {
        sEnableHardware = z16;
    }

    public static void setGrayModeOn(boolean z16) {
        sIsGrayModeOn = z16;
    }

    public static void setLogSupport(LogSupport logSupport) {
        sLogSupport = logSupport;
    }

    public static void setMaxFrameRate(int i3) {
        sMaxFrameRate = i3;
    }

    public static void setRebuildRenderOnceSurfaceDestroyed(boolean z16) {
        sRebuildRenderOnceSurfaceDestroyed = z16;
    }

    public static void setRunOnOldRenderer(boolean z16) {
        sRunOnOldRenderer = z16;
    }

    public static void setRunRendererVersion(@RendererVersion int i3) {
        sRunRendererVersion = i3;
    }
}
