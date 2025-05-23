package com.tencent.rdelivery.net;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.ads.data.AdParam;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.ServerUrlGenerator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u0004\u0010\"\"\u0004\b\u0018\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/rdelivery/net/b;", "", "", "b", "a", "Ljava/lang/String;", "getSystemId", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "systemId", "getAppId", "c", "appId", "Lcom/tencent/rdelivery/net/BaseProto$Platform;", "Lcom/tencent/rdelivery/net/BaseProto$Platform;", "getPlatform", "()Lcom/tencent/rdelivery/net/BaseProto$Platform;", "f", "(Lcom/tencent/rdelivery/net/BaseProto$Platform;)V", "platform", "d", "getAppVersion", "appVersion", "e", "getQimei", "g", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "getUniqueId", "i", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "Liz3/g;", "listener", "Liz3/g;", "()Liz3/g;", "(Liz3/g;)V", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    private static final String f364316g;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String systemId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BaseProto$Platform platform = BaseProto$Platform.ANDROID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appVersion;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String qimei;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String uniqueId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u001b\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019R\u0014\u0010\u001c\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/rdelivery/net/b$a;", "", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "", "c", "Landroid/content/Context;", "context", "", "nextReqIntervalLimit", "", "g", "", "f", AdParam.APPVER, "Liz3/g;", "listener", "Lcom/tencent/rdelivery/net/b;", "a", "d", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "b", "result", "Lcom/tencent/rdelivery/util/c;", "logger", "e", "NEXT_REQ_INTERVAL_LIMIT_DEFAULT", "I", "SERVER_URL_GET", "Ljava/lang/String;", "SERVER_URL_GET_PRE_RELEASE", "SERVER_URL_GET_RELEASE", "SERVER_URL_GET_TEST", "TAG", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.net.b$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/rdelivery/net/b$a$a", "Lcom/tencent/raft/standard/net/IRNetwork$INetworkResult;", "", "result", "", "onSuccess", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "onFail", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.rdelivery.net.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9726a implements IRNetwork.INetworkResult {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RDeliverySetting f364324a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f364325b;

            C9726a(RDeliverySetting rDeliverySetting, b bVar) {
                this.f364324a = rDeliverySetting;
                this.f364325b = bVar;
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onFail(@NotNull IRNetwork.ResultInfo result) {
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364324a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetSDKSpecificConfigRequest", "doRequest onFail", false, 4, null);
                }
                this.f364325b.a();
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onSuccess(@NotNull Object result) {
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364324a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetSDKSpecificConfigRequest", "doRequest onSuccess = " + result, false, 4, null);
                }
                Companion companion = b.INSTANCE;
                if (!(result instanceof String)) {
                    result = null;
                }
                this.f364325b.a();
                companion.e((String) result, null, this.f364324a.getLogger());
            }
        }

        Companion() {
        }

        @NotNull
        public final b a(@Nullable String appVer, @NotNull RDeliverySetting setting, @Nullable iz3.g listener) {
            BaseProto$Platform baseProto$Platform;
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDeliveryGetSDKSpecificConfigRequest", setting.getRdInstanceIdentifier()), "createRequest ", false, 4, null);
            }
            b bVar = new b();
            bVar.h(setting.getSystemId());
            bVar.c(setting.getAppId());
            if (setting.getIsAPad()) {
                baseProto$Platform = BaseProto$Platform.APAD;
            } else {
                baseProto$Platform = BaseProto$Platform.ANDROID;
            }
            bVar.f(baseProto$Platform);
            bVar.d(appVer);
            bVar.g(setting.getCom.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder.RequestParamKey.QIMEI36 java.lang.String());
            bVar.i(setting.getUuid());
            bVar.e(listener);
            return bVar;
        }

        public final void b(@NotNull b request, @NotNull IRNetwork netInterface, @NotNull RDeliverySetting setting) {
            Map<String, String> mapOf;
            Map<String, String> emptyMap;
            Intrinsics.checkParameterIsNotNull(request, "request");
            Intrinsics.checkParameterIsNotNull(netInterface, "netInterface");
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            String b16 = request.b();
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetSDKSpecificConfigRequest", "doRequest payload = " + b16, false, 4, null);
            }
            IRNetwork.HttpMethod httpMethod = IRNetwork.HttpMethod.POST;
            String d16 = d(setting);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("content-type", "application/json"));
            emptyMap = MapsKt__MapsKt.emptyMap();
            netInterface.requestWithMethod(httpMethod, d16, mapOf, emptyMap, b16, new C9726a(setting, request));
        }

        @NotNull
        public final String c(@NotNull RDeliverySetting setting) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            return "LastReqTSKey_" + setting.getAppId() + "_" + setting.getSystemId();
        }

        @NotNull
        public final String d(@NotNull RDeliverySetting setting) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            String a16 = ServerUrlGenerator.f364301a.a(setting, ServerUrlGenerator.ProtocolPathInUrl.GET_SDK_SPECIFIC_CONFIG);
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetSDKSpecificConfigRequest", "getServerUrl, result = " + a16, false, 4, null);
            }
            return a16;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(@Nullable String result, @Nullable iz3.g listener, @Nullable com.tencent.rdelivery.util.c logger) {
            JSONObject jSONObject;
            String optString;
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetSDKSpecificConfigRequest", "handleSuccess result = " + result, false, 4, null);
            }
            int i3 = -1;
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject(result);
            } catch (Exception e16) {
                e = e16;
                jSONObject = null;
            }
            try {
                i3 = jSONObject.optInt("ret_code", -1);
            } catch (Exception e17) {
                e = e17;
                if (logger != null) {
                    logger.d("RDeliveryGetSDKSpecificConfigRequest", "handleSuccess fail to decode code", e);
                }
                String str = "";
                if (i3 != BaseProto$Code.SUCCESS.getValue()) {
                }
            }
            String str2 = "";
            if (i3 != BaseProto$Code.SUCCESS.getValue()) {
                if (jSONObject != null) {
                    try {
                        jSONObject2 = jSONObject.optJSONObject("data");
                    } catch (Exception e18) {
                        if (listener != null) {
                            String message = e18.getMessage();
                            if (message != null) {
                                str2 = message;
                            }
                            listener.onFail(str2);
                        }
                        if (logger != null) {
                            logger.d("RDeliveryGetSDKSpecificConfigRequest", "handleSuccess decode Exception", e18);
                            return;
                        }
                        return;
                    }
                }
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, "RDeliveryGetSDKSpecificConfigRequest", "handleSuccess , sdkConfigData = " + jSONObject2, false, 4, null);
                }
                if (listener != null) {
                    listener.onSuccess(jSONObject2);
                    return;
                }
                return;
            }
            if (jSONObject != null && (optString = jSONObject.optString("ret_msg")) != null) {
                str2 = optString;
            }
            if (listener != null) {
                listener.onFail(str2);
            }
        }

        public final void f(@Nullable Context context, @NotNull RDeliverySetting setting) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            if (context != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                IRStorage commonStorage = setting.getCommonStorage();
                if (commonStorage != null) {
                    commonStorage.putLong(c(setting), elapsedRealtime);
                }
                com.tencent.rdelivery.util.c logger = setting.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDeliveryGetSDKSpecificConfigRequest", setting.getRdInstanceIdentifier()), "recordReqTimeStamp, lastReqTS = " + elapsedRealtime, false, 4, null);
                }
            }
        }

        public final boolean g(@Nullable Context context, int nextReqIntervalLimit, @NotNull RDeliverySetting setting) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            boolean z16 = false;
            if (context != null) {
                IRStorage commonStorage = setting.getCommonStorage();
                long j3 = 0;
                if (commonStorage != null) {
                    j3 = commonStorage.getLong(c(setting), 0L);
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - j3 < nextReqIntervalLimit * 1000) {
                    z16 = true;
                }
                com.tencent.rdelivery.util.c logger = setting.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDeliveryGetSDKSpecificConfigRequest", setting.getRdInstanceIdentifier()), "shouldLimitReq ,result = " + z16 + ", curTS = " + elapsedRealtime + ", lastReqTS = " + j3 + ", nextReqIntervalLimit = " + nextReqIntervalLimit, false, 4, null);
                }
            }
            return z16;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String str = "https://rdelivery.qq.com/v1/sdkconfig/get";
        if (BaseProto$ServerType.RELEASE.getValue() != 0) {
            if (BaseProto$ServerType.PRE_RELEASE.getValue() == 0) {
                str = "https://p.rdelivery.qq.com/v1/sdkconfig/get";
            } else if (BaseProto$ServerType.TEST.getValue() == 0) {
                str = "https://t.rdelivery.qq.com/v1/sdkconfig/get";
            }
        }
        f364316g = str;
    }

    @Nullable
    public final iz3.g a() {
        return null;
    }

    @NotNull
    public final String b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("system_id", this.systemId);
        jSONObject.putOpt("app_id", this.appId);
        jSONObject.putOpt("platform", Integer.valueOf(this.platform.getValue()));
        jSONObject.putOpt("app_version", this.appVersion);
        jSONObject.putOpt(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, this.qimei);
        jSONObject.putOpt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, this.uniqueId);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "request.toString()");
        return jSONObject2;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appId = str;
    }

    public final void d(@Nullable String str) {
        this.appVersion = str;
    }

    public final void f(@NotNull BaseProto$Platform baseProto$Platform) {
        Intrinsics.checkParameterIsNotNull(baseProto$Platform, "<set-?>");
        this.platform = baseProto$Platform;
    }

    public final void g(@Nullable String str) {
        this.qimei = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.systemId = str;
    }

    public final void i(@Nullable String str) {
        this.uniqueId = str;
    }

    public final void e(@Nullable iz3.g gVar) {
    }
}
