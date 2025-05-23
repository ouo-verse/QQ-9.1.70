package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.filter.art.BaibianFilter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WeiZhiDaoFilters {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class KaFeiFilter extends BaseFilter {
        public KaFeiFilter() {
            super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            BaibianFilter baibianFilter = new BaibianFilter(0, null, 0.3f, 0.5f, 0.0f, 0.12f, 0.02f);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            baibianFilter.setParameterDic(hashMap);
            setNextFilter(baibianFilter, null);
            GPUImageLookupFilter gPUImageLookupFilter = new GPUImageLookupFilter();
            gPUImageLookupFilter.addParam(new TextureResParam("inputImageTexture2", "weizhidao/kafei_lf.png", 33986));
            baibianFilter.setNextFilter(gPUImageLookupFilter, null);
            super.applyFilterChain(z16, f16, f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class MeiWeiFilter extends BaseFilter {
        public MeiWeiFilter() {
            super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            BaibianFilter baibianFilter = new BaibianFilter(0, null, 0.3f, 0.5f, 0.0f, 0.12f, 0.02f);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            baibianFilter.setParameterDic(hashMap);
            setNextFilter(baibianFilter, null);
            GPUImageLookupFilter gPUImageLookupFilter = new GPUImageLookupFilter();
            gPUImageLookupFilter.addParam(new TextureResParam("inputImageTexture2", "weizhidao/meiwei_lf.png", 33986));
            baibianFilter.setNextFilter(gPUImageLookupFilter, null);
            super.applyFilterChain(z16, f16, f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TianPinFilter extends BaseFilter {
        public TianPinFilter() {
            super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            BaibianFilter baibianFilter = new BaibianFilter(0, null, 0.3f, 0.5f, 0.0f, 0.12f, 0.02f);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            baibianFilter.setParameterDic(hashMap);
            setNextFilter(baibianFilter, null);
            GPUImageLookupFilter gPUImageLookupFilter = new GPUImageLookupFilter();
            gPUImageLookupFilter.addParam(new TextureResParam("inputImageTexture2", "weizhidao/tianpin_lf.png", 33986));
            baibianFilter.setNextFilter(gPUImageLookupFilter, null);
            super.applyFilterChain(z16, f16, f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class XiCanFilter extends BaseFilter {
        public XiCanFilter() {
            super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            BaibianFilter baibianFilter = new BaibianFilter(0, null, 0.3f, 0.5f, 0.0f, 0.12f, 0.02f);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            baibianFilter.setParameterDic(hashMap);
            setNextFilter(baibianFilter, null);
            GPUImageLookupFilter gPUImageLookupFilter = new GPUImageLookupFilter();
            gPUImageLookupFilter.addParam(new TextureResParam("inputImageTexture2", "weizhidao/xican_lf.png", 33986));
            baibianFilter.setNextFilter(gPUImageLookupFilter, null);
            super.applyFilterChain(z16, f16, f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class XinXianFilter extends BaseFilter {
        public XinXianFilter() {
            super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            BaibianFilter baibianFilter = new BaibianFilter(0, null, 0.3f, 0.5f, 0.0f, 0.12f, 0.02f);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            baibianFilter.setParameterDic(hashMap);
            setNextFilter(baibianFilter, null);
            GPUImageLookupFilter gPUImageLookupFilter = new GPUImageLookupFilter();
            gPUImageLookupFilter.addParam(new TextureResParam("inputImageTexture2", "weizhidao/xinxian_lf.png", 33986));
            baibianFilter.setNextFilter(gPUImageLookupFilter, null);
            super.applyFilterChain(z16, f16, f17);
        }
    }
}
