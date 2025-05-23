package com.tencent.mobileqq.shortvideo.dancemachine;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes18.dex */
public class TrAsyncTextureLoad {
    private static volatile TrAsyncTextureLoad INSTANCE;
    private EglHandlerThread eglHandlerThread;
    private final Object mLock = new Object();
    private ArrayList<HashMap<String, GLImage>> needUpdateCache = new ArrayList<>();

    TrAsyncTextureLoad() {
    }

    public static TrAsyncTextureLoad getInstance() {
        if (INSTANCE == null) {
            synchronized (TrAsyncTextureLoad.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TrAsyncTextureLoad();
                }
            }
        }
        return INSTANCE;
    }

    public void asyncLoadBoyTexture() {
        boolean z16;
        EglHandlerThread eglHandlerThread = this.eglHandlerThread;
        if (eglHandlerThread != null) {
            z16 = eglHandlerThread.isInitSuccess();
        } else {
            z16 = false;
        }
        DanceLog.printFrameQueue("GLFrameImage", "asyncLoadBoyTexture initSuccess=" + z16);
        if (z16) {
            this.eglHandlerThread.getHandler().post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    DanceLog.printFrameQueue("GLFrameImage", "asyncLoadBoyTexture start loading");
                    GLFrameImage.oncePreloadBoyFilterPrivateResource();
                    DanceLog.printFrameQueue("GLFrameImage", "asyncLoadBoyTexture end loading timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyGLThreadUpdateTextureCache(HashMap<String, GLImage> hashMap) {
        boolean z16;
        if (hashMap != null && hashMap.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        DanceLog.printFrameQueue("GLFrameImage", "notifyGLThreadUpdateTextureCache needDo=" + z16 + " itemSize=" + hashMap.size());
        if (z16) {
            synchronized (this.mLock) {
                this.needUpdateCache.add(hashMap);
            }
        }
    }

    public void onSurfaceCreate() {
        EglHandlerThread eglHandlerThread = this.eglHandlerThread;
        EglHandlerThread eglHandlerThread2 = new EglHandlerThread("async_load_texture", EGL14.eglGetCurrentContext());
        this.eglHandlerThread = eglHandlerThread2;
        eglHandlerThread2.start();
        if (eglHandlerThread != null) {
            DanceLog.printFrameQueue("GLFrameImage", "TrAsyncTextureLoad lastHandler!=null");
            eglHandlerThread.quitSafely();
        }
    }

    public void onSurfaceDestroy() {
        EglHandlerThread eglHandlerThread = this.eglHandlerThread;
        if (eglHandlerThread != null) {
            eglHandlerThread.quitSafely();
            this.eglHandlerThread = null;
        }
    }

    public void processInterrupt() {
        DanceLog.printFrameQueue("GLFrameImage", "processInterrupt");
        int size = this.needUpdateCache.size();
        DanceLog.printFrameQueue("GLFrameImage", "processInterrupt unsafeSize=" + size);
        if (size > 0) {
            synchronized (this.mLock) {
                if (this.needUpdateCache.size() > 0) {
                    Iterator<HashMap<String, GLImage>> it = this.needUpdateCache.iterator();
                    while (it.hasNext()) {
                        HashMap<String, GLImage> next = it.next();
                        Iterator<String> it5 = next.keySet().iterator();
                        while (it5.hasNext()) {
                            GLImage gLImage = next.get(it5.next());
                            if (gLImage != null) {
                                gLImage.release();
                            }
                        }
                        next.clear();
                    }
                }
                this.needUpdateCache.clear();
            }
        }
    }

    public void updateGLFrameImageCache() {
        int size = this.needUpdateCache.size();
        DanceLog.printFrameQueue("GLFrameImage", "updateGLFrameImageCache unsafeSize=" + size);
        if (size > 0) {
            synchronized (this.mLock) {
                int size2 = this.needUpdateCache.size();
                DanceLog.printFrameQueue("GLFrameImage", "updateGLFrameImageCache safeSize=" + size2);
                if (size2 > 0) {
                    Iterator<HashMap<String, GLImage>> it = this.needUpdateCache.iterator();
                    while (it.hasNext()) {
                        HashMap<String, GLImage> next = it.next();
                        DanceLog.printFrameQueue("GLFrameImage", "updateGLFrameImageCache itemSize=" + next.size());
                        GLFrameImage.updateGLFrameImageCache(next);
                        next.clear();
                    }
                }
                this.needUpdateCache.clear();
            }
        }
    }
}
