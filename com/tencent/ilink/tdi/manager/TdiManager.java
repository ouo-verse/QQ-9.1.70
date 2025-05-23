package com.tencent.ilink.tdi.manager;

import com.google.protobuf.InvalidProtocolBufferException;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilink.tdi.TdiManagerJniInterface;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001FB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020 J\u0016\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\"J\u0016\u0010#\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001eJ\u0016\u0010&\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020*J\u0016\u0010+\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u000201J \u00102\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\b\u0010\u000f\u001a\u0004\u0018\u000105J\u000e\u00106\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eJ\u0016\u0010:\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020;J\u000e\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020(J\u000e\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\u000eJ\u0006\u0010@\u001a\u00020\fJ\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\u001eJ\u000e\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020(R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/tencent/ilink/tdi/manager/TdiManager;", "", "handle", "", "(J)V", "callback", "Lcom/tencent/ilink/tdi/manager/TdiManager$Callback;", "getCallback", "()Lcom/tencent/ilink/tdi/manager/TdiManager$Callback;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/ilink/tdi/manager/TdiManager$Callback;)V", "c2CDownload", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "req", "Lcom/tencent/ilink/network/ApiProto$IlinkC2CDownload;", "c2CUpload", "Lcom/tencent/ilink/network/ApiProto$IlinkC2CUpload;", "cancelC2CDownload", "cancelC2CUpload", "cancelOAuth", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiCancelOAuthRequest;", "cancelSendAppRequest", "cancelUniqueTask", "type", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiCancelType;", "checkLoginQrCode", "createTdiManager", "ilinkAppid", "", "faceExtVerify", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceExtVerifyRequest;", "faceRecognize", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceRecognizeRequest;", "faceRecognizeConfig", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceRecognizeConfigRequest;", "getAppId", "getAppPushToken", "extraInfo", "", "getLoginQrCode", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiGetLoginQrCodeRequest;", "getOAuthCode", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiGetOAuthCodeRequest;", "getUserInfo", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiUserInfo;", "init", "param", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiInitParameter;", "login", TangramHippyConstants.LOGIN_TYPE, "Lcom/tencent/ilink/tdi/TdiApiProto$TdiLoginType;", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiLoginRequest;", "logout", "requestUploadLogfiles", "startTimestamp", "endTimestamp", "sendAppRequest", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppRequest;", "setSmcBaseInfo", "baseinfo", "setSmcUin", "uin", "smcFlushReportData", "uninit", "updateIlinkToken", "ilinkToken", "writeKvData", "kvdata", "Callback", "tdi-android-lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes7.dex */
public final class TdiManager {

