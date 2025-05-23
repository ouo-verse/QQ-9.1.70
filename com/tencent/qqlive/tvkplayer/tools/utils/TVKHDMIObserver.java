package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Intent;
import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHDMIObserver {
    private final CopyOnWriteArraySet<IHdmiEventListener> mHdmiEventListeners = new CopyOnWriteArraySet<>();
    private HDMIPlugState mHDMIPlugState = HDMIPlugState.HDMI_PLUG_STATUS_UNKNOWN;
    private Handler mDispatchHandler = null;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    enum HDMIPlugState {
        HDMI_PLUG_STATUS_UNKNOWN,
        HDMI_PLUG_STATUS_UNPLUGGED,
        HDMI_PLUG_STATUS_PLUGGED
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IHdmiEventListener {
        void onHdmiPlugEvent(@NonNull TVKHDMIObserver tVKHDMIObserver, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class TVKHDMIObserverHolder {
        private static final TVKHDMIObserver sInstance = new TVKHDMIObserver();

        TVKHDMIObserverHolder() {
        }
    }

    public static TVKHDMIObserver getInstance() {
        return TVKHDMIObserverHolder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateHdmiStatus$0(boolean z16) {
        Iterator it = new CopyOnWriteArraySet(this.mHdmiEventListeners).iterator();
        while (it.hasNext()) {
            ((IHdmiEventListener) it.next()).onHdmiPlugEvent(this, z16);
        }
    }

    public void addHdmiEventListener(@NonNull IHdmiEventListener iHdmiEventListener) {
        this.mHdmiEventListeners.add(iHdmiEventListener);
    }

    public boolean isHDMIPlugged() {
        if (this.mHDMIPlugState == HDMIPlugState.HDMI_PLUG_STATUS_PLUGGED) {
            return true;
        }
        return false;
    }

    public void removeHdmiEventListener(@NonNull IHdmiEventListener iHdmiEventListener) {
        this.mHdmiEventListeners.remove(iHdmiEventListener);
    }

    public void updateHdmiStatus(@NonNull Intent intent) {
        final boolean z16 = false;
        if (intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 1) {
            z16 = true;
        }
        HDMIPlugState hDMIPlugState = this.mHDMIPlugState;
        HDMIPlugState hDMIPlugState2 = HDMIPlugState.HDMI_PLUG_STATUS_PLUGGED;
        if (hDMIPlugState != hDMIPlugState2 || !z16) {
            HDMIPlugState hDMIPlugState3 = HDMIPlugState.HDMI_PLUG_STATUS_UNPLUGGED;
            if (hDMIPlugState == hDMIPlugState3 && !z16) {
                return;
            }
            if (!z16) {
                hDMIPlugState2 = hDMIPlugState3;
            }
            this.mHDMIPlugState = hDMIPlugState2;
            if (this.mDispatchHandler == null) {
                synchronized (this) {
                    if (this.mDispatchHandler == null) {
                        this.mDispatchHandler = new Handler(TVKThreadPool.getInstance().obtainSharedHandlerThread().getLooper());
                    }
                }
            }
            this.mDispatchHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    TVKHDMIObserver.this.lambda$updateHdmiStatus$0(z16);
                }
            });
        }
    }
}
