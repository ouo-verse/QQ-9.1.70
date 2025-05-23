package com.tencent.av.video.effect.beauty;

import android.content.Context;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyFilter;
import com.tencent.av.video.effect.filter.FilterFactory;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BeautyRender extends BaseRender {
    private static final String SKIN_COLOR_FOLDER = "SKINCOLOR";
    private static final String TAG = "BeautyRender";
    private QQAVImageBeautyFilter mBeautyFilter;
    private WeakReference<Context> mContextReference;
    private FilterFactory mFilterFactory;

    public BeautyRender(Context context, final String str) {
        this.mContextReference = new WeakReference<>(context);
        this.mFilterFactory = new FilterFactory(context);
        Log.d(TAG, "new BeautyRender resPath = " + str);
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.beauty.BeautyRender.1
            @Override // java.lang.Runnable
            public void run() {
                BeautyRender.this.mBeautyFilter = new QQAVImageBeautyFilter();
                BeautyRender.this.mBeautyFilter.setSkinColorFilter(BeautyRender.this.mFilterFactory.getFilter(str + File.separator + BeautyRender.SKIN_COLOR_FOLDER));
                BeautyRender.this.mBeautyFilter.init();
            }
        });
    }

    @Override // com.tencent.av.video.effect.core.BaseRender
    public void destroy() {
        super.destroy();
        QQAVImageBeautyFilter qQAVImageBeautyFilter = this.mBeautyFilter;
        if (qQAVImageBeautyFilter != null) {
            qQAVImageBeautyFilter.destroy();
            this.mBeautyFilter = null;
        }
    }

    public void preProcess(int i3, int i16) {
        baseProcess(i3, i16);
        QQAVImageBeautyFilter qQAVImageBeautyFilter = this.mBeautyFilter;
        if (qQAVImageBeautyFilter != null) {
            qQAVImageBeautyFilter.onOutputSizeChanged(i3, i16);
        }
    }

    @Override // com.tencent.av.video.effect.core.BaseRender
    public EffectTexture process(int i3, int i16, int i17, int i18) {
        EffectTexture process = super.process(i3, i16, i17, i18);
        QQAVImageBeautyFilter qQAVImageBeautyFilter = this.mBeautyFilter;
        if (qQAVImageBeautyFilter != null && ((qQAVImageBeautyFilter.isUseMultiParams() || this.mBeautyFilter.getAmount() != 0.0f) && (!this.mBeautyFilter.isUseMultiParams() || this.mBeautyFilter.getMixPercent() != 0.0f || this.mBeautyFilter.getSharpness() != 0.0f || this.mBeautyFilter.getExposure() != 0.0f))) {
            this.mBeautyFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
            this.mBeautyFilter.onDraw2(process.getTextureId(), this.mOutFbo);
            CommonUtils.glCheckError();
            return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
        }
        Log.d(TAG, "need not process beauty.");
        CommonUtils.glCheckError();
        return process;
    }

    public void setBeautyLevel(final float f16) {
        Log.d(TAG, "setBeautyLevel level = " + f16);
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.beauty.BeautyRender.2
            @Override // java.lang.Runnable
            public void run() {
                if (BeautyRender.this.mBeautyFilter != null) {
                    BeautyRender.this.mBeautyFilter.setAmount(f16);
                }
            }
        });
    }

    public void setNeedSkinColor(final boolean z16) {
        Log.d(TAG, "setNeedSkinColor isNeed = " + z16);
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.beauty.BeautyRender.4
            @Override // java.lang.Runnable
            public void run() {
                if (BeautyRender.this.mBeautyFilter != null) {
                    BeautyRender.this.mBeautyFilter.setNeedSkinColor(z16);
                }
            }
        });
    }

    public void setBeautyLevel(final float f16, final float f17, final float f18) {
        Log.d(TAG, "setBeautyLevel mixPercent = " + f16 + " | sharpen =" + f17 + " | exposure = " + f18);
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.beauty.BeautyRender.3
            @Override // java.lang.Runnable
            public void run() {
                if (BeautyRender.this.mBeautyFilter != null) {
                    BeautyRender.this.mBeautyFilter.setBeauty(f16, f17, f18);
                }
            }
        });
    }
}
