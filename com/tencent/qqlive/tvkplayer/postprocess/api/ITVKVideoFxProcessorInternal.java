package com.tencent.qqlive.tvkplayer.postprocess.api;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKVideoFx;
import java.util.ArrayList;

/* loaded from: classes23.dex */
public interface ITVKVideoFxProcessorInternal extends ITVKVideoFxProcessor {
    ArrayList<ITVKVideoFx> currentFxs();

    void destroy();

    @Nullable
    SurfaceTexture getInputSurfaceTexture();

    boolean init();

    void notifyOutputSurfaceSizeChanged(int i3, int i16);

    void setErrorListener(@NonNull ITVKVideoFxErrorListener iTVKVideoFxErrorListener);

    void setOutputSurface(@Nullable Surface surface);

    void setTVKPlayerLogTag(String str);
}
