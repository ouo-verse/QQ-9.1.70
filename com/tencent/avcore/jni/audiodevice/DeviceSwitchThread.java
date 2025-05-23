package com.tencent.avcore.jni.audiodevice;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class DeviceSwitchThread extends BaseThread {
    static IPatchRedirector $redirector_ = null;
    private static final int BLUETOOTH_CONNECTION_WAIT_TIME_LEN_MS = 300;
    private static final int BLUETOOTH_SCO_CONNECTION_WAIT_TIME_LEN_MS = 300;
    private static final int MAX_BLUETOOTH_CONNECTION_WAIT_COUNT = 30;
    private static final int MAX_BLUETOOTH_SCO_CONNECTION_RETRY_COUNT = 2;
    private static final int MAX_BLUETOOTH_SCO_CONNECTION_WAIT_COUNT = 10;
    private static final String TAG;
    protected boolean forceSwitchEarPhone;
    protected boolean forceSwitchSpeakerPhone;
    protected volatile boolean isRunning;
    protected AudioManager mAudioManager;
    protected BluetoothHelper mBluetoothHelper;
    protected IDeviceConnectStatusListener mConnectStatusListener;
    protected CountDownLatch mCountDownLatch;
    protected DeviceConfigManager mDeviceConfigManager;
    protected final String mDeviceName;
    private boolean mInCommunicationMode;
    private boolean mIsBluetoothScoOnBeforeStart;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class BluetoothHeadsetSwitchThread extends DeviceSwitchThread {
        static IPatchRedirector $redirector_;

        BluetoothHeadsetSwitchThread(Context context, String str) {
            super(context, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            }
        }

        private void onBluetoothConnectionFailed() {
            this.mDeviceConfigManager.setVisible(this.mDeviceName, false);
            this.mDeviceConfigManager.setBlueToothDevName("unknown");
            this.mDeviceConfigManager.resetConnectingDevice();
            this.mBluetoothHelper.setBluetoothState(1);
            IDeviceConnectStatusListener iDeviceConnectStatusListener = this.mConnectStatusListener;
            if (iDeviceConnectStatusListener != null) {
                iDeviceConnectStatusListener.onDeviceConnectFinish(this.mDeviceName, 7);
            }
        }

        private void waitBluetoothScoConnectionFinished() {
            int i3 = 0;
            while (this.isRunning) {
                int i16 = i3 + 1;
                if (i3 < 2) {
                    int i17 = 0;
                    while (true) {
                        if (!this.isRunning) {
                            break;
                        }
                        int i18 = i17 + 1;
                        if (i17 >= 10) {
                            break;
                        }
                        if (this.mBluetoothHelper.getBluetoothState() == 5) {
                            AVCoreLog.i(DeviceSwitchThread.TAG, "wait bluetooth sco connection successfully. waitCount: " + i18);
                            onDeviceSwitchSuccess();
                            break;
                        }
                        try {
                            LockMethodProxy.sleep(300L);
                            i17 = i18;
                        } catch (InterruptedException e16) {
                            AVCoreLog.e(DeviceSwitchThread.TAG, "wait bluetooth sco connection failed. exception: " + e16.getMessage());
                        }
                    }
                    if (this.mBluetoothHelper.getBluetoothState() != 5) {
                        AVCoreLog.i(DeviceSwitchThread.TAG, "retry bluetooth sco connection. retryCount: " + i16 + ", bluetooth state: " + this.mBluetoothHelper.getBluetoothState());
                        stopBluetoothSco();
                        try {
                            LockMethodProxy.sleep(1000L);
                            startBluetoothSco();
                            i3 = i16;
                        } catch (InterruptedException e17) {
                            AVCoreLog.e(DeviceSwitchThread.TAG, "retry bluetooth sco connection failed. exception: " + e17.getMessage());
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.DeviceSwitchThread
        public void executeRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.mBluetoothHelper == null) {
                AVCoreLog.e(DeviceSwitchThread.TAG, "executeRun exit. mBluetoothHelper is null.");
                return;
            }
            int i3 = 0;
            while (!this.mBluetoothHelper.isConnected()) {
                int i16 = i3 + 1;
                if (i3 < 30 && this.isRunning) {
                    try {
                        LockMethodProxy.sleep(300L);
                    } catch (InterruptedException e16) {
                        AVCoreLog.e(DeviceSwitchThread.TAG, "wait bluetooth connection failed. exception: " + e16.getMessage());
                    }
                    i3 = i16;
                } else {
                    i3 = i16;
                    break;
                }
            }
            AVCoreLog.i(DeviceSwitchThread.TAG, "wait bluetooth connection finished. waitCount: " + i3 + ", bluetooth state: " + this.mBluetoothHelper.getBluetoothState());
            if (this.mBluetoothHelper.getBluetoothState() != 1) {
                if (this.isRunning) {
                    startBluetoothSco();
                }
                waitBluetoothScoConnectionFinished();
                if (this.mBluetoothHelper.getBluetoothState() != 5) {
                    AVCoreLog.e(DeviceSwitchThread.TAG, "bluetooth sco connection failed.");
                    onBluetoothConnectionFailed();
                    return;
                }
                return;
            }
            AVCoreLog.e(DeviceSwitchThread.TAG, "bluetooth connection failed.");
            onBluetoothConnectionFailed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class EarphoneSwitchThread extends DeviceSwitchThread {
        static IPatchRedirector $redirector_;

        EarphoneSwitchThread(Context context, String str) {
            super(context, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.DeviceSwitchThread
        public void executeRun() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            setSpeakerPhone(false);
            onDeviceSwitchSuccess();
            int i3 = 0;
            while (this.isRunning) {
                if (TraeUtils.getSysSpeakerphoneOn(this.mAudioManager)) {
                    IDeviceConnectStatusListener iDeviceConnectStatusListener = this.mConnectStatusListener;
                    if (iDeviceConnectStatusListener != null) {
                        iDeviceConnectStatusListener.onDeviceExternalSwitch(this.mDeviceName);
                    }
                    if (this.forceSwitchEarPhone) {
                        setSpeakerPhone(false);
                    }
                }
                if (i3 < 5) {
                    j3 = 1000;
                } else {
                    j3 = 4000;
                }
                try {
                    LockMethodProxy.sleep(j3);
                } catch (InterruptedException e16) {
                    if (AVCoreLog.isColorLevel()) {
                        AVCoreLog.d(DeviceSwitchThread.TAG, "EarphoneSwitchThread InterruptedException[" + e16.getMessage() + "]");
                    }
                }
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IDeviceConnectStatusListener {
        void onDeviceConnectFinish(String str, int i3);

        void onDeviceConnectStart(String str);

        void onDeviceExternalSwitch(String str);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class SpeakerSwitchThread extends DeviceSwitchThread {
        static IPatchRedirector $redirector_;

        SpeakerSwitchThread(Context context, String str) {
            super(context, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.DeviceSwitchThread
        public void executeRun() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            setSpeakerPhone(true);
            onDeviceSwitchSuccess();
            int i3 = 0;
            while (this.isRunning) {
                if (!TraeUtils.getSysSpeakerphoneOn(this.mAudioManager)) {
                    IDeviceConnectStatusListener iDeviceConnectStatusListener = this.mConnectStatusListener;
                    if (iDeviceConnectStatusListener != null) {
                        iDeviceConnectStatusListener.onDeviceExternalSwitch(this.mDeviceName);
                    }
                    if (!this.forceSwitchSpeakerPhone && i3 > 4) {
                        AVCoreLog.e(DeviceSwitchThread.TAG, "SpeakerSwitchThread, \u4e0d\u9700\u8981\u6253\u5f00\u626c\u58f0\u5668, forceSwitchSpeakerPhone[" + this.forceSwitchSpeakerPhone + "]");
                        return;
                    }
                    setSpeakerPhone(true);
                }
                if (i3 < 5) {
                    j3 = 1000;
                } else {
                    j3 = 4000;
                }
                try {
                    LockMethodProxy.sleep(j3);
                } catch (InterruptedException e16) {
                    if (AVCoreLog.isColorLevel()) {
                        AVCoreLog.d(DeviceSwitchThread.TAG, "SpeakerSwitchThread InterruptedException[" + e16.getMessage() + "]");
                    }
                }
                i3++;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class WiredHeadsetSwitchThread extends DeviceSwitchThread {
        static IPatchRedirector $redirector_;

        WiredHeadsetSwitchThread(Context context, String str) {
            super(context, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.DeviceSwitchThread
        public void executeRun() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            setSpeakerPhone(false);
            setWiredHeadset(true);
            onDeviceSwitchSuccess();
            int i3 = 0;
            while (this.isRunning) {
                if (TraeUtils.getSysSpeakerphoneOn(this.mAudioManager)) {
                    setSpeakerPhone(false);
                }
                if (i3 < 5) {
                    j3 = 1000;
                } else {
                    j3 = 4000;
                }
                try {
                    LockMethodProxy.sleep(j3);
                } catch (InterruptedException e16) {
                    if (AVCoreLog.isColorLevel()) {
                        AVCoreLog.d(DeviceSwitchThread.TAG, "WiredHeadsetSwitchThread InterruptedException[" + e16.getMessage() + "]");
                    }
                }
                i3++;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13819);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            TAG = DeviceSwitchThread.class.getSimpleName();
        }
    }

    public DeviceSwitchThread(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.mDeviceConfigManager = DeviceConfigManager.getInstance();
        this.mInCommunicationMode = false;
        this.mIsBluetoothScoOnBeforeStart = false;
        this.isRunning = true;
        this.mCountDownLatch = new CountDownLatch(1);
        this.forceSwitchEarPhone = true;
        this.forceSwitchSpeakerPhone = true;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mDeviceName = str;
    }

    public static DeviceSwitchThread createDeviceSwitchThread(Context context, String str) {
        AVCoreLog.i(TAG, "createDeviceSwitchThread. deviceName: " + str);
        if (TraeConstants.DEVICE_EARPHONE.equals(str)) {
            return new EarphoneSwitchThread(context, str);
        }
        if (TraeConstants.DEVICE_SPEAKERPHONE.equals(str)) {
            return new SpeakerSwitchThread(context, str);
        }
        if (TraeConstants.DEVICE_WIRED_HEADSET.equals(str)) {
            return new WiredHeadsetSwitchThread(context, str);
        }
        if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(str)) {
            return new BluetoothHeadsetSwitchThread(context, str);
        }
        return null;
    }

    private boolean isSpecialDeviceForBluetoothSco() {
        return "OPPO".equalsIgnoreCase(Build.MANUFACTURER);
    }

    protected abstract void executeRun();

    protected void onDeviceSwitchSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        AVCoreLog.i(TAG, "onDeviceSwitchSuccess. mDeviceName: " + this.mDeviceName);
        this.mDeviceConfigManager.setVisible(this.mDeviceName, true);
        this.mDeviceConfigManager.setConnectedDevice(this.mDeviceName);
        if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(this.mDeviceName)) {
            this.mBluetoothHelper.setBluetoothConnectionDevice();
        }
        IDeviceConnectStatusListener iDeviceConnectStatusListener = this.mConnectStatusListener;
        if (iDeviceConnectStatusListener != null) {
            iDeviceConnectStatusListener.onDeviceConnectFinish(this.mDeviceName, 0);
        }
    }

    public void quit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AVCoreLog.i(TAG, "quit thread. mDeviceName: " + this.mDeviceName);
        this.isRunning = false;
        interrupt();
        if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(this.mDeviceName)) {
            stopBluetoothSco();
        }
        try {
            this.mCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            AVCoreLog.e(TAG, "wait thread quit failed. exception: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        IDeviceConnectStatusListener iDeviceConnectStatusListener = this.mConnectStatusListener;
        if (iDeviceConnectStatusListener != null) {
            iDeviceConnectStatusListener.onDeviceConnectStart(this.mDeviceName);
        }
        executeRun();
        this.mCountDownLatch.countDown();
    }

    protected void setSpeakerPhone(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        AVCoreLog.i(TAG, "setSpeakerPhone, speakerOn[" + z16 + "]");
        try {
            if (this.mAudioManager.isSpeakerphoneOn() != z16) {
                this.mAudioManager.setSpeakerphoneOn(z16);
            }
        } catch (NullPointerException unused) {
            AVCoreLog.e(TAG, "setSpeakerphoneOn npe");
        }
    }

    protected void setWiredHeadset(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        AVCoreLog.i(TAG, "setWiredHeadset, on[" + z16 + "]");
        try {
            this.mAudioManager.setWiredHeadsetOn(z16);
        } catch (NullPointerException unused) {
            AVCoreLog.e(TAG, "setWiredHeadset npe");
        }
    }

    public synchronized void start(IDeviceConnectStatusListener iDeviceConnectStatusListener, BluetoothHelper bluetoothHelper, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iDeviceConnectStatusListener, bluetoothHelper, Boolean.valueOf(z16));
            return;
        }
        AVCoreLog.i(TAG, "start thread. mDeviceName: " + this.mDeviceName + ", inCommunicationMode: " + z16);
        this.mConnectStatusListener = iDeviceConnectStatusListener;
        this.mBluetoothHelper = bluetoothHelper;
        this.mInCommunicationMode = z16;
        super.start();
    }

    protected void startBluetoothSco() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        String str = TAG;
        AVCoreLog.i(str, "startBluetoothSco. mInCommunicationMode: " + this.mInCommunicationMode + ", AudioMode:" + TraeUtils.getAudioMode(this.mAudioManager));
        try {
            if (this.mInCommunicationMode && TraeUtils.getAudioMode(this.mAudioManager) != 3) {
                TraeUtils.setAudioMode(this.mAudioManager, 3);
            }
            if (this.mAudioManager.isBluetoothScoOn()) {
                AVCoreLog.i(str, "BluetoothSco is already on");
                this.mIsBluetoothScoOnBeforeStart = true;
                this.mBluetoothHelper.setBluetoothState(5);
            } else {
                this.mIsBluetoothScoOnBeforeStart = false;
                this.mBluetoothHelper.setBluetoothState(4);
            }
            if (!this.mIsBluetoothScoOnBeforeStart || !isSpecialDeviceForBluetoothSco()) {
                this.mAudioManager.setBluetoothScoOn(true);
                this.mAudioManager.startBluetoothSco();
            }
        } catch (NullPointerException unused) {
            AVCoreLog.e(TAG, "startBluetoothSco failed. npe.");
        }
    }

    protected void stopBluetoothSco() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AVCoreLog.i(TAG, "stopBluetoothSco.");
        try {
            this.mBluetoothHelper.setBluetoothState(3);
            if (!this.mIsBluetoothScoOnBeforeStart || !isSpecialDeviceForBluetoothSco()) {
                this.mAudioManager.stopBluetoothSco();
                this.mAudioManager.setBluetoothScoOn(false);
            }
        } catch (NullPointerException unused) {
            AVCoreLog.e(TAG, "stopBluetoothSco failed. npe.");
        }
    }
}
