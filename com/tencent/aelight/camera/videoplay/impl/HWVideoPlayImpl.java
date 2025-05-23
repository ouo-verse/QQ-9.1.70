package com.tencent.aelight.camera.videoplay.impl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView;
import com.tencent.aelight.camera.videoplay.IHWVideoPlay;

/* loaded from: classes32.dex */
public class HWVideoPlayImpl implements IHWVideoPlay {
    @Override // com.tencent.aelight.camera.videoplay.IHWVideoPlay
    public GLSurfaceView getHWVideoPlayView(Context context) {
        return new HWVideoPlayView(context);
    }

    @Override // com.tencent.aelight.camera.videoplay.IHWVideoPlay
    public void setFilePath(GLSurfaceView gLSurfaceView, String str, String str2) {
        if (gLSurfaceView != null) {
            ((HWVideoPlayView) gLSurfaceView).setFilePath(str, str2);
        }
    }

    @Override // com.tencent.aelight.camera.videoplay.IHWVideoPlay
    public void setRepeat(GLSurfaceView gLSurfaceView, boolean z16) {
        if (gLSurfaceView != null) {
            ((HWVideoPlayView) gLSurfaceView).setRepeat(z16);
        }
    }

    @Override // com.tencent.aelight.camera.videoplay.IHWVideoPlay
    public void startPlay(GLSurfaceView gLSurfaceView) {
        if (gLSurfaceView != null) {
            ((HWVideoPlayView) gLSurfaceView).n();
        }
    }

    @Override // com.tencent.aelight.camera.videoplay.IHWVideoPlay
    public void stopPlay(GLSurfaceView gLSurfaceView) {
        if (gLSurfaceView != null) {
            ((HWVideoPlayView) gLSurfaceView).o();
        }
    }
}
