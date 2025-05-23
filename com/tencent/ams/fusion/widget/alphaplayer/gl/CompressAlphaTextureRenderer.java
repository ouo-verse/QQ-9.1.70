package com.tencent.ams.fusion.widget.alphaplayer.gl;

import com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CompressAlphaTextureRenderer extends AlphaTextureRenderer {
    static IPatchRedirector $redirector_;

    public CompressAlphaTextureRenderer(Object obj, int i3, int i16, TextureSurfaceRenderer.RendererStatusChangeListener rendererStatusChangeListener) {
        this(obj, i3, i16, ScaleType.FIT_CENTER, rendererStatusChangeListener, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), rendererStatusChangeListener);
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.AlphaTextureRenderer
    public String getFragmentShaderCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;varying highp vec2 textureCoordinateRGB;varying highp vec2 textureCoordinateAlpha;void main () {    highp vec4 rgbColor = texture2D(texture, textureCoordinateRGB);    highp vec4 alphaColor = texture2D(texture, textureCoordinateAlpha);    float off = mod(gl_FragCoord.x, 3.0);    if (off < 0.5 || off > 2.8) {      gl_FragColor = vec4(rgbColor.rgb * alphaColor.r, alphaColor.r);    } else if (off < 1.5) {      gl_FragColor = vec4(rgbColor.rgb * alphaColor.g, alphaColor.g);    } else {      gl_FragColor = vec4(rgbColor.rgb * alphaColor.b, alphaColor.b);    }}";
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.AlphaTextureRenderer
    protected float[] getTextureCoordinates() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (float[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f, 0.0f, 1.0f};
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.AlphaTextureRenderer
    protected int getTrueVideoWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return (int) (this.videoWidth * 0.75d);
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.AlphaTextureRenderer
    public String getVertexShaderCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "attribute vec4 vPosition;attribute vec4 vTexCoordinate;varying vec2 textureCoordinateRGB;varying vec2 textureCoordinateAlpha;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;   textureCoordinateRGB = vec2((textureTransform * vTexCoordinate).x, (textureTransform * vTexCoordinate).y);   textureCoordinateAlpha = vec2(((textureTransform * vec4(vTexCoordinate.x/3.0 + 0.75, vTexCoordinate.y, vTexCoordinate.z, vTexCoordinate.w))).x, (textureTransform * vTexCoordinate).y);}";
    }

    public CompressAlphaTextureRenderer(Object obj, int i3, int i16, ScaleType scaleType, TextureSurfaceRenderer.RendererStatusChangeListener rendererStatusChangeListener, Executor executor) {
        super(obj, i3, i16, scaleType, rendererStatusChangeListener, executor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), scaleType, rendererStatusChangeListener, executor);
    }
}
