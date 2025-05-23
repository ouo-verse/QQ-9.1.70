package com.tencent.tdf;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.Surface;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.channel.ChannelRegistry;
import com.tencent.tdf.clipboard.ClipboardChannel;
import com.tencent.tdf.embed.EmbeddedViewController;
import com.tencent.tdf.embed.mutatorsstack.MutatorsStack;
import com.tencent.tdf.event.TDFPlatformEventHandler;
import com.tencent.tdf.file.FileManager;
import com.tencent.tdf.file.IFileManager;
import com.tencent.tdf.filepicker.FilePickerChannel;
import com.tencent.tdf.keyboard.KeyboardChannel;
import com.tencent.tdf.text.TDFTextInputClientManager;
import com.tencent.tdf.utils.FontUtils;
import com.tencent.tdf.view.HostViewEventDelegate;
import com.tencent.tdf.view.INativeViewDelegate;
import com.tencent.tdf.vsync.IPipelineDriver;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFJNI {
    static IPatchRedirector $redirector_;
    private ClipboardChannel clipboardChannel;
    private TDFPlatformEventHandler eventHandler;
    private HostViewEventDelegate hostViewDelegate;
    private KeyboardChannel keyboardChannel;
    private ChannelRegistry mChannelRegistry;
    private Context mContext;
    private TDFEngineEvent mEngineEvent;
    private IFileManager mFileManager;
    private FilePickerChannel mFilePickerChannel;
    private long mNativeEngine;
    private IPipelineDriver mPipelineDriver;
    private TDFTextInputClientManager textInputClientManager;

    public TDFJNI(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mNativeEngine = -1L;
        this.mFileManager = new FileManager();
        this.mContext = context;
    }

    private native long attachToNative(TDFJNI tdfjni, TDFEngineConfig tDFEngineConfig, boolean z16);

    private void covertToTDFImageView() {
        if (!isNativeAlive()) {
            return;
        }
        this.hostViewDelegate.onConvertToImageView();
    }

    private boolean createDirectory(String str) {
        return this.mFileManager.makeDir(str);
    }

    private Bitmap decodeByteArray(byte[] bArr, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPremultiplied = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = Math.max(1, i3);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        Bitmap.Config config = decodeByteArray.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config == config2) {
            return decodeByteArray;
        }
        return decodeByteArray.copy(config2, true);
    }

    private boolean deleteFile(String str) {
        return this.mFileManager.delete(str);
    }

    private boolean fileExists(String str) {
        return this.mFileManager.exists(str);
    }

    private String getAppCacheDirectoryPath() {
        return this.mContext.getCacheDir().getAbsolutePath();
    }

    private String getAppRootPath() {
        return this.mContext.getFilesDir().getAbsolutePath();
    }

    private AssetManager getAssetsManager() {
        return this.mContext.getAssets();
    }

    private ChannelRegistry getChannelRegistry() {
        return this.mChannelRegistry;
    }

    private View getEmbeddedView(EmbeddedViewController embeddedViewController) {
        if (!isNativeAlive()) {
            return null;
        }
        return embeddedViewController.getEmbeddedView();
    }

    private List<FileManager.FileInfo> getFileInfos(String str) {
        return this.mFileManager.getFileInfos(str);
    }

    private double[] getLayoutRect(INativeViewDelegate iNativeViewDelegate) {
        if (!isNativeAlive()) {
            return new double[]{0.0d, 0.0d, 0.0d, 0.0d};
        }
        Rect layoutRect = iNativeViewDelegate.getLayoutRect();
        return new double[]{layoutRect.left, layoutRect.top, layoutRect.width(), layoutRect.height()};
    }

    private MutatorsStack getMutatorsStack() {
        if (!isNativeAlive()) {
            return null;
        }
        return new MutatorsStack();
    }

    private View getTDFView() {
        return this.hostViewDelegate.getTDFView();
    }

    private void insertHostView(INativeViewDelegate iNativeViewDelegate, View view, int i3) {
        if (!isNativeAlive()) {
            return;
        }
        iNativeViewDelegate.insertView(view, i3);
    }

    private Bitmap makeSnapshot(EmbeddedViewController embeddedViewController) {
        if (!isNativeAlive()) {
            return null;
        }
        return embeddedViewController.makeSnapshot();
    }

    public static native void nativeOnDrive(long j3);

    private native void notifyLowMemoryWarning(long j3);

    private native void onAppDestroy(long j3);

    private native void onAppInactive(long j3);

    private native void onAppPause(long j3);

    private native void onAppResume(long j3);

    private EmbeddedViewController onCreateEmbeddedViewController(String str, int i3, HashMap<String, String> hashMap) {
        if (this.hostViewDelegate != null && isNativeAlive()) {
            return this.hostViewDelegate.onCreateEmbeddedViewController(str, i3, hashMap);
        }
        return null;
    }

    private View onCreateOverlaySurfaceView(long j3) {
        if (this.hostViewDelegate != null && isNativeAlive()) {
            return this.hostViewDelegate.onCreateOverlaySurfaceView(j3);
        }
        return null;
    }

    private void onDispose(INativeViewDelegate iNativeViewDelegate) {
        if (!isNativeAlive()) {
            return;
        }
        iNativeViewDelegate.onDispose();
    }

    private void onEndFrame() {
        if (!isNativeAlive()) {
            return;
        }
        this.hostViewDelegate.onEndFrame();
    }

    private native void onOverlaySurfaceCreated(long j3, long j16, Surface surface);

    private native void onOverlaySurfaceDestroyed(long j3, long j16);

    private native void onOverlaySurfaceSizeChanged(long j3, long j16, int i3, int i16);

    private native void onSetOverlaySurfaceView(long j3, long j16, View view);

    private void onShellCreated(long j3, long j16) {
        TDFEngineEvent tDFEngineEvent = this.mEngineEvent;
        if (tDFEngineEvent != null) {
            tDFEngineEvent.onShellCreated(j3, j16);
        }
    }

    private void onShellStarted(long j3) {
        TDFEngineEvent tDFEngineEvent = this.mEngineEvent;
        if (tDFEngineEvent != null) {
            tDFEngineEvent.onShellStarted(j3);
        }
    }

    private native void onSurfaceCreated(long j3, Surface surface);

    private native void onSurfaceDestroyed(long j3);

    private native void onSurfaceSizeChanged(long j3, int i3, int i16);

    private native void onUpdateGestureInfo(long j3, long j16, boolean z16, int i3, int i16, int i17, int i18, int i19);

    private void onWillShellDestroy() {
        TDFEngineEvent tDFEngineEvent = this.mEngineEvent;
        if (tDFEngineEvent != null) {
            tDFEngineEvent.onWillShellDestroy();
        }
    }

    private native void pauseEngine(long j3);

    private void pushClipRRect(MutatorsStack mutatorsStack, float f16, float f17, float f18, float f19, float[] fArr) {
        if (!isNativeAlive() && mutatorsStack != null) {
            return;
        }
        mutatorsStack.pushClipRRect(f16, f17, f18, f19, fArr);
    }

    private void pushClipRect(MutatorsStack mutatorsStack, float f16, float f17, float f18, float f19) {
        if (!isNativeAlive() && mutatorsStack != null) {
            return;
        }
        mutatorsStack.pushClipRect(f16, f17, f18, f19);
    }

    private void pushTransform(MutatorsStack mutatorsStack, float[] fArr) {
        if (!isNativeAlive() && mutatorsStack != null) {
            return;
        }
        mutatorsStack.pushTransform(fArr);
    }

    private void removeHostView(INativeViewDelegate iNativeViewDelegate, View view) {
        if (!isNativeAlive()) {
            return;
        }
        iNativeViewDelegate.deleteView(view);
    }

    private native void resumeEngine(long j3);

    private void revertImageView() {
        if (!isNativeAlive()) {
            return;
        }
        this.hostViewDelegate.onRevertImageView();
    }

    public static native void setSystemDefaultFontPaths(long j3, String[] strArr, int[] iArr);

    private native void startEngine(long j3);

    private void startPipelineDriver(long j3) {
        IPipelineDriver iPipelineDriver = this.mPipelineDriver;
        if (iPipelineDriver != null) {
            iPipelineDriver.start(j3);
        }
    }

    private void stopPipelineDriver() {
        IPipelineDriver iPipelineDriver = this.mPipelineDriver;
        if (iPipelineDriver != null) {
            iPipelineDriver.stop();
        }
    }

    private void updateEmbeddedMutatorsStack(EmbeddedViewController embeddedViewController, MutatorsStack mutatorsStack) {
        if (!isNativeAlive()) {
            return;
        }
        embeddedViewController.updateEmbeddedViewClipRect(mutatorsStack);
    }

    private void updateEmbeddedViewProps(EmbeddedViewController embeddedViewController, HashMap<String, String> hashMap) {
        if (!isNativeAlive()) {
            return;
        }
        embeddedViewController.updateEmbeddedViewProps(hashMap);
    }

    private void updateLayoutParams(INativeViewDelegate iNativeViewDelegate, double d16, double d17, double d18, double d19) {
        if (!isNativeAlive()) {
            return;
        }
        iNativeViewDelegate.updateLayoutParams((int) d16, (int) d17, (int) d18, (int) d19);
    }

    public ClipboardChannel getClipboardChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ClipboardChannel) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.clipboardChannel;
    }

    public FilePickerChannel getFilePickerChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (FilePickerChannel) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mFilePickerChannel;
    }

    public KeyboardChannel getKeyboardChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (KeyboardChannel) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.keyboardChannel;
    }

    public TDFPlatformEventHandler getPlatformEventHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TDFPlatformEventHandler) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.eventHandler;
    }

    public TDFTextInputClientManager getTextInputClientManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TDFTextInputClientManager) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.textInputClientManager;
    }

    public long getnativeEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Long) iPatchRedirector.redirect((short) 32, (Object) this)).longValue();
        }
        return this.mNativeEngine;
    }

    public boolean isNativeAlive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if (this.mNativeEngine != -1) {
            return true;
        }
        return false;
    }

    public void notifyLowMemoryWarning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else if (isNativeAlive()) {
            notifyLowMemoryWarning(this.mNativeEngine);
        }
    }

    public void onAppDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else if (isNativeAlive()) {
            onWillShellDestroy();
            onAppDestroy(this.mNativeEngine);
            this.mNativeEngine = -1L;
        }
    }

    public void onAppInactive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else if (isNativeAlive()) {
            onAppInactive(this.mNativeEngine);
        }
    }

    public void onAppPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else if (isNativeAlive()) {
            onAppPause(this.mNativeEngine);
        }
    }

    public void onAppResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else if (isNativeAlive()) {
            onAppResume(this.mNativeEngine);
        }
    }

    public void onAttachToNative(boolean z16, TDFEngineConfig tDFEngineConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), tDFEngineConfig);
        } else {
            this.mNativeEngine = attachToNative(this, tDFEngineConfig, z16);
        }
    }

    public void onOverlaySurfaceChanged(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (isNativeAlive()) {
            onOverlaySurfaceSizeChanged(this.mNativeEngine, j3, i3, i16);
        }
    }

    public void onOverlaySurfaceCreated(long j3, Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), surface);
        } else if (isNativeAlive()) {
            onOverlaySurfaceCreated(this.mNativeEngine, j3, surface);
        }
    }

    public void onOverlaySurfaceDestroyed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, j3);
        } else if (isNativeAlive()) {
            onOverlaySurfaceDestroyed(this.mNativeEngine, j3);
        }
    }

    public void onSurfaceCreated(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) surface);
        } else if (isNativeAlive()) {
            onSurfaceCreated(this.mNativeEngine, surface);
        }
    }

    public void onSurfaceDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else if (isNativeAlive()) {
            onSurfaceDestroyed(this.mNativeEngine);
        }
    }

    public void onSurfaceSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (isNativeAlive()) {
            onSurfaceSizeChanged(this.mNativeEngine, i3, i16);
        }
    }

    public void pauseEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else if (isNativeAlive()) {
            pauseEngine(this.mNativeEngine);
        }
    }

    public void resumeEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else if (isNativeAlive()) {
            resumeEngine(this.mNativeEngine);
        }
    }

    public void setChannelRegistry(ChannelRegistry channelRegistry) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) channelRegistry);
        } else {
            this.mChannelRegistry = channelRegistry;
        }
    }

    public void setClipboardChannel(ClipboardChannel clipboardChannel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) clipboardChannel);
        } else {
            this.clipboardChannel = clipboardChannel;
        }
    }

    public TDFJNI setEngineEvent(TDFEngineEvent tDFEngineEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TDFJNI) iPatchRedirector.redirect((short) 3, (Object) this, (Object) tDFEngineEvent);
        }
        this.mEngineEvent = tDFEngineEvent;
        return this;
    }

    public void setFilePickerChannel(FilePickerChannel filePickerChannel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) filePickerChannel);
        } else {
            this.mFilePickerChannel = filePickerChannel;
        }
    }

    public TDFJNI setHostViewDelegate(HostViewEventDelegate hostViewEventDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TDFJNI) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hostViewEventDelegate);
        }
        this.hostViewDelegate = hostViewEventDelegate;
        return this;
    }

    public void setKeyboardChannel(KeyboardChannel keyboardChannel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) keyboardChannel);
        } else {
            this.keyboardChannel = keyboardChannel;
        }
    }

    public TDFJNI setPipelineDriver(IPipelineDriver iPipelineDriver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TDFJNI) iPatchRedirector.redirect((short) 5, (Object) this, (Object) iPipelineDriver);
        }
        this.mPipelineDriver = iPipelineDriver;
        return this;
    }

    public void setPlatformEventHandler(TDFPlatformEventHandler tDFPlatformEventHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) tDFPlatformEventHandler);
        } else {
            this.eventHandler = tDFPlatformEventHandler;
        }
    }

    public void setSystemDefaultFontPaths() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            FontUtils.setSystemDefaultFontPaths(this.mNativeEngine);
        }
    }

    public void setTextInputClientManager(TDFTextInputClientManager tDFTextInputClientManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) tDFTextInputClientManager);
        } else {
            this.textInputClientManager = tDFTextInputClientManager;
        }
    }

    public void startEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else if (isNativeAlive()) {
            startEngine(this.mNativeEngine);
        }
    }

    public void updateGestureInfo(long j3, boolean z16, int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
        } else if (isNativeAlive()) {
            onUpdateGestureInfo(this.mNativeEngine, j3, z16, i3, i16, i17, i18, i19);
        }
    }
}
