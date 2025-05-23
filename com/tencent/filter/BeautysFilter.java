package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BeautysFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private final int[] curveStatic;
    private int flag;
    private final int[] globalWhiten;
    private int usesmooth;

    public BeautysFilter(int i3, int i16) {
        super(BaseFilter.getFragmentShader(i3));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.curveStatic = new int[]{0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 47, 49, 50, 52, 53, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 80, 82, 83, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 100, 101, 102, 104, 105, 106, 108, 109, 110, 112, 113, 114, 116, 117, 118, 119, 121, 122, 123, 125, 126, 127, 128, 130, 131, 132, 133, 134, 136, 137, 138, 139, 140, 142, 143, 144, 145, 146, 147, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 181, 182, 183, 184, 185, 186, 187, 188, 188, 189, 190, 191, 192, 193, 193, 194, 195, 196, 197, 197, 198, 199, 200, 201, 201, 202, 203, 204, 204, 205, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 219, 219, 220, 221, 221, 222, 222, 223, 224, 224, 225, 226, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 232, 233, 234, 234, 235, 235, 236, 236, 237, 237, 238, 238, 239, 240, 240, 241, 241, 242, 242, 243, 243, 244, 244, 245, 245, 246, 246, 247, 247, 248, 248, 249, 249, 250, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255};
        this.globalWhiten = new int[]{0, 1, 3, 4, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 28, 29, 31, 33, 34, 36, 38, 39, 41, 42, 44, 46, 47, 49, 51, 52, 54, 55, 57, 59, 60, 62, 64, 65, 67, 68, 70, 71, 73, 75, 76, 78, 79, 81, 82, 84, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, 117, 119, 120, 121, 123, 124, 126, 127, 128, 130, 131, 133, 134, 135, 137, 138, 139, 141, 142, 143, 145, 146, 147, 149, 150, 151, 152, 154, 155, 156, 157, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 186, 187, 188, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 208, 209, 210, 211, 211, 212, 213, 214, 214, 215, 216, 216, 217, 218, 218, 219, 219, 220, 221, 221, 222, 223, 223, 224, 224, 225, 225, 226, 226, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, 233, 233, 234, 234, 234, 235, 235, 236, 236, 237, 237, 237, 238, 238, 239, 239, 240, 240, 240, 241, 241, 241, 242, 242, 243, 243, 243, 244, 244, 244, 245, 245, 245, 246, 246, 246, 247, 247, 247, 248, 248, 248, 249, 249, 249, 250, 250, 250, 251, 251, 251, 252, 252, 252, 253, 253, 253, 254, 254, 254, 255};
        this.flag = 0;
        this.usesmooth = i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x020a  */
    @Override // com.tencent.filter.BaseFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter;
        BaseFilter baseFilter2;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        if (isValid()) {
            super.applyFilterChain(z16, f16, f17);
            return;
        }
        this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
        if (this.usesmooth == 1) {
            BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(15));
            baseFilter3.addParam(new UniformParam.FloatParam("radius", 2.0f));
            setNextFilter(baseFilter3, null);
            BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(16));
            baseFilter4.addParam(new UniformParam.FloatParam("radius", 2.0f));
            baseFilter3.setNextFilter(baseFilter4, null);
            baseFilter = new BaseFilter(BaseFilter.getFragmentShader(17));
            baseFilter.addParam(new TextureFloatsParam("inputImageTexture2", this.curveStatic, 33986));
            baseFilter4.setNextFilter(baseFilter, null);
            baseFilter.setNextFilter(new BaseFilter(BaseFilter.getFragmentShader(18)), new int[]{this.srcTextureIndex + 1});
        } else {
            baseFilter = this;
        }
        int i17 = this.flag;
        if (i17 != 1002) {
            switch (i17) {
                case 1:
                    baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(20));
                    baseFilter2.addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
                    break;
                case 2:
                    break;
                case 3:
                    baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(22));
                    baseFilter2.addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
                    break;
                case 4:
                    baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(23));
                    baseFilter2.addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
                    break;
                case 5:
                    baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(24));
                    baseFilter2.addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
                    break;
                case 6:
                    baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(25));
                    baseFilter2.addParam(new TextureFloatsParam("inputImageTexture2", this.globalWhiten, 33986));
                    break;
                case 7:
                    baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(26));
                    baseFilter2.addParam(new TextureResParam("inputImageTexture2", "fennen.png", 33986));
                    break;
                case 8:
                    baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(12));
                    baseFilter2.addParam(new TextureResParam("inputImageTexture2", "gradient.jpg", 33986));
                    break;
                case 9:
                    baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(43));
                    baseFilter2.addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
                    break;
                default:
                    switch (i17) {
                        case 101:
                            baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(41));
                            baseFilter2.addParam(new TextureResParam("inputImageTexture2", "yangguang.png", 33986));
                            break;
                        case 102:
                            baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(42));
                            baseFilter2.addParam(new TextureResParam("inputImageTexture2", "hongrun.png", 33986));
                            break;
                        case 103:
                            baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(40));
                            baseFilter2.addParam(new TextureResParam("inputImageTexture2", "tianmei.png", 33986));
                            break;
                        default:
                            baseFilter2 = null;
                            break;
                    }
            }
            baseFilter.setNextFilter(baseFilter2, null);
            i3 = this.flag;
            if (i3 != 1 && i3 != 8 && i3 >= 1) {
                BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(19));
                baseFilter5.addParam(new TextureResParam("inputImageTexture2", "glowcenter.jpg", 33986));
                baseFilter2.setNextFilter(baseFilter5, null);
                baseFilter2 = baseFilter5;
            }
            i16 = this.flag;
            if (i16 != 9) {
                BaseFilter baseFilter6 = new BaseFilter(BaseFilter.getFragmentShader(4));
                baseFilter6.addParam(new UniformParam.FloatParam("filterAdjustParam", 0.64000005f));
                baseFilter2.setNextFilter(baseFilter6, new int[]{this.srcTextureIndex + 1});
            } else if (i16 == 1002) {
                BaseFilter baseFilter7 = new BaseFilter(BaseFilter.getFragmentShader(4));
                baseFilter7.addParam(new UniformParam.FloatParam("filterAdjustParam", 0.56f));
                baseFilter2.setNextFilter(baseFilter7, new int[]{this.srcTextureIndex + 1});
            }
            super.applyFilterChain(z16, f16, f17);
        }
        baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(21));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        i3 = this.flag;
        if (i3 != 1) {
            BaseFilter baseFilter52 = new BaseFilter(BaseFilter.getFragmentShader(19));
            baseFilter52.addParam(new TextureResParam("inputImageTexture2", "glowcenter.jpg", 33986));
            baseFilter2.setNextFilter(baseFilter52, null);
            baseFilter2 = baseFilter52;
        }
        i16 = this.flag;
        if (i16 != 9) {
        }
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void setEffectIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.flag = i3;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
        } else if (map.containsKey("effectIndex")) {
            this.flag = ((Integer) map.get("effectIndex")).intValue();
        }
    }
}
