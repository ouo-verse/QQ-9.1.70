package com.tencent.ilinkservice;

import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.IlinkServiceProto;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface TdiSessionCallback {
    void onAppSessionTimeout();

    void onCancelOAuthComplete(int i3, int i16);

    void onCdnDownloadCompleted(int i3, ApiProto.IlinkC2CDownloadResult ilinkC2CDownloadResult);

    void onCdnUploadCompleted(int i3, ApiProto.IlinkC2CUploadResult ilinkC2CUploadResult);

    void onCheckLoginQrCodeComplete(int i3, TdiApiProto.TdiCheckLoginQrCodeResponse tdiCheckLoginQrCodeResponse);

    void onFaceExtVerifyComplete(int i3, TdiApiProto.TdiFaceExtVerifyResponse tdiFaceExtVerifyResponse);

    void onFaceRecognizeComplete(int i3, TdiApiProto.TdiFaceRecognizeResponse tdiFaceRecognizeResponse);

    void onFaceRecognizeConfigComplete(int i3, TdiApiProto.TdiFaceRecognizeConfigResponse tdiFaceRecognizeConfigResponse);

    void onGetAppPushTokenComplete(int i3, int i16, TdiApiProto.TdiAppPushToken tdiAppPushToken);

    void onGetLoginQrCodeComplete(int i3, TdiApiProto.TdiGetLoginQrCodeResponse tdiGetLoginQrCodeResponse);

    void onGetOAuthCodeComplete(int i3, int i16, TdiApiProto.TdiGetOAuthCodeResponse tdiGetOAuthCodeResponse);

    void onLoginComplete(int i3, TdiApiProto.TdiLoginResponse tdiLoginResponse);

    void onLogoutComplete(int i3);

    void onReceiveAppMessage(TdiApiProto.TdiAppMessage tdiAppMessage);

    void onReceiveAppResponse(int i3, int i16, TdiApiProto.TdiAppResponse tdiAppResponse);

    void onReceiveMultiProcessCloneTicket(int i3, String str);

    void onRequestUploadLogfiles(IlinkServiceProto.IlinkPullLogCmd ilinkPullLogCmd);
}
