package com.tencent.aelight.camera.videoplay;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IHWVideoPlay extends QRouteApi {
    GLSurfaceView getHWVideoPlayView(Context context);

    void setFilePath(GLSurfaceView gLSurfaceView, String str, String str2);

    void setRepeat(GLSurfaceView gLSurfaceView, boolean z16);

    void startPlay(GLSurfaceView gLSurfaceView);

    void stopPlay(GLSurfaceView gLSurfaceView);
}
