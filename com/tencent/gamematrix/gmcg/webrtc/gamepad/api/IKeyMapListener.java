package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import android.graphics.PointF;
import androidx.annotation.MainThread;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.SceneCanvas;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IKeyMapListener {
    boolean getMouseViewPos(PointF pointF);

    @MainThread
    void onChooseItemClicked();

    void onGameInfo(boolean z16, int i3);

    void onGameLoginResult(String str, int i3, boolean z16, int i16);

    @MainThread
    void onKeyMapConfigChanged(SceneCanvas sceneCanvas);

    @MainThread
    void onKeyMapModeChanged(SceneCanvas sceneCanvas);

    @MainThread
    void onKeyMapTrackJoy(int i3, int i16, float f16, float f17);

    @MainThread
    void onKeyMapTrackKey(int i3, int i16, float f16, float f17);

    @MainThread
    void onKeyMapTrackKey(int i3, KeyItem keyItem, float f16, float f17);

    @MainThread
    void onKeyMapTrigger(int i3, KeyItem keyItem);

    @MainThread
    void onMouseViewFollowJoystick(float f16, float f17, PointF pointF);

    @MainThread
    void onVirtualGamepadMessage(int i3, int i16, int i17, int i18);

    @MainThread
    void onVirtualGamepadMessage(int i3, int i16, String str);
}
