package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHeadsetObserver {
    public static final int HEADSET_STATUS_PLUGGED = 1;
    public static final int HEADSET_STATUS_UNKNOWN = -1;
    public static final int HEADSET_STATUS_UNPLUGGED = 0;
    public static final int HEADSET_TYPE_BLUETOOTH = 1;
    public static final int HEADSET_TYPE_UNKNOWN = -1;
    public static final int HEADSET_TYPE_WIRED = 0;
    private static final TVKHeadsetObserver sInstance = new TVKHeadsetObserver();
    private final CopyOnWriteArraySet<IHeadsetEventListener> mHeadsetEventListeners = new CopyOnWriteArraySet<>();
    private int mHeadsetPlugState = -1;
    private int mHeadsetType = -1;
    private Handler mDispatchHandler = null;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface HeadsetPlugState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface HeadsetType {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IHeadsetEventListener {
        void onHeadsetPlugEvent(@NonNull TVKHeadsetObserver tVKHeadsetObserver, int i3, int i16);
    }

    public static TVKHeadsetObserver getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateHeadsetStatusAndNotifyIfNeeded$0(int i3, int i16) {
        Iterator<IHeadsetEventListener> it = this.mHeadsetEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onHeadsetPlugEvent(this, i3, i16);
        }
    }

    private void updateHeadsetStatusAndNotifyIfNeeded(final int i3, final int i16) {
        int i17 = this.mHeadsetPlugState;
        if (this.mHeadsetType == i16 && i17 == i3) {
            return;
        }
        this.mHeadsetPlugState = i3;
        this.mHeadsetType = i16;
        if (this.mDispatchHandler == null) {
            synchronized (this) {
                if (this.mDispatchHandler == null) {
                    this.mDispatchHandler = new Handler(TVKThreadPool.getInstance().obtainSharedHandlerThread().getLooper());
                }
            }
        }
        this.mDispatchHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                TVKHeadsetObserver.this.lambda$updateHeadsetStatusAndNotifyIfNeeded$0(i3, i16);
            }
        });
    }

    public void addHeadsetEventListener(@NonNull IHeadsetEventListener iHeadsetEventListener) {
        this.mHeadsetEventListeners.add(iHeadsetEventListener);
    }

    public int getHeadsetPlugState() {
        return this.mHeadsetPlugState;
    }

    public int getPluggedHeadsetType() {
        return this.mHeadsetType;
    }

    public void removeHeadsetEventListener(@NonNull IHeadsetEventListener iHeadsetEventListener) {
        this.mHeadsetEventListeners.remove(iHeadsetEventListener);
    }

    public void updateHeadsetStatusByBroadcast(@NonNull Intent intent) {
        int i3 = 1;
        int i16 = 0;
        if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
            if (intent.getIntExtra("state", 0) != 1) {
                i3 = 0;
            }
        } else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            if (intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0) == 2) {
                i16 = 1;
            }
            int i17 = i16;
            i16 = 1;
            i3 = i17;
        } else {
            return;
        }
        updateHeadsetStatusAndNotifyIfNeeded(i3, i16);
    }

    public void updateHeadsetStatusByDetection() {
        Context applicationContext;
        AudioManager audioManager;
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_headset_observing || (applicationContext = TVKCommParams.getApplicationContext()) == null || applicationContext.getApplicationContext().checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0) {
            return;
        }
        try {
            audioManager = (AudioManager) applicationContext.getSystemService("audio");
        } catch (Exception unused) {
            audioManager = null;
        }
        if (audioManager == null) {
            return;
        }
        boolean isBluetoothA2dpOn = audioManager.isBluetoothA2dpOn();
        int i3 = 1;
        if (!isBluetoothA2dpOn) {
            i3 = -1;
        }
        updateHeadsetStatusAndNotifyIfNeeded(isBluetoothA2dpOn ? 1 : 0, i3);
    }
}
