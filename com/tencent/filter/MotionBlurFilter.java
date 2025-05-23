package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MotionBlurFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private static String FRAGMENT_SHADER;
    private static String VERTEXT_SHADER;
    private BaseFilter filter1;
    private float mBlurAngle;
    private float mBlurSize;
    private float mHeight;
    private float mWidth;
    private Frame newFrame;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13557);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            VERTEXT_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform vec2 directionalTexelStep;\n \n varying vec2 textureCoordinate;\n varying vec2 oneStepBackTextureCoordinate;\n varying vec2 twoStepsBackTextureCoordinate;\n varying vec2 threeStepsBackTextureCoordinate;\n varying vec2 fourStepsBackTextureCoordinate;\n varying vec2 oneStepForwardTextureCoordinate;\n varying vec2 twoStepsForwardTextureCoordinate;\n varying vec2 threeStepsForwardTextureCoordinate;\n varying vec2 fourStepsForwardTextureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     \n     textureCoordinate = inputTextureCoordinate.xy;\n     oneStepBackTextureCoordinate = inputTextureCoordinate.xy - directionalTexelStep;\n     twoStepsBackTextureCoordinate = inputTextureCoordinate.xy - 2.0 * directionalTexelStep;\n     threeStepsBackTextureCoordinate = inputTextureCoordinate.xy - 3.0 * directionalTexelStep;\n     fourStepsBackTextureCoordinate = inputTextureCoordinate.xy - 4.0 * directionalTexelStep;\n     oneStepForwardTextureCoordinate = inputTextureCoordinate.xy + directionalTexelStep;\n     twoStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 2.0 * directionalTexelStep;\n     threeStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 3.0 * directionalTexelStep;\n     fourStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 4.0 * directionalTexelStep;\n }";
            FRAGMENT_SHADER = "precision highp float;\n \n uniform sampler2D inputImageTexture;\n \n varying vec2 textureCoordinate;\n varying vec2 oneStepBackTextureCoordinate;\n varying vec2 twoStepsBackTextureCoordinate;\n varying vec2 threeStepsBackTextureCoordinate;\n varying vec2 fourStepsBackTextureCoordinate;\n varying vec2 oneStepForwardTextureCoordinate;\n varying vec2 twoStepsForwardTextureCoordinate;\n varying vec2 threeStepsForwardTextureCoordinate;\n varying vec2 fourStepsForwardTextureCoordinate;\n \n void main()\n {\n     lowp vec4 fragmentColor = texture2D(inputImageTexture, textureCoordinate) * 0.18;\n     fragmentColor += texture2D(inputImageTexture, oneStepBackTextureCoordinate) * 0.15;\n     fragmentColor += texture2D(inputImageTexture, twoStepsBackTextureCoordinate) *  0.12;\n     fragmentColor += texture2D(inputImageTexture, threeStepsBackTextureCoordinate) * 0.09;\n     fragmentColor += texture2D(inputImageTexture, fourStepsBackTextureCoordinate) * 0.05;\n     fragmentColor += texture2D(inputImageTexture, oneStepForwardTextureCoordinate) * 0.15;\n     fragmentColor += texture2D(inputImageTexture, twoStepsForwardTextureCoordinate) *  0.12;\n     fragmentColor += texture2D(inputImageTexture, threeStepsForwardTextureCoordinate) * 0.09;\n     fragmentColor += texture2D(inputImageTexture, fourStepsForwardTextureCoordinate) * 0.05;\n\n     gl_FragColor = fragmentColor;\n }";
        }
    }

    public MotionBlurFilter() {
        super(VERTEXT_SHADER, FRAGMENT_SHADER);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.newFrame = new Frame();
        this.filter1 = new BaseFilter(VERTEXT_SHADER, FRAGMENT_SHADER);
        this.mBlurSize = 0.0f;
        this.mBlurAngle = 0.0f;
    }

    private void recalculateTexelOffsets() {
        float[] fArr = new float[2];
        float f16 = this.mHeight / this.mWidth;
        float f17 = this.mBlurSize;
        if (f17 <= 2.0f) {
            fArr[0] = (float) (((f17 * Math.cos((this.mBlurAngle * 3.141592653589793d) / 180.0d)) * f16) / this.mWidth);
            fArr[1] = (float) ((this.mBlurSize * Math.sin((this.mBlurAngle * 3.141592653589793d) / 180.0d)) / this.mWidth);
            addParam(new UniformParam.FloatsParam("directionalTexelStep", fArr));
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            this.filter1.addParam(new UniformParam.FloatsParam("directionalTexelStep", fArr));
            return;
        }
        double d16 = f16;
        fArr[0] = (float) (((Math.cos((this.mBlurAngle * 3.141592653589793d) / 180.0d) * 2.0d) * d16) / this.mWidth);
        fArr[1] = (float) ((Math.sin((this.mBlurAngle * 3.141592653589793d) / 180.0d) * 2.0d) / this.mWidth);
        addParam(new UniformParam.FloatsParam("directionalTexelStep", fArr));
        fArr[0] = (float) ((((this.mBlurSize - 2.0f) * Math.cos((this.mBlurAngle * 3.141592653589793d) / 180.0d)) * d16) / this.mWidth);
        fArr[1] = (float) (((this.mBlurSize - 2.0f) * Math.sin((this.mBlurAngle * 3.141592653589793d) / 180.0d)) / this.mWidth);
        this.filter1.addParam(new UniformParam.FloatsParam("directionalTexelStep", fArr));
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.mWidth = f16;
        this.mHeight = f17;
        setNextFilter(this.filter1, null);
        recalculateTexelOffsets();
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void beforeRender(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        float f16 = i16;
        if (f16 != this.mWidth || i17 != this.mHeight) {
            this.mWidth = f16;
            this.mHeight = i17;
            recalculateTexelOffsets();
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSLSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.clearGLSLSelf();
        Frame frame = this.newFrame;
        if (frame != null) {
            frame.clear();
        }
    }

    @Override // com.tencent.filter.BaseFilter, com.tencent.aekit.openrender.internal.AEChainI
    public Frame render(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Frame) iPatchRedirector.redirect((short) 3, (Object) this, (Object) frame);
        }
        RenderProcess(frame.getTextureId(), frame.width, frame.height, -1, 0.0d, this.newFrame);
        return this.newFrame;
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        if (map.containsKey("blurSize")) {
            this.mBlurSize = ((Float) map.get("blurSize")).floatValue();
        }
        if (map.containsKey("blurAngle")) {
            this.mBlurAngle = ((Float) map.get("blurAngle")).floatValue();
        }
        if (getProgramIds() > 0) {
            recalculateTexelOffsets();
        }
    }
}
