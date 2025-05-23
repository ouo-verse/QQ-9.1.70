package com.epicgames.ue4;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import com.epicgames.ue4.UE4;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameActivityNative {
    public static native void AbandonModule(String str, boolean z16);

    public static native void AcquirePermission(String str);

    public static native void CallLua(String str, String str2, boolean z16);

    public static native void Callback(int i3, String str);

    public static native boolean CanFinish();

    public static native void DressCostume(int i3);

    public static native void EnterAvatarShow(int i3);

    public static native void EnterBackground();

    public static native void EnterForeground();

    public static native String FindModules(String str, boolean z16);

    public static native void FlushEngine();

    public static native int GetAIFaceGender();

    public static native String GetAIFaceVersion();

    public static native boolean GetAllowLoadingModuleManually();

    public static native String GetAvatarAppearanceKey();

    public static native String GetModuleManifest();

    public static native boolean HasModule(String str);

    public static native boolean HasWindow(Surface surface);

    public static native boolean IsBootProfilingEnabled();

    public static native boolean IsEngineLooping();

    public static native boolean IsLoadedModule(String str);

    public static native boolean IsPortraitOrientation();

    public static native boolean IsSystemLoadLibraryEnabled();

    public static native void LeaveAvatarShow();

    public static native void LoadModule(String str, boolean z16);

    public static native void LoadModulesInDLL(String str, boolean z16);

    public static native void LoadModulesInPlugin(String str, boolean z16);

    public static native void LowLevelOutput(String str);

    public static native void Main(Context context, Object obj);

    public static native void MountPak(String str, int i3, String str2, boolean z16, boolean z17);

    public static native void OnBackPressed();

    public static native void OnCMShowNetworkError(String str, int i3);

    public static native void OnCMShowNetworkStateChanged(int i3);

    public static native boolean OnCMShowReceiveData(String str, byte[] bArr);

    public static native void OnContentRectChanged();

    public static native void OnDestroy();

    public static native void OnFocusGained();

    public static native void OnFocusLost();

    public static native void OnInputChanged();

    public static native void OnKeyEvent(KeyEvent keyEvent);

    public static native void OnKeyEventParameters(KeyEvent keyEvent, int i3, int i16, int i17, int i18, int i19, int i26);

    public static native void OnLowMemory();

    public static native void OnMotionEvent(MotionEvent motionEvent);

    public static native void OnPause();

    public static native void OnPortraitOrientationChanged(boolean z16, int i3, int i16);

    public static native void OnReceiveProcessEvent(int i3, String str);

    public static native void OnResume();

    public static native void OnSaveState();

    public static native void OnStart();

    public static native void OnStop();

    public static native void OnWindowInited(Surface surface, boolean z16);

    public static native void OnWindowRedrawNeeded();

    public static native void OnWindowResized(Surface surface, boolean z16, boolean z17);

    public static native void OnWindowTerminated(boolean z16);

    public static native void OpenFocusWorldLevel(String str);

    public static native void OpenLevel(String str);

    public static native void ParallelWorldActivate(int i3);

    public static native boolean ParallelWorldCanFocus(int i3);

    public static native void ParallelWorldClearWindow(int i3);

    public static native int ParallelWorldCreate();

    public static native void ParallelWorldCreateWidget(int i3, String str);

    public static native void ParallelWorldDeactivate(int i3);

    public static native void ParallelWorldDefocus(int i3);

    public static native void ParallelWorldDump(int i3, boolean z16);

    public static native void ParallelWorldDumpAll(boolean z16);

    public static native boolean ParallelWorldExists(int i3);

    public static native void ParallelWorldFocus(int i3);

    public static native int ParallelWorldGetFocusedID();

    public static native boolean ParallelWorldHasWindow(int i3);

    public static native boolean ParallelWorldIsActive(int i3);

    public static native boolean ParallelWorldIsBackground(int i3);

    public static native boolean ParallelWorldIsFocused(int i3);

    public static native boolean ParallelWorldIsKilled(int i3);

    public static native boolean ParallelWorldIsRenderingInDefocused(int i3);

    public static native boolean ParallelWorldIsTicking(int i3);

    public static native void ParallelWorldKill(int i3);

    public static native void ParallelWorldKillAll();

    public static native void ParallelWorldLoad(int i3, String str, UE4.ParallelWorld.LoadParameters loadParameters);

    public static native void ParallelWorldLoadAsync(int i3, String str, UE4.ParallelWorld.LoadParameters loadParameters);

    public static native void ParallelWorldResizeBackbuffer(int i3, int i16, int i17);

    public static native void ParallelWorldResizeWindow(int i3, int i16, int i17);

    public static native void ParallelWorldResizeWindowExt(int i3, Surface surface, int i16, int i17);

    public static native void ParallelWorldSetDrawMode(int i3, int i16);

    public static native void ParallelWorldSetRenderingInDefocused(int i3, boolean z16);

    public static native void ParallelWorldSetTicking(int i3, boolean z16);

    public static native void ParallelWorldSetTickingInActive(int i3, boolean z16);

    public static native void ParallelWorldSetTickingInBackground(int i3, boolean z16);

    public static native void ParallelWorldSetViewport(int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17);

    public static native void ParallelWorldSetWindow(int i3, Surface surface);

    public static native String ParallelWorldStringify(int i3);

    public static native String ParallelWorldStringifyAll();

    public static native void PauseEngineLoop(boolean z16, int i3, int i16, int i17, int i18);

    public static native void PreloadResources();

    public static native void PrintModule(String str);

    public static native void PrintModulesInDLL(String str);

    public static native void PrintModulesInPlugin(String str);

    public static native void PrintString(String str);

    public static native void PurgeEngine(boolean z16);

    public static native void RecordAvatarPortrait(int i3, int i16, int i17, int i18, int i19);

    public static native void RecoverEngine();

    public static native void ResizeBackbuffer(int i3, int i16, boolean z16);

    public static native void ResumeEngineLoop();

    public static native void SaveExternalTexture(int i3, String str);

    public static native void SetAllowLoadingModuleManually(boolean z16);

    public static native void SetContext(Context context);

    public static native void SetDeviceOrientation(int i3, boolean z16);

    public static native void SetEGLShareContext(long j3);

    public static native void SetEmbeddedStartupConfigure(String str);

    public static native void SetEngineAutoPurgeEnabled(boolean z16);

    public static native void SetEngineAutoPurgeOnBackPressed(boolean z16);

    public static native void SetProcessType(int i3);

    public static native void SetStartCommand(String str);

    public static native void SetStartupConfigureExtra(String str);

    public static native void SetSystemLoadLibraryEnabled(boolean z16);

    public static native void SetViewport(int i3, int i16, int i17, int i18, boolean z16, boolean z17, boolean z18);

    public static native void SetWindow(Surface surface, boolean z16, int i3, int i16, int i17, int i18, boolean z17, boolean z18);

    public static native void SynthesisSameStyleVideoEndCallback(int i3, int i16);

    public static native void UnloadModule(String str, boolean z16);

    public static native void UnloadModulesInDLL(String str, boolean z16);

    public static native void UnloadModulesInPlugin(String str, boolean z16);

    public static native long nInitRender();

    public static native void nOnDrawFrame(long j3, int i3);

    public static native void nOnSurfaceChanged(long j3, Surface surface, int i3, int i16);

    public static native void nOnSurfaceCreated(long j3, Surface surface, int i3, int i16);

    public static native void nOnSurfaceDestroyed(long j3);

    public static native void nRelease(long j3);
}
