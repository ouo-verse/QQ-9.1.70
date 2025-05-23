package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.ads.data.AdParam;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import tl.h;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MangaFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private Bitmap graybitmap;
    private int type;

    public MangaFilter(int i3) {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.graybitmap = null;
            this.type = i3;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter;
        BaseFilter baseFilter2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getVertexShader(9), BaseFilter.getFragmentShader(89));
        setNextFilter(baseFilter3, null);
        if (this.graybitmap == null) {
            BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getVertexShader(10), BaseFilter.getFragmentShader(94));
            baseFilter3.setNextFilter(baseFilter4, null);
            if (GLES20.glGetString(7937).indexOf("PowerVR SGX 540") != -1) {
                baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(96));
            } else {
                baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(96));
            }
            baseFilter4.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex + 2});
            BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getVertexShader(11), BaseFilter.getFragmentShader(91));
            baseFilter2.setNextFilter(baseFilter5, new int[]{this.srcTextureIndex + 3});
            baseFilter = new BaseFilter(BaseFilter.getFragmentShader(92));
            baseFilter.addParam(new TextureResParam("inputImageTexture2", "manga/manga.png", 33986));
            baseFilter.addParam(new UniformParam.FloatParam("height_scale", f17 / 64.0f));
            baseFilter.addParam(new UniformParam.FloatParam("width_scale", f16 / 64.0f));
            baseFilter5.setNextFilter(baseFilter, null);
        } else {
            BaseFilter baseFilter6 = new BaseFilter(BaseFilter.getFragmentShader(95));
            baseFilter6.addParam(new TextureResParam("inputImageTexture3", "manga/manga.png", 33987));
            baseFilter6.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", this.graybitmap, 33986, false));
            baseFilter6.addParam(new UniformParam.FloatParam("par", 0.45f));
            baseFilter6.addParam(new UniformParam.FloatParam("height_scale", f17 / 64.0f));
            baseFilter6.addParam(new UniformParam.FloatParam("width_scale", f16 / 64.0f));
            baseFilter3.setNextFilter(baseFilter6, null);
            baseFilter = baseFilter6;
        }
        BaseFilter baseFilter7 = new BaseFilter(BaseFilter.getFragmentShader(93));
        baseFilter7.addParam(new UniformParam.FloatParam("rx", 1.0f));
        baseFilter7.addParam(new UniformParam.FloatParam("ry", 1.0f));
        baseFilter7.addParam(new UniformParam.FloatParam("tx", 0.0f));
        baseFilter7.addParam(new UniformParam.FloatParam(AdParam.TY, 0.0f));
        baseFilter7.addParam(new UniformParam.IntParam("flag", this.type));
        float f18 = 640.0f;
        float f19 = 852.0f;
        if (f16 > 640.0f && f17 > 852.0f) {
            float f26 = f16 / 640.0f;
            float f27 = f17 / 852.0f;
            if (f26 < f27) {
                f19 = f17 / f26;
            } else {
                f18 = f16 / f27;
            }
        } else {
            float f28 = 640.0f / f16;
            float f29 = 852.0f / f17;
            if (f28 < f29) {
                f18 = f16 * f29;
            } else {
                f19 = f17 * f28;
            }
        }
        baseFilter7.addParam(new UniformParam.FloatParam("w", f18));
        baseFilter7.addParam(new UniformParam.FloatParam(h.F, f19));
        baseFilter.setNextFilter(baseFilter7, null);
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Bitmap bitmap = this.graybitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.graybitmap = null;
        }
        super.clearGLSL();
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        if (map.containsKey("graybitmap")) {
            this.graybitmap = (Bitmap) map.get("graybitmap");
        }
        if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
    }
}
