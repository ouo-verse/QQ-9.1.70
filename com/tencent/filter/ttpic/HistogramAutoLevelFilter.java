package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HistogramAutoLevelFilter extends BaseFilter {
    private float maxRatio;
    private float minRatio;

    public HistogramAutoLevelFilter(float f16) {
        super(BaseFilter.getFragmentShader(65));
        float f17 = f16 * 0.05f;
        this.minRatio = 0.0f + f17;
        this.maxRatio = 1.0f - f17;
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        addParam(new UniformParam.FloatParam("l_threshold_r", 0.1f));
        addParam(new UniformParam.FloatParam("h_threshold_r", 0.1f));
        addParam(new UniformParam.FloatParam("l_threshold_g", 0.1f));
        addParam(new UniformParam.FloatParam("h_threshold_g", 0.1f));
        addParam(new UniformParam.FloatParam("l_threshold_b", 0.1f));
        addParam(new UniformParam.FloatParam("h_threshold_b", 0.1f));
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void beforeRender(int i3, int i16, int i17) {
        int i18;
        QImage saveTexture2QImage = RendererUtils.saveTexture2QImage(i3, i16, i17);
        int[] nativeGetArrayHistogramChannels = saveTexture2QImage.nativeGetArrayHistogramChannels();
        saveTexture2QImage.Dispose();
        int[] iArr = new int[3];
        int[] iArr2 = new int[3];
        for (int i19 = 0; i19 < 3; i19++) {
            int i26 = i19 * 256;
            int i27 = 0;
            for (int i28 = 0; i28 < 256; i28++) {
                i27 += nativeGetArrayHistogramChannels[i26 + i28];
            }
            float f16 = i27;
            int i29 = (int) (this.minRatio * f16);
            int i36 = (int) (f16 * this.maxRatio);
            int i37 = 0;
            int i38 = 0;
            while (true) {
                if (i37 < 256) {
                    i38 += nativeGetArrayHistogramChannels[i26 + i37];
                    if (i38 >= i29) {
                        int i39 = i37;
                        i37++;
                        i18 = i39;
                        break;
                    }
                    i37++;
                } else {
                    i18 = 0;
                    break;
                }
            }
            while (true) {
                if (i37 < 256) {
                    i38 += nativeGetArrayHistogramChannels[i26 + i37];
                    if (i38 >= i36) {
                        break;
                    } else {
                        i37++;
                    }
                } else {
                    i37 = 0;
                    break;
                }
            }
            iArr[i19] = i18;
            iArr2[i19] = i37;
        }
        addParam(new UniformParam.FloatParam("l_threshold_r", iArr[0] / 255.0f));
        addParam(new UniformParam.FloatParam("h_threshold_r", iArr2[0] / 255.0f));
        addParam(new UniformParam.FloatParam("l_threshold_g", iArr[1] / 255.0f));
        addParam(new UniformParam.FloatParam("h_threshold_g", iArr2[1] / 255.0f));
        addParam(new UniformParam.FloatParam("l_threshold_b", iArr[2] / 255.0f));
        addParam(new UniformParam.FloatParam("h_threshold_b", iArr2[2] / 255.0f));
    }

    @Override // com.tencent.filter.BaseFilter
    public boolean renderTexture(int i3, int i16, int i17) {
        return super.renderTexture(i3, i16, i17);
    }

    public HistogramAutoLevelFilter() {
        super(BaseFilter.getFragmentShader(65));
        this.minRatio = 0.001f;
        this.maxRatio = 0.999f;
    }
}
