package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.ilinkservice.IlinkServiceProto;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkTdiSessionImpl implements IlinkTdiSessionInterface, IlinkTdiCloneSessionInterface {
    private static AtomicInteger m_clone_ids_ = new AtomicInteger(0);
    private String m_appid_;
    private TdiSessionCallback m_callback_;
    private TdiCloneCallback m_clonecallback_;
    private boolean m_i_am_clone_;
    private final String TAG = "IlinkServiceTdiImpl";
    private Vector<Integer> m_taskids_ = new Vector<>();
    private ConcurrentHashMap<Integer, Integer> m_taskid_cloneid_ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, IlinkTdiCloneSessionImpl> m_cloneid_impl_ = new ConcurrentHashMap<>();

    public IlinkTdiSessionImpl(String str, boolean z16) {
        this.m_appid_ = str;
        this.m_i_am_clone_ = z16;
    }

    private boolean checkCloneAndInValid() {
        if (this.m_i_am_clone_) {
            return true;
        }
        if (IlinkServiceImpl.getInstance().isTdiSessionValid(this)) {
            return false;
        }
        IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
        return true;
    }

    private boolean checkInValid() {
        if (IlinkServiceImpl.getInstance().isTdiSessionValid(this)) {
            return false;
        }
        IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
        return true;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void autoLogin() {
        if (checkCloneAndInValid()) {
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "autoLogin", new Class[]{String.class}, this.m_appid_);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void cancel(TdiApiProto.TdiCancelType tdiCancelType) {
        if (checkCloneAndInValid()) {
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "cancel", new Class[]{String.class, Integer.TYPE}, this.m_appid_, Integer.valueOf(tdiCancelType.getNumber()));
    }

    public void cancelAllAppRequest() {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "cancel all app request", new Object[0]);
        synchronized (this.m_taskids_) {
            for (int i3 = 0; i3 < this.m_taskids_.size(); i3++) {
                int removeAppRequestTask = IlinkServiceImpl.getInstance().removeAppRequestTask(this.m_taskids_.get(i3).intValue());
                if (removeAppRequestTask != 0) {
                    IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "cancelAppRequest", new Class[]{String.class, Integer.TYPE}, this.m_appid_, Integer.valueOf(removeAppRequestTask));
                }
            }
            this.m_taskids_.clear();
        }
        synchronized (this.m_taskid_cloneid_) {
            Iterator<Integer> it = this.m_taskid_cloneid_.keySet().iterator();
            while (it.hasNext()) {
                int removeAppRequestTask2 = IlinkServiceImpl.getInstance().removeAppRequestTask(it.next().intValue());
                if (removeAppRequestTask2 != 0) {
                    IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "cancelAppRequest", new Class[]{String.class, Integer.TYPE}, this.m_appid_, Integer.valueOf(removeAppRequestTask2));
                }
            }
            this.m_taskid_cloneid_.clear();
        }
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface, com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void cancelAppRequest(int i3) {
        if (!IlinkServiceImpl.getInstance().isTdiSessionValid(this)) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "cancel app request taskid:" + i3, new Object[0]);
        if (-1 == this.m_taskids_.indexOf(new Integer(i3))) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "local task not exit taskid:" + i3, new Object[0]);
            return;
        }
        this.m_taskids_.remove(new Integer(i3));
        int removeAppRequestTask = IlinkServiceImpl.getInstance().removeAppRequestTask(i3);
        if (removeAppRequestTask == 0) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "server task not exit or not start yet taskid:" + i3, new Object[0]);
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "cancelAppRequest", new Class[]{String.class, Integer.TYPE}, this.m_appid_, Integer.valueOf(removeAppRequestTask));
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void cancelCdnDownload(int i3) {
        if (checkCloneAndInValid()) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "tdi cancelCdnDownload taskid:" + i3, new Object[0]);
        if (-1 == this.m_taskids_.indexOf(new Integer(i3))) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "local task not exit taskid:" + i3, new Object[0]);
            return;
        }
        this.m_taskids_.remove(new Integer(i3));
        int removeAppRequestTask = IlinkServiceImpl.getInstance().removeAppRequestTask(i3);
        if (removeAppRequestTask == 0) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "server task not exit or not start yet taskid:" + i3, new Object[0]);
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "cancelCdnDownload", AidlProto.commFunctionReqWithTaskid.newBuilder().setAppid(this.m_appid_).setTaskid(removeAppRequestTask).build().toByteArray());
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void cancelCdnUpload(int i3) {
        if (checkCloneAndInValid()) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "tdi cancelCdnUpload taskid:" + i3, new Object[0]);
        if (-1 == this.m_taskids_.indexOf(new Integer(i3))) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "local task not exit taskid:" + i3, new Object[0]);
            return;
        }
        this.m_taskids_.remove(new Integer(i3));
        int removeAppRequestTask = IlinkServiceImpl.getInstance().removeAppRequestTask(i3);
        if (removeAppRequestTask == 0) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "server task not exit or not start yet taskid:" + i3, new Object[0]);
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "cancelCdnUpload", AidlProto.commFunctionReqWithTaskid.newBuilder().setAppid(this.m_appid_).setTaskid(removeAppRequestTask).build().toByteArray());
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public int cancelOAuth(TdiApiProto.TdiCancelOAuthRequest tdiCancelOAuthRequest) {
        if (checkCloneAndInValid()) {
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskids_.addElement(new Integer(addAppRequestTask));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "cancelOAuth", new Class[]{String.class, byte[].class, Integer.TYPE}, this.m_appid_, tdiCancelOAuthRequest.toByteArray(), Integer.valueOf(addAppRequestTask));
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "cancelOAuth request taskid:" + addAppRequestTask, new Object[0]);
        return addAppRequestTask;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void cancelRequest(int i3) {
        if (checkCloneAndInValid()) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "tdi cancelRequest taskid:" + i3, new Object[0]);
        if (-1 == this.m_taskids_.indexOf(new Integer(i3))) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "local task not exit taskid:" + i3, new Object[0]);
            return;
        }
        this.m_taskids_.remove(new Integer(i3));
        int removeAppRequestTask = IlinkServiceImpl.getInstance().removeAppRequestTask(i3);
        if (removeAppRequestTask == 0) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "server task not exit or not start yet taskid:" + i3, new Object[0]);
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "cancelRequest", new Class[]{String.class, Integer.TYPE}, this.m_appid_, Integer.valueOf(removeAppRequestTask));
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void checkLoginQrCode() {
        if (checkCloneAndInValid()) {
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "checkLoginQrCode", new Class[]{String.class}, this.m_appid_);
    }

    public void cloneCancelAppRequest(int i3, int i16) {
        if (this.m_i_am_clone_) {
            return;
        }
        if (!this.m_cloneid_impl_.containsKey(Integer.valueOf(i3))) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "clone session already been destroyed!!", new Object[0]);
            return;
        }
        if (!IlinkServiceImpl.getInstance().isTdiSessionValid(this)) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "cancel app request cloneid:" + i3 + ", taskid:" + i16, new Object[0]);
        Integer num = new Integer(i16);
        if (this.m_taskid_cloneid_.containsKey(num)) {
            this.m_taskid_cloneid_.remove(num);
            int removeAppRequestTask = IlinkServiceImpl.getInstance().removeAppRequestTask(i16);
            if (removeAppRequestTask == 0) {
                IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "server task not exit or not start yet clone taskid:" + i16, new Object[0]);
                return;
            }
            IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "cancelAppRequest", new Class[]{String.class, Integer.TYPE}, this.m_appid_, Integer.valueOf(removeAppRequestTask));
            return;
        }
        IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "clone taskid not exit:" + i16, new Object[0]);
    }

    public TdiApiProto.TdiUserInfo cloneGetUserInfo() {
        return getUserInfo();
    }

    public int cloneSendAppRequest(int i3, TdiApiProto.TdiAppRequest tdiAppRequest) {
        if (this.m_i_am_clone_) {
            return 0;
        }
        if (!this.m_cloneid_impl_.containsKey(Integer.valueOf(i3))) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "clone session already been destroyed!!", new Object[0]);
            return 0;
        }
        if (!IlinkServiceImpl.getInstance().isTdiSessionValid(this)) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskid_cloneid_.put(new Integer(addAppRequestTask), new Integer(i3));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "sendAppRequest", new Class[]{String.class, byte[].class, Integer.TYPE}, this.m_appid_, tdiAppRequest.toByteArray(), Integer.valueOf(addAppRequestTask));
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "send clone app request taskid:" + addAppRequestTask, new Object[0]);
        return addAppRequestTask;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public IlinkTdiCloneSessionInterface createCloneSession() {
        if (this.m_i_am_clone_) {
            return null;
        }
        int incrementAndGet = m_clone_ids_.incrementAndGet();
        if (incrementAndGet == 0) {
            incrementAndGet = m_clone_ids_.incrementAndGet();
        }
        IlinkTdiCloneSessionImpl ilinkTdiCloneSessionImpl = new IlinkTdiCloneSessionImpl(incrementAndGet, this);
        this.m_cloneid_impl_.put(new Integer(incrementAndGet), ilinkTdiCloneSessionImpl);
        return ilinkTdiCloneSessionImpl;
    }

    public void destroyAllCloneSession() {
        if (this.m_i_am_clone_) {
            return;
        }
        Enumeration<IlinkTdiCloneSessionImpl> elements = this.m_cloneid_impl_.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().onCloneDestroyed();
        }
        this.m_cloneid_impl_.clear();
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void destroyCloneSession(IlinkTdiCloneSessionInterface ilinkTdiCloneSessionInterface) {
        if (!this.m_i_am_clone_ && ilinkTdiCloneSessionInterface != null && (ilinkTdiCloneSessionInterface instanceof IlinkTdiCloneSessionImpl)) {
            int cloneId = ((IlinkTdiCloneSessionImpl) ilinkTdiCloneSessionInterface).getCloneId();
            Integer num = new Integer(cloneId);
            if (this.m_cloneid_impl_.containsKey(num)) {
                this.m_cloneid_impl_.get(num).onCloneDestroyed();
                this.m_cloneid_impl_.remove(num);
                IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "delete clone session for cloneid:" + cloneId, new Object[0]);
                return;
            }
            IlinkServiceLogImpl.getInstance().w("IlinkServiceTdiImpl", "cloneid:" + cloneId + " not exit!", new Object[0]);
        }
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void faceExtVerify(TdiApiProto.TdiFaceExtVerifyRequest tdiFaceExtVerifyRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = tdiFaceExtVerifyRequest.toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "faceExtVerify", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void faceLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = tdiLoginRequest.toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "faceLogin", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void faceRecognize(TdiApiProto.TdiFaceRecognizeRequest tdiFaceRecognizeRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = tdiFaceRecognizeRequest.toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "faceRecognize", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void faceRecognizeConfig(TdiApiProto.TdiFaceRecognizeConfigRequest tdiFaceRecognizeConfigRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = tdiFaceRecognizeConfigRequest.toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "faceRecognizeConfig", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public int getAppPushToken(byte[] bArr) {
        if (checkCloneAndInValid()) {
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskids_.addElement(new Integer(addAppRequestTask));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "getAppPushToken", new Class[]{String.class, byte[].class, Integer.TYPE}, this.m_appid_, bArr, Integer.valueOf(addAppRequestTask));
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "getAppPushToken taskid:" + addAppRequestTask, new Object[0]);
        return addAppRequestTask;
    }

    public String getAppid() {
        return this.m_appid_;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void getLoginQrCode(TdiApiProto.TdiGetLoginQrCodeRequest tdiGetLoginQrCodeRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = tdiGetLoginQrCodeRequest.toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "getLoginQrCode", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public int getOAuthCode(TdiApiProto.TdiGetOAuthCodeRequest tdiGetOAuthCodeRequest) {
        if (checkCloneAndInValid()) {
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskids_.addElement(new Integer(addAppRequestTask));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "getOAuthCode", new Class[]{String.class, byte[].class, Integer.TYPE}, this.m_appid_, tdiGetOAuthCodeRequest.toByteArray(), Integer.valueOf(addAppRequestTask));
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "getOAuthCode request taskid:" + addAppRequestTask, new Object[0]);
        return addAppRequestTask;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface, com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public TdiApiProto.TdiUserInfo getUserInfo() {
        byte[] userInfo = IlinkServiceImpl.getInstance().getUserInfo(this.m_appid_);
        TdiApiProto.TdiUserInfo build = TdiApiProto.TdiUserInfo.newBuilder().build();
        if (userInfo == null) {
            return build;
        }
        try {
            return TdiApiProto.TdiUserInfo.parseFrom(userInfo);
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            return build;
        }
    }

    public boolean isCloneSession() {
        return this.m_i_am_clone_;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void logOut() {
        if (checkCloneAndInValid()) {
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "logOut", new Class[]{String.class}, this.m_appid_);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void oauthLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = tdiLoginRequest.toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "oauthLogin", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }

    public void onAppSessionTimeout() {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onAppSessionTimeout", new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            tdiSessionCallback.onAppSessionTimeout();
        }
    }

    public void onCancelOAuthComplete(int i3, int i16) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onCancelOAuthComplete", new Object[0]);
        Integer num = new Integer(i3);
        if (this.m_taskids_.contains(num)) {
            this.m_taskids_.remove(num);
        }
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            tdiSessionCallback.onCancelOAuthComplete(i3, i16);
        }
    }

    public void onCdnDownloadCompleted(int i3, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onCdnDownloadCompleted", new Object[0]);
        Integer num = new Integer(i3);
        if (this.m_taskids_.contains(num)) {
            this.m_taskids_.remove(num);
        }
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onCdnDownloadCompleted(i3, ApiProto.IlinkC2CDownloadResult.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onCdnUploadCompleted(int i3, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onCdnUploadCompleted", new Object[0]);
        Integer num = new Integer(i3);
        if (this.m_taskids_.contains(num)) {
            this.m_taskids_.remove(num);
        }
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onCdnUploadCompleted(i3, ApiProto.IlinkC2CUploadResult.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onCheckLoginQrCodeComplete(int i3, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onCheckLoginQrCodeComplete error:" + i3, new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onCheckLoginQrCodeComplete(i3, TdiApiProto.TdiCheckLoginQrCodeResponse.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onCloneDestroyed() {
        TdiCloneCallback tdiCloneCallback;
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onCloneDestroyed", new Object[0]);
        if (this.m_i_am_clone_ && (tdiCloneCallback = this.m_clonecallback_) != null) {
            tdiCloneCallback.onCloneDestroyed();
        }
    }

    public void onFaceExtVerifyComplete(int i3, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "OnFaceExtVerifyComplete error:" + i3, new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onFaceExtVerifyComplete(i3, TdiApiProto.TdiFaceExtVerifyResponse.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onFaceRecognizeComplete(int i3, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "OnFaceRecognizeComplete error:" + i3, new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onFaceRecognizeComplete(i3, TdiApiProto.TdiFaceRecognizeResponse.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onFaceRecognizeConfigComplete(int i3, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onFaceRecognizeConfigComplete", new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onFaceRecognizeConfigComplete(i3, TdiApiProto.TdiFaceRecognizeConfigResponse.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onGetAppPushTokenComplete(int i3, int i16, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onGetAppPushTokenComplete", new Object[0]);
        Integer num = new Integer(i3);
        if (this.m_taskids_.contains(num)) {
            this.m_taskids_.remove(num);
        }
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onGetAppPushTokenComplete(i3, i16, TdiApiProto.TdiAppPushToken.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onGetLoginQrCodeComplete(int i3, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "OnGetLoginQrCodeComplete error:" + i3, new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onGetLoginQrCodeComplete(i3, TdiApiProto.TdiGetLoginQrCodeResponse.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onGetOAuthCodeComplete(int i3, int i16, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onGetOAuthCodeComplete", new Object[0]);
        Integer num = new Integer(i3);
        if (this.m_taskids_.contains(num)) {
            this.m_taskids_.remove(num);
        }
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onGetOAuthCodeComplete(i3, i16, TdiApiProto.TdiGetOAuthCodeResponse.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onLoginComplete(int i3, byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "OnLoginComplete error:" + i3, new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onLoginComplete(i3, TdiApiProto.TdiLoginResponse.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onLogoutComplete(int i3) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "OnLoginComplete error:" + i3, new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            tdiSessionCallback.onLogoutComplete(i3);
        }
    }

    public void onReceiveAppMessage(byte[] bArr) {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onReceiveAppMessage", new Object[0]);
        if (this.m_i_am_clone_) {
            TdiCloneCallback tdiCloneCallback = this.m_clonecallback_;
            if (tdiCloneCallback != null) {
                try {
                    tdiCloneCallback.onReceiveAppMessage(TdiApiProto.TdiAppMessage.parseFrom(bArr));
                    return;
                } catch (InvalidProtocolBufferException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onReceiveAppMessage(TdiApiProto.TdiAppMessage.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e17) {
                e17.printStackTrace();
            }
        }
        Enumeration<IlinkTdiCloneSessionImpl> elements = this.m_cloneid_impl_.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().onReceiveAppMessage(bArr);
        }
    }

    public void onReceiveAppResponse(int i3, int i16, byte[] bArr) {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onReceiveAppResponse error:" + i16, new Object[0]);
        Integer num = new Integer(i3);
        if (this.m_taskids_.contains(num)) {
            this.m_taskids_.remove(num);
            if (this.m_i_am_clone_) {
                TdiCloneCallback tdiCloneCallback = this.m_clonecallback_;
                if (tdiCloneCallback != null) {
                    try {
                        tdiCloneCallback.onReceiveAppResponse(i3, i16, TdiApiProto.TdiAppResponse.parseFrom(bArr));
                        return;
                    } catch (InvalidProtocolBufferException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
            TdiSessionCallback tdiSessionCallback = this.m_callback_;
            if (tdiSessionCallback != null) {
                try {
                    tdiSessionCallback.onReceiveAppResponse(i3, i16, TdiApiProto.TdiAppResponse.parseFrom(bArr));
                    return;
                } catch (InvalidProtocolBufferException e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (this.m_i_am_clone_) {
            IlinkServiceLogImpl.getInstance().w("IlinkServiceTdiImpl", "it is not a local task and i am a clone just return and ignore this taskid:" + i3, new Object[0]);
            return;
        }
        IlinkServiceLogImpl.getInstance().w("IlinkServiceTdiImpl", "Local task not exit check if it is clone task!", new Object[0]);
        if (this.m_taskid_cloneid_.containsKey(num) && this.m_cloneid_impl_.containsKey(this.m_taskid_cloneid_.get(num))) {
            this.m_cloneid_impl_.get(this.m_taskid_cloneid_.get(num)).onReceiveAppResponse(i3, i16, bArr);
        } else {
            IlinkServiceLogImpl.getInstance().w("IlinkServiceTdiImpl", "it is not a local task or clone task maybe cancel already or cloneobj not exit!", new Object[0]);
        }
    }

    public void onReceiveMultiProcessCloneTicket(int i3, String str) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "onReceiveMultiProcessCloneTicket", new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            tdiSessionCallback.onReceiveMultiProcessCloneTicket(i3, str);
        }
    }

    public void onRequestUploadLogfiles(byte[] bArr) {
        if (this.m_i_am_clone_) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "OnRequestUploadLogfiles", new Object[0]);
        TdiSessionCallback tdiSessionCallback = this.m_callback_;
        if (tdiSessionCallback != null) {
            try {
                tdiSessionCallback.onRequestUploadLogfiles(IlinkServiceProto.IlinkPullLogCmd.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void palmLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = AidlProto.thirdAppLogin.newBuilder().setAppid(this.m_appid_).setReq(tdiLoginRequest.toByteString()).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "palmLogin", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void qrCodeLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = tdiLoginRequest.toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "qrCodeLogin", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void requestMultiProcessCloneTicket() {
        if (checkCloneAndInValid()) {
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "requestMultiProcessCloneTicket", new Class[]{String.class}, this.m_appid_);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void requestUploadLogfiles(int i3, int i16) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = AidlProto.requestUploadLogfiles.newBuilder().setAppid(this.m_appid_).setStartTime(i3).setEndTime(i16).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "requestUploadLogfiles", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface, com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public int sendAppRequest(TdiApiProto.TdiAppRequest tdiAppRequest) {
        if (!IlinkServiceImpl.getInstance().isTdiSessionValid(this)) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskids_.addElement(new Integer(addAppRequestTask));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "sendAppRequest", new Class[]{String.class, byte[].class, Integer.TYPE}, this.m_appid_, tdiAppRequest.toByteArray(), Integer.valueOf(addAppRequestTask));
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "send app request localtaskid:" + addAppRequestTask, new Object[0]);
        return addAppRequestTask;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void setCallback(TdiSessionCallback tdiSessionCallback) {
        if (this.m_i_am_clone_) {
            return;
        }
        this.m_callback_ = tdiSessionCallback;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface, com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void setSmcBaseInfo(IlinkServiceProto.IlinkSmcBaseInfo ilinkSmcBaseInfo) {
        if (checkInValid()) {
            return;
        }
        byte[] byteArray = AidlProto.setSmcBaseInfo.newBuilder().setAppid(this.m_appid_).setSmcbaseinfo(ilinkSmcBaseInfo.toByteString()).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "setSmcBaseInfo", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface, com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void setSmcUin(int i3) {
        if (checkInValid()) {
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "SetSmcUin", new Class[]{String.class, Integer.TYPE}, this.m_appid_, Integer.valueOf(i3));
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void smcFlushReportData() {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = AidlProto.commFunctionReqWithTaskid.newBuilder().setAppid(this.m_appid_).setTaskid(0).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "smcFlushReportData", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public int startCdnDownload(ApiProto.IlinkC2CDownload ilinkC2CDownload) {
        if (checkCloneAndInValid()) {
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskids_.addElement(new Integer(addAppRequestTask));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "ReqCommFunctionWithTaskid", new Class[]{String.class, byte[].class, Integer.TYPE}, "startCdnDownload", AidlProto.commFunctionReqWithReq.newBuilder().setAppid(this.m_appid_).setReqdata(ilinkC2CDownload.toByteString()).build().toByteArray(), Integer.valueOf(addAppRequestTask));
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "startCdnDownload request taskid:" + addAppRequestTask, new Object[0]);
        return addAppRequestTask;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public int startCdnUpload(ApiProto.IlinkC2CUpload ilinkC2CUpload) {
        if (checkCloneAndInValid()) {
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskids_.addElement(new Integer(addAppRequestTask));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "ReqCommFunctionWithTaskid", new Class[]{String.class, byte[].class, Integer.TYPE}, "startCdnUpload", AidlProto.commFunctionReqWithReq.newBuilder().setAppid(this.m_appid_).setReqdata(ilinkC2CUpload.toByteString()).build().toByteArray(), Integer.valueOf(addAppRequestTask));
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiImpl", "startCdnUpload request taskid:" + addAppRequestTask, new Object[0]);
        return addAppRequestTask;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void thirdAppLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = AidlProto.thirdAppLogin.newBuilder().setAppid(this.m_appid_).setReq(tdiLoginRequest.toByteString()).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "thirdAppLogin", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void updateIlinkToken(String str) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = AidlProto.updateIlinkToken.newBuilder().setAppid(this.m_appid_).setIlinktoken(str).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "updateIlinkToken", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface
    public void visitorLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest) {
        if (checkCloneAndInValid()) {
            return;
        }
        byte[] byteArray = AidlProto.visitorLogin.newBuilder().setAppid(this.m_appid_).setReq(tdiLoginRequest.toByteString()).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "visitorLogin", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface, com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17, int i17) {
        if (checkInValid()) {
            return;
        }
        IlinkServiceProto.IlinkKvReportInfo.Builder newBuilder = IlinkServiceProto.IlinkKvReportInfo.newBuilder();
        newBuilder.setLogid(i3);
        newBuilder.setValue(ByteString.copyFrom(bArr));
        newBuilder.setReportNow(z16);
        newBuilder.setType(i16);
        newBuilder.setIgnoreFreqCheck(z17);
        newBuilder.setReportUinType(i17);
        byte[] byteArray = newBuilder.build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "WriteKvData", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void setCallback(TdiCloneCallback tdiCloneCallback) {
        this.m_clonecallback_ = tdiCloneCallback;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiSessionInterface, com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17) {
        if (checkInValid()) {
            return;
        }
        IlinkServiceProto.IlinkKvReportInfo.Builder newBuilder = IlinkServiceProto.IlinkKvReportInfo.newBuilder();
        newBuilder.setLogid(i3);
        newBuilder.setValue(ByteString.copyFrom(bArr));
        newBuilder.setReportNow(z16);
        newBuilder.setType(i16);
        newBuilder.setIgnoreFreqCheck(z17);
        byte[] byteArray = newBuilder.build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "WriteKvData", new Class[]{String.class, byte[].class}, this.m_appid_, byteArray);
    }
}
