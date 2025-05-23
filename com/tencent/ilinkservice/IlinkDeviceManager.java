package com.tencent.ilinkservice;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.dev.interfaces.IILinkDevCallback;
import com.tencent.ilink.dev.interfaces.ILinkDevInterfaceService;
import com.tencent.ilink.dev.proto.IlinkDevApi;
import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.network.DeviceCallbackInterface;
import com.tencent.ilink.network.DeviceInterface;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.ilinkservice.IlinkServiceProto;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mars.ilink.xlog.Xlog;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkDeviceManager implements IILinkDevCallback, DeviceCallbackInterface {
    private final String TAG = "IlinkDeviceManager";
    private ConcurrentHashMap<String, String> m_msgid_caller_map_ = new ConcurrentHashMap<>();
    private IlinkDeviceObserver m_observer_;
    private Xlog m_xlog;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDeviceObserver {
        void addDeviceCallbackTask(String str, String str2, Class[] clsArr, Object... objArr);

        void onLoginComplete(int i3, int i16);
    }

    public IlinkDeviceManager(IlinkDeviceObserver ilinkDeviceObserver) {
        Log.d("IlinkDeviceManager", "Create IlinkDeviceManager");
        this.m_observer_ = ilinkDeviceObserver;
    }

    public void AppModeStart(String str, IlinkServiceProto.InitParameter initParameter, String str2) {
        String str3 = str + "/log";
        if (initParameter.hasLogpath() && !initParameter.getLogpath().equals("")) {
            str3 = initParameter.getLogpath();
        }
        Xlog.setConsoleLogOpen(false);
        Xlog.appenderOpen(2, 0, str3, str3, str2 + "_ilinkservice", 0, "1aee6c1d19ac4865e89c8898343c047ba99bd17808567cdb3e5c07b769a52715942a76a0cc54f5311f3bc4a6ac59feb2257f1c05e224b55833bc2ea1ce1eed59");
        Xlog xlog = new Xlog();
        this.m_xlog = xlog;
        Log.setLogImp(xlog);
        Log.d("IlinkDeviceManager", "init Xlog ok!");
        ILinkDevInterfaceService.getInstance().initLog(str3, 0);
        ApiProto.IlinkStartConfig.Builder newBuilder = ApiProto.IlinkStartConfig.newBuilder();
        newBuilder.setFileDir(str);
        if (initParameter.hasDebugIp()) {
            newBuilder.setDebugIp(initParameter.getDebugIp());
        } else {
            newBuilder.setDebugIp("");
        }
        newBuilder.setDebugNet(initParameter.getDebugNet());
        if (initParameter.hasUseIotdomain()) {
            if (initParameter.getUseIotdomain()) {
                Log.i("IlinkDeviceManager", "going to use iot domain!");
                newBuilder.setSelectDomain(1);
            } else {
                Log.i("IlinkDeviceManager", "UseIotdomain is false going to use default domain!");
            }
        } else {
            Log.i("IlinkDeviceManager", "UseIotdomain not config going to use default domain!");
        }
        newBuilder.setRunningMode(ApiProto.IlinkRunningMode.kIlinkAppMode);
        ILinkDevInterfaceService.getInstance().setILinkCallback(this);
        DeviceInterface.getInstance().setDeviceCallback(this);
        DeviceInterface.Start(newBuilder.build().toByteArray());
    }

    public void AppModeStop() {
        DeviceInterface.Stop();
        DeviceInterface.getInstance().setDeviceCallback(null);
        ILinkDevInterfaceService.getInstance().uninitLog();
        this.m_xlog.appenderClose();
        this.m_xlog = null;
    }

    @Override // com.tencent.ilink.network.DeviceCallbackInterface
    public void OnFinishGetStrategy() {
        Log.d("IlinkDeviceManager", "ilinknetwork onFinishGetStrategy");
        this.m_observer_.addDeviceCallbackTask("", "onFinishGetStrategy", new Class[0], new Object[0]);
    }

    @Override // com.tencent.ilink.network.DeviceCallbackInterface
    public void OnLonglinkConnected() {
        Log.d("IlinkDeviceManager", "OnLonglinkConnected");
        this.m_observer_.addDeviceCallbackTask("", "onNetStatusChanged", new Class[]{Integer.TYPE}, 1);
    }

    @Override // com.tencent.ilink.network.DeviceCallbackInterface
    public void OnLonglinkDisconnected() {
        Log.d("IlinkDeviceManager", "OnLonglinkDisconnected");
        this.m_observer_.addDeviceCallbackTask("", "onNetStatusChanged", new Class[]{Integer.TYPE}, 0);
    }

    public void autoLogin() {
        ILinkDevInterfaceService.getInstance().login(300);
    }

    public void changeDomain(int i3) {
        ILinkDevInterfaceService.getInstance().changeDomain(i3);
    }

    public String getIlinkId() {
        return ILinkDevInterfaceService.getInstance().getIlinkId();
    }

    public long getIlinkUin() {
        return ILinkDevInterfaceService.getInstance().getUin();
    }

    public String getToken() {
        return ILinkDevInterfaceService.getInstance().getToken();
    }

    public boolean isAlreadyGetStrategy() {
        return DeviceInterface.isAlreadyGetStrategy();
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onDevLoginComplete(int i3, int i16) {
        Log.d("IlinkDeviceManager", "onLoginComplete:" + i3);
        this.m_observer_.onLoginComplete(i3, i16);
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onFinishGetStrategy() {
        Log.d("IlinkDeviceManager", "onFinishGetStrategy");
        this.m_observer_.addDeviceCallbackTask("", "onFinishGetStrategy", new Class[0], new Object[0]);
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onNetStatusChanged(int i3) {
        Log.d("IlinkDeviceManager", "onNetStatusChanged:" + i3);
        this.m_observer_.addDeviceCallbackTask("", "onNetStatusChanged", new Class[]{Integer.TYPE}, Integer.valueOf(i3));
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onReceiveMessage(int i3, byte[] bArr) {
        Log.i("IlinkDeviceManager", "onReceiveMessage cmdid:" + i3);
        if (i3 != 1) {
            Log.w("IlinkDeviceManager", "Not addmsg type cmdid:" + i3);
            return;
        }
        try {
            IlinkServiceProto.AddMsgCmd parseFrom = IlinkServiceProto.AddMsgCmd.parseFrom(bArr);
            if (parseFrom.getMsgType() == 10003) {
                this.m_observer_.addDeviceCallbackTask("", "onReceiveMessage", new Class[]{String.class, String.class, String.class, String.class, Integer.TYPE}, parseFrom.getFromIlinkId(), "", "", parseFrom.getContent(), 0);
            } else {
                Log.i("IlinkDeviceManager", "Not 10003 msgtype just ignore!");
            }
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            Log.e("IlinkDeviceManager", "parseFrom addmsg failed!");
        }
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onReceivePullLogCmd(byte[] bArr) {
        Log.d("IlinkDeviceManager", "onReceivePullLogCmd");
        this.m_observer_.addDeviceCallbackTask("", "OnCommonFunctionCallback", new Class[]{String.class, byte[].class}, "onReceivePullLogCmd", bArr);
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onSendMsgResult(int i3, String str) {
        Log.i("IlinkDeviceManager", "onSendMsgResult:" + i3);
        if (this.m_msgid_caller_map_.containsKey(str)) {
            Class[] clsArr = {Integer.TYPE, String.class};
            String str2 = this.m_msgid_caller_map_.get(str);
            this.m_msgid_caller_map_.remove(str);
            this.m_observer_.addDeviceCallbackTask(str2, "onSendMsgResult", clsArr, Integer.valueOf(i3), str);
            return;
        }
        Log.i("IlinkDeviceManager", "no body care about this message just ignore:" + str);
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onUploadLogComplete(int i3) {
        Log.d("IlinkDeviceManager", "onUploadLogComplete:" + i3);
        this.m_observer_.addDeviceCallbackTask("", "OnCommonFunctionCallback", new Class[]{String.class, byte[].class}, "onUploadLogComplete", AidlProto.onUploadLogComplete.newBuilder().setErrcode(i3).build().toByteArray());
    }

    public String sendIotMessage(String str, String str2, String str3, String str4, String str5) {
        String sendIotMessage = ILinkDevInterfaceService.getInstance().sendIotMessage(str2, str3, str4, str5);
        this.m_msgid_caller_map_.put(sendIotMessage, str);
        return sendIotMessage;
    }

    public void setConsoleLogOpen(boolean z16) {
        Xlog.setConsoleLogOpen(z16);
    }

    public void setLogLevel(int i3) {
        Xlog.setLogLevel(i3);
    }

    public void setLonglinkIplist(byte[] bArr) {
        try {
            DeviceInterface.SetLonglinkIplist(AidlProto.setLonglinkIplist.parseFrom(bArr).getSvriplist().toByteArray());
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
        }
    }

    public void setProxyInfo(byte[] bArr) {
        DeviceInterface.SetProxyInfo(bArr);
    }

    public void setShortlinkIplist(byte[] bArr) {
        try {
            DeviceInterface.SetShortlinkIplist(AidlProto.setShortlinkIplist.parseFrom(bArr).getSvriplist().toByteArray());
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
        }
    }

    public void start(String str, IlinkServiceProto.InitParameter initParameter, String str2) {
        String str3 = str + "/log";
        if (initParameter.hasLogpath() && !initParameter.getLogpath().equals("")) {
            str3 = initParameter.getLogpath();
        }
        Xlog.setConsoleLogOpen(false);
        Xlog.appenderOpen(2, 0, str3, str3, str2 + "_ilinkservice", 0, "1aee6c1d19ac4865e89c8898343c047ba99bd17808567cdb3e5c07b769a52715942a76a0cc54f5311f3bc4a6ac59feb2257f1c05e224b55833bc2ea1ce1eed59");
        Xlog xlog = new Xlog();
        this.m_xlog = xlog;
        Log.setLogImp(xlog);
        Log.d("IlinkDeviceManager", "init Xlog ok!");
        IlinkDevApi.StartConfig.Builder newBuilder = IlinkDevApi.StartConfig.newBuilder();
        newBuilder.setFileDir(str);
        if (initParameter.hasDebugIp()) {
            newBuilder.setDebugIp(initParameter.getDebugIp());
        } else {
            newBuilder.setDebugIp("");
        }
        newBuilder.setDebugNet(initParameter.getDebugNet());
        if (initParameter.hasUseIotdomain()) {
            if (initParameter.getUseIotdomain()) {
                Log.i("IlinkDeviceManager", "going to use iot domain!");
                newBuilder.setSelectDomain(1);
            } else {
                Log.i("IlinkDeviceManager", "UseIotdomain is false going to use default domain!");
            }
        } else {
            Log.i("IlinkDeviceManager", "UseIotdomain not config going to use default domain!");
        }
        ILinkDevInterfaceService.getInstance().initLog(str3, 2);
        ILinkDevInterfaceService.getInstance().setILinkCallback(this);
        ILinkDevInterfaceService.getInstance().init(newBuilder.build().toByteArray(), initParameter.getProductId(), initParameter.getDeviceId(), initParameter.getDeviceSignature(), initParameter.getSignatureVersion(), initParameter.getAuthType(), initParameter.getSignatureTimestamp(), false);
        ILinkDevInterfaceService.getInstance().login(300);
        this.m_msgid_caller_map_.clear();
    }

    public void startUploadLog(byte[] bArr) {
        ILinkDevInterfaceService.getInstance().startUploadLog(bArr);
    }

    public void stop() {
        ILinkDevInterfaceService.getInstance().uninit();
        this.m_msgid_caller_map_.clear();
        this.m_xlog.appenderClose();
        this.m_xlog = null;
    }

    public void stopUploadLog() {
        ILinkDevInterfaceService.getInstance().stopUploadLog();
    }

    public void updateDeviceInfo(byte[] bArr) {
        ILinkDevInterfaceService.getInstance().updateDeviceParams(bArr);
    }

    @Override // com.tencent.ilink.network.DeviceCallbackInterface
    public void OnSessionTimeout() {
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onDevLogoutComplete(int i3) {
    }

    @Override // com.tencent.ilink.dev.interfaces.IILinkDevCallback
    public void onReceiveResponse(int i3, int i16, byte[] bArr) {
    }
}
