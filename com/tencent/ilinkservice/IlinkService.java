package com.tencent.ilinkservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ilink.dev.proto.IlinkDevApi;
import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.tdi.IlinktdiInterfaceManager;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.ilinkservice.IIlinkServiceInterface;
import com.tencent.ilinkservice.IlinkDeviceManager;
import com.tencent.ilinkservice.IlinkImManager;
import com.tencent.ilinkservice.IlinkServiceProto;
import com.tencent.ilinkservice.IlinkServiceTdiCallback;
import com.tencent.luggage.wxa.p0.a;
import com.tencent.luggage.wxa.u0.b;
import com.tencent.mars.ilink.comm.NetStatusUtil;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkService extends Service implements IlinkServiceTdiCallback.IlinkServiceTdiCallbackObserver, IlinkDeviceManager.IlinkDeviceObserver, IlinkImManager.IlinkImObserver, b.InterfaceC6777b {
    private static final int INVOKE_DEVICECALLBACK_TASK = 3;
    private static final int INVOKE_LOCAL_TASK = 4;
    private static final int INVOKE_TDICALLBACK_TASK = 2;
    private static final String TAG = "IlinkService";
    private static final int TEST_TIMER_TASK = 1;
    public static final int m_service_version_ = 33555213;
    private static Lock m_taskid_lock_ = new ReentrantLock();
    private ServiceHandler mServiceHandler;
    private Looper mServiceLooper;
    public String m_file_dir_;
    private byte[] m_profile_;
    private HandlerThread m_task_thread_;
    private TdiApiProto.TdiInitParameter m_tdi_init_param_;
    private String m_token_;
    private ConcurrentHashMap<String, String> m_caller_cookie_map_ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, TdiSessionInfo> m_appid_tdisession_map_ = new ConcurrentHashMap<>();
    private final IlinkRemoteCallbackList m_remote_callback_list_ = new IlinkRemoteCallbackList();
    private IlinkServiceProto.InitParameter m_ilink_init_param_ = null;
    private IlinkService m_service_obj_ = this;
    private IlinkDeviceManager m_ilink_manager_ = null;
    private boolean m_login_state_ = false;
    private boolean m_login_running = true;
    private IlinkImManager m_ilink_im_manager_ = null;
    private ConcurrentHashMap<Integer, String> m_tdi_taskid_caller_map_ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> m_appid_cloneticket_map_ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Vector<String>> m_appid_clonecaller_map_ = new ConcurrentHashMap<>();
    private int m_tditaskid_ = 0;
    private boolean m_ilinklive_loaded_ = false;
    private int m_test_count_ = 0;
    private Timer m_timer = new BaseTimer();
    TimerTask m_testtask = new TimerTask() { // from class: com.tencent.ilinkservice.IlinkService.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message obtainMessage = IlinkService.this.mServiceHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = IlinkService.access$808(IlinkService.this);
            IlinkService.this.mServiceHandler.sendMessage(obtainMessage);
        }
    };
    private IBinder mBinder = new IIlinkServiceInterface.Stub() { // from class: com.tencent.ilinkservice.IlinkService.2
        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public byte[] ReqCommFunctionWithResp(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return new byte[0];
            }
            str3.hashCode();
            char c16 = '\uffff';
            switch (str3.hashCode()) {
                case -1911188865:
                    if (str3.equals("updateDeviceShadow")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1855530000:
                    if (str3.equals("getIlinkServiceVersion")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -960765421:
                    if (str3.equals("startCdnDownload")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 665062988:
                    if (str3.equals("startCdnUpload")) {
                        c16 = 3;
                        break;
                    }
                    break;
                case 686849420:
                    if (str3.equals("getDeviceShadow")) {
                        c16 = 4;
                        break;
                    }
                    break;
                case 1828329171:
                    if (str3.equals(IlinkLiveServiceImpl.ILINKLIVE_SERVICE_FUNC)) {
                        c16 = 5;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    try {
                        return AidlProto.updateDeviceShadowResp.newBuilder().setTaskid(IlinkService.this.m_ilink_im_manager_.updateDeviceShadow(AidlProto.updateDeviceShadowReq.parseFrom(bArr).getShadowdata().toByteArray())).build().toByteArray();
                    } catch (InvalidProtocolBufferException e16) {
                        e16.printStackTrace();
                        return AidlProto.updateDeviceShadowResp.newBuilder().setTaskid(0).build().toByteArray();
                    }
                case 1:
                    IlinkService.this.m_ilink_manager_.setLonglinkIplist(bArr);
                    return AidlProto.getIlinkServiceVersionResp.newBuilder().setVersion("0.3.13.dff0888").build().toByteArray();
                case 2:
                    try {
                        AidlProto.commFunctionReqWithReq parseFrom = AidlProto.commFunctionReqWithReq.parseFrom(bArr);
                        if (!IlinkService.this.isAppIdBelongToCaller(parseFrom.getAppid(), str)) {
                            return new byte[0];
                        }
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom.getAppid())) {
                            Log.d(IlinkService.TAG, "call startCdnDownload from:" + str + ", for appid:" + parseFrom.getAppid());
                            int GeneralTaskId = IlinkService.this.GeneralTaskId();
                            ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom.getAppid())).m_tdi_.getTdiManager().c2CDownload(GeneralTaskId, ApiProto.IlinkC2CDownload.parseFrom(parseFrom.getReqdata()));
                            return AidlProto.commFunctionTaskidResp.newBuilder().setTaskid(GeneralTaskId).build().toByteArray();
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom.getAppid());
                        return new byte[0];
                    } catch (InvalidProtocolBufferException e17) {
                        e17.printStackTrace();
                        return new byte[0];
                    }
                case 3:
                    try {
                        AidlProto.commFunctionReqWithReq parseFrom2 = AidlProto.commFunctionReqWithReq.parseFrom(bArr);
                        if (!IlinkService.this.isAppIdBelongToCaller(parseFrom2.getAppid(), str)) {
                            return new byte[0];
                        }
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom2.getAppid())) {
                            Log.d(IlinkService.TAG, "call startCdnUpload from:" + str + ", for appid:" + parseFrom2.getAppid());
                            int GeneralTaskId2 = IlinkService.this.GeneralTaskId();
                            ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom2.getAppid())).m_tdi_.getTdiManager().c2CUpload(GeneralTaskId2, ApiProto.IlinkC2CUpload.parseFrom(parseFrom2.getReqdata()));
                            return AidlProto.commFunctionTaskidResp.newBuilder().setTaskid(GeneralTaskId2).build().toByteArray();
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom2.getAppid());
                        return new byte[0];
                    } catch (InvalidProtocolBufferException e18) {
                        e18.printStackTrace();
                        return new byte[0];
                    }
                case 4:
                    return AidlProto.getDeviceShadowResp.newBuilder().setTaskid(IlinkService.this.m_ilink_im_manager_.getDeviceShadow()).build().toByteArray();
                case 5:
                    if (!IlinkService.this.m_ilinklive_loaded_) {
                        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("ilink_live");
                        IlinkService.this.m_ilinklive_loaded_ = true;
                    }
                    return b.b().a(bArr, IlinkService.this.m_service_obj_, str);
                default:
                    Log.e(IlinkService.TAG, "not supported function: " + str3);
                    return new byte[0];
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void SetSmcUin(String str, String str2, String str3, int i3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call SetSmcUin from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().setSmcUin(i3);
                return;
            }
            Log.e(IlinkService.TAG, "tdi session map not contain appid:" + str3);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void WriteKvData(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call WriteKvData from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().writeKvData(bArr);
                return;
            }
            Log.e(IlinkService.TAG, "tdi session map not contain appid:" + str3);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void autoLogin(String str, String str2) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.m_ilink_init_param_.getRunningMode() == 1) {
                Class cls = Integer.TYPE;
                IlinkService.this.addDeviceCallbackTask(str, "onNewLoginComplete", new Class[]{cls, cls, byte[].class, String.class}, 0, 0, IlinkService.this.m_profile_, IlinkService.this.m_token_);
            }
            if (IlinkService.this.m_login_state_) {
                Class cls2 = Integer.TYPE;
                IlinkService.this.addDeviceCallbackTask(str, "onNewLoginComplete", new Class[]{cls2, cls2, byte[].class, String.class}, 0, 0, IlinkService.this.m_profile_, IlinkService.this.m_token_);
            } else {
                if (IlinkService.this.m_login_running) {
                    Log.d(IlinkService.TAG, "auto login is running just do nothing!");
                    return;
                }
                Log.d(IlinkService.TAG, "Start auto login!");
                IlinkService.this.m_ilink_manager_.autoLogin();
                IlinkService.this.m_login_running = true;
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void cancel(String str, String str2, String str3, int i3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call cancel from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().cancelUniqueTask(TdiApiProto.TdiCancelType.valueOf(i3));
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void cancelAppRequest(String str, String str2, String str3, int i3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call cancelAppRequest from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().cancelSendAppRequest((long) i3);
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public int cancelOAuth(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return 0;
            }
            if (!IlinkService.this.isAppIdBelongToCaller(str3, str)) {
                return 0;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call cancelOAuth from:" + str + ", for appid:" + str3);
                try {
                    int GeneralTaskId = IlinkService.this.GeneralTaskId();
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().cancelOAuth(GeneralTaskId, TdiApiProto.TdiCancelOAuthRequest.parseFrom(bArr));
                    return GeneralTaskId;
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                    return 0;
                }
            }
            Log.e(IlinkService.TAG, "tdi session map not contain appid:" + str3);
            return 0;
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void cancelRequest(String str, String str2, String str3, int i3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call cancelRequest from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().cancelSendAppRequest((long) i3);
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void checkLoginQrCode(String str, String str2, String str3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call checkLoginQrCode from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().checkLoginQrCode(IlinkService.this.GeneralTaskId());
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void cloneMultiProcessTdiSession(String str, String str2, String str3, String str4) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                IlinkService.this.addDeviceCallbackTask(str, "onCloneMultiProcessTdiSession", new Class[]{Integer.TYPE, String.class}, -1, str3);
                return;
            }
            if (IlinkService.this.m_appid_cloneticket_map_.containsKey(str3)) {
                if (((String) IlinkService.this.m_appid_cloneticket_map_.get(str3)).equals(str4)) {
                    if (IlinkService.this.m_appid_clonecaller_map_.containsKey(str3)) {
                        if (((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str3)).contains(str)) {
                            Log.e(IlinkService.TAG, "clone tdi sesssion already in vector!!!");
                            IlinkService.this.addDeviceCallbackTask(str, "onCloneMultiProcessTdiSession", new Class[]{Integer.TYPE, String.class}, -2, str3);
                            return;
                        } else {
                            ((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str3)).add(str);
                            IlinkService.this.addDeviceCallbackTask(str, "onCloneMultiProcessTdiSession", new Class[]{Integer.TYPE, String.class}, 0, str3);
                            return;
                        }
                    }
                    Log.d(IlinkService.TAG, "add new item to map!");
                    IlinkService.this.m_appid_clonecaller_map_.put(str3, new Vector());
                    ((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str3)).add(str);
                    IlinkService.this.addDeviceCallbackTask(str, "onCloneMultiProcessTdiSession", new Class[]{Integer.TYPE, String.class}, 0, str3);
                    return;
                }
                Log.e(IlinkService.TAG, "cloneticket not match for appid:" + str3);
                IlinkService.this.addDeviceCallbackTask(str, "onCloneMultiProcessTdiSession", new Class[]{Integer.TYPE, String.class}, -3, str3);
                return;
            }
            Log.e(IlinkService.TAG, "cloneticket for appid not exit:" + str3);
            IlinkService.this.addDeviceCallbackTask(str, "onCloneMultiProcessTdiSession", new Class[]{Integer.TYPE, String.class}, -4, str3);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void createTdiSession(String str, String str2, String str3) throws RemoteException {
            if (IlinkService.this.isCallerLegal(str, str2)) {
                synchronized (IlinkService.this.m_appid_tdisession_map_) {
                    if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                        Log.e(IlinkService.TAG, "appid:" + str3 + "already exit in map we should recreate the tdisession for safe!");
                        ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().uninit();
                        ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.destroy();
                        IlinkService.this.m_appid_tdisession_map_.remove(str3);
                    }
                    if (IlinkService.this.m_tdi_init_param_ == null) {
                        Log.e(IlinkService.TAG, "device not login yet wait login complete then call createTdiSession!");
                        return;
                    }
                    IlinktdiInterfaceManager ilinktdiInterfaceManager = new IlinktdiInterfaceManager(str3);
                    ilinktdiInterfaceManager.getTdiManager().init(IlinkService.this.m_tdi_init_param_);
                    Log.d(IlinkService.TAG, "Success create tdi session for: " + str3);
                    TdiSessionInfo tdiSessionInfo = new TdiSessionInfo(str, str3, ilinktdiInterfaceManager);
                    tdiSessionInfo.m_tdi_callback_ = new IlinkServiceTdiCallback(str3, IlinkService.this.m_service_obj_);
                    ilinktdiInterfaceManager.getTdiManager().setCallback(tdiSessionInfo.m_tdi_callback_);
                    IlinkService.this.m_appid_tdisession_map_.put(str3, tdiSessionInfo);
                    return;
                }
            }
            Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void destroyMultiProcessTdiSession(String str, String str2, String str3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.m_appid_clonecaller_map_.containsKey(str3)) {
                if (((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str3)).contains(str)) {
                    ((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str3)).remove(str);
                    return;
                }
                Log.e(IlinkService.TAG, "call not in clonemap:" + str + ", for appid:" + str3);
                return;
            }
            Log.e(IlinkService.TAG, "appid in clonemap:" + str3);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void destroyTdiSession(String str, String str2, String str3) throws RemoteException {
            if (IlinkService.this.isCallerLegal(str, str2)) {
                synchronized (IlinkService.this.m_appid_tdisession_map_) {
                    if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                        Log.d(IlinkService.TAG, "appid:" + str3 + "exit in map try to destroy it!");
                        ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().uninit();
                        ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.destroy();
                        IlinkService.this.m_appid_tdisession_map_.remove(str3);
                    } else {
                        Log.w(IlinkService.TAG, "appid:" + str3 + " not exit in map maybe you already destroy it!");
                    }
                }
                return;
            }
            Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void faceExtVerify(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call faceExtVerify from:" + str + ", for appid:" + str3);
                try {
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().faceExtVerify(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiFaceExtVerifyRequest.parseFrom(bArr));
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void faceLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.i(IlinkService.TAG, "call faceLogin from:" + str + ", for appid:" + str3);
                try {
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().login(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiLoginType.kTdiLoginTypeFace, TdiApiProto.TdiLoginRequest.parseFrom(bArr));
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void faceRecognize(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.i(IlinkService.TAG, "call faceRecognize from:" + str + ", for appid:" + str3);
                try {
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().faceRecognize(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiFaceRecognizeRequest.parseFrom(bArr));
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void faceRecognizeConfig(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.i(IlinkService.TAG, "call faceRecognizeConfig from:" + str + ", for appid:" + str3);
                try {
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().faceRecognizeConfig(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiFaceRecognizeConfigRequest.parseFrom(bArr));
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void getAppPushToken(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call getAppPushToken from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().getAppPushToken(IlinkService.this.GeneralTaskId(), bArr);
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void getLoginQrCode(String str, String str2, String str3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.e(IlinkService.TAG, "api not longer used use new on!");
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public int getOAuthCode(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return 0;
            }
            if (!IlinkService.this.isAppIdBelongToCaller(str3, str)) {
                return 0;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call getOAuthCode from:" + str + ", for appid:" + str3);
                try {
                    int GeneralTaskId = IlinkService.this.GeneralTaskId();
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().getOAuthCode(GeneralTaskId, TdiApiProto.TdiGetOAuthCodeRequest.parseFrom(bArr));
                    return GeneralTaskId;
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                    return 0;
                }
            }
            Log.e(IlinkService.TAG, "tdi session map not contain appid:" + str3);
            return 0;
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public byte[] getProfile(String str, String str2) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return null;
            }
            a aVar = new a();
            aVar.a(IlinkService.this.m_ilink_manager_.getIlinkId());
            IlinkService.this.m_profile_ = aVar.a();
            return IlinkService.this.m_profile_;
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public String getToken(String str, String str2) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return null;
            }
            return IlinkService.this.m_ilink_manager_.getToken();
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public byte[] getUserInfo(String str, String str2, String str3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return null;
            }
            if (!IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                return null;
            }
            Log.d(IlinkService.TAG, "call getUserInfo from:" + str + ", for appid:" + str3);
            return ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().getUserInfo().toByteArray();
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public boolean isAlreadyGetStrategy(String str, String str2) {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return false;
            }
            return IlinkService.this.m_ilink_manager_.isAlreadyGetStrategy();
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public String newRegisterCallback(String str, IIlinkServiceCallback iIlinkServiceCallback, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.m_caller_cookie_map_.containsKey(str)) {
                String GeneralCookie = IlinkService.GeneralCookie(str);
                IlinkService.this.m_remote_callback_list_.register(iIlinkServiceCallback, str);
                IlinkService.this.m_caller_cookie_map_.put(str, GeneralCookie);
                return GeneralCookie;
            }
            Log.e(IlinkService.TAG, "caller:" + str + "already exit in map there are a hack app exit just ignore it!");
            return null;
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public String newSendIotMessage(String str, String str2, String str3, String str4, String str5, String str6) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return null;
            }
            return IlinkService.this.m_ilink_manager_.sendIotMessage(str, str3, str4, str5, str6);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public int newgetAppPushToken(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return 0;
            }
            if (!IlinkService.this.isAppIdBelongToCaller(str3, str)) {
                return 0;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call newgetAppPushToken from:" + str + ", for appid:" + str3);
                int GeneralTaskId = IlinkService.this.GeneralTaskId();
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().getAppPushToken(GeneralTaskId, bArr);
                return GeneralTaskId;
            }
            Log.e(IlinkService.TAG, "tdi session map not contain appid:" + str3);
            return 0;
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void newgetLoginQrCode(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call getLoginQrCode from:" + str + ", for appid:" + str3);
                try {
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().getLoginQrCode(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiGetLoginQrCodeRequest.parseFrom(bArr));
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void oauthLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (!IlinkService.this.isAppIdBelongToCaller(str3, str)) {
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call OAuthLogin from:" + str + ", for appid:" + str3);
                try {
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().login(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiLoginType.kTdiLoginTypeOAuth, TdiApiProto.TdiLoginRequest.parseFrom(bArr));
                    return;
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            Log.e(IlinkService.TAG, "tdi session map not contain appid:" + str3);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void qrCodeLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (IlinkService.this.isAppIdBelongToCaller(str3, str) && IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call qrCodeLogin from:" + str + ", for appid:" + str3);
                try {
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().login(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiLoginType.kTdiLoginTypeQrCode, TdiApiProto.TdiLoginRequest.parseFrom(bArr));
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public String registCallbackWithDeviceInfo(String str, IIlinkServiceCallback iIlinkServiceCallback, byte[] bArr) throws RemoteException {
            if (IlinkService.this.m_caller_cookie_map_.containsKey(str)) {
                Log.e(IlinkService.TAG, "caller:" + str + "already exit in map there are a hack app exit just ignore it!");
                return null;
            }
            try {
                IlinkServiceProto.InitParameter parseFrom = IlinkServiceProto.InitParameter.parseFrom(bArr);
                if (IlinkService.this.m_ilink_init_param_.getDeviceId().equals(parseFrom.getDeviceId()) && IlinkService.this.m_ilink_init_param_.getProductId() == parseFrom.getProductId()) {
                    String GeneralCookie = IlinkService.GeneralCookie(str);
                    IlinkService.this.m_remote_callback_list_.register(iIlinkServiceCallback, str);
                    IlinkService.this.m_caller_cookie_map_.put(str, GeneralCookie);
                    return GeneralCookie;
                }
                Log.e(IlinkService.TAG, "registCallbackWithDeviceInfo not match");
                return null;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
                Log.e(IlinkService.TAG, "newRegisterCallback caller:" + str + " para error!");
                return null;
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public String registerCallback(String str, IIlinkServiceCallback iIlinkServiceCallback) throws RemoteException {
            if (!IlinkService.this.m_caller_cookie_map_.containsKey(str)) {
                String GeneralCookie = IlinkService.GeneralCookie(str);
                IlinkService.this.m_remote_callback_list_.register(iIlinkServiceCallback, str);
                IlinkService.this.m_caller_cookie_map_.put(str, GeneralCookie);
                return GeneralCookie;
            }
            Log.e(IlinkService.TAG, "caller:" + str + "already exit in map there are a hack app exit just ignore it!");
            return null;
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void requestMultiProcessCloneTicket(String str, String str2, String str3) {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                IlinkService.this.addServiceCallbackTask(str3, "onReceiveMultiProcessCloneTicket", new Class[]{Integer.TYPE, String.class, String.class}, -1, str3, "");
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "appid:" + str3 + " exit in map !");
                if (((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_caller_.equals(str)) {
                    if (IlinkService.this.m_appid_cloneticket_map_.containsKey(str3)) {
                        Log.d(IlinkService.TAG, "clone ticket exit just callback");
                        IlinkService.this.addServiceCallbackTask(str3, "onReceiveMultiProcessCloneTicket", new Class[]{Integer.TYPE, String.class, String.class}, 0, str3, IlinkService.this.m_appid_cloneticket_map_.get(str3));
                        return;
                    }
                    Log.d(IlinkService.TAG, "clone ticket not exit try to create one!");
                    IlinkService.this.m_appid_cloneticket_map_.put(str3, IlinkService.GeneralCookie(str + str3));
                    IlinkService.this.addServiceCallbackTask(str3, "onReceiveMultiProcessCloneTicket", new Class[]{Integer.TYPE, String.class, String.class}, 0, str3, IlinkService.this.m_appid_cloneticket_map_.get(str3));
                    return;
                }
                Log.e(IlinkService.TAG, "the request appid is not for this caller:" + str + ", owner:" + ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_caller_ + ", appid:" + str3);
                IlinkService.this.addServiceCallbackTask(str3, "onReceiveMultiProcessCloneTicket", new Class[]{Integer.TYPE, String.class, String.class}, -2, str3, "");
                return;
            }
            Log.e(IlinkService.TAG, "tdi session for appid not exit:" + str3);
            IlinkService.this.addServiceCallbackTask(str3, "onReceiveMultiProcessCloneTicket", new Class[]{Integer.TYPE, String.class, String.class}, -3, str3, "");
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public int sendAppRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return 0;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.i(IlinkService.TAG, "call sendAppRequest from:" + str + ", for appid:" + str3);
                try {
                    int GeneralTaskId = IlinkService.this.GeneralTaskId();
                    ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().sendAppRequest(GeneralTaskId, TdiApiProto.TdiAppRequest.parseFrom(bArr));
                    if (GeneralTaskId != 0) {
                        IlinkService.this.m_tdi_taskid_caller_map_.put(new Integer(GeneralTaskId), str);
                    }
                    return GeneralTaskId;
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                    return 0;
                }
            }
            Log.e(IlinkService.TAG, "tdi session not exit any more appid:" + str3 + ", caller:" + str);
            return 0;
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public String sendIotMessage(String str, String str2, String str3, String str4, String str5) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return null;
            }
            return IlinkService.this.m_ilink_manager_.sendIotMessage(str, str3, str4, str5, "");
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void setConsoleLogOpen(String str, String str2, boolean z16) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            IlinkService.this.m_ilink_manager_.setConsoleLogOpen(z16);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void setLogLevel(String str, String str2, int i3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            IlinkService.this.m_ilink_manager_.setLogLevel(i3);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void setProxyInfo(String str, String str2, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            IlinkService.this.m_ilink_manager_.setProxyInfo(bArr);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void tdiAutoLogin(String str, String str2, String str3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                IlinkService.this.addServiceCallbackTask(str3, "onTdiLoginComplete", new Class[]{String.class, Integer.TYPE, byte[].class}, 0, str3, -1, TdiApiProto.TdiLoginResponse.newBuilder().build().toByteArray());
                return;
            }
            if (!IlinkService.this.isAppIdBelongToCaller(str3, str)) {
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call tdiAutoLogin from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().login(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiLoginType.kTdiLoginTypeAuto, null);
                return;
            }
            Log.e(IlinkService.TAG, "caller:" + str + " appid is illegal not exit:" + str3);
            IlinkService.this.addServiceCallbackTask(str3, "onTdiLoginComplete", new Class[]{String.class, Integer.TYPE, byte[].class}, 0, str3, -1, TdiApiProto.TdiLoginResponse.newBuilder().build().toByteArray());
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void tdiLogOut(String str, String str2, String str3) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            if (!IlinkService.this.isAppIdBelongToCaller(str3, str)) {
                return;
            }
            if (IlinkService.this.m_appid_tdisession_map_.containsKey(str3)) {
                Log.d(IlinkService.TAG, "call tdiLogOut from:" + str + ", for appid:" + str3);
                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(str3)).m_tdi_.getTdiManager().logout(IlinkService.this.GeneralTaskId());
                return;
            }
            Log.e(IlinkService.TAG, "caller:" + str + " appid is illegal not exit:" + str3);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void unregisterCallback(String str, String str2, IIlinkServiceCallback iIlinkServiceCallback) throws RemoteException {
            Log.e(IlinkService.TAG, "client unregisterCallback:" + str);
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            IlinkService.this.m_remote_callback_list_.unregister(iIlinkServiceCallback);
            IlinkService.this.m_caller_cookie_map_.remove(str);
            synchronized (IlinkService.this.m_appid_tdisession_map_) {
                HashSet<TdiSessionInfo> hashSet = new HashSet();
                Enumeration elements = IlinkService.this.m_appid_tdisession_map_.elements();
                while (elements.hasMoreElements()) {
                    TdiSessionInfo tdiSessionInfo = (TdiSessionInfo) elements.nextElement();
                    if (tdiSessionInfo.m_caller_.equals(str)) {
                        hashSet.add(tdiSessionInfo);
                    }
                }
                Log.w(IlinkService.TAG, "Going to delete tdi sessions num:" + hashSet.size());
                for (TdiSessionInfo tdiSessionInfo2 : hashSet) {
                    if (IlinkService.this.m_appid_cloneticket_map_.containsKey(tdiSessionInfo2.m_appid_)) {
                        IlinkService.this.m_appid_cloneticket_map_.remove(tdiSessionInfo2.m_appid_);
                        if (IlinkService.this.m_appid_clonecaller_map_.containsKey(tdiSessionInfo2.m_appid_)) {
                            Class[] clsArr = {String.class};
                            Iterator it = ((Vector) IlinkService.this.m_appid_clonecaller_map_.get(tdiSessionInfo2.m_appid_)).iterator();
                            while (it.hasNext()) {
                                IlinkService.this.addDeviceCallbackTask((String) it.next(), "onDestroyMultiProcessTdiSession", clsArr, tdiSessionInfo2.m_appid_);
                            }
                            IlinkService.this.m_appid_clonecaller_map_.remove(tdiSessionInfo2.m_appid_);
                        }
                    }
                    IlinkService.this.m_appid_tdisession_map_.remove(tdiSessionInfo2.m_appid_);
                    tdiSessionInfo2.m_tdi_.getTdiManager().uninit();
                    tdiSessionInfo2.m_tdi_.destroy();
                }
                hashSet.clear();
            }
            synchronized (IlinkService.this.m_appid_clonecaller_map_) {
                Enumeration keys = IlinkService.this.m_appid_clonecaller_map_.keys();
                while (keys.hasMoreElements()) {
                    String str3 = (String) keys.nextElement();
                    if (((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str3)).contains(str)) {
                        ((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str3)).remove(str);
                    }
                }
                Enumeration keys2 = IlinkService.this.m_tdi_taskid_caller_map_.keys();
                while (keys2.hasMoreElements()) {
                    Integer num = (Integer) keys2.nextElement();
                    if (((String) IlinkService.this.m_tdi_taskid_caller_map_.get(num)).equals(str)) {
                        IlinkService.this.m_tdi_taskid_caller_map_.remove(num);
                    }
                }
            }
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void updateDeviceInfo(String str, String str2, byte[] bArr) throws RemoteException {
            IlinkDevApi.IlinkDeviceParams ilinkDeviceParams;
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            try {
                ilinkDeviceParams = IlinkDevApi.IlinkDeviceParams.parseFrom(bArr);
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
                ilinkDeviceParams = null;
            }
            IlinkServiceProto.InitParameter.Builder newBuilder = IlinkServiceProto.InitParameter.newBuilder(IlinkService.this.m_ilink_init_param_);
            newBuilder.setProductId(ilinkDeviceParams.getIlinkProductId());
            if (ilinkDeviceParams.getSignature().length() != 0) {
                newBuilder.setDeviceSignature(ilinkDeviceParams.getSignature());
                newBuilder.setSignatureTimestamp(ilinkDeviceParams.getSignatureTimestamp());
            }
            IlinkService.this.m_ilink_init_param_ = newBuilder.build();
            Log.i(IlinkService.TAG, "Update new productid:" + IlinkService.this.m_ilink_init_param_.getProductId());
            IlinkService.this.m_ilink_manager_.updateDeviceInfo(bArr);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void voidCommFunction(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            if (!IlinkService.this.isCallerLegal(str, str2)) {
                Log.e(IlinkService.TAG, "caller:" + str + " is illegal");
                return;
            }
            str3.hashCode();
            char c16 = '\uffff';
            switch (str3.hashCode()) {
                case -2077369985:
                    if (str3.equals("updateIlinkToken")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1926850762:
                    if (str3.equals("createImSession")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -1716520125:
                    if (str3.equals("requestUploadLogfiles")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case -1705656167:
                    if (str3.equals("smcFlushReportData")) {
                        c16 = 3;
                        break;
                    }
                    break;
                case -1419276391:
                    if (str3.equals("setShortlinkIplist")) {
                        c16 = 4;
                        break;
                    }
                    break;
                case -1035986083:
                    if (str3.equals("setLonglinkIplist")) {
                        c16 = 5;
                        break;
                    }
                    break;
                case -526495596:
                    if (str3.equals("changeDomain")) {
                        c16 = 6;
                        break;
                    }
                    break;
                case -378235400:
                    if (str3.equals("destroyImSession")) {
                        c16 = 7;
                        break;
                    }
                    break;
                case -209297509:
                    if (str3.equals("visitorLogin")) {
                        c16 = '\b';
                        break;
                    }
                    break;
                case 841167721:
                    if (str3.equals("loginImSession")) {
                        c16 = '\t';
                        break;
                    }
                    break;
                case 884734785:
                    if (str3.equals("startUploadLog")) {
                        c16 = '\n';
                        break;
                    }
                    break;
                case 1093616719:
                    if (str3.equals("thirdAppLogin")) {
                        c16 = 11;
                        break;
                    }
                    break;
                case 1240306118:
                    if (str3.equals("setSmcBaseInfo")) {
                        c16 = '\f';
                        break;
                    }
                    break;
                case 1280212788:
                    if (str3.equals("cancelCdnUpload")) {
                        c16 = '\r';
                        break;
                    }
                    break;
                case 1787672827:
                    if (str3.equals("cancelCdnDownload")) {
                        c16 = 14;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    try {
                        AidlProto.updateIlinkToken parseFrom = AidlProto.updateIlinkToken.parseFrom(bArr);
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom.getAppid())) {
                            Log.d(IlinkService.TAG, "call updateIlinkToken from:" + str + ", for appid:" + parseFrom.getAppid());
                            ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom.getAppid())).m_tdi_.getTdiManager().updateIlinkToken(parseFrom.getIlinktoken());
                            return;
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom.getAppid());
                        return;
                    } catch (InvalidProtocolBufferException e16) {
                        e16.printStackTrace();
                        return;
                    }
                case 1:
                    if (IlinkService.this.m_ilink_im_manager_ == null) {
                        IlinkService ilinkService = IlinkService.this;
                        ilinkService.m_ilink_im_manager_ = new IlinkImManager(ilinkService.m_file_dir_, ilinkService.m_service_obj_);
                    }
                    IlinkService.this.m_ilink_im_manager_.createImSession(str, bArr);
                    return;
                case 2:
                    try {
                        AidlProto.requestUploadLogfiles parseFrom2 = AidlProto.requestUploadLogfiles.parseFrom(bArr);
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom2.getAppid())) {
                            Log.d(IlinkService.TAG, "call requestUploadLogfiles from:" + str + ", for appid:" + parseFrom2.getAppid());
                            ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom2.getAppid())).m_tdi_.getTdiManager().requestUploadLogfiles(parseFrom2.getStartTime(), parseFrom2.getEndTime());
                            return;
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom2.getAppid());
                        return;
                    } catch (InvalidProtocolBufferException e17) {
                        e17.printStackTrace();
                        return;
                    }
                case 3:
                    try {
                        AidlProto.commFunctionReqWithTaskid parseFrom3 = AidlProto.commFunctionReqWithTaskid.parseFrom(bArr);
                        if (!IlinkService.this.isAppIdBelongToCaller(parseFrom3.getAppid(), str)) {
                            return;
                        }
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom3.getAppid())) {
                            Log.d(IlinkService.TAG, "call smcFlushReportData from:" + str + ", for appid:" + parseFrom3.getAppid());
                            ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom3.getAppid())).m_tdi_.getTdiManager().smcFlushReportData();
                            return;
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom3.getAppid());
                        return;
                    } catch (InvalidProtocolBufferException e18) {
                        e18.printStackTrace();
                        Log.e(IlinkService.TAG, "smcFlushReportData InvalidProtocolBufferException");
                        return;
                    }
                case 4:
                    IlinkService.this.m_ilink_manager_.setShortlinkIplist(bArr);
                    return;
                case 5:
                    IlinkService.this.m_ilink_manager_.setLonglinkIplist(bArr);
                    return;
                case 6:
                    try {
                        IlinkService.this.m_ilink_manager_.changeDomain(AidlProto.changeDomainRequest.parseFrom(bArr).getDomain());
                        break;
                    } catch (InvalidProtocolBufferException e19) {
                        e19.printStackTrace();
                        break;
                    }
                case 7:
                    IlinkService.this.m_ilink_im_manager_.destroyImSession();
                    return;
                case '\b':
                    try {
                        AidlProto.visitorLogin parseFrom4 = AidlProto.visitorLogin.parseFrom(bArr);
                        if (!IlinkService.this.isAppIdBelongToCaller(parseFrom4.getAppid(), str)) {
                            return;
                        }
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom4.getAppid())) {
                            Log.d(IlinkService.TAG, "call visitorLogin from:" + str + ", for appid:" + parseFrom4.getAppid());
                            try {
                                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom4.getAppid())).m_tdi_.getTdiManager().login(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiLoginType.kTdiLoginTypeVisitor, TdiApiProto.TdiLoginRequest.parseFrom(parseFrom4.getReq()));
                                return;
                            } catch (InvalidProtocolBufferException e26) {
                                e26.printStackTrace();
                                return;
                            }
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom4.getAppid());
                        return;
                    } catch (InvalidProtocolBufferException e27) {
                        e27.printStackTrace();
                        return;
                    }
                case '\t':
                    IlinkService.this.m_ilink_im_manager_.loginImSession();
                    return;
                case '\n':
                    try {
                        IlinkService.this.m_ilink_manager_.startUploadLog(AidlProto.startUploadLog.parseFrom(bArr).getLoginfo().toByteArray());
                        return;
                    } catch (InvalidProtocolBufferException e28) {
                        e28.printStackTrace();
                        return;
                    }
                case 11:
                    try {
                        AidlProto.thirdAppLogin parseFrom5 = AidlProto.thirdAppLogin.parseFrom(bArr);
                        if (!IlinkService.this.isAppIdBelongToCaller(parseFrom5.getAppid(), str)) {
                            return;
                        }
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom5.getAppid())) {
                            Log.d(IlinkService.TAG, "call thirdAppLogin from:" + str + ", for appid:" + parseFrom5.getAppid());
                            try {
                                ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom5.getAppid())).m_tdi_.getTdiManager().login(IlinkService.this.GeneralTaskId(), TdiApiProto.TdiLoginType.kTdiLoginTypeThirdApp, TdiApiProto.TdiLoginRequest.parseFrom(parseFrom5.getReq()));
                                return;
                            } catch (InvalidProtocolBufferException e29) {
                                e29.printStackTrace();
                                return;
                            }
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom5.getAppid());
                        return;
                    } catch (InvalidProtocolBufferException e36) {
                        e36.printStackTrace();
                        return;
                    }
                case '\f':
                    try {
                        AidlProto.setSmcBaseInfo parseFrom6 = AidlProto.setSmcBaseInfo.parseFrom(bArr);
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom6.getAppid())) {
                            Log.d(IlinkService.TAG, "call setSmcBaseInfo from:" + str + ", for appid:" + parseFrom6.getAppid());
                            ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom6.getAppid())).m_tdi_.getTdiManager().setSmcBaseInfo(parseFrom6.getSmcbaseinfo().toByteArray());
                            return;
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom6.getAppid());
                        return;
                    } catch (InvalidProtocolBufferException e37) {
                        e37.printStackTrace();
                        return;
                    }
                case '\r':
                    try {
                        AidlProto.commFunctionReqWithTaskid parseFrom7 = AidlProto.commFunctionReqWithTaskid.parseFrom(bArr);
                        if (!IlinkService.this.isAppIdBelongToCaller(parseFrom7.getAppid(), str)) {
                            return;
                        }
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom7.getAppid())) {
                            Log.d(IlinkService.TAG, "call cancelCdnUpload from:" + str + ", for appid:" + parseFrom7.getAppid());
                            ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom7.getAppid())).m_tdi_.getTdiManager().cancelC2CUpload((long) parseFrom7.getTaskid());
                            return;
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom7.getAppid());
                        return;
                    } catch (InvalidProtocolBufferException e38) {
                        e38.printStackTrace();
                        Log.e(IlinkService.TAG, "cancelCdnUpload InvalidProtocolBufferException");
                        return;
                    }
                case 14:
                    try {
                        AidlProto.commFunctionReqWithTaskid parseFrom8 = AidlProto.commFunctionReqWithTaskid.parseFrom(bArr);
                        if (!IlinkService.this.isAppIdBelongToCaller(parseFrom8.getAppid(), str)) {
                            return;
                        }
                        if (IlinkService.this.m_appid_tdisession_map_.containsKey(parseFrom8.getAppid())) {
                            Log.d(IlinkService.TAG, "call cancelCdnUpload from:" + str + ", for appid:" + parseFrom8.getAppid());
                            ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(parseFrom8.getAppid())).m_tdi_.getTdiManager().cancelC2CDownload((long) parseFrom8.getTaskid());
                            return;
                        }
                        Log.e(IlinkService.TAG, "tdi session map not contain appid:" + parseFrom8.getAppid());
                        return;
                    } catch (InvalidProtocolBufferException e39) {
                        e39.printStackTrace();
                        Log.e(IlinkService.TAG, "cancelCdnUpload InvalidProtocolBufferException");
                        return;
                    }
            }
            Log.e(IlinkService.TAG, "not supported function: " + str3);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void writeLogToFile(int i3, String str, String str2) throws RemoteException {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                Log.e(str, str2);
                                return;
                            } else {
                                Log.e(str, str2);
                                return;
                            }
                        }
                        Log.w(str, str2);
                        return;
                    }
                    Log.i(str, str2);
                    return;
                }
                Log.d(str, str2);
                return;
            }
            Log.v(str, str2);
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void uninit(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.tencent.ilinkservice.IIlinkServiceInterface
        public void init(String str, String str2, String str3, byte[] bArr) throws RemoteException {
        }
    };

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class DeviceCallbackTaskInfo {
        String m_caller;
        String m_funcname;
        Class[] m_paramTypes;
        Object[] m_params;

        public DeviceCallbackTaskInfo(String str, String str2, Class[] clsArr, Object[] objArr) {
            this.m_caller = str;
            this.m_funcname = str2;
            this.m_paramTypes = clsArr;
            this.m_params = objArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class IlinkRemoteCallbackList extends RemoteCallbackList<IIlinkServiceCallback> {
        IlinkRemoteCallbackList() {
        }

        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(IIlinkServiceCallback iIlinkServiceCallback, Object obj) {
            Log.e(IlinkService.TAG, "client process died:" + obj);
            synchronized (IlinkService.this.m_appid_tdisession_map_) {
                IlinkService.this.m_remote_callback_list_.unregister(iIlinkServiceCallback);
                IlinkService.this.m_caller_cookie_map_.remove(obj);
                HashSet<TdiSessionInfo> hashSet = new HashSet();
                Enumeration elements = IlinkService.this.m_appid_tdisession_map_.elements();
                while (elements.hasMoreElements()) {
                    TdiSessionInfo tdiSessionInfo = (TdiSessionInfo) elements.nextElement();
                    if (tdiSessionInfo.m_caller_.equals(obj)) {
                        hashSet.add(tdiSessionInfo);
                    }
                }
                Log.w(IlinkService.TAG, "Going to delete tdi sessions num:" + hashSet.size());
                for (TdiSessionInfo tdiSessionInfo2 : hashSet) {
                    if (IlinkService.this.m_appid_cloneticket_map_.containsKey(tdiSessionInfo2.m_appid_)) {
                        IlinkService.this.m_appid_cloneticket_map_.remove(tdiSessionInfo2.m_appid_);
                        if (IlinkService.this.m_appid_clonecaller_map_.containsKey(tdiSessionInfo2.m_appid_)) {
                            Class[] clsArr = {String.class};
                            Iterator it = ((Vector) IlinkService.this.m_appid_clonecaller_map_.get(tdiSessionInfo2.m_appid_)).iterator();
                            while (it.hasNext()) {
                                IlinkService.this.addDeviceCallbackTask((String) it.next(), "onDestroyMultiProcessTdiSession", clsArr, tdiSessionInfo2.m_appid_);
                            }
                            IlinkService.this.m_appid_clonecaller_map_.remove(tdiSessionInfo2.m_appid_);
                        }
                    }
                    IlinkService.this.m_appid_tdisession_map_.remove(tdiSessionInfo2.m_appid_);
                    tdiSessionInfo2.m_tdi_.getTdiManager().uninit();
                    tdiSessionInfo2.m_tdi_.destroy();
                }
            }
            synchronized (IlinkService.this.m_appid_clonecaller_map_) {
                new HashSet();
                Enumeration keys = IlinkService.this.m_appid_clonecaller_map_.keys();
                while (keys.hasMoreElements()) {
                    String str = (String) keys.nextElement();
                    if (((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str)).contains(obj)) {
                        ((Vector) IlinkService.this.m_appid_clonecaller_map_.get(str)).remove(obj);
                    }
                }
                Enumeration keys2 = IlinkService.this.m_tdi_taskid_caller_map_.keys();
                while (keys2.hasMoreElements()) {
                    Integer num = (Integer) keys2.nextElement();
                    if (((String) IlinkService.this.m_tdi_taskid_caller_map_.get(num)).equals(obj)) {
                        IlinkService.this.m_tdi_taskid_caller_map_.remove(num);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class LocalTaskInfo {
        String m_funcname;
        Object m_object;
        Class[] m_paramTypes;
        Object[] m_params;
        Class m_protocol;

        public LocalTaskInfo(Object obj, Class cls, String str, Class[] clsArr, Object[] objArr) {
            this.m_object = obj;
            this.m_protocol = cls;
            this.m_funcname = str;
            this.m_paramTypes = clsArr;
            this.m_params = objArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                int i16 = 0;
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            Log.d(IlinkService.TAG, "Not supported task type yet:" + message.what);
                            return;
                        }
                        LocalTaskInfo localTaskInfo = (LocalTaskInfo) message.obj;
                        try {
                            localTaskInfo.m_protocol.getMethod(localTaskInfo.m_funcname, localTaskInfo.m_paramTypes).invoke(localTaskInfo.m_object, localTaskInfo.m_params);
                            return;
                        } catch (IllegalAccessException e16) {
                            e16.printStackTrace();
                            return;
                        } catch (NoSuchMethodException e17) {
                            e17.printStackTrace();
                            return;
                        } catch (InvocationTargetException e18) {
                            e18.printStackTrace();
                            return;
                        }
                    }
                    DeviceCallbackTaskInfo deviceCallbackTaskInfo = (DeviceCallbackTaskInfo) message.obj;
                    int beginBroadcast = IlinkService.this.m_remote_callback_list_.beginBroadcast();
                    boolean equals = deviceCallbackTaskInfo.m_caller.equals("");
                    while (i16 < beginBroadcast) {
                        if (equals) {
                            try {
                                Log.i(IlinkService.TAG, "device callback all");
                                IIlinkServiceCallback.class.getMethod(deviceCallbackTaskInfo.m_funcname, deviceCallbackTaskInfo.m_paramTypes).invoke(IlinkService.this.m_remote_callback_list_.getBroadcastItem(i16), deviceCallbackTaskInfo.m_params);
                            } catch (IllegalAccessException e19) {
                                e19.printStackTrace();
                            } catch (NoSuchMethodException e26) {
                                e26.printStackTrace();
                            } catch (InvocationTargetException e27) {
                                e27.printStackTrace();
                            }
                            i16++;
                        } else {
                            if (IlinkService.this.m_remote_callback_list_.getBroadcastCookie(i16).equals(deviceCallbackTaskInfo.m_caller)) {
                                Log.i(IlinkService.TAG, "device callback one:" + deviceCallbackTaskInfo.m_caller);
                                IIlinkServiceCallback.class.getMethod(deviceCallbackTaskInfo.m_funcname, deviceCallbackTaskInfo.m_paramTypes).invoke(IlinkService.this.m_remote_callback_list_.getBroadcastItem(i16), deviceCallbackTaskInfo.m_params);
                                break;
                            }
                            continue;
                            i16++;
                        }
                    }
                    IlinkService.this.m_remote_callback_list_.finishBroadcast();
                    return;
                }
                Log.d(IlinkService.TAG, "This is a confirm tdi callback only the correct appid can receive this callback");
                TdiCallbackTaskInfo tdiCallbackTaskInfo = (TdiCallbackTaskInfo) message.obj;
                if (!IlinkService.this.m_appid_tdisession_map_.containsKey(tdiCallbackTaskInfo.m_appid_)) {
                    Log.e(IlinkService.TAG, "appid:" + message.obj + " not exit anymore");
                    return;
                }
                int beginBroadcast2 = IlinkService.this.m_remote_callback_list_.beginBroadcast();
                String str = ((TdiSessionInfo) IlinkService.this.m_appid_tdisession_map_.get(tdiCallbackTaskInfo.m_appid_)).m_caller_;
                while (i16 < beginBroadcast2) {
                    try {
                    } catch (IllegalAccessException e28) {
                        e28.printStackTrace();
                    } catch (NoSuchMethodException e29) {
                        e29.printStackTrace();
                    } catch (InvocationTargetException e36) {
                        e36.printStackTrace();
                    }
                    if (IlinkService.this.m_remote_callback_list_.getBroadcastCookie(i16).equals(str)) {
                        Log.d(IlinkService.TAG, "find the right callback:" + str);
                        IIlinkServiceCallback.class.getMethod(tdiCallbackTaskInfo.m_funcname, tdiCallbackTaskInfo.m_paramTypes).invoke(IlinkService.this.m_remote_callback_list_.getBroadcastItem(i16), tdiCallbackTaskInfo.m_params);
                        break;
                    }
                    continue;
                    i16++;
                }
                IlinkService.this.m_remote_callback_list_.finishBroadcast();
                return;
            }
            Log.d(IlinkService.TAG, "It is a timer alive task:" + message.arg1 + " and version is:" + IlinkService.m_service_version_);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class TdiCallbackTaskInfo {
        String m_appid_;
        String m_funcname;
        Class[] m_paramTypes;
        Object[] m_params;

        public TdiCallbackTaskInfo(String str, String str2, Class[] clsArr, Object[] objArr) {
            this.m_appid_ = str;
            this.m_funcname = str2;
            this.m_paramTypes = clsArr;
            this.m_params = objArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class TdiSessionInfo {
        public String m_appid_;
        public String m_caller_;
        public IlinktdiInterfaceManager m_tdi_;
        public IlinkServiceTdiCallback m_tdi_callback_;

        public TdiSessionInfo(String str, String str2, IlinktdiInterfaceManager ilinktdiInterfaceManager) {
            this.m_caller_ = str;
            this.m_appid_ = str2;
            this.m_tdi_ = ilinktdiInterfaceManager;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String GeneralCookie(String str) {
        String str2 = ((new Random().nextDouble() + 1.0d) * Math.pow(10.0d, 10.0d)) + str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            messageDigest.update(str2.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (Integer.toHexString(i3).length() == 1) {
                    sb5.append("0");
                    sb5.append(Integer.toHexString(i3));
                } else {
                    sb5.append(Integer.toHexString(i3));
                }
            }
            return sb5.toString();
        } catch (NoSuchAlgorithmException e16) {
            Log.e(TAG, "no such algorithm:" + e16.toString());
            e16.printStackTrace();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int GeneralTaskId() {
        m_taskid_lock_.lock();
        int i3 = this.m_tditaskid_ + 1;
        this.m_tditaskid_ = i3;
        if (i3 >= Integer.MAX_VALUE || i3 == 0) {
            this.m_tditaskid_ = 1;
        }
        int i16 = this.m_tditaskid_;
        m_taskid_lock_.unlock();
        return i16;
    }

    public static /* synthetic */ int access$808(IlinkService ilinkService) {
        int i3 = ilinkService.m_test_count_;
        ilinkService.m_test_count_ = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAppIdBelongToCaller(String str, String str2) {
        if (this.m_appid_tdisession_map_.containsKey(str)) {
            if (this.m_appid_tdisession_map_.get(str).m_caller_.equals(str2)) {
                return true;
            }
            Log.e(TAG, "appid:" + str + " not belong to caller:" + str2);
            return false;
        }
        Log.e(TAG, "appid not exit");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCallerLegal(String str, String str2) {
        if (this.m_caller_cookie_map_.containsKey(str) && this.m_caller_cookie_map_.get(str).equals(str2)) {
            return true;
        }
        return false;
    }

    public void OnLocalRequestUploadLogfiles(String str, byte[] bArr) {
        Log.d(TAG, "OnLocalRequestUploadLogfiles:" + str);
        if (this.m_appid_tdisession_map_.containsKey(str)) {
            try {
                TdiApiProto.TdiUserInfo userInfo = this.m_appid_tdisession_map_.get(str).m_tdi_.getTdiManager().getUserInfo();
                IlinkServiceProto.IlinkPullLogCmd parseFrom = IlinkServiceProto.IlinkPullLogCmd.parseFrom(bArr);
                int netWorkType = NetStatusUtil.getNetWorkType(getApplicationContext());
                if (parseFrom.getUseNettype() == 0 && netWorkType != -1 && netWorkType != 1 && netWorkType != 9) {
                    Log.d(TAG, "OnLocalRequestUploadLogfiles nettype not match:" + netWorkType);
                    return;
                }
                if (parseFrom.getIncludeDevlog() && parseFrom.getIlinkLogsCount() != 0) {
                    IlinkDevApi.IlinkUploadLogInfo.Builder newBuilder = IlinkDevApi.IlinkUploadLogInfo.newBuilder();
                    newBuilder.setToken(parseFrom.getUploadToken());
                    newBuilder.addAllLogPath(parseFrom.getIlinkLogsList());
                    newBuilder.setIncludeDevLog(parseFrom.getIncludeDevlog());
                    newBuilder.setExtBuffer(parseFrom.getExtBuffer());
                    newBuilder.setCapath(parseFrom.getIlinkCapath());
                    newBuilder.setUin(userInfo.getUin());
                    newBuilder.setUsername(userInfo.getUsername());
                    this.m_ilink_manager_.startUploadLog(newBuilder.build().toByteArray());
                    return;
                }
                return;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
                return;
            }
        }
        Log.e(TAG, "UploadLogfiles tdi session map not contain appid:" + str);
    }

    @Override // com.tencent.ilinkservice.IlinkServiceTdiCallback.IlinkServiceTdiCallbackObserver, com.tencent.ilinkservice.IlinkDeviceManager.IlinkDeviceObserver
    public void addDeviceCallbackTask(String str, String str2, Class[] clsArr, Object... objArr) {
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.obj = new DeviceCallbackTaskInfo(str, str2, clsArr, objArr);
        this.mServiceHandler.sendMessage(obtainMessage);
    }

    public void addIlinkLiveCallbackTask(String str, String str2, Class[] clsArr, Object... objArr) {
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.obj = new DeviceCallbackTaskInfo(str, str2, clsArr, objArr);
        this.mServiceHandler.sendMessage(obtainMessage);
    }

    @Override // com.tencent.ilinkservice.IlinkImManager.IlinkImObserver
    public void addImCallbackTask(String str, String str2, Class[] clsArr, Object... objArr) {
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.obj = new DeviceCallbackTaskInfo(str, str2, clsArr, objArr);
        this.mServiceHandler.sendMessage(obtainMessage);
    }

    public void addLocalTask(Object obj, Class cls, String str, Class[] clsArr, Object... objArr) {
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.obj = new LocalTaskInfo(obj, cls, str, clsArr, objArr);
        this.mServiceHandler.sendMessage(obtainMessage);
    }

    @Override // com.tencent.ilinkservice.IlinkServiceTdiCallback.IlinkServiceTdiCallbackObserver
    public void addServiceCallbackTask(String str, String str2, Class[] clsArr, Object... objArr) {
        if (str2.equals("OnRequestUploadLogfiles")) {
            addLocalTask(this.m_service_obj_, IlinkService.class, "OnLocalRequestUploadLogfiles", new Class[]{String.class, byte[].class}, str, objArr[1]);
        }
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = new TdiCallbackTaskInfo(str, str2, clsArr, objArr);
        this.mServiceHandler.sendMessage(obtainMessage);
    }

    @Override // com.tencent.ilinkservice.IlinkServiceTdiCallback.IlinkServiceTdiCallbackObserver
    public String getCallerByTaskid(int i3) {
        if (this.m_tdi_taskid_caller_map_.containsKey(new Integer(i3))) {
            return this.m_tdi_taskid_caller_map_.get(new Integer(i3));
        }
        return "";
    }

    @Override // com.tencent.ilinkservice.IlinkServiceTdiCallback.IlinkServiceTdiCallbackObserver
    public Vector<String> getCloneCallers(String str) {
        return this.m_appid_clonecaller_map_.get(str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("initpara");
        if (byteArrayExtra == null) {
            Log.e(TAG, "initpara should not be null just restart");
            SystemMethodProxy.killProcess(Process.myPid());
        }
        try {
            this.m_ilink_init_param_ = IlinkServiceProto.InitParameter.parseFrom(byteArrayExtra);
            this.m_file_dir_ = getExternalFilesDir(null) + "/ilinkservice";
            File file = new File(this.m_file_dir_);
            if (!file.exists()) {
                Log.d(TAG, "try to create dir:" + this.m_file_dir_);
                file.mkdirs();
            } else {
                Log.d(TAG, "dir exit:" + this.m_file_dir_);
            }
            if (this.m_ilink_init_param_.getRunningMode() == 0) {
                this.m_login_running = true;
                this.m_ilink_manager_.start(this.m_file_dir_, this.m_ilink_init_param_, getPackageName());
            } else {
                this.m_ilink_manager_.AppModeStart(this.m_file_dir_, this.m_ilink_init_param_, getPackageName());
                this.m_tdi_init_param_ = TdiApiProto.TdiInitParameter.newBuilder().setAppDir(this.m_file_dir_).setIlinkProductId(this.m_ilink_init_param_.getProductId()).build();
            }
            Log.d(TAG, "onBind by:" + intent.getStringExtra("caller"));
            Log.d(TAG, "init para len:" + intent.getByteArrayExtra("initpara").length);
            Log.i(TAG, "Ilink service version:33555213, git revision:dff0888");
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("c++_shared");
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("linkid");
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("owl");
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("ilink_xlog");
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("ilink_network");
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("private_protobuf");
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("ilink_tdi");
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("ilink_dev");
        Log.d(TAG, "Finish load library!");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ServiceThread", 10);
        this.m_task_thread_ = baseHandlerThread;
        baseHandlerThread.start();
        this.mServiceLooper = this.m_task_thread_.getLooper();
        PlatformComm.init(getApplicationContext(), new Handler(this.mServiceLooper));
        this.m_ilink_manager_ = new IlinkDeviceManager(this);
        b.b().a(this);
        this.mServiceHandler = new ServiceHandler(this.mServiceLooper);
        this.m_timer.schedule(this.m_testtask, 5000L, 30000L);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.m_appid_cloneticket_map_.clear();
        this.m_appid_clonecaller_map_.clear();
        this.m_tdi_taskid_caller_map_.clear();
        this.m_caller_cookie_map_.clear();
        this.m_remote_callback_list_.kill();
        synchronized (this.m_appid_tdisession_map_) {
            Enumeration<TdiSessionInfo> elements = this.m_appid_tdisession_map_.elements();
            while (elements.hasMoreElements()) {
                TdiSessionInfo nextElement = elements.nextElement();
                nextElement.m_tdi_.getTdiManager().uninit();
                nextElement.m_tdi_.destroy();
            }
            this.m_appid_tdisession_map_.clear();
        }
        this.m_timer.cancel();
        this.m_task_thread_.getLooper().quit();
        try {
            this.m_task_thread_.join();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
            Log.e(TAG, "thread join failed!");
        }
        this.m_task_thread_ = null;
        if (this.m_ilink_im_manager_ != null) {
            Log.i(TAG, "going to stop im manager");
            this.m_ilink_im_manager_.stop();
            this.m_ilink_im_manager_ = null;
        }
        Log.i(TAG, "going to stop ilink manager");
        this.m_ilink_manager_.stopUploadLog();
        b.b().a();
        if (this.m_ilink_init_param_.getRunningMode() == 0) {
            this.m_ilink_manager_.stop();
        } else {
            this.m_ilink_manager_.AppModeStop();
        }
        this.m_ilink_manager_ = null;
        SystemMethodProxy.killProcess(Process.myPid());
    }

    public void onLocalLoginComplete(int i3, int i16) {
        if (i3 == 0) {
            a aVar = new a();
            aVar.a(this.m_ilink_manager_.getIlinkId());
            this.m_profile_ = aVar.a();
            this.m_token_ = this.m_ilink_manager_.getToken();
            this.m_tdi_init_param_ = TdiApiProto.TdiInitParameter.newBuilder().setAppDir(this.m_file_dir_).setIlinkProductId(this.m_ilink_init_param_.getProductId()).setIlinkSn(this.m_ilink_init_param_.getDeviceId()).setIlinkId(this.m_ilink_manager_.getIlinkId()).setIlinkToken(this.m_token_).build();
            this.m_login_state_ = true;
            this.m_login_running = false;
            Enumeration<TdiSessionInfo> elements = this.m_appid_tdisession_map_.elements();
            while (elements.hasMoreElements()) {
                elements.nextElement().m_tdi_.getTdiManager().updateIlinkToken(this.m_token_);
            }
        } else {
            this.m_profile_ = new byte[0];
            this.m_token_ = "";
            this.m_login_state_ = false;
            this.m_login_running = false;
        }
        Class cls = Integer.TYPE;
        addDeviceCallbackTask("", "onNewLoginComplete", new Class[]{cls, cls, byte[].class, String.class}, Integer.valueOf(i3), Integer.valueOf(i16), this.m_profile_, this.m_token_);
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceManager.IlinkDeviceObserver
    public void onLoginComplete(int i3, int i16) {
        Class cls = Integer.TYPE;
        addLocalTask(this.m_service_obj_, IlinkService.class, "onLocalLoginComplete", new Class[]{cls, cls}, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind by:" + intent.getStringExtra("caller"));
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind by:" + intent.getStringExtra("caller"));
        return true;
    }
}
