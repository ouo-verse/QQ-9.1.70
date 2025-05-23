package com.tencent.avcore.jni.dav;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.config.CameraConfigHelper;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.engine.dav.IDavAdapter;
import com.tencent.avcore.engine.dav.IDavEventListener;
import com.tencent.avcore.jni.data.NtrtcAppParam;
import com.tencent.avcore.jni.data.NtrtcAudioParam;
import com.tencent.avcore.jni.data.NtrtcCommonParam;
import com.tencent.avcore.jni.data.NtrtcNetworkParam;
import com.tencent.avcore.jni.data.NtrtcTerminalInfo;
import com.tencent.avcore.jni.data.NtrtcVideoParam;
import com.tencent.avcore.jni.net.NetInterfaceJni;
import com.tencent.avcore.netchannel.IDavNetCallback;
import com.tencent.avcore.netchannel.IDavNetChannel;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.GlStringParser;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public class NtrtcEngine implements IDavNetCallback {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "NtrtcEngine";
    public static boolean sDisableReOpen;
    private static volatile NtrtcEngine sInstance;
    private IDavAdapter mAdapter;
    private NtrtcEngineCallbackImplWrapper mCallbackWrapper;
    private Handler mEventHandler;
    private IDavEventListener mEventListener;
    private GlStringParser mGlStringParser;
    private boolean mIsJavaInitedOk;
    private IDavNetChannel mNetChannel;
    private AVCoreSystemInfo mSysInfo;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            sDisableReOpen = false;
            sInstance = null;
        }
    }

    NtrtcEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsJavaInitedOk = false;
            this.mCallbackWrapper = null;
        }
    }

    private static native void cacheMethodIds();

    private int callbackGetAPAndGateWayIP() {
        IDavEventListener iDavEventListener = this.mEventListener;
        if (iDavEventListener != null) {
            return iDavEventListener.getAPAndGateWayIP();
        }
        return -1;
    }

    private String callbackGetCustomInfo(long j3, String str) {
        IDavAdapter iDavAdapter = this.mAdapter;
        if (iDavAdapter != null) {
            return iDavAdapter.getCustomInfo(j3, str);
        }
        return "";
    }

    private long callbackGetMSFInviteMessageTimeStamp(long j3) {
        IDavEventListener iDavEventListener = this.mEventListener;
        if (iDavEventListener != null) {
            return iDavEventListener.getMSFInviteMessageTimeStamp(j3);
        }
        return 0L;
    }

    private void callbackSendConfigReq(byte[] bArr) {
        IDavNetChannel iDavNetChannel = this.mNetChannel;
        if (iDavNetChannel != null) {
            iDavNetChannel.sendGetVideoConfig(bArr);
        } else if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "callbackSendConfigReq, net channel is null.");
        }
    }

    private void callbackTcpSendSSOCMD(byte[] bArr, int i3, long j3) {
        IDavNetChannel iDavNetChannel = this.mNetChannel;
        if (iDavNetChannel != null) {
            iDavNetChannel.SendSharpVideoMsgBySSOChannel(i3, j3, bArr);
        } else if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "callbackSSOChannel, net channel is null.");
        }
    }

    private void callbackTcpSendSharpCMD(byte[] bArr, long j3) {
        IDavNetChannel iDavNetChannel = this.mNetChannel;
        if (iDavNetChannel != null) {
            iDavNetChannel.sendSharpVideoMsgByJCEChannel(j3, bArr);
        } else if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "callbackJCEChannel, net channel is null.");
        }
    }

    private void changePreviewSize(int i3, int i16) {
        Context context;
        if (this.mGlStringParser == null) {
            this.mGlStringParser = new GlStringParser('=', ';');
        }
        IDavAdapter iDavAdapter = this.mAdapter;
        if (iDavAdapter != null) {
            context = iDavAdapter.getContext();
        } else {
            context = null;
        }
        this.mGlStringParser.unflatten(CameraConfigHelper.getInstance(context).getCameraParameters());
        String str = this.mGlStringParser.get("preview-size-values");
        if (str != null) {
            if (str.contains(i3 + HippyTKDListViewAdapter.X + i16)) {
                postRunable(new Runnable(i3, i16) { // from class: com.tencent.avcore.jni.dav.NtrtcEngine.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$h;
                    final /* synthetic */ int val$w;

                    {
                        this.val$w = i3;
                        this.val$h = i16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, NtrtcEngine.this, Integer.valueOf(i3), Integer.valueOf(i16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (NtrtcEngine.sDisableReOpen) {
                            AVCoreLog.e(NtrtcEngine.TAG, "changePreviewSize, \u7981\u6b62\u54cd\u5e94\u91cd\u5f00\u6444\u50cf\u5934, w[" + this.val$w + "], h[" + this.val$h + "]");
                            return;
                        }
                        if (NtrtcEngine.this.mEventListener != null) {
                            NtrtcEngine.this.mEventListener.onChangePreviewSize(this.val$w, this.val$h);
                        }
                    }
                });
                return;
            }
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "changePreviewSize, \u4e0d\u5305\u542b\u8be5\u5206\u8fa8\u7387, w[" + i3 + "], h[" + i16 + "]");
        }
    }

    public static void destroyInstance() {
        if (sInstance != null) {
            synchronized (NtrtcEngine.class) {
                NtrtcRoom.destroyInstance();
                NtrtcAudio.destroyInstance();
                NtrtcVideo.destroyInstance();
                NtrtcSession.destroyInstance();
                NtrtcUtil.destroyInstance();
                sInstance = null;
            }
        }
    }

    public static NtrtcEngine getInstance() {
        if (sInstance == null) {
            synchronized (NtrtcEngine.class) {
                if (sInstance == null) {
                    sInstance = new NtrtcEngine();
                }
            }
        }
        return sInstance;
    }

    private String queryCameraParameters() {
        Context context;
        IDavAdapter iDavAdapter = this.mAdapter;
        if (iDavAdapter != null) {
            context = iDavAdapter.getContext();
        } else {
            context = null;
        }
        return CameraConfigHelper.getInstance(context).getCameraParameters();
    }

    protected boolean IsJavaInitedOk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mIsJavaInitedOk;
    }

    native int init(Context context, String str, NtrtcAppParam ntrtcAppParam, NtrtcNetworkParam ntrtcNetworkParam, NtrtcAudioParam ntrtcAudioParam, NtrtcVideoParam ntrtcVideoParam, NtrtcCommonParam ntrtcCommonParam, NtrtcTerminalInfo ntrtcTerminalInfo, NtrtcEngineCallback ntrtcEngineCallback);

    public int init(Context context, String str, NtrtcAppParam ntrtcAppParam, NtrtcNetworkParam ntrtcNetworkParam, NtrtcAudioParam ntrtcAudioParam, NtrtcVideoParam ntrtcVideoParam, NtrtcCommonParam ntrtcCommonParam, NtrtcEngineCallback ntrtcEngineCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, context, str, ntrtcAppParam, ntrtcNetworkParam, ntrtcAudioParam, ntrtcVideoParam, ntrtcCommonParam, ntrtcEngineCallback)).intValue();
        }
        NetInterfaceJni.getInstance().init(context);
        NtrtcTerminalInfo ntrtcTerminalInfo = new NtrtcTerminalInfo(this.mSysInfo, ntrtcCommonParam.isPadForMultiDeviceLogin);
        if (ntrtcEngineCallback != null) {
            NtrtcEngineCallbackImplWrapper ntrtcEngineCallbackImplWrapper = new NtrtcEngineCallbackImplWrapper();
            this.mCallbackWrapper = ntrtcEngineCallbackImplWrapper;
            ntrtcEngineCallbackImplWrapper.setBusiCallback(ntrtcEngineCallback);
        }
        return init(context, str, ntrtcAppParam, ntrtcNetworkParam, ntrtcAudioParam, ntrtcVideoParam, ntrtcCommonParam, ntrtcTerminalInfo, this.mCallbackWrapper);
    }

    public void initContext(Context context, IDavNetChannel iDavNetChannel, IDavAdapter iDavAdapter, IDavEventListener iDavEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, iDavNetChannel, iDavAdapter, iDavEventListener);
            return;
        }
        this.mNetChannel = iDavNetChannel;
        iDavNetChannel.setNetCallback(this);
        this.mSysInfo = new AVCoreSystemInfo();
        this.mAdapter = iDavAdapter;
        this.mEventListener = iDavEventListener;
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            mainLooper = Looper.myLooper();
        }
        this.mEventHandler = new Handler(mainLooper);
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.mSysInfo.setScreenSize(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels), Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels));
        }
        boolean loadLibrary = this.mAdapter.loadLibrary();
        this.mIsJavaInitedOk = loadLibrary;
        if (!loadLibrary) {
            return;
        }
        this.mAdapter.initTABSDK();
        this.mAdapter.initConfig();
        this.mAdapter.initClientLogReport();
        this.mAdapter.initBeaconReporter();
        cacheMethodIds();
    }

    public native int notifyAnotherSelfIsRing(long j3, boolean z16);

    public native int notifyAnotherTerChatStatus(long j3, int i3);

    public native void onProcessExit();

    /* JADX INFO: Access modifiers changed from: protected */
    public void postRunable(Runnable runnable) {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) runnable);
        } else if (runnable != null && (handler = this.mEventHandler) != null) {
            handler.post(runnable);
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetCallback
    public void receiveGatewayMsg(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
        } else {
            setNetIpAndPort(str, i3);
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetCallback
    public byte receiveSharpVideoAck(long j3, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Byte) iPatchRedirector.redirect((short) 21, this, Long.valueOf(j3), bArr, bArr2)).byteValue();
        }
        if (NtrtcSession.getInstance().receiveSharpVideoAck(bArr) >= 0) {
            return (byte) 0;
        }
        return (byte) -1;
    }

    @Override // com.tencent.avcore.netchannel.IDavNetCallback
    public byte receiveSharpVideoCall(long j3, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Byte) iPatchRedirector.redirect((short) 20, this, Long.valueOf(j3), bArr, bArr2)).byteValue();
        }
        if (NtrtcSession.getInstance().receiveSharpVideoCall(bArr) >= 0) {
            return (byte) 0;
        }
        return (byte) -1;
    }

    public native void setAgreeUseCellularForQuality(boolean z16);

    public native int setApType(int i3);

    public native void setCarrierType(long j3, String str, String str2);

    public native int setGatewayTestResult(int i3, int i16, int i17);

    public native int setNetIpAndPort(String str, int i3);

    public native int setSelfUin(long j3);

    public void uninit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mEventListener = null;
        NetInterfaceJni.getInstance().unInit();
        uninitNative();
        NtrtcEngineCallbackImplWrapper ntrtcEngineCallbackImplWrapper = this.mCallbackWrapper;
        if (ntrtcEngineCallbackImplWrapper != null) {
            ntrtcEngineCallbackImplWrapper.setBusiCallback(null);
            this.mCallbackWrapper = null;
        }
    }

    native int uninitNative();

    public native void updateForeBackgroundFlag(long j3, boolean z16);

    public native int updateNetworkTestResult(long j3, int i3);

    public boolean useVideoConfigPolicyOfServer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.mAdapter.useVideoConfigPolicyOfServer();
    }
}
