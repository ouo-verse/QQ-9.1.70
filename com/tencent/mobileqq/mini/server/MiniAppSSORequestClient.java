package com.tencent.mobileqq.mini.server;

import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IAppRuntime;
import mqq.app.api.SSORequest;
import mqq.app.api.SSOResponse;
import mqq.app.api.SSOResultCallback;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/mini/server/MiniAppSSORequestClient;", "", "()V", "TAG", "", "sIndexCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "decodeResponse", "Lcom/tencent/mobileqq/mini/server/MiniAppSSOResponse;", "cmd", "rawRsp", "Lmqq/app/api/SSOResponse;", "encodeRequest", "", "requestBody", "sendReq", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/mini/server/BaseMiniAppSSORequest;", "callback", "Lcom/tencent/mobileqq/mini/server/MiniAppSSOReqCallback;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppSSORequestClient {
    private static final String TAG = "MiniAppSSORequestClient";
    public static final MiniAppSSORequestClient INSTANCE = new MiniAppSSORequestClient();
    private static final AtomicLong sIndexCounter = new AtomicLong(0);

    MiniAppSSORequestClient() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MiniAppSSOResponse decodeResponse(String cmd, SSOResponse rawRsp) {
        PROTOCAL.StQWebRsp stQWebRsp;
        byte[] a16 = fh.a(rawRsp.body);
        if (a16 != null) {
            if (!(a16.length == 0)) {
                try {
                    stQWebRsp = new PROTOCAL.StQWebRsp();
                    stQWebRsp.mergeFrom(fh.a(rawRsp.body));
                } catch (InvalidProtocolBufferMicroException e16) {
                    QMLog.e(TAG, "decodeResponse: parse rsp failed:", e16);
                }
                if (stQWebRsp == null) {
                    int i3 = (int) stQWebRsp.retCode.get();
                    String stringUtf8 = stQWebRsp.errMsg.get().toStringUtf8();
                    Intrinsics.checkNotNullExpressionValue(stringUtf8, "qWebRsp.errMsg.get().toStringUtf8()");
                    return new MiniAppSSOResponse(i3, stringUtf8, stQWebRsp.busiBuff.get().toByteArray());
                }
                QMLog.e(TAG, "decodeResponse: build rsp fail, cmd = " + cmd + ", dataSize = " + (a16 != null ? Integer.valueOf(a16.length) : null));
                return null;
            }
        }
        stQWebRsp = null;
        if (stQWebRsp == null) {
        }
    }

    private final byte[] encodeRequest(byte[] requestBody) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        stQWebReq.Seq.set(sIndexCounter.incrementAndGet());
        stQWebReq.qua.set(QUA.getQUA3());
        stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(requestBody));
        byte[] b16 = fh.b(stQWebReq.toByteArray());
        Intrinsics.checkNotNullExpressionValue(b16, "makeWupBuff(webReq.toByteArray())");
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendReq$lambda$0(BaseMiniAppSSORequest request, MiniAppSSOReqCallback callback, SSOResponse it) {
        MiniAppSSOResponse miniAppSSOResponse;
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Boolean bool = it.isSuc;
        Intrinsics.checkNotNullExpressionValue(bool, "it.isSuc");
        if (bool.booleanValue()) {
            MiniAppSSORequestClient miniAppSSORequestClient = INSTANCE;
            String cmd = request.getCmd();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            miniAppSSOResponse = miniAppSSORequestClient.decodeResponse(cmd, it);
        } else {
            QMLog.e(TAG, "sendReq: fail, req=" + request.getCmd() + " retCode=" + it.errCode);
            miniAppSSOResponse = null;
        }
        callback.onResponse(miniAppSSOResponse);
    }

    public final void sendReq(final BaseMiniAppSSORequest request, final MiniAppSSOReqCallback callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SSORequest sSORequest = new SSORequest();
        sSORequest.cmd = request.getCmd();
        sSORequest.body = encodeRequest(request.getRequestData());
        ((IAppRuntime) QRoute.api(IAppRuntime.class)).sendReq(sSORequest, new SSOResultCallback() { // from class: com.tencent.mobileqq.mini.server.a
            @Override // mqq.app.api.SSOResultCallback
            public final void callback(SSOResponse sSOResponse) {
                MiniAppSSORequestClient.sendReq$lambda$0(BaseMiniAppSSORequest.this, callback, sSOResponse);
            }
        });
    }
}
