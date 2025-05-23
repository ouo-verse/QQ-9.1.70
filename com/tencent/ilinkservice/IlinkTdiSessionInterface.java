package com.tencent.ilinkservice;

import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.IlinkServiceProto;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IlinkTdiSessionInterface {
    void autoLogin();

    void cancel(TdiApiProto.TdiCancelType tdiCancelType);

    void cancelAppRequest(int i3);

    void cancelCdnDownload(int i3);

    void cancelCdnUpload(int i3);

    int cancelOAuth(TdiApiProto.TdiCancelOAuthRequest tdiCancelOAuthRequest);

    void cancelRequest(int i3);

    void checkLoginQrCode();

    IlinkTdiCloneSessionInterface createCloneSession();

    void destroyCloneSession(IlinkTdiCloneSessionInterface ilinkTdiCloneSessionInterface);

    void faceExtVerify(TdiApiProto.TdiFaceExtVerifyRequest tdiFaceExtVerifyRequest);

    void faceLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest);

    void faceRecognize(TdiApiProto.TdiFaceRecognizeRequest tdiFaceRecognizeRequest);

    void faceRecognizeConfig(TdiApiProto.TdiFaceRecognizeConfigRequest tdiFaceRecognizeConfigRequest);

    int getAppPushToken(byte[] bArr);

    void getLoginQrCode(TdiApiProto.TdiGetLoginQrCodeRequest tdiGetLoginQrCodeRequest);

    int getOAuthCode(TdiApiProto.TdiGetOAuthCodeRequest tdiGetOAuthCodeRequest);

    TdiApiProto.TdiUserInfo getUserInfo();

    void logOut();

    void oauthLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest);

    void palmLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest);

    void qrCodeLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest);

    void requestMultiProcessCloneTicket();

    void requestUploadLogfiles(int i3, int i16);

    int sendAppRequest(TdiApiProto.TdiAppRequest tdiAppRequest);

    void setCallback(TdiSessionCallback tdiSessionCallback);

    void setSmcBaseInfo(IlinkServiceProto.IlinkSmcBaseInfo ilinkSmcBaseInfo);

    void setSmcUin(int i3);

    void smcFlushReportData();

    int startCdnDownload(ApiProto.IlinkC2CDownload ilinkC2CDownload);

    int startCdnUpload(ApiProto.IlinkC2CUpload ilinkC2CUpload);

    void thirdAppLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest);

    void updateIlinkToken(String str);

    void visitorLogin(TdiApiProto.TdiLoginRequest tdiLoginRequest);

    void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17);

    void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17, int i17);
}
