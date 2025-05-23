package com.tencent.avcore.jni.mav;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avcore.config.CameraConfigHelper;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.engine.mav.IMavAdapter;
import com.tencent.avcore.engine.mav.IMavEventListener;
import com.tencent.avcore.engine.mav.MavEventId;
import com.tencent.avcore.engine.mav.MavNativeEventParams;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.GetSignResponse;
import com.tencent.avcore.jni.data.MavCommonPBMsg;
import com.tencent.avcore.jni.data.NtrtcAppParam;
import com.tencent.avcore.jni.data.NtrtcAudioParam;
import com.tencent.avcore.jni.data.NtrtcCommonParam;
import com.tencent.avcore.jni.data.NtrtcNetworkParam;
import com.tencent.avcore.jni.data.NtrtcTerminalInfo;
import com.tencent.avcore.jni.data.NtrtcVideoParam;
import com.tencent.avcore.jni.data.OpenSDKEnterRoomParam;
import com.tencent.avcore.jni.data.UinOpenIdResponse;
import com.tencent.avcore.netchannel.IMavNetCallback;
import com.tencent.avcore.netchannel.IMavNetChannel;
import com.tencent.avcore.util.AVConstants;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.avcore.util.MavJniUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MavEngineJni implements MavEventId, IMavNetCallback {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "MavEngineJni";
    protected final IMavAdapter mAdapter;
    private int mAppId;
    protected AVNativeEventProcessor mEventCallback;
    protected NativeEventHandler mEventHandler;
    protected IMavEventListener mEventListener;
    protected IMavNetChannel mNetChannel;
    protected final AVCoreSystemInfo mSysInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MavEngineJni(AVCoreSystemInfo aVCoreSystemInfo, IMavAdapter iMavAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVCoreSystemInfo, (Object) iMavAdapter);
            return;
        }
        this.mSysInfo = aVCoreSystemInfo;
        this.mAdapter = iMavAdapter;
        this.mEventCallback = iMavAdapter.getNativeEventProcessor();
        AVCoreLog.e(TAG, "MavEngineJni, callback[" + this.mEventCallback + "]");
    }

    private String getAppId() {
        try {
            return String.valueOf(this.mAppId);
        } catch (Exception e16) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "getAppId", e16);
            }
            return "";
        }
    }

    private byte[] getConfigInfoFromFile() {
        IMavAdapter iMavAdapter = this.mAdapter;
        if (iMavAdapter != null) {
            return iMavAdapter.getConfigInfoFromFile();
        }
        return null;
    }

    private String getDeviceName() {
        return AVCoreSystemInfo.getDeviceName();
    }

    private int getOsType() {
        AVCoreSystemInfo aVCoreSystemInfo = this.mSysInfo;
        if (aVCoreSystemInfo != null) {
            return aVCoreSystemInfo.getOsType();
        }
        return 0;
    }

    private int getProductId() {
        return 0;
    }

    private String getReleaseVersion() {
        return Build.VERSION.RELEASE;
    }

    private String getSharpConfigPayloadFromFile() {
        IMavAdapter iMavAdapter = this.mAdapter;
        if (iMavAdapter != null) {
            return iMavAdapter.getSharpConfigPayloadFromFile();
        }
        return "";
    }

    private int getSharpConfigVersionFromFile() {
        IMavAdapter iMavAdapter = this.mAdapter;
        if (iMavAdapter != null) {
            return iMavAdapter.getSharpConfigVersionFromFile();
        }
        return 0;
    }

    private void onGAudioNativeEvent(int i3, int i16, long j3, int i17, int i18, byte[] bArr, int i19, long j16, int i26) {
        int length;
        if (i3 == 170) {
            int i27 = (int) ((1099494850560L & j16) >> 24);
            int i28 = (int) ((16711680 & j16) >> 16);
            int i29 = (int) ((65280 & j16) >> 8);
            int i36 = (int) (j16 & 255);
            IMavAdapter iMavAdapter = this.mAdapter;
            if (iMavAdapter != null) {
                iMavAdapter.onReceiveAudio(bArr, i27, i28, i29, i36);
                return;
            }
            return;
        }
        if (this.mEventHandler != null) {
            MavNativeEventParams mavNativeEventParams = new MavNativeEventParams();
            mavNativeEventParams.detail = bArr;
            mavNativeEventParams.info = j16;
            mavNativeEventParams.groupId = j3;
            mavNativeEventParams.relationType = i16;
            mavNativeEventParams.multiAVType = i17;
            mavNativeEventParams.multiSubType = i18;
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            mavNativeEventParams.bufferLen = length;
            mavNativeEventParams.flag = i26;
            Message obtainMessage = this.mEventHandler.obtainMessage();
            if (obtainMessage != null) {
                obtainMessage.what = i3;
                obtainMessage.obj = mavNativeEventParams;
                this.mEventHandler.sendMessage(obtainMessage);
            }
        }
    }

    private synchronized String queryCameraParameters() {
        Context context;
        IMavAdapter iMavAdapter = this.mAdapter;
        if (iMavAdapter != null) {
            context = iMavAdapter.getContext();
        } else {
            context = null;
        }
        return CameraConfigHelper.getInstance(context).getCameraParameters();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void regCallbacks();

    private void sendGAudioCMD(long j3, long j16, byte[] bArr, boolean z16) {
        IMavNetChannel iMavNetChannel = this.mNetChannel;
        if (iMavNetChannel != null) {
            iMavNetChannel.sendMultiVideoMsg(j3, j16, bArr, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void AppCrased();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void AppDeadLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void AppWillTerminal();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void EnterBackGround();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void EnterFrontGround();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean NotifyBusinessExtInfo(String str, int i3, String str2, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int accept(int i3, long j3, int i16, int i17, int i18, int i19, int i26);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void changeAvRole(int i3, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void checkScreenShareAvaliable();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int commonRequest(int i3, long j3, int i16, int i17, int i18, int i19, int i26, String str, int i27, byte[] bArr, int i28);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int debugSwitch(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void enableAIDenoise(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void enableDumpAudioData(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void enableLocalSpeechRecognizeModel(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean enableLoopback(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native String getAVGQuality();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native String getAibotQualityReportInfo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getAudioScene();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long getEnterRoomTime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getInviteStrategy(long[] jArr, int i3, String[] strArr, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getNetLevel();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getNetState();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long getNetTrafficSize(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native String getNetWorkQualityRTT();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long getRoomId();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void getRoomUinOpenIdMap(long j3, long j16, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getRoomUserClientVersion(int i3, long j3, int i16, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getRoomUserTerminalType(int i3, long j3, int i16, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void getSign(long j3, int i3, long j16, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getVideoAbilityLevel();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getVolume();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int ignore(int i3, long j3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int init(Context context, String str, NtrtcAppParam ntrtcAppParam, NtrtcNetworkParam ntrtcNetworkParam, NtrtcAudioParam ntrtcAudioParam, NtrtcVideoParam ntrtcVideoParam, NtrtcCommonParam ntrtcCommonParam, NtrtcTerminalInfo ntrtcTerminalInfo);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int invite(int i3, String[] strArr, int i16, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean isEnableLoopback();

    native int kickOutPstnUsers();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void lockVideoMaxQP(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int modifyGroupAdmin(long j3, boolean z16);

    native int onRecvGAudioCMD(int i3, byte[] bArr, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native byte[] postData(long j3, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int quitRoom(int i3);

    @Override // com.tencent.avcore.netchannel.IMavNetCallback
    public void receiveGatewayMsg(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        } else {
            setNetIPAndPort(str, i3);
        }
    }

    @Override // com.tencent.avcore.netchannel.IMavNetCallback
    public int receiveMultiVideoMsg(int i3, byte[] bArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), bArr, Boolean.valueOf(z16))).intValue();
        }
        return onRecvGAudioCMD(i3, bArr, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int registerAudioDataCallback(int i3, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void registerOpenSdkApp(int i3, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int request(int i3, long j3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int requestCamera(int i3, long j3, int i16, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int requestMemPosInfoList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean sendGeneralRawChannelData(int i3, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int sendShareFrame2Native(byte[] bArr, int i3, int i16, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int sendShareFrame2NativeBmp(Bitmap bitmap, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void setAECMode(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int setApType(int i3);

    public void setAppId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mAppId = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int setAudioDataFormat(int i3, int i16, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int setAudioDataVolume(int i3, float f16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean setAudioNoiseCtrlParam(int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int setAudioOutputMode(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int setAudioScene(int i3);

    public void setEventListener(IMavEventListener iMavEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iMavEventListener);
            return;
        }
        this.mEventListener = iMavEventListener;
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            mainLooper = Looper.myLooper();
        }
        this.mEventHandler = new NativeEventHandler(mainLooper, iMavEventListener, this.mEventCallback);
    }

    native int setHowlingDetectEnable(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean setMicByAdmin(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean setMicMode(int i3);

    public void setNetChannel(IMavNetChannel iMavNetChannel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iMavNetChannel);
        } else {
            this.mNetChannel = iMavNetChannel;
            iMavNetChannel.setNetCallback(this);
        }
    }

    native int setNetIPAndPort(String str, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void setOpenSDKEnterRoomParam(OpenSDKEnterRoomParam openSDKEnterRoomParam);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void setQosParams(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int setShareEncParam(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void setVideoDataSendByDefault(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void setVideoDataSink(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int setVoiceType(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void spearAddParamByRole(int i3, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void spearClear(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int startAudioRecv();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int startAudioSend(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int startShareSend(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int startVideoRecv(String[] strArr, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int startVideoSend();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int stopAudioRecv();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int stopAudioSend(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int stopShareSend(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int stopVideoRecv();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int stopVideoSend();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int switchToAudioMode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void uninit();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int unregisterAudioDataCallback(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void unregisterOpenSdkApp(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int updateRoomInfo(int i3, long j3, int i16, boolean z16, boolean z17, boolean z18);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int updateRoomUserTerminalInfo(int i3, long j3, int i16, long j16, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class NativeEventHandler extends Handler {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "MavEngineJni_NativeEvent";
        protected final WeakReference<AVNativeEventProcessor> mCallback;
        protected final WeakReference<IMavEventListener> mEventLisRef;
        final EventCountLog mEventLogForFrameDec;
        private final RecordParam mShareRecordParam;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        static class EventCountLog {
            static IPatchRedirector $redirector_;
            int eventCount;
            long intervalMS;
            long logTime;
            String tag;

            EventCountLog(String str, long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
                    return;
                }
                this.logTime = 0L;
                this.eventCount = 0;
                this.tag = "EventCountLog_" + str;
                this.intervalMS = j3;
            }

            void log() {
                if (!AVCoreLog.isColorLevel()) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.eventCount++;
                long j3 = this.logTime;
                if (j3 < currentTimeMillis) {
                    long j16 = this.intervalMS;
                    long j17 = (currentTimeMillis + j16) - j3;
                    this.logTime = currentTimeMillis + j16;
                    AVCoreLog.i(this.tag, "EventCountLog, eventCount[" + this.eventCount + "], intervalMS[" + j17 + "]");
                    this.eventCount = 0;
                }
            }
        }

        NativeEventHandler(Looper looper, IMavEventListener iMavEventListener, AVNativeEventProcessor aVNativeEventProcessor) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, looper, iMavEventListener, aVNativeEventProcessor);
                return;
            }
            this.mEventLogForFrameDec = new EventCountLog(String.valueOf(61), 10000L);
            this.mShareRecordParam = new RecordParam();
            this.mEventLisRef = new WeakReference<>(iMavEventListener);
            this.mCallback = new WeakReference<>(aVNativeEventProcessor);
        }

        private void onChatMemberInfoChange(IMavEventListener iMavEventListener, int i3, byte[] bArr, long j3, long j16, int i16, int i17) {
            int i18;
            if (bArr == null) {
                if (i3 != 42 && i3 != 43) {
                    AVCoreLog.e(TAG, "onChatMemberInfoChange, empty detail");
                    return;
                }
                return;
            }
            String[] uinListFromBuf = MavJniUtil.getUinListFromBuf(bArr);
            if (uinListFromBuf == null) {
                AVCoreLog.e(TAG, "onChatMemberInfoChange getUinListFromBuf fail, empty uinList");
                return;
            }
            if (i3 != 42 && i3 != 43 && AVCoreLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                for (String str : uinListFromBuf) {
                    sb5.append("UserUin = ");
                    sb5.append(str);
                    sb5.append(", ");
                }
                sb5.append("eventid = ");
                sb5.append(i3);
                AVCoreLog.i(TAG, sb5.toString());
            }
            if (i3 == 42) {
                int i19 = (int) j3;
                if (i19 > 100) {
                    i18 = 100;
                } else if (i19 >= 0) {
                    i18 = i19;
                }
                iMavEventListener.onMultiVideoChatMembersInfoChange(j16, uinListFromBuf, i3, i17, j3, i16, i18);
            }
            i18 = 0;
            iMavEventListener.onMultiVideoChatMembersInfoChange(j16, uinListFromBuf, i3, i17, j3, i16, i18);
        }

        private void onRecPushEncParam(IMavEventListener iMavEventListener, int i3, long j3, long j16, int i16) {
            if (AVCoreLog.isDevelopLevel()) {
                AVCoreLog.d(TAG, "onRecPushEncParam, relationType[" + i3 + "], relationId[" + j3 + "], lValue[" + j16 + "], flag[" + i16 + "]");
            }
            RecordParam recordParam = this.mShareRecordParam;
            int i17 = recordParam.width;
            int i18 = recordParam.height;
            int i19 = recordParam.fps;
            recordParam.width = (int) ((j16 >> 32) & 4294967295L);
            recordParam.height = (int) (j16 & 4294967295L);
            recordParam.fps = i16;
            iMavEventListener.onRecSharePushEncParam(i3, j3, recordParam);
            if (AVCoreLog.isColorLevel()) {
                RecordParam recordParam2 = this.mShareRecordParam;
                if (i17 != recordParam2.width || i18 != recordParam2.height || i19 != recordParam2.fps) {
                    AVCoreLog.i(AVConstants.SHARE_TAG, "onRecPushEncParam, relationType[" + i3 + "], groupId[" + j3 + "], param[" + this.mShareRecordParam + "]");
                }
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:49:0x012d. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:51:0x0134. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:52:0x0137. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:53:0x013a. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:54:0x013d. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:55:0x0140. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:56:0x0143. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:318:0x0851 A[LOOP:0: B:316:0x084d->B:318:0x0851, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:332:0x0104  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            MavNativeEventParams mavNativeEventParams;
            int i3;
            AVNativeEventProcessor aVNativeEventProcessor;
            int i16;
            MavNativeEventParams mavNativeEventParams2;
            boolean z16;
            Message message2;
            String[] uinListFromBuf;
            int i17;
            String str;
            String[] strArr;
            ArrayList<AVUserInfo> arrayList;
            long j3;
            int i18;
            IMavEventListener iMavEventListener;
            int i19;
            boolean z17;
            long j16;
            boolean z18;
            boolean z19;
            int i26;
            Message message3;
            Message message4;
            int i27;
            IMavEventListener iMavEventListener2;
            int length;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message == null) {
                return;
            }
            MavNativeEventParams mavNativeEventParams3 = (MavNativeEventParams) message.obj;
            if (mavNativeEventParams3 == null) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(TAG, "handleMessage-->NativeEventParams is null");
                    return;
                }
                return;
            }
            IMavEventListener iMavEventListener3 = this.mEventLisRef.get();
            if (iMavEventListener3 == null) {
                AVNativeEventProcessor aVNativeEventProcessor2 = this.mCallback.get();
                if (aVNativeEventProcessor2 != null) {
                    aVNativeEventProcessor2.handleMessage(message);
                    return;
                }
                return;
            }
            int i28 = message.what;
            byte[] bArr = mavNativeEventParams3.detail;
            long j17 = mavNativeEventParams3.info;
            long j18 = mavNativeEventParams3.groupId;
            int i29 = mavNativeEventParams3.multiAVType;
            int i36 = mavNativeEventParams3.multiSubType;
            int i37 = mavNativeEventParams3.relationType;
            int i38 = mavNativeEventParams3.bufferLen;
            int i39 = mavNativeEventParams3.flag;
            if (i28 == 61) {
                this.mEventLogForFrameDec.log();
            } else if (i28 != 42 && i28 != 43 && i28 != 176 && AVCoreLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                mavNativeEventParams = mavNativeEventParams3;
                sb5.append("handleMessage, groupId[");
                sb5.append(j18);
                sb5.append("], multiAVType[");
                sb5.append(i29);
                sb5.append("], multiSubType[");
                sb5.append(i36);
                sb5.append("], relationType[");
                sb5.append(i37);
                sb5.append("], info[");
                sb5.append(j17);
                sb5.append("], detail[");
                if (bArr != null) {
                    i3 = bArr.length;
                } else {
                    i3 = -1;
                }
                sb5.append(i3);
                sb5.append("], eventId[");
                sb5.append(i28);
                sb5.append("], buflen[");
                sb5.append(i38);
                sb5.append("], flag[");
                sb5.append(i39);
                sb5.append("]");
                AVCoreLog.i(TAG, sb5.toString());
                aVNativeEventProcessor = this.mCallback.get();
                if (aVNativeEventProcessor == null) {
                    boolean isMsgNeedExtraDeal = aVNativeEventProcessor.isMsgNeedExtraDeal(i28);
                    i16 = i39;
                    if (isMsgNeedExtraDeal) {
                        z16 = isMsgNeedExtraDeal;
                        mavNativeEventParams2 = mavNativeEventParams;
                        mavNativeEventParams2.elapsedRealtime = SystemClock.elapsedRealtime();
                    } else {
                        z16 = isMsgNeedExtraDeal;
                        mavNativeEventParams2 = mavNativeEventParams;
                    }
                } else {
                    i16 = i39;
                    mavNativeEventParams2 = mavNativeEventParams;
                    z16 = false;
                }
                if (i28 == 5 && i28 != 6) {
                    if (i28 != 7) {
                        if (i28 != 8) {
                            String str2 = "";
                            if (i28 != 21) {
                                if (i28 != 22) {
                                    if (i28 != 121) {
                                        if (i28 != 122) {
                                            switch (i28) {
                                                case 11:
                                                    message2 = message;
                                                    iMavEventListener3.onGAudioRoomDestroy(i37, j18);
                                                    break;
                                                case 12:
                                                    message2 = message;
                                                    iMavEventListener3.onGAudioTerminalEnterRoom(i37, j18, i29);
                                                    break;
                                                default:
                                                    long j19 = 0;
                                                    switch (i28) {
                                                        case 18:
                                                            message2 = message;
                                                            if (bArr == null) {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_EMBED_CMD failed, empty detail");
                                                                return;
                                                            }
                                                            MavCommonPBMsg.MavCommonChannelInfo commonInfoByPbBuffer = MavCommonPBMsg.MavCommonChannelInfo.getCommonInfoByPbBuffer(bArr);
                                                            if (commonInfoByPbBuffer == null) {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_EMBED_CMD failed, empty MavCommonChannelInfo");
                                                                return;
                                                            } else {
                                                                iMavEventListener3.onRecvCommonChannelMsg(commonInfoByPbBuffer, j18, i28, i37, i29);
                                                                break;
                                                            }
                                                        case 39:
                                                            message2 = message;
                                                            iMavEventListener3.onGAudioSDKError(i37, j18, 15, (int) mavNativeEventParams2.info);
                                                            break;
                                                        case 61:
                                                            message2 = message;
                                                            String[] uinListFromBuf2 = MavJniUtil.getUinListFromBuf(bArr);
                                                            if (uinListFromBuf2 == null) {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA getUinListFromBuf fail, empty uinList");
                                                                return;
                                                            } else {
                                                                iMavEventListener3.onRemoteVideoDataComeIn(61, uinListFromBuf2[0], i37);
                                                                break;
                                                            }
                                                        case 84:
                                                            message2 = message;
                                                            iMavEventListener3.onShareOpsCallback(84, (int) j17, i37, j18, i29, i36);
                                                            break;
                                                        case 85:
                                                            message2 = message;
                                                            iMavEventListener3.onShareOpsCallback(85, (int) j17, i37, j18, i29, i36);
                                                            break;
                                                        case 86:
                                                            message2 = message;
                                                            iMavEventListener3.onShareOpsCallback(86, (int) j17, i37, j18, i29, i36);
                                                            break;
                                                        case 87:
                                                            message2 = message;
                                                            iMavEventListener3.onShareOpsCallback(87, (int) j17, i37, j18, i29, i36);
                                                            break;
                                                        case 88:
                                                            message2 = message;
                                                            iMavEventListener3.onShareOpsCallback(88, (int) j17, i37, j18, i29, i36);
                                                            break;
                                                        case 89:
                                                            message2 = message;
                                                            iMavEventListener3.onShareOpsCallback(89, (int) j17, i37, j18, i29, i36);
                                                            break;
                                                        case 90:
                                                        case 91:
                                                        case 92:
                                                            message2 = message;
                                                            iMavEventListener3.onGaGoOnStageResult(i28, j17, j18, i37);
                                                            break;
                                                        case 93:
                                                        case 94:
                                                        case 95:
                                                            message2 = message;
                                                            iMavEventListener3.onGaGoOffStageResult(i28, j17, j18, i37);
                                                            break;
                                                        case 96:
                                                        case 97:
                                                        case 98:
                                                            message2 = message;
                                                            iMavEventListener3.onGaSwitchVideoResult(i28, j17, j18, i37);
                                                            break;
                                                        case 138:
                                                        case 139:
                                                            message2 = message;
                                                            int i46 = (int) j17;
                                                            if (i46 != 3 && i46 != 15) {
                                                                if (i46 != 32) {
                                                                    int i47 = 35;
                                                                    if (i46 != 35) {
                                                                        if (i46 != 7) {
                                                                            if (i46 != 8) {
                                                                                i47 = 42;
                                                                                if (i46 != 42) {
                                                                                    if (i46 != 43) {
                                                                                        if (j17 > 200 && j17 < 300) {
                                                                                            if (bArr != null) {
                                                                                                str2 = new String(bArr);
                                                                                            }
                                                                                            j3 = j18;
                                                                                            iMavEventListener3.onGroupSecurityLimit(j3, j17, str2);
                                                                                            iMavEventListener = iMavEventListener3;
                                                                                            i18 = i29;
                                                                                            i19 = 0;
                                                                                        } else {
                                                                                            j3 = j18;
                                                                                            iMavEventListener = iMavEventListener3;
                                                                                            i19 = i46;
                                                                                            i18 = i29;
                                                                                        }
                                                                                    } else {
                                                                                        j3 = j18;
                                                                                        i18 = i29;
                                                                                        i19 = 43;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                j3 = j18;
                                                                                i18 = i29;
                                                                                iMavEventListener = iMavEventListener3;
                                                                                if (i37 == 1) {
                                                                                    i19 = 1;
                                                                                }
                                                                                i19 = 0;
                                                                            }
                                                                        } else {
                                                                            j3 = j18;
                                                                            i18 = i29;
                                                                            iMavEventListener = iMavEventListener3;
                                                                            i19 = 2;
                                                                        }
                                                                    }
                                                                    j3 = j18;
                                                                    i18 = i29;
                                                                    iMavEventListener = iMavEventListener3;
                                                                    i19 = i47;
                                                                } else {
                                                                    j3 = j18;
                                                                    i18 = i29;
                                                                    i19 = 7;
                                                                }
                                                                iMavEventListener = iMavEventListener3;
                                                            } else {
                                                                j3 = j18;
                                                                i18 = i29;
                                                                iMavEventListener = iMavEventListener3;
                                                                i19 = 3;
                                                            }
                                                            if (i19 != 0) {
                                                                iMavEventListener.onGroupVideoClosed(i37, j3, i19, i18);
                                                                break;
                                                            }
                                                            break;
                                                        case 140:
                                                        case 141:
                                                            message2 = message;
                                                            byte[] bArr2 = mavNativeEventParams2.detail;
                                                            if (bArr2 == null) {
                                                                AVCoreLog.e(TAG, "handleMessage failed, eventId:" + i28 + ", empty detail");
                                                                return;
                                                            }
                                                            AVUserInfo aVInfoFromByte = MavJniUtil.getAVInfoFromByte(bArr2);
                                                            if (i28 == 140) {
                                                                z17 = true;
                                                            } else {
                                                                z17 = false;
                                                            }
                                                            if (aVInfoFromByte != null) {
                                                                if (AVCoreLog.isColorLevel()) {
                                                                    AVCoreLog.e(TAG, "MemberAudioChange, uin[" + aVInfoFromByte.account + "], accountType[" + aVInfoFromByte.accountType + "], isMicOff[" + z17 + "]");
                                                                }
                                                                iMavEventListener3.onGAudioMemberMicChanged(aVInfoFromByte.account, aVInfoFromByte.accountType, aVInfoFromByte.pstnStatus, z17);
                                                                break;
                                                            }
                                                            break;
                                                        case 142:
                                                            message2 = message;
                                                            byte[] bArr3 = mavNativeEventParams2.detail;
                                                            if (bArr3 != null && bArr3.length == 8) {
                                                                j16 = MavJniUtil.getLongFromByte(bArr3);
                                                            } else {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_MEETINGCONTROLMODE_CHANGE, invalid detail");
                                                                j16 = 0;
                                                            }
                                                            if (j17 != 0) {
                                                                z18 = true;
                                                            } else {
                                                                z18 = false;
                                                            }
                                                            iMavEventListener3.onGAudioRoomMicModeChanged(j16, z18, false);
                                                            break;
                                                        case 143:
                                                            message2 = message;
                                                            int i48 = (int) j17;
                                                            byte[] bArr4 = mavNativeEventParams2.detail;
                                                            if (bArr4 != null && bArr4.length == 8) {
                                                                j19 = MavJniUtil.getLongFromByte(bArr4);
                                                            } else {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_SETMICBYADMIN_NOTIFY, invalid detail");
                                                            }
                                                            long j26 = j19;
                                                            if (AVCoreLog.isColorLevel()) {
                                                                AVCoreLog.i(TAG, "SetMicByAdmin : uin = " + j26 + ", micAuthByAdmin = " + i48);
                                                            }
                                                            iMavEventListener3.onGAudioMicSetByAdmin(j26, i48);
                                                            break;
                                                        case 144:
                                                            message2 = message;
                                                            int i49 = (int) j17;
                                                            byte[] bArr5 = mavNativeEventParams2.detail;
                                                            if (bArr5 != null && i49 != 0) {
                                                                ArrayList<AVUserInfo> aVInfoListFromByte = MavJniUtil.getAVInfoListFromByte(bArr5);
                                                                if (aVInfoListFromByte != null && aVInfoListFromByte.size() == i49) {
                                                                    iMavEventListener3.onGAudioSetMicFailed(i49, aVInfoListFromByte);
                                                                    break;
                                                                } else {
                                                                    AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_SETMICFAIL_NOTIFY getAVInfoListFromByte invalid userInfos");
                                                                    return;
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                            break;
                                                        case 145:
                                                            message2 = message;
                                                            byte[] bArr6 = mavNativeEventParams2.detail;
                                                            if (bArr6 != null && bArr6.length == 16) {
                                                                long longFromByte = MavJniUtil.getLongFromByte(bArr6);
                                                                byte[] bArr7 = new byte[4];
                                                                System.arraycopy(mavNativeEventParams2.detail, 12, bArr7, 0, 4);
                                                                int intFromByte = MavJniUtil.getIntFromByte(bArr7);
                                                                if (j17 == 1) {
                                                                    z19 = true;
                                                                } else {
                                                                    z19 = false;
                                                                }
                                                                if (AVCoreLog.isColorLevel()) {
                                                                    AVCoreLog.i(TAG, "onGAudioUserAudioSuspectNoisy : uin = " + longFromByte + ", isSuspectNoisy = " + z19 + ",validDuration = " + intFromByte);
                                                                }
                                                                iMavEventListener3.onGAudioUserAudioSuspectNoisy(longFromByte, z19, intFromByte);
                                                                break;
                                                            } else {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_DETECT_USER_AUDIO_NOISY, invalid detail");
                                                                return;
                                                            }
                                                            break;
                                                        case 153:
                                                            message2 = message;
                                                            iMavEventListener3.onHowling();
                                                            break;
                                                        case 154:
                                                            message2 = message;
                                                            int i56 = (int) (j17 & 4294967295L);
                                                            int i57 = (int) (4294967295L & (j17 >> 32));
                                                            if (AVCoreLog.isDevelopLevel()) {
                                                                StringBuilder sb6 = new StringBuilder();
                                                                sb6.append("EM_SDK_EVENT_ID_CAMERA_REOPEN, relationType[");
                                                                sb6.append(i37);
                                                                sb6.append("], relationId[");
                                                                sb6.append(j18);
                                                                sb6.append("], h2[");
                                                                sb6.append(i56);
                                                                sb6.append("], w2[");
                                                                sb6.append(i57);
                                                                sb6.append("],  flag[");
                                                                i26 = i16;
                                                                sb6.append(i26);
                                                                sb6.append("]");
                                                                AVCoreLog.d(TAG, sb6.toString());
                                                            } else {
                                                                i26 = i16;
                                                            }
                                                            iMavEventListener3.onCameraSettingNotify(i57, i56, i26);
                                                            break;
                                                        case 157:
                                                            message2 = message;
                                                            if (bArr != null) {
                                                                iMavEventListener3.onSetMicBySelf(MavJniUtil.getLongFromByte(bArr));
                                                                break;
                                                            } else {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_MICOFFBYSELF_NOTIFY, invalid detail");
                                                                break;
                                                            }
                                                        case 158:
                                                            message2 = message;
                                                            iMavEventListener3.onOpenMicFail();
                                                            break;
                                                        case 162:
                                                            message2 = message;
                                                            iMavEventListener3.onChangeRole((int) j17, "");
                                                            break;
                                                        case 171:
                                                            message2 = message;
                                                            if (j17 != 0) {
                                                                iMavEventListener3.onFpsChange((int) j17);
                                                                break;
                                                            }
                                                            break;
                                                        case 172:
                                                            message2 = message;
                                                            if (bArr != null) {
                                                                iMavEventListener3.onGVideoDownloadChannelCtlChanged(bArr);
                                                                break;
                                                            }
                                                            break;
                                                        case 173:
                                                            message2 = message;
                                                            iMavEventListener3.onChangeAuthority((int) j17, "");
                                                            break;
                                                        case 176:
                                                            message2 = message;
                                                            iMavEventListener3.onSelfAudioVolumeChange(j17);
                                                            break;
                                                        case 177:
                                                            message2 = message;
                                                            onRecPushEncParam(iMavEventListener3, i37, j18, j17, i16);
                                                            break;
                                                        case 178:
                                                            message3 = message;
                                                            iMavEventListener3.onCheckScreenShareAvailable((int) j17, bArr);
                                                            message2 = message3;
                                                            break;
                                                        case 179:
                                                            message3 = message;
                                                            iMavEventListener3.onInitAIDenoiseStatus();
                                                            message2 = message3;
                                                            break;
                                                        case 182:
                                                            message3 = message;
                                                            if (bArr == null) {
                                                                AVCoreLog.e(TAG, "handleMessage EM_SDK_EVENT_ID_NOTIFY_EXT_BUSINESS_INFO empty detail");
                                                                return;
                                                            }
                                                            AVUserInfo aVInfoFromByte2 = MavJniUtil.getAVInfoFromByte(bArr);
                                                            if (aVInfoFromByte2 == null) {
                                                                AVCoreLog.e(TAG, "handleMessage EM_SDK_EVENT_ID_NOTIFY_EXT_BUSINESS_INFO fail, empty userInfo");
                                                                return;
                                                            } else {
                                                                iMavEventListener3.onNotifyBusinessExtInfo(aVInfoFromByte2, j18, i28, i37, j17, i29);
                                                                message2 = message3;
                                                                break;
                                                            }
                                                        case 183:
                                                            message3 = message;
                                                            if (bArr == null) {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_GET_UIN_OPENID_MAP_RSP failed, empty detail");
                                                                return;
                                                            }
                                                            UinOpenIdResponse uinOpenIdResponseByPbBuffer = UinOpenIdResponse.getUinOpenIdResponseByPbBuffer(bArr);
                                                            if (uinOpenIdResponseByPbBuffer == null) {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_GET_UIN_OPENID_MAP_RSP failed, empty UinOpenIdResponse");
                                                                return;
                                                            } else {
                                                                iMavEventListener3.onGetUinOpenIdRespond(uinOpenIdResponseByPbBuffer, j18, i28, i37, j17, i29);
                                                                message2 = message3;
                                                                break;
                                                            }
                                                        case 184:
                                                            message3 = message;
                                                            if (bArr == null) {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_GET_SIGN_RSP failed, empty detail");
                                                                return;
                                                            }
                                                            GetSignResponse getSignResponseByPbBuffer = GetSignResponse.getGetSignResponseByPbBuffer(bArr);
                                                            if (getSignResponseByPbBuffer == null) {
                                                                AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_GET_SIGN_RSP failed, empty GetSignResponse");
                                                                return;
                                                            } else {
                                                                iMavEventListener3.onGetSignRespond(getSignResponseByPbBuffer, j18, i28, i37, j17, i29);
                                                                message2 = message3;
                                                                break;
                                                            }
                                                        case 188:
                                                            message3 = message;
                                                            iMavEventListener3.onNotifyCommonTips((int) j17, bArr);
                                                            message2 = message3;
                                                            break;
                                                        case 189:
                                                            message3 = message;
                                                            iMavEventListener3.onGeneralRawChannelData(j18, i29, i37, j17, bArr);
                                                            message2 = message3;
                                                            break;
                                                        default:
                                                            switch (i28) {
                                                                case 30:
                                                                    message4 = message;
                                                                    iMavEventListener3.onCreateRoomSuc(i37, j18, i29);
                                                                    message2 = message4;
                                                                    break;
                                                                case 31:
                                                                case 32:
                                                                    message4 = message;
                                                                    iMavEventListener3.onGAudioSDKError(i37, j18, 17, (int) mavNativeEventParams2.info);
                                                                    message2 = message4;
                                                                    break;
                                                                case 33:
                                                                    message4 = message;
                                                                    iMavEventListener3.onEnterSuc(j18, i37, i29);
                                                                    message2 = message4;
                                                                    break;
                                                                case 34:
                                                                case 35:
                                                                    message4 = message;
                                                                    iMavEventListener3.onGAudioSDKError(i37, j18, 16, (int) mavNativeEventParams2.info);
                                                                    message2 = message4;
                                                                    break;
                                                                default:
                                                                    switch (i28) {
                                                                        case 42:
                                                                        case 43:
                                                                            i27 = i29;
                                                                            iMavEventListener2 = iMavEventListener3;
                                                                            message4 = message;
                                                                            onChatMemberInfoChange(iMavEventListener2, i28, bArr, j17, j18, i27, i37);
                                                                            message2 = message4;
                                                                            break;
                                                                        case 44:
                                                                            String[] uinListFromBuf3 = MavJniUtil.getUinListFromBuf(bArr);
                                                                            if (uinListFromBuf3 == null) {
                                                                                length = 0;
                                                                            } else {
                                                                                length = uinListFromBuf3.length;
                                                                            }
                                                                            onRecvUserList(iMavEventListener3, 44, i37, j18, uinListFromBuf3, "", i29, 0, length, i16);
                                                                            message2 = message;
                                                                            break;
                                                                        case 45:
                                                                            message3 = message;
                                                                            iMavEventListener3.onGAudioKickOut(j18, i37, i29);
                                                                            message2 = message3;
                                                                            break;
                                                                        default:
                                                                            switch (i28) {
                                                                                case 70:
                                                                                case 71:
                                                                                    message3 = message;
                                                                                    if (bArr == null) {
                                                                                        AVCoreLog.e(TAG, "handleMessage, eventId:" + i28 + " empty detail");
                                                                                        return;
                                                                                    }
                                                                                    AVUserInfo aVInfoFromByte3 = MavJniUtil.getAVInfoFromByte(bArr);
                                                                                    if (aVInfoFromByte3 == null) {
                                                                                        AVCoreLog.e(TAG, "handleMessage, eventId:" + i28 + " getAVInfoFromByte fail, empty userInfo");
                                                                                        return;
                                                                                    }
                                                                                    int i58 = aVInfoFromByte3.accountType;
                                                                                    if (i58 == 0 || ((i58 == 1 && aVInfoFromByte3.pstnStatus == 3 && i28 == 70) || (i58 == 1 && i28 == 71))) {
                                                                                        iMavEventListener3.onMAVMemberInOrOut(aVInfoFromByte3, j18, i28, i37, j17, i29);
                                                                                    }
                                                                                    message2 = message3;
                                                                                    break;
                                                                                case 72:
                                                                                case 73:
                                                                                case 74:
                                                                                case 75:
                                                                                case 76:
                                                                                case 77:
                                                                                case 78:
                                                                                case 79:
                                                                                    iMavEventListener2 = iMavEventListener3;
                                                                                    i27 = i29;
                                                                                    message4 = message;
                                                                                    onChatMemberInfoChange(iMavEventListener2, i28, bArr, j17, j18, i27, i37);
                                                                                    message2 = message4;
                                                                                    break;
                                                                                default:
                                                                                    switch (i28) {
                                                                                        default:
                                                                                            switch (i28) {
                                                                                                case 107:
                                                                                                case 108:
                                                                                                    break;
                                                                                                case 109:
                                                                                                    message3 = message;
                                                                                                    if (bArr != null && bArr.length >= 8) {
                                                                                                        if (i37 != 1 && i37 != 6) {
                                                                                                            AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE, invalid relationType" + i37);
                                                                                                        } else {
                                                                                                            AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE, care EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE event relationType" + i37);
                                                                                                            long longFromByte2 = MavJniUtil.getLongFromByte(bArr);
                                                                                                            AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE, relationType:" + i37 + " uin:" + longFromByte2 + " videoSrcType:" + j17);
                                                                                                            if (i29 != 10) {
                                                                                                                iMavEventListener3.onVideoSrcChange((int) j17, i37, longFromByte2, j18);
                                                                                                            }
                                                                                                        }
                                                                                                        message2 = message3;
                                                                                                        break;
                                                                                                    } else {
                                                                                                        AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE, invalid detail");
                                                                                                        return;
                                                                                                    }
                                                                                                    break;
                                                                                                case 110:
                                                                                                    message3 = message;
                                                                                                    if (bArr != null && bArr.length >= 8) {
                                                                                                        iMavEventListener3.onPPTInOrOut(j18, MavJniUtil.getLongFromByte(bArr), i37, (int) j17);
                                                                                                        message2 = message3;
                                                                                                        break;
                                                                                                    } else {
                                                                                                        AVCoreLog.e(TAG, "EM_SDK_EVENT_ID_PPT_UPLOAD_STATE, invalid detail");
                                                                                                        return;
                                                                                                    }
                                                                                                default:
                                                                                                    if (aVNativeEventProcessor != null) {
                                                                                                        message3 = message;
                                                                                                        aVNativeEventProcessor.handleMessage(message3);
                                                                                                        message2 = message3;
                                                                                                        break;
                                                                                                    }
                                                                                            }
                                                                                            break;
                                                                                        case 101:
                                                                                        case 102:
                                                                                        case 103:
                                                                                        case 104:
                                                                                            message3 = message;
                                                                                            iMavEventListener3.onGroupChatModeChange(j18, i37, i28);
                                                                                            message2 = message3;
                                                                                            break;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                                case 13:
                                                    message2 = message;
                                                    break;
                                            }
                                        } else {
                                            message2 = message;
                                            iMavEventListener3.onDetectAudioDataIssue(4);
                                        }
                                    } else {
                                        message2 = message;
                                        iMavEventListener3.onDetectAudioDataIssue(3);
                                    }
                                } else {
                                    message2 = message;
                                    if (bArr != null) {
                                        str2 = new String(bArr);
                                    }
                                    iMavEventListener3.onKickOutFail(j18, i37, i29, (int) j17, str2);
                                }
                            } else {
                                message2 = message;
                                if (bArr != null) {
                                    str2 = new String(bArr);
                                }
                                iMavEventListener3.onKickOutSuc(j18, i37, i29, (int) j17, str2);
                            }
                        } else {
                            message2 = message;
                            int i59 = (int) j17;
                            if (i59 >= 0) {
                                if (i59 > 0) {
                                    arrayList = MavJniUtil.getAVInfoListFromByte(bArr);
                                } else {
                                    arrayList = null;
                                }
                                ArrayList<AVUserInfo> arrayList2 = arrayList;
                                if (arrayList2 != null) {
                                    onRecvUserList(iMavEventListener3, 44, i37, j18, arrayList2, 0L, 0, i29, i59);
                                } else {
                                    onRecvUserListFail(iMavEventListener3, i37, j18, -99L);
                                }
                            } else {
                                onRecvUserListFail(iMavEventListener3, i37, j18, i59);
                            }
                        }
                    }
                    message2 = message;
                } else {
                    int i65 = i16;
                    message2 = message;
                    uinListFromBuf = MavJniUtil.getUinListFromBuf(bArr);
                    i17 = 0;
                    str = uinListFromBuf[0];
                    int length2 = uinListFromBuf.length - 1;
                    strArr = new String[length2];
                    while (i17 < uinListFromBuf.length - 1) {
                        int i66 = i17 + 1;
                        strArr[i17] = uinListFromBuf[i66];
                        i17 = i66;
                    }
                    if (i37 == 2 && i37 != 1 && (i37 != 11 || i29 != 17)) {
                        if (i37 == 3) {
                            onRecvDoubleVideoMeeting(iMavEventListener3, i28, i37, str, i29, i36);
                        }
                    } else {
                        onRecvUserList(iMavEventListener3, 6, i37, j18, strArr, str, i29, i36, length2, i65);
                    }
                }
                if (!z16 && aVNativeEventProcessor != null) {
                    aVNativeEventProcessor.handleMessage(message2);
                    return;
                }
            }
            mavNativeEventParams = mavNativeEventParams3;
            aVNativeEventProcessor = this.mCallback.get();
            if (aVNativeEventProcessor == null) {
            }
            if (i28 == 5) {
            }
            int i652 = i16;
            message2 = message;
            uinListFromBuf = MavJniUtil.getUinListFromBuf(bArr);
            i17 = 0;
            str = uinListFromBuf[0];
            int length22 = uinListFromBuf.length - 1;
            strArr = new String[length22];
            while (i17 < uinListFromBuf.length - 1) {
            }
            if (i37 == 2) {
            }
            onRecvUserList(iMavEventListener3, 6, i37, j18, strArr, str, i29, i36, length22, i652);
            if (!z16) {
            }
        }

        void onRecvDoubleVideoMeeting(IMavEventListener iMavEventListener, int i3, int i16, String str, int i17, int i18) {
            if (iMavEventListener == null) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(TAG, "onRecvDoubleVideoMeeting-->mVideoController is null");
                    return;
                }
                return;
            }
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i(TAG, "onRecvDoubleVideoMeeting-->eventId=" + i3 + " ,relationType=" + i16 + " ,inviteUin=" + str + "], multiAVType[" + i17 + "], multiSubType[" + i18);
            }
            if (i3 == 6) {
                iMavEventListener.onDoubleVideoMeetingInvite(str, i17, i18);
            } else if (i3 != 44 && i3 == 5) {
                iMavEventListener.onDoubleVideoMeetingInvite(str, i17, i18);
            }
        }

        void onRecvUserList(IMavEventListener iMavEventListener, int i3, int i16, long j3, ArrayList<AVUserInfo> arrayList, long j16, int i17, int i18, int i19) {
            if (iMavEventListener == null) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.i(TAG, "onRecvUserList --> mVideoController is null");
                    return;
                }
                return;
            }
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i(TAG, "onRecvUserList.GET_ROOM_INFO, evtId[" + i3 + "], relationType[" + i16 + "], relationId[" + j3 + "], inviteUin[" + j16 + "], multiAVType[" + i18 + "], multiSubType[" + i17 + "], userCount[" + i19 + "]");
            }
            if (i3 == 44) {
                iMavEventListener.onGAudioMemAllUpdate(j3, arrayList, i18, i19);
            } else if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "onRecvUserList --> WRONG EVTID. evtId = " + i3);
            }
        }

        void onRecvUserListFail(IMavEventListener iMavEventListener, int i3, long j3, long j16) {
            AVCoreLog.e(TAG, "onRecvUserListFail, relationType[" + i3 + "], relationId[" + j3 + "], errCode[" + j16 + "]");
            iMavEventListener.onGAudioRoomDestroy(i3, j3);
        }

        void onRecvUserList(IMavEventListener iMavEventListener, int i3, int i16, long j3, String[] strArr, String str, int i17, int i18, int i19, int i26) {
            if (iMavEventListener == null) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(TAG, "onRecvUserList-->mVideoController is null");
                    return;
                }
                return;
            }
            int length = strArr != null ? strArr.length : 0;
            if (AVCoreLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onRecvUserList, evtId[");
                sb5.append(i3);
                sb5.append("], relationType[");
                sb5.append(i16);
                sb5.append("], relationId[");
                sb5.append(j3);
                sb5.append("], inviteUin[");
                sb5.append(str);
                sb5.append("], multiAVType[");
                sb5.append(i17);
                sb5.append("], multiSubType[");
                sb5.append(i18);
                sb5.append("], userListSize[");
                sb5.append(length);
                sb5.append("], userList[");
                sb5.append(strArr != null);
                sb5.append("], flag[");
                sb5.append(i26);
                sb5.append("]");
                AVCoreLog.i(TAG, sb5.toString());
            }
            if (strArr == null && i16 == 2) {
                return;
            }
            if (i3 == 44) {
                iMavEventListener.onGAudioMemAllUpdate(j3, strArr, i17, i19);
            } else if (i3 == 6) {
                iMavEventListener.onGAudioInvite(i16, j3, str, strArr, false, i17, i18, i26);
            } else if (i3 == 5) {
                iMavEventListener.onGAudioInvite(i16, j3, str, strArr, true, i17, i18, i26);
            }
        }
    }
}
