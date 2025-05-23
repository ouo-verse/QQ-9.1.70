package com.tencent.gamematrix.gmcg.base.pxlw;

import android.app.Activity;

/* loaded from: classes6.dex */
public interface PixelWorks {
    public static final int FRC_X7_SINGLE_CH_IMV = 1;
    public static final int RAM_STATE_ALLOW_FRAME_INTERP = 11;
    public static final int RAM_STATE_CLOSE_FRAME_INTERP = 1010;
    public static final int RAM_STATE_ENTER_FRAME_INTERP = 3;
    public static final int RAM_STATE_EXIT_FRAME_INTERP = 2;
    public static final int RAM_STATE_GENER_ERROR = -1;
    public static final int RAM_STATE_HYPERTHERMIA = 131076;
    public static final int RAM_STATE_LOW_BATTERY = 131080;
    public static final int RAM_STATE_NOT_ALLOW_FRAME_INTERP = 10;
    public static final int RAM_STATE_NOT_INIT = -2;
    public static final int RAM_STATE_PARAM_ERROR = -3;

    boolean isFrcOn();

    boolean isHardwareSupport();

    boolean isServiceSupport();

    boolean isSrOn();

    boolean isSupportFrc();

    boolean isSupportSr();

    void load(Activity activity);

    void onPxlwFpsUpdated(int i3);

    void setFrcFps(int i3);

    void setSrSize(int i3, int i16);

    void turnFrcStatic(boolean z16, boolean z17);

    void turnOffSr();

    void turnOnSr(boolean z16);

    void unload();
}
