package com.tencent.avcore.jni.audiodevice;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.avcore.jni.audiodevice.BluetoothHelper;
import com.tencent.avcore.jni.audiodevice.DeviceSwitchThread;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TraeAudioManager extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    private static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
    private static final int AUDIO_MANAGER_ACTIVE_RING = 2;
    private static final int AUDIO_MANAGER_ACTIVE_VOICE_CALL = 1;
    private static final String TAG = "TraeAudioManager";
    private static volatile TraeAudioManager sInstance;
    private volatile boolean isInit;
    private boolean isServiceStart;
    String lastConfig;
    int mActiveMode;
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    private AudioManager mAudioManager;
    int mAudioScene;
    BluetoothHelper mBluetoothHelper;
    private Context mContext;
    private CustomHandler mCustomHandler;
    DeviceConfigManager mDeviceConfigManager;
    int mFocusStreamType;
    boolean mInCommunicationMode;
    int mModePolicy;
    private CopyOnWriteArrayList<Notifier> mNotifiers;
    int mPrevMode;
    String mSessionConnectedDevice;
    int mStreamType;
    private DeviceSwitchThread mSwitchThread;
    private HandlerThread mTraeAudioManagerThread;
    String voiceCallOperation;
    long voiceCallSessionID;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class BluetoothStatusListener implements BluetoothHelper.IStateChangeListener {
        static IPatchRedirector $redirector_;

        BluetoothStatusListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TraeAudioManager.this);
        }

        @Override // com.tencent.avcore.jni.audiodevice.BluetoothHelper.IStateChangeListener
        public void onBluetoothPluginStateChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TraeAudioManager.this.onDevicePluginStatusChange(TraeConstants.DEVICE_BLUETOOTH_HEADSET, z16);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }

        /* synthetic */ BluetoothStatusListener(TraeAudioManager traeAudioManager, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) traeAudioManager, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class CustomHandler extends Handler {
        static IPatchRedirector $redirector_ = null;
        public static final int MSG_AUTO_DEVICE_PLUG_IN = 32870;
        public static final int MSG_AUTO_DEVICE_PLUG_OUT = 32871;
        public static final int MSG_BEGIN = 32768;
        public static final int MSG_CONNECT_DEVICE = 32773;
        public static final int MSG_CONNECT_HIGHEST_PRIORITY_DEVICE = 32774;
        public static final int MSG_FORCE_SWITCH_DEVICE = 32779;
        public static final int MSG_GET_CONNECTED_DEVICE = 32775;
        public static final int MSG_GET_DEVICE_LIST = 32771;
        public static final int MSG_GET_STREAM_TYPE = 32772;
        public static final int MSG_SET_ACTIVE_MODE = 32780;
        public static final int MSG_START_SERVICE = 32769;
        public static final int MSG_STOP_SERVICE = 32770;
        public static final int MSG_TRY_AUTO_CONNECT_DEVICE = 32869;
        public static final int MSG_VOICE_CALL_AUDIO_PARAM_CHANGED = 32778;
        public static final int MSG_VOICE_CALL_POST_PROCESS = 32777;
        public static final int MSG_VOICE_CALL_PRE_PROCESS = 32776;

        public CustomHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TraeAudioManager.this, (Object) looper);
            }
        }

        private void handleInternalStatusChange(int i3, HashMap<String, Object> hashMap) {
            if (i3 != 32774) {
                switch (i3) {
                    case MSG_TRY_AUTO_CONNECT_DEVICE /* 32869 */:
                        break;
                    case MSG_AUTO_DEVICE_PLUG_IN /* 32870 */:
                        String str = (String) hashMap.get(TraeConstants.PARAM_DEVICE_NAME);
                        AVCoreLog.i(TraeAudioManager.TAG, "handleMessage MSG_AUTO_DEVICE_PLUG_IN, plugInDevice[" + str + "]");
                        if (TraeAudioManager.this.internalConnectDevice(str, null) != 0) {
                            TraeAudioManager traeAudioManager = TraeAudioManager.this;
                            traeAudioManager.internalConnectDevice(traeAudioManager.mDeviceConfigManager.getVisibleHighestPriorityDevice(null), null);
                            return;
                        }
                        return;
                    case MSG_AUTO_DEVICE_PLUG_OUT /* 32871 */:
                        String connectedDevice = TraeAudioManager.this.mDeviceConfigManager.getConnectedDevice();
                        String str2 = (String) hashMap.get(TraeConstants.PARAM_DEVICE_NAME);
                        AVCoreLog.i(TraeAudioManager.TAG, "handleMessage MSG_AUTO_DEVICE_PLUG_OUT, connectedDevice[" + connectedDevice + "], plugOutDevice[" + str2 + "]");
                        if (!connectedDevice.equals(str2) && !connectedDevice.equals(TraeConstants.DEVICE_NONE)) {
                            TraeAudioManager.this.notifyDeviceListUpdate();
                            return;
                        }
                        TraeAudioManager traeAudioManager2 = TraeAudioManager.this;
                        if (traeAudioManager2.internalConnectDevice(traeAudioManager2.mSessionConnectedDevice, null) != 0) {
                            TraeAudioManager traeAudioManager3 = TraeAudioManager.this;
                            traeAudioManager3.internalConnectDevice(traeAudioManager3.mDeviceConfigManager.getVisibleHighestPriorityDevice(null), null);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            String visibleHighestPriorityDevice = TraeAudioManager.this.mDeviceConfigManager.getVisibleHighestPriorityDevice(null);
            String connectedDevice2 = TraeAudioManager.this.mDeviceConfigManager.getConnectedDevice();
            String str3 = (String) hashMap.get(TraeConstants.PARAM_CONNECT_DEVICE_WHEN_START_SERVICE);
            if (str3 != null && TraeAudioManager.this.mDeviceConfigManager.getVisible(str3)) {
                visibleHighestPriorityDevice = str3;
            }
            AVCoreLog.i(TraeAudioManager.TAG, "handleMessage, msg[" + i3 + "], tryConnectDevice[" + visibleHighestPriorityDevice + "], connectedDevice[" + connectedDevice2 + "], connectDeviceWhenStartService[" + str3 + "]");
            if (!visibleHighestPriorityDevice.equals(connectedDevice2)) {
                TraeAudioManager.this.internalConnectDevice(visibleHighestPriorityDevice, null);
            } else {
                TraeAudioManager.this.notifyDeviceListUpdate();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
                return;
            }
            try {
                HashMap<String, Object> hashMap = (HashMap) message.obj;
                AVCoreLog.i(TraeAudioManager.TAG, "handleMessage. msgType: " + message.what);
                int i3 = message.what;
                if (i3 == 32769) {
                    TraeAudioManager.this.internalStartService(hashMap);
                    return;
                }
                if (i3 == 32776) {
                    TraeAudioManager.this.internalVoiceCallPreProcess(hashMap);
                    return;
                }
                if (!TraeAudioManager.this.isServiceStart) {
                    AVCoreLog.e(TraeAudioManager.TAG, "handleMessage, service off");
                    TraeAudioManager.this.sendResMessage(hashMap, 1);
                    return;
                }
                int i16 = message.what;
                switch (i16) {
                    case 32770:
                        TraeAudioManager.this.internalStopService();
                        TraeAudioManager.this.abandonAudioFocus();
                        return;
                    case 32771:
                        TraeAudioManager.this.internalSessionGetDeviceList(hashMap);
                        return;
                    case 32772:
                        TraeAudioManager.this.internalGetStreamType(hashMap);
                        return;
                    case 32773:
                        TraeAudioManager.this.internalSessionConnectDevice(hashMap);
                        return;
                    case MSG_CONNECT_HIGHEST_PRIORITY_DEVICE /* 32774 */:
                    case MSG_VOICE_CALL_PRE_PROCESS /* 32776 */:
                    default:
                        handleInternalStatusChange(i16, hashMap);
                        return;
                    case MSG_GET_CONNECTED_DEVICE /* 32775 */:
                        TraeAudioManager.this.internalSessionGetConnectedDevice(hashMap);
                        return;
                    case MSG_VOICE_CALL_POST_PROCESS /* 32777 */:
                        TraeAudioManager.this.internalVoiceCallPostProcess();
                        return;
                    case MSG_VOICE_CALL_AUDIO_PARAM_CHANGED /* 32778 */:
                        Integer num = (Integer) hashMap.get(TraeConstants.PARAM_STREAM_TYPE);
                        TraeAudioManager traeAudioManager = TraeAudioManager.this;
                        int i17 = traeAudioManager.mActiveMode;
                        if (num != null) {
                            traeAudioManager.mStreamType = num.intValue();
                            TraeAudioManager.this.notifyStreamTypeUpdate(num.intValue(), i17);
                            return;
                        }
                        return;
                    case MSG_FORCE_SWITCH_DEVICE /* 32779 */:
                        TraeAudioManager.this.internalForceSwitchDevice(hashMap);
                        return;
                    case MSG_SET_ACTIVE_MODE /* 32780 */:
                        TraeAudioManager.this.setActiveMode(hashMap);
                        return;
                }
            } catch (Exception e16) {
                AVCoreLog.e(TraeAudioManager.TAG, "handleMessage failed. msgType: " + message.what + ", exception: " + e16.getMessage());
            }
        }

        public int sendMessage(int i3, HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) hashMap)).intValue();
            }
            if (sendMessage(Message.obtain(this, i3, hashMap))) {
                return 0;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class DeviceConnectStatusListener implements DeviceSwitchThread.IDeviceConnectStatusListener {
        static IPatchRedirector $redirector_;
        private HashMap<String, Object> mParams;

        public DeviceConnectStatusListener(HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TraeAudioManager.this, (Object) hashMap);
            } else {
                this.mParams = hashMap;
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.DeviceSwitchThread.IDeviceConnectStatusListener
        public void onDeviceConnectFinish(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
                return;
            }
            if (this.mParams == null) {
                TraeAudioManager.this.notifyDeviceListUpdate();
                if (i3 == 7) {
                    TraeAudioManager.this.tryAutoConnectDevice(null);
                    return;
                }
                return;
            }
            TraeAudioManager traeAudioManager = TraeAudioManager.this;
            traeAudioManager.mSessionConnectedDevice = traeAudioManager.mDeviceConfigManager.getConnectedDevice();
            HashMap<String, Object> hashMap = this.mParams;
            hashMap.put(TraeConstants.EXTRA_CONNECT_DEVICE_NAME, hashMap.get(TraeConstants.PARAM_DEVICE_NAME));
            if (TraeAudioManager.this.sendResMessage(this.mParams, i3) == 0) {
                TraeAudioManager.this.notifyDeviceListUpdate();
            }
            if (i3 != 0) {
                TraeAudioManager.this.tryAutoConnectDevice(null);
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.DeviceSwitchThread.IDeviceConnectStatusListener
        public void onDeviceConnectStart(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TraeAudioManager.this.notifyDeviceConnectStart(str);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.DeviceSwitchThread.IDeviceConnectStatusListener
        public void onDeviceExternalSwitch(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TraeAudioManager.this.notifyDeviceExternalSwitch(str);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Notifier {
        void notify(int i3, HashMap<String, Object> hashMap);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13968);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            sInstance = null;
        }
    }

    TraeAudioManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mAudioManager = null;
        this.mDeviceConfigManager = null;
        this.mBluetoothHelper = null;
        this.mTraeAudioManagerThread = null;
        this.mCustomHandler = null;
        this.isInit = false;
        this.isServiceStart = false;
        this.lastConfig = "";
        this.mActiveMode = 0;
        this.mPrevMode = 0;
        this.voiceCallSessionID = -1L;
        this.voiceCallOperation = "";
        this.mStreamType = 0;
        this.mModePolicy = -1;
        this.mAudioScene = 0;
        this.mInCommunicationMode = false;
        this.mSessionConnectedDevice = TraeConstants.DEVICE_NONE;
        this.mAudioFocusChangeListener = null;
        this.mFocusStreamType = 0;
        this.mNotifiers = new CopyOnWriteArrayList<>();
        AVCoreLog.i(TAG, "Create TraeAudioManager.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.mAudioFocusChangeListener;
        if (onAudioFocusChangeListener != null) {
            this.mAudioManager.abandonAudioFocus(onAudioFocusChangeListener);
            this.mAudioFocusChangeListener = null;
        }
    }

    private BluetoothHelper createBluetoothHelper(Context context) {
        AVCoreLog.i(TAG, "Create BluetoothHelper.");
        BluetoothHelper bluetoothHelper = new BluetoothHelper();
        if (!bluetoothHelper.init(context, new BluetoothStatusListener(this, null))) {
            return null;
        }
        return bluetoothHelper;
    }

    public static TraeAudioManager getInstance() {
        if (sInstance == null) {
            synchronized (TraeAudioManager.class) {
                if (sInstance == null) {
                    sInstance = new TraeAudioManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int internalConnectDevice(String str, HashMap<String, Object> hashMap) {
        boolean z16;
        DeviceSwitchThread deviceSwitchThread;
        DeviceSwitchThread createDeviceSwitchThread;
        BluetoothHelper bluetoothHelper;
        List<BluetoothDevice> connectedDevices;
        AVCoreLog.i(TAG, "internalConnectDevice start. deviceName: " + str);
        if (DeviceConfigManager.checkDeviceName(str) && this.mDeviceConfigManager.getVisible(str) && this.mDeviceConfigManager.isDeviceChangeable()) {
            BluetoothHelper bluetoothHelper2 = this.mBluetoothHelper;
            if (bluetoothHelper2 != null && bluetoothHelper2.getBluetoothHeadset() != null) {
                try {
                    connectedDevices = this.mBluetoothHelper.getBluetoothHeadset().getConnectedDevices();
                } catch (Exception e16) {
                    AVCoreLog.e(TAG, "internalConnectDevice getConnectedDevices failed. exception: " + e16.getMessage());
                }
                if (connectedDevices != null) {
                    if (connectedDevices.size() > 1) {
                        z16 = true;
                        if (this.mDeviceConfigManager.getConnectedDevice().equals(TraeConstants.DEVICE_NONE) && this.mDeviceConfigManager.getConnectedDevice().equals(str) && (!str.equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET) || (str.equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET) && (bluetoothHelper = this.mBluetoothHelper) != null && ((bluetoothHelper.getBluetoothState() == 4 || this.mBluetoothHelper.getBluetoothState() == 5) && !z16)))) {
                            AVCoreLog.i(TAG, "internalConnectDevice end. it has connected. deviceName: " + str);
                            return 0;
                        }
                        if (AVCoreLog.isColorLevel()) {
                            AVCoreLog.i(TAG, "isBluetoothScoAvailableOffCall[" + this.mAudioManager.isBluetoothScoAvailableOffCall() + "]");
                        }
                        if (this.mAudioManager.isBluetoothScoAvailableOffCall() && str.equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
                            AVCoreLog.e(TAG, "Bluetooth SCO audio is not available off call, visible[" + this.mDeviceConfigManager.getVisible(str) + "]");
                            this.mDeviceConfigManager.setVisible(str, false);
                            this.mDeviceConfigManager.setBlueToothDevName("unknown");
                            BluetoothHelper bluetoothHelper3 = this.mBluetoothHelper;
                            if (bluetoothHelper3 != null) {
                                bluetoothHelper3.setBluetoothState(1);
                            }
                            return 0;
                        }
                        this.mDeviceConfigManager.setConnectingDevice(str);
                        deviceSwitchThread = this.mSwitchThread;
                        if (deviceSwitchThread != null) {
                            deviceSwitchThread.quit();
                            this.mSwitchThread = null;
                        }
                        createDeviceSwitchThread = DeviceSwitchThread.createDeviceSwitchThread(this.mContext, str);
                        this.mSwitchThread = createDeviceSwitchThread;
                        if (createDeviceSwitchThread != null) {
                            createDeviceSwitchThread.start(new DeviceConnectStatusListener(hashMap), this.mBluetoothHelper, this.mInCommunicationMode);
                        }
                        AVCoreLog.i(TAG, "internalConnectDevice end.");
                        return 0;
                    }
                }
            }
            z16 = false;
            if (this.mDeviceConfigManager.getConnectedDevice().equals(TraeConstants.DEVICE_NONE)) {
            }
            if (AVCoreLog.isColorLevel()) {
            }
            if (this.mAudioManager.isBluetoothScoAvailableOffCall()) {
            }
            this.mDeviceConfigManager.setConnectingDevice(str);
            deviceSwitchThread = this.mSwitchThread;
            if (deviceSwitchThread != null) {
            }
            createDeviceSwitchThread = DeviceSwitchThread.createDeviceSwitchThread(this.mContext, str);
            this.mSwitchThread = createDeviceSwitchThread;
            if (createDeviceSwitchThread != null) {
            }
            AVCoreLog.i(TAG, "internalConnectDevice end.");
            return 0;
        }
        AVCoreLog.e(TAG, "internalConnectDevice failed. checkDeviceName: " + DeviceConfigManager.checkDeviceName(str) + ", visible: " + this.mDeviceConfigManager.getVisible(str) + ", changeable: " + this.mDeviceConfigManager.isDeviceChangeable());
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalForceSwitchDevice(HashMap<String, Object> hashMap) {
        if (hashMap != null && this.mSwitchThread != null) {
            String str = (String) hashMap.get(TraeConstants.PARAM_DEVICE_NAME);
            boolean booleanValue = ((Boolean) hashMap.get(TraeConstants.PARAM_FORCE_SWITCH_DEVICE)).booleanValue();
            AVCoreLog.i(TAG, "internalForceSwitchDevice. mDeviceName: " + str + ", isForceSwitch: " + booleanValue);
            if (TraeConstants.DEVICE_EARPHONE.equals(str)) {
                this.mSwitchThread.forceSwitchEarPhone = booleanValue;
            } else if (TraeConstants.DEVICE_SPEAKERPHONE.equals(str)) {
                this.mSwitchThread.forceSwitchSpeakerPhone = booleanValue;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalGetStreamType(HashMap<String, Object> hashMap) {
        hashMap.put(TraeConstants.EXTRA_DATA_STREAM_TYPE, Integer.valueOf(this.mStreamType));
        hashMap.put(TraeConstants.EXTRA_DATA_ACTIVE_MODE, Integer.valueOf(this.mActiveMode));
        sendResMessage(hashMap, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSessionConnectDevice(HashMap<String, Object> hashMap) {
        int i3;
        if (hashMap != null && this.mContext != null) {
            String str = (String) hashMap.get(TraeConstants.PARAM_DEVICE_NAME);
            boolean isDeviceChangeable = this.mDeviceConfigManager.isDeviceChangeable();
            if (!DeviceConfigManager.checkDeviceName(str)) {
                i3 = 4;
            } else if (!this.mDeviceConfigManager.getVisible(str)) {
                i3 = 5;
            } else if (!isDeviceChangeable) {
                this.mSessionConnectedDevice = str;
                i3 = 6;
            } else {
                i3 = 0;
            }
            AVCoreLog.i(TAG, "internalSessionConnectDevice start. sessionId[" + hashMap.get(TraeConstants.KEY_SESSION_ID) + "], devName[" + str + "], changeable[" + isDeviceChangeable + "], errorCode[" + i3 + "]");
            if (i3 == 0 && !this.mDeviceConfigManager.getConnectedDevice().equals(str)) {
                internalConnectDevice(str, hashMap);
                AVCoreLog.i(TAG, "internalSessionConnectDevice end.");
                return;
            }
            AVCoreLog.e(TAG, "internalSessionConnectDevice failed. errorCode[" + i3 + "], connectedDevice[" + this.mDeviceConfigManager.getConnectedDevice() + "]");
            hashMap.put(TraeConstants.EXTRA_CONNECT_DEVICE_NAME, str);
            sendResMessage(hashMap, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSessionGetConnectedDevice(HashMap<String, Object> hashMap) {
        hashMap.put(TraeConstants.EXTRA_DATA_CONNECTED_DEVICE_NAME, this.mDeviceConfigManager.getConnectedDevice());
        sendResMessage(hashMap, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSessionGetDeviceList(HashMap<String, Object> hashMap) {
        ArrayList<String> visibleDeviceList = this.mDeviceConfigManager.getVisibleDeviceList();
        String connectedDevice = this.mDeviceConfigManager.getConnectedDevice();
        String prevConnectedDevice = this.mDeviceConfigManager.getPrevConnectedDevice();
        String blueToothDevName = this.mDeviceConfigManager.getBlueToothDevName();
        hashMap.put(TraeConstants.EXTRA_DATA_VISIBLE_DEVICE_LIST, visibleDeviceList.toArray(new String[0]));
        hashMap.put(TraeConstants.EXTRA_DATA_CONNECTED_DEVICE, connectedDevice);
        hashMap.put(TraeConstants.EXTRA_DATA_PREV_CONNECTED_DEVICE, prevConnectedDevice);
        hashMap.put(TraeConstants.EXTRA_DATA_BLUETOOTH_NAME, blueToothDevName);
        sendResMessage(hashMap, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalStartService(HashMap<String, Object> hashMap) {
        boolean z16;
        String str = (String) hashMap.get(TraeConstants.PARAM_DEVICE_CONFIG);
        AVCoreLog.i(TAG, "internalStartService start. device config: " + str);
        if (TextUtils.isEmpty(str)) {
            AVCoreLog.e(TAG, "internalStartService failed. device config is empty.");
            return;
        }
        if (this.isServiceStart) {
            if (!this.lastConfig.equals(str) && this.mActiveMode == 0) {
                internalStopService();
            } else {
                AVCoreLog.i(TAG, "internalStartService return. lastConfig.equals(config) || mActiveMode != AUDIO_MANAGER_ACTIVE_NONE.");
                return;
            }
        }
        prevStartService(((Boolean) hashMap.get(TraeConstants.PARAM_IS_ALLOWED_USE_BLUETOOTH)).booleanValue());
        this.mDeviceConfigManager.clearConfig();
        this.mDeviceConfigManager.init(str);
        this.lastConfig = str;
        this.isServiceStart = true;
        String str2 = (String) hashMap.get(TraeConstants.PARAM_CONNECT_DEVICE_WHEN_START_SERVICE);
        int deviceNumber = this.mDeviceConfigManager.getDeviceNumber();
        for (int i3 = 0; i3 < deviceNumber; i3++) {
            String deviceName = this.mDeviceConfigManager.getDeviceName(i3);
            if (deviceName != null) {
                if (deviceName.equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
                    BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
                    if ((bluetoothHelper != null && bluetoothHelper.isConnected()) || this.mAudioManager.isBluetoothA2dpOn()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    BluetoothHelper bluetoothHelper2 = this.mBluetoothHelper;
                    if (bluetoothHelper2 != null && z16) {
                        bluetoothHelper2.setBluetoothState(2);
                    }
                    this.mDeviceConfigManager.setVisible(deviceName, z16);
                } else if (deviceName.equals(TraeConstants.DEVICE_WIRED_HEADSET)) {
                    this.mDeviceConfigManager.setVisible(deviceName, this.mAudioManager.isWiredHeadsetOn());
                } else if (deviceName.equals(TraeConstants.DEVICE_SPEAKERPHONE)) {
                    this.mDeviceConfigManager.setVisible(deviceName, true);
                }
            }
        }
        tryAutoConnectDevice(str2);
        notifyServiceState(true);
        AVCoreLog.i(TAG, "internalStartService end.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalStopService() {
        AVCoreLog.i(TAG, "internalStopService start. isServiceStart: " + this.isServiceStart);
        if (!this.isServiceStart) {
            AVCoreLog.i(TAG, "internalStopService return. !isServiceStart.");
            return;
        }
        if (this.mActiveMode == 1) {
            interruptVoiceCall();
        }
        DeviceSwitchThread deviceSwitchThread = this.mSwitchThread;
        if (deviceSwitchThread != null) {
            deviceSwitchThread.quit();
            this.mSwitchThread = null;
        }
        this.isServiceStart = false;
        notifyServiceState(false);
        try {
            TraeUtils.setAudioMode(this.mAudioManager, 0);
            TraeUtils.forceVolumeControlStream(this.mAudioManager, -1);
        } catch (Exception e16) {
            AVCoreLog.e(TAG, "internalStopService failed. exception: " + e16.getMessage());
        }
        postStopService();
        AVCoreLog.i(TAG, "internalStopService end.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalVoiceCallPostProcess() {
        this.mActiveMode = 0;
        this.mInCommunicationMode = false;
        abandonAudioFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalVoiceCallPreProcess(HashMap<String, Object> hashMap) {
        int intValue;
        int intValue2;
        int intValue3;
        if (hashMap == null) {
            return;
        }
        if (this.mActiveMode == 1) {
            AVCoreLog.i(TAG, "internalVoiceCallPreProcess return. mActiveMode == AUDIO_MANAGER_ACTIVE_VOICE_CALL.");
            sendResMessage(hashMap, 2);
            return;
        }
        this.voiceCallSessionID = ((Long) hashMap.get(TraeConstants.KEY_SESSION_ID)).longValue();
        this.voiceCallOperation = (String) hashMap.get(TraeConstants.KEY_OPERATION);
        this.mActiveMode = 1;
        this.mSessionConnectedDevice = TraeConstants.DEVICE_NONE;
        this.mPrevMode = this.mAudioManager.getMode();
        Integer num = (Integer) hashMap.get(TraeConstants.PARAM_MODE_POLICY);
        Integer num2 = (Integer) hashMap.get(TraeConstants.PARAM_STREAM_TYPE);
        Integer num3 = (Integer) hashMap.get(TraeConstants.PARAM_AUDIO_SCENE);
        if (num == null) {
            intValue = -1;
        } else {
            intValue = num.intValue();
        }
        this.mModePolicy = intValue;
        if (num2 == null) {
            intValue2 = 0;
        } else {
            intValue2 = num2.intValue();
        }
        this.mStreamType = intValue2;
        if (num3 == null) {
            intValue3 = 0;
        } else {
            intValue3 = num3.intValue();
        }
        this.mAudioScene = intValue3;
        AVCoreLog.i(TAG, "internalVoiceCallPreProcess. AudioMode: " + TraeUtils.getAudioMode(this.mModePolicy) + ", mStreamType: " + this.mStreamType + ", mActiveMode: " + this.mActiveMode + ", mAudioScene: " + this.mAudioScene);
        notifyStreamTypeUpdate(this.mStreamType, this.mActiveMode);
        TraeUtils.setAudioMode(this.mAudioManager, TraeUtils.getAudioMode(this.mModePolicy));
        if (this.mAudioScene != 5) {
            this.mInCommunicationMode = true;
            requestAudioFocus(this.mStreamType);
        }
        AVCoreLog.i(TAG, "internalVoiceCallPreProcess. mInCommunicationMode: " + this.mInCommunicationMode);
        sendResMessage(hashMap, 0);
    }

    private void interruptVoiceCall() {
        if (this.mActiveMode != 1) {
            AVCoreLog.e(TAG, "interruptVoiceCall failed, mActiveMode[" + this.mActiveMode + "]");
            return;
        }
        this.mActiveMode = 0;
        int i3 = this.mPrevMode;
        if (i3 != -1) {
            TraeUtils.setAudioMode(this.mAudioManager, i3);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.KEY_SESSION_ID, Long.valueOf(this.voiceCallSessionID));
        hashMap.put(TraeConstants.KEY_OPERATION, this.voiceCallOperation);
        sendResMessage(hashMap, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDeviceConnectStart(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.EXTRA_DATA_CHANGEABLE_STATE, Boolean.valueOf(this.mDeviceConfigManager.isDeviceChangeable()));
        hashMap.put(TraeConstants.EXTRA_CONNECT_DEVICE_NAME, str);
        Iterator<Notifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notify(2, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDeviceExternalSwitch(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.EXTRA_CONNECT_DEVICE_NAME, str);
        Iterator<Notifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notify(4, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDeviceListUpdate() {
        if (this.isInit && this.mDeviceConfigManager != null) {
            DeviceConfigManager deviceConfigManager = DeviceConfigManager.getInstance();
            ArrayList<String> visibleDeviceList = deviceConfigManager.getVisibleDeviceList();
            String connectedDevice = deviceConfigManager.getConnectedDevice();
            String prevConnectedDevice = deviceConfigManager.getPrevConnectedDevice();
            String blueToothDevName = deviceConfigManager.getBlueToothDevName();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(TraeConstants.EXTRA_DATA_VISIBLE_DEVICE_LIST, visibleDeviceList.toArray(new String[0]));
            hashMap.put(TraeConstants.EXTRA_DATA_CONNECTED_DEVICE, connectedDevice);
            hashMap.put(TraeConstants.EXTRA_DATA_PREV_CONNECTED_DEVICE, prevConnectedDevice);
            hashMap.put(TraeConstants.EXTRA_DATA_BLUETOOTH_NAME, blueToothDevName);
            Iterator<Notifier> it = this.mNotifiers.iterator();
            while (it.hasNext()) {
                it.next().notify(3, hashMap);
            }
        }
    }

    private void notifyServiceState(boolean z16) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.EXTRA_DATA_SERVICE_STATE, Boolean.valueOf(z16));
        Iterator<Notifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notify(1, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStreamTypeUpdate(int i3, int i16) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.EXTRA_DATA_STREAM_TYPE, Integer.valueOf(i3));
        hashMap.put(TraeConstants.EXTRA_DATA_ACTIVE_MODE, Integer.valueOf(i16));
        Iterator<Notifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notify(5, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDevicePluginStatusChange(String str, boolean z16) {
        if (this.mDeviceConfigManager.getVisibleUpdate()) {
            updateEarphoneVisible();
            this.mDeviceConfigManager.resetVisibleUpdate();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(TraeConstants.PARAM_DEVICE_NAME, str);
            if (z16) {
                this.mCustomHandler.sendMessage(CustomHandler.MSG_AUTO_DEVICE_PLUG_IN, hashMap);
            } else {
                this.mCustomHandler.sendMessage(CustomHandler.MSG_AUTO_DEVICE_PLUG_OUT, hashMap);
            }
        }
    }

    private void onReceiveWiredHeadsetPlug(Intent intent) {
        String stringExtra = intent.getStringExtra("name");
        boolean z16 = false;
        int intExtra = intent.getIntExtra("state", 0);
        int intExtra2 = intent.getIntExtra("microphone", 0);
        DeviceConfigManager deviceConfigManager = this.mDeviceConfigManager;
        if (intExtra == 1) {
            z16 = true;
        }
        deviceConfigManager.setVisible(TraeConstants.DEVICE_WIRED_HEADSET, z16);
        if (AVCoreLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("receive wire headset plug, name[");
            if (stringExtra == null) {
                stringExtra = "unknown";
            }
            sb5.append(stringExtra);
            sb5.append("], state[");
            sb5.append(intExtra);
            sb5.append("], microphone[");
            sb5.append(intExtra2);
            sb5.append("]");
            AVCoreLog.e(TAG, sb5.toString());
        }
    }

    private void postStopService() {
        try {
            BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
            if (bluetoothHelper != null) {
                bluetoothHelper.release();
                this.mBluetoothHelper = null;
            }
        } catch (Exception unused) {
        }
    }

    private void prevStartService(boolean z16) {
        Context context;
        if (z16) {
            try {
                if (this.mBluetoothHelper == null && (context = this.mContext) != null) {
                    this.mBluetoothHelper = createBluetoothHelper(context);
                    IntentFilter intentFilter = new IntentFilter();
                    BluetoothHelper.addAction(intentFilter);
                    this.mContext.registerReceiver(this, intentFilter);
                }
            } catch (Exception unused) {
                return;
            }
        }
        AVCoreLog.i(TAG, "isAllowedUseBluetoothDevice: " + z16);
    }

    private void requestAudioFocus(int i3) {
        if (this.mAudioFocusChangeListener == null) {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.avcore.jni.audiodevice.TraeAudioManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TraeAudioManager.this);
                    }
                }

                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i16);
                        return;
                    }
                    if (AVCoreLog.isColorLevel()) {
                        AVCoreLog.e(TraeAudioManager.TAG, "focusChange[" + i16 + "], focusSteamType[" + TraeAudioManager.this.mFocusStreamType + "], mAudioManager.getMode()[" + TraeAudioManager.this.mAudioManager.getMode() + "], mActiveMode[" + TraeAudioManager.this.mActiveMode + "]");
                    }
                }
            };
            this.mAudioFocusChangeListener = onAudioFocusChangeListener;
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                int requestAudioFocus = audioManager.requestAudioFocus(onAudioFocusChangeListener, i3, 2);
                if (requestAudioFocus != 1 && AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(TAG, "requestAudioFocus fail, ret[" + requestAudioFocus + "], mode[" + this.mAudioManager.getMode() + "]");
                }
                this.mFocusStreamType = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sendResMessage(HashMap<String, Object> hashMap, int i3) {
        if (hashMap == null) {
            AVCoreLog.e(TAG, "sendResMessage failed. params == null.");
            return -1;
        }
        Long l3 = (Long) hashMap.get(TraeConstants.KEY_SESSION_ID);
        AVCoreLog.i(TAG, "sendResMessage. sessionId: " + l3 + ", operation: " + ((String) hashMap.get(TraeConstants.KEY_OPERATION)));
        if (l3 != null && l3.longValue() != Long.MIN_VALUE) {
            hashMap.put(TraeConstants.EXTRA_RES_ERROR_CODE, Integer.valueOf(i3));
            Iterator<Notifier> it = this.mNotifiers.iterator();
            while (it.hasNext()) {
                it.next().notify(6, hashMap);
            }
            return 0;
        }
        notifyDeviceListUpdate();
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActiveMode(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        int intValue = ((Integer) hashMap.get(TraeConstants.PARAM_ACTIVE_MODE)).intValue();
        AVCoreLog.i(TAG, "setActiveMode. activeMode: " + intValue);
        this.mActiveMode = intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryAutoConnectDevice(String str) {
        if (this.mDeviceConfigManager.getVisibleUpdate()) {
            updateEarphoneVisible();
            this.mDeviceConfigManager.resetVisibleUpdate();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(TraeConstants.PARAM_CONNECT_DEVICE_WHEN_START_SERVICE, str);
            this.mCustomHandler.sendMessage(CustomHandler.MSG_TRY_AUTO_CONNECT_DEVICE, hashMap);
        }
    }

    private void updateEarphoneVisible() {
        if (this.mDeviceConfigManager.getVisible(TraeConstants.DEVICE_WIRED_HEADSET)) {
            this.mDeviceConfigManager.setVisible(TraeConstants.DEVICE_EARPHONE, false);
        } else {
            this.mDeviceConfigManager.setVisible(TraeConstants.DEVICE_EARPHONE, true);
        }
    }

    public synchronized void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        AVCoreLog.i(TAG, "init start. context: " + context + ", isInit: " + this.isInit);
        if (context == null) {
            AVCoreLog.e(TAG, "init failed. context == null.");
            return;
        }
        if (this.isInit) {
            AVCoreLog.i(TAG, "init end. it has inited.");
            return;
        }
        this.mContext = context;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mDeviceConfigManager = DeviceConfigManager.getInstance();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        this.mContext.registerReceiver(this, intentFilter);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(TAG);
        this.mTraeAudioManagerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mCustomHandler = new CustomHandler(this.mTraeAudioManagerThread.getLooper());
        this.isInit = true;
        AVCoreLog.i(TAG, "init end.");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent != null && context != null) {
            try {
                boolean z16 = true;
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    boolean visible = this.mDeviceConfigManager.getVisible(TraeConstants.DEVICE_WIRED_HEADSET);
                    onReceiveWiredHeadsetPlug(intent);
                    if (visible != this.mDeviceConfigManager.getVisible(TraeConstants.DEVICE_WIRED_HEADSET)) {
                        if (visible) {
                            z16 = false;
                        }
                        onDevicePluginStatusChange(TraeConstants.DEVICE_WIRED_HEADSET, z16);
                        return;
                    }
                    return;
                }
                boolean visible2 = this.mDeviceConfigManager.getVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET);
                BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
                if (bluetoothHelper != null) {
                    bluetoothHelper.onReceive(intent);
                }
                if (visible2 != this.mDeviceConfigManager.getVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
                    if (visible2) {
                        z16 = false;
                    }
                    onDevicePluginStatusChange(TraeConstants.DEVICE_BLUETOOTH_HEADSET, z16);
                    return;
                }
                return;
            } catch (Exception e16) {
                AVCoreLog.e(TAG, "onReceive failed. exception: " + e16.getMessage());
                return;
            }
        }
        AVCoreLog.e(TAG, "onReceive failed, intent: " + intent + ", context: " + context);
    }

    public synchronized void registerAudioSession(boolean z16, Notifier notifier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), notifier);
            return;
        }
        AVCoreLog.i(TAG, "registerAudioSession. register: " + z16 + ", notifier: " + notifier);
        if (this.isInit) {
            if (z16) {
                this.mNotifiers.add(notifier);
            } else {
                this.mNotifiers.remove(notifier);
            }
        }
    }

    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AVCoreLog.i(TAG, "release start. isInit: " + this.isInit);
        if (!this.isInit) {
            AVCoreLog.i(TAG, "release end. it has released.");
            return;
        }
        this.isInit = false;
        internalStopService();
        DeviceConfigManager deviceConfigManager = this.mDeviceConfigManager;
        if (deviceConfigManager != null) {
            deviceConfigManager.clearConfig();
            this.mDeviceConfigManager = null;
        }
        BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
        if (bluetoothHelper != null) {
            bluetoothHelper.release();
            this.mBluetoothHelper = null;
        }
        Context context = this.mContext;
        if (context != null) {
            context.unregisterReceiver(this);
            this.mContext = null;
        }
        HandlerThread handlerThread = this.mTraeAudioManagerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mTraeAudioManagerThread = null;
            this.mCustomHandler = null;
        }
        sInstance = null;
        AVCoreLog.i(TAG, "release end.");
    }

    public int sendMessage(int i3, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) hashMap)).intValue();
        }
        CustomHandler customHandler = this.mCustomHandler;
        if (customHandler != null) {
            return customHandler.sendMessage(i3, hashMap);
        }
        return -1;
    }
}
