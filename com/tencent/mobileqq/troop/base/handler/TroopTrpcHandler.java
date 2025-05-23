package com.tencent.mobileqq.troop.base.handler;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.ProtoUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.base.handler.TroopTrpcHandler;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.trpcprotocol.TroopApiGateway$ForwardReq;
import tencent.trpcprotocol.TroopApiGateway$ForwardRsp;
import tencent.trpcprotocol.TroopApiGateway$KeyValue;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u00103\u001a\u00020.\u00a2\u0006\u0004\b4\u00105J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J0\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001c\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0003J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0014J\u0010\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001cH\u0014J\u0012\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u001fH\u0016JR\u0010*\u001a\u00020)2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010%2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00112\u0006\u0010(\u001a\u00020\u0019J&\u0010+\u001a\u00020)2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010,\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010-\u001a\u00020)H\u0016R\u0017\u00103\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/base/handler/TroopTrpcHandler;", "Lcom/tencent/mobileqq/troop/handler/TroopBaseHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "Lorg/json/JSONObject;", "H2", "", "isSuccess", "", "data", "Ltencent/trpcprotocol/TroopApiGateway$ForwardRsp;", "I2", "", "compressedData", "L2", "", "cmd", "M2", "ssoResult", "response", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "F2", "key", "Lcom/tencent/mobileqq/troop/api/f;", Constants.MMCCID, "getTag", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "getCommandList", "service", "method", "", "serializationType", "", "extra", "refer", "observer", "", "J2", "onReceive", "createToServiceMsg", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/common/app/AppInterface;", "e", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "f", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTrpcHandler extends TroopBaseHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AtomicInteger f294575h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, Object> f294576i;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/base/handler/TroopTrpcHandler$a;", "", "", "CMD_TROOP_TRPC_SSO_FORWARD", "Ljava/lang/String;", "DEFAULT_TRPC_SERVICE", "DEFAULT_TRPC_SERVICE_METHOD", "", "EC_NETWORK_ERROR_PACKAGE_EMPTY", "I", "EC_NETWORK_ERROR_PACKAGE_UNCOMPRESS_FAIL", "KEY_REQUEST_CMD", "KEY_REQUEST_TIME", "KEY_SEQ", "KEY_SEQ_NUM", "KEY_TRACE_INFO", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "observerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicInteger;", TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.base.handler.TroopTrpcHandler$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/base/handler/TroopTrpcHandler$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f294578d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.api.f f294579e;

        b(String str, com.tencent.mobileqq.troop.api.f fVar) {
            this.f294578d = str;
            this.f294579e = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) fVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i3, com.tencent.mobileqq.troop.api.f observer, TroopTrpcRemoteResponse remoteResponse) {
            Intrinsics.checkNotNullParameter(observer, "$observer");
            Intrinsics.checkNotNullParameter(remoteResponse, "$remoteResponse");
            if (i3 == 0) {
                observer.b(remoteResponse);
            } else {
                observer.a(remoteResponse);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(final int errorCode, @NotNull byte[] data, @NotNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            QLog.i("TroopTrpcHandler", 1, "#OIDBRequest result: errorCode " + errorCode + ", key=" + this.f294578d);
            final TroopTrpcRemoteResponse troopTrpcRemoteResponse = new TroopTrpcRemoteResponse(errorCode, "", data, 0, "");
            final com.tencent.mobileqq.troop.api.f fVar = this.f294579e;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.base.handler.a
                @Override // java.lang.Runnable
                public final void run() {
                    TroopTrpcHandler.b.c(errorCode, fVar, troopTrpcRemoteResponse);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new Companion(null);
        f294575h = new AtomicInteger(0);
        f294576i = new ConcurrentHashMap<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTrpcHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        } else {
            this.app = app;
        }
    }

    @NonNull
    private final TroopTrpcRemoteResponse F2(JSONObject ssoResult, TroopApiGateway$ForwardRsp response) {
        int i3;
        String str;
        int i16;
        int optInt = ssoResult.optInt("channel_code", -1);
        String optString = ssoResult.optString("channel_msg", "");
        if (response == null) {
            QLog.e("TroopTrpcHandler", 1, "[combineRemoteResponse] response is null");
            if (optInt == 0) {
                i16 = -1;
            } else {
                i16 = optInt;
            }
            return new TroopTrpcRemoteResponse(i16, "ForwardRsp is null", null, optInt, optString);
        }
        QLog.i("TroopTrpcHandler", 1, "[combineRemoteResponse] retcode = " + response.retcode.get() + ", msg = " + response.retmsg.get());
        int i17 = response.retcode.get();
        String str2 = response.retmsg.get();
        int optInt2 = ssoResult.optInt("unCompressSucceed", 0);
        String optString2 = ssoResult.optString("unCompressMessage", "ForwardRsp unCompressBody failed");
        if (i17 == 0 && optInt2 != 0) {
            i3 = -2;
            str = optString2;
        } else {
            i3 = i17;
            str = str2;
        }
        PBBytesField pBBytesField = response.body;
        Intrinsics.checkNotNullExpressionValue(pBBytesField, "response.body");
        TroopTrpcRemoteResponse troopTrpcRemoteResponse = new TroopTrpcRemoteResponse(i3, str, es2.a.a(pBBytesField), optInt, optString);
        troopTrpcRemoteResponse.unCompressSucceed = optInt2;
        troopTrpcRemoteResponse.compressType = ssoResult.optInt("compressType", 0);
        troopTrpcRemoteResponse.compressRatio = ssoResult.optString("compressRatio", "0.0000");
        troopTrpcRemoteResponse.unCompressTimeCost = ssoResult.optLong("unCompressTimeCost", 0L);
        return troopTrpcRemoteResponse;
    }

    private final com.tencent.mobileqq.troop.api.f G2(String key) {
        Object remove = TypeIntrinsics.asMutableMap(f294576i).remove(key);
        if (remove instanceof com.tencent.mobileqq.troop.api.f) {
            return (com.tencent.mobileqq.troop.api.f) remove;
        }
        QLog.i("TroopTrpcHandler", 1, "#getObserver: not find observer, obj=" + remove);
        return null;
    }

    private final JSONObject H2(ToServiceMsg req, FromServiceMsg res) {
        if (res == null) {
            return new JSONObject();
        }
        try {
            int businessFailCode = res.getBusinessFailCode();
            JSONObject jSONObject = new JSONObject();
            if (businessFailCode == 1000) {
                businessFailCode = 0;
            }
            jSONObject.put("channel_code", businessFailCode);
            jSONObject.put("channel_msg", res.getBusinessFailMsg());
            if (req != null) {
                jSONObject.put("compressType", req.getAttributes().get("compressType"));
                jSONObject.put("compressRatio", req.getAttributes().get("compressRatio"));
                jSONObject.put("unCompressSucceed", req.getAttributes().get("unCompressSucceed"));
                jSONObject.put("unCompressMessage", req.getAttributes().get("unCompressMessage"));
                jSONObject.put("unCompressTimeCost", req.getAttributes().get("unCompressTimeCost"));
            }
            return jSONObject;
        } catch (Throwable unused) {
            QLog.e("TroopTrpcHandler", 1, "getSSOResult fail");
            return new JSONObject();
        }
    }

    private final TroopApiGateway$ForwardRsp I2(boolean isSuccess, ToServiceMsg req, FromServiceMsg res, Object data) {
        int trpcRspFuncRetCode;
        String str;
        boolean z16 = false;
        if (!isSuccess) {
            StringBuilder sb5 = new StringBuilder("#parseResponse: isSuccess=false");
            if (res != null) {
                int businessFailCode = res.getBusinessFailCode();
                sb5.append(", businessFailCode=");
                sb5.append(businessFailCode);
            }
            QLog.e("TroopTrpcHandler", 1, sb5);
            return null;
        }
        if (res != null && (trpcRspFuncRetCode = res.getTrpcRspFuncRetCode()) != 0) {
            byte[] trpcRspErrorMsg = res.getTrpcRspErrorMsg();
            if (trpcRspErrorMsg != null) {
                if (trpcRspErrorMsg.length == 0) {
                    z16 = true;
                }
                if (!z16) {
                    str = new String(trpcRspErrorMsg, Charsets.UTF_8);
                    QLog.e("TroopTrpcHandler", 1, "#parseResponse: trpcErrCode=" + trpcRspFuncRetCode + ", trpcErrMsg=" + str);
                    return null;
                }
            }
            str = null;
            QLog.e("TroopTrpcHandler", 1, "#parseResponse: trpcErrCode=" + trpcRspFuncRetCode + ", trpcErrMsg=" + str);
            return null;
        }
        if (!(data instanceof byte[])) {
            QLog.e("TroopTrpcHandler", 1, "#parseResponse: data=" + data);
            return null;
        }
        try {
            TroopApiGateway$ForwardRsp mergeFrom = new TroopApiGateway$ForwardRsp().mergeFrom((byte[]) data);
            byte[] byteArray = mergeFrom.body.get().toByteArray();
            int i3 = mergeFrom.compress_type.get();
            if (i3 == 1 && byteArray != null) {
                mergeFrom.body.set(ByteStringMicro.copyFrom(L2(req, byteArray)));
            }
            if (req != null) {
                HashMap<String, Object> attributes = req.getAttributes();
                Intrinsics.checkNotNullExpressionValue(attributes, "req.attributes");
                attributes.put("compressType", Integer.valueOf(i3));
            }
            QLog.i("TroopTrpcHandler", 1, "#parseResponse: code=" + mergeFrom.retcode.get() + ", msg=" + mergeFrom.retmsg.get() + " compress_type=" + mergeFrom.compress_type.get());
            return mergeFrom;
        } catch (IOException e16) {
            QLog.e("TroopTrpcHandler", 1, e16, new Object[0]);
            return null;
        }
    }

    public static /* synthetic */ void K2(TroopTrpcHandler troopTrpcHandler, String str, String str2, byte[] bArr, int i3, Map map, String str3, com.tencent.mobileqq.troop.api.f fVar, int i16, Object obj) {
        Map map2;
        String str4;
        if ((i16 & 16) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        if ((i16 & 32) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        troopTrpcHandler.J2(str, str2, bArr, i3, map2, str4, fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final byte[] L2(ToServiceMsg req, byte[] compressedData) {
        byte[] bArr;
        HashMap<String, Object> attributes;
        HashMap<String, Object> attributes2;
        byte[] bArr2;
        HashMap<String, Object> attributes3;
        HashMap<String, Object> attributes4;
        boolean z16;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        HashMap<String, Object> attributes5;
        HashMap<String, Object> attributes6;
        long currentTimeMillis = System.currentTimeMillis();
        GZIPInputStream gZIPInputStream2 = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
                byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (IOException e16) {
                e = e16;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                byte[] bArr3 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(bArr2, "bos.toByteArray()");
                if (req != null && (attributes6 = req.getAttributes()) != null) {
                    attributes6.put("unCompressSucceed", 0);
                }
                if (req != null && (attributes5 = req.getAttributes()) != null) {
                    attributes5.put("unCompressMessage", "Success");
                }
                QLog.d("TroopTrpcHandler", 1, "unCompressBody succeed, data report succeed.");
                gZIPInputStream.close();
            } catch (IOException e17) {
                e = e17;
                gZIPInputStream2 = gZIPInputStream;
                bArr = new byte[0];
                if (req != null && (attributes4 = req.getAttributes()) != null) {
                    attributes4.put("unCompressSucceed", 1);
                }
                if (req != null && (attributes3 = req.getAttributes()) != null) {
                    attributes3.put("unCompressMessage", "unCompressBody IOException failed");
                }
                QLog.d("TroopTrpcHandler", 1, "unCompressBody IOException failed: ", e.toString(), ", data report failed.");
            } catch (Throwable th6) {
                th = th6;
                gZIPInputStream2 = gZIPInputStream;
                bArr = new byte[0];
                if (req != null && (attributes2 = req.getAttributes()) != null) {
                    attributes2.put("unCompressSucceed", 2);
                }
                if (req != null && (attributes = req.getAttributes()) != null) {
                    attributes.put("unCompressMessage", "unCompressBody finally failed");
                }
                QLog.d("TroopTrpcHandler", 1, "unCompressBody finally failed: ", th.toString(), ", data report failed.");
                if (gZIPInputStream2 != null) {
                }
                bArr2 = bArr;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (req != null) {
                }
                if (bArr2.length != 0) {
                }
                if (!z16) {
                }
                QLog.d("TroopTrpcHandler", 1, "unCompressBody cost = ", Long.valueOf(currentTimeMillis2));
                return bArr2;
            }
            long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
            if (req != null) {
                HashMap<String, Object> attributes7 = req.getAttributes();
                Intrinsics.checkNotNullExpressionValue(attributes7, "req.attributes");
                attributes7.put("unCompressTimeCost", Long.valueOf(currentTimeMillis22));
            }
            if (bArr2.length != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                float length = (((compressedData.length * 10000) / bArr2.length) * 1.0f) / 10000;
                DecimalFormat decimalFormat = new DecimalFormat("0.0000");
                if (req != null) {
                    HashMap<String, Object> attributes8 = req.getAttributes();
                    Intrinsics.checkNotNullExpressionValue(attributes8, "req.attributes");
                    attributes8.put("compressRatio", decimalFormat.format(length));
                }
            }
            QLog.d("TroopTrpcHandler", 1, "unCompressBody cost = ", Long.valueOf(currentTimeMillis22));
            return bArr2;
        } finally {
            if (0 != 0) {
                gZIPInputStream2.close();
            }
        }
    }

    private final ToServiceMsg M2(String cmd, byte[] data) {
        ToServiceMsg createToServiceMsg = createToServiceMsg(cmd);
        createToServiceMsg.putWupBuffer(data);
        createToServiceMsg.setTimeout(15000L);
        return createToServiceMsg;
    }

    public final void J2(@NotNull String service, @NotNull String method, @NotNull byte[] data, int serializationType, @Nullable Map<Object, ? extends Object> extra, @Nullable String refer, @NotNull com.tencent.mobileqq.troop.api.f observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, service, method, data, Integer.valueOf(serializationType), extra, refer, observer);
            return;
        }
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(observer, "observer");
        QLog.i("TroopTrpcHandler", 1, "#sendRequest: service=" + service + ", method=" + method + ", serializationType=" + serializationType);
        if (!AppNetConnInfo.isNetSupport()) {
            QLog.i("TroopTrpcHandler", 1, "#sendRequest: without network!! return null");
            observer.a(F2(new JSONObject(), null));
            return;
        }
        String str = service + "_" + method + "_" + f294575h.getAndIncrement();
        QLog.i("TroopTrpcHandler", 1, "#sendRequest: key=" + str);
        f294576i.put(str, observer);
        if (Intrinsics.areEqual(service, "trpc.qvideo.imsdk_forward_proxy.ImsdkForwardProxy") && Intrinsics.areEqual(method, "/trpc.qvideo.imsdk_forward_proxy.ImsdkForwardProxy/OpenSSOProxy")) {
            ProtoUtils.c(this.appRuntime, new b(str, observer), data, "OidbSvcTrpcTcp.0x1290_1", 4752, 1, new Bundle(), 12000L);
            return;
        }
        TroopApiGateway$ForwardReq troopApiGateway$ForwardReq = new TroopApiGateway$ForwardReq();
        troopApiGateway$ForwardReq.service.set(service);
        troopApiGateway$ForwardReq.method.set(method);
        troopApiGateway$ForwardReq.body.set(ByteStringMicro.copyFrom(data));
        troopApiGateway$ForwardReq.serialization_type.set(serializationType);
        if (!TextUtils.isEmpty(refer)) {
            troopApiGateway$ForwardReq.refer.set(refer);
        }
        String str2 = "";
        if (extra != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : extra.keySet()) {
                if (Intrinsics.areEqual(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, obj)) {
                    str2 = String.valueOf(extra.get(obj));
                } else {
                    TroopApiGateway$KeyValue troopApiGateway$KeyValue = new TroopApiGateway$KeyValue();
                    troopApiGateway$KeyValue.key.set(obj.toString());
                    troopApiGateway$KeyValue.value.set(String.valueOf(extra.get(obj)));
                    arrayList.add(troopApiGateway$KeyValue);
                }
            }
            troopApiGateway$ForwardReq.exts.set(arrayList);
        }
        ToServiceMsg M2 = M2("trpc.iqun.api_gateway.ApiGateway.SsoForward", troopApiGateway$ForwardReq.toByteArray());
        M2.setTraceInfo(str2);
        HashMap<String, Object> attributes = M2.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "request.attributes");
        attributes.put("trpcSeq", str);
        HashMap<String, Object> attributes2 = M2.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes2, "request.attributes");
        attributes2.put("trpcSeqNum", f294575h);
        HashMap<String, Object> attributes3 = M2.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes3, "request.attributes");
        attributes3.put("requestTime", Long.valueOf(System.currentTimeMillis()));
        HashMap<String, Object> attributes4 = M2.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes4, "request.attributes");
        attributes4.put("requestCmd", service + method);
        sendPbReq(M2);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler, com.tencent.mobileqq.app.OidbWrapper
    @NotNull
    public ToServiceMsg createToServiceMsg(@Nullable String cmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 8, (Object) this, (Object) cmd);
        }
        return new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), cmd);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @Nullable
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.iqun.api_gateway.ApiGateway.SsoForward");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    @NotNull
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopTrpcHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return com.tencent.mobileqq.troop.base.handler.b.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onDestroy();
            f294576i.clear();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        Long l3;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, req, res, data);
            return;
        }
        if (res != null && req != null) {
            AtomicInteger atomicInteger = (AtomicInteger) req.getAttributes().get("trpcSeqNum");
            String str2 = (String) req.getAttributes().get("trpcSeq");
            QLog.i("TroopTrpcHandler", 1, "#onReceive: requestSeq=" + atomicInteger + " key=" + str2);
            boolean isSuccess = res.isSuccess();
            TroopApiGateway$ForwardRsp I2 = I2(isSuccess, req, res, data);
            if (I2 == null) {
                isSuccess = false;
            }
            TroopTrpcRemoteResponse F2 = F2(H2(req, res), I2);
            com.tencent.mobileqq.troop.api.f G2 = G2(str2);
            if (G2 == null) {
                QLog.e("TroopTrpcHandler", 1, "[sendPackage] observer is null");
                return;
            }
            if (isSuccess && F2.code == 0) {
                G2.b(F2);
            } else {
                G2.a(F2);
            }
            Object obj = req.getAttributes().get("requestTime");
            String str3 = null;
            if (obj instanceof Long) {
                l3 = (Long) obj;
            } else {
                l3 = null;
            }
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j3;
            Object obj2 = req.getAttributes().get("requestCmd");
            if (obj2 instanceof String) {
                str3 = (String) obj2;
            }
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            k kVar = k.f294613a;
            int i3 = F2.code;
            String str4 = F2.f293941msg;
            Intrinsics.checkNotNullExpressionValue(str4, "remoteResponse.msg");
            kVar.b(str, i3, str4, currentTimeMillis);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTrpcHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
