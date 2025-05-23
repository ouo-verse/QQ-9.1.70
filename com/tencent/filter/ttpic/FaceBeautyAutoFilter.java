package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.TextureResParam;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.view.RendererUtils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FaceBeautyAutoFilter extends BaseFilter {
    public static final int FBPFQ_HIGH = 3;
    public static final int FBPFQ_LOW = 1;
    public static final int FBPFQ_MEDIUM = 2;
    public static final int FBPFQ_NONE = 0;
    public static final int FBPF_BAIXI = 3;
    public static final int FBPF_HONGRUN = 2;
    public static final int FBPF_MENGHUAN = 5;
    public static final int FBPF_NONE = 0;
    public static final int FBPF_ROUNEN = 7;
    public static final int FBPF_TIANMEI = 4;
    public static final int FBPF_YANGGUANG = 6;
    public static final int FBPF_ZIRAN = 1;
    private int filterType;
    private int quality;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class FocusBlurFilter extends BaseFilter {
        private float blurSize;
        private float lastScaleFilt;
        private int paramTEXTRUEID;

        public FocusBlurFilter(int i3, float f16) {
            super(BaseFilter.getFragmentShader(3));
            this.blurSize = 0.0f;
            this.paramTEXTRUEID = 0;
            this.lastScaleFilt = f16;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.blurSize = 1.0f;
                    }
                } else {
                    this.blurSize = 0.67f;
                }
            } else {
                this.blurSize = 0.62f;
            }
            this.blurSize *= 2.0f;
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            this.paramTEXTRUEID = RendererUtils.createTexture();
            super.applyFilterChain(z16, f16, f17);
        }

        @Override // com.tencent.filter.BaseFilter
        public void beforeRender(int i3, int i16, int i17) {
            QImage saveTexture2QImage = RendererUtils.saveTexture2QImage(i3, i16, i17);
            FaceBeautyAutoFilter.nativeFastBlur(saveTexture2QImage, this.blurSize * this.lastScaleFilt);
            GLSLRender.nativeTextImage(saveTexture2QImage, this.paramTEXTRUEID);
            saveTexture2QImage.Dispose();
        }

        @Override // com.tencent.filter.BaseFilter
        public void clearGLSL() {
            RendererUtils.clearTexture(this.paramTEXTRUEID);
            super.clearGLSL();
        }

        @Override // com.tencent.filter.BaseFilter
        public boolean renderTexture(int i3, int i16, int i17) {
            return super.renderTexture(this.paramTEXTRUEID, i16, i17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class MicCureFaceFilter extends BaseFilter {
        private final String[] fileNames;
        private int filterType;
        private final float[] qualities;
        private int quality;

        public MicCureFaceFilter(int i3, int i16) {
            super(BaseFilter.getFragmentShader(97));
            this.fileNames = new String[]{"error.file", "yijian_ziran", "yijian_hongrun", "yijian_baixi", "yijian_tianmei", "yijian_menghuan", "yijian_yangguang", "yijian_rounen"};
            this.qualities = new float[]{1.0f, 1.0f, 0.95f, 0.9f};
            this.filterType = i3;
            this.quality = i16;
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            float[] fArr = this.qualities;
            int i3 = this.quality;
            float f18 = fArr[i3];
            int i16 = this.filterType;
            if (i16 == 5) {
                if (i3 == 1) {
                    f18 = 0.912f;
                } else if (i3 == 2) {
                    f18 = 0.95f;
                } else if (i3 == 3) {
                    f18 = 0.88f;
                }
            }
            if (i16 == 4) {
                if (i3 == 3) {
                    f18 = 1.1f;
                } else if (i3 == 2) {
                    f18 = 1.0f;
                }
            }
            this.glslProgramShader = BaseFilter.getFragmentShader(97);
            addParam(new TextureResParam("inputImageTexture2", "yijian/" + this.fileNames[this.filterType] + "_" + this.quality + ".jpg", 33986));
            addParam(new UniformParam.FloatParam(CustomImageProps.QUALITY, f18));
            addParam(new UniformParam.FloatParam("add_red", 0.0f));
            addParam(new UniformParam.FloatParam("red_m", 0.0f));
            addParam(new UniformParam.FloatParam("green_m", 0.0f));
            addParam(new UniformParam.FloatParam("blue_m", 0.0f));
            super.applyFilterChain(z16, f16, f17);
        }
    }

    public FaceBeautyAutoFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.quality = 2;
        this.filterType = 1;
    }

    public static native void nativeFastBlur(QImage qImage, float f16);

    /* JADX WARN: Removed duplicated region for block: B:14:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateToneFilter(BaseFilter baseFilter) {
        double d16;
        double d17;
        double d18;
        double d19;
        double d26;
        double d27;
        double d28;
        double d29;
        double d36;
        double d37;
        double d38;
        double d39;
        double d46;
        double d47;
        double d48;
        double d49;
        int i3 = this.filterType;
        int i16 = this.quality;
        if (i3 == 1) {
            d16 = 0.09d;
            d17 = 0.09d;
            d18 = 0.15d;
        } else {
            d16 = 0.0d;
            d17 = 0.0d;
            d18 = 0.0d;
        }
        if (i3 == 3) {
            d19 = -0.06d;
            d18 = 0.07d;
        } else {
            d19 = 0.0d;
        }
        if (i3 == 4) {
            if (i16 == 1) {
                d47 = 0.455d;
                d48 = 0.17d;
                d49 = 0.177d;
            } else {
                if (i16 == 2) {
                    d29 = 0.375d;
                    d36 = 0.125d;
                    d27 = 0.26d;
                    d28 = 0.07d;
                    d26 = 0.62d;
                    if (i3 == 2) {
                        if (i16 == 1) {
                            d16 = 0.121d;
                            d26 = 0.354d;
                        } else if (i16 == 2) {
                            d16 = 0.32d;
                            d26 = 0.35d;
                            d36 = -0.1d;
                        } else if (i16 == 3) {
                            d16 = 0.366d;
                            d26 = 0.554d;
                        }
                    }
                    double d56 = d36;
                    if (i3 == 5) {
                        d19 = -0.08d;
                    }
                    if (i3 == 7) {
                        d39 = 0.15d;
                        d37 = 0.1d;
                        d38 = -0.08d;
                    } else {
                        d37 = d26;
                        d38 = d19;
                        d39 = d27;
                    }
                    if (i3 == 6) {
                        d46 = -0.12d;
                        d39 = 0.16d;
                    } else {
                        d46 = d38;
                    }
                    baseFilter.addParam(new UniformParam.FloatParam("percent1", (float) d16));
                    baseFilter.addParam(new UniformParam.FloatParam("percent2", (float) d37));
                    baseFilter.addParam(new UniformParam.FloatParam("percent3", (float) d29));
                    baseFilter.addParam(new UniformParam.FloatParam("percent4", (float) d28));
                    baseFilter.addParam(new UniformParam.FloatParam("percent5", (float) d46));
                    baseFilter.addParam(new UniformParam.FloatParam("percent6", (float) d56));
                    baseFilter.addParam(new UniformParam.FloatParam("percent7", (float) d39));
                }
                if (i16 == 3) {
                    d47 = 0.824d;
                    d48 = 0.461d;
                    d49 = 0.152d;
                }
            }
            double d57 = d49;
            d36 = 0.2d;
            d27 = d18;
            d29 = d48;
            d26 = d47;
            d28 = d57;
            if (i3 == 2) {
            }
            double d562 = d36;
            if (i3 == 5) {
            }
            if (i3 == 7) {
            }
            if (i3 == 6) {
            }
            baseFilter.addParam(new UniformParam.FloatParam("percent1", (float) d16));
            baseFilter.addParam(new UniformParam.FloatParam("percent2", (float) d37));
            baseFilter.addParam(new UniformParam.FloatParam("percent3", (float) d29));
            baseFilter.addParam(new UniformParam.FloatParam("percent4", (float) d28));
            baseFilter.addParam(new UniformParam.FloatParam("percent5", (float) d46));
            baseFilter.addParam(new UniformParam.FloatParam("percent6", (float) d562));
            baseFilter.addParam(new UniformParam.FloatParam("percent7", (float) d39));
        }
        d26 = d17;
        d27 = d18;
        d28 = 0.0d;
        d29 = 0.0d;
        d36 = 0.0d;
        if (i3 == 2) {
        }
        double d5622 = d36;
        if (i3 == 5) {
        }
        if (i3 == 7) {
        }
        if (i3 == 6) {
        }
        baseFilter.addParam(new UniformParam.FloatParam("percent1", (float) d16));
        baseFilter.addParam(new UniformParam.FloatParam("percent2", (float) d37));
        baseFilter.addParam(new UniformParam.FloatParam("percent3", (float) d29));
        baseFilter.addParam(new UniformParam.FloatParam("percent4", (float) d28));
        baseFilter.addParam(new UniformParam.FloatParam("percent5", (float) d46));
        baseFilter.addParam(new UniformParam.FloatParam("percent6", (float) d5622));
        baseFilter.addParam(new UniformParam.FloatParam("percent7", (float) d39));
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        float f18;
        this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(99));
        setNextFilter(baseFilter, null);
        updateToneFilter(baseFilter);
        MicCureFaceFilter micCureFaceFilter = new MicCureFaceFilter(this.filterType, this.quality);
        baseFilter.setNextFilter(micCureFaceFilter, null);
        if (this.filterType == 5) {
            float min = Math.min(f17, f16);
            BaseFilter baseFilter2 = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
            baseFilter2.scaleFact = Math.min(400.0f / min, 1.0f);
            micCureFaceFilter.setNextFilter(baseFilter2, null);
            FocusBlurFilter focusBlurFilter = new FocusBlurFilter(this.quality, baseFilter2.scaleFact);
            baseFilter2.setNextFilter(focusBlurFilter, null);
            BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(3));
            int i3 = this.quality;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        f18 = 0.0f;
                    } else {
                        f18 = 0.573f;
                    }
                } else {
                    f18 = 0.78f;
                }
            } else {
                f18 = 0.89f;
            }
            focusBlurFilter.setNextFilter(baseFilter3, new int[]{this.srcTextureIndex + 3});
            focusBlurFilter.addParam(new UniformParam.FloatParam("filterAdjustParam", 1.0f - f18));
        }
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void setEffectIndex(int i3) {
        this.filterType = i3;
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        if (map.containsKey("effectIndex")) {
            this.filterType = ((Integer) map.get("effectIndex")).intValue();
        }
        if (map.containsKey("filter_type")) {
            this.filterType = ((Integer) map.get("filter_type")).intValue();
        }
        if (map.containsKey("filter_quality")) {
            this.quality = ((Integer) map.get("filter_quality")).intValue();
        }
    }
}
