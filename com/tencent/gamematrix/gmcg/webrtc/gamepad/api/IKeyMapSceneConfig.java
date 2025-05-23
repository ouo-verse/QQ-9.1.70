package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.JoyKeyCancelItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyChooseWindowItem;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IKeyMapSceneConfig {
    KeyItem findTouchButtonItem(int i3);

    ChooseWindowItem getChooseWindowItem(int i3);

    int getConfigSize(int i3);

    JoyKeyCancelItem getJoyKeyCancelItem(int i3);

    JoyPadItem getJoyPadItem(int i3);

    KeyItem getKeyItem(int i3);

    int getMapType();

    MoveItem getMoveItem(int i3);

    int getPrimarySceneId();

    String getSceneName();

    KeyChooseWindowItem getSelectKeyChooseWindowItem();

    KeyItem getTouchButtonItem(int i3);

    boolean isIsSceneLeft();

    boolean isTGPAValid();

    boolean updateSelectKeyChooseWindowItem(int i3);
}
