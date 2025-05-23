package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapSceneConfig;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SceneCanvas {
    private int m_canvasSource;
    private int m_keyMapMode;
    private boolean m_isLayoutChanged = false;
    private boolean m_isModeChanged = false;
    private int m_gameType = 1;
    private int m_keyMapType = 0;
    private int m_keyMapSource = 0;
    private int m_resourceType = 0;
    private KeyMapSceneConfig m_sceneConfig = null;

    public SceneCanvas(int i3, int i16) {
        this.m_canvasSource = i3;
        this.m_keyMapMode = i16;
    }

    public int getGameType() {
        return this.m_gameType;
    }

    public int getKeyMapMode() {
        return this.m_keyMapMode;
    }

    int getKeyMapSource() {
        return this.m_keyMapSource;
    }

    public int getKeyMapType() {
        return this.m_keyMapType;
    }

    public int getResourceType() {
        return this.m_resourceType;
    }

    public KeyMapSceneConfig getSceneConfig() {
        return this.m_sceneConfig;
    }

    public boolean isLayoutChanged() {
        return this.m_isLayoutChanged;
    }

    public boolean isModeChanged() {
        return this.m_isModeChanged;
    }

    public void setGameType(int i3) {
        this.m_gameType = i3;
    }

    public void setKeyMapMode(int i3) {
        this.m_keyMapMode = i3;
    }

    public void setKeyMapSource(int i3) {
        this.m_keyMapSource = i3;
    }

    public void setKeyMapType(int i3) {
        this.m_keyMapType = i3;
    }

    public void setLayoutChanged(boolean z16) {
        this.m_isLayoutChanged = z16;
    }

    public void setModeChanged(boolean z16) {
        this.m_isModeChanged = z16;
    }

    public void setResourceType(int i3) {
        this.m_resourceType = i3;
    }

    public void setSceneConfig(KeyMapSceneConfig keyMapSceneConfig) {
        this.m_sceneConfig = keyMapSceneConfig;
    }
}
