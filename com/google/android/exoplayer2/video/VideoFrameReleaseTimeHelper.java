package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.Choreographer;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Util;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class VideoFrameReleaseTimeHelper {
    private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500;
    private static final long MAX_ALLOWED_DRIFT_NS = 20000000;
    private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    private static final long VSYNC_OFFSET_PERCENTAGE = 80;
    private long adjustedLastFrameTimeNs;
    private final DefaultDisplayListener displayListener;
    private long frameCount;
    private boolean haveSync;
    private long lastFramePresentationTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long syncFramePresentationTimeNs;
    private long syncUnadjustedReleaseTimeNs;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    private final VSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        private static final int CREATE_CHOREOGRAPHER = 0;
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private static final int MSG_ADD_OBSERVER = 1;
        private static final int MSG_REMOVE_OBSERVER = 2;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs = -9223372036854775807L;

        VSyncSampler() {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ChoreographerOwner:Handler");
            this.choreographerOwnerThread = baseHandlerThread;
            baseHandlerThread.start();
            Handler handler = new Handler(baseHandlerThread.getLooper(), this);
            this.handler = handler;
            handler.sendEmptyMessage(0);
        }

        private void addObserverInternal() {
            int i3 = this.observerCount + 1;
            this.observerCount = i3;
            if (i3 == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private void removeObserverInternal() {
            int i3 = this.observerCount - 1;
            this.observerCount = i3;
            if (i3 == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = -9223372036854775807L;
            }
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            this.sampledVsyncTimeNs = j3;
            this.choreographer.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return false;
                    }
                    removeObserverInternal();
                    return true;
                }
                addObserverInternal();
                return true;
            }
            createChoreographerInstanceInternal();
            return true;
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }
    }

    public VideoFrameReleaseTimeHelper() {
        this(null);
    }

    private static long closestVsync(long j3, long j16, long j17) {
        long j18;
        long j19 = j16 + (((j3 - j16) / j17) * j17);
        if (j3 <= j19) {
            j18 = j19 - j17;
        } else {
            j19 = j17 + j19;
            j18 = j19;
        }
        if (j19 - j3 >= j3 - j18) {
            return j18;
        }
        return j19;
    }

    private boolean isDriftTooLarge(long j3, long j16) {
        if (Math.abs((j16 - this.syncUnadjustedReleaseTimeNs) - (j3 - this.syncFramePresentationTimeNs)) > MAX_ALLOWED_DRIFT_NS) {
            return true;
        }
        return false;
    }

    @TargetApi(17)
    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        if (this.windowManager.getDefaultDisplay() != null) {
            long refreshRate = (long) (1.0E9d / r0.getRefreshRate());
            this.vsyncDurationNs = refreshRate;
            this.vsyncOffsetNs = (refreshRate * 80) / 100;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long adjustReleaseTime(long j3, long j16) {
        long j17;
        long j18;
        VSyncSampler vSyncSampler;
        long j19 = 1000 * j3;
        if (this.haveSync) {
            if (j3 != this.lastFramePresentationTimeUs) {
                this.frameCount++;
                this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
            }
            long j26 = this.frameCount;
            if (j26 >= 6) {
                j18 = this.adjustedLastFrameTimeNs + ((j19 - this.syncFramePresentationTimeNs) / j26);
                if (isDriftTooLarge(j18, j16)) {
                    this.haveSync = false;
                } else {
                    j17 = (this.syncUnadjustedReleaseTimeNs + j18) - this.syncFramePresentationTimeNs;
                    if (!this.haveSync) {
                        this.syncFramePresentationTimeNs = j19;
                        this.syncUnadjustedReleaseTimeNs = j16;
                        this.frameCount = 0L;
                        this.haveSync = true;
                    }
                    this.lastFramePresentationTimeUs = j3;
                    this.pendingAdjustedFrameTimeNs = j18;
                    vSyncSampler = this.vsyncSampler;
                    if (vSyncSampler == null && this.vsyncDurationNs != -9223372036854775807L) {
                        long j27 = vSyncSampler.sampledVsyncTimeNs;
                        if (j27 == -9223372036854775807L) {
                            return j17;
                        }
                        return closestVsync(j17, j27, this.vsyncDurationNs) - this.vsyncOffsetNs;
                    }
                    return j17;
                }
            } else if (isDriftTooLarge(j19, j16)) {
                this.haveSync = false;
            }
        }
        j17 = j16;
        j18 = j19;
        if (!this.haveSync) {
        }
        this.lastFramePresentationTimeUs = j3;
        this.pendingAdjustedFrameTimeNs = j18;
        vSyncSampler = this.vsyncSampler;
        if (vSyncSampler == null) {
        }
        return j17;
    }

    public void disable() {
        if (this.windowManager != null) {
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    public void enable() {
        this.haveSync = false;
        if (this.windowManager != null) {
            this.vsyncSampler.addObserver();
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    public VideoFrameReleaseTimeHelper(@Nullable Context context) {
        WindowManager windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        this.windowManager = windowManager;
        if (windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : null;
            this.vsyncSampler = VSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = -9223372036854775807L;
        this.vsyncOffsetNs = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @TargetApi(17)
    /* loaded from: classes2.dex */
    public final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        public DefaultDisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i3) {
            if (i3 == 0) {
                VideoFrameReleaseTimeHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i3) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i3) {
        }
    }
}
