package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAudioPanelUtils extends QRouteApi {
    public static final int AUDIO_PANEL_CHANGE_VOICE = 3;
    public static final int AUDIO_PANEL_INPUT = 4;
    public static final int AUDIO_PANEL_PRESS_TO_SPEAK = 1;
    public static final int AUDIO_PANEL_RECORDER = 2;
    public static final int AUDIO_PANEL_RED_PACKET = 5;
    public static final int AUDIO_PANEL_UNKNOWN = 0;

    String getTimeStrByMillis(double d16);

    int getTitleBarHeight(Context context);

    int getVolumeLevel(int i3);
}