    @Nullable
    private Callback callback;
    private final long handle;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H&J\"\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H&J\"\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H&J\"\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001aH&J\"\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001cH&J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001eH&J\"\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010 H&J*\u0010!\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010$H&J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0012\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010(H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\"\u0010,\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010-H&\u00a8\u0006."}, d2 = {"Lcom/tencent/ilink/tdi/manager/TdiManager$Callback;", "", "onAppSessionTimeoutEvent", "", "onC2CDownloadComplete", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "result", "Lcom/tencent/ilink/network/ApiProto$IlinkC2CDownloadResult;", "onC2CDownloadProgress", "completedLength", "", "totalLength", "onC2CUploadComplete", "Lcom/tencent/ilink/network/ApiProto$IlinkC2CUploadResult;", "onC2CUploadProgress", "onCancelOAuthComplete", "error", "onCheckLoginQrCodeComplete", "resp", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiCheckLoginQrCodeResponse;", "onFaceExtVerifyComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceExtVerifyResponse;", "onFaceRecognizeComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceRecognizeResponse;", "onFaceRecognizeConfigComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceRecognizeConfigResponse;", "onGetAppPushTokenComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppPushToken;", "onGetLoginQrCodeComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiGetLoginQrCodeResponse;", "onGetOAuthCodeComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiGetOAuthCodeResponse;", "onLoginComplete", TangramHippyConstants.LOGIN_TYPE, "Lcom/tencent/ilink/tdi/TdiApiProto$TdiLoginType;", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiLoginResponse;", "onLogoutComplete", "onReceiveAppMessageEvent", "msg", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppMessage;", "onRequestUploadLogfilesEvent", "cmd", "", "onSendAppRequestComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppResponse;", "tdi-android-lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes7.dex */
    public interface Callback {
        void onAppSessionTimeoutEvent();

        void onC2CDownloadComplete(int taskId, @NotNull ApiProto.IlinkC2CDownloadResult result);

        void onC2CDownloadProgress(int taskId, long completedLength, long totalLength);

        void onC2CUploadComplete(int taskId, @NotNull ApiProto.IlinkC2CUploadResult result);

        void onC2CUploadProgress(int taskId, long completedLength, long totalLength);

        void onCancelOAuthComplete(int taskId, int error);

        void onCheckLoginQrCodeComplete(int taskId, int error, @Nullable TdiApiProto.TdiCheckLoginQrCodeResponse resp);

        void onFaceExtVerifyComplete(int taskId, int error, @Nullable TdiApiProto.TdiFaceExtVerifyResponse resp);

        void onFaceRecognizeComplete(int taskId, int error, @Nullable TdiApiProto.TdiFaceRecognizeResponse resp);

        void onFaceRecognizeConfigComplete(int taskId, int error, @Nullable TdiApiProto.TdiFaceRecognizeConfigResponse resp);

        void onGetAppPushTokenComplete(int taskId, int error, @Nullable TdiApiProto.TdiAppPushToken resp);

        void onGetLoginQrCodeComplete(int taskId, int error, @Nullable TdiApiProto.TdiGetLoginQrCodeResponse resp);

        void onGetOAuthCodeComplete(int taskId, int error, @Nullable TdiApiProto.TdiGetOAuthCodeResponse resp);

        void onLoginComplete(int taskId, @NotNull TdiApiProto.TdiLoginType loginType, int error, @Nullable TdiApiProto.TdiLoginResponse resp);

        void onLogoutComplete(int taskId, int error);

        void onReceiveAppMessageEvent(@Nullable TdiApiProto.TdiAppMessage msg2);

        void onRequestUploadLogfilesEvent(@NotNull byte[] cmd);

        void onSendAppRequestComplete(int taskId, int error, @Nullable TdiApiProto.TdiAppResponse resp);
    }

    public TdiManager(long j3) {
        this.handle = j3;
    }

    public final void c2CDownload(int taskId, @NotNull ApiProto.IlinkC2CDownload req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.ba(j3, taskId, byteArray);
    }

    public final void c2CUpload(int taskId, @NotNull ApiProto.IlinkC2CUpload req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.ay(j3, taskId, byteArray);
    }

    public final void cancelC2CDownload(long taskId) {
        TdiManagerJniInterface.INSTANCE.bb(this.handle, taskId);
    }

    public final void cancelC2CUpload(long taskId) {
        TdiManagerJniInterface.INSTANCE.az(this.handle, taskId);
    }

    public final void cancelOAuth(int taskId, @NotNull TdiApiProto.TdiCancelOAuthRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.ap(j3, taskId, byteArray);
    }

    public final void cancelSendAppRequest(long taskId) {
        TdiManagerJniInterface.INSTANCE.ar(this.handle, taskId);
    }

    public final void cancelUniqueTask(@NotNull TdiApiProto.TdiCancelType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TdiManagerJniInterface.INSTANCE.as(this.handle, type.getNumber());
    }

    public final void checkLoginQrCode(int taskId) {
        TdiManagerJniInterface.INSTANCE.an(this.handle, taskId);
    }

    public final long createTdiManager(@NotNull String ilinkAppid) {
        Intrinsics.checkNotNullParameter(ilinkAppid, "ilinkAppid");
        return TdiManagerJniInterface.INSTANCE.aa(ilinkAppid);
    }

    public final void faceExtVerify(int taskId, @NotNull TdiApiProto.TdiFaceExtVerifyRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.al(j3, taskId, byteArray);
    }

    public final void faceRecognize(int taskId, @NotNull TdiApiProto.TdiFaceRecognizeRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.ak(j3, taskId, byteArray);
    }

    public final void faceRecognizeConfig(int taskId, @NotNull TdiApiProto.TdiFaceRecognizeConfigRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.aj(j3, taskId, byteArray);
    }

    @NotNull
    public final String getAppId() {
        return TdiManagerJniInterface.INSTANCE.af(this.handle);
    }

    public final void getAppPushToken(int taskId, @NotNull byte[] extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        TdiManagerJniInterface.INSTANCE.aw(this.handle, taskId, extraInfo);
    }

    @Nullable
    public final Callback getCallback() {
        return this.callback;
    }

    public final void getLoginQrCode(int taskId, @NotNull TdiApiProto.TdiGetLoginQrCodeRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.am(j3, taskId, byteArray);
    }

    public final void getOAuthCode(int taskId, @NotNull TdiApiProto.TdiGetOAuthCodeRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.ao(j3, taskId, byteArray);
    }

    @NotNull
    public final TdiApiProto.TdiUserInfo getUserInfo() {
        TdiApiProto.TdiUserInfo defaultInstance = TdiApiProto.TdiUserInfo.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiUserInfo.getDefaultInstance()");
        try {
            TdiApiProto.TdiUserInfo parseFrom = TdiApiProto.TdiUserInfo.parseFrom(TdiManagerJniInterface.INSTANCE.ag(this.handle));
            Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiUserInfo.parseFrom(Td\u2026face.getUserInfo(handle))");
            return parseFrom;
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            return defaultInstance;
        }
    }

    public final void init(@NotNull TdiApiProto.TdiInitParameter param) {
        Intrinsics.checkNotNullParameter(param, "param");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = param.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "param.toByteArray()");
        tdiManagerJniInterface.ac(j3, byteArray);
    }

    public final void login(int taskId, @NotNull TdiApiProto.TdiLoginType loginType, @Nullable TdiApiProto.TdiLoginRequest req) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        int number = loginType.getNumber();
        if (req != null) {
            bArr = req.toByteArray();
        } else {
            bArr = null;
        }
        tdiManagerJniInterface.ah(j3, taskId, number, bArr);
    }

    public final void logout(int taskId) {
        TdiManagerJniInterface.INSTANCE.ai(this.handle, taskId);
    }

    public final void requestUploadLogfiles(int startTimestamp, int endTimestamp) {
        TdiManagerJniInterface.INSTANCE.ax(this.handle, startTimestamp, endTimestamp);
    }

    public final void sendAppRequest(int taskId, @NotNull TdiApiProto.TdiAppRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        TdiManagerJniInterface tdiManagerJniInterface = TdiManagerJniInterface.INSTANCE;
        long j3 = this.handle;
        byte[] byteArray = req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        tdiManagerJniInterface.aq(j3, taskId, byteArray);
    }

    public final void setCallback(@Nullable Callback callback) {
        this.callback = callback;
    }

    public final void setSmcBaseInfo(@NotNull byte[] baseinfo) {
        Intrinsics.checkNotNullParameter(baseinfo, "baseinfo");
        TdiManagerJniInterface.INSTANCE.au(this.handle, baseinfo);
    }

    public final void setSmcUin(int uin) {
        TdiManagerJniInterface.INSTANCE.av(this.handle, uin);
    }

    public final void smcFlushReportData() {
        TdiManagerJniInterface.INSTANCE.bc(this.handle);
    }

    public final void uninit() {
        TdiManagerJniInterface.INSTANCE.ad(this.handle);
    }

    public final void updateIlinkToken(@NotNull String ilinkToken) {
        Intrinsics.checkNotNullParameter(ilinkToken, "ilinkToken");
        TdiManagerJniInterface.INSTANCE.ae(this.handle, ilinkToken);
    }

    public final void writeKvData(@NotNull byte[] kvdata) {
        Intrinsics.checkNotNullParameter(kvdata, "kvdata");
        TdiManagerJniInterface.INSTANCE.at(this.handle, kvdata);
    }
}
