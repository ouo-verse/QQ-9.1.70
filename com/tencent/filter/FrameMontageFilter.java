package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FrameMontageFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private Bitmap imagebitmap;
    private int type;

    public FrameMontageFilter(int i3) {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.imagebitmap = null;
            this.type = i3;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        float f18;
        float f19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        Bitmap bitmap = this.imagebitmap;
        if (bitmap == null) {
            super.applyFilterChain(z16, f16, f17);
            return;
        }
        addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", bitmap, 33986, false));
        if (this.type == 0) {
            this.glslProgramShader = BaseFilter.getFragmentShader(51);
            float floor = (float) Math.floor((f17 / this.imagebitmap.getHeight()) + 0.999999d);
            float floor2 = (float) Math.floor((f16 / this.imagebitmap.getWidth()) + 0.999999d);
            addParam(new UniformParam.FloatParam("height_scale", floor));
            addParam(new UniformParam.FloatParam("width_scale", floor2));
        } else {
            this.glslVertextShader = BaseFilter.getVertexShader(6);
            this.glslProgramShader = BaseFilter.getFragmentShader(50);
            float height = this.imagebitmap.getHeight() / this.imagebitmap.getWidth();
            int i3 = this.type;
            float f26 = 0.0f;
            if (i3 == 1) {
                this.glslVertextShader = BaseFilter.getVertexShader(7);
                float f27 = f16 * height;
                if (f17 > f27) {
                    f19 = ((f17 - f27) / 2.0f) / f17;
                    f26 = f19;
                    f18 = 0.0f;
                    addParam(new UniformParam.FloatParam("height_offset", f26));
                    addParam(new UniformParam.FloatParam("width_offset", f18));
                } else {
                    f18 = ((f16 - (f17 / height)) / 2.0f) / f16;
                    addParam(new UniformParam.FloatParam("height_offset", f26));
                    addParam(new UniformParam.FloatParam("width_offset", f18));
                }
            } else {
                if (i3 == 2) {
                    this.glslVertextShader = BaseFilter.getVertexShader(8);
                    float f28 = f16 * height;
                    if (f17 < f28) {
                        f19 = ((f28 - f17) / 2.0f) / f28;
                        f26 = f19;
                        f18 = 0.0f;
                    } else {
                        float f29 = f17 / height;
                        f18 = ((f29 - f16) / 2.0f) / f29;
                    }
                } else {
                    f18 = 0.0f;
                }
                addParam(new UniformParam.FloatParam("height_offset", f26));
                addParam(new UniformParam.FloatParam("width_offset", f18));
            }
        }
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Bitmap bitmap = this.imagebitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.imagebitmap = null;
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
        if (map.containsKey("image")) {
            this.imagebitmap = (Bitmap) map.get("image");
        }
        if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
    }
}
