package com.tencent.mobileqq.qqaudio.audioplayer.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
import com.tencent.mobileqq.qqaudio.audioplayer.c;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AudioDeviceServiceImpl extends BroadcastReceiver implements IAudioDeviceService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AudioDeviceServiceImpl";
    private List<IAudioDeviceService.a> audioDeviceListenerList;
    private boolean isA2DpBluetoothHeadsetType;
    private boolean isBlueToothHeadsetEnable;
    private boolean isNearEar;
    private boolean isRingerModeNotNormal;
    private boolean isWiredHeadsetEnable;
    private WeakReference<AppRuntime> mApp;
    private AudioSenorManager senorManager;

    public AudioDeviceServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isNearEar = false;
        this.isWiredHeadsetEnable = false;
        this.isRingerModeNotNormal = false;
        this.isBlueToothHeadsetEnable = false;
        this.isA2DpBluetoothHeadsetType = false;
        this.audioDeviceListenerList = new CopyOnWriteArrayList();
    }

    private void bindApp(AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "$bindApp, app = " + appRuntime);
        }
        WeakReference<AppRuntime> weakReference = this.mApp;
        if (weakReference != null && weakReference.get() == appRuntime) {
            return;
        }
        WeakReference<AppRuntime> weakReference2 = this.mApp;
        if (weakReference2 != null && weakReference2.get() != null) {
            unBindApp();
        }
        this.mApp = new WeakReference<>(appRuntime);
    }

    private void notifyAllDeviceStatusChanged(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "notifyAllDeviceStatusChanged: changedType=" + i3 + " changedValue=" + z16);
        }
        for (IAudioDeviceService.a aVar : this.audioDeviceListenerList) {
            if (aVar != null && (aVar.e() & i3) == i3) {
                QLog.d(TAG, 2, "notifyAllDeviceStatusChanged: audioDeviceListener=" + aVar.getClass());
                aVar.g(i3, z16);
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        BaseApplication app = appRuntime.getApp();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.RINGER_MODE_CHANGED");
        if (BaseApplication.getContext().checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0) {
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        }
        app.registerReceiver(this, intentFilter);
        AudioSenorManager audioSenorManager = new AudioSenorManager(appRuntime);
        this.senorManager = audioSenorManager;
        audioSenorManager.q(this);
        bindApp(appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.audioDeviceListenerList.clear();
        this.senorManager.o();
        this.senorManager = null;
        unBindApp();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService, com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager.b
    public void onNearToEarStatusChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onNearToEarStatusChanged: senorIsNear=" + z16 + " | isRingerMode_not_normal =" + this.isRingerModeNotNormal);
        }
        if (z16 != this.isNearEar) {
            this.isNearEar = z16;
            notifyAllDeviceStatusChanged(2, z16);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i3;
        boolean z16;
        AppRuntime appRuntime;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        boolean z18 = true;
        if (action != null && action.equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.hasExtra("state")) {
                if (intent.getIntExtra("state", 0) == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (this.isWiredHeadsetEnable != z17) {
                    this.isWiredHeadsetEnable = z17;
                    notifyAllDeviceStatusChanged(4, z17);
                }
            }
        } else if ("android.media.RINGER_MODE_CHANGED".equals(action)) {
            try {
                i3 = ((AudioManager) context.getSystemService("audio")).getRingerMode();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive getRingerMode error:" + th5.getMessage());
                }
                i3 = 2;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "currentRingerMode:" + i3);
            }
            if (i3 != 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 != this.isRingerModeNotNormal) {
                this.isRingerModeNotNormal = z16;
                if (z16) {
                    WeakReference<AppRuntime> weakReference = this.mApp;
                    if (weakReference != null && (appRuntime = weakReference.get()) != null) {
                        c.i(false, appRuntime);
                    }
                    notifyAllDeviceStatusChanged(1, false);
                }
            }
        }
        if (BaseApplication.getContext().checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0) {
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                if (intExtra == 2 || intExtra == 0) {
                    if (intExtra != 2) {
                        z18 = false;
                    }
                    if (z18 != this.isBlueToothHeadsetEnable) {
                        this.isBlueToothHeadsetEnable = z18;
                        notifyAllDeviceStatusChanged(8, z18);
                    }
                    if (intExtra == 0) {
                        boolean c16 = c.c(context);
                        if (QLog.isColorLevel()) {
                            QLog.d("AudioPlayer", 2, "BluetoothHeadset.STATE_DISCONNECTED: bluetoothStatus=" + c16);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                if (intExtra2 == 2 || intExtra2 == 0) {
                    if (intExtra2 != 2) {
                        z18 = false;
                    }
                    if (z18 != this.isA2DpBluetoothHeadsetType) {
                        this.isA2DpBluetoothHeadsetType = z18;
                        notifyAllDeviceStatusChanged(16, z18);
                    }
                    if (intExtra2 == 0) {
                        boolean c17 = c.c(context);
                        if (QLog.isColorLevel()) {
                            QLog.d("AudioPlayer", 2, "BluetoothHeadset.STATE_DISCONNECTED: bluetoothStatus=" + c17);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService
    public void registerAudioDeviceListener(IAudioDeviceService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            QLog.e(TAG, 2, "registerAudioDeviceListener listener is null");
        } else if (this.audioDeviceListenerList.contains(aVar)) {
            QLog.e(TAG, 2, "registerAudioDeviceListener listener is contains");
        } else {
            this.audioDeviceListenerList.add(aVar);
        }
    }

    public void unBindApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            WeakReference<AppRuntime> weakReference = this.mApp;
            if (weakReference != null && weakReference.get() != null) {
                this.mApp.get().getApp().unregisterReceiver(this);
            }
            this.mApp = null;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "$unBindApp");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService
    public void unRegisterAudioDeviceListener(IAudioDeviceService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            QLog.e(TAG, 2, "unRegisterAudioDeviceListener listener is null");
        } else if (this.audioDeviceListenerList.contains(aVar)) {
            this.audioDeviceListenerList.remove(aVar);
        } else {
            QLog.e(TAG, 2, "unRegisterAudioDeviceListener listener is not contains");
        }
    }
}
