package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import androidx.annotation.MainThread;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IGamepadController {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class StreamQualityCfg {
        public boolean pEnabled;
        public boolean pForVip;
        public int pId;
        public boolean pIsSelected;
        public String pName;
    }

    int getConfigValue(int i3);

    int getGameType();

    boolean isSupportMonitorConfig();

    boolean isSupportTGPAConfig();

    void loadGameSceneForSDKScene(int i3, boolean z16);

    boolean loadGameSceneFromMonitor(int i3, String str, boolean z16);

    boolean loadGameSceneFromTGPA(String str);

    boolean loadKeyMapConfig(String str, String str2);

    void onFirstFrameRendered();

    void onLoginView(boolean z16);

    void registerKeyMapListener(IKeyMapListener iKeyMapListener);

    void requestDoubleVirtualGamepad();

    void requestVirtualGamepad();

    @MainThread
    void setKeyMapViewVisibility(boolean z16);

    void setKeyTrackMenuEnabled(boolean z16);

    void setPlayStreamQualityToVGamepad(int i3);

    void unregisterKeyMapListener();

    boolean updateStreamQualityCfgsToVGamepad(int i3, List<StreamQualityCfg> list);

    void updateWebRTCSDK(WebRTCSDK webRTCSDK);
}
