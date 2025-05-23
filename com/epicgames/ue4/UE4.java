package com.epicgames.ue4;

import android.app.Activity;
import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.FrameLayout;
import com.epicgames.ue4.GameActivityBase;
import com.epicgames.ue4.GameActivityThunk;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UE4 {
    public static String AVATAR_VIEW_TYPE_KEY = "AvatarViewType";
    private static final String DEBUG_SO_DIR = "/sdcard/Android/data/com.tencent.mobileqq/";
    public static final int ERROR_ENGINE_INACTIVE = 2;
    public static final int ERROR_ENGINE_INIT_FAILED = 1;
    public static final int ERROR_ENGINE_PURGED = 3;
    public static final int ERROR_ENGINE_SUSPENDED = 2;
    public static final int ERROR_ENGINE_UNINITED = 4;
    private static final String FINAL_SO_DIR = "/data/user/0/com.tencent.mobileqq/";
    public static String NET_STATE_CHANGED_KEY = "NetStateChanged";
    public static final int NO_ERROR = 0;
    public static final int OPTION_FIX_ACTIVITY_LEAKS = 2;
    public static final int OPTION_FIX_SENSOR_LISTENER_LEAKS = 5;
    public static final int OPTION_FORCE_TERMINATE_WINDOW = 4;
    public static final int OPTION_HANDLE_FINGER_TAPS = 1;
    public static final int OPTION_PROFILE_JAVA = 6;
    public static final int OPTION_SUPPRESS_CMSHOW_LOG = 3;
    public static final int OPTION_SUPPRESS_JAVA_LOG_IN_SHIPPING_BUILD = 0;
    public static final int TRIBOOL_FALSE = 0;
    public static final int TRIBOOL_TRUE = 1;
    public static final int TRIBOOL_UNDEF = -1;
    public static int ZPLAN_PAGE_TYPE_DRAWER = 3;
    public static int ZPLAN_PAGE_TYPE_DYNAMIC = 4;
    public static int ZPLAN_PAGE_TYPE_PORTAL = 1;
    public static int ZPLAN_PAGE_TYPE_POTO = 1;
    public static int ZPLAN_PAGE_TYPE_STORE = 2;
    private static HandlerThread _dedicatedThread = null;
    private static Handler _dedicatedThreadHandler = null;
    private static boolean _ensureEnabled = true;
    private static int _error = 0;
    private static boolean _inited = false;
    private static boolean _logEnabled = true;
    private static int _optionBits = 0;
    private static boolean _shippingBuild = false;
    private static Surface _window = null;
    public static ErrorListener errorListener = null;
    public static boolean isEnginePause = true;
    public static boolean resident = true;
    public static boolean standalone = false;
    public static Logger Log = new Logger("UE4", "UE4-JAVA");
    private static GameProfiler _profiler = new GameProfiler(true);
    private static int _backbufferWidth = 0;
    private static int _backbufferHeight = 0;
    private static Context _defaultContext = null;
    private static boolean _immersiveMode = true;
    private static boolean _engineDLLLoaded = false;
    private static boolean _engineLoaded = false;
    public static boolean engineActive = false;
    public static boolean engineInited = false;
    public static boolean engineBooted = false;

    @Deprecated
    public static boolean enginePurged = false;
    private static EnginePurgeState _enginePurgeState = EnginePurgeState.RECOVERED;
    public static EngineListener engineListener = null;
    public static EngineDLLListener engineDLLListener = null;
    public static EngineWindowListener engineWindowListener = null;
    private static boolean _deviceOrientationLocked = false;
    private static boolean _deviceOrientationLockedPortrait = true;
    private static boolean _bLoadModulesInDLL = false;
    private static boolean _librariesLoaded = false;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface EngineDLLListener {
        void onEngineDLLStateChanged(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface EngineListener {
        void onEngineActivated();

        void onEngineInited(boolean z16);

        void onEnginePurged();

        void onEnginePurging();

        void onEngineRecovered();

        void onEngineRecovering();

        void onEngineSuspended();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum EnginePurgeState {
        PURGING,
        PURGED,
        RECOVERING,
        RECOVERED
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface EngineWindowListener {
        void onEngineWindowTerminated();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ErrorListener {
        void onError(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class InitEngineParams {
        public Context context = null;
        public Bundle state = null;
        public boolean bCreateView = false;
        public GameActivityBase.SurfaceListener surfaceListener = null;
        public FrameLayout frameLayout = null;
        public GameActivityThunk.CMShowEngineInitFinishListener initFinishListener = null;
        public GameActivityThunk.CMShowEngineFirstFrameListener firstFrameListener = null;
        public boolean bLoadModulesInDLL = true;
        public String sStartCommand = "";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ParallelWorldListener {
        boolean canDrawRenderTarget(int i3, int i16);

        void drawRenderTargetAsFramebuffer(int i3, int i16, int i17, int i18);

        void drawRenderTargetAsPixels(int i3, byte[] bArr, int i16, int i17);

        void onActivated(int i3, boolean z16, int i16, int i17);

        void onDeactivated(int i3);

        void onDrawModeChanged(int i3, int i16, int i17);

        void onFocusChanged(int i3, int i16);

        void onInited(int i3);

        void onKilled(int i3);

        void onLoaded(int i3, boolean z16);

        void onNativeWindowChanged(int i3);
    }

    public static void Callback(int i3, String str) {
        GameActivityNative.Callback(i3, str);
    }

    private static void InitEngineInternal(Context context, GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener, GameActivityThunk.CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener) {
        forceClearWindow();
        GameActivityBase.SetContext(context);
        setCMShowEngineInitFinishListener(cMShowEngineInitFinishListener);
        setCMShowEngineFirstFrameListener(cMShowEngineFirstFrameListener);
        boolean z16 = context instanceof Activity;
        if (!_inited) {
            if (!z16) {
                _defaultContext = context;
            }
            GameActivityThunk.InitSingleton();
            GameActivityBase.InitSingleton(context);
            GameActivityNative.Main(GameActivityBase.Get(), GameActivityThunk.Get());
            NativeCalls.KeepAwake("Native", true);
            _shippingBuild = GameActivityBase.IsShippingBuild();
            _inited = true;
        } else {
            callbackInitFinishImmediately(cMShowEngineInitFinishListener);
        }
        if (!z16 && _defaultContext == null) {
            _defaultContext = context;
        }
    }

    @Deprecated
    public static boolean IsPortraitOrientation() {
        return isPortraitOrientation();
    }

    public static void OnCMShowNetworkError(String str, int i3) {
        GameActivityNative.OnCMShowNetworkError(str, i3);
    }

    public static void OnCMShowNetworkStateChanged(int i3) {
        GameActivityNative.OnCMShowNetworkStateChanged(i3);
    }

    public static void OpenFocusWorldLevel(String str) {
        GameActivityNative.OpenFocusWorldLevel(str);
    }

    @Deprecated
    public static void SetPortraitOrientation(boolean z16) {
        setPortraitOrientation(z16);
    }

    public static void SetUEShareContext(EGLContext eGLContext) {
        if (eGLContext != null && eGLContext != EGL14.EGL_NO_CONTEXT) {
            GameActivityNative.SetEGLShareContext(eGLContext.getNativeHandle());
        }
    }

    public static void SynthesisSameStyleVideoEndCallback(int i3, int i16) {
        GameActivityNative.SynthesisSameStyleVideoEndCallback(i3, i16);
    }

    public static void abandonModule(String str, boolean z16) {
        logBeginUT("abandonModule", "moduleName:" + str + " sync: " + z16);
        GameActivityNative.AbandonModule(str, z16);
        logEndUT("abandonModule");
    }

    public static void acquireSensors() {
        GameActivityBase.AcquireSensors();
    }

    public static void backPressed() {
        logBeginUT("backPressed");
        GameActivityNative.OnBackPressed();
        logEndUT("backPressed");
    }

    private static void callbackInitFinishImmediately(final GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener) {
        if (cMShowEngineInitFinishListener == null) {
            return;
        }
        new BaseThread(new Runnable() { // from class: com.epicgames.ue4.UE4.12
            @Override // java.lang.Runnable
            public void run() {
                GameActivityThunk.CMShowEngineInitFinishListener.this.onEngineInitFinish(true);
            }
        }).start();
    }

    public static void clearContext(Context context) {
        logBeginUT("clearContext", context);
        if (getContext() == context) {
            GameActivityBase.SetContext(null);
        } else {
            logIgnored("clearContext", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        logEndUT("clearContext");
    }

    public static void clearError() {
        _error = 0;
    }

    public static void clearWindow(Context context, boolean z16) {
        logBeginUT("clearWindow(context)", "Context:" + context + " Async:" + z16);
        profileBegin();
        ensureNotNull(context);
        if (getContext() == context) {
            forceClearWindowInternal(z16);
        } else {
            logIgnored("clearWindow", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("clearWindow(context)");
    }

    public static void destroyEngine() {
        logBeginUT("destroyEngine");
        if (_inited) {
            GameActivityBase.OnDestroy();
            GameActivityNative.OnDestroy();
            _inited = false;
            isEnginePause = true;
        } else {
            logIgnored("destroyEngine", "not inited");
        }
        logEndUT("destroyEngine");
    }

    public static void disableOption(int i3) {
        int i16 = _optionBits;
        int i17 = (~(1 << i3)) & i16;
        _optionBits = i17;
        if (i17 != i16) {
            onOptionChanged();
        }
    }

    public static void dressCostume(int i3) {
        GameActivityNative.DressCostume(i3);
    }

    public static void enableOption(int i3) {
        int i16 = _optionBits;
        int i17 = (1 << i3) & i16;
        _optionBits = i17;
        if (i17 != i16) {
            onOptionChanged();
        }
    }

    public static void ensure(boolean z16, String str) {
        if (!_ensureEnabled || z16) {
            return;
        }
        throwError("Ensure Failed! " + str);
    }

    public static void ensureNotNull(Object obj) {
        boolean z16;
        if (obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        ensure(z16, "Object must be NotNull.");
    }

    public static void enterAvatarShow(int i3) {
        GameActivityNative.EnterAvatarShow(i3);
    }

    public static void enterBackground(Context context) {
        logBeginUT("enterBackground(Context)", "Context: " + context);
        if (getContext() == context) {
            GameActivityNative.EnterBackground();
        } else {
            logIgnored("enterBackground(Context)", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        logEndUT("enterBackground(Context)");
    }

    public static void enterForeground(Context context) {
        logBeginUT("enterForeground(Context)", "Context: " + context);
        if (getContext() == context) {
            GameActivityNative.EnterForeground();
        } else {
            logIgnored("enterForeground(Context)", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        logEndUT("enterForeground(Context)");
    }

    public static void expect(EnginePurgeState enginePurgeState) {
        if (_enginePurgeState != enginePurgeState) {
            Log.error("_enginePurgeState is " + _enginePurgeState.name() + "; expected: " + enginePurgeState.name());
        }
    }

    public static String[] findModules(String str, boolean z16) {
        return GameActivityNative.FindModules(str, z16).split(";");
    }

    public static void flushEngine() {
        logBeginUT("flushEngine");
        GameActivityNative.FlushEngine();
        logEndUT("flushEngine");
    }

    public static void forceClearContext() {
        logBeginUT("forceClearContext");
        GameActivityBase.SetContext(null);
        logEndUT("forceClearContext");
    }

    public static void forceClearWindow() {
        clearWindow(false);
    }

    private static void forceClearWindowInternal(boolean z16) {
        _window = null;
        long currentMilliseconds = GameProfiler.currentMilliseconds();
        GameActivityNative.OnWindowTerminated(z16);
        log("forceClearWindowInternal", "Async: " + z16 + " Elapsedtime(ms): " + GameProfiler.elapsedMilliseconds(currentMilliseconds));
    }

    public static int getAIFaceGender() {
        return GameActivityNative.GetAIFaceGender();
    }

    public static String getAIFaceVersion() {
        return GameActivityNative.GetAIFaceVersion();
    }

    public static String getAvatarAppearanceKey() {
        return GameActivityNative.GetAvatarAppearanceKey();
    }

    public static int getBackbufferHeight() {
        return _backbufferHeight;
    }

    public static int getBackbufferWidth() {
        return _backbufferWidth;
    }

    public static Context getContext() {
        return GameActivityBase.GetContext();
    }

    public static javax.microedition.khronos.egl.EGLContext getCurrentContext() {
        return GameActivityThunk.context;
    }

    public static EGLContext getCurrentEglContext() {
        return GameActivityThunk.eglContext;
    }

    public static Context getDefaultContext() {
        return _defaultContext;
    }

    public static EnginePurgeState getEnginePurgeState() {
        return _enginePurgeState;
    }

    public static int getError() {
        return _error;
    }

    private static String getLogBeginETPrefix(String str) {
        return "UE4." + str + " [EventThread] Begin ";
    }

    private static String getLogBeginGTPrefix(String str) {
        return "UE4." + str + " [GameThread] Begin ";
    }

    private static String getLogBeginUTPrefix(String str) {
        return "UE4." + str + " [AndroidUIThread] Begin ";
    }

    private static String getLogCallUTPrefix(String str) {
        return "UE4." + str + " [AndroidUIThread] Called ";
    }

    private static String getLogEndETPrefix(String str) {
        return "UE4." + str + " [EventThread] End ";
    }

    private static String getLogEndGTPrefix(String str) {
        return "UE4." + str + " [GameThread] End ";
    }

    private static String getLogEndUTPrefix(String str) {
        return "UE4." + str + " [AndroidUIThread] End ";
    }

    public static p0.c getLuaBridge() {
        return GameActivityThunk.GetSingleton().GetLuaBridge();
    }

    public static String getModuleManifest() {
        return GameActivityNative.GetModuleManifest();
    }

    public static int getOptionBits() {
        return _optionBits;
    }

    public static Surface getWindow() {
        return _window;
    }

    public static boolean hasEnginePause() {
        return isEnginePause;
    }

    public static boolean hasError() {
        if (_error != 0) {
            return true;
        }
        return false;
    }

    public static boolean hasModule(String str) {
        return GameActivityNative.HasModule(str);
    }

    public static boolean hasOption(int i3) {
        if (((1 << i3) & _optionBits) != 0) {
            return true;
        }
        return false;
    }

    public static boolean hasWindow(Surface surface) {
        return GameActivityNative.HasWindow(surface);
    }

    public static void initEngine(Context context) {
        initEngine(context, null, false, null, null);
    }

    public static void initWindow(Surface surface) {
        initWindow(surface, true);
    }

    public static void inputEvent(KeyEvent keyEvent) {
        if (preconditionEngineInited("inputEvent(KeyEvent)")) {
            if (!_shippingBuild) {
                logBeginUT("inputEvent(KeyEvent)", "KeyEvent: " + keyEvent.getAction());
            }
            inputEventInternal(keyEvent);
            if (_shippingBuild) {
                return;
            }
            logEndUT("inputEvent(KeyEvent)");
        }
    }

    private static void inputEventInternal(KeyEvent keyEvent) {
        GameActivityNative.OnKeyEventParameters(keyEvent, keyEvent.getSource(), keyEvent.getDeviceId(), keyEvent.getKeyCode(), keyEvent.getFlags(), keyEvent.getAction(), keyEvent.getMetaState());
    }

    public static boolean isDeviceOrientationLocked() {
        return _deviceOrientationLocked;
    }

    public static boolean isDeviceOrientationLockedPortrait() {
        return _deviceOrientationLockedPortrait;
    }

    public static boolean isEngineActive() {
        return engineActive;
    }

    public static boolean isEngineBooted() {
        return engineBooted;
    }

    public static boolean isEngineDLLLoaded() {
        return _engineDLLLoaded;
    }

    public static boolean isEngineInited() {
        return engineInited;
    }

    public static boolean isEngineLoaded() {
        return _engineLoaded;
    }

    public static boolean isEnginePurged() {
        if (_enginePurgeState == EnginePurgeState.PURGED) {
            return true;
        }
        return false;
    }

    public static boolean isEnginePurging() {
        if (_enginePurgeState == EnginePurgeState.PURGING) {
            return true;
        }
        return false;
    }

    public static boolean isEngineRecovered() {
        if (_enginePurgeState == EnginePurgeState.RECOVERED) {
            return true;
        }
        return false;
    }

    public static boolean isEngineRecovering() {
        if (_enginePurgeState == EnginePurgeState.RECOVERING) {
            return true;
        }
        return false;
    }

    public static boolean isImmersiveMode() {
        return _immersiveMode;
    }

    public static boolean isInited() {
        return _inited;
    }

    public static boolean isLibrariesLoaded() {
        return _librariesLoaded;
    }

    public static boolean isLoadedModule(String str) {
        return GameActivityNative.IsLoadedModule(str);
    }

    public static boolean isPortraitOrientation() {
        return GameActivityNative.IsPortraitOrientation();
    }

    public static boolean isShippingBuild() {
        return _shippingBuild;
    }

    public static boolean isSystemLoadLibraryEnabled() {
        return GameActivityNative.IsSystemLoadLibraryEnabled();
    }

    public static void leaveAvatarShow() {
        GameActivityNative.LeaveAvatarShow();
    }

    public static void loadLibraries(boolean z16, boolean z17) {
        if (_librariesLoaded) {
            return;
        }
        profileBegin();
        standalone = z16;
        resident = z17;
        loadLibrary("UE4");
        profileBegin("soLoadLibrary");
        try {
            System.loadLibrary("gcloud");
        } catch (UnsatisfiedLinkError e16) {
            Log.debug(e16.toString());
            Log.debug("GCloud library not loaded and required!");
        }
        try {
            System.loadLibrary("gcloudcore");
        } catch (UnsatisfiedLinkError e17) {
            Log.debug(e17.toString());
            Log.debug("abase library not loaded and required!");
        }
        try {
            System.loadLibrary("GVoice");
        } catch (UnsatisfiedLinkError e18) {
            Log.debug(e18.toString());
            Log.debug("GVoice library not loaded and required!");
        }
        try {
            System.loadLibrary("QQAudioInput");
        } catch (UnsatisfiedLinkError e19) {
            Log.debug(e19.toString());
            Log.debug("Failed to load QQAudioInput library");
        }
        try {
            System.loadLibrary("QQAudioReceive");
        } catch (UnsatisfiedLinkError e26) {
            Log.debug(e26.toString());
            Log.debug("Failed to load QQAudioReceive library");
        }
        try {
            System.loadLibrary("QQAudioSend");
        } catch (UnsatisfiedLinkError e27) {
            Log.debug(e27.toString());
            Log.debug("Failed to load QQAudioSend library");
        }
        try {
            System.loadLibrary("QQAudio3A");
        } catch (UnsatisfiedLinkError e28) {
            Log.debug(e28.toString());
            Log.debug("Failed to load QQAudio3A library");
        }
        profileEnd();
        profileBegin("c++_shared");
        System.loadLibrary("c++_shared");
        profileEnd();
        log("loadLibraries", "Load *.so files succeeded");
        profileEnd();
        _librariesLoaded = true;
    }

    public static boolean loadLibrary(String str) {
        String str2 = RFixConstants.SO_PATH + str + ".so";
        profileBegin(str2);
        String str3 = DEBUG_SO_DIR + str2;
        String str4 = FINAL_SO_DIR + str2;
        try {
            if (new File(str3).exists()) {
                File file = new File(str4);
                com.epicgames.ue4.util.a aVar = com.epicgames.ue4.util.a.f32597a;
                if (!aVar.e(file.getParent())) {
                    try {
                        aVar.c(file.getParent());
                    } catch (IOException unused) {
                        log("loadLibrary", "load debug so, createDirectory fail");
                    }
                }
                if (com.epicgames.ue4.util.a.f32597a.b(str3, str4)) {
                    log("loadLibrary", "load debug so " + str4);
                    System.load(str4);
                    profileEnd();
                    return true;
                }
            }
            System.loadLibrary(str);
            profileEnd();
            return true;
        } catch (Throwable th5) {
            log("loadLibrary", th5.toString() + "load " + str2 + " failed.");
            profileEnd();
            return false;
        }
    }

    public static void loadModule(String str, boolean z16) {
        logBeginUT("loadModule", "moduleName:" + str + " sync: " + z16);
        GameActivityNative.LoadModule(str, z16);
        logEndUT("loadModule");
    }

    public static void loadModulesInBundle(String str, boolean z16) {
        logBeginUT("loadModulesInBundle", "bundleName:" + str + " sync: " + z16);
        GameActivityNative.LoadModulesInDLL(str, z16);
        logEndUT("loadModulesInBundle");
    }

    public static void loadModulesInDLL(String str, boolean z16) {
        logBeginUT("loadModulesInDLL", "dllName:" + str + " sync: " + z16);
        GameActivityNative.LoadModulesInDLL(str, z16);
        logEndUT("loadModulesInDLL");
    }

    public static void loadModulesInPlugin(String str, boolean z16) {
        logBeginUT("loadModulesInPlugin", "pluginName:" + str + " sync: " + z16);
        GameActivityNative.LoadModulesInPlugin(str, z16);
        logEndUT("loadModulesInPlugin");
    }

    public static void lockOrUnlockDeviceOrientation(Context context) {
        boolean z16;
        logBeginUT("lockOrUnlockDeviceOrientation", context);
        if (context != null && !(context instanceof Activity)) {
            z16 = true;
        } else {
            z16 = false;
        }
        _deviceOrientationLocked = z16;
        log("lockOrUnlockDeviceOrientation", "_deviceOrientationLocked: " + _deviceOrientationLocked);
        logEndUT("lockOrUnlockDeviceOrientation");
    }

    public static void log(String str) {
        if (_logEnabled) {
            if (_engineLoaded) {
                GameActivityNative.LowLevelOutput("[UE4-JAVA] " + str);
                return;
            }
            Log.debug(str);
        }
    }

    private static void logBeginET(String str) {
        if (_logEnabled) {
            log(getLogBeginETPrefix(str));
        }
    }

    private static void logBeginGT(String str) {
        if (_logEnabled) {
            log(getLogBeginGTPrefix(str));
        }
    }

    private static void logBeginUT(String str) {
        if (_logEnabled) {
            log(getLogBeginUTPrefix(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logCallUT(String str) {
        if (_logEnabled) {
            log(getLogCallUTPrefix(str));
        }
    }

    private static void logEndET(String str) {
        if (_logEnabled) {
            log(getLogEndETPrefix(str));
        }
    }

    private static void logEndGT(String str) {
        if (_logEnabled) {
            log(getLogEndGTPrefix(str));
        }
    }

    private static void logEndUT(String str) {
        if (_logEnabled) {
            log(getLogEndUTPrefix(str));
        }
    }

    private static void logIgnored(String str, String str2) {
        if (_logEnabled) {
            log("UE4." + str + " IS IGNORED. Reason: " + str2);
        }
    }

    public static void logMessage(String str) {
        log(str);
    }

    public static void mountPak(String str, int i3, String str2, boolean z16, boolean z17) {
        GameActivityNative.MountPak(str, i3, str2, z16, z17);
    }

    public static void onCMShowReceiveData(String str, byte[] bArr) {
        GameActivityNative.OnCMShowReceiveData(str, bArr);
    }

    public static void onEngineActivated() {
        logBeginET("onEngineActivated");
        engineActive = true;
        if (engineListener == null) {
            logEndET("onEngineActivated", "UE4.engineListener is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.9
                @Override // java.lang.Runnable
                public void run() {
                    EngineListener engineListener2 = UE4.engineListener;
                    if (engineListener2 != null) {
                        engineListener2.onEngineActivated();
                    }
                }
            });
            logEndET("onEngineActivated");
        }
    }

    public static void onEngineBooted() {
        logBeginGT("onEngineBooted");
        engineBooted = true;
        profileDisable();
        runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.4
            @Override // java.lang.Runnable
            public void run() {
                UE4.profileDump();
            }
        });
        logEndGT("onEngineBooted");
    }

    public static void onEngineDLLStateChanged(String str, boolean z16) {
        log("onEngineDLLStateChanged", " dllName: " + str + " loaded: " + z16);
        if ((str == null || str.isEmpty()) && _engineDLLLoaded != z16) {
            _engineDLLLoaded = z16;
            EngineDLLListener engineDLLListener2 = engineDLLListener;
            if (engineDLLListener2 != null) {
                engineDLLListener2.onEngineDLLStateChanged(z16);
            }
        }
    }

    public static void onEngineInited(boolean z16) {
        logBeginGT("onEngineInited", "succeeded: " + z16);
        engineInited = z16;
        runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.3
            @Override // java.lang.Runnable
            public void run() {
                if (!UE4.engineInited) {
                    UE4.setError(1);
                }
                EngineListener engineListener2 = UE4.engineListener;
                if (engineListener2 != null) {
                    engineListener2.onEngineInited(UE4.engineInited);
                } else {
                    UE4.log("onEngineInited", "UE4.engineListener is null");
                }
            }
        });
        logEndGT("onEngineInited");
    }

    public static void onEngineLoaded() {
        log("onEngineLoaded", "");
        _engineLoaded = true;
    }

    public static void onEnginePurged() {
        logBeginGT("onEnginePurged");
        expect(EnginePurgeState.PURGING);
        _enginePurgeState = EnginePurgeState.PURGED;
        enginePurged = true;
        if (engineListener == null) {
            logEndGT("onEnginePurged", "UE4.engineListener is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.6
                @Override // java.lang.Runnable
                public void run() {
                    EngineListener engineListener2 = UE4.engineListener;
                    if (engineListener2 != null) {
                        engineListener2.onEnginePurged();
                    }
                }
            });
            logEndGT("onEnginePurged");
        }
    }

    public static void onEnginePurging() {
        logBeginGT("onEnginePurging");
        expect(EnginePurgeState.RECOVERED);
        _enginePurgeState = EnginePurgeState.PURGING;
        if (engineListener == null) {
            logEndGT("onEnginePurging", "UE4.engineListener is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.5
                @Override // java.lang.Runnable
                public void run() {
                    EngineListener engineListener2 = UE4.engineListener;
                    if (engineListener2 != null) {
                        engineListener2.onEnginePurging();
                    }
                }
            });
            logEndGT("onEnginePurging");
        }
    }

    public static void onEngineRecovered() {
        logBeginGT("onEngineRecovered");
        expect(EnginePurgeState.RECOVERING);
        _enginePurgeState = EnginePurgeState.RECOVERED;
        enginePurged = false;
        if (engineListener == null) {
            logEndGT("onEngineRecovered", "UE4.engineListener is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.8
                @Override // java.lang.Runnable
                public void run() {
                    EngineListener engineListener2 = UE4.engineListener;
                    if (engineListener2 != null) {
                        engineListener2.onEngineRecovered();
                    }
                }
            });
            logEndGT("onEngineRecovered");
        }
    }

    public static void onEngineRecovering() {
        logBeginGT("onEngineRecovering");
        expect(EnginePurgeState.PURGED);
        _enginePurgeState = EnginePurgeState.RECOVERING;
        if (engineListener == null) {
            logEndGT("onEngineRecovering", "UE4.engineListener is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.7
                @Override // java.lang.Runnable
                public void run() {
                    EngineListener engineListener2 = UE4.engineListener;
                    if (engineListener2 != null) {
                        engineListener2.onEngineRecovering();
                    }
                }
            });
            logEndGT("onEngineRecovering");
        }
    }

    public static void onEngineSuspended() {
        logBeginET("onEngineSuspended");
        engineActive = false;
        if (engineListener == null) {
            logEndET("onEngineSuspended", "UE4.engineListener is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.11
                @Override // java.lang.Runnable
                public void run() {
                    EngineListener engineListener2 = UE4.engineListener;
                    if (engineListener2 != null) {
                        engineListener2.onEngineSuspended();
                    }
                }
            });
            logEndET("onEngineSuspended");
        }
    }

    public static void onEngineWindowTerminated() {
        logBeginET("onEngineWindowTerminated");
        runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.10
            @Override // java.lang.Runnable
            public void run() {
                EngineWindowListener engineWindowListener2 = UE4.engineWindowListener;
                if (engineWindowListener2 == null) {
                    UE4.logEndET("onEngineWindowTerminated", "UE4.engineWindowListener is null");
                } else {
                    engineWindowListener2.onEngineWindowTerminated();
                }
            }
        });
        logEndET("onEngineWindowTerminated");
    }

    public static void onFingerTaps(int i3) {
        logBeginGT("onFingerTaps", "Taps Count: " + i3);
        if (!hasOption(1)) {
            logEndGT("onFingerTaps", "UE4.OPTION_HANDLE_FINGER_TAPS is disabled");
        } else {
            runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.UE4.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
            logEndGT("onFingerTaps");
        }
    }

    private static void onOptionChanged() {
        if (hasOption(6)) {
            profileEnable();
        } else {
            profileDisable(true);
        }
    }

    public static void onReceiveProcessEvent(int i3, String str) {
        GameActivityNative.OnReceiveProcessEvent(i3, str);
    }

    public static void openLevel(String str) {
        GameActivityNative.OpenLevel(str);
    }

    public static void pauseEngine(Context context) {
        logBeginUT("pauseEngine", context);
        profileBegin();
        ensureNotNull(context);
        if (getContext() == context) {
            isEnginePause = true;
            GameActivityNative.OnFocusLost();
            GameActivityBase.OnPause();
            GameActivityNative.OnPause();
        } else {
            logIgnored("pauseEngine", "context is mismatched => CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("pauseEngine");
    }

    public static void portraitOrientationChanged(boolean z16, int i3, int i16) {
        logBeginUT("portraitOrientationChanged", "bPortrait " + z16 + " Width " + i3 + " Height " + i16);
        GameActivityNative.OnPortraitOrientationChanged(z16, i3, i16);
        logEndUT("portraitOrientationChanged");
    }

    private static boolean postcondition() {
        clearError();
        return true;
    }

    private static boolean preconditionEngineActive(String str) {
        if (!engineActive) {
            log("precondition", "Error: UE4 API '" + str + "' can't be called when the engine is deactivated");
            setError(2);
        }
        return engineActive;
    }

    private static boolean preconditionEngineInited(String str) {
        if (!_inited) {
            log("precondition", "Error: UE4 API '" + str + "' can't be called when the engine isn't initialized");
            setError(4);
        }
        return _inited;
    }

    private static boolean preconditionEngineNotPurged(String str) {
        if (enginePurged) {
            log("precondition", "Error: UE4 API '" + str + "' can't be called when the engine is purged");
            setError(3);
        }
        return !enginePurged;
    }

    public static void preloadResources() {
        GameActivityNative.PreloadResources();
    }

    public static void printModule(String str) {
        GameActivityNative.PrintModule(str);
    }

    public static void printModulesInBundle(String str) {
        GameActivityNative.PrintModulesInDLL(str);
    }

    public static void printModulesInDLL(String str) {
        GameActivityNative.PrintModulesInDLL(str);
    }

    public static void printModulesInPlugin(String str) {
        GameActivityNative.PrintModulesInPlugin(str);
    }

    public static void printString(String str) {
        GameActivityNative.PrintString(str);
    }

    public static void profileBegin(String str) {
        GameProfiler gameProfiler = _profiler;
        if (gameProfiler != null) {
            gameProfiler.begin(str);
        }
    }

    public static void profileDisable() {
        GameProfiler gameProfiler = _profiler;
        if (gameProfiler != null) {
            gameProfiler.disable();
        }
    }

    public static void profileDump() {
        GameProfiler gameProfiler = _profiler;
        if (gameProfiler != null) {
            gameProfiler.dump();
        }
    }

    public static void profileEnable() {
        GameProfiler gameProfiler = _profiler;
        if (gameProfiler == null) {
            _profiler = new GameProfiler(true);
        } else {
            gameProfiler.enable();
        }
    }

    public static void profileEnd() {
        GameProfiler gameProfiler = _profiler;
        if (gameProfiler != null) {
            gameProfiler.end();
        }
    }

    public static void profileTimepoint() {
        GameProfiler gameProfiler = _profiler;
        if (gameProfiler != null) {
            gameProfiler.timepoint();
        }
    }

    public static void purgeEngine(Surface surface) {
        unimplemented();
    }

    public static void purgeEngineDelayed() {
        GameActivityNative.PurgeEngine(true);
    }

    @Deprecated
    public static void quitEngine() {
        purgeEngine();
    }

    public static void recordAvatarPortrait(int i3, int i16, int i17, int i18, int i19) {
        GameActivityNative.RecordAvatarPortrait(i3, i16, i17, i18, i19);
    }

    public static void recoverEngine() {
        GameActivityNative.RecoverEngine();
    }

    @Deprecated
    public static void reenterEngine() {
        recoverEngine();
    }

    public static void refreshEngine(Context context, boolean z16) {
        logBeginUT("refreshEngine(bCreateView)", "Context: " + context + " bCreateView: " + z16);
        profileBegin();
        ensureNotNull(context);
        forceClearWindow();
        initEngine(context, (Bundle) null, z16);
        resumeEngine(context, z16);
        profileEnd();
        logEndUT("refreshEngine(bCreateView)");
    }

    private static void reinitEngine() {
        reinitEngineInternal(null, null, false);
    }

    private static void reinitEngineInternal(Context context, Bundle bundle, boolean z16) {
        logBeginUT("reinitEngineInternal", "context: " + context + "bundle: " + bundle + "bCreateView: " + z16);
        if (context != null) {
            initEngine(context, bundle, z16);
        } else {
            GameActivityBase.OnCreate(bundle, z16);
        }
        logEndUT("reinitEngineInternal");
    }

    public static void releaseSensors() {
        GameActivityBase.ReleaseSensors();
    }

    public static void resizeBackbuffer(Context context, int i3, int i16) {
        resizeBackbuffer(context, i3, i16, true);
    }

    public static void resizeWindow(Context context, Surface surface) {
        resizeWindow(context, surface, false, false);
    }

    private static void resizeWindowInternal(Surface surface, boolean z16, boolean z17) {
        log("resizeWindowInternal", "bAdjustDeviceOrientation: " + z16 + " bSync: " + z17);
        _window = surface;
        GameActivityNative.OnWindowResized(surface, z16, z17);
    }

    public static void restartEngine(Context context) {
        logBeginUT("restartEngine", context);
        profileBegin();
        ensureNotNull(context);
        if (getContext() == context) {
            GameActivityBase.OnRestart();
        } else {
            logIgnored("restartEngine", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("restartEngine");
    }

    public static void resumeEngine(Context context) {
        logBeginUT("resumeEngine", context);
        profileBegin();
        ensure(context);
        Surface surface = _window;
        resumeEngineInternal(context, surface, surface == null);
        profileEnd();
        logEndUT("resumeEngine");
    }

    private static void resumeEngineInternal(Context context, Surface surface, boolean z16) {
        logBeginUT("resumeEngineInternal", "context: " + context + "window: " + surface + " bCreateView: " + z16);
        profileBegin();
        ensure(context);
        isEnginePause = false;
        if (getContext() != context) {
            reinitEngine(context, z16);
        }
        if (surface != null) {
            ensure(!z16, "bCreateView == true can't coexist with window != null");
            initWindow(surface, false);
        }
        GameActivityNative.OnFocusGained();
        GameActivityBase.OnResume();
        GameActivityNative.OnResume();
        profileEnd();
        logEndUT("resumeEngineInternal");
    }

    public static void runOnDedicatedThread(Runnable runnable) {
        if (_dedicatedThreadHandler == null) {
            if (_dedicatedThread == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("UE4JavaDedicatedThread");
                _dedicatedThread = baseHandlerThread;
                baseHandlerThread.start();
            }
            _dedicatedThreadHandler = new Handler(_dedicatedThread.getLooper());
        }
        _dedicatedThreadHandler.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        GameActivityBase.RunOnUiThread(runnable);
    }

    public static void saveExternalTexture(int i3, String str) {
        GameActivityNative.SaveExternalTexture(i3, str);
    }

    public static void setBackbufferSize(int i3, int i16) {
        _backbufferWidth = i3;
        _backbufferHeight = i16;
    }

    public static void setCMShowDressCostumeListener(GameActivityThunk.DressChangedListener dressChangedListener) {
        GameActivityThunk.GetSingleton().setCMShowDressCostumeListener(dressChangedListener);
    }

    public static void setCMShowEngineFirstFrameListener(GameActivityThunk.CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener) {
        GameActivityThunk.GetSingleton().setCMShowEngineFirstFrameListener(cMShowEngineFirstFrameListener);
    }

    public static void setCMShowEngineInitFinishListener(GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener) {
        GameActivityThunk.GetSingleton().setCMShowEngineInitFinishListener(cMShowEngineInitFinishListener);
    }

    public static void setCMShowGetNetStatusListener(GameActivityThunk.CMShowGetNetStatusListener cMShowGetNetStatusListener) {
        GameActivityThunk.GetSingleton().setCMShowGetNetStatusListener(cMShowGetNetStatusListener);
    }

    public static void setCMShowLogListener(GameActivityThunk.CMShowLogListener cMShowLogListener) {
        GameActivityThunk.GetSingleton().setCMShowLogListener(cMShowLogListener);
    }

    public static void setCMShowProfileListener(GameActivityThunk.CMShowProfileListener cMShowProfileListener) {
        GameActivityThunk.GetSingleton().setCMShowProfileListener(cMShowProfileListener);
    }

    public static void setCMShowReportListenerListener(GameActivityThunk.CMShowReportListener cMShowReportListener) {
        GameActivityThunk.GetSingleton().setCMShowReportListenerListener(cMShowReportListener);
    }

    public static void setCMShowSendListener(GameActivityThunk.CMShowSendListener cMShowSendListener) {
        GameActivityThunk.GetSingleton().setCMShowSendListener(cMShowSendListener);
    }

    public static void setContext(Context context) {
        logBeginUT("setContext", context);
        if (_inited && getContext() != context && context != null && (context instanceof Activity) && (getContext() == null || !(getContext() instanceof Activity))) {
            loadModulesInDLL(false);
        }
        GameActivityBase.SetContext(context);
        logEndUT("setContext");
    }

    public static void setDecodeImage2RGBA8Listener(GameActivityThunk.DecodeImage2RGBA8Listener decodeImage2RGBA8Listener) {
        GameActivityThunk.GetSingleton().setDecodeImage2RGBA8Listener(decodeImage2RGBA8Listener);
    }

    public static void setDefaultContext(Context context) {
        log("setDefaultContext", "Context: " + context);
        ensure(context);
        _defaultContext = context;
        if (GameActivityBase.GetContext() == null) {
            log("setDefaultContext", "GameActivityBase's context is null and set default context to it.");
            GameActivityBase.SetContext(_defaultContext);
        }
    }

    public static void setDeviceOrientation(int i3, boolean z16) {
        GameActivityNative.SetDeviceOrientation(i3, z16);
    }

    public static void setEmbeddedStartupConfigure(String str) {
        GameActivityNative.SetEmbeddedStartupConfigure(str);
    }

    public static void setEngineAutoPurgeOnBackPressed(boolean z16) {
        GameActivityNative.SetEngineAutoPurgeOnBackPressed(z16);
    }

    @Deprecated
    public static void setEngineQuitOnBackPressed(boolean z16) {
        setEngineAutoPurgeOnBackPressed(z16);
    }

    @Deprecated
    public static void setEngineReentryEnabled(boolean z16) {
        setEngineAutoPurgeEnabled(z16);
    }

    public static void setError(int i3) {
        logBeginUT("setError", "OldErrorCode:" + _error + " NewErrorCode: " + i3);
        _error = i3;
        ErrorListener errorListener2 = errorListener;
        if (errorListener2 != null) {
            errorListener2.onError(i3);
        }
        logEndUT("setError");
    }

    public static void setFireEventToMainProcessListener(GameActivityThunk.FireEventToMainProcessListener fireEventToMainProcessListener) {
        GameActivityThunk.GetSingleton().setFireEventToMainProcessListener(fireEventToMainProcessListener);
    }

    public static void setImmersiveMode(boolean z16) {
        log("setImmersiveMode", "value: " + z16);
        _immersiveMode = z16;
    }

    public static void setOpenLightAIPhotoSelectorListener(GameActivityThunk.OpenLightAIPhotoSelectorListener openLightAIPhotoSelectorListener) {
        GameActivityThunk.GetSingleton().setOpenLightAIPhotoSelectorListener(openLightAIPhotoSelectorListener);
    }

    public static void setOptionBits(int i3) {
        if (_optionBits != i3) {
            _optionBits = i3;
            onOptionChanged();
        }
    }

    public static void setPortraitOrientation(boolean z16) {
        setPortraitOrientation(z16, -1, -1);
    }

    public static void setPortraitOrientationAutoAdjust(boolean z16) {
        GameActivityBase.bAllowDisplayConfigurationRequest = z16;
    }

    public static void setProcessType(int i3) {
        GameActivityNative.SetProcessType(i3);
    }

    public static void setRecordFrameListener(GameActivityThunk.RecordFrameListener recordFrameListener) {
        GameActivityThunk.GetSingleton().setRecordFrameListener(recordFrameListener);
    }

    public static void setRecordSameStyleListener(GameActivityThunk.RecordSameStyleListener recordSameStyleListener) {
        GameActivityThunk.GetSingleton().setRecordSameStyleListener(recordSameStyleListener);
    }

    public static void setRequestLeaveAvatarShowListener(GameActivityThunk.RequestLeaveAvatarShowListener requestLeaveAvatarShowListener) {
        GameActivityThunk.GetSingleton().setRequestLeaveAvatarShowListener(requestLeaveAvatarShowListener);
    }

    public static void setRequestShowFeedbackListener(GameActivityThunk.RequestShowFeedbackListener requestShowFeedbackListener) {
        GameActivityThunk.GetSingleton().setRequestShowFeedbackListener(requestShowFeedbackListener);
    }

    public static void setStartupConfigureExtra(String str) {
        GameActivityNative.SetStartupConfigureExtra(str);
    }

    public static void setSystemLoadLibraryEnabled(boolean z16) {
        GameActivityNative.SetSystemLoadLibraryEnabled(z16);
    }

    public static void setViewport(Context context, int i3, int i16, int i17, int i18) {
        setViewport(context, i3, i16, i17, i18, false, false, false);
    }

    public static void setViewportFull(Context context) {
        setViewport(context, 0, 0, 0, 0, false, false, false);
    }

    public static void setWindow(Context context, Surface surface) {
        setWindow(context, surface, true, 0, 0, 0, 0, false, false);
    }

    public static void setZPlanMallStatusListener(GameActivityThunk.ZPlanMallStatusListener zPlanMallStatusListener) {
        GameActivityThunk.GetSingleton().setZPlanMallStatusListener(zPlanMallStatusListener);
    }

    public static void showMessageBox(final String str, final String str2) {
        runOnDedicatedThread(new Runnable() { // from class: com.epicgames.ue4.UE4.1
            @Override // java.lang.Runnable
            public void run() {
                MessageBox01.suppressed = false;
                MessageBox01 messageBox01 = new MessageBox01();
                messageBox01.setCaption(str);
                messageBox01.setText(str2);
                messageBox01.addButton("Ok");
                messageBox01.show();
            }
        });
    }

    public static void startEngine(Context context) {
        logBeginUT("startEngine", context);
        profileBegin();
        ensureNotNull(context);
        if (getContext() == context) {
            GameActivityBase.OnStart();
        } else {
            logIgnored("startEngine", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("startEngine");
    }

    public static void stopEngine(Context context) {
        logBeginUT("stopEngine", context);
        profileBegin();
        ensureNotNull(context);
        if (getContext() == context) {
            isEnginePause = true;
            GameActivityBase.OnStop();
            GameActivityNative.OnStop();
        } else {
            logIgnored("stopEngine", "context is mismatched => CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("stopEngine");
    }

    public static void terminateWindow(Surface surface, boolean z16) {
        logBeginUT("terminateWindow(Surface)", "Surface:" + surface + " Async:" + z16);
        profileBegin();
        if (_window != surface && !hasOption(4)) {
            logIgnored("terminateWindow(Surface)", "window is mismatched, CurrentWindow: " + _window + " IncomingWindow: " + surface);
        } else {
            forceClearWindowInternal(z16);
        }
        profileEnd();
        logEndUT("terminateWindow(Surface)");
    }

    public static void throwError(String str) {
        if (_inited && !_shippingBuild) {
            showMessageBox("Crash", "Crash Error => " + str);
        }
        throw new IllegalStateException("Crash Error => " + str);
    }

    public static boolean toBoolean(int i3) {
        if (i3 == 1) {
            return true;
        }
        if (i3 != 0) {
            throwError("Undefine tribool can't be converted to boolean");
            return false;
        }
        return false;
    }

    public static void unimplemented() {
        ensure(false, "unimplemented");
    }

    public static void unloadModule(String str, boolean z16) {
        logBeginUT("unloadModule", "moduleName:" + str + " sync: " + z16);
        GameActivityNative.UnloadModule(str, z16);
        logEndUT("unloadModule");
    }

    public static void unloadModulesInBundle(String str, boolean z16) {
        logBeginUT("unloadModulesInBundle", "bundleName:" + str + " sync: " + z16);
        GameActivityNative.UnloadModulesInDLL(str, z16);
        logEndUT("unloadModulesInBundle");
    }

    public static void unloadModulesInDLL(String str, boolean z16) {
        logBeginUT("unloadModulesInDLL", "dllName:" + str + " sync: " + z16);
        GameActivityNative.UnloadModulesInDLL(str, z16);
        logEndUT("unloadModulesInDLL");
    }

    public static void unloadModulesInPlugin(String str, boolean z16) {
        logBeginUT("unloadModulesInPlugin", "pluginName:" + str + " sync: " + z16);
        GameActivityNative.UnloadModulesInPlugin(str, z16);
        logEndUT("unloadModulesInPlugin");
    }

    public static void initEngine(Context context, Bundle bundle, boolean z16) {
        initEngine(context, bundle, z16, null, null);
    }

    public static void initWindow(Surface surface, boolean z16) {
        logBeginUT("initWindow", "Surface:" + surface + " bSetViewportFull: " + z16);
        profileBegin();
        ensureNotNull(surface);
        if (_window == surface) {
            log("initWindow", " Same window found.");
        }
        _window = surface;
        GameActivityNative.OnWindowInited(surface, z16);
        profileEnd();
        logEndUT("initWindow");
    }

    public static void printModulesInDLL() {
        GameActivityNative.PrintModulesInDLL(null);
    }

    public static void purgeEngine() {
        GameActivityNative.PurgeEngine(false);
    }

    private static void reinitEngine(Context context) {
        ensureNotNull(context);
        reinitEngineInternal(context, null, false);
    }

    public static void resizeBackbuffer(int i3, int i16) {
        resizeBackbuffer(i3, i16, true);
    }

    public static void resizeWindow(Context context, Surface surface, boolean z16) {
        resizeWindow(context, surface, z16, false);
    }

    public static void setPortraitOrientation(boolean z16, int i3, int i16) {
        logBeginUT("setPortraitOrientation", "bPortrait " + z16 + " Width " + i3 + " Height " + i16);
        _deviceOrientationLockedPortrait = z16;
        portraitOrientationChanged(z16, i3, i16);
        logEndUT("setPortraitOrientation");
    }

    public static void setViewport(Context context, int i3, int i16, int i17, int i18, boolean z16) {
        setViewport(context, i3, i16, i17, i18, false, false, z16);
    }

    public static void setViewportFull(Context context, boolean z16) {
        setViewport(context, 0, 0, 0, 0, false, false, z16);
    }

    public static void setWindow(Surface surface) {
        setWindow(surface, true, 0, 0, 0, 0, false, false);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ParallelWorld {
        public static final int DRAW_RENDER_TARGET_AS_FRAMEBUFFER = 0;
        public static final int DRAW_RENDER_TARGET_AS_NATIVEWINDOW = 2;
        public static final int DRAW_RENDER_TARGET_AS_NOTHING = 3;
        public static final int DRAW_RENDER_TARGET_AS_PIXELS = 1;
        public static int focusedID;
        public static ParallelWorldListener listener;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class LoadParameters {
            public int windowWidth = 0;
            public int windowHeight = 0;
            public Surface windowSurface = null;
            public int drawMode = 0;
            public boolean bDuplicateOnLoad = false;
            public boolean bAutoInitializeWorld = true;
            public boolean bAutoTickInBackground = true;
            public boolean bAutoTickInActive = true;
            public boolean bAutoActivateWorld = true;
            public boolean bAutoHandleWidgets = true;
            public boolean bAutoRenderInDefocused = false;
            public boolean bCreateDedicatedAudioDevice = true;
        }

        public static void activate(int i3) {
            UE4.logCallUT("ParallelWorld.activate", "worldID: " + i3);
            if (precondition()) {
                GameActivityNative.ParallelWorldActivate(i3);
            }
        }

        public static boolean canFocus(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldCanFocus(i3);
            }
            return false;
        }

        public static void clearWindow(int i3) {
            UE4.logCallUT("ParallelWorld.clearWindow", "worldID: " + i3);
            if (precondition()) {
                GameActivityNative.ParallelWorldClearWindow(i3);
            }
        }

        public static int create() {
            UE4.logCallUT("ParallelWorld.create");
            if (precondition()) {
                return GameActivityNative.ParallelWorldCreate();
            }
            return 0;
        }

        public static void createWidget(int i3, String str) {
            if (precondition()) {
                GameActivityNative.ParallelWorldCreateWidget(i3, str);
            }
        }

        public static void deactivate(int i3) {
            UE4.logCallUT("ParallelWorld.deactivate", "worldID: " + i3);
            if (precondition()) {
                GameActivityNative.ParallelWorldDeactivate(i3);
            }
        }

        public static void defocus(int i3) {
            UE4.logCallUT("ParallelWorld.defocus", "worldID: " + i3);
            if (precondition()) {
                GameActivityNative.ParallelWorldDefocus(i3);
            }
        }

        public static void dump(int i3, boolean z16) {
            if (precondition()) {
                MessageBox01.suppressed = !z16;
                GameActivityNative.ParallelWorldDump(i3, z16);
            }
        }

        public static void dumpAll(boolean z16) {
            if (precondition()) {
                MessageBox01.suppressed = !z16;
                GameActivityNative.ParallelWorldDumpAll(z16);
            }
        }

        public static boolean exists(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldExists(i3);
            }
            return false;
        }

        public static void focus(int i3) {
            UE4.logCallUT("ParallelWorld.focus", "worldID: " + i3);
            if (precondition()) {
                GameActivityNative.ParallelWorldFocus(i3);
            }
        }

        public static int getFocusedID() {
            if (precondition()) {
                return GameActivityNative.ParallelWorldGetFocusedID();
            }
            return -1;
        }

        public static boolean hasWindow(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldHasWindow(i3);
            }
            return false;
        }

        public static long initRender() {
            return GameActivityNative.nInitRender();
        }

        public static boolean isActive(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldIsActive(i3);
            }
            return false;
        }

        public static boolean isBackground(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldIsBackground(i3);
            }
            return false;
        }

        public static boolean isFocused(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldIsFocused(i3);
            }
            return false;
        }

        public static boolean isFocusedID(int i3) {
            if (focusedID == i3) {
                return true;
            }
            return false;
        }

        public static boolean isKilled(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldIsKilled(i3);
            }
            return false;
        }

        public static boolean isRenderingInDefocused(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldIsRenderingInDefocused(i3);
            }
            return false;
        }

        public static boolean isTicking(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldIsTicking(i3);
            }
            return false;
        }

        public static void kill(int i3) {
            UE4.logCallUT("ParallelWorld.kill", "worldID: " + i3);
            if (precondition()) {
                GameActivityNative.ParallelWorldKill(i3);
            }
        }

        public static void killAll() {
            UE4.logCallUT("ParallelWorld.killAll");
            if (precondition()) {
                GameActivityNative.ParallelWorldKillAll();
            }
        }

        public static void load(int i3, String str, LoadParameters loadParameters, boolean z16) {
            UE4.logCallUT("ParallelWorld.load", "worldID: " + i3 + ",mapPath: " + str + ",background:" + z16 + ",parameters: " + loadParameters);
            if (z16) {
                GameActivityNative.ParallelWorldLoadAsync(i3, str, loadParameters);
            } else {
                GameActivityNative.ParallelWorldLoad(i3, str, loadParameters);
            }
        }

        public static void onDrawFrame(long j3, int i3) {
            GameActivityNative.nOnDrawFrame(j3, i3);
        }

        public static void onSurfaceChanged(long j3, Surface surface, int i3, int i16) {
            GameActivityNative.nOnSurfaceChanged(j3, surface, i3, i16);
        }

        public static void onSurfaceCreated(long j3, Surface surface, int i3, int i16) {
            GameActivityNative.nOnSurfaceCreated(j3, surface, i3, i16);
        }

        public static void onSurfaceDestroyed(long j3) {
            GameActivityNative.nOnSurfaceDestroyed(j3);
        }

        private static boolean precondition() {
            if (!UE4.engineActive) {
                UE4.log("ParallelWorld.precondition", "Error: ParallelWorld API can't be called when the engine is deactivated");
                UE4.setError(2);
                return false;
            }
            if (UE4.enginePurged) {
                UE4.log("ParallelWorld.precondition", "Error: ParallelWorld API can't be called when the engine is purged");
                UE4.setError(3);
                return false;
            }
            UE4.clearError();
            return true;
        }

        public static void releaseRender(long j3) {
            GameActivityNative.nRelease(j3);
        }

        public static void resizeBackbuffer(int i3, int i16, int i17) {
            UE4.logCallUT("ParallelWorld.resizeBackbuffer", "worldID: " + i3 + ",width: " + i16 + ",height:" + i17);
            if (precondition()) {
                GameActivityNative.ParallelWorldResizeBackbuffer(i3, i16, i17);
            }
        }

        public static void resizeWindow(int i3, int i16, int i17) {
            UE4.logCallUT("ParallelWorld.resizeWindow", "worldID: " + i3 + ",width: " + i16 + ",height:" + i17);
            if (precondition()) {
                GameActivityNative.ParallelWorldResizeWindow(i3, i16, i17);
            }
        }

        public static void setDrawMode(int i3, int i16) {
            UE4.logCallUT("ParallelWorld.setDrawMode", "worldID: " + i16 + ",drawMode: " + i16);
            if (precondition()) {
                GameActivityNative.ParallelWorldSetDrawMode(i3, i16);
            }
        }

        public static void setRenderingInDefocused(int i3, boolean z16) {
            UE4.logCallUT("ParallelWorld.setRenderingInDefocused", "worldID: " + i3 + ",rendering: " + z16);
            if (precondition()) {
                GameActivityNative.ParallelWorldSetRenderingInDefocused(i3, z16);
            }
        }

        public static void setTicking(int i3, boolean z16) {
            UE4.logCallUT("ParallelWorld.setTicking", "worldID: " + i3 + ",ticking: " + z16);
            if (precondition()) {
                GameActivityNative.ParallelWorldSetTicking(i3, z16);
            }
        }

        public static void setTickingInActive(int i3, boolean z16) {
            UE4.logCallUT("ParallelWorld.setTickingInActive", "worldID: " + i3 + ",ticking: " + z16);
            if (precondition()) {
                GameActivityNative.ParallelWorldSetTickingInActive(i3, z16);
            }
        }

        public static void setTickingInBackground(int i3, boolean z16) {
            UE4.logCallUT("ParallelWorld.setTickingInBackground", "worldID: " + i3 + ",ticking: " + z16);
            if (precondition()) {
                GameActivityNative.ParallelWorldSetTickingInBackground(i3, z16);
            }
        }

        public static void setViewport(int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17) {
            UE4.logCallUT("ParallelWorld.setWindow", "worldID: " + i3 + ",width: " + i18 + ",height:" + i19);
            if (precondition()) {
                GameActivityNative.ParallelWorldSetViewport(i3, i16, i17, i18, i19, z16, z17);
            }
        }

        public static void setWindow(int i3, Surface surface) {
            UE4.logCallUT("ParallelWorld.setWindow", "worldID: " + i3 + ",window:" + surface);
            if (precondition()) {
                GameActivityNative.ParallelWorldSetWindow(i3, surface);
            }
        }

        public static String stringify(int i3) {
            if (precondition()) {
                return GameActivityNative.ParallelWorldStringify(i3);
            }
            return "";
        }

        public static String stringifyAll() {
            if (precondition()) {
                return GameActivityNative.ParallelWorldStringifyAll();
            }
            return "";
        }

        public static void toggleActive(int i3) {
            UE4.logCallUT("ParallelWorld.toggleActive", "worldID: " + i3);
            if (!precondition()) {
                return;
            }
            if (isActive(i3)) {
                deactivate(i3);
            } else {
                activate(i3);
            }
        }

        public static void toggleTicking(int i3) {
            UE4.logCallUT("ParallelWorld.toggleTicking", "worldID: " + i3);
            if (precondition()) {
                setTicking(i3, !isTicking(i3));
            }
        }

        public static void dump(int i3) {
            dump(i3, false);
        }

        public static void dumpAll() {
            dumpAll(false);
        }

        public static void load(int i3, String str, LoadParameters loadParameters) {
            load(i3, str, loadParameters, false);
        }

        public static void resizeWindow(int i3, Surface surface, int i16, int i17) {
            UE4.logCallUT("ParallelWorld.resizeWindow", "worldID: " + i3 + ",width: " + i16 + ",height:" + i17 + ",window:" + surface);
            if (precondition()) {
                GameActivityNative.ParallelWorldResizeWindowExt(i3, surface, i16, i17);
            }
        }

        public static void load(int i3, String str) {
            load(i3, str, new LoadParameters());
        }
    }

    public static void ensure(boolean z16) {
        ensure(z16, "Expr is false");
    }

    public static void initEngine(Context context, GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener) {
        initEngine(context, null, false, cMShowEngineInitFinishListener, null);
    }

    private static void logBeginET(String str, String str2) {
        if (_logEnabled) {
            log(getLogBeginETPrefix(str) + str2);
        }
    }

    private static void logBeginGT(String str, String str2) {
        if (_logEnabled) {
            log(getLogBeginGTPrefix(str) + str2);
        }
    }

    private static void logBeginUT(String str, String str2) {
        if (_logEnabled) {
            log(getLogBeginUTPrefix(str) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logCallUT(String str, String str2) {
        if (_logEnabled) {
            log(getLogCallUTPrefix(str) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logEndET(String str, String str2) {
        if (_logEnabled) {
            log(getLogEndETPrefix(str) + str2);
        }
    }

    private static void logEndGT(String str, String str2) {
        if (_logEnabled) {
            log(getLogEndGTPrefix(str) + str2);
        }
    }

    private static void logEndUT(String str, String str2) {
        if (_logEnabled) {
            log(getLogEndUTPrefix(str) + str2);
        }
    }

    public static void profileBegin() {
        GameProfiler gameProfiler = _profiler;
        if (gameProfiler != null) {
            gameProfiler.begin();
        }
    }

    public static void profileDisable(boolean z16) {
        profileDisable();
        if (z16) {
            _profiler = null;
        }
    }

    public static void resizeBackbuffer(Context context, int i3, int i16, boolean z16) {
        logBeginUT("resizeBackbuffer(Context)", "Context: " + context + " Width: " + i3 + " Height: " + i16 + " bSync: " + z16);
        profileBegin();
        ensure(i3 > 0 && i16 > 0);
        if (getContext() == context) {
            GameActivityNative.ResizeBackbuffer(i3, i16, z16);
        } else {
            logIgnored("resizeBackbuffer(Context)", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("resizeBackbuffer(Context)");
    }

    public static void resizeWindow(Context context, Surface surface, boolean z16, boolean z17) {
        logBeginUT("resizeWindow(Context)", context, surface);
        profileBegin();
        ensureNotNull(context);
        if (getContext() == context) {
            resizeWindowInternal(surface, z16, z17);
        } else {
            logIgnored("resizeWindow(Context)", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("resizeWindow(Context)");
    }

    public static void setViewport(int i3, int i16, int i17, int i18) {
        setViewport(i3, i16, i17, i18, false, false, false);
    }

    public static void setViewportFull() {
        setViewport(0, 0, 0, 0, false, false, false);
    }

    public static void setWindow(Context context, Surface surface, int i3, int i16, int i17, int i18) {
        setWindow(context, surface, true, i3, i16, i17, i18, false, false);
    }

    public static void ensure(Object obj) {
        ensure(obj != null, "Object must be NotNull.");
    }

    public static void initEngine(Context context, Bundle bundle, boolean z16, GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener, GameActivityThunk.CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener) {
        initEngine(context, bundle, z16, cMShowEngineInitFinishListener, cMShowEngineFirstFrameListener, 1);
    }

    public static void loadModulesInDLL(boolean z16) {
        logBeginUT("loadModulesInDLL", "sync: " + z16 + " _engineDLLLoaded: " + _engineDLLLoaded);
        if (!_engineDLLLoaded) {
            GameActivityNative.LoadModulesInDLL(null, z16);
        }
        logEndUT("loadModulesInDLL");
    }

    private static void reinitEngine(Context context, boolean z16) {
        ensureNotNull(context);
        reinitEngineInternal(context, null, z16);
    }

    public static void setViewport(int i3, int i16, int i17, int i18, boolean z16) {
        setViewport(i3, i16, i17, i18, false, false, z16);
    }

    public static void setViewportFull(boolean z16) {
        setViewport(0, 0, 0, 0, false, false, z16);
    }

    public static void setWindow(Surface surface, int i3, int i16, int i17, int i18) {
        setWindow(surface, true, i3, i16, i17, i18, false, false);
    }

    public static void unloadModulesInDLL(boolean z16) {
        logBeginUT("unloadModulesInDLL", "sync: " + z16 + " _engineDLLLoaded: " + _engineDLLLoaded);
        if (_engineDLLLoaded) {
            GameActivityNative.UnloadModulesInDLL(null, z16);
        }
        logEndUT("unloadModulesInDLL");
    }

    public static void initEngine(Context context, Bundle bundle, boolean z16, GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener, GameActivityThunk.CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener, int i3) {
        logBeginUT("initEngine(Context)", "Context: " + context + ",Bundle: " + bundle + ",bCreateView: " + z16 + ",InitFinishListener: " + cMShowEngineInitFinishListener + ",FirstFrameListener: " + cMShowEngineFirstFrameListener + ",bAllowLoadingModuleManually: " + i3);
        profileBegin();
        ensureNotNull(context);
        if (i3 != -1) {
            GameActivityNative.SetAllowLoadingModuleManually(toBoolean(i3));
        }
        InitEngineInternal(context, cMShowEngineInitFinishListener, cMShowEngineFirstFrameListener);
        GameActivityBase.OnCreate(bundle, z16);
        profileEnd();
        logEndUT("initEngine(Context)");
    }

    public static void log(String str, String str2) {
        if (_logEnabled) {
            log("UE4." + str + " Message: " + str2);
        }
    }

    private static void logBeginUT(String str, Context context) {
        if (_logEnabled) {
            log(getLogBeginUTPrefix(str) + "Context: " + context);
        }
    }

    public static void setViewport(Context context, int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
        setViewport(context, i3, i16, i17, i18, z16, z17, false);
    }

    public static void setWindow(Context context, Surface surface, int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
        setWindow(surface, true, i3, i16, i17, i18, z16, z17);
    }

    public static void enterBackground() {
        logBeginUT("enterBackground");
        GameActivityNative.EnterBackground();
        GameActivityBase.ReleaseSensors();
        logEndUT("enterBackground");
    }

    public static void enterForeground() {
        logBeginUT("enterForeground");
        GameActivityBase.AcquireSensors();
        GameActivityNative.EnterForeground();
        logEndUT("enterForeground");
    }

    private static void reinitEngine(Context context, Bundle bundle, boolean z16) {
        ensureNotNull(context);
        reinitEngineInternal(context, bundle, z16);
    }

    public static void setViewport(Context context, int i3, int i16, int i17, int i18, boolean z16, boolean z17, boolean z18) {
        logBeginUT("setViewport(Context)", "Context: " + context + " Left: " + i3 + " Bottom: " + i16 + " Width: " + i17 + " Height: " + i18);
        profileBegin();
        ensure(context);
        ensure(i3 >= 0 && i16 >= 0 && i17 >= 0 && i18 >= 0, "(Left: " + i3 + " or Bottom: " + i16 + ") is negative OR (Width: " + i17 + " or height: " + i18 + ") isn't positive Anchor   (Left: " + z16 + " Bottom: " + z17 + ") bSync :" + z18);
        ensure((i17 == 0) == (i18 == 0), "Both width and height must be 0 at the same time to mean using fullscreen.");
        if (getContext() == context) {
            GameActivityNative.SetViewport(i3, i16, i17, i18, z16, z17, z18);
        } else {
            logIgnored("setViewport(Context)", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("setViewport(Context)");
    }

    public static void setWindow(Context context, Surface surface, boolean z16, int i3, int i16, int i17, int i18, boolean z17, boolean z18) {
        logBeginUT("setWindow(Context)", " Context: " + context + " Surface: " + surface + " Viewport (Left: " + i3 + " Bottom: " + i16 + " Width: " + i17 + " Height: " + i18 + ") Anchor   (Left: " + z17 + " Bottom: " + z18 + ")");
        profileBegin();
        ensure(context);
        ensure(i3 >= 0 && i16 >= 0 && i17 > 0 && i18 > 0, "Viewport (Left: " + i3 + " or Bottom: " + i16 + ") is negative OR Viewport (Width: " + i17 + " or height: " + i18 + ") isn't positive");
        if (getContext() == context) {
            GameActivityNative.SetWindow(surface, z16, i3, i16, i17, i18, z17, z18);
        } else {
            logIgnored("setWindow(Context)", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("setWindow(Context)");
    }

    public static void inputEvent(int i3, KeyEvent keyEvent) {
        if (preconditionEngineInited("inputEvent(int,KeyEvent)")) {
            if (!_shippingBuild) {
                logBeginUT("inputEvent(KeyEvent,KeyCode)", "KeyEvent: " + keyEvent.getAction() + " KeyCode: " + i3);
            }
            inputEventInternal(keyEvent);
            GameActivityBase.OnKeyDown(i3, keyEvent);
            if (_shippingBuild) {
                return;
            }
            logEndUT("inputEvent(KeyEvent,KeyCode)");
        }
    }

    private static void logBeginUT(String str, Object obj) {
        if (_logEnabled) {
            log(getLogBeginUTPrefix(str) + "Object: " + obj);
        }
    }

    public static void resumeEngine(Context context, GameActivityBase.SurfaceListener surfaceListener) {
        logBeginUT("resumeEngine(SurfaceListener)", "context: " + context + " surfaceListener: " + surfaceListener);
        profileBegin();
        ensure(context);
        ensure(surfaceListener);
        if (getContext() != context || GameActivityBase.surfaceListener != surfaceListener) {
            GameActivityBase.surfaceListener = surfaceListener;
            forceClearWindow();
        }
        Surface surface = _window;
        resumeEngineInternal(context, surface, surface == null);
        profileEnd();
        logEndUT("resumeEngine(SurfaceListener)");
    }

    private static void reinitEngine(Bundle bundle) {
        reinitEngineInternal(null, bundle, false);
    }

    public static void terminateWindow(Context context, boolean z16) {
        logBeginUT("terminateWindow(Context)", "Context:" + context + " Async:" + z16);
        profileBegin();
        if (getContext() == context) {
            forceClearWindowInternal(z16);
        } else {
            logIgnored("terminateWindow(Context)", "context is mismatched, CurrentContext: " + getContext() + " IncomingContext: " + context);
        }
        profileEnd();
        logEndUT("terminateWindow(Context)");
    }

    public static void clearWindow(Context context) {
        clearWindow(context, false);
    }

    private static void logBeginUT(String str, Context context, Surface surface) {
        if (_logEnabled) {
            log(getLogBeginUTPrefix(str) + "Context: " + context + " Surface: " + surface);
        }
    }

    public static void refreshEngine(Context context, Surface surface) {
        logBeginUT("refreshEngine(Context)", "Context: " + context + " Surface: " + surface);
        profileBegin();
        ensureNotNull(context);
        forceClearWindow();
        resumeEngine(context, surface);
        profileEnd();
        logEndUT("refreshEngine(Context)");
    }

    private static void reinitEngine(boolean z16) {
        reinitEngineInternal(null, null, z16);
    }

    public static void clearWindow(boolean z16) {
        logBeginUT("clearWindow(Force)", "Async:" + z16);
        profileBegin();
        forceClearWindowInternal(z16);
        profileEnd();
        logEndUT("clearWindow(Force)");
    }

    private static void reinitEngine(Bundle bundle, boolean z16) {
        reinitEngineInternal(null, bundle, z16);
    }

    public static void resizeBackbuffer(int i3, int i16, boolean z16) {
        logBeginUT("resizeBackbuffer(NoContext)", " Width: " + i3 + " Height: " + i16 + " bSync: " + z16);
        profileBegin();
        ensure(i3 > 0 && i16 > 0);
        GameActivityNative.ResizeBackbuffer(i3, i16, z16);
        profileEnd();
        logEndUT("resizeBackbuffer(NoContext)");
    }

    public static void resizeWindow(Surface surface) {
        resizeWindow(surface, false, false);
    }

    public static void resizeWindow(Surface surface, boolean z16) {
        resizeWindow(surface, z16, false);
    }

    public static void initEngine(Activity activity) {
        initEngine(activity, (Bundle) null, (GameActivityBase.SurfaceListener) null, (FrameLayout) null, (GameActivityThunk.CMShowEngineInitFinishListener) null, (GameActivityThunk.CMShowEngineFirstFrameListener) null);
    }

    public static void resizeWindow(Surface surface, boolean z16, boolean z17) {
        logBeginUT("resizeWindow(Surface)", surface);
        resizeWindowInternal(surface, z16, z17);
        logEndUT("resizeWindow(Surface)");
    }

    public static void initEngine(Activity activity, Bundle bundle) {
        initEngine(activity, bundle, (GameActivityBase.SurfaceListener) null, (FrameLayout) null, (GameActivityThunk.CMShowEngineInitFinishListener) null, (GameActivityThunk.CMShowEngineFirstFrameListener) null);
    }

    public static void inputEvent(MotionEvent motionEvent) {
        if (preconditionEngineInited("inputEvent(MotionEvent)")) {
            if (!_shippingBuild) {
                logBeginUT("inputEvent(MotionEvent)", "MotionEvent: " + motionEvent.getAction());
            }
            GameActivityNative.OnMotionEvent(motionEvent);
            if (_shippingBuild) {
                return;
            }
            logEndUT("inputEvent(MotionEvent)");
        }
    }

    public static void clearWindow() {
        clearWindow(false);
    }

    public static void initEngine(Activity activity, Bundle bundle, FrameLayout frameLayout) {
        ensureNotNull(frameLayout);
        initEngine(activity, bundle, (GameActivityBase.SurfaceListener) null, frameLayout, (GameActivityThunk.CMShowEngineInitFinishListener) null, (GameActivityThunk.CMShowEngineFirstFrameListener) null);
    }

    public static void setWindow(Surface surface, boolean z16, int i3, int i16, int i17, int i18, boolean z17, boolean z18) {
        logBeginUT("setWindow(NoContext)", " Surface: " + surface + " Viewport (Left: " + i3 + " Bottom: " + i16 + " Width: " + i17 + " Height: " + i18 + ")");
        profileBegin();
        ensure(i3 >= 0 && i16 >= 0 && i17 > 0 && i18 > 0, "Viewport (Left: " + i3 + " or Bottom: " + i16 + ") is negative OR Viewport (Width: " + i17 + " or Height: " + i18 + ") isn't positive Anchor   (Left: " + z17 + " Bottom: " + z18 + ")");
        GameActivityNative.SetWindow(surface, z16, i3, i16, i17, i18, z17, z18);
        profileEnd();
        logEndUT("setWindow(NoContext)");
    }

    public static void terminateWindow(Surface surface) {
        terminateWindow(surface, false);
    }

    public static void refreshEngine(Surface surface) {
        if (getContext() != null) {
            refreshEngine(getContext(), surface);
        } else {
            logIgnored("refreshEngine(Surface)", "context is null");
        }
    }

    public static void setViewport(int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
        setViewport(i3, i16, i17, i18, z16, z17, false);
    }

    public static void terminateWindow(Context context) {
        terminateWindow(context, false);
    }

    public static void initEngine(Activity activity, Bundle bundle, GameActivityBase.SurfaceListener surfaceListener) {
        ensureNotNull(surfaceListener);
        initEngine(activity, bundle, surfaceListener, (FrameLayout) null, (GameActivityThunk.CMShowEngineInitFinishListener) null, (GameActivityThunk.CMShowEngineFirstFrameListener) null);
    }

    public static void resumeEngine(Context context, Surface surface) {
        logBeginUT("resumeEngine(Surface)", context, surface);
        profileBegin();
        ensure(context);
        if (surface == null) {
            log("resumeEngine(Surface)", " WARNING: Incoming window is null,so it just resumes engine,but no window-init.");
        }
        resumeEngineInternal(context, surface, false);
        profileEnd();
        logEndUT("resumeEngine(Surface)");
    }

    public static void setViewport(int i3, int i16, int i17, int i18, boolean z16, boolean z17, boolean z18) {
        logBeginUT("setViewport(NoContext)", " Left: " + i3 + " Bottom: " + i16 + " Width: " + i17 + " Height: " + i18 + " bSync: " + z18);
        profileBegin();
        ensure(i3 >= 0 && i16 >= 0 && i17 >= 0 && i18 >= 0, "Viewport (Left: " + i3 + " or Bottom: " + i16 + ") is negative OR Viewport (Width: " + i17 + " or height: " + i18 + ") isn't positive Anchor   (Left: " + z16 + " Bottom: " + z17 + ") bSync :" + z18);
        ensure((i17 == 0) == (i18 == 0), "Both width and height must be 0 at the same time to mean using fullscreen.");
        GameActivityNative.SetViewport(i3, i16, i17, i18, z16, z17, z18);
        profileEnd();
        logEndUT("setViewport(NoContext)");
    }

    public static void initEngine(Activity activity, GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener) {
        initEngine(activity, (Bundle) null, (GameActivityBase.SurfaceListener) null, (FrameLayout) null, cMShowEngineInitFinishListener, (GameActivityThunk.CMShowEngineFirstFrameListener) null);
    }

    public static void refreshEngine() {
        if (getContext() != null && getWindow() != null) {
            refreshEngine(getContext(), getWindow());
        } else {
            logIgnored("refreshEngine()", "context or surface are null");
        }
    }

    public static void initEngine(Activity activity, Bundle bundle, GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener, GameActivityThunk.CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener) {
        initEngine(activity, bundle, (GameActivityBase.SurfaceListener) null, (FrameLayout) null, cMShowEngineInitFinishListener, cMShowEngineFirstFrameListener);
    }

    public static void initEngine(Activity activity, Bundle bundle, GameActivityBase.SurfaceListener surfaceListener, FrameLayout frameLayout, GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener, GameActivityThunk.CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener) {
        initEngine(activity, bundle, surfaceListener, frameLayout, cMShowEngineInitFinishListener, cMShowEngineFirstFrameListener, 0);
    }

    public static void initEngine(Activity activity, Bundle bundle, GameActivityBase.SurfaceListener surfaceListener, FrameLayout frameLayout, GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener, GameActivityThunk.CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener, int i3) {
        logBeginUT("initEngine(Activity)", "Activity: " + activity + ",Bundle: " + bundle + ",SurfaceListener: " + surfaceListener + ",FrameLayout: " + frameLayout + ",InitFinishListener: " + cMShowEngineInitFinishListener + ",FirstFrameListener: " + cMShowEngineFirstFrameListener + ",bAllowLoadingModuleManually: " + i3);
        profileBegin();
        ensureNotNull(activity);
        ensure(surfaceListener == null || frameLayout == null, "surfaceListener and frameLayout can't coexist!!");
        if (i3 != -1) {
            if (_inited) {
                loadModulesInDLL(true);
            }
            GameActivityNative.SetAllowLoadingModuleManually(toBoolean(i3));
        }
        InitEngineInternal(activity, cMShowEngineInitFinishListener, cMShowEngineFirstFrameListener);
        if (surfaceListener != null) {
            GameActivityBase.surfaceListener = surfaceListener;
            GameActivityBase.OnCreate(bundle, true);
        } else if (frameLayout != null) {
            GameActivityBase.OnCreate(bundle, frameLayout);
        } else {
            GameActivityBase.OnCreate(bundle, false);
        }
        profileEnd();
        logEndUT("initEngine(Activity)");
    }

    public static void resumeEngine(Context context, boolean z16) {
        logBeginUT("resumeEngine(bCreateView)", "context: " + context + " bCreateView: " + z16);
        profileBegin();
        ensure(context);
        if (!z16) {
            log("resumeEngine(bCreateView)", " WARNING: bCreateView is false,so it just (maybe reinits and ) resumes engine,but no window-init.");
        }
        resumeEngineInternal(context, null, z16);
        profileEnd();
        logEndUT("resumeEngine(bCreateView)");
    }

    public static void setEngineAutoPurgeEnabled(boolean z16) {
    }

    public static void initEngine(InitEngineParams initEngineParams) {
        logBeginUT("initEngine(InitEngineParams)");
        ensure(initEngineParams);
        ensure(initEngineParams.context);
        if (_inited) {
            if (initEngineParams.bLoadModulesInDLL) {
                loadModulesInDLL(true);
            }
        } else {
            GameActivityNative.SetAllowLoadingModuleManually(!initEngineParams.bLoadModulesInDLL);
        }
        Context context = initEngineParams.context;
        if (context instanceof Activity) {
            initEngine((Activity) context, initEngineParams.state, initEngineParams.surfaceListener, initEngineParams.frameLayout, initEngineParams.initFinishListener, initEngineParams.firstFrameListener, -1);
        } else {
            initEngine(context, initEngineParams.state, initEngineParams.bCreateView, initEngineParams.initFinishListener, initEngineParams.firstFrameListener, -1);
        }
        if (initEngineParams.sStartCommand.length() > 0) {
            GameActivityNative.SetStartCommand(initEngineParams.sStartCommand);
        }
        logEndUT("initEngine(InitEngineParams)");
    }
}
