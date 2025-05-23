package com.tencent.rdelivery.net;

import android.util.Base64;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.ServerUrlGenerator;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.net.i;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ.\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002J&\u0010\u0010\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002J&\u0010\u0011\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0012\u001a\u00020\u0002R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u00106\u001a\b\u0012\u0004\u0012\u00020 0/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010<\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00108\u001a\u0004\b0\u00109\"\u0004\b:\u0010;R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b=\u0010\u0016\"\u0004\b>\u0010\u0018R$\u0010A\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010J\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010F\u001a\u0004\b!\u0010G\"\u0004\bH\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/rdelivery/net/a;", "", "", ImageTaskConst.ERROR_TYPE, "errMsg", "Lorg/json/JSONObject;", "b", com.heytap.mcssdk.a.a.f36102l, "extraTag", "Lcom/tencent/rdelivery/util/c;", "logger", "c", "", "enableEncrypt", "doPrintLog", "e", "i", tl.h.F, "g", "a", "Ljava/lang/String;", "getSystemId", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "systemId", "getAppId", "k", "appId", "getSign", "o", "sign", "", "d", "Ljava/lang/Long;", "getTimestamp", "()Ljava/lang/Long;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Long;)V", "timestamp", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "getPullTarget", "()Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", DomainData.DOMAIN_NAME, "(Lcom/tencent/rdelivery/net/BaseProto$PullTarget;)V", "pullTarget", "", "f", "Ljava/util/List;", "j", "()Ljava/util/List;", "setTaskIdList", "(Ljava/util/List;)V", "taskIdList", "Liz3/f;", "Liz3/f;", "()Liz3/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Liz3/f;)V", "listener", "getUserId", "r", "userId", "Ljava/lang/Boolean;", "isDebugPackage", "()Ljava/lang/Boolean;", "l", "(Ljava/lang/Boolean;)V", "Ljava/security/Key;", "Ljava/security/Key;", "()Ljava/security/Key;", "setAesKey", "(Ljava/security/Key;)V", "aesKey", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String sign;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long timestamp;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private iz3.f listener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isDebugPackage;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Key aesKey;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String systemId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseProto$PullTarget pullTarget = BaseProto$PullTarget.PROJECT;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> taskIdList = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String userId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J(\u0010\u0018\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ0\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00040\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/rdelivery/net/a$a;", "", "Lcom/tencent/rdelivery/net/a;", Const.BUNDLE_KEY_REQUEST, "", ImageTaskConst.ERROR_TYPE, "errMsg", "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "", "i", "Lorg/json/JSONObject;", "response", "Ljava/security/Key;", "aesKey", "d", "", "f", "", "taskIds", "Liz3/f;", "listener", "c", "g", "e", "result", "Lcom/tencent/rdelivery/util/c;", "logger", "Lkotlin/Pair;", "", tl.h.F, "ERR_DECODE", "Ljava/lang/String;", "ERR_RET", "TAG", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.net.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/rdelivery/net/a$a$a", "Lcom/tencent/raft/standard/net/IRNetwork$INetworkResult;", "", "result", "", "onSuccess", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "onFail", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.rdelivery.net.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9725a implements IRNetwork.INetworkResult {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RDeliverySetting f364313a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f364314b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ IRNetwork f364315c;

            C9725a(RDeliverySetting rDeliverySetting, a aVar, IRNetwork iRNetwork) {
                this.f364313a = rDeliverySetting;
                this.f364314b = aVar;
                this.f364315c = iRNetwork;
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onFail(@NotNull IRNetwork.ResultInfo result) {
                String str;
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364313a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetRequest", "doRequest onFail", false, 4, null);
                }
                iz3.f listener = this.f364314b.getListener();
                if (listener != null) {
                    String errorMessage = result.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = "";
                    }
                    listener.onFail(errorMessage);
                }
                Companion companion = a.INSTANCE;
                a aVar = this.f364314b;
                String errorMessage2 = result.getErrorMessage();
                if (errorMessage2 == null) {
                    str = "";
                } else {
                    str = errorMessage2;
                }
                companion.i(aVar, "60", str, this.f364315c, this.f364313a);
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onSuccess(@NotNull Object result) {
                JSONObject jSONObject;
                Object obj;
                String str;
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364313a.getLogger();
                if (logger != null) {
                    logger.a(com.tencent.rdelivery.util.d.a("RDeliveryGetRequest", this.f364313a.getRdInstanceIdentifier()), "doRequest onSuccess = " + result, this.f364313a.getEnableDetailLog());
                }
                if (this.f364313a.getEnableEncrypt()) {
                    try {
                        if (!(result instanceof String)) {
                            obj = null;
                        } else {
                            obj = result;
                        }
                        String str2 = (String) obj;
                        if (str2 == null) {
                            str2 = "";
                        }
                        jSONObject = a.INSTANCE.d(new JSONObject(str2), this.f364314b.getAesKey(), this.f364313a);
                    } catch (Exception e16) {
                        com.tencent.rdelivery.util.c logger2 = this.f364313a.getLogger();
                        if (logger2 != null) {
                            logger2.d(com.tencent.rdelivery.util.d.a("RDeliveryGetRequest", this.f364313a.getRdInstanceIdentifier()), "handleSuccess fail to decrypt response", e16);
                        }
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        iz3.f listener = this.f364314b.getListener();
                        if (listener != null) {
                            listener.onFail("decrypt_fail");
                        }
                        a.INSTANCE.i(this.f364314b, "70", "decrypt_fail", this.f364315c, this.f364313a);
                        return;
                    }
                } else {
                    jSONObject = null;
                }
                if (jSONObject == null || (str = jSONObject.toString()) == null) {
                    if (!(result instanceof String)) {
                        result = null;
                    }
                    str = (String) result;
                }
                Companion companion = a.INSTANCE;
                Pair<Boolean, String> h16 = companion.h(str, this.f364314b.getListener(), this.f364313a.getLogger());
                if (!h16.getFirst().booleanValue()) {
                    companion.i(this.f364314b, "80", h16.getSecond(), this.f364315c, this.f364313a);
                }
            }
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final JSONObject d(JSONObject response, Key aesKey, RDeliverySetting setting) {
            int optInt = response.optInt("ret_code", -1);
            String optString = response.optString("ret_msg");
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                logger.a(com.tencent.rdelivery.util.d.a("RDeliveryGetRequest", setting.getRdInstanceIdentifier()), "decryptRespData code = " + optInt + ", msg = " + optString, setting.getEnableDetailLog());
            }
            if (optInt == BaseProto$Code.SUCCESS.getValue() && aesKey != null) {
                byte[] decode = Base64.decode(response.optString("cipher_text"), 2);
                Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(cipherText, Base64.NO_WRAP)");
                byte[] a16 = com.tencent.rdelivery.util.b.a(decode, aesKey.getEncoded());
                Intrinsics.checkExpressionValueIsNotNull(a16, "CryptoUtil.aesDecrypt(de\u2026dRspInfo, aesKey.encoded)");
                return new JSONObject(new String(a16, Charsets.UTF_8));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i(a request, String errType, String errMsg, IRNetwork netInterface, RDeliverySetting setting) {
            String str;
            if (setting.getEnableEncrypt()) {
                str = "get_v2";
            } else {
                str = "get_v1";
            }
            JSONObject b16 = request.b(errType, errMsg);
            i.Companion companion = i.INSTANCE;
            companion.c(companion.a(b16, str), netInterface, setting);
        }

        @NotNull
        public final a c(@NotNull List<Long> taskIds, @NotNull RDeliverySetting setting, @Nullable iz3.f listener) {
            Intrinsics.checkParameterIsNotNull(taskIds, "taskIds");
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDeliveryGetRequest", setting.getRdInstanceIdentifier()), "createGetRequest ", false, 4, null);
            }
            a aVar = new a();
            aVar.p(setting.getSystemId());
            aVar.k(setting.getAppId());
            aVar.n(setting.getPullTarget());
            aVar.q(Long.valueOf(a.INSTANCE.f() / 1000));
            aVar.o(aVar.c(setting.getCom.heytap.mcssdk.a.a.l java.lang.String(), setting.getRdInstanceIdentifier(), setting.getLogger()));
            aVar.j().addAll(taskIds);
            aVar.r(setting.getUserId());
            aVar.l(setting.getIsDebugPackage());
            aVar.m(listener);
            return aVar;
        }

        public final void e(@NotNull a request, @NotNull IRNetwork netInterface, @NotNull RDeliverySetting setting) {
            Object m476constructorimpl;
            Map<String, String> mapOf;
            Map<String, String> emptyMap;
            com.tencent.rdelivery.util.c logger;
            Intrinsics.checkParameterIsNotNull(request, "request");
            Intrinsics.checkParameterIsNotNull(netInterface, "netInterface");
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            String str = "";
            try {
                Result.Companion companion = Result.INSTANCE;
                str = request.e(setting.getEnableEncrypt(), setting.getLogger(), setting.getEnableDetailLog(), setting.getRdInstanceIdentifier());
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            String str2 = str;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null && (logger = setting.getLogger()) != null) {
                logger.d(com.tencent.rdelivery.util.d.a("RDeliveryGetRequest", setting.getRdInstanceIdentifier()), "getFinalRequestString err", m479exceptionOrNullimpl);
            }
            com.tencent.rdelivery.util.c logger2 = setting.getLogger();
            if (logger2 != null) {
                com.tencent.rdelivery.util.c.b(logger2, "RDeliveryGetRequest", "doRequest payload = " + str2, false, 4, null);
            }
            IRNetwork.HttpMethod httpMethod = IRNetwork.HttpMethod.POST;
            String g16 = g(setting);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("content-type", "application/json"));
            emptyMap = MapsKt__MapsKt.emptyMap();
            netInterface.requestWithMethod(httpMethod, g16, mapOf, emptyMap, str2, new C9725a(setting, request, netInterface));
        }

        public final long f() {
            return System.currentTimeMillis();
        }

        @NotNull
        public final String g(@NotNull RDeliverySetting setting) {
            ServerUrlGenerator.ProtocolPathInUrl protocolPathInUrl;
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            if (setting.getEnableEncrypt()) {
                protocolPathInUrl = ServerUrlGenerator.ProtocolPathInUrl.GET_CONFIG_SWITCH_DATA_BY_TASK_ID_ENCRYPT;
            } else {
                protocolPathInUrl = ServerUrlGenerator.ProtocolPathInUrl.GET_CONFIG_SWITCH_DATA_BY_TASK_ID;
            }
            String a16 = ServerUrlGenerator.f364301a.a(setting, protocolPathInUrl);
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetRequest", "getServerUrl, result = " + a16, false, 4, null);
            }
            return a16;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Pair<Boolean, String> h(@Nullable String result, @Nullable iz3.f listener, @Nullable com.tencent.rdelivery.util.c logger) {
            JSONObject jSONObject;
            String str;
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetRequest", "handleSuccess result = " + result, false, 4, null);
            }
            int i3 = -1;
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject(result);
                try {
                    i3 = jSONObject.optInt("code", -1);
                } catch (Exception e16) {
                    e = e16;
                    if (logger != null) {
                        logger.d("RDeliveryGetRequest", "handleSuccess fail to decode code", e);
                    }
                    boolean z16 = false;
                    if (i3 != BaseProto$Code.SUCCESS.getValue()) {
                    }
                    return new Pair<>(Boolean.valueOf(z16), str);
                }
            } catch (Exception e17) {
                e = e17;
                jSONObject = null;
            }
            boolean z162 = false;
            if (i3 != BaseProto$Code.SUCCESS.getValue()) {
                if (jSONObject != null) {
                    try {
                        jSONObject2 = jSONObject.optJSONObject("taskIDConfig");
                    } catch (Exception e18) {
                        String message = e18.getMessage();
                        if (message == null) {
                            message = "get_req_decode_error";
                        }
                        if (listener != null) {
                            listener.onFail(message);
                        }
                        if (logger != null) {
                            logger.d("RDeliveryGetRequest", "handleSuccess decode Exception", e18);
                        }
                        str = message;
                    }
                }
                JSONObject jSONObject3 = jSONObject2;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (jSONObject3 != null) {
                    Iterator keys = jSONObject3.keys();
                    Intrinsics.checkExpressionValueIsNotNull(keys, "it.keys()");
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        Object obj = jSONObject3.get(str2);
                        if (obj != null) {
                            linkedHashMap.put(Long.valueOf(Long.parseLong(str2)), g.Companion.b(g.INSTANCE, (JSONObject) obj, null, logger, false, 8, null));
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    }
                }
                if (listener != null) {
                    listener.onSuccess(linkedHashMap);
                }
                z162 = true;
                str = "";
            } else {
                if (jSONObject == null || (str = jSONObject.optString("msg")) == null) {
                    str = "get_req_ret_error";
                }
                if (listener != null) {
                    listener.onFail(str);
                }
            }
            return new Pair<>(Boolean.valueOf(z162), str);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject b(String errType, String errMsg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("err_type", errType);
        jSONObject.putOpt("err_msg", errMsg);
        jSONObject.putOpt("platform", BaseProto$Platform.ANDROID.name());
        jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_SDK_VER, "1.3.36-RC01");
        jSONObject.putOpt("sys_id", this.systemId);
        jSONObject.putOpt("app_id", this.appId);
        return jSONObject;
    }

    @NotNull
    public final String c(@NotNull String appKey, @Nullable String extraTag, @Nullable com.tencent.rdelivery.util.c logger) {
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        String str = this.systemId + "$" + this.appId + "$" + this.timestamp + "$" + ("rdelivery" + appKey);
        Intrinsics.checkExpressionValueIsNotNull(str, "StringBuilder().append(s\u2026              .toString()");
        String a16 = com.tencent.rdelivery.util.e.f364656a.a(str);
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDeliveryGetRequest", extraTag), "generateSign " + a16, false, 4, null);
        }
        return a16;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Key getAesKey() {
        return this.aesKey;
    }

    @NotNull
    public final String e(boolean enableEncrypt, @Nullable com.tencent.rdelivery.util.c logger, boolean doPrintLog, @Nullable String extraTag) {
        if (enableEncrypt) {
            return i(logger, doPrintLog, extraTag);
        }
        return g();
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final iz3.f getListener() {
        return this.listener;
    }

    @NotNull
    public final String g() {
        Integer num;
        JSONArray jSONArray = new JSONArray();
        Iterator<Long> it = this.taskIdList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().longValue());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("systemID", this.systemId);
        jSONObject.putOpt("appID", this.appId);
        jSONObject.putOpt("sign", this.sign);
        jSONObject.putOpt("timestamp", this.timestamp);
        BaseProto$PullTarget baseProto$PullTarget = this.pullTarget;
        if (baseProto$PullTarget != null) {
            num = Integer.valueOf(baseProto$PullTarget.getValue());
        } else {
            num = null;
        }
        jSONObject.putOpt("target", num);
        jSONObject.putOpt("taskIDs", jSONArray);
        jSONObject.putOpt("guid", this.userId);
        jSONObject.putOpt("isDebugPackage", this.isDebugPackage);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "request.toString()");
        return jSONObject2;
    }

    @NotNull
    public final JSONObject h(@Nullable com.tencent.rdelivery.util.c logger, boolean doPrintLog, @Nullable String extraTag) {
        String g16 = g();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDeliveryGetRequest", extraTag), "origin reqStr = " + g16, doPrintLog);
        }
        JSONObject jSONObject = new JSONObject();
        Key c16 = com.tencent.rdelivery.util.b.c();
        Intrinsics.checkExpressionValueIsNotNull(c16, "CryptoUtil.genAesRandomKey()");
        this.aesKey = c16;
        Charset charset = Charsets.UTF_8;
        if (g16 != null) {
            byte[] bytes = g16.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] b16 = com.tencent.rdelivery.util.b.b(bytes, c16);
            Intrinsics.checkExpressionValueIsNotNull(b16, "CryptoUtil.aesEncrypt(re\u2026tr.toByteArray(), aesKey)");
            byte[] encode = Base64.encode(b16, 2);
            Intrinsics.checkExpressionValueIsNotNull(encode, "Base64.encode(aesEncryptReq, Base64.NO_WRAP)");
            String str = new String(encode, charset);
            byte[] encode2 = Base64.encode(com.tencent.rdelivery.util.b.e(c16.getEncoded(), com.tencent.rdelivery.util.b.d("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/rT6ULqXC32dgz4t/Vv4WS9pT\nks5Z2fPmbTHIXEVeiOEnjOpPBHOi1AUz+Ykqjk11ZyjidUwDyIaC/VtaC5Z7Bt/W\n+CFluDer7LiiDa6j77if5dbcvWUrJbgvhKqaEhWnMDXT1pAG2KxL/pNFAYguSLpO\nh9pK97G8umUMkkwWkwIDAQAB")), 2);
            Intrinsics.checkExpressionValueIsNotNull(encode2, "Base64.encode(rsaByteArray, Base64.NO_WRAP)");
            String str2 = new String(encode2, charset);
            jSONObject.put("cipher_text", str);
            jSONObject.put("public_key_version", 1);
            jSONObject.put("pull_key", str2);
            return jSONObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public final String i(@Nullable com.tencent.rdelivery.util.c logger, boolean doPrintLog, @Nullable String extraTag) {
        String jSONObject = h(logger, doPrintLog, extraTag).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "v2Request.toString()");
        return jSONObject;
    }

    @NotNull
    public final List<Long> j() {
        return this.taskIdList;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appId = str;
    }

    public final void l(@Nullable Boolean bool) {
        this.isDebugPackage = bool;
    }

    public final void m(@Nullable iz3.f fVar) {
        this.listener = fVar;
    }

    public final void n(@Nullable BaseProto$PullTarget baseProto$PullTarget) {
        this.pullTarget = baseProto$PullTarget;
    }

    public final void o(@Nullable String str) {
        this.sign = str;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.systemId = str;
    }

    public final void q(@Nullable Long l3) {
        this.timestamp = l3;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.userId = str;
    }
}
