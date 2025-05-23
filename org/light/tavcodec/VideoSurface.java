package org.light.tavcodec;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.reflect.Field;
import org.light.device.LightDeviceProperty;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoSurface implements SurfaceTexture.OnFrameAvailableListener {
    private static int HandlerThreadCount;
    private static final Object handlerLock = new Object();
    private static HandlerThread handlerThread;
    private Surface outputSurface;
    private SurfaceTexture surfaceTexture;
    private int width = 0;
    private int height = 0;
    private final Object frameSyncObject = new Object();
    private boolean frameAvailable = false;
    private boolean released = false;
    private boolean attachedToGLContext = false;

    private static VideoSurface Make(int i3, int i16) {
        VideoSurface videoSurface = new VideoSurface();
        videoSurface.width = i3;
        videoSurface.height = i16;
        synchronized (handlerLock) {
            StartHandlerThread();
            int i17 = LightDeviceProperty.VERSION.SDK_INT;
            if (i17 >= 26) {
                videoSurface.surfaceTexture = new SurfaceTexture(false);
            } else {
                SurfaceTexture surfaceTexture = new SurfaceTexture(0);
                videoSurface.surfaceTexture = surfaceTexture;
                surfaceTexture.detachFromGLContext();
            }
            if (i17 >= 21) {
                videoSurface.surfaceTexture.setOnFrameAvailableListener(videoSurface, new Handler(handlerThread.getLooper()));
            } else {
                videoSurface.surfaceTexture.setOnFrameAvailableListener(videoSurface);
                videoSurface.reflectLooper();
            }
        }
        videoSurface.outputSurface = new Surface(videoSurface.surfaceTexture);
        return videoSurface;
    }

    private static synchronized void StartHandlerThread() {
        synchronized (VideoSurface.class) {
            HandlerThreadCount++;
            if (handlerThread == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("tavcodec_VideoSurface");
                handlerThread = baseHandlerThread;
                baseHandlerThread.start();
            }
        }
    }

    private boolean attachToGLContext(int i3) {
        try {
            this.surfaceTexture.attachToGLContext(i3);
            this.attachedToGLContext = true;
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private void detachFromGLContext() {
        try {
            this.surfaceTexture.detachFromGLContext();
            this.attachedToGLContext = false;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private Surface getOutputSurface() {
        return this.outputSurface;
    }

    private void onRelease() {
        if (this.released) {
            return;
        }
        this.released = true;
        synchronized (handlerLock) {
            int i3 = HandlerThreadCount - 1;
            HandlerThreadCount = i3;
            if (i3 == 0) {
                handlerThread.quit();
                handlerThread = null;
            }
        }
        Surface surface = this.outputSurface;
        if (surface != null) {
            surface.release();
            this.outputSurface = null;
        }
        if (this.surfaceTexture != null) {
            if (this.attachedToGLContext) {
                detachFromGLContext();
            }
            this.surfaceTexture.release();
            this.surfaceTexture = null;
        }
    }

    private void reflectLooper() {
        Class<?> cls;
        Class<?>[] declaredClasses = SurfaceTexture.class.getDeclaredClasses();
        int length = declaredClasses.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                cls = declaredClasses[i3];
                if (cls.getName().toLowerCase().contains("handler")) {
                    break;
                } else {
                    i3++;
                }
            } else {
                cls = null;
                break;
            }
        }
        if (cls == null) {
            return;
        }
        try {
            Object newInstance = cls.getConstructor(SurfaceTexture.class, Looper.class).newInstance(this.surfaceTexture, handlerThread.getLooper());
            Field declaredField = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            declaredField.set(this.surfaceTexture, newInstance);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private boolean updateTexImage() {
        synchronized (this.frameSyncObject) {
            int i3 = 10;
            while (!this.frameAvailable && i3 > 0) {
                i3--;
                try {
                    this.frameSyncObject.wait(50L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            this.frameAvailable = false;
            if (i3 == 0) {
                return false;
            }
            try {
                this.surfaceTexture.updateTexImage();
                return true;
            } catch (Exception e17) {
                e17.printStackTrace();
                return false;
            }
        }
    }

    private int videoHeight() {
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        float abs = Math.abs(fArr[5]);
        if (abs > 0.0f) {
            return Math.round(this.height / (abs + ((fArr[13] - abs) * 2.0f)));
        }
        return this.height;
    }

    private int videoWidth() {
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        float abs = Math.abs(fArr[0]);
        if (abs > 0.0f) {
            return Math.round(this.width / (abs + (fArr[12] * 2.0f)));
        }
        return this.width;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.frameSyncObject) {
            if (this.frameAvailable) {
                new RuntimeException("frameAvailable already set, frame could be dropped").printStackTrace();
            } else {
                this.frameAvailable = true;
                this.frameSyncObject.notifyAll();
            }
        }
    }
}
