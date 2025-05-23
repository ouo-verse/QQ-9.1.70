package com.tencent.avcore.jni;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.avcore.jni.audiodevice.AudioDeviceInterface;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcAudioDevice implements TraeAudioManager.Notifier {
    static IPatchRedirector $redirector_ = null;
    private static final String SEQ = "log_seq";
    private static final String TAG = "NtrtcAudioDevice";
    private static int s_nSessionIdAllocator;
    private ITraeAudioCallback mCallback;
    private CallbackHandler mCallbackHandler;
    private boolean mIsCallbackFromTRAEJNI;
    private boolean mIsHandlingMessage;
    private boolean mIsInited;
    private long mSessionId;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class PreprocessState {
        static IPatchRedirector $redirector_ = null;
        public static final int DOING = 1;
        public static final int DONE = 2;
        public static final int NONE = 0;

        PreprocessState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_HIDDEN_CHAT_SWITCH);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            s_nSessionIdAllocator = 0;
        }
    }

    public NtrtcAudioDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsCallbackFromTRAEJNI = false;
        this.mIsInited = false;
        this.mIsHandlingMessage = false;
    }

    private void registerAudioSession(boolean z16) {
        TraeAudioManager.getInstance().registerAudioSession(z16, this);
    }

    private static long requestSessionId() {
        long myPid = Process.myPid() << 32;
        int i3 = s_nSessionIdAllocator + 1;
        s_nSessionIdAllocator = i3;
        return myPid + i3;
    }

    public int connectDevice(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), str)).intValue();
        }
        if (str == null) {
            return -1;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.KEY_SESSION_ID, Long.valueOf(this.mSessionId));
        hashMap.put(TraeConstants.KEY_OPERATION, TraeConstants.OPERATION_CONNECT_DEVICE);
        hashMap.put(TraeConstants.PARAM_DEVICE_NAME, str);
        return TraeAudioManager.getInstance().sendMessage(32773, hashMap);
    }

    public int connectHighestPriorityDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return TraeAudioManager.getInstance().sendMessage(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE, new HashMap<>());
    }

    public int forceSwitchAudioDevice(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, str, Boolean.valueOf(z16))).intValue();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.PARAM_DEVICE_NAME, str);
        hashMap.put(TraeConstants.PARAM_FORCE_SWITCH_DEVICE, Boolean.valueOf(z16));
        return TraeAudioManager.getInstance().sendMessage(TraeAudioManager.CustomHandler.MSG_FORCE_SWITCH_DEVICE, hashMap);
    }

    public int getConnectedDevice(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, j3)).intValue();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.KEY_SESSION_ID, Long.valueOf(this.mSessionId));
        hashMap.put(TraeConstants.KEY_OPERATION, TraeConstants.OPERATION_GET_CONNECTED_DEVICE);
        return TraeAudioManager.getInstance().sendMessage(TraeAudioManager.CustomHandler.MSG_GET_CONNECTED_DEVICE, hashMap);
    }

    public int getDeviceList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.KEY_SESSION_ID, Long.valueOf(this.mSessionId));
        hashMap.put(TraeConstants.KEY_OPERATION, TraeConstants.OPERATION_GET_DEVICE_LIST);
        return TraeAudioManager.getInstance().sendMessage(32771, hashMap);
    }

    public int getStreamType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.KEY_SESSION_ID, Long.valueOf(this.mSessionId));
        hashMap.put(TraeConstants.KEY_OPERATION, TraeConstants.OPERATION_GET_STREAM_TYPE);
        return TraeAudioManager.getInstance().sendMessage(32772, hashMap);
    }

    public void init(ITraeAudioCallback iTraeAudioCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init(iTraeAudioCallback, false);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTraeAudioCallback);
        }
    }

    @Override // com.tencent.avcore.jni.audiodevice.TraeAudioManager.Notifier
    public void notify(int i3, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) hashMap);
            return;
        }
        CallbackHandler callbackHandler = this.mCallbackHandler;
        if (callbackHandler != null) {
            callbackHandler.sendMessage(i3, hashMap);
            if (this.mIsCallbackFromTRAEJNI && i3 == 6 && hashMap != null && TraeConstants.OPERATION_VOICE_CALL_PRE_PROCESS.equals((String) hashMap.get(TraeConstants.KEY_OPERATION))) {
                this.mCallbackHandler.getInt(hashMap, TraeConstants.EXTRA_RES_ERROR_CODE, 0);
                AudioDeviceInterface.setPreprocessState(2);
            }
        }
    }

    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mIsInited = false;
        registerAudioSession(false);
        this.mCallbackHandler.removeMessages(1);
        this.mCallbackHandler.removeMessages(2);
        this.mCallbackHandler.removeMessages(3);
        this.mCallbackHandler.removeMessages(4);
        this.mCallbackHandler.removeMessages(5);
        this.mCallbackHandler.removeMessages(6);
        if (!this.mIsHandlingMessage) {
            this.mCallback = null;
        }
    }

    public int setActiveMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.PARAM_ACTIVE_MODE, Integer.valueOf(i3));
        return TraeAudioManager.getInstance().sendMessage(TraeAudioManager.CustomHandler.MSG_SET_ACTIVE_MODE, hashMap);
    }

    public int startService(long j3, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), str, str2, Boolean.valueOf(z16))).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.PARAM_DEVICE_CONFIG, str);
        hashMap.put(TraeConstants.PARAM_CONNECT_DEVICE_WHEN_START_SERVICE, str2);
        hashMap.put(TraeConstants.PARAM_IS_ALLOWED_USE_BLUETOOTH, Boolean.valueOf(z16));
        return TraeAudioManager.getInstance().sendMessage(32769, hashMap);
    }

    public int stopService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return TraeAudioManager.getInstance().sendMessage(32770, new HashMap<>());
    }

    public int voiceCallAudioParamChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, i3)).intValue();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.PARAM_STREAM_TYPE, Integer.valueOf(i3));
        return TraeAudioManager.getInstance().sendMessage(TraeAudioManager.CustomHandler.MSG_VOICE_CALL_AUDIO_PARAM_CHANGED, hashMap);
    }

    public int voiceCallPostProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return TraeAudioManager.getInstance().sendMessage(TraeAudioManager.CustomHandler.MSG_VOICE_CALL_POST_PROCESS, new HashMap<>());
    }

    public int voiceCallPreProcess(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.KEY_SESSION_ID, Long.valueOf(this.mSessionId));
        hashMap.put(TraeConstants.KEY_OPERATION, TraeConstants.OPERATION_VOICE_CALL_PRE_PROCESS);
        hashMap.put(TraeConstants.PARAM_MODE_POLICY, Integer.valueOf(i3));
        hashMap.put(TraeConstants.PARAM_STREAM_TYPE, Integer.valueOf(i16));
        hashMap.put(TraeConstants.PARAM_AUDIO_SCENE, Integer.valueOf(i17));
        return TraeAudioManager.getInstance().sendMessage(TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, hashMap);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class CallbackHandler extends Handler {
        static IPatchRedirector $redirector_ = null;
        public static final int NOTIFY_DEVICE_CONNECTING_START = 2;
        public static final int NOTIFY_DEVICE_EXTERNAL_SWITCH = 4;
        public static final int NOTIFY_DEVICE_LIST_UPDATE = 3;
        public static final int NOTIFY_SERVICE_STATE = 1;
        public static final int NOTIFY_STREAM_TYPE_UPDATE = 5;
        public static final int TYPE_RESULT_MESSAGE = 6;

        public CallbackHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NtrtcAudioDevice.this, (Object) looper);
            }
        }

        private long getSeq(Object obj) {
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            return 0L;
        }

        private void handleResultMsg(HashMap<String, Object> hashMap) {
            boolean z16 = false;
            int i3 = getInt(hashMap, TraeConstants.EXTRA_RES_ERROR_CODE, 0);
            long j3 = getLong(hashMap, TraeConstants.KEY_SESSION_ID, Long.MIN_VALUE);
            String str = (String) hashMap.get(TraeConstants.KEY_OPERATION);
            if (j3 != NtrtcAudioDevice.this.mSessionId) {
                AVCoreLog.e(NtrtcAudioDevice.TAG, "handleResultMsg failed. sessionId different, mSessionId[" + NtrtcAudioDevice.this.mSessionId + "], sessionId[" + j3 + "]");
                return;
            }
            if (TraeConstants.OPERATION_GET_DEVICE_LIST.equals(str)) {
                String[] strArr = (String[]) hashMap.get(TraeConstants.EXTRA_DATA_VISIBLE_DEVICE_LIST);
                String str2 = (String) hashMap.get(TraeConstants.EXTRA_DATA_CONNECTED_DEVICE);
                String str3 = (String) hashMap.get(TraeConstants.EXTRA_DATA_PREV_CONNECTED_DEVICE);
                String str4 = (String) hashMap.get(TraeConstants.EXTRA_DATA_BLUETOOTH_NAME);
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(NtrtcAudioDevice.TAG, "OPERATION_GET_DEVICE_LIST, errCode[" + i3 + "], connectedDevice[" + str2 + "], preConnectedDevice[" + str3 + "], bluetoothName[" + str4 + "]");
                }
                if (NtrtcAudioDevice.this.mCallback != null) {
                    NtrtcAudioDevice.this.mCallback.onGetDeviceListRes(i3, strArr, str2, str3, str4);
                    return;
                }
                return;
            }
            if (TraeConstants.OPERATION_CONNECT_DEVICE.equals(str)) {
                String str5 = (String) hashMap.get(TraeConstants.EXTRA_CONNECT_DEVICE_NAME);
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(NtrtcAudioDevice.TAG, "OPERATION_CONNECT_DEVICE, errCode[" + i3 + "] deviceName[" + str5 + "]");
                }
                if (NtrtcAudioDevice.this.mCallback != null) {
                    ITraeAudioCallback iTraeAudioCallback = NtrtcAudioDevice.this.mCallback;
                    if (i3 == 0) {
                        z16 = true;
                    }
                    iTraeAudioCallback.onConnectDeviceRes(i3, str5, z16);
                    return;
                }
                return;
            }
            if (TraeConstants.OPERATION_GET_CONNECTED_DEVICE.equals(str)) {
                String str6 = (String) hashMap.get(TraeConstants.EXTRA_DATA_CONNECTED_DEVICE_NAME);
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(NtrtcAudioDevice.TAG, "OPERATION_GET_CONNECTED_DEVICE, errCode[" + i3 + "], deviceName[" + str6 + "]");
                }
                if (NtrtcAudioDevice.this.mCallback != null) {
                    NtrtcAudioDevice.this.mCallback.onGetConnectedDeviceRes(i3, str6);
                    return;
                }
                return;
            }
            if (TraeConstants.OPERATION_GET_STREAM_TYPE.equals(str)) {
                int i16 = getInt(hashMap, TraeConstants.EXTRA_DATA_STREAM_TYPE, -1);
                int i17 = getInt(hashMap, TraeConstants.EXTRA_DATA_ACTIVE_MODE, -1);
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(NtrtcAudioDevice.TAG, "OPERATION_GET_STREAM_TYPE, errCode[" + i3 + "], streamType[" + i16 + "], activeMode[" + i17 + "]");
                }
                if (NtrtcAudioDevice.this.mCallback != null) {
                    NtrtcAudioDevice.this.mCallback.onGetStreamTypeRes(i3, i16, i17);
                    return;
                }
                return;
            }
            if (TraeConstants.OPERATION_VOICE_CALL_PRE_PROCESS.equals(str)) {
                AVCoreLog.i(NtrtcAudioDevice.TAG, "handleResultMsg. OPERATION_VOICE_CALL_PRE_PROCESS, errCode[" + i3 + "]");
                if (NtrtcAudioDevice.this.mCallback != null) {
                    NtrtcAudioDevice.this.mCallback.onVoiceCallPreProcessRes(i3);
                    return;
                }
                return;
            }
            AVCoreLog.e(NtrtcAudioDevice.TAG, "handleResultMsg failed. unknown operation[" + str + "]");
        }

        public boolean getBoolean(HashMap<String, Object> hashMap, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, hashMap, str, Boolean.valueOf(z16))).booleanValue();
            }
            Object obj = hashMap.get(str);
            if (obj != null && (obj instanceof Boolean)) {
                return ((Boolean) obj).booleanValue();
            }
            return z16;
        }

        public int getInt(HashMap<String, Object> hashMap, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, this, hashMap, str, Integer.valueOf(i3))).intValue();
            }
            Object obj = hashMap.get(str);
            if (obj != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
            return i3;
        }

        public long getLong(HashMap<String, Object> hashMap, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, this, hashMap, str, Long.valueOf(j3))).longValue();
            }
            Object obj = hashMap.get(str);
            if (obj != null && (obj instanceof Long)) {
                return ((Long) obj).longValue();
            }
            return j3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                NtrtcAudioDevice.this.mIsHandlingMessage = true;
                try {
                    HashMap<String, Object> hashMap = (HashMap) message.obj;
                    if (hashMap == null) {
                        AVCoreLog.e(NtrtcAudioDevice.TAG, "handleMessage, empty params");
                        NtrtcAudioDevice.this.mIsHandlingMessage = false;
                        return;
                    }
                    if (!NtrtcAudioDevice.this.mIsInited) {
                        NtrtcAudioDevice.this.mCallback = null;
                        NtrtcAudioDevice.this.mIsHandlingMessage = false;
                        return;
                    }
                    long seq = getSeq(hashMap);
                    switch (message.what) {
                        case 1:
                            boolean z16 = getBoolean(hashMap, TraeConstants.EXTRA_DATA_SERVICE_STATE, false);
                            if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.e(NtrtcAudioDevice.TAG, "handleMessage.onServiceStateUpdate, isServiceOn[" + z16 + "], seq[" + seq + "]");
                            }
                            if (NtrtcAudioDevice.this.mCallback != null) {
                                NtrtcAudioDevice.this.mCallback.onServiceStateUpdate(seq, z16);
                                break;
                            }
                            break;
                        case 2:
                            String str = (String) hashMap.get(TraeConstants.EXTRA_CONNECT_DEVICE_NAME);
                            boolean z17 = getBoolean(hashMap, TraeConstants.EXTRA_DATA_CHANGEABLE_STATE, true);
                            if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.e(NtrtcAudioDevice.TAG, "handleMessage.(onBeginConnectDevice & onDeviceChangeableUpdate), deviceName[" + str + "], isChangeable[ " + z17 + "], seq[" + seq + "]");
                            }
                            if (NtrtcAudioDevice.this.mCallback != null) {
                                NtrtcAudioDevice.this.mCallback.onBeginConnectDevice(str);
                                NtrtcAudioDevice.this.mCallback.onDeviceChangeableUpdate(z17);
                                break;
                            }
                            break;
                        case 3:
                            String[] strArr = (String[]) hashMap.get(TraeConstants.EXTRA_DATA_VISIBLE_DEVICE_LIST);
                            String str2 = (String) hashMap.get(TraeConstants.EXTRA_DATA_CONNECTED_DEVICE);
                            String str3 = (String) hashMap.get(TraeConstants.EXTRA_DATA_PREV_CONNECTED_DEVICE);
                            String str4 = (String) hashMap.get(TraeConstants.EXTRA_DATA_BLUETOOTH_NAME);
                            if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.e(NtrtcAudioDevice.TAG, "handleMessage.onDeviceListUpdate, connectedDevice[" + str2 + "], preConnectedDevice[" + str3 + "], bluetoothName[" + str4 + "]");
                            }
                            if (NtrtcAudioDevice.this.mCallback != null) {
                                NtrtcAudioDevice.this.mCallback.onDeviceListUpdate(seq, strArr, str2, str3, str4);
                                break;
                            }
                            break;
                        case 4:
                            String str5 = (String) hashMap.get(TraeConstants.EXTRA_CONNECT_DEVICE_NAME);
                            if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.e(NtrtcAudioDevice.TAG, "handleMessage.onDeviceExternalSwitch, switchThreadDeviceName[" + str5 + "], seq[" + seq + "]");
                            }
                            if (NtrtcAudioDevice.this.mCallback != null) {
                                NtrtcAudioDevice.this.mCallback.onDeviceExternalSwitch(str5);
                                break;
                            }
                            break;
                        case 5:
                            int i3 = getInt(hashMap, TraeConstants.EXTRA_DATA_STREAM_TYPE, -1);
                            int i16 = getInt(hashMap, TraeConstants.EXTRA_DATA_ACTIVE_MODE, -1);
                            if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.e(NtrtcAudioDevice.TAG, "handleMessage.onStreamTypeUpdate, streamType[" + i3 + "], activeMode[" + i16 + "], seq[" + seq + "]");
                            }
                            if (NtrtcAudioDevice.this.mCallback != null) {
                                NtrtcAudioDevice.this.mCallback.onStreamTypeUpdate(seq, i3, i16);
                                break;
                            }
                            break;
                        case 6:
                            handleResultMsg(hashMap);
                            break;
                        default:
                            AVCoreLog.e(NtrtcAudioDevice.TAG, "handleMessage failed. msg: " + message);
                            break;
                    }
                    NtrtcAudioDevice.this.mIsHandlingMessage = false;
                    if (!NtrtcAudioDevice.this.mIsInited) {
                        NtrtcAudioDevice.this.mCallback = null;
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    AVCoreLog.e(NtrtcAudioDevice.TAG, "handleMessage, illegal param");
                    NtrtcAudioDevice.this.mIsHandlingMessage = false;
                    return;
                }
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) message);
        }

        public void sendMessage(int i3, HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) hashMap);
            } else {
                if (!NtrtcAudioDevice.this.mIsInited) {
                    return;
                }
                sendMessage(Message.obtain(this, i3, hashMap));
            }
        }

        private long getSeq(HashMap<String, Object> hashMap) {
            if (hashMap == null || !hashMap.containsKey(NtrtcAudioDevice.SEQ)) {
                return 0L;
            }
            return getSeq(hashMap.get(NtrtcAudioDevice.SEQ));
        }
    }

    public synchronized void init(ITraeAudioCallback iTraeAudioCallback, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, iTraeAudioCallback, Boolean.valueOf(z16));
            return;
        }
        this.mIsInited = true;
        this.mCallback = iTraeAudioCallback;
        this.mIsCallbackFromTRAEJNI = z16;
        this.mSessionId = requestSessionId();
        this.mCallbackHandler = new CallbackHandler(Looper.getMainLooper());
        registerAudioSession(true);
    }
}
