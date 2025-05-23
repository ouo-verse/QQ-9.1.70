package org.light.gles;

import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Arrays;
import java.util.List;
import org.light.device.DeviceInstance;
import org.light.device.GpuScopeAttrs;
import org.light.utils.LightLogUtil;
import org.light.utils.MustRunOnGLThread;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GLCapabilities {
    public static final String FLIAMENT_TEST_FRAG_SHADER = "#version 300 es\nprecision highp float;\nlayout(location = 0) out vec4 fragColor;\n\n void main(void) {\n     const vec3 _347[2] = vec3[](vec3(1, 1, 1), vec3(1, 1, 1));\n\n     float _1025 = 0.0;\n     for (uint _1149 = 0u; _1149 < 2u; _1149++){\n         _1025 += _347[_1149].z;\n     }\n     fragColor = vec4(_1025 / 2.0);\n }";
    private static final String TAG = "GLCapabilities";
    private static boolean filamentShaderCompileSucceed;
    private static SimpleGLThread glThread;
    private static String glesVersion;
    private static String gpuInfo;
    private static final String[] GPU_GL_ONE_THREAD = {"PowerVR SGX 544MP", "Adreno (TM) 306"};
    private static boolean es_GL_EXT_shader_framebuffer_fetch = false;
    private static boolean es_GL_OES_texture_float = false;
    private static boolean es_GL_OES_texture_float_linear = false;
    private static int[] maxVertexTextureImageUnits = new int[1];
    private static int[] maxCombinedTextureImageUnits = new int[1];
    private static int[] maxVertexUniformVectors = new int[1];
    private static int[] maxFragmentUniformVectors = new int[1];
    private static int[] maxVertexUniformComponents = new int[1];
    private static int[] maxFragmentUniformComponents = new int[1];
    private static volatile boolean mIsInit = false;

    public static String getGPUInfo() {
        waitInitFinish();
        return gpuInfo;
    }

    public static String getGlesVersion() {
        waitInitFinish();
        String str = glesVersion;
        if (str == null) {
            return SemanticAttributes.HttpFlavorValues.HTTP_2_0;
        }
        try {
            return str.substring(10, 13);
        } catch (StringIndexOutOfBoundsException e16) {
            e16.printStackTrace();
            return SemanticAttributes.HttpFlavorValues.HTTP_2_0;
        }
    }

    private static List<GpuScopeAttrs.GpuBean.BaseModel> getModels() {
        return Arrays.asList(GpuScopeAttrs.getInstance().getGPuModel(), GpuScopeAttrs.getInstance().getDeviceModel(), GpuScopeAttrs.getInstance().getAndroidVersionModel(), GpuScopeAttrs.getInstance().getSysVersionModel());
    }

    public static synchronized void init(final boolean z16) {
        synchronized (GLCapabilities.class) {
            LightLogUtil.i(TAG, "init: enableFramebufferFetch=" + z16);
            if (!mIsInit && glThread == null) {
                LightLogUtil.i(TAG, "init: async start");
                SimpleGLThread simpleGLThread = new SimpleGLThread(null, "GLCapabilities-Init");
                glThread = simpleGLThread;
                simpleGLThread.postJob(new Runnable() { // from class: org.light.gles.GLCapabilities.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLCapabilities.initImpl(z16);
                        boolean unused = GLCapabilities.mIsInit = true;
                        LightLogUtil.i(GLCapabilities.TAG, "init: async end");
                    }
                });
            }
        }
    }

    @MustRunOnGLThread
    private static void initExtensionValues(boolean z16) {
        if (!z16) {
            es_GL_EXT_shader_framebuffer_fetch = false;
            return;
        }
        String glGetString = GLES20.glGetString(7939);
        if (!TextUtils.isEmpty(glGetString)) {
            for (String str : glGetString.split("\\s")) {
                if (!TextUtils.isEmpty(str) && str.equals("GL_EXT_shader_framebuffer_fetch")) {
                    es_GL_EXT_shader_framebuffer_fetch = true;
                }
                if (!TextUtils.isEmpty(str) && str.equals("GL_OES_texture_float")) {
                    es_GL_OES_texture_float = true;
                }
                if (!TextUtils.isEmpty(str) && str.equals("GL_OES_texture_float_linear")) {
                    es_GL_OES_texture_float_linear = true;
                }
            }
        }
        initGLExtensionRelatedShaders();
    }

    @MustRunOnGLThread
    private static void initFilamentValues() {
        try {
            filamentShaderCompileSucceed = testCompileShader(35632, "#version 300 es\nprecision highp float;\nlayout(location = 0) out vec4 fragColor;\n\n void main(void) {\n     const vec3 _347[2] = vec3[](vec3(1, 1, 1), vec3(1, 1, 1));\n\n     float _1025 = 0.0;\n     for (uint _1149 = 0u; _1149 < 2u; _1149++){\n         _1025 += _347[_1149].z;\n     }\n     fragColor = vec4(_1025 / 2.0);\n }");
        } catch (Exception e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    private static void initGpuInfo() {
        String glGetString = GLES20.glGetString(7937);
        String glGetString2 = GLES20.glGetString(7936);
        glesVersion = GLES20.glGetString(7938);
        gpuInfo = glGetString + "; " + glGetString2 + "; " + glesVersion;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GPU = ");
        sb5.append(gpuInfo);
        LightLogUtil.d(TAG, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initImpl(boolean z16) {
        initGpuInfo();
        initExtensionValues(z16);
        initReshapeValues();
        initUniformValues();
        initFilamentValues();
    }

    @MustRunOnGLThread
    private static void initReshapeValues() {
        GLES20.glGetIntegerv(35660, maxVertexTextureImageUnits, 0);
        GLES20.glGetIntegerv(35661, maxCombinedTextureImageUnits, 0);
        LightLogUtil.d(TAG, String.format("[vtf] vtf = %d, all = %d", Integer.valueOf(maxVertexTextureImageUnits[0]), Integer.valueOf(maxCombinedTextureImageUnits[0])));
    }

    @MustRunOnGLThread
    private static void initUniformValues() {
        GLES20.glGetIntegerv(36347, maxVertexUniformVectors, 0);
        GLES20.glGetIntegerv(36349, maxFragmentUniformVectors, 0);
        GLES20.glGetIntegerv(35658, maxVertexUniformComponents, 0);
        GLES20.glGetIntegerv(35657, maxFragmentUniformComponents, 0);
        LightLogUtil.d(TAG, String.format("[uniform] GL_MAX_VERTEX_UNIFORM_VECTORS = %d, GL_MAX_FRAGMENT_UNIFORM_VECTORS = %d", Integer.valueOf(maxVertexUniformVectors[0]), Integer.valueOf(maxFragmentUniformVectors[0])));
        LightLogUtil.d(TAG, String.format("[uniform] GL_MAX_VERTEX_UNIFORM_COMPONENTS = %d, GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = %d", Integer.valueOf(maxVertexUniformComponents[0]), Integer.valueOf(maxFragmentUniformComponents[0])));
    }

    public static boolean isDeviceSupportAce3dFlush() {
        boolean z16 = true;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                z16 &= baseModel.ace3dFlushSupport;
            }
        }
        return z16;
    }

    public static boolean isDeviceSupportAceEngine() {
        boolean z16 = true;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                boolean z17 = baseModel.filamentSupport;
                if (!z17) {
                    List<String> list = baseModel.filamentWhiteList;
                    if (list != null && list.contains(DeviceInstance.getInstance().getDeviceName())) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                z16 &= z17;
            }
        }
        return z16;
    }

    public static boolean isDeviceSupportAiAbility() {
        boolean z16 = true;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                z16 &= baseModel.aiSupport;
            }
        }
        return z16;
    }

    public static boolean isDeviceSupportBone() {
        boolean z16 = true;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                z16 &= baseModel.boneSupport;
            }
        }
        return z16;
    }

    public static boolean isDeviceSupportFence() {
        boolean z16 = true;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                z16 &= baseModel.fenceSupport;
            }
        }
        return z16;
    }

    public static boolean isDeviceSupportFilamentFeature(String str) {
        List<String> list;
        GpuScopeAttrs.GpuBean.DeviceModel deviceModel = GpuScopeAttrs.getInstance().getDeviceModel();
        if (deviceModel == null || (list = deviceModel.renderBlackList) == null) {
            return true;
        }
        try {
            return true ^ list.contains(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    public static boolean isDeviceSupportGLExtension(String str) {
        List<String> list;
        GpuScopeAttrs.GpuBean.DeviceModel deviceModel = GpuScopeAttrs.getInstance().getDeviceModel();
        if (deviceModel == null || (list = deviceModel.GLExtensionBlackList) == null) {
            return true;
        }
        try {
            return true ^ list.contains(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    public static boolean isDeviceSupportHairSegPreLoad() {
        boolean z16 = true;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                z16 &= baseModel.hairSegPreLoadSupport;
            }
        }
        return z16;
    }

    public static boolean isDeviceSupportKapu() {
        boolean z16 = true;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                z16 &= baseModel.kapuSupport;
            }
        }
        return z16;
    }

    public static boolean isDeviceSupportOpenCL() {
        boolean z16 = true;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                z16 &= baseModel.openclSupport;
            }
        }
        return z16;
    }

    public static boolean isFilamentShaderCompileSucceed() {
        waitInitFinish();
        return filamentShaderCompileSucceed;
    }

    public static boolean isImuSmoothEnable() {
        GpuScopeAttrs.GpuBean.DeviceModel deviceModel = GpuScopeAttrs.getInstance().getDeviceModel();
        if (deviceModel == null) {
            return false;
        }
        return deviceModel.enableImuSmooth;
    }

    public static boolean isInOneGLThreadBlackList() {
        String[] split = getGPUInfo().split(";");
        if (split.length > 0 && !TextUtils.isEmpty(split[0])) {
            String lowerCase = split[0].trim().toLowerCase();
            for (String str : GPU_GL_ONE_THREAD) {
                if (lowerCase.equals(str.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isShareGLContextError() {
        boolean z16 = false;
        for (GpuScopeAttrs.GpuBean.BaseModel baseModel : getModels()) {
            if (baseModel != null) {
                z16 |= baseModel.shareGLContextError;
            }
        }
        return z16;
    }

    public static boolean isSupportFloatTexture() {
        waitInitFinish();
        if (es_GL_OES_texture_float && es_GL_OES_texture_float_linear) {
            return true;
        }
        return false;
    }

    public static boolean isSupportFramebufferFetch() {
        waitInitFinish();
        return es_GL_EXT_shader_framebuffer_fetch;
    }

    @MustRunOnGLThread
    public static boolean supportVTF() {
        initReshapeValues();
        if (maxVertexTextureImageUnits[0] <= 0) {
            return false;
        }
        return true;
    }

    private static boolean testCompileShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        int[] iArr = new int[1];
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            Log.e(TAG, "vertex shader test compile failed, shader : [" + str + "]");
            Log.e(TAG, glGetShaderInfoLog);
            GLES20.glDeleteShader(glCreateShader);
            return false;
        }
        GLES20.glDeleteShader(glCreateShader);
        return true;
    }

    private static void useInWrongTime() {
        new IllegalStateException("must call init method first");
    }

    private static void waitInitFinish() {
        if (!mIsInit) {
            SimpleGLThread simpleGLThread = glThread;
            if (simpleGLThread != null) {
                simpleGLThread.waitDone(200);
                if (!mIsInit) {
                    useInWrongTime();
                    return;
                }
                return;
            }
            useInWrongTime();
        }
    }

    private static void initGLExtensionRelatedShaders() {
    }
}
