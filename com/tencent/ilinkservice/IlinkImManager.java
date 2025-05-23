package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.interfaces.IILinkCallback;
import com.tencent.ilink.interfaces.ILinkAppImInterfaceService;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.luggage.wxa.s0.b;
import com.tencent.mars.ilink.xlog.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkImManager implements IILinkCallback {
    private final String TAG = "IlinkImManager";
    private String m_current_im_appid_ = "";
    private String m_current_im_caller_ = "";
    private String m_file_dir_;
    private IlinkImObserver m_observer_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkImObserver {
        void addImCallbackTask(String str, String str2, Class[] clsArr, Object... objArr);
    }

    public IlinkImManager(String str, IlinkImObserver ilinkImObserver) {
        this.m_file_dir_ = "";
        IlinkServiceInterface.getIlinkLoadDelegate().loadLibrary("ilink_im");
        this.m_file_dir_ = str;
        this.m_observer_ = ilinkImObserver;
        ILinkAppImInterfaceService.getInstance().setILinkCallback(this);
    }

    public void createImSession(String str, byte[] bArr) {
        try {
            AidlProto.createImSession parseFrom = AidlProto.createImSession.parseFrom(bArr);
            if (this.m_current_im_appid_.equals(parseFrom.getAppid())) {
                Log.i("IlinkImManager", "appid match do nothing!");
                this.m_current_im_caller_ = str;
                return;
            }
            if (this.m_current_im_appid_.equals("")) {
                Log.i("IlinkImManager", "im not create yet try to create one");
                if (ILinkAppImInterfaceService.getInstance().init(parseFrom.getAppid(), this.m_file_dir_, false, false) != 0) {
                    ILinkAppImInterfaceService.getInstance().init(parseFrom.getAppid(), this.m_file_dir_, false, true);
                }
                this.m_current_im_appid_ = parseFrom.getAppid();
                this.m_current_im_caller_ = str;
                return;
            }
            Log.w("IlinkImManager", "exit im appid not match with new one just recreate one");
            ILinkAppImInterfaceService.getInstance().uninit();
            if (ILinkAppImInterfaceService.getInstance().init(parseFrom.getAppid(), this.m_file_dir_, false, false) != 0) {
                ILinkAppImInterfaceService.getInstance().init(parseFrom.getAppid(), this.m_file_dir_, false, true);
            }
            this.m_current_im_appid_ = parseFrom.getAppid();
            this.m_current_im_caller_ = str;
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            Log.e("IlinkImManager", "proto parse failed!");
        }
    }

    public void destroyImSession() {
        ILinkAppImInterfaceService.getInstance().uninit();
        this.m_current_im_appid_ = "";
        this.m_current_im_caller_ = "";
    }

    public int getDeviceShadow() {
        return ILinkAppImInterfaceService.getInstance().getDeviceShadow();
    }

    public void loginImSession() {
        if (this.m_current_im_appid_.equals("")) {
            Log.e("IlinkImManager", "im instance not exit!");
        } else {
            ILinkAppImInterfaceService.getInstance().login(30);
        }
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onDeviceShadowUpdate(byte[] bArr) {
        Log.d("IlinkImManager", "im session onDeviceShadowUpdate");
        AidlProto.onDeviceShadowUpdate build = AidlProto.onDeviceShadowUpdate.newBuilder().setAppid(this.m_current_im_appid_).setShadowdata(ByteString.copyFrom(bArr)).build();
        this.m_observer_.addImCallbackTask(this.m_current_im_caller_, "OnCommonFunctionCallback", new Class[]{String.class, byte[].class}, "onDeviceShadowUpdate", build.toByteArray());
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onGetDeviceShadow(int i3, int i16, byte[] bArr) {
        Log.d("IlinkImManager", "im session onGetDeviceShadow");
        AidlProto.onGetDeviceShadow build = AidlProto.onGetDeviceShadow.newBuilder().setAppid(this.m_current_im_appid_).setTaskid(i3).setResult(i16).setShadowdata(ByteString.copyFrom(bArr)).build();
        this.m_observer_.addImCallbackTask(this.m_current_im_caller_, "OnCommonFunctionCallback", new Class[]{String.class, byte[].class}, "onGetDeviceShadow", build.toByteArray());
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onLoginComplete(int i3) {
        Log.i("IlinkImManager", "im session onLoginComplete");
        AidlProto.onImLoginComplete build = AidlProto.onImLoginComplete.newBuilder().setAppid(this.m_current_im_appid_).setResult(i3).build();
        this.m_observer_.addImCallbackTask(this.m_current_im_caller_, "OnCommonFunctionCallback", new Class[]{String.class, byte[].class}, "onImLoginComplete", build.toByteArray());
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onUpdateDeviceShadow(int i3, int i16, byte[] bArr) {
        Log.d("IlinkImManager", "im session onUpdateDeviceShadow");
        AidlProto.onUpdateDeviceShadow build = AidlProto.onUpdateDeviceShadow.newBuilder().setAppid(this.m_current_im_appid_).setTaskid(i3).setResult(i16).setShadowdata(ByteString.copyFrom(bArr)).build();
        this.m_observer_.addImCallbackTask(this.m_current_im_caller_, "OnCommonFunctionCallback", new Class[]{String.class, byte[].class}, "onUpdateDeviceShadow", build.toByteArray());
    }

    public void stop() {
        if (this.m_current_im_appid_.equals("")) {
            return;
        }
        ILinkAppImInterfaceService.getInstance().uninit();
        this.m_current_im_appid_ = "";
        this.m_current_im_caller_ = "";
    }

    public int updateDeviceShadow(byte[] bArr) {
        return ILinkAppImInterfaceService.getInstance().updateDeviceShadow(bArr);
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onContactsCleared() {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onThingTicketAndQrCodeTimeout() {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onCloseSdkAccount(int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onInitContacts(int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onInitContactsComplete(int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onLogoutComplete(int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onNetStatusChanged(int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onReportDataWithCacheKey(int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onAvatarUpdate(int i3, String str) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onContactVerifyRequestUpdate(String str, byte[] bArr) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onHandleContactVerifyRequestComplete(String str, int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onHangupVoipComplete(int i3, String str) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onNicknameUpdate(int i3, String str) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onReceiveCertainMessage(int i3, byte[] bArr) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onReceiveILinkThirdNotify(int i3, String str) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onSendMsgResult(int i3, String str) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onContactUpdate(int i3, String str, b bVar) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onCreateRoom(int i3, long j3, String str) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onInviteVoipComplete(int i3, String str, String str2) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onUpdateContactAlias(int i3, String str, String str2) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onGetPublicAccountQrCode(int i3, String str, int i16, int i17) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onGetThingTicket(int i3, String str, int i16, int i17) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onVoipHanguped(String str, String str2, String str3, int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onReceiveMessage(String str, String str2, String str3, String str4, int i3) {
    }

    @Override // com.tencent.ilink.interfaces.IILinkCallback
    public void onReceiveILinkVoipNotify(long j3, String str, String str2, String str3, boolean z16, int i3) {
    }
}
