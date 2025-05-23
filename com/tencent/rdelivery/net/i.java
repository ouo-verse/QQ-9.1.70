package com.tencent.rdelivery.net;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.raft.standard.net.IRNetwork;
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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00132\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/rdelivery/net/i;", "", "", "a", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "getJsonParams", "()Lorg/json/JSONObject;", "b", "(Lorg/json/JSONObject;)V", "jsonParams", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "type", "<init>", "()V", "d", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class i {

    /* renamed from: c */
    private static final String f364360c;

    /* renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    @Nullable
    private JSONObject jsonParams;

    /* renamed from: b, reason: from kotlin metadata */
    @Nullable
    private String type;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/net/i$a;", "", "Lorg/json/JSONObject;", "params", "", "type", "Lcom/tencent/rdelivery/net/i;", "a", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "d", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "", "c", "SERVER_URL_REPORT", "Ljava/lang/String;", "SERVER_URL_REPORT_PRE_RELEASE", "SERVER_URL_REPORT_RELEASE", "SERVER_URL_REPORT_TEST", "TAG", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.net.i$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/rdelivery/net/i$a$a", "Lcom/tencent/raft/standard/net/IRNetwork$INetworkResult;", "", "result", "", "onSuccess", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "onFail", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.rdelivery.net.i$a$a */
        /* loaded from: classes25.dex */
        public static final class C9729a implements IRNetwork.INetworkResult {

            /* renamed from: a */
            final /* synthetic */ RDeliverySetting f364364a;

            C9729a(RDeliverySetting rDeliverySetting) {
                this.f364364a = rDeliverySetting;
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onFail(@NotNull IRNetwork.ResultInfo result) {
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364364a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("SDKReportRequest", this.f364364a.getRdInstanceIdentifier()), "doRequest onFail", false, 4, null);
                }
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onSuccess(@NotNull Object result) {
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364364a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("SDKReportRequest", this.f364364a.getRdInstanceIdentifier()), "doRequest onSuccess = " + result, false, 4, null);
                }
            }
        }

        Companion() {
        }

        public static /* synthetic */ i b(Companion companion, JSONObject jSONObject, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = null;
            }
            return companion.a(jSONObject, str);
        }

        @NotNull
        public final i a(@NotNull JSONObject params, @Nullable String type) {
            Intrinsics.checkParameterIsNotNull(params, "params");
            i iVar = new i();
            iVar.b(params);
            iVar.c(type);
            return iVar;
        }

        public final void c(@NotNull i r95, @Nullable IRNetwork netInterface, @Nullable RDeliverySetting setting) {
            Map<String, String> mapOf;
            Map<String, String> emptyMap;
            Intrinsics.checkParameterIsNotNull(r95, "request");
            if (netInterface != null && setting != null) {
                String a16 = r95.a();
                com.tencent.rdelivery.util.c logger = setting.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("SDKReportRequest", setting.getRdInstanceIdentifier()), "doRequest payload = " + a16, false, 4, null);
                }
                IRNetwork.HttpMethod httpMethod = IRNetwork.HttpMethod.POST;
                String d16 = d(setting);
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("content-type", "application/json"));
                emptyMap = MapsKt__MapsKt.emptyMap();
                netInterface.requestWithMethod(httpMethod, d16, mapOf, emptyMap, a16, new C9729a(setting));
            }
        }

        @NotNull
        public final String d(@NotNull RDeliverySetting setting) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            String a16 = ServerUrlGenerator.f364301a.a(setting, ServerUrlGenerator.ProtocolPathInUrl.REPORT_SDK_ERR);
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "SDKReportRequest", "getServerUrl, result = " + a16, false, 4, null);
            }
            return a16;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String str = "https://rdelivery.qq.com/v1/sdk/report";
        if (BaseProto$ServerType.RELEASE.getValue() != 0) {
            if (BaseProto$ServerType.PRE_RELEASE.getValue() == 0) {
                str = "https://p.rdelivery.qq.com/v1/sdk/report";
            } else if (BaseProto$ServerType.TEST.getValue() == 0) {
                str = "https://t.rdelivery.qq.com/v1/sdk/report";
            }
        }
        f364360c = str;
    }

    @NotNull
    public final String a() {
        String str;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = this.jsonParams;
        if (jSONObject2 != null) {
            str = jSONObject2.toString();
        } else {
            str = null;
        }
        jSONObject.putOpt("json_data", str);
        jSONObject.putOpt("type", this.type);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "request.toString()");
        return jSONObject3;
    }

    public final void b(@Nullable JSONObject jSONObject) {
        this.jsonParams = jSONObject;
    }

    public final void c(@Nullable String str) {
        this.type = str;
    }
}
