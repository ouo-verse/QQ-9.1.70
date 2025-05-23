package com.tencent.ark;

import android.graphics.Bitmap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ark {
    public static final int APP_APPLICATION_NULL = 0;
    public static final int APP_INPUTMENU_COPYPASTE = 2;
    public static final int APP_INPUTMENU_PASTEONLY = 0;
    public static final int APP_INPUTMENU_SELECTPASTE = 1;
    public static final int APP_INPUTTYPE_DECIMAL = 4;
    public static final int APP_INPUTTYPE_EMAIL = 3;
    public static final int APP_INPUTTYPE_NUMBER = 2;
    public static final int APP_INPUTTYPE_PASSWORD = 1;
    public static final int APP_INPUTTYPE_TELEPHONE = 5;
    public static final int APP_INPUTTYPE_TEXT = 0;
    public static final int APP_MINVER_HIGHER = 3;
    public static final int APP_SCRIPT_TYPE_JAVASCRIPT = 2;
    public static final int APP_SCRIPT_TYPE_LUA = 1;
    public static final int APP_SCRIPT_TYPE_NULL = 0;
    public static final String APP_SPECIFIC_APPNAME = "appName";
    public static final String APP_SPECIFIC_APPPATH = "appPath";
    public static final String APP_SPECIFIC_BIZSRC = "bizSrc";
    public static final int APP_TARGETVER_LOWER = 2;
    public static final int APP_URLCHECKING_LIST_TYPE_BLACK = 1;
    public static final int APP_URLCHECKING_LIST_TYPE_WHITE = 0;
    public static final int APP_VER_ERROR = 0;
    public static final int APP_VER_MATCH = 1;
    public static final String ARKMETADATA_JSON = "json";
    public static final String ARKMETADATA_XML = "xml";
    public static final int BORDER_RECTANGLE = 0;
    public static final int BORDER_ROUND_CORNER = 1;
    public static final int BORDER_ROUND_CORNER_WITH_HORN = 2;
    public static final int BORDER_ROUND_CORNER_WITH_MULTI_RADIUS = 3;
    public static final int VariantType_Bool = 2;
    public static final int VariantType_Double = 4;
    public static final int VariantType_Int32 = 3;
    public static final int VariantType_None = 0;
    public static final int VariantType_Null = 1;
    public static final int VariantType_Object = 6;
    public static final int VariantType_String = 5;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Application extends NativeObject {
        Application() {
        }

        public static final native Application Create(String str, String str2, String str3);

        public static native void EnableScriptLeakCheck(boolean z16);

        public static native boolean JSCLoaded();

        public static native void OnConfigurationChanged();

        public native boolean CheckPermissions(String str);

        public native boolean CheckShareUrlLegality(String str);

        public native boolean CheckUrlLegality(String str);

        public native int CheckVersion();

        public native boolean CopyIconToBitmap(Bitmap bitmap);

        public native String GetActionSet();

        public native String GetDescription();

        public native String GetEngineResPath();

        public native String GetID();

        public native int GetIconHeight();

        public native int GetIconWidth();

        public native String GetLauncher();

        public native int GetScriptType();

        public native String GetSpecific(String str);

        public native String GetSystemPathFromLocal(String str);

        public native String GetUrlWhiteList();

        public native String GetVersion();

        public native void IncreaseGraphicMemSize(long j3);

        public native boolean Load(String str, String str2, String str3);

        public native void Release();

        public native boolean Run(ApplicationCallback applicationCallback, String str);

        public native void SetForeground(boolean z16);

        public native boolean SetSpecific(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ApplicationCallback {
        void AppCreate(Application application);

        void AppDestroy(Application application);

        boolean CheckUrlLegalityCallback(Application application, String str);

        void OutputScriptError(String str, String str2);

        void RegisterModules(ModuleRegister moduleRegister, Application application);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Container extends NativeObject {
        public Container() {
            this.mNative = newNativeObject(this);
        }

        private static final native void deleteNativeObject(long j3);

        private static final native long newNativeObject(Container container);

        public native boolean ActivateRootView();

        public native boolean AttachBitmap(Bitmap bitmap);

        public native boolean CheckShare();

        public native boolean CreateHardwareBitmap(int i3, int i16);

        public native boolean CreateRootView(Application application, String str);

        public native boolean DeactivateRootView();

        public void DeletePtr() {
            deleteNativeObject(this.mNative);
            this.mNative = 0L;
        }

        public native void DestroyHardwareBitmap();

        public native void DetachBitmap(Bitmap bitmap);

        public native long GetViewHandle();

        public native boolean GetViewOpaque();

        public native String GetViewShare();

        public native boolean InputCanRedo();

        public native boolean InputCanUndo();

        public native boolean InputDeleteBackward();

        public native String InputGetSelectText();

        public native boolean InputInsertText(String str);

        public native boolean InputIsFocused();

        public native boolean InputRedo();

        public native boolean InputSelect();

        public native boolean InputSelectAll();

        public native boolean InputSetCaretHolderSize(int i3, int i16);

        public native boolean InputSetSelectHolderSize(int i3, int i16);

        public native boolean InputUndo();

        public native boolean InvalidSurface();

        public native boolean Paint(float f16, float f17, float f18, float f19);

        public native void SetBorderHornLeft(boolean z16);

        public native void SetBorderRadius(float f16);

        public native void SetBorderRadiusTop(float f16);

        public native void SetBorderType(int i3);

        public native void SetContainerCallback(ContainerCallback containerCallback);

        public native void SetContextHolder(EGLContextHolder eGLContextHolder);

        public native void SetDisableGPURasterization(boolean z16);

        public native void SetDisableGPURendering(boolean z16);

        public native void SetID(String str);

        public native void SetIndependentView(boolean z16);

        public native void SetMetadata(String str, String str2);

        public native void SetShowFps(boolean z16);

        public native void SetSize(int i3, int i16);

        public native void TouchCancel(float[] fArr, float[] fArr2, int[] iArr, int i3);

        public native void TouchEnd(float[] fArr, float[] fArr2, int[] iArr, int i3);

        public native void TouchMove(float[] fArr, float[] fArr2, int[] iArr, int i3);

        public native void TouchStart(float[] fArr, float[] fArr2, int[] iArr, int i3);

        public native void ViewEvent(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ContainerCallback {
        void InputFocusChanged(boolean z16, boolean z17, int i3, float f16, float f17, float f18, float f19);

        void InputMenuChanged(boolean z16, int i3, int i16, int i17, int i18);

        void InputSelectChanged(int i3, int i16, int i17, int i18, float f16, float f17, float f18, float f19);

        void SyncRect(float f16, float f17, float f18, float f19);

        void Update(float f16, float f17, float f18, float f19);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ModuleCallbackWrapper {
        void Destruct();

        String GetTypeName();

        boolean HasMethod(String str);

        boolean Invoke(String str, VariantWrapper[] variantWrapperArr, VariantWrapper variantWrapper);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ModuleRegister extends NativeObject {
        ModuleRegister() {
        }

        public native boolean RegCallbackWrapper(ModuleCallbackWrapper moduleCallbackWrapper);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class NativeObject {
        protected long mNative = 0;

        protected void finalize() throws Throwable {
            if (this.mNative != 0) {
                Logger.logW("ark.leak", StringUtil.format("leak.obj.ark.%s.%h!!", getClass().getSimpleName(), this));
            }
            super.finalize();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface PlayerStub {
        public static final int ERROR_NETWORK = -3;
        public static final int ERROR_NO_RESOURCE = -5;
        public static final int ERROR_SUCCESS = 0;
        public static final int ERROR_UNKNOWN = -1;
        public static final int ERROR_UNSUPPORT_HARDWARE = -4;
        public static final int ERROR_UNSUPPORT_MEDIA = -2;
        public static final int STATE_ERROR = 6;
        public static final int STATE_LOAD = 2;
        public static final int STATE_LOADING = 1;
        public static final int STATE_PAUSE = 4;
        public static final int STATE_PLAY = 3;
        public static final int STATE_START = 0;
        public static final int STATE_STOP = 5;
        public static final int TYPE_AUDIO = 1;
        public static final int TYPE_VIDEO = 0;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class FrameInfo {
            public int height;
            public int texture;
            public int width;
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class MediaInfo {
            public double duration;
            public int framerate;
            public int height;
            public boolean islive;
            public int pixelbits;
            public int state;
            public int type;
            public int width;
        }

        void Destroy();

        double GetBufferedTime();

        double GetCurrentTime();

        int GetErrorCode();

        MediaInfo GetMediaInfo();

        boolean Load(String str);

        boolean Pause();

        boolean Play();

        boolean Resume();

        boolean Seek(double d16);

        void SetBufferingCallback(long j3, long j16);

        void SetFrameCallback(long j3, long j16);

        void SetOutputSizeHint(int i3, int i16);

        void SetStateCallback(long j3, long j16);

        boolean SetVolume(float f16);

        boolean Stop();

        boolean VideoPreviewSupported();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface PlayerStubFactory {
        PlayerStub CreateStub();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface RuntimeClassCallbackWrapper {
        boolean Destruct();

        boolean HasMethod(String str);

        boolean Invoke(String str, VariantWrapper[] variantWrapperArr, VariantWrapper variantWrapper);

        boolean IsModule();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class VariantWrapper extends NativeObject {
        VariantWrapper() {
        }

        public native VariantWrapper Copy();

        public native VariantWrapper Create();

        public native boolean CreateObject(String str, RuntimeClassCallbackWrapper runtimeClassCallbackWrapper);

        public native boolean GetBool();

        public native double GetDouble();

        public native int GetInt();

        public native String GetString();

        public native String GetTableAsJsonString();

        public native int GetType();

        public native long GetView();

        public native boolean Invoke(String str, VariantWrapper[] variantWrapperArr, VariantWrapper variantWrapper);

        public native boolean InvokeDefault(VariantWrapper[] variantWrapperArr, VariantWrapper variantWrapper);

        public native boolean IsArray();

        public native boolean IsFunction();

        public native boolean IsString();

        public native boolean IsTable();

        public native boolean IsUserObject();

        public native boolean IsView();

        public native void Reset();

        public native boolean SetBool(boolean z16);

        public native boolean SetDouble(double d16);

        public native boolean SetInt(int i3);

        public native boolean SetMap(Map<String, String> map);

        public native boolean SetNull();

        public native boolean SetString(String str);

        public native boolean SetTableAsJsonString(String str);

        public native boolean SetView(long j3);
    }

    public static final native void MediaSetStub(PlayerStubFactory playerStubFactory);

    public static final native void PlayerBufferingChange(long j3, long j16, boolean z16);

    public static final native void PlayerStateChange(long j3, long j16, int i3, int i16);

    public static final native void PlayerUpdateFrame(long j3, long j16, PlayerStub.FrameInfo frameInfo);

    public static final native void SetCustomFontEnable(boolean z16);

    public static final native void SetEmojiBasePath(String str);

    public static final native void SetEnvironmentManager(ArkEnvironmentManager arkEnvironmentManager);

    public static final native void SetUseAndroidHTTP(boolean z16);

    public static final native void arkApplicationSetConfig(Application application, String str);

    public static final long arkGetARMv7LibCRC32() {
        return 2675371956L;
    }

    public static final int arkGetARMv7LibSize() {
        return 3650560;
    }

    public static final native Container arkGetContainer(long j3);

    public static final int arkGetMaxTouchPoints() {
        return 8;
    }

    public static final int arkGetMinPlatformVersion() {
        return 2;
    }

    public static final native float arkGetPixelScale();

    public static final long arkGetPlatformBuildNumber() {
        return 1842025076L;
    }

    public static final int arkGetPlatformVersion() {
        return 36;
    }

    public static final long arkGetPngARMv7LibCRC32() {
        return 199180749L;
    }

    public static final int arkGetPngARMv7LibSize() {
        return 79992;
    }

    public static final native void arkHTTPSetDefaultHttpProxy(String str, int i3);

    public static final native int arkHTTPSetDownloadDirectory(String str);

    public static final native int arkHTTPShutdown();

    public static final native int arkHTTPStartup();

    public static final native boolean arkNotify(String str, String str2, String str3, String str4, String str5);

    public static final native void arkSetLibraryPath(String str, String str2);

    public static final native void arkSetPixelScale(float f16);

    public static final native void arkSetScreenSize(float f16, float f17);

    public static final native void arkSetStoragePath(String str, String str2);

    public static final long getArkSOArm64CRC() {
        return 3557938533L;
    }

    public static final int getArkSOArm64Size() {
        return 5600696;
    }

    public static final long getPngArm64CRC() {
        return 273271347L;
    }

    public static final int getPngArm64Size() {
        return 110184;
    }
}
