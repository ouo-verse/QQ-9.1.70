package com.tencent.av.video.effect.denoise;

import android.content.Context;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DenoiseRender extends BaseRender {
    private static final String TAG = "DenoiseRender";
    private WeakReference<Context> mContextReference;
    private QQAVImageDenoiseFilter mDenoiseFilter = null;

    public DenoiseRender(Context context) {
        this.mContextReference = new WeakReference<>(context);
        Log.d(TAG, "new DenoiseRender");
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.denoise.DenoiseRender.1
            @Override // java.lang.Runnable
            public void run() {
                DenoiseRender.this.mDenoiseFilter = new QQAVImageDenoiseFilter();
                DenoiseRender.this.mDenoiseFilter.init();
            }
        });
    }

    @Override // com.tencent.av.video.effect.core.BaseRender
    public void destroy() {
        super.destroy();
        QQAVImageDenoiseFilter qQAVImageDenoiseFilter = this.mDenoiseFilter;
        if (qQAVImageDenoiseFilter != null) {
            qQAVImageDenoiseFilter.destroy();
            this.mDenoiseFilter = null;
        }
    }

    public void preProcess(int i3, int i16) {
        baseProcess(i3, i16);
        QQAVImageDenoiseFilter qQAVImageDenoiseFilter = this.mDenoiseFilter;
        if (qQAVImageDenoiseFilter != null) {
            qQAVImageDenoiseFilter.onOutputSizeChanged(i3, i16);
        }
    }

    @Override // com.tencent.av.video.effect.core.BaseRender
    public EffectTexture process(int i3, int i16, int i17, int i18) {
        EffectTexture process = super.process(i3, i16, i17, i18);
        QQAVImageDenoiseFilter qQAVImageDenoiseFilter = this.mDenoiseFilter;
        if (qQAVImageDenoiseFilter == null) {
            Log.d(TAG, "mDenoiseFilter = null");
            CommonUtils.glCheckError();
            return process;
        }
        qQAVImageDenoiseFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
        this.mDenoiseFilter.onDraw2(process.getTextureId(), this.mOutFbo);
        CommonUtils.glCheckError();
        return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
    }

    public void setUpdateRate(final float f16) {
        Log.d(TAG, "setUpdateRate updateRate = " + f16);
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.denoise.DenoiseRender.2
            @Override // java.lang.Runnable
            public void run() {
                if (DenoiseRender.this.mDenoiseFilter != null) {
                    DenoiseRender.this.mDenoiseFilter.setUpdateRate(f16);
                }
            }
        });
    }
}
