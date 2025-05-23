package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SceneCanvasContainer {
    SparseArray<SceneCanvas> m_sceneCanvasArray;

    public SceneCanvasContainer() {
        if (this.m_sceneCanvasArray == null) {
            this.m_sceneCanvasArray = new SparseArray<>();
        }
    }
}
