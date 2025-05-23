package com.tencent.luggage.wxa.u3;

import android.util.Log;
import com.google.protobuf.ByteString;
import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.IlinkServiceInterface;
import com.tencent.ilinkservice.IlinkServiceProto;
import com.tencent.ilinkservice.IlinkTdiCloneSessionInterface;
import com.tencent.ilinkservice.IlinkTdiSessionInterface;
import com.tencent.ilinkservice.TdiSessionCallback;
import com.tencent.luggage.wxa.n3.c0;
import com.tencent.luggage.wxa.n3.l;
import com.tencent.luggage.wxa.n3.o;
import com.tencent.luggage.wxa.n3.r;
import com.tencent.luggage.wxa.n3.s;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.n3.y;
import com.tencent.luggage.wxa.tn.w;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements t {

    /* renamed from: f, reason: collision with root package name */
    public static final a f142102f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final IlinkTdiSessionInterface f142103a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142104b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f142105c;

    /* renamed from: d, reason: collision with root package name */
    public t.a f142106d;

    /* renamed from: e, reason: collision with root package name */
    public final d f142107e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f142108a;

        static {
            int[] iArr = new int[TdiApiProto.TdiLoginStatus.values().length];
            iArr[TdiApiProto.TdiLoginStatus.kTdiLoginUnknown.ordinal()] = 1;
            iArr[TdiApiProto.TdiLoginStatus.kTdiLoginSuccess.ordinal()] = 2;
            iArr[TdiApiProto.TdiLoginStatus.kTdiRequireManualLogin.ordinal()] = 3;
            iArr[TdiApiProto.TdiLoginStatus.kTdiRequireAutoLogin.ordinal()] = 4;
            f142108a = iArr;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u3.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6784c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IlinkTdiCloneSessionInterface f142110b;

        public RunnableC6784c(IlinkTdiCloneSessionInterface ilinkTdiCloneSessionInterface) {
            this.f142110b = ilinkTdiCloneSessionInterface;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f142103a.destroyCloneSession(this.f142110b);
        }
    }

    public c(IlinkTdiSessionInterface tdiSession, String ilinkAppId) {
        Intrinsics.checkNotNullParameter(tdiSession, "tdiSession");
        Intrinsics.checkNotNullParameter(ilinkAppId, "ilinkAppId");
        this.f142103a = tdiSession;
        this.f142104b = ilinkAppId;
        this.f142105c = Collections.synchronizedSet(new HashSet());
        d dVar = new d();
        this.f142107e = dVar;
        tdiSession.setCallback(dVar);
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public void autoLogin() {
        this.f142103a.autoLogin();
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public void c(t.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f142106d = callback;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IlinkServiceInterface.getInstance().destroyTdiSession(this.f142103a);
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public r createCloneSession() {
        IlinkTdiCloneSessionInterface cloneSessionImpl = this.f142103a.createCloneSession();
        w.d("Luggage.IlinkServiceLoginSession", "createCloneSession masterImpl@" + this.f142103a.hashCode() + " cloneImpl@" + cloneSessionImpl.hashCode());
        Intrinsics.checkNotNullExpressionValue(cloneSessionImpl, "cloneSessionImpl");
        com.tencent.luggage.wxa.u3.b bVar = new com.tencent.luggage.wxa.u3.b(cloneSessionImpl, new RunnableC6784c(cloneSessionImpl));
        this.f142105c.add(bVar);
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public void f() {
        w.d("Luggage.IlinkServiceLoginSession", "destroySession stack:" + Log.getStackTraceString(new Throwable()));
        HashSet hashSet = new HashSet(this.f142105c);
        this.f142105c.clear();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((r) it.next()).close();
        }
        IlinkServiceInterface.getInstance().destroyTdiSession(this.f142103a);
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public c0 getLoginStatus() {
        TdiApiProto.TdiLoginStatus tdiLoginStatus;
        int i3;
        TdiApiProto.TdiUserInfo userInfo = this.f142103a.getUserInfo();
        if (userInfo != null) {
            tdiLoginStatus = userInfo.getLoginStatus();
        } else {
            tdiLoginStatus = null;
        }
        if (tdiLoginStatus == null) {
            i3 = -1;
        } else {
            i3 = b.f142108a[tdiLoginStatus.ordinal()];
        }
        if (i3 != -1 && i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return c0.REQUIRE_AUTO_LOGIN;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return c0.REQUIRE_MANUAL_LOGIN;
            }
            return c0.LOGIN_SUCCESS;
        }
        return c0.LOGIN_UNKNOWN;
    }

    @Override // com.tencent.luggage.wxa.n3.u
    public long getUin() {
        return this.f142103a.getUserInfo().getUin();
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public String getUsername() {
        String username = this.f142103a.getUserInfo().getUsername();
        Intrinsics.checkNotNullExpressionValue(username, "tdiSession.userInfo.username");
        return username;
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public String o() {
        return this.f142104b;
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public void requestUploadLogfiles(int i3, int i16) {
        this.f142103a.requestUploadLogfiles(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.n3.u
    public void v() {
        this.f142103a.cancel(TdiApiProto.TdiCancelType.kTdiCancelAll);
    }

    @Override // com.tencent.luggage.wxa.n3.u
    public void writeKvData(int i3, byte[] data, boolean z16, int i16, boolean z17, int i17) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i17 == 0) {
            this.f142103a.writeKvData(i3, data, z16, i16, z17);
        } else {
            this.f142103a.writeKvData(i3, data, z16, i16, z17, i17);
        }
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public void a(String authCode, String str) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        IlinkTdiSessionInterface ilinkTdiSessionInterface = this.f142103a;
        TdiApiProto.TdiLoginRequest.Builder authCode2 = TdiApiProto.TdiLoginRequest.newBuilder().setAuthCode(ByteString.copyFromUtf8(authCode));
        if (str != null) {
            authCode2.setLkid(ByteString.copyFromUtf8(str));
        }
        ilinkTdiSessionInterface.thirdAppLogin(authCode2.setSessionType(1).build());
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public void b() {
        this.f142103a.logOut();
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public int a(int i3, int i16, String str, String str2, String str3, boolean z16, int i17) {
        return this.f142103a.startCdnUpload(ApiProto.IlinkC2CUpload.newBuilder().setAppType(i3).setFileType(i16).setTaskIdent(str).setFilePath(str2).setThumbFilepath(str3).setIsStorageMode(z16).setSnsUploadVersion(i17).setBizScene(ApiProto.IlinkEBizScene.kAppScene).build());
    }

    @Override // com.tencent.luggage.wxa.n3.t
    public void a(String osName, String osVersion, String deviceBrand, String deviceModel, String languageVer) {
        Intrinsics.checkNotNullParameter(osName, "osName");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceBrand, "deviceBrand");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(languageVer, "languageVer");
        this.f142103a.setSmcBaseInfo(IlinkServiceProto.IlinkSmcBaseInfo.newBuilder().setOsname(osName).setOsversion(osVersion).setDeviceBrand(deviceBrand).setDeviceModel(deviceModel).setLanguageVer(languageVer).build());
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements TdiSessionCallback {
        public d() {
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onCdnDownloadCompleted(int i3, ApiProto.IlinkC2CDownloadResult ilinkC2CDownloadResult) {
            com.tencent.luggage.wxa.n3.c cVar;
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                if (ilinkC2CDownloadResult != null) {
                    int errorCode = ilinkC2CDownloadResult.getErrorCode();
                    String taskIdent = ilinkC2CDownloadResult.getTaskIdent();
                    Intrinsics.checkNotNullExpressionValue(taskIdent, "it.taskIdent");
                    cVar = new com.tencent.luggage.wxa.n3.c(errorCode, taskIdent);
                } else {
                    cVar = null;
                }
                aVar.a(i3, cVar);
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onCdnUploadCompleted(int i3, ApiProto.IlinkC2CUploadResult ilinkC2CUploadResult) {
            com.tencent.luggage.wxa.n3.d dVar;
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                if (ilinkC2CUploadResult != null) {
                    int errorCode = ilinkC2CUploadResult.getErrorCode();
                    String fileUrl = ilinkC2CUploadResult.getFileUrl();
                    Intrinsics.checkNotNullExpressionValue(fileUrl, "it.fileUrl");
                    String thumbUrl = ilinkC2CUploadResult.getThumbUrl();
                    Intrinsics.checkNotNullExpressionValue(thumbUrl, "it.thumbUrl");
                    String taskIdent = ilinkC2CUploadResult.getTaskIdent();
                    Intrinsics.checkNotNullExpressionValue(taskIdent, "it.taskIdent");
                    dVar = new com.tencent.luggage.wxa.n3.d(errorCode, fileUrl, thumbUrl, taskIdent);
                } else {
                    dVar = null;
                }
                aVar.a(i3, dVar);
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onCheckLoginQrCodeComplete(int i3, TdiApiProto.TdiCheckLoginQrCodeResponse resp) {
            Object orNull;
            Intrinsics.checkNotNullParameter(resp, "resp");
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                l lVar = null;
                if (i3 == 0) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(s.f135254a.a(), resp.getStatus().getNumber());
                    s sVar = (s) orNull;
                    if (sVar == null) {
                        c cVar = c.this;
                        w.b("Luggage.IlinkServiceLoginSession", "Unknown ilink LoginQrCodeStatus " + resp.getStatus());
                        t.a aVar2 = cVar.f142106d;
                        if (aVar2 != null) {
                            aVar2.a(-1, (l) null);
                            return;
                        }
                        return;
                    }
                    long uin = resp.getUin();
                    String nickname = resp.getNickname();
                    String avatarUrl = resp.getAvatarUrl();
                    ByteString businessConfirmRespBuffer = resp.getBusinessConfirmRespBuffer();
                    Intrinsics.checkNotNullExpressionValue(businessConfirmRespBuffer, "resp.businessConfirmRespBuffer");
                    lVar = new l(sVar, uin, nickname, avatarUrl, businessConfirmRespBuffer);
                }
                aVar.a(i3, lVar);
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onFaceExtVerifyComplete(int i3, TdiApiProto.TdiFaceExtVerifyResponse resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onFaceRecognizeComplete(int i3, TdiApiProto.TdiFaceRecognizeResponse resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onFaceRecognizeConfigComplete(int i3, TdiApiProto.TdiFaceRecognizeConfigResponse resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onGetAppPushTokenComplete(int i3, int i16, TdiApiProto.TdiAppPushToken tdiAppPushToken) {
            com.tencent.luggage.wxa.n3.a aVar;
            t.a aVar2 = c.this.f142106d;
            if (aVar2 != null) {
                if (tdiAppPushToken != null) {
                    byte[] byteArray = tdiAppPushToken.getToken().toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "it.token.toByteArray()");
                    aVar = new com.tencent.luggage.wxa.n3.a(byteArray, tdiAppPushToken.getExpireTimestamp());
                } else {
                    aVar = null;
                }
                aVar2.a(i3, i16, aVar);
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onGetLoginQrCodeComplete(int i3, TdiApiProto.TdiGetLoginQrCodeResponse resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                String path = resp.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "resp.path");
                aVar.a(i3, new o(path));
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onGetOAuthCodeComplete(int i3, int i16, TdiApiProto.TdiGetOAuthCodeResponse resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onLoginComplete(int i3, TdiApiProto.TdiLoginResponse resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                aVar.onLoginComplete(i3);
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onLogoutComplete(int i3) {
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                aVar.onLogoutComplete(i3);
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onReceiveAppMessage(TdiApiProto.TdiAppMessage appMessage) {
            Intrinsics.checkNotNullParameter(appMessage, "appMessage");
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                byte[] byteArray = appMessage.getBody().toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "appMessage.body.toByteArray()");
                aVar.a(byteArray);
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onReceiveAppResponse(int i3, int i16, TdiApiProto.TdiAppResponse resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                byte[] byteArray = resp.getBody().toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "resp.body.toByteArray()");
                aVar.a(i3, i16, byteArray);
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onRequestUploadLogfiles(IlinkServiceProto.IlinkPullLogCmd cmd) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            t.a aVar = c.this.f142106d;
            if (aVar != null) {
                int startTime = cmd.getStartTime();
                int endTime = cmd.getEndTime();
                String uploadToken = cmd.getUploadToken();
                int useNettype = cmd.getUseNettype();
                List<String> ilinkAppidsList = cmd.getIlinkAppidsList();
                Intrinsics.checkNotNullExpressionValue(ilinkAppidsList, "cmd.ilinkAppidsList");
                boolean includeDevlog = cmd.getIncludeDevlog();
                String extBuffer = cmd.getExtBuffer();
                String ilinkCapath = cmd.getIlinkCapath();
                List<String> ilinkLogsList = cmd.getIlinkLogsList();
                Intrinsics.checkNotNullExpressionValue(ilinkLogsList, "cmd.ilinkLogsList");
                aVar.a(new y(startTime, endTime, uploadToken, useNettype, ilinkAppidsList, includeDevlog, extBuffer, ilinkCapath, ilinkLogsList));
            }
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onAppSessionTimeout() {
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onCancelOAuthComplete(int i3, int i16) {
        }

        @Override // com.tencent.ilinkservice.TdiSessionCallback
        public void onReceiveMultiProcessCloneTicket(int i3, String str) {
        }
    }
}
