package com.tencent.qcircle.tavcut;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.view.RendererUtils;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGPlayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGSurface;

/* loaded from: classes22.dex */
public class PagTransformManager {
    private static final String BGCOLOR = "bgcolor";
    private static final String TAG = "PagTransformManager";
    private static final String TEXTCOLOR = "textcolor";
    private static volatile PagTransformManager sInstance;
    private PAGPlayer mPagRender;
    private PAGSurface mPagSurface = null;
    private int mPagOutputTexture = 0;
    private SimpleGLThread surfaceTextureHandler = new SimpleGLThread(EGL14.eglGetCurrentContext(), TAG);

    /* loaded from: classes22.dex */
    public interface PagTransformListener {
        void onBitmapSaveDone(@Nullable Bitmap bitmap);
    }

    PagTransformManager() {
    }

    public static PagTransformManager getInstance() {
        if (sInstance == null) {
            synchronized (PagTransformManager.class) {
                if (sInstance == null) {
                    sInstance = new PagTransformManager();
                }
            }
        }
        return sInstance;
    }

    private void renderPag(@Nullable final PAGFile pAGFile, @Nullable final PagTransformListener pagTransformListener) {
        if (pAGFile == null && pagTransformListener != null) {
            pagTransformListener.onBitmapSaveDone(null);
        }
        this.surfaceTextureHandler.postJob(new Runnable() { // from class: com.tencent.qcircle.tavcut.PagTransformManager.1
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                PagTransformManager.this.mPagOutputTexture = iArr[0];
                PagTransformManager pagTransformManager = PagTransformManager.this;
                pagTransformManager.mPagSurface = PAGSurface.FromTexture(pagTransformManager.mPagOutputTexture, pAGFile.width(), pAGFile.height());
                PagTransformManager.this.mPagRender = new PAGPlayer();
                PagTransformManager.this.mPagRender.setSurface(PagTransformManager.this.mPagSurface);
                PagTransformManager.this.mPagRender.setComposition(pAGFile);
                PagTransformManager.this.mPagRender.setScaleMode(0);
                PagTransformManager.this.mPagRender.flush();
                Bitmap saveTexture = RendererUtils.saveTexture(PagTransformManager.this.mPagOutputTexture, pAGFile.width(), pAGFile.height());
                if (saveTexture != null && !saveTexture.isRecycled()) {
                    PagTransformListener pagTransformListener2 = pagTransformListener;
                    if (pagTransformListener2 != null) {
                        pagTransformListener2.onBitmapSaveDone(saveTexture);
                    }
                } else {
                    PagTransformListener pagTransformListener3 = pagTransformListener;
                    if (pagTransformListener3 != null) {
                        pagTransformListener3.onBitmapSaveDone(null);
                    }
                }
                PagTransformManager.this.mPagRender.setSurface(null);
            }
        });
    }

    @Nullable
    public PAGFile createThumbPagFile(@Nullable String str, int i3, int i16) {
        if (str == null) {
            return null;
        }
        PAGFile Load = PagViewMonitor.Load(str);
        PAGLayer[] layersByName = Load.getLayersByName(TEXTCOLOR);
        int length = layersByName.length;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i18 >= length) {
                break;
            }
            PAGLayer pAGLayer = layersByName[i18];
            if (pAGLayer instanceof PAGSolidLayer) {
                if (i3 != 0) {
                    ((PAGSolidLayer) pAGLayer).setSolidColor(i3);
                    Load.setLayerIndex(pAGLayer, Load.getLayerIndex(pAGLayer));
                }
            } else {
                i18++;
            }
        }
        PAGLayer[] layersByName2 = Load.getLayersByName("bgcolor");
        int length2 = layersByName2.length;
        while (true) {
            if (i17 >= length2) {
                break;
            }
            PAGLayer pAGLayer2 = layersByName2[i17];
            if (pAGLayer2 instanceof PAGSolidLayer) {
                if (i16 != 0) {
                    ((PAGSolidLayer) pAGLayer2).setSolidColor(i16);
                    Load.setLayerIndex(pAGLayer2, Load.getLayerIndex(pAGLayer2));
                }
            } else {
                i17++;
            }
        }
        return Load;
    }

    public void pagFile2Bitmap(@Nullable String str, @Nullable PagTransformListener pagTransformListener) {
        if (!TextUtils.isEmpty(str)) {
            renderPag(PagViewMonitor.Load(str), pagTransformListener);
        } else if (pagTransformListener != null) {
            pagTransformListener.onBitmapSaveDone(null);
        }
    }

    public void pagFileFromAssets2Bitmap(@NonNull Context context, @Nullable String str, @Nullable PagTransformListener pagTransformListener) {
        if (TextUtils.isEmpty(str)) {
            if (pagTransformListener != null) {
                pagTransformListener.onBitmapSaveDone(null);
                return;
            }
            return;
        }
        renderPag(PagViewMonitor.Load(context.getAssets(), str), pagTransformListener);
    }

    public void release() {
        PAGSurface pAGSurface = this.mPagSurface;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
        PAGPlayer pAGPlayer = this.mPagRender;
        if (pAGPlayer != null) {
            pAGPlayer.setSurface(null);
        }
        this.surfaceTextureHandler.destroy();
        RendererUtils.clearTexture(this.mPagOutputTexture);
        sInstance = null;
    }

    public void pagFile2Bitmap(@Nullable PAGFile pAGFile, @Nullable PagTransformListener pagTransformListener) {
        renderPag(pAGFile, pagTransformListener);
    }
}
