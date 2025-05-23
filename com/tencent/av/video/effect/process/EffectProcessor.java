package com.tencent.av.video.effect.process;

import android.opengl.GLES20;
import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.Beauty25Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.av.video.effect.utils.TextureDataLoader;

/* loaded from: classes3.dex */
public class EffectProcessor {
    public static final int PROCESS_ERR_FAIL = 1;
    private static final String TAG = "EffectProcessor";
    private Beauty20Render mBeauty20Render;
    private Beauty25Render mBeauty25Render;
    private BeautyRender mBeautyRender;
    private DenoiseRender mDenoiseRender;
    private FilterRender mFilterRender;
    private LowLightRender mLowLightRender;
    private OffscreenGLContext mOffscreenGLContext;
    private ProcessCallback mProcessCallback;
    private BeautyRender mTempBeautyRender;
    private TextureDataLoader mTextureDataLoader;
    private int mPicTextureId = -1;
    private int mDataLoaderTextureId = -1;
    private int[] lowlightinfo = new int[2];

    /* loaded from: classes3.dex */
    public interface ProcessCallback {
        void onComplete(EffectFrame effectFrame);

        void onError(EffectFrame effectFrame, int i3, String str);
    }

    public EffectProcessor() {
        OffscreenGLContext offscreenGLContext = new OffscreenGLContext();
        this.mOffscreenGLContext = offscreenGLContext;
        offscreenGLContext.post(new Runnable() { // from class: com.tencent.av.video.effect.process.EffectProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                EffectProcessor.this.mTextureDataLoader = new TextureDataLoader();
            }
        });
    }

    public void destroy() {
        this.mOffscreenGLContext.post(new Runnable() { // from class: com.tencent.av.video.effect.process.EffectProcessor.5
            @Override // java.lang.Runnable
            public void run() {
                if (EffectProcessor.this.mTextureDataLoader != null) {
                    EffectProcessor.this.mTextureDataLoader.destroy();
                    EffectProcessor.this.mTextureDataLoader = null;
                }
                if (EffectProcessor.this.mLowLightRender != null) {
                    EffectProcessor.this.mLowLightRender.destroy();
                    EffectProcessor.this.mLowLightRender = null;
                }
                if (EffectProcessor.this.mBeautyRender != null) {
                    EffectProcessor.this.mBeautyRender.destroy();
                    EffectProcessor.this.mBeautyRender = null;
                }
                if (EffectProcessor.this.mFilterRender != null) {
                    EffectProcessor.this.mFilterRender.destroy();
                    EffectProcessor.this.mFilterRender = null;
                }
                if (EffectProcessor.this.mBeauty20Render != null) {
                    EffectProcessor.this.mBeauty20Render.destroy();
                    EffectProcessor.this.mBeauty20Render = null;
                }
                if (EffectProcessor.this.mBeauty25Render != null) {
                    EffectProcessor.this.mBeauty25Render.destroy();
                    EffectProcessor.this.mBeauty25Render = null;
                }
                if (EffectProcessor.this.mDenoiseRender != null) {
                    EffectProcessor.this.mDenoiseRender.destroy();
                    EffectProcessor.this.mDenoiseRender = null;
                }
                if (EffectProcessor.this.mTempBeautyRender != null) {
                    EffectProcessor.this.mTempBeautyRender.destroy();
                    EffectProcessor.this.mTempBeautyRender = null;
                }
                EffectProcessor.this.mProcessCallback = null;
                if (EffectProcessor.this.mDataLoaderTextureId != -1) {
                    GLES20.glDeleteTextures(1, new int[]{EffectProcessor.this.mDataLoaderTextureId}, 0);
                    EffectProcessor.this.mDataLoaderTextureId = -1;
                }
                if (EffectProcessor.this.mOffscreenGLContext != null) {
                    EffectProcessor.this.mOffscreenGLContext.destroy();
                    EffectProcessor.this.mOffscreenGLContext = null;
                }
            }
        });
    }

    public void process(final EffectFrame effectFrame) {
        byte[] bArr;
        OffscreenGLContext offscreenGLContext = this.mOffscreenGLContext;
        if (offscreenGLContext == null) {
            ProcessCallback processCallback = this.mProcessCallback;
            if (processCallback != null) {
                processCallback.onComplete(effectFrame);
                this.mProcessCallback.onError(effectFrame, 1, "no opengl context!");
                return;
            }
            return;
        }
        if (effectFrame != null && (bArr = effectFrame.frameData) != null && bArr.length != 0 && effectFrame.frameWidth != 0 && effectFrame.frameHeight != 0 && effectFrame.frameFormat != null) {
            offscreenGLContext.post(new Runnable() { // from class: com.tencent.av.video.effect.process.EffectProcessor.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    boolean z17;
                    try {
                        Log.d(EffectProcessor.TAG, "process data size = " + effectFrame.frameData.length + " | width = " + effectFrame.frameWidth + " | height = " + effectFrame.frameHeight + " | format = " + effectFrame.frameFormat + " | LowLightRender = " + EffectProcessor.this.mLowLightRender + " | BeautyRender = " + EffectProcessor.this.mBeautyRender + " | FilterRender = " + EffectProcessor.this.mFilterRender + " | Beauty20Render = " + EffectProcessor.this.mBeauty20Render + " | Beauty25Render = " + EffectProcessor.this.mBeauty25Render + " | DenoiseRender = " + EffectProcessor.this.mDenoiseRender);
                        EffectFrame effectFrame2 = new EffectFrame();
                        EffectFrame effectFrame3 = effectFrame;
                        effectFrame2.frameData = effectFrame3.frameData;
                        effectFrame2.frameWidth = effectFrame3.frameWidth;
                        effectFrame2.frameHeight = effectFrame3.frameHeight;
                        effectFrame2.frameFormat = effectFrame3.frameFormat;
                        boolean z18 = false;
                        if (EffectProcessor.this.mFilterRender != null && EffectProcessor.this.mFilterRender.getFilterType() == 3) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (EffectProcessor.this.mFilterRender != null && (EffectProcessor.this.mFilterRender.getFilterType() == 1 || EffectProcessor.this.mFilterRender.getFilterType() == 2)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        EffectProcessor.this.lowlightinfo = LowLightUtils.DetectLowLight(effectFrame2.frameData, 20, effectFrame2.frameWidth, effectFrame2.frameHeight, 60, 1.0f);
                        if (EffectProcessor.this.mBeauty20Render != null && !z16) {
                            effectFrame2 = EffectProcessor.this.mBeauty20Render.processData(effectFrame2);
                        }
                        if (EffectProcessor.this.mBeauty25Render != null && !z16) {
                            effectFrame2 = EffectProcessor.this.mBeauty25Render.processData(effectFrame2);
                        }
                        if (EffectProcessor.this.mLowLightRender == null && EffectProcessor.this.mBeautyRender == null && EffectProcessor.this.mFilterRender == null && EffectProcessor.this.mDenoiseRender == null) {
                            if (EffectProcessor.this.mProcessCallback != null) {
                                EffectProcessor.this.mProcessCallback.onComplete(effectFrame2);
                                return;
                            }
                            return;
                        }
                        EffectTexture loadDataToTexture = EffectProcessor.this.mTextureDataLoader.loadDataToTexture(effectFrame2.frameData, effectFrame2.frameFormat, effectFrame2.frameWidth, effectFrame2.frameHeight, EffectProcessor.this.mDataLoaderTextureId);
                        EffectProcessor.this.mDataLoaderTextureId = loadDataToTexture.getTextureId();
                        if (EffectProcessor.this.mDenoiseRender != null && EffectProcessor.this.lowlightinfo[0] == 1) {
                            loadDataToTexture = EffectProcessor.this.mDenoiseRender.process(loadDataToTexture.getTextureId(), loadDataToTexture.getFbo(), loadDataToTexture.getWidth(), loadDataToTexture.getHeight());
                        }
                        if (EffectProcessor.this.mLowLightRender != null && EffectProcessor.this.lowlightinfo[0] == 1) {
                            loadDataToTexture = EffectProcessor.this.mLowLightRender.process(loadDataToTexture.getTextureId(), loadDataToTexture.getFbo(), loadDataToTexture.getWidth(), loadDataToTexture.getHeight());
                        }
                        if (EffectProcessor.this.mBeautyRender != null && !z16) {
                            BeautyRender beautyRender = EffectProcessor.this.mBeautyRender;
                            if (!z17) {
                                z18 = true;
                            }
                            beautyRender.setNeedSkinColor(z18);
                            loadDataToTexture = EffectProcessor.this.mBeautyRender.process(loadDataToTexture.getTextureId(), loadDataToTexture.getFbo(), loadDataToTexture.getWidth(), loadDataToTexture.getHeight());
                        }
                        if (EffectProcessor.this.mFilterRender != null) {
                            loadDataToTexture = EffectProcessor.this.mFilterRender.process(loadDataToTexture.getTextureId(), loadDataToTexture.getFbo(), loadDataToTexture.getWidth(), loadDataToTexture.getHeight());
                        }
                        byte[] bArr2 = new byte[loadDataToTexture.getWidth() * loadDataToTexture.getHeight() * 4];
                        CommonUtils.saveTextureToRgbaBuffer(loadDataToTexture.getFbo(), loadDataToTexture.getWidth(), loadDataToTexture.getHeight(), bArr2);
                        EffectFrame effectFrame4 = new EffectFrame();
                        effectFrame4.frameData = bArr2;
                        effectFrame4.frameWidth = loadDataToTexture.getWidth();
                        effectFrame4.frameHeight = loadDataToTexture.getHeight();
                        effectFrame4.frameFormat = ColorFormat.RGBA;
                        if (EffectProcessor.this.mProcessCallback != null) {
                            EffectProcessor.this.mProcessCallback.onComplete(effectFrame4);
                        }
                    } catch (Exception e16) {
                        if (EffectProcessor.this.mProcessCallback != null) {
                            EffectProcessor.this.mProcessCallback.onComplete(effectFrame);
                            EffectProcessor.this.mProcessCallback.onError(effectFrame, 1, e16.getMessage());
                        }
                    }
                }
            });
            return;
        }
        ProcessCallback processCallback2 = this.mProcessCallback;
        if (processCallback2 != null) {
            processCallback2.onComplete(effectFrame);
            this.mProcessCallback.onError(effectFrame, 1, "invalid input frame!");
        }
    }

    public void setBeauty20Render(Beauty20Render beauty20Render) {
        this.mBeauty20Render = beauty20Render;
        this.mBeauty25Render = null;
        this.mTempBeautyRender = this.mBeautyRender;
        this.mOffscreenGLContext.post(new Runnable() { // from class: com.tencent.av.video.effect.process.EffectProcessor.3
            @Override // java.lang.Runnable
            public void run() {
                if (EffectProcessor.this.mTempBeautyRender != null) {
                    EffectProcessor.this.mTempBeautyRender.destroy();
                    EffectProcessor.this.mTempBeautyRender = null;
                }
            }
        });
        this.mBeautyRender = null;
    }

    public void setBeauty25Render(Beauty25Render beauty25Render) {
        this.mBeauty25Render = beauty25Render;
        this.mBeauty20Render = null;
        this.mTempBeautyRender = this.mBeautyRender;
        this.mOffscreenGLContext.post(new Runnable() { // from class: com.tencent.av.video.effect.process.EffectProcessor.2
            @Override // java.lang.Runnable
            public void run() {
                if (EffectProcessor.this.mTempBeautyRender != null) {
                    EffectProcessor.this.mTempBeautyRender.destroy();
                    EffectProcessor.this.mTempBeautyRender = null;
                }
            }
        });
        this.mBeautyRender = null;
    }

    public void setBeautyRender(BeautyRender beautyRender) {
        this.mBeautyRender = beautyRender;
        this.mBeauty20Render = null;
        this.mBeauty25Render = null;
    }

    public void setDenoiseRender(DenoiseRender denoiseRender) {
        this.mDenoiseRender = denoiseRender;
    }

    public void setFilterRender(FilterRender filterRender) {
        this.mFilterRender = filterRender;
    }

    public void setLowLightRender(LowLightRender lowLightRender) {
        this.mLowLightRender = lowLightRender;
    }

    public void setProcessCallback(ProcessCallback processCallback) {
        this.mProcessCallback = processCallback;
    }
}
