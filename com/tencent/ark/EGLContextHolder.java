package com.tencent.ark;

import android.graphics.SurfaceTexture;
import android.opengl.GLES10;
import android.opengl.GLUtils;
import android.os.Build;
import com.tencent.ark.ark;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class EGLContextHolder extends ark.NativeObject {
    private static final String EGL_BAD_ALLOC_EXCEPTION = "eglCreateWindowSurface.failed.EGL_BAD_ALLOC";
    public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int RETRY_COUNT = 3;
    protected static final String TAG = "ArkApp.EGLContextHolder";
    public static EGL10 sEgl;
    public static EGLConfig[] sEglConfig;
    public static int[] sEglConfigCount;
    public static EGLConfig[] sEglPbufferConfig;
    public static int[] sEglPbufferConfigCount;
    public SurfaceTexture mSurfaceTexture;
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final String[] specialDeviceList = {"V2238A", "PD2224G", "PDBM00", "V1818CA", "RMX3823", "PGCM10", "23049RAD8C", "RMX3350", "PJV110", "V2130A", "PD2072E", "PD2166E", "PD2230C", "PD2230B", "PD2121B", "PD2121C", "PD2072B", "PD2230", "V2072A", "V2131A", "V1986A", "V2162A"};
    private static final DeviceMatcher[] sDisableList = {new DeviceMatcher(null, null, ".*MI-ONE.*", null, null), new DeviceMatcher(null, null, ".*MT7-TL00.*", null, null), new DeviceMatcher(null, "JSS15J\\.I9300.*", ".*I9300", null, null), new DeviceMatcher(null, null, ".*IdeaCentre B300.*", null, null), new DeviceMatcher("generic_x86/sdk_phone_x86/generic_x86.*", null, ".*Android SDK built for x86.*", null, null)};
    private static final DeviceMatcher[] sVirtvalContextList = {new DeviceMatcher(null, null, null, "Adreno.*", null), new DeviceMatcher(null, null, null, "Mali.*", null), new DeviceMatcher(null, null, null, "Power.*", null)};
    private static final DeviceMatcher[] sVirtvalContextDisableList = {new DeviceMatcher(null, null, null, "Adreno.*(330|405).*", null)};
    private static final DeviceMatcher[] sGPURasterDisableList = new DeviceMatcher[0];
    private static DeviceMatcher[] sExternalDisableList = null;
    private static DeviceMatcher[] sExternalVirtualContextList = null;
    private static DeviceMatcher[] sExternalVirtualContextDisableList = null;
    private static DeviceMatcher[] sExternalGPURasterDisableList = null;
    public static boolean sIsVirtualContext = false;
    public static boolean sIsGPURasterDisabled = false;
    public EGLDisplay mDisplay = EGL10.EGL_NO_DISPLAY;
    public EGLContext mContext = EGL10.EGL_NO_CONTEXT;
    public EGLSurface mSurface = EGL10.EGL_NO_SURFACE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DeviceMatcher {
        private Pattern mFingerprint;
        private Pattern mModel;
        private Pattern mRenderer;
        private Pattern mRom;
        private Pattern mVersion;

        public DeviceMatcher(String str, String str2, String str3, String str4, String str5) {
            if (str != null) {
                this.mFingerprint = Pattern.compile(str);
            }
            if (str2 != null) {
                this.mRom = Pattern.compile(str2);
            }
            if (str3 != null) {
                this.mModel = Pattern.compile(str3);
            }
            if (str4 != null) {
                this.mRenderer = Pattern.compile(str4);
            }
            if (str5 != null) {
                this.mVersion = Pattern.compile(str5);
            }
        }

        private static boolean matchImpl(Pattern pattern, String str) {
            if (pattern != null && str != null) {
                Matcher matcher = pattern.matcher(str);
                if (matcher == null || !matcher.matches()) {
                    return false;
                }
                return true;
            }
            return true;
        }

        public boolean matchGL(String str, String str2) {
            Pattern pattern = this.mRenderer;
            if ((pattern == null && this.mVersion == null) || !matchImpl(pattern, str) || !matchImpl(this.mVersion, str2)) {
                return false;
            }
            return true;
        }

        public boolean matchOS(String str, String str2, String str3) {
            Pattern pattern = this.mFingerprint;
            if ((pattern == null && this.mRom == null && this.mModel == null) || !matchImpl(pattern, str) || !matchImpl(this.mRom, str2) || !matchImpl(this.mModel, str3)) {
                return false;
            }
            return true;
        }
    }

    private native void deleteNativeObject();

    private static boolean deviceMatchGL(DeviceMatcher[] deviceMatcherArr, String str, String str2) {
        if (deviceMatcherArr == null) {
            return false;
        }
        for (DeviceMatcher deviceMatcher : deviceMatcherArr) {
            if (deviceMatcher.matchGL(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean deviceMatchOS(DeviceMatcher[] deviceMatcherArr) {
        if (deviceMatcherArr == null) {
            return false;
        }
        for (DeviceMatcher deviceMatcher : deviceMatcherArr) {
            if (deviceMatcher.matchOS(Build.FINGERPRINT, Build.DISPLAY, DeviceInfoMonitor.getModel())) {
                return true;
            }
        }
        return false;
    }

    public static native EGLContextHolder getApplicationContext();

    private static String getStringValueOrNull(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ef A[Catch: all -> 0x011d, TryCatch #0 {all -> 0x011d, blocks: (B:21:0x0063, B:23:0x0075, B:26:0x007f, B:28:0x0087, B:33:0x00a5, B:35:0x00ad, B:37:0x00b5, B:38:0x00c7, B:40:0x00cf, B:42:0x00e9, B:44:0x00ef, B:45:0x00d7, B:46:0x0092, B:47:0x0100), top: B:20:0x0063 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isDeviceSupported() {
        String glGetString;
        String glGetString2;
        boolean z16;
        logPhoneInformation();
        boolean z17 = true;
        if (!deviceMatchOS(sDisableList) && !deviceMatchOS(sExternalDisableList) && !isSpecialDeviceLimited()) {
            EGLContextHolder eGLContextHolder = new EGLContextHolder();
            if (!eGLContextHolder.createImpl(EGL10.EGL_NO_CONTEXT, null)) {
                Logger.logE(TAG, String.format("isDeviceSupported.false.create.context.fail.model.%s.%s", DeviceInfoMonitor.getModel(), Build.FINGERPRINT));
            } else {
                try {
                    if (!isSkiaSupported()) {
                        Logger.logE(TAG, String.format("isDeviceSupported.false.skia not supported", new Object[0]));
                    }
                } catch (UnsatisfiedLinkError unused) {
                    Logger.logE(TAG, "isDeviceSupported.fail.UnsatisfiedLinkError");
                }
                try {
                    glGetString = GLES10.glGetString(7937);
                    glGetString2 = GLES10.glGetString(7938);
                } catch (Throwable th5) {
                    Logger.logE(TAG, "isDeviceSupported.fail.error : " + th5);
                }
                if (!deviceMatchGL(sDisableList, glGetString, glGetString2) && !deviceMatchGL(sExternalDisableList, glGetString, glGetString2)) {
                    if (!deviceMatchGL(sVirtvalContextDisableList, glGetString, glGetString2) && !deviceMatchGL(sExternalVirtualContextDisableList, glGetString, glGetString2)) {
                        z16 = false;
                        if (!z16 && (deviceMatchGL(sVirtvalContextList, glGetString, glGetString2) || deviceMatchGL(sExternalVirtualContextList, glGetString, glGetString2))) {
                            sIsVirtualContext = true;
                            Logger.logI(TAG, String.format("isDeviceSupported.use.virtual.context.render.%s.version.%s", glGetString, glGetString2));
                        }
                        if (!deviceMatchGL(sGPURasterDisableList, glGetString, glGetString2) || deviceMatchGL(sExternalGPURasterDisableList, glGetString, glGetString2)) {
                            sIsGPURasterDisabled = true;
                            Logger.logI(TAG, String.format("isDeviceSupported.disable.gpu.raster.render.%s.version.%s", glGetString, glGetString2));
                        }
                        if (ENV.mIsDebug) {
                            Logger.logI(TAG, String.format("gl.render.%s.version.%s.end", glGetString, glGetString2));
                        }
                        eGLContextHolder.releaseImpl();
                        return z17;
                    }
                    Logger.logI(TAG, String.format("isDeviceSupported.disable.virtual.context.render.%s.version.%s.end", glGetString, glGetString2));
                    z16 = true;
                    if (!z16) {
                        sIsVirtualContext = true;
                        Logger.logI(TAG, String.format("isDeviceSupported.use.virtual.context.render.%s.version.%s", glGetString, glGetString2));
                    }
                    if (!deviceMatchGL(sGPURasterDisableList, glGetString, glGetString2)) {
                    }
                    sIsGPURasterDisabled = true;
                    Logger.logI(TAG, String.format("isDeviceSupported.disable.gpu.raster.render.%s.version.%s", glGetString, glGetString2));
                    if (ENV.mIsDebug) {
                    }
                    eGLContextHolder.releaseImpl();
                    return z17;
                }
                Logger.logE(TAG, String.format("isDeviceSupported.false.model.disabled.model.%s.%s.%s.%s", DeviceInfoMonitor.getModel(), Build.FINGERPRINT, glGetString, glGetString2));
            }
            z17 = false;
            eGLContextHolder.releaseImpl();
            return z17;
        }
        Logger.logE(TAG, String.format("isDeviceSupported.false.model.disabled.model.%s.%s", DeviceInfoMonitor.getModel(), Build.FINGERPRINT));
        return false;
    }

    public static native boolean isSkiaSupported();

    public static boolean isSpecialDeviceLimited() {
        String model = DeviceInfoMonitor.getModel();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31 && i3 <= 33) {
            for (String str : specialDeviceList) {
                if (str.equals(model)) {
                    Logger.logE(TAG, String.format("isSpecialDeviceLimited.true.model.disabled.model.%s.%s", DeviceInfoMonitor.getModel(), Build.FINGERPRINT));
                    return true;
                }
            }
        }
        return false;
    }

    private static final void logPhoneInformation() {
        Logger.logI(TAG, "phone.info.start");
        Logger.logI(TAG, String.format("Build.BOARD.%s", Build.BOARD));
        Logger.logI(TAG, String.format("Build.BRAND.%s", Build.BRAND));
        Logger.logI(TAG, String.format("Build.DEVICE.%s", Build.DEVICE));
        Logger.logI(TAG, String.format("Build.FINGERPRINT.%s", Build.FINGERPRINT));
        Logger.logI(TAG, String.format("Build.MANUFACTURER.%s", Build.MANUFACTURER));
        Logger.logI(TAG, String.format("Build.MODEL.%s", DeviceInfoMonitor.getModel()));
        Logger.logI(TAG, String.format("Build.PRODUCT.%s", Build.PRODUCT));
        Logger.logI(TAG, "phone.info.end");
    }

    private native void nativeResetContext();

    private native boolean nativeSizeChanged(int i3, int i16);

    private native boolean newNativeObject(int i3, int i16, boolean z16);

    private static DeviceMatcher parseDeviceMatcher(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String stringValueOrNull = getStringValueOrNull(jSONObject, "fingerprint");
        String stringValueOrNull2 = getStringValueOrNull(jSONObject, "rom");
        String stringValueOrNull3 = getStringValueOrNull(jSONObject, "model");
        String stringValueOrNull4 = getStringValueOrNull(jSONObject, "renderer");
        String stringValueOrNull5 = getStringValueOrNull(jSONObject, "version");
        if (stringValueOrNull == null && stringValueOrNull2 == null && stringValueOrNull3 == null && stringValueOrNull4 == null && stringValueOrNull5 == null) {
            return null;
        }
        return new DeviceMatcher(stringValueOrNull, stringValueOrNull2, stringValueOrNull3, stringValueOrNull4, stringValueOrNull5);
    }

    private static DeviceMatcher[] parseDeviceMatcherArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            DeviceMatcher parseDeviceMatcher = parseDeviceMatcher(jSONArray.optJSONObject(i3));
            if (parseDeviceMatcher != null) {
                arrayList.add(parseDeviceMatcher);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        DeviceMatcher[] deviceMatcherArr = new DeviceMatcher[arrayList.size()];
        arrayList.toArray(deviceMatcherArr);
        return deviceMatcherArr;
    }

    public static native void setApplicationContext(EGLContextHolder eGLContextHolder);

    public static void setDeviceMatcher(JSONObject jSONObject) {
        sExternalDisableList = null;
        sExternalVirtualContextList = null;
        sExternalVirtualContextDisableList = null;
        if (jSONObject == null) {
            return;
        }
        sExternalDisableList = parseDeviceMatcherArray(jSONObject.optJSONArray("disableList"));
        sExternalVirtualContextList = parseDeviceMatcherArray(jSONObject.optJSONArray("virtualContextEnableList"));
        sExternalVirtualContextDisableList = parseDeviceMatcherArray(jSONObject.optJSONArray("virtualContextDisableList"));
        sExternalGPURasterDisableList = parseDeviceMatcherArray(jSONObject.optJSONArray("gpuRasterDisableList"));
    }

    public static native void setOffscreenContext(EGLContextHolder eGLContextHolder);

    public static void setVirtualContext(boolean z16) {
        sIsVirtualContext = z16;
    }

    public boolean create(EGLContext eGLContext, SurfaceTexture surfaceTexture, int i3, int i16) {
        if (!createImpl(eGLContext, surfaceTexture)) {
            return false;
        }
        if (surfaceTexture == null) {
            i3 = 1;
        }
        if (surfaceTexture == null) {
            i16 = 1;
        }
        if (!newNativeObject(i3, i16, sIsVirtualContext)) {
            release();
            return false;
        }
        detachCurrent();
        return true;
    }

    protected boolean createImpl(EGLContext eGLContext, SurfaceTexture surfaceTexture) {
        boolean z16;
        boolean z17;
        String glGetString;
        EGLConfig[] eGLConfigArr;
        int i3;
        int i16;
        int i17;
        if (!this.mContext.equals(EGL10.EGL_NO_CONTEXT)) {
            return true;
        }
        if (sEgl == null) {
            if (!(EGLContext.getEGL() instanceof EGL10)) {
                Logger.logD(TAG, "getEGL.return.null");
                return false;
            }
            sEgl = (EGL10) EGLContext.getEGL();
        }
        this.mSurfaceTexture = surfaceTexture;
        EGL10 egl10 = sEgl;
        if (surfaceTexture == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mDisplay = eglGetDisplay;
            if (eglGetDisplay != null && !eglGetDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
                if (egl10.eglInitialize(this.mDisplay, new int[]{1, 0})) {
                    if (z16) {
                        eGLConfigArr = null;
                    } else {
                        eGLConfigArr = sEglConfig;
                    }
                    if (eGLConfigArr == null) {
                        int[] iArr = new int[1];
                        EGLConfig[] eGLConfigArr2 = new EGLConfig[1];
                        int[] iArr2 = new int[13];
                        iArr2[0] = 12352;
                        iArr2[1] = 4;
                        iArr2[2] = 12339;
                        if (z16) {
                            i17 = 1;
                        } else {
                            i17 = 4;
                        }
                        iArr2[3] = i17;
                        iArr2[4] = 12321;
                        iArr2[5] = 8;
                        iArr2[6] = 12322;
                        iArr2[7] = 8;
                        iArr2[8] = 12323;
                        iArr2[9] = 8;
                        iArr2[10] = 12324;
                        iArr2[11] = 8;
                        iArr2[12] = 12344;
                        i3 = 3;
                        if (egl10.eglChooseConfig(this.mDisplay, iArr2, eGLConfigArr2, 1, iArr)) {
                            if (eGLConfigArr2[0] != null) {
                                if (!z16) {
                                    sEglConfigCount = iArr;
                                    sEglConfig = eGLConfigArr2;
                                }
                                eGLConfigArr = eGLConfigArr2;
                            } else {
                                throw new Exception(String.format("eglChooseConfig.succ.but.eglConfigs[0].null.%s", GLUtils.getEGLErrorString(egl10.eglGetError())));
                            }
                        } else {
                            throw new Exception(String.format("eglChooseConfig.failed.%s", GLUtils.getEGLErrorString(egl10.eglGetError())));
                        }
                    } else {
                        i3 = 3;
                    }
                    int[] iArr3 = new int[i3];
                    iArr3[0] = 12440;
                    iArr3[1] = 2;
                    iArr3[2] = 12344;
                    if (sIsVirtualContext && eGLContext != null && !eGLContext.equals(EGL10.EGL_NO_CONTEXT)) {
                        this.mContext = eGLContext;
                        Logger.logI(TAG, String.format("create virtual context, this=%h, context=%h", this, eGLContext));
                    } else {
                        EGLContext eglCreateContext = egl10.eglCreateContext(this.mDisplay, eGLConfigArr[0], eGLContext, iArr3);
                        this.mContext = eglCreateContext;
                        Object[] objArr = new Object[i3];
                        objArr[0] = this;
                        objArr[1] = eglCreateContext;
                        objArr[2] = eGLContext;
                        Logger.logI(TAG, String.format("create share context, this=%h, context=%h, share=%h", objArr));
                        if (this.mContext.equals(EGL10.EGL_NO_CONTEXT)) {
                            throw new Exception(String.format("eglCreateContext.failed.%s", GLUtils.getEGLErrorString(egl10.eglGetError())));
                        }
                    }
                    int i18 = 12288;
                    for (int i19 = 0; i19 < i3; i19++) {
                        if (!z16) {
                            try {
                                this.mSurface = egl10.eglCreateWindowSurface(this.mDisplay, eGLConfigArr[0], surfaceTexture, null);
                            } catch (Exception e16) {
                                e = e16;
                                z17 = true;
                                Logger.logI(TAG, e.getMessage());
                                Logger.logI(TAG, "egl.start");
                                Logger.logI(TAG, String.format("egl.vendor.%s", egl10.eglQueryString(this.mDisplay, 12371)));
                                Logger.logI(TAG, String.format("egl.version.%s", egl10.eglQueryString(this.mDisplay, 12372)));
                                Logger.logI(TAG, String.format("egl.extension.%s", egl10.eglQueryString(this.mDisplay, 12373)));
                                Logger.logI(TAG, "egl.end");
                                if (z17 && !EGL_BAD_ALLOC_EXCEPTION.equals(e.getMessage()) && (glGetString = GLES10.glGetString(7937)) != null) {
                                    Logger.logI(TAG, "gl.start");
                                    Logger.logI(TAG, String.format("gl.renderer.%s", glGetString));
                                    Logger.logI(TAG, String.format("gl.vendor.%s", GLES10.glGetString(7936)));
                                    Logger.logI(TAG, String.format("gl.version.%s", GLES10.glGetString(7938)));
                                    Logger.logI(TAG, String.format("gl.extension.%s", GLES10.glGetString(7939)));
                                    Logger.logI(TAG, "gl.end");
                                }
                                release();
                                return false;
                            }
                        } else {
                            int[] iArr4 = new int[7];
                            iArr4[0] = 12375;
                            iArr4[1] = 1;
                            iArr4[2] = 12374;
                            iArr4[i3] = 1;
                            iArr4[4] = 12376;
                            iArr4[5] = 1;
                            iArr4[6] = 12344;
                            this.mSurface = egl10.eglCreatePbufferSurface(this.mDisplay, eGLConfigArr[0], iArr4);
                        }
                        if (this.mSurface.equals(EGL10.EGL_NO_SURFACE) && (i18 = egl10.eglGetError()) == 12291) {
                        }
                    }
                    if (!this.mSurface.equals(EGL10.EGL_NO_SURFACE)) {
                        for (int i26 = 0; i26 < i3; i26++) {
                            EGLDisplay eGLDisplay = this.mDisplay;
                            EGLSurface eGLSurface = this.mSurface;
                            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mContext)) {
                                i16 = 12288;
                                i18 = 12288;
                                break;
                            }
                            i18 = egl10.eglGetError();
                            if (i18 != 12291) {
                                break;
                            }
                        }
                        i16 = 12288;
                        if (i18 == i16) {
                            Logger.logI(TAG, String.format("egl.context.create.%h", this.mContext));
                            return true;
                        }
                        throw new Exception(String.format("eglMakeCurrent.failed.%s", GLUtils.getEGLErrorString(i18)));
                    }
                    throw new Exception(String.format("eglCreateWindowSurface.failed.%s", GLUtils.getEGLErrorString(i18)));
                }
                throw new Exception(String.format("eglInitialize.failed.%s", GLUtils.getEGLErrorString(egl10.eglGetError())));
            }
            throw new Exception(String.format("eglGetDisplay.failed.%s", GLUtils.getEGLErrorString(egl10.eglGetError())));
        } catch (Exception e17) {
            e = e17;
            z17 = false;
        }
    }

    public boolean detachCurrent() {
        Logger.logI(TAG, "context.detachCurrent");
        if (sEgl != null && !this.mContext.equals(EGL10.EGL_NO_CONTEXT) && !this.mDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
            EGL10 egl10 = sEgl;
            EGLDisplay eGLDisplay = this.mDisplay;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT)) {
                Logger.logE(TAG, "context detach current thread fail");
                return false;
            }
            return true;
        }
        Logger.logD(TAG, "egl.not.initialize");
        return false;
    }

    public boolean makeCurrent() {
        if (sEgl != null && !this.mContext.equals(EGL10.EGL_NO_CONTEXT) && !this.mSurface.equals(EGL10.EGL_NO_SURFACE) && !this.mDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
            if (this.mContext.equals(sEgl.eglGetCurrentContext()) && this.mSurface.equals(sEgl.eglGetCurrentSurface(12377))) {
                return true;
            }
            int i3 = 12288;
            int i16 = 0;
            while (true) {
                if (i16 >= 3) {
                    break;
                }
                EGL10 egl10 = sEgl;
                EGLDisplay eGLDisplay = this.mDisplay;
                EGLSurface eGLSurface = this.mSurface;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mContext)) {
                    i3 = 12288;
                    break;
                }
                i3 = sEgl.eglGetError();
                if (i3 != 12291) {
                    break;
                }
                i16++;
            }
            if (i3 != 12288) {
                Logger.logI(TAG, String.format("eglMakeCurrent.failed.%s", GLUtils.getEGLErrorString(i3)));
                return false;
            }
            if (sIsVirtualContext) {
                nativeResetContext();
            }
            if (!this.mContext.equals(sEgl.eglGetCurrentContext())) {
                Logger.logE(TAG, String.format("eglMakeCurrent.wtf.succ.but.not.current.%h.mContext.%h!!!", sEgl.eglGetCurrentContext(), this.mContext));
            }
            if (ENV.mIsDebug) {
                Logger.logD(TAG, String.format("eglMakeCurrent.succ.%h", this.mContext));
            }
            return true;
        }
        Logger.logD(TAG, "egl.not.initialize");
        return false;
    }

    public void release() {
        Logger.logI(TAG, String.format("context.release.this.%h.context=%h", this, this.mContext));
        if (this.mNative != 0) {
            deleteNativeObject();
        }
        releaseImpl();
    }

    protected void releaseImpl() {
        boolean z16;
        EGL10 egl10 = sEgl;
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.logI(TAG, String.format("egl.context.destroy.this.%h.context.%h.surfaceTexture.%h.virtual.%s.offscreen.%s", this, this.mContext, surfaceTexture, Boolean.toString(sIsVirtualContext), Boolean.toString(z16)));
        this.mSurfaceTexture = null;
        if (egl10 != null) {
            try {
                EGLContext eGLContext = this.mContext;
                if (eGLContext != null && this.mDisplay != null && this.mSurface != null) {
                    if (eGLContext.equals(egl10.eglGetCurrentContext())) {
                        EGLDisplay eGLDisplay = this.mDisplay;
                        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                    }
                    if (!this.mContext.equals(EGL10.EGL_NO_CONTEXT) && (!sIsVirtualContext || z16)) {
                        egl10.eglDestroyContext(this.mDisplay, this.mContext);
                    }
                    if (!this.mSurface.equals(EGL10.EGL_NO_SURFACE)) {
                        egl10.eglDestroySurface(this.mDisplay, this.mSurface);
                    }
                    if (!this.mDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
                        egl10.eglTerminate(this.mDisplay);
                    }
                }
            } catch (Exception e16) {
                Logger.logI(TAG, e16.getMessage());
                return;
            }
        }
        this.mContext = EGL10.EGL_NO_CONTEXT;
        this.mSurface = EGL10.EGL_NO_SURFACE;
        this.mDisplay = EGL10.EGL_NO_DISPLAY;
    }

    public boolean sizeChanged(int i3, int i16) {
        if (makeCurrent() && swapBuffer() && nativeSizeChanged(i3, i16)) {
            return true;
        }
        return false;
    }

    public boolean swapBuffer() {
        if (sEgl != null && !this.mContext.equals(EGL10.EGL_NO_CONTEXT) && !this.mSurface.equals(EGL10.EGL_NO_SURFACE) && !this.mDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
            return sEgl.eglSwapBuffers(this.mDisplay, this.mSurface);
        }
        Logger.logD(TAG, "egl.not.initialize");
        return false;
    }
}
