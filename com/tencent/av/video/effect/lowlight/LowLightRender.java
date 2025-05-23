package com.tencent.av.video.effect.lowlight;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.lowlight.QQAVImageLowLightFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LowLightRender extends BaseRender {
    private static final String TAG = "LowLightRender";
    private WeakReference<Context> mContextReference;
    private QQAVImageLowLightFilter mLowLightFilter = null;
    private Bitmap mLowLightImage;

    public LowLightRender(Context context, String str) {
        this.mLowLightImage = null;
        this.mContextReference = new WeakReference<>(context);
        this.mLowLightImage = LowLightTools.getLowLightImage(context, str);
        Log.d(TAG, "new LowLightRender resPath = " + str);
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.lowlight.LowLightRender.1
            @Override // java.lang.Runnable
            public void run() {
                LowLightRender.this.mLowLightFilter = new QQAVImageLowLightFilter();
                LowLightRender.this.mLowLightFilter.setLowLightImage(LowLightRender.this.mLowLightImage);
                LowLightRender.this.mLowLightFilter.init();
            }
        });
    }

    @Override // com.tencent.av.video.effect.core.BaseRender
    public void destroy() {
        super.destroy();
        QQAVImageLowLightFilter qQAVImageLowLightFilter = this.mLowLightFilter;
        if (qQAVImageLowLightFilter != null) {
            qQAVImageLowLightFilter.destroy();
            this.mLowLightFilter = null;
        }
    }

    public void preProcess(int i3, int i16) {
        baseProcess(i3, i16);
        QQAVImageLowLightFilter qQAVImageLowLightFilter = this.mLowLightFilter;
        if (qQAVImageLowLightFilter != null) {
            qQAVImageLowLightFilter.onOutputSizeChanged(i3, i16);
        }
    }

    @Override // com.tencent.av.video.effect.core.BaseRender
    public EffectTexture process(int i3, int i16, int i17, int i18) {
        EffectTexture process = super.process(i3, i16, i17, i18);
        QQAVImageLowLightFilter qQAVImageLowLightFilter = this.mLowLightFilter;
        if (qQAVImageLowLightFilter == null) {
            Log.d(TAG, "mLowLightFilter = null");
            CommonUtils.glCheckError();
            return process;
        }
        qQAVImageLowLightFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
        this.mLowLightFilter.onDraw2(process.getTextureId(), this.mOutFbo);
        CommonUtils.glCheckError();
        return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
    }

    public LowLightRender(Context context) {
        this.mLowLightImage = null;
        this.mContextReference = new WeakReference<>(context);
        this.mLowLightImage = LowLightTools.getLowLightImage(3.0f, 0.88f, 0.96f, 1.22f, false);
        Log.d(TAG, "new LowLightRender");
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.lowlight.LowLightRender.2
            @Override // java.lang.Runnable
            public void run() {
                LowLightRender.this.mLowLightFilter = new QQAVImageLowLightFilter();
                LowLightRender.this.mLowLightFilter.setLowLightImage(LowLightRender.this.mLowLightImage);
                LowLightRender.this.mLowLightFilter.init();
            }
        });
    }
}
