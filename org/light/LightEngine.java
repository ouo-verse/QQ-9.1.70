package org.light;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;
import org.libpag.PAGLicenseManager;
import org.light.report.LightBeaconReporter;
import org.light.report.LightReportManager;
import org.light.utils.LightLogUtil;
import org.light.utils.ThreadUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightEngine {
    private static final String TAG = "LightEngine";
    private static final int WAIT_TIMEOUT = 500;
    private static String appEntry;
    private static String appID;
    public static Object lock = new Object();
    private static String sdkVersion;
    private long nativeContext = 0;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface SDKServiceCallback extends SDKServiceRuntimeErrorCallback {
        void onServiceCreateError(String str, boolean z16);

        void onServiceStarted(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface SDKServiceRuntimeErrorCallback {
        void onServiceRuntimeError(String str);
    }

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    public static String appEntry() {
        return appEntry;
    }

    public static String appID() {
        return appID;
    }

    private static native int auth(Context context, String str, String str2, String str3);

    private static void authPAG(Context context) {
        try {
            int i3 = PAGLicenseManager.LicenseResultSuccess;
            Method declaredMethod = PAGLicenseManager.class.getDeclaredMethod("NativeLoadSDKLicense", Context.class);
            if (declaredMethod == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(PAGLicenseManager.class, context);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static int componentLevel() {
        return nativeComponentLevel();
    }

    public static String getSdkVersion() {
        if (sdkVersion == null) {
            sdkVersion = version();
        }
        return sdkVersion;
    }

    public static void init() {
        LightSurface.init();
        VideoOutput.init();
    }

    public static int initAuth(Context context, String str, String str2, String str3) {
        String str4;
        LightLogUtil.e(TAG, "initAuth appID:" + str2 + ", appEntry:" + str3);
        LightReportManager.setReporter(LightBeaconReporter.getInstance().init(context));
        appID = str2;
        appEntry = str3;
        if (context != null) {
            str4 = context.getPackageName();
        } else {
            str4 = "";
        }
        authPAG(context);
        return auth(context, str4, str, str2);
    }

    public static void initDeviceConfig(String str) {
        initDeviceConfig(str, "");
    }

    public static boolean isDeviceAbilitySupported(String str) {
        return nativeIsDeviceAbilitySupported(str);
    }

    public static LightEngine make(VideoOutputConfig videoOutputConfig, AudioOutputConfig audioOutputConfig, RendererConfig rendererConfig) {
        if (!TextUtils.isEmpty(appID) && !TextUtils.isEmpty(appEntry)) {
            LightEngine makeEngine = makeEngine(videoOutputConfig, audioOutputConfig, rendererConfig);
            ThreadUtils.executeTask(new Runnable() { // from class: org.light.LightEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    DeviceSupportUtil.isAbilityDeviceSupport("");
                }
            });
            LightLogUtil.e(TAG, String.format("LightEngine:%x init success", Integer.valueOf(System.identityHashCode(makeEngine))));
            return makeEngine;
        }
        return null;
    }

    private static native LightEngine makeEngine(VideoOutputConfig videoOutputConfig, AudioOutputConfig audioOutputConfig, RendererConfig rendererConfig);

    private native AudioOutput nativeAudioOutput();

    private static native int nativeComponentLevel();

    private native void nativeFinalize();

    private native int nativeGetOriginTexture();

    private native int nativeGetResultTexture();

    private static native void nativeInit();

    private static native void nativeInitDeviceConfig(String str, String str2);

    private static native boolean nativeIsDeviceAbilitySupported(String str);

    private native void nativeRelease();

    private native CameraController nativeSetAssetForCamera(LightAsset lightAsset);

    private native MovieController nativeSetAssetForMovie(LightAsset lightAsset);

    private native boolean nativeSetSurface(LightSurface lightSurface);

    private native Controller[] nativeSetTemplateAssets(TemplateClip[] templateClipArr);

    private static native String nativeVersion();

    private native VideoOutput nativeVideoOutput();

    public static void setAppEntry(String str) {
        LightLogUtil.e(TAG, "setAppEntry:" + str);
        appEntry = str;
    }

    public static String version() {
        try {
            return nativeVersion();
        } catch (UnsatisfiedLinkError e16) {
            LightLogUtil.e(TAG, "nativeVersion exception:\n" + e16);
            return "";
        }
    }

    public AudioOutput audioOutput() {
        return nativeAudioOutput();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativeContext != 0) {
            nativeFinalize();
        }
    }

    public int getOriginTexture() {
        return nativeGetOriginTexture();
    }

    public int getResultTexture() {
        return nativeGetResultTexture();
    }

    public native void nativeSetConfig(Config config);

    public final void release() {
        nativeRelease();
    }

    public CameraController setAssetForCamera(LightAsset lightAsset) {
        return nativeSetAssetForCamera(lightAsset);
    }

    public MovieController setAssetForMovie(LightAsset lightAsset) {
        MovieController nativeSetAssetForMovie = nativeSetAssetForMovie(lightAsset);
        LightLogUtil.e(TAG, String.format("movieController:%x init success", Integer.valueOf(System.identityHashCode(nativeSetAssetForMovie))));
        return nativeSetAssetForMovie;
    }

    public void setConfig(Config config) {
        nativeSetConfig(config);
    }

    public boolean setSurface(LightSurface lightSurface) {
        return nativeSetSurface(lightSurface);
    }

    public Controller[] setTemplateAssets(TemplateClip[] templateClipArr) {
        return nativeSetTemplateAssets(templateClipArr);
    }

    public VideoOutput videoOutput() {
        return nativeVideoOutput();
    }

    public static void initDeviceConfig(String str, String str2) {
        nativeInitDeviceConfig(str, str2);
    }
}
