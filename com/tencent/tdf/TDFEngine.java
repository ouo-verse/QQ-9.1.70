package com.tencent.tdf;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.TDFEngineConfig;
import com.tencent.tdf.channel.ChannelRegistry;
import com.tencent.tdf.clipboard.ClipboardChannel;
import com.tencent.tdf.embed.EmbeddedViewController;
import com.tencent.tdf.embed.EmbeddedViewFactoryRegister;
import com.tencent.tdf.event.TDFPlatformEventHandler;
import com.tencent.tdf.filepicker.FilePickerChannel;
import com.tencent.tdf.filepicker.FilePickerDelegate;
import com.tencent.tdf.keyboard.KeyboardChannel;
import com.tencent.tdf.text.TDFTextInputClientManager;
import com.tencent.tdf.view.HostViewEventDelegate;
import com.tencent.tdf.view.TDFOutputView;
import com.tencent.tdf.view.TDFViewportMetrics;
import com.tencent.tdf.view.overlay.TDFOverlayViewFactory;
import com.tencent.tdf.vsync.FixedIntervalPipelineDriver;
import com.tencent.tdf.vsync.IPipelineDriver;
import com.tencent.tdf.vsync.VsyncPipelineDriver;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFEngine implements TDFEngineEvent, HostViewEventDelegate {
    static IPatchRedirector $redirector_;
    private ClipboardChannel clipboardChannel;
    private TDFPlatformEventHandler eventHandler;
    private FilePickerChannel filePickerChannel;
    private KeyboardChannel keyboardChannel;
    private boolean mAppDestroyed;
    private ChannelRegistry mChannelRegistry;
    private TDFEngineConfig mConfiguration;
    private Context mContext;
    private EmbeddedViewFactoryRegister mEmbeddedViewFactoryRegister;
    private boolean mIsEngineStart;
    private IPipelineDriver mPipelineDriver;
    protected long mPipelineId;
    protected long mShell;
    private TDFOutputView mTDFOutputView;
    private TDFViewportMetrics pendingViewportMetrics;
    private TDFJNI tdfJNI;
    private TDFTextInputClientManager textInputClientManager;

    public TDFEngine(@NonNull Context context, TDFEngineConfig tDFEngineConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) tDFEngineConfig);
            return;
        }
        this.mIsEngineStart = false;
        this.mAppDestroyed = false;
        this.mShell = 0L;
        this.mPipelineId = 0L;
        this.pendingViewportMetrics = null;
        this.mConfiguration = tDFEngineConfig;
        this.mContext = context;
        if (tDFEngineConfig.getRasterTarget() == TDFEngineConfig.RasterTarget.TextureToScreen) {
            this.mPipelineDriver = new FixedIntervalPipelineDriver(tDFEngineConfig.getPipelineDriverInterval());
        } else {
            this.mPipelineDriver = new VsyncPipelineDriver();
        }
        this.tdfJNI = new TDFJNI(context).setEngineEvent(this).setHostViewDelegate(this).setPipelineDriver(this.mPipelineDriver);
        this.mTDFOutputView = createTDFView(context);
        this.clipboardChannel = new ClipboardChannel(context);
        this.mChannelRegistry = new ChannelRegistry();
        this.mEmbeddedViewFactoryRegister = new EmbeddedViewFactoryRegister();
        this.eventHandler = new TDFPlatformEventHandler();
        this.textInputClientManager = new TDFTextInputClientManager(this.mTDFOutputView);
        this.keyboardChannel = new KeyboardChannel(this.mTDFOutputView, this);
        this.tdfJNI.setChannelRegistry(this.mChannelRegistry);
        this.tdfJNI.setClipboardChannel(this.clipboardChannel);
        this.tdfJNI.setPlatformEventHandler(this.eventHandler);
        this.tdfJNI.setTextInputClientManager(this.textInputClientManager);
        this.tdfJNI.setKeyboardChannel(this.keyboardChannel);
        this.tdfJNI.onAttachToNative(false, tDFEngineConfig);
        this.tdfJNI.setSystemDefaultFontPaths();
    }

    public InputConnection createInputConnection(EditorInfo editorInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (InputConnection) iPatchRedirector.redirect((short) 16, (Object) this, (Object) editorInfo);
        }
        KeyboardChannel keyboardChannel = this.keyboardChannel;
        if (keyboardChannel == null) {
            return null;
        }
        return keyboardChannel.createInputConnection(this.mTDFOutputView, editorInfo);
    }

    protected TDFOutputView createTDFView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TDFOutputView) iPatchRedirector.redirect((short) 19, (Object) this, (Object) context);
        }
        return new TDFOutputView(context, this.mConfiguration.getViewMode(), this);
    }

    public ChannelRegistry getChannelRegistry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ChannelRegistry) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mChannelRegistry;
    }

    public EmbeddedViewFactoryRegister getEmbeddedViewFactoryRegister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (EmbeddedViewFactoryRegister) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mEmbeddedViewFactoryRegister;
    }

    public TDFJNI getJNI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TDFJNI) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.tdfJNI;
    }

    public long getPipelineId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.mPipelineId;
    }

    public TDFPlatformEventHandler getPlatformEventHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TDFPlatformEventHandler) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.eventHandler;
    }

    public long getShell() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.mShell;
    }

    public void handleKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) keyEvent);
            return;
        }
        KeyboardChannel keyboardChannel = this.keyboardChannel;
        if (keyboardChannel == null) {
            return;
        }
        if (keyboardChannel.getLastInputConnection() == null) {
            this.eventHandler.handleKeyEvent(this.mPipelineId, keyEvent);
        }
        if (this.keyboardChannel.getLastInputConnection() != null && this.keyboardChannel.getInputMethodManager().isAcceptingText()) {
            this.keyboardChannel.getLastInputConnection().sendKeyEvent(keyEvent);
        }
    }

    public void handleMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent);
        } else {
            this.eventHandler.handleMotionEvent(this.mPipelineId, motionEvent);
        }
    }

    @Override // com.tencent.tdf.view.HostViewEventDelegate
    public void onConvertToImageView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            this.mTDFOutputView.convertToImageView();
        }
    }

    @Override // com.tencent.tdf.view.HostViewEventDelegate
    public EmbeddedViewController onCreateEmbeddedViewController(String str, int i3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (EmbeddedViewController) iPatchRedirector.redirect((short) 27, this, str, Integer.valueOf(i3), map);
        }
        return new EmbeddedViewController(this.mContext, i3, this.mEmbeddedViewFactoryRegister.getEmbeddedViewFactory(str).create(this.mContext, i3, map), map);
    }

    @Override // com.tencent.tdf.view.HostViewEventDelegate
    public View onCreateOverlaySurfaceView(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this, j3);
        }
        return TDFOverlayViewFactory.getInstance().createOverlayView(this.mConfiguration.getOverlayViewKind(), this, j3);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mPipelineDriver.stop();
        this.tdfJNI.onAppDestroy();
        this.tdfJNI.setKeyboardChannel(null);
        this.keyboardChannel = null;
        this.mAppDestroyed = true;
    }

    @Override // com.tencent.tdf.view.HostViewEventDelegate
    public void onEndFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mTDFOutputView.onEndFrame();
        }
    }

    public void onMemoryPressure() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            if (this.mAppDestroyed) {
                return;
            }
            this.tdfJNI.notifyLowMemoryWarning();
        }
    }

    public void onOverlaySurfaceChanged(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.tdfJNI.onOverlaySurfaceChanged(j3, i3, i16);
        }
    }

    public void onOverlaySurfaceCreated(long j3, Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Long.valueOf(j3), surface);
        } else {
            this.tdfJNI.onOverlaySurfaceCreated(j3, surface);
        }
    }

    public void onOverlaySurfaceDestroyed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, j3);
        } else {
            if (this.mAppDestroyed) {
                return;
            }
            this.tdfJNI.onOverlaySurfaceDestroyed(j3);
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mPipelineDriver.stop();
            this.tdfJNI.onAppInactive();
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mPipelineDriver.resume();
            this.tdfJNI.onAppResume();
        }
    }

    @Override // com.tencent.tdf.view.HostViewEventDelegate
    public void onRevertImageView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.mTDFOutputView.revertImageView();
        }
    }

    @Override // com.tencent.tdf.TDFEngineEvent
    public void onShellCreated(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.mShell = j3;
            this.mPipelineId = j16;
        }
    }

    @Override // com.tencent.tdf.TDFEngineEvent
    public void onShellStarted(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, j3);
        }
    }

    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mPipelineDriver.stop();
            this.tdfJNI.onAppPause();
        }
    }

    public void onSurfaceCreated(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) surface);
            return;
        }
        if (!this.mIsEngineStart) {
            this.tdfJNI.startEngine();
            this.mIsEngineStart = true;
            TDFViewportMetrics tDFViewportMetrics = this.pendingViewportMetrics;
            if (tDFViewportMetrics != null) {
                this.eventHandler.handleViewportEvent(this.mPipelineId, tDFViewportMetrics);
                this.pendingViewportMetrics = null;
            }
        }
        this.tdfJNI.onSurfaceCreated(surface);
    }

    public void onSurfaceDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            if (this.mAppDestroyed) {
                return;
            }
            this.tdfJNI.onSurfaceDestroyed();
        }
    }

    public void onSurfaceSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.tdfJNI.onSurfaceSizeChanged(i3, i16);
        }
    }

    @Override // com.tencent.tdf.TDFEngineEvent
    public void onWillShellDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    public void setFilePickerDelegate(FilePickerDelegate filePickerDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) filePickerDelegate);
            return;
        }
        FilePickerChannel filePickerChannel = new FilePickerChannel(filePickerDelegate);
        this.filePickerChannel = filePickerChannel;
        this.tdfJNI.setFilePickerChannel(filePickerChannel);
    }

    public void updateViewportMetrics(TDFViewportMetrics tDFViewportMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) tDFViewportMetrics);
        } else if (!this.mIsEngineStart) {
            this.pendingViewportMetrics = tDFViewportMetrics;
        } else {
            this.eventHandler.handleViewportEvent(this.mPipelineId, tDFViewportMetrics);
        }
    }

    @Override // com.tencent.tdf.view.HostViewEventDelegate
    public TDFOutputView getTDFView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.mTDFOutputView : (TDFOutputView) iPatchRedirector.redirect((short) 18, (Object) this);
    }

    public TDFEngine(@NonNull Context context) {
        this(context, new TDFEngineConfig());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }
}
