package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.art.BaibianFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TransXinXianFilter extends BaseFilter {
    public TransXinXianFilter() {
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
        gPUImageLookupFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.decodeBitmap("filter/egWeizhidao1/eftXinxian/xinxian_lf.png"), 33986, true));
        baibianFilter.setNextFilter(gPUImageLookupFilter, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
