package com.tencent.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.SoInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BaseFilter extends AEChainI {
    static IPatchRedirector $redirector_ = null;
    public static final String DefaultFragmentShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    private static final String TAG;
    protected String glslProgramShader;
    protected String glslVertextShader;
    private long mGlFilterId;
    protected boolean mIsGPU;
    protected boolean mIsPreviewFilter;
    private BaseFilter mNextFilter;
    protected ParamHelper mParamHelper;
    private Map<String, UniformParam> mParamList;
    private int mProgramIds;
    private int[] mTextureIndexMap;
    public boolean needFlipBlend;
    private boolean needReleaseFrame;
    private float outPutScaleFactor;
    public float scaleFact;
    protected int srcTextureIndex;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12329);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 45)) {
            redirector.redirect((short) 45);
        } else {
            TAG = BaseFilter.class.getSimpleName();
        }
    }

    public BaseFilter(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.scaleFact = 1.0f;
        this.needFlipBlend = false;
        this.mIsGPU = true;
        this.srcTextureIndex = -1;
        this.glslVertextShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}";
        this.mGlFilterId = 0L;
        this.outPutScaleFactor = 1.0f;
        this.needReleaseFrame = false;
        this.mParamList = new HashMap();
        this.mParamHelper = null;
        this.glslVertextShader = str;
        this.glslProgramShader = str2;
    }

    private void applyInternal() {
        setRenderMode(AEOpenRenderConfig.glMode);
        this.mProgramIds = nativeApplyFilter(this.mGlFilterId, 0L);
        Iterator<UniformParam> it = this.mParamList.values().iterator();
        while (it.hasNext()) {
            it.next().initialParams(this.mProgramIds);
        }
    }

    private void checkInputOutputValid(BaseFilter baseFilter, Frame frame, int i3) {
        if (i3 == frame.getTextureId()) {
            Log.e("BaseFilter", "input and output texture is same! Same texture id is " + frame.getTextureId());
            AEOpenRenderConfig.isEnableLog();
        }
        for (UniformParam uniformParam : baseFilter.mParamList.values()) {
            if ((uniformParam instanceof UniformParam.TextureParam) && ((UniformParam.TextureParam) uniformParam).texture[0] == frame.getTextureId()) {
                Log.e("BaseFilter", "input and output texture is same! Same texture id is " + frame.getTextureId());
                AEOpenRenderConfig.isEnableLog();
            }
        }
    }

    private Frame findFrame(Frame frame, int i3) {
        while (frame != null) {
            if (i3 == 0) {
                return frame;
            }
            frame = frame.nextFrame;
            i3--;
        }
        return null;
    }

    public static String getFilterShader(boolean z16, int i3) {
        int i16;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        try {
            return nativeGetFilterShader(i16, i3);
        } catch (UnsatisfiedLinkError e16) {
            LogUtils.e(TAG, e16.toString());
            return "";
        }
    }

    public static String getFragmentShader(int i3) {
        return getFilterShader(true, i3);
    }

    public static int getVersionCode() {
        return nativeGetVersion();
    }

    public static String getVertexShader(int i3) {
        return getFilterShader(false, i3);
    }

    private void initFilterShader(int i3) {
        String str;
        String str2 = this.glslProgramShader;
        if (str2 != null && (str = this.glslVertextShader) != null) {
            try {
                this.mGlFilterId = nativeInitialWithString(this.mGlFilterId, i3, str, str2);
            } catch (UnsatisfiedLinkError e16) {
                LogUtils.e(TAG, e16.toString());
            }
        }
    }

    @SoInfo(libName = "image_filter_common")
    private native int nativeApplyFilter(long j3, long j16);

    @SoInfo(libName = "image_filter_common")
    private native boolean nativeClear(long j3);

    @SoInfo(libName = "image_filter_common")
    public static native String nativeDecrypt(String str);

    @SoInfo(libName = "image_filter_gpu")
    private static native String nativeGetFilterShader(int i3, int i16);

    @SoInfo(libName = "image_filter_common")
    private static native int nativeGetVersion();

    @SoInfo(libName = "image_filter_common")
    private native long nativeInitialWithString(long j3, int i3, String str, String str2);

    @SoInfo(libName = "image_filter_common")
    private native boolean nativeRenderTexture(long j3, int i3, int i16, int i17);

    @SoInfo(libName = "image_filter_common")
    private native boolean nativeSetGlobalTextureMatrix(long j3, float[] fArr);

    @SoInfo(libName = "image_filter_common")
    private native boolean nativeSetPositions(long j3, float[] fArr);

    @SoInfo(libName = "image_filter_common")
    private native boolean nativeSetRenderMode(long j3, int i3);

    @SoInfo(libName = "image_filter_common")
    private native boolean nativeSetRotationAndFlip(long j3, int i3, int i16, int i17);

    @SoInfo(libName = "image_filter_common")
    private native boolean nativeSetTexCords(long j3, float[] fArr);

    @SoInfo(libName = "image_filter_common")
    private native boolean nativeUpdateMatrix(long j3, float[] fArr);

    public void OnDrawFrameGLSL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        GLES20.glUseProgram(this.mProgramIds);
        Iterator<UniformParam> it = this.mParamList.values().iterator();
        while (it.hasNext()) {
            it.next().setParams(this.mProgramIds);
        }
    }

    public Frame RenderProcess(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) ? RenderProcess(i3, i16, i17, i16, i17) : (Frame) iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public BaseFilter addParam(UniformParam uniformParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseFilter) iPatchRedirector.redirect((short) 6, (Object) this, (Object) uniformParam);
        }
        if (uniformParam == null) {
            return this;
        }
        UniformParam uniformParam2 = this.mParamList.get(uniformParam.name);
        if (uniformParam2 == null) {
            this.mParamList.put(uniformParam.name, uniformParam);
        } else {
            uniformParam.handle = uniformParam2.handle;
            uniformParam2.clear();
            this.mParamList.put(uniformParam.name, uniformParam);
        }
        return this;
    }

    public void addParams(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) hashMap);
            return;
        }
        ParamHelper paramHelper = this.mParamHelper;
        if (paramHelper != null) {
            paramHelper.processParams(hashMap);
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void apply() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else if (!isValid()) {
            initFilterShader(0);
            applyInternal();
            AEOpenRenderConfig.checkStrictMode(isValid(), "filter is not valid");
        }
    }

    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.mIsPreviewFilter = z16;
        if (!isValid()) {
            apply();
        }
        BaseFilter baseFilter = this.mNextFilter;
        if (baseFilter != null) {
            baseFilter.applyFilterChain(z16, f16, f17);
        }
    }

    public void applyForOES() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            initFilterShader(1);
            applyInternal();
        }
    }

    public void beforeRender(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public void clearGLSL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        clearGLSLSelf();
        BaseFilter baseFilter = this.mNextFilter;
        if (baseFilter != null) {
            baseFilter.clearGLSL();
        }
    }

    public void clearGLSLSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        Iterator<UniformParam> it = this.mParamList.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.mParamList.clear();
        nativeClear(this.mGlFilterId);
        this.mGlFilterId = 0L;
        this.mProgramIds = 0;
    }

    public UniformParam getAndRemoveParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (UniformParam) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
        return this.mParamList.remove(str);
    }

    public BaseFilter getLastFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (BaseFilter) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        BaseFilter baseFilter = this;
        while (true) {
            BaseFilter baseFilter2 = baseFilter.mNextFilter;
            if (baseFilter2 != null) {
                baseFilter = baseFilter2;
            } else {
                return baseFilter;
            }
        }
    }

    public int getLastFilterID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return getTheFilterIndex(getLastFilter());
    }

    public UniformParam getParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (UniformParam) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
        return this.mParamList.get(str);
    }

    public int getProgramIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.mProgramIds;
    }

    public float getScaleFactor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Float) iPatchRedirector.redirect((short) 27, (Object) this)).floatValue();
        }
        return this.scaleFact;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTheFilterIndex(BaseFilter baseFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, (Object) baseFilter)).intValue();
        }
        int i3 = 0;
        BaseFilter baseFilter2 = this;
        while (baseFilter2 != null && baseFilter2 != baseFilter) {
            i3++;
            baseFilter2 = baseFilter2.mNextFilter;
        }
        if (baseFilter2 == baseFilter) {
            return i3;
        }
        return -1;
    }

    public BaseFilter getmNextFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (BaseFilter) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.mNextFilter;
    }

    public boolean isAdjustFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isGPUProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.mIsGPU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        if (this.mProgramIds > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public Frame render(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (Frame) iPatchRedirector.redirect((short) 33, (Object) this, (Object) frame);
        }
        return RenderProcess(frame.getTextureId(), frame.width, frame.height);
    }

    public boolean renderTexture(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        return nativeRenderTexture(this.mGlFilterId, i3, i16, i17);
    }

    public void setAdjustParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        }
    }

    public void setEffectIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGlobalTextureMatrix(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) fArr);
            return;
        }
        nativeSetGlobalTextureMatrix(this.mGlFilterId, fArr);
        BaseFilter baseFilter = this.mNextFilter;
        if (baseFilter != null) {
            baseFilter.setGlobalTextureMatrix(fArr);
        }
    }

    public void setNextFilter(BaseFilter baseFilter, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) baseFilter, (Object) iArr);
            return;
        }
        this.mNextFilter = baseFilter;
        if (baseFilter != null) {
            baseFilter.mTextureIndexMap = iArr;
        }
    }

    public void setParamHelper(ParamHelper paramHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) paramHelper);
        } else {
            this.mParamHelper = paramHelper;
        }
    }

    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) map);
        }
    }

    public boolean setPositions(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) fArr)).booleanValue();
        }
        return nativeSetPositions(this.mGlFilterId, fArr);
    }

    public boolean setRenderMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        return nativeSetRenderMode(this.mGlFilterId, i3);
    }

    public boolean setRotationAndFlip(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        return nativeSetRotationAndFlip(this.mGlFilterId, i3, i16, i17);
    }

    public void setScaleFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        } else {
            this.scaleFact = f16;
        }
    }

    public void setSrcFilterIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.srcTextureIndex = i3;
        }
    }

    public boolean setTexCords(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) fArr)).booleanValue();
        }
        return nativeSetTexCords(this.mGlFilterId, fArr);
    }

    public void setTextureParam(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        GLES20.glUseProgram(this.mProgramIds);
        int i17 = i16 + 2;
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramIds, "inputImageTexture" + i17);
        if (glGetUniformLocation >= 0) {
            GLES20.glActiveTexture(33984 + i17);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9728.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glUniform1i(glGetUniformLocation, i17);
        }
    }

    public void updateFilterShader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        } else {
            this.glslVertextShader = str;
            this.glslProgramShader = str2;
        }
    }

    public void updateFragmentShader(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.glslProgramShader = str;
        }
    }

    public boolean updateMatrix(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) fArr)).booleanValue();
        }
        return nativeUpdateMatrix(this.mGlFilterId, fArr);
    }

    public Frame RenderProcess(int i3, int i16, int i17, int i18, int i19) {
        int i26;
        int i27;
        int textureId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Frame) iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
        }
        HashMap hashMap = new HashMap();
        Frame frame = new Frame();
        BaseFilter baseFilter = this;
        int i28 = 0;
        while (baseFilter != null) {
            if (baseFilter == this) {
                baseFilter.beforeRender(i3, i16, i17);
            } else {
                baseFilter.beforeRender(frame.getTextureId(), frame.width, frame.height);
            }
            frame.needReleaseFrame = baseFilter.needReleaseFrame;
            if (baseFilter.mNextFilter == null) {
                float f16 = baseFilter.scaleFact;
                float f17 = this.outPutScaleFactor;
                i26 = (int) (i18 * f16 * f17);
                i27 = (int) (i19 * f16 * f17);
            } else {
                float f18 = baseFilter.scaleFact;
                i26 = (int) (i18 * f18);
                i27 = (int) (i19 * f18);
            }
            int i29 = i26;
            Frame frame2 = FrameBufferCache.getInstance().get(i29, i27);
            frame2.bindFrame(-1, i29, i27, 0.0d);
            int i36 = i28 + 1;
            hashMap.put(Integer.valueOf(i28), frame2);
            baseFilter.OnDrawFrameGLSL();
            int[] iArr = baseFilter.mTextureIndexMap;
            if (iArr != null && iArr.length > 0) {
                int i37 = 0;
                while (true) {
                    int[] iArr2 = baseFilter.mTextureIndexMap;
                    if (i37 >= iArr2.length) {
                        break;
                    }
                    int i38 = iArr2[i37];
                    if (i38 < 0) {
                        baseFilter.setTextureParam(i3, i37);
                    } else {
                        Frame frame3 = (Frame) hashMap.get(Integer.valueOf(i38));
                        if (frame3 != null) {
                            baseFilter.setTextureParam(frame3.getTextureId(), i37);
                        } else {
                            Log.e(TAG, "frame not found!");
                        }
                    }
                    i37++;
                }
            }
            if (baseFilter == this) {
                baseFilter.renderTexture(i3, i16, i17);
                textureId = i3;
            } else {
                textureId = frame.getTextureId();
                baseFilter.renderTexture(frame.getTextureId(), frame.width, frame.height);
                if (frame.needReleaseFrame) {
                    frame.clearSelf();
                }
            }
            checkInputOutputValid(baseFilter, frame2, textureId);
            baseFilter = baseFilter.mNextFilter;
            frame = frame2;
            i28 = i36;
        }
        for (Frame frame4 : hashMap.values()) {
            if (frame4 != frame) {
                FrameBufferCache.getInstance().put(frame4);
            }
        }
        return frame;
    }

    public BaseFilter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.scaleFact = 1.0f;
        this.needFlipBlend = false;
        this.mIsGPU = true;
        this.srcTextureIndex = -1;
        this.glslVertextShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}";
        this.mGlFilterId = 0L;
        this.outPutScaleFactor = 1.0f;
        this.needReleaseFrame = false;
        this.mParamList = new HashMap();
        this.mParamHelper = null;
        this.glslProgramShader = str;
    }

    public void RenderProcess(int i3, int i16, int i17, int i18, double d16, Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            RenderProcess(i3, i16, i17, i16, i17, i18, d16, frame);
        } else {
            iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Double.valueOf(d16), frame);
        }
    }

    public void RenderProcess(int i3, int i16, int i17, int i18, int i19, int i26, double d16, Frame frame) {
        Frame frame2;
        int textureId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Double.valueOf(d16), frame);
            return;
        }
        if (frame == null) {
            return;
        }
        BaseFilter baseFilter = this;
        Frame frame3 = frame;
        Frame frame4 = frame3;
        while (baseFilter != null) {
            if (baseFilter == this) {
                baseFilter.beforeRender(i3, i16, i17);
            } else {
                baseFilter.beforeRender(frame3.getTextureId(), frame3.width, frame3.height);
            }
            frame4.needReleaseFrame = baseFilter.needReleaseFrame;
            if (baseFilter.mNextFilter == null) {
                float f16 = baseFilter.scaleFact;
                float f17 = this.outPutScaleFactor;
                frame2 = frame4;
                frame4.bindFrame(i26, (int) (i18 * f16 * f17), (int) (i19 * f16 * f17), d16);
            } else {
                frame2 = frame4;
                float f18 = baseFilter.scaleFact;
                frame2.bindFrame(-1, (int) (i18 * f18), (int) (i19 * f18), d16);
            }
            baseFilter.OnDrawFrameGLSL();
            int[] iArr = baseFilter.mTextureIndexMap;
            if (iArr != null && iArr.length > 0) {
                int i27 = 0;
                while (true) {
                    int[] iArr2 = baseFilter.mTextureIndexMap;
                    if (i27 >= iArr2.length) {
                        break;
                    }
                    int i28 = iArr2[i27];
                    if (i28 < 0) {
                        baseFilter.setTextureParam(i3, i27);
                    } else {
                        Frame findFrame = findFrame(frame, i28);
                        if (findFrame != null) {
                            baseFilter.setTextureParam(findFrame.getTextureId(), i27);
                        } else {
                            Log.e(TAG, "frame not found!");
                        }
                    }
                    i27++;
                }
            }
            if (baseFilter == this) {
                baseFilter.renderTexture(i3, i16, i17);
                textureId = i3;
            } else {
                textureId = frame3.getTextureId();
                baseFilter.renderTexture(frame3.getTextureId(), frame3.width, frame3.height);
                if (frame3.needReleaseFrame) {
                    frame3.clearSelf();
                }
                frame3 = frame2;
            }
            Frame frame5 = frame2;
            if (i26 != 0) {
                checkInputOutputValid(baseFilter, frame5, textureId);
            }
            baseFilter = baseFilter.mNextFilter;
            if (baseFilter != null) {
                if (frame5.nextFrame == null) {
                    frame5.nextFrame = new Frame();
                }
                frame4 = frame5.nextFrame;
            } else {
                frame4 = frame5;
            }
        }
    }
}
