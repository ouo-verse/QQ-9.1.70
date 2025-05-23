package com.tencent.aekit.openrender.internal;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.util.RenderMonitor;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoFilterBase extends AEChainI implements AEFilterI {
    static IPatchRedirector $redirector_ = null;
    private static final String BASIC_VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 tMat;\nvoid main(void)\n{\n   gl_Position = Projection * Modelview *position;\n   vec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\n   textureCoordinate = tmp.xy;\n}";
    public static final String DefaultFragmentShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    private static boolean mDumpFilterParams;
    protected String dataPath;
    private String fragmentShader;
    protected int height;
    private Map<String, AttributeParam> mAttrParams;
    private int mCoordNum;
    private AEOpenRenderConfig.DRAW_MODE mDrawMode;
    protected double mFaceDetScale;
    protected int mFilterProjHandle;
    protected float[] mFilterProjMat;
    protected int mFilterViewHandle;
    protected float[] mFilterViewMat;
    private Map<String, UniformParam> mParamList;
    private int mRenderMode;
    protected int mSTextureHandle;
    protected float[] mTMat;
    protected int mTMatHandle;
    protected Shader shader;
    private int srcTexture;
    private String vertexShader;
    protected int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 43)) {
            redirector.redirect((short) 43);
        } else {
            mDumpFilterParams = false;
        }
    }

    public VideoFilterBase() {
        this("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private void checkInputOutputValid(VideoFilterBase videoFilterBase, Frame frame, int i3) {
        if (i3 == frame.getTextureId()) {
            Log.e("VideoFilterBase", "input and output texture is same!");
            if (AEOpenRenderConfig.isEnableLog()) {
                frame.printBackTracing();
            }
        }
        for (UniformParam uniformParam : videoFilterBase.mParamList.values()) {
            if ((uniformParam instanceof UniformParam.TextureParam) && ((UniformParam.TextureParam) uniformParam).texture[0] == frame.getTextureId()) {
                Log.e("VideoFilterBase", "input and output texture is same!");
                if (AEOpenRenderConfig.isEnableLog()) {
                    frame.printBackTracing();
                }
            }
        }
    }

    private void flipX(boolean z16) {
        if (z16) {
            float[] fArr = this.mFilterViewMat;
            fArr[0] = -fArr[0];
            fArr[1] = -fArr[1];
            fArr[2] = -fArr[2];
            fArr[3] = -fArr[3];
        }
    }

    private void flipY(boolean z16) {
        if (z16) {
            float[] fArr = this.mFilterViewMat;
            fArr[4] = -fArr[4];
            fArr[5] = -fArr[5];
            fArr[6] = -fArr[6];
            fArr[7] = -fArr[7];
        }
    }

    private void initFilter() {
        this.mAttrParams = new HashMap();
        this.mParamList = new HashMap();
        this.mSTextureHandle = -1;
        this.mFilterProjHandle = -1;
        this.mFilterViewHandle = -1;
        this.mTMatHandle = -1;
        Matrix.setIdentityM(this.mFilterProjMat, 0);
        Matrix.setIdentityM(this.mFilterViewMat, 0);
        Matrix.setIdentityM(this.mTMat, 0);
        this.mCoordNum = 4;
        this.mDrawMode = AEOpenRenderConfig.DRAW_MODE.TRIANGLE_FAN;
        this.mRenderMode = AEOpenRenderConfig.glMode;
    }

    private void rotate(int i3) {
        Matrix.setIdentityM(this.mFilterViewMat, 0);
        double d16 = (i3 * 3.1415926d) / 180.0d;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        float[] fArr = this.mFilterViewMat;
        fArr[0] = cos;
        fArr[1] = -sin;
        fArr[4] = sin;
        fArr[5] = cos;
    }

    public static void setDumpFilterParams(boolean z16) {
        mDumpFilterParams = z16;
    }

    public void ApplyGLSLFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        initAttribParams();
        Shader shader = new Shader(this.vertexShader, this.fragmentShader);
        this.shader = shader;
        shader.compile();
        AEOpenRenderConfig.checkStrictMode(isValid(), "filter is not valid");
        if (this.shader == null) {
            return;
        }
        Iterator<UniformParam> it = this.mParamList.values().iterator();
        while (it.hasNext()) {
            it.next().initialParams(this.shader.getShaderProgram());
        }
        Iterator<AttributeParam> it5 = this.mAttrParams.values().iterator();
        while (it5.hasNext()) {
            it5.next().initialParams(this.shader.getShaderProgram());
        }
        this.mSTextureHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "inputImageTexture");
        this.mFilterProjHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "Projection");
        this.mFilterViewHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "Modelview");
        this.mTMatHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "tMat");
    }

    public void OnDrawFrameGLSL() {
        boolean z16;
        Shader shader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        if (this.shader != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AEOpenRenderConfig.checkStrictMode(z16, "shader == null");
        Shader shader2 = this.shader;
        if (shader2 == null) {
            return;
        }
        shader2.bind();
        Iterator<UniformParam> it = this.mParamList.values().iterator();
        while (it.hasNext()) {
            it.next().setParams(this.shader.getShaderProgram());
        }
        for (AttributeParam attributeParam : this.mAttrParams.values()) {
            if (attributeParam.handle >= 0 && (shader = this.shader) != null) {
                attributeParam.setParams(shader.getShaderProgram());
            }
        }
    }

    public void OnDrawFrameGLSLSuper() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        if (this.shader != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AEOpenRenderConfig.checkStrictMode(z16, "shader == null");
        Shader shader = this.shader;
        if (shader == null) {
            return;
        }
        shader.bind();
        Iterator<UniformParam> it = this.mParamList.values().iterator();
        while (it.hasNext()) {
            it.next().setParams(this.shader.getShaderProgram());
        }
    }

    public Frame RenderProcess(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) ? RenderProcess(i3, i16, i17, i16, i17) : (Frame) iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public void addAttribParam(String str, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            addAttribParam(str, fArr, false);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) fArr);
        }
    }

    public void addParam(UniformParam uniformParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) uniformParam);
            return;
        }
        if (uniformParam == null) {
            return;
        }
        UniformParam uniformParam2 = this.mParamList.get(uniformParam.name);
        if (uniformParam2 == null) {
            this.mParamList.put(uniformParam.name, uniformParam);
            Shader shader = this.shader;
            if (shader != null) {
                uniformParam.initialParams(shader.getShaderProgram());
                return;
            }
            return;
        }
        uniformParam.handle = uniformParam2.handle;
        this.mParamList.put(uniformParam.name, uniformParam);
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void apply() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            ApplyGLSLFilter();
        }
    }

    public void beforeRender(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public boolean canUseBlendMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        return false;
    }

    public void clearGLSLSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        Shader shader = this.shader;
        if (shader != null) {
            shader.clear();
        }
        this.shader = null;
        Iterator<UniformParam> it = this.mParamList.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        Iterator<AttributeParam> it5 = this.mAttrParams.values().iterator();
        while (it5.hasNext()) {
            it5.next().clear();
        }
    }

    public String dump() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(String.format("class = %s\n", getClass().getName()));
        sb5.append(String.format("uniform inputImageTexture = %s\n", String.valueOf(this.srcTexture)));
        sb5.append(String.format("uniform Projection = %s\n", Arrays.toString(this.mFilterProjMat)));
        sb5.append(String.format("uniform Modelview = %s\n", Arrays.toString(this.mFilterViewMat)));
        sb5.append(String.format("uniform tMat = %s\n", Arrays.toString(this.mTMat)));
        Iterator<AttributeParam> it = this.mAttrParams.values().iterator();
        while (it.hasNext()) {
            sb5.append(String.format("attribute %s\n", it.next().toString()));
        }
        Iterator<UniformParam> it5 = this.mParamList.values().iterator();
        while (it5.hasNext()) {
            sb5.append(String.format("uniform %s \n", it5.next().toString()));
        }
        boolean[] zArr = new boolean[1];
        GLES20.glGetBooleanv(3042, zArr, 0);
        sb5.append(String.format("blend enable = " + zArr[0] + "\n", new Object[0]));
        GLES20.glGetBooleanv(2929, zArr, 0);
        sb5.append(String.format("depth test enable = " + zArr[0] + "\n", new Object[0]));
        return sb5.toString();
    }

    public AttributeParam getAttribParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (AttributeParam) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        }
        return this.mAttrParams.get(str);
    }

    public int getProgramIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.shader.getShaderProgram();
    }

    public void initAttribParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.mAttrParams.get("position") == null) {
            setPositions(AEOpenRenderConfig.ORIGIN_POSITION_COORDS);
        }
        if (this.mAttrParams.get("inputTextureCoordinate") == null) {
            setTexCords(AEOpenRenderConfig.ORIGIN_TEX_COORDS);
        }
    }

    public void initParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        Shader shader = this.shader;
        if (shader != null && shader.getShaderProgram() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public Frame render(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Frame) iPatchRedirector.redirect((short) 28, (Object) this, (Object) frame);
        }
        return RenderProcess(frame.getTextureId(), frame.width, frame.height);
    }

    public boolean renderTexture(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        this.srcTexture = i3;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glUniform1i(this.mSTextureHandle, 0);
        GLES20.glUniformMatrix4fv(this.mFilterProjHandle, 1, false, FloatBuffer.wrap(this.mFilterProjMat));
        GLES20.glUniformMatrix4fv(this.mFilterViewHandle, 1, false, FloatBuffer.wrap(this.mFilterViewMat));
        GLES20.glUniformMatrix4fv(this.mTMatHandle, 1, false, FloatBuffer.wrap(this.mTMat));
        if (mDumpFilterParams) {
            RenderMonitor.record(getClass().getSimpleName(), dump());
        }
        AEOpenRenderConfig.DRAW_MODE draw_mode = this.mDrawMode;
        if (draw_mode == AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP) {
            GLES20.glDrawArrays(5, 0, this.mCoordNum);
        } else if (draw_mode == AEOpenRenderConfig.DRAW_MODE.TRIANGLES) {
            GLES20.glDrawArrays(4, 0, this.mCoordNum);
        } else if (draw_mode == AEOpenRenderConfig.DRAW_MODE.TRIANGLE_FAN) {
            GLES20.glDrawArrays(6, 0, this.mCoordNum);
        } else if (draw_mode == AEOpenRenderConfig.DRAW_MODE.LINES) {
            GLES20.glDrawArrays(1, 0, this.mCoordNum);
        } else if (draw_mode == AEOpenRenderConfig.DRAW_MODE.LINES_STRIP) {
            GLES20.glDrawArrays(3, 0, this.mCoordNum);
        } else if (draw_mode == AEOpenRenderConfig.DRAW_MODE.POINTS) {
            GLES20.glDrawArrays(0, 0, this.mCoordNum);
        }
        int i18 = this.mRenderMode;
        if (i18 == 0) {
            GLES20.glFinish();
        } else if (i18 == 1) {
            GLES20.glFlush();
        }
        return true;
    }

    public boolean setCoordNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, i3)).booleanValue();
        }
        this.mCoordNum = i3;
        return true;
    }

    public void setDrawMode(AEOpenRenderConfig.DRAW_MODE draw_mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) draw_mode);
        } else {
            this.mDrawMode = draw_mode;
        }
    }

    public boolean setGrayCords(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) fArr)).booleanValue();
        }
        addAttribParam("inputGrayTextureCoordinate", fArr);
        return true;
    }

    public boolean setPositions(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) fArr)).booleanValue();
        }
        addAttribParam("position", fArr);
        return true;
    }

    public boolean setRenderMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        this.mRenderMode = i3;
        return true;
    }

    public void setRotationAndFlip(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        rotate(i3);
        flipX(z16);
        flipY(z17);
    }

    public boolean setTexCords(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) fArr)).booleanValue();
        }
        addAttribParam("inputTextureCoordinate", fArr);
        return true;
    }

    public void updateFilterShader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2);
        } else {
            this.vertexShader = str;
            this.fragmentShader = str2;
        }
    }

    public boolean updateMatrix(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, (Object) fArr)).booleanValue();
        }
        if (fArr != null && fArr.length >= 16) {
            this.mTMat = Arrays.copyOf(fArr, fArr.length);
            return true;
        }
        return false;
    }

    @Override // com.tencent.aekit.openrender.internal.AEFilterI
    public void updatePreview(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, obj);
    }

    public void updateVideoSize(int i3, int i16, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), Double.valueOf(d16));
            return;
        }
        this.width = i3;
        this.height = i16;
        this.mFaceDetScale = d16;
    }

    public VideoFilterBase(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.mFilterProjMat = new float[16];
        this.mFilterViewMat = new float[16];
        this.mTMat = new float[16];
        this.srcTexture = 0;
        initFilter();
        this.vertexShader = str;
        this.fragmentShader = str2;
    }

    public void RenderProcess(int i3, int i16, int i17, int i18, double d16, Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Double.valueOf(d16), frame);
            return;
        }
        beforeRender(i3, i16, i17);
        frame.bindFrame(i18, i16, i17, d16);
        OnDrawFrameGLSL();
        renderTexture(i3, i16, i17);
    }

    public void addAttribParam(String str, float[] fArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, fArr, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AttributeParam attributeParam = this.mAttrParams.get(str);
        if (attributeParam == null) {
            attributeParam = new AttributeParam(str, fArr, z16);
            Shader shader = this.shader;
            if (shader != null) {
                attributeParam.initialParams(shader.getShaderProgram());
            }
            this.mAttrParams.put(str, attributeParam);
        }
        attributeParam.setVertices(fArr);
    }

    public boolean setPositions(float[] fArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, fArr, Boolean.valueOf(z16))).booleanValue();
        }
        addAttribParam("position", fArr, z16);
        return true;
    }

    public boolean setTexCords(float[] fArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, fArr, Boolean.valueOf(z16))).booleanValue();
        }
        addAttribParam("inputTextureCoordinate", fArr, z16);
        return true;
    }

    public void updatePreview(Object obj, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return;
        }
        iPatchRedirector.redirect((short) 26, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public void updateFilterShader(Shader shader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) shader);
        } else {
            this.vertexShader = shader.getVertexShaderSource();
            this.fragmentShader = shader.getFragmentShaderSource();
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEFilterI
    public Frame RenderProcess(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) ? render(frame) : (Frame) iPatchRedirector.redirect((short) 31, (Object) this, (Object) frame);
    }

    public Frame RenderProcess(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Frame) iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
        }
        beforeRender(i3, i16, i17);
        Frame frame = FrameBufferCache.getInstance().get(i18, i19);
        frame.bindFrame(-1, i18, i19, 0.0d);
        OnDrawFrameGLSL();
        renderTexture(i3, i16, i17);
        checkInputOutputValid(this, frame, i3);
        return frame;
    }

    public void addAttribParam(AttributeParam attributeParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) attributeParam);
            return;
        }
        if (attributeParam == null) {
            return;
        }
        AttributeParam attributeParam2 = this.mAttrParams.get(attributeParam.name);
        if (attributeParam2 == null) {
            attributeParam2 = new AttributeParam(attributeParam.name, attributeParam.vertices, attributeParam.perVertexFloat, false);
            Shader shader = this.shader;
            if (shader != null) {
                attributeParam2.initialParams(shader.getShaderProgram());
            }
            this.mAttrParams.put(attributeParam.name, attributeParam2);
        }
        attributeParam2.setVertices(attributeParam.vertices);
        attributeParam2.perVertexFloat = attributeParam.perVertexFloat;
    }

    public VideoFilterBase(String str) {
        this(BASIC_VERTEX_SHADER, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
    }

    public VideoFilterBase(Shader shader) {
        this(shader.getVertexShaderSource(), shader.getFragmentShaderSource());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) shader);
    }
}
