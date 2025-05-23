package com.tencent.ilinkservice;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.dev.proto.IlinkDevApi;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.ilinkservice.IIlinkServiceCallback;
import com.tencent.ilinkservice.IIlinkServiceInterface;
import com.tencent.ilinkservice.IlinkServiceProto;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkServiceImpl {
    private static final String TAG = "IlinkServiceImpl";
    private static AtomicInteger m_local_taskid_ = new AtomicInteger(0);
    private IIlinkServiceCallback m_callback_;
    private Context m_context_;
    private Intent m_current_bind_intent_;
    private Vector<IlinkDeviceImpl> m_device_interfaces_;
    private ConcurrentHashMap<Integer, String> m_device_local_msgid_;
    private byte[] m_device_profile_;
    private String m_device_token_;
    private IIlinkServiceInterface m_ilink_service_;
    private ConcurrentHashMap<String, IlinkImSessionImpl> m_imsession_map_;
    private byte[] m_init_parameter_;
    private boolean m_isbound;
    private ConcurrentHashMap<Integer, Integer> m_local_svr_taskid_;
    private String m_process_name_;
    private String m_self_package_name_;
    private Vector<IlinkServiceCallback> m_service_callbacks_;
    private String m_service_cookie_;
    private ServiceConnection m_serviceconn_;
    private ConcurrentHashMap<String, IlinkTdiSessionImpl> m_tdisession_map_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SingletonLoader {
        private static IlinkServiceImpl singletonStatic = new IlinkServiceImpl();

        SingletonLoader() {
        }
    }

    private static String GeneralCookie(String str) {
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
            IlinkServiceLogImpl.getInstance().e(TAG, "no such algorithm:" + e16.toString(), new Object[0]);
            e16.printStackTrace();
            return str2;
        }
    }

    public static IlinkServiceImpl getInstance() {
        return SingletonLoader.singletonStatic;
    }

    private static String getProcessName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null) {
            IlinkServiceLogImpl.getInstance().e(TAG, "runningApps is null general one!", new Object[0]);
            return GeneralCookie(context.getPackageName());
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                IlinkServiceLogImpl.getInstance().d(TAG, "Process name is:" + runningAppProcessInfo.processName, new Object[0]);
                return runningAppProcessInfo.processName;
            }
        }
        IlinkServiceLogImpl.getInstance().e(TAG, "can not get process name general one!", new Object[0]);
        return GeneralCookie(context.getPackageName());
    }

    public byte[] ReqCommFunctionWithResp(String str, byte[] bArr) {
        IIlinkServiceInterface iIlinkServiceInterface = this.m_ilink_service_;
        if (iIlinkServiceInterface == null) {
            return null;
        }
        try {
            return iIlinkServiceInterface.ReqCommFunctionWithResp(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012f A[Catch: InvalidProtocolBufferException -> 0x0190, RemoteException -> 0x0195, TryCatch #2 {RemoteException -> 0x0195, InvalidProtocolBufferException -> 0x0190, blocks: (B:6:0x000b, B:9:0x001c, B:11:0x0038, B:26:0x0098, B:28:0x00b5, B:30:0x00ce, B:32:0x00d8, B:34:0x011f, B:36:0x012f, B:38:0x0139, B:40:0x0180, B:42:0x0061, B:45:0x006c, B:48:0x0077, B:51:0x0082), top: B:5:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ReqCommFunctionWithTaskid(String str, byte[] bArr, int i3) {
        char c16;
        if (this.m_ilink_service_ == null) {
            return;
        }
        try {
            Integer num = new Integer(i3);
            if (!this.m_local_svr_taskid_.containsKey(num)) {
                IlinkServiceLogImpl.getInstance().d(TAG, "app request not longer need localtaskid:" + i3, new Object[0]);
                return;
            }
            byte[] ReqCommFunctionWithResp = this.m_ilink_service_.ReqCommFunctionWithResp(this.m_process_name_, this.m_service_cookie_, str, bArr);
            int hashCode = str.hashCode();
            if (hashCode != -1911188865) {
                if (hashCode != -960765421) {
                    if (hashCode != 665062988) {
                        if (hashCode == 686849420 && str.equals("getDeviceShadow")) {
                            c16 = 0;
                            if (c16 == 0) {
                                if (c16 != 1) {
                                    if (c16 != 2 && c16 != 3) {
                                        IlinkServiceLogImpl.getInstance().e(TAG, "not supported function:" + str, new Object[0]);
                                        return;
                                    }
                                    int taskid = AidlProto.commFunctionTaskidResp.parseFrom(ReqCommFunctionWithResp).getTaskid();
                                    this.m_local_svr_taskid_.remove(num);
                                    this.m_local_svr_taskid_.put(num, new Integer(taskid));
                                    return;
                                }
                                int taskid2 = AidlProto.updateDeviceShadowResp.parseFrom(ReqCommFunctionWithResp).getTaskid();
                                if (taskid2 == 0) {
                                    IlinkServiceLogImpl.getInstance().e(TAG, "send updateDeviceShadow error try to invoke callback!", new Object[0]);
                                    AidlProto.updateDeviceShadowReq parseFrom = AidlProto.updateDeviceShadowReq.parseFrom(bArr);
                                    Class cls = Integer.TYPE;
                                    IlinkApiTaskManager.getInstance().addTask(this.m_imsession_map_.get(parseFrom.getAppid()), IlinkImSessionImpl.class, "onUpdateDeviceShadow", new Class[]{cls, cls, byte[].class}, Integer.valueOf(i3), -1, new byte[0]);
                                    return;
                                }
                                this.m_local_svr_taskid_.remove(num);
                                this.m_local_svr_taskid_.put(num, new Integer(taskid2));
                                return;
                            }
                            int taskid3 = AidlProto.getDeviceShadowResp.parseFrom(ReqCommFunctionWithResp).getTaskid();
                            if (taskid3 == 0) {
                                IlinkServiceLogImpl.getInstance().e(TAG, "send getDeviceShadow error try to invoke callback!", new Object[0]);
                                AidlProto.getDeviceShadowReq parseFrom2 = AidlProto.getDeviceShadowReq.parseFrom(bArr);
                                Class cls2 = Integer.TYPE;
                                IlinkApiTaskManager.getInstance().addTask(this.m_imsession_map_.get(parseFrom2.getAppid()), IlinkImSessionImpl.class, "onGetDeviceShadow", new Class[]{cls2, cls2, byte[].class}, Integer.valueOf(i3), -1, new byte[0]);
                                return;
                            }
                            this.m_local_svr_taskid_.remove(num);
                            this.m_local_svr_taskid_.put(num, new Integer(taskid3));
                            return;
                        }
                        c16 = '\uffff';
                        if (c16 == 0) {
                        }
                    } else {
                        if (str.equals("startCdnUpload")) {
                            c16 = 2;
                            if (c16 == 0) {
                            }
                        }
                        c16 = '\uffff';
                        if (c16 == 0) {
                        }
                    }
                } else {
                    if (str.equals("startCdnDownload")) {
                        c16 = 3;
                        if (c16 == 0) {
                        }
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                }
            } else {
                if (str.equals("updateDeviceShadow")) {
                    c16 = 1;
                    if (c16 == 0) {
                    }
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
            }
        } catch (RemoteException e16) {
            e16.printStackTrace();
        } catch (InvalidProtocolBufferException e17) {
            e17.printStackTrace();
        }
    }

    public void SetSmcUin(String str, int i3) {
        try {
            this.m_ilink_service_.SetSmcUin(this.m_process_name_, this.m_service_cookie_, str, i3);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void WriteKvData(String str, byte[] bArr) {
        try {
            this.m_ilink_service_.WriteKvData(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public int addAppRequestTask() {
        int incrementAndGet = m_local_taskid_.incrementAndGet();
        if (incrementAndGet == 0) {
            incrementAndGet = m_local_taskid_.incrementAndGet();
        }
        this.m_local_svr_taskid_.put(Integer.valueOf(incrementAndGet), 0);
        return incrementAndGet;
    }

    public int addDeviceMessageTask() {
        int incrementAndGet = m_local_taskid_.incrementAndGet();
        if (incrementAndGet == 0) {
            return m_local_taskid_.incrementAndGet();
        }
        return incrementAndGet;
    }

    public IlinkImSessionImpl addImSession(String str) {
        if (this.m_imsession_map_.containsKey(str)) {
            IlinkServiceLogImpl.getInstance().e(TAG, "Im session map already has session for appid:" + str, new Object[0]);
            IlinkServiceLogImpl.getInstance().e(TAG, "Maybe you forgot to call deleteImSession first?", new Object[0]);
            return this.m_imsession_map_.get(str);
        }
        IlinkImSessionImpl ilinkImSessionImpl = new IlinkImSessionImpl(str);
        this.m_imsession_map_.put(str, ilinkImSessionImpl);
        return ilinkImSessionImpl;
    }

    public IlinkTdiSessionImpl addTdiSession(String str) {
        if (this.m_tdisession_map_.containsKey(str)) {
            IlinkServiceLogImpl.getInstance().e(TAG, "Tdi session map already has session for appid:" + str, new Object[0]);
            IlinkServiceLogImpl.getInstance().e(TAG, "Maybe you forgot to call deleteTdiSession first?", new Object[0]);
            return this.m_tdisession_map_.get(str);
        }
        IlinkTdiSessionImpl ilinkTdiSessionImpl = new IlinkTdiSessionImpl(str, false);
        this.m_tdisession_map_.put(str, ilinkTdiSessionImpl);
        return ilinkTdiSessionImpl;
    }

    public void autoLogin(String str) {
        try {
            this.m_ilink_service_.tdiAutoLogin(this.m_process_name_, this.m_service_cookie_, str);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void cancel(String str, int i3) {
        try {
            this.m_ilink_service_.cancel(this.m_process_name_, this.m_service_cookie_, str, i3);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void cancelAppRequest(String str, int i3) {
        try {
            this.m_ilink_service_.cancelAppRequest(this.m_process_name_, this.m_service_cookie_, str, i3);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void cancelOAuth(String str, byte[] bArr, int i3) {
        try {
            Integer num = new Integer(i3);
            if (!this.m_local_svr_taskid_.containsKey(num)) {
                IlinkServiceLogImpl.getInstance().d(TAG, "cancelOAuth not longer need localtaskid:" + i3, new Object[0]);
                return;
            }
            int cancelOAuth = this.m_ilink_service_.cancelOAuth(this.m_process_name_, this.m_service_cookie_, str, bArr);
            if (cancelOAuth == 0) {
                IlinkServiceLogImpl.getInstance().e(TAG, "cancelOAuth error try to invoke callback!", new Object[0]);
                Class cls = Integer.TYPE;
                IlinkApiTaskManager.getInstance().addTask(this.m_tdisession_map_.get(str), IlinkTdiSessionImpl.class, "onCancelOAuthComplete", new Class[]{cls, cls}, Integer.valueOf(i3), -1);
                return;
            }
            this.m_local_svr_taskid_.remove(num);
            this.m_local_svr_taskid_.put(num, new Integer(cancelOAuth));
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void cancelRequest(String str, int i3) {
        try {
            this.m_ilink_service_.cancelRequest(this.m_process_name_, this.m_service_cookie_, str, i3);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void checkLoginQrCode(String str) {
        try {
            this.m_ilink_service_.checkLoginQrCode(this.m_process_name_, this.m_service_cookie_, str);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void cloneMultiProcessTdiSession(String str, String str2) {
        try {
            this.m_ilink_service_.cloneMultiProcessTdiSession(this.m_process_name_, this.m_service_cookie_, str, str2);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public IlinkDeviceImpl createDeviceInterface() {
        IlinkDeviceImpl ilinkDeviceImpl;
        synchronized (this.m_device_interfaces_) {
            ilinkDeviceImpl = new IlinkDeviceImpl();
            this.m_device_interfaces_.add(ilinkDeviceImpl);
        }
        return ilinkDeviceImpl;
    }

    public void createTdiSession(String str) {
        try {
            this.m_ilink_service_.createTdiSession(this.m_process_name_, this.m_service_cookie_, str);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void destroyDeviceInterface(IlinkDeviceImpl ilinkDeviceImpl) {
        synchronized (this.m_device_interfaces_) {
            ilinkDeviceImpl.setDestroyed();
            this.m_device_interfaces_.remove(ilinkDeviceImpl);
        }
    }

    public void destroyMultiProcessTdiSession(String str) {
        try {
            this.m_ilink_service_.destroyMultiProcessTdiSession(this.m_process_name_, this.m_service_cookie_, str);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void destroyTdiSession(String str) {
        try {
            this.m_ilink_service_.destroyTdiSession(this.m_process_name_, this.m_service_cookie_, str);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void faceExtVerify(String str, byte[] bArr) {
        try {
            this.m_ilink_service_.faceExtVerify(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void faceLogin(String str, byte[] bArr) {
        try {
            this.m_ilink_service_.faceLogin(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void faceRecognize(String str, byte[] bArr) {
        try {
            this.m_ilink_service_.faceRecognize(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void faceRecognizeConfig(String str, byte[] bArr) {
        try {
            this.m_ilink_service_.faceRecognizeConfig(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void getAppPushToken(String str, byte[] bArr, int i3) {
        try {
            Integer num = new Integer(i3);
            if (!this.m_local_svr_taskid_.containsKey(num)) {
                IlinkServiceLogImpl.getInstance().d(TAG, "getAppPushToken not longer need localtaskid:" + i3, new Object[0]);
                return;
            }
            int newgetAppPushToken = this.m_ilink_service_.newgetAppPushToken(this.m_process_name_, this.m_service_cookie_, str, bArr);
            if (newgetAppPushToken == 0) {
                IlinkServiceLogImpl.getInstance().e(TAG, "getAppPushToken error try to invoke callback!", new Object[0]);
                Class cls = Integer.TYPE;
                IlinkApiTaskManager.getInstance().addTask(this.m_tdisession_map_.get(str), IlinkTdiSessionImpl.class, "onGetAppPushTokenComplete", new Class[]{cls, cls, byte[].class}, Integer.valueOf(i3), -1, TdiApiProto.TdiAppPushToken.newBuilder().setToken(ByteString.copyFrom("".getBytes())).setExpireTimestamp(0).build().toByteArray());
                return;
            }
            this.m_local_svr_taskid_.remove(num);
            this.m_local_svr_taskid_.put(num, new Integer(newgetAppPushToken));
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public Context getContext() {
        return this.m_context_;
    }

    public void getLoginQrCode(String str, byte[] bArr) {
        try {
            this.m_ilink_service_.newgetLoginQrCode(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void getOAuthCode(String str, byte[] bArr, int i3) {
        try {
            Integer num = new Integer(i3);
            if (!this.m_local_svr_taskid_.containsKey(num)) {
                IlinkServiceLogImpl.getInstance().d(TAG, "getOAuthCode not longer need localtaskid:" + i3, new Object[0]);
                return;
            }
            int oAuthCode = this.m_ilink_service_.getOAuthCode(this.m_process_name_, this.m_service_cookie_, str, bArr);
            if (oAuthCode == 0) {
                IlinkServiceLogImpl.getInstance().e(TAG, "getOAuthCode error try to invoke callback!", new Object[0]);
                Class cls = Integer.TYPE;
                IlinkApiTaskManager.getInstance().addTask(this.m_tdisession_map_.get(str), IlinkTdiSessionImpl.class, "onGetOAuthCodeComplete", new Class[]{cls, cls, byte[].class}, Integer.valueOf(i3), -1, TdiApiProto.TdiGetOAuthCodeResponse.newBuilder().setOauthCode(ByteString.copyFrom("".getBytes())).build().toByteArray());
                return;
            }
            this.m_local_svr_taskid_.remove(num);
            this.m_local_svr_taskid_.put(num, new Integer(oAuthCode));
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public byte[] getProfile() {
        byte[] bArr = this.m_device_profile_;
        if (bArr == null) {
            return new byte[0];
        }
        return bArr;
    }

    public String getToken() {
        String str = this.m_device_token_;
        if (str == null) {
            return "";
        }
        return str;
    }

    public byte[] getUserInfo(String str) {
        IIlinkServiceInterface iIlinkServiceInterface = this.m_ilink_service_;
        if (iIlinkServiceInterface == null) {
            return null;
        }
        try {
            return iIlinkServiceInterface.getUserInfo(this.m_process_name_, this.m_service_cookie_, str);
        } catch (RemoteException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void handleAnnounceResult(Intent intent) {
        IlinkServiceLogImpl.getInstance().d(TAG, "handleAnnounceResult do nothing in standalone module!", new Object[0]);
    }

    public void handleVoteResult(Intent intent, Bundle bundle) {
        IlinkServiceLogImpl.getInstance().d(TAG, "handleVoteResult do nothing in standalone module!", new Object[0]);
    }

    public boolean isAlreadyGetStrategy() {
        IIlinkServiceInterface iIlinkServiceInterface = this.m_ilink_service_;
        if (iIlinkServiceInterface == null) {
            return false;
        }
        try {
            return iIlinkServiceInterface.isAlreadyGetStrategy(this.m_process_name_, this.m_service_cookie_);
        } catch (RemoteException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean isAppidImSessionExit(String str) {
        if (this.m_imsession_map_.containsKey(str)) {
            return true;
        }
        return false;
    }

    public boolean isAppidTdiSessionExit(String str) {
        if (this.m_tdisession_map_.containsKey(str)) {
            return true;
        }
        return false;
    }

    public boolean isDeviceLoginSuccess() {
        try {
            if (IlinkServiceProto.InitParameter.parseFrom(this.m_init_parameter_).getRunningMode() == 1) {
                return true;
            }
            return !this.m_device_token_.equals("");
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean isImSessionValid(IlinkImSessionImpl ilinkImSessionImpl) {
        if (this.m_imsession_map_.containsValue(ilinkImSessionImpl)) {
            return true;
        }
        return false;
    }

    public boolean isTdiSessionValid(IlinkTdiSessionImpl ilinkTdiSessionImpl) {
        if (this.m_tdisession_map_.containsValue(ilinkTdiSessionImpl)) {
            return true;
        }
        return false;
    }

    public void logOut(String str) {
        try {
            this.m_ilink_service_.tdiLogOut(this.m_process_name_, this.m_service_cookie_, str);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void oauthLogin(String str, byte[] bArr) {
        try {
            this.m_ilink_service_.oauthLogin(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void qrCodeLogin(String str, byte[] bArr) {
        try {
            this.m_ilink_service_.qrCodeLogin(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void receiveAnnounceMsg(Intent intent) {
        IlinkServiceLogImpl.getInstance().d(TAG, "receiveAnnounceMsg do nothing in standalone module!", new Object[0]);
    }

    public void receiveAnswer(String str, String str2, int i3) {
        IlinkServiceLogImpl.getInstance().d(TAG, "receiveAnswer do nothing in standalone module!", new Object[0]);
    }

    public Bundle receiveVoteMsg(Intent intent, Bundle bundle) {
        IlinkServiceLogImpl.getInstance().d(TAG, "receiveVoteMsg do nothing in standalone module!", new Object[0]);
        return bundle;
    }

    public void registCallback(IlinkServiceCallback ilinkServiceCallback) {
        synchronized (this.m_service_callbacks_) {
            this.m_service_callbacks_.add(ilinkServiceCallback);
        }
    }

    public int removeAppRequestTask(int i3) {
        Integer num = new Integer(i3);
        if (this.m_local_svr_taskid_.containsKey(num)) {
            Integer num2 = this.m_local_svr_taskid_.get(num);
            this.m_local_svr_taskid_.remove(num);
            return num2.intValue();
        }
        return 0;
    }

    public void removeImSession(String str) {
        if (this.m_imsession_map_.containsKey(str)) {
            IlinkServiceLogImpl.getInstance().d(TAG, "Find Im session for appid:" + str, new Object[0]);
            this.m_imsession_map_.get(str).cancelAllImRequest();
            this.m_imsession_map_.remove(str);
            return;
        }
        IlinkServiceLogImpl.getInstance().w(TAG, "im obj not exit appid:" + str, new Object[0]);
    }

    public void removeTdiSession(String str) {
        if (this.m_tdisession_map_.containsKey(str)) {
            IlinkServiceLogImpl.getInstance().d(TAG, "Find Tdi session for appid:" + str, new Object[0]);
            this.m_tdisession_map_.get(str).cancelAllAppRequest();
            this.m_tdisession_map_.get(str).destroyAllCloneSession();
            this.m_tdisession_map_.remove(str);
            return;
        }
        IlinkServiceLogImpl.getInstance().w(TAG, "tdi obj not exit appid:" + str, new Object[0]);
    }

    public void requestMultiProcessCloneTicket(String str) {
        try {
            this.m_ilink_service_.requestMultiProcessCloneTicket(this.m_process_name_, this.m_service_cookie_, str);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void sendAppRequest(String str, byte[] bArr, int i3) {
        try {
            Integer num = new Integer(i3);
            if (!this.m_local_svr_taskid_.containsKey(num)) {
                IlinkServiceLogImpl.getInstance().d(TAG, "app request not longer need localtaskid:" + i3, new Object[0]);
                return;
            }
            int sendAppRequest = this.m_ilink_service_.sendAppRequest(this.m_process_name_, this.m_service_cookie_, str, bArr);
            if (sendAppRequest == 0) {
                IlinkServiceLogImpl.getInstance().e(TAG, "send app request error try to invoke callback!", new Object[0]);
                Class cls = Integer.TYPE;
                IlinkApiTaskManager.getInstance().addTask(this.m_tdisession_map_.get(str), IlinkTdiSessionImpl.class, "onReceiveAppResponse", new Class[]{cls, cls, byte[].class}, Integer.valueOf(i3), -1, TdiApiProto.TdiAppResponse.newBuilder().setBody(ByteString.copyFrom("".getBytes())).build().toByteArray());
                return;
            }
            this.m_local_svr_taskid_.remove(num);
            this.m_local_svr_taskid_.put(num, new Integer(sendAppRequest));
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void sendIotMessage(String str, String str2, String str3, String str4, int i3) {
        try {
            String newSendIotMessage = this.m_ilink_service_.newSendIotMessage(this.m_process_name_, this.m_service_cookie_, str, str2, str3, str4);
            if (newSendIotMessage == null) {
                IlinkServiceLogImpl.getInstance().e(TAG, "sendIotMessage error try to invoke callback!", new Object[0]);
                synchronized (this.m_device_interfaces_) {
                    Class cls = Integer.TYPE;
                    Class[] clsArr = {cls, cls};
                    for (int i16 = 0; i16 < this.m_device_interfaces_.size(); i16++) {
                        IlinkApiTaskManager.getInstance().addTask(this.m_device_interfaces_.get(i16), IlinkDeviceImpl.class, "onSendMsgResult", clsArr, -1, Integer.valueOf(i3));
                    }
                }
                return;
            }
            synchronized (this.m_device_local_msgid_) {
                this.m_device_local_msgid_.put(Integer.valueOf(i3), newSendIotMessage);
            }
            return;
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
        e16.printStackTrace();
    }

    public void setConsoleLogOpen(boolean z16) {
        IIlinkServiceInterface iIlinkServiceInterface = this.m_ilink_service_;
        if (iIlinkServiceInterface == null) {
            return;
        }
        try {
            iIlinkServiceInterface.setConsoleLogOpen(this.m_process_name_, this.m_service_cookie_, z16);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void setLogLevel(int i3) {
        IIlinkServiceInterface iIlinkServiceInterface = this.m_ilink_service_;
        if (iIlinkServiceInterface == null) {
            return;
        }
        try {
            iIlinkServiceInterface.setLogLevel(this.m_process_name_, this.m_service_cookie_, i3);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void setProxyInfo(byte[] bArr) {
        try {
            this.m_ilink_service_.setProxyInfo(this.m_process_name_, this.m_service_cookie_, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public synchronized void start(Context context, byte[] bArr) {
        if (this.m_context_ != null) {
            IlinkServiceLogImpl.getInstance().d(TAG, "Service already running!", new Object[0]);
            return;
        }
        this.m_context_ = context;
        this.m_init_parameter_ = bArr;
        this.m_self_package_name_ = context.getPackageName();
        this.m_process_name_ = getProcessName(this.m_context_);
        IlinkServiceLogImpl.getInstance().d(TAG, "my process name is:" + this.m_process_name_, new Object[0]);
        this.m_current_bind_intent_.setAction("com.tencent.ilinkservice.StartIlinkService");
        this.m_current_bind_intent_.setPackage(this.m_self_package_name_);
        this.m_current_bind_intent_.putExtra("caller", this.m_process_name_);
        this.m_current_bind_intent_.putExtra("initpara", this.m_init_parameter_);
        this.m_isbound = this.m_context_.bindService(this.m_current_bind_intent_, this.m_serviceconn_, 1);
    }

    public void stop() {
        if (this.m_context_ == null) {
            return;
        }
        IIlinkServiceInterface iIlinkServiceInterface = this.m_ilink_service_;
        if (iIlinkServiceInterface != null) {
            try {
                iIlinkServiceInterface.unregisterCallback(this.m_process_name_, this.m_service_cookie_, this.m_callback_);
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
            if (this.m_isbound) {
                this.m_context_.unbindService(this.m_serviceconn_);
                this.m_isbound = false;
            }
        }
        IlinkApiTaskManager.getInstance().setIlinkServiceAvailable(false);
        IlinkApiTaskManager.getInstance().clearTask();
        this.m_ilink_service_ = null;
        this.m_service_callbacks_.clear();
        this.m_tdisession_map_.clear();
        this.m_imsession_map_.clear();
        this.m_local_svr_taskid_.clear();
        this.m_device_local_msgid_.clear();
        synchronized (this.m_device_interfaces_) {
            for (int i3 = 0; i3 < this.m_device_interfaces_.size(); i3++) {
                this.m_device_interfaces_.get(i3).setDestroyed();
            }
        }
        this.m_device_interfaces_.clear();
        this.m_device_profile_ = null;
        this.m_device_token_ = "";
        this.m_context_ = null;
    }

    public void unregistCallback(IlinkServiceCallback ilinkServiceCallback) {
        synchronized (this.m_service_callbacks_) {
            this.m_service_callbacks_.remove(ilinkServiceCallback);
        }
    }

    public void updateDeviceInfo(int i3, String str, int i16) {
        if (this.m_ilink_service_ == null) {
            return;
        }
        try {
            IlinkDevApi.IlinkDeviceParams.Builder newBuilder = IlinkDevApi.IlinkDeviceParams.newBuilder();
            newBuilder.setIlinkProductId(i3);
            newBuilder.setSignature(str);
            newBuilder.setSignatureTimestamp(i16);
            byte[] byteArray = newBuilder.build().toByteArray();
            IlinkServiceProto.InitParameter.Builder newBuilder2 = IlinkServiceProto.InitParameter.newBuilder(IlinkServiceProto.InitParameter.parseFrom(this.m_init_parameter_));
            newBuilder2.setProductId(i3);
            if (str.length() != 0) {
                newBuilder2.setDeviceSignature(str);
                newBuilder2.setSignatureTimestamp(i16);
            }
            this.m_init_parameter_ = newBuilder2.build().toByteArray();
            this.m_ilink_service_.updateDeviceInfo(this.m_process_name_, this.m_service_cookie_, byteArray);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        } catch (InvalidProtocolBufferException e17) {
            e17.printStackTrace();
        }
    }

    public void voidCommFunction(String str, byte[] bArr) {
        IIlinkServiceInterface iIlinkServiceInterface = this.m_ilink_service_;
        if (iIlinkServiceInterface == null) {
            return;
        }
        try {
            iIlinkServiceInterface.voidCommFunction(this.m_process_name_, this.m_service_cookie_, str, bArr);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void writeLogToService(int i3, String str, String str2) {
        try {
            this.m_ilink_service_.writeLogToFile(i3, str, str2);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    IlinkServiceImpl() {
        this.m_context_ = null;
        this.m_current_bind_intent_ = new Intent();
        this.m_local_svr_taskid_ = new ConcurrentHashMap<>();
        this.m_tdisession_map_ = new ConcurrentHashMap<>();
        this.m_imsession_map_ = new ConcurrentHashMap<>();
        this.m_service_callbacks_ = new Vector<>();
        this.m_device_interfaces_ = new Vector<>();
        this.m_device_token_ = "";
        this.m_device_local_msgid_ = new ConcurrentHashMap<>();
        this.m_isbound = false;
        this.m_callback_ = new IIlinkServiceCallback.Stub() { // from class: com.tencent.ilinkservice.IlinkServiceImpl.1
            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void OnCommonFunctionCallback(String str, byte[] bArr) throws RemoteException {
                char c16;
                try {
                    switch (str.hashCode()) {
                        case -2048132833:
                            if (str.equals("onImLoginComplete")) {
                                c16 = 5;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -902085954:
                            if (str.equals("onUpdateDeviceShadow")) {
                                c16 = 3;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -839542850:
                            if (str.equals("onDeviceShadowUpdate")) {
                                c16 = 4;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -743462577:
                            if (str.equals("onC2CUploadComplete")) {
                                c16 = 1;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -740831827:
                            if (str.equals("onGetDeviceShadow")) {
                                c16 = 2;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -696712298:
                            if (str.equals("onC2CDownloadComplete")) {
                                c16 = 0;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -68026435:
                            if (str.equals("onUploadLogComplete")) {
                                c16 = 6;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1161786580:
                            if (str.equals(IlinkLiveServiceImpl.ILINKLIVE_SERVICE_CALLBACK)) {
                                c16 = 7;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        default:
                            c16 = '\uffff';
                            break;
                    }
                    switch (c16) {
                        case 0:
                            AidlProto.onCommFunctionCallback parseFrom = AidlProto.onCommFunctionCallback.parseFrom(bArr);
                            if (IlinkServiceImpl.this.m_tdisession_map_.containsKey(parseFrom.getAppid())) {
                                synchronized (IlinkServiceImpl.this.m_local_svr_taskid_) {
                                    for (Integer num : IlinkServiceImpl.this.m_local_svr_taskid_.keySet()) {
                                        if (((Integer) IlinkServiceImpl.this.m_local_svr_taskid_.get(num)).intValue() == parseFrom.getTaskid()) {
                                            IlinkServiceImpl.this.m_local_svr_taskid_.remove(num);
                                            ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(parseFrom.getAppid())).onCdnDownloadCompleted(num.intValue(), parseFrom.getRespdata().toByteArray());
                                            return;
                                        }
                                    }
                                    IlinkServiceLogImpl.getInstance().w(IlinkServiceImpl.TAG, "task map not has svr task:" + parseFrom.getTaskid() + " maybe already canceled!", new Object[0]);
                                    return;
                                }
                            }
                            IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + parseFrom.getAppid(), new Object[0]);
                            return;
                        case 1:
                            AidlProto.onCommFunctionCallback parseFrom2 = AidlProto.onCommFunctionCallback.parseFrom(bArr);
                            if (IlinkServiceImpl.this.m_tdisession_map_.containsKey(parseFrom2.getAppid())) {
                                synchronized (IlinkServiceImpl.this.m_local_svr_taskid_) {
                                    for (Integer num2 : IlinkServiceImpl.this.m_local_svr_taskid_.keySet()) {
                                        if (((Integer) IlinkServiceImpl.this.m_local_svr_taskid_.get(num2)).intValue() == parseFrom2.getTaskid()) {
                                            IlinkServiceImpl.this.m_local_svr_taskid_.remove(num2);
                                            ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(parseFrom2.getAppid())).onCdnUploadCompleted(num2.intValue(), parseFrom2.getRespdata().toByteArray());
                                            return;
                                        }
                                    }
                                    IlinkServiceLogImpl.getInstance().w(IlinkServiceImpl.TAG, "task map not has svr task:" + parseFrom2.getTaskid() + " maybe already canceled!", new Object[0]);
                                    return;
                                }
                            }
                            IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + parseFrom2.getAppid(), new Object[0]);
                            return;
                        case 2:
                            AidlProto.onGetDeviceShadow parseFrom3 = AidlProto.onGetDeviceShadow.parseFrom(bArr);
                            if (IlinkServiceImpl.this.m_imsession_map_.containsKey(parseFrom3.getAppid())) {
                                synchronized (IlinkServiceImpl.this.m_local_svr_taskid_) {
                                    for (Integer num3 : IlinkServiceImpl.this.m_local_svr_taskid_.keySet()) {
                                        if (((Integer) IlinkServiceImpl.this.m_local_svr_taskid_.get(num3)).intValue() == parseFrom3.getTaskid()) {
                                            IlinkServiceImpl.this.m_local_svr_taskid_.remove(num3);
                                            ((IlinkImSessionImpl) IlinkServiceImpl.this.m_imsession_map_.get(parseFrom3.getAppid())).onGetDeviceShadow(num3.intValue(), parseFrom3.getResult(), parseFrom3.getShadowdata().toByteArray());
                                            return;
                                        }
                                    }
                                    return;
                                }
                            }
                            IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "im session not exit call create first appid:" + parseFrom3.getAppid(), new Object[0]);
                            return;
                        case 3:
                            AidlProto.onUpdateDeviceShadow parseFrom4 = AidlProto.onUpdateDeviceShadow.parseFrom(bArr);
                            if (IlinkServiceImpl.this.m_imsession_map_.containsKey(parseFrom4.getAppid())) {
                                synchronized (IlinkServiceImpl.this.m_local_svr_taskid_) {
                                    for (Integer num4 : IlinkServiceImpl.this.m_local_svr_taskid_.keySet()) {
                                        if (((Integer) IlinkServiceImpl.this.m_local_svr_taskid_.get(num4)).intValue() == parseFrom4.getTaskid()) {
                                            IlinkServiceImpl.this.m_local_svr_taskid_.remove(num4);
                                            ((IlinkImSessionImpl) IlinkServiceImpl.this.m_imsession_map_.get(parseFrom4.getAppid())).onUpdateDeviceShadow(num4.intValue(), parseFrom4.getResult(), parseFrom4.getShadowdata().toByteArray());
                                            return;
                                        }
                                    }
                                    return;
                                }
                            }
                            IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "im session not exit call create first appid:" + parseFrom4.getAppid(), new Object[0]);
                            return;
                        case 4:
                            AidlProto.onDeviceShadowUpdate parseFrom5 = AidlProto.onDeviceShadowUpdate.parseFrom(bArr);
                            if (!IlinkServiceImpl.this.m_imsession_map_.containsKey(parseFrom5.getAppid())) {
                                IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "im session not exit call create first appid:" + parseFrom5.getAppid(), new Object[0]);
                                return;
                            }
                            ((IlinkImSessionImpl) IlinkServiceImpl.this.m_imsession_map_.get(parseFrom5.getAppid())).onDeviceShadowUpdate(parseFrom5.getShadowdata().toByteArray());
                            return;
                        case 5:
                            AidlProto.onImLoginComplete parseFrom6 = AidlProto.onImLoginComplete.parseFrom(bArr);
                            if (!IlinkServiceImpl.this.m_imsession_map_.containsKey(parseFrom6.getAppid())) {
                                IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "im session not exit call create first appid:" + parseFrom6.getAppid(), new Object[0]);
                                return;
                            }
                            ((IlinkImSessionImpl) IlinkServiceImpl.this.m_imsession_map_.get(parseFrom6.getAppid())).onLoginComplete(parseFrom6.getResult());
                            return;
                        case 6:
                            AidlProto.onUploadLogComplete parseFrom7 = AidlProto.onUploadLogComplete.parseFrom(bArr);
                            synchronized (IlinkServiceImpl.this.m_device_interfaces_) {
                                for (int i3 = 0; i3 < IlinkServiceImpl.this.m_device_interfaces_.size(); i3++) {
                                    ((IlinkDeviceImpl) IlinkServiceImpl.this.m_device_interfaces_.get(i3)).onUploadLogComplete(parseFrom7.getErrcode());
                                }
                            }
                            return;
                        case 7:
                            IlinkLiveServiceImpl.getInstance().OnReceiveCommonCallback(bArr);
                            return;
                        default:
                            IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "not supported callback function:" + str, new Object[0]);
                            return;
                    }
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                }
                e16.printStackTrace();
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void OnRequestUploadLogfiles(String str, byte[] bArr) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onRequestUploadLogfiles(bArr);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onAppSessionTimeout(String str) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onAppSessionTimeout();
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onCancelOAuthComplete(String str, int i3, int i16) throws RemoteException {
                if (IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    synchronized (IlinkServiceImpl.this.m_local_svr_taskid_) {
                        for (Integer num : IlinkServiceImpl.this.m_local_svr_taskid_.keySet()) {
                            if (((Integer) IlinkServiceImpl.this.m_local_svr_taskid_.get(num)).intValue() == i3) {
                                IlinkServiceImpl.this.m_local_svr_taskid_.remove(num);
                                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onCancelOAuthComplete(num.intValue(), i16);
                                return;
                            }
                        }
                        IlinkServiceLogImpl.getInstance().w(IlinkServiceImpl.TAG, "task map not has svr task:" + i3 + " maybe already canceled!", new Object[0]);
                        return;
                    }
                }
                IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onCheckLoginQrCode(String str, int i3, byte[] bArr) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onCheckLoginQrCodeComplete(i3, bArr);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onCloneMultiProcessTdiSession(int i3, String str) throws RemoteException {
                IlinkTdiSessionImpl ilinkTdiSessionImpl = null;
                if (i3 == 0) {
                    if (IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                        IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session map already has session for appid:" + str, new Object[0]);
                        IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "There must be something wrong", new Object[0]);
                    } else {
                        ilinkTdiSessionImpl = new IlinkTdiSessionImpl(str, true);
                        IlinkServiceImpl.this.m_tdisession_map_.put(str, ilinkTdiSessionImpl);
                    }
                } else {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "failed to create clone tdi session:" + i3, new Object[0]);
                }
                synchronized (IlinkServiceImpl.this.m_service_callbacks_) {
                    for (int i16 = 0; i16 < IlinkServiceImpl.this.m_service_callbacks_.size(); i16++) {
                        ((IlinkServiceCallback) IlinkServiceImpl.this.m_service_callbacks_.get(i16)).onCloneMultiProcessTdiSession(i3, str, ilinkTdiSessionImpl);
                    }
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onDestroyMultiProcessTdiSession(String str) throws RemoteException {
                IlinkServiceLogImpl.getInstance().d(IlinkServiceImpl.TAG, "There is something wrong for the master tdi session and this clone session has been destroy!", new Object[0]);
                if (IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    if (((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).isCloneSession()) {
                        ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onCloneDestroyed();
                        IlinkServiceImpl.this.m_tdisession_map_.remove(str);
                        return;
                    }
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "it is not a clone session error:" + str, new Object[0]);
                    return;
                }
                IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "it is not in tdi session map:" + str, new Object[0]);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onFaceExtVerifyComplete(String str, int i3, byte[] bArr) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onFaceExtVerifyComplete(i3, bArr);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onFaceRecognizeComplete(String str, int i3, byte[] bArr) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onFaceRecognizeComplete(i3, bArr);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onFaceRecognizeConfigComplete(String str, int i3, byte[] bArr) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onFaceRecognizeConfigComplete(i3, bArr);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onFinishGetStrategy() throws RemoteException {
                synchronized (IlinkServiceImpl.this.m_device_interfaces_) {
                    for (int i3 = 0; i3 < IlinkServiceImpl.this.m_device_interfaces_.size(); i3++) {
                        ((IlinkDeviceImpl) IlinkServiceImpl.this.m_device_interfaces_.get(i3)).onFinishGetStrategy();
                    }
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onGetAppPushTokenComplete(String str, int i3, byte[] bArr) throws RemoteException {
                IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "aidl api not longger used!", new Object[0]);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onGetLoginQrCodeComplete(String str, int i3, byte[] bArr) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onGetLoginQrCodeComplete(i3, bArr);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onGetOAuthCodeComplete(String str, int i3, int i16, byte[] bArr) throws RemoteException {
                if (IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    synchronized (IlinkServiceImpl.this.m_local_svr_taskid_) {
                        for (Integer num : IlinkServiceImpl.this.m_local_svr_taskid_.keySet()) {
                            if (((Integer) IlinkServiceImpl.this.m_local_svr_taskid_.get(num)).intValue() == i3) {
                                IlinkServiceImpl.this.m_local_svr_taskid_.remove(num);
                                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onGetOAuthCodeComplete(num.intValue(), i16, bArr);
                                return;
                            }
                        }
                        IlinkServiceLogImpl.getInstance().w(IlinkServiceImpl.TAG, "task map not has svr task:" + i3 + " maybe already canceled!", new Object[0]);
                        return;
                    }
                }
                IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onLoginComplete(int i3, byte[] bArr, String str) throws RemoteException {
                IlinkServiceLogImpl.getInstance().d(IlinkServiceImpl.TAG, "old api Receive onlogin complete:" + i3, new Object[0]);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onLogoutComplete(String str, int i3) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onLogoutComplete(i3);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onNetStatusChanged(int i3) throws RemoteException {
                synchronized (IlinkServiceImpl.this.m_device_interfaces_) {
                    for (int i16 = 0; i16 < IlinkServiceImpl.this.m_device_interfaces_.size(); i16++) {
                        ((IlinkDeviceImpl) IlinkServiceImpl.this.m_device_interfaces_.get(i16)).onNetStatusChanged(i3);
                    }
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onNewGetAppPushTokenComplete(String str, int i3, int i16, byte[] bArr) throws RemoteException {
                if (IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    synchronized (IlinkServiceImpl.this.m_local_svr_taskid_) {
                        for (Integer num : IlinkServiceImpl.this.m_local_svr_taskid_.keySet()) {
                            if (((Integer) IlinkServiceImpl.this.m_local_svr_taskid_.get(num)).intValue() == i3) {
                                IlinkServiceImpl.this.m_local_svr_taskid_.remove(num);
                                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onGetAppPushTokenComplete(num.intValue(), i16, bArr);
                                return;
                            }
                        }
                        IlinkServiceLogImpl.getInstance().w(IlinkServiceImpl.TAG, "task map not has svr task:" + i3 + " maybe already canceled!", new Object[0]);
                        return;
                    }
                }
                IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onNewLoginComplete(int i3, int i16, byte[] bArr, String str) throws RemoteException {
                if (i3 == 0) {
                    IlinkServiceImpl.this.m_device_profile_ = bArr;
                    IlinkServiceImpl.this.m_device_token_ = str;
                } else {
                    IlinkServiceImpl.this.m_device_profile_ = new byte[0];
                    IlinkServiceImpl.this.m_device_token_ = "";
                }
                IlinkServiceLogImpl.getInstance().d(IlinkServiceImpl.TAG, "Receive onnewlogin complete:" + i3, new Object[0]);
                IlinkApiTaskManager.getInstance().writeLogToService(0, IlinkServiceImpl.TAG, IlinkServiceImpl.this.m_process_name_ + " Receive onnewlogin complete:" + i3);
                synchronized (IlinkServiceImpl.this.m_device_interfaces_) {
                    for (int i17 = 0; i17 < IlinkServiceImpl.this.m_device_interfaces_.size(); i17++) {
                        ((IlinkDeviceImpl) IlinkServiceImpl.this.m_device_interfaces_.get(i17)).onLoginComplete(i3, i16, IlinkServiceImpl.this.m_device_profile_, IlinkServiceImpl.this.m_device_token_);
                    }
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onReceiveAppMessage(String str, byte[] bArr) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onReceiveAppMessage(bArr);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onReceiveAppResponse(String str, int i3, int i16, byte[] bArr) throws RemoteException {
                if (IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    synchronized (IlinkServiceImpl.this.m_local_svr_taskid_) {
                        for (Integer num : IlinkServiceImpl.this.m_local_svr_taskid_.keySet()) {
                            if (((Integer) IlinkServiceImpl.this.m_local_svr_taskid_.get(num)).intValue() == i3) {
                                IlinkServiceImpl.this.m_local_svr_taskid_.remove(num);
                                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onReceiveAppResponse(num.intValue(), i16, bArr);
                                return;
                            }
                        }
                        IlinkServiceLogImpl.getInstance().w(IlinkServiceImpl.TAG, "task map not has svr task:" + i3 + " maybe already canceled!", new Object[0]);
                        return;
                    }
                }
                IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onReceiveMessage(String str, String str2, String str3, String str4, int i3) throws RemoteException {
                IlinkServiceLogImpl.getInstance().d(IlinkServiceImpl.TAG, "onReceiveMessage!", new Object[0]);
                synchronized (IlinkServiceImpl.this.m_device_interfaces_) {
                    for (int i16 = 0; i16 < IlinkServiceImpl.this.m_device_interfaces_.size(); i16++) {
                        ((IlinkDeviceImpl) IlinkServiceImpl.this.m_device_interfaces_.get(i16)).onReceiveMessage(str, str2, str3, str4, i3);
                    }
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onReceiveMultiProcessCloneTicket(int i3, String str, String str2) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onReceiveMultiProcessCloneTicket(i3, str2);
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onSendMsgResult(int i3, String str) throws RemoteException {
                int i16;
                int i17;
                synchronized (IlinkServiceImpl.this.m_device_local_msgid_) {
                    Iterator it = IlinkServiceImpl.this.m_device_local_msgid_.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Integer num = (Integer) it.next();
                            if (((String) IlinkServiceImpl.this.m_device_local_msgid_.get(num)).equals(str)) {
                                i17 = num.intValue();
                                IlinkServiceImpl.this.m_device_local_msgid_.remove(num);
                                break;
                            }
                        } else {
                            i17 = 0;
                            break;
                        }
                    }
                }
                if (i17 != 0) {
                    synchronized (IlinkServiceImpl.this.m_device_interfaces_) {
                        for (i16 = 0; i16 < IlinkServiceImpl.this.m_device_interfaces_.size(); i16++) {
                            ((IlinkDeviceImpl) IlinkServiceImpl.this.m_device_interfaces_.get(i16)).onSendMsgResult(i3, i17);
                        }
                    }
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onTdiLoginComplete(String str, int i3, byte[] bArr) throws RemoteException {
                if (!IlinkServiceImpl.this.m_tdisession_map_.containsKey(str)) {
                    IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Tdi session not exit call create first appid:" + str, new Object[0]);
                    return;
                }
                ((IlinkTdiSessionImpl) IlinkServiceImpl.this.m_tdisession_map_.get(str)).onLoginComplete(i3, bArr);
            }
        };
        this.m_serviceconn_ = new ServiceConnection() { // from class: com.tencent.ilinkservice.IlinkServiceImpl.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IlinkServiceImpl.this.m_ilink_service_ = IIlinkServiceInterface.Stub.asInterface(iBinder);
                try {
                    IlinkServiceImpl ilinkServiceImpl = IlinkServiceImpl.this;
                    ilinkServiceImpl.m_service_cookie_ = ilinkServiceImpl.m_ilink_service_.newRegisterCallback(IlinkServiceImpl.this.m_process_name_, IlinkServiceImpl.this.m_callback_, IlinkServiceImpl.this.m_init_parameter_);
                    IlinkServiceLogImpl.getInstance().d(IlinkServiceImpl.TAG, "my process name is:" + IlinkServiceImpl.this.m_process_name_ + ", my cookie is:" + IlinkServiceImpl.this.m_service_cookie_ + ", my package name is:" + IlinkServiceImpl.this.m_self_package_name_, new Object[0]);
                    IlinkApiTaskManager.getInstance().setIlinkServiceAvailable(true);
                    IlinkServiceLogImpl.getInstance().d(IlinkServiceImpl.TAG, "onServiceConnected finished", new Object[0]);
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                IlinkServiceLogImpl.getInstance().d(IlinkServiceImpl.TAG, "onServiceDisconnected then we should bind again", new Object[0]);
                if (IlinkServiceImpl.this.m_isbound) {
                    try {
                        IlinkServiceImpl.this.m_context_.unbindService(IlinkServiceImpl.this.m_serviceconn_);
                        IlinkServiceImpl.this.m_isbound = false;
                    } catch (IllegalArgumentException e16) {
                        e16.printStackTrace();
                        IlinkServiceLogImpl.getInstance().e(IlinkServiceImpl.TAG, "Disconnected catch argument exception!", new Object[0]);
                    }
                }
                IlinkApiTaskManager.getInstance().setIlinkServiceAvailable(false);
                IlinkApiTaskManager.getInstance().clearTask();
                IlinkServiceImpl.this.m_ilink_service_ = null;
                IlinkServiceImpl.this.m_tdisession_map_.clear();
                IlinkServiceImpl.this.m_imsession_map_.clear();
                IlinkServiceImpl.this.m_local_svr_taskid_.clear();
                synchronized (IlinkServiceImpl.this.m_device_interfaces_) {
                    for (int i3 = 0; i3 < IlinkServiceImpl.this.m_device_interfaces_.size(); i3++) {
                        ((IlinkDeviceImpl) IlinkServiceImpl.this.m_device_interfaces_.get(i3)).setDestroyed();
                    }
                }
                synchronized (IlinkServiceImpl.this.m_service_callbacks_) {
                    for (int i16 = 0; i16 < IlinkServiceImpl.this.m_service_callbacks_.size(); i16++) {
                        ((IlinkServiceCallback) IlinkServiceImpl.this.m_service_callbacks_.get(i16)).onAllResourceNeedRecreate();
                    }
                }
                IlinkServiceImpl.this.m_current_bind_intent_.setAction("com.tencent.ilinkservice.StartIlinkService");
                IlinkServiceImpl.this.m_current_bind_intent_.setPackage(IlinkServiceImpl.this.m_self_package_name_);
                IlinkServiceImpl.this.m_current_bind_intent_.putExtra("caller", IlinkServiceImpl.this.m_process_name_);
                IlinkServiceImpl.this.m_current_bind_intent_.putExtra("initpara", IlinkServiceImpl.this.m_init_parameter_);
                IlinkServiceImpl ilinkServiceImpl = IlinkServiceImpl.this;
                ilinkServiceImpl.m_isbound = ilinkServiceImpl.m_context_.bindService(IlinkServiceImpl.this.m_current_bind_intent_, IlinkServiceImpl.this.m_serviceconn_, 1);
            }
        };
        IlinkServiceLogImpl.getInstance().d(TAG, "Create IlinkServiceImpl", new Object[0]);
    }

    public void autoLogin() {
        try {
            this.m_ilink_service_.autoLogin(this.m_process_name_, this.m_service_cookie_);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }
}
