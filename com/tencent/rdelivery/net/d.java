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
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0002\u0005\u0003B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/rdelivery/net/d;", "", "", "b", "Lorg/json/JSONArray;", "a", "Lorg/json/JSONArray;", "getJsonParams", "()Lorg/json/JSONArray;", "c", "(Lorg/json/JSONArray;)V", "jsonParams", "Lcom/tencent/rdelivery/net/d$b;", "Lcom/tencent/rdelivery/net/d$b;", "()Lcom/tencent/rdelivery/net/d$b;", "d", "(Lcom/tencent/rdelivery/net/d$b;)V", "listener", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONArray jsonParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/net/d$a;", "", "Lorg/json/JSONArray;", "params", "Lcom/tencent/rdelivery/net/d$b;", "listener", "Lcom/tencent/rdelivery/net/d;", "a", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "", "c", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.net.d$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/rdelivery/net/d$a$a", "Lcom/tencent/raft/standard/net/IRNetwork$INetworkResult;", "", "result", "", "onSuccess", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "onFail", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.rdelivery.net.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9728a implements IRNetwork.INetworkResult {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RDeliverySetting f364334a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f364335b;

            C9728a(RDeliverySetting rDeliverySetting, d dVar) {
                this.f364334a = rDeliverySetting;
                this.f364335b = dVar;
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onFail(@NotNull IRNetwork.ResultInfo result) {
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364334a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("PullEventReportRequest", this.f364334a.getRdInstanceIdentifier()), "doRequest onFail", false, 4, null);
                }
                b listener = this.f364335b.getListener();
                if (listener != null) {
                    listener.onFail(result.getErrorMessage());
                }
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onSuccess(@NotNull Object result) {
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364334a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("PullEventReportRequest", this.f364334a.getRdInstanceIdentifier()), "doRequest onSuccess = " + result, false, 4, null);
                }
                b listener = this.f364335b.getListener();
                if (listener != null) {
                    listener.onSuccess();
                }
            }
        }

        Companion() {
        }

        @NotNull
        public final d a(@NotNull JSONArray params, @Nullable b listener) {
            Intrinsics.checkParameterIsNotNull(params, "params");
            d dVar = new d();
            dVar.c(params);
            dVar.d(listener);
            return dVar;
        }

        public final void b(@NotNull d request, @Nullable IRNetwork netInterface, @Nullable RDeliverySetting setting) {
            Map<String, String> mapOf;
            Map<String, String> emptyMap;
            Intrinsics.checkParameterIsNotNull(request, "request");
            if (netInterface != null && setting != null) {
                String b16 = request.b();
                com.tencent.rdelivery.util.c logger = setting.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("PullEventReportRequest", setting.getRdInstanceIdentifier()), "doRequest payload = " + b16, false, 4, null);
                }
                IRNetwork.HttpMethod httpMethod = IRNetwork.HttpMethod.POST;
                String c16 = c(setting);
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("content-type", "application/json"));
                emptyMap = MapsKt__MapsKt.emptyMap();
                netInterface.requestWithMethod(httpMethod, c16, mapOf, emptyMap, b16, new C9728a(setting, request));
            }
        }

        @NotNull
        public final String c(@NotNull RDeliverySetting setting) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            String a16 = ServerUrlGenerator.f364301a.a(setting, ServerUrlGenerator.ProtocolPathInUrl.REPORT_PULL_EVENT);
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "PullEventReportRequest", "getServerUrl, result = " + a16, false, 4, null);
            }
            return a16;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rdelivery/net/d$b;", "", "", "reason", "", "onFail", "onSuccess", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public interface b {
        void onFail(@Nullable String reason);

        void onSuccess();
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final b getListener() {
        return this.listener;
    }

    @NotNull
    public final String b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("data_list", this.jsonParams);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "request.toString()");
        return jSONObject2;
    }

    public final void c(@Nullable JSONArray jSONArray) {
        this.jsonParams = jSONArray;
    }

    public final void d(@Nullable b bVar) {
        this.listener = bVar;
    }
}
