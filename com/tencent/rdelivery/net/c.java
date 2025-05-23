package com.tencent.rdelivery.net;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.ServerUrlGenerator;
import com.tencent.rdelivery.net.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00062\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/net/c;", "", "", ImageTaskConst.ERROR_TYPE, "errMsg", "Lorg/json/JSONObject;", "b", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "d", "", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "setReqList", "(Ljava/util/List;)V", "reqList", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<RDeliveryRequest> reqList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J.\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/rdelivery/net/c$a;", "", "", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", "list", "Lcom/tencent/rdelivery/net/c;", "a", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "", "c", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "", "b", "result", "Lcom/tencent/rdelivery/util/c;", "logger", "Lkotlin/Pair;", "", "d", "ERR_DECODE", "Ljava/lang/String;", "ERR_RET", "TAG", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.net.c$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/rdelivery/net/c$a$a", "Lcom/tencent/raft/standard/net/IRNetwork$INetworkResult;", "", "result", "", "onSuccess", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "onFail", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.rdelivery.net.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9727a implements IRNetwork.INetworkResult {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RDeliverySetting f364328a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f364329b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ IRNetwork f364330c;

            C9727a(RDeliverySetting rDeliverySetting, c cVar, IRNetwork iRNetwork) {
                this.f364328a = rDeliverySetting;
                this.f364329b = cVar;
                this.f364330c = iRNetwork;
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onFail(@NotNull IRNetwork.ResultInfo result) {
                String str;
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364328a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_MergePullRequest", this.f364328a.getRdInstanceIdentifier()), "doRequest onFail, result = " + result.getErrorMessage(), false, 4, null);
                }
                Iterator<T> it = this.f364329b.c().iterator();
                while (true) {
                    str = "";
                    if (!it.hasNext()) {
                        break;
                    }
                    iz3.j mergePullRequestResultListener = ((RDeliveryRequest) it.next()).getMergePullRequestResultListener();
                    if (mergePullRequestResultListener != null) {
                        String errorMessage = result.getErrorMessage();
                        if (errorMessage != null) {
                            str = errorMessage;
                        }
                        mergePullRequestResultListener.onFail(str);
                    }
                }
                c cVar = this.f364329b;
                String errorMessage2 = result.getErrorMessage();
                if (errorMessage2 != null) {
                    str = errorMessage2;
                }
                JSONObject b16 = cVar.b("40", str);
                i.Companion companion = i.INSTANCE;
                companion.c(companion.a(b16, "batch"), this.f364330c, this.f364328a);
            }

            @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
            public void onSuccess(@NotNull Object result) {
                Intrinsics.checkParameterIsNotNull(result, "result");
                com.tencent.rdelivery.util.c logger = this.f364328a.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_MergePullRequest", this.f364328a.getRdInstanceIdentifier()), "doRequest onSuccess = " + result, false, 4, null);
                }
                Companion companion = c.INSTANCE;
                c cVar = this.f364329b;
                if (!(result instanceof String)) {
                    result = null;
                }
                Pair<Boolean, String> d16 = companion.d(cVar, (String) result, this.f364328a.getLogger());
                if (!d16.getFirst().booleanValue()) {
                    JSONObject b16 = this.f364329b.b("50", d16.getSecond());
                    i.Companion companion2 = i.INSTANCE;
                    companion2.c(companion2.a(b16, "batch"), this.f364330c, this.f364328a);
                }
            }
        }

        Companion() {
        }

        @NotNull
        public final c a(@NotNull List<RDeliveryRequest> list) {
            Intrinsics.checkParameterIsNotNull(list, "list");
            c cVar = new c();
            cVar.c().addAll(list);
            return cVar;
        }

        public final void b(@NotNull c request, @Nullable IRNetwork netInterface, @Nullable RDeliverySetting setting) {
            Map<String, String> mapOf;
            Map<String, String> emptyMap;
            Intrinsics.checkParameterIsNotNull(request, "request");
            if (netInterface != null && setting != null) {
                String d16 = request.d(setting);
                com.tencent.rdelivery.util.c logger = setting.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_MergePullRequest", setting.getRdInstanceIdentifier()), "doRequest payload = " + d16, false, 4, null);
                }
                IRNetwork.HttpMethod httpMethod = IRNetwork.HttpMethod.POST;
                String c16 = c(setting);
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("content-type", "application/json"));
                emptyMap = MapsKt__MapsKt.emptyMap();
                netInterface.requestWithMethod(httpMethod, c16, mapOf, emptyMap, d16, new C9727a(setting, request, netInterface));
            }
        }

        @NotNull
        public final String c(@NotNull RDeliverySetting setting) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            String a16 = ServerUrlGenerator.f364301a.a(setting, ServerUrlGenerator.ProtocolPathInUrl.BATCH_PULL_ALL_CONFIG_SWITCH_DATA);
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_MergePullRequest", setting.getRdInstanceIdentifier()), "getServerUrl, result = " + a16, false, 4, null);
            }
            return a16;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x012f  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Pair<Boolean, String> d(@NotNull c request, @Nullable String result, @Nullable com.tencent.rdelivery.util.c logger) {
            JSONObject jSONObject;
            int i3;
            String str;
            String str2;
            JSONObject optJSONObject;
            boolean z16;
            Object obj;
            iz3.j mergePullRequestResultListener;
            Intrinsics.checkParameterIsNotNull(request, "request");
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDelivery_MergePullRequest", "handleSuccess result = " + result, false, 4, null);
            }
            boolean z17 = false;
            try {
                jSONObject = new JSONObject(result);
                try {
                    i3 = jSONObject.optInt("ret_code", 0);
                } catch (Exception e16) {
                    e = e16;
                    if (logger != null) {
                        logger.d("RDelivery_MergePullRequest", "handleSuccess fail to decode code", e);
                    }
                    i3 = -1;
                    if (i3 != BaseProto$Code.SUCCESS.getValue()) {
                    }
                    return new Pair<>(Boolean.valueOf(z17), str2);
                }
            } catch (Exception e17) {
                e = e17;
                jSONObject = null;
            }
            if (i3 != BaseProto$Code.SUCCESS.getValue()) {
                if (jSONObject != null) {
                    try {
                        optJSONObject = jSONObject.optJSONObject("rsp_list");
                    } catch (Exception e18) {
                        String message = e18.getMessage();
                        if (message == null) {
                            message = "merge_req_decode_error";
                        }
                        str2 = message;
                        Iterator<T> it = request.c().iterator();
                        while (it.hasNext()) {
                            iz3.j mergePullRequestResultListener2 = ((RDeliveryRequest) it.next()).getMergePullRequestResultListener();
                            if (mergePullRequestResultListener2 != null) {
                                mergePullRequestResultListener2.onFail(str2);
                            }
                        }
                        if (logger != null) {
                            logger.d("RDelivery_MergePullRequest", "handleSuccess decode Exception", e18);
                        }
                    }
                } else {
                    optJSONObject = null;
                }
                if (jSONObject != null) {
                    z16 = jSONObject.optBoolean("not_batch_merge");
                } else {
                    z16 = false;
                }
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, "RDelivery_MergePullRequest", "handleSuccess cancelMergeRequest = " + z16, false, 4, null);
                }
                str2 = "";
                if (z16) {
                    Iterator<T> it5 = request.c().iterator();
                    while (it5.hasNext()) {
                        iz3.j mergePullRequestResultListener3 = ((RDeliveryRequest) it5.next()).getMergePullRequestResultListener();
                        if (mergePullRequestResultListener3 != null) {
                            mergePullRequestResultListener3.a(null, true);
                        }
                    }
                } else if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    Intrinsics.checkExpressionValueIsNotNull(keys, "rspList.keys()");
                    while (keys.hasNext()) {
                        String str3 = (String) keys.next();
                        String optString = optJSONObject.optString(str3);
                        if (optString == null) {
                            optString = "";
                        }
                        Iterator<T> it6 = request.c().iterator();
                        while (true) {
                            if (it6.hasNext()) {
                                obj = it6.next();
                                if (Intrinsics.areEqual(((RDeliveryRequest) obj).getSign(), str3)) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        RDeliveryRequest rDeliveryRequest = (RDeliveryRequest) obj;
                        if (rDeliveryRequest != null && (mergePullRequestResultListener = rDeliveryRequest.getMergePullRequestResultListener()) != null) {
                            mergePullRequestResultListener.a(optString, false);
                        }
                    }
                }
                z17 = true;
            } else {
                if (jSONObject == null || (str = jSONObject.optString("ret_msg")) == null) {
                    str = "merge_req_ret_error";
                }
                str2 = str;
                Iterator<T> it7 = request.c().iterator();
                while (it7.hasNext()) {
                    iz3.j mergePullRequestResultListener4 = ((RDeliveryRequest) it7.next()).getMergePullRequestResultListener();
                    if (mergePullRequestResultListener4 != null) {
                        mergePullRequestResultListener4.onFail(str2);
                    }
                }
            }
            return new Pair<>(Boolean.valueOf(z17), str2);
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
        JSONArray jSONArray = new JSONArray();
        for (RDeliveryRequest rDeliveryRequest : this.reqList) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("app_id", rDeliveryRequest.getAppId());
            jSONObject2.putOpt("sys_id", rDeliveryRequest.getSystemId());
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.putOpt("instance_list", jSONArray);
        return jSONObject;
    }

    @NotNull
    public final List<RDeliveryRequest> c() {
        return this.reqList;
    }

    @NotNull
    public final String d(@NotNull RDeliverySetting setting) {
        int collectionSizeOrDefault;
        com.tencent.rdelivery.util.c cVar;
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        JSONObject jSONObject = new JSONObject();
        List<RDeliveryRequest> list = this.reqList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (RDeliveryRequest rDeliveryRequest : list) {
            if (setting != null) {
                cVar = setting.getLogger();
            } else {
                cVar = null;
            }
            arrayList.add(RDeliveryRequest.C(rDeliveryRequest, cVar, false, null, 6, null));
        }
        jSONObject.putOpt("req_list", new JSONArray((Collection) arrayList));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "request.toString()");
        return jSONObject2;
    }
}
