package com.tencent.gamematrix.gmcg.sdk.pxlw;

import android.app.Activity;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayPerfInfo;

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

    boolean isSrOn();

    void onLoad(Activity activity);

    void onPxlwPerfUpdated(GmCgPlayPerfInfo gmCgPlayPerfInfo);

    void onUnload();

    void setFrcFps(int i3);

    void turnFrcStatic(boolean z16, int i3);

    void turnFrcStatic(boolean z16, boolean z17);

    void turnOffSr();

    void turnOnSr(PxlwSrConfig pxlwSrConfig, boolean z16);
}
