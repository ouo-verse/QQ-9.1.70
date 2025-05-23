package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.ilinkservice.IlinkServiceProto;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkDeviceImpl implements IlinkDeviceInterface {
    private final String TAG = "IlinkServiceDevice";
    private IlinkDeviceCallback m_callback_ = null;
    private boolean m_destroyed_ = false;
    private Vector<Integer> m_taskids_ = new Vector<>();

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void autoLogin() {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return;
        }
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "autoLogin", new Class[0], new Object[0]);
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void changeDomain(int i3) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return;
        }
        byte[] byteArray = AidlProto.changeDomainRequest.newBuilder().setDomain(i3).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "changeDomain", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public String getIlinkServiceVersion() {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return "";
        }
        byte[] ReqCommFunctionWithResp = IlinkServiceImpl.getInstance().ReqCommFunctionWithResp("getIlinkServiceVersion", new byte[0]);
        if (ReqCommFunctionWithResp == null) {
            return "";
        }
        try {
            return AidlProto.getIlinkServiceVersionResp.parseFrom(ReqCommFunctionWithResp).getVersion();
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public byte[] getProfile() {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return new byte[0];
        }
        return IlinkServiceImpl.getInstance().getProfile();
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public String getToken() {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return "";
        }
        return IlinkServiceImpl.getInstance().getToken();
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public boolean isAlreadyGetStrategy() {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return false;
        }
        return IlinkServiceImpl.getInstance().isAlreadyGetStrategy();
    }

    public void onFinishGetStrategy() {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceDevice", "onFinishGetStrategy", new Object[0]);
        IlinkDeviceCallback ilinkDeviceCallback = this.m_callback_;
        if (ilinkDeviceCallback != null) {
            ilinkDeviceCallback.onFinishGetStrategy();
        }
    }

    public void onLoginComplete(int i3, int i16, byte[] bArr, String str) {
        IlinkServiceLogImpl.getInstance().i("IlinkServiceDevice", "onLoginComplete error:" + i3, new Object[0]);
        IlinkDeviceCallback ilinkDeviceCallback = this.m_callback_;
        if (ilinkDeviceCallback != null) {
            ilinkDeviceCallback.onLoginComplete(i3, i16, bArr, str);
        }
    }

    public void onNetStatusChanged(int i3) {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceDevice", "onNetStatusChanged status:" + i3, new Object[0]);
        IlinkDeviceCallback ilinkDeviceCallback = this.m_callback_;
        if (ilinkDeviceCallback != null) {
            ilinkDeviceCallback.onNetStatusChanged(i3);
        }
    }

    public void onReceiveMessage(String str, String str2, String str3, String str4, int i3) {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceDevice", "onReceiveMessage from:" + str, new Object[0]);
        IlinkDeviceCallback ilinkDeviceCallback = this.m_callback_;
        if (ilinkDeviceCallback != null) {
            ilinkDeviceCallback.onReceiveMessage(str, str2, str3, str4, i3);
        }
    }

    public void onReceivePullLogCmd(byte[] bArr) {
        IlinkDeviceCallback ilinkDeviceCallback = this.m_callback_;
        if (ilinkDeviceCallback != null) {
            ilinkDeviceCallback.onReceivePullLogCmd(bArr);
        }
    }

    public void onSendMsgResult(int i3, int i16) {
        if (!this.m_taskids_.contains(Integer.valueOf(i16))) {
            return;
        }
        IlinkServiceLogImpl.getInstance().d("IlinkServiceDevice", "onSendMsgResult error:" + i3, new Object[0]);
        IlinkDeviceCallback ilinkDeviceCallback = this.m_callback_;
        if (ilinkDeviceCallback != null) {
            ilinkDeviceCallback.onSendMsgResult(i3, i16);
        }
    }

    public void onUploadLogComplete(int i3) {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceDevice", "onUploadLogComplete errcode:" + i3, new Object[0]);
        IlinkDeviceCallback ilinkDeviceCallback = this.m_callback_;
        if (ilinkDeviceCallback != null) {
            ilinkDeviceCallback.onUploadLogComplete(i3);
        }
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public int sendIotMessage(String str, String str2, String str3, String str4) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return 0;
        }
        int addDeviceMessageTask = IlinkServiceImpl.getInstance().addDeviceMessageTask();
        this.m_taskids_.add(Integer.valueOf(addDeviceMessageTask));
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "sendIotMessage", new Class[]{String.class, String.class, String.class, String.class, Integer.TYPE}, str, str2, str3, str4, Integer.valueOf(addDeviceMessageTask));
        return addDeviceMessageTask;
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void setCallback(IlinkDeviceCallback ilinkDeviceCallback) {
        this.m_callback_ = ilinkDeviceCallback;
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void setConsoleLogOpen(boolean z16) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
        } else {
            IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "setConsoleLogOpen", new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    public void setDestroyed() {
        this.m_taskids_.clear();
        this.m_destroyed_ = true;
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void setLogLevel(int i3) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
        } else {
            IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "setLogLevel", new Class[]{Integer.TYPE}, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void setLonglinkIplist(IlinkServiceProto.ServerIplist serverIplist) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return;
        }
        byte[] byteArray = AidlProto.setLonglinkIplist.newBuilder().setSvriplist(serverIplist.toByteString()).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "setLonglinkIplist", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void setProxyInfo(int i3, String str, int i16, String str2, String str3) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return;
        }
        if (str.isEmpty() && i3 != 0) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "ip is empty not need to set proxy!", new Object[0]);
            return;
        }
        IlinkServiceProto.IlinkNetProxyInfo.Builder newBuilder = IlinkServiceProto.IlinkNetProxyInfo.newBuilder();
        newBuilder.setIp(str);
        newBuilder.setPort(i16);
        newBuilder.setUsername(ByteString.copyFrom(str2.getBytes()));
        newBuilder.setPassword(ByteString.copyFrom(str3.getBytes()));
        newBuilder.setProxytype(i3);
        byte[] byteArray = newBuilder.build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "setProxyInfo", new Class[]{byte[].class}, byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void setShortlinkIplist(IlinkServiceProto.ServerIplist serverIplist) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return;
        }
        byte[] byteArray = AidlProto.setShortlinkIplist.newBuilder().setSvriplist(serverIplist.toByteString()).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "setShortlinkIplist", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void startUploadLog(IlinkServiceProto.IlinkUploadLogInfo ilinkUploadLogInfo) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return;
        }
        byte[] byteArray = AidlProto.startUploadLog.newBuilder().setLoginfo(ilinkUploadLogInfo.toByteString()).build().toByteArray();
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[]{String.class, byte[].class}, "startUploadLog", byteArray);
    }

    @Override // com.tencent.ilinkservice.IlinkDeviceInterface
    public void updateDeviceInfo(int i3, String str, int i16) {
        if (this.m_destroyed_) {
            IlinkServiceLogImpl.getInstance().e("IlinkServiceDevice", "already destroyed!", new Object[0]);
            return;
        }
        Class cls = Integer.TYPE;
        IlinkApiTaskManager.getInstance().addTask(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "updateDeviceInfo", new Class[]{cls, String.class, cls}, Integer.valueOf(i3), str, Integer.valueOf(i16));
    }
}
