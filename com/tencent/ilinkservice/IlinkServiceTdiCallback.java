package com.tencent.ilinkservice;

import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilink.tdi.manager.TdiManager;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.mars.ilink.xlog.Log;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes7.dex */
final class IlinkServiceTdiCallback implements TdiManager.Callback {
    private static final String TAG = "IlinkServiceTdiCB";
    private String m_appid_;
    private IlinkServiceTdiCallbackObserver m_observer_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkServiceTdiCallbackObserver {
        void addDeviceCallbackTask(String str, String str2, Class[] clsArr, Object... objArr);

        void addServiceCallbackTask(String str, String str2, Class[] clsArr, Object... objArr);

        String getCallerByTaskid(int i3);

        Vector<String> getCloneCallers(String str);
    }

    public IlinkServiceTdiCallback(String str, IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver) {
        this.m_appid_ = str;
        this.m_observer_ = ilinkServiceTdiCallbackObserver;
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onAppSessionTimeoutEvent() {
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onAppSessionTimeout", new Class[]{String.class}, str);
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onC2CDownloadComplete(int i3, ApiProto.IlinkC2CDownloadResult ilinkC2CDownloadResult) {
        byte[] byteArray = AidlProto.onCommFunctionCallback.newBuilder().setAppid(this.m_appid_).setTaskid(i3).setRespdata(ilinkC2CDownloadResult.toByteString()).build().toByteArray();
        this.m_observer_.addServiceCallbackTask(this.m_appid_, "OnCommonFunctionCallback", new Class[]{String.class, byte[].class}, "onC2CDownloadComplete", byteArray);
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onC2CDownloadProgress(int i3, long j3, long j16) {
        Log.d(TAG, "onC2CDownloadProgress taskid:" + i3 + ", cur:" + j3 + "tol:" + j16);
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onC2CUploadComplete(int i3, ApiProto.IlinkC2CUploadResult ilinkC2CUploadResult) {
        byte[] byteArray = AidlProto.onCommFunctionCallback.newBuilder().setAppid(this.m_appid_).setTaskid(i3).setRespdata(ilinkC2CUploadResult.toByteString()).build().toByteArray();
        this.m_observer_.addServiceCallbackTask(this.m_appid_, "OnCommonFunctionCallback", new Class[]{String.class, byte[].class}, "onC2CUploadComplete", byteArray);
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onC2CUploadProgress(int i3, long j3, long j16) {
        Log.d(TAG, "onC2CUploadProgress taskid:" + i3 + ", cur:" + j3 + "tol:" + j16);
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onCancelOAuthComplete(int i3, int i16) {
        Class cls = Integer.TYPE;
        Class[] clsArr = {String.class, cls, cls};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onCancelOAuthComplete", clsArr, str, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onCheckLoginQrCodeComplete(int i3, int i16, TdiApiProto.TdiCheckLoginQrCodeResponse tdiCheckLoginQrCodeResponse) {
        Class[] clsArr = {String.class, Integer.TYPE, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onCheckLoginQrCode", clsArr, str, Integer.valueOf(i16), tdiCheckLoginQrCodeResponse.toByteArray());
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onFaceExtVerifyComplete(int i3, int i16, TdiApiProto.TdiFaceExtVerifyResponse tdiFaceExtVerifyResponse) {
        Class[] clsArr = {String.class, Integer.TYPE, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onFaceExtVerifyComplete", clsArr, str, Integer.valueOf(i16), tdiFaceExtVerifyResponse.toByteArray());
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onFaceRecognizeComplete(int i3, int i16, TdiApiProto.TdiFaceRecognizeResponse tdiFaceRecognizeResponse) {
        Class[] clsArr = {String.class, Integer.TYPE, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onFaceRecognizeComplete", clsArr, str, Integer.valueOf(i16), tdiFaceRecognizeResponse.toByteArray());
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onFaceRecognizeConfigComplete(int i3, int i16, TdiApiProto.TdiFaceRecognizeConfigResponse tdiFaceRecognizeConfigResponse) {
        Class[] clsArr = {String.class, Integer.TYPE, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onFaceRecognizeConfigComplete", clsArr, str, Integer.valueOf(i16), tdiFaceRecognizeConfigResponse.toByteArray());
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onGetAppPushTokenComplete(int i3, int i16, TdiApiProto.TdiAppPushToken tdiAppPushToken) {
        Class cls = Integer.TYPE;
        Class[] clsArr = {String.class, cls, cls, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onNewGetAppPushTokenComplete", clsArr, str, Integer.valueOf(i3), Integer.valueOf(i16), tdiAppPushToken.toByteArray());
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onGetLoginQrCodeComplete(int i3, int i16, TdiApiProto.TdiGetLoginQrCodeResponse tdiGetLoginQrCodeResponse) {
        Class[] clsArr = {String.class, Integer.TYPE, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onGetLoginQrCodeComplete", clsArr, str, Integer.valueOf(i16), tdiGetLoginQrCodeResponse.toByteArray());
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onGetOAuthCodeComplete(int i3, int i16, TdiApiProto.TdiGetOAuthCodeResponse tdiGetOAuthCodeResponse) {
        Class cls = Integer.TYPE;
        Class[] clsArr = {String.class, cls, cls, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onGetOAuthCodeComplete", clsArr, str, Integer.valueOf(i3), Integer.valueOf(i16), tdiGetOAuthCodeResponse.toByteArray());
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onLoginComplete(int i3, TdiApiProto.TdiLoginType tdiLoginType, int i16, TdiApiProto.TdiLoginResponse tdiLoginResponse) {
        Class[] clsArr = {String.class, Integer.TYPE, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onTdiLoginComplete", clsArr, str, Integer.valueOf(i16), tdiLoginResponse.toByteArray());
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onLogoutComplete(int i3, int i16) {
        Class[] clsArr = {String.class, Integer.TYPE};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onLogoutComplete", clsArr, str, Integer.valueOf(i16));
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onReceiveAppMessageEvent(TdiApiProto.TdiAppMessage tdiAppMessage) {
        Class[] clsArr = {String.class, byte[].class};
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "onReceiveAppMessage", clsArr, str, tdiAppMessage.toByteArray());
        Vector<String> cloneCallers = this.m_observer_.getCloneCallers(this.m_appid_);
        if (cloneCallers != null) {
            Iterator<String> it = cloneCallers.iterator();
            while (it.hasNext()) {
                this.m_observer_.addDeviceCallbackTask(it.next(), "onReceiveAppMessage", clsArr, this.m_appid_, tdiAppMessage.toByteArray());
            }
        }
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onRequestUploadLogfilesEvent(byte[] bArr) {
        IlinkServiceTdiCallbackObserver ilinkServiceTdiCallbackObserver = this.m_observer_;
        String str = this.m_appid_;
        ilinkServiceTdiCallbackObserver.addServiceCallbackTask(str, "OnRequestUploadLogfiles", new Class[]{String.class, byte[].class}, str, bArr);
    }

    @Override // com.tencent.ilink.tdi.manager.TdiManager.Callback
    public void onSendAppRequestComplete(int i3, int i16, TdiApiProto.TdiAppResponse tdiAppResponse) {
        String callerByTaskid = this.m_observer_.getCallerByTaskid(i3);
        if (callerByTaskid.equals("")) {
            Log.e(TAG, "could not find caller by taskid:" + i3);
            return;
        }
        Class cls = Integer.TYPE;
        this.m_observer_.addDeviceCallbackTask(callerByTaskid, "onReceiveAppResponse", new Class[]{String.class, cls, cls, byte[].class}, this.m_appid_, Integer.valueOf(i3), Integer.valueOf(i16), tdiAppResponse.toByteArray());
    }
}
