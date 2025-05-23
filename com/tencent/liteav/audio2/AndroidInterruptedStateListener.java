package com.tencent.liteav.audio2;

import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.liteav.audio2.d;
import com.tencent.liteav.audio2.e;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: P */
@JNINamespace("liteav::audio")
/* loaded from: classes7.dex */
public class AndroidInterruptedStateListener implements d.a, e.b {
    private static final int RECORDING_CONFIGS_LIMIT = 10;
    public static final String TAG = "AndroidInterruptedStateListener";
    private static d mRecordingCallback;
    private final long mNativeRecordingConfigListener;
    private volatile boolean mNeedNotify = false;
    private Object mObject = new Object();
    private e mPhoneStateManager;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class RecordingConfig {

        /* renamed from: a, reason: collision with root package name */
        int f118844a = 0;

        /* renamed from: b, reason: collision with root package name */
        boolean f118845b = false;

        public int getSessionId() {
            return this.f118844a;
        }

        public boolean isSilenced() {
            return this.f118845b;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            mRecordingCallback = new d();
        }
    }

    public AndroidInterruptedStateListener(long j3) {
        this.mNativeRecordingConfigListener = j3;
        Log.d(TAG, "new AndroidInterruptedStateListener" + hashCode(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$registerAudioRecordingCallback$0(AndroidInterruptedStateListener androidInterruptedStateListener) {
        if (androidInterruptedStateListener.mPhoneStateManager == null) {
            androidInterruptedStateListener.mPhoneStateManager = new e(androidInterruptedStateListener);
        }
        e eVar = androidInterruptedStateListener.mPhoneStateManager;
        if (e.b()) {
            try {
                TelephonyManager telephonyManager = eVar.f118854a;
                if (telephonyManager != null) {
                    LocationMonitor.listen(telephonyManager, eVar, 32);
                    return;
                } else {
                    Log.w("PhoneStateManager", "TelephonyManager is null, start listen phone state failed.", new Object[0]);
                    return;
                }
            } catch (Throwable th5) {
                Log.e("PhoneStateManager", "start listen phone state failed, " + th5.getMessage(), new Object[0]);
                return;
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            try {
                if (eVar.f118856d == null) {
                    eVar.f118856d = Class.forName("android.media.AudioManager$OnModeChangedListener");
                }
                if (eVar.f118857e == null) {
                    eVar.f118857e = Proxy.newProxyInstance(eVar.f118856d.getClassLoader(), new Class[]{eVar.f118856d}, new e.a(eVar));
                }
                AudioManager.class.getMethod("addOnModeChangedListener", Executor.class, eVar.f118856d).invoke(eVar.f118855b, g.a(eVar), eVar.f118857e);
                return;
            } catch (Throwable th6) {
                Log.e("PhoneStateManager", "add mode changed listener failed, " + th6.getMessage(), new Object[0]);
                return;
            }
        }
        if (i3 >= 26 && e.f118853c != null) {
            Log.i("PhoneStateManager", "register audio playback callback.", new Object[0]);
            e.f118853c.f118851a = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$unregisterAudioRecordingCallback$1(AndroidInterruptedStateListener androidInterruptedStateListener) {
        e eVar = androidInterruptedStateListener.mPhoneStateManager;
        if (eVar != null) {
            if (e.b()) {
                try {
                    TelephonyManager telephonyManager = eVar.f118854a;
                    if (telephonyManager != null) {
                        LocationMonitor.listen(telephonyManager, eVar, 0);
                    }
                    eVar.f118858f = 0;
                    return;
                } catch (Throwable th5) {
                    Log.e("PhoneStateManager", "stop listen phone state failed, " + th5.getMessage(), new Object[0]);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 31) {
                try {
                    Class<?> cls = eVar.f118856d;
                    if (cls != null && eVar.f118857e != null) {
                        AudioManager.class.getMethod("removeOnModeChangedListener", cls).invoke(eVar.f118855b, eVar.f118857e);
                        return;
                    }
                    return;
                } catch (Throwable th6) {
                    Log.e("PhoneStateManager", "remove mode changed listener failed, " + th6.getMessage(), new Object[0]);
                    return;
                }
            }
            e.c();
        }
    }

    private static native void nativeNotifyAudioRecordingConfigChangedFromJava(long j3, RecordingConfig[] recordingConfigArr);

    private static native void nativeNotifyInterruptedByPhoneCallFromJava(long j3);

    private static native void nativeNotifyResumedByPhoneCallFromJava(long j3);

    @Override // com.tencent.liteav.audio2.d.a
    public void OnRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
        int clientAudioSessionId;
        boolean isClientSilenced;
        if (list == null) {
            return;
        }
        int min = Math.min(list.size(), 10);
        RecordingConfig[] recordingConfigArr = new RecordingConfig[min];
        for (int i3 = 0; i3 < min; i3++) {
            recordingConfigArr[i3] = new RecordingConfig();
            AudioRecordingConfiguration audioRecordingConfiguration = list.get(i3);
            RecordingConfig recordingConfig = recordingConfigArr[i3];
            clientAudioSessionId = audioRecordingConfiguration.getClientAudioSessionId();
            recordingConfig.f118844a = clientAudioSessionId;
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 29) {
                if (Build.VERSION.SDK_INT >= 29) {
                    RecordingConfig recordingConfig2 = recordingConfigArr[i3];
                    isClientSilenced = audioRecordingConfiguration.isClientSilenced();
                    recordingConfig2.f118845b = isClientSilenced;
                }
            } else {
                recordingConfigArr[i3].f118845b = false;
            }
        }
        synchronized (this.mObject) {
            if (this.mNeedNotify) {
                nativeNotifyAudioRecordingConfigChangedFromJava(this.mNativeRecordingConfigListener, recordingConfigArr);
            }
        }
    }

    @Override // com.tencent.liteav.audio2.e.b
    public void onInterruptedByPhoneCall() {
        synchronized (this.mObject) {
            if (this.mNeedNotify) {
                nativeNotifyInterruptedByPhoneCallFromJava(this.mNativeRecordingConfigListener);
            }
        }
    }

    @Override // com.tencent.liteav.audio2.e.b
    public void onResumedByPhoneCall() {
        synchronized (this.mObject) {
            if (this.mNeedNotify) {
                nativeNotifyResumedByPhoneCallFromJava(this.mNativeRecordingConfigListener);
            }
        }
    }

    public void registerAudioRecordingCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 24) {
            return;
        }
        d dVar = mRecordingCallback;
        if (dVar != null) {
            dVar.f118852a = this;
        }
        ThreadUtils.getUiThreadHandler().post(a.a(this));
        this.mNeedNotify = true;
    }

    public void unregisterAudioRecordingCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 24 || mRecordingCallback == null) {
            return;
        }
        synchronized (this.mObject) {
            this.mNeedNotify = false;
            mRecordingCallback.f118852a = null;
            ThreadUtils.getUiThreadHandler().post(b.a(this));
        }
    }
}
