package com.tencent.aekit.openrender;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEOpenRenderConfig {
    static IPatchRedirector $redirector_ = null;
    public static boolean DEBUG = false;
    public static final float[] EMPTY_POSITIONS;
    public static final float[] EMPTY_POSITIONS_TRIANGLES;
    public static boolean GL_DEBUG = false;
    public static final float[] ORIGIN_POSITION_COORDS;
    public static final float[] ORIGIN_TEX_COORDS;
    public static final float[] ORIGIN_TEX_COORDS_REVERSE;
    public static final float[] ORIGIN_TEX_COORDS_TRIANGLES;
    public static final int RENDER_MODE_GLFINISH = 0;
    public static final int RENDER_MODE_GLFLUSH = 1;
    public static final int RENDER_MODE_GLNONE = 2;
    private static boolean enableLog;
    public static int glMode;
    private static boolean strictMode;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class DRAW_MODE {
        private static final /* synthetic */ DRAW_MODE[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DRAW_MODE LINES;
        public static final DRAW_MODE LINES_STRIP;
        public static final DRAW_MODE POINTS;
        public static final DRAW_MODE TRIANGLES;
        public static final DRAW_MODE TRIANGLE_FAN;
        public static final DRAW_MODE TRIANGLE_STRIP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12092);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            DRAW_MODE draw_mode = new DRAW_MODE("TRIANGLE_STRIP", 0);
            TRIANGLE_STRIP = draw_mode;
            DRAW_MODE draw_mode2 = new DRAW_MODE("TRIANGLES", 1);
            TRIANGLES = draw_mode2;
            DRAW_MODE draw_mode3 = new DRAW_MODE("TRIANGLE_FAN", 2);
            TRIANGLE_FAN = draw_mode3;
            DRAW_MODE draw_mode4 = new DRAW_MODE("LINES", 3);
            LINES = draw_mode4;
            DRAW_MODE draw_mode5 = new DRAW_MODE("LINES_STRIP", 4);
            LINES_STRIP = draw_mode5;
            DRAW_MODE draw_mode6 = new DRAW_MODE("POINTS", 5);
            POINTS = draw_mode6;
            $VALUES = new DRAW_MODE[]{draw_mode, draw_mode2, draw_mode3, draw_mode4, draw_mode5, draw_mode6};
        }

        DRAW_MODE(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static DRAW_MODE valueOf(String str) {
            return (DRAW_MODE) Enum.valueOf(DRAW_MODE.class, str);
        }

        public static DRAW_MODE[] values() {
            return (DRAW_MODE[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class StrictModeCheckFailedException extends RuntimeException {
        static IPatchRedirector $redirector_ = null;
        private static final String KEY = "[StrictMode] ";

        public StrictModeCheckFailedException(String str) {
            super(KEY + str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EMPTY_POSITIONS = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        EMPTY_POSITIONS_TRIANGLES = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        ORIGIN_POSITION_COORDS = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
        ORIGIN_TEX_COORDS = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        ORIGIN_TEX_COORDS_REVERSE = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        ORIGIN_TEX_COORDS_TRIANGLES = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        glMode = 1;
        DEBUG = false;
        GL_DEBUG = false;
        enableLog = false;
        strictMode = false;
    }

    public AEOpenRenderConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkStrictMode(boolean z16, String str) {
        if (!strictMode || z16) {
        } else {
            throw new StrictModeCheckFailedException(str);
        }
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    public static boolean isStrictMode() {
        return strictMode;
    }

    public static void setEnableLog(boolean z16) {
        enableLog = z16;
    }

    public static void setEnableStrictMode(boolean z16) {
        strictMode = z16;
    }
}
