package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.tencent.ilinkservice.AidlProto;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkImSessionImpl implements IlinkImSessionInterface {
    private String m_appid_;
    private ImSessionCallback m_callback_ = null;
    private final String TAG = "IlinkImSessionImpl";
    private Vector<Integer> m_taskids_ = new Vector<>();

    public IlinkImSessionImpl(String str) {
        this.m_appid_ = str;
    }

    public void cancelAllImRequest() {
        IlinkServiceLogImpl.getInstance().d("IlinkImSessionImpl", "cancel all request", new Object[0]);
        synchronized (this.m_taskids_) {
            for (int i3 = 0; i3 < this.m_taskids_.size(); i3++) {
                IlinkServiceImpl.getInstance().removeAppRequestTask(this.m_taskids_.get(i3).intValue());
            }
            this.m_taskids_.clear();
        }
    }

    public String getAppid() {
        return this.m_appid_;
    }

    @Override // com.tencent.ilinkservice.IlinkImSessionInterface
    public int getDeviceShadow() {
        if (!IlinkServiceImpl.getInstance().isImSessionValid(this)) {
            IlinkServiceLogImpl.getInstance().e("IlinkImSessionImpl", "im session already been destroyed!!", new Object[0]);
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskids_.addElement(new Integer(addAppRequestTask));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "ReqCommFunctionWithTaskid", new Class[]{String.class, byte[].class, Integer.TYPE}, "getDeviceShadow", new byte[0], Integer.valueOf(addAppRequestTask));
        return addAppRequestTask;
    }

    @Override // com.tencent.ilinkservice.IlinkImSessionInterface
    public void login() {
        if (!IlinkServiceImpl.getInstance().isImSessionValid(this)) {
            IlinkServiceLogImpl.getInstance().e("IlinkImSessionImpl", "im session already been destroyed!!", new Object[0]);
            return;
        }
        byte[] byteArray = AidlProto.loginImSession.newBuilder().setAppid(this.m_appid_).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "loginImSession", byteArray);
    }

    public void onDeviceShadowUpdate(byte[] bArr) {
        IlinkServiceLogImpl.getInstance().d("IlinkImSessionImpl", "onDeviceShadowUpdate", new Object[0]);
        ImSessionCallback imSessionCallback = this.m_callback_;
        if (imSessionCallback != null) {
            imSessionCallback.onDeviceShadowUpdate(bArr);
        }
    }

    public void onGetDeviceShadow(int i3, int i16, byte[] bArr) {
        IlinkServiceLogImpl.getInstance().d("IlinkImSessionImpl", "onGetDeviceShadow error:" + i16, new Object[0]);
        Integer num = new Integer(i3);
        if (this.m_taskids_.contains(num)) {
            this.m_taskids_.remove(num);
            ImSessionCallback imSessionCallback = this.m_callback_;
            if (imSessionCallback != null) {
                imSessionCallback.onGetDeviceShadow(i3, i16, bArr);
                return;
            }
            return;
        }
        IlinkServiceLogImpl.getInstance().w("IlinkImSessionImpl", "Local task not exit!", new Object[0]);
    }

    public void onLoginComplete(int i3) {
        IlinkServiceLogImpl.getInstance().d("IlinkImSessionImpl", "onLoginComplete", new Object[0]);
        ImSessionCallback imSessionCallback = this.m_callback_;
        if (imSessionCallback != null) {
            imSessionCallback.onLoginComplete(i3);
        }
    }

    public void onUpdateDeviceShadow(int i3, int i16, byte[] bArr) {
        IlinkServiceLogImpl.getInstance().d("IlinkImSessionImpl", "onUpdateDeviceShadow error:" + i16, new Object[0]);
        Integer num = new Integer(i3);
        if (this.m_taskids_.contains(num)) {
            this.m_taskids_.remove(num);
            ImSessionCallback imSessionCallback = this.m_callback_;
            if (imSessionCallback != null) {
                imSessionCallback.onUpdateDeviceShadow(i3, i16, bArr);
                return;
            }
            return;
        }
        IlinkServiceLogImpl.getInstance().w("IlinkImSessionImpl", "Local task not exit!", new Object[0]);
    }

    @Override // com.tencent.ilinkservice.IlinkImSessionInterface
    public void setCallback(ImSessionCallback imSessionCallback) {
        this.m_callback_ = imSessionCallback;
    }

    @Override // com.tencent.ilinkservice.IlinkImSessionInterface
    public int updateDeviceShadow(byte[] bArr) {
        if (!IlinkServiceImpl.getInstance().isImSessionValid(this)) {
            IlinkServiceLogImpl.getInstance().e("IlinkImSessionImpl", "im session already been destroyed!!", new Object[0]);
            return 0;
        }
        int addAppRequestTask = IlinkServiceImpl.getInstance().addAppRequestTask();
        this.m_taskids_.addElement(new Integer(addAppRequestTask));
        byte[] byteArray = AidlProto.updateDeviceShadowReq.newBuilder().setAppid(this.m_appid_).setShadowdata(ByteString.copyFrom(bArr)).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "ReqCommFunctionWithTaskid", new Class[]{String.class, byte[].class, Integer.TYPE}, "updateDeviceShadow", byteArray, Integer.valueOf(addAppRequestTask));
        return addAppRequestTask;
    }
}
