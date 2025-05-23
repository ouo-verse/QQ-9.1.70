package com.tencent.thumbplayer.core.utils;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* loaded from: classes26.dex */
public class TPSurfaceTexture extends SurfaceTexture {
    private HandlerThread mOnFrameAvailableListenerHandlerThread;

    public TPSurfaceTexture(int i3) {
        super(i3);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("OnFrameAvailableListenerHandlerThread");
        this.mOnFrameAvailableListenerHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
    }

    public static boolean isSupportOnFrameAvailableOnNonMainThread() {
        return true;
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(@Nullable SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        super.setOnFrameAvailableListener(onFrameAvailableListener, new Handler(this.mOnFrameAvailableListenerHandlerThread.getLooper()));
    }
}
