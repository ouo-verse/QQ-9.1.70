package com.tencent.av.video.effect.filter;

import android.content.Context;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FilterRender extends BaseRender {
    private static final String TAG = "FilterRender";
    private WeakReference<Context> mContextReference;
    private QQAVImageFilter mFilter;
    private FilterFactory mFilterFactory;

    public FilterRender(Context context) {
        this(context, null);
    }

    @Override // com.tencent.av.video.effect.core.BaseRender
    public void destroy() {
        super.destroy();
        QQAVImageFilter qQAVImageFilter = this.mFilter;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.destroy();
            this.mFilter = null;
        }
    }

    public int getFilterType() {
        QQAVImageFilter qQAVImageFilter = this.mFilter;
        if (qQAVImageFilter != null) {
            return qQAVImageFilter.getQQAVEffectType();
        }
        return -1;
    }

    public void preProcess(int i3, int i16) {
        baseProcess(i3, i16);
        QQAVImageFilter qQAVImageFilter = this.mFilter;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.onOutputSizeChanged(i3, i16);
        }
    }

    @Override // com.tencent.av.video.effect.core.BaseRender
    public EffectTexture process(int i3, int i16, int i17, int i18) {
        EffectTexture process = super.process(i3, i16, i17, i18);
        if (this.mFilter == null) {
            Log.d(TAG, "mFilter = null");
            CommonUtils.glCheckError();
            return process;
        }
        Log.d(TAG, "mFilter = " + this.mFilter + " | filterType = " + this.mFilter.getQQAVEffectType());
        this.mFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
        this.mFilter.onDraw2(process.getTextureId(), this.mOutFbo);
        CommonUtils.glCheckError();
        return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
    }

    public void setFilterPath(final String str) {
        Log.d(TAG, "setFilterPath filterPath = " + str);
        addTaskBeforeProcess(new Runnable() { // from class: com.tencent.av.video.effect.filter.FilterRender.1
            @Override // java.lang.Runnable
            public void run() {
                FilterRender filterRender = FilterRender.this;
                filterRender.mFilter = filterRender.mFilterFactory.getFilter(str);
                if (FilterRender.this.mFilter != null) {
                    FilterRender.this.mFilter.init();
                }
            }
        });
    }

    public FilterRender(Context context, String str) {
        this.mFilter = null;
        this.mContextReference = new WeakReference<>(context);
        this.mFilterFactory = new FilterFactory(context);
        setFilterPath(str);
    }
}
