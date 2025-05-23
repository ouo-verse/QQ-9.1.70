package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.view.Photo;
import com.tencent.view.RendererUtils;

/* loaded from: classes6.dex */
public class PicBaseFilter {
    static IPatchRedirector $redirector_;
    private BaseFilter mBaseFilter;

    public PicBaseFilter(BaseFilter baseFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseFilter);
        } else {
            this.mBaseFilter = baseFilter;
        }
    }

    public QImage ApplyFilter(QImage qImage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QImage) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qImage);
        }
        return null;
    }

    public void RendProcessImage(QImage qImage, Frame frame) {
        int i3;
        float[] fArr;
        int[] iArr;
        int i16;
        int i17;
        int[] iArr2;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qImage, (Object) frame);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr3 = {1, 1};
        GLSLRender.nativePreprocessJepg(qImage, iArr3);
        int i19 = 1;
        int[] iArr4 = new int[1];
        int i26 = 0;
        GlUtil.glGenTextures(1, iArr4, 0);
        int i27 = 9;
        float[] fArr2 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        int[] iArr5 = {0, 0};
        int i28 = 0;
        while (i28 < iArr3[i26]) {
            int i29 = i26;
            while (true) {
                int i36 = iArr3[i19];
                if (i29 < i36) {
                    int i37 = i29;
                    int i38 = i28;
                    int[] iArr6 = iArr5;
                    float[] fArr3 = fArr2;
                    GLSLRender.nativePickJepgToTexture(qImage, i28, i29, iArr3[i26], i36, iArr4[i26], iArr6);
                    fArr3[i26] = iArr6[i26] / qImage.getWidth();
                    fArr3[4] = iArr6[1] / qImage.getHeight();
                    fArr3[2] = i38 / iArr3[i26];
                    fArr3[5] = i37 / iArr3[1];
                    this.mBaseFilter.setGlobalTextureMatrix(fArr3);
                    if (BitmapUtils.currentShareIndex >= 0) {
                        i3 = i27;
                        int i39 = i26;
                        fArr = fArr3;
                        iArr = iArr3;
                        i16 = i37;
                        this.mBaseFilter.RenderProcess(iArr4[i26], iArr6[i26], iArr6[1], -2, 0.0d, frame);
                        GLSLRender.nativePushJepgFromTexture(qImage, i38, i16, iArr[i39], iArr[1], BitmapUtils.currentShareIndex);
                        i18 = 1;
                        iArr2 = iArr4;
                        i17 = i39;
                    } else {
                        i3 = i27;
                        fArr = fArr3;
                        iArr = iArr3;
                        i16 = i37;
                        int i46 = i26;
                        int[] iArr7 = iArr4;
                        this.mBaseFilter.RenderProcess(iArr7[i46], iArr6[i46], iArr6[1], -1, 0.0d, frame);
                        i17 = i46;
                        iArr2 = iArr7;
                        i18 = 1;
                        GLSLRender.nativePushJepgFromTexture(qImage, i38, i16, iArr[i46], iArr[1], BitmapUtils.currentShareIndex);
                    }
                    i29 = i16 + 1;
                    i28 = i38;
                    i26 = i17;
                    iArr4 = iArr2;
                    iArr5 = iArr6;
                    iArr3 = iArr;
                    i19 = i18;
                    i27 = i3;
                    fArr2 = fArr;
                }
            }
            float[] fArr4 = fArr2;
            i28++;
            iArr4 = iArr4;
            i19 = i19;
            i27 = i27;
            fArr2 = fArr4;
        }
        float[] fArr5 = new float[i27];
        // fill-array-data instruction
        fArr5[0] = 1.0f;
        fArr5[1] = 0.0f;
        fArr5[2] = 0.0f;
        fArr5[3] = 0.0f;
        fArr5[4] = 1.0f;
        fArr5[5] = 0.0f;
        fArr5[6] = 0.0f;
        fArr5[7] = 0.0f;
        fArr5[8] = 1.0f;
        this.mBaseFilter.setGlobalTextureMatrix(fArr5);
        GLES20.glDeleteTextures(i19, iArr4, i26);
        LogUtils.d("BaseFilter", "RendProcessImage:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mBaseFilter = null;
        }
    }

    public void renderProcessBitmap(Bitmap bitmap, Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap, (Object) frame);
            return;
        }
        Photo createWithoutRecycle = Photo.createWithoutRecycle(bitmap);
        if (BitmapUtils.currentShareIndex < 0) {
            this.mBaseFilter.RenderProcess(createWithoutRecycle.texture(), createWithoutRecycle.width(), createWithoutRecycle.height(), createWithoutRecycle.texture(), 0.0d, frame);
            RendererUtils.saveTextureToBitmap(createWithoutRecycle.texture(), createWithoutRecycle.width(), createWithoutRecycle.height(), bitmap);
        } else {
            this.mBaseFilter.RenderProcess(createWithoutRecycle.texture(), createWithoutRecycle.width(), createWithoutRecycle.height(), -2, 0.0d, frame);
            GLSLRender.nativePushBitmapFromTexture(bitmap, BitmapUtils.currentShareIndex);
        }
        createWithoutRecycle.clear();
    }
}
